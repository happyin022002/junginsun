/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchApplyDetailRSQL.java
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

public class AccountReceivableReceiptDBDAOsearchApplyDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Apply Detail 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchApplyDetailRSQL(){
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
		query.append("FileName : AccountReceivableReceiptDBDAOsearchApplyDetailRSQL").append("\n"); 
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
		query.append("SELECT A.RCT_APLY_DTL_SEQ" ).append("\n"); 
		query.append("    , A.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("    , A.RCT_SEQ" ).append("\n"); 
		query.append("    , A.WRTF_CD" ).append("\n"); 
		query.append("    , A.RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("    , A.RCT_APLY_DT" ).append("\n"); 
		query.append("    , A.RCT_APLY_SRC_CURR_CD" ).append("\n"); 
		query.append("    , SAR_GET_FMT_MASK_FNC(A.RCT_APLY_SRC_CURR_CD, A.OTS_APLY_AMT) OTS_APLY_AMT" ).append("\n"); 
		query.append("    , A.RCT_APLY_XCH_RT" ).append("\n"); 
		query.append("    , A.OTS_XCH_RT" ).append("\n"); 
		query.append("    , A.RCT_CURR_CD" ).append("\n"); 
		query.append("    , SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, A.RCT_APLY_AMT) RCT_APLY_AMT" ).append("\n"); 
		query.append("    , A.WRTF_RMK" ).append("\n"); 
		query.append("    , A.AP_OFC_CD" ).append("\n"); 
		query.append("    , A.VNDR_NO" ).append("\n"); 
		query.append("    , A.AP_RMK" ).append("\n"); 
		query.append("    , A.AP_GL_DT" ).append("\n"); 
		query.append("    , A.RCT_APLY_FLG" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , A.CRE_DT" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , A.UPD_DT" ).append("\n"); 
		query.append("    , DECODE(A.OTS_BAL_AMT, '', '', SAR_GET_FMT_MASK_FNC(A.RCT_APLY_SRC_CURR_CD, A.OTS_BAL_AMT)) OTS_BAL_AMT" ).append("\n"); 
		query.append("FROM SAR_RCT_APLY_DTL A," ).append("\n"); 
		query.append("     SAR_RECEIPT B," ).append("\n"); 
		query.append("	 SAR_RCT_APLY_HDR C" ).append("\n"); 
		query.append("WHERE A.RCT_SEQ = B.RCT_SEQ" ).append("\n"); 
		query.append("AND B.RCT_SEQ = C.RCT_SEQ" ).append("\n"); 
		query.append("AND A.RCT_APLY_HDR_SEQ = C.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("AND B.RCT_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("AND B.RCT_NO = @[rct_no]" ).append("\n"); 
		query.append("AND C.RVS_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.RCT_APLY_DTL_SEQ" ).append("\n"); 

	}
}