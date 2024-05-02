/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0341Event.java
*@FileTitle : EsmBkg0341Event
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrintCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrintListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0341 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0341HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 박상훈
 * @see ESM_BKG_0341HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0341Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorDischCYCondVO korDischCYCondVO = null;
	// 데이터 추가/수정/삭제용 리스트 객체
	private KorDischCYCondVO[] korDischCYCondVOs = null;
	// RD Print 용 객체
	private KorImpPrintCondVO[] korImpPrintCondVOs = null;
	private KorImpPrintListVO[] korImpPrintListVOs = null;

	public EsmBkg0341Event() {}

	/**
	 * @return the korImpPrintCondVOs
	 */
	public KorImpPrintCondVO[] getKorImpPrintCondVOs() {
		KorImpPrintCondVO[] rtnVOs = null;
		if (this.korImpPrintCondVOs != null) {
			rtnVOs = Arrays.copyOf(korImpPrintCondVOs, korImpPrintCondVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korImpPrintCondVOs the korImpPrintCondVOs to set
	 */
	public void setKorImpPrintCondVOs(KorImpPrintCondVO[] korImpPrintCondVOs) {
		if (korImpPrintCondVOs != null) {
			KorImpPrintCondVO[] tmpVOs = Arrays.copyOf(korImpPrintCondVOs, korImpPrintCondVOs.length);
			this.korImpPrintCondVOs = tmpVOs;
		}
	}

	/**
	 * @return the korImpPrintListVOs
	 */
	public KorImpPrintListVO[] getKorImpPrintListVOs() {
		KorImpPrintListVO[] rtnVOs = null;
		if (this.korImpPrintListVOs != null) {
			rtnVOs = Arrays.copyOf(korImpPrintListVOs, korImpPrintListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korImpPrintListVOs the korImpPrintListVOs to set
	 */
	public void setKorImpPrintListVOs(KorImpPrintListVO[] korImpPrintListVOs) {
		if (korImpPrintListVOs != null) {
			KorImpPrintListVO[] tmpVOs = Arrays.copyOf(korImpPrintListVOs, korImpPrintListVOs.length);
			this.korImpPrintListVOs = tmpVOs;
		}
	}

	/**
	 * @return the korDischCYCondVO
	 */
	public KorDischCYCondVO getKorDischCYCondVO() {
		return korDischCYCondVO;
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
		KorDischCYCondVO[] rtnVOs = null;
		if (this.korDischCYCondVOs != null) {
			rtnVOs = Arrays.copyOf(korDischCYCondVOs, korDischCYCondVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korDischCYCondVOs the korDischCYCondVOs to set
	 */
	public void setKorDischCYCondVOs(KorDischCYCondVO[] korDischCYCondVOs) {
		if (korDischCYCondVOs != null) {
			KorDischCYCondVO[] tmpVOs = Arrays.copyOf(korDischCYCondVOs, korDischCYCondVOs.length);
			this.korDischCYCondVOs = tmpVOs;
		}
	}

}
