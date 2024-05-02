/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0440Event.java
 *@FileTitle : ESM_BKG-0440
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.27 임재택
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0440 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG-0440HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LIM JAE TAEK
 * @see ESM_BKG-0440HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0440Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RocsManifestListCondVO rocsManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private RocsManifestListCondVO[] rocsManifestListCondVOs = null;

	public EsmBkg0440Event() {
	}

	public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO) {
		this.rocsManifestListCondVO = rocsManifestListCondVO;
	}

	public void setRocsManifestListCondVOS(RocsManifestListCondVO[] rocsManifestListCondVOs) {
		if (rocsManifestListCondVOs != null)
			this.rocsManifestListCondVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
	}

	public RocsManifestListCondVO getRocsManifestListCondVO() {
		return rocsManifestListCondVO;
	}

	public RocsManifestListCondVO[] getRocsManifestListCondVOS() {
		RocsManifestListCondVO[] rtnVOs = null;
		if (rocsManifestListCondVOs != null)
			rtnVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
		return rtnVOs;
	}
}
