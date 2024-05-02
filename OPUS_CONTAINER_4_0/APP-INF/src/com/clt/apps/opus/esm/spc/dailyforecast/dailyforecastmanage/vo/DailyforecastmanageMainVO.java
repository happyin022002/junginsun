/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyforecastmanageMainVO.java
*@FileTitle : DailyforecastmanageMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.24 한상훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class  DailyforecastmanageMainVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;
	
	private String eventCommand = null;
	
	//private DBRowSet rs = null;	
	private DBRowSet rs = new DBRowSet();
	
	private List<DBRowSet> rsList = null;
	
	private DailyforecastmanageConditionVO condition = null;
	
	private SearchDailyForecastSrepAccountManageListVO vo = null;
	
	private List<SearchDailyForecastSrepAccountManageListVO> voList = null;
	
	
	private SearchDailyForecastHistoryOfcListVO historyOfc = null;
	private List<SearchDailyForecastHistoryOfcListVO> historyOfcList = null;
	
	private SearchDailyForecastHistorySrepAcctListVO serpAcct = null;
	private List<SearchDailyForecastHistorySrepAcctListVO> serpAcctList = null;
	
	public DailyforecastmanageMainVO() {}
	
	
	public String getEventCommand() {
		return eventCommand;
	}


	public void setEventCommand(String eventCommand) {
		this.eventCommand = eventCommand;
	}


	public DBRowSet getRs() {
		return rs;
	}


	public void setRs(DBRowSet rs) {
		this.rs = rs;
	}


	public DailyforecastmanageConditionVO getCondition() {
		return condition;
	}


	public void setCondition(DailyforecastmanageConditionVO condition) {
		this.condition = condition;
	}


	
	public List<DBRowSet> getRsList() {
		return rsList;
	}


	public void setRsList(List<DBRowSet> rsList) {
		this.rsList = rsList;
	}

	
	public SearchDailyForecastSrepAccountManageListVO getVo() {
		return vo;
	}


	public void setVo(SearchDailyForecastSrepAccountManageListVO vo) {
		this.vo = vo;
	}


	public List<SearchDailyForecastSrepAccountManageListVO> getVoList() {
		return voList;
	}


	public void setVoList(List<SearchDailyForecastSrepAccountManageListVO> voList) {
		this.voList = voList;
	}


	public SearchDailyForecastHistoryOfcListVO getHistoryOfc() {
		return historyOfc;
	}


	public void setHistoryOfc(SearchDailyForecastHistoryOfcListVO historyOfc) {
		this.historyOfc = historyOfc;
	}


	public List<SearchDailyForecastHistoryOfcListVO> getHistoryOfcList() {
		return historyOfcList;
	}


	public void setHistoryOfcList(
			List<SearchDailyForecastHistoryOfcListVO> historyOfcList) {
		this.historyOfcList = historyOfcList;
	}


	public SearchDailyForecastHistorySrepAcctListVO getSerpAcct() {
		return serpAcct;
	}


	public void setSerpAcct(SearchDailyForecastHistorySrepAcctListVO serpAcct) {
		this.serpAcct = serpAcct;
	}


	public List<SearchDailyForecastHistorySrepAcctListVO> getSerpAcctList() {
		return serpAcctList;
	}


	public void setSerpAcctList(
			List<SearchDailyForecastHistorySrepAcctListVO> serpAcctList) {
		this.serpAcctList = serpAcctList;
	}


	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
