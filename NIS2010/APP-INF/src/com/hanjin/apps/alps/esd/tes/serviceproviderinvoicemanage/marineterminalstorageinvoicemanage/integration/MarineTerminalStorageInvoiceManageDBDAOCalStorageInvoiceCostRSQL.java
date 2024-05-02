/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOCalStorageInvoiceCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOCalStorageInvoiceCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CalStorageInvoiceCost
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOCalStorageInvoiceCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sto_dys_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOCalStorageInvoiceCostRSQL").append("\n"); 
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
		query.append("SELECT IBFLAG," ).append("\n"); 
		query.append("        CALC_TP_CD," ).append("\n"); 
		query.append("        CALC_COST_GRP_CD," ).append("\n"); 
		query.append("        LGS_COST_CD," ).append("\n"); 
		query.append("        CNTR_NO, " ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        IO_BND_CD," ).append("\n"); 
		query.append("        DCGO_IND_CD," ).append("\n"); 
		query.append("        STAY_DYS," ).append("\n"); 
		query.append("        FREE_DYS," ).append("\n"); 
		query.append("        PAID_DAY PAY_DYS," ).append("\n"); 
		query.append("        FREE_DY_XCLD_DYS," ).append("\n"); 
		query.append("        DECODE(SIGN(CALC_PDYS_CALC_AMT), 1, OVR_DYS - PAID_DYS, OVR_DYS) OVR_DYS,  -- PAY_DYS는 CALC_PDYS_CALC_AMT가 (+)면 (+), (-)면 (-)이다" ).append("\n"); 
		query.append("        DECODE(SIGN(CALC_PDYS_CALC_AMT), 1, OVR_DYS2 - PAID_DYS, OVR_DYS2) OVR_DYS2," ).append("\n"); 
		query.append("        VOL_TR_UT_CD," ).append("\n"); 
		query.append("        CTRT_RT," ).append("\n"); 
		query.append("        DECODE(SIGN(CALC_PDYS_CALC_AMT), 1, NEW_CALC_AMT - CALC_PDYS_CALC_AMT, NEW_CALC_AMT) CALC_AMT,  --Paid Day에 대한 Rate를 구한 값(CALC_PDYS_CALC_AMT)이 0이나 (-)금액이 아닌 경우에만 Over Day+Paid Day에서 빼준다. " ).append("\n"); 
		query.append("        DECODE(SIGN(CALC_PDYS_INV_AMT ), 1, NEW_INV_AMT - CALC_PDYS_INV_AMT , NEW_INV_AMT ) INV_AMT,   --Paid 된 값을 뺀 나머지에 대한 Tier Rate를 구하기 위해 수정했음" ).append("\n"); 
		query.append("        CURR_CHK," ).append("\n"); 
		query.append("        CURR_CD," ).append("\n"); 
		query.append("        INV_XCH_RT," ).append("\n"); 
		query.append("        ACCT_CD," ).append("\n"); 
		query.append("        TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("        TML_AGMT_SEQ," ).append("\n"); 
		query.append("        TML_AGMT_VER_NO," ).append("\n"); 
		query.append("        TO_DAY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT IBFLAG," ).append("\n"); 
		query.append("  CALC_TP_CD," ).append("\n"); 
		query.append("  CALC_COST_GRP_CD," ).append("\n"); 
		query.append("  LGS_COST_CD," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  IO_BND_CD," ).append("\n"); 
		query.append("  DCGO_IND_CD," ).append("\n"); 
		query.append("  STAY_DYS," ).append("\n"); 
		query.append("  FREE_DYS," ).append("\n"); 
		query.append("  PAID_DAY," ).append("\n"); 
		query.append("  EXD_DAY FREE_DY_XCLD_DYS," ).append("\n"); 
		query.append("  (new_TO_DAY - FM_DAY)+1 OVR_DYS," ).append("\n"); 
		query.append("  (new_TO_DAY - FM_DAY)+1 OVR_DYS2," ).append("\n"); 
		query.append("  (calc_PDYS  - FM_DAY)+1 PAID_DYS,  -- Paid된 일수에 대한 Tier별 일수를 구한다." ).append("\n"); 
		query.append("  VOL_TR_UT_CD," ).append("\n"); 
		query.append("  MAX(RATE) CTRT_RT," ).append("\n"); 
		query.append("  (DECODE(SIGN(TODYS-((new_TO_DAY - FM_DAY)+1)), -1, ((new_TO_DAY - FM_DAY)+1)-TODYS, ((new_TO_DAY - FM_DAY)+1)) * RATE) * DECODE(VOL_TR_UT_CD, 'T', DECODE(CNTR_TPSZ_CD, 'D7', 2.25, 'D8', 2.4, 'D9', 2.4, 'DW', 2.65, 'DX', 2.25, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 2)), 1) NEW_CALC_AMT,    -- OVER DAY와 Paid DAY를 합쳐서 RATE 산출" ).append("\n"); 
		query.append("  (DECODE(SIGN(TODYS-((new_TO_DAY - FM_DAY)+1)), -1, ((new_TO_DAY - FM_DAY)+1)-TODYS, ((new_TO_DAY - FM_DAY)+1)) * RATE) * DECODE(VOL_TR_UT_CD, 'T', DECODE(CNTR_TPSZ_CD, 'D7', 2.25, 'D8', 2.4, 'D9', 2.4, 'DW', 2.65, 'DX', 2.25, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 2)), 1) NEW_INV_AMT," ).append("\n"); 
		query.append("  (DECODE(SIGN(TODYS-((calc_PDYS - FM_DAY)+1)), -1, ((calc_PDYS - FM_DAY)+1)-TODYS, ((calc_PDYS - FM_DAY)+1)) * RATE) * DECODE(VOL_TR_UT_CD, 'T', DECODE(CNTR_TPSZ_CD, 'D7', 2.25, 'D8', 2.4, 'D9', 2.4, 'DW', 2.65, 'DX', 2.25, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 2)), 1) CALC_PDYS_CALC_AMT, -- Paid DAY의 RATE를 산출(위에서 뺄것임, 단 양수의 값일 경우만..)" ).append("\n"); 
		query.append("  (DECODE(SIGN(TODYS-((calc_PDYS - FM_DAY)+1)), -1, ((calc_PDYS - FM_DAY)+1)-TODYS, ((calc_PDYS - FM_DAY)+1)) * RATE) * DECODE(VOL_TR_UT_CD, 'T', DECODE(CNTR_TPSZ_CD, 'D7', 2.25, 'D8', 2.4, 'D9', 2.4, 'DW', 2.65, 'DX', 2.25, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 2)), 1) CALC_PDYS_INV_AMT," ).append("\n"); 
		query.append("  CURR_CHK," ).append("\n"); 
		query.append("  CURR_CD," ).append("\n"); 
		query.append("  INV_XCH_RT," ).append("\n"); 
		query.append("  ACCT_CD," ).append("\n"); 
		query.append("  TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("  TML_AGMT_SEQ," ).append("\n"); 
		query.append("  TML_AGMT_VER_NO," ).append("\n"); 
		query.append("  TO_DAY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT 'I' IBFLAG," ).append("\n"); 
		query.append("      'A' CALC_TP_CD," ).append("\n"); 
		query.append("      'SD' CALC_COST_GRP_CD," ).append("\n"); 
		query.append("      COST_CODE LGS_COST_CD," ).append("\n"); 
		query.append("      CNTR_NO," ).append("\n"); 
		query.append("      TPSZ CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      IO IO_BND_CD," ).append("\n"); 
		query.append("      DG DCGO_IND_CD," ).append("\n"); 
		query.append("      STAY_DAY STAY_DYS," ).append("\n"); 
		query.append("      FDYS FREE_DYS," ).append("\n"); 
		query.append("      PDYS PAID_DAY," ).append("\n"); 
		query.append("      EDAY EXD_DAY," ).append("\n"); 
		query.append("      OVER_DAY," ).append("\n"); 
		query.append("      FMDYS," ).append("\n"); 
		query.append("      TODYS," ).append("\n"); 
		query.append("      ( CASE WHEN 0 >= NVL(FMDYS, 1) THEN 0 + 1 ELSE NVL(FMDYS, 1) END ) FM_DAY," ).append("\n"); 
		query.append("      ( CASE WHEN OVER_DAY <= NVL(TODYS, 999) THEN OVER_DAY ELSE NVL(TODYS, 999) END ) TO_DAY," ).append("\n"); 
		query.append("      ( CASE WHEN OVER_DAY+PDYS <= NVL(TODYS, 999) THEN OVER_DAY+PDYS ELSE NVL(TODYS, 999) END ) new_TO_DAY, -- OVER DAY와 PDYS를 합쳐서 구한다." ).append("\n"); 
		query.append("      ( CASE WHEN PDYS <= NVL(TODYS, 999) THEN PDYS ELSE NVL(TODYS, 999) END ) calc_PDYS, -- PDYS 의 Rate를 구하기 위함. 위에서 OVER DAY+PDYS에서 이 값을 뺄꺼다." ).append("\n"); 
		query.append("      UOM VOL_TR_UT_CD," ).append("\n"); 
		query.append("      RATE," ).append("\n"); 
		query.append("      CURR_CHK," ).append("\n"); 
		query.append("      CURR CURR_CD," ).append("\n"); 
		query.append("      1 INV_XCH_RT," ).append("\n"); 
		query.append("      C.ACCT_CD," ).append("\n"); 
		query.append("      L.TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("      L.TML_AGMT_SEQ," ).append("\n"); 
		query.append("      L.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("    FROM (SELECT COST_CODE, " ).append("\n"); 
		query.append("                 CNTR_NO," ).append("\n"); 
		query.append("                 TPSZ," ).append("\n"); 
		query.append("                 IO," ).append("\n"); 
		query.append("                 DG," ).append("\n"); 
		query.append("                 STAY_DAY," ).append("\n"); 
		query.append("                 STAY_DAY2," ).append("\n"); 
		query.append("                 FDYS," ).append("\n"); 
		query.append("                 PDYS, " ).append("\n"); 
		query.append("                 EDAY," ).append("\n"); 
		query.append("                 DECODE(PDYS,0,DECODE(SIGN(STAY_DAY - FDYS - EDAY),-1,0,0,0,(STAY_DAY - FDYS - EDAY)),(STAY_DAY2 - EDAY)) OVER_DAY," ).append("\n"); 
		query.append("                 UOM," ).append("\n"); 
		query.append("                 RATE," ).append("\n"); 
		query.append("                 FMDYS," ).append("\n"); 
		query.append("                 TODYS," ).append("\n"); 
		query.append("                 CURR_CHK," ).append("\n"); 
		query.append("                 CURR," ).append("\n"); 
		query.append("                 INV_XCH_RT," ).append("\n"); 
		query.append("                 TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                 TML_AGMT_SEQ," ).append("\n"); 
		query.append("                 TML_AGMT_VER_NO" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("        SELECT COST_CODE," ).append("\n"); 
		query.append("          CNTR_NO," ).append("\n"); 
		query.append("          TPSZ," ).append("\n"); 
		query.append("          IO," ).append("\n"); 
		query.append("          DG," ).append("\n"); 
		query.append("          STAY_DAY," ).append("\n"); 
		query.append("          STAY_DAY2," ).append("\n"); 
		query.append("          FDYS," ).append("\n"); 
		query.append("          DECODE(SIGN(PDYS), 1, PDYS, 0, 0, -1, 0) PDYS," ).append("\n"); 
		query.append("          DECODE(DECODE(SIGN(PDYS), 1, PDYS, 0, 0, -1, 0), 0, GIO_EDAY, INV_DT_EDAY) EDAY,                                  " ).append("\n"); 
		query.append("          UOM," ).append("\n"); 
		query.append("          RATE, " ).append("\n"); 
		query.append("          FMDYS," ).append("\n"); 
		query.append("          TODYS," ).append("\n"); 
		query.append("          DECODE(@[curr_cd], CURR, 'Y', 'N') CURR_CHK," ).append("\n"); 
		query.append("          CURR," ).append("\n"); 
		query.append("          1 INV_XCH_RT," ).append("\n"); 
		query.append("          TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("          TML_AGMT_SEQ," ).append("\n"); 
		query.append("          TML_AGMT_VER_NO" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT FF.PDYS-(DECODE(FF.SAT_FLG, 'Y', FF.PDYS_SAT, 0)+DECODE(FF.SUN_FLG, 'Y', FF.PDYS_SUN, 0)+DECODE(FF.HOL_FLG, 'Y', FF.PDYS_HOL, 0)) PDYS,    --PDYS 기간내의 토일휴 를 뺀다." ).append("\n"); 
		query.append("                   DECODE(FF.SAT_FLG, 'Y', FF.GIO_SAT, 0)+DECODE(FF.SUN_FLG, 'Y', FF.GIO_SUN, 0)+DECODE(FF.HOL_FLG, 'Y', FF.GIO_HOL, 0) GIO_EDAY,             --GI/GO Exclude day" ).append("\n"); 
		query.append("                   DECODE(FF.SAT_FLG, 'Y', FF.INV_DT_SAT, 0)+DECODE(FF.SUN_FLG, 'Y', FF.INV_DT_SUN, 0)+DECODE(FF.HOL_FLG, 'Y', FF.INV_DT_HOL, 0) INV_DT_EDAY, --Invoice period Exclude day" ).append("\n"); 
		query.append("                   FF.COST_CODE," ).append("\n"); 
		query.append("                   FF.CNTR_NO," ).append("\n"); 
		query.append("                   FF.TPSZ," ).append("\n"); 
		query.append("                   FF.IO," ).append("\n"); 
		query.append("                   FF.DG," ).append("\n"); 
		query.append("                   FF.STAY_DAY," ).append("\n"); 
		query.append("                   FF.FDYS," ).append("\n"); 
		query.append("                   FF.UOM," ).append("\n"); 
		query.append("                   FF.RATE," ).append("\n"); 
		query.append("                   FF.FMDYS," ).append("\n"); 
		query.append("                   FF.TODYS," ).append("\n"); 
		query.append("                   FF.CURR_CHK," ).append("\n"); 
		query.append("                   FF.CURR," ).append("\n"); 
		query.append("                   FF.STAY_DAY2," ).append("\n"); 
		query.append("                   FF.AGMT_DY," ).append("\n"); 
		query.append("                   FF.SAT_FLG," ).append("\n"); 
		query.append("                   FF.SUN_FLG," ).append("\n"); 
		query.append("                   FF.HOL_FLG," ).append("\n"); 
		query.append("                   FF.GI," ).append("\n"); 
		query.append("                   FF.GO," ).append("\n"); 
		query.append("                   FF.TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                   FF.TML_AGMT_SEQ," ).append("\n"); 
		query.append("                   FF.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("            SELECT F.COST_CODE," ).append("\n"); 
		query.append("              F.CNTR_NO," ).append("\n"); 
		query.append("              F.TPSZ," ).append("\n"); 
		query.append("              F.IO," ).append("\n"); 
		query.append("              F.DG," ).append("\n"); 
		query.append("              F.STAY_DAY," ).append("\n"); 
		query.append("              F.FDYS," ).append("\n"); 
		query.append("              DECODE(SIGN(F.PDYS-F.FDYS),-1,0,0,0,1,F.PDYS-F.FDYS) PDYS, " ).append("\n"); 
		query.append("              F.UOM," ).append("\n"); 
		query.append("              F.RATE," ).append("\n"); 
		query.append("              F.FMDYS," ).append("\n"); 
		query.append("              F.TODYS," ).append("\n"); 
		query.append("              DECODE(@[curr_cd], F.CURR, 'Y', 'N') CURR_CHK," ).append("\n"); 
		query.append("              F.CURR," ).append("\n"); 
		query.append("              F.STAY_DAY2," ).append("\n"); 
		query.append("              F.AGMT_DY," ).append("\n"); 
		query.append("              TES_WE_CNT_FNC ('SUN',     '', F.GIO_I,    F.GIO_O) GIO_SUN,  -- GI/GO 에 따른 excl day계산" ).append("\n"); 
		query.append("              TES_WE_CNT_FNC ('SAT',     '', F.GIO_I,    F.GIO_O) GIO_SAT,  -- GI/GO 에 따른 excl day계산" ).append("\n"); 
		query.append("              TES_HOL_CNT_FNC(@[yd_cd],  F.GIO_I,    F.GIO_O) GIO_HOL,  -- GI/GO 에 따른 excl day계산" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              TES_WE_CNT_FNC ('SUN',     '', F.INV_DT_I, F.INV_DT_O) INV_DT_SUN,  -- inv period 에 따른 excl day계산" ).append("\n"); 
		query.append("              TES_WE_CNT_FNC ('SAT',     '', F.INV_DT_I, F.INV_DT_O) INV_DT_SAT,  -- inv period 에 따른 excl day계산              " ).append("\n"); 
		query.append("              TES_HOL_CNT_FNC(@[yd_cd],  F.INV_DT_I, F.INV_DT_O) INV_DT_HOL,  -- inv period 에 따른 excl day계산" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              TES_WE_CNT_FNC ('SUN',     '', F.INV_DT_I, F.GIO_I) PDYS_SUN,  -- PDYS 휴일계산" ).append("\n"); 
		query.append("              TES_WE_CNT_FNC ('SAT',     '', F.INV_DT_I, F.GIO_I) PDYS_SAT,  -- PDYS 휴일계산       " ).append("\n"); 
		query.append("              TES_HOL_CNT_FNC(@[yd_cd],  F.INV_DT_I, F.GIO_I) PDYS_HOL,  -- PDYS 휴일계산" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("              F.SAT_FLG," ).append("\n"); 
		query.append("              F.SUN_FLG," ).append("\n"); 
		query.append("              F.HOL_FLG," ).append("\n"); 
		query.append("              F.GI," ).append("\n"); 
		query.append("              F.GO," ).append("\n"); 
		query.append("              F.TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("              F.TML_AGMT_SEQ," ).append("\n"); 
		query.append("              F.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT I.COST_CODE COST_CODE," ).append("\n"); 
		query.append("                  I.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                  I.TPSZ TPSZ," ).append("\n"); 
		query.append("                  I.IO IO," ).append("\n"); 
		query.append("                  I.DG DG," ).append("\n"); 
		query.append("				  --[CHM-201538576]Cal.Method가 Period이고 Exceeded G/out 존재할 때, Max는 Target End Period로 일치( 2015.10.28 조아영D )" ).append("\n"); 
		query.append("                  --DECODE([sto_dys_ind_cd], 'IO', TO_DATE(SUBSTR(TO_CHAR(I.GO, 'YYYYMMDD'), 1, 8), 'YYYYMMDD'), DECODE(I.GO, NULL, TO_DATE(replace([to_prd_dt], '-'), 'YYYYMMDD'), TO_DATE(SUBSTR(TO_CHAR(I.GO, 'YYYYMMDD'), 1, 8), 'YYYYMMDD'))) - TO_DATE(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDD'), 1, 8), 'YYYYMMDD') + DECODE(D.CMNC_HRMNT, '2400', 1, '0000', 0, DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT) - TO_NUMBER(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDDHH24MI'), 9, 4))), -1, 0, 0, 0, 1)) STAY_DAY," ).append("\n"); 
		query.append("				  DECODE(@[sto_dys_ind_cd], 'IO', TO_DATE(SUBSTR(TO_CHAR(I.GO, 'YYYYMMDD'), 1, 8), 'YYYYMMDD'), DECODE(I.GO, NULL, TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD'), DECODE(SIGN(TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD') - I.GO), 1, TO_DATE(SUBSTR(TO_CHAR(I.GO, 'YYYYMMDD'), 1, 8), 'YYYYMMDD'), TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD')))) " ).append("\n"); 
		query.append("				  - TO_DATE(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDD'), 1, 8), 'YYYYMMDD') " ).append("\n"); 
		query.append("				  + DECODE(D.CMNC_HRMNT, '2400', 1, '0000', 0, DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT) - TO_NUMBER(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDDHH24MI'), 9, 4))), -1, 0, 0, 0, 1)) AS STAY_DAY, -- SP 기준일경우 TO PRD DATE 기준으로 적용 변경 (2015-10-26)" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  --DECODE([sto_dys_ind_cd], 'IO', I.GO, DECODE(I.GO, NULL, TO_DATE(replace([to_prd_dt], '-'), 'YYYYMMDD'), I.GO)) GIO_O," ).append("\n"); 
		query.append("                  DECODE(@[sto_dys_ind_cd], 'IO', I.GO, DECODE(I.GO, NULL, TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD'), DECODE(SIGN(TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD') - I.GO), 1, I.GO,TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD')))) GIO_O, -- SP 기준일경우 TO PRD DATE 기준으로 적용 변경 (2015-10-26)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				  I.GI + DECODE(D.CMNC_HRMNT, '2400', 1, '0000', 0, DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT) - TO_NUMBER(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDDHH24MI'), 9, 4))), -1, 0, 0, 0, 1)) GIO_I," ).append("\n"); 
		query.append("                  --DECODE(I.GO, NULL, TO_DATE(replace([to_prd_dt], '-'), 'YYYYMMDD'), I.GO) INV_DT_O," ).append("\n"); 
		query.append("				  DECODE(I.GO, NULL, TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD'), DECODE(SIGN(TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD') - I.GO), 1, I.GO,TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD'))) INV_DT_O, -- SP 기준일경우 TO PRD DATE 기준으로 적용 변경 (2015-10-26)	" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("				  TO_DATE(replace(@[fm_prd_dt], '-'), 'YYYYMMDD') + DECODE(D.CMNC_HRMNT, '2400', 1, '0000', 0, DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT) - TO_NUMBER(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDDHH24MI'), 9, 4))), -1, 0, 0, 0, 1)) INV_DT_I, -- 2012.05.21 수정" ).append("\n"); 
		query.append("                  --DECODE(I.GO, NULL, TO_DATE(replace([to_prd_dt], '-'), 'YYYYMMDD'), TO_DATE(SUBSTR(TO_CHAR(I.GO, 'YYYYMMDD'), 1, 8), 'YYYYMMDD')) - TO_DATE(SUBSTR(TO_CHAR(TO_DATE(replace([fm_prd_dt], '-'), 'YYYYMMDD'), 'YYYYMMDD'), 1, 8), 'YYYYMMDD') + DECODE(D.CMNC_HRMNT, '2400', 1, '0000', 0, DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT) - TO_NUMBER(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDDHH24MI'), 9, 4))), -1, 0, 0, 0, 1)) STAY_DAY2, -- 2012.05.21 수정" ).append("\n"); 
		query.append("                  DECODE(I.GO, NULL, TO_DATE(replace(@[to_prd_dt],'-'), 'YYYYMMDD'), DECODE(SIGN(TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD') - I.GO), 1, TO_DATE(SUBSTR(TO_CHAR(I.GO, 'YYYYMMDD'), 1, 8), 'YYYYMMDD'), TO_DATE(replace(@[to_prd_dt], '-'), 'YYYYMMDD'))) " ).append("\n"); 
		query.append("				  - TO_DATE(SUBSTR(TO_CHAR(TO_DATE(replace(@[fm_prd_dt],'-'), 'YYYYMMDD'), 'YYYYMMDD'), 1, 8), 'YYYYMMDD') " ).append("\n"); 
		query.append("				  + DECODE(D.CMNC_HRMNT, '2400', 1, '0000', 0, DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT) - TO_NUMBER(SUBSTR(TO_CHAR(I.GI, 'YYYYMMDDHH24MI'), 9, 4))), -1, 0, 0, 0, 1))  AS STAY_DAY2, -- SP 기준일경우 TO PRD DATE 기준으로 적용 변경 (2015-10-26)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				  NVL(DECODE(DC.AGMT_DYS, NULL, D.FT_DYS, 0, D.FT_DYS, DC.AGMT_DYS), 0) FDYS," ).append("\n"); 
		query.append("                  DECODE(@[sto_dys_ind_cd], 'IO', 0, TO_DATE(replace(@[fm_prd_dt], '-'), 'YYYYMMDD') - TO_DATE(TO_CHAR(I.GI, 'YYYYMMDD'), 'YYYYMMDD')) PDYS," ).append("\n"); 
		query.append("                  RD.TML_AGMT_VOL_UT_CD UOM," ).append("\n"); 
		query.append("                  DECODE(RD.TML_AGMT_VOL_UT_CD, 'C', RC.AGMT_RT, RD.AGMT_UT_RT) RATE," ).append("\n"); 
		query.append("                  RD.FM_TR_DYS FMDYS," ).append("\n"); 
		query.append("                  RD.TO_TR_DYS TODYS," ).append("\n"); 
		query.append("                  I.GI GI," ).append("\n"); 
		query.append("                  I.GO GO," ).append("\n"); 
		query.append("                  E.SAT_FLG SAT_FLG," ).append("\n"); 
		query.append("                  E.SUN_FLG SUN_FLG," ).append("\n"); 
		query.append("                  E.HOL_FLG HOL_FLG," ).append("\n"); 
		query.append("                  D.CMNC_HRMNT CMNC," ).append("\n"); 
		query.append("                  DC.AGMT_DYS AGMT_DY," ).append("\n"); 
		query.append("                  H.TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                  H.TML_AGMT_SEQ," ).append("\n"); 
		query.append("                  H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("                  D.CURR_CD CURR," ).append("\n"); 
		query.append("                  I.RC_FLG" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT DECODE(LOCL_TS_IND_CD, 'T', DECODE(SUBSTR(C.COST_CODE, 5, 2), 'TS', C.COST_CODE), -- 수정(20070522)" ).append("\n"); 
		query.append("                          DECODE(CNTR_STY_CD, 'F', DECODE(SUBSTR(C.COST_CODE, 5, 2), 'FL', C.COST_CODE), -- 수정(20070522)" ).append("\n"); 
		query.append("                              DECODE(SUBSTR(C.COST_CODE, 5, 2), 'MT', C.COST_CODE))) COST_CODE,-- 수정(20070522)" ).append("\n"); 
		query.append("                      L.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                      L.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("                      L.IO_BND_CD IO," ).append("\n"); 
		query.append("                      NVL(L.DCGO_CLSS_CD, 'N') DG," ).append("\n"); 
		query.append("                      H.VNDR_SEQ VNDR," ).append("\n"); 
		query.append("                      H.YD_CD YD," ).append("\n"); 
		query.append("                      L.INV_GATE_OUT_DT GO," ).append("\n"); 
		query.append("                      L.INV_GATE_IN_DT GI," ).append("\n"); 
		query.append("                      L.RC_FLG," ).append("\n"); 
		query.append("                      NVL(L.AWK_CGO_FLG, 'N') AWK_CGO_FLG," ).append("\n"); 
		query.append("                      L.CNTR_STY_CD" ).append("\n"); 
		query.append("                    FROM TES_TML_SO_CNTR_LIST L," ).append("\n"); 
		query.append("                      TES_TML_SO_HDR H," ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                        SELECT C.LGS_COST_CD COST_CODE" ).append("\n"); 
		query.append("                        FROM TES_TML_SO_COST C" ).append("\n"); 
		query.append("                        WHERE C.STO_INV_FLG = 'Y'" ).append("\n"); 
		query.append("                          AND C.COST_CALC_MZD_CD = 'A' ) C" ).append("\n"); 
		query.append("                    WHERE VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append("                      AND L.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                      AND L.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("                      AND DECODE(LOCL_TS_IND_CD, 'T', 'TS', DECODE(CNTR_STY_CD, 'F', 'FL', 'MT')) = SUBSTR(C.COST_CODE, 5, 2) -- 수정(20070522)" ).append("\n"); 
		query.append("                      AND L.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND L.TML_SO_SEQ = H.TML_SO_SEQ" ).append("\n"); 
		query.append("                      AND DECODE(@[sto_dys_ind_cd], 'IO', DECODE(L.INV_GATE_OUT_DT, NULL, 'DT', 'IO'), 'DT') = DECODE(@[sto_dys_ind_cd], 'IO', 'IO', 'DT') ) I," ).append("\n"); 
		query.append("                  TES_TML_AGMT_HDR H," ).append("\n"); 
		query.append("                  TES_TML_AGMT_DTL D," ).append("\n"); 
		query.append("                  TES_TML_AGMT_TP_SZ DC," ).append("\n"); 
		query.append("                  TES_TML_AGMT_APLY_DY E," ).append("\n"); 
		query.append("                  TES_TML_AGMT_DG_CGO_CLSS G," ).append("\n"); 
		query.append("                  TES_TML_AGMT_DTL RD," ).append("\n"); 
		query.append("                  TES_TML_AGMT_TP_SZ RC," ).append("\n"); 
		query.append("                  TES_TML_AGMT_DG_CGO_CLSS R" ).append("\n"); 
		query.append("                WHERE H.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                  AND H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("                  AND H.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND TO_CHAR(H.EFF_FM_DT, 'YYYYMMDD') <= replace(@[fm_prd_dt], '-')" ).append("\n"); 
		query.append("                  AND TO_CHAR(H.EFF_TO_DT, 'YYYYMMDD') >= replace(@[fm_prd_dt], '-')" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_VER_NO = (" ).append("\n"); 
		query.append("                    SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                    FROM TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                    WHERE M.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                      AND M.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("                      AND M.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("                      AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND TO_CHAR(M.EFF_FM_DT, 'YYYYMMDD') <= replace(@[fm_prd_dt], '-')" ).append("\n"); 
		query.append("                      AND TO_CHAR(M.EFF_TO_DT, 'YYYYMMDD') >= replace(@[fm_prd_dt], '-') )" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_SEQ = D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_VER_NO = D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                  AND I.COST_CODE = D.LGS_COST_CD" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_TP_CD = 'S'" ).append("\n"); 
		query.append("                  AND D.AUTO_CALC_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND D.TML_STO_AGMT_TP_CD = 'FD'" ).append("\n"); 
		query.append("                  AND D.TML_FREE_DYS_TP_CD = 'D'" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_OFC_CTY_CD = DC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_SEQ = DC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_VER_NO = DC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_DTL_SEQ = DC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("                  AND DC.CNTR_TPSZ_CD = DECODE(I.CNTR_STY_CD, 'F', DECODE(SUBSTR(I.TPSZ, 1, 1), 'R', DECODE(I.RC_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'O', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'F', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'P', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'A', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'S', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), I.TPSZ), I.TPSZ)" ).append("\n"); 
		query.append("                  AND DC.CNTR_APLY_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("                  AND NVL(D.IO_BND_CD, 'N') = DECODE(NVL(D.IO_BND_CD, 'N'), 'N', 'N', 'S', 'S', I.IO)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_OFC_CTY_CD = E.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_SEQ = E.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_VER_NO = E.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_DTL_SEQ = E.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_OFC_CTY_CD = G.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_SEQ = G.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_VER_NO = G.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                  AND D.TML_AGMT_DTL_SEQ = G.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("                  AND DECODE(NVL(D.DCGO_APLY_TP_CD, 'N'), 'N', 'N', G.DCGO_APLY_TP_CD) = DECODE(NVL(D.DCGO_APLY_TP_CD, 'N'), 'N', 'N', 'D')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', 'N', G.DCGO_SAM_CLSS_FLG), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', 'N', 'Y'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', G.DCGO_NON_CLSS_FLG, 'N'), 'S', DECODE(I.DG, 'N', G.DCGO_NON_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', 'Y', 'N'), 'S', DECODE(I.DG, 'N', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '1', G.DCGO_N1ST_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '1', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '2', G.DCGO_N2ND_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '2', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '3', G.DCGO_N3RD_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '3', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '4', G.DCGO_N4TH_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '4', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '5', G.DCGO_N5TH_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '5', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '6', G.DCGO_N6TH_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '6', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '7', G.DCGO_N7TH_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '7', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '8', G.DCGO_N8TH_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '8', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '9', G.DCGO_N9TH_CLSS_FLG, 'N'), 'N') = DECODE(D.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '9', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_OFC_CTY_CD = RD.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_SEQ = RD.TML_AGMT_SEQ" ).append("\n"); 
		query.append("                  AND H.TML_AGMT_VER_NO = RD.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                  AND I.COST_CODE = RD.LGS_COST_CD" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_TP_CD = 'S'" ).append("\n"); 
		query.append("                  AND RD.AUTO_CALC_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND RD.TML_STO_AGMT_TP_CD = 'FD'" ).append("\n"); 
		query.append("                  AND RD.TML_FREE_DYS_TP_CD = 'R'" ).append("\n"); 
		query.append("                  AND I.COST_CODE = RD.LGS_COST_CD" ).append("\n"); 
		query.append("                  AND NVL(RD.IO_BND_CD, 'N') = DECODE(NVL(RD.IO_BND_CD, 'N'), 'N', 'N', 'S', 'S', I.IO)" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_OFC_CTY_CD = RC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_SEQ = RC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_VER_NO = RC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_DTL_SEQ = RC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("                  AND DECODE(RD.TML_AGMT_VOL_UT_CD, 'C', RC.CNTR_TPSZ_CD, 'N') = DECODE(RD.TML_AGMT_VOL_UT_CD, 'C', DECODE(I.CNTR_STY_CD, 'F', DECODE(SUBSTR(I.TPSZ, 1, 1), 'R', DECODE(I.RC_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'O', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'F', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'P', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'A', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), 'S', DECODE(I.AWK_CGO_FLG, 'Y', I.TPSZ, 'D'||SUBSTR(I.TPSZ, 2, 1)), I.TPSZ) , I.TPSZ) , 'N')" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_OFC_CTY_CD = R.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_SEQ = R.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_VER_NO = R.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                  AND RD.TML_AGMT_DTL_SEQ = R.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("                  AND DECODE(NVL(RD.DCGO_APLY_TP_CD, 'N'), 'N', 'N', R.DCGO_APLY_TP_CD) = DECODE(NVL(RD.DCGO_APLY_TP_CD, 'N'), 'N', 'N', 'R')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', 'N', R.DCGO_SAM_CLSS_FLG), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', 'N', 'Y'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', R.DCGO_NON_CLSS_FLG, 'N'), 'S', DECODE(I.DG, 'N', R.DCGO_NON_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'A', DECODE(I.DG, 'N', 'Y', 'N'), 'S', DECODE(I.DG, 'N', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '1', R.DCGO_N1ST_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '1', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '2', R.DCGO_N2ND_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '2', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '3', R.DCGO_N3RD_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '3', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '4', R.DCGO_N4TH_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '4', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '5', R.DCGO_N5TH_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '5', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '6', R.DCGO_N6TH_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '6', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '7', R.DCGO_N7TH_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '7', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '8', R.DCGO_N8TH_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '8', 'Y', 'N'), 'N')" ).append("\n"); 
		query.append("                  AND DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '9', R.DCGO_N9TH_CLSS_FLG, 'N'), 'N') = DECODE(RD.DCGO_APLY_TP_CD, 'S', DECODE(I.DG, '9', 'Y', 'N'), 'N') ) F )FF ) ) ) L," ).append("\n"); 
		query.append("      TES_LGS_COST C" ).append("\n"); 
		query.append("    WHERE L.COST_CODE = C.LGS_COST_CD(+) )" ).append("\n"); 
		query.append("WHERE ( NVL(FMDYS, 1) >= FM_DAY" ).append("\n"); 
		query.append("      OR NVL(TODYS, 999) <= TO_DAY" ).append("\n"); 
		query.append("      OR NVL(TODYS, 999) >= TO_DAY )" ).append("\n"); 
		query.append("  AND new_TO_DAY - FM_DAY >= 0" ).append("\n"); 
		query.append("GROUP BY IBFLAG, CALC_TP_CD, CALC_COST_GRP_CD, LGS_COST_CD, CNTR_NO, CNTR_TPSZ_CD, IO_BND_CD, DCGO_IND_CD, STAY_DYS, FREE_DYS, PAID_DAY, EXD_DAY, (new_TO_DAY - FM_DAY)+1, (calc_PDYS - FM_DAY)+1, VOL_TR_UT_CD, " ).append("\n"); 
		query.append("         (DECODE(SIGN(TODYS-((new_TO_DAY - FM_DAY)+1)), -1, ((new_TO_DAY - FM_DAY)+1)-TODYS, ((new_TO_DAY - FM_DAY)+1)) * RATE) * DECODE(VOL_TR_UT_CD, 'T', DECODE(CNTR_TPSZ_CD, 'D7', 2.25, 'D8', 2.4, 'D9', 2.4, 'DW', 2.65, 'DX', 2.25, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 2)), 1)," ).append("\n"); 
		query.append("         (DECODE(SIGN(TODYS-((calc_PDYS - FM_DAY)+1)), -1, ((calc_PDYS - FM_DAY)+1)-TODYS, ((calc_PDYS - FM_DAY)+1)) * RATE) * DECODE(VOL_TR_UT_CD, 'T', DECODE(CNTR_TPSZ_CD, 'D7', 2.25, 'D8', 2.4, 'D9', 2.4, 'DW', 2.65, 'DX', 2.25, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 2)), 1)," ).append("\n"); 
		query.append("         CURR_CHK, CURR_CD, INV_XCH_RT, ACCT_CD, TML_AGMT_OFC_CTY_CD, TML_AGMT_SEQ, TML_AGMT_VER_NO, TO_DAY" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD ASC, CNTR_NO ASC, CNTR_TPSZ_CD ASC, IO_BND_CD ASC, CTRT_RT ASC )" ).append("\n"); 
		query.append("WHERE DECODE(SIGN(CALC_PDYS_CALC_AMT), 1, NEW_CALC_AMT - CALC_PDYS_CALC_AMT, NEW_CALC_AMT) > 0" ).append("\n"); 

	}
}