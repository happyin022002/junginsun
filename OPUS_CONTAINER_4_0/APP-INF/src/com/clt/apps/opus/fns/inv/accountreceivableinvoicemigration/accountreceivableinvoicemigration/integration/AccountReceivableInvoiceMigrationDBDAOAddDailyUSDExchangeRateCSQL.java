/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOAddDailyUSDExchangeRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
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

public class AccountReceivableInvoiceMigrationDBDAOAddDailyUSDExchangeRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Daily USD Exchange Rate
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOAddDailyUSDExchangeRateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration ").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOAddDailyUSDExchangeRateCSQL").append("\n"); 
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
		query.append("INSERT INTO OPUSADM_TMP.INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   CUST_CNT_CD" ).append("\n"); 
		query.append("   , CUST_SEQ" ).append("\n"); 
		query.append("   , IO_BND_CD" ).append("\n"); 
		query.append("   , FM_DT" ).append("\n"); 
		query.append("   , TO_DT" ).append("\n"); 
		query.append("   , CHG_CURR_CD" ).append("\n"); 
		query.append("   , LOCL_CURR_CD" ).append("\n"); 
		query.append("   , XCH_RT_TP_CD" ).append("\n"); 
		query.append("   , AR_OFC_CD" ).append("\n"); 
		query.append("   , INV_XCH_RT" ).append("\n"); 
		query.append("   , IVS_XCH_RT" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.CUST_CNT_CD" ).append("\n"); 
		query.append("       , A.CUST_SEQ" ).append("\n"); 
		query.append("       , A.IO_BND_CD" ).append("\n"); 
		query.append("       , A.FM_DT" ).append("\n"); 
		query.append("       , A.TO_DT" ).append("\n"); 
		query.append("       , DECODE(A.CHG_CURR_CD, 'USD', A.LOCL_CURR_CD, A.CHG_CURR_CD) CHG_CURR_CD" ).append("\n"); 
		query.append("       , 'USD' LOCL_CURR_CD" ).append("\n"); 
		query.append("       , A.XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , A.AR_OFC_CD" ).append("\n"); 
		query.append("       , NVL(ROUND(DECODE(A.CHG_CURR_CD, 'USD', 1, A.INV_XCH_RT)/B.INV_XCH_RT, 6), 0) INV_XCH_RT" ).append("\n"); 
		query.append("       , NVL(ROUND(1/ROUND(DECODE(A.CHG_CURR_CD, 'USD', 1, A.INV_XCH_RT)/B.INV_XCH_RT, 6), 6), 0) IVS_XCH_RT" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , A.CRE_DT" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , A.UPD_DT" ).append("\n"); 
		query.append("FROM  OPUSADM_TMP.INV_CUST_AND_DLY_XCH_RT A," ).append("\n"); 
		query.append("      OPUSADM_TMP.INV_CUST_AND_DLY_XCH_RT B," ).append("\n"); 
		query.append("      MDM_ORGANIZATION C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND   A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND   A.FM_DT = B.FM_DT" ).append("\n"); 
		query.append("AND   A.TO_DT = B.TO_DT" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD = B.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND   A.XCH_RT_TP_CD = B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("AND   B.CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = 0" ).append("\n"); 
		query.append("AND   A.XCH_RT_TP_CD = 'V'" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND   NVL(C.ALTN_CURR_DIV_CD, 'LCL') = 'USD'" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}