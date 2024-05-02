/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderIssueDBDAOSearchBundlingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOSearchBundlingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBundlingList
	  * </pre>
	  */
	public WorkOrderIssueDBDAOSearchBundlingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOSearchBundlingListRSQL").append("\n"); 
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
		query.append("SELECT '' IBCHECK," ).append("\n"); 
		query.append("A.MCNTR_BDL_GRP_SEQ," ).append("\n"); 
		query.append("A.MCNTR_BDL_SEQ," ).append("\n"); 
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(NVL(A.MCNTR_BDL_SEQ,'N'),'N','N','Bundled') BUNDL_STS," ).append("\n"); 
		query.append("A.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("A.FM_NOD_CD," ).append("\n"); 
		query.append("A.TO_NOD_CD," ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ," ).append("\n"); 
		query.append("A.MTY_BDL_CNTR_QTY" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if($so_no_a.size() > 0)" ).append("\n"); 
		query.append("AND (A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach($code IN ${so_no_a})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($so_no_a.size() < 1)" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.EQ_TPSZ_CD, A.EQ_NO" ).append("\n"); 

	}
}