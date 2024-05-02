/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOBookingCustomerBasicVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.03.08 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOBookingCustomerBasicVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingCustomerBasicVO
	  * </pre>
	  */
	public DaoNameDAOBookingCustomerBasicVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOBookingCustomerBasicVORSQL").append("\n"); 
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
		query.append("SELECT '' AS EXIST" ).append("\n"); 
		query.append("      ,'' AS TP_CD" ).append("\n"); 
		query.append("      ,'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append("      ,'' AS CNTR_CYC_NO   " ).append("\n"); 
		query.append("      ,'' AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("      ,'' AS FM_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,'' AS FM_MVMT_DT" ).append("\n"); 
		query.append("      ,'' AS FM_MVMT_YD_CD" ).append("\n"); 
		query.append("      ,'' AS TO_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,'' AS TO_MVMT_YD_CD" ).append("\n"); 
		query.append("      ,'' AS IO_BND" ).append("\n"); 
		query.append("      ,'' AS CUST_CNT_CD" ).append("\n"); 
		query.append("      ,'' AS CUST_SEQ" ).append("\n"); 
		query.append("      ,'' AS ACT_CNT_CD" ).append("\n"); 
		query.append("      ,'' AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("	  ,'' AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}