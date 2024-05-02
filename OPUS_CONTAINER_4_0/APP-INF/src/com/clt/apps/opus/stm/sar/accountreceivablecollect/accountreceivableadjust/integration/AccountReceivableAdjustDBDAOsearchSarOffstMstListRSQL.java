/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchSarOffstMstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOsearchSarOffstMstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search AR Offset master
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchSarOffstMstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchSarOffstMstListRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("  ' ' AS ofc_cd" ).append("\n"); 
		query.append(", ' ' AS vndr_no" ).append("\n"); 
		query.append(", ' ' AS vndr_lgl_eng_nm" ).append("\n"); 
		query.append(", ' ' AS offst_tp_cd" ).append("\n"); 
		query.append(", ' ' AS bl_inv_no" ).append("\n"); 
		query.append(", ' ' AS chg_tp_cd" ).append("\n"); 
		query.append(", ' ' AS bl_curr_cd" ).append("\n"); 
		query.append(", ' ' AS inv_amt" ).append("\n"); 
		query.append(", ' ' AS bal_amt" ).append("\n"); 
		query.append(", ' ' AS ar_xch_rt" ).append("\n"); 
		query.append(", ' ' AS ar_xch_amt" ).append("\n"); 
		query.append(", ' ' AS ar_offst_no" ).append("\n"); 
		query.append(", ' ' AS cxl_flg" ).append("\n"); 
		query.append(", ' ' AS bil_to_cust_cnt_cd" ).append("\n"); 
		query.append(", ' ' AS bil_to_cust_seq" ).append("\n"); 
		query.append(", ' ' AS rhq_cd" ).append("\n"); 
		query.append(", ' ' AS ots_ofc_cd" ).append("\n"); 
		query.append(", ' ' AS bl_no" ).append("\n"); 
		query.append(", ' ' AS inv_no" ).append("\n"); 
		query.append(", ' ' AS max_ar_if_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}