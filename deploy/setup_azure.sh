#!/bin/bash

# ==========================================
# Script de Automação Infra Azure — AgroID
# ==========================================

RESOURCE_GROUP="rg-agroid-devops"
LOCATION="eastus"
VM_NAME="vm-agroid-app"
IMAGE="Ubuntu2204"
ADMIN_USER="azureuser"
VM_SIZE="Standard_D2s_v3"

echo "========================================="
echo "Iniciando Provisionamento na Azure..."
echo "========================================="

# 1. Criar o Grupo de Recursos
echo "[1/5] Criando Resource Group ($RESOURCE_GROUP)..."
az group create --name $RESOURCE_GROUP --location $LOCATION -o none

# 2. Criar a VM Linux
echo "[2/5] Criando Máquina Virtual ($VM_NAME) e instalando ferramentas..."
az vm create \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --image $IMAGE \
  --admin-username $ADMIN_USER \
  --size $VM_SIZE \
  --generate-ssh-keys \
  --custom-data cloud-init.txt \
  --output json

# 3. Abrir as Portas
echo "[3/5] Abrindo portas no Firewall (8080 para API, 1521 para Banco, 443 para SSH alternativo)..."
az vm open-port --resource-group $RESOURCE_GROUP --name $VM_NAME --port 8080 --priority 1001 -o none
az vm open-port --resource-group $RESOURCE_GROUP --name $VM_NAME --port 1521 --priority 1002 -o none
az vm open-port --resource-group $RESOURCE_GROUP --name $VM_NAME --port 443 --priority 1003 -o none

# 4. Aguardar
echo "[4/5] Aguardando cloud-init concluir instalação do Docker..."
az vm run-command invoke \
  --command-id RunShellScript \
  --name $VM_NAME \
  --resource-group $RESOURCE_GROUP \
  --scripts "cloud-init status --wait" \
  --query "value[0].message" -o tsv

# 5. Finalização
PUBLIC_IP=$(az vm show -d -g $RESOURCE_GROUP -n $VM_NAME --query publicIps -o tsv)

echo "========================================="
echo "✅ Provisionamento Concluído com Sucesso!"
echo "========================================="
echo "IP Público da VM: $PUBLIC_IP"
echo "Para conectar na VM e rodar a aplicação:"
echo "  ssh $ADMIN_USER@$PUBLIC_IP"
echo "  e execute:"
echo "    git clone https://github.com/Gabriel-Maciel06/GSJava.git"
echo "    cd GSJava"
echo "    sudo docker compose up -d --build"
echo "========================================="
