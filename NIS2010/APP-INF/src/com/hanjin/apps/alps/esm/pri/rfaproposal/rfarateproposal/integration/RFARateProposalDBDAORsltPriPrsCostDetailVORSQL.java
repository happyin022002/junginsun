/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPriPrsCostDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltPriPrsCostDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Cost Detail 화면(  PRI_6016) 에서 Cost Detail List를 추출하는 쿼리
	  * 
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPriPrsCostDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_src_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltPriPrsCostDetailVORSQL").append("\n"); 
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
		query.append("/* prop_no,amdt_seq,svc_scp_cd,cmdt_hdr_seq,rout_seq,rt_seq, rout_cs_no,rout_cs_src_dt,cost_tp  파라메터 추가*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'FREIGHT REV' NOD_CD" ).append("\n"); 
		query.append("       ,1 COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       ,'' GRP" ).append("\n"); 
		query.append("       ,'' SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("       ,'' STND_COST_NM" ).append("\n"); 
		query.append("       , NVL(PROD_REV,0) AMT   " ).append("\n"); 
		query.append("       ,'' WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       ,'' WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       ,0 LVL" ).append("\n"); 
		query.append("       ,'' ctrt_flg" ).append("\n"); 
		query.append("       ,'' avg_flg" ).append("\n"); 
		query.append("       ,''  as ROW_PROPERTIES" ).append("\n"); 
		query.append("  FROM PRI_PRS_USD_ROUT_CS_INFO" ).append("\n"); 
		query.append(" WHERE ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 
		query.append("   AND ROUT_CS_NO = @[rout_cs_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_tp} == 'O') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT   'DEM/DET' NOD_CD" ).append("\n"); 
		query.append("         ,2 COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("         ,'' GRP" ).append("\n"); 
		query.append("         ,'' SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("         ,'' STND_COST_NM" ).append("\n"); 
		query.append("         ,SUM(ESTM_USD_TTL_AMT) AMT" ).append("\n"); 
		query.append("         ,'' WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("         ,'' WTR_DE_TERM_CD" ).append("\n"); 
		query.append("         ,0 LVL" ).append("\n"); 
		query.append("         ,DECODE( MAX(ctrt_rtn_flg), 'Y', 'Y', 'N') AS Ctrt" ).append("\n"); 
		query.append("         ,DECODE( MIN(ctrt_rtn_flg), 'N', 'Y', 'N') AS Avg" ).append("\n"); 
		query.append("         ,''  as ROW_PROPERTIES" ).append("\n"); 
		query.append("     FROM PRI_PRS_USD_ROUT_ACT_COST" ).append("\n"); 
		query.append("    WHERE ROUT_CS_NO = @[rout_cs_no]" ).append("\n"); 
		query.append("      AND ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 
		query.append("      AND STND_COST_CD = '43201011'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" -- OP REVENUE" ).append("\n"); 
		query.append(" SELECT   'MISC OP REV' NOD_CD" ).append("\n"); 
		query.append("         ,4 COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("         ,'' GRP" ).append("\n"); 
		query.append("         ,'' SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("         ,'' STND_COST_NM" ).append("\n"); 
		query.append("         ,DECODE(IS_USE_TRD_UC, 'Y', TRD_UC_AMT * CNTR_TEU, RLANE_UC_AMT * CNTR_TEU) AMT" ).append("\n"); 
		query.append("         ,'' WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("         ,'' WTR_DE_TERM_CD" ).append("\n"); 
		query.append("         ,0 LVL" ).append("\n"); 
		query.append("         ,'N' Ctrt" ).append("\n"); 
		query.append("         ,'Y' Avg" ).append("\n"); 
		query.append("         ,''  as ROW_PROPERTIES" ).append("\n"); 
		query.append("   FROM (SELECT " ).append("\n"); 
		query.append("               A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("               ,A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,A2.CNTR_QTY" ).append("\n"); 
		query.append("               ,DECODE(SUBSTR(A2.CNTR_TPSZ_CD, -1), '2', A2.CNTR_QTY, A2.CNTR_QTY * 2) CNTR_TEU" ).append("\n"); 
		query.append("               ,A3.REV_YRMON" ).append("\n"); 
		query.append("               ,DECODE(NVL(A1.COST_ROUT_NO, 1), 1, A1.N1ST_TRD_CD, 2, A1.N2ND_TRD_CD, 3, A1.N3RD_TRD_CD, A1.N4TH_TRD_CD) TRD_CD --A3.TRD_CD" ).append("\n"); 
		query.append("               ,DECODE(NVL(A1.COST_ROUT_NO, 1), 1, A1.N1ST_RLANE_CD, 2, A1.N2ND_RLANE_CD, 3, A1.N3RD_RLANE_CD, A1.N4TH_RLANE_CD) RLANE_CD --A3.RLANE_CD" ).append("\n"); 
		query.append("               ,SUBSTR(DECODE(NVL(COST_ROUT_NO, 1), 1, A1.N1ST_FINC_VVD_CD, 2, A1.N2ND_FINC_VVD_CD, 3, A1.N3RD_FINC_VVD_CD, A1.N4TH_FINC_VVD_CD), -1) DIR_CD--A3.DIR_CD" ).append("\n"); 
		query.append("               ,NVL(A3.TRD_UC_AMT, 0) TRD_UC_AMT" ).append("\n"); 
		query.append("               ,NVL(A3.RLANE_UC_AMT, 0) RLANE_UC_AMT" ).append("\n"); 
		query.append("               ,A3.IS_USE_TRD_UC" ).append("\n"); 
		query.append("           FROM PRI_PRS_USD_ROUT_CS_INFO A1" ).append("\n"); 
		query.append("               ,PRI_PRS_USD_ROUT_ACT_COST A2" ).append("\n"); 
		query.append("               ,(SELECT   REV_YRMON" ).append("\n"); 
		query.append("                         ,TRD_CD" ).append("\n"); 
		query.append("                         ,RLANE_CD" ).append("\n"); 
		query.append("                         ,DIR_CD" ).append("\n"); 
		query.append("                         ,MAX(TRD_UC_AMT) TRD_UC_AMT" ).append("\n"); 
		query.append("                         ,MAX(RLANE_UC_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("                         ,MAX(IS_USE_TRD_UC) IS_USE_TRD_UC" ).append("\n"); 
		query.append("                     FROM (SELECT REV_YRMON" ).append("\n"); 
		query.append("                                 ,TRD_CD" ).append("\n"); 
		query.append("                                 ,DIR_CD" ).append("\n"); 
		query.append("                                 ,DECODE(RLANE_CD, 'XXXXX', NULL, RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("                                 ,DECODE(RLANE_CD, 'XXXXX', ETC_UT_REV_AMT, 0) TRD_UC_AMT" ).append("\n"); 
		query.append("                                 ,DECODE(RLANE_CD, 'XXXXX', 0, ETC_UT_REV_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("                                 ,CASE" ).append("\n"); 
		query.append("                                     WHEN ETC_UT_REV_AMT > 100" ).append("\n"); 
		query.append("                                     AND TRD_TTL_QTY < 100" ).append("\n"); 
		query.append("                                        THEN 'Y'" ).append("\n"); 
		query.append("                                     ELSE 'N'" ).append("\n"); 
		query.append("                                  END AS IS_USE_TRD_UC" ).append("\n"); 
		query.append("                             FROM MAS_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append("                            WHERE REV_YRMON = MAS_BZC_COST_YRMON_FNC('') )  /* MAS_BZC_COST_YRMON_FNC('', '')) ???????????????????????*/" ).append("\n"); 
		query.append("                 GROUP BY REV_YRMON, TRD_CD, RLANE_CD, DIR_CD) A3" ).append("\n"); 
		query.append("          WHERE A1.ROUT_CS_NO = A2.ROUT_CS_NO" ).append("\n"); 
		query.append("            AND A1.ROUT_CS_SRC_DT = A2.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("            AND A1.ROUT_CS_NO = 1" ).append("\n"); 
		query.append("            AND A1.ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 
		query.append("            AND A2.COA_COST_SRC_CD = '43201011'   --DEM/DET" ).append("\n"); 
		query.append("            AND A3.REV_YRMON(+) = MAS_BZC_COST_YRMON_FNC('') -- MAS_BZC_COST_YRMON_FNC('', '')" ).append("\n"); 
		query.append("            AND A3.TRD_CD(+) = DECODE(NVL(A1.COST_ROUT_NO, 1), 1, A1.N1ST_TRD_CD, 2, A1.N2ND_TRD_CD, 3, A1.N3RD_TRD_CD, A1.N4TH_TRD_CD)" ).append("\n"); 
		query.append("            AND A3.RLANE_CD(+) =" ).append("\n"); 
		query.append("                             DECODE(NVL(A1.COST_ROUT_NO, 1)" ).append("\n"); 
		query.append("                                   ,1, A1.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                                   ,2, A1.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                                   ,3, A1.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                                   ,A1.N4TH_RLANE_CD" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("            AND A3.DIR_CD(+) =" ).append("\n"); 
		query.append("                   SUBSTR(DECODE(NVL(COST_ROUT_NO, 1)" ).append("\n"); 
		query.append("                                ,1, A1.N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("                                ,2, A1.N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("                                ,3, A1.N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("                                ,A1.N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                         ,-1 ))" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT   NOD_CD" ).append("\n"); 
		query.append("         ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("         ,GRP" ).append("\n"); 
		query.append("         ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("         ,DECODE(LVL,1,SGRP_COST_CD_DESC, SUBSTR(STND_COST_NM, 3))" ).append("\n"); 
		query.append("         ,AMT" ).append("\n"); 
		query.append("         ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("         ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("         ,DECODE(LVL, 1, 1, 2) LVL" ).append("\n"); 
		query.append("         ,Ctrt" ).append("\n"); 
		query.append("         ,Avg" ).append("\n"); 
		query.append("         ,'LEVEL:' || DECODE(LVL, 1, 1, 2) ||';'  as row_properties " ).append("\n"); 
		query.append("     FROM (SELECT   NOD NOD_CD" ).append("\n"); 
		query.append("                   ,A2.ACT_GRP_CD" ).append("\n"); 
		query.append("                   ,A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                   ,(SELECT COST_ACT_GRP_NM FROM PRD_COST_ACT_GRP WHERE COST_ACT_GRP_CD = A2.ACT_GRP_CD) GRP" ).append("\n"); 
		query.append("                   ,A3.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                   ,A3.ACCT_DP_SEQ||A3.STND_COST_NM STND_COST_NM" ).append("\n"); 
		query.append("                   ,SUM(A2.RESPB_USD_TTL_AMT) AMT" ).append("\n"); 
		query.append("                   , A3.STND_COST_TP_CD || A3.MAS_COST_SRC_PRT_CD PR_CM" ).append("\n"); 
		query.append("                   ,MAX(A2.WTR_RCV_TERM_CD) WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                   ,MAX(A2.WTR_DE_TERM_CD) WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                   --,A2.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("                   --,A2.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                   ,GROUPING(A3.ACCT_DP_SEQ||A3.STND_COST_NM) LVL" ).append("\n"); 
		query.append("                   ,DECODE( MAX(ctrt_rtn_flg), 'Y', 'Y', 'N') AS Ctrt" ).append("\n"); 
		query.append("                   ,DECODE( MIN(ctrt_rtn_flg), 'N', 'Y', 'N') AS Avg" ).append("\n"); 
		query.append("               FROM PRI_PRS_USD_ROUT_ACT_COST A2" ).append("\n"); 
		query.append("                   ,MAS_STND_ACCT_V A3               " ).append("\n"); 
		query.append("                   ,(SELECT DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                                    ,ACT_GRP_CD" ).append("\n"); 
		query.append("                                    ,N1ST_NOD_CD ORG_NOD_CD" ).append("\n"); 
		query.append("                                    ,COALESCE(N4TH_NOD_CD, N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD" ).append("\n"); 
		query.append("                                    ,DECODE(N1ST_NOD_CD" ).append("\n"); 
		query.append("                                           ,N2ND_NOD_CD, N1ST_NOD_CD" ).append("\n"); 
		query.append("                                           ,DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD)" ).append("\n"); 
		query.append("                                             || DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD)" ).append("\n"); 
		query.append("                                             || DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD)" ).append("\n"); 
		query.append("                                             || DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD)" ).append("\n"); 
		query.append("                                           ) NOD" ).append("\n"); 
		query.append("                                FROM PRI_PRS_USD_ROUT_ACT_COST" ).append("\n"); 
		query.append("                               WHERE ROUT_CS_NO = @[rout_cs_no]" ).append("\n"); 
		query.append("                                 AND ROUT_CS_SRC_DT = @[rout_cs_src_dt] ) A4" ).append("\n"); 
		query.append("              WHERE A2.ROUT_CS_NO = @[rout_cs_no]" ).append("\n"); 
		query.append("                AND A2.ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 
		query.append("          AND A2.RESPB_USD_TTL_AMT <> 0" ).append("\n"); 
		query.append("                AND A3.MAS_COST_SRC_PRT_CD IN( 'CO', 'RA') -- Office Profit " ).append("\n"); 
		query.append("                AND A3.STND_COST_TP_CD IN('C', DECODE(@[cost_tp], 'C', 'C', 'O')) -- CM = 'C', OP = 'O' " ).append("\n"); 
		query.append("                AND A2.STND_COST_CD = A3.STND_COST_CD" ).append("\n"); 
		query.append("                AND A2.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("           GROUP BY A2.ACT_GRP_CD" ).append("\n"); 
		query.append("                   ,NOD" ).append("\n"); 
		query.append("                   ,CUBE(A2.COST_ACT_GRP_SEQ, A3.SGRP_COST_CD_DESC, A3.ACCT_DP_SEQ||A3.STND_COST_NM)" ).append("\n"); 
		query.append("                   , A3.STND_COST_TP_CD || A3.MAS_COST_SRC_PRT_CD" ).append("\n"); 
		query.append("                   --,A2.WTR_RCV_TERM_CD, A2.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("    WHERE COST_ACT_GRP_SEQ IS NOT NULL" ).append("\n"); 
		query.append("      AND SGRP_COST_CD_DESC IS NOT NULL" ).append("\n"); 
		query.append("      AND lvl <> 1" ).append("\n"); 
		query.append(" ORDER BY COST_ACT_GRP_SEQ, SGRP_COST_CD_DESC, LVL, STND_COST_NM" ).append("\n"); 

	}
}