/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0027Event.java
*@FileTitle      : QTA Set-up by RHQ (I/B Contract)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.21 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqQtaPotnMgmtVO;

/**
 * ESM_CSQ_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqQtaPotnMgmtVO csqQtaPotnMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmCsq0027Event(){}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
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