/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.07.11 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgTroRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgTroRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgTroRSQL").append("\n"); 
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
		query.append("        SELECT 'TRO ACTUAL SHIPPER' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.ACT_SHPR_CNT_CD||NOW.ACT_SHPR_SEQ||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_SHPR_NM||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_PSON_NM||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_SHPR_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_FAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_MPHN_NO CRNT_CTNT" ).append("\n"); 
		query.append("                , NOW.TRO_SEQ" ).append("\n"); 
		query.append("                , 1 SORT_ORDER" ).append("\n"); 
		query.append("          FROM BKG_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, RTN_TRO_FLG, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO DOOR' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.DOR_LOC_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.ZN_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_SHPR_ADDR||" ).append("\n"); 
		query.append("                  '/SELF:'||NOW.OWNR_TRK_FLG CRNT_CTNT" ).append("\n"); 
		query.append("                , NOW.TRO_SEQ" ).append("\n"); 
		query.append("                , 2 SORT_ORDER" ).append("\n"); 
		query.append("          FROM BKG_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, RTN_TRO_FLG, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO CFM' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , 'TRO SEQ: '||NOW.TRO_SEQ ||', Confirm ' ||NOW.CFM_FLG CRNT_CTNT" ).append("\n"); 
		query.append("                , NOW.TRO_SEQ" ).append("\n"); 
		query.append("                , 3 SORT_ORDER" ).append("\n"); 
		query.append("          FROM BKG_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, RTN_TRO_FLG, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND NOW.CFM_FLG = 'Y' --N is not the target of new history" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO RMK' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.DIFF_RMK CRNT_CTNT" ).append("\n"); 
		query.append("                , NOW.TRO_SEQ" ).append("\n"); 
		query.append("                , 4 SORT_ORDER" ).append("\n"); 
		query.append("          FROM BKG_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, RTN_TRO_FLG, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY TRO_SEQ, SORT_ORDER" ).append("\n"); 

	}
}