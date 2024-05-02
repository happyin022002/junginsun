/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgRfCgoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOBkgRfCgoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRfCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgRfCgoVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOBkgRfCgoVORSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	a.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	a.CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	a.BKG_NO" ).append("\n"); 
		query.append(",	a.RC_SEQ" ).append("\n"); 
		query.append(",	a.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	a.CNTR_NO" ).append("\n"); 
		query.append(",	a.PCK_TP_CD" ).append("\n"); 
		query.append(",	a.PCK_QTY" ).append("\n"); 
		query.append(",	a.NET_WGT" ).append("\n"); 
		query.append(",	a.GRS_WGT" ).append("\n"); 
		query.append(",	a.WGT_UT_CD" ).append("\n"); 
		query.append(",	a.CMDT_CD" ).append("\n"); 
		query.append(",	a.CMDT_DESC" ).append("\n"); 
		query.append(",	a.FDO_TEMP" ).append("\n"); 
		query.append(",	a.CDO_TEMP" ).append("\n"); 
		query.append(",	a.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(",	a.VENT_RTO" ).append("\n"); 
		query.append(",	a.CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	a.HUMID_NO" ).append("\n"); 
		query.append(",	a.DIFF_RMK" ).append("\n"); 
		query.append(",	a.RF_DCGO_SEQ" ).append("\n"); 
		query.append(",	a.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(",	a.VLTG_NO" ).append("\n"); 
		query.append(",	a.CTRL_ATMS_FLG" ).append("\n"); 
		query.append(",	a.MODI_ATMS_FLG" ).append("\n"); 
		query.append(",	a.HUMID_CTRL_FLG" ).append("\n"); 
		query.append(",	a.ATFC_ATMS_FLG" ).append("\n"); 
		query.append(",	a.CNTR_DRN_CD" ).append("\n"); 
		query.append(",	a.CLNG_TP_CD" ).append("\n"); 
		query.append(",	a.RQST_DT" ).append("\n"); 
		query.append(",	a.RQST_USR_ID" ).append("\n"); 
		query.append(",	a.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	a.CRE_USR_ID" ).append("\n"); 
		query.append(",	a.CRE_DT" ).append("\n"); 
		query.append(",	a.UPD_USR_ID" ).append("\n"); 
		query.append(",	a.UPD_DT" ).append("\n"); 
		query.append(",   b.POR_CD" ).append("\n"); 
		query.append(",   b.DEL_CD" ).append("\n"); 
		query.append(",   b.RCV_TERM_CD" ).append("\n"); 
		query.append(",   b.DE_TERM_CD" ).append("\n"); 
		query.append(",   c.CNTR_TPSZ_DESC EQ_TPSZ" ).append("\n"); 
		query.append(",	(SELECT CNTR_CGO_SEQ FROM BKG_DG_CGO_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND DCGO_SEQ = RF_DCGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("          FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("              ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                     , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                     , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                     , RC_SEQ" ).append("\n"); 
		query.append("                 FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND SPCL_CGO_CATE_CD = 'RF'" ).append("\n"); 
		query.append("                GROUP BY RC_SEQ) N " ).append("\n"); 
		query.append("         WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("           AND M.VSL_PRE_PST_CD||VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("           AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("           AND M.RC_SEQ = N.RC_SEQ" ).append("\n"); 
		query.append("           AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND M.RC_SEQ = A.RC_SEQ) APLY_NO " ).append("\n"); 
		query.append("FROM BKG_RF_CGO_HIS a, BKG_BKG_HIS b, MDM_CNTR_TP_SZ c" ).append("\n"); 
		query.append("WHERE	a.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND		a.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("AND 	a.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND 	a.CORR_NO = b.CORR_NO" ).append("\n"); 
		query.append("AND     a.CNTR_TPSZ_CD = c.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.RC_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	a.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	a.CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	a.BKG_NO" ).append("\n"); 
		query.append(",	a.RC_SEQ" ).append("\n"); 
		query.append(",	a.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	a.CNTR_NO" ).append("\n"); 
		query.append(",	a.PCK_TP_CD" ).append("\n"); 
		query.append(",	a.PCK_QTY" ).append("\n"); 
		query.append(",	a.NET_WGT" ).append("\n"); 
		query.append(",	a.GRS_WGT" ).append("\n"); 
		query.append(",	a.WGT_UT_CD" ).append("\n"); 
		query.append(",	a.CMDT_CD" ).append("\n"); 
		query.append(",	a.CMDT_DESC" ).append("\n"); 
		query.append(",	a.FDO_TEMP" ).append("\n"); 
		query.append(",	a.CDO_TEMP" ).append("\n"); 
		query.append(",	a.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(",	a.VENT_RTO" ).append("\n"); 
		query.append(",	a.CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	a.HUMID_NO" ).append("\n"); 
		query.append(",	a.DIFF_RMK" ).append("\n"); 
		query.append(",	a.RF_DCGO_SEQ" ).append("\n"); 
		query.append(",	a.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(",	a.VLTG_NO" ).append("\n"); 
		query.append(",	a.CTRL_ATMS_FLG" ).append("\n"); 
		query.append(",	a.MODI_ATMS_FLG" ).append("\n"); 
		query.append(",	a.HUMID_CTRL_FLG" ).append("\n"); 
		query.append(",	a.ATFC_ATMS_FLG" ).append("\n"); 
		query.append(",	a.CNTR_DRN_CD" ).append("\n"); 
		query.append(",	a.CLNG_TP_CD" ).append("\n"); 
		query.append(",	a.RQST_DT" ).append("\n"); 
		query.append(",	a.RQST_USR_ID" ).append("\n"); 
		query.append(",	a.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	a.CRE_USR_ID" ).append("\n"); 
		query.append(",	a.CRE_DT" ).append("\n"); 
		query.append(",	a.UPD_USR_ID" ).append("\n"); 
		query.append(",	a.UPD_DT" ).append("\n"); 
		query.append(",   b.POR_CD" ).append("\n"); 
		query.append(",   b.DEL_CD" ).append("\n"); 
		query.append(",   b.RCV_TERM_CD" ).append("\n"); 
		query.append(",   b.DE_TERM_CD" ).append("\n"); 
		query.append(",   c.CNTR_TPSZ_DESC EQ_TPSZ" ).append("\n"); 
		query.append(",	(SELECT CNTR_CGO_SEQ FROM BKG_DG_CGO WHERE BKG_NO = @[bkg_no] AND DCGO_SEQ = RF_DCGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("          FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("              ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                     , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                     , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                     , RC_SEQ" ).append("\n"); 
		query.append("                 FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND SPCL_CGO_CATE_CD = 'RF'" ).append("\n"); 
		query.append("                GROUP BY RC_SEQ) N " ).append("\n"); 
		query.append("         WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("           AND M.VSL_PRE_PST_CD||M.VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("           AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("           AND M.RC_SEQ = N.RC_SEQ" ).append("\n"); 
		query.append("           AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND M.RC_SEQ = A.RC_SEQ) APLY_NO " ).append("\n"); 
		query.append("FROM BKG_RF_CGO a, BKG_BOOKING b, MDM_CNTR_TP_SZ c" ).append("\n"); 
		query.append("WHERE	a.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND		a.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("AND     a.CNTR_TPSZ_CD = c.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.RC_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}