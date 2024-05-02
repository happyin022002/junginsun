/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListRSQL.java
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

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  Office 별 결산 결과 조회
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListRSQL").append("\n"); 
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
		query.append("SELECT REV_YRMON, RHQ_CD," ).append("\n"); 
		query.append("#if (${f_report} == '2')" ).append("\n"); 
		query.append("CTRL_OFC_CD, SUB_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MN_COST_TP_NM,  SUB_COST_TP_NM," ).append("\n"); 
		query.append("COA_COST_SRC_CD, ACCT_CD," ).append("\n"); 
		query.append("N1ST_NOD_CD, N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD," ).append("\n"); 
		query.append("CNTR_QTY , ESTM_COST_AMT, ACT_COST_AMT, ACCL_COST_AMT," ).append("\n"); 
		query.append("CONFIRMED_COST_AMT,DIFF_COST_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("-- (1) Full" ).append("\n"); 
		query.append("#if (${f_cost_type_f} == '1')" ).append("\n"); 
		query.append("SELECT	/*+ PARALLEL( A 4 )  */" ).append("\n"); 
		query.append("A.REV_YRMON REV_YRMON, B.RHQ_CD RHQ_CD," ).append("\n"); 
		query.append("--Control Office" ).append("\n"); 
		query.append("#if (${f_report} == '2')" ).append("\n"); 
		query.append("B.OFC_CD CTRL_OFC_CD, A.CTRL_OFC_CD SUB_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("C.COST_MN_TP MN_COST_TP_NM,  C.SUB_COST_TP_NM SUB_COST_TP_NM," ).append("\n"); 
		query.append("A.COA_COST_SRC_CD COA_COST_SRC_CD, A.ACCT_CD ACCT_CD," ).append("\n"); 
		query.append("A.N1ST_NOD_CD N1ST_NOD_CD, A.N2ND_NOD_CD N2ND_NOD_CD, NVL(A.N3RD_NOD_CD,' ') N3RD_NOD_CD, NVL(A.N4TH_NOD_CD , ' ') N4TH_NOD_CD," ).append("\n"); 
		query.append("SUM(A.CNTR_QTY) CNTR_QTY , SUM(A.ESTM_COST_AMT) ESTM_COST_AMT, SUM(A.ACT_COST_AMT) ACT_COST_AMT, SUM(A.ACCL_COST_AMT) ACCL_COST_AMT," ).append("\n"); 
		query.append("SUM(A.ACT_COST_AMT + A.ACCL_COST_AMT) CONFIRMED_COST_AMT, SUM(A.ACT_COST_AMT + A.ACCL_COST_AMT - A.ESTM_COST_AMT)  DIFF_COST_AMT" ).append("\n"); 
		query.append("FROM	LEA_ACCL_DTL A ," ).append("\n"); 
		query.append("(SELECT	DECODE(Y.MN_COST_TP_CD, 'TM', 'Terminal', 'TR', 'Transport', 'MT', 'Mty Reposition ', 'ETC' ) COST_MN_TP," ).append("\n"); 
		query.append("Y.MN_COST_TP_CD , X.SUB_COST_TP_CD, Y.SUB_COST_TP_NM , X.COA_COST_SRC_CD" ).append("\n"); 
		query.append("FROM	LEA_LGS_COST X, LEA_SUB_COST_TP Y" ).append("\n"); 
		query.append("WHERE	X.SUB_COST_TP_CD = Y.SUB_COST_TP_CD" ).append("\n"); 
		query.append("AND		X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND		Y.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND		Y.SUB_COST_TP_CD NOT IN ('TMDC','TRDC','TRMT','TMMT'))  C ," ).append("\n"); 
		query.append("(SELECT	DISTINCT OFC_CD SUB_OFC_CD , OFC_N5TH_LVL_CD OFC_CD, OFC_N3RD_LVL_CD RHQ_CD" ).append("\n"); 
		query.append(",OFC_APLY_FM_YRMON, OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("FROM	COA_OFC_LVL" ).append("\n"); 
		query.append("WHERE	OFC_N3RD_LVL_CD = @[f_rhq_cd]" ).append("\n"); 
		query.append("AND		OFC_N5TH_LVL_CD = DECODE(@[f_ctrl_ofc_cd], null, OFC_N5TH_LVL_CD, @[f_ctrl_ofc_cd])) B" ).append("\n"); 
		query.append("WHERE	A.REV_YRMON = REPLACE(@[rev_yrmon], '-')" ).append("\n"); 
		query.append("AND     A.REV_YRMON  BETWEEN B.OFC_APLY_FM_YRMON AND B.OFC_APLY_TO_YRMON           /*월별관리*/" ).append("\n"); 
		query.append("AND		A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND		A.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("AND		NOT(A.ESTM_COST_AMT = 0 AND NVL(A.ACT_COST_AMT, 0) = 0)" ).append("\n"); 
		query.append("AND		A.COA_COST_SRC_CD = C.COA_COST_SRC_CD" ).append("\n"); 
		query.append("AND		A.CTRL_OFC_CD  = B.SUB_OFC_CD" ).append("\n"); 
		query.append("GROUP BY	A.REV_YRMON, B.RHQ_CD ," ).append("\n"); 
		query.append("#if (${f_report} == '2')" ).append("\n"); 
		query.append("B.OFC_CD, A.CTRL_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("C.COST_MN_TP, C.SUB_COST_TP_NM ," ).append("\n"); 
		query.append("A.COA_COST_SRC_CD, A.ACCT_CD," ).append("\n"); 
		query.append("A.N1ST_NOD_CD, A.N2ND_NOD_CD, NVL(A.N3RD_NOD_CD,' ') , NVL(A.N4TH_NOD_CD , ' ')" ).append("\n"); 
		query.append("#end -- Full" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- (2) Empty, Volume Incentive" ).append("\n"); 
		query.append("#if (${f_cost_type_m} == '1' || ${f_cost_type_v} == '1')" ).append("\n"); 
		query.append("#if (${f_cost_type_f} == '1')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT	/*+ ORDERED USE_HASH(M) INDEX (M XAK4LEA_ACT_COST_IF)  */" ).append("\n"); 
		query.append("M.REV_YRMON REV_YRMON, B.RHQ_CD RHQ_CD ," ).append("\n"); 
		query.append("--Control Office" ).append("\n"); 
		query.append("#if (${f_report} == '2')" ).append("\n"); 
		query.append("B.OFC_CD CTRL_OFC_CD,  SUBSTR(M.CSR_NO, 4, 5) SUB_OFC_CD ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("C.COST_MN_TP  MN_COST_TP_NM , C.SUB_COST_TP_NM  SUB_COST_TP_NM ," ).append("\n"); 
		query.append("M.COA_COST_SRC_CD COA_COST_SRC_CD , M.ACCT_CD ACCT_CD," ).append("\n"); 
		query.append("M.N1ST_NOD_CD N1ST_NOD_CD , M.N2ND_NOD_CD N2ND_NOD_CD, NVL(M.N3RD_NOD_CD, '')  N3RD_NOD_CD , NVL(M.N4TH_NOD_CD ,'')  N4TH_NOD_CD ," ).append("\n"); 
		query.append("COUNT(M.CNTR_NO) CNTR_QTY , SUM(M.USD_COST_AMT) ESTM_COST_AMT, SUM(M.USD_COST_AMT) ACT_COST_AMT , 0  ACCL_COST_AMT," ).append("\n"); 
		query.append("SUM(M.USD_COST_AMT) CONFIRMED_COST_AMT , 0  DIFF_COST_AMT" ).append("\n"); 
		query.append("FROM	LEA_ACT_COST_IF M ," ).append("\n"); 
		query.append("(SELECT	DECODE(Y.MN_COST_TP_CD, 'TM', 'Terminal', 'TR', 'Transport', 'MT', 'Mty Reposition ', 'ETC' ) COST_MN_TP," ).append("\n"); 
		query.append("X.SUB_COST_TP_CD SUB_COST_TP_CD, Y.SUB_COST_TP_NM , X.COA_COST_SRC_CD , X.ACCT_CD,  X.ACCL_AUTO_CD" ).append("\n"); 
		query.append("FROM	(SELECT	DISTINCT SUB_COST_TP_CD , COA_COST_SRC_CD , ACCT_CD ACCT_CD , ACCL_AUTO_CD" ).append("\n"); 
		query.append("FROM	LEA_LGS_COST" ).append("\n"); 
		query.append("WHERE	DELT_FLG = 'N' ) X  , LEA_SUB_COST_TP Y" ).append("\n"); 
		query.append("WHERE	X.SUB_COST_TP_CD = Y.SUB_COST_TP_CD" ).append("\n"); 
		query.append("AND 	Y.DELT_FLG = 'N') C ," ).append("\n"); 
		query.append("(SELECT	DISTINCT OFC_CD SUB_OFC_CD , OFC_N5TH_LVL_CD OFC_CD, OFC_N3RD_LVL_CD RHQ_CD" ).append("\n"); 
		query.append(",OFC_APLY_FM_YRMON, OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("FROM	COA_OFC_LVL" ).append("\n"); 
		query.append("WHERE	OFC_N3RD_LVL_CD  = @[f_rhq_cd]" ).append("\n"); 
		query.append("AND		OFC_N5TH_LVL_CD   = DECODE(@[f_ctrl_ofc_cd], null, OFC_N5TH_LVL_CD, @[f_ctrl_ofc_cd])) B" ).append("\n"); 
		query.append("WHERE	M.REV_YRMON = REPLACE(@[rev_yrmon], '-')" ).append("\n"); 
		query.append("AND     M.REV_YRMON  BETWEEN B.OFC_APLY_FM_YRMON AND B.OFC_APLY_TO_YRMON           /*월별관리*/" ).append("\n"); 
		query.append("AND		M.COA_COST_SRC_CD = C.COA_COST_SRC_CD" ).append("\n"); 
		query.append("AND		M.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("AND		SUBSTR(M.CSR_NO, 4, 5)  = B.SUB_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if		(${f_cost_type_m} == '1' && ${f_cost_type_v} == '1')" ).append("\n"); 
		query.append("AND		(C.SUB_COST_TP_CD IN ('TRMT','TMMT') OR C.SUB_COST_TP_CD IN ('TMDC','TRDC'))" ).append("\n"); 
		query.append("#elseif (${f_cost_type_m} == '1' && ${f_cost_type_v} != '1')" ).append("\n"); 
		query.append("AND		(C.SUB_COST_TP_CD IN ('TRMT','TMMT'))" ).append("\n"); 
		query.append("#elseif (${f_cost_type_m} != '1' && ${f_cost_type_v} == '1')" ).append("\n"); 
		query.append("AND 	(C.SUB_COST_TP_CD IN ('TMDC','TRDC'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY	M.REV_YRMON, B.RHQ_CD ," ).append("\n"); 
		query.append("--Control Office" ).append("\n"); 
		query.append("#if (${f_report} == '2')" ).append("\n"); 
		query.append("B.OFC_CD, SUBSTR(M.CSR_NO, 4, 5) ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("C.COST_MN_TP , C.SUB_COST_TP_NM , M.COA_COST_SRC_CD, M.ACCT_CD," ).append("\n"); 
		query.append("M.N1ST_NOD_CD, M.N2ND_NOD_CD, NVL(M.N3RD_NOD_CD, '') , NVL(M.N4TH_NOD_CD ,'')" ).append("\n"); 
		query.append("#end -- Empty, Volume Incentive" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}