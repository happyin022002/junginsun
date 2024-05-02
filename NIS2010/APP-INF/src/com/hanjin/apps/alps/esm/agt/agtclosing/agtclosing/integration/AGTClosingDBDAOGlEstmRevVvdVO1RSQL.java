/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTClosingDBDAOGlEstmRevVvdVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.02.09 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTClosingDBDAOGlEstmRevVvdVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimation Closing Report
	  * </pre>
	  */
	public AGTClosingDBDAOGlEstmRevVvdVO1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration").append("\n"); 
		query.append("FileName : AGTClosingDBDAOGlEstmRevVvdVO1RSQL").append("\n"); 
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
		query.append("SELECT /*+ PARALLEL(A, 16) */" ).append("\n"); 
		query.append("B.ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("A.RLANE_CD            AS LANE," ).append("\n"); 
		query.append("B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD || REV_DIR_CD AS VSL_DIR_CD," ).append("\n"); 
		query.append("B.ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("B.REV_YRMON," ).append("\n"); 
		query.append("SUM (A.ESTM_COMM_AMT) AS ESTM_COMM_AMT," ).append("\n"); 
		query.append("SUM (A.ACT_COMM_AMT)  AS ACT_COMM_AMT," ).append("\n"); 
		query.append("SUM (A.ACCL_COMM_AMT) AS ACCL_COMM_AMT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN 0 = SUM(A.ESTM_COMM_AMT) + SUM(A.ACCL_COMM_AMT)" ).append("\n"); 
		query.append("THEN 'New'" ).append("\n"); 
		query.append("WHEN 0 = SUM(A.ACT_COMM_AMT)" ).append("\n"); 
		query.append("THEN 'UnSettled'" ).append("\n"); 
		query.append("ELSE 'Adjusted'" ).append("\n"); 
		query.append("END                       AS COMM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_REV_VVD B," ).append("\n"); 
		query.append("AGT_ESTM_COMM_BKG_INFO A" ).append("\n"); 
		query.append("WHERE B.EXE_YRMON       = REPLACE(@[exe_yrmon], '-', '')" ).append("\n"); 
		query.append("AND B.EXE_YRMON       = A.ESTM_YRMON(+)" ).append("\n"); 
		query.append("AND B.REV_YRMON       = A.REV_YRMON(+)" ).append("\n"); 
		query.append("AND B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD || REV_DIR_CD = A.REV_VVD_CD(+)" ).append("\n"); 
		query.append("AND B.ESTM_IOC_DIV_CD = A.ESTM_IOC_DIV_CD(+)" ).append("\n"); 
		query.append("AND B.ESTM_VVD_TP_CD  = A.ESTM_VVD_TP_CD(+)" ).append("\n"); 
		query.append("AND B.ESTM_BC_DIV_CD  = 'C'" ).append("\n"); 
		query.append("GROUP BY B.ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("A.RLANE_CD," ).append("\n"); 
		query.append("B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD || REV_DIR_CD," ).append("\n"); 
		query.append("B.REV_YRMON," ).append("\n"); 
		query.append("B.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("ORDER BY 4, 1, 2, 3" ).append("\n"); 

	}
}