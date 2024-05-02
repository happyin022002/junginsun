/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderInquiryDBDAOsearchWorkOrderInquiryAddCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInquiryDBDAOsearchWorkOrderInquiryAddCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderInquiry
	  * </pre>
	  */
	public WorkOrderInquiryDBDAOsearchWorkOrderInquiryAddCancelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration").append("\n"); 
		query.append("FileName : WorkOrderInquiryDBDAOsearchWorkOrderInquiryAddCancelRSQL").append("\n"); 
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
		query.append("       A.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("       DECODE(A.DTN_USE_FLG, 'Y', '1', '0') DTN_USE_FLG ," ).append("\n"); 
		query.append("       DECODE(A.WO_BL_NO_ISS_FLG, 'Y', '1', '0') WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD A, " ).append("\n"); 
		query.append("       TRS_TRSP_SO_HIS B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if($wo_no_a.size() > 0)  " ).append("\n"); 
		query.append("   AND (B.TRSP_WO_OFC_CTY_CD, B.TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${wo_no_a})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append(" 			(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("		   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4))  " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("   AND B.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND B.TRSP_SO_SEQ        = A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("GROUP BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, DTN_USE_FLG, WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($wo_no_a.size() < 1)  " ).append("\n"); 
		query.append("   AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}