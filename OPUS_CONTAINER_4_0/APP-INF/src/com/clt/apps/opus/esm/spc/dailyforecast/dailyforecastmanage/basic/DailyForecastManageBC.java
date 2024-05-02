/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : DailyforecastmanageBC.java
 *@FileTitle      : Dailyforecastmanage
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2009.08.21
 *@LastModifier   : 한상훈
 *@LastVersion    : 1.0
 * 2009.08.21
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDlyFctSplListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcOfcLvlVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpcDlyFcastCustVO;
//import com.clt.syscommon.common.table.SpcSlsRepCustMapgVO; 
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcSlsRepCustMapgNewVO;

/**
 * Dailyforecast Business Logic Command Interface<br>
 * - Dailyforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Han Sang Hoon
 * @see Esm_spc_0103EventResponse 참조
 * @since J2EE 1.6
 */ 

public interface DailyForecastManageBC {

	/**
	 * [ESM_SPC_0103]을 [행위] 합니다.<br>
	 * 
	 * @param dailyforecastmanageConditionVO DailyforecastmanageConditionVO
	 * 
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastSrepAccountManageList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0103]을 [행위] 합니다.<br>
	 * 
	 * @param spcSlsRepCustMapgVO SpcSlsRepCustMapgVO [] 
	 *           
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void multiDailyForecastSrepAccountManage(SpcSlsRepCustMapgNewVO[] spcSlsRepCustMapgVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0102]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO ConditionVO
	 *            
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastManageListVO> searchDailyForecastManage2List(ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0102]을 [행위] 합니다.<br>
	 * 
	 * @param spcDlyFcastCustVO SpcDlyFcastCustVO []
	 *             
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void multiDailyForecastManage2(SpcDlyFcastCustVO[] spcDlyFcastCustVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_9010]을 [행위] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO DlyFctInpListVO []
	 *             
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void multiDailyForecastManage3(DlyFctInpListVO[] dlyFctInpListVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0102]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO ConditionVO
	 *            
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void multiDailyForcastForHistory(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0104]을 [행위] 합니다.<br>
	 * 
	 * @param dailyforecastmanageConditionVO DailyforecastmanageConditionVO
	 *            
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistoryOfcList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0104]을 [행위] 합니다.<br>
	 * 
	 * @param dailyforecastmanageConditionVO DailyforecastmanageConditionVO
	 *            
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistorySrepAcctList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;

	/**
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<SpcOfcLvlVO> searchOfcLvlList() throws EventException;

	/**
	 * 
	 * @throws EventException
	 */
	public void multiOfficeLevelManage() throws EventException;

	/**
	 * [ESM_SPC_9010]을 [Retrieve] 합니다.<br>
	 * 
	 * @param conditionVO ConditionVO
	 *            
	 * @return List<SearchDlyFctSplListVO>
	 * @exception EventException
	 */
	public List<SearchDlyFctSplListVO> searchDailyForecastManage3List(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_9010]을 [Retrieve] 합니다.<br>
	 * 
	 * @param conditionVO ConditionVO
	 *            
	 * @return List<SearchDlyFctSplListVO>
	 * @exception EventException
	 */
	public List<SearchDlyFctSplListVO> searchDailyForecastTemplateList(ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_9010]을 [Retrieve] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO DlyFctInpListVO
	 *            
	 * @return List<DlyFctInpListVO>
	 * @exception EventException
	 */
	public List<DlyFctInpListVO> checkFileImportList(DlyFctInpListVO[] dlyFctInpListVO) throws EventException;

}