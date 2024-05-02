/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0014Event.java
*@FileTitle      : QTA Simulation by Head Office 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLodRevVO;


/**
 * ESM_SQM_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_SQM_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaLodRevVO sqmQtaLodRevVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaLodRevVO[] sqmQtaLodRevVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmSqm0014Event(){}

	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	public void setSqmQtaLodRevVO(SqmQtaLodRevVO sqmQtaLodRevVO){
		this. sqmQtaLodRevVO = sqmQtaLodRevVO;
	}

	public void setSqmQtaLodRevVOS(SqmQtaLodRevVO[] sqmQtaLodRevVOs){
		this. sqmQtaLodRevVOs = sqmQtaLodRevVOs;
	}

	public SqmQtaLodRevVO getSqmQtaLodRevVO(){
		return sqmQtaLodRevVO;
	}

	public SqmQtaLodRevVO[] getSqmQtaLodRevVOS(){
		return sqmQtaLodRevVOs;
	}

}