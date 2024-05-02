/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1006Event.java
*@FileTitle : EG vs Evaluator Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;


/**
 * ESD_SPE_1006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeEGEVMappingVO speEGEVMappingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeEGEVMappingVO[] speEGEVMappingVOs = null;

	public EsdSpe1006Event(){}

	public SpeEGEVMappingVO getSpeEGEVMappingVO() {
		return speEGEVMappingVO;
	}

	public void setSpeEGEVMappingVO(SpeEGEVMappingVO speEGEVMappingVO) {
		this.speEGEVMappingVO = speEGEVMappingVO;
	}

	public SpeEGEVMappingVO[] getSpeEGEVMappingVOs() {
		return speEGEVMappingVOs;
	}

	public void setSpeEGEVMappingVOs(SpeEGEVMappingVO[] speEGEVMappingVOs) {
		this.speEGEVMappingVOs = speEGEVMappingVOs;
	}


	



}