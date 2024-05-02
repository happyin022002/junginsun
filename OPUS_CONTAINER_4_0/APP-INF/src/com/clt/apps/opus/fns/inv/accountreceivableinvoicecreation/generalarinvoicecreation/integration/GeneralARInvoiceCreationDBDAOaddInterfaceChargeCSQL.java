/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOaddInterfaceChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.28 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOaddInterfaceChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOaddInterfaceChargeCSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOaddInterfaceChargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("per_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tva_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOaddInterfaceChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_IF_CHG (" ).append("\n"); 
		query.append("SRC_IF_DT" ).append("\n"); 
		query.append(", SRC_IF_SEQ" ).append("\n"); 
		query.append(", CHG_SEQ" ).append("\n"); 
		query.append(", CHG_CD" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append(", CURR_CD -----" ).append("\n"); 
		query.append(", PER_TP_CD" ).append("\n"); 
		query.append(", TRF_RT_AMT" ).append("\n"); 
		query.append(", RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(", INV_XCH_RT" ).append("\n"); 
		query.append(", CHG_FULL_NM" ).append("\n"); 
		query.append(", TRF_NO" ).append("\n"); 
		query.append(", TVA_FLG" ).append("\n"); 
		query.append(", REP_CHG_CD" ).append("\n"); 
		query.append(", CHG_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID -----" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[src_if_dt]" ).append("\n"); 
		query.append(", @[src_if_seq]" ).append("\n"); 
		query.append(", (SELECT NVL(MAX(CHG_SEQ) + 1, 1)" ).append("\n"); 
		query.append("FROM INV_AR_IF_CHG" ).append("\n"); 
		query.append("WHERE SRC_IF_DT = @[src_if_dt]" ).append("\n"); 
		query.append("AND SRC_IF_SEQ = @[src_if_seq])" ).append("\n"); 
		query.append(", @[chg_cd]" ).append("\n"); 
		query.append(", NVL(@[chg_amt], 0)" ).append("\n"); 
		query.append(", @[curr_cd] -----" ).append("\n"); 
		query.append(", @[per_tp_cd]" ).append("\n"); 
		query.append(", ABS(NVL(@[trf_rt_amt], 0))" ).append("\n"); 
		query.append(", NVL(@[rat_as_cntr_qty], 0)" ).append("\n"); 
		query.append(", NVL(@[inv_xch_rt], 0)" ).append("\n"); 
		query.append(", @[chg_full_nm]" ).append("\n"); 
		query.append(", @[trf_no]" ).append("\n"); 
		query.append(", NVL(@[tva_flg], 'N')" ).append("\n"); 
		query.append(", @[rep_chg_cd]" ).append("\n"); 
		query.append(", @[chg_rmk]" ).append("\n"); 
		query.append(", @[cre_usr_id] -----" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}