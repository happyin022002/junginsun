/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAO.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
=========================================================
* History
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.basic.RFAGroupCommodityProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;


/**
 * NIS2010 RFAGroupCommodityProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see RFAGroupCommodityProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class RFAGroupCommodityProposalDBDAO extends DBDAOSupport {

	/**
	 * RATE에 데이터가 존재하는지 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO
	 * @param List<String> txtArr
	 * @return List<RsltGrpCmdtListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList (PriRpScpGrpCmdtVO priRpScpGrpCmdtVO, List<String> txtArr) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltRtApplyListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * COMMODITY GROUP DETAIL정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpCmdtDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtDtlListVO .class);
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
	 * COMMODITY GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltGrpCmdtListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * COMMODITY GROUP GUIDELINE MASTER정보를 COPY합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addProposalMainGroupCommodityGlineCopy(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws DAOException,Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
                
		try {
            Map<String, String> mapVO = priRpScpGrpCmdtDtlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            
            return result;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		

	/**
	 * COMMODITY GROUP GUIDELINE DETAIL정보를 COPY합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addProposalMainGroupCommodityDetailGlineCopy(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws DAOException,Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
                
		try {
            Map<String, String> mapVO = priRpScpGrpCmdtDtlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            
            return result;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * COMMODITY GROUP MASTER정보를 추가합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addcopyProposal(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpGrpCmdtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * COMMODITY GROUP MASTER정보를 수정합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifycopyProposal(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpGrpCmdtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * COMMODITY GROUP MASTER정보를 삭제합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removecopyProposal(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpGrpCmdtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * COMMODITY GROUP MASTER정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGroupCommodity(List<PriRpScpGrpCmdtVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * COMMODITY GROUP DETAIL정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtDtlVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGroupCommodityDetail(List<PriRpScpGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 *AMEND시 MASTER에서 삭제할 경우 DETAIL의 모든 데이터를 AMEND DELETE처리한다.
	 * 
	 * @param List<PriRpScpGrpCmdtVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyGroupCommodity(List<PriRpScpGrpCmdtVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * COMMODITY GROUP DETAIL정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtDtlVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyGroupCommodityDetail(List<PriRpScpGrpCmdtDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
		
	/**
	 * COMMODITY GROUP DETAIL정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtDtlVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeGroupCommodityDetail(List<PriRpScpGrpCmdtDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * COMMODITY GROUP 정보 삭제시 DETAIL 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeMasterGroupCommodityDetail(List<PriRpScpGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");

				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * COMMODITY GROUP 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeMasterGroupCommodity(List<PriRpScpGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * COMMODITY GROUP 정보 삭제시 DETAIL 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeMasterGroupCommodityAmend(List<PriRpScpGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlGrpAmdVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * COMMODITY GROUP 정보 삭제시 DETAIL 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpGrpCmdtVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMasterGroupCommodity(List<PriRpScpGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlGrpAmdVOUSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}					
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Group Commodity 를 Amend 한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGroupCommodityAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Group Commodity Detail을 Amend 한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGroupCommodityDetailAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

    /**
     * RFA Proposal Scope Group Commodity 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @throws DAOException
	 * @throws Exception
     */
    public void addCopyProposalScopeCommodity (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOPropCpPriRpScpGrpCmdtCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Group Commodity Detail 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @throws DAOException
	 * @throws Exception
     */
    public void addCopyProposalScopeCommodityDtl (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOPropCpPriRpScpGrpCmdtDtlCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     *  SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @throws DAOException
	 * @throws Exception
     */
    public void removeProposal (PriRpScpMnVO priRpScpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtAllVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     *  SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @throws DAOException
	 * @throws Exception
     */
    public void removeProposalContent (PriRpScpMnVO priRpScpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlAllVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }     
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	

	/**
	 * COMMODITY GROUP DETAIL정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchGroupCommodityDetailStatusList (PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(priRpScpGrpCmdtDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlStsListVORSQL(), param, velParam);
			cnt = dbRowset.getRowCount();
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;
	}       
	 
	/**
	 * COMMODITY GROUP DETAIL정보를 수정합니다.
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyAllGroupCommodityDetail(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws DAOException,Exception {
		
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
            Map<String, String> mapVO = priRpScpGrpCmdtDtlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlAllVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	 
     
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyProposalRequestCancel(List<PriRpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityProposalDBDAOPriRpScpGrpCmdtDtlRequestCancelVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * COMMODITY GROUP DETAIL정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpCmdtDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtDtlListVO .class);
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
	 * COMMODITY GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltGrpCmdtHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * COMMODITY GROUP DETAIL정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpCmdtDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtDtlListVO .class);
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
	 * COMMODITY GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priRpScpGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltGrpCmdtInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
     * Guideline Commodity Group 정보를 Copy 하여 Proposal Commodity Group 정보를 생성합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @throws DAOException
     */
    public void addCopyScopeGuidelineGrpCmdt (RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFAGroupCommodityProposalDBDAOGlineCopyPriRpScpGrpCmdtCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Guideline Commodity Group Detail 정보를 Copy 하여 Proposal Commodity Group Detail 정보를 생성합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @throws DAOException
     */
    public void addCopyScopeGuidelineGrpCmdtDtl (RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe
                    .executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAOGlineCopyPriRpScpGrpCmdtDtlCSQL(),
                            param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    
    /**
     * PRS Commodity Group 정보를 Copy 하여 Proposal Commodity Group 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
     * @throws DAOException
     */
    public void addCopyRfaQuotationPriRpScpGrpCmdt (RsltCopyToProposalVO rsltCopyToProposalVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltCopyToProposalVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFAGroupCommodityProposalDBDAORqCpPriRpScpGrpCmdtCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * PRS Commodity Group 정보를 Copy 하여 Proposal Commodity Group detail 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
     * @throws DAOException
     */
    public void addCopyRfaQuotationPriRpScpGrpCmdtDtl (RsltCopyToProposalVO rsltCopyToProposalVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltCopyToProposalVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe
                    .executeUpdate((ISQLTemplate) new RFAGroupCommodityProposalDBDAORqCpPriRpScpGrpCmdtDtlCSQL(),
                            param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Summary 팝업에서 승인 대상인 모든 Service Scope Commodity Group 변경 리스트를 조회한다.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltGrpCmdtDtlListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<RsltGrpCmdtDtlListVO> searchAllGroupCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpRtCmdtHdrVO != null){
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityProposalDBDAORsltAllCmdtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
    }
}