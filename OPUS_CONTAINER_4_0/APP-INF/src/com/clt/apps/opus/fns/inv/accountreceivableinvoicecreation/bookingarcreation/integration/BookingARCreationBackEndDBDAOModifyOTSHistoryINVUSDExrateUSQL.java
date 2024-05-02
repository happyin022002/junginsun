/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOModifyOTSHistoryINVUSDExrateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationBackEndDBDAOModifyOTSHistoryINVUSDExrateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify OTS History INV USD Exrate
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOModifyOTSHistoryINVUSDExrateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOModifyOTSHistoryINVUSDExrateUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OTS_HIS" ).append("\n"); 
		query.append("   SET INV_USD_XCH_RT = DECODE(INV_CURR_CD, 'USD', 1, NVL(@[inv_xch_rt], 0))," ).append("\n"); 
		query.append("	   UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT = SYSDATE " ).append("\n"); 
		query.append("WHERE IF_NO = @[ar_if_no]||@[ar_if_ser_no]" ).append("\n"); 
		query.append("AND OTS_HIS_TP_CD = 'OTS'" ).append("\n"); 
		query.append("AND INV_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("-- AND (NVL(INV_LOCL_XCH_RT, 0) = 0 OR NVL(INV_USD_XCH_RT, 0) = 0)" ).append("\n"); 
		query.append("AND (INV_NO = '**********' OR (INV_NO <> '**********' AND NVL(INV_USD_XCH_RT, 0) = 0))" ).append("\n"); 

	}
}