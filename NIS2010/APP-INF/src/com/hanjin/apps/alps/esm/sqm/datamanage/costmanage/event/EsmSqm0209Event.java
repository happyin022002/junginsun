/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0209Event.java
*@FileTitle      : New Lane & Sector CMCB
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.20
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.20 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SQM_0209 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0209HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0209HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0209Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmSqm0209Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNewLaneSecCmcbListVO searchNewLaneSecCmcbListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;


	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}

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

}