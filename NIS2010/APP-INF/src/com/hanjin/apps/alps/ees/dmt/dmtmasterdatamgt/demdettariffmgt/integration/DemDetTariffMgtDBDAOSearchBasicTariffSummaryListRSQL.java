/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.18 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchBasicTariffSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Group 생성 이력  관리
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffSummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_grp_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_grp_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffSummaryListRSQL").append("\n"); 
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
		query.append("SELECT  A.CVRG_CNT_CD" ).append("\n"); 
		query.append("        , CASE WHEN TRIM(A.CVRG_YD_CD) IS NULL THEN" ).append("\n"); 
		query.append("        	(CASE WHEN TRIM(A.CVRG_LOC_CD) IS NULL THEN" ).append("\n"); 
		query.append("        		(CASE WHEN TRIM(A.CVRG_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("        			(CASE WHEN TRIM(A.CVRG_RGN_CD) IS NULL THEN A.CVRG_CNT_CD ELSE A.CVRG_RGN_CD END)" ).append("\n"); 
		query.append("        		ELSE A.CVRG_STE_CD" ).append("\n"); 
		query.append("        		END)" ).append("\n"); 
		query.append("        	ELSE A.CVRG_LOC_CD" ).append("\n"); 
		query.append("        	END)" ).append("\n"); 
		query.append("          ELSE A.CVRG_YD_CD" ).append("\n"); 
		query.append("          END                                                                                               AS COVRG" ).append("\n"); 
		query.append("        , A.DMDT_TRF_CD" ).append("\n"); 
		query.append("        , CASE WHEN TRIM(A.ORG_DEST_LOC_CD) IS NULL THEN " ).append("\n"); 
		query.append("        	(CASE WHEN TRIM(A.ORG_DEST_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("        		(CASE WHEN TRIM(A.ORG_DEST_RGN_CD) IS NULL THEN " ).append("\n"); 
		query.append("        			(CASE WHEN TRIM(A.ORG_DEST_CNT_CD) IS NULL THEN A.ORG_DEST_CONTI_CD ELSE A.ORG_DEST_CNT_CD END)" ).append("\n"); 
		query.append("        		ELSE A.ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("        		END)" ).append("\n"); 
		query.append("        	ELSE A.ORG_DEST_STE_CD" ).append("\n"); 
		query.append("        	END)" ).append("\n"); 
		query.append("          ELSE A.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("          END                                                                                               AS ORG_DEST" ).append("\n"); 
		query.append("        , B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT  S.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM    COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("          WHERE   S.INTG_CD_ID        = 'CD03257'" ).append("\n"); 
		query.append("          AND     S.INTG_CD_VAL_CTNT  = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("          )                                                                                                 AS DMDT_DE_TERM_NM" ).append("\n"); 
		query.append("        , CASE WHEN B.DMDT_TRF_GRP_TP_CD = 'N' THEN 'Exempted'" ).append("\n"); 
		query.append("              ELSE B.DMDT_BZC_TRF_GRP_NM END                                                                AS DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append("        , TO_CHAR(B.EFF_DT,'YYYY-MM-DD')                                                                    AS EFF_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.EXP_DT,'YYYY-MM-DD')                                                                    AS EXP_DT" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM  DMT_TRF_CMB C " ).append("\n"); 
		query.append("          WHERE C.SYS_AREA_GRP_ID   = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("          AND   C.DMDT_TRF_CD       = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("          AND   C.TRF_SEQ           = B.TRF_SEQ" ).append("\n"); 
		query.append("          AND   C.DMDT_DE_TERM_CD   = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("          AND   C.TRF_GRP_SEQ       = B.TRF_GRP_SEQ" ).append("\n"); 
		query.append("          )                                                                                                 AS CNTR_CGO_CNT" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT TO_CHAR(H.CRE_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          FROM   DMT_TRF_GRP_CFM_HIS H" ).append("\n"); 
		query.append("          WHERE  H.SYS_AREA_GRP_ID  = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("          AND    H.DMDT_TRF_CD      = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("          AND    H.TRF_SEQ          = B.TRF_SEQ" ).append("\n"); 
		query.append("          AND    H.DMDT_DE_TERM_CD  = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("          AND    H.TRF_GRP_SEQ      = B.TRF_GRP_SEQ" ).append("\n"); 
		query.append("          AND    (H.RGN_CFM_SEQ||H.GRP_CFM_SEQ) = (" ).append("\n"); 
		query.append("                                                  SELECT MAX(RGN_CFM_SEQ||GRP_CFM_SEQ)" ).append("\n"); 
		query.append("                                                  FROM  DMT_TRF_GRP_CFM_HIS" ).append("\n"); 
		query.append("                                                  WHERE SYS_AREA_GRP_ID     = H.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                                  AND   DMDT_TRF_CD         = H.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                                  AND   TRF_SEQ             = H.TRF_SEQ" ).append("\n"); 
		query.append("                                                  AND   DMDT_DE_TERM_CD     = H.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                                                  AND   TRF_GRP_SEQ         = H.TRF_GRP_SEQ" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("          )                                                                                                 AS CRE_DT" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT CRE_OFC_CD " ).append("\n"); 
		query.append("          FROM   DMT_TRF_GRP_CFM_HIS H" ).append("\n"); 
		query.append("          WHERE  H.SYS_AREA_GRP_ID     = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("          AND    H.DMDT_TRF_CD         = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("          AND    H.TRF_SEQ             = B.TRF_SEQ" ).append("\n"); 
		query.append("          AND    H.DMDT_DE_TERM_CD     = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("          AND    H.TRF_GRP_SEQ         = B.TRF_GRP_SEQ" ).append("\n"); 
		query.append("          AND    (H.RGN_CFM_SEQ||H.GRP_CFM_SEQ) = (" ).append("\n"); 
		query.append("                                                  SELECT MAX(RGN_CFM_SEQ||GRP_CFM_SEQ)" ).append("\n"); 
		query.append("                                                  FROM   DMT_TRF_GRP_CFM_HIS" ).append("\n"); 
		query.append("                                                  WHERE  SYS_AREA_GRP_ID   = H.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                                  AND    DMDT_TRF_CD       = H.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                                  AND    TRF_SEQ           = H.TRF_SEQ" ).append("\n"); 
		query.append("                                                  AND    DMDT_DE_TERM_CD   = H.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                                                  AND    TRF_GRP_SEQ       = H.TRF_GRP_SEQ" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("          )                                                                                                 AS CRE_OFC_CD " ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT (SELECT USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID) " ).append("\n"); 
		query.append("          FROM  DMT_TRF_GRP_CFM_HIS H" ).append("\n"); 
		query.append("          WHERE H.SYS_AREA_GRP_ID   = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("          AND   H.DMDT_TRF_CD       = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("          AND   H.TRF_SEQ           = B.TRF_SEQ" ).append("\n"); 
		query.append("          AND   H.DMDT_DE_TERM_CD   = B.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("          AND   H.TRF_GRP_SEQ       = B.TRF_GRP_SEQ" ).append("\n"); 
		query.append("          AND   (H.RGN_CFM_SEQ||H.GRP_CFM_SEQ) = (" ).append("\n"); 
		query.append("                                                 SELECT MAX(RGN_CFM_SEQ||GRP_CFM_SEQ)" ).append("\n"); 
		query.append("                                                 FROM   DMT_TRF_GRP_CFM_HIS" ).append("\n"); 
		query.append("                                                 WHERE  SYS_AREA_GRP_ID = H.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                                 AND    DMDT_TRF_CD     = H.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                                 AND    TRF_SEQ         = H.TRF_SEQ" ).append("\n"); 
		query.append("                                                 AND    DMDT_DE_TERM_CD = H.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("                                                 AND    TRF_GRP_SEQ     = H.TRF_GRP_SEQ" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("            )                                                                                           AS CRE_USR_NM " ).append("\n"); 
		query.append("        , DECODE(B.EXP_DT, NULL, '', TO_CHAR(B.UPD_DT, 'YYYY-MM-DD'))                                   AS UPD_DT" ).append("\n"); 
		query.append("        , DECODE(B.EXP_DT, NULL, '', B.UPD_OFC_CD)                                                      AS UPD_OFC_CD" ).append("\n"); 
		query.append("        , DECODE(B.EXP_DT, NULL, '', (SELECT USR_NM FROM COM_USER WHERE USR_ID=B.UPD_USR_ID) )          AS UPD_USR_NM" ).append("\n"); 
		query.append("		, CASE WHEN TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("      	  ELSE 'N'" ).append("\n"); 
		query.append("		  END                                                                                             AS EXPIRE_CHK" ).append("\n"); 
		query.append("FROM    DMT_TRF_RGN A, " ).append("\n"); 
		query.append("        DMT_TRF_GRP B" ).append("\n"); 
		query.append("WHERE   A.SYS_AREA_GRP_ID   = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     A.DMDT_TRF_CD       = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND     A.TRF_SEQ           = B.TRF_SEQ" ).append("\n"); 
		query.append("AND     B.CFM_FLG           = 'Y'" ).append("\n"); 
		query.append("AND     A.SUTH_CHN_USE_FLG  = 'N'" ).append("\n"); 
		query.append("#if (${dmdt_de_term_cd} != 'A')" ).append("\n"); 
		query.append("AND     B.DMDT_DE_TERM_CD   = @[dmdt_de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${svr_id} == '')" ).append("\n"); 
		query.append("	#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND     A.CVRG_CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${svr_id} == 'KOR' || ${svr_id} == 'JPN' || ${svr_id} == 'VVO')" ).append("\n"); 
		query.append("	#if (${cnt_cd} == '')" ).append("\n"); 
		query.append("AND     A.CVRG_CNT_CD       = DECODE(@[svr_id], 'KOR', 'KR', 'JPN', 'JP', 'VVO', 'RU')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND     A.CVRG_CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${cnt_cd} == '')" ).append("\n"); 
		query.append("AND     A.SYS_AREA_GRP_ID   = @[svr_id]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND     A.CVRG_CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${conti_cd} != '') " ).append("\n"); 
		query.append("AND A.ORG_DEST_CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND     A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_trf_cd in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_trf_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_trf_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_grp_tp_cd1} != '')" ).append("\n"); 
		query.append("AND ( B.DMDT_TRF_GRP_TP_CD = @[dmdt_trf_grp_tp_cd1]" ).append("\n"); 
		query.append("    #if (${dmdt_trf_grp_tp_cd2} != '')" ).append("\n"); 
		query.append("		OR B.DMDT_TRF_GRP_TP_CD = @[dmdt_trf_grp_tp_cd2] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${dmdt_trf_grp_tp_cd2} != '')" ).append("\n"); 
		query.append("		AND B.DMDT_TRF_GRP_TP_CD = @[dmdt_trf_grp_tp_cd2]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${validity1} != '')" ).append("\n"); 
		query.append("AND ( TO_CHAR(EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("      AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("		OR (TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("            AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("        #if (${validity3} != '')" ).append("\n"); 
		query.append("			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        #if (${validity3} != '')" ).append("\n"); 
		query.append("			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("		TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("        AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("		#if (${validity3} != '')" ).append("\n"); 
		query.append("			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CVRG_CNT_CD, LENGTH(COVRG), COVRG, A.DMDT_TRF_CD, LENGTH(ORG_DEST), ORG_DEST, B.DMDT_DE_TERM_CD, B.DMDT_BZC_TRF_GRP_NM, EXP_DT" ).append("\n"); 

	}
}