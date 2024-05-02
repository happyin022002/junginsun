/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UdevhjsAlpsbkgTJpn24Event.java
*@FileTitle : UdevhjsAlpsbkgTJpn24Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.10.25 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * receiving from EDI<br>
 *
 * @author KIM, Sang-Soo
 * @see 
 * @since J2EE 1.6
 */
public class UdevhjsAlpsbkgTJpn24Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

}