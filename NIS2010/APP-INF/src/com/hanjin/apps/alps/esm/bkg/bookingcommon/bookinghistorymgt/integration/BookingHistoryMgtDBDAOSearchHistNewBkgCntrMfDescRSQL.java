/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgCntrMfDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
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

public class BookingHistoryMgtDBDAOSearchHistNewBkgCntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgCntrMfDescRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgCntrMfDescRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgCntrMfDescRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("		SELECT 'Container No.(CM)' HIS_CATE_NM" ).append("\n"); 
		query.append("        	, '' PRE_CTNT" ).append("\n"); 
		query.append("	        , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')' CRNT_CTNT" ).append("\n"); 
		query.append("			, NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO, CNTR_MF_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT 'PKG/Weight/Measure(CM)' HIS_CATE_NM" ).append("\n"); 
		query.append("        	, '' PRE_CTNT" ).append("\n"); 
		query.append("    	    , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("        	    ||NOW.PCK_QTY||'('||NOW.PCK_TP_CD||')/'||NOW.CNTR_MF_WGT||'('||WGT_UT_CD||')/'||NOW.MEAS_QTY||'('||NOW.MEAS_UT_CD||')' CRNT_CTNT" ).append("\n"); 
		query.append("			, NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO, CNTR_MF_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("    	SELECT 'WPM' HIS_CATE_NM" ).append("\n"); 
		query.append("            , '' PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||DECODE(NOW.WPM_TRT_CD,'A','N/A',NOW.WPM_TRT_CD) CRNT_CTNT" ).append("\n"); 
		query.append("			, NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.WPM_TRT_CD IS NOT NULL" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO, CNTR_MF_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("	    SELECT 'M&D' HIS_CATE_NM" ).append("\n"); 
		query.append("            , '' PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||NOW.CNTR_MF_MK_DESC||'/'||NOW.CNTR_MF_GDS_DESC CRNT_CTNT" ).append("\n"); 
		query.append("			, NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO, CNTR_MF_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("    	SELECT 'HTS / HS' HIS_CATE_NM" ).append("\n"); 
		query.append("            , '' PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||NOW.HAMO_TRF_CD||'/'||NOW.CMDT_HS_CD CRNT_CTNT" ).append("\n"); 
		query.append("			, NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND (NOW.HAMO_TRF_CD IS NOT NULL OR NOW.CMDT_HS_CD IS NOT NULL OR NOW.NCM_NO IS NOT NULL)" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO, CNTR_MF_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'NCM' HIS_CATE_NM" ).append("\n"); 
		query.append("            , '' PRE_CTNT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("            ,  NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')'||'/'||BKG_JOIN_FNC (CURSOR( SELECT NCM_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("                                                        FROM BKG_CNTR_MF_DESC_DTL_HIS CUR" ).append("\n"); 
		query.append("                                                       WHERE CUR.BKG_NO      = NOW.BKG_NO" ).append("\n"); 
		query.append("                                                       AND   CUR.CORR_NO     = 'TMP0000001'                                     " ).append("\n"); 
		query.append("#else                                     " ).append("\n"); 
		query.append("                                                        FROM BKG_CNTR_MF_DESC_DTL CUR" ).append("\n"); 
		query.append("                                                       WHERE CUR.BKG_NO      = NOW.BKG_NO" ).append("\n"); 
		query.append("#end                                     " ).append("\n"); 
		query.append("                                                       AND   CUR.CNTR_NO     = NOW.CNTR_NO" ).append("\n"); 
		query.append("                                                       AND   CUR.CNTR_MF_SEQ = NOW.CNTR_MF_SEQ)" ).append("\n"); 
		query.append("                            ) CRNT_CTNT        " ).append("\n"); 
		query.append("            , NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND (NOW.NCM_NO IS NOT NULL)" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO, CNTR_MF_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("	    SELECT 'Manifest File No.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , '' PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||NOW.CNTR_MF_NO CRNT_CTNT " ).append("\n"); 
		query.append("			, NOW.CNTR_MF_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNTR_MF_NO IS NOT NULL" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO, CNTR_MF_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}