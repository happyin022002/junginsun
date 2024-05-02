/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkgUdevhjsAlpsbkgEntryEvent.java
 *@FileTitle : EsmBkgUdevhjsAlpsbkgEntryEvent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.11
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.09.11 박상훈
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UdevhjsAlpsBkgEntry 수신처리에 대한 이벤트
 * 
 * @author 박상훈
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkgUdevhjsAlpsbkgEntryEvent extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	private String flatFile = null;

	public EsmBkgUdevhjsAlpsbkgEntryEvent() {}

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
