/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManualRegisterDBDAOCreateTPBCandidateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOCreateTPBCandidateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTPBCandidate
	  * </pre>
	  */
	public ManualRegisterDBDAOCreateTPBCandidateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_mnl_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_src_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_finc_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cost_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_src_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOCreateTPBCandidateCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_OTS_DTL (" ).append("\n"); 
		query.append("OTS_DTL_SEQ" ).append("\n"); 
		query.append(", N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(", IF_RHQ_CD" ).append("\n"); 
		query.append(", IF_OFC_CD" ).append("\n"); 
		query.append(", N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append(", N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append(", N3PTY_SRC_NO" ).append("\n"); 
		query.append(", SO_NO" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", IF_CURR_CD" ).append("\n"); 
		query.append(", FILE_NO" ).append("\n"); 
		query.append(", IF_AMT" ).append("\n"); 
		query.append(", IF_RMK" ).append("\n"); 
		query.append(", EQ_KND_CD" ).append("\n"); 
		query.append(", EQ_NO" ).append("\n"); 
		query.append(", EQ_TPSZ_CD" ).append("\n"); 
		query.append(", VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(", VNDR_CNT_CD" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", N3PTY_OFC_CD" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", IF_USR_ID" ).append("\n"); 
		query.append(", IF_DT" ).append("\n"); 
		query.append(", N3PTY_IF_TP_CD" ).append("\n"); 
		query.append(", N3PTY_DELT_TP_CD" ).append("\n"); 
		query.append(", ESTM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", ACCT_CD" ).append("\n"); 
		query.append(", LGS_COST_CD" ).append("\n"); 
		query.append("--, SRC_VNDR_CNT_CD" ).append("\n"); 
		query.append(", SRC_VNDR_SEQ" ).append("\n"); 
		query.append(", MNL_INP_TP_CD" ).append("\n"); 
		query.append(", VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(", FINC_DIR_CD" ).append("\n"); 
		query.append(", COST_EXPT_FLG" ).append("\n"); 
		query.append(", TML_INV_TP_CD" ).append("\n"); 
		query.append(", OFC_CD" ).append("\n"); 
		query.append(", N3PTY_CFM_CD" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("  @[ots_dtl_seq]" ).append("\n"); 
		query.append(", @[s_n3pty_bil_tp_cd]" ).append("\n"); 
		query.append(", TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(@[s_if_ofc_cd]))" ).append("\n"); 
		query.append(", @[s_if_ofc_cd]" ).append("\n"); 
		query.append(", @[s_n3pty_src_sub_sys_cd]" ).append("\n"); 
		query.append(", @[s_n3pty_expn_tp_cd]" ).append("\n"); 
		query.append(", @[s_n3pty_src_no]" ).append("\n"); 
		query.append(", @[s_so_no]" ).append("\n"); 
		query.append(", @[s_bkg_no]" ).append("\n"); 
		query.append(", @[s_bl_no]" ).append("\n"); 
		query.append(", @[s_vsl_cd]" ).append("\n"); 
		query.append(", @[s_skd_voy_no]" ).append("\n"); 
		query.append(", @[s_skd_dir_cd]" ).append("\n"); 
		query.append(", DECODE(@[s_curr_cd],'Local',(SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = TPB_GET_N3PTY_OFC_CD_FNC(@[s_if_ofc_cd])),@[s_curr_cd])" ).append("\n"); 
		query.append(", @[s_file_no]" ).append("\n"); 
		query.append(", @[if_amt]" ).append("\n"); 
		query.append(", @[s_if_rmk]" ).append("\n"); 
		query.append(", @[eq_knd_cd]" ).append("\n"); 
		query.append(", @[eq_no]" ).append("\n"); 
		query.append(", @[eq_tpsz_cd]" ).append("\n"); 
		query.append(", @[s_vndr_cust_div_cd]" ).append("\n"); 
		query.append(", @[s_vndr_cnt_cd]" ).append("\n"); 
		query.append(", @[s_vndr_seq]" ).append("\n"); 
		query.append(", @[s_cust_cnt_cd]" ).append("\n"); 
		query.append(", @[s_cust_seq]" ).append("\n"); 
		query.append(", @[s_n3pty_ofc_cd]" ).append("\n"); 
		query.append(", @[s_yd_cd]" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", 'M'" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", @[s_svr_id]" ).append("\n"); 
		query.append(", @[s_acct_cd]" ).append("\n"); 
		query.append(", @[s_lgs_cost_cd]" ).append("\n"); 
		query.append("--, [s_src_vndr_cnt_cd]" ).append("\n"); 
		query.append(", @[s_src_vndr_seq]" ).append("\n"); 
		query.append(", @[s_mnl_inp_tp_cd]" ).append("\n"); 
		query.append(", @[s_vndr_lgl_eng_nm]" ).append("\n"); 
		query.append(", @[s_cust_lgl_eng_nm]" ).append("\n"); 
		query.append(", @[s_bkg_finc_dir_cd]" ).append("\n"); 
		query.append(", @[s_cost_expt_flg]" ).append("\n"); 
		query.append(", @[s_tml_inv_tp_cd]" ).append("\n"); 
		query.append(", TPB_GET_N3PTY_OFC_CD_FNC(@[s_if_ofc_cd])" ).append("\n"); 
		query.append(", 'I'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}