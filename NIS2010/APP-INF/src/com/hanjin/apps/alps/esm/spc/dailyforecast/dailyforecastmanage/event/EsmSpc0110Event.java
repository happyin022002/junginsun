/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0110Event.java
*@FileTitle : Daily Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.10
*@LastModifier : 전상화
*@LastVersion : 1.0
* 2012.09.10 전상화
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDailyForecastHistorySrepAcctListVO searchDailyForecastHistorySrepAcctListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchDailyForecastHistorySrepAcctListVO[] searchDailyForecastHistorySrepAcctListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDailyForecastManageListVO searchDailyForecastManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchDailyForecastManageListVO[] searchDailyForecastManageListVOs = null;

	public EsmSpc0110Event(){}
	
	public void setSearchDailyForecastHistorySrepAcctListVO(SearchDailyForecastHistorySrepAcctListVO searchDailyForecastHistorySrepAcctListVO){
		this. searchDailyForecastHistorySrepAcctListVO = searchDailyForecastHistorySrepAcctListVO;
	}

	public void setSearchDailyForecastHistorySrepAcctListVOS(SearchDailyForecastHistorySrepAcctListVO[] searchDailyForecastHistorySrepAcctListVOs){
		if (searchDailyForecastHistorySrepAcctListVOs != null) {
			SearchDailyForecastHistorySrepAcctListVO[] tmpVOs = new SearchDailyForecastHistorySrepAcctListVO[searchDailyForecastHistorySrepAcctListVOs.length];
			System.arraycopy(searchDailyForecastHistorySrepAcctListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchDailyForecastHistorySrepAcctListVOs = tmpVOs;
		}
	}

	public SearchDailyForecastHistorySrepAcctListVO getSearchDailyForecastHistorySrepAcctListVO(){
		return searchDailyForecastHistorySrepAcctListVO;
	}

	public SearchDailyForecastHistorySrepAcctListVO[] getSearchDailyForecastHistorySrepAcctListVOS(){
		SearchDailyForecastHistorySrepAcctListVO[] rtnVOs = null;
		if (this.searchDailyForecastHistorySrepAcctListVOs != null) {
			rtnVOs = new SearchDailyForecastHistorySrepAcctListVO[searchDailyForecastHistorySrepAcctListVOs.length];
			System.arraycopy(searchDailyForecastHistorySrepAcctListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	
	public void setSearchDailyForecastManageListVO(SearchDailyForecastManageListVO searchDailyForecastManageListVO){
		this. searchDailyForecastManageListVO = searchDailyForecastManageListVO;
	}
	
	public void setSearchDailyForecastManageListVOS(SearchDailyForecastManageListVO[] searchDailyForecastManageListVOs){
		if (searchDailyForecastManageListVOs != null) {
			SearchDailyForecastManageListVO[] tmpVOs = new SearchDailyForecastManageListVO[searchDailyForecastManageListVOs.length];
			System.arraycopy(searchDailyForecastManageListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchDailyForecastManageListVOs = tmpVOs;
		}
	}
	
	public SearchDailyForecastManageListVO getSearchDailyForecastManageListVO(){
		return searchDailyForecastManageListVO;
	}
	
	public SearchDailyForecastManageListVO[] getSearchDailyForecastManageListVOS(){
		SearchDailyForecastManageListVO[] rtnVOs = null;
		if (this.searchDailyForecastManageListVOs != null) {
			rtnVOs = new SearchDailyForecastManageListVO[searchDailyForecastManageListVOs.length];
			System.arraycopy(searchDailyForecastManageListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}