/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0021Event.java
*@FileTitle      : QTA Set up by Head Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqQtaPotnMgmtVO;

/**
 * ESM_CSQ_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_CSQ_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_CSQ_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0021Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqQtaPotnMgmtVO csqQtaPotnMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOs = null;
	
	public void setCsqQtaPotnMgmtVO(CsqQtaPotnMgmtVO csqQtaPotnMgmtVO){
		this. csqQtaPotnMgmtVO = csqQtaPotnMgmtVO;
	}

	public void setCsqQtaPotnMgmtVOS(CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOs){
		this. csqQtaPotnMgmtVOs = csqQtaPotnMgmtVOs;
	}

	public CsqQtaPotnMgmtVO getCsqQtaPotnMgmtVO(){
		return csqQtaPotnMgmtVO;
	}

	public CsqQtaPotnMgmtVO[] getCsqQtaPotnMgmtVOS(){
		return csqQtaPotnMgmtVOs;
	}

}