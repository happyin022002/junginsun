/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOUpdateSarAgnCltRfndMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOUpdateSarAgnCltRfndMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update SAR Agent collect & refund master table(SAR_AGN_CLT_RFND_MST)
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOUpdateSarAgnCltRfndMstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqv_locl_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_ob_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_clt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_locl_amt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_curr_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_xch_rt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_locl_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_xch_rt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_locl_amt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_locl_amt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_curr_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqv_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_xch_rt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_curr_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_curr_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_xch_rt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_amt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_amt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_xch_rt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_xch_rt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_amt4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOUpdateSarAgnCltRfndMstUSQL").append("\n"); 
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
		query.append("UPDATE SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("    SET" ).append("\n"); 
		query.append("            UPD_DT = SYSDATE" ).append("\n"); 
		query.append("           #if( ${asa_clt_seq} != '' )" ).append("\n"); 
		query.append("           , ASA_CLT_SEQ = @[asa_clt_seq]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ar_ofc_cd} != '' )" ).append("\n"); 
		query.append("           , AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${vvd_cd} != '' )" ).append("\n"); 
		query.append("           , VVD_CD = @[vvd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${port_cd} != '' )" ).append("\n"); 
		query.append("           , PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${due_dt} != '' )" ).append("\n"); 
		query.append("           , DUE_DT = @[due_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_tp_cd} != '' )" ).append("\n"); 
		query.append("           , ASA_TP_CD = @[asa_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${usd_amt} != '' )" ).append("\n"); 
		query.append("           , USD_AMT = @[usd_amt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_xch_rt1} != '' )" ).append("\n"); 
		query.append("           , ASA_XCH_RT1 = @[asa_xch_rt1]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${eqv_locl_amt} != '' )" ).append("\n"); 
		query.append("           , EQV_LOCL_AMT = @[eqv_locl_amt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${locl_amt} != '' )" ).append("\n"); 
		query.append("           , LOCL_AMT = @[locl_amt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_xch_rt2} != '' )" ).append("\n"); 
		query.append("           , ASA_XCH_RT2 = @[asa_xch_rt2]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${chg_usd_amt} != '' )" ).append("\n"); 
		query.append("           , CHG_USD_AMT = @[chg_usd_amt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ttl_amt} != '' )" ).append("\n"); 
		query.append("           , TTL_AMT = @[ttl_amt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_rmk} != '' )" ).append("\n"); 
		query.append("           , ASA_RMK = @[asa_rmk]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${eff_dt} != '' )" ).append("\n"); 
		query.append("           , EFF_DT = @[eff_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${agn_cd} != '' )" ).append("\n"); 
		query.append("           , AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${svc_scp_cd} != '' )" ).append("\n"); 
		query.append("           , SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ib_ob_cd} != '' )" ).append("\n"); 
		query.append("           , IB_OB_CD = @[ib_ob_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_curr_cd} != '' )" ).append("\n"); 
		query.append("           , ASA_CURR_CD = @[asa_curr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${sail_arr_dt} != '' )" ).append("\n"); 
		query.append("           , SAIL_ARR_DT = @[sail_arr_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${gl_yrmon} != '' )" ).append("\n"); 
		query.append("           , GL_YRMON = @[gl_yrmon]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${locl_curr_cd} != '' )" ).append("\n"); 
		query.append("           , LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_curr_cd1} != '' )" ).append("\n"); 
		query.append("           , N3RD_CURR_CD1 = @[n3rd_curr_cd1]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_amt1} != '' )" ).append("\n"); 
		query.append("           , N3RD_AMT1 = @[n3rd_amt1]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_xch_rt1} != '' )" ).append("\n"); 
		query.append("           , N3RD_XCH_RT1 = @[n3rd_xch_rt1]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_locl_amt1} != '' )" ).append("\n"); 
		query.append("           , N3RD_LOCL_AMT1 = @[n3rd_locl_amt1]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_curr_cd2} != '' )" ).append("\n"); 
		query.append("           , N3RD_CURR_CD2 = @[n3rd_curr_cd2]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_amt2} != '' )" ).append("\n"); 
		query.append("           , N3RD_AMT2 = @[n3rd_amt2]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_xch_rt2} != '' )" ).append("\n"); 
		query.append("           , N3RD_XCH_RT2 = @[n3rd_xch_rt2]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_locl_amt2} != '' )" ).append("\n"); 
		query.append("           , N3RD_LOCL_AMT2 = @[n3rd_locl_amt2]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_curr_cd3} != '' )" ).append("\n"); 
		query.append("           , N3RD_CURR_CD3 = @[n3rd_curr_cd3]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_amt3} != '' )" ).append("\n"); 
		query.append("           , N3RD_AMT3 = @[n3rd_amt3]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_xch_rt3} != '' )" ).append("\n"); 
		query.append("           , N3RD_XCH_RT3 = @[n3rd_xch_rt3]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_locl_amt3} != '' )" ).append("\n"); 
		query.append("           , N3RD_LOCL_AMT3 = @[n3rd_locl_amt3]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_curr_cd4} != '' )" ).append("\n"); 
		query.append("           , N3RD_CURR_CD4 = @[n3rd_curr_cd4]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_amt4} != '' )" ).append("\n"); 
		query.append("           , N3RD_AMT4 = @[n3rd_amt4]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_xch_rt4} != '' )" ).append("\n"); 
		query.append("           , N3RD_XCH_RT4 = @[n3rd_xch_rt4]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${n3rd_locl_amt4} != '' )" ).append("\n"); 
		query.append("           , N3RD_LOCL_AMT4 = @[n3rd_locl_amt4]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${eqv_locl_amt2} != '' )" ).append("\n"); 
		query.append("           , EQV_LOCL_AMT2 = @[eqv_locl_amt2]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if ( ${apro_flg} != '' )" ).append("\n"); 
		query.append("           , APRO_FLG = @[apro_flg]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if( ${upd_usr_id} != '' )" ).append("\n"); 
		query.append("           , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("    WHERE  1=1" ).append("\n"); 
		query.append("    AND    ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("    AND    BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    AND    CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("    AND    INV_NO = @[inv_no]" ).append("\n"); 

	}
}