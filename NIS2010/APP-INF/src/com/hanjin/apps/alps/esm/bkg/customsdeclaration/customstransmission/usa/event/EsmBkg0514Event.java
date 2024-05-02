/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0514Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.01
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.07.01 김도완
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaManifestListCondForEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0514 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0514HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_0514HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0514Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private UsaManifestListCondForEdiVO manifestListCondForEdiVO = null;

	public EsmBkg0514Event() {}

	public void setUsaManifestListCondForEdiVO(UsaManifestListCondForEdiVO manifestListCondForEdiVO) {
		this.manifestListCondForEdiVO = manifestListCondForEdiVO;
	}

	
	public UsaManifestListCondForEdiVO getUsaManifestListCondForEdiVO() {
		return manifestListCondForEdiVO;
	}

}