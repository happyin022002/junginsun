/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCancelManageDBDAO.java
*@FileTitle : Invoice Cancel
*Open Issues :
*Change history :
* 1.1 Sunghwan Cho, TRS_TRSP_SVC_ORD Update시 inv_rmk, inv_curr_cd, inv_bzc_amt 도 NULL 처리함
*@LastModifyDate : 2007-02-06
*@LastModifier : Sunghwan Cho
*@LastVersion : 1.1
* 2007-02-06 Lee Sang-Woo 
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.invoicecancelmanage.integration;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.invoicecancelmanage.event.InvoiceCancelEvent;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see InvoiceCancelManageBCImpl 참조
 * @since J2EE 1.4
 */
public class InvoiceCancelManageDBDAO extends DBDAOSupport {
	
	/**
	 * DB에 반영.(추가, 수정)<br>
	 * 
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public boolean multiCancelInvoiceList(Event et) throws DAOException {

		boolean successFlag = false;	
		
		InvoiceCancelEvent event = (InvoiceCancelEvent)et;
		String[] sInv_no  		 = event.getInv_no();
		String[] sInv_vndr_seq   = event.getInv_vndr_seq();	
		Map<String, Object> param = new HashMap<String, Object>();	
		Map<String, Object> param_scg = new HashMap<String, Object>();
		DBRowSet dbRs = null;
		int delCnt  = 0;
		
		try {
			
			for( int z = 0 ; z < sInv_no.length; z++) {
				log.error("sInv_no>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sInv_no[z]);
				log.error("sInv_vndr_seq>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sInv_vndr_seq[z]);
				if(sInv_no[z] == null || sInv_no[z].equals("") ){ throw new Exception("INV_NO is mandatory"); }
				if(sInv_vndr_seq[z] == null || sInv_vndr_seq[z].equals("") ){ throw new Exception("INV_VNDR_SEQ is mandatory");}
				
				param.put("inv_no", sInv_no[z]);
				param.put("inv_vndr_seq", sInv_vndr_seq[z]);
				
				dbRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceCancelManageDBDAOMultiCancelInvoiceListInvRSQL(), param,param);

				if (dbRs != null && dbRs.next()) { 
					if(dbRs.getString("TRSP_INV_AUD_STS_CD") != null && 
							("RC".equals(dbRs.getString("TRSP_INV_AUD_STS_CD"))
							|| "RJ".equals(dbRs.getString("TRSP_INV_AUD_STS_CD"))
							)) {
						
						param_scg.put("cre_ofc_cd", dbRs.getString("CRE_OFC_CD"));
						param_scg.put("inv_no", dbRs.getString("INV_NO"));
						param_scg.put("inv_vndr_seq", dbRs.getString("INV_VNDR_SEQ"));
						
						new SQLExecuter("DEFAULT").executeUpdate(new InvoiceCancelManageDBDAOMultiCancelInvoiceListScgUSQL(), param_scg,param_scg);			
						new SQLExecuter("DEFAULT").executeUpdate(new InvoiceCancelManageDBDAOMultiCancelInvoiceListScgDSQL(), param_scg,param_scg);			
						new SQLExecuter("DEFAULT").executeUpdate(new InvoiceCancelManageDBDAOMultiCancelInvoiceListSoUSQL(), param_scg,param_scg);			
						delCnt = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceCancelManageDBDAOMultiCancelInvoiceListInvDSQL(), param_scg,param_scg);			
						log.error("delCnt>>>>>>>>>>>>>>"+delCnt);
						if(delCnt == Statement.EXECUTE_FAILED){
							log.error("Inv_no | Inv_vndr_seq>>>>>>>>>>>>>>"+sInv_no[z]+" | "+ sInv_vndr_seq[z]);
							successFlag = false;
							throw new DAOException("Fail to delete SQL");
						}
						successFlag = true;
					} else {
						throw new Exception("current invoice status invalid");
					}
				}
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return successFlag;
	}
}