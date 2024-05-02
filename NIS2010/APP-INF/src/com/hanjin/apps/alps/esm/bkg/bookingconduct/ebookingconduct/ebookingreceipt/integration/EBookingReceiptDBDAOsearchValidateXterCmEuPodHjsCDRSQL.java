/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchValidateXterCmEuPodHjsCDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchValidateXterCmEuPodHjsCDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBooking의 Booking POL의 유럽 여부와 POD의 독일 포함 여부, HjS Code의 입력 유무를 확인 한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchValidateXterCmEuPodHjsCDRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchValidateXterCmEuPodHjsCDRSQL").append("\n"); 
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
		query.append("  SELECT DECODE(COUNT(*),0,'N','Y')" ).append("\n"); 
		query.append("     , NVL(SUM((SELECT COUNT(*) FROM BKG_CNTR_MF_DESC MC WHERE MC.BKG_NO = BK.BKG_NO AND MC.CMDT_HS_CD IS NULL)),0)" ).append("\n"); 
		query.append("  FROM BKG_VVD BK " ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.POD_CD LIKE 'DE%'" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'Y' " ).append("\n"); 
		query.append("                     FROM BKG_BOOKING K, " ).append("\n"); 
		query.append("                          BKG_VVD VVD , " ).append("\n"); 
		query.append("                          MDM_LOCATION MDM" ).append("\n"); 
		query.append("                    WHERE K.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                      AND K.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                      AND K.POL_CD = MDM.LOC_CD" ).append("\n"); 
		query.append("                      AND MDM.CONTI_CD = 'E'" ).append("\n"); 
		query.append("                      AND VVD.POD_CD LIKE 'DE%'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}