/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCommonDBDAOSearchAreaByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchAreaByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAreaByOffice
	  * </pre>
	  */
	public DMTCommonDBDAOSearchAreaByOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchAreaByOfficeRSQL").append("\n"); 
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
		query.append("SELECT OFC_N8TH_LVL_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    --        'TYOHQ'   AS OFC_C" ).append("\n"); 
		query.append("    FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    WHERE CO_IND_CD = 'H'" ).append("\n"); 
		query.append("    AND CNT_CD = (  select --* " ).append("\n"); 
		query.append("                    DISTINCT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                    from mdm_organization" ).append("\n"); 
		query.append("                    WHERE OFC_cd =  DM.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(") SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM DMT_OFC_LVL_V DM" ).append("\n"); 
		query.append("WHERE OFC_KND_CD = 2 " ).append("\n"); 
		query.append("AND OFC_LVL = 2" ).append("\n"); 

	}
}