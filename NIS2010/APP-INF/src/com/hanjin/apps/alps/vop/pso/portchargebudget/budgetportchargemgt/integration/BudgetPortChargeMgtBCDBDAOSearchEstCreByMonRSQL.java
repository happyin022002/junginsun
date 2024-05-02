/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기준월에 해당하는 추정 대상 항차를 조회한다.
	  * ===============================================================
	  * CHM-201215463-01 진마리아 Retrieve시 비용 생성 여부 관계없이 대상 항차를 전부 조회하도록 변경
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL(){
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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL").append("\n"); 
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
		query.append("SELECT V.REV_YRMON" ).append("\n"); 
		query.append("               ,V.VSL_CD || V.SKD_VOY_NO || V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("			   ,V.VSL_CD" ).append("\n"); 
		query.append("               ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,V.REV_DIR_CD" ).append("\n"); 
		query.append("               ,V.RLANE_CD" ).append("\n"); 
		query.append("               ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("               ,MAX(E.CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("               ,DECODE(TO_CHAR(MAX(E.CRE_DT), 'YYYY-MM-DD')," ).append("\n"); 
		query.append("                       '1977-05-16'," ).append("\n"); 
		query.append("                       '2010-04-03 20:00'," ).append("\n"); 
		query.append("                       TO_CHAR(MAX(E.CRE_DT), 'YYYY-MM-DD HH24:MI')) CRE_DT" ).append("\n"); 
		query.append("				, V.ESTM_IOC_DIV_CD      " ).append("\n"); 
		query.append("--FROM   GL_ESTM_REV_VVD V" ).append("\n"); 
		query.append("FROM    (SELECT EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_VVD_TP_CD, MAX(ESTM_IOC_DIV_CD) AS ESTM_IOC_DIV_CD, MAX(RLANE_CD) AS RLANE_CD" ).append("\n"); 
		query.append("        FROM   GL_ESTM_REV_VVD V" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    V.EXE_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("		AND    V.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("        AND (REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD) NOT IN (SELECT REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("                                                                                        FROM   GL_ESTM_REV_VVD V" ).append("\n"); 
		query.append("                                                                                        WHERE  1=1" ).append("\n"); 
		query.append("                                                                                        AND    V.EXE_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("																						AND    V.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("                                                                                        AND ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("                                                                                        )" ).append("\n"); 
		query.append("        GROUP BY EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_VVD_TP_CD, ESTM_IOC_DIV_CD, RLANE_CD" ).append("\n"); 
		query.append("        FROM   GL_ESTM_REV_VVD V" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    V.EXE_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("		AND    V.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("        AND (REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD) IN (SELECT REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD" ).append("\n"); 
		query.append("                                                                                        FROM   GL_ESTM_REV_VVD V" ).append("\n"); 
		query.append("                                                                                        WHERE  1=1" ).append("\n"); 
		query.append("                                                                                        AND    V.EXE_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("																						AND    V.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("                                                                                        AND ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("                                                                                        )" ).append("\n"); 
		query.append("        AND ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("        ) V" ).append("\n"); 
		query.append("      ,PSO_TGT_YD_EXPN E" ).append("\n"); 
		query.append("      ,VSK_VSL_SKD     S" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR    M" ).append("\n"); 
		query.append("WHERE  E.PSO_BZTP_CD(+) = '2'" ).append("\n"); 
		query.append("AND    V.EXE_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND    V.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND    V.VSL_CD = E.VSL_CD(+)" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO = E.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD = E.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    V.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    V.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("AND    NVL(S.ACT_CRR_CD,M.CRR_CD) = 'SML'" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND    E.RLANE_CD LIKE @[vsl_slan_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("Group BY V.REV_YRMON" ).append("\n"); 
		query.append("		,V.VSL_CD" ).append("\n"); 
		query.append("        ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,V.REV_DIR_CD" ).append("\n"); 
		query.append("        ,V.RLANE_CD" ).append("\n"); 
		query.append("        ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("		, V.ESTM_IOC_DIV_CD      " ).append("\n"); 
		query.append("ORDER  BY REV_YRMON" ).append("\n"); 
		query.append("         ,V.VSL_CD" ).append("\n"); 
		query.append("         ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,V.SKD_DIR_CD" ).append("\n"); 

	}
}