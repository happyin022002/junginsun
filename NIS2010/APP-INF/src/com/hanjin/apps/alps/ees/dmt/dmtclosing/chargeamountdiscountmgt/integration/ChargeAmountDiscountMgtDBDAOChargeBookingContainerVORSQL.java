/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOChargeBookingContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.06.08 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOChargeBookingContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG No. 에 해당되는 Billable Amount per CNTR 정보를 저장하기 위해서 사용되는 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOChargeBookingContainerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOChargeBookingContainerVORSQL").append("\n"); 
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
		query.append(",	AFT_EXPT_CNTR_SEQ" ).append("\n"); 
		query.append(",	'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",	'' CNTR_NO" ).append("\n"); 
		query.append(",	'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	'' OFC_CD" ).append("\n"); 
		query.append(",	'' BKG_NO" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",   '' POR_CD" ).append("\n"); 
		query.append(",   '' POL_CD" ).append("\n"); 
		query.append(",   '' POD_CD" ).append("\n"); 
		query.append(",   '' DEL_CD" ).append("\n"); 
		query.append(",	'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",	'' FT_DYS" ).append("\n"); 
		query.append(",	'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",	'' BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",	'' AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",	'' BIL_AMT" ).append("\n"); 
		query.append(",	'' ORG_BIL_AMT" ).append("\n"); 
		query.append(",	'' DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",	'' BKG_CNTR_QTY" ).append("\n"); 
		query.append(",	'' CHG_SEQ_DESC" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	CHG_SEQ" ).append("\n"); 
		query.append(",	FT_ADJ_FLG" ).append("\n"); 
		query.append(",	FT_ADD_DYS" ).append("\n"); 
		query.append(",	FT_TTL_DYS" ).append("\n"); 
		query.append(",	XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	'' CNTR_CHG_DC_FLG" ).append("\n"); 
		query.append(",	'' CURR_CD" ).append("\n"); 
		query.append(",	'' ALL_CURR_CD" ).append("\n"); 
		query.append(",	'' ALL_CURR_NM" ).append("\n"); 
		query.append(",	CNTR_CHG_DC_AMT" ).append("\n"); 
		query.append(",	CNTR_CHG_DC_RTO" ).append("\n"); 
		query.append(",	'' CNTR_CHG_DC_RTO2" ).append("\n"); 
		query.append(",	'' FT_END_DT" ).append("\n"); 
		query.append(",	'' OFC_TRNS_FLG" ).append("\n"); 
		query.append(",	'' OFC_TRNS_RHQ_CNG_FLG" ).append("\n"); 
		query.append(",	'' PRNT_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_CNTR" ).append("\n"); 

	}
}