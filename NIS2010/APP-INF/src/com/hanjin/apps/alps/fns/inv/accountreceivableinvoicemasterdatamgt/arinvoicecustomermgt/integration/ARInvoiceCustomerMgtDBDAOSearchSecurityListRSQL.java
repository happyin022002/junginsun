/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOSearchSecurityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOSearchSecurityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_INV_0074
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOSearchSecurityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOSearchSecurityListRSQL").append("\n"); 
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
		query.append("SELECT A.SCR_SEQ," ).append("\n"); 
		query.append("       A.CUST_SCR_DIV_CD," ).append("\n"); 
		query.append("       A.CUST_SCR_AMT," ).append("\n"); 
		query.append("       A.CUST_SCR_USD_AMT," ).append("\n"); 
		query.append("	   A.CUST_SCR_KRW_AMT," ).append("\n"); 
		query.append("       A.CR_CURR_CD," ).append("\n"); 
		query.append("       A.SCR_ST_DT," ).append("\n"); 
		query.append("       A.SCR_END_DT," ).append("\n"); 
		query.append("       A.SCR_RMK, " ).append("\n"); 
		query.append("       B.CR_ST_DT," ).append("\n"); 
		query.append("       B.CR_END_DT," ).append("\n"); 
		query.append("       B.CR_AMT," ).append("\n"); 
		query.append("       B.CR_CURR_CD CR_CURR," ).append("\n"); 
		query.append("       B.OB_CR_TERM_DYS," ).append("\n"); 
		query.append("       B.IB_CR_TERM_DYS," ).append("\n"); 
		query.append("	   A.CUST_CNT_CD," ).append("\n"); 
		query.append("	   A.CUST_SEQ," ).append("\n"); 
		query.append("	   A.AR_OFC_CD," ).append("\n"); 
		query.append("	   '' CUST_NM" ).append("\n"); 
		query.append("  FROM INV_AR_SCR A, " ).append("\n"); 
		query.append("       MDM_CR_CUST B" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   AND NVL(B.SUB_SYS_NM,'MDM') <> 'ERP'" ).append("\n"); 
		query.append(" ORDER BY A.SCR_SEQ" ).append("\n"); 

	}
}