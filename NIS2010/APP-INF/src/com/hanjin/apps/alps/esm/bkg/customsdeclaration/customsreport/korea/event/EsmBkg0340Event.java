/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0340Event.java
*@FileTitle : EsmBkg0340Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischPrintCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischPrintListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0340 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0340HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 박상훈
 * @see ESM_BKG_0340HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0340Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorDischCYCondVO korDischCYCondVO = null;
	// 데이터 추가/수정/삭제용 리스트 객체
	private KorDischCYCondVO[] korDischCYCondVOs = null;
	// PRINT 를 위한 객체
	private KorDischPrintListVO[] korDischPrintListVOs = null;
	private KorDischPrintCondVO[] korDischPrintCondVOs = null;
	
	public EsmBkg0340Event() {}

	/**
	 * @return the korDischCYCondVO
	 */
	public KorDischCYCondVO getKorDischCYCondVO() {
		return korDischCYCondVO;
	}

	/**
	 * @return the korDischPrintListVOs
	 */
	public KorDischPrintListVO[] getKorDischPrintListVOs() {
		return korDischPrintListVOs;
	}

	/**
	 * @param korDischPrintListVOs the korDischPrintListVOs to set
	 */
	public void setKorDischPrintListVOs(KorDischPrintListVO[] korDischPrintListVOs) {
		this.korDischPrintListVOs = korDischPrintListVOs;
	}

	/**
	 * @return the korDischPrintCondVOs
	 */
	public KorDischPrintCondVO[] getKorDischPrintCondVOs() {
		return korDischPrintCondVOs;
	}

	/**
	 * @param korDischPrintCondVOs the korDischPrintCondVOs to set
	 */
	public void setKorDischPrintCondVOs(KorDischPrintCondVO[] korDischPrintCondVOs) {
		this.korDischPrintCondVOs = korDischPrintCondVOs;
	}

	/**
	 * @param korDischCYCondVO the korDischCYCondVO to set
	 */
	public void setKorDischCYCondVO(KorDischCYCondVO korDischCYCondVO) {
		this.korDischCYCondVO = korDischCYCondVO;
	}

	/**
	 * @return the korDischCYCondVOs
	 */
	public KorDischCYCondVO[] getKorDischCYCondVOs() {
		return korDischCYCondVOs;
	}

	/**
	 * @param korDischCYCondVOs the korDischCYCondVOs to set
	 */
	public void setKorDischCYCondVOs(KorDischCYCondVO[] korDischCYCondVOs) {
		this.korDischCYCondVOs = korDischCYCondVOs;
	}

}
