/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingIFDBDAOsearchIFSakuraASAListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingIFDBDAOsearchIFSakuraASAListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIFSakuraASAList
	  * </pre>
	  */
	public AccountReceivableOutstandingIFDBDAOsearchIFSakuraASAListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingIFDBDAOsearchIFSakuraASAListRSQL").append("\n"); 
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
		query.append("#if (${check_if_no} == '' )" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       sohi.if_no AS ref_doc_no" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${grp_yn} == 'Y' )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	MAX(IF_SEQ_NO) IF_SEQ_NO," ).append("\n"); 
		query.append("	MAX(REC_ID) REC_ID," ).append("\n"); 
		query.append("	ACCT_CO_CD," ).append("\n"); 
		query.append("	IF_DOC_TP_CD," ).append("\n"); 
		query.append("	DOC_DT," ).append("\n"); 
		query.append("	PST_DT," ).append("\n"); 
		query.append("	REF_DOC_NO," ).append("\n"); 
		query.append("	DOC_HDR_CD," ).append("\n"); 
		query.append("	CURR_CD, " ).append("\n"); 
		query.append("	TAX_CALC_AUTO_FLG," ).append("\n"); 
		query.append("	PST_KEY_CD," ).append("\n"); 
		query.append("	VAT_TAX_CD," ).append("\n"); 
		query.append("	SUM(LOCL_AMT) LOCL_AMT," ).append("\n"); 
		query.append("	SUM(DOC_AMT) DOC_AMT," ).append("\n"); 
		query.append("	SUM(LOCL_TAX_AMT) LOCL_TAX_AMT," ).append("\n"); 
		query.append("	SUM(DOC_TAX_AMT) DOC_TAX_AMT," ).append("\n"); 
		query.append("	ASGN_NO," ).append("\n"); 
		query.append("	ITM_DESC," ).append("\n"); 
		query.append("	PLN_DT," ).append("\n"); 
		query.append("	COST_CTR_CD," ).append("\n"); 
		query.append("	ORD_NO," ).append("\n"); 
		query.append("	MN_ASET_NO," ).append("\n"); 
		query.append("	SUB_ASET_NO," ).append("\n"); 
		query.append("	ASET_TJ_TP_CD," ).append("\n"); 
		query.append("	ASET_VAL_DT," ).append("\n"); 
		query.append("	GL_ACCT_NO," ).append("\n"); 
		query.append("	CUST_NO," ).append("\n"); 
		query.append("	VNDR_CRTR_ACCT_NO," ).append("\n"); 
		query.append("	DUE_DT_CALC_BSEL_DT," ).append("\n"); 
		query.append("	PAY_MZD_CD," ).append("\n"); 
		query.append("	STE_CNTRL_BANK_IND_CD," ).append("\n"); 
		query.append("	MTRL_NO," ).append("\n"); 
		query.append("	FUEL_LAND_QTY," ).append("\n"); 
		query.append("	MEAS_BSE_UT_CD," ).append("\n"); 
		query.append("	PFITCTR_CD," ).append("\n"); 
		query.append("	ALTN_ACCT_NO," ).append("\n"); 
		query.append("	BIZ_PRNR_REF_KEY_CD1," ).append("\n"); 
		query.append("	BIZ_PRNR_REF_KEY_CD2," ).append("\n"); 
		query.append("	LINE_ITM_REF_KEY_CD," ).append("\n"); 
		query.append("	INSTR_KEY_CD1," ).append("\n"); 
		query.append("	INSTR_KEY_CD2," ).append("\n"); 
		query.append("	INSTR_KEY_CD3," ).append("\n"); 
		query.append("	PAY_REF_CD," ).append("\n"); 
		query.append("	AUTOMTC_PAY_CURR_CD," ).append("\n"); 
		query.append("	PAY_CURR_AMT," ).append("\n"); 
		query.append("	CTRT_NO," ).append("\n"); 
		query.append("	CTRT_TP_CD," ).append("\n"); 
		query.append("	PAY_RSN_CD," ).append("\n"); 
		query.append("	CLSS_CD," ).append("\n"); 
		query.append("	ACT_PLC_CD," ).append("\n"); 
		query.append("	ENTR_EXPN_ID," ).append("\n"); 
		query.append("	BUD_MGMT_DIV_CD," ).append("\n"); 
		query.append("	ACT_DT," ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	VVL_CD," ).append("\n"); 
		query.append("	HUS_BANK_ID," ).append("\n"); 
		query.append("	PAY_BLCK_KEY_CD," ).append("\n"); 
		query.append("	MAX(N1ST_LODG_PORT_CD) N1ST_LODG_PORT_CD," ).append("\n"); 
		query.append("	MAX(N1ST_LODG_PORT_ETD_DT) N1ST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("	MAX(LST_DCHG_PORT_CD) LST_DCHG_PORT_CD," ).append("\n"); 
		query.append("	MAX(LST_DCHG_PORT_ETA_DT) LST_DCHG_PORT_ETA_DT," ).append("\n"); 
		query.append("	MAX(TRD_CD) TRD_CD," ).append("\n"); 
		query.append("	MAX(TRNK_VVD_CD) TRNK_VVD_CD," ).append("\n"); 
		query.append("	REC_TP_CD," ).append("\n"); 
		query.append("	NULL SLAN_CD," ).append("\n"); 
		query.append("	NULL BKG_QTY," ).append("\n"); 
		query.append("	MAX(ASA_FLG) ASA_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Invoice(ASA)" ).append("\n"); 
		query.append("SELECT --DISTINCT" ).append("\n"); 
		query.append("      --  SAR_AR_IF_SEQ.NEXTVAL  as AR_IF_Seq" ).append("\n"); 
		query.append("     NULL AS If_Seq_No" ).append("\n"); 
		query.append("     , '' AS rec_id" ).append("\n"); 
		query.append("     , '1000' AS acct_co_cd" ).append("\n"); 
		query.append("     , 'H8' AS if_doc_tp_Cd -- 20151005 v.3.2 H1에서 H8로 변경" ).append("\n"); 
		query.append("     , TO_CHAR(SOHI.IF_DT,'YYYYMMDD') AS doc_dt" ).append("\n"); 
		query.append("     , SOHI.GL_DT AS pst_dt" ).append("\n"); 
		query.append("     --20150213 wskim 변경" ).append("\n"); 
		query.append("     --, substr(sohi.if_no, 1, length(sohi.if_no)-1) AS ref_doc_no" ).append("\n"); 
		query.append("     #if($check_if_nos.size() > 1)" ).append("\n"); 
		query.append("	 	,SUBSTR(SOHI.IF_NO,1,LENGTH(SOHI.IF_NO) -1) AS REF_DOC_NO" ).append("\n"); 
		query.append("	 #else" ).append("\n"); 
		query.append("     	,SOHI.IF_NO AS REF_DOC_NO " ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("     , NULL AS doc_hdr_cd" ).append("\n"); 
		query.append("     , SOH.OFC_CURR_CD AS curr_cd" ).append("\n"); 
		query.append("     ,'' AS tax_calc_auto_flg" ).append("\n"); 
		query.append("     /* 20150102" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REC',DECODE(SIGN(SOC.INV_AMT),1,'01',-1,'11'), 'REV',DECODE(SIGN(SOC.INV_AMT),1,'11',-1,'01')," ).append("\n"); 
		query.append("                                'EXCH_GAIN', DECODE(SIGN(SOC.INV_AMT),1,'50',-1,'40'), 'EXCH_LOSS',DECODE(SIGN(SOC.INV_AMT),1,'50',-1,'40')," ).append("\n"); 
		query.append("                                'HDR_RND',DECODE(SIGN(SOC.INV_AMT),1,'50',-1,'40')) AS pst_key_cd */" ).append("\n"); 
		query.append("     /* 20150205 wskim 차/대 구분 로직 변경" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REC',DECODE(SIGN(SOC.INV_AMT),1,'01',-1,'11'), 'REV',DECODE(SIGN(SOC.INV_AMT),1,'11',-1,'01')," ).append("\n"); 
		query.append("                                'EXCH_GAIN', DECODE(SIGN(SOC.INV_AMT),1,'50',-1,'40'), 'EXCH_LOSS',DECODE(SIGN(SOC.INV_AMT),1,'40',-1,'50')," ).append("\n"); 
		query.append("                                'HDR_RND',DECODE(SIGN(SOC.INV_AMT),1,'50',-1,'40')) AS pst_key_cd */" ).append("\n"); 
		query.append("     -- 20160421 PST Key 조건 수정" ).append("\n"); 
		query.append("     , CASE" ).append("\n"); 
		query.append("             WHEN SODT.ACCT_CLSS_CD IN ('REC', 'REV') THEN" ).append("\n"); 
		query.append("                 DECODE(NVL(SODT.ACCT_DR_AMT, 0)+ NVL(SODT.INP_DR_AMT, 0), 0, '11', '01')" ).append("\n"); 
		query.append("             WHEN SODT.ACCT_CLSS_CD IN ('EXCH_GAIN', 'EXCH_LOSS', 'HDR_RND') THEN" ).append("\n"); 
		query.append("                 DECODE(NVL(SODT.ACCT_DR_AMT, 0)+ NVL(SODT.INP_DR_AMT, 0), 0, '50', '40')" ).append("\n"); 
		query.append("        END            AS pst_key_cd " ).append("\n"); 
		query.append("     --20160421                                 " ).append("\n"); 
		query.append("     --20150227 wskim V1.9 적용 " ).append("\n"); 
		query.append("/*     , CASE" ).append("\n"); 
		query.append("           WHEN SODT.ACCT_CLSS_CD = 'HDR_RND' THEN" ).append("\n"); 
		query.append("               DECODE((SELECT MA.ACCT_CD" ).append("\n"); 
		query.append("                       FROM  MDM_ACCOUNT MA" ).append("\n"); 
		query.append("                            ,MDM_CHARGE MC" ).append("\n"); 
		query.append("                       WHERE MA.ACCT_CD = MC.CO_CHG_ACCT_CD" ).append("\n"); 
		query.append("                       AND MC.CHG_CD = SODT.CHG_TP_CD" ).append("\n"); 
		query.append("                       AND ROWNUM=1),'411111', 'B0','D0')" ).append("\n"); 
		query.append("       END  AS vat_tax_cd    */ " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("      /* 20150924 tax_cd 로직 변경 */" ).append("\n"); 
		query.append("       , CASE" ).append("\n"); 
		query.append("           WHEN SODT.ACCT_CLSS_CD = 'HDR_RND' THEN" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                  WHEN  ((SOH.BKG_IO_BND_CD ='O' and SUBSTR(SOH.POL_CD,1,2)='JP')or (SOH.BKG_IO_BND_CD ='I' and SUBSTR(SOH.POD_CD,1,2)='JP')) THEN" ).append("\n"); 
		query.append("                           'B0'" ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                           'D0'" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("               ''" ).append("\n"); 
		query.append("        END   AS vat_tax_cd       " ).append("\n"); 
		query.append("     /* 20150102" ).append("\n"); 
		query.append("     , DECODE(SODT.CURR_CD, 'JPY','',DECODE(SIGN(SOC.INV_AMT),1,SODT.ACCT_DR_AMT,-1,SODT.ACCT_CR_AMT)) AS locl_amt" ).append("\n"); 
		query.append("     , DECODE(SIGN(SOHI.OTS_AMT),1,SODT.INP_DR_AMT,-1,SODT.INP_CR_AMT) AS doc_amt*/" ).append("\n"); 
		query.append("     /* 20150204 */" ).append("\n"); 
		query.append("     -- 20150716 STM AR인 경우 SAKURA I/F 위한 GL 컬럼으로 변경" ).append("\n"); 
		query.append("     ,CASE" ).append("\n"); 
		query.append("         WHEN SOHI.OTS_SRC_CD ='STM AR' THEN" ).append("\n"); 
		query.append("           DECODE(SOH.OFC_CURR_CD, 'JPY','',DECODE(NVL(SODT.GL_ACCT_DR_AMT,0),0,SODT.GL_ACCT_CR_AMT, SODT.GL_ACCT_DR_AMT)) " ).append("\n"); 
		query.append("         WHEN SOHI.OTS_SRC_CD ='STM AP' THEN" ).append("\n"); 
		query.append("           DECODE(SOH.OFC_CURR_CD, 'JPY','',DECODE(NVL(SODT.ACCT_DR_AMT,0),0,SODT.ACCT_CR_AMT,SODT.ACCT_DR_AMT)) " ).append("\n"); 
		query.append("      END AS locl_amt" ).append("\n"); 
		query.append("      /* 20150119" ).append("\n"); 
		query.append("     , DECODE(NVL(SODT.INP_DR_AMT,0),0,SODT.INP_CR_AMT,SODT.INP_DR_AMT)AS doc_amt */" ).append("\n"); 
		query.append("     --20150205 wskim format mask 기준 currency 변경" ).append("\n"); 
		query.append("     --, TO_NUMBER(SAR_GET_CUR_AMT_FNC(SODT.CURR_CD, ABS(NVL(SODT.INP_DR_AMT, 0) - NVL(SODT.INP_CR_AMT, 0)) * SOD.LOCL_XCH_RT)) AS doc_amt" ).append("\n"); 
		query.append("     -- 20150716 STM AR인 경우 SAKURA I/F 위한 GL 컬럼으로 변경" ).append("\n"); 
		query.append("     ,CASE" ).append("\n"); 
		query.append("         WHEN SOHI.OTS_SRC_CD ='STM AR' THEN" ).append("\n"); 
		query.append("           TO_NUMBER(SAR_GET_CUR_AMT_FNC(SOH.OFC_CURR_CD, ABS(NVL(SODT.GL_INP_DR_AMT, 0) - NVL(SODT.GL_INP_CR_AMT, 0)) * SOD.LOCL_XCH_RT)) " ).append("\n"); 
		query.append("         WHEN SOHI.OTS_SRC_CD ='STM AP' THEN   " ).append("\n"); 
		query.append("           TO_NUMBER(SAR_GET_CUR_AMT_FNC(SOH.OFC_CURR_CD, ABS(NVL(SODT.INP_DR_AMT, 0) - NVL(SODT.INP_CR_AMT, 0)) * SOD.LOCL_XCH_RT)) " ).append("\n"); 
		query.append("     END AS doc_amt" ).append("\n"); 
		query.append("     ,'' AS locl_tax_amt     " ).append("\n"); 
		query.append("     ,'' AS doc_tax_amt" ).append("\n"); 
		query.append("     , SOH.BL_NO AS asgn_no" ).append("\n"); 
		query.append("     , '' AS itm_desc" ).append("\n"); 
		query.append("     , '' AS pln_dt" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     /* 20150102" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'EXCH_GAIN','TBD-A101'," ).append("\n"); 
		query.append("                                'EXCH_LOSS','TBD-A101'," ).append("\n"); 
		query.append("                                'HDR_RND','TBD-A101','') AS cost_ctr_cd -- 향후  MDA svc_scp 에서 profit_center_code 가져옴 */" ).append("\n"); 
		query.append("     --20150408 OTS_History의 svc_scp_cd로 변환값 찾도록 변경                            " ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'EXCH_GAIN'," ).append("\n"); 
		query.append("                                (SELECT MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                 FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("                                 WHERE SVC_SCP_CD =SOHI.SVC_SCP_CD)," ).append("\n"); 
		query.append("                                'EXCH_LOSS'," ).append("\n"); 
		query.append("                                (SELECT MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                 FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("                                 WHERE SVC_SCP_CD =SOHI.SVC_SCP_CD)," ).append("\n"); 
		query.append("                                'HDR_RND'," ).append("\n"); 
		query.append("                                (SELECT MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                 FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("                                 WHERE SVC_SCP_CD =SOHI.SVC_SCP_CD),'') AS cost_ctr_cd                          " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append("     ,'' AS ord_no" ).append("\n"); 
		query.append("     ,'' AS mn_aset_no" ).append("\n"); 
		query.append("     ,'' AS sub_aset_no" ).append("\n"); 
		query.append("     ,'' AS aset_tj_tp_cd" ).append("\n"); 
		query.append("     ,'' AS aset_val_dt" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'EXCH_GAIN','8225101000'," ).append("\n"); 
		query.append("                                'EXCH_LOSS','8325401000'," ).append("\n"); 
		query.append("                                --20150130 wskim HDR_RND 7001000000 " ).append("\n"); 
		query.append("                                --'HDR_RND',DECODE(SIGN(SOC.INV_AMT),1,'8225101000',-1,'8325401000'),'') AS gl_acct_no " ).append("\n"); 
		query.append("                                'HDR_RND','7001000000','') AS gl_acct_no" ).append("\n"); 
		query.append("      /*20150122*/" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REC'," ).append("\n"); 
		query.append("                                (SELECT MODI_AGN_CD" ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                  WHERE MO.OFC_CD=SOH.CLT_OFC_CD" ).append("\n"); 
		query.append("                                  AND rownum=1)," ).append("\n"); 
		query.append("                                  'REV'," ).append("\n"); 
		query.append("                                 (SELECT MODI_AGN_CD" ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                  WHERE MO.OFC_CD=SOH.CLT_OFC_CD" ).append("\n"); 
		query.append("                                  AND rownum=1),'') AS cust_no " ).append("\n"); 
		query.append("     ,'' AS vndr_crtr_acct_no" ).append("\n"); 
		query.append("      --20150302 wskim 로직변경. v2.0" ).append("\n"); 
		query.append("     ,CASE " ).append("\n"); 
		query.append("          WHEN SODT.ACCT_CLSS_CD IN ('REC', 'REV') THEN" ).append("\n"); 
		query.append("              SOH.DUE_DT" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("              ''" ).append("\n"); 
		query.append("      END    AS due_dt_calc_bsel_dt" ).append("\n"); 
		query.append("     ,'' AS pay_mzd_cd" ).append("\n"); 
		query.append("     ,'' AS ste_cntrl_bank_ind_cd" ).append("\n"); 
		query.append("     ,'' AS mtrl_no" ).append("\n"); 
		query.append("     ,'' AS fuel_land_qty" ).append("\n"); 
		query.append("     ,'' AS meas_bse_ut_cd" ).append("\n"); 
		query.append("     /* 20150102" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'EXCH_GAIN','TBD-A101'," ).append("\n"); 
		query.append("                                'EXCH_LOSS','TBD-A101'," ).append("\n"); 
		query.append("                                'HDR_RND','TBD-A101','') AS pfitctr_cd -- 향후  MDA_svc_scp 에서 profit_center_code 가져옴 */" ).append("\n"); 
		query.append("     --20150408 OTS_History의 svc_scp_cd로 변환값 찾도록 변경" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'EXCH_GAIN'," ).append("\n"); 
		query.append("                                (SELECT MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                 FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("                                 WHERE SVC_SCP_CD =SOHI.SVC_SCP_CD)," ).append("\n"); 
		query.append("                                'EXCH_LOSS'," ).append("\n"); 
		query.append("                                (SELECT MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                 FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("                                 WHERE SVC_SCP_CD =SOHI.SVC_SCP_CD)," ).append("\n"); 
		query.append("                                'HDR_RND'," ).append("\n"); 
		query.append("                                (SELECT MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                 FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("                                 WHERE SVC_SCP_CD =SOHI.SVC_SCP_CD),'') AS pfitctr_cd                          " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REC', '5360000000','REV','5360000000','') AS altn_acct_no " ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REC', 'A106','REV','A106','') AS biz_prnr_ref_key_cd1 " ).append("\n"); 
		query.append("     ,'' AS biz_prnr_ref_key_cd2" ).append("\n"); 
		query.append("     ,'' AS line_itm_ref_key_cd" ).append("\n"); 
		query.append("     ,'' AS instr_key_cd1" ).append("\n"); 
		query.append("     ,'' AS instr_key_cd2" ).append("\n"); 
		query.append("     ,'' AS instr_key_cd3" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REC', '42','REV','41','') AS pay_ref_cd" ).append("\n"); 
		query.append("     , '' AS automtc_pay_curr_cd" ).append("\n"); 
		query.append("     , '' AS pay_curr_amt" ).append("\n"); 
		query.append("     /*20150121" ).append("\n"); 
		query.append("     , (SELECT MODI_VNDR_CD" ).append("\n"); 
		query.append("        FROM MDM_VENDOR MV, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE MV.VNDR_SEQ = MO.Vndr_Seq" ).append("\n"); 
		query.append("        AND MO.OFC_CD=SOH.CLT_OFC_CD" ).append("\n"); 
		query.append("        AND rownum=1) AS ctrt_no */" ).append("\n"); 
		query.append("    , (SELECT MODI_AGN_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE MO.OFC_CD=SOH.CLT_OFC_CD" ).append("\n"); 
		query.append("        AND rownum=1) AS ctrt_no" ).append("\n"); 
		query.append("     ,'Z' AS ctrt_tp_cd" ).append("\n"); 
		query.append("     ,'' AS pay_rsn_cd" ).append("\n"); 
		query.append("     ,'' AS clss_cd" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REV','','REC',''," ).append("\n"); 
		query.append("             (SELECT ML.MODI_LOC_CD" ).append("\n"); 
		query.append("               FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("              WHERE ML.LOC_CD = (SELECT LOC_CD " ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                 WHERE OFC_CD = 'SOH.CLT_OFC_CD')" ).append("\n"); 
		query.append("              )) AS act_plc_cd " ).append("\n"); 
		query.append("     ,'' AS entr_expn_id" ).append("\n"); 
		query.append("     ,'' AS bud_mgmt_div_cd" ).append("\n"); 
		query.append("     , DECODE(SODT.ACCT_CLSS_CD,'REV', '','REC','',TO_CHAR(SOHI.IF_DT,'YYYYMMDD')) AS act_dt" ).append("\n"); 
		query.append("     ,'' AS vsl_cd " ).append("\n"); 
		query.append("     ,'' AS vvl_Cd " ).append("\n"); 
		query.append("     ,'' AS hus_bank_id" ).append("\n"); 
		query.append("     ,'' AS pay_blck_key_cd" ).append("\n"); 
		query.append("     ,SODT.OTS_DTRB_SEQ	" ).append("\n"); 
		query.append("     --20141229 wskim Accrual 요청 추가 시작" ).append("\n"); 
		query.append("     ,SOH.POL_CD AS N1ST_LODG_PORT_CD" ).append("\n"); 
		query.append("     ,(SELECT VVP.VPS_ETD_DT" ).append("\n"); 
		query.append("       FROM   VSK_VSL_PORT_SKD VVP" ).append("\n"); 
		query.append("       WHERE  VSL_CD      = SUBSTR(SOH.TRNK_VVD_CD,1,4)" ).append("\n"); 
		query.append("       AND    SKD_VOY_NO  = SUBSTR(SOH.TRNK_VVD_CD, 5, 4) " ).append("\n"); 
		query.append("       AND    SKD_DIR_CD  = SUBSTR(SOH.TRNK_VVD_CD, 9, 1) " ).append("\n"); 
		query.append("       AND    VPS_PORT_CD = SOH.POL_CD)  AS N1ST_LODG_PORT_ETD_DT " ).append("\n"); 
		query.append("     ,SOH.POD_CD AS LST_DCHG_PORT_CD " ).append("\n"); 
		query.append("      /*20150123*/" ).append("\n"); 
		query.append("     ,(SELECT VVP.VPS_ETA_DT" ).append("\n"); 
		query.append("       FROM   VSK_VSL_PORT_SKD VVP" ).append("\n"); 
		query.append("       WHERE  VSL_CD      = SUBSTR(SOH.TRNK_VVD_CD,1,4)" ).append("\n"); 
		query.append("       AND    SKD_VOY_NO  = SUBSTR(SOH.TRNK_VVD_CD, 5, 4) " ).append("\n"); 
		query.append("       AND    SKD_DIR_CD  = SUBSTR(SOH.TRNK_VVD_CD, 9, 1) " ).append("\n"); 
		query.append("       AND    VPS_PORT_CD = SOH.POD_CD)  AS LST_DCHG_PORT_ETA_DT" ).append("\n"); 
		query.append("     , (SELECT MDR.TRD_CD" ).append("\n"); 
		query.append("       FROM   AR_MST_REV_VVD AMR," ).append("\n"); 
		query.append("              MDM_DTL_REV_LANE MDR " ).append("\n"); 
		query.append("       WHERE  AMR.RLANE_CD = MDR.RLANE_CD" ).append("\n"); 
		query.append("       AND    AMR.VSL_CD||AMR.SKD_VOY_NO||AMR.SKD_DIR_CD||AMR.RLANE_DIR_CD = SOHI.REV_VVD_CD " ).append("\n"); 
		query.append("       AND    MDR.VSL_SLAN_DIR_CD = SUBSTR(SOHI.REV_VVD_CD, 9, 1)" ).append("\n"); 
		query.append("       AND    MDR.FM_CONTI_CD = (SELECT CONTI_CD  " ).append("\n"); 
		query.append("                                 FROM   MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE  LOC_CD = SOHI.POL_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("       AND    MDR.TO_CONTI_CD = (SELECT CONTI_CD  " ).append("\n"); 
		query.append("                                 FROM   MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE  LOC_CD = SOHI.POD_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("       )   AS TRD_CD" ).append("\n"); 
		query.append("     , SOH.TRNK_VVD_CD   AS TRNK_VVD_CD" ).append("\n"); 
		query.append("     --20141229 wskim Accrual 요청 추가 끝" ).append("\n"); 
		query.append("     ,SODT.ACCT_CLSS_CD AS REC_TP_CD  -- 20150129 추가 SAR_AR_IF(REC_TP_CD)에 넣어주세요" ).append("\n"); 
		query.append("     --20150224 wskim Accrual 요청. ASA Flag 추가. SAR_AR_IF.ASA_FLG에 Insert" ).append("\n"); 
		query.append("     ,'Y' AS ASA_FLG" ).append("\n"); 
		query.append("     ,SODT.CRE_USR_ID" ).append("\n"); 
		query.append("	 ,SODT.UPD_USR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   FROM SAR_OTS_HDR SOH" ).append("\n"); 
		query.append("     , SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("     , SAR_OTS_CHG SOC" ).append("\n"); 
		query.append("     , SAR_OTS_HIS SOHI" ).append("\n"); 
		query.append("     , SAR_OTS_DTRB SODT" ).append("\n"); 
		query.append("     , (SELECT SLD.LU_CD CURR_CD" ).append("\n"); 
		query.append("          FROM SCO_LU_HDR SLH" ).append("\n"); 
		query.append("             ,SCO_LU_DTL SLD" ).append("\n"); 
		query.append("         WHERE SLH.LU_APPL_CD ='SCO'" ).append("\n"); 
		query.append("           AND SLH.LU_TP_CD ='FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("           AND SLH.LU_TP_CD = SLD.LU_TP_CD) FC" ).append("\n"); 
		query.append(" WHERE SOH.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("   AND SOH.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOH.BL_NO = SOD.BL_NO" ).append("\n"); 
		query.append("   AND SOH.INV_NO = SOD.INV_NO" ).append("\n"); 
		query.append("   AND SOD.RHQ_CD = SOC.RHQ_CD" ).append("\n"); 
		query.append("   AND SOD.OTS_OFC_CD = SOC.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOD.BL_NO = SOC.BL_NO" ).append("\n"); 
		query.append("   AND SOD.INV_NO = SOC.INV_NO" ).append("\n"); 
		query.append("   --20150206 wskim chg_tp_cd 조건 추가" ).append("\n"); 
		query.append("   AND SOD.CHG_TP_CD = SOC.CHG_TP_CD   " ).append("\n"); 
		query.append("   AND SOD.BL_CURR_CD = SOC.BL_CURR_CD      " ).append("\n"); 
		query.append("   AND SOC.RHQ_CD = SOHI.RHQ_CD" ).append("\n"); 
		query.append("   AND SOC.OTS_OFC_CD = SOHI.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOC.BL_NO = SOHI.BL_NO" ).append("\n"); 
		query.append("   AND SOC.INV_NO = SOHI.INV_NO" ).append("\n"); 
		query.append("   AND SOHI.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("   AND SOC.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("   --20150206 wskim chg_tp_cd 조건 추가" ).append("\n"); 
		query.append("   AND SOC.CHG_TP_CD = SODT.CHG_TP_CD   " ).append("\n"); 
		query.append("   AND SOD.BL_CURR_CD = SODT.CURR_CD /*20150119 추가 */" ).append("\n"); 
		query.append("   --20150206 wskim chg_tp_cd 조건 추가" ).append("\n"); 
		query.append("   AND SOC.INV_AMT <> 0" ).append("\n"); 
		query.append("   --20150213 wskim AGT -> ASA 로 변경" ).append("\n"); 
		query.append("   AND SOHI.REV_TP_SRC_CD = 'ASA'" ).append("\n"); 
		query.append("   AND (NVL(SODT.GL_INP_DR_AMT,0)+NVL(SODT.GL_INP_CR_AMT,0) + NVL(SODT.GL_ACCT_DR_AMT,0)+NVL(SODT.GL_ACCT_CR_AMT,0) ) <>0" ).append("\n"); 
		query.append("   #if (${check_if_no} != '' )" ).append("\n"); 
		query.append("   AND SOHI.IF_NO IN (" ).append("\n"); 
		query.append("		#foreach( $key IN ${check_if_nos}) " ).append("\n"); 
		query.append(" 			#if($velocityCount < $check_if_nos.size())" ).append("\n"); 
		query.append("    			'$key'," ).append("\n"); 
		query.append(" 			#else" ).append("\n"); 
		query.append("  				'$key'" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND SODT.AR_IF_STS_CD = @[check_status]" ).append("\n"); 
		query.append("#if (${grp_yn} == 'Y' )" ).append("\n"); 
		query.append(") GROUP BY" ).append("\n"); 
		query.append(" ACCT_CO_CD" ).append("\n"); 
		query.append(",IF_DOC_TP_CD" ).append("\n"); 
		query.append(",DOC_DT" ).append("\n"); 
		query.append(",PST_DT" ).append("\n"); 
		query.append(",REF_DOC_NO" ).append("\n"); 
		query.append(",DOC_HDR_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TAX_CALC_AUTO_FLG" ).append("\n"); 
		query.append(",PST_KEY_CD" ).append("\n"); 
		query.append(",VAT_TAX_CD" ).append("\n"); 
		query.append(",ASGN_NO" ).append("\n"); 
		query.append(",ITM_DESC" ).append("\n"); 
		query.append(",PLN_DT" ).append("\n"); 
		query.append(",COST_CTR_CD" ).append("\n"); 
		query.append(",ORD_NO" ).append("\n"); 
		query.append(",MN_ASET_NO" ).append("\n"); 
		query.append(",SUB_ASET_NO" ).append("\n"); 
		query.append(",ASET_TJ_TP_CD" ).append("\n"); 
		query.append(",ASET_VAL_DT" ).append("\n"); 
		query.append(",GL_ACCT_NO" ).append("\n"); 
		query.append(",CUST_NO" ).append("\n"); 
		query.append(",VNDR_CRTR_ACCT_NO" ).append("\n"); 
		query.append(",DUE_DT_CALC_BSEL_DT" ).append("\n"); 
		query.append(",PAY_MZD_CD" ).append("\n"); 
		query.append(",STE_CNTRL_BANK_IND_CD" ).append("\n"); 
		query.append(",MTRL_NO" ).append("\n"); 
		query.append(",FUEL_LAND_QTY" ).append("\n"); 
		query.append(",MEAS_BSE_UT_CD" ).append("\n"); 
		query.append(",PFITCTR_CD" ).append("\n"); 
		query.append(",ALTN_ACCT_NO" ).append("\n"); 
		query.append(",BIZ_PRNR_REF_KEY_CD1" ).append("\n"); 
		query.append(",BIZ_PRNR_REF_KEY_CD2" ).append("\n"); 
		query.append(",LINE_ITM_REF_KEY_CD" ).append("\n"); 
		query.append(",INSTR_KEY_CD1" ).append("\n"); 
		query.append(",INSTR_KEY_CD2" ).append("\n"); 
		query.append(",INSTR_KEY_CD3" ).append("\n"); 
		query.append(",PAY_REF_CD" ).append("\n"); 
		query.append(",AUTOMTC_PAY_CURR_CD" ).append("\n"); 
		query.append(",PAY_CURR_AMT" ).append("\n"); 
		query.append(",CTRT_NO" ).append("\n"); 
		query.append(",CTRT_TP_CD" ).append("\n"); 
		query.append(",PAY_RSN_CD" ).append("\n"); 
		query.append(",CLSS_CD" ).append("\n"); 
		query.append(",ACT_PLC_CD" ).append("\n"); 
		query.append(",ENTR_EXPN_ID" ).append("\n"); 
		query.append(",BUD_MGMT_DIV_CD" ).append("\n"); 
		query.append(",ACT_DT" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",VVL_CD" ).append("\n"); 
		query.append(",HUS_BANK_ID" ).append("\n"); 
		query.append(",PAY_BLCK_KEY_CD" ).append("\n"); 
		query.append(",REC_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}