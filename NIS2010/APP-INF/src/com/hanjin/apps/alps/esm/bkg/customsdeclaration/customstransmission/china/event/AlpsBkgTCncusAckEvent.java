/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AlpsBkgTCncusAckReplyMQEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.28
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.09.28 이수빈
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event;

import com.hanjin.apps.alps.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * China 응답메시지 수신용 이벤트
 * 
 * @author Lee Subin
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class AlpsBkgTCncusAckEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String flatFile = null;
	
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
