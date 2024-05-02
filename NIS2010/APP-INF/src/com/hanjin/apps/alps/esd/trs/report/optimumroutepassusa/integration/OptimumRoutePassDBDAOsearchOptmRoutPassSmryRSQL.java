/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OptimumRoutePassDBDAOsearchOptmRoutPassSmryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.integration;

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
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.integration").append("\n"); 
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
		query.append("SELECT CPY_NO, WO_CRE_OFC_CD, TRSP_BND_CD, TOT_SO_CNT, PASS_CNT, NON_PASS_CNT, NON_PASS_RATIO" ).append("\n"); 
		query.append("     , NON_PASS_T_CNT, NON_PASS_R_CNT, NON_PASS_N_CNT, NON_PASS_O_CNT" ).append("\n"); 
		query.append("     , NON_PASS_T_RATIO, NON_PASS_R_RATIO, NON_PASS_N_RATIO, NON_PASS_O_RATIO" ).append("\n"); 
		query.append("     , DECODE(CPY_NO, 0, 0, DENSE_RANK() OVER (ORDER BY WO_CRE_OFC_CD, TRSP_BND_CD)) GRP_NO -- GRP_NO가 0일 경우 체크 불가" ).append("\n"); 
		query.append("     , CASE WHEN CPY_NO = 0 THEN @[input_office] ELSE WO_CRE_OFC_CD END QRY_OFC_CD -- DETAIL조회시 OFFICE CODE에 해당" ).append("\n"); 
		query.append("     , @[from_date]        IN_FROM_DATE" ).append("\n"); 
		query.append("     , @[to_date]          IN_TO_DATE" ).append("\n"); 
		query.append("     , DSCR_RSN_MAP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CPY_NO" ).append("\n"); 
		query.append("         , DECODE(CPY_NO, 0, 'ALL', CRE_OFC_CD) WO_CRE_OFC_CD" ).append("\n"); 
		query.append("         , TRSP_BND_CD" ).append("\n"); 
		query.append("         , SUM(TOT_CNT) AS TOT_SO_CNT" ).append("\n"); 
		query.append("         , SUM(PASS_CNT) AS PASS_CNT" ).append("\n"); 
		query.append("         , SUM(NON_PASS_CNT) AS NON_PASS_CNT" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' AS NON_PASS_RATIO" ).append("\n"); 
		query.append("         , SUM(NON_PASS_T_CNT) AS NON_PASS_T_CNT" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_T_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' AS NON_PASS_T_RATIO" ).append("\n"); 
		query.append("         , SUM(NON_PASS_R_CNT) AS NON_PASS_R_CNT" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_R_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' AS NON_PASS_R_RATIO" ).append("\n"); 
		query.append("         , SUM(NON_PASS_N_CNT) AS NON_PASS_N_CNT" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_N_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' AS NON_PASS_N_RATIO" ).append("\n"); 
		query.append("         , SUM(NON_PASS_O_CNT) AS NON_PASS_O_CNT" ).append("\n"); 
		query.append("         , (ROUND(NVL(SUM(NON_PASS_O_CNT),0) / SUM(TOT_CNT), 2) * 100) || '%' AS NON_PASS_O_RATIO" ).append("\n"); 
		query.append("         , ROW_NUMBER() OVER (ORDER BY INSTR('ALL,' || @[input_office], DECODE(CPY_NO, 0, 'ALL', CRE_OFC_CD))" ).append("\n"); 
		query.append("                                     , TRSP_BND_CD DESC" ).append("\n"); 
		query.append("                             ) SORT_RN" ).append("\n"); 
		query.append("         , MAX(DSCR_RSN_MAP_T)" ).append("\n"); 
		query.append("            || MAX(DSCR_RSN_MAP_R)" ).append("\n"); 
		query.append("            || MAX(DSCR_RSN_MAP_O)" ).append("\n"); 
		query.append("            || MAX(DSCR_RSN_MAP_D)" ).append("\n"); 
		query.append("            || MAX(DSCR_RSN_MAP_P)" ).append("\n"); 
		query.append("            || MAX(DSCR_RSN_MAP_N)" ).append("\n"); 
		query.append("            || MAX(DSCR_RSN_MAP_I)" ).append("\n"); 
		query.append("            || MAX(DSCR_RSN_MAP_M) DSCR_RSN_MAP" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("               CRE_OFC_CD, TRSP_BND_CD" ).append("\n"); 
		query.append("              ,SUM(ACT_CNTR_QTY) TOT_CNT" ).append("\n"); 
		query.append("              ,SUM((CASE WHEN SO_DSCR_RSN_CD IN ('M') THEN 1*NVL(ACT_CNTR_QTY,0) ELSE 0 END)) PASS_CNT" ).append("\n"); 
		query.append("              ,SUM((CASE WHEN SO_DSCR_RSN_CD IN ('M') THEN 0 ELSE 1*NVL(ACT_CNTR_QTY,0) END)) NON_PASS_CNT" ).append("\n"); 
		query.append("              ,SUM((CASE WHEN SO_DSCR_RSN_CD IN ('T') THEN 1*NVL(ACT_CNTR_QTY,0) ELSE 0 END)) NON_PASS_T_CNT" ).append("\n"); 
		query.append("              ,SUM((CASE WHEN SO_DSCR_RSN_CD IN ('R') THEN 1*NVL(ACT_CNTR_QTY,0) ELSE 0 END)) NON_PASS_R_CNT" ).append("\n"); 
		query.append("              ,SUM((CASE WHEN SO_DSCR_RSN_CD IN ('N') THEN 1*NVL(ACT_CNTR_QTY,0) ELSE 0 END)) NON_PASS_N_CNT" ).append("\n"); 
		query.append("              ,SUM((CASE WHEN SO_DSCR_RSN_CD IN ('T', 'R', 'N', 'M') THEN 0 ELSE 1*NVL(ACT_CNTR_QTY,0) END)) NON_PASS_O_CNT" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'T', 'T')) DSCR_RSN_MAP_T" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'R', 'R')) DSCR_RSN_MAP_R" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'O', 'O')) DSCR_RSN_MAP_O" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'D', 'D')) DSCR_RSN_MAP_D" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'P', 'P')) DSCR_RSN_MAP_P" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'N', 'N')) DSCR_RSN_MAP_N" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'I', 'I')) DSCR_RSN_MAP_I" ).append("\n"); 
		query.append("              ,MAX(DECODE(SO_DSCR_RSN_CD, 'M', 'M')) DSCR_RSN_MAP_M" ).append("\n"); 
		query.append("            FROM TRS_TRSP_OPTM_USA_ROUT" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("            AND INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_date],'-',''), 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("            AND WO_ISS_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_date],'-',''), 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND TRSP_BND_CD = DECODE(@[bnd_cd], 'A', TRSP_BND_CD, @[bnd_cd])" ).append("\n"); 
		query.append("            AND CRE_OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[input_office], ',')))" ).append("\n"); 
		query.append("            AND RSLT_FLG = 'Y' AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("            GROUP BY CRE_OFC_CD, TRSP_BND_CD" ).append("\n"); 
		query.append("            ) MSTD," ).append("\n"); 
		query.append("            (SELECT CPY_NO" ).append("\n"); 
		query.append("             FROM COM_CPY_NO" ).append("\n"); 
		query.append("             WHERE CPY_NO IN (1," ).append("\n"); 
		query.append("                              CASE WHEN @[input_office] = 'ALL' OR INSTR(@[input_office], ',') > 0 THEN 0 END" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("             ) CPYT" ).append("\n"); 
		query.append("GROUP BY CPY_NO" ).append("\n"); 
		query.append("         , DECODE(CPY_NO, 0, 'ALL', CRE_OFC_CD)" ).append("\n"); 
		query.append("         , TRSP_BND_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("ORDER BY SORT_RN" ).append("\n"); 

	}
}