/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableCollectIFDBDAOsearchIFSakuraOffsetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCollectIFDBDAOsearchIFSakuraOffsetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIFSakuraOffsetList
	  * </pre>
	  */
	public AccountReceivableCollectIFDBDAOsearchIFSakuraOffsetListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_offst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration").append("\n"); 
		query.append("FileName : AccountReceivableCollectIFDBDAOsearchIFSakuraOffsetListRSQL").append("\n"); 
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
		query.append("#if (${ar_offst_no} == '' )" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       SAH.ADJ_NO AS ref_doc_no" ).append("\n"); 
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
		query.append("	NULL N1ST_LODG_PORT_CD," ).append("\n"); 
		query.append("	NULL N1ST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("	NULL LST_DCHG_PORT_CD," ).append("\n"); 
		query.append("	NULL LST_DCHG_PORT_ETA_DT," ).append("\n"); 
		query.append("	NULL TRD_CD," ).append("\n"); 
		query.append("	NULL TRNK_VVD_CD," ).append("\n"); 
		query.append("	REC_TP_CD," ).append("\n"); 
		query.append("	NULL SLAN_CD," ).append("\n"); 
		query.append("	NULL BKG_QTY," ).append("\n"); 
		query.append("	NULL ASA_FLG, " ).append("\n"); 
		query.append("	RVS_FLG," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("         null AS if_seq_no" ).append("\n"); 
		query.append("       , '' AS rec_id" ).append("\n"); 
		query.append("       , '1000' AS acct_co_cd" ).append("\n"); 
		query.append("       , DECODE( SUBSTR(MO.LOC_CD, 1,2), 'JP','U4','H4') AS if_doc_tp_Cd " ).append("\n"); 
		query.append("       , SAH.ADJ_APLY_DT AS doc_dt" ).append("\n"); 
		query.append("       , SAH.ADJ_GL_DT  AS pst_dt" ).append("\n"); 
		query.append("       , REPLACE(SAH.ADJ_NO,'OFF') AS ref_doc_no" ).append("\n"); 
		query.append("       , NULL    AS doc_hdr_cd" ).append("\n"); 
		query.append("       --20150424 OFFST_CURR_CD 로 변경" ).append("\n"); 
		query.append("       , SOM.OFFST_CURR_CD AS curr_cd      " ).append("\n"); 
		query.append("       ,'' AS tax_calc_auto_flg" ).append("\n"); 
		query.append("       , CASE" ).append("\n"); 
		query.append("             WHEN SCD.DTRB_SRC_TP_CD = 'REC' THEN" ).append("\n"); 
		query.append("                 DECODE(NVL(SCD.GL_ACCT_DR_AMT, 0), 0, '11', '01')" ).append("\n"); 
		query.append("             WHEN SCD.DTRB_SRC_TP_CD = 'ADJ' THEN" ).append("\n"); 
		query.append("                 DECODE(NVL(SCD.GL_ACCT_DR_AMT, 0), 0, '50', '40')                 " ).append("\n"); 
		query.append("             WHEN SCD.DTRB_SRC_TP_CD IN ('EXCH_GAIN', 'EXCH_LOSS', 'HDR_RND') THEN" ).append("\n"); 
		query.append("                 DECODE(NVL(SCD.GL_ACCT_DR_AMT, 0), 0, '50', '40')" ).append("\n"); 
		query.append("         END            AS pst_key_cd    --9           " ).append("\n"); 
		query.append("       , CASE" ).append("\n"); 
		query.append("             WHEN SCD.DTRB_SRC_TP_CD = 'HDR_RND' THEN" ).append("\n"); 
		query.append("              DECODE( SUBSTR(MO.FINC_RGN_CD, 1,2), '11','B0','D0')  " ).append("\n"); 
		query.append("         END  AS vat_tax_cd  --10" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("       --20150424 Offset currency JPY 이면 Space, 아니면 accoouted amount" ).append("\n"); 
		query.append("       --, DECODE(SCD.CURR_CD, FC.CURR_CD,'',DECODE(NVL(SCD.GL_ACCT_DR_AMT,0),0,SCD.GL_ACCT_CR_AMT,SCD.GL_ACCT_DR_AMT)) AS locl_amt" ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("             WHEN SOM.OFFST_CURR_CD = FC.CURR_CD THEN" ).append("\n"); 
		query.append("                  NULL" ).append("\n"); 
		query.append("             ELSE" ).append("\n"); 
		query.append("                  ABS(NVL(SCD.GL_ACCT_DR_AMT, 0) - NVL(SCD.GL_ACCT_CR_AMT, 0))" ).append("\n"); 
		query.append("             END AS locl_amt   " ).append("\n"); 
		query.append("       -- 20150429 JPY의 경우 Entered  기준으로 해준다. AP와 환차 생기지 않게하기 위해서" ).append("\n"); 
		query.append("       -- 20150520 case문 삭제" ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("             WHEN SOM.OFFST_CURR_CD = FC.CURR_CD THEN" ).append("\n"); 
		query.append("                 ABS(NVL(SCD.GL_ACCT_DR_AMT, 0) - NVL(SCD.GL_ACCT_CR_AMT, 0))" ).append("\n"); 
		query.append("             ELSE" ).append("\n"); 
		query.append("                 ABS(NVL(SCD.GL_INP_DR_AMT, 0) - NVL(SCD.GL_INP_CR_AMT, 0)) " ).append("\n"); 
		query.append("           END AS doc_amt " ).append("\n"); 
		query.append("       ,'' AS locl_tax_amt" ).append("\n"); 
		query.append("       ,'' AS doc_tax_amt" ).append("\n"); 
		query.append("       --20160314  Migration시 ORG_INV_NO 송부" ).append("\n"); 
		query.append("       --, SUBSTR(DECODE(SCD.DTRB_SRC_TP_CD,'REC',SOC.BL_NO, REPLACE(SAH.ADJ_NO,'OFF')),1,18)  AS asgn_no -- 길이초과 19 max 18 DEV" ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("          WHEN SCD.DTRB_SRC_TP_CD  = 'REC' THEN" ).append("\n"); 
		query.append("               NVL(SOH.ORG_INV_NO, SOC.BL_NO)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("               SUBSTR(REPLACE(SAH.ADJ_NO,'OFF'),1,18)" ).append("\n"); 
		query.append("          END AS asgn_no        " ).append("\n"); 
		query.append("       --20160314" ).append("\n"); 
		query.append("       , DECODE(SCD.DTRB_SRC_TP_CD,'REC', SOM.OFC_CD||':'" ).append("\n"); 
		query.append("                                                    ||(SELECT USR_NM " ).append("\n"); 
		query.append("                                                        FROM COM_USER" ).append("\n"); 
		query.append("                                                        WHERE USR_ID = SOM.CRE_USR_ID),'') AS itm_desc" ).append("\n"); 
		query.append("       , DECODE(SCD.DTRB_SRC_TP_CD,'REC', SOH.SAIL_DT ,'') AS pln_dt   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      -- 20160401 'OTH'인 경우 SCO-SAKURA Code Conversion " ).append("\n"); 
		query.append("      , CASE" ).append("\n"); 
		query.append("           WHEN SCD.DTRB_SRC_TP_CD in ('ADJ','REC') THEN " ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("                 NVL(DECODE(SOHI.SVC_SCP_CD, 'OTH', NULL," ).append("\n"); 
		query.append("                       (SELECT MSS.MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                        FROM   MDM_SVC_SCP MSS" ).append("\n"); 
		query.append("                        WHERE  MSS.SVC_SCP_CD =SOHI.SVC_SCP_CD)), " ).append("\n"); 
		query.append("                        NVL(DECODE((SELECT SSCC.TGT_CD " ).append("\n"); 
		query.append("                                    FROM   SCO_STMT_CD_CONV SSCC " ).append("\n"); 
		query.append("                                    WHERE  SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                    AND    SSCC.SRC_CD = (SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                          FROM  MDM_ACCOUNT MA                          " ).append("\n"); 
		query.append("                                                          WHERE MA.ACCT_CD = (SELECT SGM_CTNT4 from SCO_LEGR_CD_CMB where CD_CMB_SEQ =SCD.DTRB_CD_CMB_SEQ))" ).append("\n"); 
		query.append("                                    AND    SSCC.USE_FLG = 'Y' " ).append("\n"); 
		query.append("                                    AND    SSCC.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                    AND ROWNUM = 1), 'ZH',(SELECT  MO.MODI_COST_CTR_CD" ).append("\n"); 
		query.append("                                                           FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                                           WHERE MO.Ofc_Cd= SOH.CLT_OFC_CD)," ).append("\n"); 
		query.append("                                                          (SELECT SSCC.TGT_CD " ).append("\n"); 
		query.append("                                                           FROM   SCO_STMT_CD_CONV SSCC " ).append("\n"); 
		query.append("                                                           WHERE  SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                           AND    SSCC.SRC_CD = ( SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                                                  FROM  MDM_ACCOUNT MA                          " ).append("\n"); 
		query.append("                                                                                  WHERE MA.ACCT_CD = (SELECT SGM_CTNT4 from SCO_LEGR_CD_CMB where CD_CMB_SEQ =SCD.DTRB_CD_CMB_SEQ))" ).append("\n"); 
		query.append("                                                           AND SSCC.USE_FLG = 'Y' " ).append("\n"); 
		query.append("                                                           AND SSCC.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                                           AND ROWNUM = 1)), 'A106')) " ).append("\n"); 
		query.append("       END cost_ctr_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,'' AS ord_no" ).append("\n"); 
		query.append("       ,'' AS mn_aset_no" ).append("\n"); 
		query.append("       ,'' AS sub_aset_no" ).append("\n"); 
		query.append("       ,'' AS aset_tj_tp_cd" ).append("\n"); 
		query.append("       ,'' AS aset_val_dt" ).append("\n"); 
		query.append("       , DECODE(SCD.DTRB_SRC_TP_CD,'ADJ','5400269051'                              " ).append("\n"); 
		query.append("                                  ,'REC', '','HDR_RND','7001000000', " ).append("\n"); 
		query.append("                                  'EXCH_GAIN', '8225101000', 'EXCH_LOSS', '8325401000', '' ) AS gl_acct_no" ).append("\n"); 
		query.append("       --20160518 Migration Customer" ).append("\n"); 
		query.append("       ,CASE" ).append("\n"); 
		query.append("           WHEN SCD.DTRB_SRC_TP_CD ='REC' THEN" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                    WHEN SCD.CUST_CNT_CD ='TB' THEN" ).append("\n"); 
		query.append("                          (SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("                            FROM  MDM_VENDOR MV ," ).append("\n"); 
		query.append("                                  MDM_ORGANIZATION MO ," ).append("\n"); 
		query.append("                                  MDM_LOCATION ML" ).append("\n"); 
		query.append("                            WHERE  MV.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("                            AND    MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                            AND    MV.RFND_PSDO_CUST_CD = SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000')))" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        CASE " ).append("\n"); 
		query.append("                           WHEN (SOH.ORG_INV_NO is not null) THEN" ).append("\n"); 
		query.append("                               ( SELECT MC1.MODI_CUST_CD" ).append("\n"); 
		query.append("                                FROM MDM_CUSTOMER MC1 " ).append("\n"); 
		query.append("                                WHERE MC1.CUST_CNT_CD = SCD.CUST_CNT_CD" ).append("\n"); 
		query.append("                                AND MC1.CUST_SEQ = SCD.CUST_SEQ )" ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                            'G1'||SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000'))" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                 END                        " ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("               '' " ).append("\n"); 
		query.append("       END cust_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,'' AS vndr_crtr_acct_no" ).append("\n"); 
		query.append("       ,DECODE(SCD.DTRB_SRC_TP_CD,'REC', SOH.Due_Dt, '') AS due_dt_calc_bsel_dt" ).append("\n"); 
		query.append("       ,DECODE(SCD.DTRB_SRC_TP_CD,'REC','2','') AS pay_mzd_cd" ).append("\n"); 
		query.append("       ,'' AS ste_cntrl_bank_ind_cd" ).append("\n"); 
		query.append("       ,'' AS mtrl_no" ).append("\n"); 
		query.append("       ,'' AS fuel_land_qty" ).append("\n"); 
		query.append("       ,'' AS meas_bse_ut_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       -- 20160401 'OTH'인 경우 SCO-SAKURA Code Conversion" ).append("\n"); 
		query.append("       , CASE" ).append("\n"); 
		query.append("           WHEN SCD.DTRB_SRC_TP_CD ='ADJ' THEN " ).append("\n"); 
		query.append("                'A106'" ).append("\n"); 
		query.append("           WHEN SCD.DTRB_SRC_TP_CD ='REC' THEN " ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("                NVL(DECODE(SOHI.SVC_SCP_CD, 'OTH', NULL," ).append("\n"); 
		query.append("                       (SELECT MSS.MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                        FROM   MDM_SVC_SCP MSS" ).append("\n"); 
		query.append("                        WHERE  MSS.SVC_SCP_CD =SOHI.SVC_SCP_CD)), " ).append("\n"); 
		query.append("                        NVL(DECODE((SELECT SSCC.TGT_CD " ).append("\n"); 
		query.append("                                    FROM   SCO_STMT_CD_CONV SSCC " ).append("\n"); 
		query.append("                                    WHERE  SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                    AND    SSCC.SRC_CD = (SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                          FROM  MDM_ACCOUNT MA                          " ).append("\n"); 
		query.append("                                                          WHERE MA.ACCT_CD = (SELECT SGM_CTNT4 from SCO_LEGR_CD_CMB where CD_CMB_SEQ =SCD.DTRB_CD_CMB_SEQ))" ).append("\n"); 
		query.append("                                    AND    SSCC.USE_FLG = 'Y' " ).append("\n"); 
		query.append("                                    AND    SSCC.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                    AND ROWNUM = 1), 'ZH',(SELECT  MO.MODI_COST_CTR_CD" ).append("\n"); 
		query.append("                                                           FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                                           WHERE MO.Ofc_Cd= SOH.CLT_OFC_CD)," ).append("\n"); 
		query.append("                                                          (SELECT SSCC.TGT_CD " ).append("\n"); 
		query.append("                                                           FROM   SCO_STMT_CD_CONV SSCC " ).append("\n"); 
		query.append("                                                           WHERE  SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                           AND    SSCC.SRC_CD = ( SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                                                  FROM  MDM_ACCOUNT MA                          " ).append("\n"); 
		query.append("                                                                                  WHERE MA.ACCT_CD = (SELECT SGM_CTNT4 from SCO_LEGR_CD_CMB where CD_CMB_SEQ =SCD.DTRB_CD_CMB_SEQ))" ).append("\n"); 
		query.append("                                                           AND SSCC.USE_FLG = 'Y' " ).append("\n"); 
		query.append("                                                           AND SSCC.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                                           AND ROWNUM = 1)), 'A106')) " ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("           END pfitctr_cd " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , DECODE(SCD.DTRB_SRC_TP_CD,'REC'," ).append("\n"); 
		query.append("                                 (SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                  FROM  MDM_ACCOUNT MA                          " ).append("\n"); 
		query.append("                                  WHERE MA.ACCT_CD = (SELECT SGM_CTNT4 from SCO_LEGR_CD_CMB where CD_CMB_SEQ =SCD.DTRB_CD_CMB_SEQ)),'') AS altn_acct_no " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -- 20160401 'OTH'인 경우 SCO-SAKURA Code Conversion " ).append("\n"); 
		query.append("       , CASE" ).append("\n"); 
		query.append("           WHEN SCD.DTRB_SRC_TP_CD ='REC' THEN " ).append("\n"); 
		query.append("                NVL(DECODE(SOHI.SVC_SCP_CD, 'OTH', NULL," ).append("\n"); 
		query.append("                       (SELECT MSS.MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                        FROM   MDM_SVC_SCP MSS" ).append("\n"); 
		query.append("                        WHERE  MSS.SVC_SCP_CD =SOHI.SVC_SCP_CD)), " ).append("\n"); 
		query.append("                        NVL(DECODE((SELECT SSCC.TGT_CD " ).append("\n"); 
		query.append("                                    FROM   SCO_STMT_CD_CONV SSCC " ).append("\n"); 
		query.append("                                    WHERE  SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                    AND    SSCC.SRC_CD = (SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                          FROM  MDM_ACCOUNT MA                          " ).append("\n"); 
		query.append("                                                          WHERE MA.ACCT_CD = (SELECT SGM_CTNT4 from SCO_LEGR_CD_CMB where CD_CMB_SEQ =SCD.DTRB_CD_CMB_SEQ))" ).append("\n"); 
		query.append("                                    AND    SSCC.USE_FLG = 'Y' " ).append("\n"); 
		query.append("                                    AND    SSCC.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                    AND ROWNUM = 1), 'ZH',(SELECT  MO.MODI_COST_CTR_CD" ).append("\n"); 
		query.append("                                                           FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                                           WHERE MO.Ofc_Cd= SOH.CLT_OFC_CD)," ).append("\n"); 
		query.append("                                                          (SELECT SSCC.TGT_CD " ).append("\n"); 
		query.append("                                                           FROM   SCO_STMT_CD_CONV SSCC " ).append("\n"); 
		query.append("                                                           WHERE  SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                           AND    SSCC.SRC_CD = ( SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                                                  FROM  MDM_ACCOUNT MA                          " ).append("\n"); 
		query.append("                                                                                  WHERE MA.ACCT_CD = (SELECT SGM_CTNT4 from SCO_LEGR_CD_CMB where CD_CMB_SEQ =SCD.DTRB_CD_CMB_SEQ))" ).append("\n"); 
		query.append("                                                           AND SSCC.USE_FLG = 'Y' " ).append("\n"); 
		query.append("                                                           AND SSCC.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                                           AND ROWNUM = 1)), 'A106')) " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 '' " ).append("\n"); 
		query.append("           END biz_prnr_ref_key_cd1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , DECODE(SCD.DTRB_SRC_TP_CD,'REC',DECODE( SUBSTR(MO.FINC_RGN_CD, 1,2), '11'," ).append("\n"); 
		query.append("                                               (SELECT TGT_CD" ).append("\n"); 
		query.append("                                                FROM SCO_STMT_CD_CONV" ).append("\n"); 
		query.append("                                                WHERE CONV_TP_CD = 'CASHIER PLACE CODE'" ).append("\n"); 
		query.append("                                                AND SRC_CD =SOM.OFC_CD),'GT' ),'') AS biz_prnr_ref_key_cd2" ).append("\n"); 
		query.append("       ,'' AS line_itm_ref_key_cd" ).append("\n"); 
		query.append("       ,'' AS instr_key_cd1" ).append("\n"); 
		query.append("       ,'' AS instr_key_cd2" ).append("\n"); 
		query.append("       ,'' AS instr_key_cd3" ).append("\n"); 
		query.append("       ,'' AS pay_ref_cd" ).append("\n"); 
		query.append("       , '' AS automtc_pay_curr_cd" ).append("\n"); 
		query.append("       , '' AS pay_curr_amt" ).append("\n"); 
		query.append("       --20160518 Migration Customer Code Check" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("             WHEN (SOH.ORG_INV_NO is not null) THEN" ).append("\n"); 
		query.append("                  CASE " ).append("\n"); 
		query.append("                       WHEN SUBSTR(MO.LOC_CD, 1,2)= 'JP' THEN" ).append("\n"); 
		query.append("                           ( SELECT MC1.MODI_CUST_CD" ).append("\n"); 
		query.append("                            FROM MDM_CUSTOMER MC1 " ).append("\n"); 
		query.append("                            WHERE MC1.CUST_CNT_CD = SCD.CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND MC1.CUST_SEQ = SCD.CUST_SEQ )" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                           CASE " ).append("\n"); 
		query.append("                              WHEN (SCD.DTRB_SRC_TP_CD= 'REC')  THEN" ).append("\n"); 
		query.append("                                    (SELECT MODI_AGN_CD" ).append("\n"); 
		query.append("                                      FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                      WHERE MO.OFC_CD=SOM.OFC_CD" ).append("\n"); 
		query.append("                                      AND rownum=1)" ).append("\n"); 
		query.append("                               ELSE" ).append("\n"); 
		query.append("                                    ( SELECT MC1.MODI_CUST_CD" ).append("\n"); 
		query.append("                                    FROM MDM_CUSTOMER MC1 " ).append("\n"); 
		query.append("                                    WHERE MC1.CUST_CNT_CD = SCD.CUST_CNT_CD" ).append("\n"); 
		query.append("                                    AND MC1.CUST_SEQ = SCD.CUST_SEQ )" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("              ELSE" ).append("\n"); 
		query.append("                 DECODE(SUBSTR(MO.LOC_CD, 1,2), 'JP'," ).append("\n"); 
		query.append("                                                DECODE(SCD.CUST_CNT_CD,'TB', " ).append("\n"); 
		query.append("                                                             (SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("                                                              FROM  MDM_VENDOR MV ," ).append("\n"); 
		query.append("                                                                    MDM_ORGANIZATION MO ," ).append("\n"); 
		query.append("                                                                    MDM_LOCATION ML" ).append("\n"); 
		query.append("                                                              WHERE  MV.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("                                                              AND    MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                                                              AND    MV.RFND_PSDO_CUST_CD = SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000'))), 'G1'||SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000')))," ).append("\n"); 
		query.append("                  DECODE(SCD.DTRB_SRC_TP_CD,'ADJ', " ).append("\n"); 
		query.append("                                             DECODE(SCD.CUST_CNT_CD,'TB', " ).append("\n"); 
		query.append("                                                             (SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("                                                              FROM  MDM_VENDOR MV ," ).append("\n"); 
		query.append("                                                                    MDM_ORGANIZATION MO ," ).append("\n"); 
		query.append("                                                                    MDM_LOCATION ML" ).append("\n"); 
		query.append("                                                              WHERE  MV.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("                                                              AND    MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                                                              AND    MV.RFND_PSDO_CUST_CD = SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000'))), 'G1'||SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000')))," ).append("\n"); 
		query.append("                                            'REC',  (SELECT MODI_AGN_CD" ).append("\n"); 
		query.append("                                                    FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                                                    WHERE MO.OFC_CD=SOM.OFC_CD" ).append("\n"); 
		query.append("                                                    AND rownum=1)," ).append("\n"); 
		query.append("                                                    DECODE(SCD.CUST_CNT_CD,'TB', " ).append("\n"); 
		query.append("                                                             (SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("                                                              FROM  MDM_VENDOR MV ," ).append("\n"); 
		query.append("                                                                    MDM_ORGANIZATION MO ," ).append("\n"); 
		query.append("                                                                    MDM_LOCATION ML" ).append("\n"); 
		query.append("                                                              WHERE  MV.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("                                                              AND    MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                                                              AND    MV.RFND_PSDO_CUST_CD = SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000'))), 'G1'||SCD.CUST_CNT_CD||TRIM(TO_CHAR(SCD.CUST_SEQ,'000000'))))) " ).append("\n"); 
		query.append("        END AS ctrt_no " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , 'Z' AS ctrt_tp_cd" ).append("\n"); 
		query.append("       ,'' AS pay_rsn_cd" ).append("\n"); 
		query.append("       ,'' AS clss_cd" ).append("\n"); 
		query.append("       , DECODE(SCD.DTRB_SRC_TP_CD,'ADJ','','REC','', " ).append("\n"); 
		query.append("                (SELECT ML.MODI_LOC_CD" ).append("\n"); 
		query.append("                 FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("                 WHERE ML.LOC_CD = (SELECT LOC_CD " ).append("\n"); 
		query.append("                                     FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                     WHERE OFC_CD = SOH.CLT_OFC_CD)" ).append("\n"); 
		query.append("                  )) AS act_plc_cd " ).append("\n"); 
		query.append("       ,'' AS entr_expn_id" ).append("\n"); 
		query.append("       ,'' AS bud_mgmt_div_cd" ).append("\n"); 
		query.append("       , DECODE(SCD.DTRB_SRC_TP_CD,'ADJ','','REC','',  TO_CHAR(SOM.AR_OFFST_DT, 'YYYYMMDD')) AS act_dt" ).append("\n"); 
		query.append("       ,'' AS vsl_cd " ).append("\n"); 
		query.append("       ,'' AS vvl_Cd " ).append("\n"); 
		query.append("       ,'' AS hus_bank_id" ).append("\n"); 
		query.append("       ,'' AS pay_blck_key_cd" ).append("\n"); 
		query.append("       ,SCD.CLT_DTRB_SEQ" ).append("\n"); 
		query.append("       ,SCD.DTRB_SRC_TP_CD     AS  rec_tp_cd" ).append("\n"); 
		query.append("       ,DECODE(trim(scd.rvs_src_seq),null,'N','Y') AS rvs_flg -- 20150319 narmal/reverse sequence 분리" ).append("\n"); 
		query.append("       ,SCD.CRE_USR_ID" ).append("\n"); 
		query.append("	   ,SCD.UPD_USR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     FROM   SAR_ADJ_HIS SAH " ).append("\n"); 
		query.append("         , SAR_CLT_DTRB SCD " ).append("\n"); 
		query.append("         , SCO_LEGR_CD_CMB SLC " ).append("\n"); 
		query.append("         , SAR_OTS_CHG SOC " ).append("\n"); 
		query.append("         , SAR_OTS_HIS SOHI" ).append("\n"); 
		query.append("         , SAR_OFFST_MST SOM" ).append("\n"); 
		query.append("         , SAR_OTS_HDR SOH" ).append("\n"); 
		query.append("         , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("         ,(SELECT SLD.LU_CD CURR_CD" ).append("\n"); 
		query.append("           FROM SCO_LU_HDR SLH" ).append("\n"); 
		query.append("               ,SCO_LU_DTL SLD" ).append("\n"); 
		query.append("           WHERE SLH.LU_APPL_CD ='SCO'" ).append("\n"); 
		query.append("           AND SLH.LU_TP_CD ='FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("           AND SLH.LU_TP_CD = SLD.LU_TP_CD) FC" ).append("\n"); 
		query.append("  WHERE  SAH.ADJ_HIS_SEQ = SCD.DTRB_SRC_SEQ " ).append("\n"); 
		query.append("    AND  SCD.DTRB_CD_CMB_SEQ = SLC.CD_CMB_SEQ " ).append("\n"); 
		query.append("    AND  SAH.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ(+) " ).append("\n"); 
		query.append("    AND  SAH.CHG_TP_CD = SOC.CHG_TP_CD(+)" ).append("\n"); 
		query.append("    AND  SOHI.REF_NO = SAH.ADJ_NO  " ).append("\n"); 
		query.append("    AND  SOM.AR_OFFST_NO = SAH.ADJ_NO " ).append("\n"); 
		query.append("    AND  SOHI.RHQ_CD = SOH.RHQ_CD" ).append("\n"); 
		query.append("    AND  SOHI.OTS_OFC_CD = SOH.OTS_OFC_CD" ).append("\n"); 
		query.append("    AND  SOHI.BL_NO = SOH.BL_NO" ).append("\n"); 
		query.append("    AND  SOHI.INV_NO = SOH.INV_NO" ).append("\n"); 
		query.append("    AND  SOM.OFFST_TP_CD ='AR'" ).append("\n"); 
		query.append("    AND  MO.OFC_CD = SOM.OFC_CD" ).append("\n"); 
		query.append("    AND  SCD.DTRB_SRC_TBL_CD = 'ADJ'" ).append("\n"); 
		query.append("    AND (NVL(SCD.GL_INP_DR_AMT,0)+NVL(SCD.GL_INP_CR_AMT,0) + NVL(SCD.GL_ACCT_DR_AMT,0)+NVL(SCD.GL_ACCT_CR_AMT,0) ) <>0 " ).append("\n"); 
		query.append("   -- AND (SOM.OFFST_CURR_CD <>'JPY' or ( NVL(SCD.GL_INP_DR_AMT, 0) - NVL(SCD.GL_INP_CR_AMT, 0))<>0) --20150520 로직 추가" ).append("\n"); 
		query.append("    #if (${ar_offst_no} != '' )" ).append("\n"); 
		query.append("    AND  SAH.ADJ_NO = @[ar_offst_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	AND SCD.AR_IF_STS_CD = @[check_status]" ).append("\n"); 
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
		query.append(",PAY_RSN_CD " ).append("\n"); 
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
		query.append(",RVS_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(" ORDER BY RVS_FLG,CURR_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}