/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOSearchTrendLineByVvdRSQL.java
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

public class EstimationDBDAOSearchTrendLineByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search a trend line by VVD.
	  * </pre>
	  */
	public EstimationDBDAOSearchTrendLineByVvdRSQL(){
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
		query.append("FileName : EstimationDBDAOSearchTrendLineByVvdRSQL").append("\n"); 
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
		query.append("-- >>>> TARGET VVD" ).append("\n"); 
		query.append("WITH SKD AS (" ).append("\n"); 
		query.append("    SELECT @[vsl_cd] VSL_CD /*VSL_CD*/" ).append("\n"); 
		query.append("           , @[skd_voy_no] SKD_VOY_NO /*SKD_VOY_NO*/" ).append("\n"); 
		query.append("           , @[skd_dir_cd] SKD_DIR_CD /*SKD_DIR_CD*/" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- <<<< TARGET VVD" ).append("\n"); 
		query.append("SELECT T1.TRND_LINE_SEQ" ).append("\n"); 
		query.append("       , T1.TRND_LINE_TP_CD" ).append("\n"); 
		query.append("       , T1.N1ST_COEF_VAL" ).append("\n"); 
		query.append("       , T1.N1ST_VAR_DGR_VAL" ).append("\n"); 
		query.append("       , T1.N2ND_COEF_VAL" ).append("\n"); 
		query.append("       , T1.N2ND_VAR_DGR_VAL" ).append("\n"); 
		query.append("       , T1.TRND_LINE_CONS_VAL" ).append("\n"); 
		query.append("       , T1.VSL_CLSS_CD" ).append("\n"); 
		query.append("       , T1.VSL_CLSS_SUB_CD" ).append("\n"); 
		query.append("       , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("       , T1.VSL_CD" ).append("\n"); 
		query.append("       , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("       , TRND_LINE_USE_TP_CD || '-' || TRND_LINE_TP_CD || '-' || VSL_CLSS_CD || VSL_CLSS_SUB_CD || VSL_SLAN_CD || VSL_CD || SKD_DIR_CD || '-' || TO_CHAR(CRE_DT, 'YYMM') || TRND_LINE_TP_SUB_CD TRND_LINE_NO" ).append("\n"); 
		query.append("FROM FCM_TRND_LINE T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRND_LINE_SEQ = (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    MAX(TRND_LINE_SEQ)" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        MAX(TRND_LINE_SEQ) TRND_LINE_SEQ" ).append("\n"); 
		query.append("        FROM FCM_TRND_LINE T1, SKD" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.VSL_CD=SKD.VSL_CD" ).append("\n"); 
		query.append("        AND TRND_LINE_TP_CD='4'" ).append("\n"); 
		query.append("        AND TRND_LINE_CHT_TP_CD='01'" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD=SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        MAX(TRND_LINE_SEQ) TRND_LINE_SEQ" ).append("\n"); 
		query.append("        FROM FCM_TRND_LINE T1, SKD" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.VSL_CD=SKD.VSL_CD" ).append("\n"); 
		query.append("        AND TRND_LINE_TP_CD='3'" ).append("\n"); 
		query.append("        AND TRND_LINE_CHT_TP_CD='01'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        MAX(TRND_LINE_SEQ) TRND_LINE_SEQ" ).append("\n"); 
		query.append("        FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND VSL_CLSS_CD=(SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR T1, SKD WHERE T1.VSL_CD=SKD.VSL_CD)" ).append("\n"); 
		query.append("        AND TRND_LINE_TP_CD='2'" ).append("\n"); 
		query.append("        AND TRND_LINE_CHT_TP_CD='01'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("        MAX(TRND_LINE_SEQ) TRND_LINE_SEQ" ).append("\n"); 
		query.append("        FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND VSL_CLSS_CD=(SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR T1, SKD WHERE T1.VSL_CD=SKD.VSL_CD)" ).append("\n"); 
		query.append("        AND TRND_LINE_TP_CD='1'" ).append("\n"); 
		query.append("        AND VSL_SLAN_CD=(SELECT VSL_SLAN_CD FROM VSK_VSL_SKD T1, SKD WHERE T1.VSL_CD=SKD.VSL_CD AND T1.SKD_VOY_NO=SKD.SKD_VOY_NO AND T1.SKD_DIR_CD=SKD.SKD_DIR_CD)" ).append("\n"); 
		query.append("        AND TRND_LINE_CHT_TP_CD='01'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}