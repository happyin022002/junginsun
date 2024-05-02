/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOSearchBudCreByMonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.05.04 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOSearchBudCreByMonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOSearchBudCreByMonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOSearchBudCreByMonRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(SUBSTR(A.BUD_SCNR_NO, 1, 4) || DECODE(INSTR(A.BUD_SCNR_NO, 'BP'), 0, 1, 2) || A.BUD_SCNR_NO), 6, 7) SCNR_NO" ).append("\n"); 
		query.append(",A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",A.RLANE_CD RLANE_CD" ).append("\n"); 
		query.append(",A.CNTR_VSL_CLSS_CAPA CAPA" ).append("\n"); 
		query.append(",SUBSTR(MAX(SUBSTR(A.BUD_SCNR_NO, 1, 4) || DECODE(INSTR(A.BUD_SCNR_NO, 'BP'), 0, 1, 2) || A.BUD_SCNR_NO || A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.RLANE_CD || A.BUD_YRMON), 26, 6) MON" ).append("\n"); 
		query.append(",SUBSTR(MAX(SUBSTR(A.BUD_SCNR_NO, 1, 4) || DECODE(INSTR(A.BUD_SCNR_NO, 'BP'), 0, 1, 2) || A.BUD_SCNR_NO || A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.RLANE_CD || B.CRE_USR_ID), 26) CRE_USR_ID" ).append("\n"); 
		query.append(",SUBSTR(MAX(SUBSTR(A.BUD_SCNR_NO, 1, 4) || DECODE(INSTR(A.BUD_SCNR_NO, 'BP'), 0, 1, 2) || A.BUD_SCNR_NO || A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.RLANE_CD || TO_CHAR(B.CRE_DT, 'YYYY-MM-DD HH24:MI')), 26) CRE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' LOCL_CURR_CD	--For Currency & Rate Grid" ).append("\n"); 
		query.append(",'' USD_XCH_RT	--For Currency & Rate Grid" ).append("\n"); 
		query.append("FROM   PSO_BUD_TGT_VVD A" ).append("\n"); 
		query.append(",PSO_TGT_YD_EXPN B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    B.PSO_BZTP_CD(+) = 1" ).append("\n"); 
		query.append("AND    A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD = B.RLANE_CD(+)" ).append("\n"); 
		query.append("AND    A.BUD_YRMON BETWEEN @[start_dt] AND @[end_dt]" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.RLANE_CD, A.CNTR_VSL_CLSS_CAPA, A.BUD_YRMON" ).append("\n"); 
		query.append("ORDER BY A.BUD_YRMON, A.RLANE_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CNTR_VSL_CLSS_CAPA" ).append("\n"); 

	}
}