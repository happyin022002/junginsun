/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TonnageTaxFillingDBDAOSearchHiringOutAndLayingUpSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxFillingDBDAOSearchHiringOutAndLayingUpSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대선선박과 계선선박의 내역을 조회한다.
	  * </pre>
	  */
	public TonnageTaxFillingDBDAOSearchHiringOutAndLayingUpSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration").append("\n"); 
		query.append("FileName : TonnageTaxFillingDBDAOSearchHiringOutAndLayingUpSummaryRSQL").append("\n"); 
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
		query.append("SELECT TRADE," ).append("\n"); 
		query.append("  LANE_CD," ).append("\n"); 
		query.append("  VSL_CD," ).append("\n"); 
		query.append("  VSL_ENG_NM," ).append("\n"); 
		query.append("  NET_RGST_TONG_WGT," ).append("\n"); 
		query.append("  ETD_START," ).append("\n"); 
		query.append("  CASE WHEN DIFF = 999 THEN TO_CHAR(TO_DATE(ETD_END, 'YYYYMMDD')+DAY, 'YYYYMMDD') ELSE ETD_END END ETD_END," ).append("\n"); 
		query.append("  USAGE," ).append("\n"); 
		query.append("  DAY," ).append("\n"); 
		query.append("  AMOUNT," ).append("\n"); 
		query.append("  PER_TON_REV," ).append("\n"); 
		query.append("  LEAD(VSL_CD) OVER (" ).append("\n"); 
		query.append("    ORDER BY VSL_CD, LANE_CD, ETD_START) AS NEXT_VSL_CD," ).append("\n"); 
		query.append("  LEAD(ETD_START) OVER (" ).append("\n"); 
		query.append("    ORDER BY VSL_CD, LANE_CD, ETD_START) AS NEXT_ETD_START," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(ETD_END, 'YYYYMMDD') + 1, 'YYYYMMDD') ETD_END_NEXT_DAY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT TRADE," ).append("\n"); 
		query.append("      LANE_CD," ).append("\n"); 
		query.append("      VSL_CD," ).append("\n"); 
		query.append("      VSL_ENG_NM," ).append("\n"); 
		query.append("      NET_RGST_TONG_WGT," ).append("\n"); 
		query.append("      ETD_DT ETD_START ," ).append("\n"); 
		query.append("      NVL(TO_CHAR(TO_DATE(ETD_LEAD, 'YYYYMMDD') - 1, 'YYYYMMDD'), ETD_DT) ETD_END," ).append("\n"); 
		query.append("      100 USAGE," ).append("\n"); 
		query.append("      DAY," ).append("\n"); 
		query.append("      TRUNC(PER_TON_REV * DAY) AMOUNT," ).append("\n"); 
		query.append("      PER_TON_REV," ).append("\n"); 
		query.append("      DECODE(NVL(DECODE(DAY - (TO_DATE(ETD_LEAD, 'YYYYMMDD') - TO_DATE(ETD_DT, 'YYYYMMDD')), 0, 0, DAY - (TO_DATE(ETD_LEAD, 'YYYYMMDD') - TO_DATE(ETD_DT, 'YYYYMMDD'))), 999), 999, 999, 0) DIFF" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A.VSL_CD," ).append("\n"); 
		query.append("          A.LDB_CAPA_QTY," ).append("\n"); 
		query.append("          A.BSA_CAPA," ).append("\n"); 
		query.append("          A.ACT_BSA_CAPA," ).append("\n"); 
		query.append("          SUM(A.VOY_DYS) DAY," ).append("\n"); 
		query.append("          TO_CHAR(A.ETD_DT, 'YYYYMMDD') ETD_DT," ).append("\n"); 
		query.append("          A.TONG_TAX_AMT," ).append("\n"); 
		query.append("          LEAD(TO_CHAR(A.ETD_DT, 'YYYYMMDD')) OVER (PARTITION BY A.VSL_CD" ).append("\n"); 
		query.append("            ORDER BY TO_CHAR(A.ETD_DT," ).append("\n"); 
		query.append("                  'YYYYMMDD')) ETD_LEAD," ).append("\n"); 
		query.append("          A.CHTR_BSA_CAPA," ).append("\n"); 
		query.append("          C.VSL_ENG_NM," ).append("\n"); 
		query.append("          C.NET_RGST_TONG_WGT," ).append("\n"); 
		query.append("          D.PER_TON_REV," ).append("\n"); 
		query.append("          MAX(A.SLAN_CD) LANE_CD," ).append("\n"); 
		query.append("          MAX(A.TRD_CD) TRADE" ).append("\n"); 
		query.append("        FROM TOT_PORT_STL_AMT A," ).append("\n"); 
		query.append("          MDM_VSL_CNTR C," ).append("\n"); 
		query.append("          TOT_VVD_STL_AMT D," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT MAX( TONG_STL_BAT_JB_SEQ ) TONG_STL_BAT_JB_SEQ," ).append("\n"); 
		query.append("              STL_YRMON" ).append("\n"); 
		query.append("            FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("            WHERE STL_YRMON BETWEEN @[year]||'01' AND @[year]||'12'" ).append("\n"); 
		query.append("            AND PORT_CD NOT IN ('FFFFF')" ).append("\n"); 
		query.append("            GROUP BY STL_YRMON ) B" ).append("\n"); 
		query.append("        WHERE A.STL_YRMON = B.STL_YRMON" ).append("\n"); 
		query.append("          AND A.TONG_STL_BAT_JB_SEQ = B.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("          AND A.STL_YRMON = D.STL_YRMON" ).append("\n"); 
		query.append("          AND A.TONG_STL_BAT_JB_SEQ = D.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("          AND A.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("          AND A.PORT_CD IN ('ZZZZZ'," ).append("\n"); 
		query.append("              'YYYYY')" ).append("\n"); 
		query.append("          AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("        GROUP BY A.VSL_CD, A.LDB_CAPA_QTY, A.BSA_CAPA, A.ACT_BSA_CAPA, TO_CHAR(A.ETD_DT, 'YYYYMMDD'), A.TONG_TAX_AMT, A.CHTR_BSA_CAPA, C.VSL_ENG_NM, C.NET_RGST_TONG_WGT, D.PER_TON_REV" ).append("\n"); 
		query.append("        ORDER BY A.VSL_CD, TO_CHAR(A.ETD_DT, 'YYYYMMDD') )" ).append("\n"); 
		query.append("    ORDER BY VSL_CD, LANE_CD, ETD_DT )" ).append("\n"); 
		query.append("ORDER BY VSL_CD, LANE_CD, ETD_START" ).append("\n"); 

	}
}