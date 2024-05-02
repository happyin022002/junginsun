/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusIrgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.01.22 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckMtyContainerStatusIrgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * with Cntr_no . whQueryStr 쿼리에서 IRG 있을때, EMPTY CNTR IRG 및 TPSZ 에 따른, BLOCK, GOODBILL, CONSTRAINED CHECK
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckMtyContainerStatusIrgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqTpSzCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmYdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toYdCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusIrgRSQL").append("\n"); 
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
		query.append(" SELECT ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("        ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("        ROUT_SEQ," ).append("\n"); 
		query.append("        PRIO_SEQ," ).append("\n"); 
		query.append("        IS_BLOCK_VENDOR," ).append("\n"); 
		query.append("        IS_GOODBILL," ).append("\n"); 
		query.append("        IS_CONSTRAINTED," ).append("\n"); 
		query.append("        ROUT_ORG_NOD_CD || ' (' || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, (DECODE(ROUT_DTL_SEQ, 1, TRSP_MOD, '' )),(DECODE(ROUT_DTL_SEQ, 1, TRSP_MOD, '' ))) ) || ') ' || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 1, '', DECODE(ROUT_DTL_SEQ, 1, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 2, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 2, '', DECODE(ROUT_DTL_SEQ, 2, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 3, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 3, '', DECODE(ROUT_DTL_SEQ, 3, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 4, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 4, '', DECODE(ROUT_DTL_SEQ, 4, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 5, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 5, '', DECODE(ROUT_DTL_SEQ, 5, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 6, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 6, '', DECODE(ROUT_DTL_SEQ, 6, '-'||LNK_DEST_NOD_CD || ' (' )))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 7, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 7, '', DECODE(ROUT_DTL_SEQ, 7, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 8, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 8, '', DECODE(ROUT_DTL_SEQ, 8, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 9, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 9, '', DECODE(ROUT_DTL_SEQ, 9, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 10, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 10, '', DECODE(ROUT_DTL_SEQ, 10, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 11, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 11, '', DECODE(ROUT_DTL_SEQ, 11, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 12, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 12, '', DECODE(ROUT_DTL_SEQ, 12, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 13, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 13, '', DECODE(ROUT_DTL_SEQ, 13, '-'||LNK_DEST_NOD_CD || ' (')))) ||" ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 14, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 14, '', DECODE(ROUT_DTL_SEQ, 14, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 15, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 15, '', DECODE(ROUT_DTL_SEQ, 15, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 16, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 16, '', DECODE(ROUT_DTL_SEQ, 16, '-'||LNK_DEST_NOD_CD || ' (' )))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 17, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 17, '', DECODE(ROUT_DTL_SEQ, 17, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 18, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 18, '', DECODE(ROUT_DTL_SEQ, 18, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 19, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 19, '', DECODE(ROUT_DTL_SEQ, 19, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 20, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 20, '', DECODE(ROUT_DTL_SEQ, 20, '-'||LNK_DEST_NOD_CD)))) " ).append("\n"); 
		query.append("        || '-'||ROUT_DEST_NOD_CD AS ROUTE" ).append("\n"); 
		query.append("  FROM ( SELECT IS_CONSTRAINTED," ).append("\n"); 
		query.append("                IS_BLOCK_VENDOR," ).append("\n"); 
		query.append("                IS_GOODBILL," ).append("\n"); 
		query.append("                ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                ROUT_SEQ," ).append("\n"); 
		query.append("                PRIO_SEQ," ).append("\n"); 
		query.append("                ROUT_DTL_SEQ," ).append("\n"); 
		query.append("                CNT," ).append("\n"); 
		query.append("                LNK_ORG_NOD_CD," ).append("\n"); 
		query.append("                LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("                TRSP_MOD_CD," ).append("\n"); 
		query.append("                DECODE(TRSP_MOD_CD, 'TD', 'TRUCK', 'RD', 'RAIL', TRSP_MOD_CD) TRSP_MOD," ).append("\n"); 
		query.append("                TZTM_HRS LINK_TT_TIME," ).append("\n"); 
		query.append("                SUM_TT_TIME," ).append("\n"); 
		query.append("                ORG_DW_TIME," ).append("\n"); 
		query.append("                NVL(DEST_DW_TIME, 0) DEST_DW_TIME" ).append("\n"); 
		query.append("           FROM ( SELECT 'N' AS IS_CONSTRAINTED," ).append("\n"); 
		query.append("                         DECODE(D.VNDR_SEQ, 105484, 'Y', 108386, 'Y', 'N') AS IS_BLOCK_VENDOR," ).append("\n"); 
		query.append("                         DECODE(M.INLND_ROUT_INV_BIL_PATT_CD, 'S2R', 'Y', 'S3R', 'Y', 'N') AS IS_GOODBILL," ).append("\n"); 
		query.append("                         M.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                         M.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                         M.ROUT_SEQ," ).append("\n"); 
		query.append("                         M.PRIO_SEQ," ).append("\n"); 
		query.append("                         D.LNK_ORG_NOD_CD," ).append("\n"); 
		query.append("                         D.LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("                         D.ROUT_DTL_SEQ," ).append("\n"); 
		query.append("                         D.TRSP_MOD_CD," ).append("\n"); 
		query.append("                         L.TZTM_HRS," ).append("\n"); 
		query.append("                         COUNT (*) OVER (PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("                             ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ) AS CNT," ).append("\n"); 
		query.append("                         SUM(L.TZTM_HRS) OVER(PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("                             ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ) AS SUM_TT_TIME," ).append("\n"); 
		query.append("                        (SELECT NVL(DRY_AVG_DWLL_HRS, 0)" ).append("\n"); 
		query.append("                           FROM MDM_YARD" ).append("\n"); 
		query.append("                          WHERE YD_CD = D.LNK_ORG_NOD_CD " ).append("\n"); 
		query.append("                        ) ORG_DW_TIME," ).append("\n"); 
		query.append("                        (SELECT NVL(DRY_AVG_DWLL_HRS, 0)" ).append("\n"); 
		query.append("                           FROM MDM_YARD" ).append("\n"); 
		query.append("                          WHERE YD_CD = D.LNK_DEST_NOD_CD " ).append("\n"); 
		query.append("                        ) DEST_DW_TIME" ).append("\n"); 
		query.append("                   FROM PRD_INLND_ROUT_MST M," ).append("\n"); 
		query.append("                        PRD_INLND_ROUT_DTL D," ).append("\n"); 
		query.append("                        PRD_INLND_EACH_LNK L" ).append("\n"); 
		query.append("                  WHERE M.PCTL_IO_BND_CD = 'M'" ).append("\n"); 
		query.append("                    AND M.WRS_MTY_CMDT_CD is not null" ).append("\n"); 
		query.append("                    AND D.VNDR_SEQ not in (105484, 108386)" ).append("\n"); 
		query.append("                    AND NVL(M.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                    AND M.ROUT_ORG_NOD_CD LIKE @[fmYdCd]||'%'" ).append("\n"); 
		query.append("                    AND M.ROUT_DEST_NOD_CD LIKE @[toYdCd]||'%'" ).append("\n"); 
		query.append("                    AND NVL( DECODE ( @[eqTpSzCd], 'D2', M.D2_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'D4', M.D4_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'D5', M.D5_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'D7', M.D7_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'O2', M.O2_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'O4', M.O4_CAPA_FLG," ).append("\n"); 
		query.append("                                                   'O5', M.O5_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'A2', M.A2_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'A4', M.A4_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'A5', M.A5_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'R2', M.R2_CAPA_FLG, " ).append("\n"); 
		query.append("                                                   'R5', M.R5_CAPA_FLG) , 'N') = 'Y'" ).append("\n"); 
		query.append("                    AND M.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                    AND M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                    AND M.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND D.LNK_ORG_NOD_CD = L.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("                    AND D.LNK_DEST_NOD_CD = L.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("                    AND D.TRSP_MOD_CD = L.TRSP_MOD_CD" ).append("\n"); 
		query.append("                    AND D.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                  ORDER BY M.ROUT_SEQ," ).append("\n"); 
		query.append("                           D.ROUT_DTL_SEQ" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("           ) M" ).append("\n"); 
		query.append("   GROUP BY M.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("            M.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("            M.ROUT_SEQ," ).append("\n"); 
		query.append("            M.PRIO_SEQ," ).append("\n"); 
		query.append("            SUM_TT_TIME," ).append("\n"); 
		query.append("            IS_BLOCK_VENDOR," ).append("\n"); 
		query.append("            IS_GOODBILL," ).append("\n"); 
		query.append("            IS_CONSTRAINTED" ).append("\n"); 
		query.append("   ORDER BY ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("            ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("            PRIO_SEQ" ).append("\n"); 

	}
}