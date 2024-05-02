/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0036Event.java
*@FileTitle      : Office QTA Summary
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.22 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqQtaStepVerVO;

/**
 * ESM_CSQ_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0036Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqQtaStepVerVO csqQtaStepVerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqQtaStepVerVO[] csqQtaStepVerVOs = null;
	
	public void setCsqQtaStepVerVO(CsqQtaStepVerVO csqQtaStepVerVO){
		this. csqQtaStepVerVO = csqQtaStepVerVO;
	}

	public void setCsqQtaStepVerVOS(CsqQtaStepVerVO[] csqQtaStepVerVOs){
		this. csqQtaStepVerVOs = csqQtaStepVerVOs;
	}

	public CsqQtaStepVerVO getCsqQtaStepVerVO(){
		return csqQtaStepVerVO;
	}

	public CsqQtaStepVerVO[] getCsqQtaStepVerVOS(){
		return csqQtaStepVerVOs;
	}

}