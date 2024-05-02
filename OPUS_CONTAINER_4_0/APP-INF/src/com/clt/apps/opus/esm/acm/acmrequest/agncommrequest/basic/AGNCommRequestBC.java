/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestBC.java
*@FileTitle : AGNCommRequestBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.26 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AGNCommRequestVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.CalcDtlBkgRevenueVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0006EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGNCommRequestBC {

	/**
	 * [ESM_ACM_0006]
	 * Agent Commission Request 목록을 조회<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @return List<AGNCommRequestVO>
	 * @exception EventException
	 */
	public List<AGNCommRequestVO> searchAGNCommRequest(AGNCommRequestVO agnCommRequestVO) throws EventException;

	/**
	 * [ESM_ACM_0006] Request<br>
	 * Agent Commission Request 화면의 요청 관련 정보 저장<br>
	 *
	 * @param AGNCommRequestVO[] agnCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestAGNCommRequest(AGNCommRequestVO[] agnCommRequestVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0006] <br>
	 * calling procedure<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @exception EventException
	 */
	public void executeAcmTest3Prc(AGNCommRequestVO agnCommRequestVO) throws EventException;

	/**
	 * [ESM_ACM_0006] Ex. Rate Input<br>
	 *
	 * @param AGNCommRequestVO[] agnCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void executeRateInput(AGNCommRequestVO[] agnCommRequestVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @param String usrId
	 * @exception EventException
	 */
	public void createAgnComm(String bkgNo, String usrId) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Revenue 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgRevenue(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Q'ty 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgQty(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Route 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgRoute(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Charge Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlChgDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Transportation Cost Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTrsCstDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 General Commission 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlGeneralComm(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Container Handling Fee (CHF) 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlCntrHandlingFee(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 T/S Commission 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTSCommission(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Commission Detail 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception EventException
	 */
	public List<CalcDtlBkgRevenueVO> searchCalcDtlCommissionDtl(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws EventException;

}