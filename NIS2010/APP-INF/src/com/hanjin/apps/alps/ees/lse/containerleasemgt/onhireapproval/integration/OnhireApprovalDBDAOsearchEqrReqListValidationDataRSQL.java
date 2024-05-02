/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchEqrReqListValidationDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchEqrReqListValidationDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR Req List의 typs별 total 과 실제 저장된 type별 totla 과 비교하여 같지 않은 경우는 에러 처리를 한다.
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchEqrReqListValidationDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reqno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchEqrReqListValidationDataRSQL").append("\n"); 
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
		query.append("SELECT A.LSE_RQST_NO," ).append("\n"); 
		query.append("       B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       B.CNTR_QTY" ).append("\n"); 
		query.append("FROM   EQR_CTRL_ONH_PLN_APRO A, EQR_CTRL_ONH_PLN_APRO_QTY B" ).append("\n"); 
		query.append("WHERE A.CRE_DT > SYSDATE - 15" ).append("\n"); 
		query.append("AND   A.ONH_PLN_YRWK=B.ONH_PLN_YRWK" ).append("\n"); 
		query.append("AND   A.LCC_CD = B.LCC_CD" ).append("\n"); 
		query.append("AND   A.EQ_LSTM_CD = B.EQ_LSTM_CD" ).append("\n"); 
		query.append("AND   A.LSE_PLN_SEQ = B.LSE_PLN_SEQ" ).append("\n"); 
		query.append("AND   A.LSE_RQST_NO =@[reqno]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("EQR_RQST_LIST_TOTAL AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.LSE_RQST_NO REQNO," ).append("\n"); 
		query.append(" #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("    #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("       SUM(DECODE(A.CNTR_TPSZ_CD,'$key',A.CNTR_QTY,0)) QTY$key," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       SUM(DECODE(A.CNTR_TPSZ_CD,'$key',A.CNTR_QTY,0)) QTY$key" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM LV_REQ_LIST A" ).append("\n"); 
		query.append("GROUP BY A.LSE_RQST_NO" ).append("\n"); 
		query.append("ORDER BY LSE_RQST_NO" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("LSE_RQST_LIST_TOTAL AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      LSE_RQST_NO REQNO," ).append("\n"); 
		query.append("       #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("           #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("               SUM(DECODE(TPSZ, '$key', QTY, 0)) QTY_$key," ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("               SUM(DECODE(TPSZ, '$key', QTY, 0)) QTY_$key" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("B.ONH_QTY QTY," ).append("\n"); 
		query.append("A.LSE_RQST_NO" ).append("\n"); 
		query.append("FROM LSE_ONH_APRO A," ).append("\n"); 
		query.append("LSE_ONH_APRO_QTY B" ).append("\n"); 
		query.append("WHERE A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("AND A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.LSE_RQST_NO = @[reqno] " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY LSE_RQST_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      A.REQNO," ).append("\n"); 
		query.append("      CASE WHEN" ).append("\n"); 
		query.append("      #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("           #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                A.QTY$key < QTY_$key OR" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("                 A.QTY$key < QTY_$key " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("      THEN 'E'" ).append("\n"); 
		query.append("      ELSE 'SU'" ).append("\n"); 
		query.append("      END REUSTT_FLG" ).append("\n"); 
		query.append("FROM EQR_RQST_LIST_TOTAL A," ).append("\n"); 
		query.append("     LSE_RQST_LIST_TOTAL B" ).append("\n"); 
		query.append("WHERE A.REQNO = B.REQNO" ).append("\n"); 

	}
}