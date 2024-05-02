/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0001Event.java
*@FileTitle      : Basic Data Relation Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqDatRltVO;

/**
 * ESM_CSQ_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0001Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqDatRltVO csqDatRltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqDatRltVO[] csqDatRltVOs = null;
	
	public void setCsqDatRltVO(CsqDatRltVO csqDatRltVO){
		this. csqDatRltVO = csqDatRltVO;
	}

	public void setCsqDatRltVOS(CsqDatRltVO[] csqDatRltVOs){
		this. csqDatRltVOs = csqDatRltVOs;
	}

	public CsqDatRltVO getCsqDatRltVO(){
		return csqDatRltVO;
	}

	public CsqDatRltVO[] getCsqDatRltVOS(){
		return csqDatRltVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}