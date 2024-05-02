/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VslResidualSpaceManageDBDAOSearchVslRsdlSpaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VslResidualSpaceManageDBDAOSearchVslRsdlSpaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel R.Capa. [ EES_EQR_0060 ]
	  * EQR_SCNR_VSL_RSDL_CAPA 테이블에서 데이터 조회
	  * </pre>
	  */
	public VslResidualSpaceManageDBDAOSearchVslRsdlSpaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration").append("\n"); 
		query.append("FileName : VslResidualSpaceManageDBDAOSearchVslRsdlSpaceRSQL").append("\n"); 
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
		query.append("SELECT	 DECODE(CO_CD,'H','SML','S','SEN') AS CO_CD" ).append("\n"); 
		query.append("		,FCAST_YRWK" ).append("\n"); 
		query.append("		,ECC_CD" ).append("\n"); 
		query.append("		,VSL_LANE_CD" ).append("\n"); 
		query.append("		,VVD" ).append("\n"); 
		query.append("		,SUM(VSL_BSA_SPC)  AS VSL_BSA_SPC" ).append("\n"); 
		query.append("		,SUM(VSL_FULL_SPC) AS VSL_FULL_SPC" ).append("\n"); 
		query.append("		,SUM(VSL_DEAD_SPC) AS VSL_DEAD_SPC" ).append("\n"); 
		query.append("		,SUM(VSL_RSDL_SPC) AS VSL_RSDL_SPC" ).append("\n"); 
		query.append("		,SUM(VSL_SPC)      AS VSL_SPC" ).append("\n"); 
		query.append("		,SUM(TTL_RSDL_SPC) AS TTL_RSDL_SPC" ).append("\n"); 
		query.append("		,MAX(SCNR_ID)      AS SCNR_ID" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	FCAST_YRWK" ).append("\n"); 
		query.append("				,(SELECT	${typeby} " ).append("\n"); 
		query.append("				  FROM		EQR_ECC_MST" ).append("\n"); 
		query.append("				  WHERE		CA.ECC_CD = ECC_CD) ECC_CD" ).append("\n"); 
		query.append("				,VSL_LANE_CD" ).append("\n"); 
		query.append("				,VSL_CD|| SKD_VOY_NO||SKD_DIR_CD  VVD" ).append("\n"); 
		query.append("				,VSL_BSA_SPC" ).append("\n"); 
		query.append("				,VSL_FULL_SPC" ).append("\n"); 
		query.append("				,VSL_DEAD_SPC" ).append("\n"); 
		query.append("				,VSL_BSA_SPC - ( VSL_FULL_SPC + VSL_DEAD_SPC )  VSL_RSDL_SPC" ).append("\n"); 
		query.append("				,VSL_SPC" ).append("\n"); 
		query.append("				,TTL_RSDL_SPC" ).append("\n"); 
		query.append("				,CO_CD" ).append("\n"); 
		query.append("				,SCNR_ID	-- key : hidden" ).append("\n"); 
		query.append("		FROM	 EQR_SCNR_VSL_RSDL_CAPA CA" ).append("\n"); 
		query.append("				,EQR_ECC_MST EM" ).append("\n"); 
		query.append("		WHERE	CA.ECC_CD = EM.ECC_CD" ).append("\n"); 
		query.append("			AND SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("			AND	CA.FCAST_YRWK BETWEEN @[frweek] AND @[toweek]" ).append("\n"); 
		query.append("	#if (${status} != '')" ).append("\n"); 
		query.append("		#if (${status} == 'R') " ).append("\n"); 
		query.append("			AND EM.RCC_CD IN (" ).append("\n"); 
		query.append("			#foreach( $key in ${arrlocation}) " ).append("\n"); 
		query.append("				#if($velocityCount < $arrlocation.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("		#elseif (${status} == 'L') " ).append("\n"); 
		query.append("			AND EM.LCC_CD IN (" ).append("\n"); 
		query.append("			#foreach( $key in ${arrlocation}) " ).append("\n"); 
		query.append("				#if($velocityCount < $arrlocation.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("		#elseif (${status} == 'E') " ).append("\n"); 
		query.append("			AND EM.ECC_CD IN (" ).append("\n"); 
		query.append("			#foreach( $key in ${arrlocation}) " ).append("\n"); 
		query.append("				#if($velocityCount < $arrlocation.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if ( $arrlane.size() > 0 ) " ).append("\n"); 
		query.append("			AND CA.VSL_LANE_CD IN(" ).append("\n"); 
		query.append("			#foreach( $key in ${arrlane}) " ).append("\n"); 
		query.append("				#if($velocityCount < $arrlane.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if ( $arrvvd.size() > 0 )" ).append("\n"); 
		query.append("			AND CA.VSL_CD||CA.SKD_VOY_NO||CA.SKD_DIR_CD IN (" ).append("\n"); 
		query.append("			#foreach( $key in ${arrvvd}) " ).append("\n"); 
		query.append("				#if($velocityCount < $arrvvd.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("GROUP BY	FCAST_YRWK" ).append("\n"); 
		query.append("		,	ECC_CD" ).append("\n"); 
		query.append("		,	VSL_LANE_CD" ).append("\n"); 
		query.append("		,	VVD" ).append("\n"); 
		query.append("		,	CO_CD" ).append("\n"); 
		query.append("ORDER BY	FCAST_YRWK" ).append("\n"); 
		query.append("		,	ECC_CD" ).append("\n"); 
		query.append("		,	VSL_LANE_CD" ).append("\n"); 
		query.append("		,	VVD" ).append("\n"); 

	}
}