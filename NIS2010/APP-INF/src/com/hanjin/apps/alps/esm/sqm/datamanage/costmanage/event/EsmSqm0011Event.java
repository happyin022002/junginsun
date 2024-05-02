/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0011Event.java
*@FileTitle      : Basic CMCB (CM Cost Per Box)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.10.27 김용습 [CHM-201538305] [CSR 전환건] Basic CMCB (CM Cost Per Box) / Basic CMCB for IAS Sector 화면 내 신규 칼럼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcCostVO;

/**
 * ESM_SQM_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0011Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaLaneOfcCostVO sqmQtaLaneOfcCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs = null;
	
	public void setSqmQtaLaneOfcCostVO(SqmQtaLaneOfcCostVO sqmQtaLaneOfcCostVO){
		this. sqmQtaLaneOfcCostVO = sqmQtaLaneOfcCostVO;
	}

	public void setSqmQtaLaneOfcCostVOS(SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs){
		if(sqmQtaLaneOfcCostVOs != null){
			this.sqmQtaLaneOfcCostVOs = new SqmQtaLaneOfcCostVO[sqmQtaLaneOfcCostVOs.length];
			for(int i=0; i<sqmQtaLaneOfcCostVOs.length; ++i){
				this.sqmQtaLaneOfcCostVOs[i] = sqmQtaLaneOfcCostVOs[i];
			}
		}
	}

	public SqmQtaLaneOfcCostVO getSqmQtaLaneOfcCostVO(){
		return sqmQtaLaneOfcCostVO;
	}

	public SqmQtaLaneOfcCostVO[] getSqmQtaLaneOfcCostVOS(){
		SqmQtaLaneOfcCostVO[] ret = null;
		if(this.sqmQtaLaneOfcCostVOs != null){
			ret = new SqmQtaLaneOfcCostVO[sqmQtaLaneOfcCostVOs.length];
			for(int i=0; i<sqmQtaLaneOfcCostVOs.length; i++){
				ret[i] = this.sqmQtaLaneOfcCostVOs[i];
			}
		}
		return ret;
	}
}