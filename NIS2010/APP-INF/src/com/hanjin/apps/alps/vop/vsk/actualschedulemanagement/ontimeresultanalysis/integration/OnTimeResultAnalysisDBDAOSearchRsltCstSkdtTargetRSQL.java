/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltCstSkdtTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * =========================================================================
	  * 2011.05.03 CHM-201109190-01 진마리아 Report data Creation내 정시로직 변경 건
	  * 2013.01.25 황태진    CHM-201322271-01 정시율 조회 조건 변경 및 멀티 저장 처리  
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
		params.put("lan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inp_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     NVL2(RST.VSL_CD, 'C','U') 						AS RST_FLG" ).append("\n"); 
		query.append("     ,SKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("     ,SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD 	AS VVD " ).append("\n"); 
		query.append("     ,SKD.VSL_CD" ).append("\n"); 
		query.append("     ,SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("     ,SKD.SUB_TRD_DIR_CD" ).append("\n"); 
		query.append("     ,SKD.VPS_PORT_CD " ).append("\n"); 
		query.append("     ,SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     ,SKD.CLPT_SEQ " ).append("\n"); 
		query.append("     ,SKD.SKD_DIR_CD " ).append("\n"); 
		query.append("     ,RST.ACT_INP_YRMON " ).append("\n"); 
		query.append("     ,TO_CHAR(TO_DATE(RST.ACT_INP_YRMON,'YYYYMM'), 'YYYY-MM') RST_INP_YRMON " ).append("\n"); 
		query.append("     ,MIN(NVL(RST.PF_ETB_DT,   SKD.PF_ETB_DT)) OVER(PARTITION BY SKD.VSL_CD, SKD.SKD_VOY_NO, SKD.SKD_DIR_CD  )   ORD  " ).append("\n"); 
		query.append("     ,SKD.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("     ,TO_CHAR(NVL(RST.PF_ETB_DT,   SKD.PF_ETB_DT), 'YYYY-MM-DD HH24:MI')   AS PF_ETB_DT " ).append("\n"); 
		query.append("     ,SKD.PRE_PF_ETD_DT         AS BFR_PF_ETD_DT --KJH Modify 2015.02" ).append("\n"); 
		query.append("     ,TO_CHAR(NVL(RST.PF_ETD_DT,   SKD.PF_ETD_DT), 'YYYY-MM-DD HH24:MI')   AS PF_ETD_DT " ).append("\n"); 
		query.append("     ,TO_CHAR(NVL(RST.ACT_BRTH_DT, SKD.ACT_BRTH_DT), 'YYYY-MM-DD HH24:MI') AS ACT_BRTH_DT " ).append("\n"); 
		query.append("     ,SKD.PRE_ACT_ETD_DT        AS BFR_ACT_DEP_DT --KJH Modify 2015.02" ).append("\n"); 
		query.append("     ,TO_CHAR(NVL(RST.ACT_DEP_DT,  SKD.ACT_DEP_DT), 'YYYY-MM-DD HH24:MI')  AS ACT_DEP_DT " ).append("\n"); 
		query.append("     ,NVL(RST.ARR_DLAY_HRS1,  SKD.ARR_DLAY_HRS1) AS ARR_DLAY_HRS1 " ).append("\n"); 
		query.append("     ,NVL(RST.ARR_DLAY_HRS2,  SKD.ARR_DLAY_HRS2) AS ARR_DLAY_HRS2 " ).append("\n"); 
		query.append("     ,NVL(RST.ARR_DLAY_RSN_CD1,  SKD.ARR_DLAY_RSN_CD1) AS ARR_DLAY_RSN_CD1 " ).append("\n"); 
		query.append("     ,NVL(RST.ARR_DLAY_RSN_CD2,  SKD.ARR_DLAY_RSN_CD2) AS ARR_DLAY_RSN_CD2 " ).append("\n"); 
		query.append("     ,NVL(RST.DEP_DLAY_HRS1,  SKD.DEP_DLAY_HRS1) AS DEP_DLAY_HRS1 " ).append("\n"); 
		query.append("     ,NVL(RST.DEP_DLAY_HRS2,  SKD.DEP_DLAY_HRS2) AS DEP_DLAY_HRS2 " ).append("\n"); 
		query.append("     ,NVL(RST.DEP_DLAY_RSN_CD1,  SKD.DEP_DLAY_RSN_CD1) AS DEP_DLAY_RSN_CD1 " ).append("\n"); 
		query.append("     ,NVL(RST.DEP_DLAY_RSN_CD2,  SKD.DEP_DLAY_RSN_CD2) AS DEP_DLAY_RSN_CD2 " ).append("\n"); 
		query.append("     ,RST.ARR_RMK1 " ).append("\n"); 
		query.append("     ,RST.ARR_RMK2 " ).append("\n"); 
		query.append("     ,RST.DEP_RMK1 " ).append("\n"); 
		query.append("     ,RST.DEP_RMK2" ).append("\n"); 
		query.append("     ,RST.INCL_BRTH_DLAY_HRS" ).append("\n"); 
		query.append("     ,RST.INCL_DEP_DLAY_HRS" ).append("\n"); 
		query.append("     ,RST.XCLD_BRTH_DLAY_HRS" ).append("\n"); 
		query.append("     ,RST.XCLD_DEP_DLAY_HRS" ).append("\n"); 
		query.append("     ,RST.VSKD_RSLT_XCLD_CD" ).append("\n"); 
		query.append("     ,SKD.YD_CD" ).append("\n"); 
		query.append("     ,SKD.CONTI_CD" ).append("\n"); 
		query.append("     ,SKD.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     ,SKD.CRR_CD AS ACT_CRR_CD" ).append("\n"); 
		query.append("     ,SKD.INIT_ETB_DT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("     (    " ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("            T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("           ,T2.VSL_CD" ).append("\n"); 
		query.append("           ,T2.SKD_VOY_NO" ).append("\n"); 
		query.append("           ,T2.SKD_DIR_CD AS SUB_TRD_DIR_CD" ).append("\n"); 
		query.append("           ,T2.VPS_PORT_CD " ).append("\n"); 
		query.append("           ,T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           ,T2.CLPT_SEQ " ).append("\n"); 
		query.append("           ,T2.SKD_DIR_CD " ).append("\n"); 
		query.append("           ,T2.YD_CD" ).append("\n"); 
		query.append("           ,T2.PF_ETB_DT" ).append("\n"); 
		query.append("           ,T2.PF_ETD_DT" ).append("\n"); 
		query.append("           ,T4.ACT_BRTH_DT" ).append("\n"); 
		query.append("           ,T4.ACT_DEP_DT" ).append("\n"); 
		query.append("           ,DECODE(T3.CONTI_CD, 'F', 'E', T3.CONTI_CD) CONTI_CD /* 아프리카는 유럽 CONTI_CD로 처리 */" ).append("\n"); 
		query.append("           ,T2.VSL_DLAY_RSN_CD      AS ARR_DLAY_RSN_CD1" ).append("\n"); 
		query.append("           ,T4.VSL_ARR_DLAY_RSN_CD  AS ARR_DLAY_RSN_CD2" ).append("\n"); 
		query.append("           ,T4.VSL_BRTH_DLAY_RSN_CD AS DEP_DLAY_RSN_CD1" ).append("\n"); 
		query.append("           ,T4.VSL_DEP_DLAY_RSN_CD  AS DEP_DLAY_RSN_CD2" ).append("\n"); 
		query.append("            ,'0' ARR_DLAY_HRS1" ).append("\n"); 
		query.append("            ,'0' ARR_DLAY_HRS2" ).append("\n"); 
		query.append("            ,'0' DEP_DLAY_HRS1" ).append("\n"); 
		query.append("            ,'0' DEP_DLAY_HRS2" ).append("\n"); 
		query.append("           ,T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("           ,T2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("           ,NVL(T1.ACT_CRR_CD, T5.CRR_CD) CRR_CD" ).append("\n"); 
		query.append("	   ,T2.INIT_ETB_DT" ).append("\n"); 
		query.append("	   ,T6.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("	   ,LAG(T2.PF_ETD_DT   ) OVER (PARTITION BY T2.VSL_CD ORDER BY T2.SKD_VOY_NO, T6.VSL_SLAN_DIR_SEQ, T2.CLPT_SEQ)        AS PRE_PF_ETD_DT" ).append("\n"); 
		query.append("	   ,LAG(T4.ACT_DEP_DT  ) OVER (PARTITION BY T2.VSL_CD ORDER BY T2.SKD_VOY_NO, T6.VSL_SLAN_DIR_SEQ, T2.CLPT_SEQ)        AS PRE_ACT_ETD_DT" ).append("\n"); 
		query.append("        FROM VSK_VSL_SKD T1, " ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD T2, " ).append("\n"); 
		query.append("             MDM_LOCATION T3," ).append("\n"); 
		query.append("             MDM_VSL_CNTR T5," ).append("\n"); 
		query.append("             MDM_VSL_SVC_LANE_DIR T6," ).append("\n"); 
		query.append("             VSK_ACT_PORT_SKD T4" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("          AND T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND T3.LOC_CD       = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND T5.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("          AND T2.VSL_CD       = T4.VSL_CD" ).append("\n"); 
		query.append("          AND T2.SKD_VOY_NO   = T4.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND T2.SKD_DIR_CD   = T4.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND T2.VPS_PORT_CD  = T4.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND T2.CLPT_IND_SEQ = T4.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          AND T2.SLAN_CD          = T6.VSL_SLAN_CD" ).append("\n"); 
		query.append("          AND T2.SKD_DIR_CD       = T6.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("          AND T2.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("	  #if (${vsl_cd} != '' )" ).append("\n"); 
		query.append("		AND T2.VSL_CD        =  @[vsl_cd] " ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("	  #if (${lan_cd} != '') " ).append("\n"); 
		query.append("		AND T1.VSL_SLAN_CD      = @[lan_cd]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("	  #if (${act_crr_cd} == 'H')" ).append("\n"); 
		query.append("		AND NVL(T1.ACT_CRR_CD, T5.CRR_CD)		IN  ('SML' )" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("	  #if (${act_crr_cd} == 'O')" ).append("\n"); 
		query.append("		AND NVL(T1.ACT_CRR_CD, T5.CRR_CD)		NOT IN ('SML')" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("     ) SKD," ).append("\n"); 
		query.append("    VSK_VSL_SKD_RSLT RST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND SKD.VSL_CD            = RST.VSL_CD(+) " ).append("\n"); 
		query.append("  AND SKD.SKD_VOY_NO        = RST.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("  AND SKD.SKD_DIR_CD        = RST.SUB_TRD_DIR_CD(+) " ).append("\n"); 
		query.append("  AND SKD.VPS_PORT_CD       = RST.VPS_PORT_CD(+) " ).append("\n"); 
		query.append("  AND SKD.CLPT_IND_SEQ      = RST.CLPT_IND_SEQ(+) " ).append("\n"); 
		query.append("  #if (${act_inp_yrmon} != '')" ).append("\n"); 
		query.append("	AND TO_CHAR(SKD.ACT_DEP_DT, 'YYYYMM') = TO_CHAR(TO_DATE(@[act_inp_yrmon], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("	AND SKD.SKD_DIR_CD    = @[skd_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${vsl_cd} != '' )" ).append("\n"); 
		query.append("	AND SKD.VSL_CD        =  @[vsl_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${voy_no} !=  '')" ).append("\n"); 
		query.append("        AND SKD.SKD_VOY_NO    = @[voy_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${dir_cd} !=  '')" ).append("\n"); 
		query.append(" 	AND SKD.SKD_DIR_CD    = @[dir_cd]  " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("ORDER BY 	VSL_SLAN_CD " ).append("\n"); 
		query.append("		, 	ORD" ).append("\n"); 
		query.append("		, 	VSL_CD " ).append("\n"); 
		query.append("		, 	SKD_VOY_NO " ).append("\n"); 
		query.append("		, 	SKD_DIR_CD" ).append("\n"); 
		query.append("		, 	CLPT_SEQ" ).append("\n"); 

	}
}