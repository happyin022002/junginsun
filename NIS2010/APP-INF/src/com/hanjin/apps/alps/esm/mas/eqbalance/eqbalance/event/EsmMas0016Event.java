/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas00016Event.java
*@FileTitle : EQ repo 회송 기여도 Credit setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.08.13 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.syscommon.common.table.MasCntrRepoRuleVO;
import com.hanjin.syscommon.common.table.MasCntrRepoShtgInfoVO;


/**
 * ESM_MAS_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasCntrRepoRuleVO[] masCntrRepoRuleVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasCntrRepoShtgInfoVO masCntrRepoShtgInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasCntrRepoShtgInfoVO[] masCntrRepoShtgInfoVOs = null;

	public EsmMas0016Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public void setMasCntrRepoRuleVOS(MasCntrRepoRuleVO[] masCntrRepoRuleVOs){
		this. masCntrRepoRuleVOs = masCntrRepoRuleVOs;
	}

	public void setMasCntrRepoShtgInfoVO(MasCntrRepoShtgInfoVO masCntrRepoShtgInfoVO){
		this. masCntrRepoShtgInfoVO = masCntrRepoShtgInfoVO;
	}

	public void setMasCntrRepoShtgInfoVOS(MasCntrRepoShtgInfoVO[] masCntrRepoShtgInfoVOs){
		this. masCntrRepoShtgInfoVOs = masCntrRepoShtgInfoVOs;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public MasCntrRepoRuleVO[] getMasCntrRepoRuleVOS(){
		return masCntrRepoRuleVOs;
	}

	public MasCntrRepoShtgInfoVO getMasCntrRepoShtgInfoVO(){
		return masCntrRepoShtgInfoVO;
	}

	public MasCntrRepoShtgInfoVO[] getMasCntrRepoShtgInfoVOS(){
		return masCntrRepoShtgInfoVOs;
	}

}