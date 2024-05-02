/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchBunkerQtyBySpeedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.01.29 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchBunkerQtyBySpeedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchBunkerQtyBySpeedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchBunkerQtyBySpeedRSQL").append("\n"); 
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
		query.append("SELECT  (" ).append("\n"); 
		query.append("            SELECT  ACT_PRC AS BNK_PRICE_BY_TON" ).append("\n"); 
		query.append("            FROM    VSK_BNK_PRC T1," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT  MAX(TO_CHAR(ACT_BRTH_DT, 'YYYYMMDD') || VPS_PORT_CD ) CURR_PORT" ).append("\n"); 
		query.append("                        FROM    VSK_DEP_RPT" ).append("\n"); 
		query.append("                        WHERE   VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND     SPL_FOIL_WGT    > 0" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("            AND     PORT_CD             = SUBSTR(CURR_PORT, 9)" ).append("\n"); 
		query.append("            AND     FOIL_DOIL_DIV_CD    = 'F'" ).append("\n"); 
		query.append("            AND     EVNT_DT             = TO_DATE(SUBSTR(CURR_PORT, 1, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("        ) AS BNK_UNIT_AMT" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("			SELECT  ROUND((FOC_HR / POWER(SPD_P, 3)) * POWER((@[spd] / (1 - (SLIP / 100))), 3) * 24, 1)" ).append("\n"); 
		query.append("			FROM    (" ).append("\n"); 
		query.append("						SELECT  T1.*," ).append("\n"); 
		query.append("								ROUND(((SPD_P - SPD_O)/SPD_P) * 100, 1)   AS SLIP," ).append("\n"); 
		query.append("								ROUND(BUNK_CONS / (DIST_O / SPD_O), 2)  AS FOC_HR" ).append("\n"); 
		query.append("						FROM    (" ).append("\n"); 
		query.append("									SELECT  /*+INDEX_DESC(T XPKVSK_NOON_RPT) */" ).append("\n"); 
		query.append("											NXT_PORT_CD     AS NXT_PORT_CD," ).append("\n"); 
		query.append("											NXT_PORT_ETA_DT AS NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("											NVGT_DIST       AS DIST_O," ).append("\n"); 
		query.append("											ENG_ML_DIST     AS DIST_P," ).append("\n"); 
		query.append("											CRNT_ACT_SPD    AS SPD_O," ).append("\n"); 
		query.append("											ROUND(ENG_ML_DIST / (NVGT_DIST / CRNT_ACT_SPD),1) AS SPD_P," ).append("\n"); 
		query.append("											ROUND(FOIL_CSM_WGT)    AS BUNK_CONS" ).append("\n"); 
		query.append("									FROM    VSK_NOON_RPT T" ).append("\n"); 
		query.append("									WHERE   VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("									AND     ROWNUM      = 1" ).append("\n"); 
		query.append("								) T1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("        ) AS BNK_UNIT_QTY" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}