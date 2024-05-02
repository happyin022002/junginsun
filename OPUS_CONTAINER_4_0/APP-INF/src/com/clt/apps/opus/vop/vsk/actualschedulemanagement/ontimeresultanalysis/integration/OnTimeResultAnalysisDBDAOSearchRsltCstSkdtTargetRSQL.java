/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltCstSkdtTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltCstSkdtTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Port Schedule 을 이용한 지연 조회
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltCstSkdtTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltCstSkdtTargetRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	 '' VSL_SLAN_CD" ).append("\n"); 
		query.append("	,'' VSL_CD" ).append("\n"); 
		query.append("	,'' SKD_VOY_NO" ).append("\n"); 
		query.append("	,'' SUB_TRD_DIR_CD" ).append("\n"); 
		query.append("	,'' VPS_PORT_CD" ).append("\n"); 
		query.append("	,'' CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,'' CLPT_SEQ" ).append("\n"); 
		query.append("	,'' SKD_DIR_CD" ).append("\n"); 
		query.append("	,'' YD_CD" ).append("\n"); 
		query.append("	,'' PF_ETB_DT" ).append("\n"); 
		query.append("	,'' PF_ETD_DT" ).append("\n"); 
		query.append("	,'' ACT_BRTH_DT" ).append("\n"); 
		query.append("	,'' ACT_DEP_DT" ).append("\n"); 
		query.append("	,'' CONTI_CD" ).append("\n"); 
		query.append("	,'' ARR_DLAY_RSN_CD1" ).append("\n"); 
		query.append("	,'' ARR_DLAY_RSN_CD2" ).append("\n"); 
		query.append("	,'' DEP_DLAY_RSN_CD1" ).append("\n"); 
		query.append("	,'' DEP_DLAY_RSN_CD2" ).append("\n"); 
		query.append("	,'' ACT_INP_YRMON" ).append("\n"); 
		query.append("	,'' ARR_DLAY_HRS1" ).append("\n"); 
		query.append("	,'' ARR_DLAY_HRS2" ).append("\n"); 
		query.append("	,'' DEP_DLAY_HRS1" ).append("\n"); 
		query.append("	,'' DEP_DLAY_HRS2" ).append("\n"); 
		query.append("	,'' TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	,'' SKD_CNG_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("    ,T1.VSL_CD" ).append("\n"); 
		query.append("    ,@[voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("    ,@[dir_cd] AS SUB_TRD_DIR_CD" ).append("\n"); 
		query.append("    ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("    ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,ROWNUM AS CLPT_SEQ" ).append("\n"); 
		query.append("    ,DECODE(Y, '0', T1.SKD_DIR_CD, '1', T1.TURN_SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("    ,T1.YD_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(T1.PF_ETB_DT, 'YYYY-MM-DD HH24:MI') PF_ETB_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(T1.PF_ETD_DT, 'YYYY-MM-DD HH24:MI') PF_ETD_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(T2.ACT_BRTH_DT, 'YYYY-MM-DD HH24:MI') ACT_BRTH_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(T2.ACT_DEP_DT, 'YYYY-MM-DD HH24:MI') ACT_DEP_DT" ).append("\n"); 
		query.append("    ,T1.CONTI_CD" ).append("\n"); 
		query.append("    ,T1.VSL_DLAY_RSN_CD AS ARR_DLAY_RSN_CD1" ).append("\n"); 
		query.append("    ,T2.VSL_ARR_DLAY_RSN_CD AS ARR_DLAY_RSN_CD2" ).append("\n"); 
		query.append("    ,T2.VSL_BRTH_DLAY_RSN_CD AS DEP_DLAY_RSN_CD1" ).append("\n"); 
		query.append("    ,T2.VSL_DEP_DLAY_RSN_CD AS DEP_DLAY_RSN_CD2" ).append("\n"); 
		query.append("	,TO_CHAR(T2.ACT_DEP_DT, 'YYYYMM') ACT_INP_YRMON" ).append("\n"); 
		query.append("	,'0' ARR_DLAY_HRS1" ).append("\n"); 
		query.append("	,'0' ARR_DLAY_HRS2" ).append("\n"); 
		query.append("	,'0' DEP_DLAY_HRS1" ).append("\n"); 
		query.append("	,'0' DEP_DLAY_HRS2" ).append("\n"); 
		query.append("	,T1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	,T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT T1.* FROM (" ).append("\n"); 
		query.append("        SELECT T1.*, DECODE(T1.TURN_PORT_IND_CD, 'N', 0, 'Y', 0, X) Y FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("				T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                ,T2.VSL_CD" ).append("\n"); 
		query.append("                ,CASE WHEN (T2.TURN_PORT_IND_CD = 'D' OR T2.TURN_PORT_IND_CD = 'V' OR T2.TURN_PORT_IND_CD = 'F') THEN" ).append("\n"); 
		query.append("                    T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                    T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                END AS SKD_VOY_NO" ).append("\n"); 
		query.append("                ,CASE WHEN (T2.TURN_PORT_IND_CD = 'D' OR T2.TURN_PORT_IND_CD = 'V' OR T2.TURN_PORT_IND_CD = 'F') THEN" ).append("\n"); 
		query.append("                    T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                    T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                END SKD_DIR_CD" ).append("\n"); 
		query.append("                ,CASE WHEN (T2.TURN_PORT_IND_CD = 'D' OR T2.TURN_PORT_IND_CD = 'V' OR T2.TURN_PORT_IND_CD = 'F') THEN" ).append("\n"); 
		query.append("                    T2.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                    T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                END AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                ,T2.VPS_PORT_CD " ).append("\n"); 
		query.append("                ,T2.YD_CD" ).append("\n"); 
		query.append("                ,T2.PF_ETB_DT" ).append("\n"); 
		query.append("                ,T2.PF_ETD_DT" ).append("\n"); 
		query.append("                ,T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                ,T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                ,DECODE(T3.CONTI_CD, 'F', 'E', T3.CONTI_CD) CONTI_CD /* 아프리카는 유럽 CONTI_CD로 처리 */" ).append("\n"); 
		query.append("                ,T2.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("                ,T2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                ,RANK() OVER(PARTITION BY T2.TURN_PORT_IND_CD ORDER BY T2.CLPT_SEQ ASC) X" ).append("\n"); 
		query.append("            FROM VSK_VSL_SKD T1, VSK_VSL_PORT_SKD T2, MDM_LOCATION T3" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("            AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("            AND T1.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("            AND T1.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("            AND T2.TURN_PORT_IND_CD != 'V'" ).append("\n"); 
		query.append("--			AND NVL(T2.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("            AND T3.LOC_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND T2.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("#if (${clpt_seq} != '') " ).append("\n"); 
		query.append("            AND TO_CHAR(T2.CLPT_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( $key in ${clpt_seq}) " ).append("\n"); 
		query.append("            #if($velocityCount < $clpt_seq.size())" ).append("\n"); 
		query.append("                '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ORDER BY T2.CLPT_SEQ" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 
		query.append("    WHERE T1.Y <= 1" ).append("\n"); 
		query.append(") T1, VSK_ACT_PORT_SKD T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD(+)" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND T1.VPS_PORT_CD = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 

	}
}