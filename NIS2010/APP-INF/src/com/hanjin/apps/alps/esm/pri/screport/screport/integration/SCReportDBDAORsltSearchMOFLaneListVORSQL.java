/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAORsltSearchMOFLaneListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchMOFLaneListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Korea MOF Filing (Base Table) - Scope & Location 조회
	  * </pre>
	  */
	public SCReportDBDAORsltSearchMOFLaneListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchMOFLaneListVORSQL").append("\n"); 
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
		query.append("SELECT ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , MAPG_SEQ" ).append("\n"); 
		query.append("     , LOC_CD" ).append("\n"); 
		query.append("     , MOF_LANE_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03541'" ).append("\n"); 
		query.append("          AND MOF_LANE_CD = INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("          AND ROWNUM = 1) AS MOF_LANE_NM" ).append("\n"); 
		query.append("     , MOF_LOC_ID" ).append("\n"); 
		query.append("     , MOF_LOC_NM" ).append("\n"); 
		query.append("     , MAPG_RMK" ).append("\n"); 
		query.append("     , DECODE(FILE_USE_ONY_FLG, 'N', '0', 'Y', '1') AS FILE_USE_ONY_FLG" ).append("\n"); 
		query.append("     , DECODE(DELT_FLG, 'N', '0', 'Y', '1') AS DELT_FLG" ).append("\n"); 
		query.append("     , A.CRE_OFC_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE.USR_NM AS CRE_USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR ( A.CRE_DT, 'YYYY-MM-DD' ) AS CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_OFC_CD" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD.USR_NM AS UPD_USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR ( A.UPD_DT, 'YYYY-MM-DD' ) AS UPD_DT" ).append("\n"); 
		query.append("FROM PRI_MOF_LANE_MAPG A" ).append("\n"); 
		query.append("   , COM_USER CRE" ).append("\n"); 
		query.append("   , COM_USER UPD" ).append("\n"); 
		query.append("WHERE A.CRE_USR_ID = CRE.USR_ID" ).append("\n"); 
		query.append("  AND A.UPD_USR_ID = UPD.USR_ID" ).append("\n"); 
		query.append("ORDER BY ORG_DEST_TP_CD DESC, LOC_CD ASC" ).append("\n"); 

	}
}