/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EdiBkgJp24sysAmrAckEvent.java
*@FileTitle : EdiBkgJp24sysAmrAckEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier :
*@LastVersion : 1.0
* 2015.03.18
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * receiving from EDI<br>
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class EdiBkgChinaSysAckEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

}