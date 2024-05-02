/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0932Event.java
*@FileTitle : Load Summary by POD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllRemarkVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0932 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0932HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEUN GMIN KIM
 * @see ESM_BKG_0932HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0932Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllCondVO korCllCondVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllRemarkVO korCllRemarkVO = null;

	/** Table Value Object Multi Data 처리 */
	private KorCllCondVO[] korCllCondVOs = null;

	public EsmBkg0932Event(){}

	public void setKorCllCondVO(KorCllCondVO korCllCondVO){
		this. korCllCondVO = korCllCondVO;
	}

	public void setKorCllRemarkVO(KorCllRemarkVO korCllRemarkVO){
		this. korCllRemarkVO = korCllRemarkVO;
	}

	public KorCllCondVO getKorCllCondVO(){
		return korCllCondVO;
	}

	public KorCllRemarkVO getKorCllRemarkVO(){
		return korCllRemarkVO;
	}

	public KorCllCondVO[] getKorCllCondVOS() {
		KorCllCondVO[] rtnVOs = null;
		if (this.korCllCondVOs != null) {
			rtnVOs = Arrays.copyOf(korCllCondVOs, korCllCondVOs.length);
		}
		return rtnVOs;
	}

	public void setKorCllCondVOS(KorCllCondVO[] korCllCondVOs) {
		if (korCllCondVOs != null) {
			KorCllCondVO[] tmpVOs = Arrays.copyOf(korCllCondVOs, korCllCondVOs.length);
			this.korCllCondVOs = tmpVOs;
		}
	}

}