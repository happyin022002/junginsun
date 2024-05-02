/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0501Event.java
*@FileTitle      : KPI Input by Head Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.08
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.08 이혜민
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.11.19 김용습 [CHM-201538497] [CSR 전환건] KPI Input by Head Office 화면 보완 (Trade Direction 칼럼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSpclLodRevVO;

/**
 * ESM_SQM_0501 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0501HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0501HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0501Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0501Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSpclLodRevVO sqmSpclLodRevVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmSpclLodRevVO[] sqmSpclLodRevVOs = null;
	
	public void setSqmSpclLodRevVO(SqmSpclLodRevVO sqmSpclLodRevVO){
		this. sqmSpclLodRevVO = sqmSpclLodRevVO;
	}

	public void setSqmSpclLodRevVOS(SqmSpclLodRevVO[] sqmSpclLodRevVOs){
		if(sqmSpclLodRevVOs != null){
			this.sqmSpclLodRevVOs = new SqmSpclLodRevVO[sqmSpclLodRevVOs.length];
			for(int i=0; i<sqmSpclLodRevVOs.length; ++i){
				this.sqmSpclLodRevVOs[i] = sqmSpclLodRevVOs[i];
			}
		}
	}

	public SqmSpclLodRevVO getSqmSpclLodRevVO(){
		return sqmSpclLodRevVO;
	}

	public SqmSpclLodRevVO[] getSqmSpclLodRevVOS(){
		SqmSpclLodRevVO[] ret = null;
		if(this.sqmSpclLodRevVOs != null){
			ret = new SqmSpclLodRevVO[sqmSpclLodRevVOs.length];
			for(int i=0; i<sqmSpclLodRevVOs.length; i++){
				ret[i] = this.sqmSpclLodRevVOs[i];
			}
		}
		return ret;
	}

}