/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCstSimDifferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.01.26 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCstSimDifferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCstSimDifferenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCstSimDifferenceRSQL").append("\n"); 
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
		query.append("SELECT	'Only Simulation data exists : (' || T.VSL_CD ||'/'|| T.SKD_VOY_NO ||'/'|| T.SKD_DIR_CD ||'/'|| T.VPS_PORT_CD ||'/'|| T.CLPT_IND_SEQ ||'/'|| T.CLPT_SEQ || ')' AS CHK_CST_SIM" ).append("\n"); 
		query.append("FROM	VSK_SWAP_CST_PORT T" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		T.SIM_DT	= TO_DATE(@[sim_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND		T.SIM_NO	= LTRIM(TO_CHAR(TO_NUMBER(@[sim_no])))" ).append("\n"); 
		query.append("AND		NOT EXISTS	( 	SELECT	'X'" ).append("\n"); 
		query.append("						FROM	VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("						WHERE	T.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("						AND		T.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND		T.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND		T.VPS_PORT_CD	= S.VPS_PORT_CD" ).append("\n"); 
		query.append("						AND		T.CLPT_IND_SEQ	= S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'Only Coastal data exists : (' || T02.VSL_CD ||'/'|| T02.SKD_VOY_NO ||'/'|| T02.SKD_DIR_CD ||'/'|| T02.VPS_PORT_CD ||'/'|| T02.CLPT_IND_SEQ ||'/'|| T02.CLPT_SEQ || ')'" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	LAST_VALUE(RNK) OVER (ORDER BY ROWNUM ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)  AS LAST_ROW" ).append("\n"); 
		query.append("				, T01.*" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	DENSE_RANK() OVER (PARTITION BY T1.VSL_CD ORDER BY  N1ST_PORT_BRTH_DT) AS RNK" ).append("\n"); 
		query.append("						, T1.SIM_DT, T1.SIM_NO, T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ, T2.CLPT_SEQ" ).append("\n"); 
		query.append("						, T2.TURN_PORT_FLG, T2.TURN_PORT_IND_CD, T2.TURN_SKD_VOY_NO, T2.TURN_SKD_DIR_CD, T2.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				FROM	VSK_SWAP_CST_VVD T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("				WHERE	1 = 1" ).append("\n"); 
		query.append("				AND		T1.SIM_DT		= TO_DATE(@[sim_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("				AND		T1.SIM_NO		= LTRIM(TO_CHAR(TO_NUMBER(@[sim_no])))" ).append("\n"); 
		query.append("				AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("				AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("				ORDER BY DENSE_RANK() OVER (PARTITION BY T1.VSL_CD ORDER BY  N1ST_PORT_BRTH_DT), T2.CLPT_SEQ" ).append("\n"); 
		query.append("				) T01" ).append("\n"); 
		query.append("		) T02" ).append("\n"); 
		query.append("WHERE	1 = " ).append("\n"); 
		query.append("		CASE" ).append("\n"); 
		query.append("		WHEN (LAST_ROW != RNK) AND NVL(TURN_PORT_IND_CD, ' ') IN ('N',      'Y') THEN 1 /* 마지막 VVD가 아니면서, 일반 PORT일 경우    : 조회 됨  */" ).append("\n"); 
		query.append("		WHEN (LAST_ROW  = RNK) AND NVL(TURN_PORT_IND_CD, ' ') IN ('N',      'Y') THEN 1 /* 마지막 VVD가 이면서  , 일반 PORT일 경우    : 조회 됨  */" ).append("\n"); 
		query.append("		WHEN (LAST_ROW  = RNK) AND NVL(TURN_PORT_IND_CD, ' ') IN ('D', 'V', 'F') THEN 1	/* 마지막 VVD가 이면서  , VIRTUAL PORT일 경우 : 조회 됨  */	" ).append("\n"); 
		query.append("		ELSE 0 END																		/* 마지막 VVD가 아니면서, VIRTUAL PORT일 경우 : 조회 안됨*/" ).append("\n"); 
		query.append("AND		NOT EXISTS	( 	SELECT	'X'" ).append("\n"); 
		query.append("						FROM	VSK_SWAP_CST_PORT S" ).append("\n"); 
		query.append("						WHERE	1	= 1" ).append("\n"); 
		query.append("						AND		T02.SIM_DT			= S.SIM_DT" ).append("\n"); 
		query.append("						AND		T02.SIM_NO			= S.SIM_NO" ).append("\n"); 
		query.append("						AND		T02.VSL_CD			= S.VSL_CD" ).append("\n"); 
		query.append("						AND		T02.SKD_VOY_NO		= S.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND		T02.SKD_DIR_CD		= S.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND		T02.VPS_PORT_CD		= S.VPS_PORT_CD" ).append("\n"); 
		query.append("						AND		T02.CLPT_IND_SEQ	= S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("					)" ).append("\n"); 

	}
}