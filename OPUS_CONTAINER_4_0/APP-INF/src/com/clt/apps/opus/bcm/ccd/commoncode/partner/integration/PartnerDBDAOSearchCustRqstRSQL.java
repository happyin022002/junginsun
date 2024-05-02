/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerDBDAOSearchCustRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCustRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Request 정보를 조회한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchCustRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCustRqstRSQL").append("\n"); 
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
		query.append("           C1.CNTR_DIV_FLG" ).append("\n"); 
		query.append("        ,  C1.BLK_DIV_FLG" ).append("\n"); 
		query.append("        ,  C1.CUST_GRP_ID" ).append("\n"); 
		query.append("        ,  C1.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,  C1.CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append("        ,  C1.CUST_ABBR_NM" ).append("\n"); 
		query.append("        ,  C1.CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("        ,  C1.BLK_CUST_TP_CD" ).append("\n"); 
		query.append("        ,  C1.INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append("        ,  C1.OFC_CD" ).append("\n"); 
		query.append("        ,  C1.FNDT_DT" ).append("\n"); 
		query.append("        ,  C1.CUST_RGST_NO" ).append("\n"); 
		query.append("        ,  C1.FINC_STS_LVL_CD" ).append("\n"); 
		query.append("        ,  C1.LOC_CD" ).append("\n"); 
		query.append("        ,  C1.CAPI_CURR_CD" ).append("\n"); 
		query.append("        ,  C1.CAPI_AMT" ).append("\n"); 
		query.append("        ,  C1.LSTK_FLG" ).append("\n"); 
		query.append("        ,  C1.EMPE_KNT" ).append("\n"); 
		query.append("        ,  C1.VNDR_SEQ" ).append("\n"); 
		query.append("        ,  C1.CUST_RMK" ).append("\n"); 
		query.append("        ,  C1.VBS_CLSS_CD" ).append("\n"); 
		query.append("        ,  C1.NBS_CLSS_CD1" ).append("\n"); 
		query.append("        ,  C1.NBS_CLSS_CD2" ).append("\n"); 
		query.append("        ,  C1.NBS_CLSS_CD3" ).append("\n"); 
		query.append("        ,  C1.CUST_STS_CD" ).append("\n"); 
		query.append("        ,  C1.CRM_ROW_ID" ).append("\n"); 
		query.append("        ,  C1.NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("        ,  C1.NVOCC_BD_NO" ).append("\n"); 
		query.append("        ,  C1.NVOCC_LIC_NO" ).append("\n"); 
		query.append("        ,  C1.NVOCC_BD_AMT" ).append("\n"); 
		query.append("        ,  C1.NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append("        ,  C1.NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append("        ,  C1.INDUS_DESC" ).append("\n"); 
		query.append("        ,  C1.CRNT_VOL_KNT" ).append("\n"); 
		query.append("        ,  C1.CMPT_DESC" ).append("\n"); 
		query.append("        ,  C1.SPCL_REQ_DESC" ).append("\n"); 
		query.append("        ,  C1.PRF_SVC_DESC" ).append("\n"); 
		query.append("        ,  C1.PRF_SVC_DTL_DESC" ).append("\n"); 
		query.append("        ,  C1.PRF_GRP_CMDT_CD" ).append("\n"); 
		query.append("        ,  C1.PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,  C1.PRF_REP_CMDT_CD" ).append("\n"); 
		query.append("        ,  C1.SREP_CD" ).append("\n"); 
		query.append("        ,  C1.CTS_NO" ).append("\n"); 
		query.append("        ,  C1.FRT_FWRD_FMC_NO" ).append("\n"); 
		query.append("        ,  C1.KEY_ACCT_FLG" ).append("\n"); 
		query.append("        ,  TO_CHAR(C1.KEY_ACCT_ST_EFF_DT, 'YYYY-MM-DD') KEY_ACCT_ST_EFF_DT" ).append("\n"); 
		query.append("        ,  TO_CHAR(C1.KEY_ACCT_END_EFF_DT, 'YYYY-MM-DD') KEY_ACCT_END_EFF_DT" ).append("\n"); 
		query.append("        ,  C1.SUBS_CO_CD" ).append("\n"); 
		query.append("        ,  C1.MODI_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,  C1.MODI_CUST_SEQ" ).append("\n"); 
		query.append("        ,  C1.RFND_PSDO_VNDR_SEQ" ).append("\n"); 
		query.append("        ,  C1.BFR_OFC_CD" ).append("\n"); 
		query.append("        ,  C1.BFR_OFC_CNG_DT" ).append("\n"); 
		query.append("        ,  C1.CRE_USR_ID" ).append("\n"); 
		query.append("        ,  C1.CRE_DT" ).append("\n"); 
		query.append("        ,  C1.UPD_USR_ID" ).append("\n"); 
		query.append("        ,  C1.UPD_DT" ).append("\n"); 
		query.append("        ,  C1.DELT_FLG" ).append("\n"); 
		query.append("        ,  C1.EAI_EVNT_DT" ).append("\n"); 
		query.append("        ,  C1.KEY_ACCT_MGR_USR_ID" ).append("\n"); 
		query.append("        ,  C1.KEY_ACCT_MGR_USR_NM" ).append("\n"); 
		query.append("        ,  C1.SLS_DELT_EFF_DT" ).append("\n"); 
		query.append("        ,  C1.FLET_MGMT_OWNR_CUST_SEQ" ).append("\n"); 
		query.append("        ,  C1.INV_ISS_CURR_TP_CD" ).append("\n"); 
		query.append("        ,  C1.INV_ISS_TP_CD" ).append("\n"); 
		query.append("        ,  C1.NMD_CUST_FLG" ).append("\n"); 
		query.append("        ,  C1.BKG_ALT_RSN" ).append("\n"); 
		query.append("        ,  C1.BKG_ALT_FM_DT" ).append("\n"); 
		query.append("        ,  C1.BKG_ALT_TO_DT" ).append("\n"); 
		query.append("        ,  C1.BKG_ALT_MSG" ).append("\n"); 
		query.append("        ,  C1.BKG_ALT_CRE_USR_ID" ).append("\n"); 
		query.append("        ,  C1.BKG_ALT_CRE_DT" ).append("\n"); 
		query.append("        ,  C1.EAI_IF_ID" ).append("\n"); 
		query.append("        ,  C1.MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append("        ,  C2.BZET_ADDR" ).append("\n"); 
		query.append("        ,  C2.ADDR_TP_CD" ).append("\n"); 
		query.append("        ,  C2.ADDR_SEQ" ).append("\n"); 
		query.append("        ,  C3.CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("        ,  C3.CUST_EML" ).append("\n"); 
		query.append("        ,  C3.CUST_URL" ).append("\n"); 
		query.append("        ,  C3.INTL_PHN_NO" ).append("\n"); 
		query.append("        ,  C3.PHN_NO" ).append("\n"); 
		query.append("        ,  C3.INTL_FAX_NO" ).append("\n"); 
		query.append("        ,  C3.FAX_NO" ).append("\n"); 
		query.append("        ,  C1.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,  C1.CUST_SEQ " ).append("\n"); 
		query.append("        ,  C1.CUST_DIV_CD" ).append("\n"); 
		query.append("        ,  C1.MODI_CUST_CD" ).append("\n"); 
		query.append("        ,  C1.CNSD_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,  C1.CNSD_CUST_SEQ " ).append("\n"); 
		query.append("        ,  C1.SPRS_PAY_LTR_FLG" ).append("\n"); 
		query.append("        ,  C1.PAY_RQST_LTR_FMT_CD" ).append("\n"); 
		query.append("        ,  C1.INV_EDI_LVL_CD" ).append("\n"); 
		query.append("        ,  C1.DFLT_INV_CURR_DIV_CD" ).append("\n"); 
		query.append("        ,  C1.RAIL_ROAD_PRIO_FLG" ).append("\n"); 
		query.append("        ,  C1.MODI_CUST_CD2" ).append("\n"); 
		query.append("        ,  C1.SPRT_EML_INV_FLG" ).append("\n"); 
		query.append("FROM MDM_CUST_RQST C1, MDM_CUST_ADDR_RQST C2, MDM_CUST_CNTC_PNT_RQST C3" ).append("\n"); 
		query.append("WHERE C1.RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND C1.RQST_NO = C2.RQST_NO(+)" ).append("\n"); 
		query.append("AND C1.RQST_NO = C3.RQST_NO(+)" ).append("\n"); 
		query.append("AND C2.ADDR_TP_CD(+)='1'" ).append("\n"); 
		query.append("AND C2.PRMRY_CHK_FLG(+)='Y'" ).append("\n"); 
		query.append("AND C3.CUST_CNTC_PNT_SEQ(+)=1" ).append("\n"); 

	}
}