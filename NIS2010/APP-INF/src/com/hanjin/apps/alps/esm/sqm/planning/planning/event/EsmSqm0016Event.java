/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0016Event.java
*@FileTitle      : QTA Set up by Head Office
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
import com.hanjin.syscommon.common.table.SqmQtaPotnMgmtVO;

/**
 * ESM_SQM_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_SQM_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0016Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaPotnMgmtVO sqmQtaPotnMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOs = null;
	
	public void setSqmQtaPotnMgmtVO(SqmQtaPotnMgmtVO sqmQtaPotnMgmtVO){
		this. sqmQtaPotnMgmtVO = sqmQtaPotnMgmtVO;
	}

	public void setSqmQtaPotnMgmtVOS(SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOs){
		this. sqmQtaPotnMgmtVOs = sqmQtaPotnMgmtVOs;
	}

	public SqmQtaPotnMgmtVO getSqmQtaPotnMgmtVO(){
		return sqmQtaPotnMgmtVO;
	}

	public SqmQtaPotnMgmtVO[] getSqmQtaPotnMgmtVOS(){
		return sqmQtaPotnMgmtVOs;
	}

}