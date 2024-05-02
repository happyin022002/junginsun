/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OnhireBalanceDBDAOsearchPlanAndApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireBalanceDBDAOsearchPlanAndApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LT/ST/OW Plan & Approval 화면 조회 쿼리
	  * </pre>
	  */
	public OnhireBalanceDBDAOsearchPlanAndApprovalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toperiod_pkup",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk_pkup",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmperiod_pkup",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toperiod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmperiod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOsearchPlanAndApprovalRSQL").append("\n"); 
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
		query.append("-- LT/ST/OW Plan & Approval 화면 조회 쿼리" ).append("\n"); 
		query.append("-- EES_EQR_1040" ).append("\n"); 
		query.append("-- 2013/12/18, ONH_ORD_YR, ONH_PKUP_YRWK 추가, 신용찬" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   A.LSE_RQST_NO" ).append("\n"); 
		query.append("       , A.ONH_ORD_YR" ).append("\n"); 
		query.append("       , A.ONH_PLN_YRWK" ).append("\n"); 
		query.append("       , A.ONH_PKUP_YRWK" ).append("\n"); 
		query.append("       , A.RCC_CD" ).append("\n"); 
		query.append("       , A.LCC_CD" ).append("\n"); 
		query.append("       , A.EQ_LSTM_CD" ).append("\n"); 
		query.append("       , A.LSE_PLN_SEQ -- HIDDEN" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'D2', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D2' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D2' )" ).append("\n"); 
		query.append("         END D2_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'D4', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D4' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D4' )" ).append("\n"); 
		query.append("         END D4_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'D5', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D5' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D5' )" ).append("\n"); 
		query.append("         END D5_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'D7', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D7' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D7' )" ).append("\n"); 
		query.append("         END D7_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'R2', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'R2' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'R2' )" ).append("\n"); 
		query.append("         END R2_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'R5', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'R5' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'R5' )" ).append("\n"); 
		query.append("         END R5_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'D9', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D9' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'D9' )" ).append("\n"); 
		query.append("         END R9_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'O2', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'O2' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'O2' )" ).append("\n"); 
		query.append("         END O2_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'O4', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'O4' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'O4' )" ).append("\n"); 
		query.append("         END O4_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'O5', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'O5' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'O5' )" ).append("\n"); 
		query.append("         END O5_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'S2', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'S2' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'S2' )" ).append("\n"); 
		query.append("         END S2_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'S4', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'S4' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'S4' )" ).append("\n"); 
		query.append("         END S4_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'F2', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'F2' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'F2' )" ).append("\n"); 
		query.append("         END F2_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'F4', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'F4' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'F4' )" ).append("\n"); 
		query.append("         END F4_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'F5', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'F5' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'F5' )" ).append("\n"); 
		query.append("         END F5_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'A2', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'A2' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'A2' )" ).append("\n"); 
		query.append("         END A2_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'A4', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'A4' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'A4' )" ).append("\n"); 
		query.append("         END A4_QTY" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN SUM(DECODE(B.CNTR_TPSZ_CD, 'A5', B.CNTR_QTY))" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'A5' )" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN ( SELECT SUM(ONH_QTY) FROM LSE_ONH_APRO_QTY Q WHERE Q.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO AND Q.AGMT_CTY_CD = C.AGMT_CTY_CD AND Q.AGMT_SEQ = C.AGMT_SEQ AND CNTR_TPSZ_CD = 'A5' )" ).append("\n"); 
		query.append("         END A5_QTY" ).append("\n"); 
		query.append("       , C.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("       , C.MFT_YR" ).append("\n"); 
		query.append("       , C.AGMT_CTY_CD||C.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("       , C.ONH_LOC_CD" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'S'" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'R'" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN 'A'" ).append("\n"); 
		query.append("         END STS_CD  -- HIDDEN" ).append("\n"); 
		query.append("       , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'Saved'" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'Requested'" ).append("\n"); 
		query.append("              WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN 'Approved'" ).append("\n"); 
		query.append("         END STS_NM   " ).append("\n"); 
		query.append("FROM     EQR_CTRL_ONH_PLN_APRO A" ).append("\n"); 
		query.append("       , EQR_CTRL_ONH_PLN_APRO_QTY B" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   LSE_RQST_NO" ).append("\n"); 
		query.append("                  , CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                  , MFT_YR" ).append("\n"); 
		query.append("                  , AGMT_CTY_CD" ).append("\n"); 
		query.append("                  , AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("                  , AGMT_SEQ" ).append("\n"); 
		query.append("                  , ONH_LOC_CD" ).append("\n"); 
		query.append("           FROM     LSE_ONH_APRO" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      DELT_FLG  = 'N'" ).append("\n"); 
		query.append("         ) C" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.ONH_PLN_YRWK = B.ONH_PLN_YRWK" ).append("\n"); 
		query.append("AND      A.LCC_CD       = B.LCC_CD" ).append("\n"); 
		query.append("AND      A.EQ_LSTM_CD   = B.EQ_LSTM_CD" ).append("\n"); 
		query.append("AND      A.LSE_PLN_SEQ  = B.LSE_PLN_SEQ" ).append("\n"); 
		query.append("AND      A.LSE_RQST_NO  = C.LSE_RQST_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- <검색조건> [S] ------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- WEEK" ).append("\n"); 
		query.append("#if(${div_flag} == '1') -- APPROVAL WEEK" ).append("\n"); 
		query.append("AND      A.ONH_PLN_YRWK = @[yrwk]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${div_flag} == '2') -- APPROVAL WEEK - PERIOD" ).append("\n"); 
		query.append("    #if(${periodtp} == 'W') -- PERIOD WEEK" ).append("\n"); 
		query.append("AND      A.ONH_PLN_YRWK BETWEEN @[fmperiod] AND @[toperiod]" ).append("\n"); 
		query.append("    #else -- PERIOD MONTH" ).append("\n"); 
		query.append("AND      A.ONH_PLN_YRWK BETWEEN ( SELECT MIN(PLN_YR)||MIN(PLN_WK) FMPERIOD FROM EQR_WK_PRD WHERE PLN_YR = SUBSTR(@[fmperiod],1,4) AND PLN_MON = SUBSTR(@[fmperiod],5,6) )" ).append("\n"); 
		query.append("                        AND     ( SELECT MIN(PLN_YR)||MAX(PLN_WK) TOPERIOD FROM EQR_WK_PRD WHERE PLN_YR = SUBSTR(@[toperiod],1,4) AND PLN_MON = SUBSTR(@[toperiod],5,6) )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${div_flag} == '3') -- PICK-UP WEEK" ).append("\n"); 
		query.append("AND      A.ONH_PKUP_YRWK = @[yrwk_pkup]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${div_flag} == '4') -- PICK-UP WEEK - PERIOD" ).append("\n"); 
		query.append("    #if(${periodtp_pkup} == 'W') -- PERIOD WEEK" ).append("\n"); 
		query.append("AND      A.ONH_PKUP_YRWK BETWEEN @[fmperiod_pkup] AND @[toperiod_pkup]" ).append("\n"); 
		query.append("    #else -- PERIOD MONTH" ).append("\n"); 
		query.append("AND      A.ONH_PKUP_YRWK BETWEEN ( SELECT MIN(PLN_YR)||MIN(PLN_WK) FMPERIOD FROM EQR_WK_PRD WHERE PLN_YR = SUBSTR(@[fmperiod_pkup],1,4) AND PLN_MON = SUBSTR(@[fmperiod_pkup],5,6) )" ).append("\n"); 
		query.append("                         AND     ( SELECT MIN(PLN_YR)||MAX(PLN_WK) TOPERIOD FROM EQR_WK_PRD WHERE PLN_YR = SUBSTR(@[toperiod_pkup],1,4) AND PLN_MON = SUBSTR(@[toperiod_pkup],5,6) )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCATION" ).append("\n"); 
		query.append("AND      A.LCC_CD IN (" ).append("\n"); 
		query.append("                       SELECT   LCC_CD" ).append("\n"); 
		query.append("                       FROM     MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                       WHERE    1 = 1" ).append("\n"); 
		query.append("#if(${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                       AND      RCC_CD = @[rcc_cd] -- RCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${lcc_cd} != '' && ${lcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                       AND      LCC_CD = @[lcc_cd] -- LCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- STATUS" ).append("\n"); 
		query.append("-- R" ).append("\n"); 
		query.append("#if(${sts_cd} == 'R')" ).append("\n"); 
		query.append("AND      A.LSE_RQST_NO IS NOT NULL" ).append("\n"); 
		query.append("AND      C.CNTR_ONH_AUTH_NO IS NULL " ).append("\n"); 
		query.append("-- S" ).append("\n"); 
		query.append("#elseif(${sts_cd} == 'S')" ).append("\n"); 
		query.append("AND      A.LSE_RQST_NO IS NULL" ).append("\n"); 
		query.append("AND      C.CNTR_ONH_AUTH_NO IS NULL" ).append("\n"); 
		query.append("---- A" ).append("\n"); 
		query.append("#elseif(${sts_cd} == 'A')" ).append("\n"); 
		query.append("AND      A.LSE_RQST_NO IS NOT NULL" ).append("\n"); 
		query.append("AND      C.CNTR_ONH_AUTH_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- <검색조건> [E] ------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.LSE_RQST_NO" ).append("\n"); 
		query.append("       , A.ONH_ORD_YR" ).append("\n"); 
		query.append("       , A.ONH_PLN_YRWK" ).append("\n"); 
		query.append("       , A.ONH_PKUP_YRWK" ).append("\n"); 
		query.append("       , A.RCC_CD" ).append("\n"); 
		query.append("       , A.LCC_CD" ).append("\n"); 
		query.append("       , A.EQ_LSTM_CD" ).append("\n"); 
		query.append("       , A.LSE_PLN_SEQ" ).append("\n"); 
		query.append("       , C.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("       , C.MFT_YR" ).append("\n"); 
		query.append("       , C.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , C.AGMT_SEQ" ).append("\n"); 
		query.append("       , C.ONH_LOC_CD" ).append("\n"); 
		query.append("ORDER BY A.ONH_PLN_YRWK" ).append("\n"); 
		query.append("       , A.RCC_CD" ).append("\n"); 
		query.append("       , A.LCC_CD" ).append("\n"); 
		query.append("       , A.EQ_LSTM_CD" ).append("\n"); 
		query.append("       , A.LSE_PLN_SEQ" ).append("\n"); 

	}
}