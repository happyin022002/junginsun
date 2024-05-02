/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0210Event.java
*@FileTitle      : P_F Skd Group Management for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.06
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.06 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.10.27 김용습 [CHM-201538305] [CSR 전환건] Basic CMCB (CM Cost Per Box) / Basic CMCB for IAS Sector 화면 내 신규 칼럼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmDatRltVO;

/**
 * ESM_SQM_0210 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0210HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0210HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0210Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0210Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNewLaneSecCmcbListVO searchNewLaneSecCmcbListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOs = null;
	
	public void setSearchNewLaneSecCmcbListVO(SearchNewLaneSecCmcbListVO searchNewLaneSecCmcbListVO){
		this. searchNewLaneSecCmcbListVO = searchNewLaneSecCmcbListVO;
	}

	public void setSearchNewLaneSecCmcbListVOS(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOs){
		if(searchNewLaneSecCmcbListVOs != null){
			this.searchNewLaneSecCmcbListVOs = new SearchNewLaneSecCmcbListVO[searchNewLaneSecCmcbListVOs.length];
			for(int i=0; i<searchNewLaneSecCmcbListVOs.length; ++i){
				this.searchNewLaneSecCmcbListVOs[i] = searchNewLaneSecCmcbListVOs[i];
			}
		}
	}

	public SearchNewLaneSecCmcbListVO getSearchNewLaneSecCmcbListVO(){
		return searchNewLaneSecCmcbListVO;
	}

	public SearchNewLaneSecCmcbListVO[] getSearchNewLaneSecCmcbListVOS(){
		SearchNewLaneSecCmcbListVO[] ret = null;
		if(this.searchNewLaneSecCmcbListVOs != null){
			ret = new SearchNewLaneSecCmcbListVO[searchNewLaneSecCmcbListVOs.length];
			for(int i=0; i<searchNewLaneSecCmcbListVOs.length; i++){
				ret[i] = this.searchNewLaneSecCmcbListVOs[i];
			}
		}
		return ret;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}