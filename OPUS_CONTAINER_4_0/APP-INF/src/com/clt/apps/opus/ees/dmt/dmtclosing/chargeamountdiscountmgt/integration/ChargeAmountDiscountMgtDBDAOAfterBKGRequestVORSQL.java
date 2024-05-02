/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOAfterBKGRequestVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOAfterBKGRequestVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 저장시 Booking Adjustment Request Detail 정보를 임시저장하기 위해서 사용할 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOAfterBKGRequestVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOAfterBKGRequestVORSQL").append("\n"); 
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
		query.append(",	AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	FT_ADJ_FLG" ).append("\n"); 
		query.append(",	FT_ADD_DYS" ).append("\n"); 
		query.append(",	FT_TTL_DYS" ).append("\n"); 
		query.append(",	XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	DC_FLG" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	DC_AMT" ).append("\n"); 
		query.append(",	DC_RTO" ).append("\n"); 
		query.append(",	EACH_CNTR_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_RQST_DTL" ).append("\n"); 

	}
}