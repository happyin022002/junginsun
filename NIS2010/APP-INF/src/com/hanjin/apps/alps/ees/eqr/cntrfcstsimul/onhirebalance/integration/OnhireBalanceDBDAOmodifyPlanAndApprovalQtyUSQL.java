/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireBalanceDBDAOmodifyPlanAndApprovalQtyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.19 문동선
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

public class OnhireBalanceDBDAOmodifyPlanAndApprovalQtyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_ONH_PLN_APRO_QTY 에 데이터를 UPDATE 한다
	  * </pre>
	  */
	public OnhireBalanceDBDAOmodifyPlanAndApprovalQtyUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOmodifyPlanAndApprovalQtyUSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_CTRL_ONH_PLN_APRO_QTY" ).append("\n"); 
		query.append("USING DUAL   " ).append("\n"); 
		query.append("ON (     ONH_PLN_YRWK = @[onh_pln_yrwk]" ).append("\n"); 
		query.append("     AND LCC_CD       = @[lcc_cd]      " ).append("\n"); 
		query.append("     AND EQ_LSTM_CD   = @[eq_lstm_cd]  " ).append("\n"); 
		query.append("     AND LSE_PLN_SEQ  = @[lse_pln_seq]  " ).append("\n"); 
		query.append("     AND CNTR_TPSZ_CD = @[cntr_tpsz_cd] )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET CNTR_QTY    = @[cntr_qty]" ).append("\n"); 
		query.append("              , UPD_USR_ID  = @[upd_usr_id] " ).append("\n"); 
		query.append("              , UPD_DT      = SYSDATE  " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN     " ).append("\n"); 
		query.append("     INSERT ( ONH_PLN_YRWK" ).append("\n"); 
		query.append("            , LCC_CD" ).append("\n"); 
		query.append("            , EQ_LSTM_CD" ).append("\n"); 
		query.append("            , LSE_PLN_SEQ" ).append("\n"); 
		query.append("            , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , CNTR_QTY" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT )" ).append("\n"); 
		query.append("     VALUES ( @[onh_pln_yrwk]" ).append("\n"); 
		query.append("            , @[lcc_cd]" ).append("\n"); 
		query.append("            , @[eq_lstm_cd]" ).append("\n"); 
		query.append("            , @[lse_pln_seq]" ).append("\n"); 
		query.append("            , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("            , @[cntr_qty]" ).append("\n"); 
		query.append("            , @[cre_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE )" ).append("\n"); 

	}
}