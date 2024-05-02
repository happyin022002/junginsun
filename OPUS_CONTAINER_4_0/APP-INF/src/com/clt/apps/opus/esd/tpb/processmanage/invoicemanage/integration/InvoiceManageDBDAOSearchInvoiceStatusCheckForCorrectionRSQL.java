/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceStatusCheckForCorrection
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
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
		query.append("SELECT NVL(r.n3pty_inv_sts_cd,'N') validyn" ).append("\n"); 
		query.append("FROM tpb_inv_rvis r, tpb_invoice v" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    AND r.n3pty_inv_no = v.n3pty_inv_no" ).append("\n"); 
		query.append("    AND v.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("    AND r.n3pty_inv_sts_cd IN ('A','C') /* A : 현재 버전 AR I/F; C : 현재 */" ).append("\n"); 
		query.append("    AND r.n3pty_inv_no = @[s_n3pty_inv_no]  " ).append("\n"); 

	}
}