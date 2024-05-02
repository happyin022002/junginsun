/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOSearchCustCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCustCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 코드를 조회한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchCustCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCustCodeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   CNTR_DIV_FLG" ).append("\n"); 
		query.append(",  BLK_DIV_FLG" ).append("\n"); 
		query.append(",  CUST_GRP_ID" ).append("\n"); 
		query.append(",  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",  CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append(",  CUST_ABBR_NM" ).append("\n"); 
		query.append(",  CNTR_CUST_TP_CD" ).append("\n"); 
		query.append(",  BLK_CUST_TP_CD" ).append("\n"); 
		query.append(",  INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append(",  OFC_CD" ).append("\n"); 
		query.append(",  FNDT_DT" ).append("\n"); 
		query.append(",  CUST_RGST_NO" ).append("\n"); 
		query.append(",  FINC_STS_LVL_CD" ).append("\n"); 
		query.append(",  LOC_CD" ).append("\n"); 
		query.append(",  CAPI_CURR_CD" ).append("\n"); 
		query.append(",  CAPI_AMT" ).append("\n"); 
		query.append(",  LSTK_FLG" ).append("\n"); 
		query.append(",  EMPE_KNT" ).append("\n"); 
		query.append(",  VNDR_SEQ" ).append("\n"); 
		query.append(",  CUST_RMK" ).append("\n"); 
		query.append(",  VBS_CLSS_CD" ).append("\n"); 
		query.append(",  NBS_CLSS_CD1" ).append("\n"); 
		query.append(",  NBS_CLSS_CD2" ).append("\n"); 
		query.append(",  NBS_CLSS_CD3" ).append("\n"); 
		query.append(",  CUST_STS_CD" ).append("\n"); 
		query.append(",  CRM_ROW_ID" ).append("\n"); 
		query.append(",  NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append(",  NVOCC_BD_NO" ).append("\n"); 
		query.append(",  NVOCC_LIC_NO" ).append("\n"); 
		query.append(",  NVOCC_BD_AMT" ).append("\n"); 
		query.append(",  NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append(",  NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append(",  INDUS_DESC" ).append("\n"); 
		query.append(",  CRNT_VOL_KNT" ).append("\n"); 
		query.append(",  CMPT_DESC" ).append("\n"); 
		query.append(",  SPCL_REQ_DESC" ).append("\n"); 
		query.append(",  PRF_SVC_DESC" ).append("\n"); 
		query.append(",  PRF_SVC_DTL_DESC" ).append("\n"); 
		query.append(",  PRF_GRP_CMDT_CD" ).append("\n"); 
		query.append(",  PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",  PRF_REP_CMDT_CD" ).append("\n"); 
		query.append(",  SREP_CD" ).append("\n"); 
		query.append(",  CTS_NO" ).append("\n"); 
		query.append(",  FRT_FWRD_FMC_NO" ).append("\n"); 
		query.append(",  KEY_ACCT_FLG" ).append("\n"); 
		query.append(",  TO_CHAR(KEY_ACCT_ST_EFF_DT, 'YYYY-MM-DD') KEY_ACCT_ST_EFF_DT" ).append("\n"); 
		query.append(",  TO_CHAR(KEY_ACCT_END_EFF_DT, 'YYYY-MM-DD') KEY_ACCT_END_EFF_DT" ).append("\n"); 
		query.append(",  SUBS_CO_CD" ).append("\n"); 
		query.append(",  MODI_CUST_CNT_CD" ).append("\n"); 
		query.append(",  MODI_CUST_SEQ" ).append("\n"); 
		query.append(",  RFND_PSDO_VNDR_SEQ" ).append("\n"); 
		query.append(",  BFR_OFC_CD" ).append("\n"); 
		query.append(",  BFR_OFC_CNG_DT" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  DELT_FLG" ).append("\n"); 
		query.append(",  EAI_EVNT_DT" ).append("\n"); 
		query.append(",  KEY_ACCT_MGR_USR_ID" ).append("\n"); 
		query.append(",  KEY_ACCT_MGR_USR_NM" ).append("\n"); 
		query.append(",  SLS_DELT_EFF_DT" ).append("\n"); 
		query.append(",  FLET_MGMT_OWNR_CUST_SEQ" ).append("\n"); 
		query.append(",  INV_ISS_CURR_TP_CD" ).append("\n"); 
		query.append(",  INV_ISS_TP_CD" ).append("\n"); 
		query.append(",  NMD_CUST_FLG" ).append("\n"); 
		query.append(",  BKG_ALT_RSN" ).append("\n"); 
		query.append(",  BKG_ALT_FM_DT" ).append("\n"); 
		query.append(",  BKG_ALT_TO_DT" ).append("\n"); 
		query.append(",  BKG_ALT_MSG" ).append("\n"); 
		query.append(",  BKG_ALT_CRE_USR_ID" ).append("\n"); 
		query.append(",  BKG_ALT_CRE_DT" ).append("\n"); 
		query.append(",  EAI_IF_ID" ).append("\n"); 
		query.append(",  MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append(",  (SELECT BZET_ADDR" ).append("\n"); 
		query.append("   FROM MDM_CUSTOMER C1, MDM_CUST_ADDR C2" ).append("\n"); 
		query.append("   WHERE C1.CUST_CNT_CD = C2.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND C1.CUST_SEQ = C2.CUST_SEQ" ).append("\n"); 
		query.append("   AND C1.CUST_CNT_CD=@[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND C1.CUST_SEQ=@[cust_seq]" ).append("\n"); 
		query.append("   AND C2.ADDR_TP_CD='1'" ).append("\n"); 
		query.append("   AND C2.PRMRY_CHK_FLG='Y'" ).append("\n"); 
		query.append("   AND ROWNUM = 1) BZET_ADDR" ).append("\n"); 
		query.append(",  (SELECT ADDR_TP_CD" ).append("\n"); 
		query.append("   FROM MDM_CUSTOMER C1, MDM_CUST_ADDR C2" ).append("\n"); 
		query.append("   WHERE C1.CUST_CNT_CD = C2.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND C1.CUST_SEQ = C2.CUST_SEQ" ).append("\n"); 
		query.append("   AND C1.CUST_CNT_CD=@[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND C1.CUST_SEQ=@[cust_seq]" ).append("\n"); 
		query.append("   AND C2.ADDR_TP_CD='1'" ).append("\n"); 
		query.append("   AND C2.PRMRY_CHK_FLG='Y'" ).append("\n"); 
		query.append("   AND ROWNUM = 1) ADDR_TP_CD" ).append("\n"); 
		query.append(",  (SELECT ADDR_SEQ" ).append("\n"); 
		query.append("   FROM MDM_CUSTOMER C1, MDM_CUST_ADDR C2" ).append("\n"); 
		query.append("   WHERE C1.CUST_CNT_CD = C2.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND C1.CUST_SEQ = C2.CUST_SEQ" ).append("\n"); 
		query.append("   AND C1.CUST_CNT_CD=@[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND C1.CUST_SEQ=@[cust_seq]" ).append("\n"); 
		query.append("   AND C2.ADDR_TP_CD='1'" ).append("\n"); 
		query.append("   AND C2.PRMRY_CHK_FLG='Y'" ).append("\n"); 
		query.append("   AND ROWNUM = 1) ADDR_SEQ" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ " ).append("\n"); 
		query.append(", CUST_DIV_CD" ).append("\n"); 
		query.append(", MODI_CUST_CD" ).append("\n"); 
		query.append(", CNSD_CUST_CNT_CD" ).append("\n"); 
		query.append(", CNSD_CUST_SEQ " ).append("\n"); 
		query.append(", SPRS_PAY_LTR_FLG" ).append("\n"); 
		query.append(", PAY_RQST_LTR_FMT_CD" ).append("\n"); 
		query.append(", INV_EDI_LVL_CD" ).append("\n"); 
		query.append(", DFLT_INV_CURR_DIV_CD" ).append("\n"); 
		query.append(", RAIL_ROAD_PRIO_FLG" ).append("\n"); 
		query.append(", MODI_CUST_CD2" ).append("\n"); 
		query.append(", SPRT_EML_INV_FLG" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("WHERE CUST_CNT_CD =@[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[cust_seq]" ).append("\n"); 

	}
}