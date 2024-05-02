/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOAddVVDExchangeRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOAddVVDExchangeRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add VVD Exchange Rate
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOAddVVDExchangeRateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOAddVVDExchangeRateCSQL").append("\n"); 
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
		query.append("INSERT INTO OPUSADM_TMP.INV_VVD_XCH_RT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , PORT_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , IO_BND_CD" ).append("\n"); 
		query.append("    , LOCL_CURR_CD" ).append("\n"); 
		query.append("    , CHG_CURR_CD " ).append("\n"); 
		query.append("    , AR_OFC_CD" ).append("\n"); 
		query.append("    , INV_XCH_RT" ).append("\n"); 
		query.append("    , IVS_XCH_RT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , XCH_RT_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	A.VSL_CD" ).append("\n"); 
		query.append("    , A.SKD_VOY_NO" ).append("\n"); 
		query.append("    , A.SKD_DIR_CD" ).append("\n"); 
		query.append("    , A.PORT_CD" ).append("\n"); 
		query.append("    , A.SVC_SCP_CD" ).append("\n"); 
		query.append("    , A.IO_BND_CD" ).append("\n"); 
		query.append("    , B.LOCL_CURR_CD" ).append("\n"); 
		query.append("    , B.CHG_CURR_CD" ).append("\n"); 
		query.append("    , A.AR_OFC_CD" ).append("\n"); 
		query.append("    , B.INV_XCH_RT" ).append("\n"); 
		query.append("    , B.IVS_XCH_RT" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , A.XCH_RT_DT" ).append("\n"); 
		query.append("FROM OPUSADM_TMP.INV_VVD_XCH_RT_DT A," ).append("\n"); 
		query.append("     OPUSADM_TMP.INV_CUST_AND_DLY_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("AND A.XCH_RT_DT = B.FM_DT" ).append("\n"); 
		query.append("AND A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND B.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("AND B.CUST_SEQ = 0" ).append("\n"); 
		query.append("AND B.XCH_RT_TP_CD = 'V'" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("    AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}