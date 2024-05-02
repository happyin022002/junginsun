/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0502Event.java
*@FileTitle      : Basic CMCB (CM Cost Per Box)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.10
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.10 이혜민
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.11.19 김용습 [CHM-201538495] [CSR 전환건] Basic CMCB 화면 보완 (Trade Direction 칼럼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSpclLaneOfcCostVO;

/**
 * ESM_SQM_0502 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0502HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0502HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0502Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0502Event(){}
	
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSpclLaneOfcCostVO sqmSpclLaneOfcCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmSpclLaneOfcCostVO[] sqmSpclLaneOfcCostVOs = null;
	
	public void setSqmSpclLodRevVO(SqmSpclLaneOfcCostVO sqmSpclLaneOfcCostVO){
		this. sqmSpclLaneOfcCostVO = sqmSpclLaneOfcCostVO;
	}

	public void setSqmSpclLaneOfcCostVOS(SqmSpclLaneOfcCostVO[] sqmSpclLaneOfcCostVOs){
		if(sqmSpclLaneOfcCostVOs != null){
			this.sqmSpclLaneOfcCostVOs = new SqmSpclLaneOfcCostVO[sqmSpclLaneOfcCostVOs.length];
			for(int i=0; i<sqmSpclLaneOfcCostVOs.length; ++i){
				this.sqmSpclLaneOfcCostVOs[i] = sqmSpclLaneOfcCostVOs[i];
			}
		}
	}

	public SqmSpclLaneOfcCostVO getSqmSpclLaneOfcCostVO(){
		return sqmSpclLaneOfcCostVO;
	}

	public SqmSpclLaneOfcCostVO[] getSqmSpclLaneOfcCostVOS(){
		SqmSpclLaneOfcCostVO[] ret = null;
		if(this.sqmSpclLaneOfcCostVOs != null){
			ret = new SqmSpclLaneOfcCostVO[sqmSpclLaneOfcCostVOs.length];
			for(int i=0; i<sqmSpclLaneOfcCostVOs.length; i++){
				ret[i] = this.sqmSpclLaneOfcCostVOs[i];
			}
		}
		return ret;
	}

}