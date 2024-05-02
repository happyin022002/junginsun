/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOCreateLicCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.20 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOCreateLicCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOCreateLicCACSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOCreateLicCACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOCreateLicCACSQL").append("\n"); 
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
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append(", AES_PTA_DT" ).append("\n"); 
		query.append(", AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append(", AES_PTU_NO" ).append("\n"); 
		query.append(", AES_PTU_DT" ).append("\n"); 
		query.append(", AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append(", AES_DWN_NO" ).append("\n"); 
		query.append(", AES_DWN_DT" ).append("\n"); 
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
		query.append(", ID_XPT_NO_ISS_DT" ).append("\n"); 
		query.append(", ID_OFC_ID" ).append("\n"); 
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
		query.append(", B13A_XPT_DT" ).append("\n"); 
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
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", MX_SHPR_PFX_CTNT" ).append("\n"); 
		query.append(", MX_SHPR_TAX_ID" ).append("\n"); 
		query.append(", MX_CNEE_PFX_CTNT" ).append("\n"); 
		query.append(", MX_CNEE_TAX_ID" ).append("\n"); 
		query.append(", MX_NTFY_PFX_CTNT" ).append("\n"); 
		query.append(", MX_NTFY_TAX_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("#elseif (${copy_type_cd} == 'TEMP')" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", 'TMP0000001' CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", @[ca_no] CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append(", AES_PTA_DT" ).append("\n"); 
		query.append(", AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append(", AES_PTU_NO" ).append("\n"); 
		query.append(", AES_PTU_DT" ).append("\n"); 
		query.append(", AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append(", AES_DWN_NO" ).append("\n"); 
		query.append(", AES_DWN_DT" ).append("\n"); 
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
		query.append(", ID_XPT_NO_ISS_DT" ).append("\n"); 
		query.append(", ID_OFC_ID" ).append("\n"); 
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
		query.append(", B13A_XPT_DT" ).append("\n"); 
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
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", MX_SHPR_PFX_CTNT" ).append("\n"); 
		query.append(", MX_SHPR_TAX_ID" ).append("\n"); 
		query.append(", MX_CNEE_PFX_CTNT" ).append("\n"); 
		query.append(", MX_CNEE_TAX_ID" ).append("\n"); 
		query.append(", MX_NTFY_PFX_CTNT" ).append("\n"); 
		query.append(", MX_NTFY_TAX_ID" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}