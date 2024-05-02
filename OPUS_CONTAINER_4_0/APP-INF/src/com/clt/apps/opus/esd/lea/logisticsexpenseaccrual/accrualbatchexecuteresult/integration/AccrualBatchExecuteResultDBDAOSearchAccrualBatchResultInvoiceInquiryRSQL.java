/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.27
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.08.27 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL").append("\n"); 
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
		query.append("SELECT	M.EXE_YRMON EXE_YRMON , NVL(M.REV_YRMON, ' ') REV_YRMON, B.RHQ_CD RHQ_CD ," ).append("\n"); 
		query.append("--f_report = '1'(RHQ)&& vendor = '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--f_report = '1'(RHQ)&& vendor = '1'" ).append("\n"); 
		query.append("#if (${f_report} == '1' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("V.VNDR_SEQ  VNDR_SEQ , V.VNDR_LGL_ENG_NM  VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--f_report = '2'(Control Office) && vendor = '0'" ).append("\n"); 
		query.append("#if (${f_report} == '2' && ${f_vndr} != '1')" ).append("\n"); 
		query.append("B.OFC_CD CTRL_OFC_CD," ).append("\n"); 
		query.append("DECODE(SUBSTR(M.CSR_NO, 4, 6) , 'SELTOB', 'SELTOB', 'SELCOE', 'SELCOE', SUBSTR(M.CSR_NO, 4, 5)) SUB_OFC_CD ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--f_report = '2'(Control Office)&& vendor = '1'" ).append("\n"); 
		query.append("#if (${f_report} == '2' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("B.OFC_CD CTRL_OFC_CD," ).append("\n"); 
		query.append("DECODE(SUBSTR(M.CSR_NO, 4, 6) , 'SELTOB', 'SELTOB', 'SELCOE', 'SELCOE', SUBSTR(M.CSR_NO, 4, 5)) SUB_OFC_CD ," ).append("\n"); 
		query.append("V.VNDR_SEQ  VNDR_SEQ , V.VNDR_LGL_ENG_NM  VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("C.COST_MN_TP  MN_COST_TP_NM , C.SUB_COST_TP_NM  SUB_COST_TP_NM ," ).append("\n"); 
		query.append("M.COA_COST_SRC_CD COA_COST_SRC_CD , M.ACCT_CD ACCT_CD," ).append("\n"); 
		query.append("M.N1ST_NOD_CD N1ST_NOD_CD , M.N2ND_NOD_CD N2ND_NOD_CD, NVL(M.N3RD_NOD_CD, '')  N3RD_NOD_CD , NVL(M.N4TH_NOD_CD ,'')  N4TH_NOD_CD ," ).append("\n"); 
		query.append("M.LOCL_CURR_CD CURR_CD, SUM(M.LOCL_COST_AMT) LOCL_COST_AMT ," ).append("\n"); 
		query.append("CASE	WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("ROUND(SUM(M.LOCL_COST_AMT / U.USD_LOCL_XCH_RT), 3)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("SUM(M.USD_COST_AMT)" ).append("\n"); 
		query.append("END USD_COST_AMT" ).append("\n"); 
		query.append("FROM	LEA_ACT_COST_IF M ," ).append("\n"); 
		query.append("(SELECT VNDR_SEQ , SUBSTR(VNDR_LGL_ENG_NM , 1, 50) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N' ) v," ).append("\n"); 
		query.append("(SELECT	CURR_CD, USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE	ACCT_XCH_RT_YRMON = REPLACE(@[exe_yrmon],'-')" ).append("\n"); 
		query.append("AND		ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N') U ," ).append("\n"); 
		query.append("(SELECT	DECODE(Y.MN_COST_TP_CD, 'TM', 'Terminal', 'TR', 'Transport', 'MT', 'Mty Reposition ', 'ETC' ) COST_MN_TP," ).append("\n"); 
		query.append("X.SUB_COST_TP_CD , Y.SUB_COST_TP_NM , X.COA_COST_SRC_CD , X.ACCT_CD,  X.ACCL_AUTO_CD" ).append("\n"); 
		query.append("FROM	(	SELECT	DISTINCT SUB_COST_TP_CD SUB_COST_TP_CD, COA_COST_SRC_CD , ACCT_CD ACCT_CD , ACCL_AUTO_CD" ).append("\n"); 
		query.append("FROM	LEA_LGS_COST" ).append("\n"); 
		query.append("WHERE	DELT_FLG = 'N'" ).append("\n"); 
		query.append(")	X  ,	LEA_SUB_COST_TP Y" ).append("\n"); 
		query.append("WHERE   X.SUB_COST_TP_CD = Y.SUB_COST_TP_CD" ).append("\n"); 
		query.append("AND		Y.DELT_FLG = 'N') C ," ).append("\n"); 
		query.append("(SELECT SUB_OFC_CD, OFC_CD, RHQ_CD" ).append("\n"); 
		query.append("FROM	(	SELECT	DISTINCT OFC_CD SUB_OFC_CD , OFC_N5TH_LVL_CD OFC_CD, OFC_N3RD_LVL_CD RHQ_CD" ).append("\n"); 
		query.append("FROM	COA_OFC_LVL" ).append("\n"); 
		query.append("WHERE  REPLACE(@[exe_yrmon], '-')  BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON           /*월별관리*/" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT	'SELTOB' , 'SELBB', 'SHAAS' FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT	'SELCOE' , 'SELBB', 'SHAAS' FROM DUAL )" ).append("\n"); 
		query.append("WHERE	RHQ_CD = @[f_rhq_cd]" ).append("\n"); 
		query.append("AND		OFC_CD = DECODE(@[f_ctrl_ofc_cd], null , OFC_CD , @[f_ctrl_ofc_cd])) B" ).append("\n"); 
		query.append("WHERE	M.EXE_YRMON = REPLACE(@[exe_yrmon], '-')" ).append("\n"); 
		query.append("AND		M.COA_COST_SRC_CD = C.COA_COST_SRC_CD" ).append("\n"); 
		query.append("AND		M.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("AND		M.LOCL_CURR_CD = U.CURR_CD" ).append("\n"); 
		query.append("AND		DECODE(SUBSTR(M.CSR_NO, 4, 6) , 'SELTOB', 'SELTOB', 'SELCOE', 'SELCOE', SUBSTR(M.CSR_NO, 4, 5)) = B.SUB_OFC_CD" ).append("\n"); 
		query.append("AND 	M.INV_VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${f_cost_type_f} == '1' || ${f_cost_type_m} == '1' || ${f_cost_type_v} == '1' )" ).append("\n"); 
		query.append("AND		(" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cost_type_f} == '1' && ${f_cost_type_m} == '1')" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#elseif (${f_cost_type_f} == '1' && ${f_cost_type_m} != '1')" ).append("\n"); 
		query.append("C.SUB_COST_TP_CD NOT IN ('TMDC','TRDC','TRMT','TMMT')" ).append("\n"); 
		query.append("#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} == '1')" ).append("\n"); 
		query.append("C.SUB_COST_TP_CD IN ('TRMT','TMMT')" ).append("\n"); 
		query.append("#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} != '1')" ).append("\n"); 
		query.append("C.SUB_COST_TP_CD IN ('TMDC','TRDC')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_cost_type_f} == '1' || ${f_cost_type_m} == '1' || ${f_cost_type_v} == '1' )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY	M.EXE_YRMON , M.REV_YRMON, B.RHQ_CD ," ).append("\n"); 
		query.append("--f_report = '1'(RHQ)&& vendor = '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--f_report = '1'(RHQ)&& vendor = '1'" ).append("\n"); 
		query.append("#if (${f_report} == '1' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("V.VNDR_SEQ , V.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--f_report = '2'(Control Office) && vendor = '0'" ).append("\n"); 
		query.append("#if (${f_report} == '2' && ${f_vndr} != '1')" ).append("\n"); 
		query.append("B.OFC_CD," ).append("\n"); 
		query.append("DECODE(SUBSTR(M.CSR_NO, 4, 6) , 'SELTOB', 'SELTOB', 'SELCOE', 'SELCOE', SUBSTR(M.CSR_NO, 4, 5)) ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--f_report = '2'(Control Office)&& vendor = '1'" ).append("\n"); 
		query.append("#if (${f_report} == '2' && ${f_vndr} == '1' )" ).append("\n"); 
		query.append("B.OFC_CD," ).append("\n"); 
		query.append("DECODE(SUBSTR(M.CSR_NO, 4, 6) , 'SELTOB', 'SELTOB', 'SELCOE', 'SELCOE', SUBSTR(M.CSR_NO, 4, 5)) ," ).append("\n"); 
		query.append("V.VNDR_SEQ , V.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("C.COST_MN_TP , C.SUB_COST_TP_NM , M.COA_COST_SRC_CD, M.ACCT_CD," ).append("\n"); 
		query.append("M.N1ST_NOD_CD, M.N2ND_NOD_CD, NVL(M.N3RD_NOD_CD, '') , NVL(M.N4TH_NOD_CD ,'') ," ).append("\n"); 
		query.append("M.LOCL_CURR_CD" ).append("\n"); 
		query.append("ORDER BY	M.EXE_YRMON , M.REV_YRMON, B.RHQ_CD ," ).append("\n"); 
		query.append("#if (${f_report} == '2')" ).append("\n"); 
		query.append("B.OFC_CD ,  DECODE(SUBSTR(M.CSR_NO, 4, 6) , 'SELTOB', 'SELTOB', 'SELCOE', 'SELCOE', SUBSTR(M.CSR_NO, 4, 5)) ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("C.COST_MN_TP" ).append("\n"); 

	}
}