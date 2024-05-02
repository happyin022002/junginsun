/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOExistBlackListedCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.11.27 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOExistBlackListedCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExistBlackListedCustomer
	  * </pre>
	  */
	public BookingUtilDBDAOExistBlackListedCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_text",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOExistBlackListedCustomerRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD||CUST_SEQ AS OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM MDM_CR_CUST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(CUST_CNT_CD, CUST_SEQ) IN" ).append("\n"); 
		query.append("(SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, BKG_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = @[input_text]" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD IN ('S', DECODE(A.CUST_TO_ORD_FLG, 'Y', 'N', 'C')))" ).append("\n"); 
		query.append("AND NVL(CUST_RLSE_CTRL_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}