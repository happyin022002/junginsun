/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UbizComOpusBkgKrcusAckEvent.java
 *@FileTitle : UbizComOpusBkgKrcusAckEvent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.17
 *@LastModifier : 이인영
 *@LastVersion : 1.0
 * 2011.11.17 이인영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UbizComOpusBkgKrcusAck 수신처리에 대한 이벤트
 *
 * @author 이인영
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class UbizComOpusBkgKrcusAckEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String flatFile = null;

	public UbizComOpusBkgKrcusAckEvent() {}

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
