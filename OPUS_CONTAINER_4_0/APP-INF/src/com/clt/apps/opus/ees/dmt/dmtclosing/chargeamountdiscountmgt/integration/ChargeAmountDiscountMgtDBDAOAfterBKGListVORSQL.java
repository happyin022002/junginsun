/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOAfterBKGListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.18 
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

public class ChargeAmountDiscountMgtDBDAOAfterBKGListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking Request 결과목록 정보를 저장할 VO 객체를 생성하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOAfterBKGListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOAfterBKGListVORSQL").append("\n"); 
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
		query.append("AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	'' CNTR_TP" ).append("\n"); 
		query.append(",	FT_ADJ_FLG" ).append("\n"); 
		query.append(",	FT_ADD_DYS" ).append("\n"); 
		query.append(",	FT_TTL_DYS" ).append("\n"); 
		query.append(",	XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	DC_FLG" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	'' ALL_CURR_CD" ).append("\n"); 
		query.append(",	'' ALL_CURR_NM" ).append("\n"); 
		query.append(",	DC_AMT" ).append("\n"); 
		query.append(",	DC_RTO" ).append("\n"); 
		query.append(",	'' DC_RTO2" ).append("\n"); 
		query.append(",	'' TVVD" ).append("\n"); 
		query.append(", 	'' POR_CD" ).append("\n"); 
		query.append(", 	'' POL_CD" ).append("\n"); 
		query.append(", 	'' POD_CD" ).append("\n"); 
		query.append(",	'' DEL_CD" ).append("\n"); 
		query.append(", 	'' RD" ).append("\n"); 
		query.append(",   '' DCGO_FLG" ).append("\n"); 
		query.append(",	'' RC_FLG" ).append("\n"); 
		query.append(", 	'' AWK_CGO_FLG" ).append("\n"); 
		query.append(",	'' BB_CGO_FLG" ).append("\n"); 
		query.append(", 	'' RD_CGO_FLG" ).append("\n"); 
		query.append(", 	'' SOC_FLG" ).append("\n"); 
		query.append(", 	'' CMDT_CD" ).append("\n"); 
		query.append(",	'' CMDT_NM" ).append("\n"); 
		query.append(",	EACH_CNTR_FLG" ).append("\n"); 
		query.append(",	'' RQST_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_RQST_DTL" ).append("\n"); 

	}
}