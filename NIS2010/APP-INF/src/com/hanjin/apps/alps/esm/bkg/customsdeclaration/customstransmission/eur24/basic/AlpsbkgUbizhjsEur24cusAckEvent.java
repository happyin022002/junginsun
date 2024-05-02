/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AlpsbkgUbizhjsEur24cusAckEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.09.27
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.09.07 김경섭
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.basic;

import com.hanjin.apps.alps.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EUR(ETA)EDI 수신용 이벤트
 * 
 * @author Kim Gyoung Sub
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class AlpsbkgUbizhjsEur24cusAckEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public String flatFile = null;

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
