/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ChAnalysisReportDBDAOSearchChAnalysisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChAnalysisReportDBDAOSearchChAnalysisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO 비용 및 S/O비용 집계내역을 조회한다
	  * </pre>
	  */
	public ChAnalysisReportDBDAOSearchChAnalysisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SO_FMDT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("HID_BOUNDMODE",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SO_TODT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.chanalysis.integration").append("\n"); 
		query.append("FileName : ChAnalysisReportDBDAOSearchChAnalysisRSQL").append("\n"); 
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
		query.append("SELECT          " ).append("\n"); 
		query.append("        GR_ID,WRK_OFC,TRSP_BND_CD,D2,D4,D5,D7,D_ETC,R2,R4,R5,R7,R8,O2+S2 O2,O4+S4 O4,O5,O7,F2+A2 F2,F4+A4 F4,F5,P2,P4,T2,T4, " ).append("\n"); 
		query.append("        VOL_TOT,VOL_20,VOL_40,     " ).append("\n"); 
		query.append("        REV_1,REV_2,REV_3,     " ).append("\n"); 
		query.append("        WO_COST,RECAL_WO,     " ).append("\n"); 
		query.append("        DIFF_1,REV_1 - WO_COST,     " ).append("\n"); 
		query.append("        DIFF_2,REV_2 - WO_COST profit_wo,      " ).append("\n"); 
		query.append("        INV_COST,     " ).append("\n"); 
		query.append("        DIFF_3,    DIFF_4,    " ).append("\n"); 
		query.append("        (REV_2 - INV_COST) profit_inv ," ).append("\n"); 
		query.append("        rev_2 - inv_cost - recal_wo PROFIT_TMP  " ).append("\n"); 
		query.append("        FROM  (  " ).append("\n"); 
		query.append("        SELECT                              " ).append("\n"); 
		query.append("        DECODE (WRK_OFC, NULL, 99, 1) DEP, GROUPING_ID(WRK_OFC,B.TRSP_BND_CD ) GR_ID,     " ).append("\n"); 
		query.append("        NVL( WRK_OFC, 'TOTAL'  ) WRK_OFC,     " ).append("\n"); 
		query.append("        NVL( B.TRSP_BND_CD , 'I+O' ) TRSP_BND_CD      " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,D2) ) D2     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,D4) ) D4     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,D5) ) D5     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,D7) ) D7     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,D_etc) ) D_etc     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,R2) ) R2     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,R4) ) R4     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,R5) ) R5     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,R7) ) R7     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,R8) ) R8    " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,O2) ) O2     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,O4) ) O4" ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,O5) ) O5" ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,O7) ) O7" ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,S2) ) S2     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,S4) ) S4     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,F2) ) F2     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,F4) ) F4     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,A2) ) A2     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,A4) ) A4     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,F5) ) F5     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,P2) ) P2     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,P4) ) P4     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,T2) ) T2      " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,T4) ) T4     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,1) ) VOL_TOT  " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,DECODE(SUBSTR(A.EQ_TPSZ_CD,2,1),'2',1,0  ) )  ) VOL_20     " ).append("\n"); 
		query.append("        ,SUM( DECODE( A.TRSP_COST_DTL_MOD_CD, 'DR' ,DECODE(SUBSTR(A.EQ_TPSZ_CD,2,1),'2',0,1  ) )  ) VOL_40     " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , NVL(REV_1,0) ) ,B.WO_DT  ) ) , 2) REV_1          " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( TRO_MANI, 'Y', DECODE( SIGN(REV_1), 0, DECODE(B.TERM , 'D',  DECODE(B.COSTMODE, 'CY', 0 , (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT) ,REV_1 ), REV_1 ), 'A',WO_COST + REV_1, REV_1),B.WO_DT ) )  ,2) REV_2           " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( TRO_MANI, 'Y', DECODE( SIGN(REV_1), 0, DECODE(B.TERM , 'D', INV_COST , (NVL(A.INV_BZC_AMT,0) + NVL(A.INV_ETC_ADD_AMT,0))/XB.USD_LOCL_XCH_RT ,REV_1 ), REV_1 ) ,REV_1  )  ,B.WO_DT ) )  ,2) REV_3            " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , WO_COST) ,   (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT),B.WO_DT)  ) ,2) WO_COST" ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( INV_COST, 0, DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , WO_COST) ,   (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT) ,0  )  , B.WO_DT  ) ) ,2 ) RECAL_WO         " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , NVL(REV_1,0) ) ,B.WO_DT  ) ) ,2) - ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , WO_COST) ,   (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT),B.WO_DT)  ) ,2) DIFF_1       " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( TRO_MANI, 'Y', DECODE( SIGN(REV_1), 0, DECODE(B.TERM , 'D', WO_COST , (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT ,REV_1 ), REV_1 ) ,REV_1  )  ,B.WO_DT ) )  ,2)  -  ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , WO_COST) ,   (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT),B.WO_DT)  ) ,2) DIFF_2        " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , INV_COST) ,  (NVL(A.INV_BZC_AMT,0) + NVL(A.INV_ETC_ADD_AMT,0))/XB.USD_LOCL_XCH_RT), B.WO_DT ) ) ,2) INV_COST     " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( TRO_MANI, 'Y', DECODE( SIGN(REV_1), 0, DECODE(B.TERM , 'D', WO_COST , (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT ,REV_1 ), REV_1 ) ,REV_1  )  ,B.WO_DT ) )  ,2)  -  ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , WO_COST) ,   (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT),B.WO_DT)  ) ,2)  DIFF_3         " ).append("\n"); 
		query.append("        ,ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE( INV_COST, 0, DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , WO_COST) , (NVl( A.BZC_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.HJL_HNDL_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.NEGO_AMT,0))/XA.USD_LOCL_XCH_RT) ,0  )  , B.WO_DT  ) ) ,2 )  - ROUND( SUM( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC ( 'USD', DECODE(B.TERM , 'D', DECODE( A.TRSP_SO_SEQ, B.TRSP_SO_SEQ , INV_COST) ,  (NVL(A.INV_BZC_AMT,0) + NVL(A.INV_ETC_ADD_AMT,0))/XB.USD_LOCL_XCH_RT), B.WO_DT ) ) ,2) DIFF_4       " ).append("\n"); 
		query.append("FROM    TRS_TRSP_SVC_ORD A, GL_MON_XCH_RT XA, GL_MON_XCH_RT XB,     " ).append("\n"); 
		query.append("    (     " ).append("\n"); 
		query.append("        SELECT      /*+ ORDERED INDEX(FL XAK7TRS_TRSP_SVC_ORD) USE_HASH(WRK) */" ).append("\n"); 
		query.append("                FL. TRSP_SO_OFC_CTY_CD, FL.TRSP_SO_SEQ, FL.BKG_NO, COP_NO , FL.TRSP_COST_DTL_MOD_CD COSTMODE, DECODE(MAX( BKG_RCVDE_TERM_CD), 'D', NVL(TRO.CFM_ALL_IN_RT_CD,'Y'), NVL(TRO.CFM_ALL_IN_RT_CD,'N')) TRO_MANI    " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'D2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) D2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'D4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) D4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'D5', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) D5      " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'D7', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) D7      " ).append("\n"); 
		query.append("                ,SUM(DECODE(SUBSTR(FL.EQ_TPSZ_CD,1,1) , 'D',DECODE (FL.EQ_TPSZ_CD,'D2',0,'D4',0,'D5',0,'D7',0, DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1)))) D_etc     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'R2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) R2      " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'R4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) R4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'R5', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) R5     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'R7', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) R7     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'R8', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) R8     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'O2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) O2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'O4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) O4" ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'O5', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) O5" ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'O7', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) O7     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'S2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) S2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'S4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) S4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'F2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) F2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'F4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) F4      " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'A2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) A2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'A4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) A4      " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'F5', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) F5      " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'P2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) P2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'P4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) P4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'T2', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) T2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(FL.EQ_TPSZ_CD, 'T4', DECODE(TRO.EUR_TRNS_TP_CD,'PU',0,1), 0)) T4     " ).append("\n"); 
		query.append("                ,MAX(WRK.CRE_OFC_CD) WRK_OFC, MAX( DECODE(TRO.EUR_TRNS_TP_CD,'FR','N',  TRO.TRO_PROC_CD ) ) TRO_STS     " ).append("\n"); 
		query.append("                ,MAX(FL.TRSP_BND_CD) TRSP_BND_CD , MAX( BKG_RCVDE_TERM_CD ) TERM , MAX( TO_CHAR( FL.LOCL_CRE_DT, 'RRRRMM') ) WO_DT     " ).append("\n"); 
		query.append("                ,SUM(ROUND( (NVl(BZC_AMT,0)+NVL(ETC_ADD_AMT,0)+NVL(HJL_HNDL_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(NEGO_AMT,0))/FM.USD_LOCL_XCH_RT,2)) WO_COST      " ).append("\n"); 
		query.append("                ,SUM(ROUND( (NVL(INV_BZC_AMT,0) + NVL(INV_ETC_ADD_AMT,0))/FM2.USD_LOCL_XCH_RT , 2) ) INV_COST     " ).append("\n"); 
		query.append("                ,SUM(ROUND( NVL(DECODE(TRO.EUR_TRNS_TP_CD,'PU',0, NVL(DECODE(DECODE(FL.TRSP_COST_DTL_MOD_CD,'DR',NVL(TRO.TRNS_REV_AMT,0),0)+DECODE(FL.TRSP_COST_DTL_MOD_CD,'DR',NVL(TRO.NMF_TRNS_REV_AMT, 0),0)+DECODE(FL.TRSP_COST_DTL_MOD_CD,'DR',NVL(TRO.ADD_REV_AMT, 0),0),0,'',DECODE(FL.TRSP_COST_DTL_MOD_CD,'DR',NVL(TRO.TRNS_REV_AMT,0),0)+DECODE(FL.TRSP_COST_DTL_MOD_CD,'DR',NVL(TRO.NMF_TRNS_REV_AMT, 0),0)+DECODE(FL.TRSP_COST_DTL_MOD_CD,'DR',NVL(TRO.ADD_REV_AMT, 0),0)) ,DECODE(FL.TRSP_COST_DTL_MOD_CD,'DR',FL.TRSP_RQST_ORD_REV_AMT,0) ) / FM1.USD_LOCL_XCH_RT),0) ,2)) REV_1 " ).append("\n"); 
		query.append("                ,SUM(ROUND(DECODE(TRO.EUR_TRNS_TP_CD,'PU',0, DECODE( TRO.CFM_ALL_IN_RT_CD,'Y', NVL(DECODE(NVL(TRO.TRNS_REV_AMT,0)+NVL(TRO.NMF_TRNS_REV_AMT, 0)+NVL(TRO.ADD_REV_AMT, 0),0,'',NVL(TRO.TRNS_REV_AMT,0)+NVL(TRO.NMF_TRNS_REV_AMT, 0)+NVL(TRO.ADD_REV_AMT, 0)) ,FL.TRSP_RQST_ORD_REV_AMT ) /FM1.USD_LOCL_XCH_RT) ) ,2) ) TRO_MANI_Y_REV      " ).append("\n"); 
		query.append("                ,SUM(ROUND(DECODE(TRO.EUR_TRNS_TP_CD,'PU',0, DECODE( TRO.CFM_ALL_IN_RT_CD,'Y', 0, NVL(DECODE(NVL(TRO.TRNS_REV_AMT,0)+NVL(TRO.NMF_TRNS_REV_AMT, 0)+NVL(TRO.ADD_REV_AMT, 0),0,'',NVL(TRO.TRNS_REV_AMT,0)+NVL(TRO.NMF_TRNS_REV_AMT, 0)+NVL(TRO.ADD_REV_AMT, 0)) ,FL.TRSP_RQST_ORD_REV_AMT ) /FM1.USD_LOCL_XCH_RT) ) ,2) ) TRO_REV   " ).append("\n"); 
		query.append("        FROM    TRS_TRSP_SVC_ORD FL, TRS_TRSP_WRK_ORD WRK, BKG_EUR_TRO TRO, GL_MON_XCH_RT FM,GL_MON_XCH_RT  FM1 , GL_MON_XCH_RT  FM2 , BKG_BOOKING BK     " ).append("\n"); 
		query.append("        WHERE    1=1     " ).append("\n"); 
		query.append("                AND FL.BKG_NO = TRO.BKG_NO(+)  " ).append("\n"); 
		query.append("                AND FL.TRSP_BND_CD = TRO.IO_BND_CD(+)     " ).append("\n"); 
		query.append("                AND FL.TRO_SEQ = TRO.TRO_SEQ(+)     " ).append("\n"); 
		query.append("                AND FL.BKG_NO = BK.BKG_NO(+)      " ).append("\n"); 
		query.append("                AND FL.TRSP_WO_OFC_CTY_CD = WRK.TRSP_WO_OFC_CTY_CD(+)     " ).append("\n"); 
		query.append("                AND FL.TRSP_WO_SEQ= WRK.TRSP_WO_SEQ(+)     " ).append("\n"); 
		query.append("                AND FL.trsp_bnd_cd IN ('I','O')      " ).append("\n"); 
		query.append("                AND FL.TRSP_SO_TP_CD = 'Y'     " ).append("\n"); 
		query.append("                AND NVL(TRO.CXL_FLG,'N') != 'Y'     " ).append("\n"); 
		query.append("                AND NVL(FL.DELT_FLG, 'N') != 'Y'      " ).append("\n"); 
		query.append("                AND FM.ACCT_XCH_RT_LVL = 1     " ).append("\n"); 
		query.append("                AND FM.CURR_CD = FL.CURR_CD     " ).append("\n"); 
		query.append("                AND FM.ACCT_XCH_RT_YRMON = TO_CHAR(FL.LOCL_CRE_DT,'YYYYMM')      " ).append("\n"); 
		query.append("                AND FM1.ACCT_XCH_RT_LVL = 1     " ).append("\n"); 
		query.append("                AND FM1.CURR_CD = NVL(RTRIM(TRO.CURR_CD),'EUR')     " ).append("\n"); 
		query.append("                AND FM1.ACCT_XCH_RT_YRMON = TO_CHAR(FL.LOCL_CRE_DT,'YYYYMM')       " ).append("\n"); 
		query.append("                AND FM2.ACCT_XCH_RT_LVL = 1     " ).append("\n"); 
		query.append("                AND FM2.CURR_CD = NVL(FL.INV_CURR_CD,'EUR')     " ).append("\n"); 
		query.append("                AND FM2.ACCT_XCH_RT_YRMON = TO_CHAR(FL.LOCL_CRE_DT,'YYYYMM')       " ).append("\n"); 
		query.append("                AND TRSP_COST_DTL_MOD_CD IN ('CY','DR','ER','CF','CN' )  " ).append("\n"); 
		query.append("                AND DECODE(FL.TRSP_COST_DTL_MOD_CD, 'CY',TRSP_CRR_MOD_CD, 'TD') IN ('TD', 'RD', 'TR', 'RT')  " ).append("\n"); 
		query.append("                AND DECODE(FL.TRSP_COST_DTL_MOD_CD, 'CY',BKG_RCVDE_TERM_CD, 'D') = 'D'     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($MONTH_FLG) " ).append("\n"); 
		query.append("    AND FL.LOCL_CRE_DT BETWEEN TO_DATE( @[SO_FMDT] , 'RRRRMM') AND LAST_DAY( to_date( @[SO_TODT] , 'RRRRMM'))+1" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    AND FL.LOCL_CRE_DT BETWEEN TO_DATE( @[SO_FMDT] , 'RRRRMMDD') AND TO_DATE( @[SO_TODT] , 'RRRRMMDD')+0.999" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${HID_BOUNDMODE} != 'ALL') " ).append("\n"); 
		query.append("    AND   FL.trsp_bnd_cd = @[HID_BOUNDMODE]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INPUT_OFFICE.size() > 0) " ).append("\n"); 
		query.append("    AND WRK.CRE_OFC_CD  IN (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${INPUT_OFFICE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $INPUT_OFFICE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($FRM_NODE.size() > 0) " ).append("\n"); 
		query.append("    AND   FL.FM_NOD_CD  IN  (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${FRM_NODE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $FRM_NODE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($TO_NODE.size() > 0) " ).append("\n"); 
		query.append("    AND   FL.TO_NOD_CD  IN  (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${TO_NODE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $TO_NODE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if( ${HID_BKGTERM} == 'Y') " ).append("\n"); 
		query.append("    AND DECODE ( FL.TRSP_BND_CD, 'O' , BK.RCV_TERM_CD ,'I' ,BK.DE_TERM_CD )= 'Y'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${HID_TROSTS} == 'C') " ).append("\n"); 
		query.append("    AND TRO.TRO_PROC_CD = 'C'" ).append("\n"); 
		query.append("    AND NVL(TRO.EUR_TRNS_TP_CD,'X') <>'FR' " ).append("\n"); 
		query.append("#elseif ( ${HID_TROSTS} == 'F') " ).append("\n"); 
		query.append("    AND ( NVL(TRO.TRO_PROC_CD,'N')  <> 'C'" ).append("\n"); 
		query.append("    OR NVL(TRO.EUR_TRNS_TP_CD,'X') ='FR' )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        GROUP BY FL.TRSP_SO_OFC_CTY_CD, FL.TRSP_SO_SEQ, COP_NO,FL.TRSP_COST_DTL_MOD_CD,  FL.BKG_NO    ,NVL(TRO.CFM_ALL_IN_RT_CD,'N') ,NVL(TRO.CFM_ALL_IN_RT_CD,'Y')    " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("    UNION ALL            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT    /*+ ORDERED INDEX(SV XAK7TRS_TRSP_SVC_ORD) USE_HASH(WRK) */" ).append("\n"); 
		query.append("                SV. TRSP_SO_OFC_CTY_CD, SV.TRSP_SO_SEQ, SV.BKG_NO, SV.COP_NO , 'DR' COSTMODE, 'Y' TRO_MANI            " ).append("\n"); 
		query.append("                ,0 D2, 0 D4    ,0 D5 ,0 D7    ,0 D_etc ,0 R2 ,0 R4            " ).append("\n"); 
		query.append("                ,0 R5, 0 R7 ,0 R8 ,0 O2 ,0 O4    ,0 O5  ,0 O7 ,0 S2  ,0 S4 ,0 F2            " ).append("\n"); 
		query.append("                ,0 F4, 0 A2    ,0 A4 ,0 F5 ,0 P2    ,0 P4  ,0 T2 ,0 T4            " ).append("\n"); 
		query.append("                ,MAX(SV.CRE_OFC_CD) WRK_OFC, MAX( COP.TRO_PROC_CD ) TRO_STS            " ).append("\n"); 
		query.append("                ,MAX(SV.TRSP_BND_CD) TRSP_BND_CD , MAX( BKG_RCVDE_TERM_CD ) TERM , MAX( TO_CHAR( SV.LOCL_CRE_DT, 'RRRRMM') ) WO_DT            " ).append("\n"); 
		query.append("                ,0 WO_COST, 0 INV_COST, 0 REV_1 ,0 TRO_MANI_Y_REV ,0 TRO_REV            " ).append("\n"); 
		query.append("        FROM    TRS_TRSP_SVC_ORD SV,TRS_TRSP_WRK_ORD WRK, BKG_BOOKING BK,         " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT    A.COP_NO, B.TRO_PROC_CD, B.EUR_TRNS_TP_CD            " ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD A, BKG_EUR_TRO B            " ).append("\n"); 
		query.append("                WHERE    1=1            " ).append("\n"); 
		query.append("                        AND A.BKG_NO = B.BKG_NO(+)             " ).append("\n"); 
		query.append("                        AND A.TRSP_BND_CD = B.IO_BND_CD(+)            " ).append("\n"); 
		query.append("                        AND A.TRO_SEQ = B.TRO_SEQ(+)            " ).append("\n"); 
		query.append("                        AND A.TRSP_RQST_ORD_REV_AMT IN (0, NULL)            " ).append("\n"); 
		query.append("                        AND B.TRNS_REV_AMT IN (0, NULL)            " ).append("\n"); 
		query.append("                        AND B.NMF_TRNS_REV_AMT IN (0, NULL)    " ).append("\n"); 
		query.append("                        AND B.ADD_REV_AMT IN (0, NULL)" ).append("\n"); 
		query.append("                        AND A.TRSP_COST_DTL_MOD_CD = 'DR'            " ).append("\n"); 
		query.append("                ) COP            " ).append("\n"); 
		query.append("        WHERE    SV.COP_NO = COP.COP_NO     " ).append("\n"); 
		query.append("                AND SV.TRSP_COST_DTL_MOD_CD = 'CY'        " ).append("\n"); 
		query.append("                AND SV.TRSP_WO_OFC_CTY_CD = WRK.TRSP_WO_OFC_CTY_CD     " ).append("\n"); 
		query.append("                AND SV.TRSP_WO_SEQ= WRK.TRSP_WO_SEQ     " ).append("\n"); 
		query.append("                AND SV.BKG_NO = BK.BKG_NO(+)     " ).append("\n"); 
		query.append("                AND TRSP_COST_DTL_MOD_CD IN ('CY','DR','ER','CF','CN' )        " ).append("\n"); 
		query.append("                AND DECODE(SV.TRSP_COST_DTL_MOD_CD, 'CY',TRSP_CRR_MOD_CD, 'TD') IN ('TD', 'RD', 'TR', 'RT')        " ).append("\n"); 
		query.append("                AND DECODE(SV.TRSP_COST_DTL_MOD_CD, 'CY',BKG_RCVDE_TERM_CD, 'D') = 'D'     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($MONTH_FLG) " ).append("\n"); 
		query.append("    AND SV.LOCL_CRE_DT BETWEEN TO_DATE( @[SO_FMDT] , 'RRRRMM') AND LAST_DAY( to_date( @[SO_TODT], 'RRRRMM'))+1" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    AND SV.LOCL_CRE_DT BETWEEN TO_DATE( @[SO_FMDT] , 'RRRRMMDD') AND TO_DATE( @[SO_TODT], 'RRRRMMDD')+0.999" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${HID_BOUNDMODE} != 'ALL') " ).append("\n"); 
		query.append("    AND   SV.TRSP_BND_CD = @[HID_BOUNDMODE]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INPUT_OFFICE.size() > 0) " ).append("\n"); 
		query.append("    AND WRK.CRE_OFC_CD  IN (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${INPUT_OFFICE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $INPUT_OFFICE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($FRM_NODE.size() > 0) " ).append("\n"); 
		query.append("    AND   SV.FM_NOD_CD  IN  (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${FRM_NODE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $FRM_NODE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($TO_NODE.size() > 0) " ).append("\n"); 
		query.append("    AND   SV.TO_NOD_CD  IN  (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${TO_NODE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $TO_NODE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if(${HID_BKGTERM} == 'Y') " ).append("\n"); 
		query.append("    AND DECODE ( SV.TRSP_BND_CD, 'O' , BK.RCV_TERM_CD ,'I' ,BK.DE_TERM_CD )= 'Y'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${HID_TROSTS} == 'C') " ).append("\n"); 
		query.append("    AND COP.TRO_PROC_CD = 'C'" ).append("\n"); 
		query.append("    AND NVL(COP.EUR_TRNS_TP_CD,'X') <>'FR' " ).append("\n"); 
		query.append("#elseif (${HID_TROSTS} == 'F') " ).append("\n"); 
		query.append("    AND ( NVL(COP.TRO_PROC_CD,'N')  <> 'C'" ).append("\n"); 
		query.append("    OR NVL(COP.EUR_TRNS_TP_CD,'X') ='FR' )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        GROUP BY SV.TRSP_SO_OFC_CTY_CD, SV.TRSP_SO_SEQ, SV.COP_NO,SV.TRSP_COST_DTL_MOD_CD,  SV.BKG_NO    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) B     " ).append("\n"); 
		query.append("    WHERE     " ).append("\n"); 
		query.append("        A.COP_NO = B.COP_NO     " ).append("\n"); 
		query.append("    AND A.TRSP_BND_CD = B.TRSP_BND_CD     " ).append("\n"); 
		query.append("    AND A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    AND A.TRSP_SO_TP_CD = 'Y'     " ).append("\n"); 
		query.append("    AND A.DELT_FLG <> 'Y'     " ).append("\n"); 
		query.append("    AND   XA.ACCT_XCH_RT_LVL = 1     " ).append("\n"); 
		query.append("    AND   XA.CURR_CD = A.CURR_CD     " ).append("\n"); 
		query.append("    AND   XA.ACCT_XCH_RT_YRMON = B.WO_DT     " ).append("\n"); 
		query.append("    AND   XB.ACCT_XCH_RT_LVL = 1     " ).append("\n"); 
		query.append("    AND   XB.CURR_CD = NVL(A.INV_CURR_CD,'EUR')     " ).append("\n"); 
		query.append("    AND   XB.ACCT_XCH_RT_YRMON = B.WO_DT     " ).append("\n"); 
		query.append("    GROUP BY  CUBE(   " ).append("\n"); 
		query.append("             WRK_OFC, B.TRSP_BND_CD   " ).append("\n"); 
		query.append("    )     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${HID_BOUNDMODE} != 'ALL') " ).append("\n"); 
		query.append("    HAVING   B.TRSP_BND_CD = @[HID_BOUNDMODE]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL     " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        SELECT      " ).append("\n"); 
		query.append("                1,  9,WRK.CRE_OFC_CD  WRK_OFC     " ).append("\n"); 
		query.append("                ,'Mty' BND     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'D2', 1, 0)) D2      " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'D4', 1, 0)) D4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'D5', 1, 0)) D5      " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'D7', 1, 0)) D7      " ).append("\n"); 
		query.append("                ,SUM(DECODE(SUBSTR(MT.EQ_TPSZ_CD,1,1) , 'D',DECODE (MT.EQ_TPSZ_CD,'D2',0,'D4',0,'D5',0,'D7',0, 1))) D_etc     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'R2', 1, 0)) R2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'R4', 1, 0)) R4      " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'R5', 1, 0)) R5      " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'R7', 1, 0)) R7     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'R8', 1, 0)) R8     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'O2', 1, 0)) O2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'O4', 1, 0)) O4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'O5', 1, 0)) O5" ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'O7', 1, 0)) O7" ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'S2', 1, 0)) S2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'S4', 1, 0)) S4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'F2', 1, 0)) F2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'F4', 1, 0)) F4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'A2', 1, 0)) A2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'A4', 1, 0)) A4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'F5', 1, 0)) F5     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'P2', 1, 0)) P2      " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'P4', 1, 0)) P4     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'T2', 1, 0)) T2     " ).append("\n"); 
		query.append("                ,SUM(DECODE(MT.EQ_TPSZ_CD, 'T4', 1, 0)) T4     " ).append("\n"); 
		query.append("                ,COUNT( MT.EQ_TPSZ_CD ) VOL_TOT  " ).append("\n"); 
		query.append("                ,SUM( DECODE( SUBSTR( MT.EQ_TPSZ_CD,2,1) , '2', 1,0) ) VOL_20     " ).append("\n"); 
		query.append("                ,SUM( DECODE( SUBSTR( MT.EQ_TPSZ_CD,2,1) , '2', 0,1) ) VOL_40     " ).append("\n"); 
		query.append("                ,0 REV_1     " ).append("\n"); 
		query.append("                ,0 REV_2     " ).append("\n"); 
		query.append("                ,0 REV_3     " ).append("\n"); 
		query.append("                ,SUM(ROUND( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC( 'USD', ( NVl(BZC_AMT,0)+NVL(ETC_ADD_AMT,0)+NVL(HJL_HNDL_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(NEGO_AMT,0) ) /FM1.USD_LOCL_XCH_RT , TO_CHAR(MT.LOCL_CRE_DT,'RRRRMM')  )    ,2)) WO_COST    " ).append("\n"); 
		query.append("                ,SUM(ROUND( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC( 'USD', DECODE( NVL(INV_BZC_AMT,0) + NVL(INV_ETC_ADD_AMT,0), 0 , ( NVl(BZC_AMT,0)+NVL(ETC_ADD_AMT,0)+NVL(HJL_HNDL_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(NEGO_AMT,0) ) /FM1.USD_LOCL_XCH_RT , 0 ) , TO_CHAR(MT.LOCL_CRE_DT,'RRRRMM') )   ,2)  ) RECAL_WO       " ).append("\n"); 
		query.append("                ,0-  SUM(ROUND( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC( 'USD', ( NVl(BZC_AMT,0)+NVL(ETC_ADD_AMT,0)+NVL(HJL_HNDL_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(NEGO_AMT,0) ) /FM1.USD_LOCL_XCH_RT,  TO_CHAR(MT.LOCL_CRE_DT,'RRRRMM') ) ,     2)  ) DIFF_1     " ).append("\n"); 
		query.append("                ,0-  SUM(ROUND( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC( 'USD', ( NVl(BZC_AMT,0)+NVL(ETC_ADD_AMT,0)+NVL(HJL_HNDL_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(NEGO_AMT,0) ) /FM1.USD_LOCL_XCH_RT,  TO_CHAR(MT.LOCL_CRE_DT,'RRRRMM') ) ,     2)  ) DIFF_2     " ).append("\n"); 
		query.append("                ,SUM(ROUND( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC( 'USD',  (NVL(INV_BZC_AMT,0) + NVL(INV_ETC_ADD_AMT,0))/FM2.USD_LOCL_XCH_RT , TO_CHAR(MT.LOCL_CRE_DT,'RRRRMM') ) , 2) ) INV_COST     " ).append("\n"); 
		query.append("                ,0-SUM(ROUND( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC( 'USD', (NVL(BZC_AMT,0)+NVL(ETC_ADD_AMT,0)+NVL(HJL_HNDL_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(NEGO_AMT,0) ) /FM1.USD_LOCL_XCH_RT , TO_CHAR(MT.LOCL_CRE_DT,'RRRRMM')  )    ,2)) DIFF_3    " ).append("\n"); 
		query.append("                ,0-SUM(ROUND( TRS_COMMON_PKG.GET_CONVERSION_EUR_AMT_FNC( 'USD', (NVL(INV_BZC_AMT,0) + NVL(INV_ETC_ADD_AMT,0))/FM2.USD_LOCL_XCH_RT , TO_CHAR(MT.LOCL_CRE_DT,'RRRRMM') ) , 2) ) DIFF_4     " ).append("\n"); 
		query.append("        FROM    TRS_TRSP_SVC_ORD MT, TRS_TRSP_WRK_ORD WRK, GL_MON_XCH_RT FM2 , GL_MON_XCH_RT FM1     " ).append("\n"); 
		query.append("        WHERE      " ).append("\n"); 
		query.append("                MT.CGO_TP_CD = 'M'     " ).append("\n"); 
		query.append("                AND MT.EQ_KND_CD = 'U'     " ).append("\n"); 
		query.append("                AND MT.TRSP_SO_TP_CD = 'M'     " ).append("\n"); 
		query.append("                AND MT.TRSP_COST_DTL_MOD_CD = 'ER'" ).append("\n"); 
		query.append("                AND MT.TRSP_WO_OFC_CTY_CD = WRK.TRSP_WO_OFC_CTY_CD     " ).append("\n"); 
		query.append("                AND MT.TRSP_WO_SEQ= WRK.TRSP_WO_SEQ     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($MONTH_FLG) " ).append("\n"); 
		query.append("    AND MT.LOCL_CRE_DT BETWEEN TO_DATE( @[SO_FMDT] , 'RRRRMM') AND LAST_DAY( to_date( @[SO_TODT] , 'RRRRMM'))+1" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    AND MT.LOCL_CRE_DT BETWEEN TO_DATE( @[SO_FMDT] , 'RRRRMMDD') AND TO_DATE( @[SO_TODT] , 'RRRRMMDD')+1    " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${HID_INCLMTY} != 'Y') " ).append("\n"); 
		query.append("    AND   MT.TRSP_SO_SEQ = 0    " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INPUT_OFFICE.size() > 0) " ).append("\n"); 
		query.append("    AND WRK.CRE_OFC_CD  IN (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${INPUT_OFFICE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $INPUT_OFFICE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($FRM_NODE.size() > 0) " ).append("\n"); 
		query.append("    AND   MT.FM_NOD_CD  IN  (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${FRM_NODE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $FRM_NODE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($TO_NODE.size() > 0) " ).append("\n"); 
		query.append("    AND  MT.TO_NOD_CD  IN  (" ).append("\n"); 
		query.append("        #foreach( ${key} in ${TO_NODE}) " ).append("\n"); 
		query.append("            #if($velocityCount < $TO_NODE.size()) " ).append("\n"); 
		query.append("                UPPER('$key'), " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                UPPER('$key') " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND   FM1.ACCT_XCH_RT_LVL = 1     " ).append("\n"); 
		query.append("    AND   FM1.CURR_CD = MT.CURR_CD     " ).append("\n"); 
		query.append("    AND   FM1.ACCT_XCH_RT_YRMON = TO_CHAR(MT.LOCL_CRE_DT,'YYYYMM')     " ).append("\n"); 
		query.append("    AND   FM2.ACCT_XCH_RT_LVL = 1     " ).append("\n"); 
		query.append("    AND   FM2.CURR_CD = NVL(MT.INV_CURR_CD,'EUR')     " ).append("\n"); 
		query.append("    AND   FM2.ACCT_XCH_RT_YRMON = TO_CHAR(MT.LOCL_CRE_DT,'YYYYMM')     " ).append("\n"); 
		query.append("    GROUP BY       " ).append("\n"); 
		query.append("    WRK.CRE_OFC_CD     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )    ORDER BY DEP, WRK_OFC,GR_ID,TRSP_BND_CD" ).append("\n"); 

	}
}