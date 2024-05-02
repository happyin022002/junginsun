/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0035Event.java
*@FileTitle      : Allocation = QTA Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.22 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.10.01 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmAlocQtaVO;

/**
 * ESM_SQM_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmAlocQtaVO sqmAlocQtaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmAlocQtaVO[] sqmAlocQtaVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmSqm0035Event(){}
	
	public void setSqmAlocQtaVO(SqmAlocQtaVO sqmAlocQtaVO){
		this. sqmAlocQtaVO = sqmAlocQtaVO;
	}

	public void setSqmAlocQtaVOS(SqmAlocQtaVO[] sqmAlocQtaVOs){
		if(sqmAlocQtaVOs != null){
			this.sqmAlocQtaVOs = new SqmAlocQtaVO[sqmAlocQtaVOs.length];
			for(int i=0; i<sqmAlocQtaVOs.length; ++i){
				this.sqmAlocQtaVOs[i] = sqmAlocQtaVOs[i];
			}
		}
	}

	public SqmAlocQtaVO getSqmAlocQtaVO(){
		return sqmAlocQtaVO;
	}

	public SqmAlocQtaVO[] getSqmAlocQtaVOS(){
		SqmAlocQtaVO[] ret = null;
		if(this.sqmAlocQtaVOs != null){
			ret = new SqmAlocQtaVO[sqmAlocQtaVOs.length];
			for(int i=0; i<sqmAlocQtaVOs.length; i++){
				ret[i] = this.sqmAlocQtaVOs[i];
			}
		}
		return ret;
	}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}