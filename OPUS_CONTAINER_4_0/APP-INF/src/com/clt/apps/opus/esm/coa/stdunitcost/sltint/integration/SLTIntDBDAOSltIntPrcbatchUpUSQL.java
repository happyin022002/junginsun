/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SLTIntDBDAOSltIntPrcbatchUpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SLTIntDBDAOSltIntPrcbatchUpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @20141224.SJH : COA_SLT_INTER_PRC_UT_COST의 EFF_TO_YRMON 일괄 업데이트
	  * -- 데이타가 비었거나 FM_MONTH 가 변경된경우
	  * @20150225.SJH. : 4003처럼 수정
	  * </pre>
	  */
	public SLTIntDBDAOSltIntPrcbatchUpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration").append("\n"); 
		query.append("FileName : SLTIntDBDAOSltIntPrcbatchUpUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SLT_INTER_PRC_UT_COST A" ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("      SELECT SLAN_CD, TRD_CD, SUB_TRD_CD, FM_CNT_CD, TO_CNT_CD, FM_PORT_CD, TO_PORT_CD, CGO_TP_CD, EFF_FM_YRMON, TO_YRMON" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT SLAN_CD, TRD_CD, SUB_TRD_CD, FM_CNT_CD, TO_CNT_CD, FM_PORT_CD, TO_PORT_CD, CGO_TP_CD, EFF_FM_YRMON, EFF_TO_YRMON" ).append("\n"); 
		query.append("                   , TO_CHAR(ADD_MONTHS(TO_DATE(LEAD(EFF_FM_YRMON,1) OVER (PARTITION BY SLAN_CD, TRD_CD, SUB_TRD_CD, FM_CNT_CD, TO_CNT_CD, FM_PORT_CD, TO_PORT_CD, CGO_TP_CD ORDER BY EFF_FM_YRMON), 'YYYYMM'),-1), 'YYYYMM') TO_YRMON" ).append("\n"); 
		query.append("              FROM COA_SLT_INTER_PRC_UT_COST" ).append("\n"); 
		query.append("			  WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("              ORDER BY SLAN_CD, TRD_CD, SUB_TRD_CD, FM_CNT_CD, TO_CNT_CD, FM_PORT_CD, TO_PORT_CD, CGO_TP_CD, EFF_FM_YRMON )" ).append("\n"); 
		query.append("      WHERE TO_YRMON IS NOT NULL" ).append("\n"); 
		query.append("        AND EFF_TO_YRMON IS NULL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (  A.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append("  AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("  AND A.FM_CNT_CD = B.FM_CNT_CD" ).append("\n"); 
		query.append("  AND A.TO_CNT_CD = B.TO_CNT_CD" ).append("\n"); 
		query.append("  AND A.FM_PORT_CD = B.FM_PORT_CD" ).append("\n"); 
		query.append("  AND A.TO_PORT_CD = B.TO_PORT_CD" ).append("\n"); 
		query.append("  AND A.CGO_TP_CD = B.CGO_TP_CD" ).append("\n"); 
		query.append("  AND A.EFF_FM_YRMON = B.EFF_FM_YRMON" ).append("\n"); 
		query.append("  AND A.DELT_FLG = 'N')" ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE " ).append("\n"); 
		query.append("    SET EFF_TO_YRMON = B.TO_YRMON" ).append("\n"); 

	}
}