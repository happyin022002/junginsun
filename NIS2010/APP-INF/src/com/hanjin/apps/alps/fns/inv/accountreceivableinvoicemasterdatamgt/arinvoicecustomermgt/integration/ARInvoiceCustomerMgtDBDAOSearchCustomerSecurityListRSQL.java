/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOSearchCustomerSecurityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
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

public class ARInvoiceCustomerMgtDBDAOSearchCustomerSecurityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOSearchCustomerSecurityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ib_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ob_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ib_term",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_scr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ob_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOSearchCustomerSecurityListRSQL").append("\n"); 
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
		query.append("       B.CUST_LGL_ENG_NM CUST_NM," ).append("\n"); 
		query.append("       A.AR_OFC_CD," ).append("\n"); 
		query.append("       A.CUST_CNT_CD||'-'||LPAD(A.CUST_SEQ,6,0) CUST_CNT_CD," ).append("\n"); 
		query.append("       C.OB_CR_TERM_DYS," ).append("\n"); 
		query.append("       C.IB_CR_TERM_DYS," ).append("\n"); 
		query.append("       A.CUST_SCR_DIV_CD," ).append("\n"); 
		query.append("       A.CUST_SCR_AMT," ).append("\n"); 
		query.append("       A.CUST_SCR_USD_AMT," ).append("\n"); 
		query.append("	   A.CUST_SCR_KRW_AMT," ).append("\n"); 
		query.append("       A.SCR_ST_DT," ).append("\n"); 
		query.append("       A.SCR_END_DT," ).append("\n"); 
		query.append("       A.SCR_RMK," ).append("\n"); 
		query.append("	   A.CR_CURR_CD" ).append("\n"); 
		query.append("  FROM INV_AR_SCR A," ).append("\n"); 
		query.append("       MDM_CUSTOMER B," ).append("\n"); 
		query.append("       MDM_CR_CUST C" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("#if (${cust_scr_div_cd} != '')" ).append("\n"); 
		query.append("   AND A.CUST_SCR_DIV_CD = @[cust_scr_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_ob_term} != '')" ).append("\n"); 
		query.append("   AND C.OB_CR_TERM_DYS BETWEEN @[fm_ob_term] AND @[to_ob_term] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_ib_term} != '')" ).append("\n"); 
		query.append("   AND C.IB_CR_TERM_DYS BETWEEN @[fm_ib_term] AND @[to_ib_term]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[ofc]" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dt} != '')" ).append("\n"); 
		query.append("   AND A.SCR_ST_DT <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${fm_dt} != '')" ).append("\n"); 
		query.append("   AND A.SCR_END_DT >= REPLACE(@[fm_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.CUST_CNT_CD||'-'||LPAD(A.CUST_SEQ,6,0), A.SCR_SEQ" ).append("\n"); 

	}
}