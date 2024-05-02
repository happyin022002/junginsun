/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchFDRAmendmentHistoryDetailRSQL.java
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

public class FeederChargeGuideLineDBDAOSearchFDRAmendmentHistoryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve Add-on Tariff Amendment History detail (VO는 따로 생성)
	  * 2015.03.05 [CHM-201534279] 최성환  Pricing FeederIHC tariff 45 칼럼 추가
	  * - HAMRU 45' 사용 그외는 40'로 적용함.
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchFDRAmendmentHistoryDetailRSQL(){
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
		query.append("FileName : FeederChargeGuideLineDBDAOSearchFDRAmendmentHistoryDetailRSQL").append("\n"); 
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
		query.append("SELECT SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("     , SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("     , SUB.AMDT_SEQ" ).append("\n"); 
		query.append("     , SUB.RT_SEQ" ).append("\n"); 
		query.append("     , SUB.PNT_LOC_CD" ).append("\n"); 
		query.append("     , (SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD = SUB.PNT_LOC_CD" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS PNT_LOC_NM     " ).append("\n"); 
		query.append("     , SUB.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("     , SUB.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , SUB.GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , CASE WHEN SUB.RHQ_CD = 'HAMRU' THEN SUB.GLINE_45FT_FRT_RT_AMT ELSE SUB.GLINE_40FT_FRT_RT_AMT END GLINE_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("     , SUB.GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.RC_SVC_FLG" ).append("\n"); 
		query.append("     , SUB.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , SUB.NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_MN" ).append("\n"); 
		query.append("         WHERE SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = SUB.N1ST_CMNC_AMDT_SEQ) AS EFF_DT" ).append("\n"); 
		query.append("     , (SELECT CASE" ).append("\n"); 
		query.append("          WHEN M.AMDT_SEQ = SUB.AMDT_SEQ THEN DECODE(TO_CHAR(M.EXP_DT,'YYYYMMDD'),'99991231', NULL, TO_CHAR(M.EXP_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("          WHEN M.AMDT_SEQ <> SUB.AMDT_SEQ THEN TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("          WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE DECODE(TO_CHAR(N.EXP_DT,'YYYYMMDD'),'99991231', NULL, TO_CHAR(N.EXP_DT,'YYYYMMDD')) END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_MN M, PRI_TRF_FDR_MN N" ).append("\n"); 
		query.append("         WHERE M.FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("           AND N.FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("           AND M.ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND N.ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND N.AMDT_SEQ = M.AMDT_SEQ - DECODE('1', SUB.AMDT_SEQ, 0, 0, 0, 1)" ).append("\n"); 
		query.append("           AND M.SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND N.SVC_SCP_CD = SUB.SVC_SCP_CD) AS EXP_DT           " ).append("\n"); 
		query.append("     , SUB.SRC_INFO_CD" ).append("\n"); 
		query.append("     , DECODE(SUB.COST_20FT_FRT_RT_AMT,'','V','') AS ADD_FLG" ).append("\n"); 
		query.append("     , '' AS DETAIL_TP" ).append("\n"); 
		query.append("     , SUB.RHQ_CD AS RHQ_CD" ).append("\n"); 
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
		query.append("             , GLINE_45FT_FRT_RT_AMT	-- 45'" ).append("\n"); 
		query.append("             , GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , RC_SVC_FLG" ).append("\n"); 
		query.append("             , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("             , LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY SVC_SCP_CD, FDR_TRF_NO, RT_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("             , SRC_INFO_CD" ).append("\n"); 
		query.append("			 , RHQ_CD		-- 45'" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_RT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           #if(${detail_tp} == '1')  " ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${detail_tp} == '2')  " ).append("\n"); 
		query.append("           AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("               (AMDT_SEQ = @[amdt_seq] - 1 AND SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("           #end    " ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("           AND FDR_TRF_NO = @[fdr_trf_no] " ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("      ) SUB" ).append("\n"); 
		query.append(" WHERE  " ).append("\n"); 
		query.append("    #if(${detail_tp} == '1')    " ).append("\n"); 
		query.append("        SUB.NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if(${detail_tp} == '2')        " ).append("\n"); 
		query.append("        (SUB.NEXT_N1ST_CMNC_AMDT_SEQ IS NULL AND SUB.N1ST_CMNC_AMDT_SEQ = SUB.AMDT_SEQ)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    OR SUB.N1ST_CMNC_AMDT_SEQ <> SUB.NEXT_N1ST_CMNC_AMDT_SEQ    " ).append("\n"); 
		query.append(" ORDER BY SUB.RT_SEQ , SUB.AMDT_SEQ" ).append("\n"); 

	}
}