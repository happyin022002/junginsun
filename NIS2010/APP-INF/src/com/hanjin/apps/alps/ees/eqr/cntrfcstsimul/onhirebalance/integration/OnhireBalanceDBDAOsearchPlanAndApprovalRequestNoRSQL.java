/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireBalanceDBDAOsearchPlanAndApprovalRequestNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.12
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.11.12 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireBalanceDBDAOsearchPlanAndApprovalRequestNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_ONH_PLN_APRO 에서 새로운 LSE_RQST_NO 를 채번한다.
	  * </pre>
	  */
	public OnhireBalanceDBDAOsearchPlanAndApprovalRequestNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOsearchPlanAndApprovalRequestNoRSQL").append("\n"); 
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
		query.append("-- LSE_RQST_NO " ).append("\n"); 
		query.append("-- Request No. 구조 : R-(LCC_CD뒷 세자리)(TERM 두 자리)(YYYYMMDD)-001" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'R-'||SUBSTR(@[lcc_cd],3,3)||@[eq_lstm_cd]||TO_CHAR(SYSDATE,'YYYYMMDD')||'-'||LPAD(NVL(MAX(SUBSTR(LSE_RQST_NO,17,3)),0)+1,3,'0') LSE_RQST_NO" ).append("\n"); 
		query.append("FROM   EQR_CTRL_ONH_PLN_APRO  " ).append("\n"); 
		query.append("WHERE  SUBSTR(LSE_RQST_NO,1,16) = 'R-'||SUBSTR(@[lcc_cd],3,3)||@[eq_lstm_cd]||TO_CHAR(SYSDATE,'YYYYMMDD')||'-'" ).append("\n"); 

	}
}