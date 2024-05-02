/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SalesActivityManageDBDAOSearchActivityInputRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOSearchActivityInputRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Activity List 조회
	  * </pre>
	  */
	public SalesActivityManageDBDAOSearchActivityInputRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_rep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("customer_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("activity",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("team_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOSearchActivityInputRSQL").append("\n"); 
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
		query.append("SELECT A.SLS_ACT_SEQ ACTIVITY_NO" ).append("\n"); 
		query.append("      ,A.SREP_CD SLS_CODE" ).append("\n"); 
		query.append("      ,C.SREP_NM SLS_NAME" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD||TRIM(TO_CHAR(A.CUST_SEQ, '099999')) CUS_CODE" ).append("\n"); 
		query.append("      ,B.CUST_LGL_ENG_NM CUS_NAME" ).append("\n"); 
		query.append("      ,NVL2(A.SLS_MGR_CMT_DESC,'Y','N') MGR_COMMENT" ).append("\n"); 
		query.append("      ,D.SLS_ACT_SUB_TP_DESC PURPOSE" ).append("\n"); 
		query.append("      ,A.CALL_RPT_FLG CALL_REPORT" ).append("\n"); 
		query.append("      ,A.ACT_PLN_DT PLAN_DT" ).append("\n"); 
		query.append("      ,A.SLS_ACT_ACT_DT ACTUAL_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,A.SREP_CMT_DESC" ).append("\n"); 
		query.append("      ,A.SLS_MGR_CMT_DESC" ).append("\n"); 
		query.append("      ,A.SLS_ACT_TP_CD PURPOSE1" ).append("\n"); 
		query.append("      ,A.SLS_ACT_SUB_TP_CD PURPOSE2" ).append("\n"); 
		query.append("      ,A.ACT_CHNL_CD CHANNEL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SAM_SLS_ACT A" ).append("\n"); 
		query.append("    ,MDM_CUSTOMER B" ).append("\n"); 
		query.append("    ,MDM_SLS_REP C" ).append("\n"); 
		query.append("    ,SAM_SLS_ACT_TP_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SREP_CD = C.SREP_CD" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.SLS_ACT_SUB_TP_CD = D.SLS_ACT_SUB_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${office_cd} != '')" ).append("\n"); 
		query.append("--AND C.OFC_CD = [office_cd] --임시적으로 조건 제거. 20131008" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sales_rep_cd} != '')" ).append("\n"); 
		query.append("AND A.SREP_CD = @[sales_rep_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${team_cd} != '')" ).append("\n"); 
		query.append("AND C.OFC_TEAM_CD = @[team_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${status} == 'R')" ).append("\n"); 
		query.append("AND A.CRE_DT IS NOT NULL" ).append("\n"); 
		query.append("AND A.ACT_PLN_DT IS NULL" ).append("\n"); 
		query.append("AND A.SLS_ACT_ACT_DT IS NULL" ).append("\n"); 
		query.append("#elseif(${status} == 'O')" ).append("\n"); 
		query.append("AND A.CRE_DT IS NOT NULL" ).append("\n"); 
		query.append("AND A.ACT_PLN_DT IS NOT NULL" ).append("\n"); 
		query.append("AND A.SLS_ACT_ACT_DT IS NULL " ).append("\n"); 
		query.append("#elseif(${status} == 'P')" ).append("\n"); 
		query.append("AND A.CRE_DT IS NOT NULL" ).append("\n"); 
		query.append("AND A.ACT_PLN_DT < SYSDATE " ).append("\n"); 
		query.append("#elseif(${status} == 'C')" ).append("\n"); 
		query.append("AND A.SLS_ACT_ACT_DT IS NOT NULL" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${search_type} == 'P')" ).append("\n"); 
		query.append("	 AND A.ACT_PLN_DT IS NOT NULL" ).append("\n"); 
		query.append("    #if(${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("     AND A.ACT_PLN_DT BETWEEN @[from_date] AND @[to_date]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#elseif(${search_type} == 'C')" ).append("\n"); 
		query.append("	 AND A.CRE_DT IS NOT NULL" ).append("\n"); 
		query.append("    #if(${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("     AND A.CRE_DT BETWEEN @[from_date] AND @[to_date]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif(${search_type} == 'A')" ).append("\n"); 
		query.append("	 AND A.SLS_ACT_ACT_DT IS NOT NULL" ).append("\n"); 
		query.append("    #if(${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("     AND A.SLS_ACT_ACT_DT BETWEEN @[from_date] AND @[to_date]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${activity} != '')" ).append("\n"); 
		query.append("AND A.SLS_ACT_SEQ = @[activity] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${customer_cd} != '')" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = SUBSTR(@[customer_cd],1,2)  " ).append("\n"); 
		query.append("AND A.CUST_SEQ = SUBSTR(@[customer_cd],3,8)  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.SLS_ACT_SEQ" ).append("\n"); 

	}
}