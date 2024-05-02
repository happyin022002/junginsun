/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFADurationProposalDBDAO.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.13 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.basic.RFADurationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstAuthorityVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurCntVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurHisVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurVO;
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
import com.hanjin.syscommon.common.table.PriRpDurVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;


/**
 * NIS2010 RFADurationProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see RFADurationProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class RFADurationProposalDBDAO extends DBDAOSupport {

	/**
	 * Main Duration 을 추가합니다.<br>
	 * 
	 * @param List<PriRpDurVO> insModels
	 * @exception DAOException
	 */
	public void addProposalDuration(List<PriRpDurVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpDurVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Max Proposal No를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationProposalNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				param.put("ofc_cd", ofcCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAORsltCrePropNoVORSQL(), param, velParam);
				dbRowset.next();
				rtnVal = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnVal;
	}		
	
	/**
	 * Main Duration 을 수정 합니다.<br>
	 * 
	 * @param List<PriRpScpDurVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalDuration(List<PriRpScpDurVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpDurVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}						
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * Scope Duration 을 추가 합니다.<br>
	 * 
	 * @param List<PriRpScpDurVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeDuration(List<PriRpScpDurVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Scope Duration 을 수정 합니다.<br>
	 * 
	 * @param List<PriRpScpDurVO> updModels 
	 * @exception DAOException
	 */
	public void modifyProposalScopeDuration(List<PriRpScpDurVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Scope Duration 을 삭제 합니다.<br>
	 * 
	 * @param List<PriRpScpDurVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalScopeDuration(List<PriRpScpDurVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(PriRpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFADurationProposalDBDAOPriRpDurRequestCancelVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Request Cancel시 Scope Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRequestCancelScope(List<PriRpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurRequestCancelVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}				
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
    /**
	 * Main Duration 의 데이터를 삭제 처리합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @exception DAOException
     */
    public void removeProposal (PriRpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFADurationProposalDBDAOPriRpDurVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }		            
                        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }	
	
    /**
     *  SCOPE의 모든 데이터를 삭제 처리합니다.<br>
     * 
     * @param PriRpScpMnVO vo
     * @exception DAOException
     */
    public void removeProposalScope (PriRpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFADurationProposalDBDAOPriRpScpDurVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
                        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }	 
    
	/**
	 * RFA Proposal Main Duration 데이터를 조회합니다.<br>
	 * 
	 * @param CstAuthorityVO cstAuthorityVO
	 * @return List<RsltPriRpDurVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRpDurVO> searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpDurVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstAuthorityVO != null){
				Map<String, String> mapVO = cstAuthorityVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOPriRpDurVORSQL(), param, velParam);
		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpDurVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	 
	/**
	 * RFA Proposal Scope Duration 데이터를 조회합니다.<br>
	 * 
	 * @param CstAuthorityVO cstAuthorityVO
	 * @return List<RsltPriRpDurVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRpDurVO> searchProposalScopeDurationList(CstAuthorityVO cstAuthorityVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpDurVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstAuthorityVO != null){
				Map<String, String> mapVO = cstAuthorityVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpDurVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	 
	 
	 

	/**
	 * Scope Duration 의 Expire Date 를 수정 합니다.<br>
	 * 
	 * @param List<PriRpScpDurVO> updModels 
	 * @exception DAOException
	 */
	public void modifyProposalScopeDurationChange(List<PriRpScpDurVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
	
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurChgVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}						
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	 
	 
	/**
	 * Main Duration 저장 시 Scope Duration 의 기간을 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpDurVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CstPriRpDurVO> searchProposalScopeCheckList(PriRpScpDurVO priRpScpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstPriRpDurVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpDurVO != null){
				Map<String, String> mapVO = priRpScpDurVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOCstPriRpDurVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstPriRpDurVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		 
	 
	/**
	 * AMEND 된 Scope 을 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriRpScpDurVO> searchProposalDurationAmendCheckList(PriRpScpDurVO priRpScpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpDurVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpDurVO != null){
				Map<String, String> mapVO = priRpScpDurVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOPriRpDurAmdChkVORSQL(), param, velParam);
		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRpScpDurVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		 
	 
	/**
	 * Main Duration 의 기간보다 큰 Scope 의 수를 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpScpDurCntVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CstPriRpScpDurCntVO> searchProposalDurationScopeCount(PriRpScpDurVO priRpScpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstPriRpScpDurCntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpDurVO != null){
				Map<String, String> mapVO = priRpScpDurVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOCstPriRpScpDurCntVORSQL(), param, velParam);
		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstPriRpScpDurCntVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	 
	 
	/**
	 * Duration Main 에 Amend 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalDurationAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpDurAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	 
	
	/**
	 * Duration Scope 에 Amend 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeDurationAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		 
	 
	/**
	 * Scope 코드를 조회합니다.<br>
	 * 
	 * @param CstPriRpScpDurVO cstPriRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriRpScpDurVO> searchProposalScope(CstPriRpScpDurVO cstPriRpScpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpDurVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstPriRpScpDurVO != null){
				Map<String, String> mapVO = cstPriRpScpDurVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurExpVORSQL(), param, velParam);
		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRpScpDurVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	/**
	 * Duration Main Amend History정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltPriRpDurHisVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRpDurHisVO> searchProposalDurationMainHistoryList(PriRpScpDurVO priRpScpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpDurHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpDurVO != null){
				Map<String, String> mapVO = priRpScpDurVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOPriRpDurHisVORSQL(), param, velParam);
		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpDurHisVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	/**
	 * Duration Scope Amend History정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltPriRpDurHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRpDurHisVO> searchProposalDurationScopeHistoryList(PriRpScpDurVO priRpScpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpDurHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpDurVO != null){
				Map<String, String> mapVO = priRpScpDurVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurHisVORSQL(), param, velParam);
		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpDurHisVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

    /**
     * RFA Proposal Duration 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalDuration (RsltRfaPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFADurationProposalDBDAOPropCpPriRpDurCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * Master RFA Proposal Duration 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalDurationMst (RsltRfaPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            velParam.put("IS_MASTER_COPY", "Y"); // Master RFA에서 Copy를 진행

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFADurationProposalDBDAOPropCpPriRpDurCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * RFA Proposal Scope Duration 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeDuration (RsltRfaPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFADurationProposalDBDAOPropCpPriRpScpDurCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * Master RFA 에서 Proposal Scope Duration 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param String eff_dt
     * @param String exp_dt
     * @exception DAOException
     */
    public void addCopyProposalScopeDurationMst (RsltRfaPropCopyVO vo, String eff_dt, String exp_dt) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            param.put("eff_dt", eff_dt.replaceAll("-", ""));
            param.put("exp_dt", exp_dt.replaceAll("-", ""));
            velParam.putAll(mapVO);
			velParam.put("IS_MASTER_COPY", "Y");

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFADurationProposalDBDAOPropCpPriRpScpDurCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
	/**
	 * Scope Duration에서 Main Duration의 Expire Date와 같은 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpDurVO priRpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalDurationAcceptCount(PriRpDurVO priRpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpDurVO != null){
				Map<String, String> mapVO = priRpDurVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurCntVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}    
    
    /**
     * Scope의 Status를 Accept로 수정합니다.<br>
     * 
     * @param PriRpScpDurVO priRpScpDurVO
     * @exception DAOException
     */
    public void modifyAcceptAutoProposalScopeDuration (PriRpScpDurVO priRpScpDurVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpDurVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFADurationProposalDBDAOPriRpScpDurAcptVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }	 
    
	/**
	 * Amend Request 시 Duration을 변경할 경우 Expire Date 를 변경합니다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels 
	 * @exception DAOException
	 */
	public void modifyProposalScopeDurationAmd(List<PriRpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
	
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFADurationProposalDBDAOPriRpScpDurAmdVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}						
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	  
	
	
	/**
     * PRS 정보를 Copy 하여 PriRpDur 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO vo
     * @return int
     * @exception DAOException
     */
    public int addCopyRfaQuotationPriRpDur (RsltCopyToProposalVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFADurationProposalDBDAORqCpPriRpDurCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            
            return result;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
	
    /**
     * PRS 정보를 Copy 하여 PriRpScpDur 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO vo
     * @return int
     * @exception DAOException
     */
    public int addCopyRfaQuotationPriRpScpDur (RsltCopyToProposalVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFADurationProposalDBDAORqCpPriRpScpDurCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            
            return result;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
	/**
	 * Scope Duration에서 Main Duration의 Expire Date와 같은 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalDurationAcceptList(PriRpScpDurVO priRpScpDurVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpDurVO != null){
				Map<String, String> mapVO = priRpScpDurVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFADurationProposalDBDAORsltAcceptScpVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}     
    
}
