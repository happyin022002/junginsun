/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodSimulateDBDAOSearchCODVskDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.29
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.07.29 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOSearchCODVskDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_VSL_SKD 에서 특정 vvd의 VSL_LOC_CD, VSL_ETD_DT 를 검색
	  * </pre>
	  */
	public CodSimulateDBDAOSearchCODVskDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchCODVskDataRSQL").append("\n"); 
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
		query.append("#if (${view_sc} != '') " ).append("\n"); 
		query.append("	#if (${col} == 'to_ecc_cd_tmp') " ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("        TO_CHAR(ROW_NUMBER()OVER(ORDER BY VSL_ETB_DT), '00')||'-'||VSL_LOC_CD AS VSL_LOC_CD" ).append("\n"); 
		query.append("		,VSL_ETD_DT" ).append("\n"); 
		query.append("		,VSL_ETB_DT" ).append("\n"); 
		query.append("		,YD_CD" ).append("\n"); 
		query.append("		,SLAN_CD" ).append("\n"); 
		query.append("		POD_USE_FLG" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			ROWNUM AS NUM" ).append("\n"); 
		query.append("			,VSL_LOC_CD" ).append("\n"); 
		query.append("			,VSL_ETD_DT" ).append("\n"); 
		query.append("			,VSL_ETB_DT" ).append("\n"); 
		query.append("			,YD_CD" ).append("\n"); 
		query.append("			,SLAN_CD" ).append("\n"); 
		query.append("			,DECODE(POD_USE_FLG, 'Y', 'TRUE', 'N', 'TRUE', '') AS POD_USE_FLG " ).append("\n"); 
		query.append("			FROM ( " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${col} == 'fm_ecc_cd_tmp') " ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			TO_CHAR(ROW_NUMBER()OVER(ORDER BY VSL_ETB_DT), '00')||'-'||VSL_LOC_CD AS VSL_LOC_CD" ).append("\n"); 
		query.append("			,VSL_ETD_DT" ).append("\n"); 
		query.append("			,VSL_ETB_DT" ).append("\n"); 
		query.append("       		,YD_CD" ).append("\n"); 
		query.append("	   		,SLAN_CD" ).append("\n"); 
		query.append("			,ROWNUM" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		SELECT VPS_PORT_CD AS VSL_LOC_CD" ).append("\n"); 
		query.append("       		,TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS' ,'NLS_DATE_LANGUAGE=AMERICAN') AS VSL_ETD_DT" ).append("\n"); 
		query.append("			,TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD HH24:MI:SS','NLS_DATE_LANGUAGE=AMERICAN') AS VSL_ETB_DT" ).append("\n"); 
		query.append("       		,YD_CD" ).append("\n"); 
		query.append("	   		,SLAN_CD" ).append("\n"); 
		query.append("       		,ROWNUM" ).append("\n"); 
		query.append("			#if (${col} == 'to_ecc_cd_tmp')" ).append("\n"); 
		query.append("			,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("          	FROM MDM_EQ_ORZ_CHT EOC" ).append("\n"); 
		query.append("         	WHERE EOC.SCC_CD = VPS_PORT_CD" ).append("\n"); 
		query.append("         	AND   EOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         	AND   EOC.RCC_CD  =  (SELECT SUB.RCC_CD" ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION MO, MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append("                                 WHERE MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                   AND MO.LOC_CD = SUB.SCC_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ), 'N')  AS POD_USE_FLG " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	 	WHERE VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("	 		AND SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("	 		AND SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 
		query.append("	#if (${col} == 'fm_ecc_cd_tmp') " ).append("\n"); 
		query.append("            AND TURN_PORT_IND_CD NOT IN ( 'D', 'V')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     		AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                  FROM   MDM_EQ_ORZ_CHT CHT, MDM_LOCATION ML" ).append("\n"); 
		query.append("                  WHERE  CHT.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("                  AND    VPS_PORT_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                  AND    ROWNUM      = 1)" ).append("\n"); 
		query.append("	 		AND SLAN_CD 	    = DECODE(@[vsl_lane_cd], NULL, DECODE(@[vsl_cd], NULL, @[vsl_lane_cd], SLAN_CD)  " ).append("\n"); 
		query.append("                                               , @[vsl_lane_cd])" ).append("\n"); 
		query.append("	 	#if (${vsl_loc_cd} != '')" ).append("\n"); 
		query.append("     		AND VPS_PORT_CD  = @[vsl_loc_cd]" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${poscol} == 'fm')" ).append("\n"); 
		query.append("     		AND TO_CHAR(VPS_ETD_DT ,'YYYYMMDD') >= (SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[pln_yrwk] )" ).append("\n"); 
		query.append("			ORDER BY  VPS_ETD_DT" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("     		AND TO_CHAR(VPS_ETB_DT ,'YYYYMMDD') >= TO_CHAR(TO_DATE( @[pln_yrwk],'YYYY-MM-DD') ,'YYYYMMDD')" ).append("\n"); 
		query.append("			ORDER BY  VPS_ETB_DT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${col} == 'fm_ecc_cd_tmp') " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${col} == 'to_ecc_cd_tmp')" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("	Z " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("--WHERE POD_USE_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${col} == 'to_ecc_cd_tmp') " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_LOC_CD" ).append("\n"); 
		query.append(",VSL_ETD_DT" ).append("\n"); 
		query.append(",VSL_ETB_DT" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",DECODE(POD_USE_FLG, 'Y', 'TRUE', 'N', 'TRUE', '') AS POD_USE_FLG " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT VPS_PORT_CD AS VSL_LOC_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS' ,'NLS_DATE_LANGUAGE=AMERICAN') AS VSL_ETD_DT" ).append("\n"); 
		query.append("-- CSR NO : N200903060090 의거 변경" ).append("\n"); 
		query.append("       ,TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD HH24:MI:SS','NLS_DATE_LANGUAGE=AMERICAN') AS VSL_ETB_DT" ).append("\n"); 
		query.append("       ,YD_CD" ).append("\n"); 
		query.append("	   ,SLAN_CD" ).append("\n"); 
		query.append("       ,ROWNUM" ).append("\n"); 
		query.append("		#if (${col} == 'to_ecc_cd_tmp')" ).append("\n"); 
		query.append("		,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("          FROM MDM_EQ_ORZ_CHT EOC" ).append("\n"); 
		query.append("         WHERE EOC.SCC_CD = VPS_PORT_CD" ).append("\n"); 
		query.append("         AND   EOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         AND   EOC.RCC_CD  =  (SELECT SUB.RCC_CD" ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION MO, MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append("                                 WHERE MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                   AND MO.LOC_CD = SUB.SCC_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ), 'N')  AS POD_USE_FLG " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	 WHERE VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("	 AND SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("	 AND SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 
		query.append("     AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                  FROM   MDM_EQ_ORZ_CHT CHT, MDM_LOCATION ML" ).append("\n"); 
		query.append("                  WHERE  CHT.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("                  AND    VPS_PORT_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                  AND    ROWNUM      = 1)" ).append("\n"); 
		query.append("	 AND SLAN_CD 	    = DECODE(@[vsl_lane_cd], NULL, DECODE(@[vsl_cd], NULL, @[vsl_lane_cd], SLAN_CD)  " ).append("\n"); 
		query.append("                                               , @[vsl_lane_cd])" ).append("\n"); 
		query.append("	 #if (${vsl_loc_cd} != '')" ).append("\n"); 
		query.append("     AND VPS_PORT_CD  = @[vsl_loc_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${poscol} == 'fm')" ).append("\n"); 
		query.append("     AND TO_CHAR(VPS_ETD_DT ,'YYYYMMDD') >= (SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[pln_yrwk] )" ).append("\n"); 
		query.append("ORDER BY  VPS_ETD_DT" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("     AND TO_CHAR(VPS_ETB_DT ,'YYYYMMDD') >= TO_CHAR(TO_DATE( @[pln_yrwk],'YYYY-MM-DD') ,'YYYYMMDD')" ).append("\n"); 
		query.append("ORDER BY  VPS_ETB_DT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#if (${col} == 'to_ecc_cd_tmp')" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("Z " ).append("\n"); 
		query.append("--WHERE POD_USE_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}