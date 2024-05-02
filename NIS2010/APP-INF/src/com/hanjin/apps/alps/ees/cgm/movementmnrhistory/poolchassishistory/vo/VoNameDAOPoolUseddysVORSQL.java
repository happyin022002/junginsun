/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VoNameDAOPoolUseddysVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.05 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOPoolUseddysVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20100305
	  * </pre>
	  */
	public VoNameDAOPoolUseddysVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo").append("\n"); 
		query.append("FileName : VoNameDAOPoolUseddysVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS UPD_DT" ).append("\n"); 
		query.append(", ''  AS CHSS_POOL_CD" ).append("\n"); 
		query.append(", ''  AS FILE_IMP_DT" ).append("\n"); 
		query.append(", ''  AS CRE_DT" ).append("\n"); 
		query.append(", ''  AS ONH_LOC_NM" ).append("\n"); 
		query.append(", ''  AS SAVE_CHK" ).append("\n"); 
		query.append(", ''  AS SAV_FILE_NM" ).append("\n"); 
		query.append(", ''  AS CRE_USR_ID" ).append("\n"); 
		query.append(", ''  AS COST_YRMON" ).append("\n"); 
		query.append(", ''  AS IMP_RSLT_DESC" ).append("\n"); 
		query.append(", ''  AS ORG_FILE_NM" ).append("\n"); 
		query.append(", ''  AS FILE_IMP_PROC_STS_NM" ).append("\n"); 
		query.append(", ''  AS OFFH_LOC_NM" ).append("\n"); 
		query.append(", ''  AS FILE_SEQ" ).append("\n"); 
		query.append(", ''  AS ROW_NO" ).append("\n"); 
		query.append(", ''  AS UPD_USR_ID" ).append("\n"); 
		query.append(", ''  AS FILE_IMP_PROC_STS_CD" ).append("\n"); 
		query.append(", ''  AS CHSS_NO" ).append("\n"); 
		query.append(", ''  AS CNTR_NO" ).append("\n"); 
		query.append(", ''  AS ONH_DT" ).append("\n"); 
		query.append(", ''  AS OFFH_DT" ).append("\n"); 
		query.append(", ''  AS POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}