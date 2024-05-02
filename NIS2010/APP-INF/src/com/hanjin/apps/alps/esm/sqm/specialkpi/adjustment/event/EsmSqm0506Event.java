/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0506Event.java
*@FileTitle      : KPI Creation & Edit_Office Add Pop up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.12
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.12 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSpclNewOfcVO;

/**
 * ESM_SQM_0506 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0506HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0506HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0506Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0506Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSpclNewOfcVO sqmSpclNewOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmSpclNewOfcVO[] sqmSpclNewOfcVOs = null;
	
	public void setSqmSpclNewOfcVO(SqmSpclNewOfcVO sqmSpclNewOfcVO){
		this. sqmSpclNewOfcVO = sqmSpclNewOfcVO;
	}
	
	public void setSqmSpclNewOfcVOS(SqmSpclNewOfcVO[] sqmSpclNewOfcVOs){
		this. sqmSpclNewOfcVOs = sqmSpclNewOfcVOs;
	}
	
	public SqmSpclNewOfcVO getSqmSpclNewOfcVO(){
		return sqmSpclNewOfcVO;
	}
	
	public SqmSpclNewOfcVO[] getSqmSpclNewOfcVOS(){
		return sqmSpclNewOfcVOs;
	}
}