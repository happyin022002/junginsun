/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0202Event.java
*@FileTitle      : POL-POD Management for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.07 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.11.10 김용습 [CHM-201538877] SQM POL-POD Management 상 Port 매치 로직 관련 CSR
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSctrPairMgmtVO;

/**
 * ESM_SQM_0202 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0202HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0202HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0202Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0202Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSctrPairMgmtVO sqmSctrPairMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmSctrPairMgmtVO[] sqmSctrPairMgmtVOs = null;
	
	public void setSqmSctrPairMgmtVO(SqmSctrPairMgmtVO sqmSctrPairMgmtVO){
		this. sqmSctrPairMgmtVO = sqmSctrPairMgmtVO;
	}

	public void setSqmSctrPairMgmtVOS(SqmSctrPairMgmtVO[] sqmSctrPairMgmtVOs){
		if(sqmSctrPairMgmtVOs != null){
			this.sqmSctrPairMgmtVOs = new SqmSctrPairMgmtVO[sqmSctrPairMgmtVOs.length];
			for(int i=0; i<sqmSctrPairMgmtVOs.length; ++i){
				this.sqmSctrPairMgmtVOs[i] = sqmSctrPairMgmtVOs[i];
			}
		}
	}

	public SqmSctrPairMgmtVO getSqmSctrPairMgmtVO(){
		return sqmSctrPairMgmtVO;
	}

	public SqmSctrPairMgmtVO[] getSqmSctrPairMgmtVOS(){
		SqmSctrPairMgmtVO[] ret = null;
		if(this.sqmSctrPairMgmtVOs != null){
			ret = new SqmSctrPairMgmtVO[sqmSctrPairMgmtVOs.length];
			for(int i=0; i<sqmSctrPairMgmtVOs.length; i++){
				ret[i] = this.sqmSctrPairMgmtVOs[i];
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