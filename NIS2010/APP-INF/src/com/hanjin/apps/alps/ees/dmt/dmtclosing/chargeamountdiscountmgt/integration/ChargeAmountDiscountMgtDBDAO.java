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
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ActualCostListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingAproItmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailFlgVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingExptClrRqstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFileListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFullHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingMasListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingPfmcListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDescVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingRsnRmkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010 ChargeAmountDiscountMgtDBDAO <br>
 * - NIS2010-DMTClosing system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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

		try {
			if (chargeBookingContainerParmVO != null) {
				Map<String, String> mapVO = chargeBookingContainerParmVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			
				//1.Charge Detail per BKG 정보를 DMT_AFT_BKG_CNTR 에서 조회를 한다.
				if ("Y".equals(chargeBookingContainerParmVO.getIsAftBkgCntr())) {
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
							ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBookingRSQL(), param, velParam);
				}
				//2.Charge Detail per BKG 정보를 DMT_CHG_CALC 에서 조회를 한다.
				else {
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
							ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBooking2RSQL(), param, velParam);		
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingContainerVO .class);
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
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

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
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
			
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
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
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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

			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
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
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
	
	/**
	 * After Booking 에 등록된 컨테이너 목록을 조회 합니다. <br>
	 * 
	 * @param String darNo
	 * @param String bkgNo
	 * @return List<ChargeBookingContainerVO>
	 * @throws DAOException
	 */
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

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
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

			dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
	
	

//	/**
//	 * Approval Setup 관련 조회 <br>
//	 * @param String approTpCd
//	 * @param String darNo
//	 * @param String dmdtOfcCd
//	 * @param String usrId
//	 * @return List<SearchApproSetupInfoListVO>
//	 * @throws EventException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<SearchApproSetupInfoListVO> searchApprovalSetup(String approTpCd, String darNo, String dmdtOfcCd, String usrId) throws DAOException,Exception {	
//		DBRowSet dbRowset = null;
//		List<SearchApproSetupInfoListVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			param.put("dmdt_expt_apro_tp_cd", approTpCd);
//			param.put("dar_no", darNo);
//			param.put("dmdt_ofc_cd", dmdtOfcCd);
//			param.put("usr_id", usrId);
//			velParam.put("dmdt_expt_apro_tp_cd", approTpCd);
//			velParam.put("dar_no", darNo);
//			velParam.put("dmdt_ofc_cd", dmdtOfcCd);
//			velParam.put("usr_id", usrId);
//
//			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
//					ChargeAmountDiscountMgtDBDAOSearchApprovalSetupRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApproSetupInfoListVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;		
//	}
	
//	/**
//	 * BKG No., Tariff Type 을 가지는 Invoice No. 목록을 조회한다. <br>
//	 * @param String aftExptDarNo
//	 * @return List<Properties>
//	 * @throws EventException
//	 */
//	public List<Properties> searchInvoiceChargeNotInterfaced(String aftExptDarNo) throws DAOException,Exception {
//		
//		DBRowSet dbRowSet = null;
//		List<Properties> list = new ArrayList<Properties>();
//		Properties props = null;
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//query parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if (aftExptDarNo != null) {
//				param.put("aft_expt_dar_no", aftExptDarNo);
//				
//				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
//						ChargeAmountDiscountMgtDBDAOSearchInvoiceChargeNotInterfacedRSQL(), param, velParam);
//				
//				while (dbRowSet.next()) {
//					props = new Properties();
//					props.setProperty("dmdt_inv_no", dbRowSet.getString(1));
//					props.setProperty("cre_ofc_cd",  dbRowSet.getString(2));
//					list.add(props);
//				}
//			}
//		}
//		catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}
//		catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}	
	
//	/**
//	 * BKG No. 에 대한 Invoice No. 를 조회한다. <br>
//	 * @param String invNo
//	 * @return String
//	 * @throws EventException
//	 */
//	public String searchInvoiceCancelContentFromCancelRmk(String invNo) throws DAOException,Exception {
//		
//		DBRowSet dbRowSet = null;
//		String result = null;
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try {
//			param.put("dmdt_inv_no", invNo);
//			
//			dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
//					ChargeAmountDiscountMgtDBDAOSearchInvoiceCancelContentFromCancelRmkRSQL(), param, null);
//			
//			while (dbRowSet.next()) {
//				result = dbRowSet.getString(1);
//			}
//		}
//		catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}
//		catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}	
	
	/**
	 * AfterBooking 승인처리 후, Reject/Counter Offer 실행시 가상Inovice 생성된게 있다면, 가상Invoice 상태를 해제해준다. <br>
	 * 
	 * @param String aftExptDarNo
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean isExistsVirtualInvoice(String aftExptDarNo) throws DAOException {	
		
		DBRowSet dbRowSet = null;
		boolean result = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("aft_expt_dar_no", aftExptDarNo);
			
			dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchExistsVirtualInvoiceRSQL(), param, null);
			
			if (dbRowSet.next()) {
				result = "Y".equals(dbRowSet.getString(1));
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;		
	}
	
	/**
	 * Virtual Invoice 의 상태를 취소로 변경한다. <br>
	 * 
	 * @param String aftExptDarNo
	 * @param String loginUsrId
	 * @param String loginOfcCd
	 * @throws DAOException
	 */
	public void cancelVirtualInvoice(String aftExptDarNo, String loginUsrId, String loginOfcCd) throws DAOException {	

		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();

		try {
			//Set Query Parameter
			param.put("aft_expt_dar_no", aftExptDarNo);
			param.put("upd_usr_id",      loginUsrId);
			param.put("upd_ofc_cd",      loginOfcCd);
				
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyVirtualInvoiceToCancelUSQL(), param, null);

		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Cancel 된 Invoice 의 Container 에 대한 Calculation 수행 후,  Charge 가 존재하는지 여부를 조회한다.<br>
	 * @param Properties invoice
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean isExistsInvoiceChargeAmount(Properties invoice) throws DAOException {	
		
		DBRowSet dbRowSet = null;
		boolean result = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("dmdt_inv_no", invoice.getProperty("dmdt_inv_no"));
			param.put("cre_ofc_cd",  invoice.getProperty("cre_ofc_cd"));
			
			dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchExistsInvoiceChargeAmountRSQL(), param, null);
			
			if (dbRowSet.next()) {
				result = "Y".equals(dbRowSet.getString(1));
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;		
	}
	
	/**
	 * Cancel 된 Invoice 에 대해 가상 Invoice 를 생성해준다. <br>
	 * 
	 * @param Properties invoice
	 * @param String loginUsrId
	 * @param String loginOfcCd
	 * @throws DAOException
	 */
	public void createVirtualInvoice(Properties invoice, String loginUsrId, String loginOfcCd) throws DAOException {	

		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();

		try {
			//Set Query Parameter
			if (invoice != null) {
				
				param.put("dmdt_inv_no", invoice.getProperty("dmdt_inv_no"));
				param.put("cre_ofc_cd",  invoice.getProperty("cre_ofc_cd"));
				param.put("upd_usr_id",  loginUsrId);
				param.put("upd_ofc_cd",  loginOfcCd);
				
				new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyVirtualInvoiceUSQL(), param, null);
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	


	/**
	 * After Booking Actual Cost List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<ActualCostListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ActualCostListVO> searchActualCostList(AfterBKGListInputVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<ActualCostListVO> list = new ArrayList<ActualCostListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {
				Map<String, String> mapVO = InputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchActualCostListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, ActualCostListVO .class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	


	/**
	 * After Booking File List 조회 <br>
	 * 
	 * @param AfterBookingFileListVO InputVO
	 * @return List<AfterBookingFileListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingFileListVO> searchAfterBookingFileList(AfterBookingFileListVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingFileListVO> list = new ArrayList<AfterBookingFileListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {
				Map<String, String> mapVO = InputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingFileListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingFileListVO .class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	/**
	 * After Booking File Nmae 조회 <br>
	 * 
	 * @param String fileSavId
	 * @return List<AfterBookingFileListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingFileListVO> searchComUpldFile(String fileSavId) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingFileListVO> list = new ArrayList<AfterBookingFileListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (fileSavId != null) {

				param.put("file_sav_id", fileSavId);
								
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchComUpldFileRSQL(), param, param);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingFileListVO .class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * After Booking Expt Clr Rqst  조회 <br>
	 * 
	 * @param AfterBKGListVO InputVO
	 * @return List<AfterBookingExptClrRqstVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingExptClrRqstVO> searchAfterBookingExptClrRqst(AfterBKGListVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingExptClrRqstVO> list = new ArrayList<AfterBookingExptClrRqstVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {
				Map<String, String> mapVO = InputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingExptClrRqstRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingExptClrRqstVO .class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	


	/**
	 * After Booking FULL HISTORY 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingFullHistoryVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingFullHistoryVO> searchAfterBookingFullHistory(AfterBKGListInputVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingFullHistoryVO> list = new ArrayList<AfterBookingFullHistoryVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {
				Map<String, String> mapVO = InputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingFullHistoryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingFullHistoryVO .class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	


	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @return List<AfterBookingReasonDescVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingReasonDescVO> searchAfterBookingReasonDesc() throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingReasonDescVO> list = new ArrayList<AfterBookingReasonDescVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
							
			dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingReasonDescVO .class);

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingReasonDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingReasonDetailVO> searchAfterBookingReasonDetail(AfterBKGListInputVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingReasonDetailVO> list = new ArrayList<AfterBookingReasonDetailVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDetailRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingReasonDetailVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingReasonDescVO InputVO
	 * @return List<AfterBookingDetailReasonListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingDetailReasonListVO> searchAfterBookingDetailReasonList(AfterBookingReasonDescVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingDetailReasonListVO> list = new ArrayList<AfterBookingDetailReasonListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailReasonListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingDetailReasonListVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	


	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingPfmcListVO InputVO
	 * @return List<AfterBookingPfmcListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingPfmcListVO> searchAfterBookingPfmc(AfterBookingPfmcListVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingPfmcListVO> list = new ArrayList<AfterBookingPfmcListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingPfmcListVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingPfmcListVO InputVO
	 * @return List<AfterBookingPfmcListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingPfmcListVO> searchAfterBookingPfmcList(AfterBookingPfmcListVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingPfmcListVO> list = new ArrayList<AfterBookingPfmcListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingPfmcListVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	/**
	 * After Booking Approval Item List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingAproItmVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingAproItmVO> searchAfterBookingAproItm(AfterBKGListInputVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingAproItmVO> list = new ArrayList<AfterBookingAproItmVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproItmRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingAproItmVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * After Booking 컨테이너의 다건의 상세정보 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<ActualCostListVO> actualCostListVOs
	 * @throws DAOException
	 */
	public void modifyAfterBookingActualCost(List<ActualCostListVO> actualCostListVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(actualCostListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingActualCostUSQL(), actualCostListVOs, null);
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
	 * @param List<AfterBookingExptClrRqstVO> afterBookingExptClrRqstVOs
	 * @throws DAOException
	 */
	public void modifyAfterBookingExptClrRqst(List<AfterBookingExptClrRqstVO> afterBookingExptClrRqstVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingExptClrRqstVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingExptClrRqstUSQL(), afterBookingExptClrRqstVOs, null);
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
	 * @param List<AfterBookingFullHistoryVO> afterBookingFullHistoryVOs
	 * @throws DAOException
	 */
	public void modifyAfterBookingFullHIstory(List<AfterBookingFullHistoryVO> afterBookingFullHistoryVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingFullHistoryVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingFullHIstoryUSQL(), afterBookingFullHistoryVOs, null);
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
	 * @param List<AfterBookingFullHistoryVO> afterBookingFullHistoryVOs
	 * @throws DAOException
	 */
	public void removeAfterBookingFullHIstory(List<AfterBookingFullHistoryVO> afterBookingFullHistoryVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingFullHistoryVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAORemoveAfterBookingFullHIstoryDSQL(), afterBookingFullHistoryVOs, null);
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
	 * After Booking Reason Remark 저장. <br>
	 * 
	 * @param List<AfterBookingRsnRmkVO> afterBookingRsnRmks
	 * @throws DAOException
	 */
	public void modifyAfterBookingRsnRmk(List<AfterBookingRsnRmkVO> afterBookingRsnRmks) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingRsnRmks.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingRsnRmkUSQL(), afterBookingRsnRmks, null);
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
	 * After Booking Reason Remark 저장. <br>
	 * 
	 * @param List<AfterBookingRsnRmkVO> afterBookingRsnRmkVOs
	 * @throws DAOException
	 */
	public void removeAfterBookingRsnRmk(List<AfterBookingRsnRmkVO> afterBookingRsnRmkVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingRsnRmkVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAORemoveAfterBookingRsnRmkDSQL(), afterBookingRsnRmkVOs, null);
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
	 * After Booking Reason Remark 저장. <br>
	 * 
	 * @param List<AfterBookingFileListVO> afterBookingFileListVOs
	 * @throws DAOException
	 */
	public void modifyAfterBookingFileUpload(List<AfterBookingFileListVO> afterBookingFileListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingFileListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingFileUploadCSQL(), afterBookingFileListVOs, null);
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
	 * After Booking DAR 다건의 상세정보를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<AfterBookingFileListVO> afterBookingFileListVOs
	 * @throws DAOException
	 */
	public void removeBookingFileUpload(List<AfterBookingFileListVO> afterBookingFileListVOs) throws DAOException,Exception {	
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int delCnt[] = null;
			if(afterBookingFileListVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAORemoveAfterBookingFileUploadDSQL(), afterBookingFileListVOs, null);
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
	 * After Booking Detail 목록을 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AfterBookingDetailFlgVO> searchAfterBookingDetailFlg(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AfterBookingDetailFlgVO> list = null;
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailFlgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBookingDetailFlgVO .class);
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
	 * After Booking DAR 의 상태를 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void modifyAfterBookingAproItm(AfterProgressVO afterProgressVO) throws DAOException {
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
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproItmCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * After Booking DAR 의 상태를 수정 합니다. <br>
	 * 
	 * @paramAfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void modifyAfterBookingAproPath(AfterProgressVO afterProgressVO) throws DAOException {
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
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproPathCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * After Booking Approvl Path 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<CommentHistoryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public List<CommentHistoryVO> searchAproPath(AfterBKGListInputVO afterBKGListInputVO) throws DAOException {
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRSQL(), param, velParam);
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
	 * After Booking Path Code, Role Status Code 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingPathRole(AfterBKGListInputVO InputVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {
				Map<String, String> mapVO = InputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingPathRoleRSQL(), param, velParam);
			
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
	 * After Booking DAR 의 상태를 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void modifyAfterBookingApprovalStatus(AfterProgressVO afterProgressVO) throws DAOException {
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
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyAfterBookingApprovalStatushUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * After Booking Path Code, Role Status Code 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO paramVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExchangeRate(ChargeBookingContainerParmVO paramVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paramVO != null) {
				Map<String, String> mapVO = paramVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchExchangeRateRSQL(), param, velParam);
			
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
	 * After Booking Reason Remark 저장. <br>
	 * 
	 * @param AfterBookingPfmcListVO afterBookingPfmcListVO
	 * @throws DAOException
	 */
	public void removeAfterBookingPfmc(AfterBookingPfmcListVO afterBookingPfmcListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBookingPfmcListVO != null) {
				Map<String, String> mapVO = afterBookingPfmcListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAORemoveAfterBookingPfmcDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * After Booking Reason Remark 저장. <br>
	 * 
	 * @param List<AfterBookingPfmcListVO> afterBookingPfmcListVOs
	 * @throws DAOException
	 */
	public void addAfterBookingPfmc(List<AfterBookingPfmcListVO> afterBookingPfmcListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingPfmcListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOAddAfterBookingPfmcCSQL(), afterBookingPfmcListVOs, null);
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
	 * BKG/B/L No 의 Tariff Type 에 맞는 Location Code를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerVO chargeBookingContainerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingRsnVal(ChargeBookingContainerVO chargeBookingContainerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chargeBookingContainerVO != null) {
				Map<String, String> mapVO = chargeBookingContainerVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingRsnValRSQL(), param, velParam);
			
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
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingReasonDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingReasonDetailVO> searchAfterBookingReasonUcTtl(AfterBKGListInputVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingReasonDetailVO> list = new ArrayList<AfterBookingReasonDetailVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonUcTtlRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingReasonDetailVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	/**
	 * After Booking Reason Remark 저장. <br>
	 * 
	 * @param List<AfterBookingAproItmVO> afterBookingAproItmVO
	 * @throws DAOException
	 */
	public void modifyAfterBookingAproRmk(List<AfterBookingAproItmVO> afterBookingAproItmVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingAproItmVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproRmkUSQL(), afterBookingAproItmVO, null);
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
	 * After Booking DAR 의 상태를 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void modifyAfterUcCggPsblFlg(AfterProgressVO afterProgressVO) throws DAOException {
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
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyAfterUcCggPsblFlgUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * BKG No., B/L No. 에 해당되는 Yard Code 를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchUcCgoPsblFlg(AfterBKGListInputVO InputVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {
				Map<String, String> mapVO = InputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchUcCgoPsblFlgRSQL(), param, velParam);
			
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
	 * After Booking Mas 조회 <br>
	 * 
	 * @param AfterBookingMasListVO InputVO
	 * @return List<AfterBookingMasListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingMasListVO> searchAfterBookingMasList(AfterBookingMasListVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingMasListVO> list = new ArrayList<AfterBookingMasListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingMasListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingMasListVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	


	/**
	 * After Booking Mas 조회 <br>
	 * 
	 * @param AfterBookingMasListVO InputVO
	 * @return List<AfterBookingMasListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AfterBookingMasListVO> searchAfterBookingMasRqstList(AfterBookingMasListVO InputVO) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		List<AfterBookingMasListVO> list = new ArrayList<AfterBookingMasListVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (InputVO != null) {

				Map<String, String> mapVO = InputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
						ChargeAmountDiscountMgtDBDAOSearchAfterBookingMasRqstListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBookingMasListVO .class);
			}

		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * After Booking Mas 삭제 <br>
	 * 
	 * @param AfterBookingMasListVO afterBookingMasListVO
	 * @throws DAOException
	 */
	public void removeAfterBookingMasRqst(AfterBookingMasListVO afterBookingMasListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBookingMasListVO != null) {
				Map<String, String> mapVO = afterBookingMasListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAORemoveAfterBookingMasRqstDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * After Booking Mas 저장. <br>
	 * 
	 * @param List<AfterBookingMasListVO> afterBookingMasListVOs
	 * @throws DAOException
	 */
	public void addAfterBookingMasRqst(List<AfterBookingMasListVO> afterBookingMasListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if(afterBookingMasListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new ChargeAmountDiscountMgtDBDAOAddAfterBookingMasRqstCSQL(), afterBookingMasListVOs, null);
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
	 * BKG No., B/L No. 에 해당되는 Yard Code 를 조회 합니다. <br>
	 * 
	 * @param String vvdCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchAfterBookingVvdCd(String vvdCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (vvdCd != null) {			
				param.put("vvd_cd", vvdCd);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingVvdCdRSQL(), param, velParam);
			
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
	 * BKG No., B/L No. 에 해당되는 Yard Code 를 조회 합니다. <br>
	 * 
	 * @param String darNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchAfterBookingSubject(String darNo) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (darNo != null) {			
				param.put("dar_no", darNo);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchAfterBookingSubjectRSQL(), param, velParam);
			
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
	 * After Booking Requset & Approval Status를 조회합니다.<br>
	 * 
	 * @param AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO
	 * @param SignOnUserAccount account
	 * @return List<AfterBkgRqstAproStsVO>
	 * @throws DAOException
	 */
	public List<AfterBkgRqstAproStsVO> searchAfterBookingrRequestApprovalStatusList(AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO, SignOnUserAccount account) throws DAOException {
		
		DBRowSet dbRowSet = null;
		List<AfterBkgRqstAproStsVO> list = new ArrayList<AfterBkgRqstAproStsVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (afterBkgRqstAproStsParamVO != null) {
				Map<String, String> mapVO = afterBkgRqstAproStsParamVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				StringTokenizer tokenizer = null;
				String temp = null;
				
				// STS CD
				List<String> stsCdList = new ArrayList<String>();
				temp = afterBkgRqstAproStsParamVO.getRqstStsCd();
				tokenizer = new StringTokenizer(temp, ",");
			    while (tokenizer.hasMoreTokens()) {
			    	stsCdList.add(tokenizer.nextToken());
			    }
				velParam.put("sts_cd_list", stsCdList);
				
				// OFC CD
				List<String> ofcCdList = new ArrayList<String>();
				temp = afterBkgRqstAproStsParamVO.getOfcCd();
				tokenizer = new StringTokenizer(temp, ",");
			    while (tokenizer.hasMoreTokens()) {
			    	ofcCdList.add(tokenizer.nextToken());
			    }
				velParam.put("ofc_cd_list", ofcCdList);
				
				// TRF CD
				List<String> trfCdList = new ArrayList<String>();
				temp = afterBkgRqstAproStsParamVO.getTrfCd();
				tokenizer = new StringTokenizer(temp, ",");
			    while (tokenizer.hasMoreTokens()) {
			    	trfCdList.add(tokenizer.nextToken());
			    }
				velParam.put("trf_cd_list", trfCdList);
				
				// DAR NO
				List<String> darNoList = new ArrayList<String>();
				temp = afterBkgRqstAproStsParamVO.getDarNo();
				tokenizer = new StringTokenizer(temp, ",");
				while (tokenizer.hasMoreTokens()) {
					darNoList.add(tokenizer.nextToken());
				}
				velParam.put("dar_no_list", darNoList);
				
				// APVL NO
				List<String> apvlNoList = new ArrayList<String>();
				temp = afterBkgRqstAproStsParamVO.getApvlNo();
				tokenizer = new StringTokenizer(temp, ",");
				while (tokenizer.hasMoreTokens()) {
					apvlNoList.add(tokenizer.nextToken());
				}
				velParam.put("apvl_no_list", apvlNoList);
				
				// BKG NO
				List<String> bkgNoList = new ArrayList<String>();
				temp = afterBkgRqstAproStsParamVO.getBkgNo();
				tokenizer = new StringTokenizer(temp, ",");
				while (tokenizer.hasMoreTokens()) {
					bkgNoList.add(tokenizer.nextToken());
				}
				velParam.put("bkg_no_list", bkgNoList);
				
				// BL NO
				List<String> blNoList = new ArrayList<String>();
				temp = afterBkgRqstAproStsParamVO.getBlNo();
				tokenizer = new StringTokenizer(temp, ",");
				while (tokenizer.hasMoreTokens()) {
					blNoList.add(tokenizer.nextToken());
				}
				velParam.put("bl_no_list", blNoList);
				
				// SC NO
				if(null != afterBkgRqstAproStsParamVO.getScNo()) {
					List<String> scNoList = new ArrayList<String>();
					temp = afterBkgRqstAproStsParamVO.getScNo();
					tokenizer = new StringTokenizer(temp, ",");
					while (tokenizer.hasMoreTokens()) {
						scNoList.add(tokenizer.nextToken());
					}
					velParam.put("sc_no_list", scNoList);	
				}
				
				// RFA NO
				if(null != afterBkgRqstAproStsParamVO.getRfaNo()) {
					List<String> rfaNoList = new ArrayList<String>();
					temp = afterBkgRqstAproStsParamVO.getRfaNo();
					tokenizer = new StringTokenizer(temp, ",");
					while (tokenizer.hasMoreTokens()) {
						rfaNoList.add(tokenizer.nextToken());
					}
					velParam.put("rfa_no_list", rfaNoList);	
				}				
				
				// TAA NO
				if(null != afterBkgRqstAproStsParamVO.getTaaNo()) {
					List<String> taaNoList = new ArrayList<String>();
					temp = afterBkgRqstAproStsParamVO.getTaaNo();
					tokenizer = new StringTokenizer(temp, ",");
					while (tokenizer.hasMoreTokens()) {
						taaNoList.add(tokenizer.nextToken());
					}
					velParam.put("taa_no_list", taaNoList);
				}				
				
				// User ID & User Office
				velParam.put("usr_id", account.getUsr_id());
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_ofc", account.getOfc_cd());
				param.put("usr_ofc", account.getOfc_cd());
				
				dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeAmountDiscountMgtDBDAOSearchAfterBookingrRequestApprovalStatusListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AfterBkgRqstAproStsVO.class);
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
	 * After Booking Mas 저장. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @throws DAOException
	 */
	public void modifyApprovalAfterBookingContainer(AfterProgressVO afterProgressVO) throws DAOException,Exception {
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
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeAmountDiscountMgtDBDAOModifyApprovalAfterBookingContainerUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking Office Code Check 로직 조회 <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcChkFlg() throws DAOException,Exception {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					ChargeAmountDiscountMgtDBDAOSearchOfcChkFlgRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			else {
				result = "N";
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

