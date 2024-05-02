/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USDomesticDBDAOAddUSDomesticTRPCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.08.05 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddUSDomesticTRPCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 3.1 Domestic TRP 데이터 생성
	  * 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public USDomesticDBDAOAddUSDomesticTRPCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOAddUSDomesticTRPCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_USA_DMST_UT_COST A1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT A.COST_YRMON" ).append("\n"); 
		query.append("      , A.EQ_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , A.LOC_CD                	AS ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("      , 'C'                   		AS COST_LOC_GRP_CD" ).append("\n"); 
		query.append("      , A.QTY                   	AS TRP_QTY" ).append("\n"); 
		query.append("      , A.INV_TOT_AMT_USD       	AS TRP_AMT" ).append("\n"); 
		query.append("      , A.INV_TOT_AMT_USD / A.QTY	AS TRP_UC_AMT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT COST_YRMON" ).append("\n"); 
		query.append("             , EQ_TPSZ_CD" ).append("\n"); 
		query.append("             , ECC_CD" ).append("\n"); 
		query.append("             , LOC_CD" ).append("\n"); 
		query.append("             , COUNT(EQ_NO) QTY" ).append("\n"); 
		query.append("             , SUM(INV_TOT_AMT_USD) INV_TOT_AMT_USD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                 SELECT REPLACE(@[f_cost_yrmon], '-', '' ) AS COST_YRMON" ).append("\n"); 
		query.append("                      , DECODE(SO.EQ_TPSZ_CD, 'D2', 'D2', 'D4', 'D4', 'D5', 'D5', 'D7', 'D7', 'OT') EQ_TPSZ_CD" ).append("\n"); 
		query.append("                      , COA_LOC_FNC(SO.FM_NOD_CD, 'ECC') ECC_CD" ).append("\n"); 
		query.append("                      , SUBSTR(SO.FM_NOD_CD, 1, 5) LOC_CD" ).append("\n"); 
		query.append("                      , SO.EQ_NO" ).append("\n"); 
		query.append("                      , ROUND ((NVL (SO.INV_BZC_AMT, 0) + NVL (SO.INV_ETC_ADD_AMT, 0)) / CASE WHEN SO.INV_CURR_CD = 'USD' THEN 1 WHEN SO.CURR_CD = 'USD' THEN 1 ELSE" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                 SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                   FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                                  WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                                    AND XCH.CURR_CD = NVL(SO.INV_CURR_CD, SO.CURR_CD) " ).append("\n"); 
		query.append("                                    AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(WRK.LOCL_CRE_DT, 'YYYYMM'), TO_CHAR(WO.LOCL_CRE_DT, 'YYYYMM'))" ).append("\n"); 
		query.append("                                ) END, 2) INV_TOT_AMT_USD" ).append("\n"); 
		query.append("                   FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                      , TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("                      , TRS_TRSP_INV_WRK WRK" ).append("\n"); 
		query.append("                      , TRS_TRSP_HJL_SVC_ORD HSO" ).append("\n"); 
		query.append("                  WHERE SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                    AND SO.TRSP_WO_SEQ        = WO.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("                    AND SO.INV_NO             = WRK.INV_NO(+)" ).append("\n"); 
		query.append("                    AND SO.INV_VNDR_SEQ       = WRK.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("                    AND SO.TRSP_SO_OFC_CTY_CD = HSO.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                    AND SO.TRSP_SO_SEQ        = HSO.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("                    AND SO.LOCL_CRE_DT BETWEEN TO_DATE (REPLACE(@[f_cre_start_dt], '-', '' )||'01', 'rrrrmmdd') AND LAST_DAY(TO_DATE(REPLACE(@[f_cre_end_dt], '-', ''), 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                    AND SO.CRE_OFC_CD IN" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                                 SELECT OFC_CD" ).append("\n"); 
		query.append("                                   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                  WHERE DELT_FLG                = 'N'" ).append("\n"); 
		query.append("                                CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                  START WITH OFC_CD             = 'NYCRA'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    AND SO.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("                    AND WO.WO_ISS_STS_CD       IN ( 'I', 'R', 'C')" ).append("\n"); 
		query.append("                    AND SO.TRSP_COST_DTL_MOD_CD = 'ER'" ).append("\n"); 
		query.append("                    AND SO.TRSP_CRR_MOD_CD      = 'RD'" ).append("\n"); 
		query.append("                    AND SO.TRSP_SO_TP_CD        = 'O'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          WHERE INV_TOT_AMT_USD > 100" ).append("\n"); 
		query.append("-- TRS에서 TRP 처리된 invoice 금액이 100불미만인 container들에 대해서는 제외" ).append("\n"); 
		query.append("       GROUP BY EQ_TPSZ_CD" ).append("\n"); 
		query.append("              , ECC_CD" ).append("\n"); 
		query.append("              , LOC_CD " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT DISTINCT ECC_CD" ).append("\n"); 
		query.append("                FROM COA_LOCATION_V" ).append("\n"); 
		query.append("                WHERE RCC_CD = 'USNYC'" ).append("\n"); 
		query.append("                AND LCC_CD IN ('USSFO', 'USPDX', 'USNYC', 'USSEA', 'CAVAN'" ).append("\n"); 
		query.append("                              ,'USHOU', 'CATOR', 'USLGB', 'USATL', 'USCHI')" ).append("\n"); 
		query.append("      ) E" ).append("\n"); 
		query.append("  WHERE A.ECC_CD = E.ECC_CD" ).append("\n"); 
		query.append(") B1 " ).append("\n"); 
		query.append("ON ( A1.COST_YRMON = B1.COST_YRMON AND A1.ORG_RAIL_LOC_CD = B1.ORG_RAIL_LOC_CD AND A1.CNTR_TPSZ_CD = B1.CNTR_TPSZ_CD AND A1.COST_LOC_GRP_CD = B1.COST_LOC_GRP_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("            SET A1.TRP_QTY    = B1.TRP_QTY" ).append("\n"); 
		query.append("              , A1.TRP_AMT    = B1.TRP_AMT" ).append("\n"); 
		query.append("              , A1.TRP_UC_AMT = B1.TRP_UC_AMT" ).append("\n"); 
		query.append("              , A1.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("              , A1.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("          A1.COST_YRMON" ).append("\n"); 
		query.append("        , A1.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("        , A1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("        , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , A1.TRP_QTY" ).append("\n"); 
		query.append("        , A1.TRP_AMT" ).append("\n"); 
		query.append("        , A1.TRP_UC_AMT" ).append("\n"); 
		query.append("        , A1.CRE_USR_ID" ).append("\n"); 
		query.append("        , A1.CRE_DT" ).append("\n"); 
		query.append("        , A1.UPD_USR_ID" ).append("\n"); 
		query.append("        , A1.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("          B1.COST_YRMON" ).append("\n"); 
		query.append("        , B1.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("        , B1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("        , B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , B1.TRP_QTY" ).append("\n"); 
		query.append("        , B1.TRP_AMT" ).append("\n"); 
		query.append("        , B1.TRP_UC_AMT" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}