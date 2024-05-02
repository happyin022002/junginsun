/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalculationBC.java
*@FileTitle : AGNCommCalculationBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.16 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo.AGNCommMassCalVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationDetailVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMCalculation Business Logic Command Interface<br>
 * - ALPS-ACMCalculation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0012EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGNCommCalculationBC {

	/**
	 * [ESM_ACM_0012]
	 * Target Booking 목록을 조회<br>
	 *
	 * @param AGNCommMassCalVO agnCommMassCalVO
	 * @return List<AGNCommMassCalVO>
	 * @exception EventException
	 */
	public List<AGNCommMassCalVO> searchAGNCommMassCalList(AGNCommMassCalVO agnCommMassCalVO) throws EventException;

	/**
	 * [ESM_ACM_0012] Start Mass Calculation<br>
	 * 대상 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassCalVO agnCommMassCalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAGNCommMassCalList(AGNCommMassCalVO agnCommMassCalVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0012] Add Batch<br>
	 * 대상 Agreement 를 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassCalVO agnCommMassCalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAGNCommAddBatch(AGNCommMassCalVO agnCommMassCalVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * [ESM_ACM_0012] BKG Export<br>
	 * 조회 결과를 Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassCalVO agnCommMassCalVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAGNCommMassCalExcel(AGNCommMassCalVO agnCommMassCalVO) throws EventException;
	
	/**
	 * [ESM_ACM_9999] BKG Calculation Search<br>
	 * BKG Calculation 목록을 조회<br>
	 * 
	 * @param BkgCalculationVO bkgcalculationVO
	 * @return List<BkgCalculationVO>
	 * @exception EventException
	 */
	public List<BkgCalculationVO> searchBkgCalculationList(BkgCalculationVO bkgcalculationVO) throws EventException;
	
	
	/**
	 * [ESM_ACM_0036] Agent Commission Calculation<br>
	 * Agent Commission Calculation Detail 목록을 조회<br>
	 * 
	 * @param BkgCalculationDetailVO bkgCalculationDetailVO
	 * @return List<BkgCalculationDetailVO>
	 * @exception EventException  
	 */
	public List<BkgCalculationDetailVO> searchBkgCalculationDetailList(BkgCalculationDetailVO bkgCalculationDetailVO) throws EventException;
	
	/**
	 * INV에서 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param String bkgNo
	 * @param String usrId
	 * @exception EventException
	 */
	public void addCalcBatchByINV(String bkgNo, String usrId) throws EventException;
}