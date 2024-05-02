/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchReqListTietleCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.10.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchReqListTietleCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면에 타이틀을 만들기 위한 값을 구하는 로직
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchReqListTietleCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchReqListTietleCodeRSQL").append("\n"); 
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
		query.append("WITH LV_REQ_LIST  AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.ONH_PLN_YRWK,A.LSE_RQST_NO,A.LSE_PLN_SEQ,B.LCC_CD,A.EQ_LSTM_CD,A.APRO_RMK,A.CRE_DT,B.CNTR_TPSZ_CD,B.CNTR_QTY" ).append("\n"); 
		query.append("FROM   EQR_CTRL_ONH_PLN_APRO A, EQR_CTRL_ONH_PLN_APRO_QTY B" ).append("\n"); 
		query.append("WHERE A.CRE_DT > SYSDATE - 15" ).append("\n"); 
		query.append("AND   A.ONH_PLN_YRWK=B.ONH_PLN_YRWK" ).append("\n"); 
		query.append("AND   A.LCC_CD = B.LCC_CD" ).append("\n"); 
		query.append("AND   A.EQ_LSTM_CD = B.EQ_LSTM_CD" ).append("\n"); 
		query.append("AND   A.LSE_PLN_SEQ = B.LSE_PLN_SEQ" ).append("\n"); 
		query.append("AND   B.CNTR_QTY > 0" ).append("\n"); 
		query.append("AND   A.LSE_RQST_NO NOT IN (SELECT LSE_RQST_NO FROM LSE_ONH_APRO WHERE LSE_RQST_NO IS NOT NULL AND DELT_FLG ='N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER(ORDER BY SEQ) SEQ, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(SELECT B.RPT_DP_SEQ" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ B" ).append("\n"); 
		query.append("WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   ROWNUM=1) SEQ" ).append("\n"); 
		query.append("FROM  LV_REQ_LIST A" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}