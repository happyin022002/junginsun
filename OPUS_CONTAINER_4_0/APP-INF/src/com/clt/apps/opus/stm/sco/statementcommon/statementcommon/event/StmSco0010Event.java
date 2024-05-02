/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSco0010Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SearchPeriodClosingInfoVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0010Event 참조
 * @since J2EE 1.4
 */

public class StmSco0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private SearchPeriodClosingInfoVO[] searchPeriodClosingInfoVOs = null;
	
	private String effYrMon = "";
	private String prdApplCd = "";


	public String getEffYrMon() {
		return effYrMon;
	}
	public void setEffYrMon(String effYrMon) {
		this.effYrMon = effYrMon;
	}
	public String getPrdApplCd() {
		return prdApplCd;
	}
	public void setPrdApplCd(String prdApplCd) {
		this.prdApplCd = prdApplCd;
	}
	
	public SearchPeriodClosingInfoVO[] getSearchPeriodClosingInfoVOs() {		
		SearchPeriodClosingInfoVO[] rtnVOs = null;
		if (this.searchPeriodClosingInfoVOs != null) {
			rtnVOs = new SearchPeriodClosingInfoVO[searchPeriodClosingInfoVOs.length];
			System.arraycopy(searchPeriodClosingInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchPeriodClosingInfoVOs(SearchPeriodClosingInfoVO[] searchPeriodClosingInfoVOs) {
		if (searchPeriodClosingInfoVOs != null) {
			SearchPeriodClosingInfoVO[] tmpVOs = new SearchPeriodClosingInfoVO[searchPeriodClosingInfoVOs.length];
			System.arraycopy(searchPeriodClosingInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchPeriodClosingInfoVOs = tmpVOs;
		}
	}

}