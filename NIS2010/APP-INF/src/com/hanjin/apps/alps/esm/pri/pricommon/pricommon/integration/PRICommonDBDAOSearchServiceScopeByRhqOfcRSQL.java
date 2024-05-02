/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRICommonDBDAOSearchServiceScopeByRhqOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSearchServiceScopeByRhqOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ 별 Service Scope 리스트 정보를 조회합니다.
	  * 2014.12.09 [CHM-201433135] [Add-on/IHC Tariff > SIN] 국가코드 ZA 추가
	  * </pre>
	  */
	public PRICommonDBDAOSearchServiceScopeByRhqOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchServiceScopeByRhqOfcRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SCP.SVC_SCP_CD AS CD" ).append("\n"); 
		query.append("              , SVC.SVC_SCP_NM AS NM" ).append("\n"); 
		query.append("FROM   MDM_SVC_SCP_LMT SCP, MDM_REGION RGN, MDM_SVC_SCP SVC, AOC_TRF_CURR AOC_CURR," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("#if(${cd} == 'SHARC' || ${cd} == '')" ).append("\n"); 
		query.append("        /* SHARC */" ).append("\n"); 
		query.append("        SELECT 'SHARC' AS RHQ_CD, A.CONTI_CD , B.SCONTI_CD  , C.CNT_CD  , C.CNT_NM  " ).append("\n"); 
		query.append("        FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        WHERE  A.CONTI_CD = 'A'" ).append("\n"); 
		query.append("        AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        AND    B.SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("        AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        #if(${cd} == '')" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${cd} == 'SINRS' || ${cd} == '')" ).append("\n"); 
		query.append("        /* SINRS */" ).append("\n"); 
		query.append("        SELECT 'SINRS' AS RHQ_CD, A.CONTI_CD, B.SCONTI_CD, C.CNT_CD, C.CNT_NM" ).append("\n"); 
		query.append("        FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        WHERE  A.CONTI_CD IN ('A', 'F')" ).append("\n"); 
		query.append("        AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        AND    B.SCONTI_CD <> 'AF'" ).append("\n"); 
		query.append("        AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        #if(${cd} == '')" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cd} == 'NYCRA' || ${cd} == '')" ).append("\n"); 
		query.append("        /* NYCRA */" ).append("\n"); 
		query.append("        SELECT 'NYCRA' AS RHQ_CD, A.CONTI_CD, B.SCONTI_CD, C.CNT_CD, C.CNT_NM" ).append("\n"); 
		query.append("        FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        WHERE  A.CONTI_CD = 'M'" ).append("\n"); 
		query.append("        AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        #if(${cd} == '')" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cd} == 'HAMRU' || ${cd} == '')" ).append("\n"); 
		query.append("        /* HAMRU */" ).append("\n"); 
		query.append("        SELECT 'HAMRU' AS RHQ_CD, A.CONTI_CD, B.SCONTI_CD, C.CNT_CD, C.CNT_NM" ).append("\n"); 
		query.append("        FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("        WHERE  A.CONTI_CD IN ('E', 'F')" ).append("\n"); 
		query.append("        AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("        AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("        AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("        ) RHQ" ).append("\n"); 
		query.append("WHERE  SCP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    SCP.RGN_CD   = RGN.RGN_CD" ).append("\n"); 
		query.append("AND    RGN.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    RGN.CNT_CD   = RHQ.CNT_CD" ).append("\n"); 
		query.append("AND    SCP.SVC_SCP_CD = SVC.SVC_SCP_CD" ).append("\n"); 
		query.append("AND    RGN.CNT_CD = AOC_CURR.CNT_CD" ).append("\n"); 
		query.append("AND    RHQ.RHQ_CD = AOC_CURR.RHQ_CD" ).append("\n"); 
		query.append("AND    SCP.ORG_DEST_CD = @[etc1]" ).append("\n"); 
		query.append("AND NOT ( " ).append("\n"); 
		query.append("	(RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEE' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("	OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEF' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("	OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'AEE' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("	OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'IAA' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("	OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'O' and  SVC.SVC_SCP_CD = 'IAA' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("	OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'D' and  SVC.SVC_SCP_CD = 'FES' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append("	OR (RHQ.RHQ_CD = 'HAMRU' AND SCP.ORG_DEST_CD = 'O' and  SVC.SVC_SCP_CD = 'FEN' and RHQ.CNT_CD = 'EG')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${etc2} != '')" ).append("\n"); 
		query.append("    AND RHQ.CNT_CD IN ( #foreach(${key} in ${list_cnt_cd})" ).append("\n"); 
		query.append("                                #if($velocityCount < $list_cnt_cd.size())" ).append("\n"); 
		query.append("                                    '$key', " ).append("\n"); 
		query.append("                                #else  " ).append("\n"); 
		query.append("                                    '$key'" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                         #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SCP.SVC_SCP_CD" ).append("\n"); 

	}
}