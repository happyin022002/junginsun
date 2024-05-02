/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOCheckIranBlackCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.22
*@LastModifier : inyoung Lee
*@LastVersion : 1.0
* 2010.12.22 inyoung Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author inyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOCheckIranBlackCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckIranBlackCustomer
	  * </pre>
	  */
	public BookingUtilDBDAOCheckIranBlackCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOCheckIranBlackCustomerRSQL").append("\n"); 
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
		query.append("SELECT DECODE(count(*),0,'N','Y')" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID='IRAN_BLACK_LIST'" ).append("\n"); 
		query.append("	AND ATTR_CTNT1 LIKE '%'||@[cust_nm]||'%'" ).append("\n"); 

	}
}