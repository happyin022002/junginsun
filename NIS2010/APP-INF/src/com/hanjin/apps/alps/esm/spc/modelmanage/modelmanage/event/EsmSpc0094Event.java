/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmSpc0094Event.java
*@FileTitle : Yield Group Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.12.02 진마리아
* 1.0 Creation
* 
* History
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0094HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0094Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustCtrlGrpVO custCtrlGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustCtrlGrpVO[] custCtrlGrpVOs = null;
	
	public EsmSpc0094Event(){}

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	
	public CustCtrlGrpVO getCustCtrlGrpVO() {
		return custCtrlGrpVO;
	}
	
	public void setCustCtrlGrpVO(CustCtrlGrpVO custCtrlGrpVO) {
		this.custCtrlGrpVO = custCtrlGrpVO;
	}
	
	public CustCtrlGrpVO[] getCustCtrlGrpVOs() {
		return custCtrlGrpVOs;
	}
	
	public void setCustCtrlGrpVOs(CustCtrlGrpVO[] custCtrlGrpVOs) {
		this.custCtrlGrpVOs = custCtrlGrpVOs;
	}

}