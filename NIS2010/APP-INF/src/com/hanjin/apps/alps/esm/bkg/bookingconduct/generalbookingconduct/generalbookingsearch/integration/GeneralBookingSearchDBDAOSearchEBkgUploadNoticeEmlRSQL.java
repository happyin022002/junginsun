/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchEBkgUploadNoticeEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.11.17 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchEBkgUploadNoticeEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * e-Booking Upload Notice 메일 수신인을 조회한다.
	  * WEB을 통해 자동생성된 BKG 중 Auto Notification에 체크되어있고  
	  * Standby:F, NoRate:R인 Booking에 대해 Upload(Receipt) Notice를 전송해준다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchEBkgUploadNoticeEmlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchEBkgUploadNoticeEmlRSQL").append("\n"); 
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
		query.append("SELECT CNTC_PSON_EML" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_CNTC_PSON C" ).append("\n"); 
		query.append("WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.CRE_USR_ID = 'HOMEPAGE'        -- WEB Auto Creation 된 BKG" ).append("\n"); 
		query.append("AND B.XTER_RQST_AUTO_NTC_FLG = 'Y'   -- Auto Notification 에 체크" ).append("\n"); 
		query.append("AND NVL(B.ALOC_STS_CD,'X') <> 'S'    -- Stanby 'F' " ).append("\n"); 
		query.append("AND NVL(B.NON_RT_STS_CD,'X') <> 'R'  -- No Rate 'F'" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_CNTC_PSON_TP_CD = 'BK'" ).append("\n"); 
		query.append("AND C.CNTC_PSON_EML IS NOT NULL" ).append("\n"); 
		query.append("AND INSTR(C.CNTC_PSON_EML,'@') > 0" ).append("\n"); 
		query.append("AND 0 = (SELECT COUNT(*)" ).append("\n"); 
		query.append("         FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         AND NTC_KND_CD = 'BK'" ).append("\n"); 
		query.append("         AND NTC_VIA_CD = 'M')" ).append("\n"); 

	}
}