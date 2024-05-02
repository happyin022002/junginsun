/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0208Event.java
*@FileTitle      :Basic Data Creation_Creation for IAS Sector
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
import com.clt.syscommon.common.table.CsqDatRltVO;

/**
 * ESM_CSQ_0208 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0208HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0208HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0208Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0208Event(){}
	
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