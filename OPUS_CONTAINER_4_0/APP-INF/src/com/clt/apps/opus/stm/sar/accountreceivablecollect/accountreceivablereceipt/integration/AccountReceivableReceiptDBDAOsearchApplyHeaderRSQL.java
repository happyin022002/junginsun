/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchApplyHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23 
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

public class AccountReceivableReceiptDBDAOsearchApplyHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Apply Header 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchApplyHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchApplyHeaderRSQL").append("\n"); 
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
		query.append("SELECT A.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("    , A.RCT_SEQ" ).append("\n"); 
		query.append("    , A.BL_NO" ).append("\n"); 
		query.append("    , A.BKG_NO" ).append("\n"); 
		query.append("    , A.INV_NO" ).append("\n"); 
		query.append("    , A.OTS_OFC_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("	, DECODE(A.BIL_TO_CUST_CNT_CD, '', '', A.BIL_TO_CUST_CNT_CD||'-'||LPAD(A.BIL_TO_CUST_SEQ, 6, '0')) BIL_TO_CUST_CD" ).append("\n"); 
		query.append("    , A.LOCL_VVD_CD" ).append("\n"); 
		query.append("    , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("    , A.SAIL_DT" ).append("\n"); 
		query.append("    , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("    , A.OBRD_DT" ).append("\n"); 
		query.append("	, DECODE(A.IO_BND_CD, 'O', 'O/B', 'I', 'I/B', '') IO_BND_CD" ).append("\n"); 
		query.append("    , A.DUE_DT" ).append("\n"); 
		query.append("    , A.SREP_CD" ).append("\n"); 
		query.append("    , A.OTS_RMK" ).append("\n"); 
		query.append("	, (SELECT INTG_CD_VAL_DP_DESC              " ).append("\n"); 
		query.append("       FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD02060'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT = A.XCH_RT_TP_CD) XCH_RT_TP_NM" ).append("\n"); 
		query.append("    , A.XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , A.XCH_RT_DT" ).append("\n"); 
		query.append("    , A.CR_FLG" ).append("\n"); 
		query.append("    , A.AR_TAX_IND_CD" ).append("\n"); 
		query.append("    , A.TJ_SRC_NM" ).append("\n"); 
		query.append("    , A.AR_FINC_SRC_CD" ).append("\n"); 
		query.append("    , A.RVS_FLG" ).append("\n"); 
		query.append("    , A.RCT_APLY_AMT" ).append("\n"); 
		query.append("    , A.RCT_APLY_FLG" ).append("\n"); 
		query.append("    , A.MAX_AR_IF_NO" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , A.CRE_DT" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , A.UPD_DT" ).append("\n"); 
		query.append("	, A.INV_DT" ).append("\n"); 
		query.append("	, (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("       FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("       WHERE OFC_CD = A.OTS_OFC_CD) RHQ_CD" ).append("\n"); 
		query.append("    , (SELECT DECODE(NVL(OTS_CD, 'ARO'), 'COU', REP_OTS_OFC_CD, A.OTS_OFC_CD)" ).append("\n"); 
		query.append("       FROM SCO_OFC_INFO" ).append("\n"); 
		query.append("       WHERE OFC_CD = A.OTS_OFC_CD) OFC_CD" ).append("\n"); 
		query.append("FROM SAR_RCT_APLY_HDR A," ).append("\n"); 
		query.append("     SAR_RECEIPT B" ).append("\n"); 
		query.append("WHERE A.RCT_SEQ = B.RCT_SEQ" ).append("\n"); 
		query.append("AND B.RCT_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("AND B.RCT_NO = @[rct_no]" ).append("\n"); 
		query.append("AND A.RVS_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.RCT_APLY_HDR_SEQ" ).append("\n"); 

	}
}