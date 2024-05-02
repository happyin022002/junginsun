/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmSpc0096Event.java
*@FileTitle : Average Performance per Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.24 진마리아
* 1.0 Creation
* 2013.01.24 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.ModelPfmcVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0096HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0096Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ModelPfmcVO modelPfmcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ModelPfmcVO[] modelPfmcVOs = null;

	public EsmSpc0096Event(){}

	public ModelPfmcVO getModelPfmcVO() {
		return modelPfmcVO;
	}

	public void setModelPfmcVO(ModelPfmcVO modelPfmcVO) {
		this.modelPfmcVO = modelPfmcVO;
	}

	public ModelPfmcVO[] getModelPfmcVOs() {
		return modelPfmcVOs;
	}

	public void setModelPfmcVOs(ModelPfmcVO[] modelPfmcVOs) {
		this.modelPfmcVOs = modelPfmcVOs;
	}

}