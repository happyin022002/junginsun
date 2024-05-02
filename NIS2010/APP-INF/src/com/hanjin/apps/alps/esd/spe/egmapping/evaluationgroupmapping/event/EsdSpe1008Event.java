/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1008Event.java
*@FileTitle : Evaluation Group Mapping & Basic Evaluation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.event;

import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.vo.EGAndBEMappingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_SPE_1008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EGAndBEMappingVO egAndBEMappingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EGAndBEMappingVO[] egAndBEMappingVOs = null;

	public EsdSpe1008Event(){}

	public EGAndBEMappingVO getEgAndBEMappingVO() {
		return egAndBEMappingVO;
	}

	public void setEgAndBEMappingVO(EGAndBEMappingVO egAndBEMappingVO) {
		this.egAndBEMappingVO = egAndBEMappingVO;
	}

	public EGAndBEMappingVO[] getEgAndBEMappingVOs() {
		return egAndBEMappingVOs;
	}

	public void setEgAndBEMappingVOs(EGAndBEMappingVO[] egAndBEMappingVOs) {
		this.egAndBEMappingVOs = egAndBEMappingVOs;
	}
	
}