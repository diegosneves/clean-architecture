# Clean Architecture

A Clean Architecture é um princípio de design de software avançado que defende a separação de responsabilidades no sistema de software. A ideia principal por trás da Clean Architecture é a independência do código-fonte em relação aos detalhes. Essas dependências são extraídas para as camadas externas do sistema por meio de abstrações e inversão de controle.

A estrutura de Clean Architecture é geralmente dividida em quatro camadas diferentes:

1. **Camada de Entidades**: Esta é a camada mais interna do círculo da Clean Architecture. Ela contém entidades de negócios que são as representações de alto nível das regras de negócios.

2. **Camada de Casos de Uso**: Esta camada contém lógica de negócios específica. É onde as regras de negócios são aplicadas.

3. **Camada de Interface do Usuário**: Esta camada é responsável por lidar com a lógica relacionada à apresentação da interface do usuário e interfaces de usuário.

4. **Camada de Infraestrutura**: Esta é a camada mais externa do círculo da Clean Architecture. Contém detalhes que são específicos para a infraestrutura, como bancos de dados, frameworks da web e etc.

A ideia principal da Clean Architecture é que as camadas internas não devem saber nada sobre as camadas externas. Em outras palavras, as dependências devem sempre apontar para dentro. Essa regra permite um design de sistema altamente decoplado e testável, promovendo a separação de interesses e tornando o sistema mais fácil de manter e estender.

Além disso, a Clean Architecture facilita a substituição de componentes individuais sem afetar o resto do sistema, pois cada componente é menos dependente de implementações específicas e mais dependente de abstrações.

---