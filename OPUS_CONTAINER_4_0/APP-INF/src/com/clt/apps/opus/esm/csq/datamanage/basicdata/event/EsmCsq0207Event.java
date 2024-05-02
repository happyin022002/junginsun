/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0207Event.java
*@FileTitle      : Basic Data Creation for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.07 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqSctrPerfIfVO;

/**
 * ESM_CSQ_0207 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0207HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0207HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0207Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0207Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqSctrPerfIfVO csqSctrPerfIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqSctrPerfIfVO[] csqSctrPerfIfVOs = null;

	private ConditionVO conditionVO = null;
	
	
	/**
	 * @return the csqSctrPerfIfVO
	 */
	public CsqSctrPerfIfVO getCsqSctrPerfIfVO() {
		return csqSctrPerfIfVO;
	}

	/**
	 * @param csqSctrPerfIfVO the csqSctrPerfIfVO to set
	 */
	public void setCsqSctrPerfIfVO(CsqSctrPerfIfVO csqSctrPerfIfVO) {
		this.csqSctrPerfIfVO = csqSctrPerfIfVO;
	}

	/**
	 * @return the csqSctrPerfIfVOs
	 */
	public CsqSctrPerfIfVO[] getCsqSctrPerfIfVOs() {
		return csqSctrPerfIfVOs;
	}

	/**
	 * @param csqSctrPerfIfVOs the csqSctrPerfIfVOs to set
	 */
	public void setCsqSctrPerfIfVOs(CsqSctrPerfIfVO[] csqSctrPerfIfVOs) {
		this.csqSctrPerfIfVOs = csqSctrPerfIfVOs;
	}

	/**
	 * @param conditionVO
	 */
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	/**
	 * @return ConditionVO
	 */
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}