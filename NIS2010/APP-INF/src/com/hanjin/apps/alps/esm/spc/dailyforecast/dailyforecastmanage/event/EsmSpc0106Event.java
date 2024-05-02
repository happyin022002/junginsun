/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0106Event.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchSalesRepInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcSlsRepCustVO;


/**
 * ESM_SPC_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSalesRepInfoVO searchSalesRepInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSalesRepInfoVO[] searchSalesRepInfoVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcSlsRepCustVO spcSlsRepCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcSlsRepCustVO[] spcSlsRepCustVOs = null;

	public EsmSpc0106Event(){}
	
	public void setSearchSalesRepInfoVO(SearchSalesRepInfoVO searchSalesRepInfoVO){
		this. searchSalesRepInfoVO = searchSalesRepInfoVO;
	}

	public void setSearchSalesRepInfoVOS(SearchSalesRepInfoVO[] searchSalesRepInfoVOs){
		if (searchSalesRepInfoVOs != null) {
			SearchSalesRepInfoVO[] tmpVOs = new SearchSalesRepInfoVO[searchSalesRepInfoVOs.length];
			System.arraycopy(searchSalesRepInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSalesRepInfoVOs = tmpVOs;
		}
	}

	public void setSpcSlsRepCustVO(SpcSlsRepCustVO spcSlsRepCustMapgVO){
		this. spcSlsRepCustVO = spcSlsRepCustMapgVO;
	}

	public void setSpcSlsRepCustVOS(SpcSlsRepCustVO[] spcSlsRepCustVOs){
		if (spcSlsRepCustVOs != null) {
			SpcSlsRepCustVO[] tmpVOs = new SpcSlsRepCustVO[spcSlsRepCustVOs.length];
			System.arraycopy(spcSlsRepCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcSlsRepCustVOs = tmpVOs;
		}
	}

	public SearchSalesRepInfoVO getSearchSalesRepInfoVO(){
		return searchSalesRepInfoVO;
	}

	public SearchSalesRepInfoVO[] getSearchSalesRepInfoVOS(){
		SearchSalesRepInfoVO[] rtnVOs = null;
		if (this.searchSalesRepInfoVOs != null) {
			rtnVOs = new SearchSalesRepInfoVO[searchSalesRepInfoVOs.length];
			System.arraycopy(searchSalesRepInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public SpcSlsRepCustVO getSpcSlsRepCustVO(){
		return spcSlsRepCustVO;
	}

	public SpcSlsRepCustVO[] getSpcSlsRepCustVOS(){
		SpcSlsRepCustVO[] rtnVOs = null;
		if (this.spcSlsRepCustVOs != null) {
			rtnVOs = new SpcSlsRepCustVO[spcSlsRepCustVOs.length];
			System.arraycopy(spcSlsRepCustVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}