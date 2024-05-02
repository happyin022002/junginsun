/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0007Event.java
*@FileTitle : Formula & Condition Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.05 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoObjListVO psoObjListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoObjListVO[] psoObjListVOs = null;

	/** 조회 조건으로 들어 오는 fomula 혹은 Condition의 PK인 id*/
	private String id;

	private FormulaGRPVO  formulaGRPVO = new FormulaGRPVO();
	/**
	 * id필드의 getter
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 *  해당 조회조건의 Fomula(1) 인지 Condition(2)인지 구분자 
	 */
	private String flag;

	/**
	 * flag 필드의 getter
	 * @return
	 */
	public String getFlag() {
		return flag;
	}

	public VopPso0007Event(){}
	
	public void setPsoObjListVO(PsoObjListVO psoObjListVO){
		this. psoObjListVO = psoObjListVO;
	}

	public void setPsoObjListVOS(PsoObjListVO[] psoObjListVOs){
		if (psoObjListVOs != null) {
			PsoObjListVO[] tmpVOs = new PsoObjListVO[psoObjListVOs.length];
			System.arraycopy(psoObjListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoObjListVOs = tmpVOs;
		}
	}

	public PsoObjListVO getPsoObjListVO(){
		return psoObjListVO;
	}

	public PsoObjListVO[] getPsoObjListVOS(){
		PsoObjListVO[] tmpVOs = null;
		if (this.psoObjListVOs != null) {
			tmpVOs = new PsoObjListVO[psoObjListVOs.length];
			System.arraycopy(psoObjListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * id 필드의 setter
	 * @param id
	 */
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	/**
	 * flag 필드의 setter
	 * @param flag
	 */
	public void setFlag(String flag) {
		// TODO Auto-generated method stub
		this.flag = flag;
	}

	/**
	 * 
	 * @param os
	 */
	public void setFormulaVOs(FormulaVO[] os) {
		// TODO Auto-generated method stub
		
	}

	public void setFormulaGRPVO(FormulaGRPVO formulaGRPVO) {
		this.formulaGRPVO = formulaGRPVO;
	}

	public FormulaGRPVO getFormulaGRPVO() {
		return formulaGRPVO;
	}

}