/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0416Event.java
 *@FileTitle : EsmBkg0416Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0347 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0347HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0347HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0347Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;


	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorDischCoCondVO korDischCoCondVO = null;
	// 데이터 추가/수정/삭제용 리스트 객체
	private KorDischCoCondVO[] korDischCoCondVOs = null;
	
	public EsmBkg0347Event() {}

	/**
	 * @return the korDischCoCondVO
	 */
	public KorDischCoCondVO getKorDischCoCondVO() {
		return korDischCoCondVO;
	}

	/**
	 * @param korDischCoCondVO the korDischCoCondVO to set
	 */
	public void setKorDischCoCondVO(KorDischCoCondVO korDischCoCondVO) {
		this.korDischCoCondVO = korDischCoCondVO;
	}

	/**
	 * @return the korDischCoCondVOs
	 */
	public KorDischCoCondVO[] getKorDischCoCondVOs() {
		KorDischCoCondVO[] rtnVOs = null;
		if (this.korDischCoCondVOs != null) {
			rtnVOs = Arrays.copyOf(korDischCoCondVOs, korDischCoCondVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korDischLocCondVOs the korDischLocCondVOs to set
	 */
	public void setKorDischCoCondVOs(KorDischCoCondVO[] korDischCoCondVOs){
		if(korDischCoCondVOs != null){
			KorDischCoCondVO[] tmpVOs = Arrays.copyOf(korDischCoCondVOs, korDischCoCondVOs.length);
			this.korDischCoCondVOs = tmpVOs;
		}
	}
	
}