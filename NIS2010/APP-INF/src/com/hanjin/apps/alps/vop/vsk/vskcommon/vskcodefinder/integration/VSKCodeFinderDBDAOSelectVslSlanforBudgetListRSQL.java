/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSelectVslSlanforBudgetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSelectVslSlanforBudgetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Budget에 사용된 Vessel Service Lane Code 목록조회
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSelectVslSlanforBudgetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSelectVslSlanforBudgetListRSQL").append("\n"); 
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
		query.append("#if (${chk_use} == 'Y')  -- :: Searching Budget Vessel Service Lance :: --" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT    DISTINCT" ).append("\n"); 
		query.append("          X.PF_SKD_TP_CD		AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("       ,  Y.VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,  Y.VSL_SLAN_NM" ).append("\n"); 
		query.append("       ,  Y.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("       ,  Y.VSL_TP_CD" ).append("\n"); 
		query.append("       ,  Y.ST_EFF_DT" ).append("\n"); 
		query.append("       ,  Y.END_EFF_DT" ).append("\n"); 
		query.append("       ,  Y.VSL_SLAN_SKD_TP_CD" ).append("\n"); 
		query.append("       ,  Y.OFC_CD" ).append("\n"); 
		query.append("       ,  Y.CO_CD" ).append("\n"); 
		query.append("       ,  Y.FDR_DIV_CD" ).append("\n"); 
		query.append("       ,  Y.CRE_USR_ID" ).append("\n"); 
		query.append("       ,  Y.CRE_DT" ).append("\n"); 
		query.append("       ,  Y.UPD_USR_ID" ).append("\n"); 
		query.append("       ,  Y.UPD_DT" ).append("\n"); 
		query.append("       ,  Y.DELT_FLG" ).append("\n"); 
		query.append("       ,  Y.EAI_EVNT_DT" ).append("\n"); 
		query.append("       ,  Y.CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("       ,  Y.VSKD_FLET_GRP_CD" ).append("\n"); 
		query.append("       ,  Y.SPCL_CGO_RQST_TGT_LANE_FLG" ).append("\n"); 
		query.append("       ,  Y.TML_PROD_RPT_FLG" ).append("\n"); 
		query.append("       ,  Y.PNDLM_FLG" ).append("\n"); 
		query.append("FROM      VSK_BUD_VSL_SKD  	X" ).append("\n"); 
		query.append("      ,   MDM_VSL_SVC_LANE 	Y" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       X.VSL_SLAN_CD    	= Y.VSL_SLAN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_dt} != '')" ).append("\n"); 
		query.append("AND       X.N1ST_PORT_BRTH_DT >= TO_DATE(@[fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${to_dt} != '')" ).append("\n"); 
		query.append("AND       X.N1ST_PORT_BRTH_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND 	  Y.VSL_SLAN_CD LIKE UPPER(@[vsl_slan_cd]) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(Y.VSL_SLAN_NM) LIKE '%' || UPPER(@[vsl_slan_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == 'TRUNK')" ).append("\n"); 
		query.append("AND 	  Y.VSL_SVC_TP_CD != 'O'" ).append("\n"); 
		query.append("#elseif (${vsl_svc_tp_cd} != '')" ).append("\n"); 
		query.append("AND 	  Y.VSL_SVC_TP_CD = DECODE(@[vsl_svc_tp_cd], 'A', Y.VSL_SVC_TP_CD, @[vsl_svc_tp_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fdr_div_cd} != '') " ).append("\n"); 
		query.append("AND 	  Y.FDR_DIV_CD = DECODE(@[fdr_div_cd], 'A', Y.FDR_DIV_CD, @[fdr_div_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND 	  Y.VSL_TP_CD 		= 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("AND 	  Y.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("ORDER BY  Y.VSL_SLAN_CD		ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else     -- :: Searching NORAML Vessel Service Lance :: --" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	VSL_SLAN_CD," ).append("\n"); 
		query.append("	VSL_SLAN_NM," ).append("\n"); 
		query.append("	VSL_SVC_TP_CD," ).append("\n"); 
		query.append("	VSL_TP_CD," ).append("\n"); 
		query.append("	ST_EFF_DT," ).append("\n"); 
		query.append("	END_EFF_DT," ).append("\n"); 
		query.append("	VSL_SLAN_SKD_TP_CD," ).append("\n"); 
		query.append("	OFC_CD," ).append("\n"); 
		query.append("	CO_CD," ).append("\n"); 
		query.append("	FDR_DIV_CD," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	DELT_FLG," ).append("\n"); 
		query.append("	EAI_EVNT_DT," ).append("\n"); 
		query.append("	CNL_AGN_VNDR_SEQ," ).append("\n"); 
		query.append("	VSKD_FLET_GRP_CD," ).append("\n"); 
		query.append("	SPCL_CGO_RQST_TGT_LANE_FLG," ).append("\n"); 
		query.append("	TML_PROD_RPT_FLG," ).append("\n"); 
		query.append("	PNDLM_FLG" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND VSL_SLAN_CD LIKE UPPER(@[vsl_slan_cd]) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(VSL_SLAN_NM) LIKE '%' || UPPER(@[vsl_slan_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == 'TRUNK')" ).append("\n"); 
		query.append("AND VSL_SVC_TP_CD != 'O'" ).append("\n"); 
		query.append("#elseif (${vsl_svc_tp_cd} != '')" ).append("\n"); 
		query.append("AND VSL_SVC_TP_CD = DECODE(@[vsl_svc_tp_cd], 'A', VSL_SVC_TP_CD, @[vsl_svc_tp_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fdr_div_cd} != '') " ).append("\n"); 
		query.append("AND FDR_DIV_CD = DECODE(@[fdr_div_cd], 'A', FDR_DIV_CD, @[fdr_div_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD	ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}