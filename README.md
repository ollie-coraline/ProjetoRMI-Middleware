# Conteúdo para o README.md (GitHub)

Este texto deve ser conciso e focado nos principais *deliverables* e conceitos acadêmicos.

## [FCCPD] Projeto 01: Middleware Procedural (Java RMI) - Criptografia e Sincronização

**Status:** Concluído

**Modelo de Middleware:** Procedural (Remote Method Invocation - RMI)

**Objetivo:** Implementar um sistema distribuído Cliente-Servidor em Java que ofereça um serviço de criptografia combinada (Cifra de César + Inversão de String), demonstrando **Transparência de Acesso** e aplicando técnicas de **Sincronização** para lidar com concorrência.

### Como Rodar o Projeto

1.  **Compilar Todos os Arquivos:**
    ```bash
    javac ServicoCriptografia.java ImplementacaoCriptografia.java Servidor.java Cliente.java
    ```
2.  **Iniciar o Servidor** (Terminal 1)
    ```bash
    java Servidor
    ```
3.  **Iniciar o Cliente** (Terminal 2)
    ```bash
    java Cliente
    ```
    *O Cliente rodará em *loop*, solicitando a operação (1, 2 ou 0 para sair).*
