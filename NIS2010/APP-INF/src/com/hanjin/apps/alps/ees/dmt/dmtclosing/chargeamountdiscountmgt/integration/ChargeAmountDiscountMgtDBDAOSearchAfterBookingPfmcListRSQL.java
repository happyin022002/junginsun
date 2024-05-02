/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcList
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingPfmcListRSQL").append("\n"); 
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
		query.append("SELECT B.CUST_CD" ).append("\n"); 
		query.append("     , B.CUST_NM" ).append("\n"); 
		query.append("     , A.POL_CD" ).append("\n"); 
		query.append("     , A.POD_CD" ).append("\n"); 
		query.append("     , A.DMDT_TRF_CD" ).append("\n"); 
		query.append("     , NVL(A.ORG_CHG_AMT,0) ORG_CHG_AMT" ).append("\n"); 
		query.append("     , NVL(A.EXPT_AMT,0) EXPT_AMT" ).append("\n"); 
		query.append("     , NVL(AFT_EXPT_DC_AMT,0) AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("     , NVL(BILL_AMT,0) BILL_AMT" ).append("\n"); 
		query.append("     , NVL(INV_PAY_AMT,0) INV_PAY_AMT" ).append("\n"); 
		query.append("     , DECODE(NVL(BILL_AMT,0),0,0, ROUND(INV_PAY_AMT/BILL_AMT * 100,2)) AS COLL_RT" ).append("\n"); 
		query.append("     , DECODE(NVL(ORG_CHG_AMT,0),0,0,ROUND(( EXPT_AMT + AFT_EXPT_DC_AMT )/ORG_CHG_AMT * 100,2)) AS EXPT_DC_RT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT CUST_CD, ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = SUBSTR(CUST_CD,1,2) AND CUST_SEQ = TO_NUMBER(SUBSTR(CUST_CD,3))) CUST_NM," ).append("\n"); 
		query.append("                   POL_CD, POD_CD, DMDT_TRF_CD, " ).append("\n"); 
		query.append("                   ROUND(SUM(ORG_CHG_AMT/USD_LOCL_XCH_RT),2) ORG_CHG_AMT, " ).append("\n"); 
		query.append("                   ROUND(SUM((CMDT_EXPT_AMT + SC_RFA_EXPT_AMT)/USD_LOCL_XCH_RT),2) AS EXPT_AMT," ).append("\n"); 
		query.append("                   ROUND(SUM(AFT_EXPT_DC_AMT/USD_LOCL_XCH_RT),2) AFT_EXPT_DC_AMT, " ).append("\n"); 
		query.append("                   ROUND(SUM(BILL_AMT/USD_LOCL_XCH_RT),2) BILL_AMT, " ).append("\n"); 
		query.append("                   ROUND(SUM(INV_PAY_AMT/USD_LOCL_XCH_RT),2) INV_PAY_AMT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                        SELECT /*+ USE_CONCAT */" ).append("\n"); 
		query.append("                            @[cust_cd] CUST_CD," ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            SUBSTR(BB.POL_CD,1,2)        POL_CD, " ).append("\n"); 
		query.append("                            SUBSTR(BB.POD_CD,1,2)        POD_CD, " ).append("\n"); 
		query.append("                            T2.DMDT_TRF_CD, " ).append("\n"); 
		query.append("            	            T2.BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("            	            SUM ( T2.ORG_CHG_AMT ) ORG_CHG_AMT, " ).append("\n"); 
		query.append("                            SUM ( NVL(T2.CMDT_EXPT_AMT, 0) ) CMDT_EXPT_AMT, " ).append("\n"); 
		query.append("                            SUM ( T2.SC_RFA_EXPT_AMT ) SC_RFA_EXPT_AMT," ).append("\n"); 
		query.append("                            SUM ( T2.AFT_EXPT_DC_AMT ) AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("                            SUM(  T2.BIL_AMT ) BILL_AMT, " ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            ROUND(SUM( NVL(( SELECT SUM(A.INV_PAY_AMT/B.INV_XCH_RT/B.BKG_CNTR_QTY)" ).append("\n"); 
		query.append("                                      FROM DMT_INV_OTS_PAY_RCV A, DMT_INV_MN B" ).append("\n"); 
		query.append("                                      WHERE A.DMDT_INV_NO = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("                                        AND A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("                                        AND DMDT_INV_PAY_TP_CD = 'M'" ).append("\n"); 
		query.append("                                        AND B.DMDT_AR_IF_CD = 'Y' ),0) ),2) INV_PAY_AMT," ).append("\n"); 
		query.append("                            ( SELECT USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND  ACCT_XCH_RT_YRMON	=	TO_CHAR(T2.TO_MVMT_DT,'YYYYMM') " ).append("\n"); 
		query.append("                                 AND  ACCT_XCH_RT_LVL	=	'1' " ).append("\n"); 
		query.append("                                 AND  CURR_CD			=	T2.BZC_TRF_CURR_CD )  USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    FROM    BKG_BOOKING BB" ).append("\n"); 
		query.append("            				, DMT_CHG_BKG_CNTR T1 " ).append("\n"); 
		query.append("                            , DMT_CHG_CALC     T2 " ).append("\n"); 
		query.append("                    WHERE   1=1 " ).append("\n"); 
		query.append("                    AND   BB.RFA_NO IN (( SELECT	RFH.RFA_NO" ).append("\n"); 
		query.append("                                              FROM	PRI_RP_MN RFA ,PRI_RP_HDR RFH" ).append("\n"); 
		query.append("                                             WHERE RFA.PROP_NO = RFH.PROP_NO " ).append("\n"); 
		query.append("                                               AND RFA.AMDT_SEQ = (SELECT /*+ NO_UNNEST */ MAX (AMDT_SEQ) " ).append("\n"); 
		query.append("                                                                     FROM PRI_RP_MN " ).append("\n"); 
		query.append("                                                                    WHERE PROP_NO = RFH.PROP_NO " ).append("\n"); 
		query.append("                                                                      AND ROWNUM <= 1) " ).append("\n"); 
		query.append("                                			 " ).append("\n"); 
		query.append("                                				AND RFA.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2) " ).append("\n"); 
		query.append("                                				AND RFA.CTRT_CUST_SEQ	= SUBSTR(@[cust_cd], 3) ))" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                    AND     BB.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                    AND     T2.TO_MVMT_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("            			                  AND     TO_DATE(@[to_dt], 'YYYY-MM-DD') + .99999 " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("                    AND T2.DMDT_CHG_STS_CD	IN ('F', 'C', 'I', 'N') " ).append("\n"); 
		query.append("                    AND T2.SYS_AREA_GRP_ID	= T1.SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("                    AND T2.CNTR_NO			= T1.CNTR_NO " ).append("\n"); 
		query.append("                    AND T2.CNTR_CYC_NO		= T1.CNTR_CYC_NO " ).append("\n"); 
		query.append("                    AND	T2.DMDT_CHG_LOC_DIV_CD <> 'SZP'				        AND	            ( " ).append("\n"); 
		query.append("                        (T2.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(T2.DMDT_TRF_CD, 1, 1) = 'C') " ).append("\n"); 
		query.append("                        OR " ).append("\n"); 
		query.append("                        (T2.DUL_TP_EXPT_FLG = 'N') " ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                    AND T2.ORG_CHG_AMT > 0" ).append("\n"); 
		query.append("            GROUP BY " ).append("\n"); 
		query.append("                            SUBSTR(BB.POL_CD,1,2)        , " ).append("\n"); 
		query.append("                            SUBSTR(BB.POD_CD,1,2)        , " ).append("\n"); 
		query.append("                            T2.DMDT_TRF_CD 				 ," ).append("\n"); 
		query.append("							T2.TO_MVMT_DT," ).append("\n"); 
		query.append("							T2.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            UNION ALL" ).append("\n"); 
		query.append("            SELECT          /*+ USE_CONCAT */                  " ).append("\n"); 
		query.append("                            @[cust_cd] CUST_CD," ).append("\n"); 
		query.append("                            SUBSTR(BB.POL_CD,1,2)        POL_CD, " ).append("\n"); 
		query.append("                            SUBSTR(BB.POD_CD,1,2)        POD_CD, " ).append("\n"); 
		query.append("                            T2.DMDT_TRF_CD, " ).append("\n"); 
		query.append("            	            T2.BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("            	            SUM ( T2.ORG_CHG_AMT ) ORG_CHG_AMT, " ).append("\n"); 
		query.append("                            SUM ( NVL(T2.CMDT_EXPT_AMT, 0) ) CMDT_EXPT_AMT, " ).append("\n"); 
		query.append("                            SUM ( T2.SC_RFA_EXPT_AMT ) SC_RFA_EXPT_AMT," ).append("\n"); 
		query.append("                            SUM ( T2.AFT_EXPT_DC_AMT ) AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("                            SUM(  T2.BIL_AMT ) BILL_AMT, " ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            ROUND(SUM( NVL(( SELECT SUM(A.INV_PAY_AMT/B.INV_XCH_RT/B.BKG_CNTR_QTY)" ).append("\n"); 
		query.append("                                      FROM DMT_INV_OTS_PAY_RCV A, DMT_INV_MN B" ).append("\n"); 
		query.append("                                      WHERE A.DMDT_INV_NO = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("                                        AND A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("                                        AND DMDT_INV_PAY_TP_CD = 'M'" ).append("\n"); 
		query.append("                                        AND B.DMDT_AR_IF_CD = 'Y' ),0) ),2) INV_PAY_AMT," ).append("\n"); 
		query.append("                            ( SELECT USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND  ACCT_XCH_RT_YRMON	=	TO_CHAR(T2.TO_MVMT_DT,'YYYYMM') " ).append("\n"); 
		query.append("                                 AND  ACCT_XCH_RT_LVL	=	'1' " ).append("\n"); 
		query.append("                                 AND  CURR_CD			=	T2.BZC_TRF_CURR_CD )  USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    FROM    BKG_BOOKING BB" ).append("\n"); 
		query.append("            				, DMT_CHG_BKG_CNTR T1 " ).append("\n"); 
		query.append("                            , DMT_CHG_CALC     T2 " ).append("\n"); 
		query.append("                    WHERE   1=1 " ).append("\n"); 
		query.append("                    AND   BB.SC_NO IN (( SELECT	SPH.SC_NO" ).append("\n"); 
		query.append("                                              FROM	PRI_SP_CTRT_PTY SCP," ).append("\n"); 
		query.append("                                                    PRI_SP_HDR SPH,  " ).append("\n"); 
		query.append("                                              		PRI_SP_MN SC                                              		 " ).append("\n"); 
		query.append("                                             WHERE	SPH.PROP_NO = SC.PROP_NO " ).append("\n"); 
		query.append("                                               AND	SCP.PROP_NO = SPH.PROP_NO " ).append("\n"); 
		query.append("                                               AND	SC.AMDT_SEQ = SCP.AMDT_SEQ " ).append("\n"); 
		query.append("                                               AND	SCP.PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 
		query.append("                                               AND	SC.AMDT_SEQ = (	SELECT /*+ NO_UNNEST */ MAX (AMDT_SEQ) " ).append("\n"); 
		query.append("                                                                      FROM PRI_SP_MN " ).append("\n"); 
		query.append("                                                                     WHERE PROP_NO = SPH.PROP_NO " ).append("\n"); 
		query.append("                                                                       AND ROWNUM <= 1) " ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("                                				AND SCP.CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2) " ).append("\n"); 
		query.append("                                               	AND SCP.CUST_SEQ	= SUBSTR(@[cust_cd], 3) ))" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                    AND     BB.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                    AND     T2.TO_MVMT_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("            			                  AND     TO_DATE(@[to_dt], 'YYYY-MM-DD') + .99999 " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("                    AND T2.DMDT_CHG_STS_CD	IN ('F', 'C', 'I', 'N') " ).append("\n"); 
		query.append("                    AND T2.SYS_AREA_GRP_ID	= T1.SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("                    AND T2.CNTR_NO			= T1.CNTR_NO " ).append("\n"); 
		query.append("                    AND T2.CNTR_CYC_NO		= T1.CNTR_CYC_NO " ).append("\n"); 
		query.append("                    AND	T2.DMDT_CHG_LOC_DIV_CD <> 'SZP'				        AND	            ( " ).append("\n"); 
		query.append("                        (T2.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(T2.DMDT_TRF_CD, 1, 1) = 'C') " ).append("\n"); 
		query.append("                        OR " ).append("\n"); 
		query.append("                        (T2.DUL_TP_EXPT_FLG = 'N') " ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                    AND T2.ORG_CHG_AMT > 0" ).append("\n"); 
		query.append("            GROUP BY " ).append("\n"); 
		query.append("                            SUBSTR(BB.POL_CD,1,2)        , " ).append("\n"); 
		query.append("                            SUBSTR(BB.POD_CD,1,2)        , " ).append("\n"); 
		query.append("                            T2.DMDT_TRF_CD ," ).append("\n"); 
		query.append("                            T2.TO_MVMT_DT," ).append("\n"); 
		query.append("							T2.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("            GROUP BY CUST_CD," ).append("\n"); 
		query.append("                   POL_CD, POD_CD, DMDT_TRF_CD ) A, " ).append("\n"); 
		query.append("          ( SELECT @[cust_cd] CUST_CD, " ).append("\n"); 
		query.append("                   ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2) AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))) CUST_NM" ).append("\n"); 
		query.append("                   FROM DUAL ) B" ).append("\n"); 
		query.append("    WHERE B.CUST_CD = A.CUST_CD(+)" ).append("\n"); 
		query.append("    ORDER BY DMDT_TRF_CD,POL_CD,POD_CD" ).append("\n"); 

	}
}