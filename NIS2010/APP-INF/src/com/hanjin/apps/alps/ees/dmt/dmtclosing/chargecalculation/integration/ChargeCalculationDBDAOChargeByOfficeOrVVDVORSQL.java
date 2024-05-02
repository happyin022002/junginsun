/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeByOfficeOrVVDVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.04.14 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeByOfficeOrVVDVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeByOfficeOrVVDVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeByOfficeOrVVDVORSQL").append("\n"); 
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
		query.append("'' OFC_CD" ).append("\n"); 
		query.append(",'' USR_RHQ_OFC_CD" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' CHG_TYPE" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' FM_MVMT_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' VVD_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' DEM_TYPE" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CUST_TYPE" ).append("\n"); 
		query.append(",'' CUST_CD" ).append("\n"); 
		query.append(",'' SVC_PROVDR" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' RFA_NO" ).append("\n"); 
		query.append(",'' COND_TYPE" ).append("\n"); 
		query.append(",'' BYPODETA" ).append("\n"); 
		query.append(",'' CS" ).append("\n"); 
		query.append(",'' WEB_MT" ).append("\n"); 
		query.append(",'' INCL_INV" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}