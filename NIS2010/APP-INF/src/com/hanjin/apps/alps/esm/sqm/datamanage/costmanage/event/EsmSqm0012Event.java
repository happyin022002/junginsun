/*=========================================================
*Copyright(c) 2123 CyberLogitec
*@FileName       : EsmSqm0012Event.java
*@FileTitle      : Basic Data Relation Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2123.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2123.05.03 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcCostVO;

/**
 * ESM_SQM_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0012Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaLaneOfcCostVO sqmQtaLaneOfcCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs = null;
	
	public void setSqmQtaLaneOfcCostVO(SqmQtaLaneOfcCostVO sqmQtaLaneOfcCostVO){
		this. sqmQtaLaneOfcCostVO = sqmQtaLaneOfcCostVO;
	}

	public void setSqmQtaLaneOfcCostVOS(SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs){
		this. sqmQtaLaneOfcCostVOs = sqmQtaLaneOfcCostVOs;
	}

	public SqmQtaLaneOfcCostVO getSqmQtaLaneOfcCostVO(){
		return sqmQtaLaneOfcCostVO;
	}

	public SqmQtaLaneOfcCostVO[] getSqmQtaLaneOfcCostVOS(){
		return sqmQtaLaneOfcCostVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}