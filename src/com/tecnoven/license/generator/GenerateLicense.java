/**
 * 
 */
package com.tecnoven.license.generator;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;

import com.tecnoven.license.generator.cypher.CryptoLibrary;
import com.tecnoven.license.generator.domain.LicenseEntity;
import com.thoughtworks.xstream.XStream;

/**
 * @author hector
 *
 */
public class GenerateLicense {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String title = System.getProperty("title");
		String date = System.getProperty("expiration");
		String macAddress = System.getProperty("mac-address");
		String services = System.getProperty("services");
		String smsPwd = System.getProperty("sms-usr");
		String smsUser = System.getProperty("sms-pwd");

		if (title == null || macAddress == null || services ==null){
			System.err.print("Invalid arguments\n Mandatory arguments =-Dtitle= | -Dmac-address={format=xx-xx-xx-xx-xx-xx} | -Dservices={format=EMAIL,SMS}");
			System.exit(1);
		}else if (services.contains("SMS")){
			if(smsPwd == null || smsUser == null){
				System.err.print("Invalid credentials for SMS sending messages");
				System.err.print("valid arguments = -Dsms-usr=user -Dsms-pwd=password");
				System.exit(1);
			}
		}
		
		LicenseEntity license = new LicenseEntity();
		
		if (date != null){
			try {
			SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
			format.applyPattern("dd/MM/yyyy");
				license.setExpirationDate(format.parse(date));
			} catch (ParseException e) {
				System.err.print("Invalid date format. i.e: {format=dd/MM/yyyy}");
				System.exit(1);
			}
		}
		license.setBarTitle(title);
		license.setMacAddress(macAddress);
		license.setSupportedServices(services);
		license.setSmsPwd(smsPwd);
		license.setSmsUser(smsUser);
		XStream writer = new XStream();
		writer.processAnnotations(license.getClass());
		
		String data = writer.toXML(license);
		
		CryptoLibrary localEncrypter = new CryptoLibrary();
		String dataEncrypted = localEncrypter.encrypt(data);

		String mainPath = System.getProperty("user.dir");
		FileUtils.writeStringToFile(new File(mainPath + File.separator + "license.lic"), dataEncrypted);
		System.out.println("License file was created successfully on '" + mainPath +"'");
	}

}
