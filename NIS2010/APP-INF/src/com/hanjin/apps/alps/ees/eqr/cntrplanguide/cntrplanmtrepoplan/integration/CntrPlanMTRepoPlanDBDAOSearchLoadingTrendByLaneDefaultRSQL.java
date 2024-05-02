/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPlanMTRepoPlanDBDAOSearchLoadingTrendByLaneDefaultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanMTRepoPlanDBDAOSearchLoadingTrendByLaneDefaultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면 기본 설정을 위한 값들 조회
	  * </pre>
	  */
	public CntrPlanMTRepoPlanDBDAOSearchLoadingTrendByLaneDefaultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration").append("\n"); 
		query.append("FileName : CntrPlanMTRepoPlanDBDAOSearchLoadingTrendByLaneDefaultRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', SYSDATE-7, @[ofc_cd]), 'YYYY-MM-DD') ETA_FM_DT " ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', SYSDATE+7, @[ofc_cd]), 'YYYY-MM-DD') ETA_TO_DT " ).append("\n"); 
		query.append("       ,( SELECT PLN_YR||PLN_WK" ).append("\n"); 
		query.append("            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("            WHERE TO_CHAR(SYSDATE-7,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT ) FM_WK" ).append("\n"); 
		query.append("       ,( SELECT PLN_YR||PLN_WK" ).append("\n"); 
		query.append("            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("            WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT ) TO_WK" ).append("\n"); 
		query.append("       ,( SELECT A.RCC_CD " ).append("\n"); 
		query.append("            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                ,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("           WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("             AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("             AND C.OFC_CD = @[ofc_cd] ) RCC_CD" ).append("\n"); 
		query.append("       ,( SELECT C.OFC_TP_CD" ).append("\n"); 
		query.append("            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                ,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("           WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("             AND B.LOC_CD = C.LOC_CD " ).append("\n"); 
		query.append("             AND C.OFC_CD = @[ofc_cd] ) OFC_TP_CD" ).append("\n"); 
		query.append("       ,( SELECT" ).append("\n"); 
		query.append("            LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_HDR_CD,'|')),'|')||'$$'||LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_HDR_NM,'|')),'|') PLN_RSN_HDR_CODE_N_TEXT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                ROWNUM ROW_ID, H.PLN_RSN_HDR_CD, H.PLN_RSN_HDR_NM" ).append("\n"); 
		query.append("                FROM  EQR_CTRL_PLN_RSN_HDR H" ).append("\n"); 
		query.append("                ORDER BY H.DP_SEQ" ).append("\n"); 
		query.append("            	)" ).append("\n"); 
		query.append("            CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("            START WITH ROW_ID = 1 ) PLN_RSN_HDR_CODE_N_TEXT" ).append("\n"); 
		query.append("       ,( SELECT	" ).append("\n"); 
		query.append("            LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_SUB_CODE,'|')),'|')||'$$'||LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_SUB_TEXT,'|')),'|') PLN_RSN_SUB_CODE_N_TEXT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                ROWNUM ROW_ID, H.PLN_RSN_HDR_NM||'@@'||S.PLN_RSN_SUB_NM PLN_RSN_SUB_TEXT, S.PLN_RSN_HDR_CD||S.PLN_RSN_SUB_CD PLN_RSN_SUB_CODE" ).append("\n"); 
		query.append("                FROM EQR_CTRL_PLN_RSN_HDR H, EQR_CTRL_PLN_RSN_SUB S" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND H.PLN_RSN_HDR_CD = S.PLN_RSN_HDR_CD" ).append("\n"); 
		query.append("                ORDER BY S.DP_SEQ" ).append("\n"); 
		query.append("            	)" ).append("\n"); 
		query.append("            CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("            START WITH ROW_ID = 1 ) PLN_RSN_SUB_CODE_N_TEXT" ).append("\n"); 
		query.append("       ,( SELECT	" ).append("\n"); 
		query.append("			NVL(C.CONTI_CD,'') CONTI_CD" ).append("\n"); 
		query.append("			FROM MDM_ORGANIZATION B, (SELECT C.* FROM MDM_LOCATION C WHERE NVL(C.DELT_FLG,'N') <> 'Y') C" ).append("\n"); 
		query.append("			WHERE	1 = 1" ).append("\n"); 
		query.append("			AND B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("			AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("			AND B.LOC_CD = C.LOC_CD(+)" ).append("\n"); 
		query.append("			AND ROWNUM <= 1 ) LOGIN_OFC_CONTI_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}