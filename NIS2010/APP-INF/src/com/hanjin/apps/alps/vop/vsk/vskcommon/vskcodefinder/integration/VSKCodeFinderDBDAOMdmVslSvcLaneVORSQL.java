/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : VSKCodeFinderDBDAOMdmVslSvcLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.13 
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

public class VSKCodeFinderDBDAOMdmVslSvcLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_VSL_SVC_LANE 테이블을 조회한다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOMdmVslSvcLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOMdmVslSvcLaneVORSQL").append("\n"); 
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
		query.append("--MDM lane delete flag 조건 삭제하여 삭제된 lane의 SKD 도 조회 가능하도록 수정 2018.03.13" ).append("\n"); 
		query.append("--AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

	}
}