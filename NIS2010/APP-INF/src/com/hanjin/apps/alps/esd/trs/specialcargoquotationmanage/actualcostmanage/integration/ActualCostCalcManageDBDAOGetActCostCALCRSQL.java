/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ActualCostCalcManageDBDAOGetActCostCALCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCalcManageDBDAOGetActCostCALCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * actual cost calc
	  * </pre>
	  */
	public ActualCostCalcManageDBDAOGetActCostCALCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cost_trf_tp_shuttle",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCalcManageDBDAOGetActCostCALCRSQL").append("\n"); 
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
		query.append("X.FM_NOD_CD FM_YD_CD" ).append("\n"); 
		query.append(", X.TO_NOD_CD TO_YD_CD" ).append("\n"); 
		query.append(", @[act_cost_trf_tp_shuttle] TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", X.IN_OUT_GAUAGE IO_GA_CD" ).append("\n"); 
		query.append(", X.TRSP_CRR_MOD_CD TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", X.FT20 ACTUAL_2OFT_AMT" ).append("\n"); 
		query.append(", X.FT40 ACTUAL_4OFT_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT (SELECT TO_CHAR(SYSDATE, 'YYYYMM') FROM DUAL) YEAR_MONTH" ).append("\n"); 
		query.append("              ,FM_NOD_CD" ).append("\n"); 
		query.append("              ,TO_NOD_CD" ).append("\n"); 
		query.append("              ,IN_OUT_GAUAGE" ).append("\n"); 
		query.append("              ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("              ,'USD' CURR" ).append("\n"); 
		query.append("              ,CASE WHEN SUM(DECODE(SUBSTR(EQ_TPSZ_CD, 2, 1), '2', 1, 0))=0 THEN 0" ).append("\n"); 
		query.append("                                                                            ELSE ROUND(SUM(DECODE(SUBSTR(EQ_TPSZ_CD, 2, 1), '2', USD_AMT, 0))/SUM(DECODE(SUBSTR(EQ_TPSZ_CD, 2, 1), '2', 1, 0)),2) " ).append("\n"); 
		query.append("                    END FT20" ).append("\n"); 
		query.append("              ,CASE WHEN SUM(DECODE(SUBSTR(EQ_TPSZ_CD, 2, 1), '2', 0, 1))=0 THEN 0" ).append("\n"); 
		query.append("                                                                            ELSE ROUND(SUM(DECODE(SUBSTR(EQ_TPSZ_CD, 2, 1), '2', 0, USD_AMT))/SUM(DECODE(SUBSTR(EQ_TPSZ_CD, 2, 1), '2', 0, 1)),2) " ).append("\n"); 
		query.append("                    END FT40" ).append("\n"); 
		query.append("              ,'SYSTEM'" ).append("\n"); 
		query.append("              ,SYSDATE" ).append("\n"); 
		query.append("              ,'SYSTEM'" ).append("\n"); 
		query.append("              ,SYSDATE " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT A.FM_NOD_CD" ).append("\n"); 
		query.append("                  ,A.TO_NOD_CD" ).append("\n"); 
		query.append("                  ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                  ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                  ,DECODE(C.IN_GA_FLG, 'Y' ,'I', 'N', 'O')  IN_OUT_GAUAGE" ).append("\n"); 
		query.append("                  ,A.INV_CURR_CD" ).append("\n"); 
		query.append("                  ,A.INV_BZC_AMT" ).append("\n"); 
		query.append("                  ,A.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append("                  ,ROUND((NVL(A.INV_BZC_AMT,0)+NVL(A.INV_ETC_ADD_AMT,0)) / B.USD_LOCL_XCH_RT, 2) USD_AMT " ).append("\n"); 
		query.append("                  ,B.USD_LOCL_XCH_RT     " ).append("\n"); 
		query.append("                  ,TO_CHAR(A.INV_CFM_DT, 'YYYYMM') INV_CFM_YR" ).append("\n"); 
		query.append("                  ,A.BKG_NO" ).append("\n"); 
		query.append("                  ,A.EQ_NO" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (      " ).append("\n"); 
		query.append("                -- FROM YARD-TO YARD동일 LOC (Shuttle, Truck)" ).append("\n"); 
		query.append("                SELECT /*+ ORDERED USE_NL(B) INDEX(B XAK6TRS_TRSP_INV_WRK) */ A.BKG_NO" ).append("\n"); 
		query.append("                      ,A.EQ_NO" ).append("\n"); 
		query.append("                      ,A.CGO_TP_CD" ).append("\n"); 
		query.append("                      ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                      ,A.FM_NOD_CD" ).append("\n"); 
		query.append("                      ,A.TO_NOD_CD" ).append("\n"); 
		query.append("                      ,A.INV_CURR_CD" ).append("\n"); 
		query.append("                      ,A.INV_BZC_AMT" ).append("\n"); 
		query.append("                      ,A.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append("                      ,C.AWK_CGO_FLG" ).append("\n"); 
		query.append("                      ,B.INV_CFM_DT" ).append("\n"); 
		query.append("                      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                      ,A.TRSP_BND_CD" ).append("\n"); 
		query.append("                FROM TRS_TRSP_INV_WRK B " ).append("\n"); 
		query.append("                    ,TRS_TRSP_SVC_ORD A    " ).append("\n"); 
		query.append("                    ,BKG_BOOKING C " ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("--                AND   B.INV_CFM_DT BETWEEN TO_DATE(:fm_dt, 'YYYYMMDD') AND TO_DATE(:to_dt, 'YYYYMMDD') -- FROM DATE, TO DATE" ).append("\n"); 
		query.append("                AND   B.INV_CFM_DT BETWEEN SYSDATE-(3*30+365) AND SYSDATE-(3*30) -- FROM DATE, TO DATE" ).append("\n"); 
		query.append("                AND   B.TRSP_INV_AUD_STS_CD = 'PD'" ).append("\n"); 
		query.append("                AND   B.INV_NO       = A.INV_NO" ).append("\n"); 
		query.append("                AND   B.INV_VNDR_SEQ = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                AND   A.TRSP_CRR_MOD_CD IN ('WD', 'TD')" ).append("\n"); 
		query.append("                AND   A.CGO_TP_CD = 'F'  -- FULL CARGO" ).append("\n"); 
		query.append("                AND   A.TRSP_COST_DTL_MOD_CD IN ('TS', 'LS') -- SHUTTLE 만 대상" ).append("\n"); 
		query.append("                AND   A.EQ_KND_CD = 'U'  -- CONTAINER TYPE" ).append("\n"); 
		query.append("                AND   A.DELT_FLG  = 'N'  -- 삭제 제외  " ).append("\n"); 
		query.append("                AND   A.EQ_TPSZ_CD IN ('F2','F4','F5','A4','O2','O4','O5','O7','S2','S4')" ).append("\n"); 
		query.append("                AND   SUBSTR(A.FM_NOD_CD,0,5) = SUBSTR(A.TO_NOD_CD,0,5)" ).append("\n"); 
		query.append("                AND   C.BKG_NO       = A.BKG_NO  " ).append("\n"); 
		query.append("                AND   C.AWK_CGO_FLG    = 'Y' -- BKG SPECIAL CARGO" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                -- EQUALIZATION PORT " ).append("\n"); 
		query.append("                SELECT /*+ ORDERED USE_NL(B) INDEX(B XAK6TRS_TRSP_INV_WRK) */ A.BKG_NO" ).append("\n"); 
		query.append("                      ,A.EQ_NO" ).append("\n"); 
		query.append("                      ,A.CGO_TP_CD" ).append("\n"); 
		query.append("                      ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                      ,A.FM_NOD_CD" ).append("\n"); 
		query.append("                      ,A.TO_NOD_CD" ).append("\n"); 
		query.append("                      ,A.INV_CURR_CD" ).append("\n"); 
		query.append("                      ,A.INV_BZC_AMT" ).append("\n"); 
		query.append("                      ,A.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append("                      ,C.AWK_CGO_FLG" ).append("\n"); 
		query.append("                      ,B.INV_CFM_DT" ).append("\n"); 
		query.append("                      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                      ,A.TRSP_BND_CD" ).append("\n"); 
		query.append("                FROM TRS_TRSP_INV_WRK B " ).append("\n"); 
		query.append("                    ,TRS_TRSP_SVC_ORD A    " ).append("\n"); 
		query.append("                    ,BKG_BOOKING C" ).append("\n"); 
		query.append("                    ,BKG_EQLZ_PORT D" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("--                AND   B.INV_CFM_DT BETWEEN TO_DATE(:fm_dt, 'YYYYMMDD') AND TO_DATE(:to_dt, 'YYYYMMDD') -- FROM DATE, TO DATE" ).append("\n"); 
		query.append("                AND   B.INV_CFM_DT BETWEEN SYSDATE-(3*30+365) AND SYSDATE-(3*30) -- FROM DATE, TO DATE" ).append("\n"); 
		query.append("                AND   B.TRSP_INV_AUD_STS_CD = 'PD'" ).append("\n"); 
		query.append("                AND   B.INV_NO       = A.INV_NO" ).append("\n"); 
		query.append("                AND   B.INV_VNDR_SEQ = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                AND   A.TRSP_CRR_MOD_CD IN ('WD', 'TD')" ).append("\n"); 
		query.append("                AND   A.CGO_TP_CD = 'F'  -- FULL CARGO" ).append("\n"); 
		query.append("                AND   A.TRSP_COST_DTL_MOD_CD IN ('TS', 'LS') -- SHUTTLE 만 대상" ).append("\n"); 
		query.append("                AND   A.EQ_KND_CD = 'U'  -- CONTAINER TYPE" ).append("\n"); 
		query.append("                AND   A.DELT_FLG  = 'N'  -- 삭제 제외  " ).append("\n"); 
		query.append("                AND   A.EQ_TPSZ_CD IN ('F2','F4','F5','A4','O2','O4','O5','O7','S2','S4')" ).append("\n"); 
		query.append("                AND   SUBSTR(A.FM_NOD_CD,0,5) <> SUBSTR(A.TO_NOD_CD,0,5)" ).append("\n"); 
		query.append("                AND   (( SUBSTR(A.FM_NOD_CD,0,5) = D.LOC_CD AND SUBSTR(A.TO_NOD_CD,0,5) = D.EQLZ_PORT_CD ) OR  ( SUBSTR(A.FM_NOD_CD,0,5) = D.EQLZ_PORT_CD AND SUBSTR(A.TO_NOD_CD,0,5) = D.LOC_CD ))" ).append("\n"); 
		query.append("                AND   C.BKG_NO       = A.BKG_NO  " ).append("\n"); 
		query.append("                AND   C.AWK_CGO_FLG    = 'Y' -- BKG SPECIAL CARGO" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("            ,GL_MON_XCH_RT B" ).append("\n"); 
		query.append("            ,BKG_AWK_CGO C" ).append("\n"); 
		query.append("            WHERE B.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("            AND   TO_CHAR(A.INV_CFM_DT, 'YYYYMM') = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("            AND   A.INV_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("            AND   A.BKG_NO  = C.BKG_NO" ).append("\n"); 
		query.append("            AND   A.EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY FM_NOD_CD" ).append("\n"); 
		query.append("                ,TO_NOD_CD" ).append("\n"); 
		query.append("                ,IN_OUT_GAUAGE" ).append("\n"); 
		query.append("                ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}