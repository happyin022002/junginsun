/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LseCommonDBDAORemoveRentalCostAccountOrdDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.04.23 이은섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author EUN-SUP LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAORemoveRentalCostAccountOrdDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * REMOVE
	  * </pre>
	  */
	public LseCommonDBDAORemoveRentalCostAccountOrdDataDSQL(){
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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration ").append("\n"); 
		query.append("FileName : LseCommonDBDAORemoveRentalCostAccountOrdDataDSQL").append("\n"); 
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
		query.append("DELETE FROM LSE_RNTL_COST_ACCT_ORD" ).append("\n"); 
		query.append(" WHERE LSE_RCV_CHG_TP_CD = @[lse_rcv_chg_tp_cd]" ).append("\n"); 
		query.append("   AND LSTM_CD = @[lstm_cd]" ).append("\n"); 

	}
}