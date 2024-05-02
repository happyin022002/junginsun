/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatementCommonDBDAOSearchMonthlyTesAccrualVerificationSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchMonthlyTesAccrualVerificationSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Summary List
	  * </pre>
	  */
	public StatementCommonDBDAOSearchMonthlyTesAccrualVerificationSummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mdl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchMonthlyTesAccrualVerificationSummaryListRSQL").append("\n"); 
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
		query.append("SELECT @[mdl_tp_cd] AS MDL_TP_CD" ).append("\n"); 
		query.append("     , REPLACE(@[accl_yrmon], '-', '') AS ACCL_YRMON" ).append("\n"); 
		query.append("     , TRGT.ACT_MONTH AS ACT_YRMON" ).append("\n"); 
		query.append("     , NVL(SUM(ACCL.ACCL_ESTM_USD)  , 0) AS ACCL_ESTM_USD" ).append("\n"); 
		query.append("     , NVL(SUM(ACCL.ACCL_ACT_USD)   , 0) AS ACCL_ACT_USD" ).append("\n"); 
		query.append("     , NVL(SUM(ACCL.ACCL_ACCL_USD)  , 0) AS ACCL_ACCL_USD" ).append("\n"); 
		query.append("     , NVL(SUM(TRGT.TRGT_ESTM_USD)  , 0) AS TRGT_ESTM_USD" ).append("\n"); 
		query.append("     , NVL(SUM(TRGT.TRGT_ACT_USD)   , 0) AS TRGT_ACT_USD" ).append("\n"); 
		query.append("     , NVL(SUM(TRGT.TRGT_ACCL_USD)  , 0) AS TRGT_ACCL_USD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SUBSTR(ACCL_T.ACT_DT,1,6) AS ACT_MONTH" ).append("\n"); 
		query.append("             , ACCL_T.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("             , NVL(ACCL_T.TRD_CD, 'NON_TRD') AS TRD_CD" ).append("\n"); 
		query.append("             , ACCL_T.LOCL_CURR_CD AS LOCL_CURR_CD" ).append("\n"); 
		query.append("             , ROUND(SUM(NVL(ACCL_T.ESTM_AMT    ,0) * FM_RT.CONV_XCH_RT/TO_RT.CONV_XCH_RT),2) AS ACCL_ESTM_USD" ).append("\n"); 
		query.append("             , ROUND(SUM(NVL(ACCL_T.ACT_AMT     ,0) * FM_RT.CONV_XCH_RT/TO_RT.CONV_XCH_RT),2) AS ACCL_ACT_USD" ).append("\n"); 
		query.append("             , ROUND(SUM(NVL(ACCL_T.ACCL_AMT    ,0) * FM_RT.CONV_XCH_RT/TO_RT.CONV_XCH_RT),2) AS ACCL_ACCL_USD" ).append("\n"); 
		query.append("          FROM SAC_COST_ACCL_INFO   ACCL_T" ).append("\n"); 
		query.append("             , SAC_DLY_XCH_RT       FM_RT" ).append("\n"); 
		query.append("             , SAC_DLY_XCH_RT       TO_RT" ).append("\n"); 
		query.append("         WHERE ACCL_T.EXE_YRMON         = REPLACE(@[accl_yrmon], '-', '')" ).append("\n"); 
		query.append("           AND ACCL_T.SYS_SRC_ID        = @[mdl_tp_cd] -- TES OR TRS" ).append("\n"); 
		query.append("           AND NVL(ACCL_T.ACCL_FLG,'Y') = 'Y'" ).append("\n"); 
		query.append("           AND FM_RT.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("           AND FM_RT.FM_CURR_CD         = ACCL_T.LOCL_CURR_CD" ).append("\n"); 
		query.append("           AND FM_RT.ACCT_XCH_RT_DT     = ACCL_T.ACT_DT" ).append("\n"); 
		query.append("           AND TO_RT.ACCT_XCH_RT_DT     = ACCL_T.ACT_DT" ).append("\n"); 
		query.append("           AND TO_RT.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("           AND TO_RT.FM_CURR_CD         = @[locl_curr_cd]" ).append("\n"); 
		query.append("#if( ${trd_cd} !='')" ).append("\n"); 
		query.append("           AND NVL(ACCL_T.TRD_CD, 'NON_TRD')        = @[trd_cd] -- Trade" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${acct_cd} !='')" ).append("\n"); 
		query.append("           AND ACCL_T.ACCT_CD           = @[acct_cd] -- Account" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(ACCL_T.ACT_DT,1,6)" ).append("\n"); 
		query.append("             , ACCL_T.ACCT_CD" ).append("\n"); 
		query.append("             , NVL(ACCL_T.TRD_CD, 'NON_TRD')" ).append("\n"); 
		query.append("             , ACCL_T.LOCL_CURR_CD" ).append("\n"); 
		query.append("       ) ACCL" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT SUBSTR(TO_CHAR(TRGT.ACT_DT,'YYYYMMDD'),1,6) AS ACT_MONTH" ).append("\n"); 
		query.append("             , TRGT.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("             , NVL(TRGT.TRD_CD, 'NON_TRD') AS TRD_CD" ).append("\n"); 
		query.append("             , TRGT.LOCL_CURR_CD AS LOCL_CURR_CD" ).append("\n"); 
		query.append("             , ROUND(SUM(NVL(TRGT.ESTM_COST_AMT ,0)  * FM_RT.CONV_XCH_RT/TO_RT.CONV_XCH_RT),2) AS TRGT_ESTM_USD" ).append("\n"); 
		query.append("             , ROUND(SUM(NVL(TRGT.ACT_COST_AMT  ,0)  * FM_RT.CONV_XCH_RT/TO_RT.CONV_XCH_RT),2) AS TRGT_ACT_USD" ).append("\n"); 
		query.append("             , ROUND(SUM(NVL(TRGT.ACCL_COST_AMT ,0)  * FM_RT.CONV_XCH_RT/TO_RT.CONV_XCH_RT),2) AS TRGT_ACCL_USD" ).append("\n"); 
		query.append("          FROM SAC_TML_ACCL_COST_IF TRGT" ).append("\n"); 
		query.append("             , SAC_DLY_XCH_RT       FM_RT" ).append("\n"); 
		query.append("             , SAC_DLY_XCH_RT       TO_RT" ).append("\n"); 
		query.append("         WHERE TRGT.EXE_YRMON           = REPLACE(@[accl_yrmon], '-', '')" ).append("\n"); 
		query.append("           AND NVL(TRGT.CXL_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("           AND FM_RT.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("           AND FM_RT.FM_CURR_CD         = TRGT.LOCL_CURR_CD" ).append("\n"); 
		query.append("           AND FM_RT.ACCT_XCH_RT_DT     = SUBSTR(TO_CHAR(TRGT.ACT_DT,'YYYYMMDD'),1,8)" ).append("\n"); 
		query.append("           AND TO_RT.ACCT_XCH_RT_DT     = SUBSTR(TO_CHAR(TRGT.ACT_DT,'YYYYMMDD'),1,8)" ).append("\n"); 
		query.append("           AND TO_RT.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("           AND TO_RT.FM_CURR_CD         = @[locl_curr_cd]" ).append("\n"); 
		query.append("#if( ${trd_cd} !='')" ).append("\n"); 
		query.append("           AND NVL(TRGT.TRD_CD, 'NON_TRD') = @[trd_cd] -- Trade" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${acct_cd} !='')" ).append("\n"); 
		query.append("           AND TRGT.ACCT_CD             = @[acct_cd] -- Account" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(TO_CHAR(TRGT.ACT_DT,'YYYYMMDD'),1,6)" ).append("\n"); 
		query.append("             , TRGT.ACCT_CD" ).append("\n"); 
		query.append("             , NVL(TRGT.TRD_CD, 'NON_TRD')" ).append("\n"); 
		query.append("             , TRGT.LOCL_CURR_CD     " ).append("\n"); 
		query.append("       ) TRGT" ).append("\n"); 
		query.append(" WHERE 1=1  " ).append("\n"); 
		query.append("   AND ACCL.ACT_MONTH       (+)= TRGT.ACT_MONTH    " ).append("\n"); 
		query.append("   AND ACCL.ACCT_CD         (+)= TRGT.ACCT_CD      " ).append("\n"); 
		query.append("   AND ACCL.TRD_CD          (+)= TRGT.TRD_CD       " ).append("\n"); 
		query.append("   AND ACCL.LOCL_CURR_CD    (+)= TRGT.LOCL_CURR_CD " ).append("\n"); 
		query.append(" GROUP BY TRGT.ACT_MONTH" ).append("\n"); 
		query.append(" ORDER BY TRGT.ACT_MONTH" ).append("\n"); 

	}
}