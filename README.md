#  

<div align="center">
   <img src="https://ik.imagekit.io/5eywr3ioq/Imagens%20Projeto%20Integrador/ConectaTravel.png" title="ConectaLife" />
</div>
 
# ✈️ ConectaTravel - Sistema de Gerenciamento de Seguro Viagem Tech

O **ConectaTravel** é um sistema de gerenciamento de seguro viagem voltado especificamente para estudantes de tecnologia, pessoas desenvolvedoras e empresas do setor tech. A aplicação permite cadastrar, consultar, atualizar e excluir clientes e apólices de viagem, além de gerenciar os usuários responsáveis pelos registros, centralizando as informações e tornando os processos de cotação e emissão mais organizados e eficientes.

O grande foco do produto gerenciado pelo sistema é atender às necessidades do profissional e estudante moderno. Para isso, a plataforma gerencia apólices que oferecem o conceito de **"Conexão all-time"** — garantindo acesso a Salas VIPs em aeroportos e parcerias com internet aérea —, além de coberturas cruciais para o público tech, como **proteção contra extravio de malas e de equipamentos tecnológicos**. O pacote do seguro também assegura tranquilidade total ao viajante, oferecendo telemedicina 24h, assistência jurídica, suporte via WhatsApp 24h em idioma nativo (português) e cobertura de despesas na hora (assistência direta), sem que o cliente precise usar o próprio dinheiro durante uma emergência.

A aplicação conta com um motor de precificação dinâmico que valida regras de negócio cruciais: o valor final da apólice é calculado com base no número total de dias de permanência no exterior e aplica, de forma automatizada, um **acréscimo de 20% no valor final caso o destino da viagem seja os Estados Unidos ou o Canadá**. Quando o cliente é elegível e a cotação é gerada, ele pode seguir de forma fluida no fluxo de contratação, garantindo uma viagem conectada, segura e sem burocracias.

---

## 📚 Conceitos Aplicados

* Programação Orientada a Objetos (POO)
* Arquitetura REST
* CRUD completo
* Relacionamento entdade-Relacionamentore entidades (OneToMany e ManyToOne)
* Persistência de dados com JPA/Hibernate
* Validação de dados
* Autenticação e autorização com Spring Security
* Criptografia de senhas
* Documentação de API com Swagger
* Testes de endpoints utilizando Insomnia
* **Deploy e Banco de Dados Cloud com Neon (PostgreSQL Serverless)**



---

## 🧩 Módulos da Aplicação

| **Módulo**               | **Funcionalidades**                                          |
| ------------------------ | ------------------------------------------------------------ |
| 👤 **Usuários**           | Cadastro, autenticação (Spring Security), gerenciamento de perfil, atualização e exclusão, consulta por Id/Nome |
| 🗂️ **Clientes**           | CRUD completo de segurados, consulta por Id/Nome e histórico de apólices vinculadas |
| 📄 **Apólices de Seguro** | CRUD completo, cálculo de prêmio/cobertura, busca por Id da apólice e gestão do status (Ativa, Cancelada, Sinistrada) |

---

## 🔒 Segurança

A aplicação utiliza **Spring Security** para proteger os endpoints da API.

Principais recursos implementados:
* Autenticação de usuários
* Senhas criptografadas
* Endpoints protegidos
* Controle de acesso via credenciais

---

## 🗄️ Banco de Dados e Modelo (DER)

Banco de dados relacional utilizando **MySQL**, com persistência através do **Spring Data JPA** e **Hibernate**.

<p align="center">
  <img src="https://ik.imagekit.io/5eywr3ioq/Imagens%20Projeto%20Integrador/DER%20ConectaTravel.png" alt="Diagrama Entidade Relacionamento" width="100%">
</p>

---


## 🌐 Deploy & Documentação da API

A aplicação está com deploy ativo na nuvem e sua documentação interativa via **Swagger / OpenAPI** pode ser acessada tanto em ambiente de produção quanto localmente:

* 🔗 **API em Produção (Render):** `https://conectatravel.onrender.com/`
* 📑 **Swagger UI (Online):** `https://conectatravel.onrender.com/swagger-ui/index.html`
* 💻 **Swagger UI (Local):** `http://localhost:8080/swagger-ui/index.html`


A documentação interativa da API está disponível via **Swagger/OpenAPI**.

> Após iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui/index.html
---

## 🧪 Testes da API

Todos os endpoints foram testados utilizando o Insomnia.

A coleção e o ambiente utilizados durante os testes estão disponíveis na pasta:

```text
docs/insomnia/
```




### Como importar

1. Abra o **Insomnia**.
2. Clique em **Create > Import**.
3. Selecione **From File**.
4. Importe primeiro a coleção (`ConectaTravelInsomnia.yaml`).
5. Em seguida, importe o ambiente (`ConectaTravel_Environment.json`).

> Após a importação, todas as requisições da API estarão prontas para serem executadas.

---


---

## ▶️ Como Executar

### Clone o repositório

```bash
git clone https://github.com/VidaConecta/ConectaTravel
```

### Entre na pasta

```bash
cd ConectaTravel
```

### Configure o banco de dados

Altere as credenciais no arquivo:

```properties
application.properties
```

### Execute o projeto

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

---

## 📌 Principais Tecnologias

| **Tecnologia**         | **Finalidade**                                         |
| ---------------------- | ------------------------------------------------------ |
| **Java**               | Linguagem de programação principal                     |
| **Spring Boot**        | Framework para desenvolvimento da API REST             |
| **Spring Security**    | Autenticação, autorização e proteção da API            |
| **Spring Data JPA**    | Abstração de persistência de dados                     |
| **Hibernate**          | ORM para mapeamento objeto-relacional                  |
| **MySQL / PostgreSQL** | Banco de dados relacional (Dev local / Produção)       |
| **Neon**               | Deploy e hospedagem cloud do banco de dados PostgreSQL |
| **Maven**              | Gerenciamento de dependências do projeto               |
| **Swagger**            | Documentação interativa das rotas da API               |
| **Insomnia**           | Validação e testes de requisições HTTP                 |

---


* ## ⚙️ Regras de Negócio & Modelagem

  ### 📋 Validações e Elegibilidade
  * **🚫 Bloqueio de Adesão:** O sistema impede o cadastro e a emissão de apólices para perfis que não atendam aos critérios de elegibilidade.

  * **📆 Validação de Datas da Apólice:** As datas de início e fim são obrigatórias na emissão de uma apólice, sendo bloqueada qualquer tentativa de cadastro onde a data final seja anterior à data inicial.

    

  ### 💰 Precificação e Cálculo de Prêmios
  * **Diária Base:** O cálculo da apólice utiliza uma taxa diária fixa de **R$ 50,00** (com vigência mínima de 1 dia).

  * **Adicional Internacional:** Viagens com destinos internacionais (ex: *Estados Unidos*, *Canadá*) recebem uma taxa adicional de **20% sobre o valor da diária** (R$ 60,00/dia).

    

  ### 🔗 Mapeamento e Relacionamento de Entidades
  * **Cliente ➔ Apólice (`1:N` / `@OneToMany`):** Um cliente pode possuir uma ou mais apólices de seguro associadas ao seu perfil, enquanto cada apólice pertence obrigatoriamente a apenas um cliente (`@ManyToOne`).
  * **Usuário ➔ Apólice (`1:N` / `@OneToMany`):** Um usuário (corretor/operador do sistema) pode emitir e gerenciar múltiplas apólices. Cada apólice mantém a referência (`@ManyToOne`) do usuário responsável por sua gestão.

<div align="center">
---

## 🤝 Time de Desenvolvedores



 

* 👨‍💻 **Everly Rosendo** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)]([https://www.linkedin.com/in/sara-hurtado-cortes](https://linkedin.com/in/everly-rosendo)/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)]([https://github.com/SaraCarlenis](https://github.com/Dev-Everly))
* 👩‍💻 **Djalma Gomes** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)]([https://www.linkedin.com/in/sara-hurtado-cortes](https://linkedin.com/in/perfil)/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/DjSoul01000) 
* 👨‍💻 **Joel Ramalho Filho ** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)]([https:///](https://www.linkedin.com/in/joel-cunha-ramalho-filho)) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/JoelRamalhoF)
* 👨‍💻 **Kauê Dota** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kaue-dota/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/kauedota)
* 👨‍💻 **Miguel Oliveira** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://br.linkedin.com/in/miguel-oliveira-da-silva/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/miguel-oliveira-silva)
* 👨‍💻 **Sara Carlenis** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sara-hurtado-cortes/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/SaraCarlenis) 
* 👨‍💻 **Victor Pedro Gaspar** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/victor-pgms/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/victorpgms)
* 👨‍💻 **Vitória Albuquerque** - [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vitória-albuqueerque/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/vitoriaalbuquerqueee)
