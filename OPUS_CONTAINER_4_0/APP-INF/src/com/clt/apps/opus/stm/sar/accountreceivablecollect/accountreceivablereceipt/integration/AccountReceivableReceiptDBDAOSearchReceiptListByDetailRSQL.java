/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchReceiptListByDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOSearchReceiptListByDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Receipt List By Detail
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchReceiptListByDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_dps_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dps_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cxl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchReceiptListByDetailRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       SR.RCT_SEQ," ).append("\n"); 
		query.append("       SR.RCT_OFC_CD," ).append("\n"); 
		query.append("       SR.RCT_NO," ).append("\n"); 
		query.append("       SR.CHQ_NO," ).append("\n"); 
		query.append("       SR.ASA_NO,    " ).append("\n"); 
		query.append("       SR.RCT_CUST_CNT_CD||NVL2(SR.RCT_CUST_CNT_CD,'-','')||LPAD(SR.RCT_CUST_SEQ, 6, '0')  RCT_CUST_CD," ).append("\n"); 
		query.append("       NVL(MCC.LOCL_NM, MC.CUST_LGL_ENG_NM) RCT_CUST_NM," ).append("\n"); 
		query.append("       SRAH.BIL_TO_CUST_CNT_CD||NVL2(SRAH.BIL_TO_CUST_CNT_CD,'-','')||LPAD(SRAH.BIL_TO_CUST_SEQ,6, '0')    OTS_CUST_CD," ).append("\n"); 
		query.append("       NVL(OMCC.LOCL_NM, OMC.CUST_LGL_ENG_NM) OTS_CUST_NM," ).append("\n"); 
		query.append("       SR.BANK_ACCT_SEQ," ).append("\n"); 
		query.append("       SBA.BANK_ACCT_NM," ).append("\n"); 
		query.append("       SR.RCT_CURR_CD," ).append("\n"); 
		query.append("       SR.RCT_AMT," ).append("\n"); 
		query.append("       SR.RCT_TP_CD," ).append("\n"); 
		query.append("       SR.RCT_DT," ).append("\n"); 
		query.append("       SR.RCT_DPS_DT," ).append("\n"); 
		query.append("       SR.CRE_USR_ID," ).append("\n"); 
		query.append("       CU.USR_NM," ).append("\n"); 
		query.append("       @[usr_ofc]   usr_ofc,             " ).append("\n"); 
		query.append("       SRAH.BL_NO," ).append("\n"); 
		query.append("       SRAH.BKG_NO," ).append("\n"); 
		query.append("       SRAH.INV_NO," ).append("\n"); 
		query.append("       SRAH.OTS_OFC_CD," ).append("\n"); 
		query.append("       SRAH.LOCL_VVD_CD," ).append("\n"); 
		query.append("       (SELECT MV.VSL_ENG_NM FROM MDM_VSL_CNTR MV WHERE SUBSTR(SRAH.LOCL_VVD_CD,0,4) = MV.VSL_CD AND ROWNUM = 1) AS VSL_NM," ).append("\n"); 
		query.append("       SRAH.IO_BND_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT SOH.POL_CD" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH  " ).append("\n"); 
		query.append("        WHERE SOH.BL_NO = SRAH.BL_NO" ).append("\n"); 
		query.append("              AND SOH.INV_NO = SRAH.INV_NO" ).append("\n"); 
		query.append("			  AND SOH.OTS_OFC_CD = (SELECT DECODE(OTS_CD, 'COU', REP_OTS_OFC_CD, OFC_CD) " ).append("\n"); 
		query.append("                                    FROM SCO_OFC_INFO " ).append("\n"); 
		query.append("                                    WHERE OFC_CD = SRAH.OTS_OFC_CD)" ).append("\n"); 
		query.append("              --AND SOH.CLT_OFC_CD = SRAH.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS POL_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT SOH.POD_CD" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH  " ).append("\n"); 
		query.append("        WHERE SOH.BL_NO = SRAH.BL_NO" ).append("\n"); 
		query.append("              AND SOH.INV_NO = SRAH.INV_NO" ).append("\n"); 
		query.append("			  AND SOH.OTS_OFC_CD = (SELECT DECODE(OTS_CD, 'COU', REP_OTS_OFC_CD, OFC_CD) " ).append("\n"); 
		query.append("                                    FROM SCO_OFC_INFO " ).append("\n"); 
		query.append("                                    WHERE OFC_CD = SRAH.OTS_OFC_CD)" ).append("\n"); 
		query.append("              --AND SOH.CLT_OFC_CD = SRAH.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS POD_CD," ).append("\n"); 
		query.append("       SRAH.INV_DT,        " ).append("\n"); 
		query.append("       SR.RCT_DT-SRAH.SAIL_ARR_DT AS CLT_TERM," ).append("\n"); 
		query.append("       SRAH.RVS_FLG," ).append("\n"); 
		query.append("       SRAD.WRTF_CD," ).append("\n"); 
		query.append("       SRAD.RCT_APLY_CHG_CD," ).append("\n"); 
		query.append("       SRAD.RCT_APLY_SRC_CURR_CD," ).append("\n"); 
		query.append("       SRAD.OTS_BAL_AMT," ).append("\n"); 
		query.append("       SRAD.OTS_APLY_AMT," ).append("\n"); 
		query.append("       SRAD.RCT_CURR_CD           AS RCT_APLY_TGT_CURR_CD," ).append("\n"); 
		query.append("       SRAD.RCT_APLY_XCH_RT," ).append("\n"); 
		query.append("       SRAD.RCT_APLY_AMT,       " ).append("\n"); 
		query.append("       SR.RCT_CXL_RSN_CD," ).append("\n"); 
		query.append("       SR.RCT_CXL_DT," ).append("\n"); 
		query.append("       DECODE(SR.RCT_CXL_RSN_CD, NULL, 'N', 'Y')             AS CXL_RSN_FLG," ).append("\n"); 
		query.append("       DECODE(SR.RCT_STS_CD, 'UNID', 'Y', 'UNAPP', 'Y', 'N') AS UNAPP_FLG," ).append("\n"); 
		query.append("	   SR.RCT_CXL_RMK," ).append("\n"); 
		query.append("	   DECODE(SR.RCT_STS_CD, 'CXL', SR.UPD_USR_ID, '') CXL_USR_ID," ).append("\n"); 
		query.append("	   SR.BANK_CHG_AMT," ).append("\n"); 
		query.append("	   (" ).append("\n"); 
		query.append("        SELECT SOH.LANE_CD" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH  " ).append("\n"); 
		query.append("        WHERE SOH.BL_NO = SRAH.BL_NO" ).append("\n"); 
		query.append("              AND SOH.INV_NO = SRAH.INV_NO" ).append("\n"); 
		query.append(" 			  AND SOH.OTS_OFC_CD = (SELECT DECODE(OTS_CD, 'COU', REP_OTS_OFC_CD, OFC_CD) " ).append("\n"); 
		query.append("                                    FROM SCO_OFC_INFO " ).append("\n"); 
		query.append("                                    WHERE OFC_CD = SRAH.OTS_OFC_CD)" ).append("\n"); 
		query.append("              --AND SOH.CLT_OFC_CD = SRAH.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS LANE_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT SOH.SVC_SCP_CD" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH  " ).append("\n"); 
		query.append("        WHERE SOH.BL_NO = SRAH.BL_NO" ).append("\n"); 
		query.append("              AND SOH.INV_NO = SRAH.INV_NO" ).append("\n"); 
		query.append("			  AND SOH.OTS_OFC_CD = (SELECT DECODE(OTS_CD, 'COU', REP_OTS_OFC_CD, OFC_CD) " ).append("\n"); 
		query.append("                                    FROM SCO_OFC_INFO " ).append("\n"); 
		query.append("                                    WHERE OFC_CD = SRAH.OTS_OFC_CD)" ).append("\n"); 
		query.append("              --AND SOH.CLT_OFC_CD = SRAH.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS SVC_SCP_CD," ).append("\n"); 
		query.append("	   (" ).append("\n"); 
		query.append("        SELECT TO_CHAR(TO_DATE(SOH.SAIL_ARR_DT,'YYYY-MM-DD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH  " ).append("\n"); 
		query.append("        WHERE SOH.BL_NO = SRAH.BL_NO" ).append("\n"); 
		query.append("              AND SOH.INV_NO = SRAH.INV_NO" ).append("\n"); 
		query.append("			  AND SOH.OTS_OFC_CD = (SELECT DECODE(OTS_CD, 'COU', REP_OTS_OFC_CD, OFC_CD) " ).append("\n"); 
		query.append("                                    FROM SCO_OFC_INFO " ).append("\n"); 
		query.append("                                    WHERE OFC_CD = SRAH.OTS_OFC_CD)" ).append("\n"); 
		query.append("              --AND SOH.CLT_OFC_CD = SRAH.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS SAIL_ARR_DT," ).append("\n"); 
		query.append("       (SELECT BC.CUST_CNT_CD ||NVL2(BC.CUST_CNT_CD,'-','')|| BC.CUST_SEQ FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = SRAH.BL_NO AND BC.BKG_CUST_TP_CD = 'S' AND ROWNUM = 1) AS S_CUST_CD, " ).append("\n"); 
		query.append("       (SELECT BC.CUST_NM FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = SRAH.BL_NO AND BC.BKG_CUST_TP_CD = 'S' AND ROWNUM = 1) AS S_CUST_NM," ).append("\n"); 
		query.append("       (SELECT BC.CUST_CNT_CD ||NVL2(BC.CUST_CNT_CD,'-','')|| BC.CUST_SEQ FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = SRAH.BL_NO AND BC.BKG_CUST_TP_CD = 'C' AND ROWNUM = 1) AS C_CUST_CD," ).append("\n"); 
		query.append("       (SELECT BC.CUST_NM FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = SRAH.BL_NO AND BC.BKG_CUST_TP_CD = 'C'AND ROWNUM = 1) AS C_CUST_NM" ).append("\n"); 
		query.append("        ,ROW_NUMBER() OVER(ORDER BY SR.RCT_SEQ DESC) AS RNUM, " ).append("\n"); 
		query.append("        COUNT(*) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("FROM   MDM_CUSTOMER MC," ).append("\n"); 
		query.append("       MDM_CR_CUST  MCC," ).append("\n"); 
		query.append("       COM_USER CU," ).append("\n"); 
		query.append("       MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("       SAP_BANK_ACCT SBA," ).append("\n"); 
		query.append("       SAR_RECEIPT SR," ).append("\n"); 
		query.append("       MDM_CUSTOMER OMC," ).append("\n"); 
		query.append("       MDM_CR_CUST  OMCC," ).append("\n"); 
		query.append("       SAR_RCT_APLY_HDR  SRAH," ).append("\n"); 
		query.append("       SAR_RCT_APLY_DTL  SRAD" ).append("\n"); 
		query.append("WHERE  SR.RCT_SEQ = SRAH.RCT_SEQ(+)" ).append("\n"); 
		query.append("AND    SRAH.RCT_APLY_HDR_SEQ = SRAD.RCT_APLY_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND    SR.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND    SR.RCT_OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("AND    SR.CRE_USR_ID = CU.USR_ID(+)" ).append("\n"); 
		query.append("--RECEIPT CUSTOMER NAME" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD =MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD = MCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ = MCC.CUST_SEQ(+)" ).append("\n"); 
		query.append("--OTS CUSTOMER NAME " ).append("\n"); 
		query.append("AND    SRAH.BIL_TO_CUST_CNT_CD = OMC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    SRAH.BIL_TO_CUST_SEQ = OMC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    SRAH.BIL_TO_CUST_CNT_CD = OMCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    SRAH.BIL_TO_CUST_SEQ = OMCC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    SR.RCT_OFC_CD IN ( ${rct_ofc_cd} )  --20140407 wskim 추가  " ).append("\n"); 
		query.append("AND    SR.CRE_USR_ID = NVL(@[rct_usr_id], SR.CRE_USR_ID)" ).append("\n"); 
		query.append("AND    SR.RCT_DT >= NVL(REPLACE(@[rct_dt_fm],'-',''), SR.RCT_DT)" ).append("\n"); 
		query.append("AND    SR.RCT_DT <= NVL(REPLACE(@[rct_dt_to],'-',''), SR.RCT_DT)       " ).append("\n"); 
		query.append("AND    SR.RCT_DPS_DT >= NVL(REPLACE(@[rct_dps_dt_fm],'-',''), SR.RCT_DPS_DT)" ).append("\n"); 
		query.append("AND    SR.RCT_DPS_DT <= NVL(REPLACE(@[rct_dps_dt_to],'-',''), SR.RCT_DPS_DT)       " ).append("\n"); 
		query.append("AND    ( (@[rct_sts_cd] = 'ALL') OR" ).append("\n"); 
		query.append("         (@[rct_sts_cd] = 'CANCEL' AND SR.RCT_CXL_DT IS NOT NULL ) OR" ).append("\n"); 
		query.append("         (@[rct_sts_cd] = 'RECEIPT' AND SR.RCT_CXL_DT IS NULL )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${rct_unpay_sts_flg} == 'UNAPP')" ).append("\n"); 
		query.append("    AND    SR.RCT_STS_CD IN ('UNAPP','UNID')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_cust_cnt_cd} != '' )" ).append("\n"); 
		query.append("    AND    SR.RCT_CUST_CNT_CD = @[rct_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_cust_seq} != '') " ).append("\n"); 
		query.append("    AND    SR.RCT_CUST_SEQ = @[rct_cust_seq]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'ALL') " ).append("\n"); 
		query.append("    AND    SRAH.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${asa_no} != '') " ).append("\n"); 
		query.append("    AND    SR.ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${chq_no} != '') " ).append("\n"); 
		query.append("    AND    SR.CHQ_NO = @[chq_no]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND    SR.BANK_ACCT_SEQ = NVL(@[bank_acct_seq], SR.BANK_ACCT_SEQ)" ).append("\n"); 
		query.append("AND    SR.RCT_TP_CD = NVL(@[rct_tp_cd], SR.RCT_TP_CD)" ).append("\n"); 
		query.append("AND    SR.RCT_NO = NVL(@[rct_no], SR.RCT_NO)" ).append("\n"); 
		query.append("AND    SR.CRE_USR_ID = NVL(@[usr_id], SR.CRE_USR_ID)" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("	AND    SRAH.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	AND    SRAH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("	AND    SRAH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ots_ofc_cd} != '') " ).append("\n"); 
		query.append("	AND    SRAH.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_cxl_rsn_cd} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_CXL_RSN_CD = @[rct_cxl_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}