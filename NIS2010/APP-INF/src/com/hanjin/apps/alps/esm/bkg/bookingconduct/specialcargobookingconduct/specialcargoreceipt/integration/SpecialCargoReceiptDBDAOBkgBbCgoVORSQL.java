/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgBbCgoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.22 
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

public class SpecialCargoReceiptDBDAOBkgBbCgoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgBbCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgBbCgoVORSQL(){
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
		query.append("FileName : SpecialCargoReceiptDBDAOBkgBbCgoVORSQL").append("\n"); 
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
		query.append("	a.BKG_NO" ).append("\n"); 
		query.append(",	a.BB_CGO_SEQ" ).append("\n"); 
		query.append(",	a.RCV_TERM_CD" ).append("\n"); 
		query.append(",	a.DE_TERM_CD" ).append("\n"); 
		query.append(",	a.PCK_QTY" ).append("\n"); 
		query.append(",	a.PCK_TP_CD" ).append("\n"); 
		query.append(",	a.GRS_WGT" ).append("\n"); 
		query.append(",	a.NET_WGT" ).append("\n"); 
		query.append(",	a.WGT_UT_CD" ).append("\n"); 
		query.append(",	a.DIM_LEN" ).append("\n"); 
		query.append(",	a.DIM_WDT" ).append("\n"); 
		query.append(",	a.DIM_HGT" ).append("\n"); 
		query.append(",	a.CGO_WGT" ).append("\n"); 
		query.append(",	a.STWG_INSTR_DESC" ).append("\n"); 
		query.append(",	a.BB_DCGO_SEQ" ).append("\n"); 
		query.append(",	a.CMDT_CD" ).append("\n"); 
		query.append(",	b.CMDT_NM" ).append("\n"); 
		query.append(",	a.SLNG_PNT_FLG" ).append("\n"); 
		query.append(",	a.GRAV_CTR_DESC" ).append("\n"); 
		query.append(",	a.PCK_DTL_DESC" ).append("\n"); 
		query.append(",	a.CGO_LODG_MZD_CD" ).append("\n"); 
		query.append(",	a.SCR_DNG_CTNT" ).append("\n"); 
		query.append(",	a.SPCL_RQST_DESC" ).append("\n"); 
		query.append(",	a.DIFF_RMK" ).append("\n"); 
		query.append(",	a.RQST_DT" ).append("\n"); 
		query.append(",	a.RQST_USR_ID" ).append("\n"); 
		query.append(",	a.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	a.CRE_USR_ID" ).append("\n"); 
		query.append(",	a.CRE_DT" ).append("\n"); 
		query.append(",	a.UPD_USR_ID" ).append("\n"); 
		query.append(",	a.UPD_DT" ).append("\n"); 
		query.append(",   a.CGO_DCHG_MZD_CD" ).append("\n"); 
		query.append(",	a.CGO_DCHG_SD_CD" ).append("\n"); 
		query.append(",	a.CGO_LODG_SD_CD" ).append("\n"); 
		query.append(",   c.POR_CD" ).append("\n"); 
		query.append(",   c.DEL_CD" ).append("\n"); 
		query.append(",	(SELECT CNTR_CGO_SEQ FROM BKG_DG_CGO_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND DCGO_SEQ = BB_DCGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("          FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("              ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                     , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                     , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                     , BB_CGO_SEQ" ).append("\n"); 
		query.append("                 FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND SPCL_CGO_CATE_CD = 'BB'" ).append("\n"); 
		query.append("                GROUP BY BB_CGO_SEQ) N " ).append("\n"); 
		query.append("         WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("           AND M.VSL_PRE_PST_CD||M.VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("           AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("           AND M.BB_CGO_SEQ = N.BB_CGO_SEQ" ).append("\n"); 
		query.append("           AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND M.BB_CGO_SEQ = A.BB_CGO_SEQ) APLY_NO " ).append("\n"); 
		query.append("FROM BKG_BB_CGO_HIS a,  MDM_COMMODITY b, BKG_BKG_HIS c" ).append("\n"); 
		query.append("WHERE	a.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND 	a.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND		a.CORR_NO = c.CORR_NO" ).append("\n"); 
		query.append("AND		a.BKG_NO = c.BKG_NO" ).append("\n"); 
		query.append("AND		a.CMDT_CD = b.CMDT_CD" ).append("\n"); 
		query.append("ORDER BY A.BB_CGO_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	a.BKG_NO" ).append("\n"); 
		query.append(",	a.BB_CGO_SEQ" ).append("\n"); 
		query.append(",	a.RCV_TERM_CD" ).append("\n"); 
		query.append(",	a.DE_TERM_CD" ).append("\n"); 
		query.append(",	a.PCK_QTY" ).append("\n"); 
		query.append(",	a.PCK_TP_CD" ).append("\n"); 
		query.append(",	a.GRS_WGT" ).append("\n"); 
		query.append(",	a.NET_WGT" ).append("\n"); 
		query.append(",	a.WGT_UT_CD" ).append("\n"); 
		query.append(",	a.DIM_LEN" ).append("\n"); 
		query.append(",	a.DIM_WDT" ).append("\n"); 
		query.append(",	a.DIM_HGT" ).append("\n"); 
		query.append(",	a.CGO_WGT" ).append("\n"); 
		query.append(",	a.STWG_INSTR_DESC" ).append("\n"); 
		query.append(",	a.BB_DCGO_SEQ" ).append("\n"); 
		query.append(",	a.CMDT_CD" ).append("\n"); 
		query.append(",	b.CMDT_NM" ).append("\n"); 
		query.append(",	a.SLNG_PNT_FLG" ).append("\n"); 
		query.append(",	a.GRAV_CTR_DESC" ).append("\n"); 
		query.append(",	a.PCK_DTL_DESC" ).append("\n"); 
		query.append(",	a.CGO_LODG_MZD_CD" ).append("\n"); 
		query.append(",	a.SCR_DNG_CTNT" ).append("\n"); 
		query.append(",	a.SPCL_RQST_DESC" ).append("\n"); 
		query.append(",	a.DIFF_RMK" ).append("\n"); 
		query.append(",	a.RQST_DT" ).append("\n"); 
		query.append(",	a.RQST_USR_ID" ).append("\n"); 
		query.append(",	a.SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append(",	a.CRE_USR_ID" ).append("\n"); 
		query.append(",	a.CRE_DT" ).append("\n"); 
		query.append(",	a.UPD_USR_ID" ).append("\n"); 
		query.append(",   a.CGO_DCHG_MZD_CD" ).append("\n"); 
		query.append(",	a.CGO_DCHG_SD_CD" ).append("\n"); 
		query.append(",	a.CGO_LODG_SD_CD" ).append("\n"); 
		query.append(",	a.UPD_DT" ).append("\n"); 
		query.append(",   c.POR_CD" ).append("\n"); 
		query.append(",   c.DEL_CD" ).append("\n"); 
		query.append(",	(SELECT CNTR_CGO_SEQ FROM BKG_DG_CGO WHERE BKG_NO = @[bkg_no] AND DCGO_SEQ = BB_DCGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("          FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("              ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                     , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                     , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                     , BB_CGO_SEQ" ).append("\n"); 
		query.append("                 FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND SPCL_CGO_CATE_CD = 'BB'" ).append("\n"); 
		query.append("                GROUP BY BB_CGO_SEQ) N " ).append("\n"); 
		query.append("         WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("           AND M.VSL_PRE_PST_CD||M.VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("           AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("           AND M.BB_CGO_SEQ = N.BB_CGO_SEQ" ).append("\n"); 
		query.append("           AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND M.BB_CGO_SEQ = A.BB_CGO_SEQ) APLY_NO " ).append("\n"); 
		query.append("FROM BKG_BB_CGO a,  MDM_COMMODITY b, BKG_BOOKING c" ).append("\n"); 
		query.append("WHERE	a.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND		a.BKG_NO = c.BKG_NO" ).append("\n"); 
		query.append("AND		a.CMDT_CD = b.CMDT_CD" ).append("\n"); 
		query.append("ORDER BY A.BB_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}