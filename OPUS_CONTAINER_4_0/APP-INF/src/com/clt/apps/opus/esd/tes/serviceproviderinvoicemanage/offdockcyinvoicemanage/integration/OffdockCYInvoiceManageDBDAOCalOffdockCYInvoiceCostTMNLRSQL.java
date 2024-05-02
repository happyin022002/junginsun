/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.01 
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

public class OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CalOffdockCYInvoiceCostTMNL
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLRSQL(){
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
		params.put("tml_calc_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'I' IBFLAG, 'A' CALC_TP_CD, 'TM' CALC_COST_GRP_CD," ).append("\n"); 
		query.append("       N.LGS_COST_CD, N.CNTR_TPSZ_CD, N.DCGO_CLSS_CD DCGO_IND_CD, N.VOL_TR_UT_CD," ).append("\n"); 
		query.append("       DECODE(N.THC,'T',N.CALC_VOL_QTY,'L',L.CALC_VOL_QTY,'G',G.CALC_VOL_QTY) CALC_VOL_QTY," ).append("\n"); 
		query.append("       DECODE(N.THC,'T',N.CALC_VOL_QTY,'L',L.CALC_VOL_QTY,'G',G.CALC_VOL_QTY) RVIS_VOL_QTY," ).append("\n"); 
		query.append("       DECODE(N.THC,'T',N.CTRT_RT,'L',L.CTRT_RT+G.CTRT_RT,'G',G.CTRT_RT+L.CTRT_RT)*2 CTRT_RT," ).append("\n"); 
		query.append("       ROUND(DECODE(N.THC,'T',N.CALC_VOL_QTY,'L',L.CALC_VOL_QTY,'G',G.CALC_VOL_QTY)*" ).append("\n"); 
		query.append("       (DECODE(N.THC,'T',N.CTRT_RT,'L',L.CTRT_RT+G.CTRT_RT,'G',G.CTRT_RT+L.CTRT_RT)*2)*INV_XCH_RT,2) INV_AMT," ).append("\n"); 
		query.append("       ROUND(DECODE(N.THC,'T',N.CALC_VOL_QTY,'L',L.CALC_VOL_QTY,'G',G.CALC_VOL_QTY)*" ).append("\n"); 
		query.append("       (DECODE(N.THC,'T',N.CTRT_RT,'L',L.CTRT_RT+G.CTRT_RT,'G',G.CTRT_RT+L.CTRT_RT)*2)*INV_XCH_RT,2) CALC_AMT," ).append("\n"); 
		query.append("       C.ACCT_CD, N.TML_AGMT_OFC_CTY_CD, N.TML_AGMT_SEQ, N.TML_AGMT_VER_NO, N.CURR_CHK, CURR_CD, INV_XCH_RT," ).append("\n"); 
		query.append("       DECODE(N.RC_FLG,'Y','Y','N') RC_FLG, N.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append(" SELECT DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, NVL(L.DCGO_CLSS_CD,'N') DCGO_CLSS_CD," ).append("\n"); 
		query.append("        SUM(DECODE(@[tml_calc_ind_cd],'TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) CALC_VOL_QTY," ).append("\n"); 
		query.append("        SUM(DECODE(@[tml_calc_ind_cd],'TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) RVIS_VOL_QTY," ).append("\n"); 
		query.append("        ND.TML_AGMT_VOL_UT_CD VOL_TR_UT_CD, NVL(ND.THC_TP_CD,'T') THC," ).append("\n"); 
		query.append("        DECODE(ND.TML_AGMT_VOL_UT_CD,'C',NC.AGMT_RT,ND.AGMT_UT_RT) CTRT_RT," ).append("\n"); 
		query.append("        SUM(DECODE(@[tml_calc_ind_cd],'TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) *" ).append("\n"); 
		query.append("        DECODE(ND.TML_AGMT_VOL_UT_CD,'C',NC.AGMT_RT,ND.AGMT_UT_RT) INV_AMT," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, DECODE(@[curr_cd],ND.CURR_CD,'Y','N') CURR_CHK, ND.CURR_CD" ).append("\n"); 
		query.append("        , NVL(DECODE(L.RC_FLG,'Y','Y','N'),'N') RC_FLG, L.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("        ROUND((SELECT USD_LOCL_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[to_prd_dt],'-'),1,6) AND CURR_CD =@[curr_cd])/(select USD_LOCL_XCH_RT from GL_MON_XCH_RT where ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[to_prd_dt],'-'),1,6) and CURR_CD = ND.CURR_CD),4) INV_XCH_RT" ).append("\n"); 
		query.append(" FROM   (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                INV_GATE_OUT_DT, DECODE(HO,0,WRK_DY,'HO') TML_WRK_DY_CD, IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("           FROM (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                        INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD') WRK_DY," ).append("\n"); 
		query.append("                        MAX((SELECT COUNT(*)" ).append("\n"); 
		query.append("        				       FROM DMT_HOLIDAY" ).append("\n"); 
		query.append("        				      WHERE 1=1" ).append("\n"); 
		query.append("        					    AND TO_CHAR(HOL_DT,'YYYYMMDD') = TO_CHAR(INV_GATE_OUT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        					    AND CNT_CD = SUBSTR(@[yd_cd],1,2)" ).append("\n"); 
		query.append("        					)) HO," ).append("\n"); 
		query.append("                         IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                   FROM TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("                  WHERE VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("                    AND TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                    AND TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append("                    GROUP BY VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD," ).append("\n"); 
		query.append("                             INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD')," ).append("\n"); 
		query.append("                             IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD, DCGO_CLSS_CD" ).append("\n"); 
		query.append("                             ) ) L, " ).append("\n"); 
		query.append("        TES_TML_AGMT_HDR H," ).append("\n"); 
		query.append("        TES_TML_AGMT_DTL ND, TES_TML_AGMT_TP_SZ NC, TES_TML_AGMT_DG_CGO_CLSS NG, TES_TML_AGMT_APLY_DY NA" ).append("\n"); 
		query.append(" WHERE  L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append(" AND    L.TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND    L.TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append(" AND    H.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append(" AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append(" AND    H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                              FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                              WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                              AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                              AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                              AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt] )" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_OFC_CTY_CD = ND.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_SEQ        = ND.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO     = ND.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') = ND.LGS_COST_CD" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_TP_CD      = 'T'" ).append("\n"); 
		query.append(" AND    ND.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append(" AND    NVL(ND.IO_BND_CD,'N')  = DECODE(NVL(ND.IO_BND_CD,'N'),'N','N','S','S',L.IO_BND_CD)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_OFC_CTY_CD = NC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_SEQ        = NC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_VER_NO     = NC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_DTL_SEQ    = NC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    DECODE(ND.TML_AGMT_VOL_UT_CD,'C',NC.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("        = DECODE(ND.TML_AGMT_VOL_UT_CD,'C',DECODE(L.CNTR_STY_CD, 'M', CASE WHEN L.CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                           THEN L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                           ELSE 'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1)" ).append("\n"); 
		query.append("                                                                      END," ).append("\n"); 
		query.append("                                DECODE(SUBSTR(L.CNTR_TPSZ_CD,1,1),'R',DECODE(L.RC_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                  'T',DECODE(L.RC_FLG,'Y','R'||SUBSTR(L.CNTR_TPSZ_CD,2,1),L.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                  'O',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                  'F',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                  'P',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                  'A',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                  'S',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   L.CNTR_TPSZ_CD)), 'N')" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_OFC_CTY_CD = NG.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_SEQ        = NG.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_VER_NO     = NG.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_DTL_SEQ    = NG.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    NVL(ND.TML_TRNS_MOD_CD,'S') = DECODE(NVL(ND.TML_TRNS_MOD_CD,'S'),'S','S'," ).append("\n"); 
		query.append("                                                                                (SELECT DECODE((SELECT NVL('X','N')" ).append("\n"); 
		query.append("                    															 FROM   TES_TML_AGMT_DTL" ).append("\n"); 
		query.append("                    															 WHERE  TML_AGMT_OFC_CTY_CD = ND.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_SEQ        = ND.TML_AGMT_SEQ" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_VER_NO     = ND.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                    															 AND    TML_TRNS_MOD_CD     = L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                    															 AND    ROWNUM = 1),'X',L.TML_TRNS_MOD_CD,'O')" ).append("\n"); 
		query.append("                    											                 FROM DUAL ))		  " ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'N','N',NG.DCGO_APLY_TP_CD) = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N',NG.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N',NG.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(L.DCGO_CLSS_CD,'N',NG.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1',NG.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2',NG.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3',NG.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4',NG.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5',NG.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6',NG.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7',NG.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8',NG.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9',NG.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(ND.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_OFC_CTY_CD  = NA.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_SEQ         = NA.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_VER_NO      = NA.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    ND.TML_AGMT_DTL_SEQ     = NA.TML_AGMT_DTL_SEQ(+)   " ).append("\n"); 
		query.append(" AND    ( DECODE(ND.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(ND.TML_DY_APLY_TP_CD,'P',DECODE(NA.WKDY_FLG,'Y','WD'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(ND.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(ND.TML_DY_APLY_TP_CD,'P',DECODE(NA.SAT_FLG,'Y','SA'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(ND.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(ND.TML_DY_APLY_TP_CD,'P',DECODE(NA.SUN_FLG,'Y','SU'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(ND.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(ND.TML_DY_APLY_TP_CD,'P',DECODE(NA.HOL_FLG,'Y','HO'),'S') ) " ).append("\n"); 
		query.append(" GROUP BY DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT'), L.TML_WRK_DY_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD, ND.TML_AGMT_VOL_UT_CD, NVL(ND.THC_TP_CD,'T')," ).append("\n"); 
		query.append("        DECODE(ND.TML_AGMT_VOL_UT_CD,'C',NC.AGMT_RT,ND.AGMT_UT_RT)," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, ND.CURR_CD, NVL(DECODE(L.RC_FLG,'Y','Y','N'),'N'), L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("        ) N," ).append("\n"); 
		query.append(" ( SELECT DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, NVL(L.DCGO_CLSS_CD,'N') DCGO_CLSS_CD," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) CALC_VOL_QTY," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) RVIS_VOL_QTY," ).append("\n"); 
		query.append("        TD.TML_AGMT_VOL_UT_CD VOL_TR_UT_CD, NVL(TD.THC_TP_CD,'T') THC," ).append("\n"); 
		query.append("        DECODE(TD.TML_AGMT_VOL_UT_CD,'C',TC.AGMT_RT,TD.AGMT_UT_RT) CTRT_RT," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) *" ).append("\n"); 
		query.append("        DECODE(TD.TML_AGMT_VOL_UT_CD,'C',TC.AGMT_RT,TD.AGMT_UT_RT) INV_AMT," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append(" FROM   (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                INV_GATE_OUT_DT, DECODE(HO,0,WRK_DY,'HO') TML_WRK_DY_CD, IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("           FROM (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                        INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD') WRK_DY," ).append("\n"); 
		query.append("                        MAX((SELECT COUNT(*)" ).append("\n"); 
		query.append("        				       FROM DMT_HOLIDAY" ).append("\n"); 
		query.append("        				      WHERE 1=1" ).append("\n"); 
		query.append("        					    AND TO_CHAR(HOL_DT,'YYYYMMDD') = TO_CHAR(INV_GATE_OUT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        					    AND CNT_CD = SUBSTR(@[yd_cd],1,2)" ).append("\n"); 
		query.append("        					)) HO," ).append("\n"); 
		query.append("                         IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                   FROM TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("                  WHERE VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("                    AND TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                    AND TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append("                    GROUP BY VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD," ).append("\n"); 
		query.append("                             INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD')," ).append("\n"); 
		query.append("                             IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD, DCGO_CLSS_CD" ).append("\n"); 
		query.append("                             ) ) L, " ).append("\n"); 
		query.append("        TES_TML_AGMT_HDR H," ).append("\n"); 
		query.append("        TES_TML_AGMT_DTL TD, TES_TML_AGMT_TP_SZ TC, TES_TML_AGMT_DG_CGO_CLSS TG, TES_TML_AGMT_APLY_DY TA" ).append("\n"); 
		query.append(" WHERE  L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append(" AND    L.TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND    L.TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append(" AND    H.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append(" AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append(" AND    H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                              FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                              WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                              AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                              AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                              AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt] )" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_OFC_CTY_CD = TD.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_SEQ        = TD.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO     = TD.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') = TD.LGS_COST_CD" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_TP_CD      = 'T'" ).append("\n"); 
		query.append(" AND    TD.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append(" AND    NVL(TD.THC_TP_CD,'T')  = 'T'" ).append("\n"); 
		query.append(" AND    NVL(TD.IO_BND_CD,'N')  = DECODE(NVL(TD.IO_BND_CD,'N'),'N','N','S','S',L.IO_BND_CD)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_OFC_CTY_CD = TC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_SEQ        = TC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_VER_NO     = TC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_DTL_SEQ    = TC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(TD.TML_AGMT_VOL_UT_CD,'C',TC.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("    = DECODE(TD.TML_AGMT_VOL_UT_CD,'C',DECODE(L.CNTR_STY_CD, 'M', CASE WHEN L.CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                       THEN L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                       ELSE 'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1)" ).append("\n"); 
		query.append("                                                                  END," ).append("\n"); 
		query.append("                                 DECODE(SUBSTR(L.CNTR_TPSZ_CD,1,1),'R',DECODE(L.RC_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'T',DECODE(L.RC_FLG,'Y','R'||SUBSTR(L.CNTR_TPSZ_CD,2,1),L.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                   'O',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'F',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'P',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'A',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'S',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   L.CNTR_TPSZ_CD)), 'N')" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_OFC_CTY_CD = TG.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_SEQ        = TG.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_VER_NO     = TG.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_DTL_SEQ    = TG.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    NVL(TD.TML_TRNS_MOD_CD,'S') = DECODE(NVL(TD.TML_TRNS_MOD_CD,'S'),'S','S'," ).append("\n"); 
		query.append("                                                                                (SELECT DECODE((SELECT NVL('X','N')" ).append("\n"); 
		query.append("                    															 FROM   TES_TML_AGMT_DTL" ).append("\n"); 
		query.append("                    															 WHERE  TML_AGMT_OFC_CTY_CD = TD.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_SEQ        = TD.TML_AGMT_SEQ" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_VER_NO     = TD.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                    															 AND    TML_TRNS_MOD_CD     = L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                    															 AND    ROWNUM = 1),'X',L.TML_TRNS_MOD_CD,'O')" ).append("\n"); 
		query.append("                    											                 FROM DUAL ))" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'N','N',TG.DCGO_APLY_TP_CD) = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N',TG.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N',TG.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(L.DCGO_CLSS_CD,'N',TG.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1',TG.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2',TG.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3',TG.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4',TG.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5',TG.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6',TG.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7',TG.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8',TG.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9',TG.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(TD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_OFC_CTY_CD  = TA.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_SEQ         = TA.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_VER_NO      = TA.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    TD.TML_AGMT_DTL_SEQ     = TA.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    ( DECODE(TD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(TD.TML_DY_APLY_TP_CD,'P',DECODE(TA.WKDY_FLG,'Y','WD'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(TD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(TD.TML_DY_APLY_TP_CD,'P',DECODE(TA.SAT_FLG,'Y','SA'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(TD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(TD.TML_DY_APLY_TP_CD,'P',DECODE(TA.SUN_FLG,'Y','SU'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(TD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(TD.TML_DY_APLY_TP_CD,'P',DECODE(TA.HOL_FLG,'Y','HO'),'S') )   " ).append("\n"); 
		query.append(" GROUP BY DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT'), L.TML_WRK_DY_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD, TD.TML_AGMT_VOL_UT_CD, NVL(TD.THC_TP_CD,'T')," ).append("\n"); 
		query.append("        DECODE(TD.TML_AGMT_VOL_UT_CD,'C',TC.AGMT_RT,TD.AGMT_UT_RT)," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("        ) T," ).append("\n"); 
		query.append("( SELECT DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, NVL(L.DCGO_CLSS_CD,'N') DCGO_CLSS_CD," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) CALC_VOL_QTY," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) RVIS_VOL_QTY," ).append("\n"); 
		query.append("        LD.TML_AGMT_VOL_UT_CD VOL_TR_UT_CD,  NVL(LD.THC_TP_CD,'T') THC," ).append("\n"); 
		query.append("        DECODE(LD.TML_AGMT_VOL_UT_CD,'C',LC.AGMT_RT,LD.AGMT_UT_RT) CTRT_RT," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) *" ).append("\n"); 
		query.append("        DECODE(LD.TML_AGMT_VOL_UT_CD,'C',LC.AGMT_RT,LD.AGMT_UT_RT) INV_AMT," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append(" FROM   (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                INV_GATE_OUT_DT, DECODE(HO,0,WRK_DY,'HO') TML_WRK_DY_CD, IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("           FROM (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                        INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD') WRK_DY," ).append("\n"); 
		query.append("                        MAX((SELECT COUNT(*)" ).append("\n"); 
		query.append("        				       FROM DMT_HOLIDAY" ).append("\n"); 
		query.append("        				      WHERE 1=1" ).append("\n"); 
		query.append("        					    AND TO_CHAR(HOL_DT,'YYYYMMDD') = TO_CHAR(INV_GATE_OUT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        					    AND CNT_CD = SUBSTR(@[yd_cd],1,2)" ).append("\n"); 
		query.append("        					)) HO," ).append("\n"); 
		query.append("                         IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                   FROM TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("                  WHERE VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("                    AND TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                    AND TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append("                    GROUP BY VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD," ).append("\n"); 
		query.append("                             INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD')," ).append("\n"); 
		query.append("                             IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD, DCGO_CLSS_CD" ).append("\n"); 
		query.append("                             ) ) L, " ).append("\n"); 
		query.append("        TES_TML_AGMT_HDR H," ).append("\n"); 
		query.append("        TES_TML_AGMT_DTL LD, TES_TML_AGMT_TP_SZ LC, TES_TML_AGMT_DG_CGO_CLSS LG, TES_TML_AGMT_APLY_DY LA" ).append("\n"); 
		query.append(" WHERE  L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append(" AND    L.TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND    L.TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append(" AND    H.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append(" AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append(" AND    H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                              FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                              WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                              AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                              AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                              AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt] )" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_OFC_CTY_CD = LD.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_SEQ        = LD.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO     = LD.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') = LD.LGS_COST_CD" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_TP_CD      = 'T'" ).append("\n"); 
		query.append(" AND    LD.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append(" AND    NVL(LD.THC_TP_CD,'T')  = 'L'" ).append("\n"); 
		query.append(" AND    NVL(LD.IO_BND_CD,'N')  = DECODE(NVL(LD.IO_BND_CD,'N'),'N','N','S','S',L.IO_BND_CD)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_OFC_CTY_CD = LC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_SEQ        = LC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_VER_NO     = LC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_DTL_SEQ    = LC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(LD.TML_AGMT_VOL_UT_CD,'C',LC.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("    = DECODE(LD.TML_AGMT_VOL_UT_CD,'C',DECODE(L.CNTR_STY_CD, 'M', CASE WHEN L.CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                       THEN L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                       ELSE 'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1)" ).append("\n"); 
		query.append("                                                                  END," ).append("\n"); 
		query.append("                                 DECODE(SUBSTR(L.CNTR_TPSZ_CD,1,1),'R',DECODE(L.RC_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'T',DECODE(L.RC_FLG,'Y','R'||SUBSTR(L.CNTR_TPSZ_CD,2,1),L.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                   'O',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'F',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'P',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'A',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'S',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   L.CNTR_TPSZ_CD)), 'N')" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_OFC_CTY_CD = LG.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_SEQ        = LG.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_VER_NO     = LG.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_DTL_SEQ    = LG.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    NVL(LD.TML_TRNS_MOD_CD,'S') = DECODE(NVL(LD.TML_TRNS_MOD_CD,'S'),'S','S'," ).append("\n"); 
		query.append("                                                                                (SELECT DECODE((SELECT NVL('X','N')" ).append("\n"); 
		query.append("                    															 FROM   TES_TML_AGMT_DTL" ).append("\n"); 
		query.append("                    															 WHERE  TML_AGMT_OFC_CTY_CD = LD.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_SEQ        = LD.TML_AGMT_SEQ" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_VER_NO     = LD.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                    															 AND    TML_TRNS_MOD_CD     = L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                    															 AND    ROWNUM = 1),'X',L.TML_TRNS_MOD_CD,'O')" ).append("\n"); 
		query.append("                    											                 FROM DUAL )) " ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'N','N',LG.DCGO_APLY_TP_CD) = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N',LG.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N',LG.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(L.DCGO_CLSS_CD,'N',LG.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1',LG.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2',LG.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3',LG.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4',LG.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5',LG.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6',LG.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7',LG.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8',LG.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9',LG.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(LD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_OFC_CTY_CD  = LA.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_SEQ         = LA.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_VER_NO      = LA.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    LD.TML_AGMT_DTL_SEQ     = LA.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    ( DECODE(LD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(LD.TML_DY_APLY_TP_CD,'P',DECODE(LA.WKDY_FLG,'Y','WD'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(LD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(LD.TML_DY_APLY_TP_CD,'P',DECODE(LA.SAT_FLG,'Y','SA'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(LD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(LD.TML_DY_APLY_TP_CD,'P',DECODE(LA.SUN_FLG,'Y','SU'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(LD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(LD.TML_DY_APLY_TP_CD,'P',DECODE(LA.HOL_FLG,'Y','HO'),'S') )    " ).append("\n"); 
		query.append(" GROUP BY DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT'), L.TML_WRK_DY_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD, LD.TML_AGMT_VOL_UT_CD, NVL(LD.THC_TP_CD,'T')," ).append("\n"); 
		query.append("        DECODE(LD.TML_AGMT_VOL_UT_CD,'C',LC.AGMT_RT,LD.AGMT_UT_RT)," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("        ) L," ).append("\n"); 
		query.append("( SELECT DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, NVL(L.DCGO_CLSS_CD,'N') DCGO_CLSS_CD," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) CALC_VOL_QTY," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) RVIS_VOL_QTY," ).append("\n"); 
		query.append("        GD.TML_AGMT_VOL_UT_CD VOL_TR_UT_CD, NVL(GD.THC_TP_CD,'T') THC," ).append("\n"); 
		query.append("        DECODE(GD.TML_AGMT_VOL_UT_CD,'C',GC.AGMT_RT,GD.AGMT_UT_RT) CTRT_RT," ).append("\n"); 
		query.append("        SUM(DECODE('TP','TP',DECODE(L.INV_GATE_OUT_DT,NULL,0,1),1)) *" ).append("\n"); 
		query.append("        DECODE(GD.TML_AGMT_VOL_UT_CD,'C',GC.AGMT_RT,GD.AGMT_UT_RT) INV_AMT," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append(" FROM   (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                INV_GATE_OUT_DT, DECODE(HO,0,WRK_DY,'HO') TML_WRK_DY_CD, IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("           FROM (SELECT VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD, " ).append("\n"); 
		query.append("                        INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD') WRK_DY," ).append("\n"); 
		query.append("                        MAX((SELECT COUNT(*)" ).append("\n"); 
		query.append("        				       FROM DMT_HOLIDAY" ).append("\n"); 
		query.append("        				      WHERE 1=1" ).append("\n"); 
		query.append("        					    AND TO_CHAR(HOL_DT,'YYYYMMDD') = TO_CHAR(INV_GATE_OUT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        					    AND CNT_CD = SUBSTR(@[yd_cd],1,2)" ).append("\n"); 
		query.append("        					)) HO," ).append("\n"); 
		query.append("                         IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                   FROM TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("                  WHERE VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("                    AND TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                    AND TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append("                    GROUP BY VRFY_RSLT_IND_CD, TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, CNTR_STY_CD, CNTR_TPSZ_CD, DCGO_CLSS_CD," ).append("\n"); 
		query.append("                             INV_GATE_OUT_DT, DECODE(TO_CHAR(INV_GATE_OUT_DT,'D'),7,'SA',1,'SU','WD')," ).append("\n"); 
		query.append("                             IO_BND_CD, RC_FLG, AWK_CGO_FLG, TML_TRNS_MOD_CD, DCGO_CLSS_CD" ).append("\n"); 
		query.append("                             ) ) L, " ).append("\n"); 
		query.append("        TES_TML_AGMT_HDR H," ).append("\n"); 
		query.append("        TES_TML_AGMT_DTL GD, TES_TML_AGMT_TP_SZ GC, TES_TML_AGMT_DG_CGO_CLSS GG, TES_TML_AGMT_APLY_DY GA" ).append("\n"); 
		query.append(" WHERE  L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append(" AND    L.TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND    L.TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append(" AND    H.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append(" AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append(" AND    H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt]" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                              FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                              WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                              AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                              AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                              AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= @[to_prd_dt]" ).append("\n"); 
		query.append("                              AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= @[to_prd_dt] )" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_OFC_CTY_CD = GD.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_SEQ        = GD.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO     = GD.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') = GD.LGS_COST_CD" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_TP_CD      = 'T'" ).append("\n"); 
		query.append(" AND    GD.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append(" AND    NVL(GD.THC_TP_CD,'T')  = 'G'" ).append("\n"); 
		query.append(" AND    NVL(GD.IO_BND_CD,'N')  = DECODE(NVL(GD.IO_BND_CD,'N'),'N','N','S','S',L.IO_BND_CD)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_OFC_CTY_CD = GC.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_SEQ        = GC.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_VER_NO     = GC.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_DTL_SEQ    = GC.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    DECODE(GD.TML_AGMT_VOL_UT_CD,'C',GC.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("      = DECODE(GD.TML_AGMT_VOL_UT_CD,'C',DECODE(L.CNTR_STY_CD, 'M', CASE WHEN L.CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                         THEN L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                         ELSE 'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1)" ).append("\n"); 
		query.append("                                                                    END," ).append("\n"); 
		query.append("                                 DECODE(SUBSTR(L.CNTR_TPSZ_CD,1,1),'R',DECODE(L.RC_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'T',DECODE(L.RC_FLG,'Y','R'||SUBSTR(L.CNTR_TPSZ_CD,2,1),L.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                   'O',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'F',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'P',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'A',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                   'S',DECODE(L.AWK_CGO_FLG,'Y',L.CNTR_TPSZ_CD,'D'||SUBSTR(L.CNTR_TPSZ_CD,2,1))," ).append("\n"); 
		query.append("                                                                  L.CNTR_TPSZ_CD)), 'N')" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_OFC_CTY_CD = GG.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_SEQ        = GG.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_VER_NO     = GG.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_DTL_SEQ    = GG.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    NVL(GD.TML_TRNS_MOD_CD,'S') = DECODE(NVL(GD.TML_TRNS_MOD_CD,'S'),'S','S'," ).append("\n"); 
		query.append("                                                                                (SELECT DECODE((SELECT NVL('X','N')" ).append("\n"); 
		query.append("                    															 FROM   TES_TML_AGMT_DTL" ).append("\n"); 
		query.append("                    															 WHERE  TML_AGMT_OFC_CTY_CD = GD.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_SEQ        = GD.TML_AGMT_SEQ" ).append("\n"); 
		query.append("                    															 AND    TML_AGMT_VER_NO     = GD.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                    															 AND    TML_TRNS_MOD_CD     = L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("                    															 AND    ROWNUM = 1),'X',L.TML_TRNS_MOD_CD,'O')" ).append("\n"); 
		query.append("                    											                 FROM DUAL )) " ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'N','N',GG.DCGO_APLY_TP_CD) = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N',GG.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N',GG.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(L.DCGO_CLSS_CD,'N',GG.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'A',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(L.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1',GG.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2',GG.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3',GG.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4',GG.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5',GG.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6',GG.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7',GG.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8',GG.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9',GG.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("        = DECODE(NVL(GD.DCGO_APLY_TP_CD,'N'),'S',DECODE(L.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_OFC_CTY_CD  = GA.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_SEQ         = GA.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_VER_NO      = GA.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" AND    GD.TML_AGMT_DTL_SEQ     = GA.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append(" AND    ( DECODE(GD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(GD.TML_DY_APLY_TP_CD,'P',DECODE(GA.WKDY_FLG,'Y','WD'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(GD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(GD.TML_DY_APLY_TP_CD,'P',DECODE(GA.SAT_FLG,'Y','SA'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(GD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(GD.TML_DY_APLY_TP_CD,'P',DECODE(GA.SUN_FLG,'Y','SU'),'S')" ).append("\n"); 
		query.append(" OR       DECODE(GD.TML_DY_APLY_TP_CD,'P',L.TML_WRK_DY_CD,'S') = DECODE(GD.TML_DY_APLY_TP_CD,'P',DECODE(GA.HOL_FLG,'Y','HO'),'S') ) " ).append("\n"); 
		query.append(" GROUP BY DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT'), L.TML_WRK_DY_CD," ).append("\n"); 
		query.append("        L.CNTR_TPSZ_CD, L.DCGO_CLSS_CD, GD.TML_AGMT_VOL_UT_CD, NVL(GD.THC_TP_CD,'T')," ).append("\n"); 
		query.append("        DECODE(GD.TML_AGMT_VOL_UT_CD,'C',GC.AGMT_RT,GD.AGMT_UT_RT)," ).append("\n"); 
		query.append("        H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO, L.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("        ) G, TES_LGS_COST C" ).append("\n"); 
		query.append("WHERE N.LGS_COST_CD = T.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND   N.CNTR_TPSZ_CD = T.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND   N.DCGO_CLSS_CD = T.DCGO_CLSS_CD(+)" ).append("\n"); 
		query.append("AND   N.VOL_TR_UT_CD = T.VOL_TR_UT_CD(+)" ).append("\n"); 
		query.append("AND   N.TML_TRNS_MOD_CD = T.TML_TRNS_MOD_CD(+)" ).append("\n"); 
		query.append("AND   N.LGS_COST_CD  = L.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND   N.CNTR_TPSZ_CD = L.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND   N.DCGO_CLSS_CD = L.DCGO_CLSS_CD(+)" ).append("\n"); 
		query.append("AND   N.VOL_TR_UT_CD = L.VOL_TR_UT_CD(+)" ).append("\n"); 
		query.append("AND   N.TML_TRNS_MOD_CD = L.TML_TRNS_MOD_CD(+)" ).append("\n"); 
		query.append("AND   N.LGS_COST_CD  = G.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND   N.CNTR_TPSZ_CD = G.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND   N.DCGO_CLSS_CD = G.DCGO_CLSS_CD(+)" ).append("\n"); 
		query.append("AND   N.VOL_TR_UT_CD = G.VOL_TR_UT_CD(+)" ).append("\n"); 
		query.append("AND   N.TML_TRNS_MOD_CD = G.TML_TRNS_MOD_CD(+)" ).append("\n"); 
		query.append("AND   N.THC <> 'G'" ).append("\n"); 
		query.append("AND   N.LGS_COST_CD = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD ASC, CNTR_TPSZ_CD ASC, DCGO_IND_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_cost_yn} == 'Y') " ).append("\n"); 
		query.append(") A, AGMTCOST B" ).append("\n"); 
		query.append("WHERE A.LGS_COST_CD = B.COST_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}