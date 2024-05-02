/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostSetUpDBDAOCreateMtyRepoTESTRSCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.01.13 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOCreateMtyRepoTESTRSCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CostSetUpDBDAOCreateMtyRepoTESTRSCostCSQL
	  * </pre>
	  */
	public CostSetUpDBDAOCreateMtyRepoTESTRSCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOCreateMtyRepoTESTRSCostCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_MTY_REPO_COST_DTL A USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , SUM(DECODE(INV_SYS_ID,'TES', COST_AMT)) MTY_TML_IF_AMT" ).append("\n"); 
		query.append("      , SUM(DECODE(INV_SYS_ID,'TRS', COST_AMT)) MTY_TRSP_IF_AMT" ).append("\n"); 
		query.append("      , SUM(DECODE(INV_SYS_ID,'TES_CRE_BSE', COST_AMT)) MTY_TML_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("      , SUM(DECODE(INV_SYS_ID,'TRS_CRE_BSE', COST_AMT)) MTY_TRSP_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("         SELECT COST_YRMON" ).append("\n"); 
		query.append("              , COST_WK" ).append("\n"); 
		query.append("              , INV_SYS_ID" ).append("\n"); 
		query.append("              , COST_AMT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                 SELECT L.EXE_YRMON COST_YRMON" ).append("\n"); 
		query.append("                      , TO_CHAR(L.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("                      , @[cost_wk] AS COST_WK" ).append("\n"); 
		query.append("                      , L.INV_SYS_ID" ).append("\n"); 
		query.append("                      , L.LOCL_CURR_CD" ).append("\n"); 
		query.append("                      , L.LOCL_COST_AMT" ).append("\n"); 
		query.append("                      , (L.LOCL_COST_AMT / DECODE (L.LOCL_CURR_CD, 'USD', 1, NVL (G.USD_LOCL_XCH_RT, 0))) COST_AMT" ).append("\n"); 
		query.append("                   FROM LEA_ACT_COST_IF L" ).append("\n"); 
		query.append("                      , GL_MON_XCH_RT G" ).append("\n"); 
		query.append("                      , (" ).append("\n"); 
		query.append("                                 SELECT TO_DATE(SLS_FM_DT, 'yyyymmdd') START_DT" ).append("\n"); 
		query.append("                                      , TO_DATE(SLS_TO_DT, 'yyyymmdd') END_DT" ).append("\n"); 
		query.append("                                   FROM COA_WK_PRD" ).append("\n"); 
		query.append("                                  WHERE COST_YR = SUBSTR(@[cost_yrmon], 1, 4)" ).append("\n"); 
		query.append("                                    AND COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                        ) C" ).append("\n"); 
		query.append("                  WHERE 1                      =1" ).append("\n"); 
		query.append("                    AND L.LOCL_CURR_CD         = G.CURR_CD" ).append("\n"); 
		query.append("                    AND G.ACCT_XCH_RT_LVL(+)   = '1'" ).append("\n"); 
		query.append("                    AND G.ACCT_XCH_RT_YRMON(+) = L.EXE_YRMON" ).append("\n"); 
		query.append("                    AND L.EXE_YRMON            = @[cost_yrmon]" ).append("\n"); 
		query.append("                    AND L.GL_DT LIKE @[cost_yrmon]||'%'" ).append("\n"); 
		query.append("                    AND L.CRE_DT BETWEEN C.START_DT AND C.END_DT + 0.99999" ).append("\n"); 
		query.append("                    AND L.INV_SYS_ID       = 'TES'" ).append("\n"); 
		query.append("                    AND L.VSL_CD           = 'CNTC'" ).append("\n"); 
		query.append("                    AND L.SKD_VOY_NO       = SUBSTR(@[cost_yrmon], 3, 4)" ).append("\n"); 
		query.append("                    AND L.SKD_DIR_CD       = 'M'" ).append("\n"); 
		query.append("                    AND L.REV_DIR_CD       = 'M'" ).append("\n"); 
		query.append("                    AND L.COA_COST_SRC_CD IN ( 'CGCUMT', 'SRFDMT', 'SRNDMT', 'SVALMT', 'SVLDMT', 'SVLDTM', 'SVSSMT', 'SVSSTM', 'SVWFMT', 'TMFDMT', 'TMFDXM', 'TMNDMT', 'TMNDRM'" ).append("\n"); 
		query.append("                        , 'TMNDXM', 'TPNDMT', 'TPNDTM' )" ).append("\n"); 
		query.append("               ORDER BY L.CRE_DT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("         SELECT COST_YRMON" ).append("\n"); 
		query.append("              , COST_WK" ).append("\n"); 
		query.append("              , INV_SYS_ID" ).append("\n"); 
		query.append("              , COST_AMT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                 SELECT A.EXE_YRMON COST_YRMON" ).append("\n"); 
		query.append("                      , @[cost_wk] AS COST_WK" ).append("\n"); 
		query.append("                      , A.INV_SYS_ID" ).append("\n"); 
		query.append("                      , (A.LOCL_COST_AMT / DECODE (A.LOCL_CURR_CD, 'USD', 1, NVL (G.USD_LOCL_XCH_RT, 0))) COST_AMT" ).append("\n"); 
		query.append("                   FROM LEA_ACT_COST_IF A" ).append("\n"); 
		query.append("                      , GL_MON_XCH_RT G" ).append("\n"); 
		query.append("                      , (" ).append("\n"); 
		query.append("                                 SELECT TO_DATE(SLS_FM_DT, 'yyyymmdd') START_DT" ).append("\n"); 
		query.append("                                      , TO_DATE(SLS_TO_DT, 'yyyymmdd') END_DT" ).append("\n"); 
		query.append("                                   FROM COA_WK_PRD" ).append("\n"); 
		query.append("                                  WHERE COST_YR = SUBSTR(@[cost_yrmon], 1, 4)" ).append("\n"); 
		query.append("                                    AND COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                        ) C" ).append("\n"); 
		query.append("                  WHERE A.INV_SYS_ID       = 'TRS'" ).append("\n"); 
		query.append("                    AND A.VSL_CD           = 'CNTC'" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO       = SUBSTR(@[cost_yrmon], 3, 4)" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD       = 'M'" ).append("\n"); 
		query.append("                    AND A.REV_DIR_CD       = 'M'" ).append("\n"); 
		query.append("                    AND A.COA_COST_SRC_CD IN" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                                 SELECT COA_COST_SRC_CD" ).append("\n"); 
		query.append("                                   FROM LEA_LGS_COST" ).append("\n"); 
		query.append("                                  WHERE SUB_COST_TP_CD IN ('TRMT', 'TMMT', 'TMMY', 'TMMS')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    AND A.EXE_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                    AND A.CRE_DT BETWEEN C.START_DT AND C.END_DT + 0.99999" ).append("\n"); 
		query.append("                    AND A.LOCL_CURR_CD         = G.CURR_CD" ).append("\n"); 
		query.append("                    AND G.ACCT_XCH_RT_LVL(+)   = '1'" ).append("\n"); 
		query.append("                    AND G.ACCT_XCH_RT_YRMON(+) = A.EXE_YRMON" ).append("\n"); 
		query.append("               ORDER BY A.CRE_DT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("--  MTY_TML_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("         SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("              , @[cost_wk] COST_WK" ).append("\n"); 
		query.append("              , 'TES_CRE_BSE' AS INV_SYS_ID" ).append("\n"); 
		query.append("              , ROUND(SUM(D.INV_AMT/G.USD_LOCL_XCH_RT), 2) COST_AMT  " ).append("\n"); 
		query.append("           FROM AP_INV_HDR A" ).append("\n"); 
		query.append("              , AP_INV_DTRB D" ).append("\n"); 
		query.append("              , GL_MON_XCH_RT G" ).append("\n"); 
		query.append("              , TES_TML_SO_HDR H      " ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                         SELECT TO_DATE(SLS_FM_DT, 'yyyymmdd') START_DT" ).append("\n"); 
		query.append("                              , TO_DATE(SLS_TO_DT, 'yyyymmdd') END_DT" ).append("\n"); 
		query.append("                           FROM COA_WK_PRD" ).append("\n"); 
		query.append("                          WHERE COST_YR = SUBSTR(@[sls_fm_dt], 1, 4)" ).append("\n"); 
		query.append("                            AND COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                ) C        " ).append("\n"); 
		query.append("          WHERE A.SRC_CTNT               = 'SO_TERMINAL'   " ).append("\n"); 
		query.append("            AND H.CRE_DT BETWEEN C.START_DT AND C.END_DT  + 0.99999" ).append("\n"); 
		query.append("            AND LENGTH(A.GL_DT) = 8" ).append("\n"); 
		query.append("            AND A.GL_DT LIKE @[cost_yrmon] ||'%'" ).append("\n"); 
		query.append("            AND A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("            AND D.FTU_USE_CTNT1 IN (" ).append("\n"); 
		query.append("                                         SELECT COA_COST_SRC_CD" ).append("\n"); 
		query.append("                                           FROM LEA_LGS_COST" ).append("\n"); 
		query.append("                                          WHERE SUB_COST_TP_CD IN ('TRMT', 'TMMT', 'TMMY', 'TMMS','TRDM','TMDM'))" ).append("\n"); 
		query.append("            AND G.ACCT_XCH_RT_LVL               = 1" ).append("\n"); 
		query.append("            AND A.CSR_CURR_CD                   = G.CURR_CD" ).append("\n"); 
		query.append("            AND G.ACCT_XCH_RT_YRMON             = SUBSTR(A.GL_DT, 1, 6)" ).append("\n"); 
		query.append("            AND D.ATTR_CTNT1                    = H.INV_NO" ).append("\n"); 
		query.append("            AND A.VNDR_NO                       = H.VNDR_SEQ" ).append("\n"); 
		query.append("            AND NVL(H.DELT_FLG,'N') = 'N'     " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("-- MTY_TRSP_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("         SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("              , @[cost_wk] COST_WK" ).append("\n"); 
		query.append("              , 'TRS_CRE_BSE' AS INV_SYS_ID" ).append("\n"); 
		query.append("              , SUM(USD_INV_AMT) COST_AMT" ).append("\n"); 
		query.append("          FROM (     " ).append("\n"); 
		query.append("                 SELECT ROUND(SUM(A.INV_BZC_AMT/G.USD_LOCL_XCH_RT), 2) USD_INV_AMT  " ).append("\n"); 
		query.append("                   FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("                      , TRS_TRSP_INV_WRK B" ).append("\n"); 
		query.append("                      , GL_MON_XCH_RT G       " ).append("\n"); 
		query.append("                      , (" ).append("\n"); 
		query.append("                                 SELECT TO_DATE(SLS_FM_DT, 'yyyymmdd') START_DT" ).append("\n"); 
		query.append("                                      , TO_DATE(SLS_TO_DT, 'yyyymmdd') END_DT" ).append("\n"); 
		query.append("                                   FROM COA_WK_PRD" ).append("\n"); 
		query.append("                                  WHERE COST_YR = SUBSTR(@[sls_fm_dt], 1, 4)" ).append("\n"); 
		query.append("                                    AND COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                        ) W        " ).append("\n"); 
		query.append("                  WHERE 1               =1" ).append("\n"); 
		query.append("                    AND A.INV_NO        = B.INV_NO" ).append("\n"); 
		query.append("                    AND A.INV_VNDR_SEQ  = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                    AND A.TRSP_SO_TP_CD = 'M'" ).append("\n"); 
		query.append("                    AND B.CRE_DT BETWEEN W.START_DT AND W.END_DT  + 0.99999  " ).append("\n"); 
		query.append("                    AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                    AND A.LGS_COST_CD IN (                            " ).append("\n"); 
		query.append("                         SELECT COA_COST_SRC_CD" ).append("\n"); 
		query.append("                           FROM LEA_LGS_COST" ).append("\n"); 
		query.append("                          WHERE SUB_COST_TP_CD IN ('TRMT', 'TMMT', 'TMMY', 'TMMS','TRDM','TMDM')" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    AND B.GL_DT LIKE @[cost_yrmon]||'%'" ).append("\n"); 
		query.append("                    AND A.INV_NO  IS NOT NULL               " ).append("\n"); 
		query.append("                    AND G.ACCT_XCH_RT_LVL               = 1" ).append("\n"); 
		query.append("                    AND B.INV_CURR_CD                   = G.CURR_CD" ).append("\n"); 
		query.append("                    AND G.ACCT_XCH_RT_YRMON             = TO_CHAR (TO_DATE(B.GL_DT, 'YYYYMMDD'), 'RRRRMM')" ).append("\n"); 
		query.append("                 )   " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("         UNION ALL   " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("-- MTY_TRSP_CRE_BSE_IF_AMT 미주 RAIL     " ).append("\n"); 
		query.append("         SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("              , @[cost_wk] COST_WK" ).append("\n"); 
		query.append("              , 'TRS_CRE_BSE' AS INV_SYS_ID" ).append("\n"); 
		query.append("              , ROUND(SUM(B.INV_BZC_AMT/G.USD_LOCL_XCH_RT), 2) COST_AMT  " ).append("\n"); 
		query.append("           FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("              , TRS_TRSP_RAIL_BIL_VNDR_SET B" ).append("\n"); 
		query.append("              , TRS_TRSP_RAIL_INV_WRK C" ).append("\n"); 
		query.append("              , GL_MON_XCH_RT G " ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                         SELECT TO_DATE(SLS_FM_DT, 'yyyymmdd') START_DT" ).append("\n"); 
		query.append("                              , TO_DATE(SLS_TO_DT, 'yyyymmdd') END_DT" ).append("\n"); 
		query.append("                           FROM COA_WK_PRD" ).append("\n"); 
		query.append("                          WHERE COST_YR = SUBSTR(@[sls_fm_dt], 1, 4)" ).append("\n"); 
		query.append("                            AND COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                ) W        " ).append("\n"); 
		query.append("          WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND A.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("            AND B.INV_NO             = C.INV_NO" ).append("\n"); 
		query.append("            AND B.INV_VNDR_SEQ       = C.INV_VNDR_SEQ" ).append("\n"); 
		query.append("            AND A.CGO_TP_CD          = 'M'" ).append("\n"); 
		query.append("            AND C.CRE_DT BETWEEN W.START_DT AND W.END_DT  + 0.99999  " ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("            AND B.INV_NO  IS NOT NULL" ).append("\n"); 
		query.append("            AND C.GL_DT LIKE @[cost_yrmon]||'%'               " ).append("\n"); 
		query.append("            AND G.ACCT_XCH_RT_LVL               = 1" ).append("\n"); 
		query.append("            AND C.INV_CURR_CD                   = G.CURR_CD" ).append("\n"); 
		query.append("            AND G.ACCT_XCH_RT_YRMON             =  TO_CHAR (TO_DATE(C.GL_DT, 'YYYYMMDD'), 'RRRRMM')" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    GROUP BY COST_YRMON, COST_WK" ).append("\n"); 
		query.append(") B " ).append("\n"); 
		query.append("ON ( A.COST_YRMON = B.COST_YRMON AND A.COST_WK = B.COST_WK )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A.MTY_TML_IF_AMT    = B.MTY_TML_IF_AMT" ).append("\n"); 
		query.append("          , A.MTY_TRSP_IF_AMT   = B.MTY_TRSP_IF_AMT" ).append("\n"); 
		query.append("          , A.MTY_TML_CRE_BSE_IF_AMT    = B.MTY_TML_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("          , A.MTY_TRSP_CRE_BSE_IF_AMT   = B.MTY_TRSP_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("          , A.UPD_USR_ID        = @[user_id]" ).append("\n"); 
		query.append("          , A.UPD_DT            = SYSDATE " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                A.COST_YRMON" ).append("\n"); 
		query.append("              , A.COST_WK" ).append("\n"); 
		query.append("              , A.MTY_TML_IF_AMT" ).append("\n"); 
		query.append("              , A.MTY_TRSP_IF_AMT " ).append("\n"); 
		query.append("              , A.APLY_ADJ_PL_FLG" ).append("\n"); 
		query.append("              , A.MTY_TML_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("              , A.MTY_TRSP_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("              , A.CRE_USR_ID" ).append("\n"); 
		query.append("              , A.CRE_DT" ).append("\n"); 
		query.append("              , A.UPD_USR_ID" ).append("\n"); 
		query.append("              , A.UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        VALUES" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                B.COST_YRMON" ).append("\n"); 
		query.append("              , B.COST_WK" ).append("\n"); 
		query.append("              , B.MTY_TML_IF_AMT" ).append("\n"); 
		query.append("              , B.MTY_TRSP_IF_AMT " ).append("\n"); 
		query.append("              , 'N'" ).append("\n"); 
		query.append("              , B.MTY_TML_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("              , B.MTY_TRSP_CRE_BSE_IF_AMT             " ).append("\n"); 
		query.append("              , @[user_id]" ).append("\n"); 
		query.append("              , SYSDATE" ).append("\n"); 
		query.append("              , @[user_id]" ).append("\n"); 
		query.append("              , SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}