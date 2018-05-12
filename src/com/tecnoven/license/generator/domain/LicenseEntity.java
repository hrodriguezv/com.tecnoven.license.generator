/**
 * 
 */
package com.tecnoven.license.generator.domain;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author hector
 *
 */
@XStreamAlias("license")
public class LicenseEntity {

    @XStreamAlias(value = "sms-usr")
	private String smsUser;
    
    @XStreamAlias(value = "sms-pwd")
    private String smsPwd;

    @XStreamAlias(value = "bar-title")
    private String barTitle;
    
    @XStreamAlias(value = "supported-services")
    private String supportedServices;
    
    @XStreamAlias(value = "mac-address")
    private String macAddress;
    
    @XStreamAlias(value = "expiration-date")
    private Date expirationDate;

	/**
	 * @return the smsUser
	 */
	public String getSmsUser() {
		return smsUser;
	}

	/**
	 * @param smsUser the smsUser to set
	 */
	public void setSmsUser(String smsUser) {
		this.smsUser = smsUser;
	}

	/**
	 * @return the smsPwd
	 */
	public String getSmsPwd() {
		return smsPwd;
	}

	/**
	 * @param smsPwd the smsPwd to set
	 */
	public void setSmsPwd(String smsPwd) {
		this.smsPwd = smsPwd;
	}

	/**
	 * @return the barTitle
	 */
	public String getBarTitle() {
		return barTitle;
	}

	/**
	 * @param barTitle the barTitle to set
	 */
	public void setBarTitle(String barTitle) {
		this.barTitle = barTitle;
	}

	/**
	 * @return the supportedServices
	 */
	public String getSupportedServices() {
		return supportedServices;
	}

	/**
	 * @param supportedServices the supportedServices to set
	 */
	public void setSupportedServices(String supportedServices) {
		this.supportedServices = supportedServices;
	}

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @param macAddress the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String[] getListSupportedServices(){
		if (this.supportedServices != null){
			return this.supportedServices.split(",");
		}
		return null;
	}
}
