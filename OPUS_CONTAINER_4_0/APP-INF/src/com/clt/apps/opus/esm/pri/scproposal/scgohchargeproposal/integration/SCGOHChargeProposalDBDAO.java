/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeProposalDBDAO.java
*@FileTitle : S/C Proposal 및 Amendment시  GOH 생성/수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.26 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.basic.SCGOHChargeProposalBCImpl;
import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.vo.CstPriSpScpGohChgVO;
import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.vo.RsltGohChgListVO;
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
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGohChgVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;


/**
 *  SCGOHChargeProposalDBDAO <br>
 * - SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see SCGOHChargeProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class SCGOHChargeProposalDBDAO extends DBDAOSupport {

	/**
	 * S/C Proposal Creation - GOH List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGohChgListVO> searchGOHChargeList(PriSpScpGohChgVO priSpScpGohChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGohChgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGohChgVO != null){
				Map<String, String> mapVO = priSpScpGohChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGOHChargeProposalDBDAORsltGohChgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGohChgListVO .class);
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
	 * GOH 테이블에 단건의 데이터를 생성한다.<br>
	 * 
	 * @param PriSpScpGohChgVO vo
	 * @exception DAOException
	 */
	public void addProposalGOHCharge(PriSpScpGohChgVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGOHChargeProposalDBDAOPriSpScpGohChgVOCSQL(), param, velParam);
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
	 * GOH 테이블에 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param PriSpScpGohChgVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyProposalGOHCharge(PriSpScpGohChgVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGOHChargeProposalDBDAOPriSpScpGohChgVOUSQL(), param, velParam);
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
	 * GOH 테이블에 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param PriSpScpGohChgVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeProposalGOHCharge(PriSpScpGohChgVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            velParam.put("is_scope_delete", "N");
            
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGOHChargeProposalDBDAOPriSpScpGohChgVODSQL(), param, velParam);
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
	 * GOH 테이블에 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGohChgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGOHCharge(List<PriSpScpGohChgVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGOHChargeProposalDBDAOPriSpScpGohChgVOCSQL(), insModels,null);
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
	 * GOH 테이블에 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriSpScpGohChgVO> updModels
	 * @param String chkAccept
	 * @exception DAOException
	 */
	public void modifyProposalGOHCharge(List<PriSpScpGohChgVO> updModels, String chkAccept) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_accept", chkAccept);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGOHChargeProposalDBDAOPriSpScpGohChgVOUSQL(), updModels, velParam);
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
	 * GOH 테이블에 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriSpScpGohChgVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGOHCharge(List<PriSpScpGohChgVO> delModels) throws DAOException,Exception {
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
           		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
            velParam.put("is_scope_delete", "N");			
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGOHChargeProposalDBDAOPriSpScpGohChgVODSQL(), delModels,velParam);
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
	 * GOH 테이블에 단건의 데이터를 생성한다.<br>
	 * 
	 * @param CstPriSpScpGohChgVO vo
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addCopyGuidelineGOHCharge(CstPriSpScpGohChgVO vo, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGOHChargeProposalDBDAOCopyGuidelineGOHChargeCSQL(), param, velParam);
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
	 * GOH 테이블에 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGOHChargeAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGOHChargeProposalDBDAOPriSpScpGohChgAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		

    /**
     * Proposal Scope GOH Charge 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeGohChg(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGOHChargeProposalDBDAOPropCpPriSpScpGohChgCSQL(),
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
     * Guideline GOH Charge 정보를 Proposal Scope 으로 Copy 생성합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGohChg(SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGOHChargeProposalDBDAOGlineCopyPriSpScpGohChgCSQL(),
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
	 * Guideline Copy 대상 데이터가 있는지 확인한다.<br>
	 * 
	 * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchCheckGuidelineGOHChargeExist(CstPriSpScpGohChgVO cstPriSpScpGohChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean rtnVal = false;
		
		try{
			if(cstPriSpScpGohChgVO != null){
				Map<String, String> mapVO = cstPriSpScpGohChgVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGOHChargeProposalDBDAOGuidelineGOHChargeExistRSQL(), param, velParam);		
			if(dbRowset.next() && dbRowset.getInt("CNT") > 0) {
				rtnVal = true;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	 
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(PriSpScpMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCGOHChargeProposalDBDAOPriSpScpGohChgRequestCancelVOUSQL(), param, velParam);
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
     *  SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpMnVO vo 
     * @exception DAOException
     */
    public void removeProposal(PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_scope_delete", "Y");
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGOHChargeProposalDBDAOPriSpScpGohChgVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
	 * S/C Proposal Creation - GOH Amend History List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGohChgListVO> searchGOHChargeHistoryList(PriSpScpGohChgVO priSpScpGohChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGohChgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGohChgVO != null){
				Map<String, String> mapVO = priSpScpGohChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGOHChargeProposalDBDAORsltGohChgHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGohChgListVO .class);
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
	 * SC GOH Inquiry List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGohChgListVO> searchGOHChargeInquiryList(PriSpScpGohChgVO priSpScpGohChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGohChgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGohChgVO != null){
				Map<String, String> mapVO = priSpScpGohChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGOHChargeProposalDBDAORsltGohChgInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGohChgListVO .class);
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