/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchRcvrBkgReviseNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.23
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.10.23 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchRcvrBkgReviseNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Revise Notice 수신 대상을 조회한다.
	  * Eml addres 별로 bkg no들을 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchRcvrBkgReviseNoticeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchRcvrBkgReviseNoticeRSQL").append("\n"); 
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
		query.append("WITH NTC AS" ).append("\n"); 
		query.append("    (SELECT BK.BKG_NO, NTC_EML " ).append("\n"); 
		query.append("       FROM BKG_BOOKING BK, BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("      WHERE BK.BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("        AND NTC.NTC_KND_CD = 'BK'   " ).append("\n"); 
		query.append("        AND NTC.NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("        AND NTC.HIS_SEQ = (SELECT MAX(HIS_SEQ) " ).append("\n"); 
		query.append("                             FROM BKG_NTC_HIS NTC2, COM_EML_SND_INFO EML" ).append("\n"); 
		query.append("                            WHERE NTC2.BKG_NO     = NTC.BKG_NO" ).append("\n"); 
		query.append("                              AND NTC2.NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                              AND NTC2.NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                              AND NTC2.SND_ID = EML.EML_SND_NO " ).append("\n"); 
		query.append("                              AND EML.EML_PROC_STS_CD = 3" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("        AND BK.BKG_NO IN (" ).append("\n"); 
		query.append("#if (${bkgNos} != '')" ).append("\n"); 
		query.append("       #foreach($bkgNosVal IN ${bkgNos})        " ).append("\n"); 
		query.append("          #if($velocityCount < $bkgNos.size()) '$bkgNosVal', #else '$bkgNosVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   )	" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT NTC_EML" ).append("\n"); 
		query.append("     , BKG_JOIN_FNC( CURSOR(SELECT NTC2.BKG_NO" ).append("\n"); 
		query.append("                              FROM NTC NTC2" ).append("\n"); 
		query.append("                             WHERE NTC.NTC_EML = NTC2.NTC_EML)) BKG_NOS" ).append("\n"); 
		query.append("	 , COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM NTC" ).append("\n"); 
		query.append(" GROUP BY NTC_EML" ).append("\n"); 

	}
}