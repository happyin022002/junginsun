/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AlpsbkgTEurcusAckEven.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.15
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.09.15 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event;

import com.hanjin.apps.alps.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * 구주위험물 신고 응답메시지 수신용 이벤트
 * 
 * @author Kyoung Jong Yun
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class AlpsbkgTEurcusAckEven extends EventSupport {
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
