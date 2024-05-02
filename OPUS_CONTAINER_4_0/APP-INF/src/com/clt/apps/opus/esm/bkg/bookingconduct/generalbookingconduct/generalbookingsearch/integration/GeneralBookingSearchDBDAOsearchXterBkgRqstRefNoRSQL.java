/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchXterBkgRqstRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchXterBkgRqstRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBkgRqstRefNo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchXterBkgRqstRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchXterBkgRqstRefNoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  (SELECT CASE WHEN MST.XTER_SNDR_ID = 'INTTRANG2' OR MST.PGSS_EDI_ID = 'IT' THEN '301' ELSE '' END" ).append("\n"); 
		query.append("   FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("   WHERE MST.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("   AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("   AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_VIA_CD <> 'WEB'" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = (SELECT MAX(MST1.XTER_RQST_SEQ) FROM BKG_XTER_RQST_MST MST1 " ).append("\n"); 
		query.append("                                                           WHERE MST.XTER_SNDR_ID = MST1.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                                           AND MST.BKG_NO = MST1.BKG_NO" ).append("\n"); 
		query.append("                                                           AND MST1.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                                                           AND MST1.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("                                                           AND MST1.XTER_RQST_VIA_CD <> 'WEB')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("   ) AS XTER_BKG_RQST_REF_NO," ).append("\n"); 
		query.append("	(SELECT BDC.ATTR_CTNT1 " ).append("\n"); 
		query.append("   FROM BKG_HRD_CDG_CTNT BDC " ).append("\n"); 
		query.append("   WHERE BDC.HRD_CDG_ID = 'CUSTOMER_301U' " ).append("\n"); 
		query.append("   AND BDC.ATTR_CTNT1 = @[rcv_id]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = BB.BKG_NO AND BDC.ATTR_CTNT2 = BC.CUST_CNT_CD||BC.CUST_SEQ)" ).append("\n"); 
		query.append("   AND ROWNUM = 1) AS FLAG" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}