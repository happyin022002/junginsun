/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOAddZeroBalanceDtlInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOAddZeroBalanceDtlInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddZeroBalanceDtlInfo
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOAddZeroBalanceDtlInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOAddZeroBalanceDtlInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO  SAR_ADJ_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  OTS_ADJ_SEQ" ).append("\n"); 
		query.append(" ,ADJ_TP_CD" ).append("\n"); 
		query.append(" ,CHG_TP_CD" ).append("\n"); 
		query.append(" ,ADJ_SRC_CURR_CD" ).append("\n"); 
		query.append(" ,OTS_BAL_AMT" ).append("\n"); 
		query.append(" ,ADJ_AMT" ).append("\n"); 
		query.append(" ,ADJ_XCH_RT" ).append("\n"); 
		query.append(" ,ADJ_CRS_CURR_CD" ).append("\n"); 
		query.append(" ,ADJ_CRS_CURR_AMT" ).append("\n"); 
		query.append(" ,LEGR_XCH_RT" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" @[ots_adj_seq]," ).append("\n"); 
		query.append(" @[adj_tp_cd]," ).append("\n"); 
		query.append(" @[chg_tp_cd]," ).append("\n"); 
		query.append(" @[bl_curr_cd]," ).append("\n"); 
		query.append(" @[ots_bal_amt]," ).append("\n"); 
		query.append(" @[ots_bal_amt]*(-1)," ).append("\n"); 
		query.append(" 1," ).append("\n"); 
		query.append(" @[bl_curr_cd]," ).append("\n"); 
		query.append(" @[ots_bal_amt]," ).append("\n"); 
		query.append(" ''," ).append("\n"); 
		query.append(" @[cre_usr_id]," ).append("\n"); 
		query.append(" SYSDATE, " ).append("\n"); 
		query.append(" @[cre_usr_id]," ).append("\n"); 
		query.append(" SYSDATE       " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}