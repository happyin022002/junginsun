/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOAddCHSCpsAuditInvoiceDetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOAddCHSCpsAuditInvoiceDetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.06.26 조경완 [CHM-201324911-01] ALPS-CHSS-COPS 기능 Trouble Shooting을 위한 CSR
	  * 2013-12-31 한종희 선처리 CSR : Audit Result 추가
	  * 2014-01-06 한종희 선처리 CSR : Audit 기준월 변경 요청
	  * 2014-07-02 CHM-201430891, SQL 수정 (김기철-설계, 신용찬-코딩)
	  * 2015-03-24 CHM-201534566, SC EXCEPTION 로직 교체(PRICING 에서 생성된 SC EXCEPTION 반영)(김기철-설계, 신용찬-코딩)
	  * 2015-05-06 오류 로직 변경, 신용찬
	  *                  1. 전월에 걸쳐도 오는 데이터도 오류 없음으로 인정
	  *                  2. PDM, ID - OC 로 넘어오면, DESCREPENCY 
	  *                     예외 ) OUT BOUND BKG이 DOOR TERM            --> COINCEDENCE  
	  *                              OUT BOUND BKG이 CY TERM, EXCEPTION=Y --> COINCEDENCE
	  * 2016-02-19 Invoice Double Charge 오류 발생시, 기 입력된 Invoice No와 Cost Month 표시
	  * 2016-03-28 Freetime Logic 추가
	  *                  CGM_COPS_MVMT_FND_FNC 에서 0(SC Exception), 1 넘어오는데이터를 0일때 Freedays*10 항목으로 넘김
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOAddCHSCpsAuditInvoiceDetailDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOAddCHSCpsAuditInvoiceDetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       , AGMT_SEQ" ).append("\n"); 
		query.append("       , AGMT_VER_NO" ).append("\n"); 
		query.append("       , COST_YRMON" ).append("\n"); 
		query.append("       , CHG_SEQ" ).append("\n"); 
		query.append("       , EQ_KND_CD" ).append("\n"); 
		query.append("       , EQ_NO" ).append("\n"); 
		query.append("       , INV_EQ_NO" ).append("\n"); 
		query.append("       , INV_CUST_EQ_NO" ).append("\n"); 
		query.append("       , CHG_CD" ).append("\n"); 
		query.append("       , INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("       , INV_EQ_ONH_DT" ).append("\n"); 
		query.append("       , INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("       , INV_BIL_ST_DT" ).append("\n"); 
		query.append("       , INV_BIL_END_DT" ).append("\n"); 
		query.append("       , INV_LSE_USE_DYS" ).append("\n"); 
		query.append("       , INV_BIL_UT_DYS" ).append("\n"); 
		query.append("       , INV_LSE_RT_AMT" ).append("\n"); 
		query.append("       , INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("       , INV_TAX_RT_AMT" ).append("\n"); 
		query.append("       , INV_TAX_AMT" ).append("\n"); 
		query.append("       , INV_LSE_CHG_TTL_AMT" ).append("\n"); 
		query.append("       , PAY_LSE_USE_DYS" ).append("\n"); 
		query.append("       , PAY_BIL_UT_DYS" ).append("\n"); 
		query.append("       , PAY_LSE_RT_AMT" ).append("\n"); 
		query.append("       , PAY_LSE_CHG_AMT" ).append("\n"); 
		query.append("       , PAY_TAX_RT_AMT" ).append("\n"); 
		query.append("       , PAY_TAX_AMT" ).append("\n"); 
		query.append("       , PAY_LSE_CHG_TTL_AMT" ).append("\n"); 
		query.append("       , EQ_BIL_ST_DT" ).append("\n"); 
		query.append("       , EQ_BIL_END_DT" ).append("\n"); 
		query.append("       , LSE_CHG_AUD_STS_CD" ).append("\n"); 
		query.append("       , PAY_LSE_CHG_STS_CD" ).append("\n"); 
		query.append("       , LSE_CHG_AUD_RSLT_RSN_CD" ).append("\n"); 
		query.append("       , PAY_CHG_AUD_RMK" ).append("\n"); 
		query.append("       , INV_BKG_NO" ).append("\n"); 
		query.append("       , INV_SC_NO" ).append("\n"); 
		query.append("       , INV_NO" ).append("\n"); 
		query.append("       , INV_REF_NO" ).append("\n"); 
		query.append("       , EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , EQ_FM_MVMT_CD" ).append("\n"); 
		query.append("       , EQ_FM_YD_CD" ).append("\n"); 
		query.append("       , EQ_FM_MVMT_DT" ).append("\n"); 
		query.append("       , EQ_TO_MVMT_CD" ).append("\n"); 
		query.append("       , EQ_TO_YD_CD" ).append("\n"); 
		query.append("       , EQ_TO_MVMT_DT" ).append("\n"); 
		query.append("       , LSE_BIL_UT_DYS" ).append("\n"); 
		query.append("       , LSE_USE_DYS" ).append("\n"); 
		query.append("       , LSE_TAX_RT_AMT" ).append("\n"); 
		query.append("       , LSE_RT_AMT" ).append("\n"); 
		query.append("       , LSE_CHG_AMT" ).append("\n"); 
		query.append("       , LSE_TAX_AMT" ).append("\n"); 
		query.append("       , LSE_CHG_TTL_AMT" ).append("\n"); 
		query.append("       , INV_BKG_TERM_CD" ).append("\n"); 
		query.append("       , INV_CUST_CNT_CD" ).append("\n"); 
		query.append("       , INV_CUST_SEQ" ).append("\n"); 
		query.append("       , ACCT_CD" ).append("\n"); 
		query.append("       , COST_CD" ).append("\n"); 
		query.append("       , INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append("       , EQ_MTY_MVMT_DT" ).append("\n"); 
		query.append("       , EQ_MTY_MVMT_YD_CD" ).append("\n"); 
		query.append("       , EQ_TO_SC_NO" ).append("\n"); 
		query.append("       , EQ_TO_BKG_NO" ).append("\n"); 
		query.append("       , EQ_TO_BKG_TERM_CD" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , INV_GATE_ACT_ID" ).append("\n"); 
		query.append("       , INV_BIL_MOD_RMK" ).append("\n"); 
		query.append("       , COST_YRMON_SEQ" ).append("\n"); 
		query.append("       , EQ_BKG_IO_BND_CD" ).append("\n"); 
		query.append("       , EQ_EXPT_FLG " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   @[agmt_ofc_cty_cd] AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       , @[agmt_seq] AGMT_SEQ" ).append("\n"); 
		query.append("       , @[agmt_ver_no] VER_NO" ).append("\n"); 
		query.append("       , @[cost_yrmon]" ).append("\n"); 
		query.append("       , ROW_NUMBER()  OVER (PARTITION BY INV_CHSS_NO ORDER BY FM_DT) SEQ" ).append("\n"); 
		query.append("       , 'Z' EQ_KND" ).append("\n"); 
		query.append("       , INV_CHSS_NO" ).append("\n"); 
		query.append("       , EQ_NO" ).append("\n"); 
		query.append("       , INV_CNTR_NO" ).append("\n"); 
		query.append("       , CHG_CD" ).append("\n"); 
		query.append("	   , INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("       , INV_EQ_ONH_DT" ).append("\n"); 
		query.append("       , INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("       , INV_BIL_ST_DT" ).append("\n"); 
		query.append("       , INV_BIL_END_DT" ).append("\n"); 
		query.append("       , INV_LSE_USE_DYS" ).append("\n"); 
		query.append("       , INV_BIL_UT_DYS" ).append("\n"); 
		query.append("       , INV_LSE_RT_AMT" ).append("\n"); 
		query.append("       , INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("       , INV_TAX_AMT" ).append("\n"); 
		query.append("       , TAX_SMRY_AMT" ).append("\n"); 
		query.append("       , INV_SMRY_AMT" ).append("\n"); 
		query.append("	   , INV_LSE_USE_DYS" ).append("\n"); 
		query.append("       , INV_BIL_UT_DYS" ).append("\n"); 
		query.append("       , INV_LSE_RT_AMT" ).append("\n"); 
		query.append("       , INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("       , INV_TAX_AMT" ).append("\n"); 
		query.append("       , TAX_SMRY_AMT" ).append("\n"); 
		query.append("       , INV_SMRY_AMT" ).append("\n"); 
		query.append("       , BILL_FM_DT" ).append("\n"); 
		query.append("       , BILL_TO_DT" ).append("\n"); 
		query.append("       , SUBSTR(ADT_RSLT,1,1) ADT_RSLT" ).append("\n"); 
		query.append("       , SUBSTR(ADT_RSLT,1,1) ADT_RSLT" ).append("\n"); 
		query.append("       , REASON_CD" ).append("\n"); 
		query.append("	   , CASE WHEN SUBSTR(ADT_RSLT,1,1) = 'I' THEN CASE WHEN CNTR_CHK 	= 1 						THEN 'Other company container movement, ' 				END||" ).append("\n"); 
		query.append("                                                   CASE WHEN CHZ_CHK 	= 1     					THEN 'Other lease term movement, ' 						END||" ).append("\n"); 
		query.append("                                                   CASE WHEN MVMT_CHK 	= 1    						THEN 'Movement is not found, ' 							END||" ).append("\n"); 
		query.append("		                                           CASE WHEN PCT_CHK 	= 1      					THEN 'PCT-STE moves involved, ' 						END||" ).append("\n"); 
		query.append("		                                           CASE WHEN DUP_CHK 	= 1     					THEN 'Invoice is a double charge '||  DUP_DESC || ', '	END||" ).append("\n"); 
		query.append("                                                   CASE WHEN SC_EXP_CHK = 1   						THEN 'Not S/C exception apply booking, ' 				END||" ).append("\n"); 
		query.append("                                                   CASE WHEN AREA_CHK 	= 1     					THEN 'Out of CPS SCC area, ' 							END||" ).append("\n"); 
		query.append("                                                   CASE WHEN TO_MVMT_CHK= 1  AND REASON_CD0 = '0' 	THEN 'To movement is out of month (Dup), ' 				END||" ).append("\n"); 
		query.append("                                                   CASE WHEN TO_MVMT_CHK= 1  AND REASON_CD0 = '4' 	THEN 'To movement is out of month (No Dup), '			END||" ).append("\n"); 
		query.append("                                                   CASE WHEN YARD_CHK 	= 1 						THEN 'Out of CPS yard code, ' 							END||" ).append("\n"); 
		query.append("                                                   CASE WHEN ONT_CHG_CHK= 1 						THEN 'Not on Terminal charge billing yard code, '		END||" ).append("\n"); 
		query.append("                                                   CASE WHEN DOM_CHK 	= 1 						THEN 'Not domestic usage billing yard code, '			END" ).append("\n"); 
		query.append("              WHEN SUBSTR(ADT_RSLT,1,1) = 'D' THEN CASE WHEN BILL_DAYS = (FT_DYS+FT_DYS_2) AND (FT_DYS+FT_DYS_2) > 0 THEN 'FreeTime(' || (FT_DYS+FT_DYS_2) || 'Days),' END||" ).append("\n"); 
		query.append("                                                   CASE WHEN MULTI_MOVE_CHK	= 1      				THEN 'Multi Move Credit, ' 						        END||" ).append("\n"); 
		query.append("                                                   CASE WHEN NO_CHG_CHK	= 1      					THEN 'STE Shuttle, WCCP account, ' 						END" ).append("\n"); 
		query.append("         END AS ERR_RMK" ).append("\n"); 
		query.append("       , CASE WHEN BKG_CGO_TP_CD = 'F' AND FM_MVMT_CD <> 'MT' THEN NVL(BKG_NO,SUBSTR(VRFY_RSLT_DESC,1,12)) ELSE '' END AS BKG_NO" ).append("\n"); 
		query.append("       , CASE WHEN BKG_CGO_TP_CD = 'F' AND FM_MVMT_CD <> 'MT' THEN DECODE(BKG_NO,NULL,RTRIM(SUBSTR(VRFY_RSLT_DESC,13,9)),SC_NO) ELSE '' END AS SC_NO" ).append("\n"); 
		query.append("       , @[inv_no]" ).append("\n"); 
		query.append("       , @[inv_ref_no]" ).append("\n"); 
		query.append("       , INV_CUST_EQ_TPSZ_NM" ).append("\n"); 
		query.append("       , FM_MVMT_CD" ).append("\n"); 
		query.append("       , FM_YD" ).append("\n"); 
		query.append("       , FM_DT" ).append("\n"); 
		query.append("       , TO_MVMT_CD" ).append("\n"); 
		query.append("       , TO_YD" ).append("\n"); 
		query.append("       , TO_DT" ).append("\n"); 
		query.append("       , DECODE(FM_DT, NULL, '',BILL_DAYS) BILL_DAYS" ).append("\n"); 
		query.append("       , DECODE(FM_DT, NULL, '',USED_DAYS) USED_DAYS" ).append("\n"); 
		query.append("       , CHSS_POOL_TAX_RT" ).append("\n"); 
		query.append("       , CHSS_POOL_RT_AMT" ).append("\n"); 
		query.append("       , BILL_RATE_AMT" ).append("\n"); 
		query.append("       , BILL_TAX_AMT" ).append("\n"); 
		query.append("       , BILL_RATE_AMT + BILL_TAX_AMT" ).append("\n"); 
		query.append("       , CASE WHEN BKG_CGO_TP_CD = 'F' AND FM_MVMT_CD <> 'MT' THEN INV_BKG_TERM_CD ELSE '' END AS INV_BKG_TERM_CD" ).append("\n"); 
		query.append("       , CASE WHEN BKG_CGO_TP_CD = 'F' AND FM_MVMT_CD <> 'MT' THEN DECODE(BKG_NO,NULL,RTRIM(SUBSTR(VRFY_RSLT_DESC,22,2)),INV_CUST_CNT_CD) ELSE '' END AS INV_CUST_CNT_CD" ).append("\n"); 
		query.append("       , CASE WHEN BKG_CGO_TP_CD = 'F' AND FM_MVMT_CD <> 'MT' THEN DECODE(BKG_NO,NULL,RTRIM(SUBSTR(VRFY_RSLT_DESC,25,6)),INV_CUST_SEQ) ELSE '' END AS INV_CUST_SEQ" ).append("\n"); 
		query.append("       , '510851' AS ACCT_CD" ).append("\n"); 
		query.append("       , 'EQCZNP' AS COST_CD" ).append("\n"); 
		query.append("       , INV_BKG_NO" ).append("\n"); 
		query.append("       , MT_DT" ).append("\n"); 
		query.append("       , MT_YD" ).append("\n"); 
		query.append("       , TO_SC_NO" ).append("\n"); 
		query.append("       , TO_BKG_NO" ).append("\n"); 
		query.append("       , TO_BKG_TERM" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[upd_usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , INV_GATE_ACT_ID" ).append("\n"); 
		query.append("       , INV_BIL_MOD_RMK" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   COST_YRMON_SEQ" ).append("\n"); 
		query.append("           FROM     CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND      AGMT_SEQ 	    = @[agmt_seq]" ).append("\n"); 
		query.append("           AND      COST_YRMON 	    = @[cost_yrmon]" ).append("\n"); 
		query.append("           AND      CHG_CRE_SEQ 	= @[chg_cre_seq]" ).append("\n"); 
		query.append("         ) AS COST_YRMON_SEQ" ).append("\n"); 
		query.append("       , CASE WHEN BKG_CGO_TP_CD = 'F' AND FM_MVMT_CD <> 'MT' THEN SUBSTR(FM_ID,35,1) ELSE '' END AS EQ_BKG_IO_BND_CD" ).append("\n"); 
		query.append("       , CASE WHEN  FM_MVMT_CD IN ('OP','ID') AND SUBSTR(FM_ID,15,1) <> 'D' THEN DECODE(SC_EXP_CHK,0,'Y','N') ELSE 'N' END AS EQ_EXPT_FLG" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   A.INV_CHSS_NO" ).append("\n"); 
		query.append("		          , A.INV_CNTR_NO" ).append("\n"); 
		query.append("                  , A.CHG_CD" ).append("\n"); 
		query.append("                  , A.INV_EQ_ONH_DT" ).append("\n"); 
		query.append("                  , A.INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("                  , A.INV_BIL_ST_DT" ).append("\n"); 
		query.append("                  , A.INV_BIL_END_DT" ).append("\n"); 
		query.append("                  , A.INV_LSE_USE_DYS" ).append("\n"); 
		query.append("                  , A.INV_BIL_UT_DYS" ).append("\n"); 
		query.append("                  , A.INV_LSE_RT_AMT" ).append("\n"); 
		query.append("                  , A.INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("                  , A.INV_TAX_AMT" ).append("\n"); 
		query.append("                  , A.INV_NO" ).append("\n"); 
		query.append("                  , A.INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("                  , A.INV_CUST_EQ_TPSZ_NM" ).append("\n"); 
		query.append("                  , A.TAX_SMRY_AMT" ).append("\n"); 
		query.append("                  , A.INV_SMRY_AMT" ).append("\n"); 
		query.append("                  , A.VRFY_RSLT_DESC" ).append("\n"); 
		query.append("                  , A.INV_BKG_NO" ).append("\n"); 
		query.append("                  , A.FM_ID" ).append("\n"); 
		query.append("                  , A.INV_GATE_ACT_ID" ).append("\n"); 
		query.append("                  , A.INV_BIL_MOD_RMK" ).append("\n"); 
		query.append("                  , A.EQ_NO" ).append("\n"); 
		query.append("                  , A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                  , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , A.FM_CHSS_NO" ).append("\n"); 
		query.append("                  , A.FM_MVMT_CD" ).append("\n"); 
		query.append("                  , A.FM_YD" ).append("\n"); 
		query.append("                  , A.FM_DT" ).append("\n"); 
		query.append("                  , A.BKG_NO" ).append("\n"); 
		query.append("                  , A.FM_SCC_CD" ).append("\n"); 
		query.append("                  , A.TERM_CD" ).append("\n"); 
		query.append("                  , A.SC_NO" ).append("\n"); 
		query.append("                  , A.OB_CNTR_FLG" ).append("\n"); 
		query.append("                  , A.FCNTR_FLG" ).append("\n"); 
		query.append("                  , A.CNTR_CHK" ).append("\n"); 
		query.append("                  , A.CHZ_CHK" ).append("\n"); 
		query.append("                  , A.MVMT_CHK" ).append("\n"); 
		query.append("                  , A.AREA_CHK" ).append("\n"); 
		query.append("                  , A.YARD_CHK" ).append("\n"); 
		query.append("                  , A.ONT_CHG_CHK" ).append("\n"); 
		query.append("                  , A.DOM_CHK" ).append("\n"); 
		query.append("                  , A.SC_EXP_CHK" ).append("\n"); 
		query.append("                  , A.FT_DYS" ).append("\n"); 
		query.append("                  , A.DUP_CHK" ).append("\n"); 
		query.append("                  , A.TO_ID" ).append("\n"); 
		query.append("                  , A.FM_INF1" ).append("\n"); 
		query.append("                  , A.DDCT_TP_CD" ).append("\n"); 
		query.append("                  , A.CHSS_POOL_RT_AMT" ).append("\n"); 
		query.append("                  , A.CHSS_POOL_TAX_RT" ).append("\n"); 
		query.append("                  , A.AMT_AUD_FLG" ).append("\n"); 
		query.append("                  , A.DMST_ON_TML_CHG_FLG" ).append("\n"); 
		query.append("                  , A.DMST_PD_CHG_FLG" ).append("\n"); 
		query.append("                  , A.ON_TML_CHG_FLG" ).append("\n"); 
		query.append("                  , A.TO_CHSS_NO" ).append("\n"); 
		query.append("                  , A.TO_MVMT_CD" ).append("\n"); 
		query.append("                  , A.TO_YD" ).append("\n"); 
		query.append("                  , A.TO_DT" ).append("\n"); 
		query.append("                  , A.TO_MVMT_CHK" ).append("\n"); 
		query.append("                  , A.TO_MVMT_CHK2" ).append("\n"); 
		query.append("                  , A.ERR_CHK0" ).append("\n"); 
		query.append("                  , A.PCT_CHK" ).append("\n"); 
		query.append("                  , A.MULTI_MOVE_CHK" ).append("\n"); 
		query.append("                  , A.NO_CHG_CHK" ).append("\n"); 
		query.append("                  , A.BILL_FM_DT" ).append("\n"); 
		query.append("                  , A.BILL_TO_DT" ).append("\n"); 
		query.append("                  , A.MT_DT" ).append("\n"); 
		query.append("                  , A.MT_YD" ).append("\n"); 
		query.append("                  , A.TO_SC_NO" ).append("\n"); 
		query.append("                  , A.TO_BKG_NO" ).append("\n"); 
		query.append("                  , A.TO_BKG_TERM" ).append("\n"); 
		query.append("                  , A.DUP_DESC" ).append("\n"); 
		query.append("                  , A.DEDUCT_DAYS1" ).append("\n"); 
		query.append("                  , A.DEDUCT_DAYS2" ).append("\n"); 
		query.append("                  , A.DEDUCT_DAY3" ).append("\n"); 
		query.append("                  , A.USED_DAYS" ).append("\n"); 
		query.append("                  , A.REASON_CD0" ).append("\n"); 
		query.append("                  , A.TO_MVMT_CHK3" ).append("\n"); 
		query.append("                  , A.FM_ID_2" ).append("\n"); 
		query.append("                  , A.BILL_DAYS" ).append("\n"); 
		query.append("                  , A.BILL_RATE_AMT" ).append("\n"); 
		query.append("                  , A.BILL_TAX_AMT" ).append("\n"); 
		query.append("                  , CASE WHEN A.SC_EXP_CHK_2 > 9 THEN 0 ELSE A.SC_EXP_CHK_2 END AS SC_EXP_CHK_2" ).append("\n"); 
		query.append("                  , CASE WHEN A.SC_EXP_CHK_2 > 9 THEN SC_EXP_CHK_2 / 10 ELSE 0 END AS FT_DYS_2 -- CGM_SC_EXP_CHK_FNC 에서 가져올때 FT_DYS에 10곱해서 가져옴" ).append("\n"); 
		query.append("                  , CASE WHEN A.ERR_CHK0 + A.PCT_CHK + A.TO_MVMT_CHK3 > 0 THEN 'Invoice Only'" ).append("\n"); 
		query.append("                         WHEN A.NO_CHG_CHK > 0 THEN 'Discrepancy'" ).append("\n"); 
		query.append("                         WHEN A.MULTI_MOVE_CHK > 0 THEN 'Discrepancy'" ).append("\n"); 
		query.append("                         WHEN A.CHG_CD = 'PDM' AND A.FM_MVMT_CD = 'ID' AND A.TO_MVMT_CD = 'OC' THEN " ).append("\n"); 
		query.append("                              CASE WHEN (A.TO_BKG_NO IS NOT NULL AND A.TO_BKG_TERM ='D') OR (A.TO_BKG_NO IS NOT NULL AND A.TO_BKG_TERM ='Y' AND DECODE(A.SC_EXP_CHK_2, 0, 0, 1, 1, 0) = 0) THEN" ).append("\n"); 
		query.append("                                        CASE WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT = 0   THEN 'Coincidency'" ).append("\n"); 
		query.append("                                             WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS = 0 THEN 'Coincidency'" ).append("\n"); 
		query.append("                                             WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS  <= A.BILL_DAYS-(A.FT_DYS+DECODE(A.SC_EXP_CHK_2, 0, 0, 1, 0, (A.SC_EXP_CHK_2/10)))           THEN 'Coincidency'" ).append("\n"); 
		query.append("                                             WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS > A.BILL_DAYS-(A.FT_DYS+DECODE(A.SC_EXP_CHK_2, 0, 0, 1, 0, (A.SC_EXP_CHK_2/10)))             THEN 'Discrepancy'" ).append("\n"); 
		query.append("                                             WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT <=  A.BILL_RATE_AMT + BILL_TAX_AMT  THEN 'Coincidency'" ).append("\n"); 
		query.append("                                             ELSE 'Discrepancy'" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE 'Discrepancy'" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                         ELSE" ).append("\n"); 
		query.append("                              CASE WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT = 0   THEN 'Coincidency'" ).append("\n"); 
		query.append("                                   WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS = 0 THEN 'Coincidency'" ).append("\n"); 
		query.append("                                   WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS  <= A.BILL_DAYS THEN 'Coincidency'" ).append("\n"); 
		query.append("                                   WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS > A.BILL_DAYS THEN 'Discrepancy'" ).append("\n"); 
		query.append("                                   WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT <=  A.BILL_RATE_AMT + BILL_TAX_AMT  THEN 'Coincidency'" ).append("\n"); 
		query.append("                                   ELSE 'Discrepancy'" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                    END AS ADT_RSLT" ).append("\n"); 
		query.append("                  , DECODE(SIGN(A.ERR_CHK0+A.PCT_CHK+A.TO_MVMT_CHK3),1,REASON_CD0," ).append("\n"); 
		query.append("                           CASE WHEN A.CHG_CD = 'PDM' AND A.FM_MVMT_CD = 'ID' AND A.TO_MVMT_CD = 'OC' THEN " ).append("\n"); 
		query.append("                                     CASE WHEN (A.TO_BKG_NO IS NOT NULL AND A.TO_BKG_TERM ='D') OR (A.TO_BKG_NO IS NOT NULL AND A.TO_BKG_TERM ='Y' AND (A.SC_EXP_CHK_2 = 0 OR A.SC_EXP_CHK_2 > 9)) THEN -- FREE TIME인 경우 10이상으로 입력됨" ).append("\n"); 
		query.append("                                               CASE WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS  = A.BILL_DAYS THEN 'A'" ).append("\n"); 
		query.append("                                                    WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS <  A.BILL_DAYS THEN 'B'" ).append("\n"); 
		query.append("                                                    WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS >  A.BILL_DAYS THEN 'S'" ).append("\n"); 
		query.append("                                                    WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT =  A.BILL_RATE_AMT + A.BILL_TAX_AMT  THEN 'A'" ).append("\n"); 
		query.append("                                                    WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT <  A.BILL_RATE_AMT + A.BILL_TAX_AMT  THEN 'B'" ).append("\n"); 
		query.append("                                                    WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT >  A.BILL_RATE_AMT + A.BILL_TAX_AMT  AND A.INV_BIL_UT_DYS <>  A.BILL_DAYS THEN 'S'" ).append("\n"); 
		query.append("                                                    WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT >  A.BILL_RATE_AMT + A.BILL_TAX_AMT  AND A.INV_LSE_CHG_AMT <>  A.BILL_RATE_AMT THEN 'T'" ).append("\n"); 
		query.append("                                                    WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT >  A.BILL_RATE_AMT + A.BILL_TAX_AMT  AND A.TAX_SMRY_AMT <>  A.BILL_TAX_AMT THEN 'U'" ).append("\n"); 
		query.append("                                                    ELSE 'V'" ).append("\n"); 
		query.append("                                               END" ).append("\n"); 
		query.append("                                          ELSE 'H' -- disperency" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                                ELSE " ).append("\n"); 
		query.append("                                     CASE WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS  = A.BILL_DAYS  THEN 'A'" ).append("\n"); 
		query.append("                                          WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS <  A.BILL_DAYS  THEN 'B'" ).append("\n"); 
		query.append("                                          WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS >  A.BILL_DAYS  THEN 'S'" ).append("\n"); 
		query.append("                                          WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT =  A.BILL_RATE_AMT + A.BILL_TAX_AMT  THEN 'A'" ).append("\n"); 
		query.append("                                          WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT <  A.BILL_RATE_AMT + A.BILL_TAX_AMT  THEN 'B'" ).append("\n"); 
		query.append("                                          WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT >  A.BILL_RATE_AMT + A.BILL_TAX_AMT  AND A.INV_BIL_UT_DYS <>  A.BILL_DAYS THEN 'S'" ).append("\n"); 
		query.append("                                          WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT >  A.BILL_RATE_AMT + A.BILL_TAX_AMT  AND A.INV_LSE_CHG_AMT <>  A.BILL_RATE_AMT THEN 'T'" ).append("\n"); 
		query.append("                                          WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT >  A.BILL_RATE_AMT + A.BILL_TAX_AMT  AND A.TAX_SMRY_AMT <>  A.BILL_TAX_AMT THEN 'U'" ).append("\n"); 
		query.append("                                          ELSE 'V'" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                    ) AS REASON_CD" ).append("\n"); 
		query.append("                  , A.INV_BIL_UT_DYS - A.BILL_DAYS AS DIFF_DAYS" ).append("\n"); 
		query.append("                  , SUBSTR(FM_ID, 15,1) AS INV_BKG_TERM_CD" ).append("\n"); 
		query.append("                  , LTRIM(SUBSTR(FM_ID, 21, 2)) AS INV_CUST_CNT_CD" ).append("\n"); 
		query.append("                  , SUBSTR(FM_ID, 23, 6) AS INV_CUST_SEQ" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   A.*" ).append("\n"); 
		query.append("                             , CASE WHEN A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3)  <= 0 THEN 0 " ).append("\n"); 
		query.append("                                    WHEN A.FT_DYS > 0 AND A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) - A.FT_DYS > 0 THEN A.FT_DYS" ).append("\n"); 
		query.append("                                    ELSE A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) " ).append("\n"); 
		query.append("                               END AS BILL_DAYS" ).append("\n"); 
		query.append("			                 , A.CHSS_POOL_RT_AMT * (" ).append("\n"); 
		query.append("                                    CASE WHEN A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) <= 0 THEN 0 " ).append("\n"); 
		query.append("                                         WHEN A.FT_DYS > 0 AND A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) - A.FT_DYS > 0 THEN A.FT_DYS" ).append("\n"); 
		query.append("                                         ELSE A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) " ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("                               ) AS BILL_RATE_AMT" ).append("\n"); 
		query.append("			                 , ROUND(A.CHSS_POOL_RT_AMT * (" ).append("\n"); 
		query.append("                                    CASE WHEN A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) <= 0 THEN 0 " ).append("\n"); 
		query.append("                                         WHEN A.FT_DYS > 0 AND A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) - A.FT_DYS > 0 THEN A.FT_DYS" ).append("\n"); 
		query.append("                                         ELSE A.USED_DAYS+A.DEDUCT_DAYS1+A.DEDUCT_DAYS2+DECODE(SIGN(A.DEDUCT_DAYS1+A.DEDUCT_DAYS2),-1,0,A.DEDUCT_DAY3) " ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("                               ) * A.CHSS_POOL_TAX_RT/100,2) AS BILL_TAX_AMT" ).append("\n"); 
		query.append("			                 , CASE WHEN A.TO_BKG_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("                                         CASE WHEN  (A.CHG_CD = 'ONT') OR (SUBSTR(A.FM_ID_2,15,1) = 'D') OR (SUBSTR(A.FM_ID_2,16,1) = 0) THEN 0 -- ON TERMINAL, DOOR TERM, ( 다음조건 모두 만족 : OP/ID, REETER TYPE, REEFER DRY CARGO='N'(진짜냉동), DELIVERY=USOAK, OUT BOUND 아닐때) " ).append("\n"); 
		query.append("                                              WHEN  B.MVMT_STS_CD IN('OP','ID') AND SUBSTR(A.FM_ID_2,15,1) <> 'D' AND SUBSTR(A.FM_ID_2,34,1) = 0 THEN 0 -- SC=AEN110235, DOOR 아니고 POD 가 지정된 곳이며, OB_CNTR_FLG=N 이면 EXCEPTION, 0 리턴   ('CAPRR','CAVAN','USSEA','USTIW','USPDX','USOAK','USLAX','USLGB')                                                                                                " ).append("\n"); 
		query.append("                                              WHEN  B.MVMT_STS_CD IN('OP','ID') AND SUBSTR(A.FM_ID_2,15,1) <> 'D' AND SUBSTR(A.FM_ID_2,34,1) = 1 THEN 1 -- SC=AEN110235, DOOR 아니고 POD 가 지정된 곳 아니고, DEL_CD 가 지정된 곳이고, OB_CNTR_FLG=N 이면 EXCEPTION, 1 리턴                                                         " ).append("\n"); 
		query.append("                                              WHEN  B.MVMT_STS_CD IN('OP','ID') AND SUBSTR(A.FM_ID_2,15,1) <> 'D' THEN DECODE(LTRIM(SUBSTR(A.FM_ID_2, 6, 9)), NULL, 1,CGM_SC_EXP_CHK_FNC(A.INV_CNTR_NO,B.CNMV_CYC_NO,B.CNMV_EVNT_DT,B.MVMT_STS_CD,RTRIM(SUBSTR(A.FM_ID_2,6,9)),SUBSTR(A.FM_ID_2,29,5),B.CNTR_TPSZ_CD,A.TO_BKG_NO, 'Y'))  -- OP, ID 이고 DOOR TERM 아닐때 " ).append("\n"); 
		query.append("                                              ELSE 0" ).append("\n"); 
		query.append("                                         END    " ).append("\n"); 
		query.append("                                    ELSE 0          " ).append("\n"); 
		query.append("                               END AS SC_EXP_CHK_2" ).append("\n"); 
		query.append("                      FROM     (" ).append("\n"); 
		query.append("                                 SELECT   A.*" ).append("\n"); 
		query.append("                                        , CASE WHEN A.DDCT_TP_CD ='1' THEN --on tml 차감" ).append("\n"); 
		query.append("                                                                           DECODE(A.CHG_CD,'ONT',DECODE(LEAD(A.BILL_FM_DT,1) OVER(PARTITION BY A.INV_CHSS_NO,SIGN(A.ERR_CHK0+A.PCT_CHK) ORDER BY A.FM_DT),A.BILL_TO_DT,-1,0),0)" ).append("\n"); 
		query.append("                                               WHEN A.DDCT_TP_CD ='2' THEN 0 -- no deduct" ).append("\n"); 
		query.append("                                          END AS DEDUCT_DAYS1" ).append("\n"); 
		query.append("                                        , CASE WHEN A.DDCT_TP_CD ='1' THEN --on tml 차감" ).append("\n"); 
		query.append("                                                                           DECODE(A.CHG_CD,'ONT',DECODE(LAG(A.BILL_TO_DT,1) OVER(PARTITION BY A.INV_CHSS_NO,SIGN(A.ERR_CHK0+A.PCT_CHK) ORDER BY A.FM_DT),A.BILL_FM_DT,-1,0),0)" ).append("\n"); 
		query.append("                                               WHEN A.DDCT_TP_CD ='2' THEN 0 -- no deduct" ).append("\n"); 
		query.append("                                          END AS DEDUCT_DAYS2" ).append("\n"); 
		query.append("				                        , CASE WHEN A.TERM_CD = 'Y' AND A.FM_MVMT_CD = 'IC' AND A.TO_MVMT_CD = 'ID' AND A.ON_TML_CHG_FLG = 'Y' THEN -1" ).append("\n"); 
		query.append("                                               WHEN A.TERM_CD = 'Y' AND A.ON_TML_CHG_FLG = 'Y' AND A.FM_MVMT_CD = 'OC' AND " ).append("\n"); 
		query.append("                                                    (" ).append("\n"); 
		query.append("                                                      SELECT   /*+ INDEX_DESC (P XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                                                               P.MVMT_STS_CD" ).append("\n"); 
		query.append("                                                      FROM     CTM_MOVEMENT P" ).append("\n"); 
		query.append("                                                      WHERE    1 = 1" ).append("\n"); 
		query.append("                                                      AND      P.CNTR_NO = A.INV_CNTR_NO" ).append("\n"); 
		query.append("                                                      AND      P.CNMV_YR||TO_CHAR(P.CNMV_SEQ,'0000')||P.CNMV_SPLIT_NO < A.FM_INF1" ).append("\n"); 
		query.append("                                                      AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                                    ) IN ('OP','ID')" ).append("\n"); 
		query.append("                                                    THEN -1 " ).append("\n"); 
		query.append("                                               ELSE 0 " ).append("\n"); 
		query.append("                                          END  DEDUCT_DAY3" ).append("\n"); 
		query.append("				                        , A.BILL_TO_DT - A.BILL_FM_DT + 1 AS USED_DAYS" ).append("\n"); 
		query.append("				                        , CASE WHEN A.AMT_AUD_FLG ='Y' AND A.INV_SMRY_AMT = 0  THEN  'W'" ).append("\n"); 
		query.append("                                               WHEN A.AMT_AUD_FLG ='N' AND A.INV_BIL_UT_DYS = 0 THEN 'W'" ).append("\n"); 
		query.append("                                               WHEN A.DUP_CHK = 1     THEN 'Y'" ).append("\n"); 
		query.append("                                               WHEN A.CNTR_CHK = 1    THEN '1'" ).append("\n"); 
		query.append("                                               WHEN A.CHZ_CHK = 1     THEN '2'  " ).append("\n"); 
		query.append("                                               WHEN A.MVMT_CHK = 1    THEN '3'" ).append("\n"); 
		query.append("                                               WHEN A.PCT_CHK = 1     THEN 'X'" ).append("\n"); 
		query.append("                                               WHEN A.SC_EXP_CHK = 1  THEN '9'" ).append("\n"); 
		query.append("                                               WHEN A.AREA_CHK = 1    THEN '5'" ).append("\n"); 
		query.append("                                               WHEN A.TO_MVMT_CHK = 1 AND  TO_MVMT_CHK2 = 1 THEN '0'     -- OUT OF MONTH 이고 중복이면 To movement is out of month (Dup) 처리                   " ).append("\n"); 
		query.append("                                               WHEN A.TO_MVMT_CHK = 1 AND  TO_MVMT_CHK2 = 0 AND (INV_EQ_ONH_DT <> INV_BIL_ST_DT OR INV_BIL_ST_DT <> BILL_FM_DT OR INV_EQ_OFFH_DT <> INV_BIL_END_DT OR INV_BIL_END_DT <> BILL_TO_DT)  THEN '4'    -- OUT OF MONTH 이고 중복 아닌데 조건 만족 못하면 To movement is out of month (No Dup) 처리                     " ).append("\n"); 
		query.append("                                               WHEN A.YARD_CHK = 1    THEN '6'" ).append("\n"); 
		query.append("                                               WHEN A.ONT_CHG_CHK = 1 THEN '7'" ).append("\n"); 
		query.append("                                               WHEN A.DOM_CHK = 1     THEN '8'" ).append("\n"); 
		query.append("                                               WHEN A.FT_DYS > 0      THEN 'Z'                           -- FREETIME LOGIC 추가로 데이터 추가" ).append("\n"); 
		query.append("                                          END REASON_CD0" ).append("\n"); 
		query.append("                                        , CASE WHEN A.TO_MVMT_CHK = 1 AND  TO_MVMT_CHK2 = 1 THEN 1" ).append("\n"); 
		query.append("                                               WHEN A.TO_MVMT_CHK = 1 AND  TO_MVMT_CHK2 = 0 AND (INV_EQ_ONH_DT <> INV_BIL_ST_DT OR INV_BIL_ST_DT <> BILL_FM_DT OR INV_EQ_OFFH_DT <> INV_BIL_END_DT OR INV_BIL_END_DT <> BILL_TO_DT)  THEN 1 " ).append("\n"); 
		query.append("                                               ELSE 0" ).append("\n"); 
		query.append("                                          END TO_MVMT_CHK3" ).append("\n"); 
		query.append("                                        , CGM_COPS_MVMT_FND_FNC(A.INV_CNTR_NO, A.CHG_CD, A.MT_DT, A.MT_YD, @[cost_yrmon], A.TO_BKG_NO, A.INV_CHSS_NO, A.TO_BKG_NO) AS FM_ID_2" ).append("\n"); 
		query.append("                                 FROM" ).append("\n"); 
		query.append("                                          (" ).append("\n"); 
		query.append("                                            SELECT   A.INV_CHSS_NO" ).append("\n"); 
		query.append("                                                   , A.INV_CNTR_NO" ).append("\n"); 
		query.append("                                                   , A.CHG_CD" ).append("\n"); 
		query.append("                                                   , A.INV_EQ_ONH_DT" ).append("\n"); 
		query.append("                                                   , A.INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("                                                   , A.INV_BIL_ST_DT" ).append("\n"); 
		query.append("                                                   , A.INV_BIL_END_DT" ).append("\n"); 
		query.append("                                                   , A.INV_LSE_USE_DYS" ).append("\n"); 
		query.append("                                                   , A.INV_BIL_UT_DYS" ).append("\n"); 
		query.append("                                                   , A.INV_LSE_RT_AMT" ).append("\n"); 
		query.append("                                                   , A.INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("                                                   , A.INV_TAX_AMT" ).append("\n"); 
		query.append("                                                   , A.INV_NO" ).append("\n"); 
		query.append("                                                   , A.INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("                                                   , A.INV_CUST_EQ_TPSZ_NM" ).append("\n"); 
		query.append("                                                   , A.TAX_SMRY_AMT" ).append("\n"); 
		query.append("                                                   , A.INV_SMRY_AMT" ).append("\n"); 
		query.append("                                                   , A.VRFY_RSLT_DESC" ).append("\n"); 
		query.append("                                                   , A.INV_BKG_NO" ).append("\n"); 
		query.append("                                                   , A.FM_ID" ).append("\n"); 
		query.append("                                                   , A.INV_GATE_ACT_ID" ).append("\n"); 
		query.append("                                                   , A.INV_BIL_MOD_RMK" ).append("\n"); 
		query.append("                                                   , A.EQ_NO" ).append("\n"); 
		query.append("                                                   , A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                                                   , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                   , A.FM_CHSS_NO" ).append("\n"); 
		query.append("                                                   , A.FM_MVMT_CD" ).append("\n"); 
		query.append("                                                   , A.FM_YD" ).append("\n"); 
		query.append("                                                   , A.FM_DT" ).append("\n"); 
		query.append("                                                   , A.BKG_NO" ).append("\n"); 
		query.append("                                                   , A.FM_SCC_CD" ).append("\n"); 
		query.append("                                                   , A.TERM_CD" ).append("\n"); 
		query.append("                                                   , A.SC_NO" ).append("\n"); 
		query.append("                                                   , A.OB_CNTR_FLG" ).append("\n"); 
		query.append("                                                   , A.FCNTR_FLG" ).append("\n"); 
		query.append("                                                   , A.CNTR_CHK" ).append("\n"); 
		query.append("                                                   , A.CHZ_CHK" ).append("\n"); 
		query.append("                                                   , A.MVMT_CHK" ).append("\n"); 
		query.append("                                                   , A.AREA_CHK" ).append("\n"); 
		query.append("                                                   , A.YARD_CHK" ).append("\n"); 
		query.append("                                                   , A.ONT_CHG_CHK" ).append("\n"); 
		query.append("                                                   , A.DOM_CHK" ).append("\n"); 
		query.append("                                                   , CASE WHEN A.SC_EXP_CHK > 9 THEN 0 ELSE A.SC_EXP_CHK END AS SC_EXP_CHK" ).append("\n"); 
		query.append("                                                   , CASE WHEN A.SC_EXP_CHK > 9 THEN SC_EXP_CHK / 10 ELSE 0 END AS FT_DYS   -- CGM_SC_EXP_CHK_FNC 에서 가져올때 FT_DYS에 10곱해서 가져옴" ).append("\n"); 
		query.append("                                                   , A.DUP_CHK" ).append("\n"); 
		query.append("                                                   , A.MULTI_MOVE_CHK" ).append("\n"); 
		query.append("                                                   , A.TO_ID" ).append("\n"); 
		query.append("                                                   , A.FM_INF1" ).append("\n"); 
		query.append("                                                   , A.DDCT_TP_CD" ).append("\n"); 
		query.append("                                                   , A.CHSS_POOL_RT_AMT" ).append("\n"); 
		query.append("                                                   , A.CHSS_POOL_TAX_RT" ).append("\n"); 
		query.append("                                                   , A.AMT_AUD_FLG" ).append("\n"); 
		query.append("                                                   , A.DMST_ON_TML_CHG_FLG" ).append("\n"); 
		query.append("                                                   , A.DMST_PD_CHG_FLG" ).append("\n"); 
		query.append("                                                   , A.ON_TML_CHG_FLG" ).append("\n"); 
		query.append("                                                   , B.CHSS_NO TO_CHSS_NO" ).append("\n"); 
		query.append("                                                   , B.MVMT_STS_CD TO_MVMT_CD" ).append("\n"); 
		query.append("                                                   , B.ORG_YD_CD TO_YD" ).append("\n"); 
		query.append("                                                   , B.CNMV_EVNT_DT TO_DT" ).append("\n"); 
		query.append("                                                    -- 전월에 걸쳐도 오는 데이터도 오류 없음으로 인정. 신용찬, 2015-05-06" ).append("\n"); 
		query.append("                                                   , CASE WHEN (TO_CHAR(B.CNMV_EVNT_DT,'YYYYMM') < TO_CHAR(TO_DATE(@[cost_yrmon],'YYYYMM')-1, 'YYYYMM')) THEN 1 ELSE 0 END TO_MVMT_CHK" ).append("\n"); 
		query.append("                                                   , CASE WHEN (TO_CHAR(B.CNMV_EVNT_DT,'YYYYMM') < TO_CHAR(TO_DATE(@[cost_yrmon],'YYYYMM')-1, 'YYYYMM')) THEN" ).append("\n"); 
		query.append("                                                               NVL( (" ).append("\n"); 
		query.append("                                                                      SELECT   1" ).append("\n"); 
		query.append("                                                                      FROM     CGM_LSE_CHG_DTL H" ).append("\n"); 
		query.append("                                                                      WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                      AND      H.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                                                                      AND      H.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("                                                                      AND      H.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("                                                                      AND      H.COST_YRMON < @[cost_yrmon]" ).append("\n"); 
		query.append("                                                                      AND      H.CHG_CD = A.CHG_CD" ).append("\n"); 
		query.append("                                                                      AND      (" ).append("\n"); 
		query.append("                                                                                    (TO_CHAR(A.INV_BIL_ST_DT,'YYYYMM') BETWEEN TO_CHAR(H.INV_BIL_ST_DT,'YYYYMM') AND TO_CHAR(H.INV_BIL_END_DT,'YYYYMM'))" ).append("\n"); 
		query.append("                                                                                 OR (TO_CHAR(A.INV_BIL_END_DT,'YYYYMM') BETWEEN TO_CHAR(H.INV_BIL_ST_DT,'YYYYMM') AND TO_CHAR(H.INV_BIL_END_DT,'YYYYMM'))" ).append("\n"); 
		query.append("                                                                               )" ).append("\n"); 
		query.append("                                                                      AND      DECODE(A.INV_CNTR_NO,NULL,'1',H.INV_CUST_EQ_NO) = DECODE(A.INV_CNTR_NO,NULL,'1',A.INV_CNTR_NO)" ).append("\n"); 
		query.append("                                                                      AND      H.EQ_NO = A.INV_CHSS_NO" ).append("\n"); 
		query.append("                                                                      AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                                                    ),0) " ).append("\n"); 
		query.append("                                                          ELSE 0" ).append("\n"); 
		query.append("                                                     END AS TO_MVMT_CHK2" ).append("\n"); 
		query.append("                                                   , CASE WHEN (A.CNTR_CHK+A.CHZ_CHK+A.MVMT_CHK+A.AREA_CHK+A.YARD_CHK+A.ONT_CHG_CHK+A.DOM_CHK+DECODE(A.SC_EXP_CHK, 0, 0, 1, 1, 0)+A.DUP_CHK > 0) THEN 1 ELSE 0 END AS ERR_CHK0" ).append("\n"); 
		query.append("                                                   , CASE WHEN CHG_CD= 'PDM' AND FM_YD = 'USLGBM5' AND ORG_YD_CD = 'USLGBY2' AND FM_MVMT_CD = 'TN' THEN 1 ELSE 0 END AS PCT_CHK" ).append("\n"); 
		query.append("                                                   , CASE WHEN A.FM_MVMT_CD = 'TN' AND A.FM_YD = 'USLGBM1' AND B.ORG_YD_CD = 'USLGBY2' THEN 1 ELSE 0 END AS NO_CHG_CHK" ).append("\n"); 
		query.append("                                                   , CASE WHEN TO_CHAR(B.CNMV_EVNT_DT,'YYYYMM') < @[cost_yrmon]  THEN TRUNC(A.FM_DT) ELSE  DECODE(@[cost_yrmon],TO_CHAR(A.FM_DT,'YYYYMM'),TRUNC(A.FM_DT),TO_DATE(@[cost_yrmon]||'01','YYYYMMDD')) END AS BILL_FM_DT" ).append("\n"); 
		query.append("                                                   , CASE WHEN TO_CHAR(B.CNMV_EVNT_DT,'YYYYMM') < @[cost_yrmon]  THEN TRUNC(B.CNMV_EVNT_DT) ELSE  DECODE(@[cost_yrmon],TO_CHAR(B.CNMV_EVNT_DT,'YYYYMM'),TRUNC(B.CNMV_EVNT_DT),LAST_DAY(TO_DATE(@[cost_yrmon],'YYYYMM'))) END AS BILL_TO_DT" ).append("\n"); 
		query.append("	                                               , CASE WHEN SUBSTR(A.TO_ID,1,2) = 'MT' AND SUBSTR(A.TO_ID,46,1) ='P' THEN TO_DATE(RTRIM(LTRIM(SUBSTR(TO_ID,10,8))),'YYYYMMDDhh24miss') ELSE TO_DATE('','YYYYMMDD') END AS MT_DT" ).append("\n"); 
		query.append("                                                   , CASE WHEN SUBSTR(A.TO_ID,1,2) = 'MT' AND SUBSTR(A.TO_ID,46,1) ='P' THEN RTRIM(LTRIM(SUBSTR(A.TO_ID,3,7))) ELSE '' END AS MT_YD" ).append("\n"); 
		query.append("                                                   , CASE WHEN SUBSTR(A.TO_ID,46,1) ='P' THEN RTRIM(LTRIM(SUBSTR(A.TO_ID,36,9))) ELSE '' END AS TO_SC_NO" ).append("\n"); 
		query.append("                                                   , CASE WHEN SUBSTR(A.TO_ID,46,1) ='P' THEN RTRIM(LTRIM(SUBSTR(A.TO_ID,24,12))) ELSE '' END AS TO_BKG_NO" ).append("\n"); 
		query.append("                                                   , CASE WHEN SUBSTR(A.TO_ID,46,1) ='P' THEN RTRIM(LTRIM(SUBSTR(A.TO_ID,45,1))) ELSE '' END AS TO_BKG_TERM" ).append("\n"); 
		query.append("                                                    -- 2016.02.19 CHM-201640199 Invoice Double Charge 오류 발생시 InvNo + Cost " ).append("\n"); 
		query.append("                                                   , CASE WHEN A.DUP_CHK = 1 THEN" ).append("\n"); 
		query.append("                                                             (" ).append("\n"); 
		query.append("                                                               SELECT   '/ INV # ' || HDR.INV_NO || ', Cost month ' || HDR.COST_YRMON" ).append("\n"); 
		query.append("                                                               FROM     CGM_LSE_CHG_HDR HDR, CGM_LSE_CHG_DTL DTL" ).append("\n"); 
		query.append("                                                               WHERE    1 = 1" ).append("\n"); 
		query.append("                                                               AND      HDR.AGMT_OFC_CTY_CD = DTL.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                                               AND      HDR.AGMT_SEQ = DTL.AGMT_SEQ" ).append("\n"); 
		query.append("                                                               AND      HDR.AGMT_VER_NO = DTL.AGMT_VER_NO" ).append("\n"); 
		query.append("                                                               AND      HDR.COST_YRMON = DTL.COST_YRMON" ).append("\n"); 
		query.append("                                                               AND      HDR.COST_YRMON_SEQ = DTL.COST_YRMON_SEQ" ).append("\n"); 
		query.append("                                                               AND      DTL.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                                                               AND      DTL.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("                                                               AND      DTL.CHG_CD = A.CHG_CD" ).append("\n"); 
		query.append("                                                               AND      (" ).append("\n"); 
		query.append("                                                                             (TO_CHAR(A.INV_BIL_ST_DT,'YYYYMMDD')  BETWEEN TO_CHAR(DTL.INV_BIL_ST_DT,'YYYYMMDD') AND TO_CHAR(DTL.INV_BIL_END_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("                                                                          OR (TO_CHAR(A.INV_BIL_END_DT,'YYYYMMDD') BETWEEN TO_CHAR(DTL.INV_BIL_ST_DT,'YYYYMMDD') AND TO_CHAR(DTL.INV_BIL_END_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("                                                                        )" ).append("\n"); 
		query.append("                                                               AND      DECODE(A.INV_CNTR_NO,NULL,'1',DTL.INV_CUST_EQ_NO) = DECODE(A.INV_CNTR_NO,NULL,'1',A.INV_CNTR_NO)" ).append("\n"); 
		query.append("                                                               AND      DTL.EQ_NO = A.INV_CHSS_NO" ).append("\n"); 
		query.append("                                                               AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                                          ELSE ''" ).append("\n"); 
		query.append("                                                     END AS DUP_DESC" ).append("\n"); 
		query.append("                                            FROM     (" ).append("\n"); 
		query.append("                                                       SELECT   /*+ USE_NL(A M B) */" ).append("\n"); 
		query.append("                                                                A.*" ).append("\n"); 
		query.append("							                                  , B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                                                              , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                              , B.CHSS_NO AS FM_CHSS_NO" ).append("\n"); 
		query.append("                                                              , B.MVMT_STS_CD AS FM_MVMT_CD" ).append("\n"); 
		query.append("                                                              , B.ORG_YD_CD AS FM_YD" ).append("\n"); 
		query.append("                                                              , B.CNMV_EVNT_DT AS FM_DT" ).append("\n"); 
		query.append("                                                              , B.BKG_NO" ).append("\n"); 
		query.append("                                                              , SUBSTR(FM_ID,1,5) AS FM_SCC_CD" ).append("\n"); 
		query.append("                                                              , SUBSTR(A.FM_ID,15,1) AS TERM_CD" ).append("\n"); 
		query.append("                                                              , LTRIM(RTRIM(SUBSTR(A.FM_ID,6,9))) AS SC_NO" ).append("\n"); 
		query.append("                                                              , B.OB_CNTR_FLG" ).append("\n"); 
		query.append("                                                              , B.FCNTR_FLG" ).append("\n"); 
		query.append("                                                              , DECODE(M.CNTR_NO,NULL,1,0) AS CNTR_CHK" ).append("\n"); 
		query.append("                                                              , DECODE(Z.ACIAC_DIV_CD,'A',1,0) AS CHZ_CHK" ).append("\n"); 
		query.append("                                                              , DECODE(A.FM_ID,NULL,1,0) AS MVMT_CHK" ).append("\n"); 
		query.append("                                                              , CASE WHEN SUBSTR(A.FM_ID,35) IS NOT NULL AND D.LOC_CD IS NULL THEN 1 ELSE 0 END AS AREA_CHK" ).append("\n"); 
		query.append("                                                              , CASE WHEN SUBSTR(A.FM_ID,35) IS NOT NULL AND D.LOC_CD IS NOT NULL AND C.YD_CD IS NULL THEN NVL((SELECT 0 FROM MDM_YARD Y WHERE Y.YD_CD = B.ORG_YD_CD AND UPPER(Y.YD_NM) LIKE '%PSEUDO%'),1) ELSE 0  END AS YARD_CHK                                          " ).append("\n"); 
		query.append("                                                              , CASE WHEN A.CHG_CD = 'ONT' AND SUBSTR(B.MVMT_STS_CD,1,2) IN('IC','OC') THEN " ).append("\n"); 
		query.append("                                                                          CASE WHEN (NVL(C.ON_TML_CHG_FLG,'N') = 'N') OR (C.BILABL_SPCL_CNTR_TP_NM IS NOT NULL AND INSTR(C.BILABL_SPCL_CNTR_TP_NM,B.CNTR_TPSZ_CD) =0) THEN 1 ELSE 0 END" ).append("\n"); 
		query.append("                                                                     WHEN A.CHG_CD = 'ONT' AND SUBSTR(B.MVMT_STS_CD,1,2) IN ('MT') THEN" ).append("\n"); 
		query.append("                                                                          CASE WHEN (NVL(C.ON_TML_MTY_CHG_FLG,'N') = 'N') OR (C.BILABL_SPCL_CNTR_TP_NM IS NOT NULL AND INSTR(C.BILABL_SPCL_CNTR_TP_NM,B.CNTR_TPSZ_CD) =0) THEN 1 ELSE 0 END" ).append("\n"); 
		query.append("                                                                     ELSE 0" ).append("\n"); 
		query.append("                                                                END AS ONT_CHG_CHK" ).append("\n"); 
		query.append("                                                              , CASE WHEN (A.CHG_CD= 'ONT' AND SUBSTR(B.MVMT_STS_CD,1,1) ='C' AND C.DMST_ON_TML_CHG_FLG ='N' ) THEN 1" ).append("\n"); 
		query.append("                                                                     WHEN (A.CHG_CD= 'PDM' AND SUBSTR(B.MVMT_STS_CD,1,1) ='C' AND C.DMST_PD_CHG_FLG    = 'N' ) THEN 1" ).append("\n"); 
		query.append("                                                                     ELSE 0" ).append("\n"); 
		query.append("                                                                END AS DOM_CHK" ).append("\n"); 
		query.append("                                                                -- 2015-03-24 CHM-201534566, SC EXCEPTION 로직 교체(PRICING 에서 생성된 SC EXCEPTION 반영)(김기철-설계, 신용찬-코딩)" ).append("\n"); 
		query.append("                                                              , CASE WHEN (A.CHG_CD = 'ONT') OR (SUBSTR(A.FM_ID,15,1) = 'D') OR (SUBSTR(A.FM_ID,16,1) = 0) THEN 0 -- ON TERMINAL, DOOR TERM, ( 다음조건 모두 만족 : OP/ID, REETER TYPE, REEFER DRY CARGO='N'(진짜냉동), DELIVERY=USOAK, OUT BOUND 아닐때)" ).append("\n"); 
		query.append("                                                                     WHEN B.MVMT_STS_CD IN('OP','ID') AND SUBSTR(A.FM_ID,15,1) <> 'D' AND SUBSTR(A.FM_ID,34,1) = 0 THEN 0 -- SC=AEN110235, DOOR 아니고 POD 가 지정된 곳이며, OB_CNTR_FLG=N 이면 EXCEPTION, 0 리턴   ('CAPRR','CAVAN','USSEA','USTIW','USPDX','USOAK','USLAX','USLGB')                                                                                                " ).append("\n"); 
		query.append("                                                                     WHEN B.MVMT_STS_CD IN('OP','ID') AND SUBSTR(A.FM_ID,15,1) <> 'D' AND SUBSTR(A.FM_ID,34,1) = 1 THEN 1 -- SC=AEN110235, DOOR 아니고 POD 가 지정된 곳 아니고, DEL_CD 가 지정된 곳이고, OB_CNTR_FLG=N 이면 EXCEPTION, 1 리턴                                                         " ).append("\n"); 
		query.append("                                                                     WHEN B.MVMT_STS_CD IN('OP','ID') AND SUBSTR(A.FM_ID,15,1) <> 'D' THEN -- OP, ID 이고 DOOR TERM 아닐때" ).append("\n"); 
		query.append("                                                                          DECODE(LTRIM(SUBSTR(A.FM_ID, 6, 9)), NULL, 1,CGM_SC_EXP_CHK_FNC(B.CNTR_NO,B.CNMV_CYC_NO,B.CNMV_EVNT_DT,B.MVMT_STS_CD,RTRIM(SUBSTR(A.FM_ID,6,9)),SUBSTR(A.FM_ID,29,5),B.CNTR_TPSZ_CD,B.BKG_NO, 'Y'))" ).append("\n"); 
		query.append("                                                                     ELSE 0" ).append("\n"); 
		query.append("                                                                END AS SC_EXP_CHK" ).append("\n"); 
		query.append("							                                  , NVL( (" ).append("\n"); 
		query.append("                                                                       SELECT   1" ).append("\n"); 
		query.append("                                                                       FROM     CGM_LSE_CHG_DTL H" ).append("\n"); 
		query.append("                                                                       WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                       AND      H.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                                                                       AND      H.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("                                                                       AND      H.CHG_CD = A.CHG_CD" ).append("\n"); 
		query.append("                                                                       AND      (" ).append("\n"); 
		query.append("                                                                                     (TO_CHAR(A.INV_BIL_ST_DT,'YYYYMMDD')  BETWEEN TO_CHAR(H.INV_BIL_ST_DT,'YYYYMMDD') AND TO_CHAR(H.INV_BIL_END_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("                                                                                  OR (TO_CHAR(A.INV_BIL_END_DT,'YYYYMMDD') BETWEEN TO_CHAR(H.INV_BIL_ST_DT,'YYYYMMDD') AND TO_CHAR(H.INV_BIL_END_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("                                                                                )" ).append("\n"); 
		query.append("                                                                       AND      DECODE(A.INV_CNTR_NO,NULL,'1',H.INV_CUST_EQ_NO) = DECODE(A.INV_CNTR_NO,NULL,'1',A.INV_CNTR_NO)" ).append("\n"); 
		query.append("                                                                       AND      H.EQ_NO = A.INV_CHSS_NO" ).append("\n"); 
		query.append("                                                                       AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                                                     ),0) AS DUP_CHK" ).append("\n"); 
		query.append("							                                  , (" ).append("\n"); 
		query.append("  							                                      SELECT   COUNT(1)" ).append("\n"); 
		query.append("  							                                      FROM     CGM_LSE_INV_TMP B" ).append("\n"); 
		query.append("  							                                      WHERE    1 = 1" ).append("\n"); 
		query.append("  							                                      AND      B.CHG_CRE_SEQ = A.CHG_CRE_SEQ" ).append("\n"); 
		query.append("  							                                      AND      B.INV_EQ_NO = A.INV_CHSS_NO" ).append("\n"); 
		query.append("  							                                      AND      B.INV_EQ_ONH_DT < A.INV_EQ_ONH_DT" ).append("\n"); 
		query.append("  							                                      AND      B.INV_EQ_OFFH_DT >= A.INV_EQ_ONH_DT" ).append("\n"); 
		query.append("							                                    ) AS MULTI_MOVE_CHK" ).append("\n"); 
		query.append("							                                  , (" ).append("\n"); 
		query.append("                                                                  SELECT   /*+ INDEX(B2 XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                                                                           RPAD(B2.MVMT_STS_CD||B2.ORG_YD_CD||TO_CHAR(B2.CNMV_EVNT_DT,'YYYYMMDDhh24miss'),23,' ')" ).append("\n"); 
		query.append("                                                                         ||(" ).append("\n"); 
		query.append("                                                                             SELECT   /*+ INDEX(B3 XFN1CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                                                                                      RPAD(NVL(BK.BKG_NO,' '),12,' ')||RPAD(NVL(BK.SC_NO,' '),9,' ')||NVL(BK.RCV_TERM_CD,' ')||'P'||B3.ROWID" ).append("\n"); 
		query.append("                                                                             FROM     CTM_MOVEMENT B3 , BKG_BOOKING BK" ).append("\n"); 
		query.append("                                                                             WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                             AND      B3.CNTR_NO=B2.CNTR_NO" ).append("\n"); 
		query.append("                                                                             AND      B3.CNMV_YR||TO_CHAR(B3.CNMV_SEQ,'0000')||B3.CNMV_SPLIT_NO > B2.CNMV_YR||TO_CHAR(B2.CNMV_SEQ,'0000')||B2.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                                                                             AND      B3.MVMT_STS_CD IN('OC','CO','XX')" ).append("\n"); 
		query.append("                                                                             AND      A.CHG_CD ='PDM' " ).append("\n"); 
		query.append("                                                                             AND      B.MVMT_STS_CD IN('ID','TN')" ).append("\n"); 
		query.append("                                                                             AND      ((UPPER(Y.YD_NM) LIKE '%PSEUDO%') OR (B2.ORG_YD_CD = 'USATLGE'))" ).append("\n"); 
		query.append("                                                                             AND      B3.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                                                                             AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                                                             UNION" ).append("\n"); 
		query.append("                                                                             SELECT   RPAD(' ',22,' ')||'G'||B2.ROWID" ).append("\n"); 
		query.append("                                                                             FROM     DUAL" ).append("\n"); 
		query.append("                                                                             WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                             AND      (" ).append("\n"); 
		query.append("                                                                                           (A.CHG_CD ='ONT')" ).append("\n"); 
		query.append("                                                                                        OR (     A.CHG_CD = 'PDM'" ).append("\n"); 
		query.append("                                                                                             AND (UPPER(Y.YD_NM) NOT LIKE '%PSEUDO%') " ).append("\n"); 
		query.append("                                                                                             AND (B2.ORG_YD_CD <> 'USATLGE')" ).append("\n"); 
		query.append("                                                                                           )" ).append("\n"); 
		query.append("                                                                                      )" ).append("\n"); 
		query.append("                                                                             AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                                                  FROM     CTM_MOVEMENT B2" ).append("\n"); 
		query.append("                                                                         , MDM_YARD Y" ).append("\n"); 
		query.append("                                                                  WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                  AND      A.INV_CNTR_NO = B2.CNTR_NO" ).append("\n"); 
		query.append("                                                                  AND      Y.YD_CD = B2.ORG_YD_CD" ).append("\n"); 
		query.append("                                                                  AND      B2.CNMV_YR||TO_CHAR(B2.CNMV_SEQ,'0000')||B2.CNMV_SPLIT_NO > B.CNMV_YR||TO_CHAR(B.CNMV_SEQ,'0000')||B.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                                                                  AND      ROWNUM = 1" ).append("\n"); 
		query.append("                                                                ) TO_ID" ).append("\n"); 
		query.append("							                                  , B.CNMV_YR||TO_CHAR(B.CNMV_SEQ,'0000')||B.CNMV_SPLIT_NO FM_INF1" ).append("\n"); 
		query.append("							                                  , NVL(C.DDCT_TP_CD,'2') DDCT_TP_CD" ).append("\n"); 
		query.append("							                                  , D.CHSS_POOL_RT_AMT" ).append("\n"); 
		query.append("							                                  , D.CHSS_POOL_TAX_RT" ).append("\n"); 
		query.append("							                                  , D.AMT_AUD_FLG" ).append("\n"); 
		query.append("							                                  , C.DMST_ON_TML_CHG_FLG" ).append("\n"); 
		query.append("							                                  , C.DMST_PD_CHG_FLG" ).append("\n"); 
		query.append("							                                  , C.ON_TML_CHG_FLG" ).append("\n"); 
		query.append("                                                       FROM     (" ).append("\n"); 
		query.append("                                                                  SELECT   A.INV_EQ_NO INV_CHSS_NO" ).append("\n"); 
		query.append("                                                                         , A.INV_CUST_EQ_NO INV_CNTR_NO" ).append("\n"); 
		query.append("                                                                         , A.CHG_CD" ).append("\n"); 
		query.append("                                                                         , A.INV_EQ_ONH_DT" ).append("\n"); 
		query.append("                                                                         , A.INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("                                                                         , A.INV_BIL_ST_DT" ).append("\n"); 
		query.append("                                                                         , A.INV_BIL_END_DT" ).append("\n"); 
		query.append("                                                                         , A.INV_LSE_USE_DYS" ).append("\n"); 
		query.append("                                                                         , A.INV_BIL_UT_DYS" ).append("\n"); 
		query.append("                                                                         , A.INV_LSE_RT_AMT" ).append("\n"); 
		query.append("                                                                         , A.INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("                                                                         , A.INV_TAX_AMT" ).append("\n"); 
		query.append("                                                                         , A.INV_NO" ).append("\n"); 
		query.append("                                                                         , A.INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("                                                                         , A.INV_CUST_EQ_TPSZ_NM" ).append("\n"); 
		query.append("                                                                         , A.TAX_SMRY_AMT" ).append("\n"); 
		query.append("                                                                         , A.INV_SMRY_AMT" ).append("\n"); 
		query.append("                                                                         , A.VRFY_RSLT_DESC" ).append("\n"); 
		query.append("                                                                         , A.INV_BKG_NO" ).append("\n"); 
		query.append("                                                                         , A.INV_GATE_ACT_ID" ).append("\n"); 
		query.append("                                                                         , CGM_COPS_MVMT_FND_FNC(A.INV_CUST_EQ_NO,A.CHG_CD,A.INV_EQ_ONH_DT,A.INV_YD_CD,@[cost_yrmon],A.INV_BKG_NO,A.INV_EQ_NO,SUBSTR(VRFY_RSLT_DESC,1,12)) AS FM_ID" ).append("\n"); 
		query.append("                                                                         , A.INV_BIL_MOD_RMK" ).append("\n"); 
		query.append("                                                                         , A.EQ_NO" ).append("\n"); 
		query.append("                                                                         , A.CHG_CRE_SEQ" ).append("\n"); 
		query.append("                                                                  FROM     CGM_LSE_INV_TMP A" ).append("\n"); 
		query.append("                                                                  WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                  AND      CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("                                                                ) A" ).append("\n"); 
		query.append("                                                              , CTM_MOVEMENT B" ).append("\n"); 
		query.append("                                                              , CGM_AGMT_CPS_COND C" ).append("\n"); 
		query.append("                                                              , CGM_AGMT_CPS_RT  D" ).append("\n"); 
		query.append("                                                              , MST_CONTAINER M" ).append("\n"); 
		query.append("                                                              , CGM_EQUIPMENT Z" ).append("\n"); 
		query.append("                                                       WHERE    1 = 1" ).append("\n"); 
		query.append("                                                       AND      SUBSTR(A.FM_ID,36) = B.ROWID(+)" ).append("\n"); 
		query.append("                                                       AND      B.ORG_YD_CD = C.YD_CD(+)" ).append("\n"); 
		query.append("                                                       AND      @[agmt_ofc_cty_cd] = C.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                                                       AND      @[agmt_seq] = C.AGMT_SEQ(+)" ).append("\n"); 
		query.append("                                                       AND      @[agmt_ver_no]	= C.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                                                       AND      @[agmt_ofc_cty_cd] = D.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                                                       AND      @[agmt_seq] = D.AGMT_SEQ(+)" ).append("\n"); 
		query.append("                                                       AND      @[agmt_ver_no] = D.AGMT_VER_NO(+)            " ).append("\n"); 
		query.append("                                                       AND      SUBSTR(A.FM_ID,1,5) = D.LOC_CD(+)" ).append("\n"); 
		query.append("                                                       AND      A.INV_CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("                                                       AND      A.INV_CHSS_NO = Z.EQ_NO(+)" ).append("\n"); 
		query.append("                                                     ) A" ).append("\n"); 
		query.append("                                                   , CTM_MOVEMENT B" ).append("\n"); 
		query.append("                                            WHERE    1 = 1" ).append("\n"); 
		query.append("                                            AND      SUBSTR(A.TO_ID,47) = B.ROWID(+)" ).append("\n"); 
		query.append("                                          ) A" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                             , CTM_MOVEMENT B" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      SUBSTR(A.FM_ID_2,36) = B.ROWID(+)" ).append("\n"); 
		query.append("                      ORDER BY A.INV_CHSS_NO,A.FM_DT" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}