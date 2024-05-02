/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchOutstandingReceiptDtlTempRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
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

public class AccountReceivableReceiptDBDAOSearchOutstandingReceiptDtlTempRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOutstandingReceiptDtlTemp
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchOutstandingReceiptDtlTempRSQL(){
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
		query.append("FileName : AccountReceivableReceiptDBDAOSearchOutstandingReceiptDtlTempRSQL").append("\n"); 
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
		query.append("SELECT OTS_OFC_CD" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("    , RCT_APLY_SRC_CURR_CD" ).append("\n"); 
		query.append("    , SAR_GET_FMT_MASK_FNC(RCT_APLY_SRC_CURR_CD, OTS_BAL_AMT) OTS_BAL_AMT" ).append("\n"); 
		query.append("    , SAR_GET_FMT_MASK_FNC(RCT_APLY_SRC_CURR_CD, OTS_APLY_AMT) OTS_APLY_AMT" ).append("\n"); 
		query.append("    , OTS_XCH_RT" ).append("\n"); 
		query.append("    , RCT_APLY_XCH_RT" ).append("\n"); 
		query.append("    , RCT_CURR_CD" ).append("\n"); 
		query.append("    , SAR_GET_FMT_MASK_FNC(RCT_CURR_CD, RCT_APLY_AMT) RCT_APLY_AMT" ).append("\n"); 
		query.append("    , DP_PRCS_KNT" ).append("\n"); 
		query.append("    , RCT_APLY_HDR_NO RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("    , RCT_APLY_FLG" ).append("\n"); 
		query.append("FROM SAR_OTS_RCT_TMP" ).append("\n"); 
		query.append("WHERE OTS_RCT_TMP_SEQ = @[ots_rct_tmp_seq]" ).append("\n"); 
		query.append("ORDER BY OTS_OFC_CD" ).append("\n"); 
		query.append("        , BL_NO" ).append("\n"); 
		query.append("        , INV_NO" ).append("\n"); 
		query.append("        , RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("        , RCT_APLY_SRC_CURR_CD" ).append("\n"); 

	}
}