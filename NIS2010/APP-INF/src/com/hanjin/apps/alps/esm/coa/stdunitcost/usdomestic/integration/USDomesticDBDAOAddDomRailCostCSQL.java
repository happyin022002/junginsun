/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddDomRailCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.20 
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

public class USDomesticDBDAOAddDomRailCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddDomRailCost
	  * </pre>
	  */
	public USDomesticDBDAOAddDomRailCostCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOAddDomRailCostCSQL").append("\n"); 
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
		query.append("--Rail Operation data I/F--" ).append("\n"); 
		query.append("MERGE INTO COA_USA_DMST_UT_COST B1" ).append("\n"); 
		query.append("     USING " ).append("\n"); 
		query.append("            (SELECT REPLACE(@[f_cost_yrmon], '-', '')         AS COST_YRMON" ).append("\n"); 
		query.append("                    ,ORGLOC ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("                    ,CNTRTP24 CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    ,SUM(VOL) VOL" ).append("\n"); 
		query.append("                    ,SUM(EXP) EXPN" ).append("\n"); 
		query.append("              FROM(" ).append("\n"); 
		query.append("                    SELECT A.ORGLOC" ).append("\n"); 
		query.append("                          ,A.DESTLOC" ).append("\n"); 
		query.append("                          ,A.CNTRTP24" ).append("\n"); 
		query.append("                          ,COUNT(A.CNTRTP24) VOL" ).append("\n"); 
		query.append("                          ,SUM(EXP) EXP" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT RM.DMST_BKG_NO" ).append("\n"); 
		query.append("                              ,RM.ROUT_ORG_LOC_CD ORGLOC" ).append("\n"); 
		query.append("                              ,RM.ROUT_DEST_LOC_CD DESTLOC" ).append("\n"); 
		query.append("                              ,MAX(DECODE(MC.CNTR_TPSZ_CD, 'D7', 'D7', 'D5', 'D5', 'D4', 'D4', 'D2', 'D2', 'OTHER')) CNTRTP24" ).append("\n"); 
		query.append("                              ,SUM(DECODE(DMST_INV_BIL_STY_CD, 'C', (NVL(RD1.AGMT_RT_AMT, 0) + NVL(RD2.AGMT_RT_AMT , 0))/2, NVL(RD1.AGMT_RT_AMT, 0) + NVL(RD2.AGMT_RT_AMT , 0))) EXP" ).append("\n"); 
		query.append("                         FROM DOM_RAIL_SO_MST RM" ).append("\n"); 
		query.append("                             ,DOM_RAIL_SO_DTL RD1" ).append("\n"); 
		query.append("                             ,DOM_RAIL_SO_DTL RD2" ).append("\n"); 
		query.append("                             ,MST_CONTAINER MC" ).append("\n"); 
		query.append("                             ,MDM_VENDOR M1" ).append("\n"); 
		query.append("                             ,MDM_VENDOR M2" ).append("\n"); 
		query.append("                        WHERE RM.TRSP_SO_OFC_CTY_CD = RD1.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                          AND RM.TRSP_SO_SEQ = RD1.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("                          AND RM.TRSP_SO_OFC_CTY_CD = RD2.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                          AND RM.TRSP_SO_SEQ = RD2.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("                          AND RD1.SUB_RAIL_SEQ(+) = '1'" ).append("\n"); 
		query.append("                          AND RD2.SUB_RAIL_SEQ(+) <> '1'" ).append("\n"); 
		query.append("                          AND RD1.VNDR_SEQ = M1.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                          AND RD2.VNDR_SEQ = M2.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                          AND RM.CRE_DT BETWEEN TO_DATE(REPLACE(@[f_cre_start_dt], '-', '')||'01', 'YYYY-MM-DD') AND LAST_DAY(TO_DATE(REPLACE(@[f_cre_end_dt], '-', ''), 'YYYY-MM')) + .99999  -- SO Cre DT 조건" ).append("\n"); 
		query.append("                          AND RM.DMST_SO_STS_CD in ('O','C')" ).append("\n"); 
		query.append("                          AND RM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("                      GROUP BY DMST_BKG_NO, ROUT_ORG_LOC_CD, ROUT_DEST_LOC_CD" ).append("\n"); 
		query.append("                      HAVING COUNT(*)>1 " ).append("\n"); 
		query.append("                      UNION ALL               " ).append("\n"); 
		query.append("                        SELECT RM.DMST_BKG_NO" ).append("\n"); 
		query.append("                              ,RM.ROUT_ORG_LOC_CD ORGLOC" ).append("\n"); 
		query.append("                              ,RM.ROUT_DEST_LOC_CD DESTLOC" ).append("\n"); 
		query.append("                              ,MAX(DECODE(MC.CNTR_TPSZ_CD, 'D7', 'D7', 'D5', 'D5', 'D4', 'D4', 'D2', 'D2', 'OTHER')) CNTRTP24" ).append("\n"); 
		query.append("                              ,SUM(NVL(RD1.AGMT_RT_AMT, 0) + NVL(RD2.AGMT_RT_AMT, 0)) EXP" ).append("\n"); 
		query.append("                         FROM DOM_RAIL_SO_MST RM" ).append("\n"); 
		query.append("                             ,DOM_RAIL_SO_DTL RD1" ).append("\n"); 
		query.append("                             ,DOM_RAIL_SO_DTL RD2" ).append("\n"); 
		query.append("                             ,MST_CONTAINER MC" ).append("\n"); 
		query.append("                             ,MDM_VENDOR M1" ).append("\n"); 
		query.append("                             ,MDM_VENDOR M2" ).append("\n"); 
		query.append("                       WHERE RM.TRSP_SO_OFC_CTY_CD = RD1.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                         AND RM.TRSP_SO_SEQ = RD1.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("                         AND RM.TRSP_SO_OFC_CTY_CD = RD2.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                         AND RM.TRSP_SO_SEQ = RD2.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("                         AND RD1.SUB_RAIL_SEQ(+) = '1'" ).append("\n"); 
		query.append("                         AND RD2.SUB_RAIL_SEQ(+) <> '1'" ).append("\n"); 
		query.append("                         AND RD1.VNDR_SEQ = M1.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                         AND RD2.VNDR_SEQ = M2.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                         AND RM.CRE_DT BETWEEN TO_DATE(REPLACE(@[f_cre_start_dt], '-', '')||'01', 'YYYY-MM-DD') AND LAST_DAY(TO_DATE(REPLACE(@[f_cre_end_dt], '-', ''), 'YYYY-MM')) + .99999  -- SO Cre DT 조건" ).append("\n"); 
		query.append("                         AND RM.DMST_SO_STS_CD in ('O', 'C')" ).append("\n"); 
		query.append("                         AND RM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("                   GROUP BY DMST_BKG_NO, ROUT_ORG_LOC_CD, ROUT_DEST_LOC_CD" ).append("\n"); 
		query.append("                     HAVING COUNT(*)=1 ) A" ).append("\n"); 
		query.append("                    GROUP BY ORGLOC, DESTLOC, CNTRTP24 )AA" ).append("\n"); 
		query.append("               WHERE CNTRTP24 <> 'OTHER'    " ).append("\n"); 
		query.append("             GROUP BY ORGLOC, CNTRTP24" ).append("\n"); 
		query.append("             ) B2" ).append("\n"); 
		query.append("  ON (    B1.COST_YRMON        = B2.COST_YRMON" ).append("\n"); 
		query.append("      AND B1.ORG_RAIL_LOC_CD   = B2.ORG_RAIL_LOC_CD" ).append("\n"); 
		query.append("      AND B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD ) " ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET B1.RAIL_SO_VOL_QTY = B2.VOL" ).append("\n"); 
		query.append("            ,B1.RAIL_AGMT_AMT   = B2.EXPN" ).append("\n"); 
		query.append("            ,B1.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("            ,B1.UPD_DT = SYSDATE" ).append("\n"); 

	}
}