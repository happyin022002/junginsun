/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0008Event.java
*@FileTitle : Route Cost (PA/RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.12.04  임옥영  최초 생성
* 2009.08.05  박수훈  New Framework 적용[0008]
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLinkCostListVO searchLinkCostListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchLinkCostListVO[] searchLinkCostListVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0008Event(){}
	
	public void setSearchLinkCostListVO(SearchLinkCostListVO searchLinkCostListVO){
		this. searchLinkCostListVO = searchLinkCostListVO;
	}
	//SJH.20150508.소스품질S
	public void setSearchLinkCostListVOS(SearchLinkCostListVO[] searchLinkCostListVOs){
		if(searchLinkCostListVOs != null){
			SearchLinkCostListVO[] tmpVOs = Arrays.copyOf(searchLinkCostListVOs, searchLinkCostListVOs.length);
			this.searchLinkCostListVOs = tmpVOs;
		}
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public SearchLinkCostListVO getSearchLinkCostListVO(){
		return searchLinkCostListVO;
	}
	//SJH.20150508.소스품질
	public SearchLinkCostListVO[] getSearchLinkCostListVOS(){
		SearchLinkCostListVO[] rtnVOs = null;
		if (this.searchLinkCostListVOs != null) {
			rtnVOs = Arrays.copyOf(searchLinkCostListVOs, searchLinkCostListVOs.length);
		}
		return rtnVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}