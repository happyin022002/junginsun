/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselStatusDBDAOSearchVesselStatusListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.16 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselStatusDBDAOSearchVesselStatusListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Status Entry를 조회한다
	  * </pre>
	  */
	public VesselStatusDBDAOSearchVesselStatusListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("insur_vsl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("insur_cvrg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.integration").append("\n"); 
		query.append("FileName : VesselStatusDBDAOSearchVesselStatusListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.VSL_CD" ).append("\n"); 
		query.append(",   B.VSL_ENG_NM" ).append("\n"); 
		query.append(",	A.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",   (SELECT CLM_PTY_ABBR_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.INSUR_CLM_PTY_NO) INSUR_CLM_PTY_NM" ).append("\n"); 
		query.append(",	A.INSUR_EFF_DT" ).append("\n"); 
		query.append(",	A.INSUR_EXP_DT" ).append("\n"); 
		query.append(",	A.INSUR_VSL_TP_CD" ).append("\n"); 
		query.append(",	A.VSL_BLD_YR" ).append("\n"); 
		query.append(",	A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",   (SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = A.VSL_RGST_CNT_CD) CNT_NM" ).append("\n"); 
		query.append(",	A.INSUR_VSL_CLSS_NM" ).append("\n"); 
		query.append(",	A.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	A.DWT_WGT" ).append("\n"); 
		query.append(",	A.INSUR_VSL_OSHP_CD" ).append("\n"); 
		query.append(",	A.VSL_OSHP_EFF_DT" ).append("\n"); 
		query.append(",	A.VSL_OSHP_EXP_DT" ).append("\n"); 
		query.append(",	A.INSUR_CVRG_CD" ).append("\n"); 
		query.append(",	A.INSUR_TP_CD" ).append("\n"); 
		query.append(",	A.INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	A.DDCT_CGO_AMT" ).append("\n"); 
		query.append(",	A.DDCT_CRW_AMT" ).append("\n"); 
		query.append(",	A.DDCT_DMG_HL_AMT" ).append("\n"); 
		query.append(",	A.DDCT_OTR_AMT" ).append("\n"); 
		query.append(",	A.INSUR_RMK" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR B, CNI_INSUR_CTRT_DTL A" ).append("\n"); 
		query.append("WHERE B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("#if (${insur_tp_cd} != '')  " ).append("\n"); 
		query.append("AND A.INSUR_TP_CD LIKE @[insur_tp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')  " ).append("\n"); 
		query.append("AND A.VSL_CD LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '')  " ).append("\n"); 
		query.append("AND B.VSL_ENG_NM LIKE @[vsl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${insur_clm_pty_no} != '')  " ).append("\n"); 
		query.append("AND A.INSUR_CLM_PTY_NO LIKE @[insur_clm_pty_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${insur_cvrg_cd} != '')  " ).append("\n"); 
		query.append("AND A.INSUR_CVRG_CD LIKE @[insur_cvrg_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${insur_vsl_tp_cd} != '')  " ).append("\n"); 
		query.append("AND A.INSUR_VSL_TP_CD LIKE @[insur_vsl_tp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${insur_vsl_oshp_cd} != '')  " ).append("\n"); 
		query.append("AND A.INSUR_VSL_OSHP_CD LIKE @[insur_vsl_oshp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${insur_period} == 'INS_IN')  " ).append("\n"); 
		query.append("AND	A.INSUR_EFF_DT BETWEEN REPLACE(@[insur_eff_dt],'-','') AND REPLACE(@[insur_exp_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${insur_period} == 'INSOUT')  " ).append("\n"); 
		query.append("AND	A.INSUR_EXP_DT BETWEEN REPLACE(@[insur_eff_dt],'-','') AND REPLACE(@[insur_exp_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${insur_period} == 'TOOIN')  " ).append("\n"); 
		query.append("AND	A.VSL_OSHP_EFF_DT BETWEEN REPLACE(@[insur_eff_dt],'-','') AND REPLACE(@[insur_exp_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${insur_period} == 'TOOOUT')  " ).append("\n"); 
		query.append("AND	A.VSL_OSHP_EXP_DT BETWEEN REPLACE(@[insur_eff_dt],'-','') AND REPLACE(@[insur_exp_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}