/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EstimationReportDBDAOByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationReportDBDAOByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대상/진행 항차 Report 생성
	  * </pre>
	  */
	public EstimationReportDBDAOByVvdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration").append("\n"); 
		query.append("FileName : EstimationReportDBDAOByVvdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	MAX(E.REV_YRMON) REV_YRMON," ).append("\n"); 
		query.append("	MAX(E.RLANE_CD) RLANE_CD," ).append("\n"); 
		query.append("	E.VSL_CD || E.SKD_VOY_NO || E.SKD_DIR_CD || E.REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("	MAX(E.ESTM_VVD_TP_CD) ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("	SUM(DECODE(P.ACCT_CD, '511911', 0, ESTM_AMT)) AS PORT_AMT, " ).append("\n"); 
		query.append("	SUM(DECODE(P.ACCT_CD, '511911', ESTM_AMT, 0)) AS CANAL_AMT, " ).append("\n"); 
		query.append("	SUM(ESTM_AMT) AS TOTAL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM GL_ESTM_REV_VVD E, GL_ESTM_IF_ERP P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.EXE_YRMON = ( SELECT MAX(EXE_YRMON) FROM GL_ESTM_IF_ERP WHERE SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("#if (${estm_vvd_tp_cd} == '1') " ).append("\n"); 
		query.append("AND P.REV_YRMON = @[rev_yrmon] " ).append("\n"); 
		query.append("AND E.ESTM_VVD_TP_CD IN ('RV', 'BV') " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND P.REV_YRMON IN (SELECT  TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon] ,'YYYYMM'),1),'YYYYMM')  FROM DUAL)" ).append("\n"); 
		query.append("AND E.ESTM_VVD_TP_CD IN ('PV')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND P.EXE_YRMON = ( SELECT MAX(EXE_YRMON) FROM GL_ESTM_IF_ERP WHERE SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("AND P.REV_YRMON = E.REV_YRMON" ).append("\n"); 
		query.append("AND E.EXE_YRMON = @[rev_yrmon] " ).append("\n"); 
		query.append("AND E.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("AND E.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("AND E.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("AND E.REV_DIR_CD = P.REV_DIR_CD" ).append("\n"); 
		query.append("--AND E.ESTM_VVD_TP_CD = P.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("AND P.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("AND E.ESTM_IOC_DIV_CD = P.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("GROUP BY E.VSL_CD, E.SKD_VOY_NO, E.SKD_DIR_CD, E.REV_DIR_CD" ).append("\n"); 
		query.append("ORDER BY RLANE_CD" ).append("\n"); 

	}
}