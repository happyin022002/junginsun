/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0141Event.java
*@FileTitle : Link별 표준단가 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.01 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;


/**
 * ESM_MAS_0141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0141HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0141Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLinkCostListByPRDVO searchLinkCostListByPRDVO = null;	
	

	public EsmMas0141Event(){}
	
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