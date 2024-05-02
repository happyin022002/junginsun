/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCAffiliateProposalDBDAO.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.basic.SCAffiliateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.CstPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSpAfilVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;


/**
 * NIS2010 SCAffiliateProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kong Back Jin
 * @see SCAffiliateProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class SCAffiliateProposalDBDAO extends DBDAOSupport {

	/** 
	 * Affiliate Company 리스트를 조회합니다.<br>
	 *  
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpAfilVO> searchAffiliateList(PriSpAfilVO priSpAfilVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpAfilVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpAfilVO != null){
				Map<String, String> mapVO = priSpAfilVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpAfilVO .class);
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
	 * Amendment History Inquiry - Affiliate Company 리스트를 조회한다.  <br>
	 * 
	 * @param RsltAfilListVO pVo
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAfilListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltAfilListVO> searchAffiliateHistoryList(RsltAfilListVO pVo,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAfilListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(pVo != null){
				Map<String, String> mapVO = pVo.getColumnValues();
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCAffiliateProposalDBDAORsltAfilListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltAfilListVO.class);
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
	 * Affiliate Company  데이터를 삭제합니다.<br>
	 * Init Cancel시 해당 Amend Seq No.의 모든 데이터를 삭제합니다.<br>
	 * @param PriSpMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeProposal(PriSpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.put("is_init_delete", "Y"); // INIT Cancel 삭제시 사용
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	/**
	 * 여러건의 Affiliate Company  데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpAfilVO> insModels
	 * @exception DAOException
	 */
	public void addAffiliateS(List<PriSpAfilVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilVOCSQL(), insModels,null);
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
	 * 여러건의 Affiliate Company  데이터를 수정합니다.<br>
	 * 
	 * @param List<PriSpAfilVO> updModels
	 * @exception DAOException
	 */
	public void modifyAffiliateS(List<PriSpAfilVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 여러건의 Affiliate Company  데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpAfilVO> delModels
	 * @exception DAOException
	 */
	public void removeAffiliateS(List<PriSpAfilVO> delModels) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				velParam.put("is_init_delete", "N"); // INIT Cancel 삭제시 사용
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Affiliate Company  데이터의 Status를 수정합니다.<br>
	 * 
	 * @param CstPriSpAfilVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllAffiliate(CstPriSpAfilVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilAcceptVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}	
	
	/**
	 * Manual 입력이 가능한 Scope이 하나라도 포함되어 있는지 조회한다.<br>
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<PriSpAfilVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSpAfilVO> searchManualCheck(PriSpAfilVO priSpAfilVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpAfilVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpAfilVO != null){
				Map<String, String> mapVO = priSpAfilVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilVOMnlChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpAfilVO .class);
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
	 * 해당 Amend Seq 의 데이터를  Amend Seq + 1하여  추가 합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addAffiliateAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilAmdVOCSQL(), insModels,null);
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
     * Proposal Affiliate 정보를 Copy 하여  생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalAffiliate (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCAffiliateProposalDBDAOPropCpPriSpAfilCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
	 * Status 가 Accept인 데이터를 Accept Cancel로 수정합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(PriSpMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilRequestCancelVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * Inquiry - Affiliate Company 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilInqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpAfilInqVO> searchAffiliateInquiryList(PriSpAfilVO priSpAfilVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpAfilInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpAfilVO != null){
				Map<String, String> mapVO = priSpAfilVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCAffiliateProposalDBDAORsltPriSpAfilInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpAfilInqVO .class);
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
	 * Inquiry - Affiliate Company에서 manual 입력이 가능한 Scope이 있는지 조회합니다.<br>
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<PriSpAfilVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSpAfilVO> searchManualCheckInquiry(PriSpAfilVO priSpAfilVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpAfilVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpAfilVO != null){
				Map<String, String> mapVO = priSpAfilVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilVOMnlChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpAfilVO .class);
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