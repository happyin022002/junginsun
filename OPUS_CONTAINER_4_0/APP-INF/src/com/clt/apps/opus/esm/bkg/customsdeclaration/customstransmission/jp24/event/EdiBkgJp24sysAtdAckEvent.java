/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EdiBkgJp24sysAtdAckEvent.java
*@FileTitle : EdiBkgJp24sysAtdAckEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.25
*@LastModifier :
*@LastVersion : 1.0
* 2013.10.25
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * receiving from EDI<br>
 *
 * @author KIM, Sang-Soo
 * @see
 * @since J2EE 1.6
 */
public class EdiBkgJp24sysAtdAckEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

}