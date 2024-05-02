/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EurSoAckManageDBDAO.java
*@FileTitle : Eur S/O  정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.eursoack.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.servicesio.eursoack.basic.EurSoAckManageBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see EurSoAckManageBCImpl 참조
 * @since J2EE 1.4
 */
public class EurSoAckManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param eq_no
	 * @param edi_rcv_rslt_cd
	 * @param edi_rcv_rslt_msg
	 * @param trsp_so_seq
	 * @return
	 * @throws DAOException
	 */
	public int addEurSoAckList(String eq_no, String edi_rcv_rslt_cd, String edi_rcv_rslt_msg, String trsp_so_seq) throws DAOException {
		int resultCount1 = 0;
		boolean isExecute = false ;
		try{
			if(trsp_so_seq == null || trsp_so_seq.equals("") ){ throw new Exception("TRSP_SO_SEQ is mandatory"); }
			
			DBRowSet rs = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trsp_so_seq", trsp_so_seq);
	        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
	        EurSoAckManageDBDAOaddEurSoAckListRSQL template = new EurSoAckManageDBDAOaddEurSoAckListRSQL();	        
	        rs = sqlExe.executeQuery(template,param,null);
	        
	        Map<String, Object> uParam = new HashMap<String, Object>();
	        if ( rs!= null && rs.next()){
				if (searchEurSoAckList(trsp_so_seq)){
					isExecute = true;
					uParam.put("edi_rcv_rslt_cd", edi_rcv_rslt_cd);	
					uParam.put("selCre_ofc_cd", rs.getString("CRE_OFC_CD"));
					uParam.put("edi_rcv_rslt_msg", edi_rcv_rslt_msg.trim());
					uParam.put("trsp_so_seq", trsp_so_seq);
				} else {
					throw new Exception("trsp_so_seq data does not exist.");
				}	        	
	        }
			if ( isExecute ) {
				SQLExecuter sqlUpex = new SQLExecuter("DEFAULT");	        
				EurSoAckManageDBDAOaddEurSoAckListUSQL upTemplate = new EurSoAckManageDBDAOaddEurSoAckListUSQL();
		        resultCount1=sqlUpex.executeUpdate(upTemplate,uParam,null);
			}
			log.info(" resultCount1 : " + resultCount1);
			 
			if (resultCount1 < 0) {
				throw new DAOException("processing fail");
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
	public boolean searchEurSoAckList(String pk1) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet rs = null;
		try{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("pk1", pk1);
	        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
	        EurSoAckManageDBDAOsearchEurSoAckListRSQL template = new EurSoAckManageDBDAOsearchEurSoAckListRSQL();	        
	        rs = sqlExe.executeQuery(template,param,null);
	        
			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1) : "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){
					isSuccessful = true;
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