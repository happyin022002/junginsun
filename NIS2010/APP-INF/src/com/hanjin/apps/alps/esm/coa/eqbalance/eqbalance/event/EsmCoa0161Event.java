/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0161Event.java
*@FileTitle : To(DEL) RCC For EQ Repo. Contribution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 박수훈
*@LastVersion : 1.1
* 2008.09.01 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
* 2009.10.06 박수훈 Alps New Framework 적용[0161]
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaCntrRepoRoutEccVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0161ListVO;


/**
 * ESM_COA_0161 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0161HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0161HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0161Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaCntrRepoRoutEccVO coaCntrRepoRoutEccVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEQBalance0161ListVO searchEQBalance0161ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEQBalance0161ListVO[] searchEQBalance0161ListVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0161Event(){}
	
	public void setCoaCntrRepoRoutEccVO(CoaCntrRepoRoutEccVO coaCntrRepoRoutEccVO){
		this. coaCntrRepoRoutEccVO = coaCntrRepoRoutEccVO;
	}

	public void setCoaCntrRepoRoutEccVOS(CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVOs){
		this. coaCntrRepoRoutEccVOs = coaCntrRepoRoutEccVOs;
	}

	public void setSearchEQBalance0161ListVO(SearchEQBalance0161ListVO searchEQBalance0161ListVO){
		this. searchEQBalance0161ListVO = searchEQBalance0161ListVO;
	}

	public void setSearchEQBalance0161ListVOS(SearchEQBalance0161ListVO[] searchEQBalance0161ListVOs){
		this. searchEQBalance0161ListVOs = searchEQBalance0161ListVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public CoaCntrRepoRoutEccVO getCoaCntrRepoRoutEccVO(){
		return coaCntrRepoRoutEccVO;
	}

	public CoaCntrRepoRoutEccVO[] getCoaCntrRepoRoutEccVOS(){
		return coaCntrRepoRoutEccVOs;
	}

	public SearchEQBalance0161ListVO getSearchEQBalance0161ListVO(){
		return searchEQBalance0161ListVO;
	}

	public SearchEQBalance0161ListVO[] getSearchEQBalance0161ListVOS(){
		return searchEQBalance0161ListVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}