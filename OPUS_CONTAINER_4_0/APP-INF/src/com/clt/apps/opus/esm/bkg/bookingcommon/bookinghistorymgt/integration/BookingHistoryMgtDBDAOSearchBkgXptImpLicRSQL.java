/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgXptImpLicRSQL.java
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

public class BookingHistoryMgtDBDAOSearchBkgXptImpLicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgXptImpLicRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgXptImpLicRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgXptImpLicRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", XPT_IMP_SEQ" ).append("\n"); 
		query.append(", CNT_CD" ).append("\n"); 
		query.append(", XPT_LIC_NO" ).append("\n"); 
		query.append(", TS_REF_NO" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", MF_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", DIVD_FLG" ).append("\n"); 
		query.append(", DIVD_SEQ" ).append("\n"); 
		query.append(", DIVD_PCK_QTY" ).append("\n"); 
		query.append(", DIVD_PCK_TP_CD" ).append("\n"); 
		query.append(", DIVD_WGT" ).append("\n"); 
		query.append(", DIVD_WGT_UT_CD" ).append("\n"); 
		query.append(", SAM_PCK_ID" ).append("\n"); 
		query.append(", SAM_PCK_QTY" ).append("\n"); 
		query.append(", SAM_PCK_TP_CD" ).append("\n"); 
		query.append(", UCR_NO" ).append("\n"); 
		query.append(", AUS_MF_REF_NO" ).append("\n"); 
		query.append(", AES_TP_CD" ).append("\n"); 
		query.append(", AES_INLND_TRNS_PFX_CTNT" ).append("\n"); 
		query.append(", AES_INLND_TRNS_NO" ).append("\n"); 
		query.append(", AES_PTA_PFX_CTNT" ).append("\n"); 
		query.append(", AES_PTA_NO1" ).append("\n"); 
		query.append(", AES_PTA_NO2" ).append("\n"); 
		query.append(", TO_CHAR(AES_PTA_DT, 'YYYY-MM-DD HH24:MI:SS') AES_PTA_DT" ).append("\n"); 
		query.append(", AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append(", AES_PTU_NO" ).append("\n"); 
		query.append(", TO_CHAR(AES_PTU_DT, 'YYYY-MM-DD HH24:MI:SS') AES_PTU_DT" ).append("\n"); 
		query.append(", AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append(", AES_DWN_NO" ).append("\n"); 
		query.append(", TO_CHAR(AES_DWN_DT, 'YYYY-MM-DD HH24:MI:SS') AES_DWN_DT" ).append("\n"); 
		query.append(", AES_EXPT_ID" ).append("\n"); 
		query.append(", AES_EXPT_CTNT" ).append("\n"); 
		query.append(", SHPR_TAX_NO" ).append("\n"); 
		query.append(", SHPR_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(", CNEE_TAX_NO" ).append("\n"); 
		query.append(", CNEE_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(", NTFY_TAX_NO" ).append("\n"); 
		query.append(", NTFY_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(", BRZ_DECL_NO" ).append("\n"); 
		query.append(", BRZ_DECL_CPY_DESC_FLG" ).append("\n"); 
		query.append(", BRZ_CMDT_CD" ).append("\n"); 
		query.append(", ID_DECL_CD" ).append("\n"); 
		query.append(", ID_XPT_NO" ).append("\n"); 
		query.append(", TO_CHAR(ID_XPT_NO_ISS_DT, 'YYYY-MM-DD HH24:MI:SS') ID_XPT_NO_ISS_DT" ).append("\n"); 
		query.append(", ID_OFC_ID AS ID_OFC_CD -- eBKG upload 테스트 중 발견, VO까지 수정해야 하는지 확인 필요, 민동진" ).append("\n"); 
		query.append(", IDA_IEC_NO" ).append("\n"); 
		query.append(", IDA_IEC_CPY_DESC_FLG" ).append("\n"); 
		query.append(", CAED_TP_CD" ).append("\n"); 
		query.append(", CAED_PFX_CTNT" ).append("\n"); 
		query.append(", CAED_NO1" ).append("\n"); 
		query.append(", CAED_NO2" ).append("\n"); 
		query.append(", CAED_NO3" ).append("\n"); 
		query.append(", G7_EDI_PFX_CTNT" ).append("\n"); 
		query.append(", G7_EDI_NO1" ).append("\n"); 
		query.append(", G7_EDI_NO2" ).append("\n"); 
		query.append(", B13A_XPT_PFX_CTNT" ).append("\n"); 
		query.append(", TO_CHAR(B13A_XPT_DT, 'YYYYMMDDHH24MI') B13A_XPT_DT" ).append("\n"); 
		query.append(", B13A_XPT_NO1" ).append("\n"); 
		query.append(", B13A_XPT_NO2" ).append("\n"); 
		query.append(", MF_SMRY_RPT_PFX_CTNT" ).append("\n"); 
		query.append(", MF_SMRY_RPT_NO" ).append("\n"); 
		query.append(", CGO_CTRL_PFX_CTNT" ).append("\n"); 
		query.append(", CGO_CTRL_NO" ).append("\n"); 
		query.append(", NDR_REF_PFX_CTNT" ).append("\n"); 
		query.append(", NDR_REF_ID" ).append("\n"); 
		query.append(", NDR_REF_CTNT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}