/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchOutstandingReceiptHdrTempRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
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

public class AccountReceivableReceiptDBDAOSearchOutstandingReceiptHdrTempRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOutstandingReceiptHdrTemp
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchOutstandingReceiptHdrTempRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rct_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchOutstandingReceiptHdrTempRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT RCT_APLY_HDR_NO RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("    , RCT_APLY_FLG" ).append("\n"); 
		query.append("    , RHQ_CD" ).append("\n"); 
		query.append("    , OFC_CD" ).append("\n"); 
		query.append("    , OTS_OFC_CD" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , BIL_TO_CUST_CNT_CD||'-'||LPAD(BIL_TO_CUST_SEQ, 6, '0') BIL_TO_CUST_CD" ).append("\n"); 
		query.append("    , LOCL_VVD_CD" ).append("\n"); 
		query.append("    , TRNK_VVD_CD" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , DECODE(IO_BND_CD, 'O', 'O/B', 'I/B') IO_BND_CD" ).append("\n"); 
		query.append("    , DUE_DT" ).append("\n"); 
		query.append("    , SREP_CD" ).append("\n"); 
		query.append("    , OTS_RMK" ).append("\n"); 
		query.append("    , (SELECT INTG_CD_VAL_DP_DESC              " ).append("\n"); 
		query.append("       FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD02060'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT = XCH_RT_TP_CD) XCH_RT_TP_NM" ).append("\n"); 
		query.append("    , XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , XCH_RT_DT" ).append("\n"); 
		query.append("    , CR_FLG" ).append("\n"); 
		query.append("    , AR_FINC_SRC_CD" ).append("\n"); 
		query.append("    , MAX_AR_IF_NO" ).append("\n"); 
		query.append("    , INV_DT" ).append("\n"); 
		query.append("FROM SAR_OTS_RCT_TMP" ).append("\n"); 
		query.append("WHERE OTS_RCT_TMP_SEQ = @[ots_rct_tmp_seq]" ).append("\n"); 
		query.append("AND HDR_DUP_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY OTS_OFC_CD" ).append("\n"); 
		query.append("        , BL_NO" ).append("\n"); 
		query.append("        , INV_NO" ).append("\n"); 

	}
}