/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1154Event.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.12
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1154 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1154HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_1154HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1154Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BrManifestListCondVO brManifestListCondVO = null;
	
	public EsmBkg1154Event(){}

	public BrManifestListCondVO getBrManifestListCondVO() {
		return brManifestListCondVO;
	}

	public void setBrManifestListCondVO(BrManifestListCondVO brManifestListCondVO) {
		this.brManifestListCondVO = brManifestListCondVO;
	}

	
}