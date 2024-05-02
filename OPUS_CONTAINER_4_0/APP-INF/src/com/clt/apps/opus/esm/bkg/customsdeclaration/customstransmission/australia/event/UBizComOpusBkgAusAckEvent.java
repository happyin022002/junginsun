/*=========================================================
*Copyright(c) CyberLogitec
*@FileName : UBizComOpusBkgAusAckEvent.java
*@FileTitle : UBizComOpusBkgAusAckEvent
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * receiving from EDI<br>
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class UBizComOpusBkgAusAckEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

}