/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalDBDAO.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.18 문동규
* 1.0 Creation
=========================================================
 * History
 * 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.basic.RFANoteProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;


/**
 * NIS2010 RFANoteProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see RFANoteProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class RFANoteProposalDBDAO extends DBDAOSupport {
		 
	/**
	 *  SPECIAL NOTE GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteListVO> searchNoteList(PriRpScpNoteListVO priRpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteListVO != null){
				Map<String, String> mapVO = priRpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAORsltNoteListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 *  SPECIAL NOTE GROUP CONTENTS정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchNoteContentList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteCtntVO != null){
				Map<String, String> mapVO = priRpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAORsltNoteCtntListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 *  SPECIAL NOTE GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteCtntVO != null){
				Map<String, String> mapVO = priRpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpSpecNoteCtntListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 	 
	/**
	 *  SPECIAL NOTE GROUP MASTER정보를 AMEND처리합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalNoteAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Special Note Detail에 대한 Amend처리를 한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalNoteContentAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * SPECIAL NOTE GROUP MASTER정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpNoteListVO> insModels
	 * @exception DAOException
	 */
	public void addNote(List<PriRpScpNoteListVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP MASTER정보를 변경합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @exception DAOException
	 */
	public void modifyNote(PriRpScpNoteListVO priRpScpNoteListVO) throws DAOException,Exception {		
	    // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpNoteListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


    /**
     * RFA Proposal Scope Special Note 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeNote (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPropCpPriRpScpNoteCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
     * RFA Proposal Scope Special Note Content 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeNoteCtnt (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPropCpPriRpScpNoteCtntCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
	/**
	 * SPECIAL NOTE GROUP정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpNoteListVO> updModels
	 * @exception DAOException
	 */
	public void modifyNote(List<PriRpScpNoteListVO> updModels) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE 정보 수정시 CONTENTS정보를 삭제합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @exception DAOException
	 */
	public void removeGroupNoteContent(PriRpScpNoteListVO priRpScpNoteListVO) throws DAOException,Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = priRpScpNoteListVO.getColumnValues();
			
            param.putAll(mapVO);
            velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
            
			SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteCtntVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE 정보 수정시 CONTENTS정보를 수정합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @exception DAOException
	 */
	public void modifyGroupNoteContent(PriRpScpNoteListVO priRpScpNoteListVO) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
       	Map<String, Object> velParam = new HashMap<String, Object>();
       
       	try {
       		Map<String, String> mapVO = priRpScpNoteListVO.getColumnValues();
			
          	param.putAll(mapVO);
          	velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
           
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteCtntVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to udate SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpNoteListVO> delModels
	 * @exception DAOException
	 */
	public void removeNote(List<PriRpScpNoteListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");// MASTER에서 DELETE 버튼 이벤트시 사용
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpNoteListVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupNoteContent(List<PriRpScpNoteListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");// MASTER에서 DELETE 버튼 이벤트시 사용
				
				//MASTER에 해당하는 DETAIL의 모든 데이터를 삭제한다.
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP CONTENTS정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpNoteCtntListVO> insModels
	 * @exception DAOException
	 */
	public void addNoteContent(List<PriRpScpNoteCtntListVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP CONTENTS정보를 변경합니다.<br>
	 * 
	 * @param List<PriRpScpNoteCtntListVO> updModels
	 * @exception DAOException
	 */
	public void modifyNoteContent(List<PriRpScpNoteCtntListVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_master_delete", "N");
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP CONTENTS정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpNoteCtntListVO> delModels
	 * @exception DAOException
	 */
	public void removeNoteContent(List<PriRpScpNoteCtntListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); // SCOPE별 삭제시 사용
				velParam.put("is_master_delete", "N");// MASTER에서 DELETE 버튼 이벤트시 사용
					
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				
			
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP DETAIL정보를 ACCEPT처리합니다.<br>
	 * 
	 * @param List<PriRpScpNoteCtntVO> updModels
	 * @exception DAOException
	 */
	public void modifyAcceptNote(List<PriRpScpNoteCtntVO> updModels) throws DAOException,Exception {		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
			int updCnt[] = null;
			if(updModels.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");
				velParam.put("is_all_accept", "N");
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntActVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE GROUP DETAIL정보를 ACCEPT처리합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @exception DAOException
	 */
	public void modifyAcceptAllNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException,Exception {
		 // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpNoteCtntVO.getColumnValues();
			
            param.putAll(mapVO);
            velParam.put("is_all_accept", "Y");
            
			SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteCtntActVOUSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
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
            velParam.put("is_scope_delete", "Y"); // SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");// MASTER에서 DELETE 버튼 이벤트시 사용

			//NOTE
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            /*
            //NOTE CONTENTS
            sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteCtntVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }				
            */      
                        
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
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
            velParam.put("is_scope_delete", "Y"); // SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");// MASTER에서 DELETE 버튼 이벤트시 사용
			/*
			//NOTE
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            */
            //NOTE CONTENTS
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteCtntVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }				
                  
                        
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
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
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntRequestCancelVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
    
	/**
	 * Main Request 시 자동으로 Accept를 합니다.<br>
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @exception DAOException
	 */
	public void modifyAutoAcceptProposalNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpNoteCtntVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteProposalDBDAOPriRpScpNoteCtntAutoAcceptVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }	
			
			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * STATUS가 ACCEPT가 아닌 데이터를 조회한다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchAllAcceptDataList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteCtntVO != null){
				Map<String, String> mapVO = priRpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntActVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	/**
	 *  SPECIAL NOTE GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteListVO> searchNoteHistoryList(PriRpScpNoteListVO priRpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteListVO != null){
				Map<String, String> mapVO = priRpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAORsltNoteHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 *  SPECIAL NOTE GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchSpecialNoteContentHistoryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteCtntVO != null){
				Map<String, String> mapVO = priRpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpSpecNoteCtntHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	/**
	 *  SPECIAL NOTE GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteListVO> searchNoteInquiryList(PriRpScpNoteListVO priRpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteListVO != null){
				Map<String, String> mapVO = priRpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAORsltNoteInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 *  SPECIAL NOTE GROUP MASTER정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchSpecialNoteContentInquiryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpNoteCtntVO != null){
				Map<String, String> mapVO = priRpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpSpecNoteCtntInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
		
	/**
     * 이전SEQ에 해당하는 NOTE의 MAX DP_SEQ를 조회한다.<br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception DAOException
     */
    public String searchNoteMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	String maxDpSeq = null;
            if(priRpScpNoteCtntVO != null){
                Map<String, String> mapVO = priRpScpNoteCtntVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteMaxDpSeqRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	maxDpSeq = dbRowset.getString(1);
            }
            
            return maxDpSeq;
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
	/**
     * 이전SEQ에 해당하는 NOTE CONTENT의 MAX DP_SEQ를 조회한다.<br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception DAOException
     */
    public String searchNoteContentMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	String maxDpSeq = null;
            if(priRpScpNoteCtntVO != null){
                Map<String, String> mapVO = priRpScpNoteCtntVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteCtntMaxDpSeqRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	maxDpSeq = dbRowset.getString(1);
            }
            
            return maxDpSeq;
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

	/**
	 * Accept All 화면의 SPECIAL NOTE의 Special Notes 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltNoteCtntListVO> searchAllSpecialNoteContentList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteProposalDBDAORsltAllSpecNoteCtntListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Master RFA에서 Request Cancel시 Note Conversion의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalConvRequestCancel(List<PriRpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteProposalDBDAOPriRpScpNoteConvRequestCancelVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}