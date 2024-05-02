/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0055Event.java
*@FileTitle      : QTA Edit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.22 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqCfmQtaVO;

/**
 * ESM_CSQ_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqCfmQtaVO csqCfmQtaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqCfmQtaVO[] csqCfmQtaVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmCsq0055Event(){}
	
	public void setCsqCfmQtaVO(CsqCfmQtaVO csqCfmQtaVO){
		this. csqCfmQtaVO = csqCfmQtaVO;
	}

	public void setCsqCfmQtaVOS(CsqCfmQtaVO[] csqCfmQtaVOs){
		this. csqCfmQtaVOs = csqCfmQtaVOs;
	}

	public CsqCfmQtaVO getCsqCfmQtaVO(){
		return csqCfmQtaVO;
	}

	public CsqCfmQtaVO[] getCsqCfmQtaVOS(){
		return csqCfmQtaVOs;
	}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}