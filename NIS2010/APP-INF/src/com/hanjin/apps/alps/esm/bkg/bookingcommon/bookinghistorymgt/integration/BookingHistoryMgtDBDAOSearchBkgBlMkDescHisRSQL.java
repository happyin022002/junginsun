/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgBlMkDescHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.11.14 이준근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchBkgBlMkDescHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgBlMkDescHis
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgBlMkDescHisRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration ").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgBlMkDescHisRSQL").append("\n"); 
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
		query.append("    SELECT 'MARKS' HIS_CATE_NM" ).append("\n"); 
		query.append("           , TRIM(NVL(NOW_BL.MK_DESC, ' ')) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_MK_DESC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE NOW_BL.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_MK_DESC NOW_BL" ).append("\n"); 
		query.append("     WHERE NOW_BL.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("    SELECT 'DESCRIPTION OF GOODS' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TRIM(NVL(NOW_BL.CMDT_DESC, ' ')) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_MK_DESC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE NOW_BL.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_MK_DESC NOW_BL" ).append("\n"); 
		query.append("     WHERE NOW_BL.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}