/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOGetMyPerformanceSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOGetMyPerformanceSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMyPerformanceSelect
	  * </pre>
	  */
	public CustomerEdiDBDAOGetMyPerformanceSelectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOGetMyPerformanceSelectRSQL").append("\n"); 
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
		query.append("R.EDI_GRP_CD" ).append("\n"); 
		query.append(", R.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(", R.EDI_GRP_DESC" ).append("\n"); 
		query.append(", R.EDI_CGO_RMK" ).append("\n"); 
		query.append(", SUBSTR(MAX(SYS_CONNECT_BY_PATH(R.RPT_COL_NM, ',')),2) EDI_STS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT C.EDI_GRP_CD" ).append("\n"); 
		query.append(", C.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(", C.EDI_GRP_DESC" ).append("\n"); 
		query.append(", C.EDI_CGO_RMK" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY C.EDI_GRP_CD ORDER BY RPT_COL_SEQ) RNUM" ).append("\n"); 
		query.append(", SUBSTR(F.RPT_COL_NM, 1, LENGTH(F.RPT_COL_NM)-2) RPT_COL_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EDI_USR_CUST C" ).append("\n"); 
		query.append(", SCE_PERF_RPT_FOM F" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${user_id} != '')" ).append("\n"); 
		query.append("AND C.CRE_USR_ID = @[user_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND C.EDI_STS_SEQ = 2" ).append("\n"); 
		query.append("AND C.CRE_USR_ID = F.CRE_USR_ID(+)" ).append("\n"); 
		query.append("AND C.EDI_GRP_CD = F.EDI_GRP_CD(+)" ).append("\n"); 
		query.append("AND F.EDI_STS_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND F.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("C.EDI_GRP_CD" ).append("\n"); 
		query.append(", C.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(", C.EDI_GRP_DESC" ).append("\n"); 
		query.append(", C.EDI_CGO_RMK" ).append("\n"); 
		query.append(", F.RPT_COL_NM" ).append("\n"); 
		query.append(", RPT_COL_SEQ" ).append("\n"); 
		query.append(") R" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("R.EDI_GRP_CD" ).append("\n"); 
		query.append(", R.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(", R.EDI_GRP_DESC" ).append("\n"); 
		query.append(", R.EDI_CGO_RMK" ).append("\n"); 
		query.append("START WITH RNUM = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR R.EDI_GRP_CD = R.EDI_GRP_CD" ).append("\n"); 

	}
}