/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0503Event.java
*@FileTitle : EsmBkg0503Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.01.17 이수진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkCondVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * ESM_BKG_0503 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0503HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author charves
 * @see ESM_BKG_0503HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0503Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorTransCrossChkCondVO korTransCrossChkCondVO = null;




	public EsmBkg0503Event() {

	}


	/**
	 * @return the korTransCrossChkCondVO
	 */
	public KorTransCrossChkCondVO getKorTransCrossChkCondVO() {
		return korTransCrossChkCondVO;
	}


	/**
	 * @param korTransCrossChkCondVO the korTransCrossChkCondVO to set
	 */
	public void setKorTransCrossChkCondVO(
			KorTransCrossChkCondVO korTransCrossChkCondVO) {
		this.korTransCrossChkCondVO = korTransCrossChkCondVO;
	}



}