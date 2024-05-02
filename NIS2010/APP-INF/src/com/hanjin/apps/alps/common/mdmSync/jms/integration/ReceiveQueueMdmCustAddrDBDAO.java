/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CUST_ADDRDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 
 * 2009.06.25 R200906190002 Customer Address PK 변경 요청 : iskim
 * 			addr_tp_cd 를 PK 에서 제거
 * 			
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.SearchMdmCustAddrVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.SearchMdmOrganizationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCustAddr;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCustAddrDBDAO extends DBDAOSupport{
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmCustAddr(SearchMdmCustAddrVO searchMdmCustAddrVO) throws DAOException {
		
		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt = 0;
				if (searchMdmCustAddrVO !=null) {
					insCnt = sqlExe.executeUpdate(
							new ReceiveQueueMdmCustAddrDBDAOAddMdmCustAddrCSQL(),
							searchMdmCustAddrVO.getColumnValues(), null);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert..");
					
				}//if
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into mdm_cust_addr:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into mdm_cust_addr:",new String[]{}).getMessage());
			}//try
		
		return resultFlag;
	}	
	
	/**
	 * 기존 데이타 유무 확인
	 * @param SearchMdmCustAddrVO
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDMCustAddrList(SearchMdmCustAddrVO searchMdmCustAddrVO) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
		int rowCount = 0;
		try {
			if (searchMdmCustAddrVO !=null) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReceiveQueueMdmCustAddrDBDAOSearchMdmCustAddrListRSQL(),	searchMdmCustAddrVO.getColumnValues(), null);
				while (dbRowset.next()) {
					rowCount++;
					isSuccessful = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.error("in dbdao cust_cnt_cd = " + searchMdmCustAddrVO.getCustCntCd() + " / cust_seq = " + searchMdmCustAddrVO.getCustSeq() + " / rowCnt = " + rowCount + "  /  searchMDMCustAddrList isSuccessful = " + isSuccessful);
		return isSuccessful;	
	}	
	
	 /** Updating  table
	  *  @parameter List<SearchMdmOrganizationVO
	  *  @throw
	  */
	public boolean modifyMdmCustAddr(SearchMdmCustAddrVO searchMdmCustAddrVO)throws DAOException{

		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt = 0;
				if (searchMdmCustAddrVO != null) {
					insCnt = sqlExe.executeUpdate(
							new ReceiveQueueMdmCustAddrDBDAOModifyMdmCustAddrUSQL(),
							searchMdmCustAddrVO.getColumnValues(), null);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update..");
					
				}//if
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Updateing  mdm_cust_addr:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Updateing  mdm_cust_addr:",new String[]{}).getMessage());
			}//try
			
		return resultFlag;   	
   }	
	/**
	 * crm_row_id 가 있는 경우 update, 없는 경우 insert
	 * @param crm_row_id
	 * @return
	 * @throws DAOException
	 */
//	public boolean searchCrm_row_id(String crm_row_id) throws DAOException{
//		boolean isSuccessful = false; 
//		Connection con = null;
//		PreparedStatement selectPs  = null;
//		ResultSet rs = null;
//		DBRowSet dRs = null;
//		
//		String selectQuery = "";
//		selectQuery = "/* " + this.getClass().getName() + " - searchMDMCURRList() */" + "\n"
//			+ " SELECT crm_row_id FROM mdm_cust_addr												".trim() + "\n"
//			+ " WHERE 	crm_row_id = '"+crm_row_id+"'     	               				".trim() + "\n"
//			;
//
//		try {
//			con = getConnection();
//			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				selectPs = new LoggableStatement(con, selectQuery);
//			} else {
//				selectPs = con.prepareStatement(selectQuery);
//			}
//
//			log.info("crm_row_id : " + crm_row_id);
//			
//			rs = selectPs.executeQuery();
//
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//			
//			if(dRs.getRowCount() <= 0)
//				isSuccessful = true;
//				
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(selectPs);
//			closeConnection(con);
//		}
//		return isSuccessful;	
//	}
	
	/**
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmCustAddr(SearchMdmCustAddrVO searchMdmCustAddrVO) throws DAOException{
		  boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt = 0;
				if (searchMdmCustAddrVO !=null) {
					insCnt = sqlExe.executeUpdate(
							new ReceiveQueueMdmCustAddrDBDAORemoveMdmCustAddrDSQL(),
							searchMdmCustAddrVO.getColumnValues(), null);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete..");
					
				}//if
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Deleting into mdm_cust_addr:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Deleting into mdm_cust_addr:",new String[]{}).getMessage());
			}//try
		
		return resultFlag;	
	}
	 /** Updating  table
	  *  @parameter SearchMdmCustAddrVO searchMdmCustAddrVO
	  *  @throw
	  */
	public boolean modifyBkgCustCdVal(SearchMdmCustAddrVO searchMdmCustAddrVO)throws DAOException{

		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt = 0;
				if (searchMdmCustAddrVO != null) {
					insCnt = sqlExe.executeUpdate(
							new ReceiveQueueMdmCustAddrDBDDAOModifyBkgCustCdValAddrUSQL(),
							searchMdmCustAddrVO.getColumnValues(), null);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update..");
					
				}//if
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Updateing  Bkg_Cust_addr:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Updateing  Bkg_Cust_addr:",new String[]{}).getMessage());
			}//try
	
		return resultFlag;   	
  }		

}
