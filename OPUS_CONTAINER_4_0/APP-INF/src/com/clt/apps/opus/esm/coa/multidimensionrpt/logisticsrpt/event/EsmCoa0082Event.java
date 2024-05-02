/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0082Event.java
*@FileTitle : Logistics Exp. by Node & Link
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 최인경
*@LastVersion : 1.0
* 2009.08.04 최인경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event;

import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_COA_0082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi In Kyung
 * @see ESM_COA_0082HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0082Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLogisticsRPT0082ListVO searchLogisticsRPT0082ListVO = null;	
	
	private SearchLgstConditionVO searchLgstConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchLogisticsRPT0082ListVO[] searchLogisticsRPT0082ListVOs = null;

	public SearchLogisticsRPT0082ListVO getSearchLogisticsRPT0082ListVO() {
		return searchLogisticsRPT0082ListVO;
	}

	public void setSearchLogisticsRPT0082ListVO(
			SearchLogisticsRPT0082ListVO searchLogisticsRPT0082ListVO) {
		this.searchLogisticsRPT0082ListVO = searchLogisticsRPT0082ListVO;
	}

	public SearchLgstConditionVO getSearchLgstConditionVO() {
		return searchLgstConditionVO;
	}

	public void setSearchLgstConditionVO(SearchLgstConditionVO searchLgstConditionVO) {
		this.searchLgstConditionVO = searchLgstConditionVO;
	}
	
	//SJH.20150507.소스품질
	public SearchLogisticsRPT0082ListVO[] getSearchLogisticsRPT0082ListVOs() {
		SearchLogisticsRPT0082ListVO[] rtnVOs = null;
		if (this.searchLogisticsRPT0082ListVOs != null) {
			rtnVOs = Arrays.copyOf(searchLogisticsRPT0082ListVOs, searchLogisticsRPT0082ListVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSearchLogisticsRPT0082ListVOs(SearchLogisticsRPT0082ListVO[] searchLogisticsRPT0082ListVOs){
		if(searchLogisticsRPT0082ListVOs != null){
			SearchLogisticsRPT0082ListVO[] tmpVOs = Arrays.copyOf(searchLogisticsRPT0082ListVOs, searchLogisticsRPT0082ListVOs.length);
			this.searchLogisticsRPT0082ListVOs = tmpVOs;
		}
	}
}