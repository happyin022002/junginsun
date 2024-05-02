/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AlpsbkgUbizhjsEurcusAckEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.25
 *@LastModifier : 이석준
 *@LastVersion : 1.0
 * 2009.09.07 이석준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Glovis EDI 수신용 이벤트
 *  
 * @author SUK JOON LEE
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class UbizhjsAlpsinvGlovisEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public String flatFile = null;
	public String integrationId = null;
	
	
	/**
	 * @return the integrationId
	 */
	public String getIntegrationId() {
		return integrationId;
	}

	/**
	 * @param integrationId the integrationId to set
	 */
	public void setIntegrationId(String integrationId) {
		this.integrationId = integrationId;
	}

	/**
	 * @return the flatFile
	 */
	public String getFlatFile() {
		return flatFile;
	}

	/**
	 * @param flatFile the flatFile to set
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}


	
}
