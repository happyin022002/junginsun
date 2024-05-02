/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0141Event.java
*@FileTitle : Link별 표준단가 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.01 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0141HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0141Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLinkCostListByPRDVO searchLinkCostListByPRDVO = null;	
	

	public EsmCoa0141Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchLinkCostListByPRDVO(SearchLinkCostListByPRDVO searchLinkCostListByPRDVO){
		this. searchLinkCostListByPRDVO = searchLinkCostListByPRDVO;
	}	

	public SearchLinkCostListByPRDVO getSearchLinkCostListByPRDVO(){
		return searchLinkCostListByPRDVO;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}	

}