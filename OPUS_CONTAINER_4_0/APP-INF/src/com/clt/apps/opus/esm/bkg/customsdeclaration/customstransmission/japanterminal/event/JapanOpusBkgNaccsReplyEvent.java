/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanOpusBkgNaccsReplyEvent.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.07
 *@LastModifier :
 *@LastVersion : 1.0
 * 2012.03.07
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event;

import com.clt.apps.opus.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 일본 EDI 수신용 이벤트
 *
 * @author KMJ
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.4
 */
public class JapanOpusBkgNaccsReplyEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
}
