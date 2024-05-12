package diegosneves.github.cleanarchitecture.exception.shared;

import org.springframework.http.HttpStatus;

/**
 * A classe {@link ExceptionDetails} é uma enumeração que define várias mensagens de exceções.
 * Cada mensagem corresponde a uma condição específica de validação ou erro
 * que pode ocorrer durante as operações.
 *
 * @author diegoneves
 */
public enum ExceptionDetails {

    CONSTRUCTOR_DEFAULT_UNDEFINED("Classe [ %s ] deve declarar um construtor padrão.", HttpStatus.NOT_IMPLEMENTED),
    CLASS_MAPPING_FAILURE("Falha ao tentar mapear a classe [ %s ].", HttpStatus.NOT_IMPLEMENTED),
    ADDRESS_CREATION_FAILURE("A criação de um novo Endereço falhou devido ao seguinte motivo: %s", HttpStatus.BAD_REQUEST),
    CUSTOMER_CREATION_FAILURE("A criação de um novo Cliente falhou devido ao seguinte motivo: %s", HttpStatus.BAD_REQUEST),
    INVALID_UUID_FORMAT_MESSAGE("O ID %s precisa estar no formato UUID", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

    ExceptionDetails(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }


    /**
     * Formata uma mensagem com a entrada fornecida e retorna a mensagem formatada.
     *
     * @param message A mensagem de entrada que será formatada.
     * @return A mensagem após a formatação.
     */
    public String getMessage(String message) {
        return String.format(this.message, message);
    }

    /**
     * Retorna o código de status HTTP associado ao erro.
     *
     * @return O código numérico do status HTTP relacionado com o erro.
     */
    public int getStatusCodeValue() {
        return this.httpStatus.value();
    }

    /**
     * Obtém o status HTTP associado ao erro.
     *
     * @return O código de status HTTP relacionado ao erro.
     */
    public HttpStatus getHttpStatusCode() {
        return this.httpStatus;
    }

}
