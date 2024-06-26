/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOModifyCustomerSecurityUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.09 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOModifyCustomerSecurityUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_INV_0074
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOModifyCustomerSecurityUSQL(){
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
		params.put("cr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOModifyCustomerSecurityUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_SCR" ).append("\n"); 
		query.append("SET CUST_SCR_DIV_CD		= @[cust_scr_div_cd]" ).append("\n"); 
		query.append(", CUST_SCR_AMT    = @[cust_scr_amt]" ).append("\n"); 
		query.append(", CUST_SCR_USD_AMT     = @[cust_scr_usd_amt]" ).append("\n"); 
		query.append(", CUST_SCR_KRW_AMT     = @[cust_scr_krw_amt]" ).append("\n"); 
		query.append(", CR_CURR_CD           = @[cr_curr_cd]" ).append("\n"); 
		query.append(", SCR_ST_DT            = REPLACE(@[scr_st_dt],'-','')" ).append("\n"); 
		query.append(", SCR_END_DT           = REPLACE(@[scr_end_dt],'-','')" ).append("\n"); 
		query.append(", SCR_RMK              = @[scr_rmk]" ).append("\n"); 
		query.append(", UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD			= @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ				= @[cust_seq]" ).append("\n"); 
		query.append("AND SCR_SEQ				= @[scr_seq]" ).append("\n"); 

	}
}