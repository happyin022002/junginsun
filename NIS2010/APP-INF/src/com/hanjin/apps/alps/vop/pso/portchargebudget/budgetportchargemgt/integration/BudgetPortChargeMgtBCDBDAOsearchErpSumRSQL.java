/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchErpSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.02 
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

public class BudgetPortChargeMgtBCDBDAOsearchErpSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP로 I/F된 항비 목록을 Revenue Month, Account Code별로 집계하여 조회한다.
	  * ==========================================================================
	  * CHM-201108564-01 진마리아 I/F to ERP화면내 조회 조건 추가
	  * 2011.04.25 CHM-201110288-01 진마리아 1월 조회시 전년도 12월 정보를 필터링하여 제외
	  * 2012.02.01 CHM-201215463-01 진마리아 추정 대상월과 생성월 관계에 대한 로직 수정
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" A.REV_YRMON" ).append("\n"); 
		query.append(",A.ACCT_CD" ).append("\n"); 
		query.append(",SUM(A.ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append(",SUM(A.ACT_AMT) ACT_AMT" ).append("\n"); 
		query.append(",SUM(A.ACCL_AMT) ACCL_AMT" ).append("\n"); 
		query.append(",'' txtsDate" ).append("\n"); 
		query.append(",'' txteDate" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${txtsdate} != '' && ${txtedate} != ''  )" ).append("\n"); 
		query.append("AND A.EXE_YRMON IN ( SELECT MAX(EXE_YRMON)  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                    WHERE REV_YRMON BETWEEN replace(@[txtsdate], '-', '') AND replace(@[txtedate], '-', '')" ).append("\n"); 
		query.append("                      AND SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("                      AND REV_YRMON = A.REV_YRMON  )" ).append("\n"); 
		query.append("AND A.REV_YRMON BETWEEN replace(@[txtsdate], '-', '') AND replace(@[txtedate], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( $acct_cd_list.size() > 0)" ).append("\n"); 
		query.append("AND A.ACCT_CD IN" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("		#foreach( $acct_cd in ${acct_cd_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $acct_cd_list.size()) '$acct_cd', #else '$acct_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("GROUP BY A.REV_YRMON, A.ACCT_CD" ).append("\n"); 
		query.append("ORDER BY A.REV_YRMON, A.ACCT_CD" ).append("\n"); 

	}
}