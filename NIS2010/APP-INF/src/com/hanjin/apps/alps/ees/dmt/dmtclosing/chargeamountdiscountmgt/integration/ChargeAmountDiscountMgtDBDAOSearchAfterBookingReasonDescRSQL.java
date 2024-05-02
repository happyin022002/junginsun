/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.23 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDesc
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDescRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT2 AS RSN_DESC" ).append("\n"); 
		query.append("     , ATTR_CTNT3 AS SPEC_RSN_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT4 AS SPEC_RSN_DESC" ).append("\n"); 
		query.append("	 , ATTR_CTNT5 AS RSN_BT_CD" ).append("\n"); 
		query.append("	 , ATTR_CTNT6 AS RSN_DESC_FLG" ).append("\n"); 
		query.append("	 , ATTR_CTNT7 AS RSN_FILE_FLG" ).append("\n"); 
		query.append("	 , ATTR_CTNT10 AS DTL_RMK" ).append("\n"); 
		query.append("	 , ' |'||bkg_join_fnc(CURSOR ((SELECT ATTR_CTNT3 " ).append("\n"); 
		query.append("                               FROM DMT_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                              WHERE HRD_CDG_ID = 'AFT_BKG_SPEC_RSN_CD'" ).append("\n"); 
		query.append("                                AND ATTR_CTNT1 = A.ATTR_CTNT3 " ).append("\n"); 
		query.append("                                AND ATTR_CTNT4 = 'file')),'|') FILE_LVL_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , ' |'||bkg_join_fnc(CURSOR ((SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                               FROM DMT_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                              WHERE HRD_CDG_ID = 'AFT_BKG_SPEC_RSN_CD'" ).append("\n"); 
		query.append("                                AND ATTR_CTNT1 = A.ATTR_CTNT3" ).append("\n"); 
		query.append("                                AND ATTR_CTNT4 = 'file' )),'|') FILE_LVL_VALUE" ).append("\n"); 
		query.append("FROM DMT_HRD_CDG_CTNT A" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'AFT_BKG_RSN_CD'" ).append("\n"); 
		query.append("ORDER BY HRD_CDG_ID_SEQ" ).append("\n"); 

	}
}