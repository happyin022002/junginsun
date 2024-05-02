/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OpusbkgUbizcomEurcusAckEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.07
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.09.07 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event;

import com.clt.apps.opus.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EUR(ETA)EDI 수신용 이벤트
 * 
 * @author Kyoung Jong Yun
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class OpusbkgUbizcomEurcusAckEvent extends EventSupport {
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
