/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAO.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS ChargeAmountDiscountMgtDBDAO <br>
 * - OPUS-DMTClosing system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see ChargeAmountDiscountMgtBCImpl 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAO extends DBDAOSupport {
	
	/**
	 * After Booking 목록을 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AfterBKGListVO> searchAfterBookingList(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBKGListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBKGListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * After Booking 의 정보를 Booking 테이블에서 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AfterBKGListVO> searchAfterBookingListInBooking(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBKGListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingListInBookingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBKGListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * After Booking 의 기타정보를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListInputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AfterBKGListInputVO> searchAfterBookingDAR(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBKGListInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBKGListInputVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * After Booking 의 기타정보를 Booking 테이블에서 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListInputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AfterBKGListInputVO> searchAfterBookingDARInBooking(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBKGListInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARInBookingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBKGListInputVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }
	 
	/**
	 * Booking No. 에 해당하는 컨테이너 정보를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeBookingContainerVO> searchContainerChargeByBooking(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeBookingContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chargeBookingContainerParmVO != null) {
				Map<String, String> mapVO = chargeBookingContainerParmVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//[2015.05.28]소스품질 Modify
				//1.Charge Detail per BKG 정보를 DMT_AFT_BKG_CNTR 에서 조회를 한다.
				if ("Y".equals(chargeBookingContainerParmVO.getIsAftBkgCntr())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
							ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBookingRSQL(), param, velParam);
				}
				//2.Charge Detail per BKG 정보를 DMT_CHG_CALC 에서 조회를 한다.
				else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
							ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBooking2RSQL(), param, velParam);		
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingContainerVO .class);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 컨테이너의 Quantity를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeBookingContainerVO> searchContainerQuantity(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeBookingContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chargeBookingContainerParmVO != null) {
				Map<String, String> mapVO = chargeBookingContainerParmVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchContainerQuantityRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 컨테이너의 Currency를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeBookingContainerVO> searchContainerCurrency(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeBookingContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chargeBookingContainerParmVO != null) {
				Map<String, String> mapVO = chargeBookingContainerParmVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchContainerCurrencyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * After Booking Request Container목록을 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public List<AfterBKGDetailVO> searchAfterBookingDetailList(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBKGDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBKGDetailVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Comment History를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<CommentHistoryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public List<CommentHistoryVO> searchCommentHistory(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommentHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchCommentHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommentHistoryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Booking Data 를 조회 합니다. <br>
	 * 
	 * @param AfterBKGDetailInputVO afterBKGDetailInputVO
	 * @return List<AfterBKGDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AfterBKGDetailVO> searchBookingData(AfterBKGDetailInputVO afterBKGDetailInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBKGDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGDetailInputVO != null) {
				Map<String, String> mapVO = afterBKGDetailInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBKGDetailVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * After Booking Request Request목록을 조회 합니다. <br>
	 * 
	 * @param AfterBKGDetailInputVO afterBKGDetailInputVO
	 * @return List<AfterBKGDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AfterBKGDetailVO> searchBookingDetailData(AfterBKGDetailInputVO afterBKGDetailInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBKGDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGDetailInputVO != null) {
				Map<String, String> mapVO = afterBKGDetailInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchBookingDetailDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBKGDetailVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Charge 정보가 있는지 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return int
	 * @throws DAOException
	 */	
	public int searchChargeContainerCount(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		int result = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchChargeContainerCountRSQL(), param, velParam);
			
			if (dbRowset.next()) result = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;		
	}
	
	/**
	 * Charge Container 에 등록된 데이터에서 Calculation Type이 맞는지 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkCalculationType(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		boolean result = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOCheckCalcuationTypeRSQL(), param, velParam);
			
			if (dbRowset.next()) result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * BKG No., B/L No. 에 해당되는 Yard Code 를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchFromYardByBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchFromYardByBKGBLNoRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			else {
				result = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * BKG No., B/L No. 에 해당되는 Location Code 를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchLocationByBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchLocationByBKGBLNoRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			else {
				result = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Tariff Type 과 BKG 또는 B/L No. 가 중복되는지 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkDupTariffBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOCheckDupTariffBKGBLNoRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Balance Charge 가 있는 CNTR 인지 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkBalanceCharge(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		boolean result = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBKGListInputVO != null) {
				Map<String, String> mapVO = afterBKGListInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOCheckBalanceChargeRSQL(), param, velParam);
			
			if (dbRowset.next()) result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * After Booking DAR 의 상태를 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void modifyAfterBookingStatus(AfterProgressVO afterProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterProgressVO != null) {
				Map<String, String> mapVO = afterProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyAfterBookingStatusUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking DAR 가 이미 등록되어 있는지 조회 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isDupAfterBookingRequest(AfterProgressVO afterProgressVO) throws DAOException,Exception {
		boolean result = false;
		DBRowSet dbRowset = null;		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();;

		try{
			if (afterProgressVO != null) {
				Map<String, String> mapVO = afterProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOSearchDupAfterBookingRequestRSQL(), param, velParam);
	
			if (dbRowset.next()) {
				result = dbRowset.getInt(1) > 0 ? true : false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * After Booking DAR. 를 생성 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @throws DAOException
	 */	
	public void addAfterBookingRequest(AfterProgressVO afterProgressVO)	throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (afterProgressVO != null) {
				Map<String, String> mapVO = afterProgressVO .getColumnValues();

				param.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOAddAfterBookingRequestCSQL(), param, null);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Comment History를 생성 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @throws DAOException
	 */	
	public void addCommentHistory(AfterProgressVO afterProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterProgressVO != null) {
				Map<String, String> mapVO = afterProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOAddCommentHistoryCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking DAR의 상세정보 다건을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<AfterBKGRequestVO> afterBKGRequestVOs
	 * @throws DAOException
	 */
	public void addAfterBookingDAR(List<AfterBKGRequestVO> afterBKGRequestVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(afterBKGRequestVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOAddAfterBookingDARCSQL(), afterBKGRequestVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking 컨테이너의 다건의 상세정보 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOs
	 * @throws DAOException
	 */
	public void addAfterBookingContainer(List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(afterBKGCNTRRequestVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOAddAfterBookingContainerCSQL(), afterBKGCNTRRequestVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking DAR 의 정보를 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @throws DAOException
	 */	
	public void modifyAfterBookingRequest(AfterProgressVO afterProgressVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();;

		try{
			if (afterProgressVO != null) {
				Map<String, String> mapVO = afterProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyAfterBookingRequestUSQL(), param, velParam);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * After Booking DAR 의 다건의 정보를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param List<AfterBKGRequestVO> afterBKGRequestVOs
	 * @throws DAOException
	 */
	public void modifyAfterBookingDAR(List<AfterBKGRequestVO> afterBKGRequestVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(afterBKGRequestVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingDARUSQL(), afterBKGRequestVOs, null);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking Charge 컨테이너 다건의 상세정보를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOs
	 * @throws DAOException
	 */
	public void modifyAfterBookingContainer(List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(afterBKGCNTRRequestVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingContainerUSQL(), afterBKGCNTRRequestVOs, null);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking DAR 다건의 상세정보를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<AfterBKGRequestVO> afterBKGRequestVOs
	 * @throws DAOException
	 */
	public void removeAfterBookingDAR(List<AfterBKGRequestVO> afterBKGRequestVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(afterBKGRequestVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAORemoveAfterBookingDARDSQL(), afterBKGRequestVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking Charge 컨테이너 다건의 상세정보를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOs
	 * @throws DAOException
	 */
	public void removeAfterBookingContainer(List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(afterBKGCNTRRequestVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAORemoveAfterBookingContainerDSQL(), afterBKGCNTRRequestVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DAR No. 에 해당되는 Calculation 처리할 Charge Calculation 목록을 조회 합니다. <br>
	 * 
	 * @param String darNo
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<ChargeCalculationContainerVO> searchChargeCalculationList(String darNo) throws DAOException,Exception {	
		DBRowSet dbRowset = null;
		List<ChargeCalculationContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("aft_expt_dar_no", darNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchChargeCalculationListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	 
	/**
	 * DAR No. 에 해당되는 Booking No. 목록을 조회 합니다. <br>
	 * 
	 * @param String darNo
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchBKGListByDARNo(String darNo) throws DAOException,Exception {	
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("aft_expt_dar_no", darNo);
			velParam.put("aft_expt_dar_no", darNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchBKGListByDARNoRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}

	/*
	 * After Booking 에 등록된 컨테이너 목록을 조회 합니다. <br>
	 * 
	 * @param String darNo
	 * @param String bkgNo
	 * @return List<ChargeBookingContainerVO>
	 * @throws DAOException
	 */
	/* 2010.02.22 한진해운 특화 로직으로 인식되어 삭제
	 @SuppressWarnings("unchecked")	
	public List<ChargeBookingContainerVO> searchContainerListAppliedAfterExceptionByDARNo(
			String darNo, String bkgNo) throws DAOException,Exception {	
		DBRowSet dbRowset = null;
		List<ChargeBookingContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("aft_expt_dar_no", darNo);
			param.put("bkg_no", bkgNo);
			velParam.put("aft_expt_dar_no", darNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchContainerListAppliedAfterExceptionByDARNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	*/
	/**
	 * Location Code 와 I/O Bound Code 에 해당하는 Calcuation Type을 조회 합니다. <br>
	 * 
	 * @param String locCd
	 * @param String ioBndCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCalcTypeCode(String locCd, String ioBndCd) throws DAOException {	
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);
			param.put("io_bnd_cd", ioBndCd);
			param.put("cnt_cd", locCd.substring(0, 2));
			
			velParam.put("loc_cd", locCd);
			velParam.put("cnt_cd", locCd.substring(0, 2));
			velParam.put("io_bnd_cd", ioBndCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchCalcTypeCodeRSQL(), param, velParam);

			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;		
	}
	
	/**
	 * Approval, Counter Offer, Reject 시 최종 Update Date 를 조회 합니다.<br>
	 * 
	 * @param  AfterProgressVO afterProgressVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchUpdateDate(AfterProgressVO afterProgressVO) throws DAOException {
		//result object
		String 					result		= null;
		DBRowSet				dbRowSet	= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (afterProgressVO != null) {
				Map<String, String> mapVO = afterProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOSearchUpdateDateRSQL(), param, velParam);
			
			if (dbRowSet.next()) {
				result = dbRowSet.getString(1);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
}
