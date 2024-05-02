/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAODrwSkdSearchRSQL.java
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

public class OnTimeResultAnalysisDBDAODrwSkdSearchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drewry Schedule 정보 조회
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAODrwSkdSearchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drw_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drw_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drw_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drw_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drw_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drw_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAODrwSkdSearchRSQL").append("\n"); 
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
		query.append("WITH TB1 AS ( SELECT  T1.POL_CD	" ).append("\n"); 
		query.append("		,T1.POL_YD_CD" ).append("\n"); 
		query.append("		,T1.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,T1.POL_CLPT_SEQ	" ).append("\n"); 
		query.append("		,T1.POD_CD" ).append("\n"); 
		query.append("		,T1.POD_YD_CD" ).append("\n"); 
		query.append("		,T1.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,T1.POD_CLPT_SEQ" ).append("\n"); 
		query.append("		,T1.SLAN_CD " ).append("\n"); 
		query.append("		,T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD   AS  VVD" ).append("\n"); 
		query.append("		,T1.VSL_CD" ).append("\n"); 
		query.append("		,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("		,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		,T3.CRR_CD" ).append("\n"); 
		query.append("		,T3.CNTR_VSL_CLSS_CAPA			AS TEU" ).append("\n"); 
		query.append("		,T1.POL_ACT_DEP_DT" ).append("\n"); 
		query.append("		,T1.POL_ACT_ATD_INP_DT" ).append("\n"); 
		query.append("		,T1.POD_VPS_ETA_DT" ).append("\n"); 
		query.append("		,T1.POD_VPS_ETB_DT" ).append("\n"); 
		query.append("		,(SELECT SKD_CNG_STS_CD " ).append("\n"); 
		query.append("			FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("			WHERE VSL_CD = T1.VSL_CD " ).append("\n"); 
		query.append("			AND SKD_VOY_NO = T1.SKD_VOY_NO " ).append("\n"); 
		query.append("			AND SKD_DIR_CD = T1.SKD_DIR_CD " ).append("\n"); 
		query.append("			AND SLAN_CD = T1.SLAN_CD" ).append("\n"); 
		query.append("			AND VPS_PORT_CD = T1.POD_CD " ).append("\n"); 
		query.append("			AND CLPT_IND_SEQ = T1.POD_CLPT_IND_SEQ ) AS OPT" ).append("\n"); 
		query.append("		,NVL(VP.TURN_SKD_VOY_NO,T1.SKD_VOY_NO )  TURN_NO  " ).append("\n"); 
		query.append("		,NVL(VP.TURN_SKD_DIR_CD,T1.SKD_DIR_CD )  TURN_CD" ).append("\n"); 
		query.append("		,T1.DRW_INP_YRMON" ).append("\n"); 
		query.append("FROM    VSK_VSL_DRW_SKD T1," ).append("\n"); 
		query.append("	    VSK_VSL_PORT_SKD VP," ).append("\n"); 
		query.append("        MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = VP.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = VP.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = VP.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.POD_CD       = VP.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     T1.POD_CLPT_IND_SEQ = VP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND     T1.VSL_CD = T3.VSL_CD(+)" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT	TA.POL_CD" ).append("\n"); 
		query.append("		,TA.POL_YD_CD" ).append("\n"); 
		query.append("		,TA.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,TA.POL_CLPT_SEQ" ).append("\n"); 
		query.append("    	,TA.POD_CD" ).append("\n"); 
		query.append("        ,TA.POD_YD_CD" ).append("\n"); 
		query.append("		,TA.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,TA.POD_CLPT_SEQ" ).append("\n"); 
		query.append("    	,TA.SLAN_CD" ).append("\n"); 
		query.append("    	,TA.VVD" ).append("\n"); 
		query.append("    	,TA.CRR_CD" ).append("\n"); 
		query.append("    	,TA.TEU" ).append("\n"); 
		query.append("    	,TA.POL_ACT_DEP_DT" ).append("\n"); 
		query.append("    	,TA.POL_ACT_ATD_INP_DT" ).append("\n"); 
		query.append("    	,TA.POD_VPS_ETA_DT" ).append("\n"); 
		query.append("    	,TA.POD_VPS_ETB_DT" ).append("\n"); 
		query.append("    	,T2.ACT_ARR_DT  AS POD_ACT_ARR_DT" ).append("\n"); 
		query.append("    	,T2.ACT_BRTH_DT    AS POD_ACT_BRTH_DT" ).append("\n"); 
		query.append("    	,TA.OPT" ).append("\n"); 
		query.append("    	,TA.DRW_INP_YRMON" ).append("\n"); 
		query.append("FROM	 TB1 TA" ).append("\n"); 
		query.append("	,VSK_ACT_PORT_SKD T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TA.VSL_CD = T2.VSL_CD(+) " ).append("\n"); 
		query.append("AND TA.TURN_NO = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND TA.TURN_CD = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND TA.POD_CD = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND TA.POD_CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#if (${drw_fm_dt} != ''&& ${drw_to_dt} != '')" ).append("\n"); 
		query.append("AND 	TO_CHAR(TA.POD_VPS_ETB_DT,'YYYYMM') BETWEEN TO_CHAR(TO_DATE( REPLACE(@[drw_fm_dt],'-'), 'YYYYMM'), 'YYYYMM') AND TO_CHAR(TO_DATE( REPLACE(@[drw_to_dt],'-'), 'YYYYMM'), 'YYYYMM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${drw_slan_cd} != '')" ).append("\n"); 
		query.append("AND 	TA.SLAN_CD = @[drw_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${drw_crr_cd} == 'H')" ).append("\n"); 
		query.append("AND 	TA.CRR_CD 	IN  ('SML' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${drw_crr_cd} == 'O')" ).append("\n"); 
		query.append("AND 	TA.CRR_CD 	NOT IN ('SML')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${drw_pol_cd} != '' && ${drw_pol_cd} != 'ALL')" ).append("\n"); 
		query.append("AND 	TA.POL_CD = @[drw_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${drw_pod_cd} != '' && ${drw_pod_cd} != 'ALL')" ).append("\n"); 
		query.append("AND 	TA.POD_CD = @[drw_pod_cd] 	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${drw_teu} != '')" ).append("\n"); 
		query.append("AND 	TA.TEU < @[drw_teu]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TA.SLAN_CD ,TA.VVD ,  TA.POL_ACT_DEP_DT" ).append("\n"); 

	}
}