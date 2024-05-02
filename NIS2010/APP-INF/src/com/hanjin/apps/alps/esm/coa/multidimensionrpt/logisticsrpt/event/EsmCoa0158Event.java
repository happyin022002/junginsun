/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0158Event.java
*@FileTitle : Logistics Vol. by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : Choi In Kyung
*@LastVersion : 1.0
* 2009.10.26 Choi In Kyung
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.event;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_COA_0158 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_COA_0158HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi In Kyung
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0158Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLogisticsRPT0158ListVO searchLogisticsRPT0158ListVO = null;	
	
	private SearchLgstConditionVO searchLgstConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchLogisticsRPT0158ListVO[] searchLogisticsRPT0158ListVOs = null;

	public SearchLgstConditionVO getSearchLgstConditionVO() {
		return searchLgstConditionVO;
	}

	public void setSearchLgstConditionVO(SearchLgstConditionVO searchLgstConditionVO) {
		this.searchLgstConditionVO = searchLgstConditionVO;
	}

	public SearchLogisticsRPT0158ListVO getSearchLogisticsRPT0158ListVO() {
		return searchLogisticsRPT0158ListVO;
	}

	public void setSearchLogisticsRPT0158ListVO(
			SearchLogisticsRPT0158ListVO searchLogisticsRPT0158ListVO) {
		this.searchLogisticsRPT0158ListVO = searchLogisticsRPT0158ListVO;
	}

	public SearchLogisticsRPT0158ListVO[] getSearchLogisticsRPT0158ListVOs() {
		return searchLogisticsRPT0158ListVOs;
	}

	public void setSearchLogisticsRPT0158ListVOs(
			SearchLogisticsRPT0158ListVO[] searchLogisticsRPT0158ListVOs) {
		this.searchLogisticsRPT0158ListVOs = searchLogisticsRPT0158ListVOs;
	}

	
}