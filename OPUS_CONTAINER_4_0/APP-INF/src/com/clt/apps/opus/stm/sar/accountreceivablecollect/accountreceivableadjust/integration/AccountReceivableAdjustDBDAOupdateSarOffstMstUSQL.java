/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOupdateSarOffstMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.08 
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

public class AccountReceivableAdjustDBDAOupdateSarOffstMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update SAR_OFFST_MST table
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOupdateSarOffstMstUSQL(){
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
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AccountReceivableAdjustDBDAOupdateSarOffstMstUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OFFST_MST" ).append("\n"); 
		query.append("    SET" ).append("\n"); 
		query.append("             UPD_DT = SYSDATE" ).append("\n"); 
		query.append("           #if  (${ar_offst_dt}  !=  '')  " ).append("\n"); 
		query.append("             , AR_OFFST_DT = @[ar_offst_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("             , OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${offst_curr_cd} != '')" ).append("\n"); 
		query.append("             , OFFST_CURR_CD = @[offst_curr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${bil_to_cnt_cd} != '')" ).append("\n"); 
		query.append("             , BIL_TO_CNT_CD = @[bil_to_cnt_cd]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${bil_to_cust_seq} != '')" ).append("\n"); 
		query.append("             , BIL_TO_CUST_SEQ = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${vndr_no} != '')" ).append("\n"); 
		query.append("             , VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${offst_tp_cd} != '')" ).append("\n"); 
		query.append("             , OFFST_TP_CD = @[offst_tp_cd]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${bl_no} != '')" ).append("\n"); 
		query.append("             , BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           #if (${inv_no} != '')" ).append("\n"); 
		query.append("             , INV_NO = @[inv_no]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${curr_cd} != '')" ).append("\n"); 
		query.append("             , CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${offst_amt} != '')" ).append("\n"); 
		query.append("             , OFFST_AMT = @[offst_amt]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${offst_xch_rt} != '')" ).append("\n"); 
		query.append("             , OFFST_XCH_RT = @[offst_xch_rt]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${offst_xch_amt} != '')" ).append("\n"); 
		query.append("             , OFFST_XCH_AMT = @[offst_xch_amt]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${gl_dt} != '')" ).append("\n"); 
		query.append("             , GL_DT = @[gl_dt]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${cxl_flg} != '')" ).append("\n"); 
		query.append("             , CXL_FLG = @[cxl_flg]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${upd_usr_id} != '')" ).append("\n"); 
		query.append("             , UPD_USR_ID = @[upd_usr_id]        " ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${chg_tp_cd} != '')" ).append("\n"); 
		query.append("             , CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${max_ar_if_no} != '')" ).append("\n"); 
		query.append("             , MAX_AR_IF_NO = @[max_ar_if_no]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${ap_inv_no} != '')" ).append("\n"); 
		query.append("             , AP_INV_NO = @[ap_inv_no]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${rhq_cd} != '')" ).append("\n"); 
		query.append("             , RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${ots_ofc_cd} != '')" ).append("\n"); 
		query.append("             , OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${ots_bal_amt} != '')" ).append("\n"); 
		query.append("             , OTS_BAL_AMT = @[ots_bal_amt]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${offst_ofc_cd} != '')" ).append("\n"); 
		query.append("             , OFFST_OFC_CD = @[offst_ofc_cd]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("    WHERE   1=1" ).append("\n"); 
		query.append("    AND    AR_OFFST_NO = @[ar_offst_no]" ).append("\n"); 
		query.append("    AND    AR_OFFST_SEQ = @[ar_offst_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}