/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOChargeBookingContainerParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.05 
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

public class ChargeAmountDiscountMgtDBDAOChargeBookingContainerParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 별 조회된 지불금액정보를 저장할 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOChargeBookingContainerParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOChargeBookingContainerParmVORSQL").append("\n"); 
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
		query.append("SELECT	'' POD" ).append("\n"); 
		query.append(",	'' POL" ).append("\n"); 
		query.append(",	'' DEL" ).append("\n"); 
		query.append(",	'' POR" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' TARIFF" ).append("\n"); 
		query.append(",	'' DAR_NO" ).append("\n"); 
		query.append(",	'' BKG_NO" ).append("\n"); 
		query.append(",	'' APVL_NO" ).append("\n"); 
		query.append(",	'' IS_CNTR" ).append("\n"); 
		query.append(",	'' APVL_OFC_CD" ).append("\n"); 
		query.append(",	'' AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	'' AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",	'' IS_AFT_BKG_CNTR" ).append("\n"); 
		query.append(",	'' OFC_TRNS_FLG" ).append("\n"); 
		query.append(",	'' OFC_TRNS_RHQ_CNG_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}