/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1001Event.java
*@FileTitle : Evaluation Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.20 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.event;
 
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeQECreVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_SPE_1015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeQECreVO speQECreVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeQECreVO[] speQECreVOs = null;

	public EsdSpe1015Event(){}

	public SpeQECreVO getSpeQECreVO() {
		return speQECreVO;
	}

	public void setSpeQECreVO(SpeQECreVO speQECreVO) {
		this.speQECreVO = speQECreVO;
	}

	public SpeQECreVO[] getSpeQECreVOs() {
		return speQECreVOs;
	}

	public void setSpeQECreVOs(SpeQECreVO[] speQECreVOs) {
		this.speQECreVOs = speQECreVOs;
	}
	


}