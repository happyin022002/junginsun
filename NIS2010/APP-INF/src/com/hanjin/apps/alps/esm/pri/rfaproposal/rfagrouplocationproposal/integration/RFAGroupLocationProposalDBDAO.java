/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationProposalDBDAO.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.06 변영주
* 1.0 Creation
* =========================================================
* History
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.basic.RFAGroupLocationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;


/**
 * NIS2010 RFAGroupLocationProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see RFAGroupLocationProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class RFAGroupLocationProposalDBDAO extends DBDAOSupport {

	 
	/**
	 * PRI_RP_SCP_RT_ROUT_PNT,PRI_RP_SCP_RT_ROUT_VIA, <br>
	 * PRI_RP_SCP_GRI_ROUT_PNT, PRI_RP_SCP_GRI_ROUT_VIA에서의 데이터존재 유무를 확인합니다.<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @param List<String> txtArr
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriRpScpGrpLocVO priRpScpGrpLocVO, List<String> txtArr) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpLocVO != null){
				Map<String, String> mapVO = priRpScpGrpLocVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltRtApplyListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * LOCATION GROUP DETAIL을 조회한다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
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
	 * LOCATION GROUP MASTER를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchGroupLocationList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpLocVO != null){
				Map<String, String> mapVO = priRpScpGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * LOCATION GROUP MASTER를 생성한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocation(List<PriRpScpGrpLocVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocVOCSQL(), insModels,null);
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
	 * LOCATION GROUP MASTER를 수정한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocation(List<PriRpScpGrpLocVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocVOUSQL(), updModels,null);
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
	 * LOCATION GROUP MASTER 삭제시 DETAIL 정보를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeMasterGroupLocationDetail(List<PriRpScpGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVODSQL(), delModels,velParam);
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
	 * LOCATION GROUP MASTER를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeMasterGroupLocation(List<PriRpScpGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocVODSQL(), delModels,velParam);
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
	 * LOCATION GROUP MASTER 삭제시 DETAIL 정보를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeMasterGroupLocationAmend(List<PriRpScpGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlGrpAmdVODSQL(), delModels,velParam);
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
	 * LOCATION GROUP MASTER 삭제시 DETAIL 정보를 수정한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void modifyMasterGroupLocationAmend(List<PriRpScpGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlGrpAmdVOUSQL(), delModels,velParam);
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
	 * LOCATION GROUP DETAIL을 생성한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationDetail(List<PriRpScpGrpLocDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVOCSQL(), insModels,null);
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
	 * LOCATION GROUP DETAIL을 수정한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocationDetail(List<PriRpScpGrpLocDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVOUSQL(), updModels,null);
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
	 * LOCATION GROUP DETAIL의 모든데이터를 수정한다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @exception DAOException
	 */
	public void modifyAllGroupLocationDetail(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws DAOException,Exception {
		
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
            Map<String, String> mapVO = priRpScpGrpLocDtlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlAllVOUSQL(),
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
	 * LOCATION GROUP DETAIL을 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGrpLocDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocationDetail(List<PriRpScpGrpLocDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVODSQL(), delModels,velParam);
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
	 * LOCATION GROUP MASTER의 데이터를 AMEND SEQ +1 생성한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocAmdVOCSQL(), insModels,null);
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
	 * LOCATION GROUP DETAIL의 데이터를 AMEND SEQ +1 생성한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationDetailAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlAmdVOCSQL(), insModels,null);
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
	 * LOCATION GROUP GUIDELINE MASTER의 데이터를  복사한다.<br><br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return int 
	 * @exception DAOException
	 */
	public int addProposalMainGroupLocationGlineCopy(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws DAOException,Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
                
		try {
            Map<String, String> mapVO = priRpScpGrpLocDtlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOPriRpScpGrpLocGlineCpVOCSQL(),
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
	 * LOCATION GROUP GUIDELINE DETAIL의 데이터를  복사한다.<br><br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int addProposalMainGroupLocationDetailGlineCopy(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws DAOException,Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
                
		try {
            Map<String, String> mapVO = priRpScpGrpLocDtlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlGlineCpVOCSQL(),
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
     * RFA Proposal Scope Group Location 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeLocation (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOPropCpPriRpScpGrpLocCSQL(),
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
     * RFA Proposal Scope Group Location Detail 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeLocationDtl (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOPropCpPriRpScpGrpLocDtlCSQL(),
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
     * Guideline Location Group 정보를 Copy하여 Proposal Location Group 정보를 생성합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpLoc (RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOGlineCopyPriRpScpGrpLocCSQL(),
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
     * Guideline Location Group Detail 정보를 Copy하여 Proposal Location Group Detail 정보를 생성합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpLocDtl (RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOGlineCopyPriRpScpGrpLocDtlCSQL(),
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
	 * Location Group 을 All Accept/All Accept Cancel 시 유효한 데이터가 있는지 조회합니다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchGroupLocationDetailStatusList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(priRpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltGrpLocDtlStsListVORSQL(), param, velParam);
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
     *  SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
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
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOPriRpScpGrpLocAllVODSQL(), param, velParam);
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
     * @exception DAOException
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
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlAllVODSQL(), param, velParam);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(List<PriRpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlRequestCancelVOUSQL(), updModels,null);
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
	 * LOCATION GROUP DETAIL을 조회한다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltGrpLocDtlHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
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
	 * LOCATION GROUP MASTER를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpLocVO != null){
				Map<String, String> mapVO = priRpScpGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltGrpLocHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * MDM_LOCATION 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchServiceScopeLocationCodeList(RsltCdListVO rsltCdListVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdListVO != null) {
				Map<String, String> mapVO = rsltCdListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGroupLocationProposalDBDAORsltLocCdListVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * LOCATION GROUP DETAIL을 조회한다.<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priRpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltGrpLocDtlInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
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
	 * LOCATION GROUP MASTER를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpGrpLocVO != null){
				Map<String, String> mapVO = priRpScpGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltGrpLocInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
     * PRS Location Group 정보를 Copy 하여 Proposal Location Group 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
     * @exception DAOException
     */
    public void addCopyRfaQuotationPriRpScpGrpLoc (RsltCopyToProposalVO rsltCopyToProposalVO) throws DAOException, Exception {
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
                    (ISQLTemplate) new RFAGroupLocationProposalDBDAORqCpPriRpScpGrpLocCSQL(), param, velParam);
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
     * PRS Location Group 정보를 Copy 하여 Proposal Location Group detail 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
     * @exception DAOException
     */
    public void addCopyRfaQuotationPriRpScpGrpLocDtl (RsltCopyToProposalVO rsltCopyToProposalVO) throws DAOException, Exception {
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
                    .executeUpdate((ISQLTemplate) new RFAGroupLocationProposalDBDAORqCpPriRpScpGrpLocDtlCSQL(),
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
     * Summary 팝업에서 승인 대상인 모든 Service Scope Location 변경 리스트를 조회한다.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltGrpLocDtlListVO>
     * @throws EventException
     */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchAllGroupLocationList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpRtCmdtHdrVO != null){
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupLocationProposalDBDAORsltAllLocListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	 
}