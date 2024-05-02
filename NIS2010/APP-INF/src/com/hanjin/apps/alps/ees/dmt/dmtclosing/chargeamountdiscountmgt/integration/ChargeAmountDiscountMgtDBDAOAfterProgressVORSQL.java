/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOAfterProgressVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOAfterProgressVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking History 정보를 저장할 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOAfterProgressVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOAfterProgressVORSQL").append("\n"); 
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
		query.append("SELECT	AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_RQST_STS_DESC" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	RQST_OFC_CD" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	AFT_BKG_APRO_NO" ).append("\n"); 
		query.append(",	APRO_USR_ID" ).append("\n"); 
		query.append(",	APRO_DT" ).append("\n"); 
		query.append(",	APRO_OFC_CD" ).append("\n"); 
		query.append(",	'' RHQ_OFC_CD" ).append("\n"); 
		query.append(",	'' SC_NO" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append(",	MSG_DT" ).append("\n"); 
		query.append(",	'' PROG_SEQ" ).append("\n"); 
		query.append(",	'' PROG_RMK" ).append("\n"); 
		query.append(",	'' PROG_DT" ).append("\n"); 
		query.append(",	'' PROG_USR_ID" ).append("\n"); 
		query.append(",	'' PROG_OFC_CD" ).append("\n"); 
		query.append(",	'' JOB_KEY" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' BACKEND_JOB_FLAG" ).append("\n"); 
		query.append(",	'' POPUP_FLAG" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_RQST" ).append("\n"); 

	}
}