/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0551Event.java
 *@FileTitle : AncsManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.ESM_BKG_0551HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0551 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0551HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0551HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkgUbizhjsAlpsbkgAnrackEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String sFlatFile ;

	public String getFlatFile() {
		return sFlatFile;
	}

	public void setFlatFile(String flatFile) {
		sFlatFile = flatFile;
	}
	
}