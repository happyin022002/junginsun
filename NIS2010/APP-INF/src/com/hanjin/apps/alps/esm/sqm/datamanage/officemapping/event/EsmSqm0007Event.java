/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0007Event.java
*@FileTitle      : RHQ-Office Mapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaOfcVO;


/**
 * ESM_SQM_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_SQM_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaOfcVO sqmQtaOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaOfcVO[] sqmQtaOfcVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmSqm0007Event(){}

	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setSqmQtaOfcVO(SqmQtaOfcVO sqmQtaOfcVO){
		this. sqmQtaOfcVO = sqmQtaOfcVO;
	}

	public void setSqmQtaOfcVOS(SqmQtaOfcVO[] sqmQtaOfcVOs){
		this. sqmQtaOfcVOs = sqmQtaOfcVOs;
	}

	public SqmQtaOfcVO getSqmQtaOfcVO(){
		return sqmQtaOfcVO;
	}

	public SqmQtaOfcVO[] getSqmQtaOfcVOS(){
		return sqmQtaOfcVOs;
	}

}