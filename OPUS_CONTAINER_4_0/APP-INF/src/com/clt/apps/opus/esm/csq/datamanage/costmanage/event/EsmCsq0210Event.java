/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0210Event.java
*@FileTitle      : P_F Skd Group Management for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.06
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.06 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqDatRltVO;

/**
 * ESM_CSQ_0210 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0210HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0210HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0210Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0210Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNewLaneSecCmcbListVO searchNewLaneSecCmcbListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOs = null;
	
	public void setSearchNewLaneSecCmcbListVO(SearchNewLaneSecCmcbListVO searchNewLaneSecCmcbListVO){
		this. searchNewLaneSecCmcbListVO = searchNewLaneSecCmcbListVO;
	}

	public void setSearchNewLaneSecCmcbListVOS(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOs){
		this. searchNewLaneSecCmcbListVOs = searchNewLaneSecCmcbListVOs;
	}

	public SearchNewLaneSecCmcbListVO getSearchNewLaneSecCmcbListVO(){
		return searchNewLaneSecCmcbListVO;
	}

	public SearchNewLaneSecCmcbListVO[] getSearchNewLaneSecCmcbListVOS(){
		return searchNewLaneSecCmcbListVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}