/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchBayPlanListByVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchBayPlanListByVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI로 수신한 Bay Plan 정보를 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchBayPlanListByVvdPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchBayPlanListByVvdPortRSQL").append("\n"); 
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
		query.append("ETA_DT" ).append("\n"); 
		query.append(",ETD_DT" ).append("\n"); 
		query.append(",BAY_PLN_ID" ).append("\n"); 
		query.append(",TO_CHAR(RCV_DT, 'YYYY-MM-DD HH24:MI') RCV_DT" ).append("\n"); 
		query.append(",VSL_CD VSL" ).append("\n"); 
		query.append(",VSL_CD || VSL_VOY_DIR_NO TRNK_VVD_ID" ).append("\n"); 
		query.append(",EUR_DG_DEP_PORT_CD POL_CD" ).append("\n"); 
		query.append(",EUR_DG_NXT_PORT_CD POD_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_DG_BAY_PLN" ).append("\n"); 
		query.append("ORDER BY RCV_DT DESC" ).append("\n"); 

	}
}