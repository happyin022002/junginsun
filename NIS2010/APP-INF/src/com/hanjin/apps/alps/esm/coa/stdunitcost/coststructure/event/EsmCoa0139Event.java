/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsmCoa0139Event.java
*@FileTitle : Feeder Term
*Open Issues :
*@LastModifyDate : 2009-07-24
*@LastModifier : 장영석
*@LastVersion : 1.3
* 2007-05-22 Lee Ho Ik
* 1.0 최초 생성
*Change history :
* 2009.07.24 장영석 New Framework 적용
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaTrnsFdrTermVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;

/**
 * ESM_COA_0139 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0139HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0139HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0139Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaTrnsFdrTermVO coaTrnsFdrTermVO = null;
	
	private SearchConditionVO searchConditionVO = null;
	/** Table Value Object Multi Data 처리 */
	private CoaTrnsFdrTermVO[] coaTrnsFdrTermVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostStructure0139ListVO searchCostStructure0139ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCostStructure0139ListVO[] searchCostStructure0139ListVOs = null;

	public EsmCoa0139Event(){}
	
	public void setCoaTrnsFdrTermVO(CoaTrnsFdrTermVO coaTrnsFdrTermVO){
		this. coaTrnsFdrTermVO = coaTrnsFdrTermVO;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}           
	
	
	public void setCoaTrnsFdrTermVOS(CoaTrnsFdrTermVO[] coaTrnsFdrTermVOs){
		this. coaTrnsFdrTermVOs = coaTrnsFdrTermVOs;
	}

	public void setSearchCostStructure0139ListVO(SearchCostStructure0139ListVO searchCostStructure0139ListVO){
		this. searchCostStructure0139ListVO = searchCostStructure0139ListVO;
	}

	public void setSearchCostStructure0139ListVOS(SearchCostStructure0139ListVO[] searchCostStructure0139ListVOs){
		this. searchCostStructure0139ListVOs = searchCostStructure0139ListVOs;
	}

	public CoaTrnsFdrTermVO getCoaTrnsFdrTermVO(){
		return coaTrnsFdrTermVO;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	public CoaTrnsFdrTermVO[] getCoaTrnsFdrTermVOS(){
		return coaTrnsFdrTermVOs;
	}

	public SearchCostStructure0139ListVO getSearchCostStructure0139ListVO(){
		return searchCostStructure0139ListVO;
	}

	public SearchCostStructure0139ListVO[] getSearchCostStructure0139ListVOS(){
		return searchCostStructure0139ListVOs;
	}

}