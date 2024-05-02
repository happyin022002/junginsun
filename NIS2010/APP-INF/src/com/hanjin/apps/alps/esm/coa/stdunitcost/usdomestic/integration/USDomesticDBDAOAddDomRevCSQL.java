/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddDomRevCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddDomRevCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddDomRev
	  * </pre>
	  */
	public USDomesticDBDAOAddDomRevCSQL(){
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
		query.append("FileName : USDomesticDBDAOAddDomRevCSQL").append("\n"); 
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
		query.append("-- HJL Billing report 로부터 Rev. I/F-- " ).append("\n"); 
		query.append("INSERT INTO COA_USA_DMST_UT_COST" ).append("\n"); 
		query.append("      ( COST_YRMON" ).append("\n"); 
		query.append("      , ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("      , COST_LOC_GRP_CD " ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , DMST_VOL_QTY" ).append("\n"); 
		query.append("      , RAILG_AMT" ).append("\n"); 
		query.append("      , EQ_RNTL_SCG_AMT" ).append("\n"); 
		query.append("      , FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("      , DMST_TTL_FRT_REV_AMT" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("      ) " ).append("\n"); 
		query.append("SELECT REPLACE(@[f_cost_yrmon], '-', '')         AS COST_YRMON" ).append("\n"); 
		query.append("     , TT.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("     , 'C' --location level" ).append("\n"); 
		query.append("     , TT.CNTRTP2457" ).append("\n"); 
		query.append("     , COUNT(TT.INVNO)     AS VOL --VOLUME" ).append("\n"); 
		query.append("     , SUM(TT.GRATE)       AS RAILAGE  --RAILAGE" ).append("\n"); 
		query.append("     , SUM(TT.EQAMT)       AS EQAMT --EQ RENTAL" ).append("\n"); 
		query.append("     , SUM(TT.FSCAMT)      AS FSCAMT " ).append("\n"); 
		query.append("     , SUM(TT.HAZAMT)      AS HAZAMT" ).append("\n"); 
		query.append("     , SUM(TT.TAMT)        AS TAMT" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("  FROM ( SELECT /*+ ORDERED */0 AS CHK" ).append("\n"); 
		query.append("              , DB.ORG_RAIL_LOC_CD --ORG LOC          " ).append("\n"); 
		query.append("              , ID.INV_NO INVNO --INV NO" ).append("\n"); 
		query.append("              , NVL(ID.RAILG_RT_AMT, 0) IRATE --INVOICE RATE" ).append("\n"); 
		query.append("              , NVL(GR.RAILG_RT_AMT, 0) GRATE --RAILAGE" ).append("\n"); 
		query.append("              , NVL(EQ.SCG_AMT, 0) EQAMT --EQ RENTAL" ).append("\n"); 
		query.append("              , ROUND(DECODE(FS.DMST_SCG_TP_CD, 'P', (NVL(GR.RAILG_RT_AMT, 0) * DECODE(FS.SCG_AMT, 0, 100, FS.SCG_AMT))/100 , NVL(FS.SCG_AMT, 0)), 2) FSCAMT" ).append("\n"); 
		query.append("              , NVL(ID.HZD_MTRL_SCG_RT_AMT, 0) HAZAMT --HAZMAT" ).append("\n"); 
		query.append("              , DECODE(NVL(GR.RAILG_RT_AMT, 0), 0, 0, NVL(GR.RAILG_RT_AMT, 0) + NVL(EQ.SCG_AMT, 0) + NVL(ID.HZD_MTRL_SCG_RT_AMT, 0) + ROUND(DECODE(FS.DMST_SCG_TP_CD, 'P', (NVL(GR.RAILG_RT_AMT, 0) * DECODE(FS.SCG_AMT, 0, 100, FS.SCG_AMT))/100 , NVL(FS.SCG_AMT, 0)), 2)) TAMT" ).append("\n"); 
		query.append("              , DB.DMST_BKG_NO BKGNO" ).append("\n"); 
		query.append("              , DECODE(DB.CNTR_TPSZ_CD, 'D7', 'D7', 'D5', 'D5', 'D4', 'D4', 'D2', 'D2', 'F2', 'OT', 'F4', 'OT', 'R2', 'OT', 'O2', 'OT', 'P2', 'OT', 'O4', 'OT', 'P4', 'OT'" ).append("\n"); 
		query.append("                                      , 'T2', 'OT', 'T4', 'OT', 'R4', 'OT', 'R5', 'OT', 'R7', 'OT', 'S2', 'OT', 'S4', 'OT', 'D8', 'OT', 'D9', 'OT', 'A2', 'OT', 'A4', 'OT', 'F5', 'OT', 'Q5', 'OT' , 'D3', 'OT', 'DX', 'OT', 'R1', 'OT', 'R9', 'OT') CNTRTP2457" ).append("\n"); 
		query.append("           FROM DOM_FRT_INV IH" ).append("\n"); 
		query.append("              , DOM_FRT_INV_DTL ID" ).append("\n"); 
		query.append("              , DOM_BOOKING DB" ).append("\n"); 
		query.append("              , DOM_GEN_RT GR" ).append("\n"); 
		query.append("              , DOM_SURCHARGE EQ" ).append("\n"); 
		query.append("              , DOM_KNTR_PTY KP" ).append("\n"); 
		query.append("              , DOM_SURCHARGE FS" ).append("\n"); 
		query.append("          WHERE DB.DMST_BKG_NO = ID.DMST_BKG_NO" ).append("\n"); 
		query.append("            AND IH.INV_NO = ID.INV_NO" ).append("\n"); 
		query.append("            AND IH.INV_CXL_FLG = 'N'" ).append("\n"); 
		query.append("            AND DB.DMST_CUST_CD = KP.DMST_KNTR_PTY_CD(+)" ).append("\n"); 
		query.append("            AND DB.DMST_CUST_SEQ = KP.DMST_KNTR_PTY_SEQ(+)" ).append("\n"); 
		query.append("            AND DB.ORG_RAIL_LOC_CD = GR.FM_LOC_CD" ).append("\n"); 
		query.append("            AND DB.DEST_RAIL_LOC_CD = GR.TO_LOC_CD" ).append("\n"); 
		query.append("            AND GR.DMST_GEN_RT_TP_CD = 'S'" ).append("\n"); 
		query.append("            AND DECODE(DB.TRP_BKG_FLG, 'Y', 'TRP', 'N', 'HRP') = GR.DMST_BKG_TP_CD" ).append("\n"); 
		query.append("            AND IH.CRE_DT BETWEEN GR.EFF_DT AND GR.EXP_DT + 0.99999" ).append("\n"); 
		query.append("            AND DB.DMST_RAIL_SVC_TP_CD = GR.DMST_RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("            AND DECODE(DB.CNTR_FULL_FLG, 'Y', 'F', 'M') = GR.FULL_MTY_CD" ).append("\n"); 
		query.append("            AND DB.CNTR_TPSZ_CD = GR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            AND DB.CNTR_OWNR_CO_CD = GR.CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("            AND EQ.DMST_SCG_CD(+) = 'E'" ).append("\n"); 
		query.append("            AND IH.RT_APLY_DT BETWEEN EQ.EFF_DT(+) AND EQ.EXP_DT(+) + 0.99999" ).append("\n"); 
		query.append("            AND EQ.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("            AND FS.DMST_SCG_CD(+) = 'F'" ).append("\n"); 
		query.append("            AND IH.RT_APLY_DT BETWEEN FS.EFF_DT(+) AND FS.EXP_DT(+) + 0.99999" ).append("\n"); 
		query.append("            AND FS.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("            AND DB.ORG_RAIL_LOC_CD IS NOT NULL --ORG LOC" ).append("\n"); 
		query.append("            AND IH.CRE_DT BETWEEN TO_DATE(@[f_cre_start_dt]||'01', 'YYYY-MM-DD') AND LAST_DAY(TO_DATE(@[f_cre_end_dt], 'YYYY-MM'))+0.99999" ).append("\n"); 
		query.append("            AND NVL(ID.HJS_RAILG_RT_AMT, 0) = 0" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         SELECT 0 AS CHK" ).append("\n"); 
		query.append("              , DB.ORG_RAIL_LOC_CD --ORG LOC" ).append("\n"); 
		query.append("              , ID.INV_NO INVNO --INV NO" ).append("\n"); 
		query.append("              , NVL(ID.RAILG_RT_AMT, 0) IRATE -- INVOICE RATE" ).append("\n"); 
		query.append("              , NVL(ID.HJS_RAILG_RT_AMT, 0) GRATE --RAILAGE" ).append("\n"); 
		query.append("              , NVL(EQ.SCG_AMT, 0) EQAMT --EQ RENTAL" ).append("\n"); 
		query.append("              , ROUND(DECODE(FS.DMST_SCG_TP_CD, 'P', (NVL(ID.HJS_RAILG_RT_AMT, 0) * DECODE(FS.SCG_AMT, 0, 100, FS.SCG_AMT))/100 , NVL(FS.SCG_AMT, 0)), 2) FSCAMT" ).append("\n"); 
		query.append("              , NVL(ID.HZD_MTRL_SCG_RT_AMT, 0) HAZAMT --HAZMAT" ).append("\n"); 
		query.append("              , DECODE(NVL(ID.HJS_RAILG_RT_AMT, 0), 0, 0, NVL(ID.HJS_RAILG_RT_AMT, 0) + NVL(EQ.SCG_AMT, 0) + NVL(ID.HZD_MTRL_SCG_RT_AMT, 0) + ROUND(DECODE(FS.DMST_SCG_TP_CD, 'P', (NVL(ID.HJS_RAILG_RT_AMT, 0) * DECODE(FS.SCG_AMT, 0, 100, FS.SCG_AMT))/100 , NVL(FS.SCG_AMT, 0)), 2)) TAMT" ).append("\n"); 
		query.append("              , DB.DMST_BKG_NO BKGNO" ).append("\n"); 
		query.append("              , DECODE(DB.CNTR_TPSZ_CD, 'D7', 'D7', 'D5', 'D5', 'D4', 'D4', 'D2', 'D2', 'F2', 'OT', 'F4', 'OT', 'R2', 'OT', 'O2', 'OT', 'P2', 'OT', 'O4', 'OT', 'P4', 'OT'" ).append("\n"); 
		query.append("                                      , 'T2', 'OT', 'T4', 'OT', 'R4', 'OT', 'R5', 'OT', 'R7', 'OT', 'S2', 'OT', 'S4', 'OT', 'D8', 'OT', 'D9', 'OT', 'A2', 'OT', 'A4', 'OT', 'F5', 'OT', 'Q5', 'OT' , 'D3', 'OT', 'DX', 'OT', 'R1', 'OT', 'R9', 'OT') CNTRTP2457 --Dry 이외 CNTR는 Other로 변경 (Rail report와 기준 통일- COA only)" ).append("\n"); 
		query.append("           FROM DOM_FRT_INV IH" ).append("\n"); 
		query.append("              , DOM_FRT_INV_DTL ID" ).append("\n"); 
		query.append("              , DOM_BOOKING DB" ).append("\n"); 
		query.append("              , DOM_SURCHARGE EQ" ).append("\n"); 
		query.append("              , DOM_KNTR_PTY KP" ).append("\n"); 
		query.append("              , DOM_SURCHARGE FS" ).append("\n"); 
		query.append("          WHERE DB.DMST_BKG_NO = ID.DMST_BKG_NO" ).append("\n"); 
		query.append("            AND IH.INV_NO = ID.INV_NO" ).append("\n"); 
		query.append("            AND IH.INV_CXL_FLG = 'N'" ).append("\n"); 
		query.append("            AND DB.DMST_CUST_CD = KP.DMST_KNTR_PTY_CD(+)" ).append("\n"); 
		query.append("            AND DB.DMST_CUST_SEQ = KP.DMST_KNTR_PTY_SEQ(+)" ).append("\n"); 
		query.append("            AND EQ.DMST_SCG_CD(+) = 'E'" ).append("\n"); 
		query.append("            AND IH.RT_APLY_DT BETWEEN EQ.EFF_DT(+) AND EQ.EXP_DT(+) + 0.99999" ).append("\n"); 
		query.append("            AND EQ.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("            AND FS.DMST_SCG_CD(+) = 'F'" ).append("\n"); 
		query.append("            AND IH.RT_APLY_DT BETWEEN FS.EFF_DT(+) AND FS.EXP_DT(+) + 0.99999" ).append("\n"); 
		query.append("            AND FS.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("            AND DB.ORG_RAIL_LOC_CD IS NOT NULL --ORG LOC" ).append("\n"); 
		query.append("            AND IH.CRE_DT BETWEEN TO_DATE(@[f_cre_start_dt]||'01', 'YYYY-MM-DD') AND LAST_DAY(TO_DATE(@[f_cre_end_dt], 'YYYY-MM'))+0.99999" ).append("\n"); 
		query.append("            AND NVL(ID.HJS_RAILG_RT_AMT, 0) <> 0" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         SELECT 1 AS CHK" ).append("\n"); 
		query.append("              , DB.ORG_RAIL_LOC_CD --ORG LOC" ).append("\n"); 
		query.append("              , ID.INV_NO INVNO --INV NO" ).append("\n"); 
		query.append("              , NVL(ID.RAILG_RT_AMT, 0) IRATE --INVOICE RATE" ).append("\n"); 
		query.append("              , NVL(GR.RAILG_RT_AMT, 0) GRATE --RAILAGE" ).append("\n"); 
		query.append("              , NVL(EQ.SCG_AMT, 0) EQAMT --EQ RENTAL" ).append("\n"); 
		query.append("              , ROUND(DECODE(FS.DMST_SCG_TP_CD, 'P', (NVL(ID.HJS_RAILG_RT_AMT, 0) * DECODE(FS.SCG_AMT, 0, 100, FS.SCG_AMT))/100 , NVL(FS.SCG_AMT, 0)), 2) FSCAMT" ).append("\n"); 
		query.append("              , NVL(ID.HZD_MTRL_SCG_RT_AMT, 0) HAZAMT --HAZMAT" ).append("\n"); 
		query.append("              , DECODE(NVL(ID.HJS_RAILG_RT_AMT, 0), 0, 0, NVL(ID.HJS_RAILG_RT_AMT, 0) + NVL(EQ.SCG_AMT, 0) + NVL(ID.HZD_MTRL_SCG_RT_AMT, 0) + ROUND(DECODE(FS.DMST_SCG_TP_CD, 'P', (NVL(ID.HJS_RAILG_RT_AMT, 0) * DECODE(FS.SCG_AMT, 0, 100, FS.SCG_AMT))/100 , NVL(FS.SCG_AMT, 0)), 2)) TAMT" ).append("\n"); 
		query.append("              , DB.DMST_BKG_NO BKGNO" ).append("\n"); 
		query.append("              , DECODE(DB.CNTR_TPSZ_CD, 'D7', 'D7', 'D5', 'D5', 'D4', 'D4', 'D2', 'D2', 'F2', 'OT', 'F4', 'OT', 'R2', 'OT', 'O2', 'OT', 'P2', 'OT', 'O4', 'OT', 'P4', 'OT'" ).append("\n"); 
		query.append("                                      , 'T2', 'OT', 'T4', 'OT', 'R4', 'OT', 'R5', 'OT', 'R7', 'OT', 'S2', 'OT', 'S4', 'OT', 'D8', 'OT', 'D9', 'OT', 'A2', 'OT', 'A4', 'OT', 'F5', 'OT', 'Q5', 'OT' , 'D3', 'OT', 'DX', 'OT', 'R1', 'OT', 'R9', 'OT') CNTRTP2457" ).append("\n"); 
		query.append("           FROM DOM_FRT_INV IH" ).append("\n"); 
		query.append("              , DOM_FRT_INV_DTL ID" ).append("\n"); 
		query.append("              , DOM_BOOKING DB" ).append("\n"); 
		query.append("              , DOM_GEN_RT GR" ).append("\n"); 
		query.append("              , DOM_SURCHARGE EQ" ).append("\n"); 
		query.append("              , DOM_KNTR_PTY KP" ).append("\n"); 
		query.append("              , DOM_SURCHARGE FS" ).append("\n"); 
		query.append("          WHERE DB.DMST_BKG_NO = ID.DMST_BKG_NO" ).append("\n"); 
		query.append("            AND IH.INV_NO = ID.INV_NO" ).append("\n"); 
		query.append("            AND IH.INV_CXL_FLG = 'N'" ).append("\n"); 
		query.append("            AND DB.DMST_CUST_CD = KP.DMST_KNTR_PTY_CD(+)" ).append("\n"); 
		query.append("            AND DB.DMST_CUST_SEQ = KP.DMST_KNTR_PTY_SEQ(+)" ).append("\n"); 
		query.append("            AND DB.ORG_RAIL_LOC_CD = GR.FM_LOC_CD(+)" ).append("\n"); 
		query.append("            AND DB.DEST_RAIL_LOC_CD = GR.TO_LOC_CD(+)" ).append("\n"); 
		query.append("            AND GR.DMST_GEN_RT_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("            AND DECODE(DB.TRP_BKG_FLG, 'Y', 'TRP', 'N', 'HRP') = GR.DMST_BKG_TP_CD(+)" ).append("\n"); 
		query.append("            AND DB.DMST_RAIL_SVC_TP_CD = GR.DMST_RAIL_SVC_TP_CD(+)" ).append("\n"); 
		query.append("            AND DECODE(DB.CNTR_FULL_FLG, 'Y', 'F', 'M') = GR.FULL_MTY_CD(+)" ).append("\n"); 
		query.append("            AND DB.CNTR_TPSZ_CD = GR.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("            AND DB.CNTR_OWNR_CO_CD = GR.CNTR_OWNR_CO_CD(+)" ).append("\n"); 
		query.append("            AND GR.RAILG_RT_AMT IS NULL" ).append("\n"); 
		query.append("            AND EQ.DMST_SCG_CD(+) = 'E'" ).append("\n"); 
		query.append("            AND IH.RT_APLY_DT BETWEEN EQ.EFF_DT(+) AND EQ.EXP_DT(+) + 0.99999" ).append("\n"); 
		query.append("            AND EQ.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("            AND FS.DMST_SCG_CD(+) = 'F'" ).append("\n"); 
		query.append("            AND IH.RT_APLY_DT BETWEEN FS.EFF_DT(+) AND FS.EXP_DT(+) + 0.99999" ).append("\n"); 
		query.append("            AND FS.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("            AND DB.ORG_RAIL_LOC_CD IS NOT NULL --ORG LOC" ).append("\n"); 
		query.append("            AND IH.CRE_DT BETWEEN TO_DATE(@[f_cre_start_dt]||'01', 'YYYY-MM-DD') AND LAST_DAY(TO_DATE(@[f_cre_end_dt], 'YYYY-MM'))+0.99999" ).append("\n"); 
		query.append("            AND NVL(ID.HJS_RAILG_RT_AMT, 0) = 0 ) TT " ).append("\n"); 
		query.append("  WHERE  TT.CNTRTP2457 <> 'OT'" ).append("\n"); 
		query.append(" GROUP BY TT.ORG_RAIL_LOC_CD , TT.CNTRTP2457" ).append("\n"); 

	}
}