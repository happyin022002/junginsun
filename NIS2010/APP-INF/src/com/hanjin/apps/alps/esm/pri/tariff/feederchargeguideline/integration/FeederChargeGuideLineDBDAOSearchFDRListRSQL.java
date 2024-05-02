/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchFDRListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOSearchFDRListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FDRList 조회
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchFDRListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOSearchFDRListRSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("       ORG_DEST_TP_CD," ).append("\n"); 
		query.append("       FDR_TRF_NO," ).append("\n"); 
		query.append("       AMDT_SEQ," ).append("\n"); 
		query.append("       RT_SEQ," ).append("\n"); 
		query.append("       N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("       PNT_LOC_CD," ).append("\n"); 
		query.append("       BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("       RCV_DE_TERM_CD," ).append("\n"); 
		query.append("       GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       GLINE_45FT_FRT_RT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("       COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       COST_45FT_FRT_RT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("       LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       LOCL_CURR_COST_45FT_FRT_RT_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("       TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("       TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("       TRSP_45FT_COST_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("       TML_20FT_COST_AMT," ).append("\n"); 
		query.append("       TML_40FT_COST_AMT," ).append("\n"); 
		query.append("       TML_45FT_COST_AMT, -- 45' Cost 추가" ).append("\n"); 
		query.append("       GLINE_RF_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       GLINE_RF_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       COST_RF_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       COST_RF_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       LOCL_CURR_COST_RF_20FT_RT_AMT," ).append("\n"); 
		query.append("       LOCL_CURR_COST_RF_40FT_RT_AMT," ).append("\n"); 
		query.append("       TRSP_RF_20FT_COST_AMT," ).append("\n"); 
		query.append("       TRSP_RF_40FT_COST_AMT," ).append("\n"); 
		query.append("       TML_RF_20FT_COST_AMT," ).append("\n"); 
		query.append("       TML_RF_40FT_COST_AMT," ).append("\n"); 
		query.append("       RC_SVC_FLG,    " ).append("\n"); 
		query.append("       WTR_RCV_TERM_CD," ).append("\n"); 
		query.append("       WTR_DE_TERM_CD," ).append("\n"); 
		query.append("       RHQ_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT," ).append("\n"); 
		query.append("       SRC_INFO_CD," ).append("\n"); 
		query.append("       FDR_RT_RMK," ).append("\n"); 
		query.append("       LOCL_CURR_CD" ).append("\n"); 
		query.append("  FROM PRI_TRF_FDR_RT A" ).append("\n"); 
		query.append(" WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd]     " ).append("\n"); 
		query.append("   AND A.FDR_TRF_NO = @[fdr_trf_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}