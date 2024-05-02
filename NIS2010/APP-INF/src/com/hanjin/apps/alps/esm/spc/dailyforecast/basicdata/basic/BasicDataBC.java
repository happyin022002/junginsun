/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BasicDataBC.java
*@FileTitle : DailyForecast
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.23 한상훈
* 1.0 Creation
* 
* History
* 2013.05.20 진마리아 [CHM-201324741-01] Lane Office POL 화면 로직 보완 - validation 및 error handling
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByWeekListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.SpcFcastOfcPolMapgVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgVO;
//import com.hanjin.syscommon.common.table.SpcIrrFcastOfcPolMapgVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcIrrFcastOfcPolMapgVO;

/**
 * ALPS-Dailyforecast Business Logic Command Interface<br>
 * - ALPS-Dailyforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Han Sang Hoon
 * @see Esm_spc_0100EventResponse 참조 
 * @since J2EE 1.6
 */

public interface BasicDataBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO
	 * @return List<SearchDailyForcastManageByVvdListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForcastManageByVvdListVO> searchDailyForcastManageByVvdList(SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO
	 * @return List<SearchDailyForcastManageByWeekListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForcastManageByWeekListVO> searchDailyForcastManageByWeekList(SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForcastVvdManage(SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastOfcPolMapgVO[] spcFcastOfcPolMapgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForcastManage(SpcFcastOfcPolMapgVO[] spcFcastOfcPolMapgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Lane, Bound 에 등록 가능한 Port인지 체크<br>
	 * 
	 * @param SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO
	 * @return String
	 * @exception EventException
	 */
	public String checkLanePortValid(SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO) throws EventException;
	
	/**
	 * 입력한 Office가 Region Office 체크합니다.<br>
	 * 
	 * @param SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO
	 * @return String
	 * @exception EventException
	 */
	public String checkOfficeValid(SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO) throws EventException;
	
	/**
	 * 입력한 vvd가 valid한지 체크합니다.<br>
	 * 
	 * @param SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO
	 * @return String
	 * @exception EventException
	 */
	public String checkVvdValid(SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO) throws EventException;
}