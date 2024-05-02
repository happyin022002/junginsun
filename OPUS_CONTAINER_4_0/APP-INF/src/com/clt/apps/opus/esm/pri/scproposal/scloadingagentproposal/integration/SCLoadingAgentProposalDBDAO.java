/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCLoadingAgentProposalDBDAO.java
*@FileTitle : S/C Proposal Loading Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : PRI
*@LastVersion : 1.0
* 2012.04.16 PRI
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpLodgAgnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;


/**
 *  SCLoadingAgentProposalDBDAO <br>
 * - SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see refer SCLoadingAgentProposalBCImpl
 * @since J2EE 1.6
 */
public class SCLoadingAgentProposalDBDAO extends DBDAOSupport {

	/**
	 * S/C Proposal Loading Agent 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltLodgAgnListVO> searchLoadingAgentList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltLodgAgnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpLodgAgnVO != null){
				Map<String, String> mapVO = priSpScpLodgAgnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltLodgAgnListVO .class);
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
	 * S/C Proposal Loading Agent 정보를 추가합니다.<br>
	 * 
	 * @param List<PriSpScpLodgAgnVO> insModels
	 * @exception DAOException
	 */
	public void addManageLoadingAgentS(List<PriSpScpLodgAgnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVOCSQL(), insModels,null);
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
	 * S/C Proposal Loading Agent 정보를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpLodgAgnVO> updModels
	 * @exception DAOException
	 */
	public void modifyManageLoadingAgentS(List<PriSpScpLodgAgnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVOUSQL(), updModels,null);
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
	 * S/C Proposal Loading Agent 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpLodgAgnVO> delModels
	 * @exception DAOException
	 */
	public void removeManageLoadingAgentS(List<PriSpScpLodgAgnVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
	            velParam.put("is_scope_delete", "N"); //SCOPE 별 삭제시에 사용
	            
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVODSQL(), delModels, velParam);
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
	 * S/C Proposal Loading Agent 정보를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpLodgAgnVO> updModels
	 * @exception DAOException
	 */
	public void modifyAcceptAllLoadingAgentS(List<PriSpScpLodgAgnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnActVOUSQL(), updModels,null);
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
	 * S/C Proposal Loading Agent 정보를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpLodgAgnVO> updModels
	 * @exception DAOException
	 */
	public void modifyCancelLoadingAgentS(List<PriSpScpLodgAgnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnActVOUSQL(), updModels,null);
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
	 * S/C Proposal Loading Agent 정보를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpLodgAgnVO> updModels
	 * @exception DAOException
	 */
	public void modifyAcceptLoadingAgentS(List<PriSpScpLodgAgnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnActVOUSQL(), updModels,null);
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
	 * S/C Proposal Loading Agent 정보를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpLodgAgnVO> updModels
	 * @exception DAOException
	 */
	public void modifyCancelAllLoadingAgentS(List<PriSpScpLodgAgnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnActVOUSQL(), updModels,null);
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
	 * S/C Proposal Loading Agent 정보를 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addLoadingAgentAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnAmdVOCSQL(), insModels,null);
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
     * Proposal Scope Loading Agent 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeLoading (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCLoadingAgentProposalDBDAOPropCpPriSpScpLodgAgnCSQL(),
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
            velParam.put("is_scope_delete", "Y");

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnVODSQL(), param, velParam);
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
	 * Terms의 데이터 수를 가져온다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO 
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck (PriSpScpMnVO priSpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priSpScpMnVO != null){
				Map<String, String> mapVO = priSpScpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnDeleteChkVORSQL(), param, velParam);
            if (dbRowset.next()) {
            	cnt = dbRowset.getInt(1);
            
            }

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}			
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnRequestCancelVOUSQL(), param, velParam);
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
	 * S/C Proposal Loading Agent 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltLodgAgnListVO> searchLoadingAgentHistoryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltLodgAgnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpLodgAgnVO != null){
				Map<String, String> mapVO = priSpScpLodgAgnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnHistoryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltLodgAgnListVO .class);
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
	 * S/C Proposal Loading Agent 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltLodgAgnListVO> searchLoadingAgentInquiryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltLodgAgnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpLodgAgnVO != null){
				Map<String, String> mapVO = priSpScpLodgAgnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCLoadingAgentProposalDBDAOPriSpScpLodgAgnInquiryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltLodgAgnListVO .class);
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