/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgEdiGrpCustVORSQL.java
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

public class BookingMasterMgtDBDAOBkgEdiGrpCustVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgEdiGrpCustVO
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgEdiGrpCustVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgEdiGrpCustVORSQL").append("\n"); 
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
		query.append("    '' AS CNT_CD," ).append("\n"); 
		query.append("    '' AS CUST_SEQ," ).append("\n"); 
		query.append("    '' AS SC_NO," ).append("\n"); 
		query.append("    '' AS BKG_CFM_FLG," ).append("\n"); 
		query.append("    '' AS BKG_CFM_AUTO_FLG," ).append("\n"); 
		query.append("    '' AS BL_DRFT_AUTO_FLG," ).append("\n"); 
		query.append("    '' AS BL_DRFT_FLG," ).append("\n"); 
		query.append("    '' AS CGO_TRAK_FLG," ).append("\n"); 
		query.append("    '' AS AN_FLG," ).append("\n"); 
		query.append("    '' AS ESVC_BL_TP_CD," ).append("\n"); 
		query.append("    '' AS BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("    '' AS DELT_FLG," ).append("\n"); 
		query.append("    '' AS EAI_STS," ).append("\n"); 
		query.append("    '' AS CRE_USR_ID," ).append("\n"); 
		query.append("    '' AS CRE_DT," ).append("\n"); 
		query.append("    '' AS UPD_USR_ID," ).append("\n"); 
		query.append("    '' AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}