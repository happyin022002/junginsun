/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOSearchRevenueStrcSetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.25 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOSearchRevenueStrcSetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRevenueStrcSetList
	  * </pre>
	  */
	public ACMSetupDBDAOSearchRevenueStrcSetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOSearchRevenueStrcSetListRSQL").append("\n"); 
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
		query.append("SELECT REV_CHG_SEQ ," ).append("\n"); 
		query.append("CHG_CD ," ).append("\n"); 
		query.append("REV_FM_DT_CD ," ).append("\n"); 
		query.append("REV_FM_DT ," ).append("\n"); 
		query.append("REV_TO_DT_CD ," ).append("\n"); 
		query.append("REV_TO_DT ," ).append("\n"); 
		query.append("RHQ_CD AS RHQ_OFC_CD," ).append("\n"); 
		query.append("SVC_SCP_CD AS SCP_CD," ).append("\n"); 
		query.append("CRE_USR_ID ," ).append("\n"); 
		query.append("CRE_DT ," ).append("\n"); 
		query.append("UPD_USR_ID ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM ACM_AGN_SET_REV_CHG_CD" ).append("\n"); 
		query.append("ORDER BY REV_CHG_SEQ" ).append("\n"); 

	}
}