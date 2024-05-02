/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOStlStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.10 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOStlStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target Voyage vs Unsettled Status
	  * 2010.10.25 이준범(수정자:이영두 수석) CHM-201006632-01
	  * BSA에 값이 있는 경우 Taget VVD 에 없으면 COA->BST Amount 값이 0 으로 나오게 처리
	  * 
	  * 2010.11.4 이상민 (수정자:이영두 수석) [CHM-201006882] JO - Target voyage vs Unsettled status 보완
	  *                 Target VVD 가 Renue 와 Expense 가 동시에 있는 경우 2배로 금액이 발생함
	  *                 JOO Combined Amount 와 JOO Slip Amount에 두배로 표시되는 부분 수정
	  * 
	  * 2010.11.17 박희동 조회조건 추가, rmk 추가
	  * 2011.01.11 이준범 [CHM-201108229-01] JO > TARGET VOYAGE VS UNSETTLED STATUS 관련 ERROR 수정요청
	  * - BSA가 REV/EXP 다 있는 항차의 경우, 실제 DIFF가 아닌데도 DIFF 로 표시되는 오류 수정
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOStlStatusVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOStlStatusVORSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD, A.RLANE_CD, A.JO_CRR_CD, A.VVD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON, A.ACCT_YRMON, A.JO_STL_ITM_CD, R.JO_UNSTL_STS_RMK, '' AS USR_ID," ).append("\n"); 
		query.append("       A.R_COA_BSA_AMT, A.R_JOO_CMB_AMT, A.R_JOO_SLP_AMT, A.R_JOO_CMB_BGCOLOR_YN, A.R_JOO_SLP_BGCOLOR_YN, " ).append("\n"); 
		query.append("       A.E_COA_BSA_AMT, A.E_JOO_CMB_AMT, A.E_JOO_SLP_AMT, A.E_JOO_CMB_BGCOLOR_YN, A.E_JOO_SLP_BGCOLOR_YN" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("               A.TRD_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD" ).append("\n"); 
		query.append("              ,A.JO_CRR_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.REV_DIR_CD" ).append("\n"); 
		query.append("              ,B.REV_YRMON" ).append("\n"); 
		query.append("              ,A.ACCT_YRMON" ).append("\n"); 
		query.append("              ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', E.R_COA_BSA_AMT, 0)),0) AS R_COA_BSA_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', C.R_JOO_CMB_AMT, 0)),0) AS R_JOO_CMB_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', D.R_JOO_SLP_AMT, 0)),0)  AS R_JOO_SLP_AMT" ).append("\n"); 
		query.append("              -- COA데이터가 없는 경우는 Combined와 Slip을 비교해서 같으면 검정색 다르면 빨간색" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', E.R_COA_BSA_AMT, 0)),0) = 0" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                        CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', D.R_JOO_SLP_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', C.R_JOO_CMB_AMT, 0)),0)" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', E.R_COA_BSA_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', C.R_JOO_CMB_AMT, 0)),0)" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("               END r_joo_cmb_bgcolor_yn" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', C.R_JOO_CMB_AMT, 0)),0) = 0" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                        CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', D.R_JOO_SLP_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', C.R_JOO_CMB_AMT, 0)),0)" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', C.R_JOO_CMB_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'R', D.R_JOO_SLP_AMT, 0)),0)" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("               END r_joo_slp_bgcolor_yn" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', E.E_COA_BSA_AMT, 0)),0) AS E_COA_BSA_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', C.E_JOO_CMB_AMT, 0)),0) AS E_JOO_CMB_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', D.E_JOO_SLP_AMT, 0)),0) AS E_JOO_SLP_AMT" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', E.E_COA_BSA_AMT, 0)),0) = 0" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                        CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', D.E_JOO_SLP_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', C.E_JOO_CMB_AMT, 0)),0)" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', E.E_COA_BSA_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', C.E_JOO_CMB_AMT, 0)),0)" ).append("\n"); 
		query.append("                              THEN 'Y'" ).append("\n"); 
		query.append("                              ELSE 'N'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("               END e_joo_cmb_bgcolor_yn" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', E.E_COA_BSA_AMT, 0)),0) = 0 " ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                        CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', D.E_JOO_SLP_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', C.E_JOO_CMB_AMT, 0)),0)" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        CASE WHEN NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', E.E_COA_BSA_AMT, 0)),0) <> NVL(SUM(DECODE(A.RE_DIVR_CD, 'E', D.E_JOO_SLP_AMT, 0)),0)" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("               END e_joo_slp_bgcolor_yn" ).append("\n"); 
		query.append("       FROM   (SELECT " ).append("\n"); 
		query.append("                      DISTINCT" ).append("\n"); 
		query.append("                      A.ACCT_YRMON" ).append("\n"); 
		query.append("                     ,A.JO_CRR_CD" ).append("\n"); 
		query.append("                     ,A.TRD_CD" ).append("\n"); 
		query.append("                     ,A.RLANE_CD" ).append("\n"); 
		query.append("                     ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     ,A.VSL_CD    " ).append("\n"); 
		query.append("                     ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     ,A.REV_DIR_CD" ).append("\n"); 
		query.append("                     ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("               FROM   JOO_STL_VVD A" ).append("\n"); 
		query.append("               WHERE  A.ACCT_YRMON BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("               AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("               AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("               AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("               AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("               AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,AR_MST_REV_VVD  B" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      C.ACCT_YRMON" ).append("\n"); 
		query.append("                     ,C.JO_CRR_CD" ).append("\n"); 
		query.append("                     ,C.TRD_CD" ).append("\n"); 
		query.append("                     ,C.RLANE_CD" ).append("\n"); 
		query.append("                     ,C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     ,C.VSL_CD    " ).append("\n"); 
		query.append("                     ,C.SKD_VOY_NO" ).append("\n"); 
		query.append("                     ,C.SKD_DIR_CD" ).append("\n"); 
		query.append("                     ,C.REV_DIR_CD" ).append("\n"); 
		query.append("                     ,SUM(DECODE(C.RE_DIVR_CD,'R',C.STL_LOCL_AMT,0)) AS R_JOO_CMB_AMT" ).append("\n"); 
		query.append("                     ,SUM(DECODE(C.RE_DIVR_CD,'E',C.STL_LOCL_AMT,0)) AS E_JOO_CMB_AMT" ).append("\n"); 
		query.append("               FROM  JOO_SETTLEMENT  C" ).append("\n"); 
		query.append("                    ,JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("                    ,JOO_STL_CMB     E" ).append("\n"); 
		query.append("               WHERE  C.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    C.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("               AND    C.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("               AND    D.ACCT_YRMON  = E.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    D.JO_CRR_CD   = E.JO_CRR_CD" ).append("\n"); 
		query.append("               AND    D.STL_CMB_SEQ = E.STL_CMB_SEQ" ).append("\n"); 
		query.append("               AND    D.RE_DIVR_CD  = E.RE_DIVR_CD" ).append("\n"); 
		query.append("               AND    C.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("               AND    E.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("               AND    E.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("               AND    C.ACCT_YRMON  BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("               AND    C.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("               AND    C.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("               AND    C.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("               AND    C.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("               GROUP  BY" ).append("\n"); 
		query.append("                      C.ACCT_YRMON" ).append("\n"); 
		query.append("                     ,C.JO_CRR_CD" ).append("\n"); 
		query.append("                     ,C.TRD_CD" ).append("\n"); 
		query.append("                     ,C.RLANE_CD" ).append("\n"); 
		query.append("                     ,C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     ,C.VSL_CD    " ).append("\n"); 
		query.append("                     ,C.SKD_VOY_NO" ).append("\n"); 
		query.append("                     ,C.SKD_DIR_CD" ).append("\n"); 
		query.append("                     ,C.REV_DIR_CD" ).append("\n"); 
		query.append("              ) C" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      D.ACCT_YRMON" ).append("\n"); 
		query.append("                     ,D.JO_CRR_CD" ).append("\n"); 
		query.append("                     ,D.TRD_CD" ).append("\n"); 
		query.append("                     ,D.RLANE_CD" ).append("\n"); 
		query.append("                     ,D.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     ,D.VSL_CD    " ).append("\n"); 
		query.append("                     ,D.SKD_VOY_NO" ).append("\n"); 
		query.append("                     ,D.SKD_DIR_CD" ).append("\n"); 
		query.append("                     ,D.REV_DIR_CD" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.RE_DIVR_CD,'R',C.CSR_LOCL_AMT,0)) AS R_JOO_SLP_AMT" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.RE_DIVR_CD,'E',C.CSR_LOCL_AMT,0)) AS E_JOO_SLP_AMT" ).append("\n"); 
		query.append("               FROM   JOO_SETTLEMENT  D" ).append("\n"); 
		query.append("                     ,JOO_STL_CMB_DTL A" ).append("\n"); 
		query.append("                     ,JOO_STL_CMB     B" ).append("\n"); 
		query.append("                     ,JOO_SLIP        C               " ).append("\n"); 
		query.append("               WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("               AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("               AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("               AND    A.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    A.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("               AND    A.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("               AND    B.SLP_TP_CD   = C.SLP_TP_CD" ).append("\n"); 
		query.append("               AND    B.SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("               AND    B.SLP_OFC_CD  = C.SLP_OFC_CD" ).append("\n"); 
		query.append("               AND    B.SLP_ISS_DT  = C.SLP_ISS_DT" ).append("\n"); 
		query.append("               AND    B.SLP_SER_NO  = C.SLP_SER_NO" ).append("\n"); 
		query.append("               AND    D.ACCT_YRMON  = C.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    D.STL_VVD_SEQ = C.STL_VVD_SEQ" ).append("\n"); 
		query.append("               AND    D.STL_SEQ     = C.STL_SEQ" ).append("\n"); 
		query.append("               AND    C.DR_CR_CD    = 'DR'" ).append("\n"); 
		query.append("               AND    B.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("               AND    A.ACCT_YRMON  BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("               AND    D.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("               AND    D.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("               AND    D.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("               AND    D.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("               GROUP  BY" ).append("\n"); 
		query.append("                      D.ACCT_YRMON" ).append("\n"); 
		query.append("                     ,D.JO_CRR_CD" ).append("\n"); 
		query.append("                     ,D.TRD_CD" ).append("\n"); 
		query.append("                     ,D.RLANE_CD" ).append("\n"); 
		query.append("                     ,D.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     ,D.VSL_CD    " ).append("\n"); 
		query.append("                     ,D.SKD_VOY_NO" ).append("\n"); 
		query.append("                     ,D.SKD_DIR_CD" ).append("\n"); 
		query.append("                     ,D.REV_DIR_CD" ).append("\n"); 
		query.append("              ) D" ).append("\n"); 
		query.append("             ,(" ).append("\n"); 
		query.append("         SELECT" ).append("\n"); 
		query.append("                 A.COST_YRMON AS ACCT_YRMON" ).append("\n"); 
		query.append("                ,C.CRR_CD  AS JO_CRR_CD" ).append("\n"); 
		query.append("                ,A.TRD_CD" ).append("\n"); 
		query.append("                ,A.RLANE_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,A.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                ,'S/H' AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("                ,SUM(CASE WHEN C.BSA_OP_JB_CD IN ('001','002','004') THEN C.CRR_PERF_AMT ELSE 0 END) AS R_COA_BSA_AMT" ).append("\n"); 
		query.append("                ,SUM(CASE WHEN C.BSA_OP_JB_CD IN ('000','003','005') THEN C.CRR_PERF_AMT ELSE 0 END) AS E_COA_BSA_AMT" ).append("\n"); 
		query.append("           FROM MAS_MON_VVD      A," ).append("\n"); 
		query.append("                BSA_VVD_CRR_PERF C" ).append("\n"); 
		query.append("          WHERE A.VSL_CD      = C.VSL_CD" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO  = C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A.DIR_CD      = C.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND A.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("            AND A.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("                  --AND B.REV_PORT_ETD_DT BETWEEN ADD_MONTHS(TO_DATE(REPLACE(acct_yrmon_fr,'-',''),'YYYYMM'),-3) AND LAST_DAY  (TO_DATE(REPLACE(acct_yrmon_to,'-',''),'YYYYMM'))+0.99999" ).append("\n"); 
		query.append("            AND C.BSA_OP_JB_CD IN ('000','001','002','003','004','005')" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("            AND A.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("            AND A.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("            AND C.CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("            AND 'S/H'         = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("            AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("          GROUP BY" ).append("\n"); 
		query.append("                 A.COST_YRMON" ).append("\n"); 
		query.append("                ,C.CRR_CD" ).append("\n"); 
		query.append("                ,A.TRD_CD" ).append("\n"); 
		query.append("                ,A.RLANE_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,A.DIR_CD" ).append("\n"); 
		query.append("         HAVING SUM(C.CRR_BSA_CAPA) <> 0" ).append("\n"); 
		query.append("         AND    SUM(C.CRR_PERF_AMT) <> 0" ).append("\n"); 
		query.append("              ) E," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("               SELECT JO_CRR_CD, RLANE_CD " ).append("\n"); 
		query.append("                 FROM JOO_CRR_AUTH " ).append("\n"); 
		query.append("                WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                  AND AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${ofc_cd} == 'SELADG')" ).append("\n"); 
		query.append("                  AND JO_CRR_AUTH_CD = 'W'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("                GROUP BY JO_CRR_CD, RLANE_CD" ).append("\n"); 
		query.append("              ) F" ).append("\n"); 
		query.append("       WHERE  A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("       AND    A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND    A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND    A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD     = F.JO_CRR_CD" ).append("\n"); 
		query.append("       AND    A.RLANE_CD      = F.RLANE_CD    " ).append("\n"); 
		query.append("       AND    A.ACCT_YRMON    = C.ACCT_YRMON   (+)" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD     = C.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("       AND    A.TRD_CD        = C.TRD_CD       (+)" ).append("\n"); 
		query.append("       AND    A.RLANE_CD      = C.RLANE_CD     (+)" ).append("\n"); 
		query.append("       AND    A.JO_STL_ITM_CD = C.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("       AND    A.VSL_CD        = C.VSL_CD       (+)" ).append("\n"); 
		query.append("       AND    A.SKD_VOY_NO    = C.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("       AND    A.SKD_DIR_CD    = C.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("       AND    A.REV_DIR_CD    = C.REV_DIR_CD   (+)" ).append("\n"); 
		query.append("       AND    A.ACCT_YRMON    = D.ACCT_YRMON   (+)" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD     = D.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("       AND    A.TRD_CD        = D.TRD_CD       (+)" ).append("\n"); 
		query.append("       AND    A.RLANE_CD      = D.RLANE_CD     (+)" ).append("\n"); 
		query.append("       AND    A.JO_STL_ITM_CD = D.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("       AND    A.VSL_CD        = D.VSL_CD       (+)" ).append("\n"); 
		query.append("       AND    A.SKD_VOY_NO    = D.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("       AND    A.SKD_DIR_CD    = D.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("       AND    A.REV_DIR_CD    = D.REV_DIR_CD   (+)" ).append("\n"); 
		query.append("       --AND    A.ACCT_YRMON    = E.ACCT_YRMON   (+)" ).append("\n"); 
		query.append("       AND    A.JO_CRR_CD     = E.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("       AND    A.TRD_CD        = E.TRD_CD       (+)" ).append("\n"); 
		query.append("       AND    A.RLANE_CD      = E.RLANE_CD     (+)" ).append("\n"); 
		query.append("       AND    A.VSL_CD        = E.VSL_CD       (+)" ).append("\n"); 
		query.append("       AND    A.SKD_VOY_NO    = E.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("       AND    A.SKD_DIR_CD    = E.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("       AND    A.RLANE_CD      = E.RLANE_CD     (+)" ).append("\n"); 
		query.append("       AND    A.JO_STL_ITM_CD = E.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("       GROUP  BY" ).append("\n"); 
		query.append("               A.TRD_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD" ).append("\n"); 
		query.append("              ,A.JO_CRR_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.REV_DIR_CD" ).append("\n"); 
		query.append("              ,B.REV_YRMON" ).append("\n"); 
		query.append("              ,A.ACCT_YRMON" ).append("\n"); 
		query.append("              ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       JOO_TGT_UNSTL_STS_RMK R" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = R.ACCT_YRMON   (+)" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = R.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("AND    A.TRD_CD        = R.TRD_CD       (+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = R.RLANE_CD     (+)" ).append("\n"); 
		query.append("AND    A.VSL_CD        = R.VSL_CD       (+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = R.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = R.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("AND    A.REV_DIR_CD    = R.REV_DIR_CD   (+)" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = R.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("#if (${diff_only_yn} == 'Y')" ).append("\n"); 
		query.append("AND    (A.R_JOO_CMB_BGCOLOR_YN = 'Y' OR A.R_JOO_SLP_BGCOLOR_YN = 'Y' OR A.E_JOO_CMB_BGCOLOR_YN = 'Y' OR A.E_JOO_SLP_BGCOLOR_YN = 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rmk_yn} == 'Y')" ).append("\n"); 
		query.append("AND    R.JO_UNSTL_STS_RMK IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY" ).append("\n"); 
		query.append("        A.TRD_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.JO_CRR_CD" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.REV_DIR_CD" ).append("\n"); 
		query.append("       ,A.REV_YRMON" ).append("\n"); 
		query.append("       ,A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 

	}
}