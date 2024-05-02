/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력 받은 Lane Code로 생성된 Standard P/F SKD Detail 정보를 조회한다.
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration").append("\n"); 
		query.append("FileName : LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL").append("\n"); 
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
		query.append("WITH V_PORT AS (" ).append("\n"); 
		query.append("    SELECT T2.SKD_DIR_CD" ).append("\n"); 
		query.append("         , T2.PORT_CD AS LOC_CD" ).append("\n"); 
		query.append("         , CASE WHEN T4.VSL_SLAN_DIR_SEQ = 1 AND TURN_PORT_IND_CD = 'N' AND PORT_ROTN_SEQ = 1 THEN 'Y'" ).append("\n"); 
		query.append("                ELSE T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("           END TURN_PORT_IND_CD" ).append("\n"); 
		query.append("         , T2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("         , T4.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("         , T1.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("         , CASE WHEN T4.VSL_SLAN_DIR_SEQ = 1 AND (TURN_PORT_IND_CD = 'Y' OR (TURN_PORT_IND_CD = 'N' AND PORT_ROTN_SEQ = 1)) THEN 50 " ).append("\n"); 
		query.append("                WHEN T4.VSL_SLAN_DIR_SEQ = 1 AND TURN_PORT_IND_CD = 'N' AND PORT_ROTN_SEQ > 1 THEN 100" ).append("\n"); 
		query.append("                WHEN T4.VSL_SLAN_DIR_SEQ = 2 AND TURN_PORT_IND_CD = 'Y' THEN 50" ).append("\n"); 
		query.append("                ELSE 0 END OB_RTO" ).append("\n"); 
		query.append("         , CASE WHEN T4.VSL_SLAN_DIR_SEQ = 2 AND TURN_PORT_IND_CD = 'N' AND PORT_ROTN_SEQ > 1 THEN 100" ).append("\n"); 
		query.append("                ELSE 0 END IB_RTO" ).append("\n"); 
		query.append("         , MAX(T2.PORT_ROTN_SEQ) OVER () AS MAX_ROW" ).append("\n"); 
		query.append("         , MAX(T2.PORT_ROTN_SEQ) OVER (PARTITION BY T4.VSL_SLAN_DIR_SEQ) AS MAX_SEQ_ROW" ).append("\n"); 
		query.append("      FROM VSK_PF_SKD T1" ).append("\n"); 
		query.append("         , VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("         , MDM_VSL_SVC_LANE T3" ).append("\n"); 
		query.append("         , MDM_VSL_SVC_LANE_DIR T4" ).append("\n"); 
		query.append("     WHERE T1.VSL_SLAN_CD   = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("       AND T1.PF_SVC_TP_CD  = T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("       AND T1.VSL_SLAN_CD   = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("       AND T2.VSL_SLAN_CD   = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("       AND T2.SKD_DIR_CD    = T4.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("       AND T1.VSL_SLAN_CD   = @[vsl_slan_cd]" ).append("\n"); 
		query.append("       AND T1.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("       AND T3.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("       AND T2.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("     ORDER BY T2.PORT_ROTN_SEQ  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT;" ).append("\n"); 
		query.append(", V_PORT_IN AS (" ).append("\n"); 
		query.append("    SELECT DECODE(SKD_DIR_CD,'E','W','W','E','S','N','S') AS SKD_DIR_CD" ).append("\n"); 
		query.append("         , LOC_CD" ).append("\n"); 
		query.append("         , 'N' AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append("         , ROWNUM AS PORT_ROTN_SEQ" ).append("\n"); 
		query.append("         , 2 AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("         , SLAN_CD" ).append("\n"); 
		query.append("         , 0 AS OB_RTO" ).append("\n"); 
		query.append("         , 50 AS IB_RTO" ).append("\n"); 
		query.append("      FROM V_PORT" ).append("\n"); 
		query.append("     WHERE VSL_SLAN_DIR_SEQ = 1" ).append("\n"); 
		query.append("       AND TURN_PORT_IND_CD = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT_IN;" ).append("\n"); 
		query.append(", V_PORT_OUT AS (" ).append("\n"); 
		query.append("    SELECT DECODE(SKD_DIR_CD,'E','W','W','E','S','N','S') AS SKD_DIR_CD" ).append("\n"); 
		query.append("         , LOC_CD" ).append("\n"); 
		query.append("         , 'N' AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append("         , ROWNUM AS PORT_ROTN_SEQ" ).append("\n"); 
		query.append("         , 1 AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("         , SLAN_CD" ).append("\n"); 
		query.append("         , 0 AS OB_RTO" ).append("\n"); 
		query.append("         , 50 AS IB_RTO" ).append("\n"); 
		query.append("      FROM V_PORT" ).append("\n"); 
		query.append("     WHERE VSL_SLAN_DIR_SEQ = 2" ).append("\n"); 
		query.append("       AND TURN_PORT_IND_CD = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT_OUT;" ).append("\n"); 
		query.append("SELECT SKD_DIR_CD" ).append("\n"); 
		query.append("     , LOC_CD" ).append("\n"); 
		query.append("     --, TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     --, ROWNUM AS PORT_ROTN_SEQ" ).append("\n"); 
		query.append("     --, VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("     , SLAN_CD" ).append("\n"); 
		query.append("     , OB_RTO" ).append("\n"); 
		query.append("     , IB_RTO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SKD_DIR_CD" ).append("\n"); 
		query.append("             , LOC_CD" ).append("\n"); 
		query.append("             , TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , PORT_ROTN_SEQ" ).append("\n"); 
		query.append("             , VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("             , SLAN_CD" ).append("\n"); 
		query.append("             , OB_RTO" ).append("\n"); 
		query.append("             , IB_RTO" ).append("\n"); 
		query.append("          FROM V_PORT" ).append("\n"); 
		query.append("         WHERE VSL_SLAN_DIR_SEQ = 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT SKD_DIR_CD" ).append("\n"); 
		query.append("             , LOC_CD" ).append("\n"); 
		query.append("             , TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , PORT_ROTN_SEQ" ).append("\n"); 
		query.append("             , VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("             , SLAN_CD" ).append("\n"); 
		query.append("             , OB_RTO" ).append("\n"); 
		query.append("             , IB_RTO" ).append("\n"); 
		query.append("          FROM V_PORT_OUT" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT SKD_DIR_CD" ).append("\n"); 
		query.append("             , LOC_CD" ).append("\n"); 
		query.append("             , TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , PORT_ROTN_SEQ" ).append("\n"); 
		query.append("             , VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("             , SLAN_CD" ).append("\n"); 
		query.append("             , OB_RTO" ).append("\n"); 
		query.append("             , IB_RTO" ).append("\n"); 
		query.append("          FROM V_PORT" ).append("\n"); 
		query.append("         WHERE VSL_SLAN_DIR_SEQ = 2" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT SKD_DIR_CD" ).append("\n"); 
		query.append("             , LOC_CD" ).append("\n"); 
		query.append("             , TURN_PORT_IND_CD" ).append("\n"); 
		query.append("             , PORT_ROTN_SEQ" ).append("\n"); 
		query.append("             , VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("             , SLAN_CD" ).append("\n"); 
		query.append("             , OB_RTO" ).append("\n"); 
		query.append("             , IB_RTO" ).append("\n"); 
		query.append("          FROM V_PORT_IN" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}