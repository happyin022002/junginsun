/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAO.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.20 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionDeleteVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionParamVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS SCExceptionTariffMgtDBDAO <br>
 * - OPUS-DMTExceptionMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SungHoon, Lee
 * @see SCExceptionTariffMgtBCImpl 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAO extends DBDAOSupport {
	/**
	 * S/C Exception Terms Entry를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionGRPVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCExceptionVO> searchSCException(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCExceptionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionVO .class);
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
	 * S/C Exception에 해당하는 Multi Coverage목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCExceptionCoverageVO> searchMultiCoverageBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchMultiCoverageBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCoverageVO .class);
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
	 * S/C Exception 에 해당하는 Tiered Free Time를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionFreeTimeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCExceptionFreeTimeVO> searchTieredFreeTimeBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionFreeTimeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchTieredFreeTimeBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionFreeTimeVO .class);
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
	 * S/C Exception 에 해당하는 Rate Adjustment를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionRateAdjustVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCExceptionRateAdjustVO> searchRateAdjustmentBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionRateAdjustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchRateAdjustmentBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionRateAdjustVO .class);
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
	 * S/C Exception 에 해당하는 Actual Customer를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCExceptionCustomerVO> searchCustomerBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchCustomerBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCustomerVO .class);
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
	 * S/C Exception 에 해당하는 Commodity를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCExceptionCommodityVO> searchCommodityBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCommodityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchCommodityBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCommodityVO .class);
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
	 * Proposal No. 에 해당하는 Version 목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVersionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCExceptionVersionVO> searchVersionByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionVersionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchVersionByProposalNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionVersionVO .class);
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
	 * Proposal No. 에 해당하는 Actual Customer 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCExceptionCustomerVO> searchCustomerListBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchCustomerListBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCustomerVO .class);
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
	 * Proposal No. 에 해당하는 Commodity 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCExceptionCommodityVO> searchCommodityListBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCommodityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchCommodityListBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCommodityVO .class);
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
	 * Proposal No, Version Seq 에 해당되는 다음 Group Seq 를 조회 합니다. <br>
	 * 
	 * @param SCExceptionVO sCExceptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchNextGroupSequence(SCExceptionVO sCExceptionVO) throws DAOException {
		int result = -1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVO != null) {
				Map<String, String> mapVO = sCExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchNextGroupSeqRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1);
				
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
	 * Proposal No, Version Seq, Group Seq 에 해당되는 다음 Coverage Seq 를 조회 합니다. <br>
	 * 
	 * @param SCExceptionCoverageVO sCExceptionCoverageVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchNextCoverageSequence(SCExceptionCoverageVO sCExceptionCoverageVO) throws DAOException {
		int result = -1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionCoverageVO != null) {
				Map<String, String> mapVO = sCExceptionCoverageVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchNextCoverageSequenceRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1);
				
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
	 * Proposal No, Version Seq, Group Seq 에 해당되는 다음 FreeTime Seq 를 조회 합니다. <br>
	 * 
	 * @param SCExceptionFreeTimeVO sCExceptionFreeTimeVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchNextFreeTimeSequence(SCExceptionFreeTimeVO sCExceptionFreeTimeVO) throws DAOException {
		int result = -1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionFreeTimeVO != null) {
				Map<String, String> mapVO = sCExceptionFreeTimeVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchNextFreeTimeSequenceRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1);
				
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
	 * Proposal No, Version Seq, Group Seq 에 해당되는 다음 Rate Adjustment Seq 를 조회 합니다. <br>
	 * 
	 * @param SCExceptionRateAdjustVO sCExceptionRateAdjustVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchNextRTAdjustSequence(SCExceptionRateAdjustVO sCExceptionRateAdjustVO) throws DAOException {
		int result = -1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionRateAdjustVO != null) {
				Map<String, String> mapVO = sCExceptionRateAdjustVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchNextRTAdjustSequenceRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1);
				
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
	 * 특정 Version 정보가 존재하는지 조회 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean existSCExceptionVersion(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		boolean 				result 		= false;
		DBRowSet 				dbRowset 	= null;		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAODuplicateSCExceptionVersionRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
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
	 * S/C Exception Tariff 의 Version 에 포함된 Group 정보가 존재하는지 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean existSCException(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		boolean 				result 		= false;
		DBRowSet 				dbRowset 	= null;		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOExistSCExceptionGroupRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
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
	 * Proposal No. 와 Version No.에 해당하는 S/C Exception Version 정보를 삭제 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */	
	public void removeSCExceptionVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
			}	

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionVersionDSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Proposal No. 와 Version No.에 해당하는 S/C Exception Version Prog 정보를 삭제 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */	
	public void removeSCExceptionVersionProg(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
			}	

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionVersionProgDSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Version를 생성 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void addSCExceptionVersion(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionVersionCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Tariff 의 정보를 생성 합니다. <br>
	 * 
	 * @param SCExceptionVO sCExceptionVO
	 * @throws DAOException
	 */
	public void addSCExceptionGroup(SCExceptionVO sCExceptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (sCExceptionVO != null) {
				Map<String, String> mapVO = sCExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionGroupCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<SCExceptionVO> sCExceptionVOs
	 * @throws DAOException
	 */
	public void addSCExceptionGroups(List<SCExceptionVO> sCExceptionVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(sCExceptionVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOAddSCExceptionGroupsCSQL(), sCExceptionVOs, null);
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
	 * S/C Exception Coverage 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<SCExceptionCoverageVO> sCExceptionCoverageVOs
	 * @throws DAOException
	 */
	public void addSCExceptionCoverages(List<SCExceptionCoverageVO> sCExceptionCoverageVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(sCExceptionCoverageVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOAddSCExceptionCoveragesCSQL(), sCExceptionCoverageVOs, null);
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
	 * S/C Exception Free Time 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOs
	 * @throws DAOException
	 */
	public void addSCExceptionFreeTimes(List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(sCExceptionFreeTimeVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOAddSCExceptionFreeTimesCSQL(), sCExceptionFreeTimeVOs, null);
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
	 * S/C Exception Rate Adjustment 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOs
	 * @throws DAOException
	 */
	public void addSCExceptionRates(List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(sCExceptionRateAdjustVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOAddSCExceptionRatesCSQL(), sCExceptionRateAdjustVOs, null);
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
	 * S/C Exception Customer 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<SCExceptionCustomerVO> sCExceptionCustomerVOs
	 * @throws DAOException
	 */
	public void addSCExceptionCustomers(List<SCExceptionCustomerVO> sCExceptionCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(sCExceptionCustomerVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOAddSCExceptionCustomersCSQL(), sCExceptionCustomerVOs, null);
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
	 * S/C Exception Commodity 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * 
	 * @param List<SCExceptionCommodityVO> sCExceptionCommodityVOs
	 * @throws DAOException
	 */
	public void addSCExceptionCommodities(List<SCExceptionCommodityVO> sCExceptionCommodityVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(sCExceptionCommodityVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOAddSCExceptionCommoditiesCSQL(), sCExceptionCommodityVOs, null);
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
	 * S/C Exception Tariff 의 정보를 수정 합니다. <br>
	 * 
	 * @param SCExceptionVO sCExceptionVO
	 * @throws DAOException
	 */
	public void modifySCExceptionGroup(SCExceptionVO sCExceptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (sCExceptionVO != null) {
				Map<String, String> mapVO = sCExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOModifySCExceptionGroupsUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception 다건의 데이터를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param List<SCExceptionVO> sCExceptionVOs
	 * @throws DAOException
	 */
	public void modifySCExceptionGroups(List<SCExceptionVO> sCExceptionVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(sCExceptionVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOModifySCExceptionGroupsUSQL(), sCExceptionVOs, null);
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
	 * S/C Exception Coverage 다건의 데이터를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param List<SCExceptionCoverageVO> sCExceptionCoverageVOs
	 * @throws DAOException
	 */
	public void modifySCExceptionCoverages(List<SCExceptionCoverageVO> sCExceptionCoverageVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(sCExceptionCoverageVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOModifySCExceptionCoveragesUSQL(), sCExceptionCoverageVOs, null);
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
	 * S/C Exception Free Time 다건의 데이터를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOs
	 * @throws DAOException
	 */
	public void modifySCExceptionFreeTimes(List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(sCExceptionFreeTimeVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOModifySCExceptionFreeTimesUSQL(), sCExceptionFreeTimeVOs, null);
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
	 * S/C Exception Rate Adjustment 다건의 데이터를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOs
	 * @throws DAOException
	 */
	public void modifySCExceptionRates(List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(sCExceptionRateAdjustVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOModifySCExceptionRatesUSQL(), sCExceptionRateAdjustVOs, null);
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
	 * S/C Exception 다건의 데이터를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<SCExceptionVO> sCExceptionVOs
	 * @throws DAOException
	 */
	public void removeSCExceptionGroups(List<SCExceptionVO> sCExceptionVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(sCExceptionVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAORemoveSCExceptionGroupsDSQL(), sCExceptionVOs, null);
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
	 * S/C Exception Coverage 다건의 데이터를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<SCExceptionCoverageVO> sCExceptionCoverageVOs
	 * @throws DAOException
	 */
	public void removeSCExceptionCoverages(List<SCExceptionCoverageVO> sCExceptionCoverageVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(sCExceptionCoverageVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAORemoveSCExceptionCoveragesDSQL(), sCExceptionCoverageVOs, null);
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
	 * S/C Exception 삭제시 이에 해당되는 모든 Coverages 을 삭제 합니다. <br>
	 * 
	 * @param List<SCExceptionVO> sCExceptionVOs
	 * @throws DAOException
	 */
	public void removeSCExceptionCoveragesByGroups(List<SCExceptionVO> sCExceptionVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(sCExceptionVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAORemoveSCExceptionCoveragesByGroupsDSQL(), sCExceptionVOs, null);
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
	 * S/C Exception Free Time 다건의 데이터를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOs
	 * @throws DAOException
	 */
	public void removeSCExceptionFreeTimes(List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(sCExceptionFreeTimeVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAORemoveSCExceptionFreeTimesDSQL(), sCExceptionFreeTimeVOs, null);
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
	 * S/C Exception Rate Adjustment 다건의 데이터를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOs
	 * @throws DAOException
	 */
	public void removeSCExceptionRates(List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(sCExceptionRateAdjustVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAORemoveSCExceptionRatesDSQL(), sCExceptionRateAdjustVOs, null);
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
	 * S/C Exception Customer 다건의 데이터를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<SCExceptionCustomerVO> sCExceptionCustomerVOs
	 * @throws DAOException
	 */
	public void removeSCExceptionCustomers(List<SCExceptionCustomerVO> sCExceptionCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(sCExceptionCustomerVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAORemoveSCExceptionCustomersDSQL(), sCExceptionCustomerVOs, null);
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
	 * S/C Exception Commodity 다건의 데이터를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<SCExceptionCommodityVO> sCExceptionCommodityVOs
	 * @throws DAOException
	 */
	public void removeSCExceptionCommodities(List<SCExceptionCommodityVO> sCExceptionCommodityVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(sCExceptionCommodityVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new SCExceptionTariffMgtDBDAORemoveSCExceptionCommoditiesDSQL(), sCExceptionCommodityVOs, null);
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
	 * S/C Exception Version를 삭제상태로 수정 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionByVer(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExecuter = new SQLExecuter("");
			
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionCVRGDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionFTDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionRTDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionCUSTDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionCMDTDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionGRPDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionVersionProgDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionVersionDSQL(), param, velParam);				
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Tariff Type 에 맞는 Calculation Type 이 존재하는지 조회 합니다. <br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkCalcType(CalculationTypeParmVO calculationTypeParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calculationTypeParmVO != null) {
				Map<String, String> mapVO = calculationTypeParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOCheckCalcTypeRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
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
	 * 선택한 Tariff Type 에 맞는 Dual Type 이 존재하는지 조회 합니다. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkDualTypeCoverage(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (dualTypeCustomerVO != null) {
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOCheckDualTypeCoverageRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
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
	 * BKG POR(O) or DEL(I) 의 입력된 CN 의 Continent 와 Coverage CN 의 Continent 가 동일한지 조회 합니다.<br>
	 * 
	 * @param SCExceptionVO sCExceptionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkContinentType(SCExceptionVO sCExceptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVO != null) {
				Map<String, String> mapVO = sCExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOCheckContinentTypeRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
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
	 * S/C 가 Filed Status 인지를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkFiledBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOCheckFiledBySCRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
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
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyVersionSTS(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOModifyVersionSTSUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Version 의 상태가 Accepted 인지 조회를 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isAcceptedVersionSTS(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		DBRowSet 				dbRowset	= null;
		boolean					result 		= false;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOIsAcceptedVersionSTSRSQL(), param, velParam);
			
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
	 * Accept 버튼 클릭시 상태가 Live 로 변경될 경우, 이하버전의 Live 상태는 모두 Deleted 상태로 수정 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyUnderVersionDelSTS(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOModifyUnderVersionDelSTSUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C 의 버전상태가 변경될 경우 그 이력을 생성 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void addSCExceptionVersionProg(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddVersionPROGCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C 에 생성된 이력중 마지막 이력상태가 'Temp.Saved' 인지를 조회 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isTempSavedStatusOfLastVersionProg(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		boolean				result		= false;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOIsTempSavedStatusOfLastVersionProgRSQL(), param, velParam);

			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
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
	 * S/C 의 버전상태가 변경될 경우 그 이력을 생성 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyLastVersionProg(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOModifyLastVersionProgUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Accept 버튼 클릭시 상태가 Live 로 변경될 경우, 이하버전의 Live 상태는 모두 Deleted 상태로 변경함에 따른 그 이력을 생성 합니다.<br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void addUnderVersionPROG(SCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddUnderVersionPROGCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C, RFA Exception를 조회 합니다. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCRFAExceptionListVO> searchSCTariffListByOffice(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws DAOException {
		DBRowSet 						dbRowset 	= null;
		List<SCRFAExceptionListVO> 		list 		= null;
		//query parameter
		Map<String, Object> 			param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 			velParam 	= new HashMap<String, Object>();
		
		try{
			if (sCRFAExceptionParamVO != null) {
				Map<String, String> mapVO = sCRFAExceptionParamVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Type
				List<String> 	statusCdList 	= new ArrayList<String>();
				String[]		statusCdArray 	= sCRFAExceptionParamVO.getVerStsCd().split(",");

				for (int i = 0 ; i < statusCdArray.length ; i++) {
					statusCdList.add(statusCdArray[i]);
			    }
				velParam.put("sts_cd_list", statusCdList);
				
				//2.Tariff
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = sCRFAExceptionParamVO.getTariff().split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//3.Ref. Office
				List<String> ofcCdList = new ArrayList<String>();
				String[] ofcCdArray = sCRFAExceptionParamVO.getOfcCd().split(",");
				for (int i = 0 ; i < ofcCdArray.length ; i++) {
					ofcCdList.add(ofcCdArray[i]);
			    }
				velParam.put("dmdt_ofc_list", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCTariffListByOfficeRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCRFAExceptionListVO .class);
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
	 * S/C, RFA Exception를 조회 합니다. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCRFAExceptionListVO> searchSCTariffListByCoverage(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws DAOException {
		DBRowSet 						dbRowset 	= null;
		List<SCRFAExceptionListVO> 		list 		= null;
		//query parameter
		Map<String, Object> 			param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 			velParam 	= new HashMap<String, Object>();
		
		try{
			if (sCRFAExceptionParamVO != null) {
				Map<String, String> mapVO = sCRFAExceptionParamVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Type
				List<String> 	statusCdList 	= new ArrayList<String>();
				String[]		statusCdArray 	= sCRFAExceptionParamVO.getVerStsCd().split(",");
				
				for (int i = 0 ; i < statusCdArray.length ; i++) {
					statusCdList.add(statusCdArray[i]);
			    }
				velParam.put("sts_cd_list", statusCdList);
				
				//2.Tariff
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = sCRFAExceptionParamVO.getTariff().split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//3.Ref. Office
				List<String> ofcCdList = new ArrayList<String>();
				String[] ofcCdArray = sCRFAExceptionParamVO.getOfcCd().split(",");
				for (int i = 0 ; i < ofcCdArray.length ; i++) {
					ofcCdList.add(ofcCdArray[i]);
			    }
				velParam.put("dmdt_ofc_list", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCTariffListByCoverageRSQL(), param, velParam);	
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCRFAExceptionListVO .class);
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
	 * S/C, RFA Exception를 조회 합니다. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCRFAExceptionListVO> searchSCTariffListByDAR(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws DAOException {
		DBRowSet 						dbRowset 	= null;
		List<SCRFAExceptionListVO> 		list 		= null;
		//query parameter
		Map<String, Object> 			param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 			velParam 	= new HashMap<String, Object>();
		
		try{
			if (sCRFAExceptionParamVO != null) {
				Map<String, String> mapVO = sCRFAExceptionParamVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Type
				List<String> 	statusCdList 	= new ArrayList<String>();
				String[]		statusCdArray 	= sCRFAExceptionParamVO.getVerStsCd().split(",");
				
				for (int i = 0 ; i < statusCdArray.length ; i++) {
					statusCdList.add(statusCdArray[i]);
			    }
				velParam.put("sts_cd_list", statusCdList);
				
				//2.Tariff
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = sCRFAExceptionParamVO.getTariff().split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//3.Ref. Office
				List<String> ofcCdList = new ArrayList<String>();
				String[] ofcCdArray = sCRFAExceptionParamVO.getOfcCd().split(",");
				for (int i = 0 ; i < ofcCdArray.length ; i++) {
					ofcCdList.add(ofcCdArray[i]);
			    }
				velParam.put("dmdt_ofc_list", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCTariffListByDARRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCRFAExceptionListVO .class);
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
	 * S/C, RFA Exception를 조회 합니다. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCRFAExceptionListVO> searchBeforeBookingListByOffice(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws DAOException {
		DBRowSet 						dbRowset 	= null;
		List<SCRFAExceptionListVO> 		list 		= null;
		//query parameter
		Map<String, Object> 			param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 			velParam 	= new HashMap<String, Object>();
		
		try{
			if (sCRFAExceptionParamVO != null) {
				Map<String, String> mapVO = sCRFAExceptionParamVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Type
				List<String> 	statusCdList 	= new ArrayList<String>();
				String[] 		statusCdArray 	= sCRFAExceptionParamVO.getRqstStsCd().split(",");
				
				for (int i = 0 ; i < statusCdArray.length ; i++) {
					statusCdList.add(statusCdArray[i]);
			    }
				velParam.put("sts_cd_list", statusCdList);
				
				//2.Tariff
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = sCRFAExceptionParamVO.getTariff().split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//3.Ref. Office
				List<String> ofcCdList = new ArrayList<String>();
				String[] ofcCdArray = sCRFAExceptionParamVO.getOfcCd().split(",");
				for (int i = 0 ; i < ofcCdArray.length ; i++) {
					ofcCdList.add(ofcCdArray[i]);
			    }
				velParam.put("dmdt_ofc_list", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchBeforeBookingListByOfficeRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCRFAExceptionListVO .class);
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
	 * S/C, RFA Exception를 조회 합니다. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCRFAExceptionListVO> searchBeforeBookingListByCoverage(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws DAOException {
		DBRowSet 						dbRowset 	= null;
		List<SCRFAExceptionListVO> 		list 		= null;
		//query parameter
		Map<String, Object> 			param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 			velParam 	= new HashMap<String, Object>();
		
		try{
			if (sCRFAExceptionParamVO != null) {
				Map<String, String> mapVO = sCRFAExceptionParamVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Type
				List<String> 	statusCdList 	= new ArrayList<String>();
				String[] 		statusCdArray 	= sCRFAExceptionParamVO.getRqstStsCd().split(",");
				
				for (int i = 0 ; i < statusCdArray.length ; i++) {
					statusCdList.add(statusCdArray[i]);
			    }
				velParam.put("sts_cd_list", statusCdList);
				
				//2.Tariff
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = sCRFAExceptionParamVO.getTariff().split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//3.Ref. Office
				List<String> ofcCdList = new ArrayList<String>();
				String[] ofcCdArray = sCRFAExceptionParamVO.getOfcCd().split(",");
				for (int i = 0 ; i < ofcCdArray.length ; i++) {
					ofcCdList.add(ofcCdArray[i]);
			    }
				velParam.put("dmdt_ofc_list", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchBeforeBookingListByCoverageRSQL(), param, velParam);	
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCRFAExceptionListVO .class);
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
	 * S/C, RFA Exception를 조회 합니다. <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCRFAExceptionListVO> searchBeforeBookingListByDAR(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws DAOException {
		DBRowSet 						dbRowset 	= null;
		List<SCRFAExceptionListVO> 		list 		= null;
		//query parameter
		Map<String, Object> 			param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 			velParam 	= new HashMap<String, Object>();
		
		try{
			if (sCRFAExceptionParamVO != null) {
				Map<String, String> mapVO = sCRFAExceptionParamVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Type
				List<String> 	statusCdList 	= new ArrayList<String>();
				String[] 		statusCdArray 	= sCRFAExceptionParamVO.getRqstStsCd().split(",");
				
				for (int i = 0 ; i < statusCdArray.length ; i++) {
					statusCdList.add(statusCdArray[i]);
			    }
				velParam.put("sts_cd_list", statusCdList);
				
				//2.Tariff
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = sCRFAExceptionParamVO.getTariff().split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//3.Ref. Office
				List<String> ofcCdList = new ArrayList<String>();
				String[] ofcCdArray = sCRFAExceptionParamVO.getOfcCd().split(",");
				for (int i = 0 ; i < ofcCdArray.length ; i++) {
					ofcCdList.add(ofcCdArray[i]);
			    }
				velParam.put("dmdt_ofc_list", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchBeforeBookingListByDARRSQL(), param, velParam);	
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCRFAExceptionListVO .class);
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
	 * Proposal No. 에 해당되는 SC No.와 Customer Code, Customer Name을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCExceptionCustomerVO> searchSCNoCustomerByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOSearchSCNoCustomerByProposalNoRSQL(), param, velParam);				
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCustomerVO .class);
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
	 * Proposal No 의 S/C Duration 데이터를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionParmVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SCExceptionParmVO searchSCDuration(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		SCExceptionParmVO resultVO = null;
		List<SCExceptionParmVO> resultVOS = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOSearchSCDurationRSQL(), param, velParam);				
			resultVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionParmVO .class);
			
			if (resultVOS != null && resultVOS.size() > 0) {
				resultVO = resultVOS.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVO;
	}
	
	/**
	 * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean hasAcceptAuth(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOHasAcceptAuthRSQL(), param, velParam);				

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
	 * Affiliate Customer 를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCExceptionCustomerVO> searchAffiliateListBySC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchAffiliateListBySCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCustomerVO .class);
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
	 * Customer Type 이 'Affiliate' 인지를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception DAOException
	 */
	 public boolean checkAffiliateCustomer(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new SCExceptionTariffMgtDBDAOCheckAffiliateCustomerRSQL(), param, velParam);				

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
	 * Customer 가 S/C Customer 인지 조회 합니다. <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isSCCustomer(String custCntCd, String custSeq) throws DAOException {
		boolean result = false;		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOIsSCCustomerRSQL(), param, null);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
				
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
	 * Prop No. 에 해당하는 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param String sCNo
	 * @return List<SCExceptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCExceptionVO> searchSCExceptionListByPropNo(String sCNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			param.put("prop_no", sCNo);
			velParam.put("prop_no", sCNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCExceptionListByPropNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionVO .class);
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
	 * Customer Code 에 해당하는 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param String custNo
	 * @return List<SCExceptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<SCExceptionVO> searchSCExceptionListByCustomer(String custNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			param.put("cust_cd", custNo);
			velParam.put("cust_cd", custNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCExceptionListByCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionVO .class);
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
	 * Proposal No., Version No. 에 해당하는 S/C Exception를 삭제 합니다. <br>
	 * 
	 * @param  SCExceptionDeleteVO sCExceptionDeleteVO
	 * @throws DAOException
	 */
	public void removeSCExceptionByPropVerNo(SCExceptionDeleteVO sCExceptionDeleteVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionDeleteVO != null) {
				Map<String, String> mapVO = sCExceptionDeleteVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sQLExecuter = new SQLExecuter("");
			
			//1.S/C Exception Tariff 의 Commodity 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveCommodityByPropVerNoDSQL(), param, velParam);
			
			//2.S/C Exception Tariff 의 Actual Customer 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveActCustByPropVerNoDSQL(), param, velParam);
			
			//3.S/C Exception Tariff 의 Rate Adjustment 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveRTAdjustByPropVerNoDSQL(), param, velParam);
			
			//4.S/C Exception Tariff 의 Tiered Free Time 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveTieredFTByPropVerNoDSQL(), param, velParam);
			
			//5.S/C Exception Tariff 의 Multi Coverage 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveMultiCVRGByPropVerNoDSQL(), param, velParam);
			
			//6.S/C Exception Tariff 의 Group 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionByPropVerNoDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 S/C Exception Tariff 의 모든 Commodity 정보를 삭제 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionCommodity(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionCommodityDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 S/C Exception Tariff 의 모든 Customer 정보를 삭제 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionCustomer(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionCustomerDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 선택한 S/C Exception Tariff 의 모든 RateAdjustment 정보를 삭제 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionRateAdjustment(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionRateAdjustmentDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 S/C Exception Tariff 의 모든 Free Time 정보를 삭제 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionFreeTime(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionFreeTimeDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 S/C Exception Tariff 의 Group Seq. 정보를 삭제 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionTariff(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionTariffDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 S/C Exception Tariff 의 모든 Coverage 정보를 삭제 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionCoverage(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAORemoveSCExceptionCoverageDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 S/C Exception Tariff 의 다음 Version Seq. 정보를 조회 합니다.<br>
	 * 
	 * @param  String propNo
	 * @return String
	 * @throws DAOException
	 */	
	public String searchSCExceptionVersionSeq(String propNo)  throws DAOException {
		String				result		= null;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			param.put("prop_no", propNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCExceptionVersionSeqRSQL(), param, null);
			
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
	 * 선택한 S/C Exception Tariff 의 다음 Group Seq. 정보를 조회 합니다.<br>
	 * 
	 * @param  SCExceptionVO sCExceptionVO
	 * @return String
	 * @throws DAOException
	 */	
	public String searchSCExceptionGroupSeq(SCExceptionVO sCExceptionVO)  throws DAOException {
		String				result		= null;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionVO != null) {
				Map<String, String> mapVO = sCExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchSCExceptionGroupSeqRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getInt(1) + "";
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
	 * 이전 버전의 모든 S/C Exception Tariff Group 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionGroupOfPrevVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionGroupOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 이전 버전의 모든 S/C Exception Tariff Multi Coverage 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionCoverageOfPrevVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionCoverageOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 이전 버전의 모든 S/C Exception Tariff Free Time 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionFreeTimeOfPrevVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionFreeTimeOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 이전 버전의 모든 S/C Exception Tariff Rate Adjustment 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionRateAdjustmentOfPrevVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionRateAdjustmentOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 이전 버전의 모든 S/C Exception Tariff Customer 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionCustomerOfPrevVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionCustomerOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 이전 버전의 모든 S/C Exception Tariff Commodity 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionCommodityOfPrevVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionCommodityOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Tariff History 팝업에서 선택한 버전의 모든 S/C Exception Tariff Group 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionGroupOfHistVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionGroupOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * S/C Exception Tariff History 팝업에서 선택한 버전의 모든 S/C Exception Tariff Multi Coverage 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionCoverageOfHistVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionCoverageOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Tariff History 팝업에서 선택한 버전의 모든 S/C Exception Tariff Free Time 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionFreeTimeOfHistVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionFreeTimeOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * S/C Exception Tariff History 팝업에서 선택한 버전의 모든 S/C Exception Tariff Rate Adjustment 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionRateAdjustmentOfHistVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionRateAdjustmentOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * S/C Exception Tariff History 팝업에서 선택한 버전의 모든 S/C Exception Tariff Customer 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionCustomerOfHistVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionCustomerOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * S/C Exception Tariff History 팝업에서 선택한 버전의 모든 S/C Exception Tariff Commodity 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionCommodityOfHistVersion(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOAddSCExceptionCommodityOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 화면에서 입력한 S/C 정보와 기등록된 S/C 정보중 중복된 데이터가 있는지 조회 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isDuplicateSC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//result object
		boolean 				isDuplicate	= false;
		DBRowSet				dbRowSet	= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Coverage >==================================================================================
				List<String> 	coverageList 	= new ArrayList<String>();
				String[] 		coverageArray 	= sCExceptionParmVO.getCoverageList().split("\\|");
				for (int i = 0 ; i < coverageArray.length ; i++) {
					coverageList.add(coverageArray[i]);
				}				
				velParam.put("list_coverage", coverageList);
				//============================================================================================
				
				//Actual Customer >===========================================================================
				List<String> 	actCustList 	= new ArrayList<String>();
				String[] 		actCustArray 	= sCExceptionParmVO.getActCustList().split("\\|");
				for (int i = 0 ; i < actCustArray.length ; i++) {
					actCustList.add(actCustArray[i]);
				}				
				velParam.put("list_act_cust", actCustList);
				//============================================================================================
				
				//Commodity
				List<String> 	cmdtList 		= new ArrayList<String>();
				String[] 		cmdtArray 		= sCExceptionParmVO.getCmdtList().split("\\|");
				for (int i = 0 ; i < cmdtArray.length ; i++) {
					cmdtList.add(cmdtArray[i]);
				}				
				velParam.put("list_cmdt", cmdtList);
				//============================================================================================
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOIsDuplicateSCRSQL(), param, velParam);
			
			if (dbRowSet.next()) {
				isDuplicate = dbRowSet.getInt(1) > 0 ? true : false;
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isDuplicate;
	}	
	
	/**
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @return String
	 * @throws DAOException
	 */
	public boolean isCustomerByPriMn(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//result object
		boolean  				isCustomer	= false;
		DBRowSet				dbRowSet	= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		try {
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOIsCustomerByPriMnRSQL(), param, velParam);
			if (dbRowSet.next()) {
				isCustomer = dbRowSet.getInt("cnt") > 0 ? true : false;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isCustomer;
	}

	/**
	 * Proposal No. 에 해당하는 DMT에 존재하는 Actual Customer 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCExceptionCustomerVO> searchCustomerListByDMTSC(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new SCExceptionTariffMgtDBDAOSearchCustomerListByDMTSCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCustomerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
}
