/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCanalTzTierCalcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCanalTzTierCalcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BAY PLAN SURCHARGE를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCanalTzTierCalcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCanalTzTierCalcRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        VSL_CD || VOY_NO || DIR_CD VVD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("		, VOY_NO" ).append("\n"); 
		query.append("		, DIR_CD" ).append("\n"); 
		query.append("		, PORT_CD AS SCG_CAR_PORT_CD" ).append("\n"); 
		query.append("		, CALL_IND" ).append("\n"); 
		query.append("        , CASE WHEN RNK='Y' THEN" ).append("\n"); 
		query.append("            TIER_1ST" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            TIER_2ND" ).append("\n"); 
		query.append("        END SCG_CAR_TIER" ).append("\n"); 
		query.append("        , CASE WHEN RNK='Y' THEN" ).append("\n"); 
		query.append("            TEU_1ST" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            TEU_2ND" ).append("\n"); 
		query.append("        END SCG_CAR_TEU" ).append("\n"); 
		query.append("		, TR_SCG_RTO AS SCG_CAR_RATIO" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	ROW_NUMBER () OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS SEQ" ).append("\n"); 
		query.append("				, VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND" ).append("\n"); 
		query.append("				, DECODE(SIGN(TEU - 11), -1, 'N', 'Y') AS RNK" ).append("\n"); 
		query.append("				, TIER_NO AS TIER_1ST				" ).append("\n"); 
		query.append("				, LEAD (TIER_NO) OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS TIER_2ND" ).append("\n"); 
		query.append("				, TEU AS TEU_1ST" ).append("\n"); 
		query.append("				, LEAD (TEU) OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS TEU_2ND				" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND" ).append("\n"); 
		query.append("						, TIER_NO AS TIER_NO" ).append("\n"); 
		query.append("						, MAX(MAX_TIER_BY_BAY) AS TIER_ORG" ).append("\n"); 
		query.append("						, SUM(CASE WHEN (TIER = MAX_TIER_BY_BAY) THEN TEU ELSE 0 END) AS TEU" ).append("\n"); 
		query.append("				FROM	(	" ).append("\n"); 
		query.append("							SELECT	T1.VSL_CD" ).append("\n"); 
		query.append("									, T1.VOY_NO" ).append("\n"); 
		query.append("									, T1.DIR_CD" ).append("\n"); 
		query.append("									, T1.PORT_CD" ).append("\n"); 
		query.append("									, T1.CALL_IND" ).append("\n"); 
		query.append("									, T1.PLAN_TYPE" ).append("\n"); 
		query.append("									, T1.BAY" ).append("\n"); 
		query.append("									, T1.TIER									" ).append("\n"); 
		query.append("									, MAX(T1.TIER) OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY ) AS MAX_TIER_BY_BAY" ).append("\n"); 
		query.append("									, COUNT (DISTINCT T1.TIER) OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY ) AS TIER_NO							" ).append("\n"); 
		query.append("									, SUM( CASE WHEN T1.SZTP LIKE 'D2%' THEN 1 ELSE 2 END ) AS TEU" ).append("\n"); 
		query.append("									, ROW_NUMBER () OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY, T1.TIER ORDER BY T1.TIER DESC, T1.PLAN_TYPE DESC) AS PLAN_TYPE_SEQ 						" ).append("\n"); 
		query.append("							FROM	BAY_PLAN T1" ).append("\n"); 
		query.append("							WHERE	1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--							AND		T2.VSL_CD	(+)= T1.VSL_CD" ).append("\n"); 
		query.append("--							AND		T2.VOY_NO	(+)= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("--							AND		T2.DIR_CD	(+)= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("--							AND		T2.PORT_CD	(+)= T1.PRE_PORT" ).append("\n"); 
		query.append("--							AND		T2.CALL_IND	(+)= T1.PRE_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("							AND		(T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND) IN " ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("#foreach(${param} in ${tgtVvd})" ).append("\n"); 
		query.append("	#if($velocityCount < $tgtVvd.size())" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}', '${param.bayLoc}', '${param.bayCal}')," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}', '${param.bayLoc}', '${param.bayCal}')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("							AND		T1.TIER		>= '50'" ).append("\n"); 
		query.append("							GROUP BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.PLAN_TYPE, T1.BAY, T1.TIER" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				WHERE	PLAN_TYPE_SEQ	= 1		" ).append("\n"); 
		query.append("				GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, TIER_NO	" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		) T1, VSK_PORT_CNL_TR_SCG T2" ).append("\n"); 
		query.append("WHERE	T2.LOC_CD		= 'EGSCA'" ).append("\n"); 
		query.append("AND		T2.TR_SEQ		= DECODE(RNK, 'Y', TIER_1ST, TIER_2ND) " ).append("\n"); 
		query.append("AND		T1.SEQ			= 1" ).append("\n"); 

	}
}