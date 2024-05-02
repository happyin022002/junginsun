/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOInternetBookingRequestEmailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.01.04 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOInternetBookingRequestEmailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingUtilDBDAOInternetBookingRequestEmailInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOInternetBookingRequestEmailInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	BKG.BKG_NO," ).append("\n"); 
		query.append("  	(SELECT BCP.CNTC_PSON_EML FROM BKG_CNTC_PSON BCP WHERE BCP.BKG_NO = BKG.BKG_NO AND BCP.BKG_CNTC_PSON_TP_CD = 'BK' AND ROWNUM = 1) AS BKG_CNTC_PSON_EML," ).append("\n"); 
		query.append("  	BKG.RC_FLG," ).append("\n"); 
		query.append("  	BKG.DCGO_FLG," ).append("\n"); 
		query.append("  	BKG.AWK_CGO_FLG," ).append("\n"); 
		query.append("  	BKG.XTER_RMK," ).append("\n"); 
		query.append("  	(SELECT COUNT(HIS.BKG_NO) FROM BKG_NTC_HIS HIS WHERE HIS.BKG_NO = BKG.BKG_NO AND HIS.NTC_KND_CD = 'BK' AND HIS.NTC_VIA_CD = 'M' ) AS XTER_RQST_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ  = (SELECT MAX(XTER_RQST_SEQ) FROM BKG_XTER_RQST_MST WHERE XTER_RQST_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("AND MST.AUTO_EML_FLG = 'Y'" ).append("\n"); 

	}
}