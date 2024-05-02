/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UbizhjsAlpsBkgNaccsReplyEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.22
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.09.22 손윤석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.event;

import com.hanjin.apps.alps.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * 캐나다 EDI 수신용 이벤트
 * 
 * @author Kim Min Jeong
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.4
 */
public class UbizhjsAlpsBkgNaccsReplyEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	private String rcvMsg = null;
	
	public String getRcvMsg() {
		return rcvMsg;
	}
	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}
}
