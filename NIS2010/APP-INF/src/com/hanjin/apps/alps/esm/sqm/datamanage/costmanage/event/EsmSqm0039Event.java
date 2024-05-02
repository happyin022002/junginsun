/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0039Event.java
*@FileTitle      : New Office Creation
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
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;


/**
 * ESM_SQM_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0039Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaLaneOfcVO sqmQtaLaneOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setSqmQtaLaneOfcVO(SqmQtaLaneOfcVO sqmQtaLaneOfcVO){
		this. sqmQtaLaneOfcVO = sqmQtaLaneOfcVO;
	}

	public void setSqmQtaLaneOfcVOS(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs){
		this. sqmQtaLaneOfcVOs = sqmQtaLaneOfcVOs;
	}

	public SqmQtaLaneOfcVO getSqmQtaLaneOfcVO(){
		return sqmQtaLaneOfcVO;
	}

	public SqmQtaLaneOfcVO[] getSqmQtaLaneOfcVOS(){
		return sqmQtaLaneOfcVOs;
	}

}