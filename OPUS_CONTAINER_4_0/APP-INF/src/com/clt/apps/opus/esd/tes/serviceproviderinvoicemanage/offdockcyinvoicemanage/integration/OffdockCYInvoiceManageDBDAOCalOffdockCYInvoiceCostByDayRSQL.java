/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostByDayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostByDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CalOffdockCYInvoiceCostByDay
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostByDayRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostByDayRSQL").append("\n"); 
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
		query.append("#if (${agmt_cost_yn} == 'Y') " ).append("\n"); 
		query.append("WITH AGMTCOST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ltrim(regexp_substr((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                            from tes_tml_so_hdr" ).append("\n"); 
		query.append("                            where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND TML_SO_SEQ = @[tml_so_seq]), '[^|]+', 1, level ) ,'|') as cost_cd" ).append("\n"); 
		query.append(" FROM dual" ).append("\n"); 
		query.append(" connect by level<= ( length((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                from tes_tml_so_hdr" ).append("\n"); 
		query.append("                               where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND TML_SO_SEQ = @[tml_so_seq]))+1 - length(replace((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                                                                from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                                                               where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND TML_SO_SEQ = @[tml_so_seq]), '|')) ) / length('|')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  IBFLAG, CALC_TP_CD, CALC_COST_GRP_CD," ).append("\n"); 
		query.append("         LGS_COST_CD," ).append("\n"); 
		query.append("         CNTR_NO," ).append("\n"); 
		query.append("         CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         IO_BND_CD," ).append("\n"); 
		query.append("         DCGO_IND_CD," ).append("\n"); 
		query.append("         STAY_DYS," ).append("\n"); 
		query.append("         FREE_DYS," ).append("\n"); 
		query.append("         PAID_DAY," ).append("\n"); 
		query.append("         EXD_DAY FREE_DY_XCLD_DYS," ).append("\n"); 
		query.append("         (TO_DAY - FM_DAY)+1 OVR_DYS, (TO_DAY - FM_DAY)+1 OVR_DYS2," ).append("\n"); 
		query.append("         VOL_TR_UT_CD," ).append("\n"); 
		query.append("         MAX(RATE) CTRT_RT," ).append("\n"); 
		query.append("         ROUND((DECODE(SIGN(TODYS-((TO_DAY - FM_DAY)+1)),-1,((TO_DAY - FM_DAY)+1)-TODYS,((TO_DAY - FM_DAY)+1)) * RATE * INV_XCH_RT) *" ).append("\n"); 
		query.append("           DECODE(VOL_TR_UT_CD,'T',DECODE(CNTR_TPSZ_CD,'D7',2.25,'D8',2.4,'D9',2.4,'DW',2.65,'DX',2.25,DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),2,1,2)),1),2)  CALC_AMT," ).append("\n"); 
		query.append("         ROUND((DECODE(SIGN(TODYS-((TO_DAY - FM_DAY)+1)),-1,((TO_DAY - FM_DAY)+1)-TODYS,((TO_DAY - FM_DAY)+1)) * RATE * INV_XCH_RT) *" ).append("\n"); 
		query.append("           DECODE(VOL_TR_UT_CD,'T',DECODE(CNTR_TPSZ_CD,'D7',2.25,'D8',2.4,'D9',2.4,'DW',2.65,'DX',2.25,DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),2,1,2)),1),2)  INV_AMT," ).append("\n"); 
		query.append("         CURR_CHK," ).append("\n"); 
		query.append("         CURR_CD," ).append("\n"); 
		query.append("         INV_XCH_RT," ).append("\n"); 
		query.append("         ACCT_CD," ).append("\n"); 
		query.append("         TML_AGMT_OFC_CTY_CD, TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_SO_CNTR_LIST_SEQ, TO_DAY" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("   SELECT 'I' IBFLAG, 'A' CALC_TP_CD, 'SD' CALC_COST_GRP_CD, COST_CODE LGS_COST_CD, CNTR_NO, TPSZ CNTR_TPSZ_CD, IO IO_BND_CD," ).append("\n"); 
		query.append("         DG DCGO_IND_CD, STAY_DAY STAY_DYS, FDYS FREE_DYS, PDYS PAID_DAY, EDAY EXD_DAY, FMDYS, TODYS," ).append("\n"); 
		query.append("         ( CASE WHEN 0 >= NVL(FMDYS,1)" ).append("\n"); 
		query.append("                THEN 0 + 1" ).append("\n"); 
		query.append("                ELSE NVL(FMDYS,1)" ).append("\n"); 
		query.append("           END )  FM_DAY," ).append("\n"); 
		query.append("         ( CASE WHEN OVER_DAY <= NVL(TODYS,999)" ).append("\n"); 
		query.append("                THEN OVER_DAY" ).append("\n"); 
		query.append("                ELSE NVL(TODYS,999)" ).append("\n"); 
		query.append("           END )  TO_DAY," ).append("\n"); 
		query.append("         UOM VOL_TR_UT_CD, RATE, CURR_CHK, CURR CURR_CD, INV_XCH_RT, C.ACCT_CD," ).append("\n"); 
		query.append("         L.TML_AGMT_OFC_CTY_CD, L.TML_AGMT_SEQ, L.TML_AGMT_VER_NO, L.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("   SELECT COST_CODE," ).append("\n"); 
		query.append("          CNTR_NO," ).append("\n"); 
		query.append("          TPSZ," ).append("\n"); 
		query.append("          IO," ).append("\n"); 
		query.append("          DG," ).append("\n"); 
		query.append("          STAY_DAY," ).append("\n"); 
		query.append("          FDYS," ).append("\n"); 
		query.append("          DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0) PDYS," ).append("\n"); 
		query.append("          EDAY," ).append("\n"); 
		query.append("          DECODE(@[sto_dys_ind_cd],'IO'," ).append("\n"); 
		query.append("            ( DECODE(SIGN(STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("              - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0)),-1,0,0,0, STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("              - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0)))," ).append("\n"); 
		query.append("            ( DECODE(DECODE(SIGN(TO_DATE(@[fm_prd_dt],'YYYYMMDD HH24:MI') - GI),-1," ).append("\n"); 
		query.append("                SIGN((GI + DECODE(SIGN(STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("                - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0)),-1,0,0,0, STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("                - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0))) - TO_DATE(@[fm_prd_dt],'YYYYMMDD HH24:MI'))," ).append("\n"); 
		query.append("                SIGN(( TO_DATE(@[fm_prd_dt],'YYYYMMDD HH24:MI') - GI + DECODE(SIGN(STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("                - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0)),-1,0,0,0, STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("                - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0))))) ,1," ).append("\n"); 
		query.append("              ( DECODE(SIGN(STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("                 - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0)),-1,0,0,0, STAY_DAY - (FDYS+DECODE(SAT_FLG,'Y',SAT,0)+DECODE(SUN_FLG,'Y',SUN,0)+DECODE(HOL_FLG,'Y',HOL,0))" ).append("\n"); 
		query.append("                 - DECODE(SIGN(PDYS),1,PDYS,0,0,-1,0)) ), STAY_DAY2) )) OVER_DAY," ).append("\n"); 
		query.append("          UOM," ).append("\n"); 
		query.append("          RATE," ).append("\n"); 
		query.append("          FMDYS," ).append("\n"); 
		query.append("          TODYS, DECODE(@[curr_cd],CURR,'Y','N') CURR_CHK, CURR, " ).append("\n"); 
		query.append("          ROUND((SELECT USD_LOCL_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[to_prd_dt],'-'),1,6) AND CURR_CD =@[curr_cd])/(select USD_LOCL_XCH_RT from GL_MON_XCH_RT where ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[to_prd_dt],'-'),1,6) and CURR_CD = CURR),4) INV_XCH_RT," ).append("\n"); 
		query.append("          TML_AGMT_OFC_CTY_CD, TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("   FROM  (" ).append("\n"); 
		query.append("   SELECT F.COST_CODE," ).append("\n"); 
		query.append("          F.CNTR_NO," ).append("\n"); 
		query.append("          F.TPSZ," ).append("\n"); 
		query.append("          F.IO," ).append("\n"); 
		query.append("          F.DG," ).append("\n"); 
		query.append("          F.STAY_DAY," ).append("\n"); 
		query.append("          F.FDYS," ).append("\n"); 
		query.append("          F.PDYS-F.FDYS-(DECODE(F.SAT_FLG,'Y',F.SAT,0)+DECODE(F.SUN_FLG,'Y',F.SUN,0)+DECODE(F.HOL_FLG,'Y',F.HOL,0)) PDYS," ).append("\n"); 
		query.append("          DECODE(F.SAT_FLG,'Y',F.SAT,0)+DECODE(F.SUN_FLG,'Y',F.SUN,0)+DECODE(F.HOL_FLG,'Y',F.HOL,0) EDAY," ).append("\n"); 
		query.append("          F.UOM," ).append("\n"); 
		query.append("          F.RATE," ).append("\n"); 
		query.append("          F.FMDYS," ).append("\n"); 
		query.append("          F.TODYS," ).append("\n"); 
		query.append("          DECODE(@[curr_cd],F.CURR,'Y','N') CURR_CHK, F.CURR," ).append("\n"); 
		query.append("          F.STAY_DAY2, F.HOL, F.SAT, F.SUN, F.SAT_FLG, F.SUN_FLG, F.HOL_FLG, F.GI, F.GO," ).append("\n"); 
		query.append("          F.TML_AGMT_OFC_CTY_CD, F.TML_AGMT_SEQ, F.TML_AGMT_VER_NO, F.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("   FROM   (" ).append("\n"); 
		query.append("          SELECT I.COST_CODE                       COST_CODE," ).append("\n"); 
		query.append("                 I.CNTR_NO                         CNTR_NO," ).append("\n"); 
		query.append("                 I.TPSZ                            TPSZ," ).append("\n"); 
		query.append("                 I.IO                              IO," ).append("\n"); 
		query.append("                 I.DG                              DG," ).append("\n"); 
		query.append("                 DECODE(@[sto_dys_ind_cd],'IO',TO_DATE(SUBSTR(TO_CHAR(I.GO,'YYYYMMDD'),1,8),'YYYYMMDD')," ).append("\n"); 
		query.append("                   DECODE(I.GO,NULL,TO_DATE(@[to_prd_dt],'YYYYMMDD'),DECODE(SIGN(@[to_prd_dt]-TO_CHAR(I.GO,'YYYYMMDD')),-1,TO_DATE(@[to_prd_dt],'YYYYMMDD'),TO_DATE(SUBSTR(TO_CHAR(I.GO,'YYYYMMDD'),1,8),'YYYYMMDD'))))" ).append("\n"); 
		query.append("                   - TO_DATE(SUBSTR(TO_CHAR(I.GI,'YYYYMMDD'),1,8),'YYYYMMDD')" ).append("\n"); 
		query.append("                   + DECODE(D.CMNC_HRMNT,'2400',1,'0000',0,DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT)" ).append("\n"); 
		query.append("                   - TO_NUMBER(SUBSTR(TO_CHAR(I.GI,'YYYYMMDDHH24MI'),9,4))),-1,0,0,0,1)) STAY_DAY," ).append("\n"); 
		query.append("                 DECODE(I.GO,NULL,TO_DATE(@[to_prd_dt],'YYYYMMDD'),TO_DATE(SUBSTR(TO_CHAR(I.GO,'YYYYMMDD'),1,8),'YYYYMMDD'))" ).append("\n"); 
		query.append("                   - TO_DATE(SUBSTR(TO_CHAR(TO_DATE(@[fm_prd_dt],'YYYYMMDD'),'YYYYMMDD'),1,8),'YYYYMMDD')" ).append("\n"); 
		query.append("                   + DECODE(D.CMNC_HRMNT,'2400',1,'0000',0,DECODE(SIGN(TO_NUMBER(D.CMNC_HRMNT)" ).append("\n"); 
		query.append("                   - TO_NUMBER(SUBSTR(TO_CHAR(I.GI,'YYYYMMDDHH24MI'),9,4))),-1,0,0,0,1)) STAY_DAY2," ).append("\n"); 
		query.append("                 NVL(DECODE(DC.AGMT_DYS,NULL,D.FT_DYS,0,D.FT_DYS,DC.AGMT_DYS),0) FDYS," ).append("\n"); 
		query.append("                 DECODE(@[sto_dys_ind_cd],'IO',0,TO_DATE(@[fm_prd_dt],'YYYYMMDD') - TO_DATE(TO_CHAR(I.GI,'YYYYMMDD'),'YYYYMMDD')) PDYS," ).append("\n"); 
		query.append("                 RD.TML_AGMT_VOL_UT_CD              UOM," ).append("\n"); 
		query.append("                 DECODE(RD.TML_AGMT_VOL_UT_CD,'C',RC.AGMT_RT,RD.AGMT_UT_RT) RATE," ).append("\n"); 
		query.append("                 RD.FM_TR_DYS FMDYS," ).append("\n"); 
		query.append("                 RD.TO_TR_DYS TODYS," ).append("\n"); 
		query.append("                 I.GI GI," ).append("\n"); 
		query.append("                 I.GO GO," ).append("\n"); 
		query.append("                 E.SAT_FLG SAT_FLG," ).append("\n"); 
		query.append("                 E.SUN_FLG SUN_FLG," ).append("\n"); 
		query.append("                 E.HOL_FLG HOL_FLG," ).append("\n"); 
		query.append("                 D.CMNC_HRMNT CMNC," ).append("\n"); 
		query.append("                 TES_WE_CNT_FNC('SUN',DC.AGMT_DYS,I.GI,I.GO) SUN," ).append("\n"); 
		query.append("                 TES_WE_CNT_FNC('SAT',DC.AGMT_DYS,I.GI,I.GO) SAT," ).append("\n"); 
		query.append("                 TES_HOL_CNT_FNC(@[yd_cd],I.GI,I.GO) HOL," ).append("\n"); 
		query.append("                 H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, I.TML_SO_CNTR_LIST_SEQ, D.CURR_CD CURR, I.RC_FLG" ).append("\n"); 
		query.append("          FROM ( SELECT DECODE(CNTR_STY_CD,'F',DECODE(SUBSTR(C.COST_CODE,5,2),'FL',C.COST_CODE)," ).append("\n"); 
		query.append("                          DECODE(SUBSTR(C.COST_CODE,5,2),'MT',C.COST_CODE)) COST_CODE," ).append("\n"); 
		query.append("                        L.CNTR_NO           CNTR_NO," ).append("\n"); 
		query.append("                        L.CNTR_STY_CD," ).append("\n"); 
		query.append("                        L.CNTR_TPSZ_CD      TPSZ," ).append("\n"); 
		query.append("                        L.IO_BND_CD         IO," ).append("\n"); 
		query.append("                        NVL(L.DCGO_CLSS_CD,'N')      DG," ).append("\n"); 
		query.append("                        H.VNDR_SEQ          VNDR," ).append("\n"); 
		query.append("                        H.YD_CD             YD," ).append("\n"); 
		query.append("                        --L.INV_GATE_OUT_DT   GO," ).append("\n"); 
		query.append("                        --L.INV_GATE_IN_DT    GI,   --GI,GO가 Null일때 Invoice Period를 넣는것으로 변경 2016.01.14" ).append("\n"); 
		query.append("						NVL(L.INV_GATE_OUT_DT,TO_DATE(@[to_prd_dt],'YYYYMMDD')) GO," ).append("\n"); 
		query.append("                        NVL(L.INV_GATE_IN_DT, TO_DATE(@[fm_prd_dt],'YYYYMMDD')) GI," ).append("\n"); 
		query.append("                        L.RC_FLG, L.TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("                        L.AWK_CGO_FLG" ).append("\n"); 
		query.append("                 FROM   TES_TML_SO_CNTR_LIST L, TES_TML_SO_HDR H," ).append("\n"); 
		query.append("                        ( SELECT C.LGS_COST_CD COST_CODE" ).append("\n"); 
		query.append("                          FROM   TES_TML_SO_COST C" ).append("\n"); 
		query.append("                          WHERE  C.FDCK_CY_STO_FLG  = 'Y'" ).append("\n"); 
		query.append("                          AND    C.COST_CALC_MZD_CD = 'A' ) C" ).append("\n"); 
		query.append("                 WHERE  VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("                 AND    L.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                 AND    L.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("                 AND    DECODE(L.CNTR_STY_CD,'F','FL','MT') = SUBSTR(C.COST_CODE,5,2)" ).append("\n"); 
		query.append("                 AND    L.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                 AND    L.TML_SO_SEQ        = H.TML_SO_SEQ" ).append("\n"); 
		query.append("                 AND    DECODE(@[sto_dys_ind_cd],'IO',DECODE(L.INV_GATE_OUT_DT,NULL,'DT','IO'),'DT') = DECODE(@[sto_dys_ind_cd],'IO','IO','DT')" ).append("\n"); 
		query.append("                 ) I," ).append("\n"); 
		query.append("                 TES_TML_AGMT_HDR H, TES_TML_AGMT_DTL D, TES_TML_AGMT_TP_SZ DC, TES_TML_AGMT_APLY_DY E," ).append("\n"); 
		query.append("                 TES_TML_AGMT_DG_CGO_CLSS G, TES_TML_AGMT_DTL RD, TES_TML_AGMT_TP_SZ RC, TES_TML_AGMT_DG_CGO_CLSS R" ).append("\n"); 
		query.append("          WHERE  H.YD_CD           = @[yd_cd]" ).append("\n"); 
		query.append("          AND    H.VNDR_SEQ        = @[vndr_seq]" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("          AND    H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("          AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= @[fm_prd_dt]" ).append("\n"); 
		query.append("          AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= @[fm_prd_dt]" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                                       FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                                       WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                                       AND    M.VNDR_SEQ            =  @[vndr_seq]" ).append("\n"); 
		query.append("                                       AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                                       AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                                       AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= @[fm_prd_dt]" ).append("\n"); 
		query.append("                                       AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= @[fm_prd_dt] )" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_OFC_CTY_CD  = D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_SEQ         = D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_VER_NO      = D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("          AND    I.COST_CODE            = D.LGS_COST_CD" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_TP_CD       = 'S'" ).append("\n"); 
		query.append("          AND    D.AUTO_CALC_FLG        = 'Y'" ).append("\n"); 
		query.append("          AND    D.TML_STO_AGMT_TP_CD   = 'FD'" ).append("\n"); 
		query.append("          AND    D.TML_FREE_DYS_TP_CD   = 'D'" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_OFC_CTY_CD  = DC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_SEQ         = DC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_VER_NO      = DC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_DTL_SEQ     = DC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("          AND    DC.CNTR_TPSZ_CD        = DECODE(SUBSTR(I.TPSZ,1,1),'R',DECODE(I.RC_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("                                                                    'T',DECODE(I.RC_FLG,'Y','R'||SUBSTR(I.TPSZ,2,1),I.TPSZ)," ).append("\n"); 
		query.append("                                                                    'O',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("                                                                    'F',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("                                                                    'P',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("                                                                    'A',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("                                                                    'S',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("                                                                    I.TPSZ)" ).append("\n"); 
		query.append("          AND    DC.CNTR_APLY_TP_CD(+)  = 'D'" ).append("\n"); 
		query.append("          AND    NVL(D.IO_BND_CD,'N')  = DECODE(NVL(D.IO_BND_CD,'N'),'N','N','S','S',I.IO)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_OFC_CTY_CD  = E.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_SEQ         = E.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_VER_NO      = E.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_DTL_SEQ     = E.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_OFC_CTY_CD  = G.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_SEQ         = G.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_VER_NO      = G.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("          AND    D.TML_AGMT_DTL_SEQ     = G.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("          AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',G.DCGO_APLY_TP_CD) = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N','D')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N','N',G.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N',G.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(I.DG,'N',G.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N','Y','N'),'S',DECODE(I.DG,'N','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'1',G.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'1','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'2',G.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'2','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'3',G.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'3','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'4',G.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'4','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'5',G.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'5','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'6',G.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'6','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'7',G.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'7','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'8',G.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'8','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'9',G.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(D.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'9','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_OFC_CTY_CD  = RD.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_SEQ         = RD.TML_AGMT_SEQ" ).append("\n"); 
		query.append("          AND    H.TML_AGMT_VER_NO      = RD.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("          AND    I.COST_CODE            = RD.LGS_COST_CD" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_TP_CD      = 'S'" ).append("\n"); 
		query.append("          AND    RD.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append("          AND    RD.TML_STO_AGMT_TP_CD  = 'FD'" ).append("\n"); 
		query.append("          AND    RD.TML_FREE_DYS_TP_CD  = 'R'" ).append("\n"); 
		query.append("          AND    I.COST_CODE            = RD.LGS_COST_CD" ).append("\n"); 
		query.append("          AND    NVL(RD.IO_BND_CD,'N')  = DECODE(NVL(RD.IO_BND_CD,'N'),'N','N','S','S',I.IO)" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_OFC_CTY_CD  = RC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_SEQ         = RC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_VER_NO      = RC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_DTL_SEQ     = RC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("  AND    DECODE(RD.TML_AGMT_VOL_UT_CD,'C',RC.CNTR_TPSZ_CD,'N') = DECODE(RD.TML_AGMT_VOL_UT_CD,'C',DECODE(SUBSTR(I.TPSZ,1,1),'R',DECODE(I.RC_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("                                                                                                                            'T',DECODE(I.RC_FLG,'Y','R'||SUBSTR(I.TPSZ,2,1),I.TPSZ)," ).append("\n"); 
		query.append("	   					                                                                                                    'O',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("	   					                                                                                                    'F',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("	   					                                                                                                    'P',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("	   					                                                                                                    'A',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("	   					                                                                                                    'S',DECODE(I.AWK_CGO_FLG,'Y',I.TPSZ,DECODE(I.CNTR_STY_CD,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1)))," ).append("\n"); 
		query.append("	   					                                                                                                    I.TPSZ),  'N')" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_OFC_CTY_CD  = R.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_SEQ         = R.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_VER_NO      = R.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("          AND    RD.TML_AGMT_DTL_SEQ     = R.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("          AND    DECODE(NVL(RD.DCGO_APLY_TP_CD,'N'),'N','N',R.DCGO_APLY_TP_CD) = DECODE(NVL(RD.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N','N',R.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N',R.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(I.DG,'N',R.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'A',DECODE(I.DG,'N','Y','N'),'S',DECODE(I.DG,'N','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'1',R.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'1','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'2',R.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'2','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'3',R.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'3','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'4',R.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'4','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'5',R.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'5','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'6',R.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'6','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'7',R.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'7','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'8',R.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'8','Y','N'),'N')" ).append("\n"); 
		query.append("          AND    DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'9',R.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("                 = DECODE(RD.DCGO_APLY_TP_CD,'S',DECODE(I.DG,'9','Y','N'),'N') ) F ) ) L, TES_LGS_COST C" ).append("\n"); 
		query.append("   WHERE    L.COST_CODE = C.LGS_COST_CD(+) )" ).append("\n"); 
		query.append(" WHERE    ( NVL(FMDYS,1) >= FM_DAY" ).append("\n"); 
		query.append("            OR     NVL(TODYS,999) <= TO_DAY" ).append("\n"); 
		query.append("            OR     NVL(TODYS,999) >= TO_DAY )" ).append("\n"); 
		query.append(" AND  TO_DAY - FM_DAY >= 0" ).append("\n"); 
		query.append(" GROUP BY IBFLAG, CALC_TP_CD, CALC_COST_GRP_CD, LGS_COST_CD, CNTR_NO, CNTR_TPSZ_CD, IO_BND_CD, DCGO_IND_CD, STAY_DYS," ).append("\n"); 
		query.append("          FREE_DYS, PAID_DAY, EXD_DAY, (TO_DAY - FM_DAY)+1, VOL_TR_UT_CD," ).append("\n"); 
		query.append("          (DECODE(SIGN(TODYS-((TO_DAY - FM_DAY)+1)),-1,((TO_DAY - FM_DAY)+1)-TODYS,((TO_DAY - FM_DAY)+1)) * RATE * INV_XCH_RT) *" ).append("\n"); 
		query.append("            DECODE(VOL_TR_UT_CD,'T',DECODE(CNTR_TPSZ_CD,'D7',2.25,'D8',2.4,'D9',2.4,'DW',2.65,'DX',2.25,DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),2,1,2)),1)," ).append("\n"); 
		query.append("          CURR_CHK, CURR_CD, INV_XCH_RT, ACCT_CD, TML_AGMT_OFC_CTY_CD, TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_SO_CNTR_LIST_SEQ, TO_DAY" ).append("\n"); 
		query.append(" ORDER BY LGS_COST_CD ASC, CNTR_NO ASC, CNTR_TPSZ_CD ASC, IO_BND_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_cost_yn} == 'Y') " ).append("\n"); 
		query.append(") A, AGMTCOST B" ).append("\n"); 
		query.append("WHERE A.LGS_COST_CD = B.COST_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}