/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgXptImpLicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.27 
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

public class BookingHistoryMgtDBDAOSearchHistNewBkgXptImpLicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgXptImpLicRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgXptImpLicRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgXptImpLicRSQL").append("\n"); 
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
		query.append("        SELECT DECODE(NOW.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-KOREA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.XPT_LIC_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.TS_REF_NO||" ).append("\n"); 
		query.append("                  '/PACKAGE:'||NOW.PCK_QTY||' '||NOW.PCK_TP_CD||" ).append("\n"); 
		query.append("                  '/WEIGHT:'||NOW.MF_WGT||' '||NOW.WGT_UT_CD||" ).append("\n"); 
		query.append("                  '/UCR:'||NOW.UCR_NO CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNT_CD = 'KR'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, XPT_IMP_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(NOW.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||'-USA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , TRIM(" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_INLND_TRNS_NO, '','','AES ITN:')||NOW.AES_INLND_TRNS_NO|| " ).append("\n"); 
		query.append("                  DECODE(NOW.AES_PTA_NO1, '','','PTA:')||NOW.AES_PTA_NO1||' '||NOW.AES_PTA_NO2||' '||TO_CHAR(NOW.AES_PTA_DT,'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_PTU_NO, '','','PTU:')||NOW.AES_PTU_NO||' '||TO_CHAR(NOW.AES_PTU_DT,'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_DWN_NO, '','','DOWN:')||NOW.AES_DWN_NO||' '||TO_CHAR(NOW.AES_DWN_DT,'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_EXPT_ID, '','','EXCEPTION:')||(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                                 WHERE INTG_CD_ID = 'CD02570'" ).append("\n"); 
		query.append("                                                                   AND INTG_CD_VAL_CTNT = NOW.AES_EXPT_ID)||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_EXPT_CTNT, '','','EXCEPTION:')||' '||NOW.AES_EXPT_CTNT) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNT_CD = 'US'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, XPT_IMP_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(NOW.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-INDONESIA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.ID_DECL_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.ID_XPT_NO||" ).append("\n"); 
		query.append("                  '/'||TO_CHAR(NOW.ID_XPT_NO_ISS_DT, 'YYYY-MM-DD HH24:MI:SS')||" ).append("\n"); 
		query.append("                  '/'||NOW.ID_OFC_ID CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNT_CD = 'ID'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, XPT_IMP_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(NOW.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-INDIA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.IDA_IEC_NO CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNT_CD = 'IN'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, XPT_IMP_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(NOW.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-BRAZIL' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.SHPR_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNEE_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.NTFY_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.BRZ_DECL_NO CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNT_CD = 'BR'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, XPT_IMP_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(NOW.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||'-CANADA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , '' PRE_CTNT" ).append("\n"); 
		query.append("                , TRIM(" ).append("\n"); 
		query.append("                 DECODE(NOW.CAED_NO1, '','','CAED:')||NOW.CAED_NO1||NOW.CAED_NO2||NOW.CAED_NO3||" ).append("\n"); 
		query.append("                 DECODE(NOW.G7_EDI_NO1, '','','G7 EDI:')||NOW.G7_EDI_NO1||NOW.G7_EDI_NO2||" ).append("\n"); 
		query.append("                 DECODE(NOW.B13A_XPT_NO1, '','','B13A:')||TO_CHAR(NOW.B13A_XPT_DT, 'YYYYMMDDHH24MI')||' '||NOW.B13A_XPT_NO1||NOW.B13A_XPT_NO2||" ).append("\n"); 
		query.append("                 DECODE(NOW.MF_SMRY_RPT_NO, '','','SUM:')||NOW.MF_SMRY_RPT_NO||" ).append("\n"); 
		query.append("                 DECODE(NOW.CGO_CTRL_NO, '','','IN-TRANSIT:')||NOW.CGO_CTRL_NO||" ).append("\n"); 
		query.append("                 DECODE(NOW.NDR_REF_ID, '','','NDR:')||NOW.NDR_REF_ID) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNT_CD = 'CA'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, IO_BND_CD, XPT_IMP_SEQ) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}