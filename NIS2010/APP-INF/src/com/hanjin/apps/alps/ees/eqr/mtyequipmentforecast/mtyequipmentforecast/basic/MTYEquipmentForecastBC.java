/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastBC.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic;

import java.util.List; 

import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Mtyequipmentforecast Business Logic Command Interface<br>
 * - ALPS-Mtyequipmentforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim jong jun
 * @see Ees_cim_5001EventResponse 참조
 * @since J2EE 1.6
 */

public interface MTYEquipmentForecastBC {

	/**
	 *  지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceListVO> searchMtyBalanceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
	/**
	 * OP Forecast, MG Forecast 의 Log를 조회.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceListVO> searchMtyBalanceListLog(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;	

	/**
	 *  지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceReferenceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceReferenceListVO> searchMtyBalanceReferenceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;

	/**
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
	 * 
	 * @param MtyBalanceListVO[] mtyBalanceListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMtyBalance(MtyBalanceListVO[] mtyBalanceListVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 *  해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalRptOtrVO>
	 * @exception EventException
	 */
	public List<MtyBalRptOtrVO> searchMtyBalanceOtherList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
	/**
	 * ECC내 소속 야드 를 조회한다<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchYardList(String locGrpCd, String locCd) throws EventException;

	/**
	 * searchDateListByWeek<br>
	 * 
	 * @param yearWeek
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchDateListByWeek( String yearWeek ) throws EventException;

	/**
	 * 장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 생성,수정,삭제한다.(팝업)<br>
	 * 
	 * @param MtyBalRptOtrVO[] mtyBalanceListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyBalanceOther(MtyBalRptOtrVO[] mtyBalanceListVOs,SignOnUserAccount account) throws EventException;

	/**
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;

	/**
	 *  MTY Balance Report의 In&Out Bound FCST Data의 정확도를 WEEK별로 조회<br>
	 * 
	 * @param ForecastAccuracyOptionVO	forecastAccuracyOptionVO
	 * @param SignOnUserAccount	userAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchForecastAccuracyList(ForecastAccuracyOptionVO forecastAccuracyOptionVO, SignOnUserAccount userAccount) throws EventException;
	
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOut(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException;
	
	/**
	 *  VVD를 이용해 slan cd를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMtyBalanceRepoOutSlanCd(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException;

	/**
	 *  VVD를 이용해 from yard list 및 etd dt를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOutFrYdList(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException;
	
	/**
	 *  VVD를 이용해 to yard list 및 etb dt를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOutToYdList(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException;
	
	/**
	 *  T/D VVD가 아닌 경우 입력된 yard cd가 해당 ecc/lcc/scc에 속하는지 체크<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkMtyBalanceRepoOutYard(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws EventException;
	
	/**
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 수정한다.)<br>
	 * 
	 * @param MtyBalanceRepoListVO[] mtyBalanceRepoListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyBalanceRepoOut(MtyBalanceRepoListVO[] mtyBalanceRepoListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ECC 조회 시점, 해당 REPO ID 포함 4주치에 대한 O/B FCST D.TTL(Dry TTL)이 0 이상인지 체크<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String checkMtyBalanceLCCSave(MtyBalanceOptionVO mtyBalanceOptionVO)  throws EventException;
	 
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceDischargedList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
	/**
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyRepoInDetailList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
	/**
	 * REPO IN 데이터를 수기로 관리하는 기능 처리<br>
	 * 
	 * @param MtyBalanceRepoListVO[] mtyBalanceRepoListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyRepoInDetailList(MtyBalanceRepoListVO[] mtyBalanceRepoListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * LCC/ECC/SCC 에 속한 LOCATION<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchLocationList(String locGrpCd, String locCd) throws EventException;
	
	/**
	 * 특정 주차내의 일자 목록을 조회한다<br>
	 * 
	 * @param String wk_st_dt
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchLocationDateList(String wk_st_dt) throws EventException;	
	
}