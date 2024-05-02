/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0028Event.java
*@FileTitle      : Office QTA Summary
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.22 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaStepVerVO;

/**
 * ESM_SQM_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0028Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaStepVerVO sqmQtaStepVerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaStepVerVO[] sqmQtaStepVerVOs = null;
	
	public void setSqmQtaStepVerVO(SqmQtaStepVerVO sqmQtaStepVerVO){
		this. sqmQtaStepVerVO = sqmQtaStepVerVO;
	}

	public void setSqmQtaStepVerVOS(SqmQtaStepVerVO[] sqmQtaStepVerVOs){
		this. sqmQtaStepVerVOs = sqmQtaStepVerVOs;
	}

	public SqmQtaStepVerVO getSqmQtaStepVerVO(){
		return sqmQtaStepVerVO;
	}

	public SqmQtaStepVerVO[] getSqmQtaStepVerVOS(){
		return sqmQtaStepVerVOs;
	}

}