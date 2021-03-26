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

### Criar Anotation personalizado para validar campos de uma classe

Código abaixo corresponde a criação somente do Anotation: @Nome

```java
	import java.lang.annotation.ElementType;
	import java.lang.annotation.Retention;
	import java.lang.annotation.RetentionPolicy;
	import java.lang.annotation.Target;
	import javax.validation.Constraint;
	import javax.validation.Payload;
	
	@Constraint(validatedBy = NomeValidator.class)
	@Target({ ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	
	public @interface Nome {
		String message() default "Erro de validação";
		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default {};
	}
```

Código abaixo implementa a classe NomeValidator que é a classe que contém o código da regra de negócio da validação personalizada
```java
	import java.util.ArrayList;
	import java.util.List;
	import javax.validation.ConstraintValidator;
	import javax.validation.ConstraintValidatorContext;
	
	public class NomeValidator implements ConstraintValidator<Nome, Tipo> {
	
		@Override
		public void initialize(Nome ann) {
		}
		
		@Override
		public boolean isValid(Tipo objDto, ConstraintValidatorContext context) {
			List<FieldMessage> list = new ArrayList<>();
			// inclua os testes aqui, inserindo erros na lista
			
			for (FieldMessage e : list) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMessage())
					.addPropertyNode(e.getFieldName()).addConstraintViolation();
			}
			
			return list.isEmpty();
		}
	}

```

No qual:
	- Nome: Nome da anotação. Ex: Nome  
	- Tipo: Classe que irá ser implementada  

### Pegando atributos de uma requisição

```java
	@Autowired
    private HttpServletRequest request;


    @SuppressWarnings("unchecked")
    Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

    Integer uriId = Integer.parseInt(map.get("id"));
```

Objeto map contem a chave o valor de cada atributo. Ex: <"id", "2">
