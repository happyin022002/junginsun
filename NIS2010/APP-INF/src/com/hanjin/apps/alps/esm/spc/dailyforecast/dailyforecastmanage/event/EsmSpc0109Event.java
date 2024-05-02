/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0109Event.java
*@FileTitle : Daily Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchContractForecastManageListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcCtrtFcastCustVO;


/**
 * ESM_SPC_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchContractForecastManageListVO searchContractForecastManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchContractForecastManageListVO[] searchContractForecastManageListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcCtrtFcastCustVO spcCtrtFcastCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcCtrtFcastCustVO[] spcCtrtFcastCustVOs = null;

	public EsmSpc0109Event(){}
	
	public void setSearchDailyForecastManageListVO(SearchContractForecastManageListVO searchContractForecastManageListVO){
		this. searchContractForecastManageListVO = searchContractForecastManageListVO;
	}

	public void setSearchDailyForecastManageListVOS(SearchContractForecastManageListVO[] searchContractForecastManageListVOs){
		if (searchContractForecastManageListVOs != null) {
			SearchContractForecastManageListVO[] tmpVOs = new SearchContractForecastManageListVO[searchContractForecastManageListVOs.length];
			System.arraycopy(searchContractForecastManageListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchContractForecastManageListVOs = tmpVOs;
		}
	}

	public void setSpcCtrtFcastCustVO(SpcCtrtFcastCustVO spcCtrtFcastCustVO){
		this. spcCtrtFcastCustVO = spcCtrtFcastCustVO;
	}

	public void setSpcCtrtFcastCustVOS(SpcCtrtFcastCustVO[] spcCtrtFcastCustVOs){
		if (spcCtrtFcastCustVOs != null) {
			SpcCtrtFcastCustVO[] tmpVOs = new SpcCtrtFcastCustVO[spcCtrtFcastCustVOs.length];
			System.arraycopy(spcCtrtFcastCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcCtrtFcastCustVOs = tmpVOs;
		}
	}

	public SearchContractForecastManageListVO getSearchContractForecastManageListVO(){
		return searchContractForecastManageListVO;
	}

	public SearchContractForecastManageListVO[] getSearchContractForecastManageListVOS(){
		SearchContractForecastManageListVO[] rtnVOs = null;
		if (this.searchContractForecastManageListVOs != null) {
			rtnVOs = new SearchContractForecastManageListVO[searchContractForecastManageListVOs.length];
			System.arraycopy(searchContractForecastManageListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public SpcCtrtFcastCustVO getSpcCtrtFcastCustVO(){
		return spcCtrtFcastCustVO;
	}

	public SpcCtrtFcastCustVO[] getSpcCtrtFcastCustVOS(){
		SpcCtrtFcastCustVO[] rtnVOs = null;
		if (this.spcCtrtFcastCustVOs != null) {
			rtnVOs = new SpcCtrtFcastCustVO[spcCtrtFcastCustVOs.length];
			System.arraycopy(spcCtrtFcastCustVOs, 0, rtnVOs, 0, rtnVOs.length);
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