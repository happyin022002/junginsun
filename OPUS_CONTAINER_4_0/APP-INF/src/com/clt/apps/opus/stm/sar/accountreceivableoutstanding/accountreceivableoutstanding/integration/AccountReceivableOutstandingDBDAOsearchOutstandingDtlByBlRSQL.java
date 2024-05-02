/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchOutstandingDtlByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOsearchOutstandingDtlByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding Inquiry by B/L(Invoice) Detail
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchOutstandingDtlByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchOutstandingDtlByBlRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("         A.RHQ_CD" ).append("\n"); 
		query.append("       , A.OTS_OFC_CD" ).append("\n"); 
		query.append("       , A.BL_NO" ).append("\n"); 
		query.append("       , A.INV_NO" ).append("\n"); 
		query.append("       , A.BL_CURR_CD " ).append("\n"); 
		query.append("       , A.CHG_TP_CD " ).append("\n"); 
		query.append("       , A.INV_AMT " ).append("\n"); 
		query.append("       , A.INV_UPD_DT" ).append("\n"); 
		query.append("       , A.RCT_AMT" ).append("\n"); 
		query.append("       , A.RCT_UPD_DT" ).append("\n"); 
		query.append("       , A.ADJ_AMT " ).append("\n"); 
		query.append("       , A.ADJ_UPD_DT" ).append("\n"); 
		query.append("       , A.BAL_AMT" ).append("\n"); 
		query.append("       , A.BAL_UPD_DT" ).append("\n"); 
		query.append("       , A.LOCL_XCH_RT" ).append("\n"); 
		query.append("       , A.USD_XCH_RT                 " ).append("\n"); 
		query.append("       , A.BAL_LOCL_AMT" ).append("\n"); 
		query.append("       , A.BAL_USD_AMT" ).append("\n"); 
		query.append("       , B.BIL_TO_CUST_CNT_CD || LPAD(B.BIL_TO_CUST_SEQ,6, '0') CUST_NUM" ).append("\n"); 
		query.append("       , B.BKG_NO" ).append("\n"); 
		query.append("FROM     SAR_OTS_DTL A" ).append("\n"); 
		query.append("       , SAR_OTS_HDR B" ).append("\n"); 
		query.append("WHERE 1 = 1          " ).append("\n"); 
		query.append("  AND A.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("  AND A.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("  AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("  AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("  AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND A.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("  AND A.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 

	}
}