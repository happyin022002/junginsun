/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOaddOutstandingDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOaddOutstandingDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_OTS_DTL 테이블에 insert
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOaddOutstandingDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOaddOutstandingDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_OTS_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    RHQ_CD" ).append("\n"); 
		query.append("    , OTS_OFC_CD" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , BL_CURR_CD" ).append("\n"); 
		query.append("    , INV_AMT" ).append("\n"); 
		query.append("    , INV_UPD_DT" ).append("\n"); 
		query.append("	, RCT_AMT" ).append("\n"); 
		query.append("    , RCT_UPD_DT" ).append("\n"); 
		query.append("	, ADJ_AMT " ).append("\n"); 
		query.append("    , ADJ_UPD_DT" ).append("\n"); 
		query.append("    , BAL_AMT " ).append("\n"); 
		query.append("    , BAL_UPD_DT" ).append("\n"); 
		query.append("	, WRTF_AMT" ).append("\n"); 
		query.append("	, WRTF_UPD_DT" ).append("\n"); 
		query.append("    , LOCL_XCH_RT" ).append("\n"); 
		query.append("    , USD_XCH_RT" ).append("\n"); 
		query.append("    , BAL_LOCL_AMT" ).append("\n"); 
		query.append("    , BAL_USD_AMT " ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("	, CHG_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[rhq_cd]" ).append("\n"); 
		query.append("    , @[ots_ofc_cd]" ).append("\n"); 
		query.append("    , @[bl_no]" ).append("\n"); 
		query.append("    , @[inv_no]" ).append("\n"); 
		query.append("    , @[bl_curr_cd]" ).append("\n"); 
		query.append("    , NVL(@[inv_amt], 0)" ).append("\n"); 
		query.append("    , CASE TO_CHAR(NVL(@[inv_amt], 0)) WHEN '0' THEN NULL ELSE SYSDATE END" ).append("\n"); 
		query.append(" 	, NVL(@[rct_amt], 0)" ).append("\n"); 
		query.append("    , CASE TO_CHAR(NVL(@[rct_amt], 0)) WHEN '0' THEN NULL ELSE SYSDATE END" ).append("\n"); 
		query.append(" 	, NVL(@[adj_amt], 0)" ).append("\n"); 
		query.append("    , CASE TO_CHAR(NVL(@[adj_amt], 0)) WHEN '0' THEN NULL ELSE SYSDATE END" ).append("\n"); 
		query.append("  	, NVL(@[inv_amt], 0) - NVL(@[rct_amt], 0) + NVL(@[adj_amt], 0)" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	, NVL(@[wrtf_amt], 0)" ).append("\n"); 
		query.append("	, CASE TO_CHAR(NVL(@[wrtf_amt], 0)) WHEN '0' THEN NULL ELSE SYSDATE END" ).append("\n"); 
		query.append("    , NVL(@[locl_xch_rt], 0)" ).append("\n"); 
		query.append("    , NVL(@[usd_xch_rt], 0)" ).append("\n"); 
		query.append("    , (SELECT ROUND((NVL(@[inv_amt], 0) - NVL(@[rct_amt], 0) + NVL(@[adj_amt], 0)) * NVL(@[locl_xch_rt], 0), DP_PRCS_KNT)" ).append("\n"); 
		query.append("       FROM MDM_CURRENCY" ).append("\n"); 
		query.append("       WHERE CURR_CD = @[ofc_curr_cd])" ).append("\n"); 
		query.append("    , ROUND((NVL(@[inv_amt], 0) - NVL(@[rct_amt], 0) + NVL(@[adj_amt], 0)) * NVL(@[usd_xch_rt], 0), 2)" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	, @[chg_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}