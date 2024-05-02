/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Ubiz2comOpusbkgAmsAckEvent.java
 *@FileTitle : 미세관 응답 메세지 수신 이벤트.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.09.29 김도완
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event;

import com.clt.apps.opus.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EUR(ETA)EDI 수신용 이벤트
 * 
 * @author Kim Do-Wan
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class Ubiz2comOpusbkgAmsAckEvent extends EventSupport {
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
