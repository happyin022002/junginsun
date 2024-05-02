/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfStowageMgtDBDAOPortColorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfStowageMgtDBDAOPortColorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStowageMgtDBDAOPortColorList
	  * </pre>
	  */
	public OpfStowageMgtDBDAOPortColorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bay_idx",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration").append("\n"); 
		query.append("FileName : OpfStowageMgtDBDAOPortColorListRSQL").append("\n"); 
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
		query.append("SELECT PLAN.POD AS PORT_NM" ).append("\n"); 
		query.append("       , COLOR.BG_COLR_R||'_'||COLOR.BG_COLR_G||'_'||COLOR.BG_COLR_B AS PORT_COLOR" ).append("\n"); 
		query.append("FROM CDV_VESSEL VESSEL" ).append("\n"); 
		query.append("    , TPL_VSL_STWG_BAY BAY" ).append("\n"); 
		query.append("    , TPL_VSL_STWG_CELL CELL" ).append("\n"); 
		query.append("    , (SELECT *" ).append("\n"); 
		query.append("        FROM BAY_PLAN " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND (VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND, PLAN_TYPE) IN (SELECT VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("                                                                                   , CASE WHEN COUNT(PLAN_TYPE) > 1 THEN 'E' ELSE 'F' END AS PLAN_TYPE" ).append("\n"); 
		query.append("                                                                            FROM BAY_PLAN A" ).append("\n"); 
		query.append("                                                                            WHERE 1=1" ).append("\n"); 
		query.append("                                                                            AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                                            AND VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                                            AND DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                                            AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("																			AND CALL_IND = @[call_ind]" ).append("\n"); 
		query.append("                                                                            GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("                                                                            )" ).append("\n"); 
		query.append("    ) PLAN" ).append("\n"); 
		query.append("    , (SELECT FAVORITE_CD AS PORT_CD," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(FRGRND_COLR_CTNT, 2, LENGTH(FRGRND_COLR_CTNT)-2), '[^,]+', 1, 1) FR_COLR_R," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(FRGRND_COLR_CTNT, 2, LENGTH(FRGRND_COLR_CTNT)-2), '[^,]+', 1, 2) FR_COLR_G," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(FRGRND_COLR_CTNT, 2, LENGTH(FRGRND_COLR_CTNT)-2), '[^,]+', 1, 3) FR_COLR_B," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(BG_COLR_CTNT, 2, LENGTH(BG_COLR_CTNT)-2), '[^,]+', 1, 1) BG_COLR_R," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(BG_COLR_CTNT, 2, LENGTH(BG_COLR_CTNT)-2), '[^,]+', 1, 2) BG_COLR_G," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(BG_COLR_CTNT, 2, LENGTH(BG_COLR_CTNT)-2), '[^,]+', 1, 3) BG_COLR_B" ).append("\n"); 
		query.append("            FROM STO_CD_LANE_FVRT" ).append("\n"); 
		query.append("            WHERE LANE_CD = 'NE3' --LANE CODE" ).append("\n"); 
		query.append("              AND CATE_CD = 'PORT'" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT PORT_CD," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(PORT_FRGRND_COLR_CTNT, 2, LENGTH(PORT_FRGRND_COLR_CTNT)-2), '[^,]+', 1, 1) FR_COLR_R," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(PORT_FRGRND_COLR_CTNT, 2, LENGTH(PORT_FRGRND_COLR_CTNT)-2), '[^,]+', 1, 2) FR_COLR_G," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(PORT_FRGRND_COLR_CTNT, 2, LENGTH(PORT_FRGRND_COLR_CTNT)-2), '[^,]+', 1, 3) FR_COLR_B," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(PORT_BG_COLR_CTNT, 2, LENGTH(PORT_BG_COLR_CTNT)-2), '[^,]+', 1, 1) BG_COLR_R," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(PORT_BG_COLR_CTNT, 2, LENGTH(PORT_BG_COLR_CTNT)-2), '[^,]+', 1, 2) BG_COLR_G," ).append("\n"); 
		query.append("              REGEXP_SUBSTR(SUBSTR(PORT_BG_COLR_CTNT, 2, LENGTH(PORT_BG_COLR_CTNT)-2), '[^,]+', 1, 3) BG_COLR_B" ).append("\n"); 
		query.append("            FROM STO_CD_PORT" ).append("\n"); 
		query.append("            WHERE NOT EXISTS (" ).append("\n"); 
		query.append("                SELECT *" ).append("\n"); 
		query.append("                FROM STO_CD_LANE_FVRT" ).append("\n"); 
		query.append("                WHERE LANE_CD = 'NE3' --LANE CODE" ).append("\n"); 
		query.append("                  AND CATE_CD = 'PORT'" ).append("\n"); 
		query.append("                  AND PORT_CD = FAVORITE_CD)" ).append("\n"); 
		query.append("    ) COLOR                            " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VESSEL.CDV_VSL_CODE = @[vsl_cd]" ).append("\n"); 
		query.append("AND VESSEL.CDV_VSL_CODE = BAY.VSL_CD" ).append("\n"); 
		query.append("AND BAY.VSL_CD = CELL.VSL" ).append("\n"); 
		query.append("AND BAY.BAY_IDX = CELL.BAY_IDX" ).append("\n"); 
		query.append("AND BAY.BAY_NM = @[bay_idx]" ).append("\n"); 
		query.append("AND CELL.DH_TP IN ('D', 'H')" ).append("\n"); 
		query.append("AND CELL.TR_IDX != -1" ).append("\n"); 
		query.append("AND CELL.BAY_NM = PLAN.BAY(+)" ).append("\n"); 
		query.append("AND CELL.ROW_NM = PLAN.ROWW(+)" ).append("\n"); 
		query.append("AND CELL.TR_NM = PLAN.TIER(+)" ).append("\n"); 
		query.append("AND PLAN.POD = COLOR.PORT_CD(+)" ).append("\n"); 
		query.append("AND NVL(PLAN.POD,'N') != 'N'" ).append("\n"); 
		query.append("GROUP BY PLAN.POD," ).append("\n"); 
		query.append("        COLOR.BG_COLR_R," ).append("\n"); 
		query.append("        COLOR.BG_COLR_G," ).append("\n"); 
		query.append("        COLOR.BG_COLR_B" ).append("\n"); 
		query.append("ORDER BY PLAN.POD" ).append("\n"); 

	}
}