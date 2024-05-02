/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsBrokerageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOFmsBrokerageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Slip – Brokerage / Window Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsBrokerageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsBrokerageListRSQL").append("\n"); 
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
		query.append("WITH V_VVD AS(" ).append("\n"); 
		query.append("        SELECT DISTINCT VVD_CD" ).append("\n"); 
		query.append("             , VST_DT" ).append("\n"); 
		query.append("             , VED_DT" ).append("\n"); 
		query.append("             , FLET_CTRT_NO" ).append("\n"); 
		query.append("             , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , COM_VVD_FLG" ).append("\n"); 
		query.append("             , CASE WHEN COM_VVD_FLG = 'Y' AND FLET_CTRT_TP_CD = 'TO' THEN FLET_CTRT_NO" ).append("\n"); 
		query.append("                    WHEN COM_VVD_FLG = 'N' AND FLET_CTRT_TP_CD = 'TI' THEN FLET_CTRT_NO" ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("               END AS EXIST_FLET_CTRT_NO" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT FV.VSL_CD || FV.SKD_VOY_NO || FV.SKD_DIR_CD || FV.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("                     , FV.VST_DT" ).append("\n"); 
		query.append("                     , FV.VED_DT" ).append("\n"); 
		query.append("                     , FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , FC.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                     , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE M" ).append("\n"); 
		query.append("                             WHERE M.REP_TRD_CD = 'COM'" ).append("\n"); 
		query.append("                               AND M.RLANE_CD = FV.RLANE_CD),'N') AS COM_VVD_FLG" ).append("\n"); 
		query.append("                  FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                     , FMS_VVD FV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND FC.VSL_CD = FV.VSL_CD" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT FV.VSL_CD || FV.SKD_VOY_NO || FV.SKD_DIR_CD || FV.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("                     , FV.VST_DT" ).append("\n"); 
		query.append("                     , FV.VED_DT" ).append("\n"); 
		query.append("                     , FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , SUBSTR(FI.FLET_CTRT_NO, 5,2) AS FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                     , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE M" ).append("\n"); 
		query.append("                             WHERE M.REP_TRD_CD = 'COM'" ).append("\n"); 
		query.append("                               AND M.RLANE_CD = FV.RLANE_CD),'N') AS COM_VVD_FLG" ).append("\n"); 
		query.append("                  FROM FMS_ID_VSL FI" ).append("\n"); 
		query.append("                     , FMS_VVD FV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND FI.USE_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND FI.VSL_CD = FV.VSL_CD )" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND (CASE WHEN COM_VVD_FLG = 'Y' AND FLET_CTRT_TP_CD = 'TO' THEN FLET_CTRT_NO" ).append("\n"); 
		query.append("                     WHEN COM_VVD_FLG = 'N' AND FLET_CTRT_TP_CD = 'TI' THEN FLET_CTRT_NO" ).append("\n"); 
		query.append("                     ELSE NULL" ).append("\n"); 
		query.append("                END) IS NOT NULL" ).append("\n"); 
		query.append("         ORDER BY VVD_CD, VST_DT " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT * FROM V_VVD; " ).append("\n"); 
		query.append("     , V_EXIST_VVD AS (" ).append("\n"); 
		query.append("        SELECT A.INV_DESC" ).append("\n"); 
		query.append("             , A.EFF_DT" ).append("\n"); 
		query.append("             , A.EXP_DT" ).append("\n"); 
		query.append("             , A.ACCT_ITM_NM" ).append("\n"); 
		query.append("             , A.ACCT_CD" ).append("\n"); 
		query.append("             , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("             , A.CURR_CD" ).append("\n"); 
		query.append("             , A.INV_AMT" ).append("\n"); 
		query.append("             , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("             , A.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("             , A.INV_SEQ" ).append("\n"); 
		query.append("             , A.INV_DTL_SEQ" ).append("\n"); 
		query.append("             , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , LISTAGG (A.VVD_CD, '|') WITHIN GROUP ( ORDER BY A.VVD_CD) AS VVD_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.INV_DESC" ).append("\n"); 
		query.append("                             , TO_CHAR(A.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("                             , TO_CHAR(A.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                             , B.ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , A.ACCT_CD" ).append("\n"); 
		query.append("                             , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , A.CURR_CD" ).append("\n"); 
		query.append("                             , A.INV_AMT" ).append("\n"); 
		query.append("                             , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("                             , A.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("                             , A.INV_SEQ" ).append("\n"); 
		query.append("                             , A.INV_DTL_SEQ" ).append("\n"); 
		query.append("                             , C.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                             , CASE WHEN C.FLET_CTRT_TP_CD = 'TO' AND V.COM_VVD_FLG = 'Y' THEN V.VVD_CD" ).append("\n"); 
		query.append("                                    WHEN C.FLET_CTRT_TP_CD = 'TI' AND V.COM_VVD_FLG = 'N' THEN V.VVD_CD" ).append("\n"); 
		query.append("                                    ELSE NULL" ).append("\n"); 
		query.append("                               END AS VVD_CD" ).append("\n"); 
		query.append("                          FROM FMS_INV_DTL A" ).append("\n"); 
		query.append("                             , FMS_ACCT_ITM B" ).append("\n"); 
		query.append("                             , FMS_CONTRACT C" ).append("\n"); 
		query.append("                             , V_VVD V" ).append("\n"); 
		query.append("                         WHERE A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("                           AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                           AND A.BROG_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND A.SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("                           AND A.FLET_ISS_TP_CD NOT IN ('OFF')" ).append("\n"); 
		query.append("                           AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("                           AND A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("                           AND C.FLET_CTRT_NO = V.FLET_CTRT_NO" ).append("\n"); 
		query.append("                           AND ( TO_CHAR(A.EFF_DT,'YYYYMMDD') BETWEEN V.VST_DT AND V.VED_DT" ).append("\n"); 
		query.append("                                    OR TO_CHAR(A.EXP_DT,'YYYYMMDD') BETWEEN VST_DT AND VED_DT ) " ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                 WHERE A.VVD_CD IS NOT NULL " ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("         GROUP BY A.INV_DESC" ).append("\n"); 
		query.append("             , A.EFF_DT" ).append("\n"); 
		query.append("             , A.EXP_DT" ).append("\n"); 
		query.append("             , A.ACCT_ITM_NM" ).append("\n"); 
		query.append("             , A.ACCT_CD" ).append("\n"); 
		query.append("             , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("             , A.CURR_CD" ).append("\n"); 
		query.append("             , A.INV_AMT" ).append("\n"); 
		query.append("             , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("             , A.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("             , A.INV_SEQ" ).append("\n"); 
		query.append("             , A.INV_DTL_SEQ" ).append("\n"); 
		query.append("             , A.FLET_CTRT_TP_CD " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("--SELECT * FROM V_EXIST_VVD; " ).append("\n"); 
		query.append("SELECT A.INV_DESC" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("     , B.ACCT_ITM_NM" ).append("\n"); 
		query.append("     , A.ACCT_CD" ).append("\n"); 
		query.append("     , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("     , A.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("     , A.INV_SEQ" ).append("\n"); 
		query.append("     , A.INV_DTL_SEQ" ).append("\n"); 
		query.append("     , C.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , V.VVD_CD AS VVD_CD_TXT" ).append("\n"); 
		query.append("     , NULL AS VVD_CD" ).append("\n"); 
		query.append("  FROM FMS_INV_DTL A" ).append("\n"); 
		query.append("     , FMS_ACCT_ITM B" ).append("\n"); 
		query.append("     , FMS_CONTRACT C" ).append("\n"); 
		query.append("     , V_EXIST_VVD V" ).append("\n"); 
		query.append(" WHERE A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("   AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("   AND A.BROG_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("   AND A.FLET_ISS_TP_CD NOT IN ('OFF')" ).append("\n"); 
		query.append("   AND A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("   AND A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("   AND A.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("   AND TO_CHAR(A.EFF_DT,'YYYYMMDD') = V.EFF_DT(+)" ).append("\n"); 
		query.append("   AND TO_CHAR(A.EXP_DT,'YYYYMMDD') = V.EXP_DT(+)" ).append("\n"); 
		query.append("   AND A.ACCT_CD = V.ACCT_CD(+)" ).append("\n"); 
		query.append("   AND A.ACCT_ITM_SEQ = V.ACCT_ITM_SEQ(+)" ).append("\n"); 
		query.append("   AND A.INV_SEQ = V.INV_SEQ(+)" ).append("\n"); 
		query.append("   AND A.INV_DTL_SEQ = V.INV_DTL_SEQ(+)" ).append("\n"); 
		query.append(" ORDER BY A.EFF_DT, A.INV_DESC" ).append("\n"); 

	}
}