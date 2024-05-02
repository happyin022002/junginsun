/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeRequestDBDAO.java
*@FileTitle : EQ Interchange Request
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2015.05.21 길정권
* 1.0 Creation
2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.AvailableOnewayInventoryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeReqVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchOfferInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeSummaryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS EqInterchangeRequestDBDAO <br>
 * - ALPS-EqInterchangeRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jikkil
 * @see EqInterchangeRequestBCImpl 참조
 * @since J2EE 1.6
 */
public class EqInterchangeRequestDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PAGE_SIZE_1000  =  1000;	
	//
	/**
	 * EQ Interchange Request 작업 목록을 조회합니다.<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqInterchangeReqVO> searchEqInterchangeRequestData(EqInterchangeReqVO eqInterchangeReqVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<EqInterchangeReqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrCntrTpszCd = null;

		try{
			if(eqInterchangeReqVO != null){
				Map<String, String> mapVO = eqInterchangeReqVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        if ( !JSPUtil.getNull(eqInterchangeReqVO.getTpszCd()).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(eqInterchangeReqVO.getTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
		        
			}

			dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchEqInterchangeRequestDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqInterchangeReqVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EQ Interchange Request 자료를 LSE_EQ_ITCHG_RQST Table에 Insert 한다.<br>
	 *
	 * @param EqInterchangeReqVO eqInterchangeReqVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addEqInterchangeReqVO(EqInterchangeReqVO eqInterchangeReqVOs) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = eqInterchangeReqVOs.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOEqInterchangeRequestDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	
	
	/**
	 * EQ Interchange Request를 업데이트한다. <br>
	 *
	 * @param EqInterchangeReqVO eqInterchangeReqVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateEqInterchangeReqVO(EqInterchangeReqVO eqInterchangeReqVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = eqInterchangeReqVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOEqInterchangeRequestDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EES_LSE_0107 : EQ Interchange Request를 다건 삭제합니다.<br>
	 *
	 * @param EqInterchangeReqVO eqInterchangeReqVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void removeEqInterchangeReqVOs(EqInterchangeReqVO eqInterchangeReqVOs) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = eqInterchangeReqVOs.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOEqInterchangeRequestDataDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	

	/**
	 * 신규 Request Number를 조회합니다.<br>
	 *
	 * @param  String lstmCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchEqInterchangeReqNo(String lstmCd) throws DAOException {
		String reqNo = "";
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
	    	param.put("lstm_cd", lstmCd);
			velParam.put("lstm_cd", lstmCd);

			dbRowset = new SQLExecuter().executeQuery(new EqInterchangeDBDAOEqInterchangeRequestNoMakeRSQL(), param, velParam);
			if(dbRowset.next()) {
				reqNo = dbRowset.getString("req_no");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return reqNo;
	}
	
	
	/**
	 * EMU Cost를 조회합니다.<br>
	 *
	 * @param  String loc_tp
	 * @param  String org_dest_cd
	 * @param  String cntr_tpsz_cd
	 * @param  String loc_cd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchEmuCost(String loc_tp , String org_dest_cd , String cntr_tpsz_cd , String loc_cd) throws DAOException {
		String emuCost = "";
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
	    	param.put("loc_tp", loc_tp);
			velParam.put("loc_tp", loc_tp);
			param.put("org_dest_cd", org_dest_cd);
			velParam.put("org_dest_cd", org_dest_cd);
			param.put("cntr_tpsz_cd", cntr_tpsz_cd);
			velParam.put("cntr_tpsz_cd", cntr_tpsz_cd);
			param.put("loc_cd", loc_cd);
			velParam.put("loc_cd", loc_cd);
			

			dbRowset = new SQLExecuter().executeQuery(new EqInterchangeRequestDBDAOSearchEMUCostRSQL(), param, velParam);
			if(dbRowset.next()) {
				emuCost = dbRowset.getString("CALCU_TTL");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return emuCost;
	}
	
	//
	/**
	 * EQ Interchange Request 작업 목록을 조회합니다.<br>
	 * combo list을 윈한 Req No 조회 
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqInterchangeReqVO> searchEqInterchangeReqNumberData(EqInterchangeReqVO eqInterchangeReqVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<EqInterchangeReqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eqInterchangeReqVO != null){
				Map<String, String> mapVO = eqInterchangeReqVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

		dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchEqInterchangeReqNumberDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqInterchangeReqVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 신규 Auth Number를 조회합니다.<br>
	 *
	 * @param  String locCd 
	 * @param  String lstmCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchEqInterchangeAuthNo(String locCd, String lstmCd) throws DAOException {
		String authNo = "";
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
	    	param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
	    	param.put("lstm_cd", lstmCd);
			velParam.put("lstm_cd", lstmCd);

			dbRowset = new SQLExecuter().executeQuery(new EqInterchangeDBDAOEqInterchangeAuthNoMakeRSQL(), param, velParam);
			if(dbRowset.next()) {
				authNo = dbRowset.getString("auth_no");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return authNo;
	}	
	
	/**
	 * EQ Interchange Approval 자료를 LSE_EQ_ITCHG Table에 Insert 한다.<br>
	 *
	 * @param EqInterchangeReqVO eqInterchangeReqVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addEqInterchangeApprovalVO(EqInterchangeReqVO eqInterchangeReqVOs) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = eqInterchangeReqVOs.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOEqInterchangeApprovalDataUSQL(), param, velParam);
			result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOEqInterchangeApprovalDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	//
	/**
	 * EQ Interchange Update 작업 목록을 조회합니다.<br>
	 *
	 * @param  EqInterchangeVO eqInterchangeVO
	 * @return List<EqInterchangeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqInterchangeVO> searchEqInterchangeUpdateData(EqInterchangeVO eqInterchangeVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<EqInterchangeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrCntrTpszCd = null;
		try{
			if(eqInterchangeVO != null){
				Map<String, String> mapVO = eqInterchangeVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
		        
		        if ( !JSPUtil.getNull(eqInterchangeVO.getTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(eqInterchangeVO.getTpszCd(),",","|"));
					log.info("=====tpsz===" + arrCntrTpszCd);
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchEqInterchangeUpdateDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqInterchangeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
 //
	/**
	 * EQ Interchange Update 작업 목록을 조회합니다.<br>
	 * combo list을 윈한 Auth No 조회 
	 * @param  EqInterchangeVO eqInterchangeVO
	 * @return List<EqInterchangeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqInterchangeVO> searchEqInterchangeAuthNumberData(EqInterchangeVO eqInterchangeVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<EqInterchangeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eqInterchangeVO != null){
				Map<String, String> mapVO = eqInterchangeVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

		dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOSearchEqInterchangeAuthNumberDataRSQL(), param, velParam);
		list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqInterchangeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
 /**
	 * EQ Interchange Update를 업데이트한다. <br>
	 *
	 * @param EqInterchangeVO EqInterchangeVOS
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateEqInterchangeUpdate(EqInterchangeVO EqInterchangeVOS) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = EqInterchangeVOS.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOUpdateEqInterchangeUpdateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

 /**
	 * EQ Interchange Update를  Auth No Cancel 한다. <br>
	 *
	 * @param EqInterchangeVO EqInterchangeVOS 
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateEqInterchangeAuthNoCancel(EqInterchangeVO EqInterchangeVOS) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = EqInterchangeVOS.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOUpdateEqInterchangeAuthNoCancelUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	}
	
	 /**
	 * EQ Interchange Update를 Req No 를Cancel 한다. <br>
	 *
	 * @param EqInterchangeVO EqInterchangeVOS
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateEqInterchangeReqNoCancel(EqInterchangeVO EqInterchangeVOS) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = EqInterchangeVOS.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOUpdateEqInterchangeReqNoCancelUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			}
	
	/**
	 * EQ Interchange Approval 작업 목록을 조회합니다.<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqInterchangeReqVO> searchEqInterchangeApprovalData(EqInterchangeReqVO eqInterchangeReqVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<EqInterchangeReqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrCntrTpszCd = null;

		try{
			if(eqInterchangeReqVO != null){
				Map<String, String> mapVO = eqInterchangeReqVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        if ( !JSPUtil.getNull(eqInterchangeReqVO.getTpszCd()).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(eqInterchangeReqVO.getTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
		        
			}

			dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchEqInterchangeApprovalDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqInterchangeReqVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	 //
		/**
		 * EQ Interchange offer inquiry 조회.<br>
		 *  
		 * @param  SearchOfferInquiryVO searchOfferInquiryVO
		 * @return List<SearchOfferInquiryVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchOfferInquiryVO> searchOfferInquiryData(SearchOfferInquiryVO searchOfferInquiryVO) throws DAOException {
	
			DBRowSet dbRowset = null;
			List<SearchOfferInquiryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			List<String> arrCntrTpszCd = null;
			try{
				if(searchOfferInquiryVO != null){
					Map<String, String> mapVO = searchOfferInquiryVO.getColumnValues();
	
			        param.putAll(mapVO);
			        velParam.putAll(mapVO);
			        String period_stdt = searchOfferInquiryVO.getPeriodStdt();
		            period_stdt = period_stdt.replaceAll("-", "");
		            String period_eddt = searchOfferInquiryVO.getPeriodEddt();
		            period_eddt = period_eddt.replaceAll("-", "");

		            param.put("period_stdt"       , period_stdt);
		            param.put("period_eddt"       , period_eddt);
		            
			        if ( !JSPUtil.getNull(searchOfferInquiryVO.getTpszCd()).equals("") ) {
			        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchOfferInquiryVO.getTpszCd(),",","|"));
						param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
						velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					}
				}
	
			dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchOfferInquiryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfferInquiryVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		 
			/**
		     * EQ interchange pick-up/off-hire 현황목록을 조회합니다.<br>
			 *
			 * @param  SearchParamVO searchParamVO
			 * @return List<EqInterchangeSummaryVO>
			 * @throws DAOException
			 */
		    @SuppressWarnings("unchecked")
		    public List<EqInterchangeSummaryVO> searchEqInterchangeSummaryListData(SearchParamVO searchParamVO) throws DAOException {

			    DBRowSet dbRowset = null;
			    List<EqInterchangeSummaryVO> list = null;
			    //query parameter
			    Map<String, Object> param = new HashMap<String, Object>();
			    //velocity parameter
			    Map<String, Object> velParam = new HashMap<String, Object>();

			    try{
			    	if(searchParamVO != null){
				        Map<String, String> mapVO = searchParamVO.getColumnValues();

				        param.putAll(mapVO);
				        velParam.putAll(mapVO);
				       
				        List<String> arrCntrTpszCd = null;

				        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
				        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
				        	param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				        	velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				        }
			    	}

			    	dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchEqInterchangeSummaryListRSQL(), param, velParam);
			    	list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqInterchangeSummaryVO.class);
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
		     * EQ interchange pick-up/off-hire 전체건수를 조회합니다.<br>
		     *
		     * @param  SearchParamVO searchParamVO
		     * @return int
		     * @throws DAOException
		     */
		    @SuppressWarnings("unchecked")
		    public int searchEqInterchangeContainerCountData(SearchParamVO searchParamVO) throws DAOException {

		    	int totalCnt = 0;
			    DBRowSet dbRowset = null;
			    //query parameter
			    Map<String, Object> param = new HashMap<String, Object>();
			    //velocity parameter
			    Map<String, Object> velParam = new HashMap<String, Object>();

			    try{
			    	if(searchParamVO != null){
			    		Map<String, String> mapVO = searchParamVO.getColumnValues();

				        param.putAll(mapVO);
				        velParam.putAll(mapVO);

				        List<String> arrCntrTpszCd = null;

				        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
				        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
				        	param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				        	velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				        }
			    	}

			    	dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchEqInterchangeContainerCountRSQL(), param, velParam);
			    	if(dbRowset.next()) {
			    		totalCnt = dbRowset.getInt("TOTAL_CNT");
			    	}
			    }catch(SQLException se){
			    	log.error(se.getMessage(),se);
			    	throw new DAOException(new ErrorHandler(se).getMessage());
			    }catch(Exception ex){
			    	log.error(ex.getMessage(),ex);
			    	throw new DAOException(new ErrorHandler(ex).getMessage());
			    }

			    return totalCnt;
		    }

		    /**
		     * EQ interchange pick-up/off-hire 장비의 상세내역을 조회합니다.<br>
		     *
		     * @param  SearchParamVO searchParamVO
		     * @return List<SubLeaseOutDetailVO>
		     * @throws DAOException
		     */
		    @SuppressWarnings("unchecked")
		    public List<EqInterchangeDetailVO> searchEqInterchangeContainerDetailData(SearchParamVO searchParamVO) throws DAOException {
		    	int currentPage = 1; //Integer.parseInt(searchParamVO.getIpage());
		   	    int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
		   	    int endNo   = PAGE_SIZE_1000 *  currentPage;

			    DBRowSet dbRowset = null;
			    List<EqInterchangeDetailVO> list = null;
			    //query parameter
			    Map<String, Object> param = new HashMap<String, Object>();
			    //velocity parameter
			    Map<String, Object> velParam = new HashMap<String, Object>();

			    try{
			    	if(searchParamVO != null){
			    		Map<String, String> mapVO = searchParamVO.getColumnValues();

				        param.putAll(mapVO);
				        param.put("startno", startNo);
						param.put("endno", endNo);
				        velParam.putAll(mapVO);
				        velParam.put("startno", startNo);
				        velParam.put("endno", endNo);

				        List<String> arrCntrTpszCd = null;

				        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
				        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
				        	param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				        	velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				        }
			    	}

			    	dbRowset = new SQLExecuter("").executeQuery(new EqInterchangeDBDAOsearchEqInterchangeContainerDetailRSQL(), param, velParam);
			    	list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqInterchangeDetailVO.class);
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
			 * 신규 Request Sequence를 조회합니다.<br>
			 *
			 * @param  String comboReqNo
			 * @return String
			 * @throws DAOException
			 * @throws Exception
			 */
			public String searchEqInterchangeSetReqSeq(String comboReqNo) throws DAOException {
				String reqSeq = "";
			    DBRowSet dbRowset = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try {
			    	param.put("combo_req_no", comboReqNo);
					velParam.put("combo_req_no", comboReqNo);

					dbRowset = new SQLExecuter().executeQuery(new EqInterchangeDBDAOEqInterchangeRequestSequenceRSQL(), param, velParam);
					if(dbRowset.next()) {
						reqSeq = dbRowset.getString("req_seq");
			    	}
			    } catch(SQLException se) {
			    	log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(ex.getMessage());
				}

				return reqSeq;
			}
						 
				/**
				 * Available Oneway Inventory 조회<br>
				 * 
	             * @param String locFmTp
	             * @param String locFm
	             * @param String dpsl
	             * @param String orgCntrTpszCd
	             * @param String trd
	             * @param String locTp
	             * @param String locTo
	             * @param String sts
	             * @param String stay
	             * @param String dys
	             * @param String agmtSeq
	             * @param String vndrSeq
			     * @return List<AvailableOnewayInventoryVO>
				 * @throws DAOException
				 */
				 @SuppressWarnings("unchecked")
				public List<AvailableOnewayInventoryVO> searchAvailableOnewayListBasic(String locFmTp,String locFm,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String sts,String stay,String dys,String agmtSeq,String vndrSeq) throws DAOException {
					DBRowSet dbRowset = null;
					List<AvailableOnewayInventoryVO> list = null;
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();

					try{
						param.put("loc_fm_tp",	locFmTp);
						param.put("loc_fm",		locFm);
						param.put("dpsl",		dpsl);
						param.put("trd",		trd);	
						param.put("loc_tp",	locTp);
						param.put("loc_to",		locTo);
						param.put("sts",		sts);
						param.put("stay",		stay);
						param.put("dys",		    dys);
						param.put("agmt_seq",		agmtSeq);
						param.put("vndr_seq",		    vndrSeq);
						
						List<String> arrCntrTpszCd = null;
						
						if ( !JSPUtil.getNull(orgCntrTpszCd).equals("") ) {
							arrCntrTpszCd = JSPUtil.convertStringToArrayList(orgCntrTpszCd);
							param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
						}
						
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EqInterchangeDBDAOAvailableOnewayListRSQL(), param, param);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOnewayInventoryVO.class);
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
					 * Available Oneway Inventory 조회<br>
					 * 
			         * @param String locFmTp
			         * @param String locFm
			         * @param String dpsl
			         * @param String orgCntrTpszCd
			         * @param String trd
			         * @param String locTp
			         * @param String locTo
			         * @param String sts
			         * @param String stay
			         * @param String dys
			         * @param String agmtSeq
			         * @param String vndrSeq
					 * @return List<AvailableOnewayInventoryVO>
					 * @throws DAOException
					 */
					 @SuppressWarnings("unchecked")
					public List<AvailableOnewayInventoryVO> searchAvailableOnewaySummaryData(String locFmTp,String locFm,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String sts,String stay,String dys,String agmtSeq,String vndrSeq) throws DAOException {
						DBRowSet dbRowset = null;
						List<AvailableOnewayInventoryVO> list = null;
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();

						try{
							param.put("loc_fm_tp",	locFmTp);
							param.put("loc_fm",		locFm);
							param.put("dpsl",		dpsl);
							param.put("trd",		trd);	
							param.put("loc_tp",	locTp);
							param.put("loc_to",		locTo);
							param.put("sts",		sts);
							param.put("stay",		stay);
							param.put("dys",		    dys);
							param.put("agmt_seq",		agmtSeq);
							param.put("vndr_seq",		    vndrSeq);
							
							List<String> arrCntrTpszCd = null;
							
							if ( !JSPUtil.getNull(orgCntrTpszCd).equals("") ) {
								arrCntrTpszCd = JSPUtil.convertStringToArrayList(orgCntrTpszCd);
								param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
							}
							
							dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EqInterchangeDBDAOAvailableOnewaySummaryRSQL(), param, param);
							list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOnewayInventoryVO.class);
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
						 * Oneway Loading PFMC 조회<br>
						 * 
					     * @param String period
					     * @param String froms
					     * @param String dpsl
					     * @param String orgCntrTpszCd
					     * @param String trd
					     * @param String locTp
					     * @param String locTo
					     * @param String tos
					     * @param String delDol
					     * @param String porDol
					     * @param String ifFlg
					     * @param String mvmt
						 * @return List<AvailableOnewayInventoryVO>
						 * @exception EventException
						 */
						 @SuppressWarnings("unchecked")
						public List<AvailableOnewayInventoryVO> searchOnewayLoadingPFMCSSummaryData(String period,String froms,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String tos,String delDol,String porDol,String ifFlg,String mvmt) throws DAOException {
							DBRowSet dbRowset = null;
							List<AvailableOnewayInventoryVO> list = null;
							//query parameter
							Map<String, Object> param = new HashMap<String, Object>();

							try{
								
								froms = froms.replaceAll("-", "");
								tos = tos.replaceAll("-", "");
								
								param.put("period",	period);
								param.put("froms",		froms);
								param.put("dpsl",		dpsl);
								param.put("trd",		trd);	
								param.put("loc_tp",	    locTp);
								param.put("loc_to",		locTo);
								param.put("tos",		tos);
								param.put("del_dol",    delDol);
								param.put("por_dol",	porDol);
								param.put("if_flg",   ifFlg);
								param.put("mvmt",	mvmt);

								
								List<String> arrCntrTpszCd = null;
								
								if ( !JSPUtil.getNull(orgCntrTpszCd).equals("") ) {
									arrCntrTpszCd = JSPUtil.convertStringToArrayList(orgCntrTpszCd);
									param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
								}
								
								dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EqInterchangeDBDAOOnewayLoadingPFMCSummaryRSQL(), param, param);
								list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOnewayInventoryVO.class);
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
							 * Oneway Loading PFMC 조회<br>
							 * 
						     * @param String period
						     * @param String froms
						     * @param String dpsl
						     * @param String orgCntrTpszCd
						     * @param String trd
						     * @param String locTp
						     * @param String locTo
						     * @param String tos
						     * @param String delDol
						     * @param String porDol
						     * @param String ifFlg
						     * @param String mvmt
							 * @return List<AvailableOnewayInventoryVO>
							 * @exception EventException
							 */
							 @SuppressWarnings("unchecked")
							public List<AvailableOnewayInventoryVO> searchOnewayLoadingPFMCSListData(String period,String froms,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String tos,String delDol,String porDol,String ifFlg,String mvmt) throws DAOException {
								DBRowSet dbRowset = null;
								List<AvailableOnewayInventoryVO> list = null;
								//query parameter
								Map<String, Object> param = new HashMap<String, Object>();

								try{
									
									froms = froms.replaceAll("-", "");
									tos = tos.replaceAll("-", "");
									
									param.put("period",	period);
									param.put("froms",		froms);
									param.put("dpsl",		dpsl);
									param.put("trd",		trd);	
									param.put("loc_tp",	    locTp);
									param.put("loc_to",		locTo);
									param.put("tos",		tos);
									param.put("del_dol",    delDol);
									param.put("por_dol",	porDol);
									param.put("if_flg",   ifFlg);
									param.put("mvmt",	mvmt);

									
									List<String> arrCntrTpszCd = null;
									
									if ( !JSPUtil.getNull(orgCntrTpszCd).equals("") ) {
										arrCntrTpszCd = JSPUtil.convertStringToArrayList(orgCntrTpszCd);
										param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
									}
									
									dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EqInterchangeDBDAOOnewayLoadingPFMCListRSQL(), param, param);
									list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOnewayInventoryVO.class);
								}catch(SQLException se){
									log.error(se.getMessage(),se);
									throw new DAOException(new ErrorHandler(se).getMessage());
								}catch(Exception ex){
									log.error(ex.getMessage(),ex);
									throw new DAOException(new ErrorHandler(ex).getMessage());
								}
								return list;
							}
							 
								/** EES_MST_0113 : save <br>
								 * LSE_ONEWAY_LOAD_PFMC를 수정합니다.<br> 
								 * @author DOO KI MIN
								 * @category EES_MST_0113
								 * @category modifyLseOnewayLoadPFMCData    
								 * @param AvailableOnewayInventoryVO availableOnewayInventoryVO
								 * @exception DAOException
								 * @exception Exception 
								 */	
								public void modifyLseOnewayLoadPFMCData(AvailableOnewayInventoryVO availableOnewayInventoryVO) throws DAOException {
									//query parameter
									Map<String, Object> param = new HashMap<String, Object>();
									//velocity parameter
									Map<String, Object> velParam = new HashMap<String, Object>();
									try {
										Map<String, String> mapVO = availableOnewayInventoryVO.getColumnValues();
										param.putAll(mapVO);
										velParam.putAll(mapVO);
										
										SQLExecuter sqlExe = new SQLExecuter("");
										int result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOLseOnewayLoadPFMCDUSQL(), param, velParam);
										if(result == Statement.EXECUTE_FAILED)
											throw new DAOException("Fail to insert SQL");

									} catch(SQLException se) {
										log.error(se.getMessage(),se);
										throw new DAOException(new ErrorHandler(se).getMessage());
									} catch(Exception ex) {
										log.error(ex.getMessage(),ex);
										throw new DAOException(new ErrorHandler(ex).getMessage());
									}
								
								}
								
								/** EES_MST_0113 : save <br>
								 * LSE_ONEWAY_LOAD_PFMC를 수정합니다.<br> 
								 * @author DOO KI MIN
								 * @category EES_MST_0113
								 * @category modifyMasOffhBkgListData    
								 * @param AvailableOnewayInventoryVO availableOnewayInventoryVO
								 * @exception DAOException
								 * @exception Exception 
								 */									
								public void modifyMasOffhBkgListData(AvailableOnewayInventoryVO availableOnewayInventoryVO) throws DAOException {
									//query parameter
									Map<String, Object> param = new HashMap<String, Object>();
									//velocity parameter
									Map<String, Object> velParam = new HashMap<String, Object>();
									try {
										Map<String, String> mapVO = availableOnewayInventoryVO.getColumnValues();
										param.putAll(mapVO);
										velParam.putAll(mapVO);
										
										SQLExecuter sqlExe = new SQLExecuter("");
										int result = sqlExe.executeUpdate((ISQLTemplate)new EqInterchangeDBDAOMasOffhBkgListUSQL(), param, velParam);
										if(result == Statement.EXECUTE_FAILED)
											throw new DAOException("Fail to insert SQL");

									} catch(SQLException se) {
										log.error(se.getMessage(),se);
										throw new DAOException(new ErrorHandler(se).getMessage());
									} catch(Exception ex) {
										log.error(ex.getMessage(),ex);
										throw new DAOException(new ErrorHandler(ex).getMessage());
									}
								
								}
}
