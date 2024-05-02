/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1001Event.java
*@FileTitle : Evaluation Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo.SpeEGCreVO;


/**
 * ESD_SPE_1001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeEGCreVO speEGCreVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeEGCreVO[] speEGCreVOs = null;

	public EsdSpe1001Event(){}

	public SpeEGCreVO getSpeEGCreVO() {
		return speEGCreVO;
	}

	public void setSpeEGCreVO(SpeEGCreVO speEGCreVO) {
		this.speEGCreVO = speEGCreVO;
	}

	public SpeEGCreVO[] getSpeEGCreVOs() {
		return speEGCreVOs;
	}

	public void setSpeEGCreVOs(SpeEGCreVO[] speEGCreVOs) {
		this.speEGCreVOs = speEGCreVOs;
	}
	

}