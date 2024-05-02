/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0015Event.java
*@FileTitle      : RBC Lane QTA Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaRbcVO;

/**
 * ESM_SQM_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaRbcVO sqmQtaRbcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaRbcVO[] sqmQtaRbcVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmSqm0015Event(){}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	public void setSqmQtaRbcVO(SqmQtaRbcVO sqmQtaRbcVO){
		this. sqmQtaRbcVO = sqmQtaRbcVO;
	}

	public void setSqmQtaRbcVOS(SqmQtaRbcVO[] sqmQtaRbcVOs){
		this. sqmQtaRbcVOs = sqmQtaRbcVOs;
	}

	public SqmQtaRbcVO getSqmQtaRbcVO(){
		return sqmQtaRbcVO;
	}

	public SqmQtaRbcVO[] getSqmQtaRbcVOS(){
		return sqmQtaRbcVOs;
	}

}