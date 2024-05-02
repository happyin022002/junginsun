/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UdevComOpusvskTActskdEvent.java
*@FileTitle : EDI to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.10 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * receiving from MQ<br>
 *
 * @author KIM, Sang-Soo
 * @see
 * @since J2EE 1.6
 */

public class UbizComOpusCtmEqmvmtEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

}