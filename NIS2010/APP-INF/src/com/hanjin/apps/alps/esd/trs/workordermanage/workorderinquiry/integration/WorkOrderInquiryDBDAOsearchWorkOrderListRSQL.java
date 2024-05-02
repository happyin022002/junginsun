/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderInquiryDBDAOsearchWorkOrderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.15 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInquiryDBDAOsearchWorkOrderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderList
	  * </pre>
	  */
	public WorkOrderInquiryDBDAOsearchWorkOrderListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration").append("\n"); 
		query.append("FileName : WorkOrderInquiryDBDAOsearchWorkOrderListRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_SO_OFC_CTY_CD ," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("DECODE(A.DTN_USE_FLG, 'Y', '1', '0') DTN_USE_FLG ," ).append("\n"); 
		query.append("DECODE(A.WO_BL_NO_ISS_FLG, 'Y', '1', '0') WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if($wo_no_a.size() > 0)" ).append("\n"); 
		query.append("AND (A.TRSP_WO_OFC_CTY_CD,A.TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach($code IN ${wo_no_a})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($wo_no_a.size() < 1)" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}