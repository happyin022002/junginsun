/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : USATruckWoAckManageDBDAO.java
*@FileTitle : USATruck WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-08
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-08 Park Jun-Yong
* 1.0 최초 생성
* N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usatruckediwoack.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Jun-Yong
 * @see USATruckWoAckManageBCImpl 참조
 * @since J2EE 1.4
 */
public class USATruckEdiWoAckManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param edi_ctrl_seq
	 * @param edi_rcv_rslt_cd
	 * @return
	 * @throws DAOException
	 */
	public int addUSATruckEdiWoAckManageList(String edi_ctrl_seq, String edi_rcv_rslt_cd) throws DAOException {
				  
		int resultCount1 = 0;
		DBRowSet rs = null;
	
		try {
			if(edi_ctrl_seq == null || edi_ctrl_seq.equals("") ){ throw new Exception("EDI_CTRL_SEQ is mandatory"); }										
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_ctrl_seq", edi_ctrl_seq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListRSQL template = new USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);
			
			if ( rs!= null && rs.next()){
				if (searchUSATruckEdiWoAckManageList(edi_ctrl_seq)){	
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("edi_rcv_rslt_cd", edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd", rs.getString("CRE_OFC_CD"));
					if("214".equals(rs.getString("EDI_RCV_MSG_TP_CD"))){
						uparam.put("edi_rcv_msg_tp_cd", rs.getString("EDI_RCV_MSG_TP_CD"));
					}else{
						uparam.put("edi_rcv_msg_tp_cd", "997");				
					}	
					uparam.put("edi_ctrl_seq",edi_ctrl_seq);
					USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListUSQL utemplate = new USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListUSQL();	        
					resultCount1 = sqlExe.executeUpdate(utemplate,uparam,uparam);
				} else {
					throw new Exception("edi_ctrl_seq data does not exist.");
				}		
				
				log.info(" resultCount1 : " + resultCount1);
				 
				if (resultCount1 <  0) {
					throw new DAOException("processing fail");
					//throw new DAOException(new ErrorHandler("COM11001").getMessage());
				}			
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
		
		return resultCount1; 
	}

	/**
	 *  ReceiveInterface(Receive) 처리한다.<br>
	 * - N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청
	 * 
	 * @param edi_so_no
	 * @param edi_rcv_rslt_cd
	 * @return
	 * @throws DAOException
	 */
	public int addUSATruckEdi990WoAckManageList(String edi_so_no, String edi_rcv_rslt_cd) throws DAOException {
				  
		int resultCount1 = 0; 
		// Connection Interface  	
		DBRowSet rs = null;
		try {		
			if(edi_so_no == null || edi_so_no.equals("") ){ throw new Exception("EDI_CTRL_SEQ is mandatory"); }										

			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_so_no", edi_so_no);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL template = new USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);
			
			if ( rs!= null && rs.next()){
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("edi_rcv_rslt_cd", edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd", rs.getString("CRE_OFC_CD"));
					if("214".equals(rs.getString("EDI_RCV_MSG_TP_CD"))){
						uparam.put("edi_rcv_msg_tp_cd", rs.getString("EDI_RCV_MSG_TP_CD"));
					}else{
						uparam.put("edi_rcv_msg_tp_cd","990");
					}		
					uparam.put("edi_so_no", edi_so_no);
					USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL utemplate = new USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL();	        
					resultCount1 = sqlExe.executeUpdate(utemplate,uparam,uparam); 					
					
				} else {
					throw new Exception("SO_NO data does not exist.");
				}
			
				log.info(" resultCount1 : " + resultCount1);
				 
				if (resultCount1 <  0) {
					throw new DAOException("processing fail");
					//throw new DAOException(new ErrorHandler("COM11001").getMessage());
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
		
		return resultCount1; 
	}

	
	/**
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchUSATruckEdiWoAckManageList(String pk1) throws DAOException{
		boolean isSuccessful = false;
		DBRowSet rs = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_ctrl_seq", pk1);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USATruckEdiWoAckManageDBDAOsearchUSATruckEdiWoAckManageListRSQL template = new USATruckEdiWoAckManageDBDAOsearchUSATruckEdiWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);            

			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1) : "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){
					isSuccessful = true;
				} else {
					throw new Exception("NOT EXISTS IN TRS 204 TRUCK EDI HISTORY.");
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
	}
}