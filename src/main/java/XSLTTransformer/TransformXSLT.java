package XSLTTransformer;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory ;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.yaml.snakeyaml.reader.StreamReader;

public class TransformXSLT {

	@SuppressWarnings("unused")
	public static String createHTML(String xml) {
		try {

			
			String xsl =  "src/main/java/XSLTTransformer/tp3.01.xslt";
			
			// create a new instance of TransformerFactory
			TransformerFactory tFactory = TransformerFactory.newInstance();
			tFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

			// new StreamSource : convert a String into XML input stream (fichier xsl)
			Source xslSource = new StreamSource(new File(xsl));
			Transformer transformer = tFactory.newTransformer(xslSource);

			// new StreamSource : convert a String into XML input stream (fichier xml)
			Source xmlSource = new StreamSource(new StringReader(xml));
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			//Transform the XML Source to a Result
			transformer.transform(xmlSource, new StreamResult(outputStream));

//			File html = new File ("test.html");
//			html.(new String(outputStream.toByteArray()));
//			
			String str = new String(outputStream.toByteArray());
			System.out.println(str);
			return str;

		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	

}
