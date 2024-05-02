/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.02.11 장창수
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

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taxable Amount I/F Status popup 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFStatusVORSQL(){
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
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFStatusVORSQL").append("\n"); 
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
		query.append("SELECT TRD_CD" ).append("\n"); 
		query.append(",TONG_ITM_CD" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CFM_USR_ID" ).append("\n"); 
		query.append(",N1ST_CFM_DT" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT X.TRD_CD" ).append("\n"); 
		query.append(",X.TRD_NUM" ).append("\n"); 
		query.append(",X.CODE             TONG_ITM_CD" ).append("\n"); 
		query.append(",NVL(Y.CFM_FLG,'N') CFM_FLG" ).append("\n"); 
		query.append(",Y.CFM_USR_ID" ).append("\n"); 
		query.append(",Y.N1ST_CFM_DT" ).append("\n"); 
		query.append(",Y.CFM_DT" ).append("\n"); 
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
		query.append("SELECT TRD_CD, ROWNUM TRD_NUM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT(TRD_CD) TRD_CD" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(SELECT A.TRD_CD" ).append("\n"); 
		query.append(",A.TONG_ITM_CD" ).append("\n"); 
		query.append(",A.CFM_USR_ID" ).append("\n"); 
		query.append(",A.CFM_FLG" ).append("\n"); 
		query.append(",A.CFM_DT" ).append("\n"); 
		query.append(", DECODE(B.N1ST_CFM_DT, NULL, A.N1ST_CFM_DT,B.N1ST_CFM_DT)  N1ST_CFM_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT  TRD_CD" ).append("\n"); 
		query.append(",   TONG_ITM_CD" ).append("\n"); 
		query.append(",   CFM_USR_ID" ).append("\n"); 
		query.append(",   CFM_FLG" ).append("\n"); 
		query.append(",   CFM_DT" ).append("\n"); 
		query.append(",   N1ST_CFM_DT" ).append("\n"); 
		query.append("FROM TOT_STL_CFM" ).append("\n"); 
		query.append("WHERE TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("AND STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT TRD_CD" ).append("\n"); 
		query.append(",   TONG_ITM_CD" ).append("\n"); 
		query.append(",   CFM_USR_ID" ).append("\n"); 
		query.append(",   CFM_FLG" ).append("\n"); 
		query.append(",   N1ST_CFM_DT" ).append("\n"); 
		query.append("FROM TOT_STL_CFM" ).append("\n"); 
		query.append("WHERE TONG_STL_BAT_JB_SEQ = (SELECT MIN(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("AND STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.TRD_CD = B.TRD_CD (+)" ).append("\n"); 
		query.append("AND A.TONG_ITM_CD = B.TONG_ITM_CD (+)" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.CODE = Y.TONG_ITM_CD(+)" ).append("\n"); 
		query.append("AND   X.TRD_CD = Y.TRD_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TRD_CD" ).append("\n"); 
		query.append(", 99 TRD_NUM" ).append("\n"); 
		query.append(",TONG_ITM_CD" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CFM_USR_ID" ).append("\n"); 
		query.append(",MIN(N1ST_CFM_DT)  N1ST_CFM_DT" ).append("\n"); 
		query.append(",MAX(CFM_DT)       CFM_DT" ).append("\n"); 
		query.append(", 1  SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'ERP I/F'     TRD_CD" ).append("\n"); 
		query.append(",''            TONG_ITM_CD" ).append("\n"); 
		query.append(",'Y'           CFM_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID    CFM_USR_ID" ).append("\n"); 
		query.append(",CRE_DT        N1ST_CFM_DT" ).append("\n"); 
		query.append(",CRE_DT        CFM_DT" ).append("\n"); 
		query.append("FROM TOT_ERP_IF" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND 0 < (SELECT COUNT(*) FROM TOT_ERP_IF WHERE STL_YRMON =@[stl_yrmon])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY  TRD_CD, TONG_ITM_CD, CFM_FLG, CFM_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ERP I/F'     TRD_CD" ).append("\n"); 
		query.append(", 99 TRD_NUM" ).append("\n"); 
		query.append(",''            TONG_ITM_CD" ).append("\n"); 
		query.append(",'N'           CFM_FLG" ).append("\n"); 
		query.append(",''            CFM_USR_ID" ).append("\n"); 
		query.append(",NULL            N1ST_CFM_DT" ).append("\n"); 
		query.append(",NULL          CFM_DT" ).append("\n"); 
		query.append(", 1  SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE 0 = (SELECT COUNT(*) FROM TOT_ERP_IF WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY TRD_NUM, SEQ ASC" ).append("\n"); 

	}
}