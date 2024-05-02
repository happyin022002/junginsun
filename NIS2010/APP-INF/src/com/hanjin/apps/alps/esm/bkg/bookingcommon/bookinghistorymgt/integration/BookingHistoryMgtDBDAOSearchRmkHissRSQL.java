/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchRmkHissRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchRmkHissRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchRmkHissRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchRmkHissRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchRmkHissRSQL").append("\n"); 
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
		query.append("SELECT BKG_DESC_CNG_ITM_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT CASE WHEN NVL(trim(@[xter_rmk]),'') = NVL(NOW_BK.XTER_RMK,'') AND NVL(trim(@[inter_rmk]),'') = NVL(NOW_BK.INTER_RMK,'') THEN ''" ).append("\n"); 
		query.append("                WHEN (@[inter_rmk] IS NULL AND NOW_BK.INTER_RMK IS NOT NULL) OR  (NVL(trim(@[inter_rmk]),'') <> NVL(NOW_BK.INTER_RMK,'')) THEN '2'" ).append("\n"); 
		query.append("                WHEN (@[xter_rmk] IS NULL AND NOW_BK.XTER_RMK IS NOT NULL) OR (NVL(trim(@[xter_rmk]),'') <> NVL(NOW_BK.XTER_RMK,'')) THEN '1'" ).append("\n"); 
		query.append("                ELSE '3' " ).append("\n"); 
		query.append("                END AS BKG_DESC_CNG_ITM_CD" ).append("\n"); 
		query.append("        , @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE BKG_DESC_CNG_ITM_CD IS NOT NULL" ).append("\n"); 

	}
}