/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UbizhjsAlpsbkgKrcusAckEvent.java
 *@FileTitle : UbizhjsAlpsbkgKrcusAckEvent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.17
 *@LastModifier : 이인영
 *@LastVersion : 1.0
 * 2011.11.17 이인영
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UbizhjsAlpsbkgKrcusAck 수신처리에 대한 이벤트
 * 
 * @author 이인영
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class UbizhjsAlpsbkgKrcusAckEvent extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	private String flatFile = null;

	public UbizhjsAlpsbkgKrcusAckEvent() {}

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
