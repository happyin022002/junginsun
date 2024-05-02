/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0335Event.java
*@FileTitle : EsmBkg0335Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0335 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0335HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 박상훈
 * @see ESM_BKG_0335HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0335Event extends EventSupport {


	private static final long serialVersionUID = 8454854104105301205L;
	
	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorEntryTpCondVO korEntryTpCondVO = null;
	// 데이터 추가/수정/삭제용 리스트 객체
	private KorEntryTpCondVO[] korEntryTpCondVOs = null;
	
	public EsmBkg0335Event() {}

	/**
	 * @return the korEntryTpCondVO
	 */
	public KorEntryTpCondVO getKorEntryTpCondVO() {
		return korEntryTpCondVO;
	}

	/**
	 * @param korEntryTpCondVO the korEntryTpCondVO to set
	 */
	public void setKorEntryTpCondVO(KorEntryTpCondVO korEntryTpCondVO) {
		this.korEntryTpCondVO = korEntryTpCondVO;
	}

	/**
	 * @return the korEntryTpCondVOs
	 */
	public KorEntryTpCondVO[] getKorEntryTpCondVOs() {
		return korEntryTpCondVOs;
	}

	/**
	 * @param korEntryTpCondVOs the korEntryTpCondVOs to set
	 */
	public void setKorEntryTpCondVOs(KorEntryTpCondVO[] korEntryTpCondVOs) {
		this.korEntryTpCondVOs = korEntryTpCondVOs;
	}

}
