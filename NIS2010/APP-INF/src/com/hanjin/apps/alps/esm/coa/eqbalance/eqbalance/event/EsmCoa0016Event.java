/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa00016Event.java
*@FileTitle : EQ repo 회송 기여도 Credit setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.08.13 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoRuleVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoShtgInfoVO;


/**
 * ESM_COA_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaCntrRepoRuleVO[] coaCntrRepoRuleVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaCntrRepoShtgInfoVO coaCntrRepoShtgInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaCntrRepoShtgInfoVO[] coaCntrRepoShtgInfoVOs = null;

	public EsmCoa0016Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public void setCoaCntrRepoRuleVOS(CoaCntrRepoRuleVO[] coaCntrRepoRuleVOs){
		this. coaCntrRepoRuleVOs = coaCntrRepoRuleVOs;
	}

	public void setCoaCntrRepoShtgInfoVO(CoaCntrRepoShtgInfoVO coaCntrRepoShtgInfoVO){
		this. coaCntrRepoShtgInfoVO = coaCntrRepoShtgInfoVO;
	}

	public void setCoaCntrRepoShtgInfoVOS(CoaCntrRepoShtgInfoVO[] coaCntrRepoShtgInfoVOs){
		this. coaCntrRepoShtgInfoVOs = coaCntrRepoShtgInfoVOs;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public CoaCntrRepoRuleVO[] getCoaCntrRepoRuleVOS(){
		return coaCntrRepoRuleVOs;
	}

	public CoaCntrRepoShtgInfoVO getCoaCntrRepoShtgInfoVO(){
		return coaCntrRepoShtgInfoVO;
	}

	public CoaCntrRepoShtgInfoVO[] getCoaCntrRepoShtgInfoVOS(){
		return coaCntrRepoShtgInfoVOs;
	}

}