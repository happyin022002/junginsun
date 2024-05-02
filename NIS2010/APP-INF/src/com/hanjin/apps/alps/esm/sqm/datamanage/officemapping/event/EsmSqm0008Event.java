/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0008Event.java
*@FileTitle      : Lane-Office Relation Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.20
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.20 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.12.24 [CHM-201539389] Lane Office Inactive 불가하도록 비활성화 로직 변경
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * ESM_SQM_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0008Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaLaneOfcVO sqmQtaLaneOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs = null;
	
	public void setSqmQtaLaneOfcVO(SqmQtaLaneOfcVO sqmQtaLaneOfcVO){
		this. sqmQtaLaneOfcVO = sqmQtaLaneOfcVO;
	}

	public void setSqmQtaLaneOfcVOS(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs){
		if(sqmQtaLaneOfcVOs != null){
			this.sqmQtaLaneOfcVOs = new SqmQtaLaneOfcVO[sqmQtaLaneOfcVOs.length];
			for(int i=0; i<sqmQtaLaneOfcVOs.length; ++i){
				this.sqmQtaLaneOfcVOs[i] = sqmQtaLaneOfcVOs[i];
			}
		}
	}

	public SqmQtaLaneOfcVO getSqmQtaLaneOfcVO(){
		return sqmQtaLaneOfcVO;
	}

	public SqmQtaLaneOfcVO[] getSqmQtaLaneOfcVOS(){
		SqmQtaLaneOfcVO[] ret = null;
		if(this.sqmQtaLaneOfcVOs != null){
			ret = new SqmQtaLaneOfcVO[sqmQtaLaneOfcVOs.length];
			for(int i=0; i<sqmQtaLaneOfcVOs.length; i++){
				ret[i] =  this.sqmQtaLaneOfcVOs[i];
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