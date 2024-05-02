/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0005Event.java
*@FileTitle      : New Office Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;


/**
 * ESM_CSQ_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_CSQ_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0005Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqQtaLaneOfcVO csqQtaLaneOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setCsqQtaLaneOfcVO(CsqQtaLaneOfcVO csqQtaLaneOfcVO){
		this. csqQtaLaneOfcVO = csqQtaLaneOfcVO;
	}

	public void setCsqQtaLaneOfcVOS(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs){
		this. csqQtaLaneOfcVOs = csqQtaLaneOfcVOs;
	}

	public CsqQtaLaneOfcVO getCsqQtaLaneOfcVO(){
		return csqQtaLaneOfcVO;
	}

	public CsqQtaLaneOfcVO[] getCsqQtaLaneOfcVOS(){
		return csqQtaLaneOfcVOs;
	}

}