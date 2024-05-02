/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchChinaDailyUSDExrateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOSearchChinaDailyUSDExrateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search China Daily USD Exrate
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchChinaDailyUSDExrateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcl_curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration ").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchChinaDailyUSDExrateRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(DECODE(B.INV_XCH_RT, 0, 0, DECODE(@[curr], @[lcl_curr], 1, A.INV_XCH_RT)/B.INV_XCH_RT), 6), 0) EX_RATE" ).append("\n"); 
		query.append("FROM  OPUSADM_TMP.INV_CUST_AND_DLY_XCH_RT A," ).append("\n"); 
		query.append("      OPUSADM_TMP.INV_CUST_AND_DLY_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND   A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD = B.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND   A.XCH_RT_TP_CD = B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("AND   A.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("AND   A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("AND   REPLACE(@[sa_dt],'-','') BETWEEN A.FM_DT AND A.TO_DT" ).append("\n"); 
		query.append("AND   REPLACE(@[sa_dt],'-','') BETWEEN B.FM_DT AND B.TO_DT" ).append("\n"); 
		query.append("AND   A.CHG_CURR_CD = DECODE(@[curr], @[lcl_curr], 'USD', @[curr])" ).append("\n"); 
		query.append("AND   B.CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD = @[lcl_curr]" ).append("\n"); 
		query.append("AND   A.XCH_RT_TP_CD = 'V'" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}