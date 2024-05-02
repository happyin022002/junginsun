/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkgOpusbkgUdevcomEvent.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 Creation
=========================================================*/


package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * FNS009_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * FNS009_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author limjaetaek
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkgOpusbkgUdevcomEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
}