/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ActualCostCSRManageDBDAOSearchActualCostCsrListByGLMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCSRManageDBDAOSearchActualCostCsrListByGLMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL Month 별 CSR List
	  * </pre>
	  */
	public ActualCostCSRManageDBDAOSearchActualCostCsrListByGLMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_csr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gl_mon_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sys_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCSRManageDBDAOSearchActualCostCsrListByGLMonthRSQL").append("\n"); 
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
		query.append("SELECT B.EXE_YRMON, " ).append("\n"); 
		query.append("       B.CSR_NO, " ).append("\n"); 
		query.append("       B.INV_SYS_ID, " ).append("\n"); 
		query.append("       B.CTRL_OFC_CD, " ).append("\n"); 
		query.append("       A.INV_DT, " ).append("\n"); 
		query.append("       B.COA_COST_SRC_CD," ).append("\n"); 
		query.append("       X.LGS_COST_FULL_NM COST_DESC,  " ).append("\n"); 
		query.append("       B.LOCL_CURR_CD," ).append("\n"); 
		query.append("       SUM(B.LOCL_COST_AMT) COST_AMT, " ).append("\n"); 
		query.append("       ROUND(SUM(B.LOCL_COST_AMT)/R.USD_LOCL_XCH_RT , 2) AS USD_AMT," ).append("\n"); 
		query.append("       A.ACCT_XCH_RT_YRMON AS XCH_RT_YRMON" ).append("\n"); 
		query.append("FROM   AP_INV_HDR A, " ).append("\n"); 
		query.append("       LEA_ACT_COST_IF B, " ).append("\n"); 
		query.append("       GL_MON_XCH_RT R," ).append("\n"); 
		query.append("       LEA_LGS_COST X" ).append("\n"); 
		query.append("#if (${f_acbm_flag} == 'Y')" ).append("\n"); 
		query.append("      , LEA_YRY_COST_BUD Y" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("  AND B.EXE_YRMON  = REPLACE(@[gl_mon_from],'-','')" ).append("\n"); 
		query.append("  AND A.CSR_NO = B.CSR_NO " ).append("\n"); 
		query.append("  AND B.COA_COST_SRC_CD  = X.COA_COST_SRC_CD " ).append("\n"); 
		query.append("#if (${f_sys_id} != '') " ).append("\n"); 
		query.append("  AND B.INV_SYS_ID = @[f_sys_id] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND B.EXE_YRMON = R.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("  AND R.ACCT_XCH_RT_LVL(+) = 3" ).append("\n"); 
		query.append("  AND R.CURR_CD(+) = B.LOCL_CURR_CD" ).append("\n"); 
		query.append("#if (${f_acbm_flag} == 'Y')" ).append("\n"); 
		query.append("  AND Y.BSE_YR  = SUBSTR(B.EXE_YRMON,1,4) - 1 " ).append("\n"); 
		query.append("  --AND Y.CTRL_OFC_CD = B.CTRL_OFC_CD" ).append("\n"); 
		query.append("  AND Y.CTRL_OFC_CD = DECODE(B.CTRL_OFC_CD ,'PUSBS','PUSSC','PUSBO','PUSSC','SKGBA', 'PIRBA', B.CTRL_OFC_CD)" ).append("\n"); 
		query.append("  AND Y.COA_COST_SRC_CD = B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ctrl_ofc_cd} != '') " ).append("\n"); 
		query.append("  AND B.CTRL_OFC_CD =  @[f_ctrl_ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_ctrl_ofc_cd} == '')  " ).append("\n"); 
		query.append("  AND B.CTRL_OFC_CD IN ( SELECT YY.CTRL_OFC_CD" ).append("\n"); 
		query.append("                          FROM( SELECT DISTINCT" ).append("\n"); 
		query.append("                            	CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SHARC' --('SELTOB','SELCOE') THEN 'SHAAS'" ).append("\n"); 
		query.append("                                     ELSE XX.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                END AS RHQ_CD" ).append("\n"); 
		query.append("       		                  , XX.OFC_CD AS CTRL_OFC_CD" ).append("\n"); 
		query.append("                  	          FROM( SELECT *" ).append("\n"); 
		query.append("                                FROM( SELECT L.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                            ,L.OFC_CD" ).append("\n"); 
		query.append("                                            ,L.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("                                            ,ROW_NUMBER() OVER (PARTITION BY L.OFC_CD ORDER BY L.OFC_APLY_TO_YRMON DESC) OFC_ORDER" ).append("\n"); 
		query.append("                                      FROM  MAS_OFC_LVL L" ).append("\n"); 
		query.append("                                      WHERE  L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                                        AND  L.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                                  ) X" ).append("\n"); 
		query.append("                                WHERE X.OFC_ORDER = 1" ).append("\n"); 
		query.append("                                 ) XX" ).append("\n"); 
		query.append("                            ) YY " ).append("\n"); 
		query.append("                         WHERE YY.RHQ_CD = @[f_rhq_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_coa_cost_src_cd} != '')  " ).append("\n"); 
		query.append(" AND B.COA_COST_SRC_CD LIKE @[f_coa_cost_src_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_csr_no} != '')  " ).append("\n"); 
		query.append(" AND B.CSR_NO LIKE @[f_csr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY B.EXE_YRMON, " ).append("\n"); 
		query.append("         B.CSR_NO, " ).append("\n"); 
		query.append("         B.INV_SYS_ID, " ).append("\n"); 
		query.append("         B.CTRL_OFC_CD, " ).append("\n"); 
		query.append("         A.INV_DT, " ).append("\n"); 
		query.append("         B.COA_COST_SRC_CD," ).append("\n"); 
		query.append("         X.LGS_COST_FULL_NM, " ).append("\n"); 
		query.append("         B.LOCL_CURR_CD, " ).append("\n"); 
		query.append("         A.ACCT_XCH_RT_YRMON, " ).append("\n"); 
		query.append("         B.LOCL_CURR_CD, " ).append("\n"); 
		query.append("         R.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("ORDER BY B.EXE_YRMON, " ).append("\n"); 
		query.append("         B.CSR_NO" ).append("\n"); 

	}
}