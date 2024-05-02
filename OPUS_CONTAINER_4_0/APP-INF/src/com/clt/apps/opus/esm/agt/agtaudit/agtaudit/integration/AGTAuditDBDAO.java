/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTAuditDBDAO.java
*@FileTitle : Agent Commission Audit Management Service Command
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.06 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAOSearchApPayInvDtlRSQL;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAOSearchApPayInvRSQL;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.basic.AGTAuditBCImpl;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommTobeApproved1VO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTVVDRateVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceDetailVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceMasterVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgentActualINFtoAPCheckVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtApPayInvVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommBasicInformationVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtRptItmInfoMstDtlVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.BkgAgnCommDeductionRatingVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.BkgAgtChgDdctVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionDtrbVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionHdrVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.DeductionChargeVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.GrsNetCDVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.InterfaceCancelVO;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.AgtAgnCommDtlVO;
import com.clt.syscommon.common.table.AgtAgnCommVO;
import com.clt.syscommon.common.table.AgtCommBkgInfoVO;
import com.clt.syscommon.common.table.AgtRptItmInfoDtlVO;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * OPUS AGTAuditDBDAO <br>
 * - OPUS-AGTAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *  
 * @author Lee Ho Jin
 * @see AGTAuditBCImpl 참조
 * @since J2EE 1.6
 */
public class AGTAuditDBDAO extends DBDAOSupport {
	/**
	 * (ESM_AGT_0010) Agent Commission Maintenance & Request의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtCommListVO> searchAGTCommForRequest(AgtCommListVO agtCommListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCommListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchAGTCommForRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCommListVO .class);
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
	 * (ESM_AGT_010) Agent Commission Maintenance & Request 의 agn_cd에 따른 LocalDate 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnCommVO> searchLocalDate(AgtCommListVO agtCommListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchLocalDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
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
	 * (ESM_AGT_010) Agent Commission Maintenance & Request 의 Request를 위한 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnCommVO> searchModifyAGTCommForRequest(AgtAgnCommVO agtAgnCommVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommForRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
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
	 * ESM_AGT_010) Agent Commission Maintenance & Request 의 Master 정보를 수정한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommForRequest (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommForRequestUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * (ESM_AGT_010) Agent Commission Maintenance & Request 의 Master 정보를 수정한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommForRequestDtl (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommForRequestDtlUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}


	/**
	 * (ESM_AGT_010) Agent Commission Maintenance & Request 의 Request를 위한 EDI 정보를 조회한다.<br>
	 * 
	 * @param String sEdiRequestBkg
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchModifyAGTCommForRequestEdi(String sEdiRequestBkg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sEdiRequestBkg != null && sEdiRequestBkg != ""){
				param.put("bkg_no", sEdiRequestBkg);
				velParam.put("bkg_no", sEdiRequestBkg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommForRequestEdiRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	

	/**
	 * (ESM_AGT_010) Agent Commission Maintenance & Request 의 Request를 위한 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnCommVO> searchModifyAGTCommExRateByRequest(AgtAgnCommVO agtAgnCommVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommExRateForRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
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
	 * (ESM_AGT_010) Agent Commission Maintenance & Request 의 Master 정보를 수정한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommExRateByRequest (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommExRateForRequestUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	
	/**
	 * (ESM_AGT_010) Agent Commission Maintenance & Request 의 Detail 정보를 수정한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommExRateByRequestDtl (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommExRateForRequestDtlUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	
	/**
	 * ESM_AGT_0011 화면 대한 Calculation History 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnCommVO> searchAGTCommCalculationHistory(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(velParam);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAOCalculationHistoryVORSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnCommVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_0011 화면 대한 Commission Detail Amount 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnCommVO> searchAGTCommCommissionDetailAmount(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAOCommissionDetailAmountVORSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnCommVO.class);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * ESM_AGT_0011 화면 대한 TP/SZ QTY 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgQuantityVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BkgQuantityVO> searchAGTCommDetailTypeSizeQty(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
	    DBRowSet dbRowSet = null;
	    List<BkgQuantityVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	    	if(agtAgnCommVO != null){
	    		Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
	    		param.putAll(mapVO);
	    		velParam.putAll(mapVO);
	    	}
	    	dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAOTypeSizeQtyVORSQL(), param, velParam);
	    	list = (List) RowSetUtil.rowSetToVOs(dbRowSet, BkgQuantityVO.class);
	    }catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * ESM_AGT_0011 화면 대한 Basic Information 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtCommBasicInformationVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtCommBasicInformationVO> searchAGTCommBasicInformation(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<AgtCommBasicInformationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (agtAgnCommVO != null) {
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAOBasicInformationVORSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtCommBasicInformationVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_0012 화면의 Rating 정보 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionRating(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<BkgAgnCommDeductionRatingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAODeductionRatingVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,BkgAgnCommDeductionRatingVO.class);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_0012 화면 대한 Total 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotal(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<BkgAgnCommDeductionRatingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAODeductionTotalVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, BkgAgnCommDeductionRatingVO.class);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_0012 화면 대한 Total info 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws DAOException
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotalInfo(AgtAgnCommVO agtAgnCommVO) throws DAOException{
		DBRowSet dbRowSet = null;
		List<BkgAgnCommDeductionRatingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAODeductionTotalInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, BkgAgnCommDeductionRatingVO.class);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_0012 화면 대한 Deducted Charge 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgtChgDdctVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BkgAgtChgDdctVO> searchAGTCommDeductionCharge(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<BkgAgtChgDdctVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAODeductionChargeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, BkgAgtChgDdctVO.class);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_0012 화면 대한 Deducted Transportation Cost 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<DeductionChargeVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<DeductionChargeVO> searchAGTCommDeductionTrspCost(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<DeductionChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAODeductionTrspCostVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, DeductionChargeVO.class);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_0012 화면 대한 Gross / Net, Net Ocean Revenue 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<GrsNetCDVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<GrsNetCDVO> searchAGTCommGrsNetCD(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<GrsNetCDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCommDBDAOGrsNetCDVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, GrsNetCDVO.class);
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	 /**
	 * (ESM_AGT_016) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 */
	public List<AgtAgnCommVO> searchOtherCommforApproval(AgtAgnCommVO agtAgnCommVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAgtAgnCommVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
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
	 * (ESM_AGT_016) Other Commission Approval의 정보를 수정한다.<br> 
	 * @param List<AgtAgnCommVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	 public int[] modifymultiOtherCommforApproval(List<AgtAgnCommVO> updModels) throws DAOException,Exception{
		 int updCnt[] = null;
		 try{
				SQLExecuter sqlExe = new SQLExecuter("");
				if(updModels.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTAuditDBDAOAgtAgnCommVOUSQL(), updModels,null);
					log.info(updCnt.length);
					for(int i=0; i<updCnt.length;i++){
						if(updCnt[i] == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
				}
			}catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 return updCnt;
		 
	 }
	 /**
	  *(ESM_AGT_016) Other Commission Approval의 Detail 정보를 수정한다.<br> 
	  * @param List<AgtAgnCommDtlVO> updModels
	  * @return int[] 
	  * @throws DAOException
	  * @throws Exception
	  */
	 public int[] multiOtherCommforApprovalDtl(List<AgtAgnCommDtlVO> updModels) throws DAOException, Exception{
		 int updCnt[] = null;
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
				if(updModels.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTAuditDBDAOAgtAgnCommdtlVOUSQL(), updModels,null);
					log.info(updCnt.length);
					for(int i=0; i<updCnt.length;i++){
						if(updCnt[i] == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
				}
		 }catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 return updCnt;
	 }
	 /**
	  * (ESM_AGT_016) Other Commission Approval의 정보를 Reject 한다.<br> 
	  * @param List<AgtAgnCommVO> updModels
	  * @return int[]
	  * @throws DAOException
	  * @throws Exception
	  */
	 public int[] modifymultiOtherCommforApprovalReject(List<AgtAgnCommVO> updModels) throws DAOException,Exception{
		 int updCnt[] = null;
		 try{
				SQLExecuter sqlExe = new SQLExecuter("");
				if(updModels.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTAuditDBDAOAgtAgnCommRejectVOUSQL(), updModels,null);
					log.info(updCnt.length);
					for(int i=0; i<updCnt.length;i++){
						if(updCnt[i] == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
				}
			}catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 return updCnt;
	 }
	 /**
	  * (ESM_AGT_016) Other Commission Approval의 정보를 Cancel 한다. <br>
	  * @param List<AgtAgnCommVO> updModels
	  * @return int[]
	  * @throws DAOException
	  * @throws Exception
	  */
	 public int[] modifymultiOtherCommforApprovalCancel(List<AgtAgnCommVO> updModels) throws DAOException,Exception{
		 int updCnt[] = null;
		 try{
				SQLExecuter sqlExe = new SQLExecuter("");
				if(updModels.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTAuditDBDAOAgtAgnCommCancelVOUSQL(), updModels,null);
					log.info(updCnt.length);
					for(int i=0; i<updCnt.length;i++){
						if(updCnt[i] == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
				}
			}catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 return updCnt;
	 }

	 /**
		 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트를 가져온다.<br>
		 * 
		 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
		 * @return List<APActualInterfaceMasterVO>
		 * @throws DAOException
		 */
		public List<APActualInterfaceMasterVO> searchAPActualInterfaceMaster(APActualInterfaceMasterVO apActualInterfaceMasterVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<APActualInterfaceMasterVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(apActualInterfaceMasterVO != null){
					Map<String, String> mapVO = apActualInterfaceMasterVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					log.info("\n >>>>velParam="+velParam);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchAPActualInterfaceMasterRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceMasterVO .class);
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
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailVO apActualInterfaceDetailVO
	 * @return List<APActualInterfaceDetailVO>
	 * @throws DAOException
	 */
	public List<APActualInterfaceDetailVO> searchAPActualInterfaceDetail(APActualInterfaceDetailVO apActualInterfaceDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<APActualInterfaceDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(apActualInterfaceDetailVO != null){
				Map<String, String> mapVO = apActualInterfaceDetailVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchAPActualInterfaceDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceDetailVO .class);
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
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 가능여부를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean searchApInvHdrIfFlg(APActualInterfaceMasterVO apActualInterfaceMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean isInterfaced = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(apActualInterfaceMasterVO != null){
				Map<String, String> mapVO = apActualInterfaceMasterVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOApInvHdrIfFlgRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("INTERFACE_SUCCESS") > 0){
					isInterfaced = true; 
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isInterfaced;
	}

	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @return List<InterfaceCancelVO>
	 * @throws DAOException
	 */
	public List<InterfaceCancelVO> searchCancelAgentActualINFList(APActualInterfaceMasterVO apActualInterfaceMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InterfaceCancelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apActualInterfaceMasterVO != null){
				Map<String, String> mapVO = apActualInterfaceMasterVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOCancelAgentActualINFListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InterfaceCancelVO .class);
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
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 가능여부를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean searchCancelAgentActualINFAfterINF(InterfaceCancelVO interfaceCancelVO) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean isInterfaced = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOCancelAgentActualINFAfterINFRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("AFTER_INTERFACED") > 0){
					isInterfaced = true; 
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isInterfaced;
	}


	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return List<InterfaceCancelVO>
	 * @throws DAOException
	 */
	public List<InterfaceCancelVO> searchCancelAgentActualINFAfterINFList(InterfaceCancelVO interfaceCancelVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InterfaceCancelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOCancelAgentActualINFAfterINFRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InterfaceCancelVO .class);
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
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return InterfaceCancelVO
	 * @throws DAOException
	 */
	public InterfaceCancelVO searchBeforeActualINF(InterfaceCancelVO interfaceCancelVO) throws DAOException {
		DBRowSet dbRowset = null;
		InterfaceCancelVO beforeCanceledAcSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOBeforeActualINFRSQL(), param, velParam);
			beforeCanceledAcSeq = (InterfaceCancelVO)RowSetUtil.rowSetToVOs(dbRowset, InterfaceCancelVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return beforeCanceledAcSeq;
	}


	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return InterfaceCancelVO
	 * @throws DAOException
	 */
	public InterfaceCancelVO searchBeforeCanceledAcSeq(InterfaceCancelVO interfaceCancelVO) throws DAOException {
		DBRowSet dbRowset = null;
		InterfaceCancelVO beforeCanceledAcSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOBeforeCanceledAcSeqRSQL(), param, velParam);
			beforeCanceledAcSeq = (InterfaceCancelVO)RowSetUtil.rowSetToVOs(dbRowset, InterfaceCancelVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return beforeCanceledAcSeq;
	}

	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int removeBeforeCanceledAcSeq (InterfaceCancelVO interfaceCancelVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOBeforeCanceledAcSeqDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param String csr_no
	 * @throws DAOException
	 */

	public void modifyAGTCommIFBack(String csr_no) throws DAOException {
		log.debug("\n modifyAGTCommIFBack Start");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
				param.put("csr_no", csr_no);
				new SQLExecuter("").executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommInfoIFBackUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n modifyAGTCommIFBack End");

	}
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param String csr_no
	 * @throws DAOException
	 */

	public void modifyAGTCommIFBackAP(String csr_no) throws DAOException {
		log.debug("\n modifyAGTCommIFBackAP Start");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
				param.put("csr_no", csr_no);
				new SQLExecuter("").executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommInfoIFBackAPUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n modifyAGTCommIFBackAP End");

	}
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int removeBeforeCanceledAcSeqDtl(InterfaceCancelVO interfaceCancelVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOBeforeCanceledAcSeqDtlDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int modifyInterfaceCanceledMst (InterfaceCancelVO interfaceCancelVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOInterfaceCanceledMstUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int modifyInterfaceCanceledDtl (InterfaceCancelVO interfaceCancelVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOInterfaceCanceledDtlUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int modifyInterfaceCanceledFirst(InterfaceCancelVO interfaceCancelVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOInterfaceCenceledFirstUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @param String usr_id
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int modifyInterfaceCanceled (InterfaceCancelVO interfaceCancelVO, String usr_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", usr_id);
				velParam.put("usr_id", usr_id);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOInterfaceCenceledUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int removeBeforeCanceled (InterfaceCancelVO interfaceCancelVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOBeforeCanceledDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트 중 CsrNo에 따른 Cancel 대상 리스트를 가져온다.<br>
	 * 
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */

	public int removeBeforeCanceledDtl (InterfaceCancelVO interfaceCancelVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(interfaceCancelVO != null){
				Map<String, String> mapVO = interfaceCancelVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOBeforeCanceledDtlDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	

	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param InterfaceCancelVO interfaceCancelVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createBeforeActualINF(InterfaceCancelVO interfaceCancelVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(interfaceCancelVO != null){
				Map<String, String> mapVo = interfaceCancelVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOApCancelCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return AgentActualINFtoAPCheckVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public AgentActualINFtoAPCheckVO selectAgentActualINFtoAP(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AgentActualINFtoAPCheckVO> list = null;
		AgentActualINFtoAPCheckVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVO = agentActualINFtoAPCheckVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSelectAgentActualINFtoAPRSQL(), param, velParam);
			if ( 0 < dbRowset.getRowCount())
			{
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentActualINFtoAPCheckVO .class);
			result = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
    }
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @return boolean
	 * @throws DAOException
	 * @throws Exception
	 */ 
	public boolean selectBKGStatus(APActualInterfaceMasterVO apActualInterfaceMasterVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AgtCommListVO> list = null;
		boolean bkgSts = true;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apActualInterfaceMasterVO != null){
				Map<String, String> mapVO = apActualInterfaceMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchBKGStatusCdRSQL(), param, velParam);
			if ( 0 < dbRowset.getRowCount()){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCommListVO .class);
				for(int i=0 ; i < list.size() ; i++){
					if(list.get(i).getBkgStsCd().equals("A"))bkgSts=false;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgSts;
    }
	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderAddApCsrNo(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOApCsrNoCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) REV VVD를 수정한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommBkgInfoRevVVD(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommBkgInfoRevVVDUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderAgtAgnComm(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderAgtAgnCommUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderAgtAgnCommDtl(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderAgtAgnCommDtlUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderApInvHdr(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderApInvHdrCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderApInvDtrb(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderApInvDtrbUpdate(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderApInvIf(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderApInvIfCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return AgentActualINFtoAPCheckVO
	 * @throws DAOException
	 * @throws EventException
	 */
	public AgentActualINFtoAPCheckVO createAGTCSRHeaderApInvHdrSelect(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AgentActualINFtoAPCheckVO> list = null;
		AgentActualINFtoAPCheckVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVO = agentActualINFtoAPCheckVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderApInvHdrRSQL(), param, velParam);
			if ( 0 < dbRowset.getRowCount())
			{
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentActualINFtoAPCheckVO .class);
			result = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
    }


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderAgtAgnComm2(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderAgtAgnComm2USQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCSRHeaderApInvHdrUpdate(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCSRHeaderApInvHdrUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return AgentActualINFtoAPCheckVO
	 * @throws DAOException
	 * @throws EventException
	 */
	public AgentActualINFtoAPCheckVO searchAGTCSRInfo(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AgentActualINFtoAPCheckVO> list = null;
		AgentActualINFtoAPCheckVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVO = agentActualINFtoAPCheckVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchAGTCSRInfoRSQL(), param, velParam);
			if ( 0 < dbRowset.getRowCount())
			{
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentActualINFtoAPCheckVO .class);
			result = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
    }


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommInfo(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommInfoUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTApprovalRequesttoEP(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTApprovalRequesttoEPUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyApprovalStep(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyApprovalStepUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}


	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws EventException
	 */
	public DBRowSet searchAgentActualINFtoAP(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVO = agentActualINFtoAPCheckVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchAgentActualINFtoAPRSQL(), param, velParam);
			if ( 1 > dbRowset.getRowCount())
			{
				//CSR No has already Interfaced! Please check up CSR No[$]
				throw new DAOException((new ErrorHandler("AGT00029", agentActualINFtoAPCheckVO.getCsrNo())).getMessage());
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }

	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AGTCommInfoForPrintVO agtCommInfoForPrintVO
	 * @return List<AGTCommInfoForPrintVO>
	 * @throws DAOException
	 * @throws EventException
	 */
	public List<AGTCommInfoForPrintVO> searchAGTCommInfoForPrint1(AGTCommInfoForPrintVO agtCommInfoForPrintVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AGTCommInfoForPrintVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCommInfoForPrintVO != null){
				Map<String, String> mapVO = agtCommInfoForPrintVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAGTCommInfoForPrint1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGTCommInfoForPrintVO .class);
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
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AGTCommInfoForPrint2VO agtCommInfoForPrint2VO
	 * @return List<AGTCommInfoForPrint2VO> 
	 * @throws DAOException
	 * @throws EventException
	 */
	public List<AGTCommInfoForPrint2VO> searchAGTCommInfoForPrint2(AGTCommInfoForPrint2VO agtCommInfoForPrint2VO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AGTCommInfoForPrint2VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCommInfoForPrint2VO != null){
				Map<String, String> mapVO = agtCommInfoForPrint2VO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAGTCommInfoForPrint2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGTCommInfoForPrint2VO .class);
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
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO> 
	 * @throws DAOException
	 * @throws Exception
	 */
	 public List<AgtAgnCommVO> searchAGTCommApprovalNo(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		 log.info("\n   <<<<<<a>>>>");
		 DBRowSet dbRowset = null;
			List<AgtAgnCommVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(agtAgnCommVO != null){
					Map<String, String> mapVO = agtAgnCommVO .getColumnValues();					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAgtAgnCommApprovalNoVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
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
	  * (ESM_AGT_0036) Agent Commission Approval 조회 한다.<br>
	  * @param AgtAgnCommVO agtAgnCommVO
	  * @return List<AgtAgnCommVO>
	  * @throws DAOException
	  * @throws Exception
	  */
	 public List<AgtAgnCommVO> searchAGTCommTobeApproved(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<AgtAgnCommVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAgtAgnCommApprovalVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
		 
	 }
	 /**
	  * (ESM_AGT_0036) Agent Commission Approval Check Local Date 조회 한다.<br>
	  * @param AgtAgnCommVO agtAgnCommVO
	  * @return List<AGTCommTobeApproved1VO>
	  * @throws DAOException
	  * @throws Exception
	  */
	 public String searchAGTAuditDBDAOAGTCommTobeApprovedChkLocalDt(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		 DBRowSet dbRowSet = null;
		 String localDt = "";
		 //List<AGTCommTobeApproved1VO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try
		{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAGTCommTobeApproved1RSQL(), param, velParam);
			if (dbRowSet.next())
			{
				localDt = dbRowSet.getString("LOCAL_DATE");
			}
		 }catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		return localDt;
	}
	 /**
	  * (ESM_AGT_0036) Agent Commission Approval Check Local Date 조회 한다.<br>
	  * @param AgtAgnCommVO agtAgnCommVO
	  * @return List<AGTCommTobeApproved1VO>
	  * @throws DAOException
	  * @throws Exception
	  */
	 public String searchAGTAuditDBDAOAGTCommTobeApprovedGetLocalDt(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		 DBRowSet dbRowSet = null;
		 String localDt = "";
		 //List<AGTCommTobeApproved1VO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try
		{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAGTCommTobeApproved2RSQL(), param, velParam);
			if (dbRowSet.next())
			{
				localDt = dbRowSet.getString("LOCAL_DATE");
			}
		 }catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		return localDt;
	 }

	
	
	
	
	 /**
	  * (ESM_AGT_0036) Agent Commission Approval Check Approval No의 중복 존재 여부를 조회 한다.<br>
	  * @param AgtAgnCommVO agtAgnCommVO
	  * @return List<CheckApprovalNoVO>
	  * @throws DAOException
	  * @throws Exception
	  */
	 public String searchAGTAuditDBDAOAGTCommTobeCheckApprovalNo(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception {
		DBRowSet dbRowSet = null;
		String strAproCnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (agtAgnCommVO != null)
			{
				Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAGTCommTobeCheckApprovalNoRSQL(), param, velParam);
			if (dbRowSet.next())
			{
				strAproCnt = dbRowSet.getString("CNT");
			}

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strAproCnt;
	 }
	 /**
	  * (ESM_AGT_0036) Agent Commission Approval Confirm 하기 위해 Local Date 조회 한다.
	  * @param AgtAgnCommVO agtAgnCommVO
	  * @return List<AGTCommTobeApproved1VO>
	  * @throws DAOException
	  * @throws Exception
	  */
	 public List<AGTCommTobeApproved1VO> searchAGTAuditDBDAOAGTCommTobeApproved2(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		 DBRowSet dbRowSet = null;
		 List<AGTCommTobeApproved1VO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(agtAgnCommVO != null){
//				 for(int i=0; i<agtAgnCommVO.length; i++){
					 Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
//				 }
			 } 
			 dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAGTCommTobeApproved2RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AGTCommTobeApproved1VO .class);
		 }catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		return list;
	 }
		/**
		 * (ESM_AGT_0036) Agent Commission Approval 를 Confirm 한다.<br>	
		 * @param AgtAgnCommVO agtAgnCommVO
		 * @return int
		 * @throws DAOException
		 * @throws Exception
		 */
		public int modifyAGTCommTobeApproved(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(agtAgnCommVO != null){
					Map<String, String> mapVo = agtAgnCommVO .getColumnValues();
					param.putAll(mapVo);
					velParam.putAll(mapVo);
					log.info("\n >>>>param="+param);
				}
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOAGTCommTobeApprovedUSQL(), param,velParam);
				
				if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");
			}catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		/**
		 * (ESM_AGT_0036) Agent Commission Approval 를 Confirm 한다.<br>	
		 * @param AgtAgnCommVO agtAgnCommVO
		 * @return int
		 * @throws DAOException
		 * @throws Exception
		 */
		public int modifyAGTCommTobeApprovedConfirm(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(agtAgnCommVO != null){
					Map<String, String> mapVo = agtAgnCommVO .getColumnValues();
					param.putAll(mapVo);
					velParam.putAll(mapVo);
					log.info("\n >>>>param="+param);
				}
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOAGTCommTobeApprovedConfirmUSQL(), param,velParam);
				
				if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");
			}catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
	/**
	 * (ESM_AGT_0036) Agent Commission Approval 를 Confirm 한다.<br>	
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnCommVO> searchAGTAuditDBDAOAGTCommTobeApprovedEAI(AgtAgnCommVO agtAgnCommVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(agtAgnCommVO != null){
//				 for(int i=0; i<agtAgnCommVO.length; i++){
					 Map<String, String> mapVO = agtAgnCommVO.getColumnValues();
					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
//				 }
			 } 
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOAGTCommTobeApprovedEAIRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AGTCommTobeApproved1VO .class);
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	    
    }
	/**
	 * (ESM_AGT_0042) Other Commission Maintenance & Request의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnCommVO> searchOtherCommForRequest(AgtAgnCommVO agtAgnCommVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchOtherCommforRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
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
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyOtherCommForRequest (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyOtherCommForRequestUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * (ESM_AGT_0042) Other Commission Maintenance & Request의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnCommVO> searchMultiOtherCommForRequest(AgtAgnCommVO agtAgnCommVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtAgnCommVO .class);
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
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiOtherCommForRequestAgtAgnComm (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiOtherCommForRequestAgtAgnCommDtl (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDtlCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiOtherCommForRequestAgtCommBkgInfo(AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtCommBkgInfoCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiOtherCommForRequestAgtAgnComm (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiOtherCommForRequestAgtAgnCommDtl(AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDtlUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiOtherCommForRequestAgtCommBkgInfo(AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtCommBkgInfoUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiOtherCommForRequestAgtAgnComm (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiOtherCommForRequestAgtAgnCommDtl(AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDtlDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiOtherCommForRequestAgtCommBkgInfo (AgtAgnCommVO agtAgnCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtAgnCommVO != null){
				Map<String, String> mapVO = agtAgnCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOMultiOtherCommForRequestAgtCommBkgInfoDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * ESM_AGT_0043 화면 조회
	 * @param CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO
	 * @return List<CSRDetailforCommissionHdrVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<CSRDetailforCommissionHdrVO> searchCSRDetailforCommissionHdr(
			CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<CSRDetailforCommissionHdrVO> list = null;
		//query paramter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity paramter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(csrDetailforCommissionHdrVO != null){
				Map<String, String> mapVO = csrDetailforCommissionHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOCSRDetailforCommissionHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CSRDetailforCommissionHdrVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;

    }
	/**
	 * ESM_AGT_0043 화면 조회
	 * @param CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO
	 * @return List<CSRDetailforCommissionDtrbVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<CSRDetailforCommissionDtrbVO> searchCSRDetailforCommissionDtrb(
			CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO) throws DAOException, Exception{
		DBRowSet dbRowSet = null;
		List<CSRDetailforCommissionDtrbVO> list = null;
		//query paramter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity paramter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(csrDetailforCommissionDtrbVO != null){
				Map<String, String> mapVO = csrDetailforCommissionDtrbVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOCSRDetailforCommissionDtrbRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CSRDetailforCommissionDtrbVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * (ESM_AGT_0051) Agent Commission Maintenance & Request의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtCommListVO> searchAGTCommList(AgtCommListVO agtCommListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCommListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchAGTCommListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCommListVO .class);
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
	 * (ESM_AGT_0051) Agent Commission Maintenance & Request의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtCommListVO> searchBKGList(AgtCommListVO agtCommListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCommListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchBKGListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCommListVO .class);
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
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtCommListVO> searchAGTCommForAudit(AgtCommListVO agtCommListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCommListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchAGTCommForAuditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCommListVO .class);
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
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정한다.<br> 
	 * @param AgtCommListVO agtCommListVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommForAuditAgtAgnComm(AgtCommListVO agtCommListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정한다.<br> 
	 * @param AgtCommListVO agtCommListVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAGTCommForAuditAgtAgnCommDtl(AgtCommListVO agtCommListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOCreateAGTCommForAuditAgtAgnCommDtlCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}


	/**
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정한다.<br> 
	 * @param AgtCommListVO agtCommListVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeAGTCommForAuditAgtAgnCommDtl(AgtCommListVO agtCommListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAORemoveAGTCommForAuditAgtAgnCommDtlDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}

	/**
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정한다.<br> 
	 * @param AgtCommListVO agtCommListVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCancelAGTCommForAudit(AgtCommListVO agtCommListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyCancelAGTCommForAuditUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}


	/**
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정한다.<br> 
	 * @param AgtCommListVO agtCommListVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRejectAGTCommForAudit(AgtCommListVO agtCommListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(agtCommListVO != null){
				Map<String, String> mapVO = agtCommListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyRejectAGTCommForAuditUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
     * 1. 기능 : Monthly Exchange Rate count<p>
     * 2. 처리개요 : Monthly Exchange Rate의 총 카운트를 조회한다.<p> 
     * <p/>
	 * @param et COM_ENS_0F1Event
     * @return int
     * @throws DAOException
     *
     */
	public int totalVVDRate(AGTVVDRateVO aGTVVDRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(aGTVVDRateVO != null){
			Map<String, String> mapVO = aGTVVDRateVO .getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}		
		
		velParam.put("where", "");
		int result = 0;
			
        String vvd = aGTVVDRateVO.getVvd();
       	String port = aGTVVDRateVO.getPort();
    	String chg_curr_cd = aGTVVDRateVO.getChgCurrCd();
    	String locl_curr_cd = aGTVVDRateVO.getLoclCurrCd();
    	String scope = aGTVVDRateVO.getScope();
    	String bound = aGTVVDRateVO.getBound();

    	if(!vvd.equals("")) {
			velParam.put("vsl_cd", vvd);
			param.put("vsl_cd", vvd);
			if(velParam.get("where").equals(""))
				velParam.put("where", "vsl_cd");
		}
		if(!port.equals("")) {
			param.put("port_cd", port);
			velParam.put("port_cd", port);
			if(velParam.get("where").equals(""))
				velParam.put("where", "port_cd");
		}
		if(!chg_curr_cd.equals("")) {
			param.put("chg_curr_cd", chg_curr_cd);
			velParam.put("chg_curr_cd", chg_curr_cd);
			if(velParam.get("where").equals(""))
				velParam.put("where", "chg_curr_cd");
		}
		if(!locl_curr_cd.equals("")) {
			param.put("locl_curr_cd", locl_curr_cd);
			velParam.put("locl_curr_cd", locl_curr_cd);
			if(velParam.get("where").equals(""))
				velParam.put("where", "locl_curr_cd");
		}
		if(!scope.equals("")) {
			param.put("svc_scp_cd", scope);
			velParam.put("svc_scp_cd", scope);
			if(velParam.get("where").equals(""))
				velParam.put("where", "svc_scp_cd");
		}
		if(!bound.equals("")) {
			param.put("io_bnd_cd", bound);
			velParam.put("io_bnd_cd", bound);
			if(velParam.get("where").equals(""))
				velParam.put("where", "io_bnd_cd");
		}
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSelectVVDRateCountRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = Integer.parseInt(dbRowset.getString("CNT"));
			}
			if(result>0) return result;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;
	}
	
	/**
	 * Monthly의 모든 목록을 가져온다.<br>
	 * @param AGTVVDRateVO aGTVVDRateVO
	 * @return List<AGTVVDRateVO>
	 * @throws DAOException
	 */
	public List<AGTVVDRateVO> searchVVDRateList(AGTVVDRateVO aGTVVDRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGTVVDRateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(aGTVVDRateVO != null){
			Map<String, String> mapVO = aGTVVDRateVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		velParam.put("where", "");
		
        // 페이징 처리
		int currentPage = Integer.parseInt(aGTVVDRateVO.getIPage());
		int startPart   = Constants.PAGE_SIZE_50 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_50 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
		
		String vvd = aGTVVDRateVO.getVvd();
       	String port = aGTVVDRateVO.getPort();
    	String chg_curr_cd = aGTVVDRateVO.getChgCurrCd();
    	String locl_curr_cd = aGTVVDRateVO.getLoclCurrCd();
    	String scope = aGTVVDRateVO.getScope();
    	String bound = aGTVVDRateVO.getBound();

    	if(!vvd.equals("")) {
			velParam.put("vsl_cd", vvd);
			param.put("vsl_cd", vvd);
			if(velParam.get("where").equals(""))
				velParam.put("where", "vsl_cd");
		}
		if(!port.equals("")) {
			param.put("port_cd", port);
			velParam.put("port_cd", port);
			if(velParam.get("where").equals(""))
				velParam.put("where", "port_cd");
		}
		if(!chg_curr_cd.equals("")) {
			param.put("chg_curr_cd", chg_curr_cd);
			velParam.put("chg_curr_cd", chg_curr_cd);
			if(velParam.get("where").equals(""))
				velParam.put("where", "chg_curr_cd");
		}
		if(!locl_curr_cd.equals("")) {
			param.put("locl_curr_cd", locl_curr_cd);
			velParam.put("locl_curr_cd", locl_curr_cd);
			if(velParam.get("where").equals(""))
				velParam.put("where", "locl_curr_cd");
		}
		if(!scope.equals("")) {
			param.put("svc_scp_cd", scope);
			velParam.put("svc_scp_cd", scope);
			if(velParam.get("where").equals(""))
				velParam.put("where", "svc_scp_cd");
		}
		if(!bound.equals("")) {
			param.put("io_bnd_cd", bound);
			velParam.put("io_bnd_cd", bound);
			if(velParam.get("where").equals(""))
				velParam.put("where", "io_bnd_cd");
		}

		param.put("startpart", startPart);
		param.put("endpart", endPart);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSelectVVDRateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGTVVDRateVO .class);
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
	 * 
	 * @param tesTmlSoHdrVO
	 * @return
	 * @throws DAOException
	 */
	public ApPayInvVO searchAgtApPayInv(APActualInterfaceMasterVO aPActualInterfaceMasterVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<ApPayInvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			log.debug("aPActualInterfaceMasterVO====>"+aPActualInterfaceMasterVO);
			if(aPActualInterfaceMasterVO != null){
				Map<String, String> mapVO = aPActualInterfaceMasterVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchApPayInvRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}	
	
//	/**
//	 * 
//	 * @param apPayInvVO
//	 * @return
//	 * @throws DAOException
//	 */
//	public ApPayInvVO[] searchAgtApPayInv(APActualInterfaceMasterVO aPActualInterfaceMasterVO) throws DAOException{
//		DBRowSet dbRowset = null;
//		List<ApPayInvVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(aPActualInterfaceMasterVO != null){
//				Map<String, String> mapVO = aPActualInterfaceMasterVO .getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchApPayInvRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO .class);
//			
//			ApPayInvVO[] rtvos = new ApPayInvVO[list.size()]; 
//			
//			for(int i=0 ; i<list.size();i++){
//				rtvos[i] = list.get(i);
//			}
//			return rtvos;
//			
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 * 
	 * @param apPayInvVO
	 * @return
	 * @throws DAOException
	 */
	public ApPayInvDtlVO[] searchAgtApPayInvDtl(APActualInterfaceMasterVO aPActualInterfaceMasterVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<ApPayInvDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(aPActualInterfaceMasterVO != null){
				Map<String, String> mapVO = aPActualInterfaceMasterVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTAuditDBDAOSearchApPayInvDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvDtlVO .class);
			
			ApPayInvDtlVO[] rtvos = new ApPayInvDtlVO[list.size()]; 
			
			for(int i=0 ; i<list.size();i++){
				rtvos[i] = list.get(i);
			}
			return rtvos;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * (ESM_AGT_017) Agent Commission 의 커미션 스테이터스 코드를 업데이트한다..<br>
	 * 
	 * @param String csr_no
	 * @throws DAOException
	 */

	public void modifyAGTCommProcStsCd(ApPayInvVO apPayInvVO) throws DAOException {
		log.debug("\n modifyAGTCommProcStsCd Start");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = apPayInvVO .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new AGTAuditDBDAOModifyAGTCommProcStsCdUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n modifyAGTCommIFBackAP End");

	}	
	
	
}