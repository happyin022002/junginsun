/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0210Event.java
*@FileTitle : ID Link Condition
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.20 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;


/**
 * VOP_PSO_0210 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0210HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_PSO_0210HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0210Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UseStatusConditonFormulaDtlVO[] useStatusConditonFormulaDtlVOs = null;

	public VopPso0210Event(){}
	
	public void setUseStatusConditonFormulaDtlVO(UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO){
		this. useStatusConditonFormulaDtlVO = useStatusConditonFormulaDtlVO;
	}

	public void setUseStatusConditonFormulaDtlVOS(UseStatusConditonFormulaDtlVO[] useStatusConditonFormulaDtlVOs){
		if (useStatusConditonFormulaDtlVOs != null) {
			UseStatusConditonFormulaDtlVO[] tmpVOs = new UseStatusConditonFormulaDtlVO[useStatusConditonFormulaDtlVOs .length];
			System.arraycopy(useStatusConditonFormulaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. useStatusConditonFormulaDtlVOs = tmpVOs;
		}
	}

	public UseStatusConditonFormulaDtlVO getUseStatusConditonFormulaDtlVO(){
		return useStatusConditonFormulaDtlVO;
	}


	public UseStatusConditonFormulaDtlVO[] getUseStatusConditonFormulaDtlVOS(){
		UseStatusConditonFormulaDtlVO[] tmpVOs = null;
		if (this. useStatusConditonFormulaDtlVOs != null) {
			tmpVOs = new UseStatusConditonFormulaDtlVO[useStatusConditonFormulaDtlVOs .length];
			System.arraycopy(useStatusConditonFormulaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}