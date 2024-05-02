/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0989Event.java
*@FileTitle : EsmBkg0989Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransmitHistDtlCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0989 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0989HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 박상훈
 * @see ESM_BKG_0989HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0989Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorTransmitHistDtlCondVO korTransmitHistDtlCondVO = null;
	
	public EsmBkg0989Event() {}

	/**
	 * @return the korTransmitHistDtlCondVO
	 */
	public KorTransmitHistDtlCondVO getKorTransmitHistDtlCondVO() {
		return korTransmitHistDtlCondVO;
	}

	/**
	 * @param korTransmitHistDtlCondVO the korTransmitHistDtlCondVO to set
	 */
	public void setKorTransmitHistDtlCondVO(
			KorTransmitHistDtlCondVO korTransmitHistDtlCondVO) {
		this.korTransmitHistDtlCondVO = korTransmitHistDtlCondVO;
	}
}
