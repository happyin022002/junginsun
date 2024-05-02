/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CUSTDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * History--------------------------------------------------
 * 1.0 최초 생성
 * 2009-09-14 Oh hyun kyoung NIS2010 변환
 * 2010-07-02 이행지 Ticket ID(CHM-201004395):MDM Refund Customer Code 데이터 I/F 수정 및 데이터 이행건
 * =========================================================
 */
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCustCntcPntVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCustomerDBDAO extends DBDAOSupport{
	

	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmCustomer(List<MdmCustomerVO> voList) throws DAOException {
		boolean isSuccessful = false;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if (voList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAOAddMdmCustomerCSQL(), voList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
		return isSuccessful; 
	}
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean modifyMdmCustomer(List<MdmCustomerVO> voList) throws DAOException {
		boolean isSuccessful = false;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (voList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAOModifyMdmCustomerUSQL(), voList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;			
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
		return isSuccessful; 
	}
	
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addBkgCustomerSlsRep(List<MdmCustomerVO> voList) throws DAOException {
		boolean isSuccessful = false;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (voList.size() > 0) {
			
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAOAddBkgCustomerSlsRepCSQL(), voList, null);
				
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;			
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
		return isSuccessful; 
	}
	
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @param pk2
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmCustList(String custCntCd,String custSeq) throws DAOException{
		boolean isSuccessful = false; 

		
		try {
			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			
			DBRowSet dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueMdmCustomerDBDAOSearchMdmCustListRSQL(), param, param);
			
			if(dRs.getRowCount() > 0){
				isSuccessful = false;
			}else{
				isSuccessful = true;
			}
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful;	
	}
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @param pk2
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmCustSlsRepList(String custCntCd,String custSeq, String srepCd) throws DAOException{
		boolean isSuccessful = false; 

		
		try {
			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			param.put("srep_cd", srepCd);
			
			DBRowSet dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueMdmCustomerDBDAOSearchMdmCustSlsRepListRSQL(), param, param);
			
			if(dRs.getRowCount() > 0){
				isSuccessful = false;
			}else{
				isSuccessful = true;
			}
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful;	
	}
		
	/**
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmCustomer(List<MdmCustomerVO> voList) throws DAOException{
		boolean isSuccessful = false; 
							
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (voList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAORemoveMdmCustomerUSQL(), voList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;	


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful; 	
	}
	
	/**
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeBkgCustCdVal(List<MdmCustomerVO> voList) throws DAOException{
		boolean isSuccessful = false; 
							
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (voList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAORemoveBkgCustCdValDSQL(), voList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;	


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful; 	
	}
	
	/**
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeBkgCustCdVal(MdmCustomerVO custVO) throws DAOException{
		boolean isSuccessful = false; 
							
		try {
			Map<String, String> velParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			velParam.putAll(custVO.getColumnValues());
			param.putAll(custVO.getColumnValues());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int rowCnt = 0;
			if (custVO != null) {
				rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAORemoveBkgCustCdValDSQL(), param, velParam);
			}//if			
			isSuccessful = true;	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful; 	
	}
	/**
	 * insert, update (mdm_cust_cntc_pnt)
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmCustCntcPnt(List<MdmCustCntcPntVO> voList) throws DAOException {
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (voList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAOAddMdmCustCntcPntCSQL(), voList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;	

			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful; 
	}
	
	/**
	 * insert, update (bkg_cust_cd_val)
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean mergeBkgCustCdVal(List<MdmCustomerVO> voList) throws DAOException {
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (voList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAOMergeBkgCustCdValCSQL(), voList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;	
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful; 
	}
	
	/**
	 * insert, update (mdm_cust_cntc_pnt)
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean modifyMdmCustCntcPnt(List<MdmCustCntcPntVO> voList) throws DAOException {
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (voList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmCustomerDBDAOModifyMdmCustCntcPntUSQL(), voList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;	

		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful; 
	}
		

	/**
	 * 기존 데이타 유무 확인
	 * @param pk1
	 * @param pk2
	 * @param pk3
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchMdmCustCntcPntList(String custCntCd,String custSeq,String custCntcPntSeq) throws DAOException{
		boolean isSuccessful = false; 

		try {
			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			param.put("cust_cntc_pnt_seq", custCntcPntSeq);			
			
			
			DBRowSet dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueMdmCustomerDBDAOSearchMdmCustCntcPntListRSQL(), param, param);
			
			if(dRs.getRowCount() > 0){
				isSuccessful = false;
			}else{
				isSuccessful = true;
			}
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful;	
	}

}
