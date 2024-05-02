/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLseparateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLseparateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CalOffdockCYInvoiceCostTMNLseparate
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLseparateRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLseparateRSQL").append("\n"); 
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
		query.append("SELECT 'I' IBFLAG, 'A' CALC_TP_CD, 'TM' CALC_COST_GRP_CD," ).append("\n"); 
		query.append("       L.LGS_COST_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DCGO_CLSS_CD  DCGO_IND_CD," ).append("\n"); 
		query.append("       CALC_VOL_QTY," ).append("\n"); 
		query.append("       RVIS_VOL_QTY," ).append("\n"); 
		query.append("       VOL_TR_UT_CD," ).append("\n"); 
		query.append("       CTRT_RT," ).append("\n"); 
		query.append("       CALC_VOL_QTY * CTRT_RT INV_AMT,     -- 수정(20070514)" ).append("\n"); 
		query.append("       CALC_VOL_QTY * CTRT_RT CALC_AMT,    -- 수정(20070514)" ).append("\n"); 
		query.append("       C.ACCT_CD," ).append("\n"); 
		query.append("       L.TML_AGMT_OFC_CTY_CD, L.TML_AGMT_SEQ, L.TML_AGMT_VER_NO, L.CURR_CHK, CURR_CD, 1 INV_XCH_RT, DECODE(L.RC_FLG,'Y','Y','N') RC_FLG," ).append("\n"); 
		query.append("	   TML_TRNS_MOD_CD -- 2015.09.10 [CHM-201537696]ODCY Invoice에서 CTM의 Mode와 I/O 구분 Verify 기준으로 가지고 오기" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD," ).append("\n"); 
		query.append("       L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD," ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_IN_DT,NULL,0,DECODE(SIGN(TO_CHAR(L.INV_GATE_IN_DT,'YYYYMMDD')-@[fm_prd_dt]),-1,0,1))) +" ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_OUT_DT,NULL,0,DECODE(SIGN(@[to_prd_dt]-TO_CHAR(L.INV_GATE_OUT_DT,'YYYYMMDD')),-1,0,1))) CALC_VOL_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_IN_DT,NULL,0,DECODE(SIGN(TO_CHAR(L.INV_GATE_IN_DT,'YYYYMMDD')-@[fm_prd_dt]),-1,0,1))) +" ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_OUT_DT,NULL,0,DECODE(SIGN(@[to_prd_dt]-TO_CHAR(L.INV_GATE_OUT_DT,'YYYYMMDD')),-1,0,1))) RVIS_VOL_QTY," ).append("\n"); 
		query.append("       TD.TML_AGMT_VOL_UT_CD VOL_TR_UT_CD," ).append("\n"); 
		query.append("       DECODE(TD.TML_AGMT_VOL_UT_CD,'C',TC.AGMT_RT,TD.AGMT_UT_RT) CTRT_RT," ).append("\n"); 
		query.append("       H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, DECODE(@[curr_cd],TD.CURR_CD,'Y','N') CURR_CHK, TD.CURR_CD, DECODE(L.RC_FLG,'Y','Y','N') RC_FLG, -- 수정(20071107)" ).append("\n"); 
		query.append("	   NVL(L.TML_TRNS_MOD_CD,'S') TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("FROM   TES_TML_SO_CNTR_LIST L, TES_TML_AGMT_HDR H," ).append("\n"); 
		query.append("       TES_TML_AGMT_DTL TD, TES_TML_AGMT_TP_SZ TC, TES_TML_AGMT_DG_CGO_CLSS TG" ).append("\n"); 
		query.append("WHERE  L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("AND    L.TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    L.TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append("AND    H.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("AND    H.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("AND    H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt]" ).append("\n"); 
		query.append("AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                             FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                             WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                             AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                             AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                             AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                             AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("                             AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt] )" ).append("\n"); 
		query.append("AND    H.TML_AGMT_OFC_CTY_CD = TD.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    H.TML_AGMT_SEQ        = TD.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    H.TML_AGMT_VER_NO     = TD.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') = TD.LGS_COST_CD" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_TP_CD     = 'T'" ).append("\n"); 
		query.append("AND    TD.AUTO_CALC_FLG      = 'Y'" ).append("\n"); 
		query.append("AND    NVL(TD.THC_TP_CD,'T') = 'T'" ).append("\n"); 
		query.append("AND    NVL(TD.IO_BND_CD,'N') = DECODE(NVL(TD.IO_BND_CD,'N'),'N','N','S','S',L.IO_BND_CD)" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_OFC_CTY_CD = TC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_SEQ        = TC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_VER_NO     = TC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_DTL_SEQ    = TC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(TD.TML_AGMT_VOL_UT_CD,'C',TC.CNTR_TPSZ_CD,'N') " ).append("\n"); 
		query.append("        = DECODE(TD.TML_AGMT_VOL_UT_CD,'C',DECODE(L.CNTR_STY_CD,'F',DECODE(SUBSTR(L.CNTR_TPSZ_CD,1,1),'O',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'F',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'P',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'A',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'S',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                          L.CNTR_TPSZ_CD),L.CNTR_TPSZ_CD),'N')" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_OFC_CTY_CD = TG.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_SEQ        = TG.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_VER_NO     = TG.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    TD.TML_AGMT_DTL_SEQ    = TG.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'N','N',TG.DCGO_APLY_TP_CD) = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N',TG.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N',TG.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(L.DCGO_CLSS_CD,'N',TG.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1',TG.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2',TG.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3',TG.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4',TG.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5',TG.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6',TG.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7',TG.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8',TG.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9',TG.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append("AND    NVL(L.TML_TRNS_MOD_CD,'S') = DECODE(NVL(TD.TML_TRNS_MOD_CD,'S'),'S',NVL(L.TML_TRNS_MOD_CD,'S'),NVL(TD.TML_TRNS_MOD_CD,'S'))" ).append("\n"); 
		query.append("GROUP BY DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT')," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD, TD.TML_AGMT_VOL_UT_CD," ).append("\n"); 
		query.append("        DECODE(TD.TML_AGMT_VOL_UT_CD,'C',TC.AGMT_RT,TD.AGMT_UT_RT)," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, TD.CURR_CD, DECODE(L.RC_FLG,'Y','Y','N'),  -- 수정(20071107)" ).append("\n"); 
		query.append("		NVL(L.TML_TRNS_MOD_CD,'S')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD," ).append("\n"); 
		query.append("       L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD," ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_IN_DT,NULL,0,DECODE(SIGN(TO_CHAR(L.INV_GATE_IN_DT,'YYYYMMDD')-@[fm_prd_dt]),-1,0,1))) +" ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_OUT_DT,NULL,0,DECODE(SIGN(@[to_prd_dt]-TO_CHAR(L.INV_GATE_OUT_DT,'YYYYMMDD')),-1,0,1))) CALC_VOL_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_IN_DT,NULL,0,DECODE(SIGN(TO_CHAR(L.INV_GATE_IN_DT,'YYYYMMDD')-@[fm_prd_dt]),-1,0,1))) +" ).append("\n"); 
		query.append("       SUM(DECODE(L.INV_GATE_OUT_DT,NULL,0,DECODE(SIGN(@[to_prd_dt]-TO_CHAR(L.INV_GATE_OUT_DT,'YYYYMMDD')),-1,0,1))) RVIS_VOL_QTY," ).append("\n"); 
		query.append("       LD.TML_AGMT_VOL_UT_CD VOL_TR_UT_CD ," ).append("\n"); 
		query.append("       DECODE(LD.TML_AGMT_VOL_UT_CD,'C',LC.AGMT_RT+GC.AGMT_RT,LD.AGMT_UT_RT+GD.AGMT_UT_RT) CTRT_RT," ).append("\n"); 
		query.append("       H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, DECODE(@[curr_cd],LD.CURR_CD,'Y','N') CURR_CHK, LD.CURR_CD, DECODE(L.RC_FLG,'Y','Y','N') RC_FLG,  -- 수정(20071107)" ).append("\n"); 
		query.append("	   NVL(L.TML_TRNS_MOD_CD,'S') TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("FROM   TES_TML_SO_CNTR_LIST L, TES_TML_AGMT_HDR H," ).append("\n"); 
		query.append("       TES_TML_AGMT_DTL LD, TES_TML_AGMT_TP_SZ LC, TES_TML_AGMT_DG_CGO_CLSS LG," ).append("\n"); 
		query.append("       TES_TML_AGMT_DTL GD, TES_TML_AGMT_TP_SZ GC, TES_TML_AGMT_DG_CGO_CLSS GG" ).append("\n"); 
		query.append("WHERE  L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("AND    L.TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    L.TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append("AND    H.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("AND    H.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("AND    H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt]" ).append("\n"); 
		query.append("AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                             FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                             WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                             AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                             AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                             AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                             AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("                             AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt] )" ).append("\n"); 
		query.append("AND    H.TML_AGMT_OFC_CTY_CD = LD.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    H.TML_AGMT_SEQ        = LD.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    H.TML_AGMT_VER_NO     = LD.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') = LD.LGS_COST_CD" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_TP_CD     = 'T'" ).append("\n"); 
		query.append("AND    LD.AUTO_CALC_FLG      = 'Y'" ).append("\n"); 
		query.append("AND    NVL(LD.THC_TP_CD,'T') = 'L'" ).append("\n"); 
		query.append("AND    NVL(LD.IO_BND_CD,'N') = DECODE(NVL(LD.IO_BND_CD,'N'),'N','N','S','S',L.IO_BND_CD)" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_OFC_CTY_CD = LC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_SEQ        = LC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_VER_NO     = LC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_DTL_SEQ    = LC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(LD.TML_AGMT_VOL_UT_CD,'C',LC.CNTR_TPSZ_CD,'N') " ).append("\n"); 
		query.append("        = DECODE(LD.TML_AGMT_VOL_UT_CD,'C',DECODE(L.CNTR_STY_CD,'F',DECODE(SUBSTR(L.CNTR_TPSZ_CD,1,1),'O',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'F',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'P',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'A',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'S',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                          L.CNTR_TPSZ_CD),L.CNTR_TPSZ_CD),'N')" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_OFC_CTY_CD = LG.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_SEQ        = LG.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_VER_NO     = LG.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    LD.TML_AGMT_DTL_SEQ    = LG.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'N','N',LG.DCGO_APLY_TP_CD) = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N',LG.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N',LG.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(L.DCGO_CLSS_CD,'N',LG.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1',LG.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2',LG.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3',LG.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4',LG.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5',LG.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6',LG.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7',LG.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8',LG.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9',LG.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append("AND    H.TML_AGMT_OFC_CTY_CD = GD.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    H.TML_AGMT_SEQ        = GD.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    H.TML_AGMT_VER_NO     = GD.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') = GD.LGS_COST_CD" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_TP_CD     = 'T'" ).append("\n"); 
		query.append("AND    GD.AUTO_CALC_FLG      = 'Y'" ).append("\n"); 
		query.append("AND    NVL(GD.THC_TP_CD,'T') = 'G'" ).append("\n"); 
		query.append("AND    NVL(GD.IO_BND_CD,'N') = DECODE(NVL(GD.IO_BND_CD,'N'),'N','N','S','S',L.IO_BND_CD)" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_OFC_CTY_CD = GC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_SEQ        = GC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_VER_NO     = GC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_DTL_SEQ    = GC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(GD.TML_AGMT_VOL_UT_CD,'C',GC.CNTR_TPSZ_CD,'N') " ).append("\n"); 
		query.append("        = DECODE(GD.TML_AGMT_VOL_UT_CD,'C',DECODE(L.CNTR_STY_CD,'F',DECODE(SUBSTR(L.CNTR_TPSZ_CD,1,1),'O',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'F',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'P',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'A',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                      'S',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                                                          L.CNTR_TPSZ_CD),L.CNTR_TPSZ_CD),'N')" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_OFC_CTY_CD = GG.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_SEQ        = GG.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_VER_NO     = GG.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    GD.TML_AGMT_DTL_SEQ    = GG.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'N','N',GG.DCGO_APLY_TP_CD) = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'N','N',GG.DCGO_APLY_TP_CD) = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'N','N','D')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N',GG.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N',GG.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(L.DCGO_CLSS_CD,'N',GG.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1',GG.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2',GG.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3',GG.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4',GG.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5',GG.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6',GG.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7',GG.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8',GG.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9',GG.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("       = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append("AND    NVL(L.TML_TRNS_MOD_CD,'S') = DECODE(NVL(LD.TML_TRNS_MOD_CD,'S'),'S',NVL(L.TML_TRNS_MOD_CD,'S'),NVL(LD.TML_TRNS_MOD_CD,'S'))" ).append("\n"); 
		query.append("GROUP BY DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT')," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD, LD.TML_AGMT_VOL_UT_CD," ).append("\n"); 
		query.append("        DECODE(LD.TML_AGMT_VOL_UT_CD,'C',LC.AGMT_RT+GC.AGMT_RT,LD.AGMT_UT_RT+GD.AGMT_UT_RT)," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, LD.CURR_CD, DECODE(L.RC_FLG,'Y','Y','N'),  -- 수정(20071107)" ).append("\n"); 
		query.append("		NVL(L.TML_TRNS_MOD_CD,'S') " ).append("\n"); 
		query.append("        ) L, TES_LGS_COST C" ).append("\n"); 
		query.append("WHERE L.LGS_COST_CD = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("ORDER BY L.LGS_COST_CD ASC, CNTR_TPSZ_CD ASC, DCGO_CLSS_CD ASC" ).append("\n"); 

	}
}