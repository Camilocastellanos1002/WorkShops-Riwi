package com.riwi.Library_BooksNow.util.messages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public class ErrorMessage {
    private final String mensaje = "";

    public static String idNotFound(String entity) {
        final String message = "No hay registros en la entidad %s con el id suministrado";
        return String.format(message, entity);
    }
}
