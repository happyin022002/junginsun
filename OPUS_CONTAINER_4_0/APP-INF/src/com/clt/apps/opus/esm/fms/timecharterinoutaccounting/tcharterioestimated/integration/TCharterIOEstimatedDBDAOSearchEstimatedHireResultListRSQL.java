/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOSearchEstimatedHireResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOSearchEstimatedHireResultListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL_ESTM_IF_ERP Hire Search
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOSearchEstimatedHireResultListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("est_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOSearchEstimatedHireResultListRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append(" 2015.10.26 : GL_ESTM_IF_ERP 에 등록된 데이타를 조회하므로 GL_ESTM_REV_VVD/FMS_VVD의 레코드를 기준으로 한다." ).append("\n"); 
		query.append(" 대선/용선 구분없이 연결된 VVD, Account 데이타를 조회 한다." ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("WITH  V_FMS_VVD AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT G.EXE_YRMON" ).append("\n"); 
		query.append("                     , V.REV_YRMON" ).append("\n"); 
		query.append("                     , V.RLANE_CD" ).append("\n"); 
		query.append("                     , V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD||V.REV_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                     , V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V.REV_DIR_CD" ).append("\n"); 
		query.append("                     , V.VST_DT" ).append("\n"); 
		query.append("                     , V.VED_DT" ).append("\n"); 
		query.append("                  FROM FMS_VVD V" ).append("\n"); 
		query.append("                     , GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND G.EXE_YRMON      = REPLACE(@[exe_yrmon],'-') " ).append("\n"); 
		query.append("                   AND G.REV_YRMON      BETWEEN REPLACE(@[fr_duration],'-') AND REPLACE(@[to_duration],'-')" ).append("\n"); 
		query.append("                   AND G.ESTM_VVD_TP_CD = @[est_type]" ).append("\n"); 
		query.append("                   AND G.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("                   AND G.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND G.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND G.REV_DIR_CD     = V.REV_DIR_CD " ).append("\n"); 
		query.append("                   AND V.REV_YRMON      BETWEEN REPLACE(@[fr_duration],'-') AND REPLACE(@[to_duration],'-')" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        ORDER BY A.EXE_YRMON, A.VVD_CD, A.REV_YRMON          " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_FMS_VVD; " ).append("\n"); 
		query.append("SELECT 'R' AS IBFLAG" ).append("\n"); 
		query.append("     , G.EXE_YRMON" ).append("\n"); 
		query.append("     , G.REV_YRMON" ).append("\n"); 
		query.append("     , G.ACT_DT" ).append("\n"); 
		query.append("     , G.AGMT_NO AS RE_DIVR_CD" ).append("\n"); 
		query.append("     , V.RLANE_CD AS RLANE_CD" ).append("\n"); 
		query.append("     , G.VSL_CD||G.SKD_VOY_NO||G.SKD_DIR_CD||G.REV_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("     , G.VSL_CD" ).append("\n"); 
		query.append("     , G.SKD_VOY_NO" ).append("\n"); 
		query.append("     , G.SKD_DIR_CD" ).append("\n"); 
		query.append("     , G.REV_DIR_CD " ).append("\n"); 
		query.append("     , G.ACCT_CD" ).append("\n"); 
		query.append("     , (SELECT MAX(MA.ACCT_ENG_NM)" ).append("\n"); 
		query.append("          FROM MDM_ACCOUNT MA" ).append("\n"); 
		query.append("         WHERE 1=1 --MA.JNL_CRE_FLG = 'Y'" ).append("\n"); 
		query.append("           AND MA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MA.ACCT_CD = G.ACCT_CD) AS ACCT_ITM_NM" ).append("\n"); 
		query.append("     , SUBSTR(G.WO_NO,1 ,8) AS VST_DT" ).append("\n"); 
		query.append("     , SUBSTR(G.WO_NO,10,8) AS VED_DT" ).append("\n"); 
		query.append("     , G.VVD_DUR_DYS AS ESTM_DYS" ).append("\n"); 
		query.append("     , G.SAIL_DYS AS SAIL_DYS" ).append("\n"); 
		query.append("     , NULL AS ORI_HIRE_EFF_DT" ).append("\n"); 
		query.append("     , NULL AS ORI_HIRE_EXP_DT" ).append("\n"); 
		query.append("     , G.HIR_DT_AMT AS HIRE_AMT" ).append("\n"); 
		query.append("     , G.ESTM_AMT AS EST_AMT" ).append("\n"); 
		query.append("     , G.ACT_AMT AS ACT_AMT" ).append("\n"); 
		query.append("     , G.ACCL_AMT AS ACC_AMT" ).append("\n"); 
		query.append("     , G.ESTM_SEQ_NO " ).append("\n"); 
		query.append("     , G.ESTM_VVD_TP_CD " ).append("\n"); 
		query.append("     , SUBSTR(G.VNDR_INV_NO ,1 , 8) AS SLP_EFF_DT" ).append("\n"); 
		query.append("     , SUBSTR(G.VNDR_INV_NO ,10, 8) AS SLP_EXP_DT" ).append("\n"); 
		query.append("  FROM GL_ESTM_IF_ERP G" ).append("\n"); 
		query.append("     , V_FMS_VVD V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND G.SYS_SRC_ID = 'CDA'" ).append("\n"); 
		query.append("   AND G.EXE_YRMON = REPLACE(@[exe_yrmon],'-')" ).append("\n"); 
		query.append("   AND G.REV_YRMON BETWEEN REPLACE(@[fr_duration],'-') AND REPLACE(@[to_duration],'-')" ).append("\n"); 
		query.append("   AND G.ESTM_VVD_TP_CD = @[est_type]" ).append("\n"); 
		query.append("   AND G.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND G.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND G.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND G.REV_DIR_CD = V.REV_DIR_CD" ).append("\n"); 
		query.append("   AND G.REV_YRMON = V.REV_YRMON" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("   AND G.AGMT_NO = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   AND G.VSL_CD||G.SKD_VOY_NO||G.SKD_DIR_CD||G.REV_DIR_CD LIKE @[vvd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_cd} != '')" ).append("\n"); 
		query.append("	#if (${acct_cd} == 'C') " ).append("\n"); 
		query.append("		AND G.ACCT_CD IN (SELECT AC.ACCT_CD" ).append("\n"); 
		query.append("                            FROM FMS_ACCT_CATE AC" ).append("\n"); 
		query.append("                               , FMS_ACCT_ITM AI" ).append("\n"); 
		query.append("                           WHERE AC.FLET_ACCT_CATE_CD = 'TC'" ).append("\n"); 
		query.append("                             AND AC.ACCT_CD = AI.ACCT_CD" ).append("\n"); 
		query.append("                             AND AC.ACCT_ITM_SEQ = AI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             AND ROWNUM = 1)" ).append("\n"); 
		query.append("    #elseif (${acct_cd} == 'O') " ).append("\n"); 
		query.append("		AND G.ACCT_CD NOT IN (SELECT AC.ACCT_CD" ).append("\n"); 
		query.append("                               FROM FMS_ACCT_CATE AC" ).append("\n"); 
		query.append("                                  , FMS_ACCT_ITM AI" ).append("\n"); 
		query.append("                              WHERE AC.FLET_ACCT_CATE_CD = 'TC'" ).append("\n"); 
		query.append("                                AND AC.ACCT_CD = AI.ACCT_CD" ).append("\n"); 
		query.append("                                AND AC.ACCT_ITM_SEQ = AI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                AND ROWNUM = 1) " ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY G.AGMT_NO, G.VSL_CD||G.SKD_VOY_NO||G.SKD_DIR_CD||G.REV_DIR_CD, NVL(G.HIR_DT_AMT,'0') DESC, G.ACT_DT, G.ACCT_CD" ).append("\n"); 

	}
}