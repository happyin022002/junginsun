/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AudPerfDAOSearchLgsCostCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.audperf.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AudPerfDAOSearchLgsCostCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AudPerfDAOSearchLgsCostCdRSQL DESC 
	  * </pre>
	  */
	public AudPerfDAOSearchLgsCostCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.audperf.integration").append("\n"); 
		query.append("FileName : AudPerfDAOSearchLgsCostCdRSQL").append("\n"); 
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
		query.append("SELECT LGS_COST_CD" ).append("\n"); 
		query.append("      ,LGS_COST_NM" ).append("\n"); 
		query.append("      ,MDL_CD" ).append("\n"); 
		query.append("      ,CGO_TP_CD" ).append("\n"); 
		query.append("  FROM TABLE(EAS_EXPN_AUD_PKG.GET_LGS_COST_DIV_FNC())" ).append("\n"); 
		query.append(" ORDER BY MDL_CD, CGO_TP_CD, LGS_COST_CD" ).append("\n"); 

	}
}