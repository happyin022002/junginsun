/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RailTransitReportDAOSmmyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDAOSmmyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SmmyList
	  * </pre>
	  */
	public RailTransitReportDAOSmmyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration ").append("\n"); 
		query.append("FileName : RailTransitReportDAOSmmyListRSQL").append("\n"); 
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
		query.append("  '' RANK_CD" ).append("\n"); 
		query.append(", '' MNTH" ).append("\n"); 
		query.append(", '' WEEK" ).append("\n"); 
		query.append(", '' SLS_FM_DT" ).append("\n"); 
		query.append(", '' SLS_TO_DT" ).append("\n"); 
		query.append(", '' CGO_TP_CD" ).append("\n"); 
		query.append(", '' TRSP_BND_CD" ).append("\n"); 
		query.append(", '' FM_NOD_CD" ).append("\n"); 
		query.append(", '' TO_NOD_CD" ).append("\n"); 
		query.append(", '' TML_DWLL_TM_HRS" ).append("\n"); 
		query.append(", '' ORG_DWLL_TM_HRS" ).append("\n"); 
		query.append(", '' RAIL_RUN_TM_HRS" ).append("\n"); 
		query.append(", '' ITCHG_N1ST_DWLL_TM_HRS" ).append("\n"); 
		query.append(", '' ITCHG_N2ND_DWLL_TM_HRS" ).append("\n"); 
		query.append(", '' DEST_N1ST_DWLL_TM_HRS" ).append("\n"); 
		query.append(", '' DEST_N2ND_DWLL_TM_HRS" ).append("\n"); 
		query.append(", '' RAIL_TZTM_HRS" ).append("\n"); 
		query.append(", '' TTL_TZTM_HRS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}