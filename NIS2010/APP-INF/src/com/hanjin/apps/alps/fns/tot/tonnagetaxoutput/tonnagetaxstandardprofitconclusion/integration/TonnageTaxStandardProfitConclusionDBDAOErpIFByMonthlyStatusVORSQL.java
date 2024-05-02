/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.02.09 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP I/F(Montly) status 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyStatusVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyStatusVORSQL").append("\n"); 
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
		query.append("CASE WHEN COUNT(A.CFM_FLG) = 0 THEN" ).append("\n"); 
		query.append("'Completed'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'Processing'" ).append("\n"); 
		query.append("END                                                       STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT CFM_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT X.TRD_CD" ).append("\n"); 
		query.append(",X.CODE             TONG_ITM_CD" ).append("\n"); 
		query.append(",NVL(Y.CFM_FLG,'N') CFM_FLG" ).append("\n"); 
		query.append(",X.SEQ" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT 1 AS SEQ, 'NRT' CODE" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 3 AS SEQ, 'USE' CODE" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 2 AS SEQ, 'DYS' CODE" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TRD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT(TRD_CD) TRD_CD" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(SELECT  TRD_CD" ).append("\n"); 
		query.append(",   TONG_ITM_CD" ).append("\n"); 
		query.append(",   CFM_FLG" ).append("\n"); 
		query.append("FROM TOT_STL_CFM" ).append("\n"); 
		query.append("WHERE TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_STL_CFM WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("AND STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.CODE = Y.TONG_ITM_CD(+)" ).append("\n"); 
		query.append("AND   X.TRD_CD = Y.TRD_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.CFM_FLG ='N'" ).append("\n"); 

	}
}