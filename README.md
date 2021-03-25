# cursomc

## Diagrama proposto da aplicação

![Diagrama da aplicacao](./diagrama.png)

## Anotações importantes do projeto

### Proteção para referência cíclica na serialização Json:
@JsonManagedReference  
Lado do relacionamento que deseja retornar objetos

@JsonBackReference  
Lado do relacionamento que deseja omitir objetos

### Checklist de tratamento de exceção de id inválido
Criar ObjectNotFountException  
Criar StandardError  
Criar ResourceExceptionHandler  

### Criando entidades fracas no banco de dados
@ElementCollection  
@CollectionTable(name = "Telefone")

Usando as anotações acima, é criado uma Tabela Telefone no banco, sem uma primary key.  
Essa tabela leva o ID da classe que tem ela como atribute e uma string telefone como coluna

### Mapeamento one to one
```java
    class Pagamento {
        @OneToOne
        @JoinColumn(name = "pedido_id")
        @MapsId 
        private Pedido pedido;
    }
```

Faz com que o ID da classe Pagamento ser igual ao ID da classe Pedido

### Criando chave primaria composta  

Classe que tem como atributo uma chave primária composta
```java
    public class ItemPedido implements Serializable {
    
        @EmbeddedId
        private ItemPedidoPK id = new ItemPedidoPK();
    
    }
```

Anotação usada para criar uma chave primaria composta
```java
    @Embeddable // sub tipo de classe
    public class ItemPedidoPK implements Serializable {
    }
```

### Validacao com Bean Validation
@Valid  
Faz as validações do objeto passado pela requisição e retorna erro caso não esteja de acordo com as validações

```java
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto) {
    // codigo
    }
```
