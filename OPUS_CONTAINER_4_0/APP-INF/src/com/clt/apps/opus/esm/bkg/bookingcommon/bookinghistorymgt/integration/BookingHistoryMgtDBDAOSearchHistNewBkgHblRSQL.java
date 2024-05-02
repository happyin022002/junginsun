/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgHblRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.09.30 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgHblRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgHblRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgHblRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgHblRSQL").append("\n"); 
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
		query.append("	 , CNTR_MF_NO AS COLUMN1" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'HOUSE B/L' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.HBL_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTR_MF_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.BL_MK_DESC||" ).append("\n"); 
		query.append("                  '/'||NOW.BL_GDS_DESC||" ).append("\n"); 
		query.append("                  '/WEIGHT:'||NOW.HBL_WGT||' '||NOW.WGT_UT_CD||" ).append("\n"); 
		query.append("                  '/PACKAGE:'||NOW.PCK_QTY||' '||NOW.PCK_TP_CD||" ).append("\n"); 
		query.append("                  '/MEASURE:'||NOW.CMDT_MEAS_QTY||' '||NOW.CMDT_MEAS_UT_CD CRNT_CTNT" ).append("\n"); 
		query.append("				, NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_HBL_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_HBL NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, HBL_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}