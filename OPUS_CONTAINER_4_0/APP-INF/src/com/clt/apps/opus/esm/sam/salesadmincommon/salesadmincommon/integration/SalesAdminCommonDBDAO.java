/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonDBDAO.java
*@FileTitle : Sales Activity Item
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.ccd.ccdcommon.ccdcommon.integration.CcdCommonDBDAOCheckVndrCodeRSQL;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic.SalesAdminCommonBCImpl;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SamActTpMstVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SearchActItemMstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SamSlsActTpDtlVO;
import com.clt.syscommon.common.table.SamSlsActVO;


/**
 * ALPS SalesAdminCommonDBDAO <br>
 * - ALPS-SalesAdminCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONGJINHO
 * @see SalesAdminCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class SalesAdminCommonDBDAO extends DBDAOSupport {

	/**
	 * [Sheet1] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchActItemMstVO searchActItemMstVO
	 * @return List<SearchActItemMstVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchActItemMstVO> searchActItemMstList(SearchActItemMstVO searchActItemMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchActItemMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchActItemMstVO != null){
				Map<String, String> mapVO = searchActItemMstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOSearchActItemMstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActItemMstVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 
	/**
	 * [Sheet2] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchActItemMstVO searchActItemMstVO
	 * @return List<SearchActItemMstVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchActItemMstVO> searchActItemDtlList(SearchActItemMstVO searchActItemMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchActItemMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchActItemMstVO != null){
				Map<String, String> mapVO = searchActItemMstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOSearchActItemDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActItemMstVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	
	/**
	 * [Sheet1] 정보를 [추가 후 저장] 합니다.<br>
	 * 
	 * @param List<SamActTpMstVO> samActTpMstVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addActItemMstList(List<SamActTpMstVO> samActTpMstVOs) throws Exception{
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(samActTpMstVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = samActTpMstVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new SalesAdminCommonDBDAOAddActItemMstListCSQL(), samActTpMstVOs, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Sheet1] 정보를 [수정  후 저장] 합니다.<br>
	 * 
	 * @param List<SamActTpMstVO> samActTpMstVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyActItemMstList(List<SamActTpMstVO> samActTpMstVOs) throws Exception{
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(samActTpMstVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = samActTpMstVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new SalesAdminCommonDBDAOModifyActItemMstListUSQL(), samActTpMstVOs, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [Sheet1] 정보를 [삭제 후 저장] 합니다.<br>
	 * 
	 * @param List<SamActTpMstVO> samActTpMstVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeActItemMstList(List<SamActTpMstVO> samActTpMstVOs) throws Exception, DAOException{
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(samActTpMstVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = samActTpMstVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new SalesAdminCommonDBDAORemoveActItemMstListDSQL(), samActTpMstVOs, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [Sheet2] 정보를 [추가 후 저장] 합니다.<br>
	 * 
	 * @param List<SamSlsActTpDtlVO> samSlsActTpDtlVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addActItemMstListS(List<SamSlsActTpDtlVO> samSlsActTpDtlVOs) throws Exception, DAOException{
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(samSlsActTpDtlVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = samSlsActTpDtlVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new SalesAdminCommonDBDAOAddActItemMstListSCSQL(), samSlsActTpDtlVOs, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Sheet2] 정보를 [수정 후 저장] 합니다.<br>
	 * 
	 * @param List<SamSlsActTpDtlVO> samSlsActTpDtlVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyActItemMstListS(List<SamSlsActTpDtlVO> samSlsActTpDtlVOs) throws Exception, DAOException{
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(samSlsActTpDtlVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = samSlsActTpDtlVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new SalesAdminCommonDBDAOModifyActItemMstListSUSQL(), samSlsActTpDtlVOs, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [Sheet2] 정보를 [삭제 후 저장] 합니다.<br>
	 * 
	 * @param List<SamSlsActTpDtlVO> samSlsActTpDtlVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeActItemMstListS(List<SamSlsActTpDtlVO> samSlsActTpDtlVOs) throws Exception, DAOException{
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(samSlsActTpDtlVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = samSlsActTpDtlVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new SalesAdminCommonDBDAORemoveActItemDtlListDSQL(), samSlsActTpDtlVOs, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [Sheet1] 정보를 [삭제 후] [sheet2] 정보를 [함께 삭제] 합니다.<br>
	 * 
	 * @param List<SamActTpMstVO> samActTpMstVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeActItemMstDtlList(List<SamActTpMstVO> samActTpMstVOs) throws Exception, DAOException{
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(samActTpMstVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = samActTpMstVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new SalesAdminCommonDBDAORemoveActItemMstDtlListDSQL(), samActTpMstVOs, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet checkCustomerCode(String custCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(custCd != null){
					param.put("cust_cd"    ,custCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckCustomerCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * CR Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet checkCrCustomerCode(String custCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(custCd != null){
					param.put("cust_cd"    ,custCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckCrCustomerCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * CR Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet checkCntcCustomerCode(String custCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(custCd != null){
					param.put("cust_cd"    ,custCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckCntcCustomerCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	
	/**
	 * Customer Code와 Name 을 체크합니다.<br>
	 * 
	 * @param String custCdNm
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet checkCustCodeName(String custCdNm) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(custCdNm != null){
					param.put("cust_cd" ,custCdNm);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckCustCodeNameRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	
	/**
	 * Group Customer Name 을 가져옵니다.<br>
	 * 
	 * @param String grpCustCd
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet getGroupCustName(String grpCustCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(grpCustCd != null){
					param.put("cust_grp_id" ,grpCustCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOGetGroupCustNameRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	
	/**
	 * Office Code 를 체크합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet checkOfficeCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(ofcCd != null){
					param.put("ofc_cd" ,ofcCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckOfficeCdRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	
	/**
	 * Sales Repository Code 를 체크합니다.<br>
	 * 
	 * @param String sRepCd
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet checkSalesRepCode(String sRepCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(sRepCd != null){
					param.put("srep_cd" ,sRepCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckSalesRepCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}

	/**
	 * User Authority 를 가져옵니다.<br>
	 * 
	 * @param String usrAuth
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet getUserAuth(SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(account.getUsr_id() != null){
					param.put("usr_id" ,account.getUsr_id());
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOGetUserAuthRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	
	/**
	 * Location Code 를 가져옵니다.<br>
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DBRowSet checkLocCode(String locCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(locCd != null){
					param.put("loc_cd" ,locCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckLocCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * Office Team Code 를 가져옵니다.<br>
	 * 
	 * @param String ofcTeamCd
	 * @return String
	 * @exception EventException
	 */
	public DBRowSet checkOfcTeamCode(String ofcTeamCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(ofcTeamCd != null){
					param.put("ofc_team_cd" ,ofcTeamCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckOfcTeamCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	
	
	/**
	 * Activity Type 을 가져옵니다.<br>
	 * 
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchSamActType() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","SamActType");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOSearchSamActTypeRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	
	
	/**
	 * Sub Activity Type 을 가져옵니다.<br>
	 * 
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchSamActSubType() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","SamActSubType");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOSearchSamActSubTypeRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * Major Trade 을 가져옵니다.<br>
	 * 
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchMajorTrade() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","MajorTrade");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOSearchMajorTradeRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Customer의 Activity를 실행한 Sales Rep을 조회합니다.<br>
	 * 
	 * @param SamSlsActVO samSlsActVO
	 * @return String
	 * @exception DAOException
	 */
	public DBRowSet checkSrepByActivity(SamSlsActVO samSlsActVO) throws DAOException{
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
			try {
				if(samSlsActVO != null){
					Map<String, String> mapVO = samSlsActVO.getColumnValues();
					param.putAll(mapVO);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesAdminCommonDBDAOCheckSrepByActivityRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
}