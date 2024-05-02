/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtDBDAOsearchAgreementMenuDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.10.08 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAgreementMenuDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 어그리먼트 메뉴를 타입에 따라 동적으로 가져온다.
	  * </pre>
	  */
	public RateMgtDBDAOsearchAgreementMenuDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAgreementMenuDataRSQL").append("\n"); 
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
		query.append("SELECT SUBSTRB(B.PRNT_CD_ID,0,1) AS EQ_TYPE," ).append("\n"); 
		query.append("B.TAB_TITLE," ).append("\n"); 
		query.append("B.MNR_ORD_TP_CD," ).append("\n"); 
		query.append("MAX(B.MNR_CD_DP_SEQ) AS DP_SEQ," ).append("\n"); 
		query.append("B.TAB_TYPE," ).append("\n"); 
		query.append("B.COST_CD" ).append("\n"); 
		query.append("FROM (SELECT A.PRNT_CD_ID," ).append("\n"); 
		query.append("A.MNR_CD_DP_SEQ," ).append("\n"); 
		query.append("DECODE(SUBSTRB(A.MNR_CD_ID," ).append("\n"); 
		query.append("LENGTH(A.MNR_CD_ID) - 1," ).append("\n"); 
		query.append("LENGTH(A.MNR_CD_ID))," ).append("\n"); 
		query.append("'RC'," ).append("\n"); 
		query.append("'Repair'," ).append("\n"); 
		query.append("A.MNR_CD_DESC) AS TAB_TITLE," ).append("\n"); 
		query.append("A.MNR_ORD_TP_CD," ).append("\n"); 
		query.append("SUBSTRB(A.MNR_CD_ID,LENGTH(A.MNR_CD_ID) - 1,LENGTH(A.MNR_CD_ID)) AS TAB_TYPE," ).append("\n"); 
		query.append("DECODE(A.MNR_ORD_TP_CD,'LB','LB',A.MNR_CD_ID) AS COST_CD" ).append("\n"); 
		query.append("FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("WHERE A.PRNT_CD_ID IN (" ).append("\n"); 
		query.append("SELECT MNR_CD_ID || 'G' FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00002'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND AGMT_USE_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY A.PRNT_CD_ID, A.MNR_CD_DP_SEQ) B" ).append("\n"); 
		query.append("GROUP BY B.PRNT_CD_ID, B.TAB_TITLE, B.MNR_ORD_TP_CD, B.TAB_TYPE ,B.COST_CD" ).append("\n"); 
		query.append("ORDER BY B.PRNT_CD_ID, DP_SEQ" ).append("\n"); 

	}
}