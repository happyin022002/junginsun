/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OpusBkgTPsacusAckEven.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.15
 *@LastModifier :
 *@LastVersion : 1.0
 * 2009.09.15
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event;

import com.clt.apps.opus.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 구주위험물 신고 응답메시지 수신용 이벤트
 *
 * @author Kyoung Jong Yun
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class OpusBkgTPsacusAckEven extends EventSupport {
	private static final long serialVersionUID = 1L;

	private String flatFile = null;

	/**
	 * @return flatFile
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
