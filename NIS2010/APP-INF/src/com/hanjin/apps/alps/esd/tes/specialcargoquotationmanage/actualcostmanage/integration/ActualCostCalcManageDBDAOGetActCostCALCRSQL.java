/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualCostCalcManageDBDAOGetActCostCALCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCalcManageDBDAOGetActCostCALCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * actual cost calc
	  * </pre>
	  */
	public ActualCostCalcManageDBDAOGetActCostCALCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cost_trf_tp_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cost_trf_tp_basic",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCalcManageDBDAOGetActCostCALCRSQL").append("\n"); 
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
		query.append("Y.TML_AWK_CGO_TRF_TP_CD, Y.YD_CD, Y.IO_BND_CD, Y.IO_GA_CD, Y.TML_AWK_TS_CD," ).append("\n"); 
		query.append("SUM(Y.CALC_2OFT_AMT) ACTUAL_2OFT_AMT," ).append("\n"); 
		query.append("SUM(Y.CALC_4OFT_AMT) ACTUAL_4OFT_AMT," ).append("\n"); 
		query.append("SUM(Y.ACTUAL_2OFT_QTY) ACTUAL_2OFT_QTY," ).append("\n"); 
		query.append("SUM(Y.ACTUAL_4OFT_QTY) ACTUAL_4OFT_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("M.TML_AWK_CGO_TRF_TP_CD, M.YD_CD, M.VNDR_SEQ, M.IO_BND_CD, M.IO_GA_CD, M.TML_AWK_TS_CD" ).append("\n"); 
		query.append(", M.ACTUAL_2OFT_AMT" ).append("\n"); 
		query.append(", M.ACTUAL_4OFT_AMT" ).append("\n"); 
		query.append(", M.ACTUAL_2OFT_QTY" ).append("\n"); 
		query.append(", M.ACTUAL_4OFT_QTY" ).append("\n"); 
		query.append(", ROUND(M.X1/DECODE(M.X2,NULL,1,'',1,0,1,M.X2),2) CALC_2OFT_AMT" ).append("\n"); 
		query.append(", ROUND(M.X3/DECODE(M.X4,NULL,1,'',1,0,1,M.X4),2) CALC_4OFT_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("K.TML_AWK_CGO_TRF_TP_CD, K.YD_CD, K.VNDR_SEQ, K.IO_BND_CD, K.IO_GA_CD, K.TML_AWK_TS_CD" ).append("\n"); 
		query.append(", K.ACTUAL_2OFT_AMT" ).append("\n"); 
		query.append(", K.ACTUAL_4OFT_AMT" ).append("\n"); 
		query.append(", K.ACTUAL_2OFT_QTY" ).append("\n"); 
		query.append(", K.ACTUAL_4OFT_QTY" ).append("\n"); 
		query.append(", NVL(K.ACTUAL_2OFT_AMT,0) * NVL(K.ACTUAL_2OFT_QTY,0) X1" ).append("\n"); 
		query.append(", NVL(MAX(K.ACTUAL_2OFT_QTY) OVER (PARTITION BY K.TML_AWK_CGO_TRF_TP_CD, K.YD_CD, K.IO_BND_CD, K.IO_GA_CD, K.TML_AWK_TS_CD),1) X2" ).append("\n"); 
		query.append(", NVL(K.ACTUAL_4OFT_AMT,0) * NVL(K.ACTUAL_4OFT_QTY,0) X3" ).append("\n"); 
		query.append(", NVL(MAX(K.ACTUAL_4OFT_QTY) OVER (PARTITION BY K.TML_AWK_CGO_TRF_TP_CD, K.YD_CD, K.IO_BND_CD, K.IO_GA_CD, K.TML_AWK_TS_CD),1) X4" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("/** 1. BASIC (SVLDFL + TMNDFL) **/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("L.TML_AWK_CGO_TRF_TP_CD, L.YD_CD, L.VNDR_SEQ, L.IO_BND_CD, L.IO_GA_CD, L.TML_AWK_TS_CD," ).append("\n"); 
		query.append("SUM(L.ACTUAL_2OFT_AMT) ACTUAL_2OFT_AMT," ).append("\n"); 
		query.append("SUM(L.ACTUAL_4OFT_AMT) ACTUAL_4OFT_AMT," ).append("\n"); 
		query.append("SUM(L.ACTUAL_2OFT_QTY) ACTUAL_2OFT_QTY," ).append("\n"); 
		query.append("SUM(L.ACTUAL_4OFT_QTY) ACTUAL_4OFT_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("/** 1. BASIC (SVLDFL + TMNDFL) **/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[act_cost_trf_tp_basic] TML_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("X.YD_CD, X.VNDR_SEQ, X.IO_BND_CD, X.IO_GA_CD, X.TML_AWK_TS_CD" ).append("\n"); 
		query.append(", ROUND(NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',X.USD_RT,0))/DECODE(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',1,0)),0,1,SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',1,0))),0),2) ACTUAL_2OFT_AMT" ).append("\n"); 
		query.append(", ROUND(NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',X.USD_RT,'5',X.USD_RT,0))/DECODE(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',1,'5',1,0)),0,1,SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',1,'5',1,0))),0),2) ACTUAL_4OFT_AMT" ).append("\n"); 
		query.append(", NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',VOL_QTY,0)),1) ACTUAL_2OFT_QTY" ).append("\n"); 
		query.append(", NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',VOL_QTY,'5',VOL_QTY,0)),1) ACTUAL_4OFT_QTY, X.LGS_COST_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD, 'I' IO_GA_CD, 'S' TML_AWK_TS_CD" ).append("\n"); 
		query.append(", ROUND(AVG(ROUND(NVL(NVL(D.CTRT_RT*NVL(D.INV_XCH_RT,1),1)/NVL(G.USD_LOCL_XCH_RT,1),1),2)),10) USD_RT" ).append("\n"); 
		query.append(", H.INV_OFC_CD, H.VNDR_SEQ, H.INV_NO, COUNT(L.CNTR_NO) VOL_QTY, D.LGS_COST_CD" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR H, MDM_VENDOR V, AP_INV_HDR A, GL_MON_XCH_RT G, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("--    AND    H.VNDR_SEQ = '112871' --test" ).append("\n"); 
		query.append("--    AND    H.INV_NO = 'SC01D166019' --test" ).append("\n"); 
		query.append("--AND    H.YD_CD IN (" ).append("\n"); 
		query.append("--'SGSINKA'" ).append("\n"); 
		query.append("----'AEJEAJA','AEKLFTT','BEANRY1','BEANRY2','BHBAHY1','BRITJY5','BRRIOY7','BRSSZT2','BRSSZY4','BRSSZYB'" ).append("\n"); 
		query.append("----'AEJEAJA','BEANRY2','BHBAHY1','BRITJY5','BRRIOY7','BRSSZT2','BRSSZY4'--,'BRSSZYB','CNHKGCH','CNHKGHT','CNNBOY3','CNSHAM1'" ).append("\n"); 
		query.append("--) --test" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    H.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND    A.SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append("AND    A.GL_DT IS NOT NULL" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    NVL(A.IF_FLG,'N') <> 'E'" ).append("\n"); 
		query.append("AND    NVL(A.RCV_ERR_FLG,'N') <> 'E'" ).append("\n"); 
		query.append("AND    A.GL_DT BETWEEN TO_CHAR(SYSDATE-(3*30+365),'YYYYMMDD') AND TO_CHAR(SYSDATE-(3*30),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    D.CALC_COST_GRP_CD    IN ('TM')" ).append("\n"); 
		query.append("AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("AND    NVL(D.INV_AMT,0)    <> 0" ).append("\n"); 
		query.append("AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("AND    H.CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT,1,6)" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("'ST','N') <> 'Y'" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.VSL_CD,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.VSL_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.SKD_VOY_NO,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.SKD_VOY_NO,'N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.SKD_DIR_CD,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.SKD_DIR_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    NVL(DECODE(D.RC_FLG,'Y','Y','N'),'N') = NVL(DECODE(L.RC_FLG,'Y','Y','N'),'N')" ).append("\n"); 
		query.append("AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("'ON',DECODE(L.CNTR_STY_CD,'F','F','M')," ).append("\n"); 
		query.append("'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT')," ).append("\n"); 
		query.append("'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("'ON',SUBSTR(D.LGS_COST_CD,6,1)," ).append("\n"); 
		query.append("'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("--    AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("AND    D.LGS_COST_CD IN ('SVLDFL','TMNDFL')" ).append("\n"); 
		query.append("--    AND    L.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND    L.CNTR_TPSZ_CD IN ('D2','D4','D5')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD, H.INV_OFC_CD, H.VNDR_SEQ, H.INV_NO, SUBSTR(A.GL_DT,1,6), D.CTRT_RT, G.USD_LOCL_XCH_RT, D.LGS_COST_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.YD_CD, X.VNDR_SEQ, X.IO_BND_CD, X.IO_GA_CD, X.TML_AWK_TS_CD, X.LGS_COST_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/** 2. BASIC (TPNDFL) **/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[act_cost_trf_tp_basic] TML_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("X.YD_CD, X.VNDR_SEQ, X.IO_BND_CD, X.IO_GA_CD, X.TML_AWK_TS_CD" ).append("\n"); 
		query.append(", ROUND(NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',X.USD_RT,0))/DECODE(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',1,0)),0,1,SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',1,0))),0),2) ACTUAL_2OFT_AMT" ).append("\n"); 
		query.append(", ROUND(NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',X.USD_RT,'5',X.USD_RT,0))/DECODE(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',1,'5',1,0)),0,1,SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',1,'5',1,0))),0),2) ACTUAL_4OFT_AMT" ).append("\n"); 
		query.append(", NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',VOL_QTY,0)),1) ACTUAL_2OFT_QTY" ).append("\n"); 
		query.append(", NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',VOL_QTY,'5',VOL_QTY,0)),1) ACTUAL_4OFT_QTY, X.LGS_COST_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD, 'I' IO_GA_CD, 'S' TML_AWK_TS_CD" ).append("\n"); 
		query.append(", ROUND(AVG(ROUND(NVL(NVL(D.CTRT_RT*NVL(D.INV_XCH_RT,1),1)/NVL(G.USD_LOCL_XCH_RT,1),1),2)),10) USD_RT" ).append("\n"); 
		query.append(", H.INV_OFC_CD, H.VNDR_SEQ, H.INV_NO, COUNT(L.CNTR_NO) VOL_QTY, D.LGS_COST_CD" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR H, MDM_VENDOR V, AP_INV_HDR A, GL_MON_XCH_RT G, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("--    AND    H.VNDR_SEQ = '112871' --test" ).append("\n"); 
		query.append("--    AND    H.INV_NO = 'SC01D166019' --test" ).append("\n"); 
		query.append("--AND    H.YD_CD IN (" ).append("\n"); 
		query.append("--'SGSINKA'" ).append("\n"); 
		query.append("----'AEJEAJA','AEKLFTT','BEANRY1','BEANRY2','BHBAHY1','BRITJY5','BRRIOY7','BRSSZT2','BRSSZY4','BRSSZYB'" ).append("\n"); 
		query.append("----'AEJEAJA','BEANRY2','BHBAHY1','BRITJY5','BRRIOY7','BRSSZT2','BRSSZY4'--,'BRSSZYB','CNHKGCH','CNHKGHT','CNNBOY3','CNSHAM1'" ).append("\n"); 
		query.append("--) --test" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    H.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND    A.SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append("AND    A.GL_DT IS NOT NULL" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    NVL(A.IF_FLG,'N') <> 'E'" ).append("\n"); 
		query.append("AND    NVL(A.RCV_ERR_FLG,'N') <> 'E'" ).append("\n"); 
		query.append("AND    A.GL_DT BETWEEN TO_CHAR(SYSDATE-(3*30+365),'YYYYMMDD') AND TO_CHAR(SYSDATE-(3*30),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    D.CALC_COST_GRP_CD    IN ('TM')" ).append("\n"); 
		query.append("AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("AND    NVL(D.INV_AMT,0)    <> 0" ).append("\n"); 
		query.append("AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("AND    H.CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT,1,6)" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("'ST','N') <> 'Y'" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.VSL_CD,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.VSL_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.SKD_VOY_NO,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.SKD_VOY_NO,'N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.SKD_DIR_CD,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.SKD_DIR_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    NVL(DECODE(D.RC_FLG,'Y','Y','N'),'N') = NVL(DECODE(L.RC_FLG,'Y','Y','N'),'N')" ).append("\n"); 
		query.append("AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("'ON',DECODE(L.CNTR_STY_CD,'F','F','M')," ).append("\n"); 
		query.append("'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT')," ).append("\n"); 
		query.append("'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("'ON',SUBSTR(D.LGS_COST_CD,6,1)," ).append("\n"); 
		query.append("'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("--    AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("AND    D.LGS_COST_CD IN ('TPNDFL')" ).append("\n"); 
		query.append("--    AND    L.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND    L.CNTR_TPSZ_CD IN ('D2','D4','D5')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD, H.INV_OFC_CD, H.VNDR_SEQ, H.INV_NO, SUBSTR(A.GL_DT,1,6), D.CTRT_RT, G.USD_LOCL_XCH_RT, D.LGS_COST_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.YD_CD, X.VNDR_SEQ, X.IO_BND_CD, X.IO_GA_CD, X.TML_AWK_TS_CD, X.LGS_COST_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** 3. T/S (~TS) **/" ).append("\n"); 
		query.append("@[act_cost_trf_tp_ts] TML_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("X.YD_CD, X.VNDR_SEQ, X.IO_BND_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND ( NVL(X.OVR_FWRD_LEN,0) > 0 OR NVL(X.OVR_BKWD_LEN,0) > 0 OR NVL(X.OVR_HGT,0) > 0 OR" ).append("\n"); 
		query.append("NVL(X.OVR_LF_LEN,0) > 0 OR NVL(X.OVR_RT_LEN,0) > 0 OR  NVL(X.OVR_VOID_SLT_QTY,0) > 0 )" ).append("\n"); 
		query.append("THEN 'O'" ).append("\n"); 
		query.append("ELSE 'I'" ).append("\n"); 
		query.append("END IO_GA_CD," ).append("\n"); 
		query.append("TES_OOG_GET_TS_YARD_TP_FNC (X.BKG_NO, X.CNTR_NO, X.CNTR_TPSZ_CD, X.YD_CD, X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.IO_BND_CD) TML_AWK_TS_CD" ).append("\n"); 
		query.append(", ROUND(NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',X.USD_RT,0))/DECODE(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',1,0)),0,1,SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',1,0))),0),2) ACTUAL_2OFT_AMT" ).append("\n"); 
		query.append(", ROUND(NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',X.USD_RT,'5',X.USD_RT,0))/DECODE(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',1,'5',1,0)),0,1,SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',1,'5',1,0))),0),2) ACTUAL_4OFT_AMT" ).append("\n"); 
		query.append(", NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'2',VOL_QTY,0)),1) ACTUAL_2OFT_QTY" ).append("\n"); 
		query.append(", NVL(SUM(DECODE(SUBSTR(X.CNTR_TPSZ_CD,2,1),'4',VOL_QTY,'5',VOL_QTY,0)),1) ACTUAL_4OFT_QTY, X.LGS_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD, ROUND(AVG(ROUND(NVL(NVL(D.CTRT_RT*NVL(D.INV_XCH_RT,1),1)/NVL(G.USD_LOCL_XCH_RT,1),1),2)),10) USD_RT" ).append("\n"); 
		query.append(", H.INV_OFC_CD, H.VNDR_SEQ, H.INV_NO" ).append("\n"); 
		query.append(", COUNT(L.CNTR_NO) VOL_QTY, D.LGS_COST_CD, L.VSL_CD, L.SKD_VOY_NO, L.SKD_DIR_CD" ).append("\n"); 
		query.append(", L.CNTR_NO, BC.BKG_NO, BC.OVR_FWRD_LEN, BC.OVR_BKWD_LEN, BC.OVR_HGT, BC.OVR_LF_LEN, BC.OVR_RT_LEN, BC.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("FROM   TES_TML_SO_HDR H, MDM_VENDOR V, AP_INV_HDR A, GL_MON_XCH_RT G, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C" ).append("\n"); 
		query.append(", BKG_BOOKING BB, BKG_AWK_CGO BC" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("--    AND    H.VNDR_SEQ = '112871' --test" ).append("\n"); 
		query.append("--    AND    H.INV_NO = 'SC01D166019' --test" ).append("\n"); 
		query.append("--AND    H.YD_CD IN (" ).append("\n"); 
		query.append("--'SGSINKA'" ).append("\n"); 
		query.append("----'AEJEAJA','AEKLFTT','BEANRY1','BEANRY2','BHBAHY1','BRITJY5','BRRIOY7','BRSSZT2','BRSSZY4','BRSSZYB'" ).append("\n"); 
		query.append("----'AEJEAJA','BEANRY2','BHBAHY1','BRITJY5','BRRIOY7','BRSSZT2','BRSSZY4'--,'BRSSZYB','CNHKGCH','CNHKGHT','CNNBOY3','CNSHAM1'" ).append("\n"); 
		query.append("--) --test" ).append("\n"); 
		query.append("AND    H.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    H.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND    A.SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append("AND    A.GL_DT IS NOT NULL" ).append("\n"); 
		query.append("AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    NVL(A.IF_FLG,'N') <> 'E'" ).append("\n"); 
		query.append("AND    NVL(A.RCV_ERR_FLG,'N') <> 'E'" ).append("\n"); 
		query.append("AND    A.GL_DT BETWEEN TO_CHAR(SYSDATE-(3*30+365),'YYYYMMDD') AND TO_CHAR(SYSDATE-(3*30),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("AND    D.CALC_COST_GRP_CD    IN ('TM')" ).append("\n"); 
		query.append("AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("AND    NVL(D.INV_AMT,0)    <> 0" ).append("\n"); 
		query.append("AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("AND    H.CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT,1,6)" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("'ST','N') <> 'Y'" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.VSL_CD,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.VSL_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.SKD_VOY_NO,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.SKD_VOY_NO,'N'),'N')" ).append("\n"); 
		query.append("AND    DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(L.SKD_DIR_CD,'N'),'N') = DECODE(NVL(H.TML_INV_TP_CD,'N'),'TM',NVL(D.SKD_DIR_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    NVL(DECODE(D.RC_FLG,'Y','Y','N'),'N') = NVL(DECODE(L.RC_FLG,'Y','Y','N'),'N')" ).append("\n"); 
		query.append("AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("'ON',DECODE(L.CNTR_STY_CD,'F','F','M')," ).append("\n"); 
		query.append("'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT')," ).append("\n"); 
		query.append("'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("'TM',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("'ON',SUBSTR(D.LGS_COST_CD,6,1)," ).append("\n"); 
		query.append("'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("= DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("--    AND    D.LGS_COST_CD IN ('TPNDTS','SVLDTS')" ).append("\n"); 
		query.append("AND    D.LGS_COST_CD LIKE '%TS'" ).append("\n"); 
		query.append("AND    L.CNTR_TPSZ_CD IN ('A2','A4','F2','F4','F5','O2','O4','O5','P2','P4','S2','S4')" ).append("\n"); 
		query.append("AND    BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND    BC.BKG_NO = L.BKG_NO" ).append("\n"); 
		query.append("AND    BC.CNTR_NO = L.CNTR_NO" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD, H.INV_OFC_CD, H.VNDR_SEQ, H.INV_NO, SUBSTR(A.GL_DT,1,6), D.CTRT_RT, G.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(", L.VSL_CD, L.SKD_VOY_NO, L.SKD_DIR_CD, D.LGS_COST_CD" ).append("\n"); 
		query.append(", BC.BKG_NO, BC.OVR_FWRD_LEN, BC.OVR_BKWD_LEN, BC.OVR_HGT, BC.OVR_LF_LEN, BC.OVR_RT_LEN, BC.OVR_VOID_SLT_QTY, L.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("H.YD_CD, L.CNTR_TPSZ_CD, L.IO_BND_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.YD_CD, X.VNDR_SEQ, X.IO_BND_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND ( NVL(X.OVR_FWRD_LEN,0) > 0 OR NVL(X.OVR_BKWD_LEN,0) > 0 OR NVL(X.OVR_HGT,0) > 0 OR" ).append("\n"); 
		query.append("NVL(X.OVR_LF_LEN,0) > 0 OR NVL(X.OVR_RT_LEN,0) > 0 OR  NVL(X.OVR_VOID_SLT_QTY,0) > 0 )" ).append("\n"); 
		query.append("THEN 'O'" ).append("\n"); 
		query.append("ELSE 'I'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(", TES_OOG_GET_TS_YARD_TP_FNC (X.BKG_NO, X.CNTR_NO, X.CNTR_TPSZ_CD, X.YD_CD, X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.IO_BND_CD)" ).append("\n"); 
		query.append(", X.LGS_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") L" ).append("\n"); 
		query.append("GROUP BY L.TML_AWK_CGO_TRF_TP_CD, L.YD_CD, L.VNDR_SEQ, L.IO_BND_CD, L.IO_GA_CD, L.TML_AWK_TS_CD" ).append("\n"); 
		query.append(") K" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("GROUP BY Y.TML_AWK_CGO_TRF_TP_CD, Y.YD_CD, Y.IO_BND_CD, Y.IO_GA_CD, Y.TML_AWK_TS_CD" ).append("\n"); 
		query.append("ORDER BY Y.TML_AWK_CGO_TRF_TP_CD, Y.YD_CD, Y.IO_BND_CD, Y.IO_GA_CD" ).append("\n"); 

	}
}