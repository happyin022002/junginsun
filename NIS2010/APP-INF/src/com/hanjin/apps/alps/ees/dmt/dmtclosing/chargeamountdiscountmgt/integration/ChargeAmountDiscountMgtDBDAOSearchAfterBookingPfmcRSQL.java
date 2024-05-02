/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmc
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD||LPAD(CUST_SEQ, 6, '0')  AS CUST_CD, " ).append("\n"); 
		query.append("       ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ AND ROWNUM = 1) CUST_NM," ).append("\n"); 
		query.append("       POL_CD, " ).append("\n"); 
		query.append("       POD_CD, " ).append("\n"); 
		query.append("       DMDT_TRF_CD, " ).append("\n"); 
		query.append("       ORG_CHG_AMT, " ).append("\n"); 
		query.append("       DMDT_EXPT_AMT AS EXPT_AMT," ).append("\n"); 
		query.append("       AFT_EXPT_DC_AMT, " ).append("\n"); 
		query.append("       BIL_AMT AS BILL_AMT, " ).append("\n"); 
		query.append("       INV_PAY_AMT, " ).append("\n"); 
		query.append("       DECODE(BIL_AMT,0,0, ROUND(INV_PAY_AMT/BIL_AMT * 100,2)) AS COLL_RT," ).append("\n"); 
		query.append("       DECODE(ORG_CHG_AMT,0,0,ROUND(( DMDT_EXPT_AMT + AFT_EXPT_DC_AMT )/ORG_CHG_AMT * 100,2)) AS EXPT_DC_RT" ).append("\n"); 
		query.append("FROM DMT_AFT_BKG_PERF_RQST A" ).append("\n"); 
		query.append("WHERE AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("ORDER BY AFT_BKG_PERF_RQST_SEQ" ).append("\n"); 

	}
}