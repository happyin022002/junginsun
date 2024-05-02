/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOcopyExportImportNumberByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.10 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOcopyExportImportNumberByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationBLDBDAOcopyExportImportNumberByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOcopyExportImportNumberByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_xpt_imp_lic(BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",XPT_IMP_SEQ" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",XPT_LIC_NO" ).append("\n"); 
		query.append(",TS_REF_NO" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",PCK_TP_CD" ).append("\n"); 
		query.append(",MF_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",DIVD_FLG" ).append("\n"); 
		query.append(",DIVD_SEQ" ).append("\n"); 
		query.append(",DIVD_PCK_QTY" ).append("\n"); 
		query.append(",DIVD_PCK_TP_CD" ).append("\n"); 
		query.append(",DIVD_WGT" ).append("\n"); 
		query.append(",DIVD_WGT_UT_CD" ).append("\n"); 
		query.append(",SAM_PCK_ID" ).append("\n"); 
		query.append(",SAM_PCK_QTY" ).append("\n"); 
		query.append(",SAM_PCK_TP_CD" ).append("\n"); 
		query.append(",UCR_NO" ).append("\n"); 
		query.append(",AUS_MF_REF_NO" ).append("\n"); 
		query.append(",AES_TP_CD" ).append("\n"); 
		query.append(",AES_INLND_TRNS_PFX_CTNT" ).append("\n"); 
		query.append(",AES_INLND_TRNS_NO" ).append("\n"); 
		query.append(",AES_PTA_PFX_CTNT" ).append("\n"); 
		query.append(",AES_PTA_NO1" ).append("\n"); 
		query.append(",AES_PTA_NO2" ).append("\n"); 
		query.append(",AES_PTA_DT" ).append("\n"); 
		query.append(",AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append(",AES_PTU_NO" ).append("\n"); 
		query.append(",AES_PTU_DT" ).append("\n"); 
		query.append(",AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append(",AES_DWN_NO" ).append("\n"); 
		query.append(",AES_DWN_DT" ).append("\n"); 
		query.append(",AES_EXPT_ID" ).append("\n"); 
		query.append(",AES_EXPT_CTNT" ).append("\n"); 
		query.append(",SHPR_TAX_NO" ).append("\n"); 
		query.append(",SHPR_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(",CNEE_TAX_NO" ).append("\n"); 
		query.append(",CNEE_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(",NTFY_TAX_NO" ).append("\n"); 
		query.append(",NTFY_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(",BRZ_DECL_NO" ).append("\n"); 
		query.append(",BRZ_DECL_CPY_DESC_FLG" ).append("\n"); 
		query.append(",BRZ_CMDT_CD" ).append("\n"); 
		query.append(",ID_DECL_CD" ).append("\n"); 
		query.append(",ID_XPT_NO" ).append("\n"); 
		query.append(",ID_XPT_NO_ISS_DT" ).append("\n"); 
		query.append(",ID_OFC_ID" ).append("\n"); 
		query.append(",IDA_IEC_NO" ).append("\n"); 
		query.append(",IDA_IEC_CPY_DESC_FLG" ).append("\n"); 
		query.append(",CAED_TP_CD" ).append("\n"); 
		query.append(",CAED_PFX_CTNT" ).append("\n"); 
		query.append(",CAED_NO1" ).append("\n"); 
		query.append(",CAED_NO2" ).append("\n"); 
		query.append(",CAED_NO3" ).append("\n"); 
		query.append(",G7_EDI_PFX_CTNT" ).append("\n"); 
		query.append(",G7_EDI_NO1" ).append("\n"); 
		query.append(",G7_EDI_NO2" ).append("\n"); 
		query.append(",B13A_XPT_PFX_CTNT" ).append("\n"); 
		query.append(",B13A_XPT_DT" ).append("\n"); 
		query.append(",B13A_XPT_NO1" ).append("\n"); 
		query.append(",B13A_XPT_NO2" ).append("\n"); 
		query.append(",MF_SMRY_RPT_PFX_CTNT" ).append("\n"); 
		query.append(",MF_SMRY_RPT_NO" ).append("\n"); 
		query.append(",CGO_CTRL_PFX_CTNT" ).append("\n"); 
		query.append(",CGO_CTRL_NO" ).append("\n"); 
		query.append(",NDR_REF_PFX_CTNT" ).append("\n"); 
		query.append(",NDR_REF_ID" ).append("\n"); 
		query.append(",NDR_REF_CTNT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",(select /*+index_desc ( bkg_xpt_imp_lic XPKBKG_XPT_IMP_LIC)*/" ).append("\n"); 
		query.append("nvl(sum(XPT_IMP_SEQ),0)+ xpt.XPT_IMP_SEQ" ).append("\n"); 
		query.append("from bkg_xpt_imp_lic" ).append("\n"); 
		query.append("where XPT_IMP_SEQ >= 0" ).append("\n"); 
		query.append("and rownum <= 1" ).append("\n"); 
		query.append("and bkg_no = @[targetBkg] ) XPT_IMP_SEQ" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",XPT_LIC_NO" ).append("\n"); 
		query.append(",TS_REF_NO" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",PCK_TP_CD" ).append("\n"); 
		query.append(",MF_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",DIVD_FLG" ).append("\n"); 
		query.append(",DIVD_SEQ" ).append("\n"); 
		query.append(",DIVD_PCK_QTY" ).append("\n"); 
		query.append(",DIVD_PCK_TP_CD" ).append("\n"); 
		query.append(",DIVD_WGT" ).append("\n"); 
		query.append(",DIVD_WGT_UT_CD" ).append("\n"); 
		query.append(",SAM_PCK_ID" ).append("\n"); 
		query.append(",SAM_PCK_QTY" ).append("\n"); 
		query.append(",SAM_PCK_TP_CD" ).append("\n"); 
		query.append(",UCR_NO" ).append("\n"); 
		query.append(",AUS_MF_REF_NO" ).append("\n"); 
		query.append(",AES_TP_CD" ).append("\n"); 
		query.append(",AES_INLND_TRNS_PFX_CTNT" ).append("\n"); 
		query.append(",AES_INLND_TRNS_NO" ).append("\n"); 
		query.append(",AES_PTA_PFX_CTNT" ).append("\n"); 
		query.append(",AES_PTA_NO1" ).append("\n"); 
		query.append(",AES_PTA_NO2" ).append("\n"); 
		query.append(",AES_PTA_DT" ).append("\n"); 
		query.append(",AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append(",AES_PTU_NO" ).append("\n"); 
		query.append(",AES_PTU_DT" ).append("\n"); 
		query.append(",AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append(",AES_DWN_NO" ).append("\n"); 
		query.append(",AES_DWN_DT" ).append("\n"); 
		query.append(",AES_EXPT_ID" ).append("\n"); 
		query.append(",AES_EXPT_CTNT" ).append("\n"); 
		query.append(",SHPR_TAX_NO" ).append("\n"); 
		query.append(",SHPR_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(",CNEE_TAX_NO" ).append("\n"); 
		query.append(",CNEE_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(",NTFY_TAX_NO" ).append("\n"); 
		query.append(",NTFY_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(",BRZ_DECL_NO" ).append("\n"); 
		query.append(",BRZ_DECL_CPY_DESC_FLG" ).append("\n"); 
		query.append(",BRZ_CMDT_CD" ).append("\n"); 
		query.append(",ID_DECL_CD" ).append("\n"); 
		query.append(",ID_XPT_NO" ).append("\n"); 
		query.append(",ID_XPT_NO_ISS_DT" ).append("\n"); 
		query.append(",ID_OFC_ID" ).append("\n"); 
		query.append(",IDA_IEC_NO" ).append("\n"); 
		query.append(",IDA_IEC_CPY_DESC_FLG" ).append("\n"); 
		query.append(",CAED_TP_CD" ).append("\n"); 
		query.append(",CAED_PFX_CTNT" ).append("\n"); 
		query.append(",CAED_NO1" ).append("\n"); 
		query.append(",CAED_NO2" ).append("\n"); 
		query.append(",CAED_NO3" ).append("\n"); 
		query.append(",G7_EDI_PFX_CTNT" ).append("\n"); 
		query.append(",G7_EDI_NO1" ).append("\n"); 
		query.append(",G7_EDI_NO2" ).append("\n"); 
		query.append(",B13A_XPT_PFX_CTNT" ).append("\n"); 
		query.append(",B13A_XPT_DT" ).append("\n"); 
		query.append(",B13A_XPT_NO1" ).append("\n"); 
		query.append(",B13A_XPT_NO2" ).append("\n"); 
		query.append(",MF_SMRY_RPT_PFX_CTNT" ).append("\n"); 
		query.append(",MF_SMRY_RPT_NO" ).append("\n"); 
		query.append(",CGO_CTRL_PFX_CTNT" ).append("\n"); 
		query.append(",CGO_CTRL_NO" ).append("\n"); 
		query.append(",NDR_REF_PFX_CTNT" ).append("\n"); 
		query.append(",NDR_REF_ID" ).append("\n"); 
		query.append(",NDR_REF_CTNT" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_xpt_imp_lic xpt" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}