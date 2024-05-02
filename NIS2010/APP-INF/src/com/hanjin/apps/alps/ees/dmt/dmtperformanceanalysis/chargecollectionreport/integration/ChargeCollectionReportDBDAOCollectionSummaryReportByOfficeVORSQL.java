/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Collection Status Report by Office의 상세 내역을 조회
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOCollectionSummaryReportByOfficeVORSQL").append("\n"); 
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
		query.append("SELECT  OFC_CD" ).append("\n"); 
		query.append("	   ,OFC_RHQ_CD" ).append("\n"); 
		query.append("	   ,SUBSTR(TO_MVMT_DT, 0, 4) YEAR" ).append("\n"); 
		query.append("	   ,SUBSTR(TO_MVMT_DT, 5, 2) MONTH" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			SELECT  CASE" ).append("\n"); 
		query.append("                         WHEN Y.OFC_CD='DXBBA' -- DXBBA 오피스는 테이블 값이 존재하지않아 강제로 값을 정함" ).append("\n"); 
		query.append("							THEN 'DXBSC'" ).append("\n"); 
		query.append("                         ELSE (" ).append("\n"); 
		query.append("								SELECT  CASE" ).append("\n"); 
		query.append("											-- 아래 오피스는 4레벨" ).append("\n"); 
		query.append("											WHEN Y.OFC_CD IN (" ).append("\n"); 
		query.append("													--HAMRU" ).append("\n"); 
		query.append("													'KOPBA', 'TLLBA', 'CASBA', 'LEIBA', 'LISBA', 'TUNBA', " ).append("\n"); 
		query.append("													--NYCRA" ).append("\n"); 
		query.append("													'CCSBA'," ).append("\n"); 
		query.append("													--SHARC" ).append("\n"); 
		query.append("													'CANSO', 'KHHBA'," ).append("\n"); 
		query.append("													--TYOIB" ).append("\n"); 
		query.append("													'KIJBA', 'NGOSO', 'TMKBA'," ).append("\n"); 
		query.append("													--SINRS" ).append("\n"); 
		query.append("													'BLRBA', 'BRCBA', 'HYDBA', 'IDRBA', 'JPRBA', 'KNPBA', 'MUNBA', 'NAGBA', 'PAVKS', 'PNVBA', " ).append("\n"); 
		query.append("													'TUTBA', 'TUTBS', 'VPMKS', 'CMBSC', 'CGPKS', 'DACSC', 'DARBA', 'DJIBA', 'DURBA', 'AUHSO', " ).append("\n"); 
		query.append("													'DOHBA', 'DXBBA', 'DXBSC', 'IRQBA', 'JORBA', 'THRBA', 'DMNBA', 'JEDBA', 'BLWBA', 'JKTBA', " ).append("\n"); 
		query.append("													'JKTSC', 'KHIBA', 'KWIBA', 'MBABA', 'MNLBA'" ).append("\n"); 
		query.append("												) " ).append("\n"); 
		query.append("												THEN OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("											-- OFC_KND_CD & OFC_LVL 조합으로 5레벨 컨트롤 오피스인 부분만 구한다" ).append("\n"); 
		query.append("											WHEN   (OFC_KND_CD = 6 AND OFC_LVL = 5)" ).append("\n"); 
		query.append("												OR (OFC_KND_CD = 6 AND OFC_LVL = 6)" ).append("\n"); 
		query.append("												OR (OFC_KND_CD = 3 AND OFC_LVL = 5)" ).append("\n"); 
		query.append("												OR (OFC_KND_CD = 4 AND OFC_LVL = 6) " ).append("\n"); 
		query.append("												THEN OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("											ELSE OFC_N4TH_LVL_CD -- 그외에는 모두 4레벨" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("								  FROM  DMT_OFC_LVL_V" ).append("\n"); 
		query.append("								 WHERE  OFC_N8TH_LVL_CD = Y.OFC_CD " ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("			  FROM  DUAL " ).append("\n"); 
		query.append("		) AS CTRL_OFC_CD" ).append("\n"); 
		query.append("	   ,DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,TTL_CNTR" ).append("\n"); 
		query.append("	   ,CURR_CD" ).append("\n"); 
		query.append("	   ,INCR_CNTR" ).append("\n"); 
		query.append("	   ,INCR_AMT" ).append("\n"); 
		query.append("	   ,CMDT_CNTR" ).append("\n"); 
		query.append("	   ,CMDT_AMT" ).append("\n"); 
		query.append("	   ,EXPT_CNTR" ).append("\n"); 
		query.append("	   ,EXPT_AMT" ).append("\n"); 
		query.append("	   ,DC_CNTR" ).append("\n"); 
		query.append("	   ,DC_AMT" ).append("\n"); 
		query.append("	   ,BILL_CNTR1" ).append("\n"); 
		query.append("	   ,BILL_AMT1" ).append("\n"); 
		query.append("	   ,BILL_CNTR" ).append("\n"); 
		query.append("	   ,BILL_AMT" ).append("\n"); 
		query.append("	   ,INV_CNTR" ).append("\n"); 
		query.append("	   ,INV_AMT" ).append("\n"); 
		query.append("	   ,INV_IF_CNTR 				AS COLL_CNTR" ).append("\n"); 
		query.append("	   ,INV_IF_AMT 					AS COLL_AMT" ).append("\n"); 
		query.append("	   ,CEIL( ( COLL_AMT + INV_PAY_AMT ) / DECODE(INCR_AMT,  0, 1, INCR_AMT) *10000) / 100	AS COLL_RTO_A" ).append("\n"); 
		query.append("	   ,CEIL( ( COLL_AMT + INV_PAY_AMT ) / DECODE(BILL_AMT1, 0, 1, BILL_AMT1)*10000) / 100	AS COLL_RTO_B" ).append("\n"); 
		query.append("	   ,CEIL( ( COLL_AMT + INV_PAY_AMT ) / DECODE(INV_AMT,   0, 1, BILL_AMT) *10000) / 100	AS COLL_RTO_C" ).append("\n"); 
		query.append("	   ,CEIL( ( COLL_AMT + INV_PAY_AMT ) / DECODE(INV_AMT,   0, 1, INV_AMT)  *10000) / 100	AS COLL_RTO_D" ).append("\n"); 
		query.append("       ,NVL(INV_PAY_AMT,0) 			AS INV_PAY_AMT" ).append("\n"); 
		query.append("       ,NVL(INV_PAY_CNTR,0) 		AS INV_PAY_CNTR" ).append("\n"); 
		query.append("       ,( COLL_AMT + INV_PAY_AMT ) 	AS ALL_COLL_AMT" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  X.OFC_CD             	AS OFC_CD" ).append("\n"); 
		query.append("			       ,X.OFC_RHQ_CD         	AS OFC_RHQ_CD" ).append("\n"); 
		query.append("				   ,X.TO_MVMT_DT		 	AS TO_MVMT_DT" ).append("\n"); 
		query.append("				   ,X.DMDT_TRF_CD        	AS DMDT_TRF_CD" ).append("\n"); 
		query.append("				   ,SUM(TTL_CNTR)        	AS TTL_CNTR" ).append("\n"); 
		query.append("				   ,X.CURR_CD            	AS CURR_CD" ).append("\n"); 
		query.append("				   ,SUM(X.INCR_CNTR  )   	AS INCR_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.INCR_AMT   )   	AS INCR_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.CMDT_CNTR  )   	AS CMDT_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.CMDT_AMT   )   	AS CMDT_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.EXPT_CNTR  )   	AS EXPT_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.EXPT_AMT   )   	AS EXPT_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.DC_CNTR    )   	AS DC_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.DC_AMT     )   	AS DC_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.BILL_CNTR1 )   	AS BILL_CNTR1" ).append("\n"); 
		query.append("				   ,SUM(X.BILL_AMT1  )   	AS BILL_AMT1" ).append("\n"); 
		query.append("				   ,SUM(X.BILL_CNTR  )   	AS BILL_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.BILL_AMT   )   	AS BILL_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.INV_CNTR   )   	AS INV_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.INV_AMT    )   	AS INV_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.INV_IF_CNTR )  	AS INV_IF_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.INV_IF_AMT   ) 	AS INV_IF_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.COLL_CNTR )    	AS COLL_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.COLL_AMT   )   	AS COLL_AMT" ).append("\n"); 
		query.append("				   ,SUM(X.INV_PAY_CNTR ) 	AS INV_PAY_CNTR" ).append("\n"); 
		query.append("				   ,SUM(X.INV_PAY_AMT)   	AS INV_PAY_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						SELECT  #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("							    DECODE(C.OFC_RHQ_CD, 'NYCHQ', 'NYCRA', C.OFC_RHQ_CD) AS OFC_CD" ).append("\n"); 
		query.append("								#else" ).append("\n"); 
		query.append("								C.OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							   ,C.OFC_RHQ_CD 					AS OFC_RHQ_CD" ).append("\n"); 
		query.append("							   ,TO_CHAR(C.TO_MVMT_DT, 'YYYYMM') AS TO_MVMT_DT" ).append("\n"); 
		query.append("							   ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("							   ,COUNT(C.CNTR_NO) 				AS TTL_CNTR" ).append("\n"); 
		query.append("							   ,DECODE( @[curr_flg], 'U', 'USD', C.BZC_TRF_CURR_CD ) CURR_CD" ).append("\n"); 
		query.append("							   ,SUM ( DECODE( NVL(C.ORG_CHG_AMT, 0), 0, 0, 1 ) ) 	INCR_CNTR" ).append("\n"); 
		query.append("							   ,SUM ( ROUND ( DECODE( @[curr_flg], 'U', C.ORG_CHG_AMT  / F.USD_LOCL_XCH_RT, C.ORG_CHG_AMT  ) , 2 )) INCR_AMT" ).append("\n"); 
		query.append("							   ,SUM ( DECODE( NVL(C.CMDT_EXPT_AMT, 0), 0, 0, 1 ) ) CMDT_CNTR" ).append("\n"); 
		query.append("							   ,SUM ( ROUND ( DECODE( @[curr_flg], 'U', NVL(C.CMDT_EXPT_AMT, 0) / F.USD_LOCL_XCH_RT, NVL(C.CMDT_EXPT_AMT, 0) ) , 2 )) CMDT_AMT" ).append("\n"); 
		query.append("							   ,SUM ( DECODE( NVL(C.SC_RFA_EXPT_AMT, 0), 0, 0, 1 ) ) EXPT_CNTR" ).append("\n"); 
		query.append("							   ,SUM ( ROUND ( DECODE( @[curr_flg], 'U', C.SC_RFA_EXPT_AMT / F.USD_LOCL_XCH_RT, C.SC_RFA_EXPT_AMT) , 2 )) EXPT_AMT" ).append("\n"); 
		query.append("							   ,SUM ( DECODE( NVL(C.AFT_EXPT_DC_AMT, 0), 0, 0, 1 ) ) DC_CNTR" ).append("\n"); 
		query.append("							   ,SUM ( ROUND ( DECODE( @[curr_flg], 'U', C.AFT_EXPT_DC_AMT  / F.USD_LOCL_XCH_RT, C.AFT_EXPT_DC_AMT  ) , 2 )) DC_AMT" ).append("\n"); 
		query.append("							   /* BILLABLE1 */" ).append("\n"); 
		query.append("							   ,SUM( DECODE( NVL(( C.BIL_AMT + NVL(C.AFT_EXPT_DC_AMT,0) ) , 0), 0, 0, 1 ) ) BILL_CNTR1" ).append("\n"); 
		query.append("							   ,SUM( ROUND( DECODE( @[curr_flg], 'U', ( C.BIL_AMT + NVL(C.AFT_EXPT_DC_AMT,0) ) / F.USD_LOCL_XCH_RT, ( C.BIL_AMT + NVL(C.AFT_EXPT_DC_AMT,0) ) ), 2 )) BILL_AMT1" ).append("\n"); 
		query.append("							   " ).append("\n"); 
		query.append("								/* BILLABLE2 */				   " ).append("\n"); 
		query.append("								,SUM( DECODE( NVL(C.BIL_AMT, 0), 0, 0, 1 ) ) BILL_CNTR" ).append("\n"); 
		query.append("								,SUM( ROUND( DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT ), 2 )) BILL_AMT" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("								/* INVOICE */			" ).append("\n"); 
		query.append("								,SUM( DECODE( V.DMDT_INV_STS_CD, 'I', 1, 0 )) INV_CNTR" ).append("\n"); 
		query.append("								,SUM( ROUND( DECODE( V.DMDT_INV_STS_CD, 'I', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT), 0), 2 )) INV_AMT" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("								/* COLLECTION */" ).append("\n"); 
		query.append("								,SUM(	CASE " ).append("\n"); 
		query.append("											WHEN NVL((   SELECT  ATTR_CTNT1 " ).append("\n"); 
		query.append("														  FROM  DMT_HRD_CDG_CTNT H " ).append("\n"); 
		query.append("														 WHERE  HRD_CDG_ID = 'AUTO_AR_IF_OFC' " ).append("\n"); 
		query.append("														   AND  ATTR_CTNT1 = V.CRE_OFC_CD ),'N') = 'N' THEN " ).append("\n"); 
		query.append("												DECODE( V.DMDT_AR_IF_CD, 'Y', 1, 0 )" ).append("\n"); 
		query.append("											ELSE " ).append("\n"); 
		query.append("												0 " ).append("\n"); 
		query.append("										END " ).append("\n"); 
		query.append("								) AS COLL_CNTR" ).append("\n"); 
		query.append("							   ,SUM( ROUND(	" ).append("\n"); 
		query.append("											CASE " ).append("\n"); 
		query.append("												WHEN NVL(( 	SELECT  ATTR_CTNT1 " ).append("\n"); 
		query.append("															  FROM  DMT_HRD_CDG_CTNT H " ).append("\n"); 
		query.append("															 WHERE  HRD_CDG_ID = 'AUTO_AR_IF_OFC' " ).append("\n"); 
		query.append("															   AND  ATTR_CTNT1 = V.CRE_OFC_CD ),'N') = 'N' THEN " ).append("\n"); 
		query.append("													DECODE (V.DMDT_AR_IF_CD, 'Y', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT ) , 0 ) " ).append("\n"); 
		query.append("												ELSE " ).append("\n"); 
		query.append("													0 " ).append("\n"); 
		query.append("												END, 2)" ).append("\n"); 
		query.append("								) COLL_AMT" ).append("\n"); 
		query.append("								/* INVOICE AR IF  */								" ).append("\n"); 
		query.append("							   ,SUM( DECODE( V.DMDT_AR_IF_CD, 'Y', 1, 0 ) ) INV_IF_CNTR" ).append("\n"); 
		query.append("							   ,SUM( ROUND(	DECODE (V.DMDT_AR_IF_CD, 'Y', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT ), 0 ), 2 )) INV_IF_AMT" ).append("\n"); 
		query.append("							   ,SUM( ROUND(CASE WHEN V.BIL_AMT != 0 AND NVL(( SELECT MIN(DECODE(AA.CRE_USR_ID,'ERP_MIG','N','Y')) FROM DMT_INV_OTS_PAY_RCV AA" ).append("\n"); 
		query.append("												   WHERE AA.DMDT_INV_NO = V.DMDT_INV_NO" ).append("\n"); 
		query.append("													 AND INV_PAY_RCV_SEQ < 2000000 ),'N') = 'N' THEN" ).append("\n"); 
		query.append("												ROUND(NVL(( SELECT SUM(DECODE( @[curr_flg], 'U', ( AA.INV_PAY_AMT*C.BIL_AMT/V.BIL_AMT/V.INV_XCH_RT ) / F.USD_LOCL_XCH_RT, AA.INV_PAY_AMT*C.BIL_AMT/V.BIL_AMT/V.INV_XCH_RT )) " ).append("\n"); 
		query.append("															  FROM DMT_INV_OTS_PAY_RCV AA" ).append("\n"); 
		query.append("															 WHERE AA.DMDT_INV_NO = V.DMDT_INV_NO" ).append("\n"); 
		query.append("															   AND ( AA.INV_PAY_RCV_SEQ >= 2000000 OR AA.CRE_USR_ID = 'ERP_MIG' )" ).append("\n"); 
		query.append("															   AND AA.DMDT_INV_PAY_TP_CD = 'M'" ).append("\n"); 
		query.append("											 ),0), 2 )                       " ).append("\n"); 
		query.append("									   WHEN V.BIL_AMT != 0 AND NVL(( SELECT MIN(DECODE(AA.CRE_USR_ID,'ERP_MIG','N','Y')) FROM DMT_INV_OTS_PAY_RCV AA" ).append("\n"); 
		query.append("												   WHERE AA.DMDT_INV_NO = V.DMDT_INV_NO" ).append("\n"); 
		query.append("													 AND INV_PAY_RCV_SEQ < 2000000                                      " ).append("\n"); 
		query.append("													 AND AA.DMDT_INV_PAY_TP_CD = 'M'),'N') = 'Y'  THEN DECODE (V.DMDT_AR_IF_CD, 'Y', DECODE( @[curr_flg], 'U', C.BIL_AMT / F.USD_LOCL_XCH_RT, C.BIL_AMT ) , 0 )" ).append("\n"); 
		query.append("									   ELSE 0 END ,2)) AS INV_PAY_AMT" ).append("\n"); 
		query.append("							   ,SUM(CASE WHEN NVL(( SELECT SUM(AA.INV_PAY_AMT)" ).append("\n"); 
		query.append("										   FROM DMT_INV_OTS_PAY_RCV AA" ).append("\n"); 
		query.append("										  WHERE AA.DMDT_INV_NO = V.DMDT_INV_NO" ).append("\n"); 
		query.append("											AND ( AA.INV_PAY_RCV_SEQ >= 2000000 OR AA.CRE_USR_ID = 'ERP_MIG' )" ).append("\n"); 
		query.append("											AND AA.DMDT_INV_PAY_TP_CD = 'M'  ), 0) != 0 THEN 1" ).append("\n"); 
		query.append("									  WHEN NVL(( SELECT MIN(DECODE(AA.CRE_USR_ID,'ERP_MIG','N','Y')) FROM DMT_INV_OTS_PAY_RCV AA" ).append("\n"); 
		query.append("													WHERE AA.DMDT_INV_NO = V.DMDT_INV_NO" ).append("\n"); 
		query.append("													  AND ( AA.INV_PAY_RCV_SEQ < 2000000 AND AA.CRE_USR_ID != 'ERP_MIG' )" ).append("\n"); 
		query.append("													  AND AA.DMDT_INV_PAY_TP_CD = 'M' ),'N') = 'Y' THEN DECODE( V.DMDT_AR_IF_CD, 'Y', 1, 0 )" ).append("\n"); 
		query.append("									 ELSE 0 END ) INV_PAY_CNTR" ).append("\n"); 
		query.append("					 " ).append("\n"); 
		query.append("					 " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC	  C" ).append("\n"); 
		query.append("							   ,DMT_INV_MN		  V" ).append("\n"); 
		query.append("							   ,DMT_CHG_BKG_CNTR  B" ).append("\n"); 
		query.append("							   ,GL_MON_XCH_RT	  F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						 WHERE  C.TO_MVMT_DT BETWEEN TO_DATE(@[start_dt],'YYYYMMDD') +.0  AND TO_DATE(@[end_dt],'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("						   AND  C.DMDT_CHG_STS_CD IN ( 'F' ,'C', 'I', 'N')" ).append("\n"); 
		query.append("						   " ).append("\n"); 
		query.append("						   -- 조건추가(S) 2013.10.23" ).append("\n"); 
		query.append("						   #if(${uclm_flg} != 'ALL')          " ).append("\n"); 
		query.append("						   AND  NVL(C.UCLM_FLG, 'N') = @[uclm_flg]" ).append("\n"); 
		query.append("						   #end" ).append("\n"); 
		query.append("						   " ).append("\n"); 
		query.append("						   -- 조건추가(E)" ).append("\n"); 
		query.append("						   #if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("						   AND  C.OFC_CD IN (" ).append("\n"); 
		query.append("								#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("									#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   #elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("						   AND  C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("						   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						   AND  C.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("								#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("									#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   AND  ( C.ORG_CHG_AMT > 0 OR C.BIL_AMT > 0 )" ).append("\n"); 
		query.append("						   AND  C.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  C.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("						   AND  C.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  C.DMDT_INV_NO		=	V.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("						   AND  C.DMDT_CHG_LOC_DIV_CD <> 'SZP'	-- 2010/03/18 추가" ).append("\n"); 
		query.append("						   -- 2010/03/25 추가" ).append("\n"); 
		query.append("						   AND  (" ).append("\n"); 
		query.append("									(C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C') OR (C.DUL_TP_EXPT_FLG = 'N')" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   AND  (" ).append("\n"); 
		query.append("									(C.DMDT_CHG_STS_CD <> 'I') OR (C.DMDT_CHG_STS_CD = 'I' AND V.DMDT_INV_STS_CD = 'I' AND V.DMDT_AR_IF_CD <> 'H')" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						   #if (${dmdt_cntr_tp_cd} != 'A')" ).append("\n"); 
		query.append("						   AND  B.DMDT_CNTR_TP_CD IN (" ).append("\n"); 
		query.append("								#foreach( $cntr_tp in ${cntr_tp_list} )" ).append("\n"); 
		query.append("									#if ($cntr_tp == 'S')" ).append("\n"); 
		query.append("									'F', 'O', 'T', 'P', 'S', 'A'" ).append("\n"); 
		query.append("									#elseif ($cntr_tp == 'D' || $cntr_tp == 'R')" ).append("\n"); 
		query.append("									'$cntr_tp'" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if($velocityCount < $cntr_tp_list.size()) , #end" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						   AND  F.ACCT_XCH_RT_YRMON	= TO_CHAR(C.TO_MVMT_DT,'YYYYMM')" ).append("\n"); 
		query.append("						   AND  F.ACCT_XCH_RT_LVL	= '1'" ).append("\n"); 
		query.append("						   AND  F.CURR_CD          	= C.BZC_TRF_CURR_CD		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						GROUP BY #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("								 DECODE(C.OFC_RHQ_CD, 'NYCHQ', 'NYCRA', C.OFC_RHQ_CD)" ).append("\n"); 
		query.append("								 #else" ).append("\n"); 
		query.append("								 C.OFC_CD" ).append("\n"); 
		query.append("								 #end" ).append("\n"); 
		query.append("				                ,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("				                ,TO_CHAR(C.TO_MVMT_DT, 'YYYYMM')" ).append("\n"); 
		query.append("				                ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("				                ,DECODE( @[curr_flg], 'U', 'USD', C.BZC_TRF_CURR_CD )" ).append("\n"); 
		query.append("				                ,V.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("					) X" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			GROUP BY X.OFC_CD" ).append("\n"); 
		query.append("			        ,X.OFC_RHQ_CD" ).append("\n"); 
		query.append("					,X.TO_MVMT_DT" ).append("\n"); 
		query.append("					,X.DMDT_TRF_CD" ).append("\n"); 
		query.append("					,X.CURR_CD" ).append("\n"); 
		query.append("		) Y" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SUBSTR(TO_MVMT_DT, 0, 4)" ).append("\n"); 
		query.append("        ,SUBSTR(TO_MVMT_DT, 5, 2)" ).append("\n"); 
		query.append("        ,OFC_RHQ_CD" ).append("\n"); 
		query.append("        ,OFC_CD" ).append("\n"); 

	}
}