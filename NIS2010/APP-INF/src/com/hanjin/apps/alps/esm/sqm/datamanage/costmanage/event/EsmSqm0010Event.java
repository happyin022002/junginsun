/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0010Event.java
*@FileTitle      : OfficeMapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneVO;


/**
 * ESM_SQM_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0010Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaNewLaneVO sqmQtaNewLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaNewLaneVO[] sqmQtaNewLaneVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaNewLaneOfcCostVO[] sqmQtaNewLaneOfcCostVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setSqmQtaNewLaneVO(SqmQtaNewLaneVO sqmQtaNewLaneVO){
		this. sqmQtaNewLaneVO = sqmQtaNewLaneVO;
	}

	public void setSqmQtaNewLaneVOS(SqmQtaNewLaneVO[] sqmQtaNewLaneVOs){
		this. sqmQtaNewLaneVOs = sqmQtaNewLaneVOs;
	}

	public SqmQtaNewLaneVO getSqmQtaNewLaneVO(){
		return sqmQtaNewLaneVO;
	}

	public SqmQtaNewLaneVO[] getSqmQtaNewLaneVOS(){
		return sqmQtaNewLaneVOs;
	}

	public void setSqmQtaNewLaneOfcCostVOS(SqmQtaNewLaneOfcCostVO[] sqmQtaNewLaneOfcCostVOs){
		this. sqmQtaNewLaneOfcCostVOs = sqmQtaNewLaneOfcCostVOs;
	}
	
	public SqmQtaNewLaneOfcCostVO[] getSqmQtaNewLaneOfcCostVOS(){
		return sqmQtaNewLaneOfcCostVOs;
	}
}