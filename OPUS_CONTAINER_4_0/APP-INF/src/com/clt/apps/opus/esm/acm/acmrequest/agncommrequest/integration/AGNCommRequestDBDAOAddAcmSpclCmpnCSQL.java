/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmSpclCmpnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmSpclCmpnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmSpclCmpn
	  * 
	  * 2016.04.01 박다은 Agreement Delt_flg 체크로직 추가
	  * 2016.04.25 박다은 [CSR:#11434] local currency 적용 로직 추가
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmSpclCmpnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_crnt_spcl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfeu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rteu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("box",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rbox",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_spcl_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmSpclCmpnCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SPCL_CMPN " ).append("\n"); 
		query.append("(BKG_NO, SPCL_OFC_CD, SPCL_CMPN_SEQ, SPCL_CMPN_STS_CD, PPD_AMT, CRNT_AMT, IF_AMT, VSL_DEP_DT, LOC_DIV_CD, LOC_CD, AR_OFC_CD, AP_OFC_CD, AP_CTR_CD, COMM_STND_COST_CD, SPCL_OCCR_INFO_CD, SPCL_SLAN_CD, SPCL_RLANE_CD, SPCL_VSL_CD, SPCL_SKD_VOY_NO, SPCL_SKD_DIR_CD, SPCL_REV_DIR_CD, OFC_CHR_CD, VNDR_CNT_CD, VNDR_SEQ, CMDT_TP_CD, CMDT_CD, CUST_CNT_CD, CUST_SEQ, SPCL_AGMT_SEQ, SHPR_CNT_CD, SHPR_SEQ, RFA_NO, CUST_KND_CD, SPCL_DIV_CD, SPCL_BKG_RT, BKG_BX_QTY, SPCL_BX_AMT, BKG_TEU_QTY, SPCL_TEU_AMT, BKG_FEU_QTY, SPCL_FEU_AMT, BKG_RF_TEU_QTY, SPCL_RF_TEU_AMT, BKG_RF_FEU_QTY, SPCL_RF_FEU_AMT, SPCL_CMPN_RMK, ACCL_FLG, PAY_CHK_FLG, PAY_CHK_USR_ID, PAY_CHK_DT, PAY_CHK_GDT, CSR_NO, APRO_USR_ID, APRO_DT, APRO_GDT, GL_DT, ASA_NO, INV_TAX_RT, IF_USR_ID, IF_DT, IF_GDT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("CURR_CD, PAY_XCH_RT, PAY_PPD_AMT, PAY_CRNT_AMT, PAY_IF_AMT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    SPCL_OFC_CD," ).append("\n"); 
		query.append("    @[max_spcl_cmpn_seq]            AS SPCL_CMPN_SEQ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  (CASE WHEN CRNT_AMT - @[ppd_crnt_spcl_amt] < 0 AND @[max_spcl_cmpn_seq] < 2 THEN 'CN'  " ).append("\n"); 
		query.append("        WHEN CRNT_AMT - @[ppd_crnt_spcl_amt] = 0 THEN 'CZ'" ).append("\n"); 
		query.append("        ELSE 'CS'" ).append("\n"); 
		query.append("   END) AS SPCL_CMPN_STS_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--    'CS'                            AS SPCL_CMPN_STS_CD," ).append("\n"); 
		query.append("    @[ppd_crnt_spcl_amt]            AS PPD_AMT," ).append("\n"); 
		query.append("    CRNT_AMT," ).append("\n"); 
		query.append("    CRNT_AMT - @[ppd_crnt_spcl_amt] AS IF_AMT," ).append("\n"); 
		query.append("    VSL_DEP_DT," ).append("\n"); 
		query.append("    NULL         AS LOC_DIV_CD," ).append("\n"); 
		query.append("    NULL         AS LOC_CD," ).append("\n"); 
		query.append("    (SELECT AR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = SPCL_OFC_CD)  AS AR_OFC_CD," ).append("\n"); 
		query.append("    (SELECT AP_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = SPCL_OFC_CD)  AS AP_OFC_CD," ).append("\n"); 
		query.append("    (SELECT AP_CTR_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = SPCL_OFC_CD)  AS AP_CTR_CD," ).append("\n"); 
		query.append("    COMM_STND_COST_CD,SPCL_OCCR_INFO_CD,SPCL_SLAN_CD,SPCL_RLANE_CD,SPCL_VSL_CD,SPCL_SKD_VOY_NO,SPCL_SKD_DIR_CD,SPCL_REV_DIR_CD," ).append("\n"); 
		query.append("    @[ofc_chr_cd] AS OFC_CHR_CD," ).append("\n"); 
		query.append("    VNDR_CNT_CD,VNDR_SEQ,CMDT_TP_CD,CMDT_CD,CUST_CNT_CD,CUST_SEQ,SPCL_AGMT_SEQ,SHPR_CNT_CD,SHPR_SEQ,RFA_NO," ).append("\n"); 
		query.append("    CUST_KND_CD,SPCL_DIV_CD,SPCL_BKG_RT,BKG_BX_QTY,SPCL_BX_AMT,BKG_TEU_QTY,SPCL_TEU_AMT,BKG_FEU_QTY,SPCL_FEU_AMT,BKG_RF_TEU_QTY,SPCL_RF_TEU_AMT,BKG_RF_FEU_QTY,SPCL_RF_FEU_AMT," ).append("\n"); 
		query.append("    NULL AS SPCL_CMPN_RMK," ).append("\n"); 
		query.append("    NULL AS ACCL_FLG," ).append("\n"); 
		query.append("    NULL AS PAY_CHK_FLG," ).append("\n"); 
		query.append("    NULL AS PAY_CHK_USR_ID," ).append("\n"); 
		query.append("    NULL AS PAY_CHK_DT," ).append("\n"); 
		query.append("    NULL AS PAY_CHK_GDT," ).append("\n"); 
		query.append("    NULL AS CSR_NO," ).append("\n"); 
		query.append("    NULL AS APRO_USR_ID," ).append("\n"); 
		query.append("    NULL AS APRO_DT," ).append("\n"); 
		query.append("    NULL AS APRO_GDT," ).append("\n"); 
		query.append("    NULL AS GL_DT," ).append("\n"); 
		query.append("    NULL AS ASA_NO," ).append("\n"); 
		query.append("    NULL AS INV_TAX_RT," ).append("\n"); 
		query.append("    NULL AS IF_USR_ID," ).append("\n"); 
		query.append("    NULL AS IF_DT," ).append("\n"); 
		query.append("    NULL AS IF_GDT," ).append("\n"); 
		query.append("    @[usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[usr_id] AS UPD_USR_ID ," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("    CURR_CD AS CURR_CD, " ).append("\n"); 
		query.append("    PAY_XCH_RT AS PAY_XCH_RT, " ).append("\n"); 
		query.append("    ROUND(@[ppd_crnt_spcl_amt] * PAY_XCH_RT, 3) AS PAY_PPD_AMT, " ).append("\n"); 
		query.append("    ROUND(CRNT_AMT * PAY_XCH_RT, 3) AS PAY_CRNT_AMT, " ).append("\n"); 
		query.append("    ROUND((CRNT_AMT - @[ppd_crnt_spcl_amt]) * PAY_XCH_RT, 3) AS PAY_IF_AMT   " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        INFO.BKG_NO," ).append("\n"); 
		query.append("        AGMT.SPCL_OFC_CD," ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("        WHEN 'BA' = AGMT.SPCL_DIV_CD " ).append("\n"); 
		query.append("        THEN ( " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("            CASE NVL (AGMT.SPCL_BKG_RT, 0) " ).append("\n"); 
		query.append("            WHEN 0 THEN 0 " ).append("\n"); 
		query.append("            ELSE ROUND (NVL ( SUM (BRT.CHG_AMT), 0) * (NVL (AGMT.SPCL_BKG_RT, 0) / 100), 2) " ).append("\n"); 
		query.append("            END " ).append("\n"); 
		query.append("            FROM BKG_CHG_RT BRT " ).append("\n"); 
		query.append("            WHERE BRT.BKG_NO         = INFO.BKG_NO " ).append("\n"); 
		query.append("            AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("            AND CURR_CD              = 'USD' " ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("        WHEN 'BF' = AGMT.SPCL_DIV_CD " ).append("\n"); 
		query.append("        THEN ( " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("            CASE NVL (AGMT.SPCL_BKG_RT, 0) " ).append("\n"); 
		query.append("            WHEN 0 THEN 0 " ).append("\n"); 
		query.append("            ELSE ROUND (NVL ( SUM (BRT.CHG_AMT), 0) * (NVL (AGMT.SPCL_BKG_RT, 0) / 100), 2) " ).append("\n"); 
		query.append("            END " ).append("\n"); 
		query.append("            FROM BKG_CHG_RT BRT " ).append("\n"); 
		query.append("            WHERE BRT.BKG_NO         = INFO.BKG_NO " ).append("\n"); 
		query.append("            AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("            AND CURR_CD              = 'USD' " ).append("\n"); 
		query.append("            AND BRT.CHG_CD IN ( 'OFT') " ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("        WHEN 'BS' = AGMT.SPCL_DIV_CD " ).append("\n"); 
		query.append("        THEN " ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("            CASE NVL (AGMT.SPCL_BKG_RT, 0) " ).append("\n"); 
		query.append("            WHEN 0 THEN 0 " ).append("\n"); 
		query.append("            ELSE ROUND (NVL( SUM (BRT.CHG_AMT), 0) * (NVL (AGMT.SPCL_BKG_RT, 0) / 100), 2) " ).append("\n"); 
		query.append("            END " ).append("\n"); 
		query.append("            FROM BKG_CHG_RT BRT " ).append("\n"); 
		query.append("            WHERE BRT.BKG_NO               = INFO.BKG_NO " ).append("\n"); 
		query.append("            AND FRT_INCL_XCLD_DIV_CD       = 'N' " ).append("\n"); 
		query.append("            AND CURR_CD                    = 'USD' " ).append("\n"); 
		query.append("            AND AGMT.SPCL_CHG_CTNT||',OFT' LIKE '%' || BRT.CHG_CD || '%' " ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("        WHEN 'CA' = AGMT.SPCL_DIV_CD " ).append("\n"); 
		query.append("        THEN NVL (AGMT.SPCL_BX_AMT, 0) * QUTY.BKG_BX_QTY " ).append("\n"); 
		query.append("        WHEN 'CS' = AGMT.SPCL_DIV_CD " ).append("\n"); 
		query.append("        THEN (NVL (AGMT.SPCL_BX_AMT,     0) * QUTY.BKG_BX_QTY )" ).append("\n"); 
		query.append("           + (NVL (AGMT.SPCL_TEU_AMT,    0) * QUTY.BKG_TEU_QTY )" ).append("\n"); 
		query.append("           + (NVL (AGMT.SPCL_FEU_AMT,    0) * QUTY.BKG_FEU_QTY )" ).append("\n"); 
		query.append("           + (NVL (AGMT.SPCL_RF_TEU_AMT, 0) * QUTY.BKG_RF_TEU_QTY )" ).append("\n"); 
		query.append("           + (NVL (AGMT.SPCL_RF_FEU_AMT, 0) * QUTY.BKG_RF_FEU_QTY )" ).append("\n"); 
		query.append("         END                                   AS CRNT_AMT," ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("            SELECT SKD.VPS_ETD_DT " ).append("\n"); 
		query.append("            FROM   VSK_VSL_PORT_SKD SKD, BKG_VVD          BVV " ).append("\n"); 
		query.append("            WHERE  SKD.VSL_CD                      = NVL (BVV.VSL_CD, '*') " ).append("\n"); 
		query.append("            AND    SKD.SKD_VOY_NO                  = NVL (BVV.SKD_VOY_NO, '*') " ).append("\n"); 
		query.append("            AND    SKD.SKD_DIR_CD                  = NVL (BVV.SKD_DIR_CD, '*') " ).append("\n"); 
		query.append("            AND    SKD.VPS_PORT_CD                 = NVL (BVV.POL_CD, '*') " ).append("\n"); 
		query.append("            AND    NVL (SKD.SKD_CNG_STS_CD, ' ') <>  'S' " ).append("\n"); 
		query.append("            AND    BVV.VSL_PRE_PST_CD              = 'T' " ).append("\n"); 
		query.append("            AND    BVV.BKG_NO                      = INFO.BKG_NO " ).append("\n"); 
		query.append("            AND    ROWNUM                          = 1 " ).append("\n"); 
		query.append("        )                                       AS VSL_DEP_DT," ).append("\n"); 
		query.append("        (SELECT COMM_STND_COST_CD FROM ACM_COMM_TP_CD_MAPG WHERE COMM_TP_CD = 'M' ) AS COMM_STND_COST_CD," ).append("\n"); 
		query.append("        BOOK.POL_CD                    AS SPCL_OCCR_INFO_CD," ).append("\n"); 
		query.append("        BOOK.SLAN_CD                   AS SPCL_SLAN_CD," ).append("\n"); 
		query.append("        RGST.RLANE_CD                  AS SPCL_RLANE_CD," ).append("\n"); 
		query.append("        BOOK.VSL_CD                    AS SPCL_VSL_CD," ).append("\n"); 
		query.append("        BOOK.SKD_VOY_NO                AS SPCL_SKD_VOY_NO," ).append("\n"); 
		query.append("        BOOK.SKD_DIR_CD                AS SPCL_SKD_DIR_CD," ).append("\n"); 
		query.append("        BOOK.REV_DIR_CD                AS SPCL_REV_DIR_CD," ).append("\n"); 
		query.append("        MTCH.VNDR_CNT_CD               AS VNDR_CNT_CD," ).append("\n"); 
		query.append("        MTCH.VNDR_SEQ                  AS VNDR_SEQ," ).append("\n"); 
		query.append("        AGMT.CMDT_TP_CD                AS CMDT_TP_CD," ).append("\n"); 
		query.append("        AGMT.CMDT_CD                   AS CMDT_CD," ).append("\n"); 
		query.append("        AGMT.CUST_CNT_CD               AS CUST_CNT_CD," ).append("\n"); 
		query.append("        AGMT.CUST_SEQ                  AS CUST_SEQ," ).append("\n"); 
		query.append("        AGMT.SPCL_AGMT_SEQ             AS SPCL_AGMT_SEQ," ).append("\n"); 
		query.append("        SUBSTR(INFO.SHPR,1,2)          AS SHPR_CNT_CD," ).append("\n"); 
		query.append("        TO_NUMBER(SUBSTR(INFO.SHPR,3)) AS SHPR_SEQ," ).append("\n"); 
		query.append("        BOOK.RFA_NO                    AS RFA_NO," ).append("\n"); 
		query.append("        AGMT.CUST_KND_CD               AS CUST_KND_CD," ).append("\n"); 
		query.append("        AGMT.SPCL_DIV_CD               AS SPCL_DIV_CD," ).append("\n"); 
		query.append("        AGMT.SPCL_BKG_RT               AS SPCL_BKG_RT," ).append("\n"); 
		query.append("        QUTY.BKG_BX_QTY                AS BKG_BX_QTY," ).append("\n"); 
		query.append("        AGMT.SPCL_BX_AMT               AS SPCL_BX_AMT," ).append("\n"); 
		query.append("        QUTY.BKG_TEU_QTY               AS BKG_TEU_QTY," ).append("\n"); 
		query.append("        AGMT.SPCL_TEU_AMT              AS SPCL_TEU_AMT," ).append("\n"); 
		query.append("        QUTY.BKG_FEU_QTY               AS BKG_FEU_QTY," ).append("\n"); 
		query.append("        AGMT.SPCL_FEU_AMT              AS SPCL_FEU_AMT," ).append("\n"); 
		query.append("        QUTY.BKG_RF_TEU_QTY            AS BKG_RF_TEU_QTY," ).append("\n"); 
		query.append("        AGMT.SPCL_RF_TEU_AMT           AS SPCL_RF_TEU_AMT," ).append("\n"); 
		query.append("        QUTY.BKG_RF_FEU_QTY            AS BKG_RF_FEU_QTY," ).append("\n"); 
		query.append("        AGMT.SPCL_RF_FEU_AMT           AS SPCL_RF_FEU_AMT," ).append("\n"); 
		query.append("        AGMT.PAY_XCH_RT                AS PAY_XCH_RT," ).append("\n"); 
		query.append("        AGMT.CURR_CD                   AS CURR_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY INFO.BKG_NO, SPCL_OFC_CD, NVL(INFO.SHPR,'*'), NVL(POR_GRP_TP_CD,'*'), NVL(POL_GRP_TP_CD,'*'), NVL(POD_GRP_TP_CD,'*')" ).append("\n"); 
		query.append("                     ORDER BY DECODE(NVL(CMDT_TP_CD,'*'),'*','0',CMDT_TP_CD) DESC ) CMDT_DUP_CHK," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY INFO.BKG_NO, SPCL_OFC_CD ,NVL(CMDT_TP_CD,'*'),NVL(POR_GRP_TP_CD,'*'), NVL(POL_GRP_TP_CD,'*'), NVL(POD_GRP_TP_CD,'*')" ).append("\n"); 
		query.append("                     ORDER BY DECODE(NVL(INFO.SHPR,'*'),'*','0',INFO.SHPR) DESC ) SHPR_DUP_CHK," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY INFO.BKG_NO, SPCL_OFC_CD ,NVL(CMDT_TP_CD,'*'),NVL(INFO.SHPR,'*'), NVL(POL_GRP_TP_CD,'*'), NVL(POD_GRP_TP_CD,'*')" ).append("\n"); 
		query.append("                     ORDER BY DECODE(NVL(POR_GRP_TP_CD,'*'),'*','0',POR_GRP_TP_CD) DESC ) POR_DUP_CHK," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY INFO.BKG_NO, SPCL_OFC_CD ,NVL(CMDT_TP_CD,'*'),NVL(INFO.SHPR,'*'), NVL(POR_GRP_TP_CD,'*'), NVL(POD_GRP_TP_CD,'*')" ).append("\n"); 
		query.append("                     ORDER BY DECODE(NVL(POL_GRP_TP_CD,'*'),'*','0',POL_GRP_TP_CD) DESC ) POL_DUP_CHK," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY INFO.BKG_NO, SPCL_OFC_CD ,NVL(CMDT_TP_CD,'*'),NVL(INFO.SHPR,'*'), NVL(POR_GRP_TP_CD,'*'), NVL(POL_GRP_TP_CD,'*')" ).append("\n"); 
		query.append("                     ORDER BY DECODE(NVL(POD_GRP_TP_CD,'*'),'*','0',POD_GRP_TP_CD) DESC ) POD_DUP_CHK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        ACM_SPCL_AGMT           AGMT, " ).append("\n"); 
		query.append("        ACM_SPCL_CUST_VNDR_MTCH MTCH, " ).append("\n"); 
		query.append("        BKG_BOOKING             BOOK," ).append("\n"); 
		query.append("        COA_RGST_BKG            RGST," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("              @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("            , @[box]    AS BKG_BX_QTY" ).append("\n"); 
		query.append("            , @[teu]    AS BKG_TEU_QTY" ).append("\n"); 
		query.append("            , @[feu]    AS BKG_FEU_QTY" ).append("\n"); 
		query.append("            , @[rbox]   AS BKG_RF_QTY" ).append("\n"); 
		query.append("            , @[rteu]   AS BKG_RF_TEU_QTY" ).append("\n"); 
		query.append("            , @[rfeu]   AS BKG_RF_FEU_QTY" ).append("\n"); 
		query.append("            FROM DUAL " ).append("\n"); 
		query.append("        ) QUTY," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                BKG.BKG_NO, " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                      BCU.CUST_CNT_CD||TO_CHAR (BCU.CUST_SEQ, 'FM000000') " ).append("\n"); 
		query.append("                FROM  BKG_CUSTOMER BCU " ).append("\n"); 
		query.append("                WHERE BCU.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("                AND   BCU.BKG_CUST_TP_CD ='S' " ).append("\n"); 
		query.append("                AND   ROWNUM = 1 " ).append("\n"); 
		query.append("                )                                                 AS SHPR," ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                      BCU.CUST_CNT_CD||TO_CHAR (BCU.CUST_SEQ, 'FM000000') " ).append("\n"); 
		query.append("                FROM  BKG_CUSTOMER BCU " ).append("\n"); 
		query.append("                WHERE BCU.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("                AND   BCU.BKG_CUST_TP_CD ='F' " ).append("\n"); 
		query.append("                AND   ROWNUM = 1 " ).append("\n"); 
		query.append("                )                                                 AS FRT_FWDR, " ).append("\n"); 
		query.append("                BKG.SC_NO, " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                      SMN.REAL_CUST_CNT_CD||TO_CHAR(SMN.REAL_CUST_SEQ, 'FM000000') " ).append("\n"); 
		query.append("                FROM  PRI_SP_MN  SMN, " ).append("\n"); 
		query.append("                      PRI_SP_HDR SHD " ).append("\n"); 
		query.append("                WHERE SHD.SC_NO       = BKG.SC_NO" ).append("\n"); 
		query.append("                AND   SHD.PROP_NO     = SMN.PROP_NO " ).append("\n"); 
		query.append("                AND   SMN.PROP_STS_CD = 'A' " ).append("\n"); 
		query.append("                AND   TO_DATE( @[rt_aply_dt] , 'YYYYMMDD')  BETWEEN SMN.EFF_DT AND SMN.EXP_DT " ).append("\n"); 
		query.append("                AND   ROWNUM = 1 " ).append("\n"); 
		query.append("                )                                                 AS SC_REAL_CUST, " ).append("\n"); 
		query.append("                BKG.RFA_NO, " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                      RMN.CTRT_CUST_CNT_CD||TO_CHAR(RMN.CTRT_CUST_SEQ, 'FM000000') " ).append("\n"); 
		query.append("                FROM  PRI_RP_MN  RMN, " ).append("\n"); 
		query.append("                      PRI_RP_HDR RHD " ).append("\n"); 
		query.append("                WHERE RHD.RFA_NO      = BKG.RFA_NO" ).append("\n"); 
		query.append("                AND   RHD.PROP_NO     = RMN.PROP_NO " ).append("\n"); 
		query.append("                AND   RMN.PROP_STS_CD = 'A' " ).append("\n"); 
		query.append("                AND   TO_DATE(  @[rt_aply_dt] , 'YYYYMMDD')  BETWEEN RMN.EFF_DT AND RMN.EXP_DT " ).append("\n"); 
		query.append("                AND ROWNUM = 1 " ).append("\n"); 
		query.append("                )                                                 AS RFA_CTRTR," ).append("\n"); 
		query.append("                BKG.CMDT_CD, " ).append("\n"); 
		query.append("                BKG.REP_CMDT_CD, " ).append("\n"); 
		query.append("                BKG.POR_CD                                        AS POR_CD, " ).append("\n"); 
		query.append("                POR.RGN_CD                                        AS POR_RGN_CD, " ).append("\n"); 
		query.append("                POR.CNT_CD                                        AS POR_CNT_CD, " ).append("\n"); 
		query.append("                POR.SCONTI_CD                                     AS POR_SCONTI_CD, " ).append("\n"); 
		query.append("                POR.CONTI_CD                                      AS POR_CONTI_CD, " ).append("\n"); 
		query.append("                BKG.POL_CD                                        AS POL_CD,  " ).append("\n"); 
		query.append("                POL.RGN_CD                                        AS POL_RGN_CD, " ).append("\n"); 
		query.append("                POL.CNT_CD                                        AS POL_CNT_CD, " ).append("\n"); 
		query.append("                POL.SCONTI_CD                                     AS POL_SCONTI_CD, " ).append("\n"); 
		query.append("                POL.CONTI_CD                                      AS POL_CONTI_CD, " ).append("\n"); 
		query.append("                BKG.POD_CD                                        AS POD_CD,  " ).append("\n"); 
		query.append("                POD.RGN_CD                                        AS POD_RGN_CD, " ).append("\n"); 
		query.append("                POD.CNT_CD                                        AS POD_CNT_CD, " ).append("\n"); 
		query.append("                POD.SCONTI_CD                                     AS POD_SCONTI_CD, " ).append("\n"); 
		query.append("                POD.CONTI_CD                                      AS POD_CONTI_CD, " ).append("\n"); 
		query.append("                @[rt_aply_dt]                                      AS RT_APLY_DT" ).append("\n"); 
		query.append("            FROM BKG_BOOKING      BKG," ).append("\n"); 
		query.append("                 MDM_LOCATION     POR, " ).append("\n"); 
		query.append("                 MDM_LOCATION     POL, " ).append("\n"); 
		query.append("                 MDM_LOCATION     POD" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND BKG_NO      =  @[bkg_no]" ).append("\n"); 
		query.append("            AND BKG.POR_CD  = POR.LOC_CD " ).append("\n"); 
		query.append("            AND BKG.POL_CD  = POL.LOC_CD " ).append("\n"); 
		query.append("            AND BKG.POD_CD  = POD.LOC_CD " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    )INFO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND BOOK.BKG_NO      = INFO.BKG_NO" ).append("\n"); 
		query.append("    AND RGST.BKG_NO      = INFO.BKG_NO" ).append("\n"); 
		query.append("    AND MTCH.CUST_CNT_CD = AGMT.CUST_CNT_CD " ).append("\n"); 
		query.append("    AND MTCH.CUST_SEQ    = AGMT.CUST_SEQ " ).append("\n"); 
		query.append("    AND AGMT.CUST_CNT_CD || TO_CHAR (AGMT.CUST_SEQ, 'FM000000') || AGMT.CUST_KND_CD " ).append("\n"); 
		query.append("    IN ( " ).append("\n"); 
		query.append("        INFO.SHPR         || 'S', " ).append("\n"); 
		query.append("        INFO.FRT_FWDR     || 'F', " ).append("\n"); 
		query.append("        INFO.RFA_CTRTR    || 'R'," ).append("\n"); 
		query.append("        INFO.SC_REAL_CUST || 'C', " ).append("\n"); 
		query.append("        SUBSTR (INFO.SHPR        , 1, 2) || '999999' || 'S', " ).append("\n"); 
		query.append("        SUBSTR (INFO.FRT_FWDR    , 1, 2) || '999999' || 'F', " ).append("\n"); 
		query.append("        SUBSTR (INFO.RFA_CTRTR   , 1, 2) || '999999' || 'R', " ).append("\n"); 
		query.append("        SUBSTR (INFO.SC_REAL_CUST, 1, 2) || '999999' || 'C' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    /*  Effective Date 로직  */    " ).append("\n"); 
		query.append("    AND AGMT.FM_EFF_DT <= INFO.RT_APLY_DT   " ).append("\n"); 
		query.append("    AND AGMT.TO_EFF_DT >= INFO.RT_APLY_DT  " ).append("\n"); 
		query.append("    /* SHIPPER가 존재하는지 */ " ).append("\n"); 
		query.append("    AND  NVL (AGMT.SHPR_CNT_CD, '*') || NVL (TO_CHAR(AGMT.SHPR_SEQ, 'FM000000'), '000000') = " ).append("\n"); 
		query.append("    CASE NVL (AGMT.SHPR_CNT_CD, '*') || NVL (TO_CHAR(AGMT.SHPR_SEQ, 'FM000000'), '000000') " ).append("\n"); 
		query.append("         WHEN '*000000' THEN '*000000' " ).append("\n"); 
		query.append("         ELSE INFO.SHPR" ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    /* RFA NO가 존재하는지 */ " ).append("\n"); 
		query.append("    AND  NVL (AGMT.RFA_NO, '*') = " ).append("\n"); 
		query.append("    CASE NVL (AGMT.RFA_NO, '*') " ).append("\n"); 
		query.append("         WHEN '*' THEN '*' " ).append("\n"); 
		query.append("         ELSE NVL (INFO.RFA_NO, '*') " ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    /* SC NO가 존재하는지 */ " ).append("\n"); 
		query.append("    AND  NVL (AGMT.SC_NO, '*') = " ).append("\n"); 
		query.append("    CASE NVL (AGMT.SC_NO, '*') " ).append("\n"); 
		query.append("         WHEN '*' THEN '*' " ).append("\n"); 
		query.append("         ELSE NVL (INFO.SC_NO, '*') " ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    /* REP COMMODITY, COMMODITY가  존재하는지 */ " ).append("\n"); 
		query.append("    AND  NVL (AGMT.CMDT_CD, '*') = " ).append("\n"); 
		query.append("    CASE NVL (AGMT.CMDT_TP_CD, '*') " ).append("\n"); 
		query.append("        WHEN '*' THEN NVL (AGMT.CMDT_CD, '*') " ).append("\n"); 
		query.append("        WHEN '2' THEN INFO.REP_CMDT_CD " ).append("\n"); 
		query.append("        WHEN '3' THEN INFO.CMDT_CD " ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    /* POR Location 해당 ROUTE별로 존재하는지 */ " ).append("\n"); 
		query.append("    AND  NVL (AGMT.POR_ROUT_CD  , '*') = " ).append("\n"); 
		query.append("    CASE NVL (AGMT.POR_GRP_TP_CD, '*') " ).append("\n"); 
		query.append("         WHEN '*' THEN '*' " ).append("\n"); 
		query.append("         WHEN '5' THEN INFO.POR_CD " ).append("\n"); 
		query.append("         WHEN '4' THEN INFO.POR_RGN_CD " ).append("\n"); 
		query.append("         WHEN '3' THEN INFO.POR_CNT_CD " ).append("\n"); 
		query.append("         WHEN '2' THEN INFO.POR_SCONTI_CD " ).append("\n"); 
		query.append("         WHEN '1' THEN INFO.POR_CONTI_CD " ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    /* POL Location 해당 ROUTE별로 존재하는지 */ " ).append("\n"); 
		query.append("    AND  NVL (AGMT.POL_ROUT_CD  , '*') = " ).append("\n"); 
		query.append("    CASE NVL (AGMT.POL_GRP_TP_CD, '*') " ).append("\n"); 
		query.append("         WHEN '*' THEN '*' " ).append("\n"); 
		query.append("         WHEN '5' THEN INFO.POL_CD " ).append("\n"); 
		query.append("         WHEN '4' THEN INFO.POL_RGN_CD " ).append("\n"); 
		query.append("         WHEN '3' THEN INFO.POL_CNT_CD " ).append("\n"); 
		query.append("         WHEN '2' THEN INFO.POL_SCONTI_CD " ).append("\n"); 
		query.append("         WHEN '1' THEN INFO.POL_CONTI_CD " ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    /* POD Location 해당 ROUTE별로 존재하는지 */ " ).append("\n"); 
		query.append("    AND  NVL (AGMT.POD_ROUT_CD  , '*') = " ).append("\n"); 
		query.append("    CASE NVL (AGMT.POD_GRP_TP_CD, '*') " ).append("\n"); 
		query.append("         WHEN '*' THEN '*' " ).append("\n"); 
		query.append("         WHEN '5' THEN INFO.POD_CD " ).append("\n"); 
		query.append("         WHEN '4' THEN INFO.POD_RGN_CD " ).append("\n"); 
		query.append("         WHEN '3' THEN INFO.POD_CNT_CD " ).append("\n"); 
		query.append("         WHEN '2' THEN INFO.POD_SCONTI_CD " ).append("\n"); 
		query.append("         WHEN '1' THEN INFO.POD_CONTI_CD " ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    AND AGMT.DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CMDT_DUP_CHK = 1" ).append("\n"); 
		query.append("AND SHPR_DUP_CHK = 1" ).append("\n"); 
		query.append("AND POR_DUP_CHK  = 1" ).append("\n"); 
		query.append("AND POL_DUP_CHK  = 1" ).append("\n"); 
		query.append("AND POD_DUP_CHK  = 1" ).append("\n"); 

	}
}