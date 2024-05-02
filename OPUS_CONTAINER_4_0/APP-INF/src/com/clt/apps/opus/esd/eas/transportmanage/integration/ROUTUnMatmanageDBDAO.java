/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ROUTUnMatmanageDBDAO.java
*@FileTitle : Route UnMatch List
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
* * N200903200050 EAS 보완요청 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.eas.common.util.RequestDataSet;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0002Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0903Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ROUTUnMatmanageDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class ROUTUnMatmanageDBDAO extends DBDAOSupport {

	/**
	 * ROC To를 위한 TPB Office Code 조회.<br>
	 * @param EsdEas0002Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 * * N200903200050 EAS 보완요청 
	 */
	public DBRowSet searchRoutUnMatList(EsdEas0002Event event) throws DAOException {

		DBRowSet dRs = null;
		
		try{
			String ctrl_ofc_cd = event.getCtrlOfcCd().trim();  
			String s_bnd = event.getSBnd().trim();  
			if ( s_bnd.equals("A") ){
				s_bnd = "%";
			}
			
			String org = event.getOrg().trim();  
			String dest = event.getDest().trim();  
			String search_choice = event.getSearchChoice();  
			if ( search_choice==null ) {
				search_choice = "MM";
			}
			
			String somonth = event.getSomonth();  
			String fromsodate = event.getFromsodate();  
			String tosodate = event.getTosodate();  
		    String port = event.getPort();
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("somonth", somonth);
			param.put("ctrl_ofc_cd", ctrl_ofc_cd);
			param.put("s_bnd", s_bnd);
			param.put("org", org);
			param.put("dest", dest);
			param.put("search_choice", search_choice);
			param.put("fromsodate",fromsodate);
			param.put("tosodate",tosodate);
			param.put("port", port);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			ROUTUnMatmanageDBDAOsearchRoutUnMatListRSQL template = new ROUTUnMatmanageDBDAOsearchRoutUnMatListRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);				
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}

	/**
	 * ROC To를 위한 TPB Office Code 조회.<br>
	 * @param EsdEas0903Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRoutUnMatBlInforDetail(EsdEas0903Event event) throws DAOException {

		DBRowSet dRs = null;
		
		try{
			String bkgNo = event.getBkgNo();  

			Map<String, Object> param = new HashMap<String, Object>();

			param.put("bkgNo", bkgNo);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			ROUTUnMatmanageDBDAOsearchRoutUnMatBlInforDetailRSQL template = new ROUTUnMatmanageDBDAOsearchRoutUnMatBlInforDetailRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);				
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}
	
	/**
	 * ROC To를 위한 TPB Office Code 조회.<br>
	 * @param EsdEas0903Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRoutUnMatSoInforDetail(EsdEas0903Event event) throws DAOException {

		DBRowSet dRs = null;
		
		try{
			String bkgNo = event.getBkgNo();  
			String soOfcCd = event.getSoOfcCd();
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("bkgNo", bkgNo);
			param.put("creOfcCd", soOfcCd);
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			ROUTUnMatmanageDBDAOsearchRoutUnMatSoInforDetailRSQL template = new ROUTUnMatmanageDBDAOsearchRoutUnMatSoInforDetailRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);				
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}

	/**
	 * Expense Audit Remark 조회.<br>
	 * @param RequestDataSet dataSet 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchExpnAudRmk(RequestDataSet dataSet) throws DAOException {

		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		String n_bkg_no_split = "";
		if(dataSet.getString("s_bkg_no").length()==11){
			if(dataSet.getString("s_bkg_no_split").equals("")){
				n_bkg_no_split = "  ";
			}else{
				n_bkg_no_split = dataSet.getString("s_bkg_no_split");
			}
		}else{
			n_bkg_no_split = (dataSet.getString("s_bkg_no")).substring(11,13);
		}
		String bkg_no = (dataSet.getString("s_bkg_no")).substring(0,11);  
		String bl_no = dataSet.getString("s_bl_no");  
		String eas_expn_tp_cd = dataSet.getString("s_eas_expn_tp_cd");  

		StringBuffer queryStr = new StringBuffer("");
		queryStr.append( " SELECT BKG_NO,																										".trim() + " \n" );
		queryStr.append( " RMK_CTNT_SEQ,																										".trim() + " \n" );
		queryStr.append( " RMK_CTNT,																											".trim() + " \n" );
		queryStr.append( " DECODE(NVL(TO_CHAR(UPD_DT,'YYYY-MM-DD'),'0'),'0',TO_CHAR(CRE_DT,'YYYY-MM-DD'),TO_CHAR(UPD_DT,'YYYY-MM-DD')) UPD_DT,	".trim() + " \n" );
		queryStr.append( " CRE_OFC_CD,																											".trim() + " \n" );
		queryStr.append( " DECODE(NVL(UPD_USR_ID,'0'),'0',CRE_USR_ID,UPD_USR_ID) UPD_USR_ID, 													".trim() + " \n" );
		queryStr.append( " BL_NO||BL_NO_TP||BL_NO_CHK BL_NO,																					".trim() + " \n" );
		queryStr.append( " EAS_EXPN_TP_CD,																										".trim() + " \n" );
		queryStr.append( " BKG_NO_SPLIT																											".trim() + " \n" );
		queryStr.append( " FROM TRS_EXPN_AUD_RMK																								".trim() + " \n" );
		queryStr.append( " WHERE BKG_NO = ?																										".trim() + " \n" );
		queryStr.append(" AND BKG_NO_SPLIT = ? 					                                                                          				".trim() + " \n" );
		queryStr.append( " AND BL_NO||BL_NO_TP||BL_NO_CHK = ?																					".trim() + " \n" );
		queryStr.append( " AND EAS_EXPN_TP_CD = ?																								".trim() + " \n" );
		queryStr.append( " ORDER BY BKG_NO, BL_NO, RMK_CTNT_SEQ																					".trim() + " \n" );
		
		try {
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}

			ps.setString(i++, bkg_no);
			ps.setString(i++, n_bkg_no_split);
			ps.setString(i++, bl_no);
			ps.setString(i++, eas_expn_tp_cd);
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			} else {
				log.info("\n SQL :" + queryStr );
			}
			rs = ps.executeQuery();
	
			// 결과를 DBRowset에 담는다.
			dRs = new DBRowSet();
			dRs.populate(rs);
			
			log.debug(" size : " + dRs.getRowCount());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return dRs;
	}
	
	/**
	 * Expense Audit Remark 추가/수정.<br>
	 * @param RequestDataSet dataSet 
	 * @throws DAOException
	 */
	public void multiExpnAudRmk(RequestDataSet dataSet) throws DAOException {
/*
		// Connection Interface
		Connection con = null;
//		 INSERT를 수행하기 위한 SQL Statement
		PreparedStatement insertPs = null;
 		// update를 수행하기 위한 SQL Statement
		PreparedStatement updatePs = null;
		// DB ResultSet
		//DBRowSet dRs = null;

		boolean isInsert = false ;
        boolean isUpdate = false ;
        
        //입력
        StringBuffer insertQuery = new StringBuffer();         
        insertQuery.append(" INSERT INTO TRS_EXPN_AUD_RMK													\n");
        insertQuery.append(" (BKG_NO,																		\n");
        insertQuery.append(" BKG_NO_SPLIT,																	\n");
        insertQuery.append(" EAS_EXPN_TP_CD,																\n");
        insertQuery.append(" RMK_CTNT_SEQ,																	\n");
        insertQuery.append(" BL_NO,																			\n");
        insertQuery.append(" BL_NO_TP,																		\n");
        insertQuery.append(" BL_NO_CHK,																		\n");
        insertQuery.append(" RMK_CTNT,																		\n");
        insertQuery.append(" CRE_OFC_CD,																	\n");
        insertQuery.append(" CRE_DT,																		\n");
        insertQuery.append(" UPD_DT,																		\n");
        insertQuery.append(" CRE_USR_ID,																	\n");
        insertQuery.append(" UPD_USR_ID) 																	\n");
        if(dataSet.getString("s_bkg_no").length()==11){
        	insertQuery.append(" VALUES (?, ?, ?, (SELECT NVL(MAX(RMK_CTNT_SEQ),0)+1 FROM TRS_EXPN_AUD_RMK 	\n");
        }else{
        	insertQuery.append(" VALUES (?, ?, ?, (SELECT NVL(MAX(RMK_CTNT_SEQ),0)+1 FROM TRS_EXPN_AUD_RMK 		\n");
        }
        insertQuery.append(" WHERE BKG_NO = ? AND BKG_NO_SPLIT = ? AND BL_NO||BL_NO_TP||BL_NO_CHK = ?),							\n");
        insertQuery.append(" SUBSTR(?, 1, 10), SUBSTR(?, 11, 1), SUBSTR(?, 12, 1), ?, ?, 					\n");
        insertQuery.append("  SYSDATE, SYSDATE, ?, ?)														\n");

        //수정
        StringBuffer updateQuery = new StringBuffer();        
        updateQuery.append(" UPDATE TRS_EXPN_AUD_RMK									\n");
        updateQuery.append(" SET RMK_CTNT = ?,											\n");
        updateQuery.append("     UPD_USR_ID = ?,										\n");
        updateQuery.append("     UPD_DT = SYSDATE,										\n");
        updateQuery.append("     CRE_OFC_CD = ?											\n");
        updateQuery.append(" WHERE BKG_NO = ? 											\n");
        updateQuery.append(" AND BKG_NO_SPLIT = ? 						\n");
        updateQuery.append(" AND BL_NO||BL_NO_TP||BL_NO_CHK = ? 						\n");
        updateQuery.append(" AND EAS_EXPN_TP_CD = ?										\n");
        updateQuery.append(" AND RMK_CTNT_SEQ = ? 										\n");
        
        try {
			con = getConnection();
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				insertPs = new LoggableStatement(con, insertQuery.toString());
				updatePs = new LoggableStatement(con, updateQuery.toString());
			} else {
				insertPs = con.prepareStatement(insertQuery.toString());
				updatePs = con.prepareStatement(updateQuery.toString());
			}
					
            for(int i=1; i<dataSet.getParameterLength("ib_flag"); i++) {
    			
				if (dataSet.getString("ib_flag",i).equals("I")) {
					isInsert = true;
					int idx = 1;
					String n_bkg_no_split = "";
			        //수정 bkg_no 자릿수 
					insertPs.setString(idx++, (dataSet.getString("s_bkg_no",i)).substring(0,11));
	
					if(dataSet.getString("s_bkg_no").length()==11){
						if(dataSet.getString("s_bkg_no_split",i).equals("")){
							n_bkg_no_split = "  ";
						}else{
							n_bkg_no_split = dataSet.getString("s_bkg_no_split",i);
						}
					}else{
						n_bkg_no_split = (dataSet.getString("s_bkg_no",i)).substring(11,13);
					}
					insertPs.setString(idx++, n_bkg_no_split);
					insertPs.setString(idx++, dataSet.getString("s_eas_expn_tp_cd",i));
					insertPs.setString(idx++, (dataSet.getString("s_bkg_no",i)).substring(0,11));
					insertPs.setString(idx++, n_bkg_no_split);					
					insertPs.setString(idx++, dataSet.getString("s_bl_no",i));
					insertPs.setString(idx++, dataSet.getString("s_bl_no",i));
					insertPs.setString(idx++, dataSet.getString("s_bl_no",i));
					insertPs.setString(idx++, dataSet.getString("s_bl_no",i));
					insertPs.setString(idx++, dataSet.getString("rmk_ctnt"));
					insertPs.setString(idx++, dataSet.getString("s_cre_ofc_cd"));
					insertPs.setString(idx++, dataSet.getString("s_user_id"));
					insertPs.setString(idx++, dataSet.getString("s_user_id"));
					
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						log.info("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
					} else {
						log.info("\n SQL :" + insertQuery );
					}
					
					insertPs.addBatch();
					
				} else if (dataSet.getString("ib_flag",i).equals("U")) {
					isUpdate = true ;
					int idx = 1;
					String n_bkg_no_split = "";					
					if(dataSet.getString("s_bkg_no").length()==11){
						if(dataSet.getString("s_bkg_no_split",i).equals("")){
							n_bkg_no_split = "  ";
						}else{
							n_bkg_no_split = dataSet.getString("s_bkg_no_split",i);
						}
					}else{
						n_bkg_no_split = (dataSet.getString("s_bkg_no",i)).substring(11,13);
					}
					updatePs.setString(idx++, dataSet.getString("rmk_ctnt",i));
					updatePs.setString(idx++, dataSet.getString("s_user_id",i));
					updatePs.setString(idx++, dataSet.getString("s_cre_ofc_cd",i));
					updatePs.setString(idx++, (dataSet.getString("s_bkg_no",i)).substring(0,11));
					updatePs.setString(idx++, n_bkg_no_split);
					updatePs.setString(idx++, dataSet.getString("s_bl_no",i));
					updatePs.setString(idx++, dataSet.getString("s_eas_expn_tp_cd",i));
					updatePs.setString(idx++, dataSet.getString("rmk_ctnt_seq"));
					
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						log.info("\n SQL :" + ((LoggableStatement)updatePs).getQueryString());
					} else {
						log.info("\n SQL :" + updateQuery );
					}
					updatePs.addBatch();
				} 
					
            }
            
			if( isInsert ) insertPs.executeBatch();
			if( isUpdate ) updatePs.executeBatch();			
			
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
            closeStatement(insertPs);
            closeStatement(updatePs);
            closeConnection(con);
        }
        */
    }
    
}