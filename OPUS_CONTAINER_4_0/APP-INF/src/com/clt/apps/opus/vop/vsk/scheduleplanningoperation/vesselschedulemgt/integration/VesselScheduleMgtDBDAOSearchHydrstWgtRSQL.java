/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchHydrstWgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.18 정진우
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

public class VesselScheduleMgtDBDAOSearchHydrstWgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchHydrstWgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("draft",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchHydrstWgtRSQL").append("\n"); 
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
		query.append("SELECT  ROUND(TPL, 2) AS DRFT_DPTH" ).append("\n"); 
		query.append("		, ROUND(TPL * UNIT_DRFT + MIN_DWT_WGT, 2) AS DWT_WGT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  CASE WHEN MAX_MAN_DRFT_DPTH = MIN_DRFT_DPTH" ).append("\n"); 
		query.append("                     	 THEN MAX_DWT_WGT / (MAX_MAN_DRFT_DPTH * 100)" ).append("\n"); 
		query.append("                     	 ELSE (MAX_DWT_WGT - MIN_DWT_WGT) / ((MAX_MAN_DRFT_DPTH - MIN_DRFT_DPTH) * 100)" ).append("\n"); 
		query.append("                	END AS TPL" ).append("\n"); 
		query.append("                    , ((TO_NUMBER(@[draft]) - MIN_DRFT_DPTH) * 100) AS UNIT_DRFT" ).append("\n"); 
		query.append("                    , MIN_DWT_WGT" ).append("\n"); 
		query.append("            FROM    (       " ).append("\n"); 
		query.append("                        SELECT  VSL_CD" ).append("\n"); 
		query.append("                                , MAX(MIN_SEQ) AS MIN_SEQ" ).append("\n"); 
		query.append("                                , MAX(MAX_SEQ) AS MAX_SEQ" ).append("\n"); 
		query.append("                                , MAX(MIN_DWT_WGT) AS MIN_DWT_WGT" ).append("\n"); 
		query.append("                                , MAX(MAX_DWT_WGT) AS MAX_DWT_WGT" ).append("\n"); 
		query.append("                                , MAX(MIN_DRFT_DPTH) AS MIN_DRFT_DPTH" ).append("\n"); 
		query.append("                                , MAX(MAX_MAN_DRFT_DPTH) AS MAX_MAN_DRFT_DPTH" ).append("\n"); 
		query.append("                        FROM    (" ).append("\n"); 
		query.append("                                    SELECT  VSL_CD" ).append("\n"); 
		query.append("                                            , MTX_SEQ AS MIN_SEQ" ).append("\n"); 
		query.append("                                            , NULL AS MAX_SEQ" ).append("\n"); 
		query.append("                                            , DWT_WGT AS MIN_DWT_WGT" ).append("\n"); 
		query.append("                                            , NULL AS MAX_DWT_WGT" ).append("\n"); 
		query.append("                                            , DRFT_DPTH AS MIN_DRFT_DPTH" ).append("\n"); 
		query.append("                                            , NULL AS MAX_MAN_DRFT_DPTH" ).append("\n"); 
		query.append("                                    FROM    VSK_HYDRST_MTX" ).append("\n"); 
		query.append("                                    WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                    AND     DRFT_DPTH = (" ).append("\n"); 
		query.append("                                                            SELECT	MAX(DRFT_DPTH) AS DRFT_DPTH" ).append("\n"); 
		query.append("                                                            FROM	VSK_HYDRST_MTX" ).append("\n"); 
		query.append("                                                            WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                            AND     DRFT_DPTH <= TO_NUMBER(@[draft])" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                    UNION ALL" ).append("\n"); 
		query.append("                                    SELECT  VSL_CD" ).append("\n"); 
		query.append("                                            , NULL AS MIN_SEQ" ).append("\n"); 
		query.append("                                            , MTX_SEQ AS MAX_SEQ" ).append("\n"); 
		query.append("                                            , NULL AS MIN_DWT_WGT" ).append("\n"); 
		query.append("                                            , DWT_WGT AS MAX_DWT_WGT" ).append("\n"); 
		query.append("                                            , NULL AS MIN_DRFT_DPTH" ).append("\n"); 
		query.append("                                            , DRFT_DPTH AS MAX_MAN_DRFT_DPTH" ).append("\n"); 
		query.append("                                    FROM    VSK_HYDRST_MTX" ).append("\n"); 
		query.append("                                    WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                    AND     DRFT_DPTH = (" ).append("\n"); 
		query.append("                                                            SELECT	MIN(DRFT_DPTH) AS DRFT_DPTH" ).append("\n"); 
		query.append("                                                            FROM	VSK_HYDRST_MTX" ).append("\n"); 
		query.append("                                                            WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                            AND     DRFT_DPTH >= TO_NUMBER(@[draft])" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                        GROUP BY VSL_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}