/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOModifyContractCarriageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.03.15 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOModifyContractCarriageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContractCarriage 수정
	  * </pre>
	  */
	public ClaimMainDBDAOModifyContractCarriageUSQL(){
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
		params.put("n1st_pre_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_pre_ts_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_pre_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_pst_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOModifyContractCarriageUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CGO_CLM_CTRT SET" ).append("\n"); 
		query.append("	TRNK_REF_VVD_NO			= @[trnk_ref_vvd_no]" ).append("\n"); 
		query.append(",	SHPR_NM					= @[shpr_nm]" ).append("\n"); 
		query.append(",	CNEE_NM					= @[cnee_nm]" ).append("\n"); 
		query.append(",	NTFY_NM					= @[ntfy_nm]" ).append("\n"); 
		query.append(",	CRR_TERM_CD				= @[crr_term_cd]" ).append("\n"); 
		query.append(",	CLM_OFRT_AMT			= @[clm_ofrt_amt]" ).append("\n"); 
		query.append(",	CLM_OFRT_TERM_CD		= @[clm_ofrt_term_cd]" ).append("\n"); 
		query.append(",	CLM_OFRT_FLG			= @[clm_ofrt_flg]" ).append("\n"); 
		query.append(",	POR_CD					= @[por_cd]" ).append("\n"); 
		query.append(",	RCT_DT					= @[rct_dt]" ).append("\n"); 
		query.append(",	POL_CD					= @[pol_cd]" ).append("\n"); 
		query.append(",	LODG_DT					= @[lodg_dt]" ).append("\n"); 
		query.append(",	POD_CD					= @[pod_cd]" ).append("\n"); 
		query.append(",	DCHG_DT					= @[dchg_dt]" ).append("\n"); 
		query.append(",	DEL_CD					= @[del_cd]" ).append("\n"); 
		query.append(",	DE_DT					= @[de_dt]" ).append("\n"); 
		query.append(",	N1ST_PRE_REF_VVD_NO		= @[n1st_pre_ref_vvd_no]" ).append("\n"); 
		query.append(",	N2ND_PRE_REF_VVD_NO		= @[n2nd_pre_ref_vvd_no]" ).append("\n"); 
		query.append(",	N3RD_PRE_REF_VVD_NO		= @[n3rd_pre_ref_vvd_no]" ).append("\n"); 
		query.append(",	N1ST_PRE_TS_LOC_CD		= @[n1st_pre_ts_loc_cd]" ).append("\n"); 
		query.append(",	N1ST_PRE_TS_DT			= @[n1st_pre_ts_dt]" ).append("\n"); 
		query.append(",	N2ND_PRE_TS_LOC_CD		= @[n2nd_pre_ts_loc_cd]" ).append("\n"); 
		query.append(",	N2ND_PRE_TS_DT			= @[n2nd_pre_ts_dt]" ).append("\n"); 
		query.append(",	N3RD_PRE_TS_LOC_CD		= @[n3rd_pre_ts_loc_cd]" ).append("\n"); 
		query.append(",	N3RD_PRE_TS_DT			= @[n3rd_pre_ts_dt]" ).append("\n"); 
		query.append(",	N1ST_PST_REF_VVD_NO		= @[n1st_pst_ref_vvd_no]" ).append("\n"); 
		query.append(",	N2ND_PST_REF_VVD_NO		= @[n2nd_pst_ref_vvd_no]" ).append("\n"); 
		query.append(",	N3RD_PST_REF_VVD_NO		= @[n3rd_pst_ref_vvd_no]" ).append("\n"); 
		query.append(",	N1ST_PST_TS_LOC_CD		= @[n1st_pst_ts_loc_cd]" ).append("\n"); 
		query.append(",	N1ST_PST_TS_DT			= @[n1st_pst_ts_dt]" ).append("\n"); 
		query.append(",	N2ND_PST_TS_LOC_CD		= @[n2nd_pst_ts_loc_cd]" ).append("\n"); 
		query.append(",	N2ND_PST_TS_DT			= @[n2nd_pst_ts_dt]" ).append("\n"); 
		query.append(",	N3RD_PST_TS_LOC_CD		= @[n3rd_pst_ts_loc_cd]" ).append("\n"); 
		query.append(",	N3RD_PST_TS_DT			= @[n3rd_pst_ts_dt]" ).append("\n"); 
		query.append(",	SLAN_CD					= @[slan_cd]" ).append("\n"); 
		query.append(",	UPD_USR_ID				= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT					= CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE CGO_CLM_NO  = @[cgo_clm_no]" ).append("\n"); 

	}
}