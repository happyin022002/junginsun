/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchManualBookingStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : Moon Hwan Choi
*@LastVersion : 1.0
* 2015.03.25 Moon Hwan Choi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchManualBookingStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManualBookingStatus
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchManualBookingStatusRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orgl_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchManualBookingStatusRSQL").append("\n"); 
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
		query.append("WITH BKG_MNL_BOOKING AS (" ).append("\n"); 
		query.append("SELECT 1 AS SEQ_NO " ).append("\n"); 
		query.append("     ,'OBK' AS SRC_TB" ).append("\n"); 
		query.append("     , COUNT(*) AS CNT" ).append("\n"); 
		query.append("     , BKG_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[orgl_bkg_no]" ).append("\n"); 
		query.append(" GROUP BY 'OBK', BKG_OFC_CD" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 2 AS SEQ_NO " ).append("\n"); 
		query.append("     ,'BKG' AS SRC_TB" ).append("\n"); 
		query.append("     , COUNT(*) AS CNT" ).append("\n"); 
		query.append("     , BKG_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" GROUP BY 'BKG', BKG_OFC_CD" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 3 AS SEQ_NO" ).append("\n"); 
		query.append("     , 'XTR' AS SRC_TB" ).append("\n"); 
		query.append("     , COUNT(*) AS CNT" ).append("\n"); 
		query.append("     , ''  AS OFC_CD " ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" GROUP BY 'XTR', ''" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 4 AS SEQ_NO" ).append("\n"); 
		query.append("     , 'MNL' AS SRC_TB" ).append("\n"); 
		query.append("     , COUNT(*) AS CNT" ).append("\n"); 
		query.append("     , CRE_OFC_CD AS OFC_CD  " ).append("\n"); 
		query.append("  FROM BKG_CHN_BKG_NO_GEN " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" GROUP BY 'MNL', CRE_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT CASE WHEN NVL((SELECT CNT FROM BKG_MNL_BOOKING WHERE SEQ_NO =3),0) > 0 THEN 'X' -- Occupied in eService" ).append("\n"); 
		query.append("            WHEN NVL((SELECT CNT FROM BKG_MNL_BOOKING WHERE SEQ_NO =2),0) > 0 THEN 'B' -- Occupied in OPUS Booking " ).append("\n"); 
		query.append("            WHEN NVL((SELECT CNT FROM BKG_MNL_BOOKING WHERE SEQ_NO =4),0) = 0 THEN 'M' -- Manual number is not exist" ).append("\n"); 
		query.append("            ELSE NVL((SELECT CASE WHEN MNL1.OFC_CD = MNL2.OFC_CD THEN 'Y' ELSE 'O' END FROM BKG_MNL_BOOKING MNL1, BKG_MNL_BOOKING MNL2 WHERE MNL1.SEQ_NO =1 AND MNL2.SEQ_NO =4 ),'Y') -- 'O' Original booking and manual bookin number creation office doe not matched. 'Y' This booking number can use for manual booking copy." ).append("\n"); 
		query.append("       END AS MNL_BKG_STS" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 

	}
}