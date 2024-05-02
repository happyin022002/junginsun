/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0080Event.java
*@FileTitle : Logistics Exp. by Lane
*Open Issues :
*Change history :
* 2009.08.04 최인경 1.0 Creation
*@LastModifyDate : 2009.10.08
*@LastModifier : 최인경
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event;

import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO2;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_COA_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi In Kyung
 * @see ESM_COA_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0080Event extends EventSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLogisticsRPT0080ListVO searchLogisticsRPT0080ListVO = null;	
	private SearchLogisticsRPT0080ListVO2 searchLogisticsRPT0080ListVO2 = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private SearchLogisticsRPT0080ListVO[] searchLogisticsRPT0080ListVOs = null;
	private SearchLogisticsRPT0080ListVO2[] searchLogisticsRPT0080ListVO2s = null;
	
	private SearchLgstConditionVO searchLgstConditionVO = null;
	
	public EsmCoa0080Event(){}

	public void setSearchLogisticsRPT0080ListVO(SearchLogisticsRPT0080ListVO searchLogisticsRPT0080ListVO){
		this. searchLogisticsRPT0080ListVO = searchLogisticsRPT0080ListVO;
	}
	
	//SJH.20150507.소스품질
	public void setSearchLogisticsRPT0080ListVOs(SearchLogisticsRPT0080ListVO[] searchLogisticsRPT0080ListVOs){
		if(searchLogisticsRPT0080ListVOs != null){
			SearchLogisticsRPT0080ListVO[] tmpVOs = Arrays.copyOf(searchLogisticsRPT0080ListVOs, searchLogisticsRPT0080ListVOs.length);
			this.searchLogisticsRPT0080ListVOs = tmpVOs;
		}
	}

	public void setSearchLogisticsRPT0080ListVO2(SearchLogisticsRPT0080ListVO2 searchLogisticsRPT0080ListVO2){
		this. searchLogisticsRPT0080ListVO2 = searchLogisticsRPT0080ListVO2;
	}
	
	//SJH.20150507.소스품질
	public void setSearchLogisticsRPT0080ListVO2s(SearchLogisticsRPT0080ListVO2[] searchLogisticsRPT0080ListVO2s){
		if(searchLogisticsRPT0080ListVO2s != null){
			SearchLogisticsRPT0080ListVO2[] tmpVOs = Arrays.copyOf(searchLogisticsRPT0080ListVO2s, searchLogisticsRPT0080ListVO2s.length);
			this.searchLogisticsRPT0080ListVO2s = tmpVOs;
		}
	}
	
	public void setSearchLgstConditionVO(
			SearchLgstConditionVO searchLgstConditionVO) {
		this.searchLgstConditionVO = searchLgstConditionVO;
	}	

	public SearchLogisticsRPT0080ListVO getSearchLogisticsRPT0080ListVO(){
		return searchLogisticsRPT0080ListVO;
	}
	
	//SJH.20150507.소스품질
	public SearchLogisticsRPT0080ListVO[] getSearchLogisticsRPT0080ListVOs(){
		SearchLogisticsRPT0080ListVO[] rtnVOs = null;
		if (this.searchLogisticsRPT0080ListVOs != null) {
			rtnVOs = Arrays.copyOf(searchLogisticsRPT0080ListVOs, searchLogisticsRPT0080ListVOs.length);
		}
		return rtnVOs;
	}

	public SearchLogisticsRPT0080ListVO2 getSearchLogisticsRPT0080ListVO2(){
		return searchLogisticsRPT0080ListVO2;
	}
	
	//SJH.20150507.소스품질
	public SearchLogisticsRPT0080ListVO2[] getSearchLogisticsRPT0080ListVO2s(){
		SearchLogisticsRPT0080ListVO2[] rtnVOs = null;
		if (this.searchLogisticsRPT0080ListVO2s != null) {
			rtnVOs = Arrays.copyOf(searchLogisticsRPT0080ListVO2s, searchLogisticsRPT0080ListVO2s.length);
		}
		return rtnVOs;
	}
	
	public SearchLgstConditionVO getSearchLgstConditionVO() {
		return searchLgstConditionVO;
	}

}