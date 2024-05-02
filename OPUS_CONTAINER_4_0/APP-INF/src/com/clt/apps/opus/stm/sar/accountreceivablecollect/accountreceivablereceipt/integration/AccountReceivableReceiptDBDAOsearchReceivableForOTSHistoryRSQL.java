/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchReceivableForOTSHistoryRSQL.java
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

public class AccountReceivableReceiptDBDAOsearchReceivableForOTSHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTS History 반영대상 Receivable 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchReceivableForOTSHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchReceivableForOTSHistoryRSQL").append("\n"); 
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
		query.append("SELECT B.IF_NO" ).append("\n"); 
		query.append("    , B.RHQ_CD" ).append("\n"); 
		query.append("    , B.OTS_OFC_CD" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.INV_NO" ).append("\n"); 
		query.append("    , B.CURR_CD" ).append("\n"); 
		query.append("    , DECODE(A.RCV_APPL_TP_CD, 'RECEIPT', DECODE(C.RCT_TP_CD, 'OFF', 'RCTOFF', 'RCT'), DECODE(C.RCT_TP_CD, 'OFF', 'RCTOFFR', 'RCTR')) OTS_HIS_TP_CD" ).append("\n"); 
		query.append("    , B.OTS_SRC_CD" ).append("\n"); 
		query.append("    , A.GL_DT" ).append("\n"); 
		query.append("    , NVL(SUM(A.APLY_AMT), 0) * (-1) OTS_AMT" ).append("\n"); 
		query.append("    , C.RCT_NO REF_NO" ).append("\n"); 
		query.append("    , C.RCT_OFC_CD INV_OFC_CD" ).append("\n"); 
		query.append("    , B.OTS_RMK" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.VSL_CD" ).append("\n"); 
		query.append("    , B.SKD_VOY_NO" ).append("\n"); 
		query.append("    , B.DIR_CD" ).append("\n"); 
		query.append("    , B.SVC_SCP_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , B.LOCL_XCH_RT" ).append("\n"); 
		query.append("    , B.USD_XCH_RT" ).append("\n"); 
		query.append("    , B.BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_DT" ).append("\n"); 
		query.append("    , B.POL_CD" ).append("\n"); 
		query.append("    , B.POD_CD    " ).append("\n"); 
		query.append("	, B.REV_TP_SRC_CD" ).append("\n"); 
		query.append("	, B.REV_VVD_CD" ).append("\n"); 
		query.append("FROM SAR_RCV_APPL A," ).append("\n"); 
		query.append("     SAR_OTS_HIS B," ).append("\n"); 
		query.append("	 SAR_RECEIPT C," ).append("\n"); 
		query.append("	 SAR_RCV_APPL_SEQ_TMP D" ).append("\n"); 
		query.append("WHERE A.OTS_HIS_SEQ = B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND A.RCT_SEQ = C.RCT_SEQ" ).append("\n"); 
		query.append("AND A.RCV_APPL_SEQ = D.RCV_APPL_SEQ" ).append("\n"); 
		query.append("GROUP BY B.IF_NO" ).append("\n"); 
		query.append("    , B.RHQ_CD" ).append("\n"); 
		query.append("    , B.OTS_OFC_CD" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.INV_NO" ).append("\n"); 
		query.append("    , B.CURR_CD" ).append("\n"); 
		query.append("    , A.RCV_APPL_TP_CD" ).append("\n"); 
		query.append("	, C.RCT_TP_CD" ).append("\n"); 
		query.append("    , B.OTS_SRC_CD" ).append("\n"); 
		query.append("    , A.GL_DT" ).append("\n"); 
		query.append("    , C.RCT_NO" ).append("\n"); 
		query.append("    , C.RCT_OFC_CD" ).append("\n"); 
		query.append("    , B.OTS_RMK" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.VSL_CD" ).append("\n"); 
		query.append("    , B.SKD_VOY_NO" ).append("\n"); 
		query.append("    , B.DIR_CD" ).append("\n"); 
		query.append("    , B.SVC_SCP_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , B.LOCL_XCH_RT" ).append("\n"); 
		query.append("    , B.USD_XCH_RT" ).append("\n"); 
		query.append("    , B.BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_DT" ).append("\n"); 
		query.append("    , B.POL_CD" ).append("\n"); 
		query.append("    , B.POD_CD" ).append("\n"); 
		query.append("	, B.REV_TP_SRC_CD" ).append("\n"); 
		query.append("	, B.REV_VVD_CD" ).append("\n"); 
		query.append("    , B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("ORDER BY B.OTS_HIS_SEQ" ).append("\n"); 

	}
}