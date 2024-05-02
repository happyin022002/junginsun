/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchEqrReqListReqNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.19
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.12.19 채창호
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

public class OnhireApprovalDBDAOsearchEqrReqListReqNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth no로 reqNo와 total qty을 가져온다.
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchEqrReqListReqNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("authNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchEqrReqListReqNoDataRSQL").append("\n"); 
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
		query.append(",A.ONH_ORD_YR" ).append("\n"); 
		query.append("FROM   EQR_CTRL_ONH_PLN_APRO A, EQR_CTRL_ONH_PLN_APRO_QTY B" ).append("\n"); 
		query.append("WHERE A.CRE_DT > SYSDATE - 15" ).append("\n"); 
		query.append("AND   A.ONH_PLN_YRWK=B.ONH_PLN_YRWK" ).append("\n"); 
		query.append("AND   A.LCC_CD = B.LCC_CD" ).append("\n"); 
		query.append("AND   A.EQ_LSTM_CD = B.EQ_LSTM_CD" ).append("\n"); 
		query.append("AND   A.LSE_PLN_SEQ = B.LSE_PLN_SEQ" ).append("\n"); 
		query.append("AND   B.CNTR_QTY > 0" ).append("\n"); 
		query.append("AND   A.LSE_RQST_NO IN (SELECT LSE_RQST_NO FROM LSE_ONH_APRO WHERE CNTR_ONH_AUTH_NO = @[authNo] AND DELT_FLG ='N')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("REQNO," ).append("\n"); 
		query.append("LCC," ).append("\n"); 
		query.append("TERM," ).append("\n"); 
		query.append("REMARK," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("ORD_YR," ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("DECODE(QTY$key ,'0','','$key'||'|') ||" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(QTY$key ,'0','','$key') TITLELIST," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("QTY$key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("QTY$key," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("DECODE(QTY$key ,'0','','$key'||':'||QTY$key||',') ||" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(QTY$key ,'0','','$key'||':'||QTY$key) TOTALLIST," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("TOTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.LSE_RQST_NO REQNO," ).append("\n"); 
		query.append("A.LCC_CD LCC," ).append("\n"); 
		query.append("A.EQ_LSTM_CD TERM," ).append("\n"); 
		query.append("A.APRO_RMK REMARK ," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT ,'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("A.ONH_ORD_YR ORD_YR," ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("SUM(DECODE(A.CNTR_TPSZ_CD,'$key',A.CNTR_QTY,0)) QTY$key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SUM(DECODE(A.CNTR_TPSZ_CD,'$key',A.CNTR_QTY,0)) QTY$key," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("'$key'||':'||SUM(DECODE(A.CNTR_TPSZ_CD,'$key',A.CNTR_QTY,0)) ||','||" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'||':'||SUM(DECODE(A.CNTR_TPSZ_CD,'$key',A.CNTR_QTY,0)) TOTALlIST," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SUM(CNTR_QTY) TOTAL" ).append("\n"); 
		query.append("FROM LV_REQ_LIST A" ).append("\n"); 
		query.append("GROUP BY A.LSE_RQST_NO,A.LCC_CD,A.EQ_LSTM_CD,A.CRE_DT,A.APRO_RMK,A.ONH_ORD_YR" ).append("\n"); 
		query.append("ORDER BY LSE_RQST_NO,A.CRE_DT, LCC_CD,EQ_LSTM_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}