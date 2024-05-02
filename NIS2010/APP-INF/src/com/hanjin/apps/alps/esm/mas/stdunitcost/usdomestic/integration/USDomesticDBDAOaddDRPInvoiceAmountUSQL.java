/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : USDomesticDBDAOaddDRPInvoiceAmountUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOaddDRPInvoiceAmountUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Off-hire US Rail Invoice Amount 데이터 생성 (DRP cost)
	  * 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public USDomesticDBDAOaddDRPInvoiceAmountUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cre_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cre_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOaddDRPInvoiceAmountUSQL").append("\n"); 
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
		query.append("-- US Rail Invoice Amount" ).append("\n"); 
		query.append("-- 반드시 '4.1 EQ Off-hire 데이터 생성 (Sub lease out , CN Domestic)' 이 먼저 진행되어야한다." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MERGE INTO MAS_USA_DMST_UT_COST A1 USING" ).append("\n"); 
		query.append("(     " ).append("\n"); 
		query.append("        WITH US_RAIL_INV AS (" ).append("\n"); 
		query.append("                 SELECT ROUND(SUM( NVL(B.INV_BZC_AMT, 0) / CASE WHEN B.INV_CURR_CD = 'USD' THEN 1 ELSE" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                         SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                                          WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                                            AND XCH.CURR_CD = B.INV_CURR_CD " ).append("\n"); 
		query.append("                                            AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(A.LOCL_CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                                ) END ),3) US_RAIL_INV_AMT" ).append("\n"); 
		query.append("                   FROM TRS_TRSP_RAIL_INV_WRK A" ).append("\n"); 
		query.append("                      , TRS_TRSP_RAIL_INV_DTL B" ).append("\n"); 
		query.append("                  WHERE A.INV_ISS_DT BETWEEN TO_DATE (REPLACE(@[f_cre_start_dt], '-', '' )||'01', 'rrrrmmdd') " ).append("\n"); 
		query.append("                                         AND LAST_DAY(TO_DATE(REPLACE(@[f_cre_end_dt], '-', ''), 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                    AND A.INV_VNDR_SEQ               = '105475'	-- CANADIAN NATIONAL" ).append("\n"); 
		query.append("                    AND A.CRE_OFC_CD                 = 'NYCRAO'" ).append("\n"); 
		query.append("                    AND A.INV_NO                     = B.INV_NO" ).append("\n"); 
		query.append("                    AND A.INV_VNDR_SEQ               = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                    AND B.CRNT_TRSP_RAIL_INV_AUD_CD IN ( 'C', 'I') -- Coincidence, Invoice Only" ).append("\n"); 
		query.append("                    AND B.DMST_REPO_FLG              = 'Y'         -- DRP checked" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         SELECT A.COST_YRMON" ).append("\n"); 
		query.append("              , A.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("              , A.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("              , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , ROUND((A.CND_DMST_QTY / A.CND_DMST_TOT) * B.US_RAIL_INV_AMT, 3) AS DMST_RAIL_INV_AMT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                         SELECT COST_YRMON" ).append("\n"); 
		query.append("                              , ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("                              , COST_LOC_GRP_CD" ).append("\n"); 
		query.append("                              , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , NVL(CND_DMST_QTY, 0) CND_DMST_QTY" ).append("\n"); 
		query.append("                              , SUM(CND_DMST_QTY) OVER (PARTITION BY COST_YRMON) CND_DMST_TOT" ).append("\n"); 
		query.append("                           FROM MAS_USA_DMST_UT_COST" ).append("\n"); 
		query.append("                          WHERE COST_YRMON      = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append("                            AND COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("                ) A, US_RAIL_INV B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") B1 ON ( A1.COST_YRMON = B1.COST_YRMON " ).append("\n"); 
		query.append("      AND A1.ORG_RAIL_LOC_CD 	= B1.ORG_RAIL_LOC_CD " ).append("\n"); 
		query.append("      AND A1.CNTR_TPSZ_CD 		= B1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      AND A1.COST_LOC_GRP_CD 	= B1.COST_LOC_GRP_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.DMST_RAIL_INV_AMT    = B1.DMST_RAIL_INV_AMT" ).append("\n"); 
		query.append("          , A1.UPD_USR_ID       	= @[upd_usr_id]" ).append("\n"); 
		query.append("          , A1.UPD_DT           	= SYSDATE" ).append("\n"); 

	}
}