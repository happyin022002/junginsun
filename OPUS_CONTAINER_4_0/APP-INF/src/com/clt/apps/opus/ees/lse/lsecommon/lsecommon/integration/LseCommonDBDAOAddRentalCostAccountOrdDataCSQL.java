/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LseCommonDBDAOAddRentalCostAccountOrdDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.04.24 이은섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author EUN-SUP LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOAddRentalCostAccountOrdDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public LseCommonDBDAOAddRentalCostAccountOrdDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_rcv_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lgs_cost_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration").append("\n"); 
		query.append("FileName : LseCommonDBDAOAddRentalCostAccountOrdDataCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_RNTL_COST_ACCT_ORD" ).append("\n"); 
		query.append("  (LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("   LSTM_CD," ).append("\n"); 
		query.append("   ACCT_CD," ).append("\n"); 
		query.append("   COST_CD," ).append("\n"); 
		query.append("   LGS_COST_FULL_NM," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("  (@[lse_rcv_chg_tp_cd]," ).append("\n"); 
		query.append("   @[lstm_cd]," ).append("\n"); 
		query.append("   @[acct_cd]," ).append("\n"); 
		query.append("   @[cost_cd]," ).append("\n"); 
		query.append("   @[lgs_cost_full_nm]," ).append("\n"); 
		query.append("   @[cre_usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[upd_usr_id]," ).append("\n"); 
		query.append("   SYSDATE)" ).append("\n"); 

	}
}