# cursomc

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
```
    class Pagamento {
        @OneToOne
        @JoinColumn(name = "pedido_id")
        @MapsId 
        private Pedido pedido;
    }
```

Faz com que o ID da classe Pagamento ser igual ao ID da classe Pedido
