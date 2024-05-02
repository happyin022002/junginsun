/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0028Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0028HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO = null;
	private CstmsManifestAmendmentVO cstmsManifestAmendmentVO = null;

	/** Table Value Object 조회 결과 및 다건 처리 */
	private CstmsManifestAmendmentVO[] cstmsManifestAmendmentVOs = null;

	private String cntCd = "";
	private String aiDiv = "";


	public EsmBkg0028Event() {}


	public void setCstmsManifestAmendmentCondVO(CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO) {
		this.cstmsManifestAmendmentCondVO = cstmsManifestAmendmentCondVO;
	}

	public void setCstmsManifestAmendmentVO(CstmsManifestAmendmentVO cstmsManifestAmendmentVO) {
		this.cstmsManifestAmendmentVO = cstmsManifestAmendmentVO;
	}

	public CstmsManifestAmendmentCondVO getCstmsManifestAmendmentCondVO() {
		return cstmsManifestAmendmentCondVO;
	}

	public CstmsManifestAmendmentVO getCstmsManifestAmendmentVO() {
		return cstmsManifestAmendmentVO;
	}

	public CstmsManifestAmendmentVO[] getCstmsManifestAmendmentVOs() {
		CstmsManifestAmendmentVO[] rtnVOs = null;
		if (this.cstmsManifestAmendmentVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsManifestAmendmentVOs, cstmsManifestAmendmentVOs.length);
		}
		return rtnVOs;
	}

	public void setCstmsManifestAmendmentVOs(CstmsManifestAmendmentVO[] cstmsManifestAmendmentVOs) {
		if (cstmsManifestAmendmentVOs != null) {
			CstmsManifestAmendmentVO[] tmpVOs = Arrays.copyOf(cstmsManifestAmendmentVOs, cstmsManifestAmendmentVOs.length);
			this.cstmsManifestAmendmentVOs = tmpVOs;
		}
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getAiDiv() {
		return aiDiv;
	}


	public void setAiDiv(String aiDiv) {
		this.aiDiv = aiDiv;
	}

}
