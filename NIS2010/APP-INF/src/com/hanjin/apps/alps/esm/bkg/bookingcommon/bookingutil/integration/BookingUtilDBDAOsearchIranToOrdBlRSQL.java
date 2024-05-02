/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDAOsearchIranToOrdBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchIranToOrdBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Iran에 Order B/L이 출항, 입항하는지 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOsearchIranToOrdBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchIranToOrdBlRSQL").append("\n"); 
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
		query.append("SELECT NVL(" ).append("\n"); 
		query.append("        (SELECT 'Y'" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("         WHERE (BK.POR_CD LIKE 'IR%' OR BK.POL_CD LIKE 'IR%' OR BK.POD_CD LIKE 'IR%' OR BK.DEL_CD LIKE 'IR%')" ).append("\n"); 
		query.append("           AND CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("           AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                             FROM BKG_CUSTOMER BC " ).append("\n"); 
		query.append("                            WHERE BC.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("                              AND BC.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                              AND BC.CUST_CNT_CD = 'KR' " ).append("\n"); 
		query.append("                              AND BC.CUST_SEQ = 21) " ).append("\n"); 
		query.append("           AND BKG_NO = @[bkg_no]), 'N'" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("         ) RESULT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}