/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddLeaseOutCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.12.07 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddLeaseOutCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 4.1 EQ Off-hire 데이터 생성 (Sub lease out , CN Domestic)
	  * </pre>
	  */
	public USDomesticDBDAOAddLeaseOutCSQL(){
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
		query.append("FileName : USDomesticDBDAOAddLeaseOutCSQL").append("\n"); 
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
		query.append("--CN DOMESTIC|SUB LEASE OUT" ).append("\n"); 
		query.append(" -- 최종" ).append("\n"); 
		query.append("MERGE INTO COA_USA_DMST_UT_COST A1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("             SELECT COST_YRMON" ).append("\n"); 
		query.append("              , ECC_CD               AS ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("              , 'E'                  AS COST_LOC_GRP_CD" ).append("\n"); 
		query.append("              , CNTR_TPSZ_CD         AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , SUM(CND_DMST_QTY)    AS CND_DMST_QTY" ).append("\n"); 
		query.append("              , SUM(SUB_LSE_OUT_QTY) AS SUB_LSE_OUT_QTY" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                         SELECT  REPLACE(@[f_cost_yrmon], '-', '' ) AS COST_YRMON" ).append("\n"); 
		query.append("                              , B.ECC_CD" ).append("\n"); 
		query.append("                              , B.SCC_CD" ).append("\n"); 
		query.append("                              , C.VNDR_SEQ" ).append("\n"); 
		query.append("                              , SUBSTR(NVL(D.VNDR_ABBR_NM, D.VNDR_SEQ), 0, 8) AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("                              , A.LSTM_CD" ).append("\n"); 
		query.append("                              , DECODE(A.CNTR_TPSZ_CD,'D2','D2', 'D4','D4', 'D5','D5', 'D7','D7', 'OT') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              , DECODE(C.VNDR_SEQ, '105475', COUNT(B.CNTR_NO), 0) CND_DMST_QTY" ).append("\n"); 
		query.append("                              , DECODE(C.VNDR_SEQ, '105475', 0, COUNT(B.CNTR_NO)) SUB_LSE_OUT_QTY" ).append("\n"); 
		query.append("                           FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                              , MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                              , LSE_AGREEMENT C" ).append("\n"); 
		query.append("                              , MDM_VENDOR D" ).append("\n"); 
		query.append("                              , (" ).append("\n"); 
		query.append("                                  SELECT DISTINCT ECC_CD" ).append("\n"); 
		query.append("                                        FROM COA_LOCATION_V" ).append("\n"); 
		query.append("                                        WHERE RCC_CD = 'USNYC'" ).append("\n"); 
		query.append("                                        AND LCC_CD IN ('USSFO', 'USPDX', 'USNYC', 'USSEA', 'CAVAN'" ).append("\n"); 
		query.append("                                                      ,'USHOU', 'CATOR', 'USLGB', 'USATL', 'USCHI')" ).append("\n"); 
		query.append("                              ) E" ).append("\n"); 
		query.append("                          WHERE A.CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("                            AND B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("                            AND B.AGMT_SEQ    = C.AGMT_SEQ" ).append("\n"); 
		query.append("                            AND C.VNDR_SEQ    = D.VNDR_SEQ" ).append("\n"); 
		query.append("                            AND A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("                            --  AND A.LST_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                            AND B.CNTR_STS_CD = 'SBO' --SUB LEASE OUT" ).append("\n"); 
		query.append("                            AND B.RCC_CD      = 'USNYC'" ).append("\n"); 
		query.append("                            AND B.ECC_CD      = E.ECC_CD" ).append("\n"); 
		query.append("                                --   AND C.VNDR_SEQ = '105475' --CNRA20" ).append("\n"); 
		query.append("                            AND B.CNTR_STS_EVNT_DT BETWEEN TO_DATE (REPLACE(@[f_cre_start_dt], '-', '' )||'01', 'rrrrmmdd') AND LAST_DAY(TO_DATE(REPLACE(@[f_cre_end_dt], '-', ''), 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                       GROUP BY @[f_cost_yrmon]" ).append("\n"); 
		query.append("                              , B.ECC_CD" ).append("\n"); 
		query.append("                              , B.SCC_CD" ).append("\n"); 
		query.append("                              , C.VNDR_SEQ" ).append("\n"); 
		query.append("                              , SUBSTR(NVL(D.VNDR_ABBR_NM, D.VNDR_SEQ), 0, 8)" ).append("\n"); 
		query.append("                              , A.LSTM_CD" ).append("\n"); 
		query.append("                              , DECODE(A.CNTR_TPSZ_CD,'D2','D2', 'D4','D4', 'D5','D5', 'D7','D7', 'OT')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE CNTR_TPSZ_CD <> 'OT'" ).append("\n"); 
		query.append("        GROUP BY COST_YRMON" ).append("\n"); 
		query.append("              , ECC_CD" ).append("\n"); 
		query.append("              , CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") B1 ON ( A1.COST_YRMON = B1.COST_YRMON AND A1.ORG_RAIL_LOC_CD = B1.ORG_RAIL_LOC_CD AND A1.CNTR_TPSZ_CD = B1.CNTR_TPSZ_CD AND A1.COST_LOC_GRP_CD = B1.COST_LOC_GRP_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.CND_DMST_QTY    = B1.CND_DMST_QTY" ).append("\n"); 
		query.append("          , A1.SUB_LSE_OUT_QTY = B1.SUB_LSE_OUT_QTY" ).append("\n"); 
		query.append("          , A1.UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("          , A1.UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("          A1.COST_YRMON" ).append("\n"); 
		query.append("        , A1.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("        , A1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("        , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , A1.CND_DMST_QTY" ).append("\n"); 
		query.append("        , A1.SUB_LSE_OUT_QTY " ).append("\n"); 
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
		query.append("        , B1.CND_DMST_QTY" ).append("\n"); 
		query.append("        , B1.SUB_LSE_OUT_QTY " ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}