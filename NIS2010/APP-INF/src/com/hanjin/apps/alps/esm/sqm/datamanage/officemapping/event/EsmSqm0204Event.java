/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0204Event.java
*@FileTitle      : Sector-Office Relation Setting for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.08
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.08 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.10.27 김용습 [CHM-201537712] [CSR 전환건] "Sector-Office Relation Setting for IAS Sector 화면 내 Creation"의 로직 변경 
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSctrLaneOfcVO;

/**
 * ESM_SQM_0204 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0204HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0204HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0204Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0204Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSctrLaneOfcVO sqmSctrLaneOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmSctrLaneOfcVO[] sqmSctrLaneOfcVOs = null;
	
	public void setSqmSctrLaneOfcVO(SqmSctrLaneOfcVO sqmSctrLaneOfcVO){
		this. sqmSctrLaneOfcVO = sqmSctrLaneOfcVO;
	}

	public void setSqmSctrLaneOfcVOS(SqmSctrLaneOfcVO[] sqmSctrLaneOfcVOs){
		if(sqmSctrLaneOfcVOs != null){
			this.sqmSctrLaneOfcVOs = new SqmSctrLaneOfcVO[sqmSctrLaneOfcVOs.length];
			for(int i=0; i<sqmSctrLaneOfcVOs.length; ++i){
				this.sqmSctrLaneOfcVOs[i] = sqmSctrLaneOfcVOs[i];
			}
		}
	}

	public SqmSctrLaneOfcVO getSqmSctrLaneOfcVO(){
		return sqmSctrLaneOfcVO;
	}

	public SqmSctrLaneOfcVO[] getSqmSctrLaneOfcVOS(){
		SqmSctrLaneOfcVO[] ret = null;
		if(this.sqmSctrLaneOfcVOs != null){
			ret = new SqmSctrLaneOfcVO[sqmSctrLaneOfcVOs.length];
			for(int i=0; i<sqmSctrLaneOfcVOs.length; i++){
				ret[i] = this.sqmSctrLaneOfcVOs[i];
			}
		}
		return ret;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}