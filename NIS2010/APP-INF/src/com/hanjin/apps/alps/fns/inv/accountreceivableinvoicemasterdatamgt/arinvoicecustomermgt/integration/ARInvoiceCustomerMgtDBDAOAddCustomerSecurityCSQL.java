/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOAddCustomerSecurityCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.05 
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

public class ARInvoiceCustomerMgtDBDAOAddCustomerSecurityCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_INV_0074
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOAddCustomerSecurityCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_scr_krw_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_scr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scr_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_scr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scr_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_scr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOAddCustomerSecurityCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_SCR (" ).append("\n"); 
		query.append("			  CUST_CNT_CD" ).append("\n"); 
		query.append("			, CUST_SEQ" ).append("\n"); 
		query.append("			, SCR_SEQ" ).append("\n"); 
		query.append("			, AR_OFC_CD" ).append("\n"); 
		query.append("			, CUST_SCR_DIV_CD" ).append("\n"); 
		query.append("			, CUST_SCR_AMT" ).append("\n"); 
		query.append("			, CUST_SCR_USD_AMT" ).append("\n"); 
		query.append("			, CUST_SCR_KRW_AMT" ).append("\n"); 
		query.append("			, CR_CURR_CD" ).append("\n"); 
		query.append("			, SCR_ST_DT" ).append("\n"); 
		query.append("			, SCR_END_DT" ).append("\n"); 
		query.append("			, SCR_RMK" ).append("\n"); 
		query.append("			, CRE_USR_ID" ).append("\n"); 
		query.append("			, CRE_DT" ).append("\n"); 
		query.append("			, UPD_USR_ID" ).append("\n"); 
		query.append("			, UPD_DT )" ).append("\n"); 
		query.append("	VALUES" ).append("\n"); 
		query.append("			( @[cust_cnt_cd] " ).append("\n"); 
		query.append("			, @[cust_seq]   " ).append("\n"); 
		query.append("			, (SELECT NVL(MAX(SCR_SEQ)+1,1) " ).append("\n"); 
		query.append("				 FROM INV_AR_SCR " ).append("\n"); 
		query.append("				WHERE CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("				  AND CUST_SEQ = @[cust_seq])    " ).append("\n"); 
		query.append("			, @[ar_ofc_cd]   " ).append("\n"); 
		query.append("			, @[cust_scr_div_cd]" ).append("\n"); 
		query.append("			, @[cust_scr_amt]" ).append("\n"); 
		query.append("			, @[cust_scr_usd_amt]" ).append("\n"); 
		query.append("			, @[cust_scr_krw_amt]" ).append("\n"); 
		query.append("			, @[cr_curr_cd]  " ).append("\n"); 
		query.append("			, REPLACE(@[scr_st_dt],'-','')" ).append("\n"); 
		query.append("			, REPLACE(@[scr_end_dt],'-','')  " ).append("\n"); 
		query.append("			, @[scr_rmk]     " ).append("\n"); 
		query.append("			, @[cre_usr_id]  " ).append("\n"); 
		query.append("			, SYSDATE      " ).append("\n"); 
		query.append("			, @[upd_usr_id]  " ).append("\n"); 
		query.append("			, SYSDATE)" ).append("\n"); 

	}
}