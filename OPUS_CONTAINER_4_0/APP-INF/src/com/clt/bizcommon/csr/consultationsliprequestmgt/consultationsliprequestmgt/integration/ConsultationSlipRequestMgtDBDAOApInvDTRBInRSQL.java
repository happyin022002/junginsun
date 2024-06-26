/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOApInvDTRBInRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOApInvDTRBInRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOApInvDTRBInRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_tax_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOApInvDTRBInRSQL").append("\n"); 
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
		query.append("SELECT LINE_SEQ," ).append("\n"); 
		query.append("       ROWNUM LINE_NO," ).append("\n"); 
		query.append("       LINE_TP_LU_CD," ).append("\n"); 
		query.append("       CSR_AMT," ).append("\n"); 
		query.append("       INV_DESC," ).append("\n"); 
		query.append("       INV_TAX_CD," ).append("\n"); 
		query.append("       DTRB_COA_CO_CD," ).append("\n"); 
		query.append("       DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("       DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("       DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("       DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("       DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("       DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("       DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("       ATTR_CATE_NM," ).append("\n"); 
		query.append("       ATTR_CTNT1," ).append("\n"); 
		query.append("       ATTR_CTNT2," ).append("\n"); 
		query.append("       ATTR_CTNT3," ).append("\n"); 
		query.append("       ATTR_CTNT4," ).append("\n"); 
		query.append("       ATTR_CTNT5," ).append("\n"); 
		query.append("       ATTR_CTNT6," ).append("\n"); 
		query.append("       ATTR_CTNT7," ).append("\n"); 
		query.append("       ATTR_CTNT8," ).append("\n"); 
		query.append("       ATTR_CTNT9," ).append("\n"); 
		query.append("       ATTR_CTNT10," ).append("\n"); 
		query.append("       ATTR_CTNT11," ).append("\n"); 
		query.append("       ATTR_CTNT12," ).append("\n"); 
		query.append("       ATTR_CTNT13," ).append("\n"); 
		query.append("       ATTR_CTNT14," ).append("\n"); 
		query.append("       ATTR_CTNT15," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       ACT_VVD_CD," ).append("\n"); 
		query.append("       PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("       SO_CRR_CD," ).append("\n"); 
		query.append("       YD_CD," ).append("\n"); 
		query.append("       FTU_USE_CTNT1," ).append("\n"); 
		query.append("       FTU_USE_CTNT2," ).append("\n"); 
		query.append("       FTU_USE_CTNT3," ).append("\n"); 
		query.append("       FTU_USE_CTNT4," ).append("\n"); 
		query.append("       FTU_USE_CNTR5," ).append("\n"); 
		query.append("       TO_CHAR(CRE_DT, 'YYYY/MM/DD HH24:MI:SS') CRE_DT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM   ( SELECT @[line_seq] LINE_SEQ," ).append("\n"); 
		query.append("                'ITEM' LINE_TP_LU_CD," ).append("\n"); 
		query.append("                --NVL(ROUND(SUM(INV_AMT)),0) CSR_AMT," ).append("\n"); 
		query.append("                DECODE(INV_CURR_CD," ).append("\n"); 
		query.append("                'KRW',ROUND(SUM(INV_AMT),0)," ).append("\n"); 
		query.append("                'JPY',ROUND(SUM(INV_AMT),0)," ).append("\n"); 
		query.append("                ROUND(SUM(INV_AMT),2)) CSR_AMT," ).append("\n"); 
		query.append("                INV_DESC," ).append("\n"); 
		query.append("                @[inv_tax_cd] INV_TAX_CD," ).append("\n"); 
		query.append("                '01' DTRB_COA_CO_CD," ).append("\n"); 
		query.append("                DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("                DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("                DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("                DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("                DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("                '000000' DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("                '000000' DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("                ATTR_CATE_NM," ).append("\n"); 
		query.append("                ATTR_CTNT1," ).append("\n"); 
		query.append("                ATTR_CTNT2," ).append("\n"); 
		query.append("                ATTR_CTNT3," ).append("\n"); 
		query.append("                NULL ATTR_CTNT4," ).append("\n"); 
		query.append("                NULL ATTR_CTNT5," ).append("\n"); 
		query.append("                NULL ATTR_CTNT6," ).append("\n"); 
		query.append("                NULL ATTR_CTNT7," ).append("\n"); 
		query.append("                ATTR_CTNT8," ).append("\n"); 
		query.append("                ATTR_CTNT9," ).append("\n"); 
		query.append("                NULL ATTR_CTNT10," ).append("\n"); 
		query.append("                ATTR_CTNT11," ).append("\n"); 
		query.append("                ATTR_CTNT12," ).append("\n"); 
		query.append("                NULL ATTR_CTNT13," ).append("\n"); 
		query.append("                ATTR_CTNT14," ).append("\n"); 
		query.append("                TO_CHAR(SYSDATE, 'YYYY/MM/DD') ATTR_CTNT15," ).append("\n"); 
		query.append("                NULL BKG_NO," ).append("\n"); 
		query.append("                CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                ACT_VVD_CD," ).append("\n"); 
		query.append("                PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("                SO_CRR_CD," ).append("\n"); 
		query.append("                YD_CD," ).append("\n"); 
		query.append("                FTU_USE_CTNT1," ).append("\n"); 
		query.append("                FTU_USE_CTNT2," ).append("\n"); 
		query.append("                NULL FTU_USE_CTNT3," ).append("\n"); 
		query.append("                NULL FTU_USE_CTNT4," ).append("\n"); 
		query.append("                NULL FTU_USE_CNTR5," ).append("\n"); 
		query.append("                GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) CRE_DT," ).append("\n"); 
		query.append("                @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("                NULL EAI_EVNT_DT" ).append("\n"); 
		query.append("         FROM   ( SELECT DECODE(H.INV_SUB_SYS_CD,'TLL',NVL(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                           ||D.REV_DIR_CD, '0000000000')," ).append("\n"); 
		query.append("                           ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("                             FROM   MDM_ACCOUNT" ).append("\n"); 
		query.append("                             WHERE  ACCT_CD = DECODE(D.ACCT_CD,'111011','954113',D.ACCT_CD) ) )   INV_DESC," ).append("\n"); 
		query.append("                         D.INV_AMT                                                                INV_AMT," ).append("\n"); 
		query.append("                         ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("                           FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE  OFC_CD = H.COST_OFC_CD )                                        DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("                         ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("                           FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE  OFC_CD = H.COST_OFC_CD )                                        DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("                         DECODE(D.ACCT_CD,'111011','954113',D.ACCT_CD)                            DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("                         DECODE(DECODE(D.ACCT_CD,'111011','954113',D.ACCT_CD)," ).append("\n"); 
		query.append("                                '954113','0000000000','564611','0000000000','113331','0000000000','113321','0000000000'," ).append("\n"); 
		query.append("                                NVL(D.VSL_CD" ).append("\n"); 
		query.append("                                    ||D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ||D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    ||D.REV_DIR_CD, '0000000000'))                                DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("                         ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("                           FROM   MDM_VENDOR" ).append("\n"); 
		query.append("                           WHERE  VNDR_SEQ = H.VNDR_SEQ )                                         DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("                         DECODE(D.ACCT_CD,'111011','954113',D.ACCT_CD)                            ATTR_CATE_NM," ).append("\n"); 
		query.append("                         H.INV_NO                                                                 ATTR_CTNT1," ).append("\n"); 
		query.append("                         TO_CHAR(H.INV_ISS_DT,'YYYY/MM/DD HH24:MI:SS')                            ATTR_CTNT2," ).append("\n"); 
		query.append("                         NVL(D.PORT_CD, ( SELECT LOC_CD" ).append("\n"); 
		query.append("												    								FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("												   								 WHERE OFC_CD = H.COST_OFC_CD ))         							  ATTR_CTNT3," ).append("\n"); 
		query.append("                         DECODE(D.ACCT_CD,'113331',H.INV_RMK,NULL)                                ATTR_CTNT8," ).append("\n"); 
		query.append("                         DECODE(D.ACCT_CD,'113331',H.INV_NO,NULL)                                 ATTR_CTNT9," ).append("\n"); 
		query.append("                         D.ACT_DT                                                                 ATTR_CTNT11,--ACTIVITY DATE" ).append("\n"); 
		query.append("                         D.ACT_PLC                                                                ATTR_CTNT12,--ACTIVITY PLACE" ).append("\n"); 
		query.append("                         NVL(D.SLAN_CD, (SELECT SLAN_CD FROM AR_MST_REV_VVD WHERE VSL_CD = D.VSL_CD " ).append("\n"); 
		query.append("                                         AND SKD_VOY_NO = D.SKD_VOY_NO AND SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                         AND RLANE_DIR_CD = D.REV_DIR_CD))                        ATTR_CTNT14,--SERVICE LANE" ).append("\n"); 
		query.append("                         D.CNTR_TPSZ_CD                                                           CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                         DECODE(D.ACCT_CD,'111011',NULL,'954113',NULL,'564611',NULL,D.ACT_VVD_CD) ACT_VVD_CD," ).append("\n"); 
		query.append("                         'C'                                                                      PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("                         NULL                                                                     SO_CRR_CD," ).append("\n"); 
		query.append("                         D.YD_CD                                                                  YD_CD," ).append("\n"); 
		query.append("                         DECODE(D.ACCT_CD,'111011',NULL,D.LGS_COST_CD)                            FTU_USE_CTNT1," ).append("\n"); 
		query.append("                         DECODE(D.ACCT_CD,'111011',NULL,DECODE(H.INV_SUB_SYS_CD,'PSO',NULL," ).append("\n"); 
		query.append("                                TO_CHAR(D.SO_20FT_QTY+D.SO_40FT_QTY+D.SO_TEU_QTY+D.SO_UT_QTY)))   FTU_USE_CTNT2," ).append("\n"); 
		query.append("                         H.INV_CURR_CD                                                            INV_CURR_CD" ).append("\n"); 
		query.append("                  FROM   AP_PAY_INV H, AP_PAY_INV_DTL D" ).append("\n"); 
		query.append("                  WHERE  H.INV_NO      = @[inv_no]" ).append("\n"); 
		query.append("                  AND    H.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("                  AND    H.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                  AND    H.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("                  AND    D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  SELECT" ).append("\n"); 
		query.append("                        ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("                            FROM    MDM_ACCOUNT" ).append("\n"); 
		query.append("                           WHERE   ACCT_CD = DECODE(SIGN(H.WHLD_TAX_AMT), 1, '954116', '')) INV_DESC," ).append("\n"); 
		query.append("                          DECODE(SIGN(H.WHLD_TAX_AMT), 1, H.WHLD_TAX_AMT, 0)               INV_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("                           FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE  OFC_CD = H.COST_OFC_CD )                                        DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("                           FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE  OFC_CD = H.COST_OFC_CD )                                        DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         DECODE(SIGN(H.WHLD_TAX_AMT), 1, '954116', '')                            DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         '0000000000'                                                             DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("                         '00'                                                                     DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("                         DECODE(SIGN(H.WHLD_TAX_AMT), 1, '954116', '')                            ATTR_CATE_NM," ).append("\n"); 
		query.append("                         H.INV_NO                                                                 ATTR_CTNT1," ).append("\n"); 
		query.append("                         TO_CHAR(H.INV_ISS_DT,'YYYY/MM/DD HH24:MI:SS')                            ATTR_CTNT2," ).append("\n"); 
		query.append("                         NVL((SELECT D.PORT_CD" ).append("\n"); 
		query.append("                                FROM AP_PAY_INV_DTL D" ).append("\n"); 
		query.append("                               WHERE H.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("                                 AND D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1), ( SELECT LOC_CD" ).append("\n"); 
		query.append("																					    								 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("																					   								  WHERE OFC_CD = H.COST_OFC_CD ))  	  ATTR_CTNT3," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT8," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT9," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT11,--ACTIVITY DATE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT12,--ACTIVITY PLACE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT14,--SERVICE LANE" ).append("\n"); 
		query.append("                         NULL                                                                     CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                         NULL                                                                     ACT_VVD_CD," ).append("\n"); 
		query.append("                         'C'                                                                      PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("                         NULL                                                                     SO_CRR_CD," ).append("\n"); 
		query.append("                         NULL                                                                     YD_CD," ).append("\n"); 
		query.append("                         NULL                                                                     FTU_USE_CTNT1," ).append("\n"); 
		query.append("                         NULL                                                                     FTU_USE_CTNT2," ).append("\n"); 
		query.append("                         H.INV_CURR_CD                                                              INV_CURR_CD" ).append("\n"); 
		query.append("                  FROM   AP_PAY_INV H" ).append("\n"); 
		query.append("                  WHERE  H.INV_NO      = @[inv_no]" ).append("\n"); 
		query.append("                  AND    H.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("                  AND    H.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                  AND    1             = DECODE(SIGN(H.WHLD_TAX_AMT), 1, 1, 0)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				  UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				  SELECT" ).append("\n"); 
		query.append("                        ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("                            FROM    MDM_ACCOUNT" ).append("\n"); 
		query.append("                           WHERE   ACCT_CD = DECODE(SIGN(H.INV_VAT_AMT), 1, '111811', '')) INV_DESC," ).append("\n"); 
		query.append("                          DECODE(SIGN(H.INV_VAT_AMT), 1, H.INV_VAT_AMT, 0)     INV_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("                           FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE  OFC_CD = H.COST_OFC_CD )                                        DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("                           FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE  OFC_CD = H.COST_OFC_CD )                                        DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         DECODE(SIGN(H.INV_VAT_AMT), 1, '111811', '')                             DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         '0000000000'                                                             DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("                         '00'                                                                     DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("                         DECODE(SIGN(H.INV_VAT_AMT), 1, '111811', '')                             ATTR_CATE_NM," ).append("\n"); 
		query.append("                         H.INV_NO                                                                   ATTR_CTNT1," ).append("\n"); 
		query.append("                         TO_CHAR(H.INV_ISS_DT,'YYYY/MM/DD HH24:MI:SS')                              ATTR_CTNT2," ).append("\n"); 
		query.append("                         NVL((SELECT D.PORT_CD" ).append("\n"); 
		query.append("                                FROM AP_PAY_INV_DTL D" ).append("\n"); 
		query.append("                               WHERE H.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("                                 AND D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1), ( SELECT LOC_CD" ).append("\n"); 
		query.append("																					    								 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("																					   								  WHERE OFC_CD = H.COST_OFC_CD ))  	  ATTR_CTNT3," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT8," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT9," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT11,--ACTIVITY DATE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT12,--ACTIVITY PLACE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT14,--SERVICE LANE" ).append("\n"); 
		query.append("                         NULL                                                                     CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                         NULL                                                                     ACT_VVD_CD," ).append("\n"); 
		query.append("                         'C'                                                                      PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("                         NULL                                                                     SO_CRR_CD," ).append("\n"); 
		query.append("                         NULL                                                                     YD_CD," ).append("\n"); 
		query.append("                         NULL                                                                     FTU_USE_CTNT1," ).append("\n"); 
		query.append("                         NULL                                                                     FTU_USE_CTNT2," ).append("\n"); 
		query.append("                         H.INV_CURR_CD                                                              INV_CURR_CD" ).append("\n"); 
		query.append("                  FROM   AP_PAY_INV H" ).append("\n"); 
		query.append("                  WHERE  H.INV_NO      = @[inv_no]" ).append("\n"); 
		query.append("                  AND    H.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("                  AND    H.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                  AND    1             = decode(H.INV_CURR_CD, 'KRW', 0, 1)" ).append("\n"); 
		query.append("                  AND    1             = DECODE(SIGN(H.INV_VAT_AMT), 1, 1, 0)" ).append("\n"); 
		query.append("				/*2009-11-23 질문 : INV_DESC, CNTR_TPSZ_CD, ACT_VVD_CD, YD_CD, LGS_COST_CD 값*/" ).append("\n"); 
		query.append("				  UNION ALL" ).append("\n"); 
		query.append("				/*2009-12-07 PSO AR General INV 대체전표*/" ).append("\n"); 
		query.append("		      SELECT" ).append("\n"); 
		query.append("		             ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("		             FROM    MDM_ACCOUNT" ).append("\n"); 
		query.append("		             WHERE   ACCT_CD =" ).append("\n"); 
		query.append("		                     (SELECT" ).append("\n"); 
		query.append("		                             /*+ INDEX_DESC (B XPKAP_PAY_INV_DTL) */" ).append("\n"); 
		query.append("		                             B.ACCT_CD" ).append("\n"); 
		query.append("		                     FROM    AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("		                     WHERE   H.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("		                         AND ROWNUM        = 1" ).append("\n"); 
		query.append("		                     )" ).append("\n"); 
		query.append("		             ) INV_DESC                ," ).append("\n"); 
		query.append("		             -( H.INV_TTL_AMT ) INV_AMT," ).append("\n"); 
		query.append("		             ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("		             FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("		             WHERE   OFC_CD = H.COST_OFC_CD" ).append("\n"); 
		query.append("		             ) DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("		             ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("		             FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("		             WHERE   OFC_CD = H.COST_OFC_CD" ).append("\n"); 
		query.append("		             ) DTRB_COA_CTR_CD           ," ).append("\n"); 
		query.append("		             '111211' DTRB_COA_ACCT_CD   ," ).append("\n"); 
		query.append("		             '0000000000' DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("		             ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("		             FROM    MDM_VENDOR" ).append("\n"); 
		query.append("		             WHERE   VNDR_SEQ = H.VNDR_SEQ" ).append("\n"); 
		query.append("		             ) DTRB_COA_INTER_CO_CD                                  ," ).append("\n"); 
		query.append("		             '111211' ATTR_CATE_NM                                   ," ).append("\n"); 
		query.append("		             H.INV_NO ATTR_CTNT1                                     ," ).append("\n"); 
		query.append("		             TO_CHAR(H.INV_ISS_DT,'YYYY/MM/DD HH24:MI:SS') ATTR_CTNT2," ).append("\n"); 
		query.append("                 NVL((SELECT D.PORT_CD" ).append("\n"); 
		query.append("                        FROM AP_PAY_INV_DTL D" ).append("\n"); 
		query.append("                       WHERE H.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("                         AND D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                         AND ROWNUM = 1), ( SELECT LOC_CD" ).append("\n"); 
		query.append("																	    								 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("																	   								  WHERE OFC_CD = H.COST_OFC_CD ))  	  ATTR_CTNT3," ).append("\n"); 
		query.append("		             NULL ATTR_CTNT8  ," ).append("\n"); 
		query.append("		             NULL ATTR_CTNT9  ," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT11,--ACTIVITY DATE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT12,--ACTIVITY PLACE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT14,--SERVICE LANE" ).append("\n"); 
		query.append("		             NULL CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		             (SELECT B.ACT_VVD_CD" ).append("\n"); 
		query.append("		             FROM    AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("		             WHERE   H.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("		                 AND ROWNUM        = 1" ).append("\n"); 
		query.append("		             ) ACT_VVD_CD       ," ).append("\n"); 
		query.append("		             'C' PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("		             NULL SO_CRR_CD     ," ).append("\n"); 
		query.append("		             (SELECT B.YD_CD" ).append("\n"); 
		query.append("		             FROM    AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("		             WHERE   H.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("		                 AND ROWNUM        = 1" ).append("\n"); 
		query.append("		             ) YD_CD           ," ).append("\n"); 
		query.append("		             NULL FTU_USE_CTNT1," ).append("\n"); 
		query.append("		             NULL FTU_USE_CTNT2," ).append("\n"); 
		query.append("		             H.INV_CURR_CD INV_CURR_CD" ).append("\n"); 
		query.append("		      FROM   AP_PAY_INV H" ).append("\n"); 
		query.append("		      WHERE  H.INV_NO            = @[inv_no]" ).append("\n"); 
		query.append("		         AND H.VNDR_SEQ          = @[vndr_seq]" ).append("\n"); 
		query.append("		         AND H.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("		         AND H.PSO_TRNS_SLP_CTNT = 'AR'" ).append("\n"); 
		query.append("		         AND H.INV_SUB_SYS_CD    = 'PSO'" ).append("\n"); 
		query.append("		         " ).append("\n"); 
		query.append("				  UNION ALL" ).append("\n"); 
		query.append("				/*2009-12-07 PSO Canal Invoice 대체*/" ).append("\n"); 
		query.append("		      SELECT" ).append("\n"); 
		query.append("		             ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("		             FROM    MDM_ACCOUNT" ).append("\n"); 
		query.append("		             WHERE   ACCT_CD = '110911'" ).append("\n"); 
		query.append("		             ) INV_DESC                ," ).append("\n"); 
		query.append("		             -( H.INV_TTL_AMT ) INV_AMT," ).append("\n"); 
		query.append("		             ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("		             FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("		             WHERE   OFC_CD = H.COST_OFC_CD" ).append("\n"); 
		query.append("		             ) DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("		             ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("		             FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("		             WHERE   OFC_CD = H.COST_OFC_CD" ).append("\n"); 
		query.append("		             ) DTRB_COA_CTR_CD           ," ).append("\n"); 
		query.append("		             '110911' DTRB_COA_ACCT_CD   ," ).append("\n"); 
		query.append("		             '0000000000' DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("		             ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("		             FROM    MDM_VENDOR" ).append("\n"); 
		query.append("		             WHERE   VNDR_SEQ = H.VNDR_SEQ" ).append("\n"); 
		query.append("		             ) DTRB_COA_INTER_CO_CD                                  ," ).append("\n"); 
		query.append("		             '110911' ATTR_CATE_NM                                   ," ).append("\n"); 
		query.append("		             H.INV_NO ATTR_CTNT1                                     ," ).append("\n"); 
		query.append("		             TO_CHAR(H.INV_ISS_DT,'YYYY/MM/DD HH24:MI:SS') ATTR_CTNT2," ).append("\n"); 
		query.append("                 NVL((SELECT D.PORT_CD" ).append("\n"); 
		query.append("                        FROM AP_PAY_INV_DTL D" ).append("\n"); 
		query.append("                       WHERE H.INV_RGST_NO = D.INV_RGST_NO" ).append("\n"); 
		query.append("                         AND D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                         AND ROWNUM = 1), ( SELECT LOC_CD" ).append("\n"); 
		query.append("												    								  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("												   								   WHERE OFC_CD = H.COST_OFC_CD ))  	  ATTR_CTNT3," ).append("\n"); 
		query.append("		             NULL ATTR_CTNT8  ," ).append("\n"); 
		query.append("		             NULL ATTR_CTNT9  ," ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT11,--ACTIVITY DATE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT12,--ACTIVITY PLACE" ).append("\n"); 
		query.append("                         NULL                                                                     ATTR_CTNT14,--SERVICE LANE" ).append("\n"); 
		query.append("		             NULL CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		             (SELECT B.ACT_VVD_CD" ).append("\n"); 
		query.append("		             FROM    AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("		             WHERE   H.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("		                 AND ROWNUM        = 1" ).append("\n"); 
		query.append("		             ) ACT_VVD_CD       ," ).append("\n"); 
		query.append("		             'C' PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("		             NULL SO_CRR_CD     ," ).append("\n"); 
		query.append("		             (SELECT B.YD_CD" ).append("\n"); 
		query.append("		             FROM    AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("		             WHERE   H.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("		                 AND ROWNUM        = 1" ).append("\n"); 
		query.append("		             ) YD_CD           ," ).append("\n"); 
		query.append("		             NULL FTU_USE_CTNT1," ).append("\n"); 
		query.append("		             NULL FTU_USE_CTNT2," ).append("\n"); 
		query.append("		             H.INV_CURR_CD INV_CURR_CD" ).append("\n"); 
		query.append("		      FROM   AP_PAY_INV H" ).append("\n"); 
		query.append("		      WHERE  H.INV_NO            = @[inv_no]" ).append("\n"); 
		query.append("		         AND H.VNDR_SEQ          = @[vndr_seq]" ).append("\n"); 
		query.append("		         AND H.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("		         AND H.PSO_TRNS_SLP_CTNT = 'AA'" ).append("\n"); 
		query.append("		         AND H.INV_SUB_SYS_CD    = 'PSO'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("         GROUP BY @[line_seq]," ).append("\n"); 
		query.append("                  INV_DESC," ).append("\n"); 
		query.append("                  INV_CURR_CD," ).append("\n"); 
		query.append("                  @[inv_tax_cd]," ).append("\n"); 
		query.append("                  DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("                  DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("                  DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("                  DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("                  DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("                  ATTR_CATE_NM," ).append("\n"); 
		query.append("                  ATTR_CTNT1," ).append("\n"); 
		query.append("                  ATTR_CTNT2," ).append("\n"); 
		query.append("                  ATTR_CTNT3," ).append("\n"); 
		query.append("                  ATTR_CTNT8," ).append("\n"); 
		query.append("                  ATTR_CTNT9," ).append("\n"); 
		query.append("                  ATTR_CTNT11," ).append("\n"); 
		query.append("                  ATTR_CTNT12," ).append("\n"); 
		query.append("                  ATTR_CTNT14," ).append("\n"); 
		query.append("                  TO_CHAR(SYSDATE, 'YYYY/MM/DD')," ).append("\n"); 
		query.append("                  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                  ACT_VVD_CD," ).append("\n"); 
		query.append("                  PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("                  SO_CRR_CD," ).append("\n"); 
		query.append("                  YD_CD," ).append("\n"); 
		query.append("                  FTU_USE_CTNT1," ).append("\n"); 
		query.append("                  FTU_USE_CTNT2," ).append("\n"); 
		query.append("                  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])," ).append("\n"); 
		query.append("                  @[cre_usr_id] )" ).append("\n"); 

	}
}