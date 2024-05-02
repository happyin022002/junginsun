/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTransitScheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchCanalTransitScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AgentCanalTransitFeeBCDBDAO
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchCanalTransitScheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTransitScheduleRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("		T5.SVC_SCP_BND_CD" ).append("\n"); 
		query.append("		,DECODE(T5.SVC_SCP_BND_CD, 'N', 'North', 'S', 'South') BOUND" ).append("\n"); 
		query.append("		,T2.VSL_CD" ).append("\n"); 
		query.append("		,T2.SKD_DIR_CD" ).append("\n"); 
		query.append("		,T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("		,T3.VSL_ENG_NM ||'('|| T3.VSL_CD ||')' VSL_ENG_NM" ).append("\n"); 
		query.append("		,T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("		,T2.VPS_PORT_CD" ).append("\n"); 
		query.append("		,T2.CLPT_SEQ" ).append("\n"); 
		query.append("		,TO_CHAR(T2.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("		,TO_CHAR(T2.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append("		,TO_CHAR(T2.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("        ,(SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("          AND SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND CLPT_SEQ > T2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND VPS_ETA_DT > T2.VPS_ETA_DT" ).append("\n"); 
		query.append("          AND NVL(SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("          AND ROWNUM=1" ).append("\n"); 
		query.append("        ) NXT_PORT_CD" ).append("\n"); 
		query.append("        ,(SELECT CLPT_SEQ" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("          AND SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND CLPT_SEQ > T2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND VPS_ETA_DT > T2.VPS_ETA_DT" ).append("\n"); 
		query.append("          AND NVL(SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("          AND ROWNUM=1" ).append("\n"); 
		query.append("        ) NXT_PORT_CLPT_SEQ" ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("          AND SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND CLPT_SEQ > T2.CLPT_SEQ" ).append("\n"); 
		query.append("          AND VPS_ETA_DT > T2.VPS_ETA_DT" ).append("\n"); 
		query.append("          AND NVL(SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("          AND ROWNUM=1" ).append("\n"); 
		query.append("        ) NXT_PORT_ETA" ).append("\n"); 
		query.append("        ,(SELECT 'Y' FROM PSO_TGT_VVD" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND VSL_CD=T1.VSL_CD" ).append("\n"); 
		query.append("          AND SKD_VOY_NO=T1.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND SKD_DIR_CD=T1.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND PSO_BZTP_CD='5'" ).append("\n"); 
		query.append("		  --AND BUD_SCNR_NO 		= '999912'" ).append("\n"); 
		query.append("          ) TGT_VVD_EXIST_FLG" ).append("\n"); 
		query.append("       ,@[i_page] I_PAGE  --현재 페이지 번호" ).append("\n"); 
		query.append("       ,ROWNUM RN" ).append("\n"); 
		query.append("FROM   VSK_VSL_SKD T1" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE T4" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE_DIR T5" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND    T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    NVL(T2.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("AND    (T2.VPS_PORT_CD = 'EGSUZ' OR T2.VPS_PORT_CD = 'PAPAC')" ).append("\n"); 
		query.append("AND    T2.VPS_ETB_DT BETWEEN TO_DATE(@[tgt_yrmon], 'YYYYMM')" ).append("\n"); 
		query.append("                     AND ADD_MONTHS(TO_DATE(@[tgt_yrmon], 'YYYYMM'), 1)" ).append("\n"); 
		query.append("AND    T2.VSL_CD = T3.VSL_CD" ).append("\n"); 
		query.append("AND    T3.CRR_CD = 'HJS'" ).append("\n"); 
		query.append("AND    T1.VSL_SLAN_CD = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    T4.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("	#if (${lane_cd} != '') " ).append("\n"); 
		query.append("AND    T1.VSL_SLAN_CD =  @[lane_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND    T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("AND		T1.VSL_SLAN_CD	= T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND		T1.SKD_DIR_CD	= T5.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("--AND		T5.SVC_SCP_BND_CD IS NOT NULL" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND		T4.CNL_AGN_VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("ORDER BY T2.VPS_ETB_DT ASC" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append(" WHERE RN BETWEEN (@[pagerows]*(@[i_page]-1)+1) AND (@[pagerows]*@[i_page])  --pagerows:명시적이지 않은 숨은 매개변수:페이지당레코드수" ).append("\n"); 

	}
}