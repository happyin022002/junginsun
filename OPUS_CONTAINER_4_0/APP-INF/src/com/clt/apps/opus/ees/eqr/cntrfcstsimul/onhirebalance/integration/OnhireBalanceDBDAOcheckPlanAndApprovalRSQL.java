/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OnhireBalanceDBDAOcheckPlanAndApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.04.01 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireBalanceDBDAOcheckPlanAndApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check key value in EQR_CTRL_ONH_ORD
	  * </pre>
	  */
	public OnhireBalanceDBDAOcheckPlanAndApprovalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOcheckPlanAndApprovalRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CHK" ).append("\n"); 
		query.append("     , DECODE(COUNT(1),0,'',MAX(LSE_RQST_NO)) LSE_RQST_NO" ).append("\n"); 
		query.append("     , MAX(STS_CD) STS_CD " ).append("\n"); 
		query.append("FROM (      " ).append("\n"); 
		query.append("       SELECT A.LSE_RQST_NO" ).append("\n"); 
		query.append("            , CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'S'" ).append("\n"); 
		query.append("                   WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'R'" ).append("\n"); 
		query.append("                   WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN 'A'" ).append("\n"); 
		query.append("              END STS_CD " ).append("\n"); 
		query.append("       FROM   EQR_CTRL_ONH_PLN_APRO   A " ).append("\n"); 
		query.append("            ,(SELECT LSE_RQST_NO " ).append("\n"); 
		query.append("                   , CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("               FROM  LSE_ONH_APRO " ).append("\n"); 
		query.append("               WHERE DELT_FLG = 'N' ) C" ).append("\n"); 
		query.append("       WHERE  A.LSE_RQST_NO   = C.LSE_RQST_NO(+)" ).append("\n"); 
		query.append("       AND    A.ONH_PLN_YRWK  = @[onh_pln_yrwk]" ).append("\n"); 
		query.append("       AND    A.LCC_CD        = @[lcc_cd]      " ).append("\n"); 
		query.append("       AND    A.EQ_LSTM_CD    = @[eq_lstm_cd]  " ).append("\n"); 
		query.append("       AND    A.LSE_PLN_SEQ   = @[lse_pln_seq]" ).append("\n"); 
		query.append("       AND ROWNUM <= 1" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}