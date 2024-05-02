/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireBalanceDBDAOremovePlanAndApprovalDSQL.java
*@FileTitle : LT ST OW Plan & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.13
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.13 문동선
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

public class OnhireBalanceDBDAOremovePlanAndApprovalDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_ONH_PLN_APRO 에 데이터를 DELETE 한다
	  * </pre>
	  */
	public OnhireBalanceDBDAOremovePlanAndApprovalDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOremovePlanAndApprovalDSQL").append("\n"); 
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
		query.append("DELETE EQR_CTRL_ONH_PLN_APRO" ).append("\n"); 
		query.append(" WHERE ONH_PLN_YRWK = @[onh_pln_yrwk]" ).append("\n"); 
		query.append("   AND LCC_CD       = @[lcc_cd]      " ).append("\n"); 
		query.append("   AND EQ_LSTM_CD   = @[eq_lstm_cd]  " ).append("\n"); 
		query.append("   AND LSE_PLN_SEQ  = @[lse_pln_seq]" ).append("\n"); 

	}
}