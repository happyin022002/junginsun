/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0334Event.java
*@FileTitle : EsmBkg0334Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0334 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0334HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 박상훈
 * @see ESM_BKG_0334HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0334Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorDischLocCondVO korDischLocCondVO = null;
	// 데이터 추가/수정/삭제용 리스트 객체
	private KorDischLocCondVO[] korDischLocCondVOs = null;

	public EsmBkg0334Event() {}

	/**
	 * @return the korDischLocCondVO
	 */
	public KorDischLocCondVO getKorDischLocCondVO() {
		return korDischLocCondVO;
	}

	/**
	 * @param korDischLocCondVO the korDischLocCondVO to set
	 */
	public void setKorDischLocCondVO(KorDischLocCondVO korDischLocCondVO) {
		this.korDischLocCondVO = korDischLocCondVO;
	}

	/**
	 * @return the korDischLocCondVOs
	 */
	public KorDischLocCondVO[] getKorDischLocCondVOs() {
		KorDischLocCondVO[] rtnVOs = null;
		if (this.korDischLocCondVOs != null) {
			rtnVOs = Arrays.copyOf(korDischLocCondVOs, korDischLocCondVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korDischLocCondVOs the korDischLocCondVOs to set
	 */
	public void setKorDischLocCondVOs(KorDischLocCondVO[] korDischLocCondVOs) {
		if (korDischLocCondVOs != null) {
			KorDischLocCondVO[] tmpVOs = Arrays.copyOf(korDischLocCondVOs, korDischLocCondVOs.length);
			this.korDischLocCondVOs = tmpVOs;
		}
	}

}
