/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0022Event.java
*@FileTitle      : QTA Set-up by RHQ (I/B Contract)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.21 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaPotnMgmtVO;

/**
 * ESM_SQM_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaPotnMgmtVO sqmQtaPotnMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmSqm0022Event(){}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	public void setSqmQtaPotnMgmtVO(SqmQtaPotnMgmtVO sqmQtaPotnMgmtVO){
		this. sqmQtaPotnMgmtVO = sqmQtaPotnMgmtVO;
	}

	public void setSqmQtaPotnMgmtVOS(SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOs){
		if(sqmQtaPotnMgmtVOs != null){
			this.sqmQtaPotnMgmtVOs = new SqmQtaPotnMgmtVO[sqmQtaPotnMgmtVOs.length];
			for(int i=0; i<sqmQtaPotnMgmtVOs.length; ++i){
				this.sqmQtaPotnMgmtVOs[i] = sqmQtaPotnMgmtVOs[i];
			}
		}
	}

	public SqmQtaPotnMgmtVO getSqmQtaPotnMgmtVO(){
		return sqmQtaPotnMgmtVO;
	}

	public SqmQtaPotnMgmtVO[] getSqmQtaPotnMgmtVOS(){
		SqmQtaPotnMgmtVO[] ret = null;
		if(this.sqmQtaPotnMgmtVOs != null){
			ret = new SqmQtaPotnMgmtVO[sqmQtaPotnMgmtVOs.length];
			for(int i=0; i<sqmQtaPotnMgmtVOs.length; i++){
				ret[i] = this.sqmQtaPotnMgmtVOs[i];
			}
		}
		return ret;
	}

}