/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchFDRDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
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

public class FeederChargeGuideLineDBDAOSearchFDRDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search FDR Detail ( FDRDetailVO 생성)
	  * 
	  * * History
	  * 2013.03.16 [CHM-201534279] 전지예 Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchFDRDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : FeederChargeGuideLineDBDAOSearchFDRDetailRSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , FDR_TRF_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("	 , RT_SEQ" ).append("\n"); 
		query.append("     , PNT_LOC_CD" ).append("\n"); 
		query.append("     , (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION" ).append("\n"); 
		query.append("         WHERE LOC_CD = PNT_LOC_CD" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS PNT_LOC_NM" ).append("\n"); 
		query.append("     , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("     , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , GLINE_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , LOCL_CURR_COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("     , TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("     , TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("     , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("     , MTY_TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("     , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("     , TML_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , MB_20FT_RTO" ).append("\n"); 
		query.append("     , MB_40FT_RTO" ).append("\n"); 
		query.append("     , MB_45FT_RTO -- 45' Cost 추가" ).append("\n"); 
		query.append("     , RC_SVC_FLG" ).append("\n"); 
		query.append("     , GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , COST_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , COST_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , LOCL_CURR_COST_RF_20FT_RT_AMT" ).append("\n"); 
		query.append("     , LOCL_CURR_COST_RF_40FT_RT_AMT" ).append("\n"); 
		query.append("     , TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("     , TRSP_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("     , MTY_TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("     , MTY_TRSP_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("     , TML_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("     , TML_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("     , MB_RF_20FT_RTO" ).append("\n"); 
		query.append("     , MB_RF_40FT_RTO" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_MN" ).append("\n"); 
		query.append("         WHERE SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = SUB.N1ST_CMNC_AMDT_SEQ) AS EFF_DT" ).append("\n"); 
		query.append("     , (SELECT CASE" ).append("\n"); 
		query.append("          WHEN M.AMDT_SEQ = SUB.AMDT_SEQ THEN DECODE(TO_CHAR(M.EXP_DT, 'YYYYMMDD'),'99991231', NULL , TO_CHAR(M.EXP_DT, 'YYYYMMDD'))" ).append("\n"); 
		query.append("          WHEN M.AMDT_SEQ <> SUB.AMDT_SEQ THEN TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("          WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE DECODE(TO_CHAR(N.EXP_DT, 'YYYYMMDD'),'99991231', NULL , TO_CHAR(N.EXP_DT, 'YYYYMMDD')) END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_MN M, PRI_TRF_FDR_MN N" ).append("\n"); 
		query.append("         WHERE M.FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("           AND N.FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("           AND M.ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND N.ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND N.AMDT_SEQ = M.AMDT_SEQ - DECODE('1', SUB.AMDT_SEQ, 0, 0, 0, 1)" ).append("\n"); 
		query.append("           AND M.SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND N.SVC_SCP_CD = SUB.SVC_SCP_CD) AS EXP_DT" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , FDR_RT_RMK" ).append("\n"); 
		query.append("     , LOCL_CURR_CD" ).append("\n"); 
		query.append("     , LOCL_CURR_CD AS LOCL_CURR_CD_RF" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , '' AS RHQ_CD" ).append("\n"); 
		query.append("  FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("             , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             , FDR_TRF_NO" ).append("\n"); 
		query.append("             , AMDT_SEQ" ).append("\n"); 
		query.append("             , RT_SEQ" ).append("\n"); 
		query.append("             , PNT_LOC_CD" ).append("\n"); 
		query.append("             , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("             , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("             , GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , CASE WHEN @[rhq_cd] = 'HAMRU'" ).append("\n"); 
		query.append("                    THEN GLINE_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                    ELSE GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                END GLINE_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , CASE WHEN @[rhq_cd] = 'HAMRU'" ).append("\n"); 
		query.append("                    THEN COST_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                    ELSE COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                END COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , CASE WHEN @[rhq_cd] = 'HAMRU'" ).append("\n"); 
		query.append("                    THEN LOCL_CURR_COST_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                    ELSE LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                END LOCL_CURR_COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("             , CASE WHEN @[rhq_cd] = 'HAMRU'" ).append("\n"); 
		query.append("                    THEN TRSP_45FT_COST_AMT" ).append("\n"); 
		query.append("                    ELSE TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("                END TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("             , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("             , CASE WHEN @[rhq_cd] = 'HAMRU'" ).append("\n"); 
		query.append("                    THEN MTY_TRSP_45FT_COST_AMT" ).append("\n"); 
		query.append("                    ELSE MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("                END MTY_TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("             , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("             , CASE WHEN @[rhq_cd] = 'HAMRU'" ).append("\n"); 
		query.append("                    THEN TML_45FT_COST_AMT" ).append("\n"); 
		query.append("                    ELSE TML_40FT_COST_AMT" ).append("\n"); 
		query.append("                END TML_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , MB_20FT_RTO" ).append("\n"); 
		query.append("             , MB_40FT_RTO" ).append("\n"); 
		query.append("             , CASE WHEN @[rhq_cd] = 'HAMRU'" ).append("\n"); 
		query.append("                    THEN MB_45FT_RTO" ).append("\n"); 
		query.append("                    ELSE MB_40FT_RTO" ).append("\n"); 
		query.append("                END MB_45FT_RTO -- 45' Cost 추가" ).append("\n"); 
		query.append("             , RC_SVC_FLG" ).append("\n"); 
		query.append("             , GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , LOCL_CURR_COST_RF_20FT_RT_AMT" ).append("\n"); 
		query.append("             , LOCL_CURR_COST_RF_40FT_RT_AMT" ).append("\n"); 
		query.append("             , TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("             , MTY_TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("             , MTY_TRSP_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("             , TML_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("             , TML_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("             , MB_RF_20FT_RTO" ).append("\n"); 
		query.append("             , MB_RF_40FT_RTO" ).append("\n"); 
		query.append("             , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("             , LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY SVC_SCP_CD, FDR_TRF_NO, RT_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("             , SRC_INFO_CD" ).append("\n"); 
		query.append("             , FDR_RT_RMK" ).append("\n"); 
		query.append("             , LOCL_CURR_CD" ).append("\n"); 
		query.append("             , CRE_USR_ID" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("             , UPD_USR_ID" ).append("\n"); 
		query.append("             , UPD_DT" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_RT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("               (AMDT_SEQ = @[amdt_seq] - 1 AND" ).append("\n"); 
		query.append("               SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND FDR_TRF_NO = @[fdr_trf_no]" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("      ) SUB" ).append("\n"); 
		query.append(" WHERE NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    OR N1ST_CMNC_AMDT_SEQ <> NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(" ORDER BY RT_SEQ , AMDT_SEQ" ).append("\n"); 

	}
}