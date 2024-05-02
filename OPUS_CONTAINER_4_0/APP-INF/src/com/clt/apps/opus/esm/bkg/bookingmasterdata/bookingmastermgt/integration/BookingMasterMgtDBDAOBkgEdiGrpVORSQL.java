/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgEdiGrpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgEdiGrpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgEdiGrpVO
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgEdiGrpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgEdiGrpVORSQL").append("\n"); 
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
		query.append("    '' AS ESVC_GRP_CD," ).append("\n"); 
		query.append("    '' AS CO_CD," ).append("\n"); 
		query.append("    '' AS ESVC_GRP_NM," ).append("\n"); 
		query.append("    '' AS CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("    '' AS MCHN_TRD_PRNR_ID," ).append("\n"); 
		query.append("    '' AS ESVC_GRP_DELT_FLG," ).append("\n"); 
		query.append("    '' AS EAI_STS," ).append("\n"); 
		query.append("    '' AS CRE_USR_ID," ).append("\n"); 
		query.append("    '' AS CRE_DT," ).append("\n"); 
		query.append("    '' AS UPD_USR_ID," ).append("\n"); 
		query.append("    '' AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}