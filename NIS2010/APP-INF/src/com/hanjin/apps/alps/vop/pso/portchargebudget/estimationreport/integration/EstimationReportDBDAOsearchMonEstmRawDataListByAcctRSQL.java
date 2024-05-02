/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EstimationReportDBDAOsearchMonEstmRawDataListByAcctRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.23 
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

public class EstimationReportDBDAOsearchMonEstmRawDataListByAcctRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추정결산 ACCT별 집계
	  * </pre>
	  */
	public EstimationReportDBDAOsearchMonEstmRawDataListByAcctRSQL(){
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
		query.append("FileName : EstimationReportDBDAOsearchMonEstmRawDataListByAcctRSQL").append("\n"); 
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
		query.append("SELECT T1.REV_YRMON," ).append("\n"); 
		query.append("       T2.RLANE_CD," ).append("\n"); 
		query.append("       T1.VSL_CD," ).append("\n"); 
		query.append("       T1.SKD_VOY_NO," ).append("\n"); 
		query.append("       T1.SKD_DIR_CD," ).append("\n"); 
		query.append("       T1.LOC_CD," ).append("\n"); 
		query.append("       T1.ACCT_CD," ).append("\n"); 
		query.append("       SUM(T1.ESTM_AMT) ESTM_AMT," ).append("\n"); 
		query.append("       SUM(T1.ACT_AMT) ACT_AMT," ).append("\n"); 
		query.append("       SUM(T1.ACCL_AMT) ACCL_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(T1.ACCT_CD, 511911, 0, T1.ESTM_AMT)) ESTM_PORT_AMT ," ).append("\n"); 
		query.append("       SUM(DECODE(T1.ACCT_CD, 511911, T1.ESTM_AMT, 0)) ESTM_CANAL_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(T1.ACCT_CD, 511911, 0, T1.ACT_AMT)) ACT_PORT_AMT ," ).append("\n"); 
		query.append("       SUM(DECODE(T1.ACCT_CD, 511911, T1.ACT_AMT, 0)) ACT_CANAL_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(T1.ACCT_CD, 511911, 0, T1.ACCL_AMT)) ACCL_PORT_AMT ," ).append("\n"); 
		query.append("       SUM(DECODE(T1.ACCT_CD, 511911, T1.ACCL_AMT, 0)) ACCL_CANAL_AMT," ).append("\n"); 
		query.append("       (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) CNTR_DZN_CAPA" ).append("\n"); 
		query.append("FROM   GL_ESTM_IF_ERP T1," ).append("\n"); 
		query.append("       GL_ESTM_REV_VVD T2" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("-- 결산 데이터 생성시에 추정 실행 년에 해당하는 정보를 모두 삭제 후 재 생성하기 때문에 실행월 이번달, 전달, 전년도로 검색할 필요가 없다. 2018-03-23" ).append("\n"); 
		query.append("#if (${raw_flg} != '')" ).append("\n"); 
		query.append("    #if (${raw_flg} == 'TM')" ).append("\n"); 
		query.append("        AND    T2.REV_YRMON =REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("    #elseif (${raw_flg} == 'PM')" ).append("\n"); 
		query.append("        AND T2.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("    #elseif (${raw_flg} == 'PY')" ).append("\n"); 
		query.append("        AND T2.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-12),'YYYYMM')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    T1.SYS_SRC_ID='PSO'" ).append("\n"); 
		query.append("AND    T1.EXE_YRMON=T2.EXE_YRMON" ).append("\n"); 
		query.append("AND    T1.REV_YRMON=T2.REV_YRMON" ).append("\n"); 
		query.append("AND    T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("AND    T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    T1.REV_DIR_CD=T2.REV_DIR_CD" ).append("\n"); 
		query.append("AND    T1.ESTM_VVD_TP_CD=T2.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("AND    T1.ESTM_IOC_DIV_CD=T2.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY T1.REV_YRMON, T2.RLANE_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.LOC_CD, T1.ACCT_CD" ).append("\n"); 
		query.append("ORDER BY T1.REV_YRMON, T2.RLANE_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.LOC_CD, T1.ACCT_CD" ).append("\n"); 

	}
}