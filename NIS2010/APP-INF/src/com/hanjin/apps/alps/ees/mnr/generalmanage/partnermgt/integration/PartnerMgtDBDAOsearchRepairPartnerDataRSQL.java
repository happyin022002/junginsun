/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PartnerMgtDBDAOsearchRepairPartnerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.01.08 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerMgtDBDAOsearchRepairPartnerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRepairPartnerData
	  * </pre>
	  */
	public PartnerMgtDBDAOsearchRepairPartnerDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.integration").append("\n"); 
		query.append("FileName : PartnerMgtDBDAOsearchRepairPartnerDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.VNDR_SEQ" ).append("\n"); 
		query.append(",C.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append(",C.CTRL_OFC_CD" ).append("\n"); 
		query.append(",C.MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",C.MNR_PRNR_TP_CD" ).append("\n"); 
		query.append(",C.MNR_PRNR_KND_CD" ).append("\n"); 
		query.append(",C.MNR_PRNR_KND_DTL_CD" ).append("\n"); 
		query.append(",C.MNR_PRNR_STS_CD" ).append("\n"); 
		query.append(",C.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",C.MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",C.EDI_ID" ).append("\n"); 
		query.append(",C.SP_PTAL_ID" ).append("\n"); 
		query.append(",C.SP_PTAL_PWD" ).append("\n"); 
		query.append(",C.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append(",C.MNR_PRNR_LOCL_LANG_NM" ).append("\n"); 
		query.append(",C.MNR_PRNR_ADDR" ).append("\n"); 
		query.append(",C.MNR_BIL_TO_NM" ).append("\n"); 
		query.append(",TO_CHAR(C.EFF_DT, 'yyyy-mm-dd') EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.EXP_DT, 'yyyy-mm-dd') EXP_DT" ).append("\n"); 
		query.append(",C.BANK_NM" ).append("\n"); 
		query.append(",C.BANK_ACCT_NO" ).append("\n"); 
		query.append(",C.PAY_MZD_CD" ).append("\n"); 
		query.append(",C.PAY_TERM_DYS" ).append("\n"); 
		query.append(",C.ZIP_CD" ).append("\n"); 
		query.append(",C.OWNR_NM" ).append("\n"); 
		query.append(",C.BZCT_NM" ).append("\n"); 
		query.append(",C.BZTP_NM" ).append("\n"); 
		query.append(",C.BIZ_RGST_NO" ).append("\n"); 
		query.append(",C.MNR_SHOP_FLG" ).append("\n"); 
		query.append(",C.MNR_PAYR_CNT_CD" ).append("\n"); 
		query.append(",C.MNR_PAYR_SEQ" ).append("\n"); 
		query.append(",C.MNR_PRNR_CAPI_AMT" ).append("\n"); 
		query.append(",C.EMPE_KNT" ).append("\n"); 
		query.append(",C.DPT_DESC" ).append("\n"); 
		query.append(",C.MNR_PRNR_ABBR_NM" ).append("\n"); 
		query.append(",C.INTL_PHN_NO" ).append("\n"); 
		query.append(",C.PHN_NO" ).append("\n"); 
		query.append(",C.INTL_FAX_NO" ).append("\n"); 
		query.append(",C.FAX_NO" ).append("\n"); 
		query.append(",C.MNR_PRNR_EML" ).append("\n"); 
		query.append(",C.MNR_PRNR_RMK" ).append("\n"); 
		query.append(",C.TRSM_MOD_CD" ).append("\n"); 
		query.append(",C.FILE_SEQ" ).append("\n"); 
		query.append(",B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",B.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append(",B.PAY_CURR_CD" ).append("\n"); 
		query.append(",C.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(C.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",C.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(C.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MDM_VENDOR B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append(",A.CTRL_OFC_CD" ).append("\n"); 
		query.append(",A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_TP_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_KND_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_KND_DTL_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_STS_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",A.EDI_ID" ).append("\n"); 
		query.append(",A.SP_PTAL_ID" ).append("\n"); 
		query.append(",A.SP_PTAL_PWD" ).append("\n"); 
		query.append(",A.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.MNR_PRNR_LOCL_LANG_NM" ).append("\n"); 
		query.append(",A.MNR_PRNR_ADDR" ).append("\n"); 
		query.append(",A.MNR_BIL_TO_NM" ).append("\n"); 
		query.append(",A.EFF_DT" ).append("\n"); 
		query.append(",A.EXP_DT" ).append("\n"); 
		query.append(",A.BANK_NM" ).append("\n"); 
		query.append(",A.BANK_ACCT_NO" ).append("\n"); 
		query.append(",A.PAY_MZD_CD" ).append("\n"); 
		query.append(",A.PAY_TERM_DYS" ).append("\n"); 
		query.append(",A.ZIP_CD" ).append("\n"); 
		query.append(",A.OWNR_NM" ).append("\n"); 
		query.append(",A.BZCT_NM" ).append("\n"); 
		query.append(",A.BZTP_NM" ).append("\n"); 
		query.append(",A.BIZ_RGST_NO" ).append("\n"); 
		query.append(",A.MNR_SHOP_FLG" ).append("\n"); 
		query.append(",A.MNR_PAYR_CNT_CD" ).append("\n"); 
		query.append(",A.MNR_PAYR_SEQ" ).append("\n"); 
		query.append(",A.MNR_PRNR_CAPI_AMT" ).append("\n"); 
		query.append(",A.EMPE_KNT" ).append("\n"); 
		query.append(",A.DPT_DESC" ).append("\n"); 
		query.append(",A.MNR_PRNR_ABBR_NM" ).append("\n"); 
		query.append(",A.INTL_PHN_NO" ).append("\n"); 
		query.append(",A.PHN_NO" ).append("\n"); 
		query.append(",A.INTL_FAX_NO" ).append("\n"); 
		query.append(",A.FAX_NO" ).append("\n"); 
		query.append(",A.MNR_PRNR_EML" ).append("\n"); 
		query.append(",A.MNR_PRNR_RMK" ).append("\n"); 
		query.append(",A.TRSM_MOD_CD" ).append("\n"); 
		query.append(",A.FILE_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM MNR_PARTNER A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${mnr_prnr_seq} != '')" ).append("\n"); 
		query.append("A.MNR_PRNR_SEQ = TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append("AND   A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = C.MNR_PRNR_SEQ(+)" ).append("\n"); 

	}
}