/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCargoVolByBayPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.11 정진우
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

public class VesselScheduleMgtDBDAOSearchCargoVolByBayPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCargoVolByBayPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCargoVolByBayPlanRSQL").append("\n"); 
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
		query.append("SELECT	TP_20_QTY, TP_40_QTY" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	/* GROUP START */" ).append("\n"); 
		query.append("				ROW_NUMBER() OVER (ORDER BY DECODE(PLAN_TYPE, 'F', 0, 1)) AS PLAN_TYPE_SEQ" ).append("\n"); 
		query.append("				, SUM(DECODE(SUBSTR(SZTP, 2, 1), 2, 1, 0)) AS TP_20_QTY" ).append("\n"); 
		query.append("				, SUM(DECODE(SUBSTR(SZTP, 2, 1), 2, 0, 1)) AS TP_40_QTY" ).append("\n"); 
		query.append("		FROM	BAY_PLAN" ).append("\n"); 
		query.append("		WHERE	1	= 1" ).append("\n"); 
		query.append("		AND		POD	= @[vps_port_cd]" ).append("\n"); 
		query.append("		AND		(VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, POL) IN " ).append("\n"); 
		query.append("				(	/* IN STRART */" ).append("\n"); 
		query.append("					SELECT	/* T50 START */" ).append("\n"); 
		query.append("							VSL_CD, SKD_VOY_NO,SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ, VPS_PORT_CD" ).append("\n"); 
		query.append("					FROM	(" ).append("\n"); 
		query.append("							SELECT	/* T40 START */" ).append("\n"); 
		query.append("									NO, VSL_CD, SKD_VOY_NO,SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("									, MAX(NO) OVER () AS LAST_PAY" ).append("\n"); 
		query.append("							FROM	(" ).append("\n"); 
		query.append("									SELECT	/* T30 START */" ).append("\n"); 
		query.append("											NO, VSL_CD, SKD_VOY_NO,SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ," ).append("\n"); 
		query.append("											NVL((	SELECT	1" ).append("\n"); 
		query.append("													FROM	BAY_PLAN S" ).append("\n"); 
		query.append("													WHERE	T30.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("													AND		T30.SKD_VOY_NO	= S.VOY_NO" ).append("\n"); 
		query.append("													AND		T30.SKD_DIR_CD	= S.DIR_CD" ).append("\n"); 
		query.append("													AND		T30.VPS_PORT_CD	= S.PORT_CD" ).append("\n"); 
		query.append("													AND		T30.CLPT_IND_SEQ= S.CALL_IND" ).append("\n"); 
		query.append("													AND		ROWNUM			= 1" ).append("\n"); 
		query.append("												), 0) AS CHK_PAY" ).append("\n"); 
		query.append("									FROM	(" ).append("\n"); 
		query.append("											SELECT	/* T20 START */" ).append("\n"); 
		query.append("													--SKIP 전 PORT와 CONTI CODE가 동일한 것과 최초 CONTI CODE가 바뀌는 PORT까지를 조회한다." ).append("\n"); 
		query.append("													T20.*" ).append("\n"); 
		query.append("													, FIRST_VALUE(NO) OVER (ORDER BY CHK ASC, NO DESC ROWS UNBOUNDED PRECEDING) AS STR_ROW" ).append("\n"); 
		query.append("													, LAST_VALUE(NO) OVER (ORDER BY ROWNUM ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS END_ROW" ).append("\n"); 
		query.append("											FROM	(" ).append("\n"); 
		query.append("													SELECT	/* T10 START */" ).append("\n"); 
		query.append("															--TARGET DATA 조회 : SKIP PORT VVD 포함, SKIP VVD와 연결된 바로 전 TURNING VVD와 연결된 VIRTUAL VVD를 조회한다." ).append("\n"); 
		query.append("															ROW_NUMBER() OVER (ORDER BY CLPT_SEQ) AS NO" ).append("\n"); 
		query.append("															, VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("															, CONTI_CD				" ).append("\n"); 
		query.append("															, DECODE(CONTI_CD, LAST_VALUE(CONTI_CD) OVER (ORDER BY ROWNUM ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING), 1, 0) AS CHK" ).append("\n"); 
		query.append("													FROM	(" ).append("\n"); 
		query.append("																SELECT	VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ, CONTI_CD, CLPT_SEQ" ).append("\n"); 
		query.append("																FROM	VSK_VSL_PORT_SKD T1, MDM_LOCATION T2" ).append("\n"); 
		query.append("																WHERE	T1.VPS_PORT_CD	= T2.LOC_CD" ).append("\n"); 
		query.append("																AND		VSL_CD      	= @[vsl_cd]" ).append("\n"); 
		query.append("																AND		SKD_VOY_NO  	= ( SELECT  TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("                                                                                            FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                                            WHERE   VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                                                                            AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("																                            AND     SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("																                            AND     TURN_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("																                            AND     ROWNUM = 1" ).append("\n"); 
		query.append("																                          )" ).append("\n"); 
		query.append("																AND		SKD_DIR_CD  	= ( SELECT  TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                            FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                                            WHERE   VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                                                                            AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("																                            AND     SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("																                            AND     TURN_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("																                            AND     ROWNUM = 1" ).append("\n"); 
		query.append("																                          )" ).append("\n"); 
		query.append("																AND		VPS_PORT_CD	NOT IN ('EGSUZ', 'PAPAC')" ).append("\n"); 
		query.append("																AND		TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("																AND		'S'			!= NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("																UNION ALL" ).append("\n"); 
		query.append("																SELECT	VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD,CLPT_IND_SEQ, CONTI_CD, CLPT_SEQ + 100 AS CLPT_SEQ" ).append("\n"); 
		query.append("																FROM	VSK_VSL_PORT_SKD T1, MDM_LOCATION T2" ).append("\n"); 
		query.append("																WHERE	T1.VPS_PORT_CD	= T2.LOC_CD" ).append("\n"); 
		query.append("																AND		VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("																AND		SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("																AND		SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("																AND		VPS_PORT_CD	NOT IN ('EGSUZ', 'PAPAC')" ).append("\n"); 
		query.append("																AND		'S'			!= NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("																AND		CLPT_SEQ	<" ).append("\n"); 
		query.append("																(" ).append("\n"); 
		query.append("																	SELECT	CLPT_SEQ" ).append("\n"); 
		query.append("																	FROM	VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("																	WHERE	T1.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("																	AND		T1.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("																	AND		T1.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("																	AND		S.VPS_PORT_CD	= @[vps_port_cd]" ).append("\n"); 
		query.append("																	AND		S.CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 
		query.append("																)" ).append("\n"); 
		query.append("															) T10 /* T10 END */" ).append("\n"); 
		query.append("													) T20	/* T20 END */" ).append("\n"); 
		query.append("											) T30" ).append("\n"); 
		query.append("									WHERE	NO BETWEEN STR_ROW AND END_ROW  /* T30 END */" ).append("\n"); 
		query.append("									) T40" ).append("\n"); 
		query.append("							WHERE	CHK_PAY	= 1 /* T40 END */" ).append("\n"); 
		query.append("							) T50" ).append("\n"); 
		query.append("					WHERE	LAST_PAY	= NO	/* T50 END */" ).append("\n"); 
		query.append("				)  /* IN END */" ).append("\n"); 
		query.append("		GROUP BY PLAN_TYPE /* GROUP END */" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE	PLAN_TYPE_SEQ = 1" ).append("\n"); 

	}
}