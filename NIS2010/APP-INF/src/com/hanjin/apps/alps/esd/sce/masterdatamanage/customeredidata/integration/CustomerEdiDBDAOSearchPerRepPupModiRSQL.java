/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchPerRepPupModiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.14 
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

public class CustomerEdiDBDAOSearchPerRepPupModiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPerRepPupModi
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchPerRepPupModiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchPerRepPupModiRSQL").append("\n"); 
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
		query.append("SELECT DECODE(USE_FLG, 'Y',1,0) AS S_USE_FLG" ).append("\n"); 
		query.append("     , RPT_COL_SEQ S_RPT_COL_SEQ" ).append("\n"); 
		query.append("     , RPT_COL_NM S_RPT_COL_NM" ).append("\n"); 
		query.append("     , CRE_USR_ID S_CRE_USR_ID" ).append("\n"); 
		query.append("     , EDI_GRP_CD S_EDI_GRP_CD" ).append("\n"); 
		query.append("     , RPT_COL_DESC S_RPT_COL_DESC" ).append("\n"); 
		query.append("     , EDI_STS_FLG S_EDI_STS_FLG" ).append("\n"); 
		query.append("     , '-' S_CUST_EDI_STS_CD" ).append("\n"); 
		query.append("     , 1 S_HIDDEN_FLG " ).append("\n"); 
		query.append("FROM SCE_PERF_RPT_FOM P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.EDI_STS_FLG = 'N'" ).append("\n"); 
		query.append("AND P.CRE_USR_ID =  @[cre_usr_id]" ).append("\n"); 
		query.append("AND P.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  S_USE_FLG" ).append("\n"); 
		query.append(", S_RPT_COL_SEQ" ).append("\n"); 
		query.append(", S_RPT_COL_NM" ).append("\n"); 
		query.append(", S_CRE_USR_ID" ).append("\n"); 
		query.append(", S_EDI_GRP_CD" ).append("\n"); 
		query.append(", S_RPT_COL_DESC" ).append("\n"); 
		query.append(", S_EDI_STS_FLG" ).append("\n"); 
		query.append(", SUBSTR(MAX(SYS_CONNECT_BY_PATH(S.S_CUST_EDI_STS_CD, ',')),2) S_CUST_EDI_STS_CD" ).append("\n"); 
		query.append(", S_HIDDEN_FLG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DECODE(USE_FLG, 'Y',1,0) AS S_USE_FLG" ).append("\n"); 
		query.append("     , RPT_COL_SEQ S_RPT_COL_SEQ" ).append("\n"); 
		query.append("     , RPT_COL_NM S_RPT_COL_NM" ).append("\n"); 
		query.append("     , CRE_USR_ID S_CRE_USR_ID" ).append("\n"); 
		query.append("     , P.EDI_GRP_CD S_EDI_GRP_CD" ).append("\n"); 
		query.append("     , RPT_COL_DESC S_RPT_COL_DESC" ).append("\n"); 
		query.append("     , EDI_STS_FLG S_EDI_STS_FLG" ).append("\n"); 
		query.append("     , E.CUST_EDI_STS_CD S_CUST_EDI_STS_CD" ).append("\n"); 
		query.append("     , DECODE(E.CUST_EDI_STS_CD, NULL, 0, 1) S_HIDDEN_FLG" ).append("\n"); 
		query.append("     , EDI_STS_SEQ" ).append("\n"); 
		query.append("     , ROW_NUMBER() OVER (PARTITION BY RPT_COL_SEQ ORDER BY EDI_STS_SEQ) RNUM" ).append("\n"); 
		query.append("FROM SCE_PERF_RPT_FOM P, EDI_GRP_CGO E" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.CRE_USR_ID =  @[cre_usr_id]" ).append("\n"); 
		query.append("AND P.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("AND P.EDI_STS_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND E.EDI_GRP_CD(+) = @[cs_grp_id]" ).append("\n"); 
		query.append("AND E.EDI_STND_STS_CD(+) = SUBSTR(RPT_COL_NM,1, LENGTH(RPT_COL_NM)-2)" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("  S_USE_FLG" ).append("\n"); 
		query.append(", S_RPT_COL_SEQ" ).append("\n"); 
		query.append(", S_RPT_COL_NM" ).append("\n"); 
		query.append(", S_CRE_USR_ID" ).append("\n"); 
		query.append(", S_EDI_GRP_CD" ).append("\n"); 
		query.append(", S_RPT_COL_DESC" ).append("\n"); 
		query.append(", S_EDI_STS_FLG" ).append("\n"); 
		query.append(", S_HIDDEN_FLG" ).append("\n"); 
		query.append("START WITH RNUM = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR S.S_RPT_COL_SEQ = S.S_RPT_COL_SEQ" ).append("\n"); 
		query.append("ORDER BY S_RPT_COL_SEQ" ).append("\n"); 

	}
}