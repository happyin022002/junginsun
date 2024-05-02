/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0038Event.java
*@FileTitle      : Lane Master
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneMgmtVO;


/**
 * ESM_SQM_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_SQM_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaLaneMgmtVO sqmQtaLaneMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaLaneMgmtVO[] sqmQtaLaneMgmtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmSqm0038Event(){}

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	public void setSqmQtaLaneMgmtVO(SqmQtaLaneMgmtVO sqmQtaLaneMgmtVO){
		this. sqmQtaLaneMgmtVO = sqmQtaLaneMgmtVO;
	}

	public void setSqmQtaLaneMgmtVOS(SqmQtaLaneMgmtVO[] sqmQtaLaneMgmtVOs){
		this. sqmQtaLaneMgmtVOs = sqmQtaLaneMgmtVOs;
	}

	public SqmQtaLaneMgmtVO getSqmQtaLaneMgmtVO(){
		return sqmQtaLaneMgmtVO;
	}

	public SqmQtaLaneMgmtVO[] getSqmQtaLaneMgmtVOS(){
		return sqmQtaLaneMgmtVOs;
	}

}