/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0030Event.java
*@FileTitle : EsmBkg0030Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.06.23 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdFormVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son Yun Seuk
 * @see ESM_BKG_0030HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private KorManifestListCondVO 	 korManifestListCondVO = null;
	private KorAmdFormVO[] korAmdFormVOs = null;

	/**
	 * @return the korManifestListCondVO
	 */
	public KorManifestListCondVO getKorManifestListCondVO() {
		return korManifestListCondVO;
	}

	/**
	 * @param korManifestListCondVO the korManifestListCondVO to set
	 */
	public void setKorManifestListCondVO(KorManifestListCondVO korManifestListCondVO) {
		this.korManifestListCondVO = korManifestListCondVO;
	}

	/**
	 * @return the korAmdFormVOs
	 */
	public KorAmdFormVO[] getKorAmdFormVOs() {
		KorAmdFormVO[] rtnVOs = null;
		if (this.korAmdFormVOs != null) {
			rtnVOs = Arrays.copyOf(korAmdFormVOs, korAmdFormVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korAmdFormVOs the korAmdFormVOs to set
	 */
	public void setKorAmdFormVOs(KorAmdFormVO[] korAmdFormVOs) {
		if (korAmdFormVOs != null) {
			KorAmdFormVO[] tmpVOs = Arrays.copyOf(korAmdFormVOs, korAmdFormVOs.length);
			this.korAmdFormVOs = tmpVOs;
		}
	}

}
