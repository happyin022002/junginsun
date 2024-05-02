/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationBC.java
*@FileTitle : ACMSimulationBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.09 김상수
* 1.0 Creation
* 
* 2014.06.03 박다은 [CHM-201430120] Agent Comm. Mass simulation 에 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AGNCommMassSimVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AGNCommSimulationVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SearchAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateDetailVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimulationNoVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMSimulation Business Logic Command Interface<br>
 * - ALPS-ACMSimulation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0106EventResponse 참조
 * @since J2EE 1.6
 */

public interface ACMSimulationBC {

	/**
	 * [ESM_ACM_0106]
	 * Agreement Search화면의 Actual Agreement 목록을 조회<br>
	 *
	 * @param SearchAgreementVO searchAgreementVO
	 * @return List<SearchAgreementVO>
	 * @exception EventException
	 */
	public List<SearchAgreementVO> searchActualAgreement(SearchAgreementVO searchAgreementVO) throws EventException;

	/**
	 * [ESM_ACM_0106]
	 * Agreement Search화면의 Simulation Agreement 목록을 조회<br>
	 *
	 * @param SearchAgreementVO searchAgreementVO
	 * @return List<SearchAgreementVO>
	 * @exception EventException
	 */
	public List<SearchAgreementVO> searchSimulationAgreement(SearchAgreementVO searchAgreementVO) throws EventException;

	/**
	 * [ESM_ACM_0010]
	 * Agent Commission Simulation 목록을 조회<br>
	 *
	 * @param AGNCommSimulationVO agnCommSimulationVO
	 * @return List<AGNCommSimulationVO>
	 * @exception EventException
	 */
	public List<AGNCommSimulationVO> searchAGNCommSimulation(AGNCommSimulationVO agnCommSimulationVO) throws EventException;
	
	/**
	 * [ESM_ACM_0010]
	 * Agent Commission Simulation 결과 목록을 조회<br>
	 *
	 * @param AGNCommSimulationVO agnCommSimulationVO
	 * @return List<AGNCommSimulationVO>
	 * @exception EventException
	 */
	public List<AGNCommSimulationVO> searchAGNCommSimulationResult(AGNCommSimulationVO agnCommSimulationVO) throws EventException;
	
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * New Simulation No. 를 조회<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String getNewSimulationNo() throws EventException;
	
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Simulation No. Max 값 조회<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String getMaxSimulationNo() throws EventException;
	
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Simulation Info. 저장<br>
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @exception EventException
	 */
	public void addAcmSimInfo(SimulationNoVO simulationNoVO) throws EventException;
	
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Agent Commission Simulation 화면의 Start Simulation 버튼 이벤트<br>
	 *
	 * @param String bkgNo
	 * @param String usrId
	 * @param String simNo
	 * @exception EventException
	 */
	public void simulateAGNCommSimulation(String bkgNo, String usrId, String simNo) throws EventException;

	/**
	 * [ESM_ACM_0011-01 / ESM_ACM_0011-03 / ESM_ACM_0115]
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception EventException
	 */
	public List<SimAgnRateMasterVO> searchSimAgnRateMaster(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0011-01]
	 * [Master]탭 목록을 저장<br>
	 *
	 * @param SimAgnRateMasterVO[] simAgnRateMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSimAgnRateMaster(SimAgnRateMasterVO[] simAgnRateMasterVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0011-02 / ESM_ACM_0011-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateDetailVO>
	 * @exception EventException
	 */
	public List<SimAgnRateDetailVO> searchSimAgnRateDetail(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Master 목록을 저장<br>
	 *
	 * @param SimAgnRateDetailVO[] simAgnRateDetailVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSimAgnRateDetail(SimAgnRateDetailVO[] simAgnRateDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0011-01 / ESM_ACM_0115]
	 * New Agreement No. 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception EventException
	 */
	public List<SimAgnRateMasterVO> getNewAgreementNo(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0115]
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @exception EventException
	 */
	public void getAgreementNoInfo(SimAgnRateMasterVO simAgnRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0115]
	 * 선택된 Agreement No.의 Master와 Detail, TP/SZ, Route, Charge 목록을 New Ageement No.로 저장<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgmtCopy(SimAgnRateMasterVO simAgnRateMasterVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0033]
	 * Target Booking 목록을 조회<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return List<AGNCommMassSimVO>
	 * @exception EventException
	 */
	public List<AGNCommMassSimVO> searchAGNCommMassSimList(AGNCommMassSimVO agnCommMassSimVO) throws EventException;

	/**
	 * [ESM_ACM_0033] Start Simulation<br>
	 * 대상 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAGNCommMassSimList(AGNCommMassSimVO agnCommMassSimVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0033] BKG Export<br>
	 * 조회 결과를 Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAGNCommMassSimExcel(AGNCommMassSimVO agnCommMassSimVO) throws EventException;

	/**
	 * [ESM_ACM_0110] Simulation No. Search<br>
	 * Simulation No. Search 목록을 조회<br>
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @return List<SimulationNoVO>
	 * @exception EventException
	 */
	public List<SimulationNoVO> searchSimulationNoList(SimulationNoVO simulationNoVO) throws EventException;

	/**
	 * [ESM_ACM_0110]Simulation No 의 Simulation Office 조회<br>
	 * Simulation Office 조회
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @return List<SimulationNoVO>
	 * @exception EventException
	 */
	public List<SimulationNoVO> getSimulationOfficeList(SimulationNoVO simulationNoVO) throws EventException;
	
	/**
	 * [ESM_ACM_0033] Simulation Result - Simulation Number<br>
	 * imulation Result - Simulation Number Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAGNCommMassSimSimulationNumberExcel(AGNCommMassSimVO agnCommMassSimVO) throws EventException;

	/**
	 * [ESM_ACM_0033]
	 * 
	 * @param agnCommMassSimVO
	 * @param account
	 * @throws EventException
	 */
	public void manageAGNCommAddBatchList(AGNCommMassSimVO agnCommMassSimVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0033]
	 * 
	 * @param agnCommMassSimVO
	 * @param account
	 * @throws EventException
	 */
	public void manageSimCommAddBatchList(AGNCommMassSimVO agnCommMassSimVO, SignOnUserAccount account) throws EventException;

	
}