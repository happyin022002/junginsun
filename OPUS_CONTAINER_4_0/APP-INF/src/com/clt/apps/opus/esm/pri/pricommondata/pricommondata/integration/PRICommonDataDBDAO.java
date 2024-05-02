/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDataDBDAO.java
*@FileTitle : PRI Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.04.16 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.basic.PRICommonDataBCImpl;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.PriRcvDeTermMapgVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeGroupingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyMappingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriScgPctBseChgVO;
import com.clt.syscommon.common.table.PriScgPctBseVO;
import com.clt.syscommon.common.table.PriSvcScpPptMapgVO;
import com.clt.syscommon.common.table.PriSvcScpPptVO;

/**
 * PRICommonDataDBDAO <br>
 * - PRI system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHKIM
 * @see PRICommonDataBCImpl 참조
 * @since J2EE 1.6
 */
public class PRICommonDataDBDAO extends DBDAOSupport {

	/**
	 * ESM_PRI_5004 : Retrieve <br>
	 * 입력한 PRI에 해당하는 PRI 조회
	 * @param PriSvcScpPptVO priSvcScpPptVO
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception DAOException
	 */
	public List<RsltServiceScopePropertyVO> searchServiceScopeProperty(PriSvcScpPptVO priSvcScpPptVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltServiceScopePropertyVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSvcScpPptVO != null){
				Map<String, String> mapVO = priSvcScpPptVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDataDBDAORsltServiceScopePropertyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltServiceScopePropertyVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * ESM_PRI_5004 : SAVE INSERT<br>
	 * PRI insert
	 * 
	 * @param PriSvcScpPptVO priSvcScpPptVO
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception DAOException
	 */
	public List<RsltServiceScopePropertyVO> addServiceScopeProperty(PriSvcScpPptVO priSvcScpPptVO) throws DAOException {

		List<RsltServiceScopePropertyVO> list = new ArrayList<RsltServiceScopePropertyVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSvcScpPptVO != null){
				Map<String, String> mapVO = priSvcScpPptVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = 0;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PRICommonDataDBDAOServiceScopePropertyVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_5004 : SAVE UPDATE<br>
	 * PRI update
	 * 
	 * @param PriSvcScpPptVO priSvcScpPptVO
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception DAOException
	 */
	public List<RsltServiceScopePropertyVO> modifyServiceScopeProperty(PriSvcScpPptVO priSvcScpPptVO) throws DAOException {
		// TODO Auto-generated method stub

		List<RsltServiceScopePropertyVO> list = new ArrayList<RsltServiceScopePropertyVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSvcScpPptVO != null){
				Map<String, String> mapVO = priSvcScpPptVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = 0;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PRICommonDataDBDAOServiceScopePropertyVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * ESM_PRI_5004 : SAVE DELECT<br>
	 * PRI delete
	 * 
	 * @param PriSvcScpPptVO priSvcScpPptVO
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception DAOException
	 */
	public List<RsltServiceScopePropertyVO> removeServiceScopeProperty(PriSvcScpPptVO priSvcScpPptVO) throws DAOException {

		List<RsltServiceScopePropertyVO> list = new ArrayList<RsltServiceScopePropertyVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSvcScpPptVO != null){
				Map<String, String> mapVO = priSvcScpPptVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = 0;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PRICommonDataDBDAOServiceScopePropertyVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_PRI_5005 : Retrieve <br>
	 * 입력한 PRI에 해당하는 PRI 조회
	 * @param PriSvcScpPptMapgVO priSvcScpPptMapgVO
	 * @return List<RsltServiceScopePropertyMappingVO>
	 * @exception DAOException
	 */
	public List<RsltServiceScopePropertyMappingVO> searchServiceScopePropertyMapping(PriSvcScpPptMapgVO priSvcScpPptMapgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltServiceScopePropertyMappingVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSvcScpPptMapgVO != null){
				Map<String, String> mapVO = priSvcScpPptMapgVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDataDBDAORsltServiceScopePropertyMappingVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltServiceScopePropertyMappingVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_PRI_5005 : SAVE INSERT<br>
	 * PRI insert
	 * 
	 * @param PriSvcScpPptMapgVO priSvcScpPptMapgVO
	 * @return List<RsltServiceScopePropertyMappingVO>
	 * @exception DAOException
	 */
	public List<RsltServiceScopePropertyMappingVO> addServiceScopePropertyMapping(PriSvcScpPptMapgVO priSvcScpPptMapgVO) throws DAOException {

		List<RsltServiceScopePropertyMappingVO> list = new ArrayList<RsltServiceScopePropertyMappingVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSvcScpPptMapgVO != null){
				Map<String, String> mapVO = priSvcScpPptMapgVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = 0;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PRICommonDataDBDAOServiceScopePropertyMappingVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * ESM_PRI_5005 : SAVE DELECT<br>
	 * PRI delete
	 * 
	 * @param PriSvcScpPptMapgVO priSvcScpPptMapgVO 
	 * @return List<RsltServiceScopePropertyMappingVO>
	 * @exception DAOException
	 */
	public List<RsltServiceScopePropertyMappingVO> removeServiceScopePropertyMapping(PriSvcScpPptMapgVO priSvcScpPptMapgVO) throws DAOException {

		List<RsltServiceScopePropertyMappingVO> list = new ArrayList<RsltServiceScopePropertyMappingVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSvcScpPptMapgVO != null){
				Map<String, String> mapVO = priSvcScpPptMapgVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = 0;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PRICommonDataDBDAOServiceScopePropertyMappingVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * ESM_PRI_5002 : Retrieve <br>
	 * 
	 * @return List<searchPercentBaseCharge>
	 * @exception DAOException
	 */
	public List<RsltPercentBaseChargeVO> searchPercentBaseCharge() throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPercentBaseChargeVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDataDBDAOSearchPercentBaseChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPercentBaseChargeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_5002 : sheet1 on select cell <br>
	 * 
	 * @param PriScgPctBseVO priScgPctBseVO
	 * @return List<RsltPercentBaseChargeGroupingVO>
	 * @exception DAOException
	 */
	public List<RsltPercentBaseChargeGroupingVO> searchPercentBaseChargeGrouping(PriScgPctBseVO priScgPctBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPercentBaseChargeGroupingVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priScgPctBseVO != null){
				Map<String, String> mapVO = priScgPctBseVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDataDBDAOSearchPercentBaseChargeGroupingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPercentBaseChargeGroupingVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_5002 : sheet1 SAVE <br>
	 * adding PCT_BSE_CD
	 * 
	 * @param List<PriScgPctBseVO> insModels
	 * @exception DAOException
	 */
	public void addPercentBaseCharge(List<PriScgPctBseVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PRICommonDataDBDAOAddPercentBaseChargeCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_5002 : sheet1 SAVE <br>
	 * updating PCT_BSE_CD
	 * 
	 * @param List<PriScgPctBseVO> priScgPctBseVOs
	 * @exception DAOException
	 */
	public void modifyPercentBaseCharge(List<PriScgPctBseVO> priScgPctBseVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(priScgPctBseVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PRICommonDataDBDAOModifyPercentBaseChargeUSQL(), priScgPctBseVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_5002 : sheet1 SAVE <br>
	 * deleting PCT_BSE_CD
	 * 
	 * @param List<PriScgPctBseVO> priScgPctBseVOs
	 * @exception DAOException
	 */
	public void removePercentBaseCharge(List<PriScgPctBseVO> priScgPctBseVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(priScgPctBseVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PRICommonDataDBDAORemovePercentBaseChargeDSQL(), priScgPctBseVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_5002 : sheet2 SAVE <br>
	 * adding CHG_CD
	 * 
	 * @param List<PriScgPctBseChgVO> insModels
	 * @exception DAOException
	 */
	public void addPercentBaseChargeGrouping(List<PriScgPctBseChgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PRICommonDataDBDAOAddPercentBaseChargeGroupingCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_5002 : sheet2 SAVE <br>
	 * deleting CHG_CD
	 * 
	 * @param List<PriScgPctBseChgVO> priScgPctBseChgVOs
	 * @exception DAOException
	 */
	public void removePercentBaseChargeGrouping(List<PriScgPctBseChgVO> priScgPctBseChgVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(priScgPctBseChgVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PRICommonDataDBDAORemovePercentBaseChargeGroupingDSQL(), priScgPctBseChgVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BKG Term Mapping Creation 정보를 조회해 온다.<br>
	 * 
	 * @return List<PriRcvDeTermMapgVO>
	 * @throws DAOException
	 */
	public List<PriRcvDeTermMapgVO> searchBookingTermMappingList() throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRcvDeTermMapgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDataDBDAOSearchBookingTermMappingListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRcvDeTermMapgVO.class);
			
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
	 * BKG Term Mapping Creation 정보를 생성한다.<br>
	 * 
	 * @param List<PriRcvDeTermMapgVO> insertVoList
	 * @throws DAOException
	 */
	public void addBookingTermMapping(List<PriRcvDeTermMapgVO> insertVoList) throws DAOException {
		
		
		int creCnt[] = null;
		try{
		
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PRICommonDataDBDAOAddBookingTermMappingCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}
	
	
	
	

	/**
	 * BKG Term Mapping Creation 정보를 삭제한다.<br>
	 * 
	 * @param List<PriRcvDeTermMapgVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeBookingTermMapping(List<PriRcvDeTermMapgVO> deleteVoList) throws DAOException {
		

		
		
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PRICommonDataDBDAORemoveBookingTermMappingDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
}

