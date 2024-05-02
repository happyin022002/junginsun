/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAP_TAXDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ApTaxVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueApTaxDBDAO extends DBDAOSupport{
	/**
	 * insert, update
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public int addApTax(ApTaxVO apTaxVO) throws DAOException {
		
		int insCnt = 0;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = apTaxVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll( mapVO );
				velParam.putAll( mapVO );
			}		
				
			if(apTaxVO.getApTaxNm()!=null && apTaxVO.getApTaxNm().trim().length()>0 
					&& apTaxVO.getTaxNo()!=null && apTaxVO.getTaxNo().trim().length()>0){	
				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueApTaxDBDAOAddApTaxCSQL(),  param, velParam);
			}
			
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
		return insCnt; 
		
		
//		boolean isSuccessful = false; 
//		// Connection Interface   
//		Connection con = null;
//		// INSERT를 수행하기 위한 SQL Statement
//		PreparedStatement insertPs  = null;
//		// UPDATE를 수행하기 위한 SQL Statement
//		PreparedStatement updatePs  = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		boolean isInsert = false ; 
//		boolean isUpdate = false ;
//		
//		//입력
//		String insertQuery = "";
//		insertQuery = "/* " + this.getClass().getName() + " - addAP_TAX() */					" + "\n"	
//			 + " INSERT INTO ap_tax (                                       					".trim() + "\n"
//			 + "	ap_tax_nm   ,tax_no      ,tax_rt      ,tax_naid_flg,fa_flg      ,			".trim() + "\n"
//			 + "	tax_nsl_flg ,cre_dt      ,cre_usr_id  ,upd_dt      ,upd_usr_id  ,			".trim() + "\n"
//			 + "	eai_evnt_dt ,aval_flg                                              			".trim() + "\n"
//			 + " )                                                                  			".trim() + "\n"
//			 + " VALUES  (																		".trim() + "\n"
//			 + "	HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8'),?,?,									".trim() + "\n"
//			 + "	HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8'),										".trim() + "\n"
//			 + "	to_number(?),							".trim() + "\n"
//			 + "	HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8'),										".trim() + "\n"
//			 + "	to_date(?,'yyyymmddhh24miss'),?,to_date(?,'yyyymmddhh24miss'),				".trim() + "\n"
//			 + "	?,to_date(?,'yyyymmddhh24miss'),?                                         	".trim() + "\n"
//			 + " )																				".trim() + "\n"
//		;	
//		//수정
//		String updateQuery = "";
//		updateQuery = "/* " + this.getClass().getName() + " - modifyAP_TAX() */				" + "\n"	
//			 + " UPDATE ap_tax SET           												".trim() + "\n"
//			 + "	tax_rt	     = to_number(?),		".trim() + "\n"
//			 + "	tax_naid_flg = HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8'),					".trim() + "\n"
//			 + "	fa_flg       = HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8'),					".trim() + "\n"
//			 + "	tax_nsl_flg  = HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8'),					".trim() + "\n"
//			 + "	cre_dt       = to_date(?,'yyyymmddhh24miss'),cre_usr_id   = ?,      	".trim() + "\n"
//			 + "	upd_dt       = to_date(?,'yyyymmddhh24miss'),upd_usr_id   = ?,      	".trim() + "\n"
//			 + "	eai_evnt_dt  = to_date(?,'yyyymmddhh24miss'),aval_flg	  = ?           ".trim() + "\n"
//			 + " WHERE 	ap_tax_nm	= HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8')				".trim() + "\n"
//			 + " AND	tax_no      = ?														".trim() + "\n"
//			 + " AND 	eai_evnt_dt <= to_date(?,'yyyymmddhh24miss')       					".trim() + "\n"
//		;	
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				insertPs = new LoggableStatement(con, insertQuery);
//				updatePs = new LoggableStatement(con, updateQuery);
//			} else {
//				insertPs = con.prepareStatement(insertQuery);
//				updatePs = con.prepareStatement(updateQuery);
//			}
//			
//			AP_TAX model = (AP_TAX)o; 
//			String ap_tax_nm = model.getAp_tax_nm();
//			String tax_no = model.getTax_no();
//			
//			log.info("ap_tax_nm : " + ap_tax_nm);
//			log.info("tax_no : " + tax_no);
//			
//			if(searchAP_TAXList(ap_tax_nm,tax_no)){
//				if ( ap_tax_nm != null && ap_tax_nm.trim().length() > 0 
//						&& tax_no != null && tax_no.trim().length() > 0 ) {
//					isInsert = true ;
//					i = 1; // INSERT INTO ap_tax
//					insertPs.setString(i++, model.getAp_tax_nm   ());
//					insertPs.setString(i++, model.getTax_no      ());
//					insertPs.setString(i++, model.getTax_rt      ());
//					insertPs.setString(i++, model.getTax_naid_flg());
//					insertPs.setString(i++, model.getFa_flg      ());
//					insertPs.setString(i++, model.getTax_nsl_flg ());
//					insertPs.setString(i++, model.getCre_dt      ());
//					insertPs.setString(i++, model.getCre_usr_id  ());
//					insertPs.setString(i++, model.getUpd_dt      ());
//					insertPs.setString(i++, model.getUpd_usr_id  ());
//					insertPs.setString(i++, model.getEai_evnt_dt ());
//					insertPs.setString(i++, model.getAval_flg    ());
//					insertPs.addBatch();
//				}
//			}else{
//				if ( ap_tax_nm != null && ap_tax_nm.trim().length() > 0 
//						&& tax_no != null && tax_no.trim().length() > 0 ) {
//					isUpdate = true;
//					i = 1; // UPDATE ap_tax SET
//					updatePs.setString(i++, model.getTax_rt      ());
//					updatePs.setString(i++, model.getTax_naid_flg());
//					updatePs.setString(i++, model.getFa_flg      ());
//					updatePs.setString(i++, model.getTax_nsl_flg ());
//					updatePs.setString(i++, model.getCre_dt      ());
//					updatePs.setString(i++, model.getCre_usr_id  ());
//					updatePs.setString(i++, model.getUpd_dt      ());
//					updatePs.setString(i++, model.getUpd_usr_id  ());
//					updatePs.setString(i++, model.getEai_evnt_dt ());
//					updatePs.setString(i++, model.getAval_flg    ());
//					updatePs.setString(i++, model.getAp_tax_nm   ());
//					updatePs.setString(i++, model.getTax_no      ());
//					updatePs.setString(i++, model.getEai_evnt_dt ());
//					updatePs.addBatch();
//				}
//			}
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
//				log.info("\n SQL :" + ((LoggableStatement)updatePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + insertQuery );
//				log.info("\n SQL :" + updateQuery );
//			}
//			if ( isInsert )				insertPs.executeBatch();
//			if ( isUpdate )				updatePs.executeBatch();
//			isSuccessful = true;
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(insertPs);
//			closeStatement(updatePs);
//			closeConnection(con);
//			insertQuery = null;
//			updateQuery = null;
//		}
//		return isSuccessful; 
	}
	
	/**
	 * 
	 * @param apTaxVO
	 * @return
	 * @throws DAOException
	 */
	public int modifyApTax(ApTaxVO apTaxVO) throws DAOException {
		int insCnt = 0;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = apTaxVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			if(apTaxVO.getApTaxNm()!=null && apTaxVO.getApTaxNm().trim().length()>0 
					&& apTaxVO.getTaxNo()!=null && apTaxVO.getTaxNo().trim().length()>0){	
				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueApTaxDBDAOModifyApTaxUSQL(),  param, velParam);
			}
			
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
		return insCnt; 
		
		
	}
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchApTaxList(ApTaxVO apTaxVO) throws DAOException{
		
		DBRowSet			dbRowSet	= null;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		boolean			isSuccessful	= true; 
		
		try {
			
			if ( apTaxVO != null ) {
				Map<String, String>	mapVO = apTaxVO.getColumnValues();
				
				param	.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueApTaxDBDAOSearchApTaxListRSQL(), param, null);
			
			if( dbRowSet != null && dbRowSet.next() ) { 
				if( dbRowSet.getRowCount() > 0 ) {
					isSuccessful = false;
				}
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
		
		
//		boolean isSuccessful = false; 
//		// Connection Interface   
//		Connection con = null;
//		// Select를 수행하기 위한 SQL Statement
//		PreparedStatement selectPs  = null;
//		
//		ResultSet rs = null;
//		DBRowSet dRs = null;
//		
//		String selectQuery = "";
//		selectQuery = "/* " + this.getClass().getName() + " - searchAP_TAXList() */	" + "\n"
//			+ " SELECT ap_tax_nm FROM ap_tax													".trim() + "\n"
//			+ " WHERE 	ap_tax_nm = HJSEAI_PKG.h_decode('"+pk+"', 'UTF8' ,'UTF8')		".trim() + "\n"
//			+ " AND 	tax_no 	= '"+pk1+"'     	               						".trim() + "\n"
//			;
//
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				selectPs = new LoggableStatement(con, selectQuery);
//			} else {
//				selectPs = con.prepareStatement(selectQuery);
//			}
//
//			log.info("pk : " + pk);
//			log.info("pk1 : " + pk1);
//			rs = selectPs.executeQuery();
//
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//			
//			if(dRs.getRowCount() <= 0)
//				isSuccessful = true;
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
	}

//	/**
//	 * delete
//	 * @param o
//	 * @return
//	 * @throws DAOException
//	 */
//	public int removeApTax(ApTaxVO apTaxVO) throws DAOException{
//		int insCnt = 0;
//		//query parameter
//		Map<String, Object> param		= new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam	= new HashMap<String, Object>();
//		
//		try {
//			
//			Map<String, String> mapVO = apTaxVO.getColumnValues();
//			
//			if ( mapVO != null ) {
//				param	.putAll( mapVO );
//				velParam.putAll( mapVO );
//			}
//			
//			if(apTaxVO.getApTaxNm()!=null && apTaxVO.getApTaxNm().trim().length()>0 
//					&& apTaxVO.getTaxNo()!=null && apTaxVO.getTaxNo().trim().length()>0){	
//				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueApTaxDBDAORemoveApTaxUSQL(),  param, velParam);
//			}
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		}
//		return insCnt; 
//		
//		
//		boolean isSuccessful = false; 
//		// Connection Interface   
//		Connection con = null;
//		// INSERT를 수행하기 위한 SQL Statement
//		PreparedStatement deletePs  = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;	
//		boolean isDelete = false ; 
//		//입력1
//		String deleteQuery = "";
//		deleteQuery = "/* " + this.getClass().getName() + " - removeAP_TAX() */" + "\n"	
//			 + " UPDATE ap_tax SET aval_flg = 'N'                 			  	".trim() + "\n"
//			 + " WHERE 	ap_tax_nm  = HJSEAI_PKG.h_decode(?, 'UTF8' ,'UTF8')		".trim() + "\n"
//			 + " AND	tax_no    = ?										  	".trim() + "\n"
//			 + " AND 	eai_evnt_dt <= to_date(?,'yyyymmddhh24miss')       		".trim() + "\n"
//		;								
//		try {
//			con = getConnection();
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				deletePs = new LoggableStatement(con, deleteQuery);
//			} else {
//				deletePs = con.prepareStatement(deleteQuery);
//			}
//			
//			AP_TAX model = (AP_TAX)o;
//			String ap_tax_nm = model.getAp_tax_nm();
//			String tax_no = model.getTax_no();
//			
//			log.info("ap_tax_nm : " + ap_tax_nm);
//			log.info("tax_no : " + tax_no);
//			
//			if ( ap_tax_nm != null && ap_tax_nm.trim().length() > 0 
//					&& tax_no != null && tax_no.trim().length() > 0
//					&& !searchAP_TAXList(ap_tax_nm,tax_no)) {
//				isDelete = true ;
//				i = 1; // DELETE FROM ap_tax
//				deletePs.setString(i++, model.getAp_tax_nm());
//				deletePs.setString(i++, model.getTax_no());
//				deletePs.setString(i++, model.getEai_evnt_dt());
//				deletePs.addBatch();
//			}
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + deleteQuery );
//			}
//			if ( isDelete ){
//				deletePs.executeBatch();
//			}
//			isSuccessful = true;
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(deletePs);
//			closeConnection(con);
//			deleteQuery = null;
//		}
//		return isSuccessful; 	
//	}

}