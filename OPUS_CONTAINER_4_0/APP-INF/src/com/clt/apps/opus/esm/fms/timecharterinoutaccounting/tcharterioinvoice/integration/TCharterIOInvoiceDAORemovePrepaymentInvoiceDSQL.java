/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAORemovePrepaymentInvoiceDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.27 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAORemovePrepaymentInvoiceDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAORemovePrepaymentInvoiceDSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAORemovePrepaymentInvoiceDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}
	
	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("DELETE FROM FMS_INVOICE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND INV_SEQ = @[inv_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration ").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAORemovePrepaymentInvoiceDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}