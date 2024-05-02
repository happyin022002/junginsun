/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgChgRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.26 
* 1.0 Creation
* History
* 2012.10.15 김기택 [CHM-201218571-01] [BKG] C/A 항목 추가 요청
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

public class BookingHistoryMgtDBDAOSearchHistNewBkgChgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgChgRtRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgChgRtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgChgRtRSQL").append("\n"); 
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
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'CHARGE OFFICE' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.N3PTY_RCV_OFC_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CHG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CHG_RT NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, RT_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'CHARGE DETAIL' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CHG_CD||" ).append("\n"); 
		query.append("				  '/'||NOW.TRF_ITM_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CURR_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.CHG_UT_AMT, '99,999,999.00'))||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.RAT_AS_QTY, '99,999.000'))||" ).append("\n"); 
		query.append("                  '/'||NOW.RAT_UT_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.CHG_AMT, '999,999,999.00'))||" ).append("\n"); 
		query.append("                  '/'||DECODE(NOW.FRT_INCL_XCLD_DIV_CD, 'Y', 'INCLUDE', 'N', 'EXCLUDE')||" ).append("\n"); 
		query.append("                  '/'||NOW.FRT_TERM_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.CGO_CATE_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.N3PTY_RCV_OFC_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.N3PTY_CUST_CNT_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.N3PTY_CUST_SEQ, '000000'))||" ).append("\n"); 
		query.append("				  '/'||NOW.PRN_HDN_FLG CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CHG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CHG_RT NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, RT_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}