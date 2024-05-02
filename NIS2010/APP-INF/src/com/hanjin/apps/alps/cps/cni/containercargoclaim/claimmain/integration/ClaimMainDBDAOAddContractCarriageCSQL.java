/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOAddContractCarriageCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.03.19 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOAddContractCarriageCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contract Of Carriage 입력
	  * </pre>
	  */
	public ClaimMainDBDAOAddContractCarriageCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pst_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pre_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pre_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pre_ts_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pre_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pst_ts_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pst_ts_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntfy_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_pre_ts_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_ofrt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pre_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pst_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pst_ts_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_qlty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pre_ts_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pst_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_ofrt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pre_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pst_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pst_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pst_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_ofrt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pre_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOAddContractCarriageCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM_CTRT(" ).append("\n"); 
		query.append("   CGO_CLM_NO" ).append("\n"); 
		query.append(",  TRNK_REF_VVD_NO" ).append("\n"); 
		query.append(",  CLM_CGO_TP_CD" ).append("\n"); 
		query.append(",  SHPR_NM" ).append("\n"); 
		query.append(",  CNEE_NM" ).append("\n"); 
		query.append(",  NTFY_NM" ).append("\n"); 
		query.append(",  CGO_QLTY_DESC" ).append("\n"); 
		query.append(",  CRR_TERM_CD" ).append("\n"); 
		query.append(",  CLM_OFRT_AMT" ).append("\n"); 
		query.append(",  CLM_OFRT_TERM_CD" ).append("\n"); 
		query.append(",  CLM_OFRT_FLG" ).append("\n"); 
		query.append(",  POR_CD" ).append("\n"); 
		query.append(",  RCT_DT" ).append("\n"); 
		query.append(",  POL_CD" ).append("\n"); 
		query.append(",  LODG_DT" ).append("\n"); 
		query.append(",  POD_CD" ).append("\n"); 
		query.append(",  DCHG_DT" ).append("\n"); 
		query.append(",  DEL_CD" ).append("\n"); 
		query.append(",  DE_DT" ).append("\n"); 
		query.append(",  N1ST_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(",  N2ND_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(",  N3RD_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(",  N1ST_PRE_TS_LOC_CD" ).append("\n"); 
		query.append(",  N1ST_PRE_TS_DT" ).append("\n"); 
		query.append(",  N2ND_PRE_TS_LOC_CD" ).append("\n"); 
		query.append(",  N2ND_PRE_TS_DT" ).append("\n"); 
		query.append(",  N3RD_PRE_TS_LOC_CD" ).append("\n"); 
		query.append(",  N3RD_PRE_TS_DT" ).append("\n"); 
		query.append(",  N1ST_PST_REF_VVD_NO" ).append("\n"); 
		query.append(",  N2ND_PST_REF_VVD_NO" ).append("\n"); 
		query.append(",  N3RD_PST_REF_VVD_NO" ).append("\n"); 
		query.append(",  N1ST_PST_TS_LOC_CD" ).append("\n"); 
		query.append(",  N1ST_PST_TS_DT" ).append("\n"); 
		query.append(",  N2ND_PST_TS_LOC_CD" ).append("\n"); 
		query.append(",  N2ND_PST_TS_DT" ).append("\n"); 
		query.append(",  N3RD_PST_TS_LOC_CD" ).append("\n"); 
		query.append(",  N3RD_PST_TS_DT" ).append("\n"); 
		query.append(",  REP_CMDT_CD" ).append("\n"); 
		query.append(",  N3RD_REF_VVD_NO" ).append("\n"); 
		query.append(",  SLAN_CD" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append("  ) VALUES (" ).append("\n"); 
		query.append("   @[cgo_clm_no]" ).append("\n"); 
		query.append(" , @[trnk_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[clm_cgo_tp_cd]" ).append("\n"); 
		query.append(" , @[shpr_nm]" ).append("\n"); 
		query.append(" , @[cnee_nm]" ).append("\n"); 
		query.append(" , @[ntfy_nm]" ).append("\n"); 
		query.append(" , @[cgo_qlty_desc]" ).append("\n"); 
		query.append(" , @[crr_term_cd]" ).append("\n"); 
		query.append(" , @[clm_ofrt_amt]" ).append("\n"); 
		query.append(" , @[clm_ofrt_term_cd]" ).append("\n"); 
		query.append(" , @[clm_ofrt_flg]" ).append("\n"); 
		query.append(" , @[por_cd]" ).append("\n"); 
		query.append(" , @[rct_dt]" ).append("\n"); 
		query.append(" , @[pol_cd]" ).append("\n"); 
		query.append(" , @[lodg_dt]" ).append("\n"); 
		query.append(" , @[pod_cd]" ).append("\n"); 
		query.append(" , @[dchg_dt]" ).append("\n"); 
		query.append(" , @[del_cd]" ).append("\n"); 
		query.append(" , @[de_dt]" ).append("\n"); 
		query.append(" , @[n1st_pre_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[n2nd_pre_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[n3rd_pre_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[n1st_pre_ts_loc_cd]" ).append("\n"); 
		query.append(" , @[n1st_pre_ts_dt]" ).append("\n"); 
		query.append(" , @[n2nd_pre_ts_loc_cd]" ).append("\n"); 
		query.append(" , @[n2nd_pre_ts_dt]" ).append("\n"); 
		query.append(" , @[n3rd_pre_ts_loc_cd]" ).append("\n"); 
		query.append(" , @[n3rd_pre_ts_dt]" ).append("\n"); 
		query.append(" , @[n1st_pst_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[n2nd_pst_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[n3rd_pst_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[n1st_pst_ts_loc_cd]" ).append("\n"); 
		query.append(" , @[n1st_pst_ts_dt]" ).append("\n"); 
		query.append(" , @[n2nd_pst_ts_loc_cd]" ).append("\n"); 
		query.append(" , @[n2nd_pst_ts_dt]" ).append("\n"); 
		query.append(" , @[n3rd_pst_ts_loc_cd]" ).append("\n"); 
		query.append(" , @[n3rd_pst_ts_dt]" ).append("\n"); 
		query.append(" , @[rep_cmdt_cd]" ).append("\n"); 
		query.append(" , @[n3rd_ref_vvd_no]" ).append("\n"); 
		query.append(" , @[slan_cd]" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(" , @[upd_usr_id]" ).append("\n"); 
		query.append(" , CNI_GET_GMT_FNC(@[upd_usr_id]) )" ).append("\n"); 

	}
}