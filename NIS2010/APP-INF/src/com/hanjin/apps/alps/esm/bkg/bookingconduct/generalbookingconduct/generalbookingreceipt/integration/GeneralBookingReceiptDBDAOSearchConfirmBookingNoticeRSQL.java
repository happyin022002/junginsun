/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchConfirmBookingNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchConfirmBookingNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Confirm Booking notice
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchConfirmBookingNoticeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchConfirmBookingNoticeRSQL").append("\n"); 
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
		query.append("SELECT BCP.CNTC_PSON_EML CNTC_PSON_EML" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("     ,BKG_CNTC_PSON BCP" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BB.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("AND BB.NON_RT_STS_CD = 'F'" ).append("\n"); 
		query.append("AND BB.ALOC_STS_CD = 'F'" ).append("\n"); 
		query.append("AND BB.BKG_NO = BXRM.BKG_NO" ).append("\n"); 
		query.append("AND BXRM.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("AND BXRM.XTER_RQST_VIA_CD = 'WEB'" ).append("\n"); 
		query.append("AND BXRM.AUTO_EML_FLG = 'Y'" ).append("\n"); 
		query.append("AND BB.BKG_NO = BCP.BKG_NO" ).append("\n"); 
		query.append("AND BCP.BKG_CNTC_PSON_TP_CD = 'BK'" ).append("\n"); 
		query.append("AND BCP.CNTC_PSON_EML IS NOT NULL" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' FROM BKG_NTC_HIS BNH WHERE BNH.BKG_NO = BB.BKG_NO AND BNH.NTC_VIA_CD = 'M' AND BNH.NTC_KND_CD = 'BK')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}