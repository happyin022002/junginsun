/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselStatusDBDAOCustomVesselStatusVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.16 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselStatusDBDAOCustomVesselStatusVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Status Entry를 생성한다
	  * </pre>
	  */
	public VesselStatusDBDAOCustomVesselStatusVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_oshp_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_vsl_clss_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_oshp_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_dmg_hl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_cgo_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_vsl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_cvrg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rgst_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_crw_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_vsl_oshp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_plcy_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_otr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bld_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_rgst_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration").append("\n"); 
		query.append("FileName : VesselStatusDBDAOCustomVesselStatusVOCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_INSUR_CTRT_DTL (" ).append("\n"); 
		query.append("	INSUR_TP_CD" ).append("\n"); 
		query.append(",	INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	INSUR_EFF_DT" ).append("\n"); 
		query.append(",	INSUR_EXP_DT" ).append("\n"); 
		query.append(",	INSUR_VSL_TP_CD" ).append("\n"); 
		query.append(",	VSL_BLD_YR" ).append("\n"); 
		query.append(",	VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",	INSUR_VSL_CLSS_NM" ).append("\n"); 
		query.append(",	GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	DWT_WGT" ).append("\n"); 
		query.append(",	INSUR_VSL_OSHP_CD" ).append("\n"); 
		query.append(",	VSL_OSHP_EFF_DT" ).append("\n"); 
		query.append(",	VSL_OSHP_EXP_DT" ).append("\n"); 
		query.append(",	INSUR_CVRG_CD" ).append("\n"); 
		query.append(",	DDCT_CGO_AMT" ).append("\n"); 
		query.append(",	DDCT_CRW_AMT" ).append("\n"); 
		query.append(",	DDCT_DMG_HL_AMT" ).append("\n"); 
		query.append(",	DDCT_OTR_AMT" ).append("\n"); 
		query.append(",	INSUR_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[insur_tp_cd]" ).append("\n"); 
		query.append(",	@[insur_plcy_yr]" ).append("\n"); 
		query.append(",	@[insur_clm_pty_no]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[insur_eff_dt]" ).append("\n"); 
		query.append(",	@[insur_exp_dt]" ).append("\n"); 
		query.append(",	@[insur_vsl_tp_cd]" ).append("\n"); 
		query.append(",	@[vsl_bld_yr]" ).append("\n"); 
		query.append(",	@[vsl_rgst_cnt_cd]" ).append("\n"); 
		query.append(",	@[insur_vsl_clss_nm]" ).append("\n"); 
		query.append(",	@[grs_rgst_tong_wgt]" ).append("\n"); 
		query.append(",	@[dwt_wgt]" ).append("\n"); 
		query.append(",	@[insur_vsl_oshp_cd]" ).append("\n"); 
		query.append(",	@[vsl_oshp_eff_dt]" ).append("\n"); 
		query.append(",	@[vsl_oshp_exp_dt]" ).append("\n"); 
		query.append(",	@[insur_cvrg_cd]" ).append("\n"); 
		query.append(",	@[ddct_cgo_amt]" ).append("\n"); 
		query.append(",	@[ddct_crw_amt]" ).append("\n"); 
		query.append(",	@[ddct_dmg_hl_amt]" ).append("\n"); 
		query.append(",	@[ddct_otr_amt]" ).append("\n"); 
		query.append(",	@[insur_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}