/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastBC.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcst3AvgVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Mtyequipmentforecast Business Logic Command Interface<br>
 * - OPUS-Mtyequipmentforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim jong jun
 * @see Ees_cim_5001EventResponse 참조
 * @since J2EE 1.6
 */

public interface MTYEquipmentForecastBC {

	/**
	 * 과거 3주 분 실적과 향후 3주 까지의 OPMG Forecast Input data 를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<OpmgFcstInputVO> searchOpmgFcstInputBasic(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
	/**
	 * 과거 3주의 평균 OP, MG, Repo Out 을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<OpmgFcst3AvgVO> searchOpmgFcst3AvgBasic(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
	/**
	 * OPMG Forecast 화면의 Reference2 데이터를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @param String	kind
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchOpmgFcstReference2Basic(MtyBalanceOptionVO mtyBalanceOptionVO, String kind) throws EventException;
	
	/**
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
	 * 
	 * @param OpmgFcstInputVO[] opmgFcstInputVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOpmgFcstInputBasic(OpmgFcstInputVO[] opmgFcstInputVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 직전 주차를 조회<br>
	 * 
	 * @param String week
	 * @return String
	 * @exception EventException
	 */
	public String searchBeforeWeekBasic(String week) throws EventException; 
	
	/**
	 * OP Forecast, MG Forecast 의 Log를 조회.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceListVO> searchMtyBalanceListLog(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;	

	/**
	 *  해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalRptOtrVO>
	 * @exception EventException
	 */
	public List<MtyBalRptOtrVO> searchMtyBalanceOtherList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
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
	public String checkMtyBalanceLCCSave(MtyBalanceOptionVO mtyBalanceOptionVO)  throws EventException;
	
	/**
	 * OP/MG FCST 화면의 OP/MG/RO/OTHER 항목수정 가능여부 확인<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception DAOException
	 */
	public String checkMtyBalanceSaveAvailable(MtyBalanceOptionVO mtyBalanceOptionVO, SignOnUserAccount account)  throws EventException;	
	 
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceDischargedList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
}