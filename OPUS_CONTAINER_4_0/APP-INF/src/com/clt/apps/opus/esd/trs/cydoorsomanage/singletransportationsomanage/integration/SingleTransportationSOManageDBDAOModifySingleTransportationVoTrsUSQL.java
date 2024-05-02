/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOModifySingleTransportationVoTrsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOModifySingleTransportationVoTrsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O Correction
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOModifySingleTransportationVoTrsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_pln_dt_hms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_stop_de_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt_hms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_free_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmb_so_rlt_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_srt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt_hms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sub_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_de_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOModifySingleTransportationVoTrsUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SET " ).append("\n"); 
		query.append("       EQ_NO = @[eq_no], " ).append("\n"); 
		query.append("       TRSP_COST_DTL_MOD_CD = @[trsp_cost_dtl_mod_cd], " ).append("\n"); 
		query.append("       TRSP_CRR_MOD_CD = @[trsp_crr_mod_cd], " ).append("\n"); 
		query.append("       COST_ACT_GRP_CD = @[cost_act_grp_cd], " ).append("\n"); 
		query.append("       TRSP_SO_STS_CD = 'R', " ).append("\n"); 
		query.append("       FM_NOD_CD = @[fm_nod_cd]||@[fm_nod_yard], " ).append("\n"); 
		query.append("       TO_NOD_CD = @[to_nod_cd]||@[to_nod_yard], " ).append("\n"); 
		query.append("       VIA_NOD_CD = @[via_nod_cd]||@[via_nod_yard], " ).append("\n"); 
		query.append("       DOR_NOD_CD = @[dor_nod_cd]||@[dor_nod_yard], " ).append("\n"); 
		query.append("       ACT_CUST_CNT_CD = @[act_cust_cnt_cd], " ).append("\n"); 
		query.append("       ACT_CUST_SEQ = @[act_cust_seq], " ).append("\n"); 
		query.append("       DOR_DE_ADDR = @[dor_de_addr], " ).append("\n"); 
		query.append("       MLT_STOP_DE_FLG = @[mlt_stop_de_flg], " ).append("\n"); 
		query.append("       N1ST_NOD_PLN_DT = TO_DATE(@[n1st_nod_pln_dt] || NVL2(@[n1st_nod_pln_dt], @[n1st_nod_pln_dt_hms], ''), 'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("       LST_NOD_PLN_DT = TO_DATE(@[lst_nod_pln_dt]   || NVL2(@[lst_nod_pln_dt],  @[lst_nod_pln_dt_hms], '') , 'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("       DOR_NOD_PLN_DT = TO_DATE(@[dor_nod_pln_dt]   || NVL2(@[dor_nod_pln_dt],  @[dor_nod_pln_dt_hms], ''), 'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("       DOR_SVC_TP_CD = @[dor_svc_tp_cd], " ).append("\n"); 
		query.append("       INTER_RMK = @[inter_rmk], " ).append("\n"); 
		query.append("       SPCL_INSTR_RMK = @[spcl_instr_rmk], " ).append("\n"); 
		query.append("       TRSP_SO_TP_CD = DECODE(@[cgo_tp_cd], 'F', 'Y', 'M')," ).append("\n"); 
		query.append("       TRSP_SO_CMB_TP_CD = @[trsp_so_cmb_tp_cd]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${cbstatus} == 'CF' || ${cbstatus} == 'CS')" ).append("\n"); 
		query.append("           TRSP_SO_CMB_SEQ = @[trsp_so_cmb_seq], " ).append("\n"); 
		query.append("           TRSP_SO_CMB_SRT_NO = @[trsp_so_cmb_srt_no], " ).append("\n"); 
		query.append("           CMB_SO_RLT_STS_FLG = @[cmb_so_rlt_sts_flg], " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CNTR_PKUP_NO = @[cntr_pkup_no], " ).append("\n"); 
		query.append("       AVAL_DT = TO_DATE( @[aval_dt] , 'YYYYMMDD HH24:MI:SS'), " ).append("\n"); 
		query.append("       LST_FREE_DT = TO_DATE( @[lst_free_dt] , 'YYYYMMDD HH24:MI:SS'), " ).append("\n"); 
		query.append("       LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD), " ).append("\n"); 
		query.append("       UPD_DT = SYSDATE," ).append("\n"); 
		query.append("       UPD_USR_ID = @[form_cre_usr_id], " ).append("\n"); 
		query.append("       SUB_EQ_TPSZ_CD = @[sub_eq_tpsz_cd], " ).append("\n"); 
		query.append("       EQ_TPSZ_CD = @[eq_tpsz_cd], " ).append("\n"); 
		query.append("       CNTR_SUB_FLG = @[cntr_sub_flg], " ).append("\n"); 
		query.append("       FCTRY_NM = @[fctry_nm], " ).append("\n"); 
		query.append("       CNTC_PSON_NM = @[cntc_pson_nm], " ).append("\n"); 
		query.append("       CNTC_PSON_PHN_NO = @[cntc_pson_phn_no], " ).append("\n"); 
		query.append("       CNTC_PSON_FAX_NO = @[cntc_pson_fax_no], " ).append("\n"); 
		query.append("       DOR_PST_CD = @[dor_pst_cd]," ).append("\n"); 
		query.append("	   EQ_ATCH_DT = NVL(EQ_ATCH_DT, NVL2(@[eq_no], SYSDATE, NULL)) " ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] " ).append("\n"); 
		query.append("  AND  TRSP_SO_SEQ = @[trsp_so_seq] " ).append("\n"); 
		query.append("  AND  NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}