/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CHKMAIL_ADDRDBDAO
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-10-22
 *@LastModifier : yujin
 *@LastVersion : 1.0
 * 2007-10-22 yujin
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmChkmailAddr;
import com.hanjin.syscommon.common.table.MdmVendorVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author yujin
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVendorEtcDBDAO extends DBDAOSupport {

	/** 
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmVendor(List<MdmVendorVO> mdmVendorVOs) throws DAOException {

		int rowCnt[] = null;
		
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmVendorEtcDBDAOMergeMdmVendorEtcCSQL(),
					mdmVendorVOs, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}

	public boolean removeMdmVendor(List<MdmVendorVO> mdmVendorVOs) throws DAOException {

		int rowCnt[] = null;
		
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmVendorEtcDBDAORemoveMdmVendorEtcUSQL(),
					mdmVendorVOs, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}
	
//	public boolean addMdmVendor(Collection models) throws DAOException {
//		
//		boolean isSuccessful = false; 
//		// Connection Interface   
//		Connection con = null;
//		// INSERT를 수행하기 위한 SQL Statement
//		PreparedStatement mergePs  = null;
//
//		int i = 1;
//		
//		boolean isMerge = false ; 
//		
//		//입력
//		String mergeQuery = "";
//		mergeQuery = "/* " + this.getClass().getName() + " - addMDM_CHKMAIL_ADDR() */			" + "\n"	
//		+ " MERGE INTO MDM_VENDOR a																".trim() + "\n"                                                  	                          
//		+ " USING ( select ? VNDR_SEQ from dual ) b                                             ".trim() + "\n"
//		+ " ON (a.VNDR_SEQ = b.VNDR_SEQ )                                                       ".trim() + "\n"
//		+ " WHEN MATCHED THEN                                                                   ".trim() + "\n"
//		+ " UPDATE                                                                              ".trim() + "\n"
//		+ " set                                                                                 ".trim() + "\n"
//		+ "  chk_de_addr1  = HJSEAI_PKG.h_decode(?,'UTF8','UTF8')                                                                  ".trim() + "\n"
//		+ " ,chk_de_addr2  = HJSEAI_PKG.h_decode(?,'UTF8','UTF8')                                                                  ".trim() + "\n"
//		+ " ,chk_de_addr3  = HJSEAI_PKG.h_decode(?,'UTF8','UTF8')                                                                  ".trim() + "\n"
//		+ " ,chk_de_cty_nm = ?                                                                  ".trim() + "\n"
//		+ " ,chk_de_ste_cd = ?                                                                  ".trim() + "\n"
//		+ " ,chk_de_zip_cd = ?                                                                  ".trim() + "\n"
//		+ " ,chk_de_cnt_cd = ?                                                                  ".trim() + "\n"
//		+ " ,lu_delt_flg   = ?                                                                  ".trim() + "\n"
//		+ " ,cre_usr_id   = ?                                                                   ".trim() + "\n"
//		+ " ,cre_dt   = to_date(?,'yyyymmddhh24miss')                                           ".trim() + "\n"
//		+ " ,upd_usr_id   = ?                                                                   ".trim() + "\n"
//		+ " ,upd_dt   = to_date(?,'yyyymmddhh24miss')                                           ".trim() + "\n"
//		+ " ,eai_evnt_dt   = to_date(?,'yyyymmddhh24miss')                                      ".trim() + "\n"
//		+ " where VNDR_SEQ   = ?							                                    ".trim() + "\n"
//		+ " WHEN NOT MATCHED THEN                                                               ".trim() + "\n"
//		+ " insert (                                                                            ".trim() + "\n"
//		+ "  VNDR_SEQ, chk_de_addr1, chk_de_addr2, chk_de_addr3,                                ".trim() + "\n"
//		+ "  chk_de_cty_nm, chk_de_ste_cd, chk_de_zip_cd, chk_de_cnt_cd, lu_delt_flg,           ".trim() + "\n"
//		+ "  cre_usr_id, cre_dt, upd_usr_id, upd_dt, eai_evnt_dt					            ".trim() + "\n"
//		+ "                                                                                     ".trim() + "\n"
//		+ " )                                                                                   ".trim() + "\n"
//		+ " values                                                                              ".trim() + "\n"
//		+ " (                                                                                   ".trim() + "\n"
//		+ "  ?, HJSEAI_PKG.h_decode(?,'UTF8','UTF8'), HJSEAI_PKG.h_decode(?,'UTF8','UTF8'), HJSEAI_PKG.h_decode(?,'UTF8','UTF8'),                                                                        ".trim() + "\n"
//		+ "  ?, ?, ?, ?, ?,                                                                      ".trim() + "\n"
//		+ "  ?, to_date(?,'yyyymmddhh24miss'), ?, to_date(?,'yyyymmddhh24miss'), to_date(?,'yyyymmddhh24miss') ".trim() + "\n"
//		+ " )                                                                                   ".trim() + "\n"
//		;	
//
//		
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				mergePs = new LoggableStatement(con, mergeQuery);
//			} else {
//				mergePs = con.prepareStatement(mergeQuery);
//			}
//			
//			Iterator itr = models.iterator();
//			
//			MdmChkmailAddr  model = null;
//			String vndr_seq = null;
//			
//			int kk = 0;
//			
//			while (itr.hasNext()) {
//				
//				model = (MdmChkmailAddr)itr.next();
//				vndr_seq = model.getVndrSeq();
//	
//				log.info("\n //--->>>  vndr_seq : " + vndr_seq);
//
//				isMerge = true;
//				
//				i = 1;
//				
//				//Where
//				mergePs.setString(i++, model.getVndrSeq());
//				
//				//Update
//				mergePs.setString(i++, model.getChk_de_addr1());
//				mergePs.setString(i++, model.getChk_de_addr2());
//				mergePs.setString(i++, model.getChk_de_addr3());
//				mergePs.setString(i++, model.getChk_de_cty_nm());
//				mergePs.setString(i++, model.getChk_de_ste_cd());
//				mergePs.setString(i++, model.getChk_de_zip_cd());
//				mergePs.setString(i++, model.getChk_de_cnt_cd());
//				mergePs.setString(i++, model.getLu_delt_flg());
//				mergePs.setString(i++, model.getCreUsrId());
//				mergePs.setString(i++, model.getCreDt());
//				mergePs.setString(i++, model.getUpdusrId());
//				mergePs.setString(i++, model.getUpdDt());
//				mergePs.setString(i++, model.getEai_evnt_dt());
//				mergePs.setString(i++, model.getVndrSeq());
//				
//				//Insert
//				mergePs.setString(i++, model.getVndrSeq());
//				mergePs.setString(i++, model.getChk_de_addr1());
//				mergePs.setString(i++, model.getChk_de_addr2());
//				mergePs.setString(i++, model.getChk_de_addr3());
//				mergePs.setString(i++, model.getChk_de_cty_nm());
//				mergePs.setString(i++, model.getChk_de_ste_cd());
//				mergePs.setString(i++, model.getChk_de_zip_cd());
//				mergePs.setString(i++, model.getChk_de_cnt_cd());
//				mergePs.setString(i++, model.getLu_delt_flg());
//				mergePs.setString(i++, model.getCreUsrId());
//				mergePs.setString(i++, model.getCreDt());
//				mergePs.setString(i++, model.getUpdusrId());
//				mergePs.setString(i++, model.getUpdDt());
//				mergePs.setString(i++, model.getEai_evnt_dt());
//						
//				
//				mergePs.addBatch();
//				
//				kk++;
//				
//				log.info("\n //--->>> SQL : "+kk+" ---- " );
//				
//			}
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n //--->>> SQL : "+kk+" ---- " + ((LoggableStatement)mergePs).getQueryString());
//			} else {
//				log.info("\n //--->>> SQL : "+kk+" ---- " + mergePs );
//			}
//			
//			if ( isMerge ) mergePs.executeBatch();
//			
//			log.info("\n //--->>> isMerge : " + isMerge );
//			
//			isSuccessful = true;
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
//		} finally {
//			closeStatement(mergePs);
//			closeConnection(con);
//			mergeQuery = null;
//		}
//		return isSuccessful; 
//	}	

	/** 
	 * Delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
//	public boolean removeMdmVendor(Collection models) throws DAOException {
//		
//		boolean isSuccessful = false; 
//		// Connection Interface   
//		Connection con = null;
//
//		// DELETE를 수행하기 위한 SQL Statement
//		PreparedStatement deletePs  = null;
//		
//		int i = 1;
//		
//		boolean isMerge = false ; 
//
//		//삭제
//		String updateQuery = "";
//		updateQuery = "/* " + this.getClass().getName() + " - removeMDM_CHKMAIL_ADDR() */	" + "\n"	
//			+ " update MDM_VENDOR                              								".trim() + "\n"
//			+ " set  lu_delt_flg = ?     	   												".trim() + "\n"
//			+ "     ,upd_usr_id   = ?                                                       ".trim() + "\n"
//			+ "     ,upd_dt   = to_date(?,'yyyymmddhh24miss')                               ".trim() + "\n"
//			+ "     ,eai_evnt_dt   = to_date(?,'yyyymmddhh24miss')                          ".trim() + "\n"
//			+ " where vndr_seq = ?     	       												".trim() + "\n"
//			;
//
//		
//		
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				deletePs = new LoggableStatement(con, updateQuery);
//			} else {
//				deletePs = con.prepareStatement(updateQuery);
//			}
//			
//			Iterator itr = models.iterator();
//			
//			MdmChkmailAddr  model = null;
//			String vndr_seq = null;
//			
//			while (itr.hasNext()) {
//				
//				model = (MdmChkmailAddr)itr.next();
//				vndr_seq = model.getVndrSeq();
//	
//				log.info("vndr_seq : " + vndr_seq);
//
//				isMerge = true;
//				
//				i = 1;
//				
//			
//				//Update
//				deletePs.setString(i++, model.getLu_delt_flg());
//				deletePs.setString(i++, model.getUpdusrId());
//				deletePs.setString(i++, model.getUpdDt());
//				deletePs.setString(i++, model.getEai_evnt_dt());
//				deletePs.setString(i++, model.getVndrSeq());
//						
//				
//				deletePs.addBatch();
//			}
//			
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + deletePs );
//			}
//
//			if ( isMerge )				deletePs.executeBatch();
//			
//			isSuccessful = true;
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
//		} finally {
//			closeStatement(deletePs);
//			closeConnection(con);
//			updateQuery = null;
//		}
//		return isSuccessful; 
//	}	
}
