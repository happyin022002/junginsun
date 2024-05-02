/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차료에 대한 추정실적을 조회
	  * </pre>
	  */
	public PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("period_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration").append("\n"); 
		query.append("FileName : PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL").append("\n"); 
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
		query.append("WITH RCV_VAL AS (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               @[period_dt]         AS period_dt" ).append("\n"); 
		query.append("              ,@[lse_ctrt_no]       AS lse_ctrt_no " ).append("\n"); 
		query.append("              ,@[vndr_seq]          AS vndr_seq" ).append("\n"); 
		query.append("              ,@[lse_pay_chg_tp_cd] AS lse_pay_chg_tp_cd" ).append("\n"); 
		query.append("              ,@[skr_acct_cd]       AS skr_acct_cd" ).append("\n"); 
		query.append("              ,@[rev_month]         AS rev_month" ).append("\n"); 
		query.append("              ,@[agmt_seq]          AS agmt_seq" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT                                                            " ).append("\n"); 
		query.append("  ESTM_SEQ_NO                                      SEQ,           " ).append("\n"); 
		query.append("  SUBSTR(EXE_YRMON, 1, 4)  || '-' || SUBSTR(EXE_YRMON, 5, 2) ACTUAL_MONTH,  " ).append("\n"); 
		query.append("  SYS_SRC_ID                                       SYS_NAME,      " ).append("\n"); 
		query.append("  SUBSTR(REV_YRMON, 1, 4)  || '-' || SUBSTR(REV_YRMON, 5, 2) REV_MONTH,     " ).append("\n"); 
		query.append("  ACCT_CD                                          ACCT_CODE,     " ).append("\n"); 
		query.append("  AGMT_NO                                          AGMT_NO,       " ).append("\n"); 
		query.append("  BIZ_UT_ID                                        BIZ_UNIT,      " ).append("\n"); 
		query.append("  VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD REV_VVD,       " ).append("\n"); 
		query.append("  CNTR_TPSZ_CD                                     TP_SZ,         " ).append("\n"); 
		query.append("  CNTR_QTY                                         EST_QTY,       " ).append("\n"); 
		query.append("  ESTM_AMT                                         ESTIMATED_COST," ).append("\n"); 
		query.append("  ACT_AMT                                          ACTUAL_COST,   " ).append("\n"); 
		query.append("  ACCL_AMT                                         ACCURAL_AMT," ).append("\n"); 
		query.append("  LOCL_CURR_CD                                     LOCL_CURR_CD," ).append("\n"); 
		query.append("  ACT_DT                                           ACT_DT," ).append("\n"); 
		query.append("  ACT_PLC_CD                                       ACT_PLC_CD," ).append("\n"); 
		query.append("  SLAN_CD                                          SLAN_CD," ).append("\n"); 
		query.append("  ACCT_DTL_CD                                      ACCT_DTL_CD," ).append("\n"); 
		query.append("  COST_ACT_PLC_CD                                  COST_ACT_PLC_CD,  " ).append("\n"); 
		query.append("  (SELECT LA.LSTM_CD" ).append("\n"); 
		query.append("     FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("    WHERE SUBSTR(A.AGMT_NO, 1, 3) = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND SUBSTR(A.AGMT_NO, -6)   = LA.AGMT_SEQ" ).append("\n"); 
		query.append("      AND ROWNUM          = 1)                     LSTM_CD," ).append("\n"); 
		query.append("  (SELECT LA.LSE_CTRT_NO" ).append("\n"); 
		query.append("     FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("    WHERE SUBSTR(A.AGMT_NO, 1, 3) = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND SUBSTR(A.AGMT_NO, -6)   = LA.AGMT_SEQ" ).append("\n"); 
		query.append("      AND ROWNUM          = 1)                     LSE_CTRT_NO," ).append("\n"); 
		query.append("  (SELECT LA.VNDR_SEQ" ).append("\n"); 
		query.append("     FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("    WHERE SUBSTR(A.AGMT_NO, 1, 3) = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND SUBSTR(A.AGMT_NO, -6)   = LA.AGMT_SEQ" ).append("\n"); 
		query.append("      AND ROWNUM          = 1)                     VNDR_SEQ," ).append("\n"); 
		query.append("  (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("         , MDM_VENDOR MV" ).append("\n"); 
		query.append("    WHERE SUBSTR(A.AGMT_NO, 1, 3) = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND SUBSTR(A.AGMT_NO, -6)   = LA.AGMT_SEQ" ).append("\n"); 
		query.append("      AND LA.VNDR_SEQ    = MV.VNDR_SEQ" ).append("\n"); 
		query.append("      AND ROWNUM         = 1)                      VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("   WO_NO                                           LSE_PAY_CHG_TP_CD," ).append("\n"); 
		query.append("   (SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("      FROM  MDM_ACCOUNT MA" ).append("\n"); 
		query.append("     WHERE A.ACCT_CD = MA.ACCT_CD" ).append("\n"); 
		query.append("       AND ROWNUM        = 1)                      SKR_ACCT_CD," ).append("\n"); 
		query.append("  NVL(IF_FLG, 'N')                                 IF_CHK_FLG," ).append("\n"); 
		query.append("  CRE_USR_ID                                       CRE_USR_ID,    " ).append("\n"); 
		query.append("  TO_CHAR(CRE_DT,'YYYY-MM-DD')                     CRE_DT,        " ).append("\n"); 
		query.append("  UPD_USR_ID                                       UPD_USR_ID,    " ).append("\n"); 
		query.append("  TO_CHAR(UPD_DT,'YYYY-MM-DD')                     UPD_DT         " ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP A " ).append("\n"); 
		query.append("WHERE A.SYS_SRC_ID = 'LSE'" ).append("\n"); 
		query.append("AND   EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                 FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                WHERE SUBSTR(A.AGMT_NO, 1, 3)  = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                  AND SUBSTR(A.AGMT_NO, -6)    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                  #if (${lse_ctrt_no} != '')" ).append("\n"); 
		query.append("                  AND LA.LSE_CTRT_NO = @[lse_ctrt_no]" ).append("\n"); 
		query.append("                  #end  " ).append("\n"); 
		query.append("                  #if (${vndr_seq} != '')" ).append("\n"); 
		query.append("                  AND LA.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("                  #end  " ).append("\n"); 
		query.append("                  #if (${agmt_seq} != '')" ).append("\n"); 
		query.append("                  AND LA.AGMT_CTY_CD = 'HHO'" ).append("\n"); 
		query.append("                  AND LA.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("				  #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("				  AND  LA.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("				  #end  " ).append("\n"); 
		query.append("                  AND ROWNUM           = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lse_pay_chg_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.WO_NO = @[lse_pay_chg_tp_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${skr_acct_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("              FROM  MDM_ACCOUNT MA" ).append("\n"); 
		query.append("             WHERE A.ACCT_CD  = MA.ACCT_CD" ).append("\n"); 
		query.append("               AND MA.MODI_ACCT_CD IN (" ).append("\n"); 
		query.append("  		 			#foreach($key IN ${arr_skr_acct_cd})" ).append("\n"); 
		query.append("			  		  	#if($velocityCount < $arr_skr_acct_cd.size())" ).append("\n"); 
		query.append("  							'$key', " ).append("\n"); 
		query.append("  						#else " ).append("\n"); 
		query.append("  							'$key' " ).append("\n"); 
		query.append("  						#end " ).append("\n"); 
		query.append("  					#end " ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("               AND ROWNUM  = 1)" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${rev_month} != '')" ).append("\n"); 
		query.append("AND  A.REV_YRMON = REPLACE(@[rev_month], '-', '')" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("AND   A.EXE_YRMON  = @[period_eddt]" ).append("\n"); 
		query.append("ORDER BY A.ESTM_SEQ_NO" ).append("\n"); 

	}
}