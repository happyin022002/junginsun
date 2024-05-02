/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPrecautionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.01
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.02.01 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchPrecautionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Creation시 cmdt_cd로 Precaution 정보 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPrecautionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPrecautionRSQL").append("\n"); 
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
		query.append("SELECT 	CASE WHEN REP_IMDG_LVL_CD = 'P' THEN 'P'" ).append("\n"); 
		query.append("             ELSE (SELECT 'H' " ).append("\n"); 
		query.append("                     FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                    WHERE HRD_CDG_ID = 'RAW_WET_HIDE_CMDT' " ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = CMDT_CD) END REP_IMDG_LVL_CD, " ).append("\n"); 
		query.append("		CMDT_NM," ).append("\n"); 
		query.append("		REP_CMDT_CD " ).append("\n"); 
		query.append("  FROM MDM_COMMODITY" ).append("\n"); 
		query.append(" WHERE CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}