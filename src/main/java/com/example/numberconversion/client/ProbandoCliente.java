package com.example.numberconversion.client;

import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.namespace.QName;
import java.math.BigInteger;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProbandoCliente {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private final WebServiceTemplate webServiceTemplate;

    public void testingMetodo(BigInteger ubiNum) {
        // Crear una nueva instancia de NumberToWords
        NumberToWords request = OBJECT_FACTORY.createNumberToWords();
        request.setUbiNum(ubiNum);

        // Crear el JAXBElement para la solicitud
        JAXBElement<NumberToWords> jaxbRequest = new JAXBElement<>(
                new QName("http://www.dataaccess.com/webservicesserver/", "NumberToWords"), // Asegúrate de usar el namespace correcto
                NumberToWords.class,
                request
        );

        // Enviar la solicitud SOAP y recibir la respuesta
        NumberToWordsResponse response =
                (NumberToWordsResponse) webServiceTemplate.marshalSendAndReceive(jaxbRequest);

        // Manejar la respuesta (por ejemplo, loguear el resultado)
        log.info("Respuesta recibida: {}", response.getNumberToWordsResult());
    }
}
