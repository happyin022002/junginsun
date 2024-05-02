/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeArgumentVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.11.01 황효근
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

public class ChargeCalculationDBDAOChargeArgumentVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeArgumentVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeArgumentVORSQL").append("\n"); 
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
		query.append("'' CALL_FLAG" ).append("\n"); 
		query.append(",'' EST_MK" ).append("\n"); 
		query.append(",'' SCH_CHG_STS" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' BYPODETA" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' CHG_TYPE" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' CNT_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' WEB_IND_FLG" ).append("\n"); 
		query.append(",'' BYDR" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' OFC_RHQ_CD" ).append("\n"); 
		query.append(",'' RHQ_OFC_CD" ).append("\n"); 
		query.append(",'' DMDT_INV_NO" ).append("\n"); 
		query.append(",'' DR_DT" ).append("\n"); 
		query.append(",'' CR_INV_NO" ).append("\n"); 
		query.append(",'' ERR_CODE" ).append("\n"); 
		query.append(",'' ERR_MSG" ).append("\n"); 
		query.append(",'' TRUCKER_CD" ).append("\n"); 
		query.append(",'' DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(",'' CORR_RMK" ).append("\n"); 
		query.append(",'' BACKENDJOB_KEY" ).append("\n"); 
		query.append(",'' BACKENDJOB_ID" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' STS_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}