/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchBLInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchBLInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchBLInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchBLInquiryRSQL").append("\n"); 
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
		query.append("SELECT ADVBL.BL_NO," ).append("\n"); 
		query.append("       ADVBL.VSL_CD||ADVBL.SKD_VOY_NO||ADVBL.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       VSL.VSL_ENG_NM," ).append("\n"); 
		query.append("       ADVBL.RVIS_CNTR_CUST_TP_CD AS MST_BL," ).append("\n"); 
		query.append("       ADVBL.POL_CD," ).append("\n"); 
		query.append("       ADVBL.POD_CD," ).append("\n"); 
		query.append("       SUBSTR(ADVBL.POD_CD, 3, 3) AS POD_POSTFIX," ).append("\n"); 
		query.append("       ADVBL.BKG_DEL_CD," ).append("\n"); 
		query.append("       ADVBL.RCV_TERM_CD," ).append("\n"); 
		query.append("       ADVBL.DE_TERM_CD," ).append("\n"); 
		query.append("       RTRIM(TO_CHAR(NVL(ADVBL.PCK_QTY, 0), 'FM999,999,990.999'), '.') AS PCK_QTY," ).append("\n"); 
		query.append("       ADVBL.PCK_TP_CD," ).append("\n"); 
		query.append("       RTRIM(TO_CHAR(NVL(ADVBL.GRS_WGT, 0), 'FM999,999,999,999,990.999'), '.') AS GRS_WGT," ).append("\n"); 
		query.append("       ADVBL.WGT_UT_CD," ).append("\n"); 
		query.append("       RTRIM(TO_CHAR(NVL(ADVBL.MEAS_QTY, 0), 'FM999,999,999.999'), '.') AS MEAS_QTY," ).append("\n"); 
		query.append("       ADVBL.MEAS_UT_CD," ).append("\n"); 
		query.append("       ADVBL.CMDT_CD," ).append("\n"); 
		query.append("       ADVBL.IMDG_CLSS_CD," ).append("\n"); 
		query.append("       ADVBL.IMDG_UN_NO," ).append("\n"); 
		query.append("       --------------------------" ).append("\n"); 
		query.append("       SHPR.CUST_CNT_CD AS SHPR_CNT_CD," ).append("\n"); 
		query.append("       SHPR.CUST_SEQ AS SHPR_SEQ," ).append("\n"); 
		query.append("       SHPR.PHN_NO AS SHPR_PHN_NO," ).append("\n"); 
		query.append("       SHPR.FAX_NO AS SHPR_FAX_NO," ).append("\n"); 
		query.append("       SHPR.CUST_NM AS SHPR_NM," ).append("\n"); 
		query.append("       SHPR.CUST_ADDR AS SHPR_ADDR," ).append("\n"); 
		query.append("       CNEE.CUST_CNT_CD AS CNEE_CNT_CD," ).append("\n"); 
		query.append("       CNEE.CUST_SEQ AS CNEE_SEQ," ).append("\n"); 
		query.append("       CNEE.PHN_NO AS CNEE_PHN_NO," ).append("\n"); 
		query.append("       CNEE.FAX_NO AS CNEE_FAX_NO," ).append("\n"); 
		query.append("       CNEE.CUST_NM AS CNEE_NM," ).append("\n"); 
		query.append("       CNEE.CUST_ADDR AS CNEE_ADDR," ).append("\n"); 
		query.append("       NTFY.CUST_CNT_CD AS NTFY_CNT_CD," ).append("\n"); 
		query.append("       NTFY.CUST_SEQ AS NTFY_SEQ," ).append("\n"); 
		query.append("       NTFY.PHN_NO AS NTFY_PHN_NO," ).append("\n"); 
		query.append("       NTFY.FAX_NO AS NTFY_FAX_NO," ).append("\n"); 
		query.append("       NTFY.CUST_NM AS NTFY_NM," ).append("\n"); 
		query.append("       NTFY.CUST_ADDR AS NTFY_ADDR," ).append("\n"); 
		query.append("       --------------------------" ).append("\n"); 
		query.append("       ADVBL.LOCL_TS_IND_CD," ).append("\n"); 
		query.append("       ADVBL.JP_CSTMS_TRNS_CD," ).append("\n"); 
		query.append("       ADVBL.LMT_NO," ).append("\n"); 
		query.append("       ADVBL.CY_OPR_ID," ).append("\n"); 
		query.append("--       CUST.RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("       DECODE(ADVBL.POD_CD, VVD.POD_CD, 'DIR', 'T/S') AS POD_DIV," ).append("\n"); 
		query.append("       '' AS CORR_RSN_CD," ).append("\n"); 
		query.append("       '' AS CORR_RSN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_BL ADVBL," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_CUST SHPR," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_CUST CNEE," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_CUST NTFY," ).append("\n"); 
		query.append("       MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("       MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE ADVBL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND ADVBL.JP_BL_STS_CD = 'A'" ).append("\n"); 
		query.append("   AND ADVBL.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("   AND ADVBL.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND ADVBL.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND ADVBL.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ(+) = SHPR.CUST_SEQ" ).append("\n"); 
		query.append("   AND CUST.CUST_CNT_CD(+) = SHPR.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND ADVBL.BL_NO = SHPR.BL_NO(+)" ).append("\n"); 
		query.append("   AND ADVBL.BL_SPLIT_NO = SHPR.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("   AND SHPR.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND ADVBL.BL_NO = CNEE.BL_NO(+)" ).append("\n"); 
		query.append("   AND ADVBL.BL_SPLIT_NO = CNEE.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("   AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND ADVBL.BL_NO = NTFY.BL_NO(+)" ).append("\n"); 
		query.append("   AND ADVBL.BL_SPLIT_NO = NTFY.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("   AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND ADVBL.VSL_CD = VSL.VSL_CD" ).append("\n"); 

	}
}