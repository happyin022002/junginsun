/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOaddTempEstimateDTLDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.02.04 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOaddTempEstimateDTLDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTempEstimateDTLData
	  * </pre>
	  */
	public InterfaceMgtDBDAOaddTempEstimateDTLDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vol_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_vrfy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_sz_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_mtrl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_lr_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_lbr_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_mtrl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lbr_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_cd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_agmt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_lbr_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_opt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_lst_ver_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_cd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_lbr_bzc_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_lbr_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lbr_mtrl_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_len_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_rpr_cd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_wdt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_wrk_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_dmg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_lbr_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_dmg_cd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtrl_reco_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_rpr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_lbr_bzc_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_lbr_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_lbr_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtrl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOaddTempEstimateDTLDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_RPR_RQST_TMP_DTL(" ).append("\n"); 
		query.append("RQST_EQ_NO" ).append("\n"); 
		query.append(",RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append(",RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append(",RPR_RQST_TMP_DTL_SEQ" ).append("\n"); 
		query.append(",RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append(",COST_CD" ).append("\n"); 
		query.append(",EQ_LOC_CD" ).append("\n"); 
		query.append(",EQ_LOC_CD_CHK_FLG" ).append("\n"); 
		query.append(",EQ_CMPO_CD" ).append("\n"); 
		query.append(",EQ_CMPO_CD_CHK_FLG" ).append("\n"); 
		query.append(",EQ_DMG_CD" ).append("\n"); 
		query.append(",EQ_DMG_CD_CHK_FLG" ).append("\n"); 
		query.append(",EQ_RPR_CD" ).append("\n"); 
		query.append(",EQ_RPR_CD_CHK_FLG" ).append("\n"); 
		query.append(",TRF_DIV_CD" ).append("\n"); 
		query.append(",TRF_OPT_CD" ).append("\n"); 
		query.append(",VOL_TP_CD" ).append("\n"); 
		query.append(",RPR_QTY" ).append("\n"); 
		query.append(",RPR_SZ_NO" ).append("\n"); 
		query.append(",RPR_LEN_NO" ).append("\n"); 
		query.append(",RPR_WDT_NO" ).append("\n"); 
		query.append(",RPR_LBR_HRS" ).append("\n"); 
		query.append(",RPR_LBR_RT" ).append("\n"); 
		query.append(",RPR_LBR_BZC_HRS" ).append("\n"); 
		query.append(",RPR_LBR_BZC_RT" ).append("\n"); 
		query.append(",MNR_LBR_BZC_AMT" ).append("\n"); 
		query.append(",LBR_MTRL_BZC_AMT" ).append("\n"); 
		query.append(",LBR_COST_AMT" ).append("\n"); 
		query.append(",MTRL_COST_AMT" ).append("\n"); 
		query.append(",XCH_MTRL_COST_AMT" ).append("\n"); 
		query.append(",MTRL_RECO_AMT" ).append("\n"); 
		query.append(",MNR_LR_ACCT_FLG" ).append("\n"); 
		query.append(",N3PTY_FLG" ).append("\n"); 
		query.append(",N3PTY_BIL_LBR_HRS" ).append("\n"); 
		query.append(",N3PTY_BIL_LBR_RT" ).append("\n"); 
		query.append(",N3PTY_BIL_LBR_COST_AMT" ).append("\n"); 
		query.append(",N3PTY_BIL_MTRL_COST_AMT" ).append("\n"); 
		query.append(",MNR_AGMT_AMT" ).append("\n"); 
		query.append(",MNR_WRK_AMT" ).append("\n"); 
		query.append(",N3PTY_BIL_AMT" ).append("\n"); 
		query.append(",RPR_DTL_RMK" ).append("\n"); 
		query.append(",MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[rqst_eq_no]" ).append("\n"); 
		query.append(",@[rpr_rqst_tmp_seq]" ).append("\n"); 
		query.append(",@[rpr_rqst_tmp_ver_no]" ).append("\n"); 
		query.append(",@[rpr_rqst_tmp_dtl_seq]" ).append("\n"); 
		query.append(",@[rpr_rqst_lst_ver_flg]" ).append("\n"); 
		query.append(",@[cost_cd]" ).append("\n"); 
		query.append(",@[eq_loc_cd]" ).append("\n"); 
		query.append(",@[eq_loc_cd_chk_flg]" ).append("\n"); 
		query.append(",@[eq_cmpo_cd]" ).append("\n"); 
		query.append(",@[eq_cmpo_cd_chk_flg]" ).append("\n"); 
		query.append(",@[eq_dmg_cd]" ).append("\n"); 
		query.append(",@[eq_dmg_cd_chk_flg]" ).append("\n"); 
		query.append(",@[eq_rpr_cd]" ).append("\n"); 
		query.append(",@[eq_rpr_cd_chk_flg]" ).append("\n"); 
		query.append(",@[trf_div_cd]" ).append("\n"); 
		query.append(",@[trf_opt_cd]" ).append("\n"); 
		query.append(",@[vol_tp_cd]" ).append("\n"); 
		query.append(",@[rpr_qty]" ).append("\n"); 
		query.append(",@[rpr_sz_no]" ).append("\n"); 
		query.append(",@[rpr_len_no]" ).append("\n"); 
		query.append(",@[rpr_wdt_no]" ).append("\n"); 
		query.append(",@[rpr_lbr_hrs]" ).append("\n"); 
		query.append(",@[rpr_lbr_rt]" ).append("\n"); 
		query.append(",@[rpr_lbr_bzc_hrs]" ).append("\n"); 
		query.append(",@[rpr_lbr_bzc_rt]" ).append("\n"); 
		query.append(",@[mnr_lbr_bzc_amt]" ).append("\n"); 
		query.append(",@[lbr_mtrl_bzc_amt]" ).append("\n"); 
		query.append(",@[lbr_cost_amt]" ).append("\n"); 
		query.append(",@[mtrl_cost_amt]" ).append("\n"); 
		query.append(",@[xch_mtrl_cost_amt]" ).append("\n"); 
		query.append(",@[mtrl_reco_amt]" ).append("\n"); 
		query.append(",@[mnr_lr_acct_flg]" ).append("\n"); 
		query.append(",@[n3pty_flg]" ).append("\n"); 
		query.append(",@[n3pty_bil_lbr_hrs]" ).append("\n"); 
		query.append(",@[n3pty_bil_lbr_rt]" ).append("\n"); 
		query.append(",@[n3pty_bil_lbr_cost_amt]" ).append("\n"); 
		query.append(",@[n3pty_bil_mtrl_cost_amt]" ).append("\n"); 
		query.append(",@[mnr_agmt_amt]" ).append("\n"); 
		query.append(",@[mnr_wrk_amt]" ).append("\n"); 
		query.append(",@[n3pty_bil_amt]" ).append("\n"); 
		query.append(",@[rpr_dtl_rmk]" ).append("\n"); 
		query.append(",@[mnr_vrfy_tp_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}