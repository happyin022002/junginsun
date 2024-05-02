/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchReceivableForOTSHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOsearchReceivableForOTSHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTS Header 반영대상 Receivable 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchReceivableForOTSHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchReceivableForOTSHeaderRSQL").append("\n"); 
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
		query.append("SELECT Q.RHQ_CD" ).append("\n"); 
		query.append("   	   , Q.OTS_OFC_CD" ).append("\n"); 
		query.append("   	   , Q.BL_NO" ).append("\n"); 
		query.append("   	   , Q.INV_NO" ).append("\n"); 
		query.append("   	   , Q.INV_OFC_CD CLT_OFC_CD" ).append("\n"); 
		query.append("   	   , P.UPD_USR_ID" ).append("\n"); 
		query.append("FROM SAR_RCV_APPL P," ).append("\n"); 
		query.append("     SAR_OTS_HIS Q," ).append("\n"); 
		query.append("     (SELECT MAX(A.RCV_APPL_SEQ) RCV_APPL_SEQ" ).append("\n"); 
		query.append("      FROM SAR_RCV_APPL A," ).append("\n"); 
		query.append("           SAR_OTS_HIS B," ).append("\n"); 
		query.append("		   SAR_RCV_APPL_SEQ_TMP C" ).append("\n"); 
		query.append("      WHERE A.OTS_HIS_SEQ = B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("      AND A.RCV_APPL_SEQ = C.RCV_APPL_SEQ" ).append("\n"); 
		query.append("      GROUP BY B.RHQ_CD" ).append("\n"); 
		query.append("               , B.OTS_OFC_CD" ).append("\n"); 
		query.append("               , B.BL_NO" ).append("\n"); 
		query.append("               , B.INV_NO) R" ).append("\n"); 
		query.append("WHERE P.RCV_APPL_SEQ = R.RCV_APPL_SEQ" ).append("\n"); 
		query.append("AND P.OTS_HIS_SEQ = Q.OTS_HIS_SEQ" ).append("\n"); 

	}
}