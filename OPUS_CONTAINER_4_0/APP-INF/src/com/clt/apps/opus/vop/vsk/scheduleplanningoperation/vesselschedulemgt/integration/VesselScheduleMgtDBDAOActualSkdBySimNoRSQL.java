/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOActualSkdBySimNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.18 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOActualSkdBySimNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOActualSkdBySimNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOActualSkdBySimNoRSQL").append("\n"); 
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
		query.append("SELECT	SEQ" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, VPS_PORT_CD" ).append("\n"); 
		query.append("		, CLPT_IND_SEQ" ).append("\n"); 
		query.append("		, CLPT_SEQ" ).append("\n"); 
		query.append("		, PORT_SKD_STS_CD" ).append("\n"); 
		query.append("		, TURN_PORT_IND_CD" ).append("\n"); 
		query.append("		, TO_CHAR(ACT_ARR_DT, 'YYYYMMDDHH24MI') AS ACT_ARR_DT" ).append("\n"); 
		query.append("		, TO_CHAR(ACT_BRTH_DT, 'YYYYMMDDHH24MI') AS ACT_BRTH_DT" ).append("\n"); 
		query.append("		, TO_CHAR(ACT_DEP_DT, 'YYYYMMDDHH24MI') AS ACT_DEP_DT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	ROW_NUMBER() OVER (ORDER BY RNK, CLPT_SEQ) AS SEQ " ).append("\n"); 
		query.append("				, LAST_VALUE(RNK) OVER (ORDER BY ROWNUM ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)  AS LAST_ROW" ).append("\n"); 
		query.append("				, T01.*" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	DENSE_RANK() OVER (PARTITION BY T1.VSL_CD ORDER BY  N1ST_PORT_BRTH_DT) AS RNK" ).append("\n"); 
		query.append("						, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("						, T2.VPS_PORT_CD" ).append("\n"); 
		query.append("						, T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("						, T2.CLPT_SEQ" ).append("\n"); 
		query.append("						, T2.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("						, T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("						, ACT_ARR_DT" ).append("\n"); 
		query.append("						, ACT_BRTH_DT" ).append("\n"); 
		query.append("						, ACT_DEP_DT" ).append("\n"); 
		query.append("				FROM	VSK_SWAP_CST_VVD	T1" ).append("\n"); 
		query.append("						, VSK_SWAP_CST_PORT T2" ).append("\n"); 
		query.append("						, VSK_ACT_PORT_SKD	T3" ).append("\n"); 
		query.append("				WHERE	1 = 1" ).append("\n"); 
		query.append("				AND		T1.SIM_DT		= T2.SIM_DT" ).append("\n"); 
		query.append("				AND		T1.SIM_NO		= T2.SIM_NO" ).append("\n"); 
		query.append("				AND		T1.SIM_DT		= TO_DATE(@[sim_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("				AND		T1.SIM_NO		= LTRIM(TO_CHAR(TO_NUMBER(@[sim_no])))" ).append("\n"); 
		query.append("				AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("				AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND		T2.VSL_CD		= T3.VSL_CD			(+)" ).append("\n"); 
		query.append("				AND		T2.SKD_VOY_NO	= T3.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("				AND		T2.SKD_DIR_CD	= T3.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("				AND		T2.VPS_PORT_CD	= T3.VPS_PORT_CD	(+)" ).append("\n"); 
		query.append("				AND		T2.CLPT_IND_SEQ	= T3.CLPT_IND_SEQ	(+)" ).append("\n"); 
		query.append("				ORDER BY DENSE_RANK() OVER (PARTITION BY T1.VSL_CD ORDER BY  N1ST_PORT_BRTH_DT), T2.CLPT_SEQ" ).append("\n"); 
		query.append("				) T01" ).append("\n"); 
		query.append("		) T02" ).append("\n"); 
		query.append("WHERE	1 = " ).append("\n"); 
		query.append("		CASE" ).append("\n"); 
		query.append("		WHEN (LAST_ROW != RNK) AND NVL(TURN_PORT_IND_CD, ' ') IN ('N',      'Y') THEN 1 /* 마지막 VVD가 아니면서, 일반 PORT일 경우    : 조회 됨  */" ).append("\n"); 
		query.append("		WHEN (LAST_ROW  = RNK) AND NVL(TURN_PORT_IND_CD, ' ') IN ('N',      'Y') THEN 1 /* 마지막 VVD가 이면서  , 일반 PORT일 경우    : 조회 됨  */" ).append("\n"); 
		query.append("		WHEN (LAST_ROW  = RNK) AND NVL(TURN_PORT_IND_CD, ' ') IN ('D', 'V', 'F') THEN 1	/* 마지막 VVD가 이면서  , VIRTUAL PORT일 경우 : 조회 됨  */	" ).append("\n"); 
		query.append("		ELSE 0 END" ).append("\n"); 
		query.append("ORDER BY RNK, CLPT_SEQ" ).append("\n"); 

	}
}