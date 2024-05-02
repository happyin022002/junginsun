/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BATManagementDBDAOSearchSimBatchManagementListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.batmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BATManagementDBDAOSearchSimBatchManagementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Simulation Batch List 정보를 조회한다.
	  * </pre>
	  */
	public BATManagementDBDAOSearchSimBatchManagementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.batmanagement.integration").append("\n");
		query.append("FileName : BATManagementDBDAOSearchSimBatchManagementListRSQL").append("\n");
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
		query.append("    BAT_ITM_NM," ).append("\n");
		query.append("    CRE_USR_ID," ).append("\n");
		query.append("    COMM_TP_CD," ).append("\n");
		query.append("    N_CNT," ).append("\n");
		query.append("    COM_CNT," ).append("\n");
		query.append("    TOT_BKG_CNT," ).append("\n");
		query.append("    STAT_DT," ).append("\n");
		query.append("    STAT_TM," ).append("\n");
		query.append("    BAT_DESC" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("    SELECT" ).append("\n");
		query.append("          A.BAT_ITM_NM," ).append("\n");
		query.append("          A.CRE_USR_ID," ).append("\n");
		query.append("          A.COMM_TP_CD," ).append("\n");
		query.append("          SUM(CASE WHEN A.BAT_FLG = 'N' THEN 1 ELSE 0 END) AS N_CNT," ).append("\n");
		query.append("          SUM(CASE WHEN A.BAT_END_DT IS NOT NULL THEN 1 ELSE 0 END) AS COM_CNT," ).append("\n");
		query.append("          COUNT(A.BKG_NO) AS TOT_BKG_CNT," ).append("\n");
		query.append("          TO_CHAR( MIN(CASE WHEN A.BAT_FLG IN ('P','Y') THEN A.UPD_DT ELSE NULL END), 'YYYY-MM-DD' ) AS STAT_DT," ).append("\n");
		query.append("          TO_CHAR( MIN(CASE WHEN A.BAT_FLG IN ('P','Y') THEN A.UPD_DT ELSE NULL END), 'HH24:MI'    ) AS STAT_TM," ).append("\n");
		query.append("          A.BAT_DESC," ).append("\n");
		query.append("          MAX(A.CRE_DT) AS CRE_DT" ).append("\n");
		query.append("    FROM  ACM_CALC_BAT A" ).append("\n");
		query.append("    WHERE COMM_TP_CD = 'S'" ).append("\n");
		query.append("    AND   BAT_FLG   <> 'X' " ).append("\n");
		query.append("    GROUP BY A.CRE_USR_ID, A.COMM_TP_CD, A.BAT_DESC, A.BAT_ITM_NM" ).append("\n");
		query.append(")" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND   COM_CNT <> TOT_BKG_CNT" ).append("\n");
		query.append("ORDER BY CRE_DT,CRE_USR_ID" ).append("\n");

	}
}