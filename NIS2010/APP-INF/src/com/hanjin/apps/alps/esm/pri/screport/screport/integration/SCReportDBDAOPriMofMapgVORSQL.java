/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAOPriMofMapgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.22 
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

public class SCReportDBDAOPriMofMapgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_MOF_MAPG 테이블 조회
	  * </pre>
	  */
	public SCReportDBDAOPriMofMapgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOPriMofMapgVORSQL").append("\n"); 
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
		query.append("SELECT MAPG_TP_CD" ).append("\n"); 
		query.append("     , MAPG_SEQ" ).append("\n"); 
		query.append("     , MOF_ID" ).append("\n"); 
		query.append("     , HJS_ID" ).append("\n"); 
		query.append("     , MAPG_RMK" ).append("\n"); 
		query.append("     , FILE_USE_ONY_FLG AS FILE_USE_ONY_FLG" ).append("\n"); 
		query.append("     , DELT_FLG AS DELT_FLG " ).append("\n"); 
		query.append("     , A.CRE_OFC_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE.USR_NM AS CRE_USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR ( A.CRE_DT, 'YYYY-MM-DD' ) AS CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_OFC_CD" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD.USR_NM AS UPD_USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR ( A.UPD_DT, 'YYYY-MM-DD' ) AS UPD_DT" ).append("\n"); 
		query.append("     FROM PRI_MOF_MAPG A" ).append("\n"); 
		query.append("   , COM_USER UPD" ).append("\n"); 
		query.append("   , COM_USER CRE" ).append("\n"); 
		query.append(" WHERE A.CRE_USR_ID = CRE.USR_ID" ).append("\n"); 
		query.append("  AND A.UPD_USR_ID = UPD.USR_ID" ).append("\n"); 
		query.append("  AND MAPG_TP_CD = @[mapg_tp_cd]" ).append("\n"); 

	}
}