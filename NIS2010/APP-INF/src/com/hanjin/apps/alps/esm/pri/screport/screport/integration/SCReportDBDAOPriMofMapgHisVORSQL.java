/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAOPriMofMapgHisVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOPriMofMapgHisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_MOF_MAPG_HIS 테이블 조회
	  * </pre>
	  */
	public SCReportDBDAOPriMofMapgHisVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration ").append("\n"); 
		query.append("FileName : SCReportDBDAOPriMofMapgHisVORSQL").append("\n"); 
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
		query.append("     , HIS_SEQ" ).append("\n"); 
		query.append("     , UPD_TP_NM" ).append("\n"); 
		query.append("     , LST_EVNT_DT" ).append("\n"); 
		query.append("     , MOF_ID" ).append("\n"); 
		query.append("     , HJS_ID" ).append("\n"); 
		query.append("     , MAPG_RMK" ).append("\n"); 
		query.append("     , FILE_USE_ONY_FLG" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , UPD_OFC_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_MOF_MAPG_HIS" ).append("\n"); 

	}
}