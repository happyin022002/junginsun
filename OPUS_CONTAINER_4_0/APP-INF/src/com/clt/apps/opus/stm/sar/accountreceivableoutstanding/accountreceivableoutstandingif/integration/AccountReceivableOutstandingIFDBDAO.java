/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountReceivableOutstandingIFDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.basic.AccountReceivableOutstandingIFBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.vo.CheckIFSakuraVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.vo.SaKuraIFVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * AccountReceivableOutstandingIFDBDAO <br>
 * - AccountReceivableOutstandingIF system Business Logic<br>
 * 
 * @author 
 * @see AccountReceivableOutstandingIFBCImpl
 * @since J2EE 1.4
 */
public class AccountReceivableOutstandingIFDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	/**
	 * AccountReceivableOutstandingIFDBDAO object creation<br>
	 * AccountReceivableOutstandingIFDBDAO creation<br>
	 */
	public AccountReceivableOutstandingIFDBDAO() { }
	
	
	/**
	 * AccountReceivableOutstandingIFDBDAO object creation<br>
	 * AccountReceivableOutstandingIFDBDAO creation<br>
	 * @param String dataSource
	 */
	public AccountReceivableOutstandingIFDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}
		
	/**
	 * search for create sakura if data
	 * @author myoungsin park 2014. 9. 29
	 * @param String ifNo
	 * @return CheckIFSakuraVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CheckIFSakuraVO checkIFSakura(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		CheckIFSakuraVO returnVO = null;
		List<CheckIFSakuraVO> list = null;
		String firstIfNo = ifNo;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ifNo.indexOf(",") != -1){
				String[] ifNos =  ifNo.split(",");
				firstIfNo = ifNos[0];
			}
			
			param.put("check_if_no", firstIfNo); 
			velParam.put("check_if_no", firstIfNo);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOcheckIFSakuraRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CheckIFSakuraVO.class);
			if (list.size() > 0) {
				returnVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVO;
	}	
	
	/**
	 * search for create sakura if data
	 * @author myoungsin park 2015. 01. 02
	 * @param String ifNo
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraNonCurrencyList(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("check_if_no", ifNo);
			velParam.put("check_if_no", ifNo);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOsearchIFSakuraNonCurrencyListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SaKuraIFVO.class);
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
	 * check for create sakura if data
	 * @author myoungsin park 2015. 01. 02
	 * @param String ifNo
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int checkIFSakuraNonInvNo(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		int noInvCnt = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("check_if_no", ifNo);
			velParam.put("check_if_no", ifNo);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOcheckIFSakuraNonInvNoRSQL(),param, velParam);							
			if(dbRowset.next()){
				noInvCnt = dbRowset.getInt("NON_INV_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return noInvCnt;
	}	
	
	
	/**
	 * search for create sakura if data
	 * @author myoungsin park 2015. 01. 02
	 * @param String ifNo
	 * @param String status
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraErrorList(String ifNo,String status) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;
		List<String> ifNoLists = new ArrayList<String>();
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(ifNo.indexOf(",") != -1){
				String[] ifNoArrs =  ifNo.split(",");
				for (int i = 0; i < ifNoArrs.length; i++) {
					ifNoLists.add(ifNoArrs[i]);
				}
			} else {
				ifNoLists.add(ifNo.trim());
			}
			
			param.put("check_if_no", ifNo);
			velParam.put("check_if_no", ifNo);
			param.put("check_if_nos", ifNoLists);      
			velParam.put("check_if_nos", ifNoLists); 
			param.put("check_status", status);
			velParam.put("check_status", status);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOsearchIFSakuraErrorListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SaKuraIFVO.class);
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
	 * search for create sakura if data
	 * @author myoungsin park 2014. 9. 29
	 * @param String ifNo
	 * @param String status
	 * @param String grpYn
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraNonJpList(String ifNo,String status,String grpYn) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;
		List<String> ifNoLists = new ArrayList<String>();
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			if(ifNo.indexOf(",") != -1){
				String[] ifNoArrs =  ifNo.split(",");
				for (int i = 0; i < ifNoArrs.length; i++) {
					ifNoLists.add(ifNoArrs[i]);
				}
			} else {
				ifNoLists.add(ifNo.trim());
			}
			
			param.put("check_if_no", ifNo);
			velParam.put("check_if_no", ifNo);
			param.put("check_if_nos", ifNoLists);      
			velParam.put("check_if_nos", ifNoLists);  
			param.put("check_status", status);
			velParam.put("check_status", status);
			param.put("grp_yn", grpYn);
			velParam.put("grp_yn", grpYn);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOsearchIFSakuraNonJpListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SaKuraIFVO.class);
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
	 * search for create sakura if data
	 * @author myoungsin park 2014. 9. 29
	 * @param String ifNo
	 * @param String status
	 * @param String grpYn
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraJpList(String ifNo,String status,String grpYn) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;
		List<String> ifNoLists = new ArrayList<String>();
		
		// query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ifNo.indexOf(",") != -1){
				String[] ifNoArrs =  ifNo.split(",");
				for (int i = 0; i < ifNoArrs.length; i++) {
					ifNoLists.add(ifNoArrs[i]);
				}
			} else {
				ifNoLists.add(ifNo.trim());
			}
			
			param.put("check_if_no", ifNo);
			velParam.put("check_if_no", ifNo);
			param.put("check_if_nos", ifNoLists);      
			velParam.put("check_if_nos", ifNoLists);  
			param.put("check_status", status);
			velParam.put("check_status", status);
			param.put("grp_yn", grpYn);
			velParam.put("grp_yn", grpYn);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOsearchIFSakuraJpListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SaKuraIFVO.class);
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
	 * search for create sakura if data
	 * @author myoungsin park 2014. 9. 29
	 * @param String ifNo
	 * @param String status
	 * @param String grpYn
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraASAList(String ifNo,String status,String grpYn) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;
		List<String> ifNoLists = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ifNo.indexOf(",") != -1){
				String[] ifNoArrs =  ifNo.split(",");
				for (int i = 0; i < ifNoArrs.length; i++) {
					ifNoLists.add(ifNoArrs[i]);
				}
			} else {
				ifNoLists.add(ifNo.trim());
			}
			
			param.put("check_if_no", ifNo);
			velParam.put("check_if_no", ifNo);
			param.put("check_if_nos", ifNoLists);      
			velParam.put("check_if_nos", ifNoLists);  
			param.put("check_status", status);
			velParam.put("check_status", status);
			param.put("grp_yn", grpYn);
			velParam.put("grp_yn", grpYn);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOsearchIFSakuraASAListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SaKuraIFVO.class);
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
	 * modify ost_dtrb status
	 * @author myoungsin park 2014. 9. 29 
	 * @param List<SaKuraIFVO> sarIFVOs
	 * @exception DAOException
	 */
	public void modifyDtrbStatus(List<SaKuraIFVO> sarIFVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (sarIFVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new AccountReceivableOutstandingIFDBDAOmodifyDtrbStatusUSQL(),
								sarIFVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyOtsDtrbStatus No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 /**
	 * Search InterfaceSeq<br>
	 * 
     * @author MyoungSin Park
     * @return String
     * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchSakuraIFSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String arEmlSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingIFDBDAOsearchSakuraIFSeqRSQL(), param, velParam);											
			if(dbRowset.next()){
				arEmlSeq = dbRowset.getString("ar_if_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arEmlSeq;
	}	
	
	/**
	 * Search InterfaceSeq<br>
	 * 
     * @author MyoungSin Park
     * @return String
     * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchSakuraArIFToSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String ifSeqNo = ""; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingIFDBDAOsearchSakuraArIFToSeqRSQL(), param, velParam);											
			if(dbRowset.next()){
				ifSeqNo = dbRowset.getString("if_seq_no"); 
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ifSeqNo;
	}	
	
	/**
	 * Search InterfaceSeq<br>
	 * 
     * @author MyoungSin Park
     * @param String ifNo
     * @return String
     * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPreviousSakuraArIFToSeq(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		String ifSeqNo = ""; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("check_if_no", ifNo);
			velParam.put("check_if_no", ifNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingIFDBDAOsearchPreviousSakuraArIFToSeqRSQL(), param, velParam);											
			if(dbRowset.next()){
				ifSeqNo = dbRowset.getString("if_seq_no"); 
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ifSeqNo;
	}	
	
	/**
	 * Search for VAT merge<br>
	 * 
	 * @return List<AROutstandingDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingHistVO> searchReFindSakuraIfNoForBatch() throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingHistVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableOutstandingIFDBDAOsearchReFindSakuraIfNoForBatchRSQLRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHistVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}