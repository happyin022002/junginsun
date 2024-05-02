/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchApplyTotalAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.20 
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

public class AccountReceivableReceiptDBDAOSearchApplyTotalAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchApplyTotalAmount
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchApplyTotalAmountRSQL(){
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
		query.append("FileName : AccountReceivableReceiptDBDAOSearchApplyTotalAmountRSQL").append("\n"); 
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
		query.append("SELECT SAR_GET_FMT_MASK_FNC(A.RCT_CURR_CD, SUM(C.RCT_APLY_AMT) - NVL(A.BANK_CHG_AMT, 0)) TTL_APLY_AMT" ).append("\n"); 
		query.append("FROM SAR_RECEIPT A," ).append("\n"); 
		query.append("	 SAR_RCT_APLY_HDR B," ).append("\n"); 
		query.append("	 SAR_RCT_APLY_DTL C" ).append("\n"); 
		query.append("WHERE A.RCT_SEQ = B.RCT_SEQ" ).append("\n"); 
		query.append("AND A.RCT_SEQ = C.RCT_SEQ" ).append("\n"); 
		query.append("AND B.RCT_APLY_HDR_SEQ = C.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("AND B.RVS_FLG = 'N'" ).append("\n"); 
		query.append("AND A.RCT_NO = @[rct_no]" ).append("\n"); 
		query.append("AND A.RCT_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("GROUP BY A.RCT_CURR_CD" ).append("\n"); 
		query.append("	   , A.BANK_CHG_AMT" ).append("\n"); 

	}
}