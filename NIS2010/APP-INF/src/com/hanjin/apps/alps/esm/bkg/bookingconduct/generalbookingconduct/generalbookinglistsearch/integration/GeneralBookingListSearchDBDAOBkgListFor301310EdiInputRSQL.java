/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOBkgListFor301310EdiInputRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOBkgListFor301310EdiInputRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgListFor301310EdiInput
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOBkgListFor301310EdiInputRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration ").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOBkgListFor301310EdiInputRSQL").append("\n"); 
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
		query.append("SELECT  '' AS BKG_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS BL_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS CUST_NM" ).append("\n"); 
		query.append("       ,'' AS EDI_RECEIVE_NM" ).append("\n"); 
		query.append("       ,'' AS CUST_SEQ" ).append("\n"); 
		query.append("       ,'' AS BL_NO" ).append("\n"); 
		query.append("       ,'' AS VVD" ).append("\n"); 
		query.append("       ,'' AS BKG_STF_CD" ).append("\n"); 
		query.append("       ,'' AS SALES_REP" ).append("\n"); 
		query.append("       ,'' AS BKG_NO" ).append("\n"); 
		query.append("       ,'' AS POL_CD" ).append("\n"); 
		query.append("       ,'' AS SC_NO" ).append("\n"); 
		query.append("       ,'' AS BKG_TO_DT" ).append("\n"); 
		query.append("       ,'' AS SLS_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS BKG_FROM_DT" ).append("\n"); 
		query.append("       ,'' AS EDI_GROUP_ID" ).append("\n"); 
		query.append("       ,'' AS CUST_TP_CD" ).append("\n"); 
		query.append("       ,'' AS CUST_CNT_CD" ).append("\n"); 
		query.append("       ,'' AS EDI_RECEIVE_ID" ).append("\n"); 
		query.append("       ,'' AS EDI_SENT_STS_CD" ).append("\n"); 
		query.append("       ,'' AS POD_CD" ).append("\n"); 
		query.append("       ,'' AS DEL_CD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}