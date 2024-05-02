/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchActStEndByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.05 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOSearchActStEndByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search actual start, end info by VVD.
	  * </pre>
	  */
	public EstimationDBDAOSearchActStEndByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOSearchActStEndByVvdRSQL").append("\n"); 
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
		query.append("SELECT  MAX(VSL_CD) VSL_CD" ).append("\n"); 
		query.append("       ,MAX(SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("       ,MAX(SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("       ,MAX(ST_PORT_CD) ST_PORT_CD" ).append("\n"); 
		query.append("       ,MAX(ST_CLPT_IND_SEQ) ST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ,TO_CHAR(MAX(ST_ETB_DT), 'YYYYMMDD') AS ST_ETB_DT" ).append("\n"); 
		query.append("       ,MAX(END_SKD_VOY_NO) END_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,MAX(END_SKD_DIR_CD) END_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,MAX(END_PORT_CD) END_PORT_CD" ).append("\n"); 
		query.append("       ,MAX(END_CLPT_IND_SEQ) END_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ,TO_CHAR(MAX(END_ETB_DT), 'YYYYMMDD') AS END_ETB_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT VVD_SEQ" ).append("\n"); 
		query.append("           ,DECODE(VVD_SEQ, 1, VSL_CD, '') VSL_CD" ).append("\n"); 
		query.append("           ,DECODE(START_SEQ, 1, SKD_VOY_NO, '') SKD_VOY_NO" ).append("\n"); 
		query.append("           ,DECODE(START_SEQ, 1, SKD_DIR_CD, '') SKD_DIR_CD" ).append("\n"); 
		query.append("           ,DECODE(START_SEQ, 1, VPS_PORT_CD, '') ST_PORT_CD" ).append("\n"); 
		query.append("           ,DECODE(START_SEQ, 1, CLPT_IND_SEQ, '') ST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("           ,DECODE(START_SEQ, 1, VPS_ETB_DT, '') ST_ETB_DT" ).append("\n"); 
		query.append("           ,DECODE(END_SEQ, 1, SKD_VOY_NO, '') END_SKD_VOY_NO" ).append("\n"); 
		query.append("           ,DECODE(END_SEQ, 1, SKD_DIR_CD, '') END_SKD_DIR_CD" ).append("\n"); 
		query.append("           ,DECODE(END_SEQ, 1, VPS_PORT_CD, '') END_PORT_CD" ).append("\n"); 
		query.append("           ,DECODE(END_SEQ, 1, CLPT_IND_SEQ, '') END_CLPT_IND_SEQ" ).append("\n"); 
		query.append("           ,DECODE(END_SEQ, 1, VPS_ETB_DT, '') END_ETB_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        -- >>>> TARGET VVD" ).append("\n"); 
		query.append("        WITH SKD AS (" ).append("\n"); 
		query.append("            SELECT @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("                 , @[skd_voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append("                 , @[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("            FROM DUAL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        -- <<<< TARGET VVD" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        T1.*," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(ORDER BY VVD_SEQ, PORT_SEQ) START_SEQ," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(ORDER BY VVD_SEQ DESC, PORT_SEQ DESC) END_SEQ" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT 1 VVD_SEQ" ).append("\n"); 
		query.append("                   , T1.VSL_CD" ).append("\n"); 
		query.append("                   , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                   , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                   , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("                   , T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   , T1.CLPT_SEQ" ).append("\n"); 
		query.append("                   , T1.VPS_ETA_DT" ).append("\n"); 
		query.append("                   , T1.VPS_ETB_DT" ).append("\n"); 
		query.append("                   , T1.VPS_ETD_DT" ).append("\n"); 
		query.append("                   , ROW_NUMBER() OVER(PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.CLPT_SEQ) PORT_SEQ" ).append("\n"); 
		query.append("            FROM SKD, VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND SKD.VSL_CD=T1.VSL_CD" ).append("\n"); 
		query.append("            AND SKD.SKD_VOY_NO=T1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND SKD.SKD_DIR_CD=T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT 2 VVD_SEQ" ).append("\n"); 
		query.append("                   , T1.VSL_CD" ).append("\n"); 
		query.append("                   , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                   , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                   , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("                   , T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   , T1.CLPT_SEQ" ).append("\n"); 
		query.append("                   , T1.VPS_ETA_DT" ).append("\n"); 
		query.append("                   , T1.VPS_ETB_DT" ).append("\n"); 
		query.append("                   , T1.VPS_ETD_DT" ).append("\n"); 
		query.append("                   , ROW_NUMBER() OVER(PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.CLPT_SEQ DESC) PORT_SEQ" ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT T1.VSL_CD, T1.TURN_SKD_VOY_NO SKD_VOY_NO, T1.TURN_SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM SKD, VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND SKD.VSL_CD=T1.VSL_CD" ).append("\n"); 
		query.append("                AND SKD.SKD_VOY_NO=T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND SKD.SKD_DIR_CD=T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND T1.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("                GROUP BY T1.VSL_CD, T1.TURN_SKD_VOY_NO, T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            SKD, VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND SKD.VSL_CD=T1.VSL_CD" ).append("\n"); 
		query.append("            AND SKD.SKD_VOY_NO=T1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND SKD.SKD_DIR_CD=T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ORDER BY VVD_SEQ, PORT_SEQ" ).append("\n"); 
		query.append("        )T1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND START_SEQ=1 OR END_SEQ=1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}