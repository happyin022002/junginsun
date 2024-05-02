/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyforecastmanageBC.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.10.17 [CHM-201325350] Split 04-영업지원 Application 개발 요청 - 이로 인해 Forecast Input Save의 parameter 변경
* 2013.10.28 [CHM-201325350] 영업지원 Application 개발요청 - Others 저장시 Others 안에 있는 다른건 zero로 변경
* 2015.11.19 이혜민 [CHM-201538569] FCST Input > Account Add/Del 사용시 Data 확인 및 팝업처리 요청
* 2016.04.01 이혜민 [CHM-201640539] ALPS Live Out Of Memory Error 확인 및 조치 요청(Sales Rep이 몇 개의 Account를 체크했는지 개수 조회)
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchAccumulatedGuidePfmcVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchContractForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchLoadOfficeMappingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchSalesRepInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcCtrtFcastCustVO;
import com.hanjin.syscommon.common.table.SpcCtrtFcastOfcMapgVO;
import com.hanjin.syscommon.common.table.SpcDlyFcastCustVO;
import com.hanjin.syscommon.common.table.SpcSlsRepCustMapgVO;
import com.hanjin.syscommon.common.table.SpcSlsRepCustVO;

/**
 * ALPS-Dailyforecast Business Logic Command Interface<br>
 * - ALPS-Dailyforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Han Sang Hoon
 * @see Esm_spc_0103EventResponse 참조
 * @since J2EE 1.6
 */

public interface DailyForecastManageBC {

	/**
	 * [ESM_SPC_0103]을 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastSrepAccountManageList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0103]을 [행위] 합니다.<br>
	 * 
	 * @param SpcSlsRepCustMapgVO[] spcSlsRepCustMapgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForecastSrepAccountManage(SpcSlsRepCustMapgVO[] spcSlsRepCustMapgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0999]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastManageListVO> searchDailyForecastManage2List(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0999]을 [행위] 합니다.<br>
	 * 
	 * @param SpcDlyFcastCustVO[] spcDlyFcastCustVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForecastManage2(SpcDlyFcastCustVO[] spcDlyFcastCustVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0999]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForcastForHistory(ConditionVO conditionVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0104]을 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistoryOfcList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0104]을 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistorySrepAcctList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;

	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep 정보를 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO> 
	 * @throws EventException
	 */
	public List<SearchSalesRepInfoVO> searchSalesRepList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException;

	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO> 
	 * @throws EventException
	 */
	public List<SearchSalesRepInfoVO> searchSalesRepAccountList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException;

	/**
	 * ESM_SPC_0106 : SEARCHLIST03
	 * Individual 을 언체크 할경우 해당 S.Rep, 화주, S.office 에 이번주 이후에 물량을 준게 있는지 확인한다
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<String> 
	 * @throws EventException
	 */
	public List<String> searchSalesRepVolExistList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException;
	
	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 관리한다.
	 * 
	 * @param  SpcSlsRepCustVO[] spcSlsRepCustVOS
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSalesRepAccountManage(SpcSlsRepCustVO[] spcSlsRepCustVOS, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [ESM_SPC_0102]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastManageListVO> searchDailyForecastManageListByKor(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SPC_0102 : [Retreive 전]<br>
	 * 해당 Sales Rep이 몇 개의 Account를 체크했는지 개수를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSrepAccountCnt(ConditionVO conditionVO) throws EventException;
	
	
	/**
	 * [ESM_SPC_107]을 [행위] 합니다.<br>
	 * 
	 * @param SpcDlyFcastCustVO[] spcDlyFcastCustVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void multiDailyForecastManageForKor(SpcDlyFcastCustVO[] spcDlyFcastCustVO,String usrId) throws EventException;
	
	/**
	 * [ESM_SPC_0109]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchContractForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchContractForecastManageListVO> searchContractForecastManageList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0109]을 [행위] 합니다.<br>
	 * 
	 * @param SpcCtrtFcastCustVO[] spcCtrtFcastCustVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiContractForecastManage(SpcCtrtFcastCustVO[] spcCtrtFcastCustVO,SignOnUserAccount account) throws EventException;
  
    /**
	 * [ESM_SPC_0110]을 [행위] 합니다. 
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastHistorySrepAcctListVO>
	 * @throws EventException
	 */
	public List<SearchDailyForecastHistorySrepAcctListVO> searchPreviousSalesRepList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0110]을 [행위] 합니다.
	 * 
	 * @param SearchDailyForecastManageListVO[] searchDailyForecastManageListVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiDailyForecastManageSwitch(SearchDailyForecastManageListVO[] searchDailyForecastManageListVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0111]을 [행위] 합니다.
	 * 
	 * @param SpcCtrtFcastOfcMapgVO[] spcCtrtFcastOfcMapgVOS
	 * @param SignOnUserAccount account
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @throws EventException
	 */
	public void multiLoadOfficeMappingList(SpcCtrtFcastOfcMapgVO[] spcCtrtFcastOfcMapgVOS, SignOnUserAccount account, DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0111]을 [행위] 합니다.
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<SearchLoadOfficeMappingListVO>
	 * @throws EventException
	 */
	public List<SearchLoadOfficeMappingListVO> searchLoadOfficeMappingList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0112]을 [행위] 합니다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO>
	 * @throws EventException
	 */
	public List<SearchSalesRepInfoVO> searchAccountSrepList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException;

	/**
	 * [ESM_SPC_0112]을 [행위] 합니다.
	 * 
	 * @param SpcSlsRepCustVO[] spcSlsRepCustVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiAccountSrepList(SpcSlsRepCustVO[] spcSlsRepCustVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0108]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAccumulatedGuidePfmcVO>
	 * @exception EventException
	 */
	public List<SearchAccumulatedGuidePfmcVO> searchAccumulatedGuidePfmcList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [모바일] others fcast 입력시 내부에 존재하는 fcast를 0으로 update (alps는 화면내에서 control함)<br>
	 * 
	 * @param SpcDlyFcastCustVO[] spcDlyFcastCustVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void multiOthersFcastToZero(SpcDlyFcastCustVO[] spcDlyFcastCustVO,String usrId) throws EventException;
	
}