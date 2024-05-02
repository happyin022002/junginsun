/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OpusBkgNzcusAckEvent.java
*@FileTitle : OpusBkgNzcusAckEvent
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * receiving from EDI<br>
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class OpusBkgNzcusAckEvent extends EventSupport {
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