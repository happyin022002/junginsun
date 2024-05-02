/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalDBDAO.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.18 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.basic.SCNoteProposalBCImpl;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;


/**
 *  SCNoteProposalDBDAO <br>
 * - SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see SCNoteProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class SCNoteProposalDBDAO extends DBDAOSupport {

	/**
	 * Contract Clause Master Detail 정보를 조회합니다.<br>
	 * 
	 * @param RsltCtrtCluzListVO rsltCtrtCluzListVO
	 * @return List<RsltCtrtCluzListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCtrtCluzListVO> searchContractClauseMasterDetailList(RsltCtrtCluzListVO rsltCtrtCluzListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCtrtCluzListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCtrtCluzListVO != null){
				Map<String, String> mapVO = rsltCtrtCluzListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltCtrtCluzListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCtrtCluzListVO .class);
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
	 * Standard Note Guideline Master 정보를 COPY한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return int
	 * @exception DAOException
	 */
	public int addProposalNoteGlineCopy(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException,Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
                
		try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            
            return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note Guideline Detail 정보를 COPY한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return int
	 * @exception DAOException
	 */
	public int addProposalNoteContentGlineCopy(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException,Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
                
		try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            
            return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	
	/**
	 * Standard Note 의 Header 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteHeaderVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltNoteHeaderVO> searchNoteHeader(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteListVO != null){
				Map<String, String> mapVO = priSpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltNoteHeaderVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteHeaderVO .class);
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
	 * Standard Note 의 Master 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteListVO> searchNoteList(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteListVO != null){
				Map<String, String> mapVO = priSpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltNoteListVORSQL(), param, velParam);
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
	 * Standard Note 의 Contents 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteCtntVO != null){
				Map<String, String> mapVO = priSpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltNoteCtntListVORSQL(), param, velParam);
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
	 * Special Note 의 Contents 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteCtntVO != null){
				Map<String, String> mapVO = priSpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpSpecNoteCtntListVORSQL(), param, velParam);
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
	 * Standard Note 의 Header 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchNoteContentExist(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(priSpScpNoteListVO != null){
				Map<String, String> mapVO = priSpScpNoteListVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCpChkVORSQL(), param, null);
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
	 * Special Note 정보를 추가한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalNoteAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteAmdVOCSQL(), insModels,null);
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
	 * Special Note 정보를 추가한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalNoteContentAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntAmdVOCSQL(), insModels,null);
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
	 * Special Note 정보를 추가한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> insModels
	 * @exception DAOException
	 */
	public void addNote(List<PriSpScpNoteListVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteVOCSQL(), insModels,null);
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
     * Special Note 정보를 갱신한다.<br>
     * 
     * @param PriSpScpNoteListVO priSpScpNoteListVO
     * @exception DAOException
     */
    public void modifyNote (PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();
            param.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteVOUSQL(), param, velParam);
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
     * Proposal Scope Special Note 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeNote (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPropCpPriSpScpNoteCSQL(),
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
     * Proposal Scope Special Note Content 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeNoteCtnt (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPropCpPriSpScpNoteCtntCSQL(),
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
	 * Special Note 정보를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> updModels
	 * @exception DAOException
	 */
	public void modifyNote(List<PriSpScpNoteListVO> updModels) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
								
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteVOUSQL(), updModels,null);
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
	 * Special Note 정보를 갱신할때 Contents 의 데이터도 갱신한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupNoteContent(List<PriSpScpNoteListVO> updModels) throws DAOException,Exception {
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){				
				//MASTER DELETE ROW
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
				velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntVOUSQL(), updModels,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Special Note 정보를 갱신할때 Contents 의 데이터도 갱신한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @exception DAOException
	 */
	public void modifyGroupNoteContent(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
       	Map<String, Object> velParam = new HashMap<String, Object>();
       
       	try {
       		Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();
			
          	param.putAll(mapVO);
          	velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
			velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
			velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
           
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntVOUSQL(), param, velParam);
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
	 * Special Note 정보를 삭제할때 Contents 의 데이터도 삭제한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @exception DAOException
	 */
	public void removeGroupNoteContent(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException,Exception {
		 // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();
			
            param.putAll(mapVO);
            velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
			velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
			velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
            
			SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntVODSQL(), param, velParam);
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
	 * Special Note 정보를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> delModels
	 * @exception DAOException
	 */
	public void removeNote(List<PriSpScpNoteListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
				velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteVODSQL(), delModels, velParam);
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
	 * Special Note Contents 정보를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupNoteContent(List<PriSpScpNoteListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
				velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
				velParam.put("is_master_delete", "Y");	// MASTER에서 DELETE 버튼 이벤트시 사용
				
				//MASTER에 해당하는 DETAIL의 모든 데이터를 삭제한다.
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntVODSQL(), delModels, velParam);
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
	 * Special Note 정보를 추가한다.<br>
	 * 
	 * @param List<PriSpScpNoteCtntListVO> insModels
	 * @exception DAOException
	 */
	public void addNoteContent(List<PriSpScpNoteCtntListVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntVOCSQL(), insModels,null);
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
	 * Special Note 정보를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpNoteCtntListVO> updModels
	 * @exception DAOException
	 */
	public void modifyNoteContent(List<PriSpScpNoteCtntListVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				// query parameter
		        //Map<String, Object> param = new HashMap<String, Object>();
		        // velocity parameter		       				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_master_delete", "N");
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntVOUSQL(), updModels, velParam);
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
	 * Special Note 정보를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpNoteCtntListVO> delModels
	 * @exception DAOException
	 */
	public void removeNoteContent(List<PriSpScpNoteCtntListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
				velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
				velParam.put("is_master_delete", "N");	// MASTER에서 DELETE 버튼 이벤트시 사용
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntVODSQL(), delModels, velParam);
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
	 * Special Note 정보를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpNoteCtntVO> updModels
	 * @exception DAOException
	 */
	public void modifyAcceptNote(List<PriSpScpNoteCtntVO> updModels) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
			int updCnt[] = null;
			if(updModels.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");
				velParam.put("is_all_accept", "N");
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntActVOUSQL(), updModels, velParam);
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
	 * Special Note 정보를 갱신한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @exception DAOException
	 */
	public void modifyAcceptAllNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException,Exception {
		 // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteCtntVO.getColumnValues();
			
            param.putAll(mapVO);
            velParam.put("is_all_accept", "Y");
            
			SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntActVOUSQL(), param, velParam);
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
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception DAOException
     */
    public void removeProposal (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_scope_delete", "Y"); 	// SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");	// MASTER에서 DELETE 버튼 이벤트시 사용
			velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
			velParam.put("is_glcopy", "N");		  	// STANDARD NOTE에서의 DELETE시에 사용
			
            //NOTE
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteVODSQL(), param, velParam);
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
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception DAOException
     */
    public void removeProposalContent (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_scope_delete", "Y"); 	// SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");	// MASTER에서 DELETE 버튼 이벤트시 사용
			velParam.put("is_type_delete", "N");	// TYPE별 삭제시 사용
			velParam.put("is_glcopy", "N");		  	// STANDARD NOTE에서의 DELETE시에 사용
			
            //NOTE CONTENTS
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntVODSQL(), param, velParam);
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
     *  SCOPE에 해당하는 STANDARD NOTE의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpNoteListVO priSpScpNoteListVO
     * @exception DAOException
     */
    public void removeStandardNote (PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");	// MASTER에서 DELETE 버튼 이벤트시 사용
			velParam.put("is_type_delete", "Y");	// TYPE별 삭제시 사용
			velParam.put("is_glcopy", "N");		  	// STANDARD NOTE에서의 DELETE시에 사용
			
            //NOTE
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteVODSQL(), param, velParam);
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
     *  SCOPE에 해당하는 STANDARD NOTE의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpNoteListVO priSpScpNoteListVO
     * @exception DAOException
     */
    public void removeStandardNoteContent (PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_scope_delete", "N"); 	// SCOPE별 삭제시 사용
			velParam.put("is_master_delete", "N");	// MASTER에서 DELETE 버튼 이벤트시 사용
			velParam.put("is_type_delete", "Y");	// TYPE별 삭제시 사용
			velParam.put("is_glcopy", "N");		  	// STANDARD NOTE에서의 DELETE시에 사용
			            
            //NOTE CONTENTS
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntVODSQL(), param, velParam);
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
     *  SCOPE에 해당하는 STANDARD NOTE의 모든 데이터를 AMEND삭제처리한다.<br>
     * 
     * @param PriSpScpNoteListVO priSpScpNoteListVO
     * @exception DAOException
     */
    public void modifyStandardNoteContent (PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();
            param.putAll(mapVO);
			 
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntAmdDelVOUSQL(), param, velParam);
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
     * SCOPE에 해당하는 STANDARD NOTE의 모든 데이터를 AMEND CANCEL 처리한다.<br>
     * 
     * @param PriSpScpNoteListVO priSpScpNoteListVO
     * @exception DAOException
     */
    public void addStandardNoteContentList (PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntAmdDelCancelVOCSQL(),
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
     * Guideline Standard Note 정보를 Copy 하여 Proposal Standard Note 정보를 생성합니다.<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @exception DAOException
     */
    public void addCopyScopeGuidelineStndNote (SpScpGlineCopyVO spScpGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = spScpGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOGlineCopyPriSpScpNoteCSQL(),
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
     * Copy 할 Guideline Standard Note 정보의 NOTE_HDR_SEQ를 조회합니다.<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return String
     * @exception DAOException
     */
    public String searchGuidelineCopyNoteHdrSeq(SpScpGlineCopyVO spScpGlineCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        String noteHdrSeq = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(spScpGlineCopyVO != null){
                Map<String, String> mapVO = spScpGlineCopyVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAOGlineCopyGetNoteHdrSeqRSQL(), param, velParam);
            
            if (dbRowset.next()) {
                noteHdrSeq = dbRowset.getString(1);
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return noteHdrSeq;
    }
    
    /**
     * Guideline Standard Note Content 정보를 Copy 하여 Proposal Standard Note Content 정보를 생성합니다.<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @exception DAOException
     */
    public void addCopyScopeGuidelineStndNoteCtnt (SpScpGlineCopyVO spScpGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = spScpGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOGlineCopyPriSpScpNoteCtntCSQL(),
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
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(PriSpScpMnVO priSpScpMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntRequestCancelVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * Request Cancel시 Standard Note Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception EventException
	 */
	public void modifyProposalRequestCancelStandardNote(PriSpScpMnVO priSpScpMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntRequestCancelStandardNoteVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
    
	/**
	 * S/C Proposal을 Request 할때 자동으로 Accept를 합니다.<br>
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @exception DAOException
	 */
	public void modifyAutoAcceptProposalNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpNoteCtntVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntAutoAcceptVOUSQL(),
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
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchAllAcceptDataList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteCtntVO != null){
				Map<String, String> mapVO = priSpScpNoteCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntActVORSQL(), param, velParam);
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
	 * Standard Note 의 Master History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteListVO> searchNoteHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteListVO != null){
				Map<String, String> mapVO = priSpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltNoteHistoryListVORSQL(), param, velParam);
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
	 * Standard Note 의 Contents History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchNoteContentHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteListVO != null){
				Map<String, String> mapVO = priSpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltNoteCtntHistoryListVORSQL(), param, velParam);
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
	 * Standard Note 의 Master 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteListVO> searchNoteInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteListVO != null){
				Map<String, String> mapVO = priSpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltNoteInquiryListVORSQL(), param, velParam);
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
	 * Standard Note 의 Contents 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltNoteCtntListVO> searchNoteContentInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteListVO != null){
				Map<String, String> mapVO = priSpScpNoteListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltNoteCtntInquiryListVORSQL(), param, velParam);
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
	 * NOTE CONTENTS의 CHARGE TYPE CODE를 갱신한다.<br>
	 * 
	 * @param PriSpScpNoteCtntListVO priSpScpNoteCtntListVO
	 * @exception DAOException
	 */
	public void modifyNoteContentChargeType(PriSpScpNoteCtntListVO priSpScpNoteCtntListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priSpScpNoteCtntListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntChgTpVOUSQL(),
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
     * 이전SEQ에 해당하는 NOTE의 MAX DP_SEQ를 조회한다.<br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception DAOException
     */
    public String searchNoteMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	String maxDpSeq = null;
            if(priSpScpNoteCtntVO != null){
                Map<String, String> mapVO = priSpScpNoteCtntVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteMaxDpSeqRSQL(), param, velParam);
            
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
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception DAOException
     */
    public String searchNoteContentMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	String maxDpSeq = null;
            if(priSpScpNoteCtntVO != null){
                Map<String, String> mapVO = priSpScpNoteCtntVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntMaxDpSeqRSQL(), param, velParam);
            
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
     * Conversion Update 시 Amend Seq.를 기준으로 다음 Amend Seq의 NOTE_CHG_TP_CD를 수정한다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void modifyConversionNote(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOConversionNoteCtntUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }    
    
    
	/**
	 * SCNoteProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param List<String> txtArr
	 * @return List<RsltNoteCtntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltNoteCtntListVO> searchSpecialNoteAcceptedList (PriSpScpNoteCtntVO priSpScpNoteCtntVO, List<String> txtArr) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteCtntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpNoteCtntVO != null){
				Map<String, String> mapVO = priSpScpNoteCtntVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCNoteProposalDBDAORsltRtAcceptedListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteCtntListVO .class);
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
     *  add History Note Content for Deleting Dem/Det<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception DAOException
     */
    public void addProposalScpNoteContentHistoryForDemDet (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

            param.putAll(mapVO);

            //NOTE CONTENTS
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteCtntMigHisCSQL(), param, velParam);
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
     *  add History Note for Deleting Dem/Det<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception DAOException
     */
    public void addProposalScpNoteHistoryForDemDet (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

            param.putAll(mapVO);

            //NOTE CONTENTS
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCNoteProposalDBDAOPriSpScpNoteMigHisCSQL(), param, velParam);
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
	 * Special Note History 저장.<br>
	 * 
	 * @param List<PriSpScpNoteListVO> delModels
	 * @exception DAOException
	 */
	public void addNoteHistory(List<PriSpScpNoteListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteHistoryCSQL(), delModels, velParam);
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
	 * Special Note Content History 저장.<br>
	 * 
	 * @param List<PriSpScpNoteCtntListVO> delModels
	 * @exception DAOException
	 */
	public void addNoteContentHistory(List<PriSpScpNoteCtntListVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCNoteProposalDBDAOPriSpScpNoteCtntHistoryCSQL(), delModels, velParam);
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
    
    
	
}