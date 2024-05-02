/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRoutePointProposalDBDAO.java
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.21 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.basic.SCRoutePointProposalBCImpl;
import com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
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
import com.clt.syscommon.common.table.PriSpScpRoutPntVO;


/**
 *  SCRoutePointProposalDBDAO <br>
 * - SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see SCRoutePointProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class SCRoutePointProposalDBDAO extends DBDAOSupport {

	/**
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRoutPntLocListVO> searchRoutePointLocationList(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutPntLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltRoutPntLocListVO != null){
				Map<String, String> mapVO = rsltRoutPntLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRoutePointProposalDBDAORsltRoutPntLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRoutPntLocListVO .class);
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
		 * Org/Dst Location의 ROUTE별 정보가 존재하는지를 조회합니다.<br>
		 * 
		 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO
		 * @return List<RsltRoutPntLocListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltRoutPntLocListVO> searchRoutePointLocationType(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltRoutPntLocListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(rsltRoutPntLocListVO != null){
					Map<String, String> mapVO = rsltRoutPntLocListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRoutePointProposalDBDAORsltRoutPntLocTypeVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRoutPntLocListVO .class);
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
		 * Org/Dst Location의 ROUTE별 정보가 존재하는지를 조회합니다.<br>
		 * 
		 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
		 * @return List<RsltRoutPntLocListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryType(PriSpScpRoutPntVO priSpScpRoutPntVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltRoutPntLocListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSpScpRoutPntVO != null){
					Map<String, String> mapVO = priSpScpRoutPntVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRoutePointProposalDBDAORsltRoutPntLocHistoryTypeVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRoutPntLocListVO .class);
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
	 * Org/Dst Location 정보가 존재하는지를 조회합니다.<br>
	 * 
	 * @param List<PriSpScpRoutPntVO> insModels
	 * @exception DAOException,Exception
	 */
	public void addRoutePointLocation(List<PriSpScpRoutPntVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRoutePointProposalDBDAOPriSpScpRoutPntVOCSQL(), insModels,null);
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
	 * Org/Dst Location의 정보를 갱신합니다.<br>
	 * chkAccept 가 Y 이면 ACCEPT 갱신이고 N 이면 데이터 갱신<br>
	 * 
	 * @param List<PriSpScpRoutPntVO> updModels
	 * @param  String chkAccept
	 * @exception DAOException
	 */
	public void modifyRoutePointLocation(List<PriSpScpRoutPntVO> updModels, String chkAccept) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_accept", chkAccept);
								
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCRoutePointProposalDBDAOPriSpScpRoutPntVOUSQL(), updModels, velParam);
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
	 * Org/Dst Location의 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeRoutePointLocation(List<PriSpScpRoutPntVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				//SCOPE 별 전체삭제가 아닐 경우 'N'
				Map<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_scope_delete", "N");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCRoutePointProposalDBDAOPriSpScpRoutPntVODSQL(), delModels, velParam);
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
	 * Org/Dst Location의 정보를 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRoutePointAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRoutePointProposalDBDAOPriSpScpRoutPntAmdVOCSQL(), insModels,null);
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
     * Proposal Scope Route Point 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeRoute (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRoutePointProposalDBDAOPropCpPriSpScpRoutPntCSQL(),
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
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRoutePointProposalDBDAOPriSpScpRoutPntVODSQL(),
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRoutePointProposalDBDAOPriSpScpRoutPntRequestCancelVOUSQL(), param, velParam);
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
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryList(PriSpScpRoutPntVO priSpScpRoutPntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutPntLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpRoutPntVO != null){
				Map<String, String> mapVO = priSpScpRoutPntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRoutePointProposalDBDAORsltRoutPntLocHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRoutPntLocListVO .class);
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
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryList(PriSpScpRoutPntVO priSpScpRoutPntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutPntLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpRoutPntVO != null){
				Map<String, String> mapVO = priSpScpRoutPntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRoutePointProposalDBDAORsltRoutPntLocInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRoutPntLocListVO .class);
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
	 * Org/Dst Location의 ROUTE별 정보가 존재하는지를 조회합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryType(PriSpScpRoutPntVO priSpScpRoutPntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutPntLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpRoutPntVO != null){
				Map<String, String> mapVO = priSpScpRoutPntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRoutePointProposalDBDAORsltRoutPntLocInquiryTypeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRoutPntLocListVO .class);
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
