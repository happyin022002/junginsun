/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgEurTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgEurTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgEurTroRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgEurTroRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgEurTroRSQL").append("\n"); 
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
		query.append("        SELECT 'TRO YARD' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.HLG_TP_CD||" ).append("\n"); 
		query.append("                  '/PICKUP:'||NOW.CNTR_PKUP_YD_CD||" ).append("\n"); 
		query.append("                  '/'||TO_CHAR(NOW.CNTR_PKUP_DT, 'YYYY-MM-DD HH24:MI:SS')||" ).append("\n"); 
		query.append("                  '/RETURN:'||NOW.CNTR_RTN_YD_CD||" ).append("\n"); 
		query.append("                  '/'||TO_CHAR(NOW.CNTR_RTN_DT, 'YYYY-MM-DD HH24:MI:SS') CRNT_CTNT" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO ACTUAL SHIPPER' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_CNT_CD||NOW.ACT_CUST_SEQ CRNT_CTNT" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO RATE' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CURR_CD||" ).append("\n"); 
		query.append("                  '/MANIFESTED RATE:'||NOW.ALL_IN_RT_CD||" ).append("\n"); 
		query.append("                  '/VAT'||NOW.VAT_FLG||" ).append("\n"); 
		query.append("                  '/T1 DOC'||NOW.T1_DOC_FLG||" ).append("\n"); 
		query.append("                  '/'||NOW.TRNS_REV_AMT CRNT_CTNT" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO SPCL INST' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, TRO_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}