/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOXptImpLicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOXptImpLicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOXptImpLicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOXptImpLicRSQL").append("\n"); 
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
		query.append("#if (${cnt_cd} == 'CA')" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       CNT_CD," ).append("\n"); 
		query.append("       CAED_TP_CD," ).append("\n"); 
		query.append("       CAED_PFX_CTNT," ).append("\n"); 
		query.append("       CAED_NO1," ).append("\n"); 
		query.append("       CAED_NO2," ).append("\n"); 
		query.append("       CAED_NO3," ).append("\n"); 
		query.append("       G7_EDI_PFX_CTNT," ).append("\n"); 
		query.append("       G7_EDI_NO1," ).append("\n"); 
		query.append("       G7_EDI_NO2," ).append("\n"); 
		query.append("       MF_SMRY_RPT_PFX_CTNT," ).append("\n"); 
		query.append("       MF_SMRY_RPT_NO," ).append("\n"); 
		query.append("       B13A_XPT_PFX_CTNT," ).append("\n"); 
		query.append("       TO_CHAR(B13A_XPT_DT,'yyyy/mm/dd hh24:mi') B13A_XPT_DT," ).append("\n"); 
		query.append("       B13A_XPT_NO1," ).append("\n"); 
		query.append("       B13A_XPT_NO2," ).append("\n"); 
		query.append("       CGO_CTRL_PFX_CTNT," ).append("\n"); 
		query.append("       CGO_CTRL_NO," ).append("\n"); 
		query.append("       NDR_REF_PFX_CTNT," ).append("\n"); 
		query.append("       NDR_REF_ID," ).append("\n"); 
		query.append("       NDR_REF_CTNT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'CA'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'TG')   " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       CNT_CD," ).append("\n"); 
		query.append("       TG_ECTN_NO," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'TG'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'NG')   " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       CNT_CD," ).append("\n"); 
		query.append("       NG_EXS_ENS_NO," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'NG'   " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'BR')   " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("	   SHPR_TAX_NO," ).append("\n"); 
		query.append("	   CNEE_TAX_NO," ).append("\n"); 
		query.append("       NTFY_TAX_NO," ).append("\n"); 
		query.append("       BRZ_DECL_NO," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'BR'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'ID')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("	   ID_XPT_NO," ).append("\n"); 
		query.append("	   to_char(ID_XPT_NO_ISS_DT,'yyyyMMdd') ID_XPT_NO_ISS_DT," ).append("\n"); 
		query.append("       ID_OFC_ID AS ID_OFC_CD," ).append("\n"); 
		query.append("       ID_DECL_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'ID'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'IN')" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("	   CNTR_NO," ).append("\n"); 
		query.append("	   IDA_IEC_NO," ).append("\n"); 
		query.append("       IDA_SHP_BIL_NO," ).append("\n"); 
		query.append("       TO_CHAR(IDA_SHP_BIL_ISS_DT,'YYYY-MM-DD') IDA_SHP_BIL_ISS_DT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'IN' " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'MX')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   --CNT_CD," ).append("\n"); 
		query.append("	   'MX' CNT_CD," ).append("\n"); 
		query.append("       MX_SHPR_TAX_ID," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'MX'     " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'CO')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   'CO' CNT_CD," ).append("\n"); 
		query.append("       MX_SHPR_TAX_ID," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'CO'  " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'EC')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   'EC' CNT_CD," ).append("\n"); 
		query.append("       MX_SHPR_TAX_ID," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'EC'  " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'PE')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   'PE' CNT_CD," ).append("\n"); 
		query.append("       MX_SHPR_TAX_ID," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'PE'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'TR')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       'TR' CNT_CD," ).append("\n"); 
		query.append("       TR_SHPR_TAX_ID," ).append("\n"); 
		query.append("       TR_CNEE_TAX_ID," ).append("\n"); 
		query.append("       TR_NTFY_TAX_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'TR'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'IL')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       'IL' CNT_CD," ).append("\n"); 
		query.append("       IL_SHPR_TAX_ID," ).append("\n"); 
		query.append("       IL_CNEE_TAX_ID," ).append("\n"); 
		query.append("       IL_NTFY_TAX_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'IL'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'LB')     " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       'LB' CNT_CD," ).append("\n"); 
		query.append("       LB_SHPR_TAX_ID," ).append("\n"); 
		query.append("       LB_CNEE_TAX_ID," ).append("\n"); 
		query.append("       LB_NTFY_TAX_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'LB'" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'KR')" ).append("\n"); 
		query.append("#if (${popuptpcd} == 'S')" ).append("\n"); 
		query.append("SELECT XPT_LIC_NO " ).append("\n"); 
		query.append("      ,PCK_QTY     " ).append("\n"); 
		query.append("      ,PCK_TP_CD   " ).append("\n"); 
		query.append("      ,CNTR_WGT AS MF_WGT    " ).append("\n"); 
		query.append("      ,WGT_UT_CD    " ).append("\n"); 
		query.append("      ,CGO_DIVD_FLG AS DIVD_FLG    " ).append("\n"); 
		query.append("	  ,DIVD_SEQ" ).append("\n"); 
		query.append("      ,STY_ID AS SAM_PCK_ID" ).append("\n"); 
		query.append("      ,DIVD_PCK_QTY AS SAM_PCK_QTY" ).append("\n"); 
		query.append("      ,DIVD_PCK_TP_CD AS SAM_PCK_TP_CD" ).append("\n"); 
		query.append("	  ,'' AS UCR_NO" ).append("\n"); 
		query.append("  FROM BKG_XTER_XPT_LIC_NO" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       XPT_LIC_NO," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       MF_WGT AS," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_SEQ," ).append("\n"); 
		query.append("       SAM_PCK_ID," ).append("\n"); 
		query.append("       SAM_PCK_QTY," ).append("\n"); 
		query.append("       SAM_PCK_TP_CD," ).append("\n"); 
		query.append("       UCR_NO," ).append("\n"); 
		query.append("       TS_REF_NO," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC    " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CNT_CD = 'KR'" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'US')" ).append("\n"); 
		query.append("#if (${popuptpcd} == 'S')" ).append("\n"); 
		query.append("select aes_inlnd_trns_no    AES_INLND_TRNS_NO" ).append("\n"); 
		query.append("        , aes_pta_no1       AES_PTA_NO1" ).append("\n"); 
		query.append("        , aes_pta_no2       AES_PTA_NO2" ).append("\n"); 
		query.append("        , aes_pta_dt        AES_PTA_DT" ).append("\n"); 
		query.append("        , aes_ptu_no        AES_PTU_NO" ).append("\n"); 
		query.append("        , aes_ptu_dt        AES_PTU_DT" ).append("\n"); 
		query.append("        , aes_dwn_no       AES_DWN_NO" ).append("\n"); 
		query.append("        , aes_dwn_dt       AES_DWN_DT" ).append("\n"); 
		query.append("        , aes_expt_ctnt     AES_EXPT_CTNT" ).append("\n"); 
		query.append("  from bkg_xter_aes" ).append("\n"); 
		query.append(" where xter_sndr_id = @[xter_sndr_id]" ).append("\n"); 
		query.append("   and xter_rqst_no = @[xter_rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq= @[xter_rqst_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT LIC.BKG_NO," ).append("\n"); 
		query.append("       LIC.IO_BND_CD," ).append("\n"); 
		query.append("       LIC.XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   LIC.CNT_CD," ).append("\n"); 
		query.append("       LIC.AES_TP_CD," ).append("\n"); 
		query.append("       LIC.AES_INLND_TRNS_PFX_CTNT," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_INLND_TRNS_NO) AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("       LIC.AES_PTA_PFX_CTNT," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_PTA_NO1) AES_PTA_NO1," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_PTA_NO2) AES_PTA_NO2," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_PTA_DT,'MM-DD-YYYY') AES_PTA_DT," ).append("\n"); 
		query.append("       LIC.AES_PTU_PFX_CTNT," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_PTU_NO) AES_PTU_NO," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_PTU_DT,'MM-DD-YYYY') AES_PTU_DT," ).append("\n"); 
		query.append("       LIC.AES_DWN_PFX_CTNT," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_DWN_NO) AES_DWN_NO," ).append("\n"); 
		query.append("       TO_CHAR(LIC.AES_DWN_DT,'MM-DD-YYYY') AES_DWN_DT," ).append("\n"); 
		query.append("       LIC.AES_EXPT_ID," ).append("\n"); 
		query.append("       LIC.AES_EXPT_CTNT," ).append("\n"); 
		query.append("       LIC.ENTR_CLSS_TP_CD," ).append("\n"); 
		query.append("       LIC.ENTR_CLSS_RMK," ).append("\n"); 
		query.append("	   LIC.CRE_USR_ID," ).append("\n"); 
		query.append("	   LIC.UPD_USR_ID," ).append("\n"); 
		query.append("       LIC.AES_TP_PRN_FLG," ).append("\n"); 
		query.append("       LIC.VIN_CTNT," ).append("\n"); 
		query.append("       NVL(BKG.VEH_CMDT_FLG,'N') AS VEH_CMDT_FLG" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC_HIS LIC" ).append("\n"); 
		query.append("      ,BKG_BKG_HIS BKG" ).append("\n"); 
		query.append(" WHERE LIC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND LIC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND LIC.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND LIC.CORR_NO = BKG.CORR_NO" ).append("\n"); 
		query.append("#else    " ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC LIC " ).append("\n"); 
		query.append("      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE LIC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND LIC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND LIC.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND LIC.CNT_CD = 'US'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}