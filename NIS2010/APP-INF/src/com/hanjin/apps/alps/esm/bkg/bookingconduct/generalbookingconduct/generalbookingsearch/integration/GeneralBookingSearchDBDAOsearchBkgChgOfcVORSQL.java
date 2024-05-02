/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchBkgChgOfcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchBkgChgOfcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgChgOfcVO
	  * 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchBkgChgOfcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchBkgChgOfcVORSQL").append("\n"); 
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
		query.append("SELECT '' BKG_NO" ).append("\n"); 
		query.append("     , '' PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("     , '' PPD_PAYR_CNT_CD" ).append("\n"); 
		query.append("     , '' PPD_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("     , '' CLT_OFC_CD" ).append("\n"); 
		query.append("     , '' CLT_PAYR_CNT_CD" ).append("\n"); 
		query.append("     , '' CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("     , '' BF_PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("     , '' BF_PPD_PAYR_CNT_CD" ).append("\n"); 
		query.append("     , '' BF_PPD_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("     , '' BF_CLT_OFC_CD" ).append("\n"); 
		query.append("     , '' BF_CLT_PAYR_CNT_CD" ).append("\n"); 
		query.append("     , '' BF_CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}