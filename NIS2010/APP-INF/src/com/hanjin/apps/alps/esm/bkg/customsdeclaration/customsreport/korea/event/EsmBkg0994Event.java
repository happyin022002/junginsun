/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0994Event.java
*@FileTitle : EsmBkg0994Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistDtlCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0994 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0994HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 박상훈
 * @see ESM_BKG_0994HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0994Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorRcvHistDtlCondVO korRcvHistDtlCondVO = null;
	
	public EsmBkg0994Event() {}

	/**
	 * @return the korRcvHistDtlCondVO
	 */
	public KorRcvHistDtlCondVO getKorRcvHistDtlCondVO() {
		return korRcvHistDtlCondVO;
	}

	/**
	 * @param korRcvHistDtlCondVO the korRcvHistDtlCondVO to set
	 */
	public void setKorRcvHistDtlCondVO(
			KorRcvHistDtlCondVO korRcvHistDtlCondVO) {
		this.korRcvHistDtlCondVO = korRcvHistDtlCondVO;
	}
}
