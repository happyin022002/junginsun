/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOaddSarOffstMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.28 
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

public class AccountReceivableAdjustDBDAOaddSarOffstMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert offset master
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOaddSarOffstMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_inv_term_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_xch_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_offst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_offst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_offst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOaddSarOffstMstCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_OFFST_MST ( " ).append("\n"); 
		query.append("                  AR_OFFST_NO" ).append("\n"); 
		query.append("                , RHQ_CD" ).append("\n"); 
		query.append("                , OTS_OFC_CD" ).append("\n"); 
		query.append("                , AR_OFFST_SEQ" ).append("\n"); 
		query.append("                , AR_OFFST_DT" ).append("\n"); 
		query.append("                , OFC_CD" ).append("\n"); 
		query.append("                , OFFST_CURR_CD" ).append("\n"); 
		query.append("                , BIL_TO_CNT_CD" ).append("\n"); 
		query.append("                , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("                , VNDR_NO" ).append("\n"); 
		query.append("                , OFFST_TP_CD" ).append("\n"); 
		query.append("                , BL_NO" ).append("\n"); 
		query.append("                , INV_NO" ).append("\n"); 
		query.append("                , CURR_CD" ).append("\n"); 
		query.append("                , OFFST_AMT" ).append("\n"); 
		query.append("                , OFFST_XCH_RT" ).append("\n"); 
		query.append("                , OFFST_XCH_AMT" ).append("\n"); 
		query.append("                , GL_DT" ).append("\n"); 
		query.append("                , CXL_FLG" ).append("\n"); 
		query.append("                , CRE_USR_ID" ).append("\n"); 
		query.append("                , CRE_DT" ).append("\n"); 
		query.append("                , UPD_USR_ID" ).append("\n"); 
		query.append("                , UPD_DT" ).append("\n"); 
		query.append("                , CHG_TP_CD" ).append("\n"); 
		query.append("                , MAX_AR_IF_NO" ).append("\n"); 
		query.append("                , AP_INV_NO" ).append("\n"); 
		query.append("                , OTS_BAL_AMT" ).append("\n"); 
		query.append("                , OFFST_OFC_CD" ).append("\n"); 
		query.append("				, AP_RMK" ).append("\n"); 
		query.append("				, AP_INV_TERM_DT" ).append("\n"); 
		query.append("    ) VALUES ( " ).append("\n"); 
		query.append("                  @[ar_offst_no]" ).append("\n"); 
		query.append("                , @[rhq_cd]" ).append("\n"); 
		query.append("                , @[ots_ofc_cd]" ).append("\n"); 
		query.append("                , @[ar_offst_seq]" ).append("\n"); 
		query.append("                , TO_DATE(@[ar_offst_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                , @[ofc_cd]" ).append("\n"); 
		query.append("                , @[offst_curr_cd]" ).append("\n"); 
		query.append("                , @[bil_to_cnt_cd]" ).append("\n"); 
		query.append("                , @[bil_to_cust_seq]" ).append("\n"); 
		query.append("                , @[vndr_no]" ).append("\n"); 
		query.append("                , @[offst_tp_cd]" ).append("\n"); 
		query.append("                , @[bl_no]" ).append("\n"); 
		query.append("                , @[inv_no]" ).append("\n"); 
		query.append("                , @[curr_cd]" ).append("\n"); 
		query.append("                , @[offst_amt]" ).append("\n"); 
		query.append("                , @[offst_xch_rt]" ).append("\n"); 
		query.append("                , @[offst_xch_amt]" ).append("\n"); 
		query.append("                , TO_DATE(@[gl_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                , @[cxl_flg]" ).append("\n"); 
		query.append("                , @[cre_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("                , @[upd_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("                , @[chg_tp_cd]" ).append("\n"); 
		query.append("                , @[max_ar_if_no]" ).append("\n"); 
		query.append("                , @[ap_inv_no]" ).append("\n"); 
		query.append("                , @[ots_bal_amt]" ).append("\n"); 
		query.append("                , @[offst_ofc_cd]" ).append("\n"); 
		query.append("				, @[ap_rmk]" ).append("\n"); 
		query.append("				, @[ap_inv_term_dt]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}