/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0080Event.java
*@FileTitle : Logistics Exp. by Lane
*Open Issues :
*Change history :
* 2009.08.04 최인경 1.0 Creation
*@LastModifyDate : 2009.10.08
*@LastModifier : 최인경
*@LastVersion : 1.0
* =======================================================
* History
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00802ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;

/**
 * ESM_MAS_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi In Kyung
 * @see ESM_MAS_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0080Event extends EventSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLogisticsRPT0080ListVO searchLogisticsRPT0080ListVO = null;	
	private SearchLogisticsRPT00802ListVO searchLogisticsRPT00802ListVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private SearchLogisticsRPT0080ListVO[] searchLogisticsRPT0080ListVOs = null;
	private SearchLogisticsRPT00802ListVO[] searchLogisticsRPT00802ListVOs = null;
	
	private SearchLgstConditionVO searchLgstConditionVO = null;
	
	public EsmMas0080Event(){}

	public void setSearchLogisticsRPT0080ListVO(SearchLogisticsRPT0080ListVO searchLogisticsRPT0080ListVO){
		this. searchLogisticsRPT0080ListVO = searchLogisticsRPT0080ListVO;
	}
	
	public void setSearchLogisticsRPT0080ListVOs(SearchLogisticsRPT0080ListVO[] searchLogisticsRPT0080ListVOs){
		this. searchLogisticsRPT0080ListVOs = searchLogisticsRPT0080ListVOs;
	}

	public void setSearchLogisticsRPT00802ListVO(SearchLogisticsRPT00802ListVO searchLogisticsRPT00802ListVO){
		this. searchLogisticsRPT00802ListVO = searchLogisticsRPT00802ListVO;
	}
	
	public void setSearchLogisticsRPT00802ListVOs(SearchLogisticsRPT00802ListVO[] searchLogisticsRPT00802ListVOs){
		this. searchLogisticsRPT00802ListVOs = searchLogisticsRPT00802ListVOs;
	}
	
	public void setSearchLgstConditionVO(
			SearchLgstConditionVO searchLgstConditionVO) {
		this.searchLgstConditionVO = searchLgstConditionVO;
	}	

	public SearchLogisticsRPT0080ListVO getSearchLogisticsRPT0080ListVO(){
		return searchLogisticsRPT0080ListVO;
	}
	
	public SearchLogisticsRPT0080ListVO[] getSearchLogisticsRPT0080ListVOs(){
		return searchLogisticsRPT0080ListVOs;
	}

	public SearchLogisticsRPT00802ListVO getSearchLogisticsRPT00802ListVO(){
		return searchLogisticsRPT00802ListVO;
	}
	
	public SearchLogisticsRPT00802ListVO[] getSearchLogisticsRPT00802ListVOs(){
		return searchLogisticsRPT00802ListVOs;
	}
	
	public SearchLgstConditionVO getSearchLgstConditionVO() {
		return searchLgstConditionVO;
	}

}