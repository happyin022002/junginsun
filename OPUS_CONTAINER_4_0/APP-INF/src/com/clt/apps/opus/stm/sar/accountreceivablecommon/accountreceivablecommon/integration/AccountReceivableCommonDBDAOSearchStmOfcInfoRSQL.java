/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchStmOfcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOSearchStmOfcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search MDM Office & SCO Office
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchStmOfcInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchStmOfcInfoRSQL").append("\n"); 
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
		query.append("    SELECT      A.OFC_CD" ).append("\n"); 
		query.append("              , A.OFC_ENG_NM" ).append("\n"); 
		query.append("              , A.OFC_LOCL_NM" ).append("\n"); 
		query.append("              , A.OFC_ADDR" ).append("\n"); 
		query.append("              , A.OFC_ZIP_CD" ).append("\n"); 
		query.append("              , A.OFC_KND_CD" ).append("\n"); 
		query.append("              , A.AGN_KND_CD" ).append("\n"); 
		query.append("              , A.VNDR_CNT_CD" ).append("\n"); 
		query.append("              , A.VNDR_SEQ" ).append("\n"); 
		query.append("              , A.INTL_PHN_NO" ).append("\n"); 
		query.append("              , A.OFC_PHN_NO" ).append("\n"); 
		query.append("              , A.INTL_FAX_NO" ).append("\n"); 
		query.append("              , A.OFC_FAX_NO" ).append("\n"); 
		query.append("              , A.OFC_PSON_KNT" ).append("\n"); 
		query.append("              , A.OFC_RMK" ).append("\n"); 
		query.append("              , A.LOC_CD" ).append("\n"); 
		query.append("              , A.BIL_CURR_CD" ).append("\n"); 
		query.append("              , A.AR_CURR_CD" ).append("\n"); 
		query.append("              , A.AR_CTR_CD" ).append("\n"); 
		query.append("              , A.PRNT_OFC_CD" ).append("\n"); 
		query.append("              , A.OPN_DT" ).append("\n"); 
		query.append("              , A.CLZ_DT" ).append("\n"); 
		query.append("              , A.FINC_RGN_CD" ).append("\n"); 
		query.append("              , A.AR_OFC_CD" ).append("\n"); 
		query.append("              , A.AR_CTRL_OFC_CD" ).append("\n"); 
		query.append("              , A.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("              , A.IB_CR_TERM_DYS" ).append("\n"); 
		query.append("              , A.OB_CR_TERM_DYS" ).append("\n"); 
		query.append("              , A.SUB_AGN_FLG" ).append("\n"); 
		query.append("              , A.REP_CUST_CNT_CD" ).append("\n"); 
		query.append("              , A.REP_CUST_SEQ" ).append("\n"); 
		query.append("              , A.INV_PFX_CD" ).append("\n"); 
		query.append("              , A.AP_OFC_CD" ).append("\n"); 
		query.append("              , A.AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("              , A.AP_HO_ACCT_CD" ).append("\n"); 
		query.append("              , A.AP_CTR_CD" ).append("\n"); 
		query.append("              , A.AR_AGN_STL_CD" ).append("\n"); 
		query.append("              , A.FX_CURR_RT" ).append("\n"); 
		query.append("              , A.AP_EURO_CURR_USE_FLG" ).append("\n"); 
		query.append("              , A.USA_BRK_BRNC_RQST_CTRL_OFC_CD" ).append("\n"); 
		query.append("              , A.ASA_CR_TERM_DYS" ).append("\n"); 
		query.append("              , A.SO_IF_CD" ).append("\n"); 
		query.append("              , A.SLS_OFC_USE_FLG" ).append("\n"); 
		query.append("              , A.SLS_OFC_DIV_CD" ).append("\n"); 
		query.append("              , A.OFC_TAX_ID" ).append("\n"); 
		query.append("              , A.OFC_RFA_SC_USE_FLG" ).append("\n"); 
		query.append("              , A.COMM_IF_IND_CD" ).append("\n"); 
		query.append("              , A.FAX_IP" ).append("\n"); 
		query.append("              , A.BFR_OFC_CD" ).append("\n"); 
		query.append("              , A.MODI_OFC_CD" ).append("\n"); 
		query.append("              , A.OFC_CMMC_CD" ).append("\n"); 
		query.append("              , A.OFC_TP_CD" ).append("\n"); 
		query.append("              , A.PRC_OFC_CD" ).append("\n"); 
		query.append("              , A.OFC_URL" ).append("\n"); 
		query.append("              , A.OFC_REP_EML" ).append("\n"); 
		query.append("              , A.BKG_SVR_SRCH_ROUT_CD" ).append("\n"); 
		query.append("              , A.OFC_SLS_DELT_FLG" ).append("\n"); 
		query.append("              , A.DOC_RCVR_HIDE_FLG" ).append("\n"); 
		query.append("              , A.FINC_HIDE_FLG" ).append("\n"); 
		query.append("              , A.FINC_PSDO_OFC_FLG" ).append("\n"); 
		query.append("              , A.SUBS_CO_FLG" ).append("\n"); 
		query.append("              , A.GL_CTR_CD" ).append("\n"); 
		query.append("              , A.TEAM_MGR_NM" ).append("\n"); 
		query.append("              , A.TEAM_FAX_NO" ).append("\n"); 
		query.append("              , A.OFC_LOCL_LANG_ADDR" ).append("\n"); 
		query.append("              , A.CRE_USR_ID" ).append("\n"); 
		query.append("              , A.CRE_DT" ).append("\n"); 
		query.append("              , A.UPD_USR_ID" ).append("\n"); 
		query.append("              , A.UPD_DT" ).append("\n"); 
		query.append("              , A.DELT_FLG" ).append("\n"); 
		query.append("              , A.EAI_EVNT_DT" ).append("\n"); 
		query.append("              , A.EAI_IF_ID" ).append("\n"); 
		query.append("              , B.OFC_ENTR_LVL_CD" ).append("\n"); 
		query.append("              , B.BANK_CTRL_CD" ).append("\n"); 
		query.append("              , B.OTS_CD" ).append("\n"); 
		query.append("              , B.REP_OTS_OFC_CD" ).append("\n"); 
		query.append("              , B.MISC_LSS_LMT_AMT" ).append("\n"); 
		query.append("              , B.MISC_INCM_LMT_AMT" ).append("\n"); 
		query.append("              , B.AGN_CMB_CD" ).append("\n"); 
		query.append("              , B.AGN_PFX_CD" ).append("\n"); 
		query.append("              , B.OTS_CATE_CD" ).append("\n"); 
		query.append("              , B.AGN_CURR_CD" ).append("\n"); 
		query.append("              , B.AGN_OTS_LMT_AMT" ).append("\n"); 
		query.append("              , B.OTS_IF_FLG" ).append("\n"); 
		query.append("              , B.BANK_CHG_ACCT_CD" ).append("\n"); 
		query.append("              , B.OVPAY_TP_CD" ).append("\n"); 
		query.append("              , B.OFC_INQ_LVL_CD" ).append("\n"); 
		query.append("              , B.LOCL_CURR_CD" ).append("\n"); 
		query.append("              , B.OFC_CNT_CD" ).append("\n"); 
		query.append("              , B.RCT_TP_CD" ).append("\n"); 
		query.append("              , B.RCT_UNAPY_FLG" ).append("\n"); 
		query.append("              , B.OFC_BRNC_AGN_TP_CD" ).append("\n"); 
		query.append("              , B.BANK_OFC" ).append("\n"); 
		query.append("              , B.ENBL_FLG" ).append("\n"); 
		query.append("              , B.AR_PRN_CTNT" ).append("\n"); 
		query.append("              , B.AR_PRN_TIT_NM" ).append("\n"); 
		query.append("              , B.OTS_SMRY_CD" ).append("\n"); 
		query.append("              , B.RCT_OFC_TIT_NM" ).append("\n"); 
		query.append("              , B.RCT_OFC_ADDR" ).append("\n"); 
		query.append("              , B.RCT_OFC_TELCM_FAX_NO_CTNT" ).append("\n"); 
		query.append("              , B.RCT_OFC_SPCL_NO_CTNT" ).append("\n"); 
		query.append("              , B.RCT_TIT_NM" ).append("\n"); 
		query.append("              , B.RCT_RMK" ).append("\n"); 
		query.append("              , B.RCT_SPCL_RMK" ).append("\n"); 
		query.append("              , B.RCT_DOC_CD" ).append("\n"); 
		query.append("              , B.OFC_WRTF_TP_CD1" ).append("\n"); 
		query.append("              , B.OFC_WRTF_TP_CD2" ).append("\n"); 
		query.append("              , B.OFC_WRTF_TP_CD3" ).append("\n"); 
		query.append("              , B.OFC_WRTF_TP_CD4" ).append("\n"); 
		query.append("              , B.OFC_WRTF_TP_CD5" ).append("\n"); 
		query.append("    FROM        MDM_ORGANIZATION A" ).append("\n"); 
		query.append("              , SCO_OFC_INFO B " ).append("\n"); 
		query.append("    WHERE       A.OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("      AND       A.OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}