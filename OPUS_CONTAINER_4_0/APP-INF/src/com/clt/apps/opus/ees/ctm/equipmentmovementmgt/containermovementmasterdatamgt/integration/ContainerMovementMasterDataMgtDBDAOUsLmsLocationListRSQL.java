/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtDBDAOUsLmsLocationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMasterDataMgtDBDAOUsLmsLocationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US AMS Location List 조회
	  * </pre>
	  */
	public ContainerMovementMasterDataMgtDBDAOUsLmsLocationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMasterDataMgtDBDAOUsLmsLocationListRSQL").append("\n"); 
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
		query.append("SELECT TRIM (LOC_AMS_PORT_CD) LOC_AMS_PORT_CD," ).append("\n"); 
		query.append("       TRIM (LOC_CD) LOC_CD," ).append("\n"); 
		query.append("       LOC_NM," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE TRIM(LOC_AMS_PORT_CD) IS NOT NULL" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY LOC_AMS_PORT_CD" ).append("\n"); 

	}
}