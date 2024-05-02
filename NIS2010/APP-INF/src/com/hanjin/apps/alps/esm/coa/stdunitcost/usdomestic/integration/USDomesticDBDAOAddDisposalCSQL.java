/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddDisposalCSQL.java
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

public class USDomesticDBDAOAddDisposalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 4.2 EQ Off-hire 데이터 생성 (Disposal)
	  * </pre>
	  */
	public USDomesticDBDAOAddDisposalCSQL(){
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
		query.append("FileName : USDomesticDBDAOAddDisposalCSQL").append("\n"); 
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
		query.append("-- DISPOSAL" ).append("\n"); 
		query.append("MERGE INTO COA_USA_DMST_UT_COST A1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         SELECT REPLACE(@[f_cost_yrmon], '-', '' ) AS COST_YRMON" ).append("\n"); 
		query.append("              , C.ECC_CD        AS ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("              , 'E'             AS COST_LOC_GRP_CD" ).append("\n"); 
		query.append("              , A.EQ_TPSZ_CD    AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , SUM(A.DISP_QTY) AS DISP_QTY" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                         SELECT B.DISP_SOLD_DT AS APRO_DT" ).append("\n"); 
		query.append("                              , DECODE(B.EQ_TPSZ_CD, 'D2', 'D2', 'D4', 'D4', 'D5', 'D5', 'D7', 'D7', 'OT') EQ_TPSZ_CD" ).append("\n"); 
		query.append("                              , B.DISP_QTY" ).append("\n"); 
		query.append("                              , B.DISP_YD_CD" ).append("\n"); 
		query.append("                           FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append("                              , MNR_DISP_DTL B" ).append("\n"); 
		query.append("                          WHERE A.DISP_NO       = B.DISP_NO" ).append("\n"); 
		query.append("                            AND B.DISP_SOLD_DT IS NOT NULL" ).append("\n"); 
		query.append("                            AND B.DISP_SOLD_DT BETWEEN TO_DATE (REPLACE(@[f_cre_start_dt], '-', '' )||'01', 'rrrrmmdd') AND LAST_DAY(TO_DATE(REPLACE(@[f_cre_end_dt], '-', ''), 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                            AND A.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                         SELECT A.LOC_CD" ).append("\n"); 
		query.append("                              , A.RGN_CD" ).append("\n"); 
		query.append("                              , A.SCC_CD" ).append("\n"); 
		query.append("                              , A.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("                              , C.LCC_CD" ).append("\n"); 
		query.append("                              , C.ECC_CD" ).append("\n"); 
		query.append("                              , C.RCC_CD" ).append("\n"); 
		query.append("                           FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                              , MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("                          WHERE A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("                            AND C.RCC_CD = 'USNYC'" ).append("\n"); 
		query.append("                            AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND C.LCC_CD IN ('USSFO', 'USPDX', 'USNYC', 'USSEA', 'CAVAN','USHOU', 'CATOR', 'USLGB', 'USATL', 'USCHI')" ).append("\n"); 
		query.append("                ) C" ).append("\n"); 
		query.append("          WHERE SUBSTR(A.DISP_YD_CD, 1, 5) = C.LOC_CD" ).append("\n"); 
		query.append("            AND A.EQ_TPSZ_CD <> 'OT'" ).append("\n"); 
		query.append("        GROUP BY C.ECC_CD" ).append("\n"); 
		query.append("              , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(") B1 ON ( A1.COST_YRMON = B1.COST_YRMON AND A1.ORG_RAIL_LOC_CD = B1.ORG_RAIL_LOC_CD AND A1.CNTR_TPSZ_CD = B1.CNTR_TPSZ_CD AND A1.COST_LOC_GRP_CD = B1.COST_LOC_GRP_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.DISP_QTY         = B1.DISP_QTY" ).append("\n"); 
		query.append("          , A1.UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("          , A1.UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("          A1.COST_YRMON" ).append("\n"); 
		query.append("        , A1.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("        , A1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("        , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , A1.DISP_QTY" ).append("\n"); 
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
		query.append("        , B1.DISP_QTY" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}