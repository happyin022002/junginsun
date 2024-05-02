/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkgUdevComOpusBkgEntryEvent.java
 *@FileTitle : EsmBkgUdevComOpusBkgEntryEvent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.11
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.09.11 박상훈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UdevComOpusBkgEntry 수신처리에 대한 이벤트
 *
 * @author 박상훈
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkgUdevComOpusBkgEntryEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String flatFile = null;

	public EsmBkgUdevComOpusBkgEntryEvent() {}

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
