/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproItmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.26 
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

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproItmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproItm
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproItmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproItmCSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_AFT_BKG_APRO_ITM A" ).append("\n"); 
		query.append("  USING (" ).append("\n"); 
		query.append("            SELECT @[aft_expt_dar_no] AS DAR_NO, A.ATTR_CTNT1 ITM_LVL, A.ATTR_CTNT2 ITM_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , CASE ATTR_CTNT1 WHEN '1' THEN TO_CHAR(SUM_CM)" ).append("\n"); 
		query.append("                                             WHEN '2' THEN TO_CHAR(ROUND(TTL_BIL_AFT_DC_AMT,2))" ).append("\n"); 
		query.append("                                             WHEN '3' THEN TO_CHAR(ROUND((EXPT_DC_AMT+SC_RFA_EXPT_AMT),2))" ).append("\n"); 
		query.append("                                             WHEN '4' THEN ' '" ).append("\n"); 
		query.append("                                             WHEN '5' THEN TO_CHAR(L_STS_CNT)" ).append("\n"); 
		query.append("                                             WHEN '6' THEN TO_CHAR(COLL_PFMC)" ).append("\n"); 
		query.append("                                             WHEN '7' THEN TO_CHAR(WAIVE_PFMC)" ).append("\n"); 
		query.append("                                             ELSE '' " ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                   AS VALUE_1" ).append("\n"); 
		query.append("                 , CASE ATTR_CTNT1 WHEN '1' THEN TO_CHAR(ROUND(OTS_AMT,2))" ).append("\n"); 
		query.append("                                             WHEN '2' THEN TO_CHAR(TOT_COST_AMT)" ).append("\n"); 
		query.append("                                             WHEN '3' THEN TO_CHAR(ROUND(INCURR_50,2))" ).append("\n"); 
		query.append("                                             WHEN '4' THEN ' '" ).append("\n"); 
		query.append("                                             WHEN '5' THEN TO_CHAR(UCLM_CNT)" ).append("\n"); 
		query.append("                                             WHEN '6' THEN TO_CHAR(COLL_PFMC)" ).append("\n"); 
		query.append("                                             WHEN '7' THEN TO_CHAR(WAIVE_PFMC)" ).append("\n"); 
		query.append("                                             ELSE ''" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                   AS VALUE_2" ).append("\n"); 
		query.append("                  , CASE ATTR_CTNT1 WHEN '1' THEN " ).append("\n"); 
		query.append("                            CASE WHEN ROUND(SUM_CM,0) > ROUND(ROUND(OTS_AMT,2) * 0.3,0) THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(SUM_CM,0) = ROUND(ROUND(OTS_AMT,2) * 0.3,0) THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2' END" ).append("\n"); 
		query.append("                       WHEN '2' THEN" ).append("\n"); 
		query.append("                            CASE WHEN ROUND(TTL_BIL_AFT_DC_AMT,0) > ROUND(TOT_COST_AMT,0) THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(TTL_BIL_AFT_DC_AMT,0) = ROUND(TOT_COST_AMT,0) THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2' END" ).append("\n"); 
		query.append("                       WHEN '3' THEN" ).append("\n"); 
		query.append("                            CASE WHEN ROUND((EXPT_DC_AMT+SC_RFA_EXPT_AMT),2) <= ROUND(INCURR_50,2) THEN '0'" ).append("\n"); 
		query.append("                                 ELSE '2' END" ).append("\n"); 
		query.append("                       WHEN '4' THEN ' '" ).append("\n"); 
		query.append("                       WHEN '5' THEN " ).append("\n"); 
		query.append("                            CASE WHEN NVL(L_STS_CNT,0) = 0 AND NVL(UCLM_CNT,0) = 0 THEN '0'" ).append("\n"); 
		query.append("                                 WHEN NVL(UCLM_CNT,0) > 0 THEN '2'" ).append("\n"); 
		query.append("                                 WHEN NVL(L_STS_CNT,0) > 0 THEN '1'" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       WHEN '6' THEN" ).append("\n"); 
		query.append("                            CASE WHEN ROUND(COLL_PFMC,0) > 90 THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(COLL_PFMC,0) = 90 THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2'" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("                       WHEN '7' THEN " ).append("\n"); 
		query.append("                            CASE WHEN ROUND(WAIVE_PFMC,0) < 50 THEN '0'" ).append("\n"); 
		query.append("                                 WHEN ROUND(WAIVE_PFMC,0) = 50 THEN '1'" ).append("\n"); 
		query.append("                                 ELSE '2'" ).append("\n"); 
		query.append("                                 END" ).append("\n"); 
		query.append("            END AS VALUE_3 " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("            FROM dmt_hrd_cdg_ctnt A," ).append("\n"); 
		query.append("               ( SELECT MAX(" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                            SELECT SUM(NVL(BB.BIL_AFT_DC_AMT/AA.AFT_BKG_XCH_RT,0))" ).append("\n"); 
		query.append("                            FROM DMT_AFT_BKG_CNTR BB, DMT_AFT_BKG_ADJ_RQST_DTL AA" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                            AND BB.AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                            AND AA.AFT_EXPT_DAR_NO = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                            AND AA.AFT_EXPT_ADJ_SEQ = BB.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("                           ))  AS TTL_BIL_AFT_DC_AMT,             " ).append("\n"); 
		query.append("                           MAX(NVL((SELECT SUM(AFT_BKG_ACT_COST_AMT) FROM DMT_AFT_BKG_ACT_COST_RQST WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO ),0)) TOT_COST_AMT,            " ).append("\n"); 
		query.append("                           MAX((SELECT SUM(AFT_BKG_CM_AMT) FROM DMT_AFT_BKG_ADJ_RQST_DTL WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO )) AS SUM_CM,               " ).append("\n"); 
		query.append("                           SUM((C.ORG_CHG_AMT - C.SC_RFA_EXPT_AMT)/A.AFT_BKG_XCH_RT) AS OTS_AMT,               " ).append("\n"); 
		query.append("                           MAX((SELECT ROUND(DECODE(SUM(BIL_AMT),0,0,(SUM(INV_PAY_AMT)/SUM(BIL_AMT)))*100,2) FROM DMT_AFT_BKG_PERF_RQST WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO )) AS COLL_PFMC,               " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           MAX(" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                            SELECT SUM(NVL(BB.RQST_DC_AMT/AA.AFT_BKG_XCH_RT,0))" ).append("\n"); 
		query.append("                            FROM DMT_AFT_BKG_CNTR BB, DMT_AFT_BKG_ADJ_RQST_DTL AA" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                            AND BB.AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                            AND AA.AFT_EXPT_DAR_NO = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                            AND AA.AFT_EXPT_ADJ_SEQ = BB.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("                           ))  AS EXPT_DC_AMT,               " ).append("\n"); 
		query.append("                           ROUND(SUM(C.ORG_CHG_AMT/A.AFT_BKG_XCH_RT)*0.5,2) INCURR_50,               " ).append("\n"); 
		query.append("                           SUM(DECODE(C.DMDT_CHG_STS_CD,'L',1,0)) L_STS_CNT,               " ).append("\n"); 
		query.append("                           SUM(DECODE(C.UCLM_FLG,'Y',1,0)) UCLM_CNT,   " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("                           MAX((SELECT DECODE(SUM(ORG_CHG_AMT-DMDT_EXPT_AMT),0,0,ROUND(DECODE(SUM(ORG_CHG_AMT-DMDT_EXPT_AMT),0,0,SUM(AFT_EXPT_DC_AMT)/SUM(ORG_CHG_AMT-DMDT_EXPT_AMT)*100),2)) FROM DMT_AFT_BKG_PERF_RQST WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO)) AS DC_PFMC,               " ).append("\n"); 
		query.append("                           MAX((SELECT DECODE(SUM(ORG_CHG_AMT),0,0,ROUND(SUM(DMDT_EXPT_AMT+AFT_EXPT_DC_AMT)/SUM(ORG_CHG_AMT)*100,2)) FROM DMT_AFT_BKG_PERF_RQST WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO)) AS WAIVE_PFMC       " ).append("\n"); 
		query.append("            			 " ).append("\n"); 
		query.append("						 , SUM(C.SC_RFA_EXPT_AMT/A.AFT_BKG_XCH_RT) SC_RFA_EXPT_AMT   " ).append("\n"); 
		query.append("                    FROM DMT_AFT_BKG_ADJ_RQST_DTL A, DMT_CHG_BKG_CNTR B, DMT_CHG_CALC C" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND A.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("                    AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND A.DMDT_TRF_CD = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                    AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                    AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                    AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                    ) ITME" ).append("\n"); 
		query.append("            WHERE HRD_CDG_ID = 'AFT_BKG_APRO_ITME'" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("  ON (      A.AFT_EXPT_DAR_NO  =   B.DAR_NO " ).append("\n"); 
		query.append("     AND    A.AFT_BKG_ITM_LVL  =   B.ITM_LVL" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("      SET A.AFT_BKG_ITM_NM      =   B.ITM_NM" ).append("\n"); 
		query.append("        , A.AFT_BKG_ITM_CTNT1   =   B.VALUE_1" ).append("\n"); 
		query.append("        , A.AFT_BKG_ITM_CTNT2   =   B.VALUE_2" ).append("\n"); 
		query.append("        , A.AFT_BKG_ITM_CTNT3   =   B.VALUE_3" ).append("\n"); 
		query.append("        , A.UPD_USR_ID          =   @[upd_usr_id]" ).append("\n"); 
		query.append("        , A.UPD_DT              =   SYSDATE" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("          , AFT_BKG_ITM_LVL" ).append("\n"); 
		query.append("          , AFT_BKG_ITM_NM" ).append("\n"); 
		query.append("          , AFT_BKG_ITM_CTNT1" ).append("\n"); 
		query.append("          , AFT_BKG_ITM_CTNT2" ).append("\n"); 
		query.append("          , AFT_BKG_ITM_CTNT3" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT )" ).append("\n"); 
		query.append("    VALUES (B.DAR_NO" ).append("\n"); 
		query.append("          , B.ITM_LVL" ).append("\n"); 
		query.append("          , B.ITM_NM" ).append("\n"); 
		query.append("          , B.VALUE_1" ).append("\n"); 
		query.append("          , B.VALUE_2" ).append("\n"); 
		query.append("		  , B.VALUE_3" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , sysdate" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , sysdate" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}