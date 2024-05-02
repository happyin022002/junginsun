/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OptimumRoutePassDBDAOsearchOptmRoutPassSmryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimumRoutePassDBDAOsearchOptmRoutPassSmryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOptmRoutPassSmry
	  * </pre>
	  */
	public OptimumRoutePassDBDAOsearchOptmRoutPassSmryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("door_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.integration").append("\n"); 
		query.append("FileName : OptimumRoutePassDBDAOsearchOptmRoutPassSmryRSQL").append("\n"); 
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
		query.append("---- CPY_NO : 0 - GRAND GRAND TOTAL (Office-ALL,TM-ALL)" ).append("\n"); 
		query.append("---- CPY_NO : 1 - GRAND TOTAL       (Office-ALL,TM-개별)" ).append("\n"); 
		query.append("---- CPY_NO : 2 - OFFICE TOTAL      (Office-개별,TM-ALL)" ).append("\n"); 
		query.append("---- CPY_NO : 3 - 개별                              (Office-개별,TM-개별)" ).append("\n"); 
		query.append("---- OptmRoutPassSmryVO" ).append("\n"); 
		query.append("SELECT CPY_NO, WO_CRE_OFC_CD, TRSP_BND_CD, TRSP_MOD_CD, TOT_SO_CNT, PASS_CNT, ALT_PASS_CNT, NON_PASS_CNT, NON_PASS_RATIO" ).append("\n"); 
		query.append("     , NON_PASS_T_CNT, NON_PASS_R_CNT, NON_PASS_N_CNT, NON_PASS_O_CNT" ).append("\n"); 
		query.append("     , NON_PASS_T_RATIO, NON_PASS_R_RATIO, NON_PASS_N_RATIO, NON_PASS_O_RATIO" ).append("\n"); 
		query.append("     , DECODE(CPY_NO, 0, 0, 1, 0, DENSE_RANK() OVER (ORDER BY WO_CRE_OFC_CD, TRSP_BND_CD)) GRP_NO -- GRP_NO가 0일 경우 체크 불가" ).append("\n"); 
		query.append("     , CASE WHEN CPY_NO IN (0,1) THEN @[input_office] ELSE WO_CRE_OFC_CD END QRY_OFC_CD -- DETAIL조회시 OFFICE CODE에 해당" ).append("\n"); 
		query.append("     , CASE WHEN CPY_NO IN (0,2) THEN @[trsp_mod_cd] ELSE TRSP_MOD_CD END QRY_TRSP_MOD_CD -- DETAIL조회시 Trans Mode에 해당" ).append("\n"); 
		query.append("     , @[from_date]        IN_FROM_DATE" ).append("\n"); 
		query.append("     , @[to_date]          IN_TO_DATE" ).append("\n"); 
		query.append("     , DSCR_RSN_MAP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    select CPY_NO" ).append("\n"); 
		query.append("         , DECODE(CPY_NO, 0, 'ALL', 1, 'ALL', WO_CRE_OFC_CD) WO_CRE_OFC_CD" ).append("\n"); 
		query.append("         , TRSP_BND_CD" ).append("\n"); 
		query.append("         , DECODE(CPY_NO, 0, 'ALL', 2, 'ALL', TRSP_MOD_CD) TRSP_MOD_CD" ).append("\n"); 
		query.append("         , SUM(TOT_CNT) TOT_SO_CNT" ).append("\n"); 
		query.append("         , SUM(PASS_CNT)  PASS_CNT" ).append("\n"); 
		query.append("		 , SUM(ALT_PASS_CNT) ALT_PASS_CNT" ).append("\n"); 
		query.append("         , SUM(NON_PASS_CNT) NON_PASS_CNT" ).append("\n"); 
		query.append("         , SUM(NON_PASS_T_CNT) NON_PASS_T_CNT" ).append("\n"); 
		query.append("         , SUM(NON_PASS_R_CNT) NON_PASS_R_CNT" ).append("\n"); 
		query.append("         , SUM(NON_PASS_N_CNT) NON_PASS_N_CNT" ).append("\n"); 
		query.append("         , SUM(NON_PASS_O_CNT) NON_PASS_O_CNT" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' NON_PASS_RATIO" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_T_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' NON_PASS_T_RATIO" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_R_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' NON_PASS_R_RATIO" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_N_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' NON_PASS_N_RATIO" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_O_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' NON_PASS_O_RATIO" ).append("\n"); 
		query.append("         , ROW_NUMBER() OVER (ORDER BY INSTR('ALL,' || @[input_office], DECODE(CPY_NO, 0, 'ALL', 1, 'ALL', WO_CRE_OFC_CD))" ).append("\n"); 
		query.append("                                     , TRSP_BND_CD DESC" ).append("\n"); 
		query.append("                                     , DECODE(CPY_NO, 0, 'ALL', 2, 'ALL', TRSP_MOD_CD)" ).append("\n"); 
		query.append("                             ) SORT_RN" ).append("\n"); 
		query.append("     , MAX(DSCR_RSN_MAP_T)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_R)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_O)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_D)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_P)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_N)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_I)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_M)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_S)" ).append("\n"); 
		query.append("        || MAX(DSCR_RSN_MAP_A) DSCR_RSN_MAP" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            A.CRE_OFC_CD                         WO_CRE_OFC_CD, -- wo create office" ).append("\n"); 
		query.append("            B.TRSP_BND_CD," ).append("\n"); 
		query.append("            B.TRSP_CRR_MOD_CD TRSP_MOD_CD," ).append("\n"); 
		query.append("            COUNT(1) TOT_CNT," ).append("\n"); 
		query.append("             SUM((CASE WHEN B.SO_DSCR_RSN_CD IN ('M') AND B.PASS_TP_CD IS NULL THEN 1 ELSE 0 END)) PASS_CNT" ).append("\n"); 
		query.append("           , SUM((CASE WHEN B.SO_DSCR_RSN_CD IN ('M') AND B.PASS_TP_CD = 'A' THEN 1 ELSE 0 END)) ALT_PASS_CNT" ).append("\n"); 
		query.append("           , SUM((CASE WHEN B.SO_DSCR_RSN_CD IN ('M') THEN 0 ELSE 1 END)) NON_PASS_CNT" ).append("\n"); 
		query.append("           , SUM((CASE WHEN B.SO_DSCR_RSN_CD IN ('T') THEN 1 ELSE 0 END)) NON_PASS_T_CNT" ).append("\n"); 
		query.append("           , SUM((CASE WHEN B.SO_DSCR_RSN_CD IN ('R') THEN 1 ELSE 0 END)) NON_PASS_R_CNT" ).append("\n"); 
		query.append("           , SUM((CASE WHEN B.SO_DSCR_RSN_CD IN ('N') THEN 1 ELSE 0 END)) NON_PASS_N_CNT" ).append("\n"); 
		query.append("           , SUM((CASE WHEN B.SO_DSCR_RSN_CD IN ('T', 'R', 'N', 'M') THEN 0 ELSE 1 END)) NON_PASS_O_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'T', 'T')) DSCR_RSN_MAP_T" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'R', 'R')) DSCR_RSN_MAP_R" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'O', 'O')) DSCR_RSN_MAP_O" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'D', 'D')) DSCR_RSN_MAP_D" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'P', 'P')) DSCR_RSN_MAP_P" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'N', 'N')) DSCR_RSN_MAP_N" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'I', 'I')) DSCR_RSN_MAP_I" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'M', 'M')) DSCR_RSN_MAP_M" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'S', 'S')) DSCR_RSN_MAP_S" ).append("\n"); 
		query.append("           , MAX(DECODE(B.SO_DSCR_RSN_CD, 'A', 'A')) DSCR_RSN_MAP_A" ).append("\n"); 
		query.append("        FROM TRS_TRSP_WRK_ORD A ," ).append("\n"); 
		query.append("            TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("           , TRS_TRSP_INV_WRK C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_node} != ''|| ${door_node} != '')" ).append("\n"); 
		query.append("           , BKG_BOOKING BKG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE B.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND B.TRSP_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("        AND A.TRSP_WO_OFC_CTY_CD = B.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        AND A.TRSP_WO_SEQ = B.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("        AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("        AND B.SO_DSCR_RSN_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND A.LOCL_UPD_DT >= TO_DATE('20120701', 'YYYYMMDD')  -- System Open시 처리" ).append("\n"); 
		query.append("#if (${from_node} != ''|| ${door_node} != '')" ).append("\n"); 
		query.append("        AND B.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_node} != '') " ).append("\n"); 
		query.append("        AND DECODE(B.TRSP_BND_CD, 'O', BKG.POL_NOD_CD, BKG.POD_NOD_CD) LIKE @[from_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${door_node} != '') " ).append("\n"); 
		query.append("      AND NVL((SELECT  ZN_CD" ).append("\n"); 
		query.append("                         FROM BKG_EUR_TRO_DTL TD" ).append("\n"); 
		query.append("                            , SCE_TRO_MAPG M" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                         AND B.COP_NO = M.COP_NO" ).append("\n"); 
		query.append("                         AND TD.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                         AND TD.IO_BND_CD = M.IO_BND_CD" ).append("\n"); 
		query.append("                         AND TD.TRO_SEQ = M.TRO_SEQ" ).append("\n"); 
		query.append("                         AND TD.ZN_CD IS NOT NULL" ).append("\n"); 
		query.append("                         AND TD.DOR_ADDR_TP_CD = 'D'" ).append("\n"); 
		query.append("                         AND ROWNUM=1)" ).append("\n"); 
		query.append("					   , DECODE(B.TRSP_BND_CD, 'O', BKG.POR_NOD_CD, BKG.DEL_NOD_CD)) LIKE @[door_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ---------------------- VELOCITY 영역" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("        AND A.LOCL_UPD_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                          AND TO_DATE(REPLACE(@[to_date],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("        AND B.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("        AND B.INV_VNDR_SEQ = C.INV_VNDR_SEQ" ).append("\n"); 
		query.append("        AND C.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                          AND TO_DATE(REPLACE(@[to_date],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND A.CRE_OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[input_office], ',')))" ).append("\n"); 
		query.append("        AND B.TRSP_BND_CD = DECODE(@[bnd_cd], 'A', b.TRSP_BND_CD, @[bnd_cd])" ).append("\n"); 
		query.append("        AND B.TRSP_CRR_MOD_CD IN (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                   WHERE INTG_CD_ID = 'CD00283'" ).append("\n"); 
		query.append("                                     AND (INSTR(@[trsp_mod_cd], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                                           OR @[trsp_mod_cd] = 'ALL'" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("        GROUP BY A.CRE_OFC_CD, B.TRSP_BND_CD, b.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("        ) MSTD," ).append("\n"); 
		query.append("       (SELECT CPY_NO -- 0(Grand Total) 1(Office Total) 2(Detail)" ).append("\n"); 
		query.append("        FROM COM_CPY_NO" ).append("\n"); 
		query.append("        WHERE CPY_NO IN (3" ).append("\n"); 
		query.append("                         , CASE WHEN @[trsp_mod_cd] = 'ALL' OR INSTR(@[trsp_mod_cd], ',') > 0 THEN 2 END" ).append("\n"); 
		query.append("                         , CASE WHEN @[input_office] = 'ALL' OR INSTR(@[input_office], ',') > 0 THEN 1 END" ).append("\n"); 
		query.append("                         , CASE WHEN (@[trsp_mod_cd] = 'ALL' OR INSTR(@[trsp_mod_cd], ',') > 0)" ).append("\n"); 
		query.append("                                     AND (@[input_office] = 'ALL' OR INSTR(@[input_office], ',') > 0) THEN 0 END" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        ) CPYT" ).append("\n"); 
		query.append("    GROUP BY CPY_NO" ).append("\n"); 
		query.append("           , DECODE(CPY_NO, 0, 'ALL', 1, 'ALL', WO_CRE_OFC_CD)" ).append("\n"); 
		query.append("           , TRSP_BND_CD" ).append("\n"); 
		query.append("           , DECODE(CPY_NO, 0, 'ALL', 2, 'ALL', TRSP_MOD_CD)" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("ORDER BY SORT_RN" ).append("\n"); 

	}
}