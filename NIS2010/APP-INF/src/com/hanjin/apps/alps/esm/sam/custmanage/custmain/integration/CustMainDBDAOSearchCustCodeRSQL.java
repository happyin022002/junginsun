/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchCustCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchCustCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Main info Search
	  * </pre>
	  */
	public CustMainDBDAOSearchCustCodeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCustCodeRSQL").append("\n"); 
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
		query.append("   CNTR_DIV_FLG" ).append("\n"); 
		query.append("	,  BLK_DIV_FLG" ).append("\n"); 
		query.append("	,  CUST_GRP_ID" ).append("\n"); 
		query.append(",  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",  CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append(",  CUST_ABBR_NM" ).append("\n"); 
		query.append(",  BLK_CUST_TP_CD" ).append("\n"); 
		query.append(",  INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append(",  RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append(",  OFC_CD" ).append("\n"); 
		query.append(",  FNDT_DT" ).append("\n"); 
		query.append(",  CUST_RGST_NO" ).append("\n"); 
		query.append(",  FINC_STS_LVL_CD" ).append("\n"); 
		query.append(",  MC.LOC_CD" ).append("\n"); 
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
		query.append(",  DECODE (MC.DELT_FLG,'Y','D','A') CUST_STS_CD" ).append("\n"); 
		query.append(",  MC.CRM_ROW_ID" ).append("\n"); 
		query.append(",  MC.CRM_ROW_ID CUST_ROW_ID" ).append("\n"); 
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
		query.append(",  MC.CRE_USR_ID" ).append("\n"); 
		query.append(",  MC.CRE_DT" ).append("\n"); 
		query.append(",  MC.UPD_USR_ID" ).append("\n"); 
		query.append(",  MC.UPD_DT" ).append("\n"); 
		query.append(",  DECODE(SLS_DELT_EFF_DT, NULL, 'N', 'Y') DELT_FLG" ).append("\n"); 
		query.append(",  MC.EAI_EVNT_DT" ).append("\n"); 
		query.append(",  KEY_ACCT_MGR_USR_ID" ).append("\n"); 
		query.append(",  KEY_ACCT_MGR_USR_NM" ).append("\n"); 
		query.append(",  SLS_DELT_EFF_DT" ).append("\n"); 
		query.append(",  FLET_MGMT_OWNR_CUST_SEQ" ).append("\n"); 
		query.append(",  INV_ISS_CURR_TP_CD" ).append("\n"); 
		query.append(",  INV_ISS_TP_CD" ).append("\n"); 
		query.append(",  NMD_CUST_FLG" ).append("\n"); 
		query.append(",  BKG_ALT_RSN" ).append("\n"); 
		query.append(",  TO_CHAR(BKG_ALT_FM_DT, 'YYYY-MM-DD') BKG_ALT_FM_DT" ).append("\n"); 
		query.append(",  TO_CHAR(BKG_ALT_TO_DT, 'YYYY-MM-DD') BKG_ALT_TO_DT" ).append("\n"); 
		query.append(",  BKG_ALT_MSG" ).append("\n"); 
		query.append(",  BKG_ALT_CRE_USR_ID" ).append("\n"); 
		query.append(",  BKG_ALT_CRE_DT" ).append("\n"); 
		query.append(",  MC.EAI_IF_ID" ).append("\n"); 
		query.append(",  MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append(",  MCA.BZET_ADDR" ).append("\n"); 
		query.append(",  MCA.ADDR_TP_CD" ).append("\n"); 
		query.append(",  MCA.ADDR_SEQ" ).append("\n"); 
		query.append(",  MCA.STE_CD" ).append("\n"); 
		query.append(",  MCA.ZIP_CD" ).append("\n"); 
		query.append(", MC.CUST_CNT_CD" ).append("\n"); 
		query.append(", MC.CUST_SEQ " ).append("\n"); 
		query.append(", MCCP.CUST_EML" ).append("\n"); 
		query.append(", MCCP.CUST_URL" ).append("\n"); 
		query.append(", MCCP.INTL_PHN_NO" ).append("\n"); 
		query.append(", MCCP.PHN_NO" ).append("\n"); 
		query.append(", MCCP.INTL_FAX_NO" ).append("\n"); 
		query.append(", MCCP.FAX_NO" ).append("\n"); 
		query.append(", MC.RGN_ACCT_FLG" ).append("\n"); 
		query.append(", MC.NEW_KEY_ACCT_FLG" ).append("\n"); 
		query.append(", MC.CUST_RMK" ).append("\n"); 
		query.append(", MC.NVOCC_HJS_SCAC_CD" ).append("\n"); 
		query.append(", (SELECT MS.IDA_STE_CD FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND MS.DELT_FLG = 'N' AND ROWNUM = 1) IDA_STE_CD" ).append("\n"); 
		query.append(", MC.IDA_PAN_NO" ).append("\n"); 
		query.append(", MC.IDA_GST_RGST_NO" ).append("\n"); 
		query.append(", MC.IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append(",  MC.IDA_CO_TYPE_CD" ).append("\n"); 
		query.append(",  MC.IDA_CUST_EML" ).append("\n"); 
		query.append(", (SELECT MS.STE_NM FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND MS.DELT_FLG = 'N' AND ROWNUM = 1) STE_NM" ).append("\n"); 
		query.append(", (SELECT CTCD.INTG_CD_VAL_DP_DESC FROM MDM_STATE MS, COM_INTG_CD_DTL CTCD WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND MS.DELT_FLG = 'N' AND CTCD.INTG_CD_ID = 'CD03556' AND MS.IDA_TERR_DIV_CD = CTCD.INTG_CD_VAL_CTNT AND ROWNUM = 1) IDA_TERR_DIV_CD" ).append("\n"); 
		query.append("--, (SELECT FILE_SAV_ID FROM MDM_CUST_SEZ_CERTI CERTI WHERE CERTI.CUST_CNT_CD = MC.CUST_CNT_CD AND CERTI.CUST_SEQ = MC.CUST_SEQ AND FILE_SEQ = 1) FILE_SAV_ID" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("	SELECT FILE_SAV_ID FROM (" ).append("\n"); 
		query.append("  		SELECT ROWNUM, FILE_SAV_ID FROM MDM_CUST_SEZ_CERTI WHERE CUST_CNT_CD = 'IN' AND CUST_SEQ = @[cust_seq] order by FILE_SEQ DESC" ).append("\n"); 
		query.append("	) WHERE ROWNUM = 1" ).append("\n"); 
		query.append("  ) FILE_SAV_ID" ).append("\n"); 
		query.append("--, (SELECT FILE_NM FROM MDM_CUST_SEZ_CERTI CERTI WHERE CERTI.CUST_CNT_CD = MC.CUST_CNT_CD AND CERTI.CUST_SEQ = MC.CUST_SEQ AND FILE_SEQ = 1) FILE_NM" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("	SELECT FILE_NM FROM (" ).append("\n"); 
		query.append("  		SELECT ROWNUM, FILE_NM FROM MDM_CUST_SEZ_CERTI WHERE CUST_CNT_CD = 'IN' AND CUST_SEQ = @[cust_seq] order by FILE_SEQ DESC" ).append("\n"); 
		query.append("	) WHERE ROWNUM = 1" ).append("\n"); 
		query.append("  ) FILE_NM" ).append("\n"); 
		query.append(", MC.CUST_CNT_CD||TRIM(TO_CHAR(MC.CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append(", MC.OTI_ORZ_NO" ).append("\n"); 
		query.append(", MCA.CTY_NM" ).append("\n"); 
		query.append(", 'I' GRP_INDIV_DIV" ).append("\n"); 
		query.append(", MC.GLO_ACCT_FLG" ).append("\n"); 
		query.append(", MC.RF_ACCT_FLG" ).append("\n"); 
		query.append(", MCA.CRM_ROW_ID ADDR_ROW_ID" ).append("\n"); 
		query.append(", MC.CO_CHN_TP_CD" ).append("\n"); 
		query.append(", MC.CO_CHN_NO" ).append("\n"); 
		query.append(", MC.ID_NPWP_RGST_NO" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("     , MDM_LOCATION ML" ).append("\n"); 
		query.append("     , MDM_CUST_CNTC_PNT MCCP" ).append("\n"); 
		query.append("     , (SELECT * FROM MDM_CUST_ADDR MCA WHERE MCA.CUST_CNT_CD = @[cust_cnt_cd] AND MCA.CUST_SEQ = @[cust_seq] AND MCA.ADDR_TP_CD='1' AND MCA.PRMRY_CHK_FLG='Y' AND ROWNUM = 1) MCA" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD =@[cust_cnt_cd]" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND MC.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = MCCP.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = MCCP.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND MCCP.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = MCA.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = MCA.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD <> 'TB'" ).append("\n"); 

	}
}