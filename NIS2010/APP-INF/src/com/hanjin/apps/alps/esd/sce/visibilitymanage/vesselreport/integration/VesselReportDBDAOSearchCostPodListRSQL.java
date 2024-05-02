/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselReportDBDAOSearchCostPodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchCostPodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pod 조회
	  * </pre>
	  */
	public VesselReportDBDAOSearchCostPodListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchCostPodListRSQL").append("\n"); 
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
		query.append("SELECT LOC_CD COP_POD_CD" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cost_div} == 'ALL')" ).append("\n"); 
		query.append("	AND LOC_CD IN ('USABC','USLAX','USLGB','USOAK','USPDX','USSEA','USTIW','USYHO','USHOU','USMSY'," ).append("\n"); 
		query.append("'USBOS','USCHS','USEFG','USILM','USJAX','USMIA','USMOB','USNPG','USNYC','USORF','USPWM','USSAV','USVEK'," ).append("\n"); 
		query.append("'CAPRR','CAVAN','CAHAL','CAMTR')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_div} == 'PHXSA')" ).append("\n"); 
		query.append("	AND LOC_CD IN ('USABC','USLAX','USLGB','USOAK','USPDX','USSEA','USTIW','USYHO','USHOU','USMSY','USBOS','USCHS','USEFG','USILM','USJAX','USMIA','USMOB','USNPG','USNYC','USORF','USPWM','USSAV','USVEK')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_div} == 'TORSC')" ).append("\n"); 
		query.append("	AND LOC_CD IN ('CAPRR','CAVAN','CAHAL','CAMTR')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LOC_CD" ).append("\n"); 

	}
}