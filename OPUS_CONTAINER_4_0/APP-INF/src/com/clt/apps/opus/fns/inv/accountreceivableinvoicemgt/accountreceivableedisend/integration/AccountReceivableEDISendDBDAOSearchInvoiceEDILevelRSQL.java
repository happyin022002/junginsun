/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEDILevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchInvoiceEDILevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Invoice EDI Level
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEDILevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEDILevelRSQL").append("\n"); 
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
		query.append("SELECT NVL(INV_EDI_LVL_CD, 'B') INV_EDI_LVL_CD" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE (CUST_CNT_CD, CUST_SEQ) IN " ).append("\n"); 
		query.append("#if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("    (SELECT DISTINCT PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("         , PTY.CUST_SEQ" ).append("\n"); 
		query.append("         --, PTY.CTRT_PTY_NM" ).append("\n"); 
		query.append("      FROM PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("         , PRI_SP_HDR HDR" ).append("\n"); 
		query.append("     WHERE HDR.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("       AND PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND HDR.SC_NO = @[sc_rfa_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    (SELECT DISTINCT MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("         , MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("      FROM PRI_RP_MN MN" ).append("\n"); 
		query.append("         , PRI_RP_HDR HDR" ).append("\n"); 
		query.append("     WHERE HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("       AND HDR.RFA_NO = @[sc_rfa_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}