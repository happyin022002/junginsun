/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BasicDataBC.java
*@FileTitle      : BasicData
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.23
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.07.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.basic;

import java.util.List;

import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByWeekListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcIrrFcastOfcPolMapgVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Dailyforecast Business Logic Command Interface<br>
 * - Dailyforecast에 대한 비지니스 로직에 대한 인터페이스<br>
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