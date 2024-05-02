/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : KorSoAckManageDBDAO.java
*@FileTitle : Kor S/O  정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.korsoack.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.servicesio.korsoack.basic.KorSoAckManageBCImpl;
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
 * @see KorSoAckManageBCImpl 참조
 * @since J2EE 1.4
 */
public class KorSoAckManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * @param wo_edi_rcv_rslt_cd
	 * @param wo_edi_rcv_rslt_msg
	 * @param wo_edi_rcv_purp_cd
	 * @param trsp_wo_ofc_cty_cd
	 * @param trsp_wo_seq
	 * @return
	 * @throws DAOException
	 */
	public int addKorSoAckList(String wo_edi_rcv_rslt_cd, String wo_edi_rcv_rslt_msg, String wo_edi_rcv_purp_cd, String trsp_wo_ofc_cty_cd, String trsp_wo_seq ) throws DAOException {

		DBRowSet rs = null;
	
		int resultCount1 = 0;
		int resultCount = 0;
		
		try {

			if(trsp_wo_ofc_cty_cd == null || trsp_wo_ofc_cty_cd.equals("") ){ throw new Exception("TRSP_WO_OFC_CTY_CD is mandatory"); }			
			if(trsp_wo_seq == null || trsp_wo_seq.equals("") ){ throw new Exception("TRSP_WO_SEQ is mandatory"); }			
			
            
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("trsp_wo_ofc_cty_cd",trsp_wo_ofc_cty_cd);
            param.put("trsp_wo_seq",trsp_wo_seq);
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
            KorSoAckManageDBDAOaddKorSoAckListWoRSQL template = new KorSoAckManageDBDAOaddKorSoAckListWoRSQL();	        
            rs = sqlExe.executeQuery(template,param,null);
  
			if ( rs!= null && rs.next()){				
				if (searchKorSoAckList(trsp_wo_ofc_cty_cd, trsp_wo_seq)){				
	
		            Map<String, Object> uparam = new HashMap<String, Object>();
		            uparam.put("edi_rcv_rslt_cd",wo_edi_rcv_rslt_cd);
		            uparam.put("edi_rcv_rslt_dt",rs.getString("CRE_OFC_CD"));
		            uparam.put("edi_rcv_rslt_msg",wo_edi_rcv_rslt_msg);
		            uparam.put("edi_rcv_purp_cd",wo_edi_rcv_purp_cd);
		            uparam.put("trsp_wo_ofc_cty_cd",trsp_wo_ofc_cty_cd);
		            uparam.put("trsp_wo_seq",trsp_wo_seq);
		            KorSoAckManageDBDAOaddKorSoAckListSoUSQL utemplate = new KorSoAckManageDBDAOaddKorSoAckListSoUSQL();	        
		            resultCount1 = sqlExe.executeUpdate(utemplate,uparam,uparam);

					
					KorSoAckManageDBDAOaddKorSoAckListWoUSQL uWotemplate = new KorSoAckManageDBDAOaddKorSoAckListWoUSQL();	        
		            resultCount = sqlExe.executeUpdate(uWotemplate,uparam,uparam);
	
				} else {
					throw new Exception("trsp_so_seq data does not exist.");
				}		

				log.info(" resultCount1 : " + resultCount1);
				log.info(" resultCount : " + resultCount);
				 
				if (resultCount1 < 0 && resultCount <0 ){
					throw new DAOException("processing fail");
				} else {
					resultCount1 = resultCount1 + resultCount;
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
	 * @param pk1
	 * @param pk2
	 * @return
	 * @throws DAOException
	 */
	public boolean searchKorSoAckList(String pk1, String pk2) throws DAOException{
		boolean isSuccessful = false;
		DBRowSet rs = null;
		try {
	        Map<String, Object> param = new HashMap<String, Object>();
            param.put("trsp_wo_ofc_cty_cd",pk1);
            param.put("trsp_wo_seq",pk2);
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");		        
            KorSoAckManageDBDAOsearchKorSoAckListWoRSQL template = new KorSoAckManageDBDAOsearchKorSoAckListWoRSQL();	        
            rs = sqlExe.executeQuery(template,param,null);

			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1): "+rs.getString(1));
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