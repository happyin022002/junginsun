/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgAwkCgoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.16 
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

public class SpecialCargoReceiptDBDAOBkgAwkCgoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgAwkCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgAwkCgoVORSQL(){
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
		query.append("FileName : SpecialCargoReceiptDBDAOBkgAwkCgoVORSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,A.AWK_CGO_SEQ" ).append("\n"); 
		query.append("      ,A.RCV_TERM_CD" ).append("\n"); 
		query.append("      ,A.DE_TERM_CD" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.PCK_TP_CD" ).append("\n"); 
		query.append("      ,A.PCK_QTY" ).append("\n"); 
		query.append("      ,A.GRS_WGT" ).append("\n"); 
		query.append("      ,A.NET_WGT" ).append("\n"); 
		query.append("      ,A.WGT_UT_CD" ).append("\n"); 
		query.append("      ,A.OVR_FWRD_LEN" ).append("\n"); 
		query.append("      ,A.OVR_BKWD_LEN" ).append("\n"); 
		query.append("      ,A.OVR_HGT" ).append("\n"); 
		query.append("      ,A.OVR_LF_LEN" ).append("\n"); 
		query.append("      ,A.OVR_RT_LEN" ).append("\n"); 
		query.append("      ,A.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("      ,A.TTL_DIM_LEN" ).append("\n"); 
		query.append("      ,A.TTL_DIM_WDT" ).append("\n"); 
		query.append("      ,A.TTL_DIM_HGT" ).append("\n"); 
		query.append("      ,A.AWK_DCGO_SEQ" ).append("\n"); 
		query.append("      ,A.CMDT_CD" ).append("\n"); 
		query.append("      ,B.CMDT_NM" ).append("\n"); 
		query.append("      ,A.IN_GA_FLG" ).append("\n"); 
		query.append("      ,A.CRN_PST_STS_CD" ).append("\n"); 
		query.append("      ,A.XTD_OVR_QTY" ).append("\n"); 
		query.append("      ,A.PST_LCK_PIN_FLG" ).append("\n"); 
		query.append("      ,A.GRAV_CTR_DESC" ).append("\n"); 
		query.append("      ,A.STWG_RQST_DESC" ).append("\n"); 
		query.append("      ,A.DIFF_RMK" ).append("\n"); 
		query.append("      ,A.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("      ,A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.RQST_DT" ).append("\n"); 
		query.append("      ,A.RQST_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,A.UND_DECK_TOP_FLG" ).append("\n"); 
		query.append("      ,C.POR_CD" ).append("\n"); 
		query.append("      ,C.DEL_CD" ).append("\n"); 
		query.append("      ,D.CNTR_TPSZ_DESC EQ_TPSZ" ).append("\n"); 
		query.append("      ,(SELECT CNTR_CGO_SEQ FROM BKG_DG_CGO_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND DCGO_SEQ = A.AWK_DCGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("          FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("              ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                     , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                     , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                     , AWK_CGO_SEQ" ).append("\n"); 
		query.append("                 FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND SPCL_CGO_CATE_CD = 'AK'" ).append("\n"); 
		query.append("                GROUP BY AWK_CGO_SEQ) N " ).append("\n"); 
		query.append("         WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("           AND M.VSL_PRE_PST_CD||M.VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("           AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("           AND M.AWK_CGO_SEQ = N.AWK_CGO_SEQ" ).append("\n"); 
		query.append("           AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND M.AWK_CGO_SEQ = A.AWK_CGO_SEQ) APLY_NO" ).append("\n"); 
		query.append("	,AWK_CGO_RQST_GRP_EML1" ).append("\n"); 
		query.append("	,AWK_CGO_RQST_GRP_EML2  " ).append("\n"); 
		query.append("	,E.CNTR_WGT BKG_CNTR_WGT" ).append("\n"); 
		query.append("  FROM BKG_AWK_CGO_HIS A" ).append("\n"); 
		query.append("      ,MDM_COMMODITY B" ).append("\n"); 
		query.append("      ,BKG_BKG_HIS C" ).append("\n"); 
		query.append("      ,MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("	  ,BKG_CNTR_HIS E" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND A.CORR_NO = C.CORR_NO" ).append("\n"); 
		query.append("   AND A.CORR_NO = E.CORR_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   and A.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.CNTR_NO = E.CNTR_NO(+)" ).append("\n"); 
		query.append(" ORDER BY A.AWK_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,A.AWK_CGO_SEQ" ).append("\n"); 
		query.append("      ,A.RCV_TERM_CD" ).append("\n"); 
		query.append("      ,A.DE_TERM_CD" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.PCK_TP_CD" ).append("\n"); 
		query.append("      ,A.PCK_QTY" ).append("\n"); 
		query.append("      ,A.GRS_WGT" ).append("\n"); 
		query.append("      ,A.NET_WGT" ).append("\n"); 
		query.append("      ,A.WGT_UT_CD" ).append("\n"); 
		query.append("      ,A.OVR_FWRD_LEN" ).append("\n"); 
		query.append("      ,A.OVR_BKWD_LEN" ).append("\n"); 
		query.append("      ,A.OVR_HGT" ).append("\n"); 
		query.append("      ,A.OVR_LF_LEN" ).append("\n"); 
		query.append("      ,A.OVR_RT_LEN" ).append("\n"); 
		query.append("      ,A.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("      ,A.TTL_DIM_LEN" ).append("\n"); 
		query.append("      ,A.TTL_DIM_WDT" ).append("\n"); 
		query.append("      ,A.TTL_DIM_HGT" ).append("\n"); 
		query.append("      ,A.AWK_DCGO_SEQ" ).append("\n"); 
		query.append("      ,A.CMDT_CD" ).append("\n"); 
		query.append("      ,B.CMDT_NM" ).append("\n"); 
		query.append("      ,A.IN_GA_FLG" ).append("\n"); 
		query.append("      ,A.CRN_PST_STS_CD" ).append("\n"); 
		query.append("      ,A.XTD_OVR_QTY" ).append("\n"); 
		query.append("      ,A.PST_LCK_PIN_FLG" ).append("\n"); 
		query.append("      ,A.GRAV_CTR_DESC" ).append("\n"); 
		query.append("      ,A.STWG_RQST_DESC" ).append("\n"); 
		query.append("      ,A.DIFF_RMK" ).append("\n"); 
		query.append("      ,A.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("      ,A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,A.RQST_DT" ).append("\n"); 
		query.append("      ,A.RQST_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,A.UND_DECK_TOP_FLG" ).append("\n"); 
		query.append("      ,C.POR_CD" ).append("\n"); 
		query.append("      ,C.DEL_CD" ).append("\n"); 
		query.append("      ,D.CNTR_TPSZ_DESC EQ_TPSZ" ).append("\n"); 
		query.append("      ,(SELECT CNTR_CGO_SEQ FROM BKG_DG_CGO WHERE BKG_NO = @[bkg_no] AND DCGO_SEQ = A.AWK_DCGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("          FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("              ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                     , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                     , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                     , AWK_CGO_SEQ" ).append("\n"); 
		query.append("                 FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND SPCL_CGO_CATE_CD = 'AK'" ).append("\n"); 
		query.append("                GROUP BY AWK_CGO_SEQ) N " ).append("\n"); 
		query.append("         WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("           AND M.VSL_PRE_PST_CD||M.VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("           AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("           AND M.AWK_CGO_SEQ = N.AWK_CGO_SEQ" ).append("\n"); 
		query.append("           AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND M.AWK_CGO_SEQ = A.AWK_CGO_SEQ) APLY_NO  " ).append("\n"); 
		query.append("	,AWK_CGO_RQST_GRP_EML1" ).append("\n"); 
		query.append("	,AWK_CGO_RQST_GRP_EML2  " ).append("\n"); 
		query.append("    ,E.CNTR_WGT BKG_CNTR_WGT        " ).append("\n"); 
		query.append("  FROM BKG_AWK_CGO A" ).append("\n"); 
		query.append("      ,MDM_COMMODITY B" ).append("\n"); 
		query.append("      ,BKG_BOOKING C" ).append("\n"); 
		query.append("      ,MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("      ,BKG_CONTAINER E" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND A.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.CNTR_NO = E.CNTR_NO(+)" ).append("\n"); 
		query.append(" ORDER BY A.AWK_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}