/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0204Event.java
*@FileTitle      : Sector-Office Relation Setting for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.08
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.08 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqSctrLaneOfcVO;

/**
 * ESM_CSQ_0204 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0204HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0204HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0204Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0204Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqSctrLaneOfcVO csqSctrLaneOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqSctrLaneOfcVO[] csqSctrLaneOfcVOs = null;
	
	public void setCsqSctrLaneOfcVO(CsqSctrLaneOfcVO csqSctrLaneOfcVO){
		this. csqSctrLaneOfcVO = csqSctrLaneOfcVO;
	}

	public void setCsqSctrLaneOfcVOS(CsqSctrLaneOfcVO[] csqSctrLaneOfcVOs){
		this. csqSctrLaneOfcVOs = csqSctrLaneOfcVOs;
	}

	public CsqSctrLaneOfcVO getCsqSctrLaneOfcVO(){
		return csqSctrLaneOfcVO;
	}

	public CsqSctrLaneOfcVO[] getCsqSctrLaneOfcVOS(){
		return csqSctrLaneOfcVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}