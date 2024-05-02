/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonUcTtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.16 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonUcTtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonUcTtl
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonUcTtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonUcTtlRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.BKG_NO DETAIL_1_TYPE" ).append("\n"); 
		query.append("     , B.CNTR_NO DETAIL_2_TYPE" ).append("\n"); 
		query.append("	 , A.DMDT_TRF_CD DETAIL_3_TYPE" ).append("\n"); 
		query.append("     , @[dar_no] AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("FROM DMT_AFT_BKG_ADJ_RQST_DTL A, DMT_AFT_BKG_CNTR B" ).append("\n"); 
		query.append("WHERE A.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("AND A.AFT_EXPT_DAR_NO = B.AFT_EXPT_DAR_NO" ).append("\n"); 

	}
}