/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselReportDBDAOSearchEqmtOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchEqmtOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combo조회 조건을 위한 Equipment Office Code 조회
	  * </pre>
	  */
	public VesselReportDBDAOSearchEqmtOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchEqmtOfcCdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE CNT_CD IN ('US','CA','MX')" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND EQ_CTRL_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY EQ_CTRL_OFC_CD" ).append("\n"); 

	}
}