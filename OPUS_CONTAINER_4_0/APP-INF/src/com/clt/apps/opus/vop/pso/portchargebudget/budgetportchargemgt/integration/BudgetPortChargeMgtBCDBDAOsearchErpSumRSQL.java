/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchErpSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOsearchErpSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchErpSum
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOsearchErpSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtedate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOsearchErpSumRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(ERP.ACT_DT,1,6) AS ACT_DT" ).append("\n"); 
		query.append("     , ERP.ACCT_CD" ).append("\n"); 
		query.append("     , SUM(ROUND(ERP.ESTM_AMT / RT.USD_LOCL_XCH_RT, 2)) AS ESTM_AMT" ).append("\n"); 
		query.append("     , SUM(ROUND(ERP.ACT_AMT  / RT.USD_LOCL_XCH_RT, 2)) AS ACT_AMT" ).append("\n"); 
		query.append("     , SUM(ROUND(ERP.ACCL_AMT / RT.USD_LOCL_XCH_RT, 2)) AS ACCL_AMT" ).append("\n"); 
		query.append("     , ERP.ACCT_DTL_CD AS COST_CD" ).append("\n"); 
		query.append("     , (SELECT MAX(X.LGS_COST_FULL_NM) FROM TES_LGS_COST X WHERE X.LGS_COST_CD = ERP.ACCT_DTL_CD) COST_NM" ).append("\n"); 
		query.append("  FROM GL_ESTM_IF_ERP ERP" ).append("\n"); 
		query.append("     , GL_MON_XCH_RT RT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ERP.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("   AND EXE_YRMON = REPLACE(@[exe_yrmon], '-', '') " ).append("\n"); 
		query.append("   #if( ${txtsdate} !='' && ${txtedate} !='' )" ).append("\n"); 
		query.append("   AND SUBSTR(ACT_DT,1,6) BETWEEN REPLACE(@[txtsdate], '-', '') AND REPLACE(@[txtedate], '-', '') " ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append("   #if( ${acct_cd} !='' )" ).append("\n"); 
		query.append("   AND ACCT_CD = @[acct_cd] " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND RT.ACCT_XCH_RT_YRMON = ERP.REV_YRMON" ).append("\n"); 
		query.append("   AND RT.ACCT_XCH_RT_LVL = NVL((SELECT ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("                                   FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                                  WHERE ACCT_XCH_RT_YRMON = ERP.REV_YRMON" ).append("\n"); 
		query.append("                                    AND CURR_CD = ERP.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                    AND ACCT_XCH_RT_LVL = '1' ), '1')" ).append("\n"); 
		query.append("   AND RT.CURR_CD = ERP.LOCL_CURR_CD " ).append("\n"); 
		query.append("  /*2016.04.18 Add : Accrual 대상 만 진행함.*/" ).append("\n"); 
		query.append("  AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                FROM SCO_AP_COST_ACT_INFO SACAI" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND SACAI.SRC_MDL_CD          = 'PSO'" ).append("\n"); 
		query.append("                  AND NVL(SACAI.ENBL_FLG, 'N')  = 'N'" ).append("\n"); 
		query.append("                  AND NVL(SACAI.ACCL_FLG, 'N')  = 'Y'" ).append("\n"); 
		query.append("                  AND SACAI.ACT_COST_CD         = ERP.ACCT_DTL_CD)" ).append("\n"); 
		query.append(" GROUP BY SUBSTR(ERP.ACT_DT,1,6), ERP.ACCT_CD, ERP.ACCT_DTL_CD" ).append("\n"); 
		query.append(" ORDER BY SUBSTR(ERP.ACT_DT,1,6), ERP.ACCT_CD, ERP.ACCT_DTL_CD" ).append("\n"); 

	}
}