/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1023Event.java
*@FileTitle : Evaluator Inquiry Choice
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.04 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.common.popup.vo.SpePopupVO;


/**
 * ESD_SPE_1023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpePopupVO spePopupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpePopupVO[] spePopupVOs = null;

	public EsdSpe1023Event(){}
	
	public void setSpePopupVO(SpePopupVO spePopupVO){
		this. spePopupVO = spePopupVO;
	}

	public void setSpePopupVOS(SpePopupVO[] spePopupVOs){
		this. spePopupVOs = spePopupVOs;
	}

	public SpePopupVO getSpePopupVO(){
		return spePopupVO;
	}

	public SpePopupVO[] getSpePopupVOS(){
		return spePopupVOs;
	}

}