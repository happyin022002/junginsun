/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRealCustomerProposalDBDAO.java
*@FileTitle : Real Customer Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.09.23 
* 1.0 Creation
=========================================================
* History
* 2011.11.11 서미진 [CHM-201114405] Location 정보 추가로 입력할 수 있도록 처리
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.basic.SCRealCustomerProposalBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.RsltRealCustInquiryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.PriSpRealCustVO;

/**
 * ALPS SCRealCustomerProposalDBDAO <br>
 * - ALPS-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO MI JIN
 * @see SCRealCustomerProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class SCRealCustomerProposalDBDAO extends DBDAOSupport {

	/**
	 * ESM_PRI_0040 : RETRIEVE 
	 * Real Customer 정보를 조회 합니다.<br>
	 * 
	 * @param RsltRealCustInquiryVO rsltRealCustInquiryVO
	 * @return List<RsltRealCustInquiryVO>
	 * @exception DAOException
	 */
	public List<RsltRealCustInquiryVO> searchRealCustomerList(RsltRealCustInquiryVO rsltRealCustInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRealCustInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rsltRealCustInquiryVO != null){
				Map<String, String> mapVO = rsltRealCustInquiryVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRealCustomerProposalDBDAOSearchRealCustomerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRealCustInquiryVO.class);
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
	 * ESM_PRI_0040 : SAVE 
	 * Real Customer 정보를 생성 합니다.<br>
	 * 
	 * @param PriSpRealCustVO priSpRealCustVO
	 * @exception DAOException
	 */
	public void addRealCustomer(PriSpRealCustVO priSpRealCustVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priSpRealCustVO != null) {
				Map<String, String> mapVO = priSpRealCustVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new SCRealCustomerProposalDBDAOAddRealCustomerCSQL(), param, velParam);		
            if (insCnt == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to create SQL");
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
	 * ESM_PRI_0040 : SAVE 
	 * Real Customer 정보를 수정 합니다.<br>
	 * 
	 * @param List<PriSpRealCustVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyRealCustomer(List<PriSpRealCustVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRealCustomerProposalDBDAOModifyRealCustomerUSQL(), updateSheetVoList,null);
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
	 * ESM_PRI_0040 : SAVE 
	 * Real Customer 정보를 삭제 합니다.<br>
	 * 
	 * @param List<PriSpRealCustVO> deleteSheetVoList
	 * @exception DAOException
	 */
	public void removeRealCustomer(List<PriSpRealCustVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRealCustomerProposalDBDAORemoveRealCustomerDSQL(), deleteSheetVoList,null);
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
	 * ESM_PRI_0040 : SAVE 
	 * Proposal No. AMD NO.에 해당하는 Real Customer를 모두 삭제 합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @exception DAOException
	 */
	public void removeAllRealCustomer(PriSpMnVO priSpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priSpMnVO != null) {
				Map<String, String> mapVO = priSpMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new SCRealCustomerProposalDBDAORemoveAllRealCustomerDSQL(), param, velParam);		
            if (insCnt == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
	 * Real Customer를 COPY 합니다. <br>
	 * 
	 * @param List<RsltPropCopyVO> insertVoList
	 * @exception DAOException
	 */
	public void addcopyRealCustomer(List<RsltPropCopyVO> insertVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRealCustomerProposalDBDAOAddcopyRealCustomerCSQL(), insertVoList,null);
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
	 * 해당 조건의 Real Customer 데이터를 Amend Seq + 1하여 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insertVoList
	 * @exception DAOException
	 */
	public void addcopyAmendRealCustomer(List<PriSpMnVO> insertVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRealCustomerProposalDBDAOAddcopyAmendRealCustomerCSQL(), insertVoList,null);
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
     * ESM_PRI_0040 : OPEN<br>
     * Affiliate와 Loading Agent 의 cust 정보를 조회합니다.<br>
	 * 
	 * @param PriSpRealCustVO priSpRealCustVO
     * @return List<PriSpRealCustVO>
	 * @exception DAOException
	 */
	public List<PriSpRealCustVO> searchAffiliateLoadingagentInfo(PriSpRealCustVO priSpRealCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpRealCustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSpRealCustVO != null){
				Map<String, String> mapVO = priSpRealCustVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRealCustomerProposalDBDAOSearchAffiliateLoadingagentInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpRealCustVO.class);
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