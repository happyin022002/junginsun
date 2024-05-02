/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OnhireBalanceDBDAOmodifyOnhireStatusUSQL.java
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

public class OnhireBalanceDBDAOmodifyOnhireStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UPDATE EQR_CTRL_ONH_ORD
	  * </pre>
	  */
	public OnhireBalanceDBDAOmodifyOnhireStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_prd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("onh_ord_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_ord_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOmodifyOnhireStatusUSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_CTRL_ONH_ORD" ).append("\n"); 
		query.append("USING DUAL   " ).append("\n"); 
		query.append("ON (     ONH_ORD_YR  = @[onh_ord_yr]               " ).append("\n"); 
		query.append("     AND LCC_CD      = @[lcc_cd]                   " ).append("\n"); 
		query.append("     AND EQ_LSTM_CD  = @[eq_lstm_cd]               " ).append("\n"); 
		query.append("     AND LSE_PRD_SEQ = @[lse_prd_seq] )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET ONH_ORD_RMK = @[onh_ord_rmk]" ).append("\n"); 
		query.append("              , UPD_USR_ID  = @[upd_usr_id] " ).append("\n"); 
		query.append("              , UPD_DT      = SYSDATE  " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN     " ).append("\n"); 
		query.append("     INSERT ( ONH_ORD_YR" ).append("\n"); 
		query.append("            , LCC_CD" ).append("\n"); 
		query.append("            , EQ_LSTM_CD" ).append("\n"); 
		query.append("            , LSE_PRD_SEQ" ).append("\n"); 
		query.append("            , RCC_CD" ).append("\n"); 
		query.append("            , ONH_ORD_RMK" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT )" ).append("\n"); 
		query.append("     VALUES ( @[onh_ord_yr]" ).append("\n"); 
		query.append("            , @[lcc_cd]" ).append("\n"); 
		query.append("            , @[eq_lstm_cd]" ).append("\n"); 
		query.append("            , @[lse_prd_seq]" ).append("\n"); 
		query.append("            , @[rcc_cd]" ).append("\n"); 
		query.append("            , @[onh_ord_rmk]" ).append("\n"); 
		query.append("            , @[cre_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE )" ).append("\n"); 

	}
}