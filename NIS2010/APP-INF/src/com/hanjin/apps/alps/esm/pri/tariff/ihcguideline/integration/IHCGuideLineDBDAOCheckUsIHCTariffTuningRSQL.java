/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOCheckUsIHCTariffTuningRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.27
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.27 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOCheckUsIHCTariffTuningRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * before confirm, check US IHC Tariff tuning
	  * </pre>
	  */
	public IHCGuideLineDBDAOCheckUsIHCTariffTuningRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOCheckUsIHCTariffTuningRSQL").append("\n"); 
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
		query.append("#if(${cost_cnt_cd} == 'US')" ).append("\n"); 
		query.append("SELECT COM.INTG_CD_VAL_DP_DESC AS USA_COST_TRF_SVC_MOD_NM" ).append("\n"); 
		query.append("     , COUNT(RT.USA_COST_TRF_SVC_MOD_CD) AS TOTAL_COUNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cost_cnt_cd} == 'CA')    " ).append("\n"); 
		query.append("SELECT 'Canada Inland' USA_COST_TRF_SVC_MOD_NM" ).append("\n"); 
		query.append("     , COUNT(RT.IHC_TRF_NO) AS TOTAL_COUNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append("     , COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND RT.SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("   AND RT.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND RT.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND RT.AMDT_SEQ = @[amdt_seq] " ).append("\n"); 
		query.append("   AND RT.IHC_CGO_TP_CD = 'DR'" ).append("\n"); 
		query.append("   AND RT.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("   AND RT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("   AND (      NOT (TRUNC(RT.GLINE_20FT_FRT_RT_AMT) = RT.GLINE_20FT_FRT_RT_AMT AND MOD(RT.GLINE_20FT_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("           OR NOT (TRUNC(RT.GLINE_40FT_FRT_RT_AMT) = RT.GLINE_40FT_FRT_RT_AMT AND MOD(RT.GLINE_40FT_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("           OR NOT (TRUNC(RT.GLINE_20FT_RAIL_FRT_RT_AMT) = RT.GLINE_20FT_RAIL_FRT_RT_AMT AND MOD(RT.GLINE_20FT_RAIL_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("           OR NOT (TRUNC(RT.GLINE_40FT_RAIL_FRT_RT_AMT) = RT.GLINE_40FT_RAIL_FRT_RT_AMT AND MOD(RT.GLINE_40FT_RAIL_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("           OR NOT (TRUNC(RT.GLINE_20FT_TRK_FRT_RT_AMT) = RT.GLINE_20FT_TRK_FRT_RT_AMT AND MOD(RT.GLINE_20FT_TRK_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("           OR NOT (TRUNC(RT.GLINE_40FT_TRK_FRT_RT_AMT) = RT.GLINE_40FT_TRK_FRT_RT_AMT AND MOD(RT.GLINE_40FT_TRK_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND COM.INTG_CD_ID = 'CD03121'" ).append("\n"); 
		query.append("   AND RT.USA_COST_TRF_SVC_MOD_CD = COM.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("#if(${cost_cnt_cd} == 'US')   " ).append("\n"); 
		query.append("GROUP BY COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'Reefer' AS USA_COST_TRF_SVC_MOD_NM" ).append("\n"); 
		query.append("     , COUNT(RT.IHC_CGO_TP_CD) AS TOTAL_COUNT" ).append("\n"); 
		query.append("  FROM PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND RT.SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("   AND RT.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND RT.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND RT.AMDT_SEQ = @[amdt_seq] " ).append("\n"); 
		query.append("   AND RT.IHC_CGO_TP_CD = 'RF'" ).append("\n"); 
		query.append("   AND RT.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("   AND RT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("   AND (      NOT (TRUNC(RT.GLINE_20FT_FRT_RT_AMT) = RT.GLINE_20FT_FRT_RT_AMT AND MOD(RT.GLINE_20FT_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("           OR NOT (TRUNC(RT.GLINE_40FT_FRT_RT_AMT) = RT.GLINE_40FT_FRT_RT_AMT AND MOD(RT.GLINE_40FT_FRT_RT_AMT ,5) = 0)" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}