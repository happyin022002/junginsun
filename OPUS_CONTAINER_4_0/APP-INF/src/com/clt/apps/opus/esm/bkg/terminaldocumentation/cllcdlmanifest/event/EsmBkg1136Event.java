/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0155Event.java
*@FileTitle : ESM_BKG_0155
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.10
* 1.0 Creation
*
* 2011.11.10 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCrossChkCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0155 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0155HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0155HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1136Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllCrossChkCondVO korCllCrossChkCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private KorCllCrossChkCondVO[] korCllCrossChkCondVOs = null;

	public EsmBkg1136Event(){}

	public void setKorCllCrossChkCondVO(KorCllCrossChkCondVO korCllCrossChkCondVO){
		this. korCllCrossChkCondVO = korCllCrossChkCondVO;
	}

	public KorCllCrossChkCondVO getKorCllCrossChkCondVO(){
		return korCllCrossChkCondVO;
	}

	public KorCllCrossChkCondVO[] getKorCllCrossChkCondVOs() {
		KorCllCrossChkCondVO[] rtnVOs = null;
		if (this.korCllCrossChkCondVOs != null) {
			rtnVOs = Arrays.copyOf(korCllCrossChkCondVOs,korCllCrossChkCondVOs.length);
		}
		return rtnVOs;
	}

	public void setKorCllCrossChkCondVOs(KorCllCrossChkCondVO[] korCllCrossChkCondVOs) {
		if (korCllCrossChkCondVOs != null) {
			KorCllCrossChkCondVO[] tmpVOs = Arrays.copyOf(korCllCrossChkCondVOs,korCllCrossChkCondVOs.length);
			this.korCllCrossChkCondVOs = tmpVOs;
		}
	}

}