/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0081Event.java
*@FileTitle : Logistics Exp. by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* =======================================================
* History
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.event;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00812ListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi In Kyung
 * @see ESM_MAS_0080HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0081Event extends EventSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	private SearchLogisticsRPT0081ListVO searchLogisticsRPT0081ListVO = null;	
	private SearchLogisticsRPT00812ListVO searchLogisticsRPT00812ListVO = null;	
	private SearchLgstConditionVO searchLgstConditionVO = null;
	
	private SearchLogisticsRPT0081ListVO[] searchLogisticsRPT0081ListVOs = null;
	private SearchLogisticsRPT00812ListVO[] searchLogisticsRPT00812ListVOs = null;
	
	

	public SearchLgstConditionVO getSearchLgstConditionVO() {
		return searchLgstConditionVO;
	}

	public void setSearchLgstConditionVO(SearchLgstConditionVO searchLgstConditionVO) {
		this.searchLgstConditionVO = searchLgstConditionVO;
	}

	public SearchLogisticsRPT0081ListVO getSearchLogisticsRPT0081ListVO() {
		return searchLogisticsRPT0081ListVO;
	}

	public void setSearchLogisticsRPT0081ListVO(
			SearchLogisticsRPT0081ListVO searchLogisticsRPT0081ListVO) {
		this.searchLogisticsRPT0081ListVO = searchLogisticsRPT0081ListVO;
	}

	public SearchLogisticsRPT00812ListVO getSearchLogisticsRPT00812ListVO() {
		return searchLogisticsRPT00812ListVO;
	}

	public void setSearchLogisticsRPT00812ListVO(
			SearchLogisticsRPT00812ListVO searchLogisticsRPT00812ListVO) {
		this.searchLogisticsRPT00812ListVO = searchLogisticsRPT00812ListVO;
	}

	public SearchLogisticsRPT0081ListVO[] getSearchLogisticsRPT0081ListVOs() {
		return searchLogisticsRPT0081ListVOs;
	}

	public void setSearchLogisticsRPT0081ListVOs(
			SearchLogisticsRPT0081ListVO[] searchLogisticsRPT0081ListVOs) {
		this.searchLogisticsRPT0081ListVOs = searchLogisticsRPT0081ListVOs;
	}

	public SearchLogisticsRPT00812ListVO[] getSearchLogisticsRPT00812ListVOs() {
		return searchLogisticsRPT00812ListVOs;
	}

	public void setSearchLogisticsRPT00812ListVOs(
			SearchLogisticsRPT00812ListVO[] searchLogisticsRPT00812ListVOs) {
		this.searchLogisticsRPT00812ListVOs = searchLogisticsRPT00812ListVOs;
	}
}