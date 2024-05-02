/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchErpDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.30 
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

public class BudgetPortChargeMgtBCDBDAOsearchErpDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP로 I/F된 항비 상세 목록을 조회한다.
	  * ====================================
	  * 2011.04.25 CHM-201110288-01 진마리아 1월 조회시 전년도 12월 정보를 필터링하여 제외
	  * 2012.02.01 CHM-201215463-01 진마리아 추정 대상월과 생성월 관계에 대한 로직 수정
	  * 2014.06.13 CHM-201430702 이윤정 Vessel particular내 Desion capacity값이 보이도록 Down Excel내 칼럼 추가
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOsearchErpDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOsearchErpDtlRSQL").append("\n"); 
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
		query.append(" EXE_YRMON" ).append("\n"); 
		query.append(",SYS_SRC_ID" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",ESTM_SEQ_NO" ).append("\n"); 
		query.append(",RLANE REV_LANE" ).append("\n"); 
		query.append(",LOC_CD PORT" ).append("\n"); 
		query.append(",RVVD REV_VVD" ).append("\n"); 
		query.append(",DCAPA" ).append("\n"); 
		query.append(",ESTM_AMT" ).append("\n"); 
		query.append(",ACT_AMT" ).append("\n"); 
		query.append(",ACCL_AMT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' sdt" ).append("\n"); 
		query.append(",'' edt" ).append("\n"); 
		query.append(",'' match_flag" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("    SELECT  EXE_YRMON, REV_YRMON,  ACCT_CD" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("                select RLANE_CD from AR_MST_REV_VVD A " ).append("\n"); 
		query.append("                where   A.VSL_CD     = G.VSL_CD" ).append("\n"); 
		query.append("                AND     A.SKD_VOY_NO = G.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     A.SKD_DIR_CD = G.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     A.RLANE_DIR_CD = G.REV_DIR_CD" ).append("\n"); 
		query.append("                and     rownum = 1" ).append("\n"); 
		query.append("                ) RLANE" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("                SELECT CNTR_DZN_CAPA" ).append("\n"); 
		query.append("                FROM  MDM_VSL_CNTR M" ).append("\n"); 
		query.append("                WHERE M.VSL_CD = G.VSL_CD" ).append("\n"); 
		query.append("                AND   M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                ) DCAPA" ).append("\n"); 
		query.append("            ,LOC_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD RVVD, ESTM_AMT, ACT_AMT, ACCL_AMT, ESTM_SEQ_NO" ).append("\n"); 
		query.append("			,SYS_SRC_ID" ).append("\n"); 
		query.append("    FROM    GL_ESTM_IF_ERP G" ).append("\n"); 
		query.append("    WHERE   1=1" ).append("\n"); 
		query.append("    --AND G.EXE_YRMON LIKE TO_CHAR(SYSDATE, 'YYYY')||'%'" ).append("\n"); 
		query.append("    #if( ${sdt} != '' )" ).append("\n"); 
		query.append("    AND G.EXE_YRMON LIKE SUBSTR(REPLACE(@[edt], '-', ''),1,4)||'%'" ).append("\n"); 
		query.append("    AND G.REV_YRMON BETWEEN replace(@[sdt], '-', '') AND replace(@[edt], '-', '')" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if( $acct_cd_list.size() > 0)" ).append("\n"); 
		query.append("	AND G.ACCT_CD IN" ).append("\n"); 
		query.append("	    (" ).append("\n"); 
		query.append("			#foreach( $acct_cd in ${acct_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $acct_cd_list.size()) '$acct_cd', #else '$acct_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND     G.SYS_SRC_ID  = 'PSO'" ).append("\n"); 
		query.append("    #if( ${match_flag} == 'match' )" ).append("\n"); 
		query.append("    -- Matched" ).append("\n"); 
		query.append("    AND     G.ACCL_AMT    = 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if( ${match_flag} == 'unmatch' )" ).append("\n"); 
		query.append("    -- UNMatched" ).append("\n"); 
		query.append("    AND     G.ACCL_AMT    <> 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY EXE_YRMON, REV_YRMON,  ACCT_CD, RLANE, LOC_CD, RVVD" ).append("\n"); 

	}
}