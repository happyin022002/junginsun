/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountDBDAO.java
*@FileTitle : Account
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.18 조인영
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.account.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.ccd.commoncode.account.basic.AccountBCImpl;
import com.clt.apps.opus.bcm.ccd.commoncode.account.vo.AccountVO;
import com.clt.apps.opus.bcm.ccd.commoncode.account.vo.ChargeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.account.vo.RepChargeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.account.vo.CurrencyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS_CNTR-Account <br>
 * OPUS_CNTR-Account system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조인영
 * @see AccountBCImpl 참조
 * @since J2EE 1.6
 */

public class AccountDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 4488966281158465096L;

	/**
	 * Account 정보를 가져온다<br>
	 * 
	 * @param String acctCd
	 * @return List<AccountVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<AccountVO> searchAccountCode(String acctCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccountVO> acctVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("acct_cd", acctCd);
			vparam.put("acct_cd", acctCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountDBDAOSearchAccountCodeRSQL(), param, vparam);
			acctVO = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return acctVO;
	}
    
	 /**
	  * Account 정보를 저장한다(입력)<br>
	  * 
	  * @param List<AccountVO> acctVO
	  * @throws DAOException
	  */

	 public void addAccountCode(List<AccountVO> acctVO) throws DAOException,Exception {
		 try {

			 SQLExecuter sqlExe = new SQLExecuter("");
			 int insCnt[] = null;
			 if(acctVO.size() > 0){
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOAddAccountCodeCSQL(), acctVO, null);
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
	  * Account 정보를 저장한다(수정)<br>
	  * 
	  * @param List<AccountVO> acctVO
	  * @throws DAOException
	  */

	 public void modifyAccountCode(List<AccountVO> acctVO) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int updCnt[] = null;
			 if(acctVO.size() > 0){
				 updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOModifyAccountCodeUSQL(), acctVO, null);
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
	 * Charge 정보를 가져온다<br>
	 * 
	 * @param String chgCd
	 * @return List<ChargeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<ChargeVO> searchChargeCode(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<ChargeVO> chgVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("chg_cd", chgCd);
			vparam.put("chg_cd", chgCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountDBDAOSearchChargeCodeRSQL(), param, vparam);
			chgVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chgVO;
	}
	
	/**
	 * Charge 정보를 가져온다<br>
	 * 
	 * @param rqstNo String
	 * @return List<ChargeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<ChargeVO> searchChargeRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<ChargeVO> chgVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("rqst_no", rqstNo);
			vparam.put("rqst_no", rqstNo);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountDBDAOSearchChargeRqstRSQL(), param, vparam);
			chgVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chgVO;
	}
    
	/**
	 * Charge 정보를 저장한다(입력)<br>
	 * 
	 * @param chgVO ChargeVO
	 * @throws DAOException
	 */

	public void addChargeCode(List<ChargeVO> chgVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chgVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOAddChargeCodeCSQL(), chgVO, null);
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
	 * Charge 정보를 저장한다(입력)<br>
	 * 
	 * @param chgVO ChargeVO
	 * @throws DAOException
	 */

	public void addChargeRqst(List<ChargeVO> chgVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chgVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOAddChargeRqstCSQL(), chgVO, null);
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
	 * Charge 정보를 저장한다(수정)<br>
	 * 
	 * @param chgVO ChargeVO
	 * @throws DAOException
	 */

	public void modifyChargeCode(List<ChargeVO> chgVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chgVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOModifyChargeCodeUSQL(), chgVO, null);
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
	 * Charge 정보를 저장한다(수정)<br>
	 * 
	 * @param chgVO ChargeVO
	 * @throws DAOException
	 */

	public void modifyChargeRqst(List<ChargeVO> chgVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(chgVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOModifyChargeRqstUSQL(), chgVO, null);
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
	 * Rep Charge 정보를 가져온다<br>
	 * 
	 * @param String repChgCd
	 * @return List<RepChargeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<RepChargeVO> searchRepChgCode(String repChgCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<RepChargeVO> repChgVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("rep_chg_cd", repChgCd);
			vparam.put("rep_chg_cd", repChgCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountDBDAOSearchRepChgCodeRSQL(), param, vparam);
			repChgVO = (List)RowSetUtil.rowSetToVOs(dbRowset, RepChargeVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return repChgVO;
	}
	 
		/**
		 * Rep Charge Code 를 중복여부를 체크한다<br>
		 * 
		 * @param String repChgCd
		 * @return boolean
		 * @throws DAOException
		 */
		public boolean searchRepChgCodeChk(String repChgCd) throws DAOException {
			
			 DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> vparam = new HashMap<String, Object>();
			
			//return type
			boolean rtnVal = false;
			
			try{
				//query parameter
				param.put("rep_chg_cd", repChgCd);
				vparam.put("rep_chg_cd", repChgCd);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountDBDAOSearchRepChgCodeChkRSQL(), param, vparam);
				if(dbRowset.next() && dbRowset.getInt("CNT") > 0) {
					rtnVal = true;
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return rtnVal;
		} 
    
	/**
	 * Rep Charge 정보를 저장한다(입력)<br>
	 * 
	 * @param repChgVO List<RepChargeVO>
	 * @throws DAOException
	 */
	public void addRepChgCode(List<RepChargeVO> repChgVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(repChgVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOAddRepChgCodeCSQL(), repChgVO, null);
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
	 * Rep Charge 정보를 저장한다(수정)<br>
	 * 
	 * @param repChgVO List<RepChargeVO>
	 * @throws DAOException
	 */
	public void modifyRepChgCode(List<RepChargeVO> repChgVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(repChgVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOModifyRepChgCodeUSQL(), repChgVO, null);
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
	 * Currency 정보를 가져온다<br>
	 * 
	 * @param String currCd
	 * @return List<CurrencyVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<CurrencyVO> searchCurrCode(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<CurrencyVO> currVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("curr_cd", currCd);
			vparam.put("curr_cd", currCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountDBDAOSearchCurrCodeRSQL(), param, vparam);
			currVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CurrencyVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return currVO;
	}
    
	/**
	 * Currency 정보를 저장한다(입력)<br>
	 * 
	 * @param currVO List<CurrencyVO>
	 * @throws DAOException
	 */
	public void addCurrCode(List<CurrencyVO> currVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(currVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOAddCurrCodeCSQL(), currVO, null);
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
	 * Currency 정보를 저장한다(수정)<br>
	 * 
	 * @param currVO List<CurrencyVO>
	 * @throws DAOException
	 */
	public void modifyCurrCode(List<CurrencyVO> currVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(currVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountDBDAOModifyCurrCodeUSQL(), currVO, null);
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
