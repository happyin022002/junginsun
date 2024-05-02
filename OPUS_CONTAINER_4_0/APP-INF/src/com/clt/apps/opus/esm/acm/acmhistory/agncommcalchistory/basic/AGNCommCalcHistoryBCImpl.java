/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalcHistoryBCImpl.java
*@FileTitle : AGNCommCalcHistoryBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.24 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration.AGNCommCalcHistoryDBDAO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.AGNCommCalcHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.CalcDtlHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * OPUS-ACMHistory Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0016Event,AGNCommCalcHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGNCommCalcHistoryBCImpl extends BasicCommandSupport implements AGNCommCalcHistoryBC {

	// Database Access Object
	private transient AGNCommCalcHistoryDBDAO dbDao = null;

	/**
	 * AGNCommCalcHistoryBCImpl 객체 생성<br>
	 * AGNCommCalcHistoryDBDAO를 생성한다.<br>
	 */
	public AGNCommCalcHistoryBCImpl() {
		dbDao = new AGNCommCalcHistoryDBDAO();
	}

	/**
	 * [ESM_ACM_0016]
	 * Agent Commission Calculation History 목록을 조회<br>
	 *
	 * @param AGNCommCalcHistoryVO agnCommCalcHistoryVO
	 * @return List<AGNCommCalcHistoryVO>
	 * @exception EventException
	 */
	public List<AGNCommCalcHistoryVO> searchAGNCommCalcHistory(AGNCommCalcHistoryVO agnCommCalcHistoryVO) throws EventException {
		try {
			return dbDao.searchAGNCommCalcHistory(agnCommCalcHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 Booking Revenue 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlBkgRevenue(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlBkgRevenue(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 Booking Q'ty 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlBkgQty(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlBkgQty(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 Booking Route 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlBkgRoute(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlBkgRoute(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 Charge Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlChgDeduction(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlChgDeduction(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 Transportation Cost Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlTrsCstDeduction(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlTrsCstDeduction(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 General Commission 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlGeneralComm(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlGeneralComm(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 Container Handling Fee (CHF) 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlCntrHandlingFee(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlCntrHandlingFee(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0116] Retrieve<br>
	 * Calculation Detail from History의 T/S Commission 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlTSCommission(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlTSCommission(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0116] Retrieve <br>
	 * Calculation Detail from History 의 Commission Detail 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception EventException
	 */
	public List<CalcDtlHistoryVO> searchCalcDtlCommissionDtl(CalcDtlHistoryVO calcDtlHistoryVO) throws EventException {
		try {
			return dbDao.searchCalcDtlCommissionDtl(calcDtlHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}