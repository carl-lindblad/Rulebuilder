package com;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Map;

public class Action_XML_Builder {

    public void Action_builders(Map<String, String> parametersInput, String actionType, String sectionType, String messageLevel, String messageText) {
        try {

            String xmlFilePath = "C:\\DevStuff\\Rule builder\\Action_rules_XML\\Actions\\asd.xml";

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("rule");
            document.appendChild(root);

            // actions element
            Element actions = document.createElement("actions");
            root.appendChild(actions);

            // action element
            Element action = document.createElement("action");
            actions.appendChild(action);
            action.setAttribute("type", actionType);


            // sub_action element
            Element sub_action = document.createElement("sub_action");
            action.appendChild(sub_action);
            sub_action.setAttribute("type", sectionType);

            // parameters element
            Element parameters = document.createElement("parameters");
            sub_action.appendChild(parameters);


            /**
             * Parameter
             */
            for (Map.Entry<String, String> param : parametersInput.entrySet()
            ) {
                System.out.println("test key:" + param.getKey());
                System.out.println("test key:" + param.getValue());

                Element parameter = document.createElement("parameter");
                parameters.appendChild(parameter);
                parameter.setAttribute("name", param.getKey());
                parameter.setAttribute("val", param.getValue());

            }


            if (!messageLevel.equals("") && !messageText.equals("")) {
                // message element
                Element message = document.createElement("message");
                sub_action.appendChild(message);

                // parameters message element
                Element parametersMessage = document.createElement("parameters");
                message.appendChild(parametersMessage);


                // message element
                Element parameterMessageLevel = document.createElement("parameter");
                parametersMessage.appendChild(parameterMessageLevel);
                parameterMessageLevel.setAttribute("name", "LEVEL");
                parameterMessageLevel.setAttribute("val", messageLevel);

                // message element
                Element parameterMessage = document.createElement("parameter");
                parametersMessage.appendChild(parameterMessage);
                parameterMessage.setAttribute("name", "TEXT");
                parameterMessage.setAttribute("val", messageText);


            }
            /**
             * create the xml file
             */
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
