/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAORobPassRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.09.04 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAORobPassRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스케줄과 CTM의 VL, VD 날짜가 맞는지 확인
	  * </pre>
	  */
	public SettlementProcessDBDAORobPassRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration ").append("\n"); 
		query.append("FileName : SettlementProcessDBDAORobPassRSQL").append("\n"); 
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
		query.append("WITH PRE_VVD AS (  " ).append("\n"); 
		query.append("	SELECT DISTINCT " ).append("\n"); 
		query.append("	   VSL_CD" ).append("\n"); 
		query.append("	  ,TURN_SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,TURN_SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("	FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("	AND (TURN_SKD_VOY_NO IS NOT NULL OR TURN_SKD_DIR_CD IS NOT NULL) START WITH VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND TURN_PORT_IND_CD IN ('Y','N') CONNECT BY PRIOR TURN_SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("	AND PRIOR TURN_SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("	AND PRIOR VSL_CD = VSL_CD" ).append("\n"); 
		query.append("	AND TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("	AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NEXT_VVD AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     AA.VSL_CD" ).append("\n"); 
		query.append("    ,AA.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,AA.SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("            SELECT       " ).append("\n"); 
		query.append("            A.*" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                VSL_CD, SKD_VOY_NO, SKD_DIR_CD, MAX(VPS_ETD_DT) AS VPS_ETD_DT" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                AND SKD_VOY_NO >= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                AND TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("                GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("            ) A " ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND VPS_ETD_DT >  ( SELECT MAX(VPS_ETD_DT) " ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                  WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                  AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                  AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                              )                " ).append("\n"); 
		query.append("            ORDER BY VPS_ETD_DT ASC" ).append("\n"); 
		query.append("    ) AA" ).append("\n"); 
		query.append("    WHERE ROWNUM =1    " ).append("\n"); 
		query.append("), CTM AS (" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("    FROM CTM_MOVEMENT A  " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.MVMT_STS_CD IN ('VL','VD')" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("            (  A.CRNT_VSL_CD = (SELECT VSL_CD FROM PRE_VVD) AND A.CRNT_SKD_VOY_NO = (SELECT SKD_VOY_NO FROM PRE_VVD) AND A.CRNT_SKD_DIR_CD = (SELECT SKD_DIR_CD FROM PRE_VVD) )" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            (  A.CRNT_VSL_CD = SUBSTR(@[vvd],1,4) AND A.CRNT_SKD_VOY_NO = SUBSTR(@[vvd],5,4) AND A.CRNT_SKD_DIR_CD = SUBSTR(@[vvd],9,1) )        " ).append("\n"); 
		query.append("            OR        " ).append("\n"); 
		query.append("            (  A.CRNT_VSL_CD = (SELECT VSL_CD FROM NEXT_VVD) AND A.CRNT_SKD_VOY_NO = (SELECT SKD_VOY_NO FROM NEXT_VVD) AND A.CRNT_SKD_DIR_CD = (SELECT SKD_DIR_CD FROM NEXT_VVD) )" ).append("\n"); 
		query.append("        )  " ).append("\n"); 
		query.append("), MVMT_DT AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     AA.CNTR_NO, CNMV_YR, CNMV_ID_NO, MVMT_STS_CD, CNMV_EVNT_DT, INP_YD_CD, CRNT_VSL_CD, CRNT_SKD_VOY_NO, CRNT_SKD_DIR_CD     " ).append("\n"); 
		query.append("    ,MAX(CLPT_IND_SEQ2) AS CLPT_IND_SEQ2" ).append("\n"); 
		query.append("    ,MAX(CLPT_IND_SEQ3) AS CLPT_IND_SEQ3" ).append("\n"); 
		query.append("    ,MAX(CNMV_DT) AS CNMV_DT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("             A.CNTR_NO" ).append("\n"); 
		query.append("            ,A.CNMV_YR" ).append("\n"); 
		query.append("            ,A.CNMV_ID_NO" ).append("\n"); 
		query.append("            ,A.MVMT_STS_CD" ).append("\n"); 
		query.append("            ,A.CNMV_EVNT_DT" ).append("\n"); 
		query.append("            ,A.INP_YD_CD" ).append("\n"); 
		query.append("            ,A.CRNT_VSL_CD" ).append("\n"); 
		query.append("            ,A.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("            ,A.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("            ,V.VPS_ETA_DT     " ).append("\n"); 
		query.append("            ,V.VPS_ETD_DT" ).append("\n"); 
		query.append("            ,V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,V.YD_CD        " ).append("\n"); 
		query.append("            ,(  CASE WHEN TO_NUMBER(TO_CHAR(A.CNMV_EVNT_DT,'YYYYMMDDHH24MISS')) >= TO_NUMBER(TO_CHAR(V.VPS_ETA_DT,'YYYYMMDDHH24MISS'))    AND " ).append("\n"); 
		query.append("                          TO_NUMBER(TO_CHAR(A.CNMV_EVNT_DT,'YYYYMMDDHH24MISS')) <= TO_NUMBER(TO_CHAR(V.VPS_ETD_DT,'YYYYMMDDHH24MISS')) " ).append("\n"); 
		query.append("                     THEN V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     ELSE '0'" ).append("\n"); 
		query.append("                     END " ).append("\n"); 
		query.append("             ) CLPT_IND_SEQ2            " ).append("\n"); 
		query.append("            ,J.CLPT_IND_SEQ AS CLPT_IND_SEQ3" ).append("\n"); 
		query.append("            ,J.CNMV_DT" ).append("\n"); 
		query.append("        FROM CTM A, VSK_VSL_PORT_SKD V, JOO_CNTR_MVMT_EVNT_DT J" ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("        AND A.CNTR_NO = J.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND A.CNMV_YR = J.CNMV_YR(+)" ).append("\n"); 
		query.append("        AND A.CNMV_ID_NO = J.CNMV_ID_NO(+)    " ).append("\n"); 
		query.append("        AND V.VSL_CD = A.CRNT_VSL_CD" ).append("\n"); 
		query.append("        AND V.SKD_VOY_NO = A.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("        AND V.SKD_DIR_CD = A.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("        AND V.VPS_PORT_CD = SUBSTR(A.INP_YD_CD,1,5)" ).append("\n"); 
		query.append("        AND V.YD_CD = A.INP_YD_CD     " ).append("\n"); 
		query.append("		     ) AA" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     GROUP BY CNTR_NO, CNMV_YR, CNMV_ID_NO, MVMT_STS_CD, CNMV_EVNT_DT, INP_YD_CD, CRNT_VSL_CD, CRNT_SKD_VOY_NO, CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("), MVMT_DT2 AS (  " ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("         A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNMV_YR" ).append("\n"); 
		query.append("        ,A.CNMV_ID_NO" ).append("\n"); 
		query.append("        ,A.MVMT_STS_CD" ).append("\n"); 
		query.append("        ,A.CNMV_EVNT_DT" ).append("\n"); 
		query.append("        ,A.INP_YD_CD" ).append("\n"); 
		query.append("        ,A.CRNT_VSL_CD" ).append("\n"); 
		query.append("        ,A.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.CLPT_IND_SEQ2" ).append("\n"); 
		query.append("        ,A.CLPT_IND_SEQ3" ).append("\n"); 
		query.append("        ,DECODE(A.CLPT_IND_SEQ2,'0',CNMV_DT,A.CNMV_EVNT_DT) AS CNMV_DT" ).append("\n"); 
		query.append("    FROM MVMT_DT A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MVMT_DT3 AS (" ).append("\n"); 
		query.append("    SELECT CASE WHEN COUNT(1) = 0 THEN 'P'" ).append("\n"); 
		query.append("                ELSE 'NP'" ).append("\n"); 
		query.append("                END PASS" ).append("\n"); 
		query.append("    FROM MVMT_DT2 M" ).append("\n"); 
		query.append("    WHERE M.CNMV_DT IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT PASS FROM MVMT_DT3" ).append("\n"); 

	}
}