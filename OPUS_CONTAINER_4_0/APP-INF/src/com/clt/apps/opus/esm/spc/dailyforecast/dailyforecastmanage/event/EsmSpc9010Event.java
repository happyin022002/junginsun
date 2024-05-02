/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : EsmSpc9010Event.java
 *@FileTitle      : Daily Forecast Input
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2014.07.17
 *@LastModifier   : PCH
 *@LastVersion    : 1.0
 * 2009.08.27
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpcDlyFcastCustVO;

/**
 * ESM_SPC_9010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SPC_9010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CHOI Yun Sung
 * @see ESM_SPC_9010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc9010Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private SearchDailyForecastManageListVO searchDailyForecastManageListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchDailyForecastManageListVO[] searchDailyForecastManageListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private DlyFctInpListVO dlyFctInpListVO = null;

	/** Table Value Object Multi Data 처리 */
	private DlyFctInpListVO[] dlyFctInpListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private SpcDlyFcastCustVO spcDlyFcastCustVO = null;

	/** Table Value Object Multi Data 처리 */
	private SpcDlyFcastCustVO[] spcDlyFcastCustVOs = null;

	public EsmSpc9010Event() {
	}

	public void setSearchDailyForecastManageListVO(SearchDailyForecastManageListVO searchDailyForecastManageListVO) {
		this.searchDailyForecastManageListVO = searchDailyForecastManageListVO;
	}

	public void setSearchDailyForecastManageListVOS(SearchDailyForecastManageListVO[] searchDailyForecastManageListVOs) {
		if(searchDailyForecastManageListVOs != null){
			SearchDailyForecastManageListVO[] tmpVOs = Arrays.copyOf(searchDailyForecastManageListVOs, searchDailyForecastManageListVOs.length);
			this.searchDailyForecastManageListVOs  = tmpVOs;
		}
	}

	public void setSpcDlyFcastCustVO(SpcDlyFcastCustVO spcDlyFcastCustVO) {
		this.spcDlyFcastCustVO = spcDlyFcastCustVO;
	}

	public void setSpcDlyFcastCustVOS(SpcDlyFcastCustVO[] spcDlyFcastCustVOs) {
		if(spcDlyFcastCustVOs != null){
			SpcDlyFcastCustVO[] tmpVOs = Arrays.copyOf(spcDlyFcastCustVOs, spcDlyFcastCustVOs.length);
			this.spcDlyFcastCustVOs  = tmpVOs;
		}
	}

	public SearchDailyForecastManageListVO getSearchDailyForecastManageListVO() {
		return searchDailyForecastManageListVO;
	}

	public SearchDailyForecastManageListVO[] getSearchDailyForecastManageListVOS() {
		SearchDailyForecastManageListVO[] rtnVOs = null;
		if (this.searchDailyForecastManageListVOs != null) {
			rtnVOs = Arrays.copyOf(searchDailyForecastManageListVOs, searchDailyForecastManageListVOs.length);
		}
		return rtnVOs;
	}

	public SpcDlyFcastCustVO getSpcDlyFcastCustVO() {
		return spcDlyFcastCustVO;
	}

	public SpcDlyFcastCustVO[] getSpcDlyFcastCustVOS() {
		SpcDlyFcastCustVO[] rtnVOs = null;
		if (this.spcDlyFcastCustVOs != null) {
			rtnVOs = Arrays.copyOf(spcDlyFcastCustVOs, spcDlyFcastCustVOs.length);
		}
		return rtnVOs;
	}

	private ConditionVO conditionVO = null;

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setDlyFctInpListVO(DlyFctInpListVO searchDailyForecastManageListVO) {
		this.dlyFctInpListVO = searchDailyForecastManageListVO;
	}

	public void setDlyFctInpListVOS(DlyFctInpListVO[] dlyFctInpListVOs) {
		if(dlyFctInpListVOs != null){
			DlyFctInpListVO[] tmpVOs = Arrays.copyOf(dlyFctInpListVOs, dlyFctInpListVOs.length);
			this.dlyFctInpListVOs  = tmpVOs;
		}
	}

	public DlyFctInpListVO getDlyFctInpListVO() {
		return dlyFctInpListVO;
	}

	public DlyFctInpListVO[] getDlyFctInpListVOS() {
		DlyFctInpListVO[] rtnVOs = null;
		if (this.dlyFctInpListVOs != null) {
			rtnVOs = Arrays.copyOf(dlyFctInpListVOs, dlyFctInpListVOs.length);
		}
		return rtnVOs;
	}
}