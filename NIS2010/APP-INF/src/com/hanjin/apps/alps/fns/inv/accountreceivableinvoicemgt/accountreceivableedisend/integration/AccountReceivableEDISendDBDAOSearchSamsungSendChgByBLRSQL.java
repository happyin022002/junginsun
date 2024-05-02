/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchSamsungSendChgByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.20 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchSamsungSendChgByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSamsungSendChgByBL
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchSamsungSendChgByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchSamsungSendChgByBLRSQL").append("\n"); 
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
		query.append("#if (${rcrv_id} == '')" ).append("\n"); 
		query.append("SELECT --C.CHG_CD CHARGE_CD," ).append("\n"); 
		query.append("  DECODE(C.CHG_CD, 'XXX', 'CFS', C.CHG_CD) CHARGE_CD," ).append("\n"); 
		query.append("  --B.ISS_DT FRT_ISSUE_DATE," ).append("\n"); 
		query.append("  A.BIL_DT FRT_ISSUE_DATE," ).append("\n"); 
		query.append("  C.CHG_AMT + C.VAT_AMT REQ_AMOUNT," ).append("\n"); 
		query.append("  NVL(C.CHG_CURR_CD,' ') REQ_CUR_CD," ).append("\n"); 
		query.append("  C.CHG_AMT SUP_AMOUNT," ).append("\n"); 
		query.append("  NVL(C.CHG_CURR_CD,' ') SUP_CUR_CD," ).append("\n"); 
		query.append("  C.VAT_AMT TAX_AMOUNT," ).append("\n"); 
		query.append("  NVL(C.VAT_CURR_CD,' ') TAX_CUR_CD," ).append("\n"); 
		query.append("  DECODE(C.CHG_CURR_CD,'KRW',1,A.INV_XCH_RT) RAT_EX_RATE,  " ).append("\n"); 
		query.append("  C.CHG_CURR_CD BASIC_CUR_CD," ).append("\n"); 
		query.append("  C.CHG_CURR_CD DEST_CUR_CD," ).append("\n"); 
		query.append("  NVL(A.INV_XCH_RT_DT,' ') RAT_EX_RATE_DATE," ).append("\n"); 
		query.append("  C.MSG_ID MSG_ID_CHG," ).append("\n"); 
		query.append("  C.MSG_NO MSG_NO_CHG," ).append("\n"); 
		query.append("  C.BL_LINE_NO BL_LINE_NO_CHG," ).append("\n"); 
		query.append("  C.BL_SRC_NO BL_SRC_NO_CHG" ).append("\n"); 
		query.append("FROM INV_AR_EDI_GERP_HDR A," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_BL B," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_CHG C" ).append("\n"); 
		query.append("WHERE A.MSG_ID = B.MSG_ID" ).append("\n"); 
		query.append("  AND A.MSG_NO = B.MSG_NO" ).append("\n"); 
		query.append("  AND B.MSG_ID = C.MSG_ID" ).append("\n"); 
		query.append("  AND B.MSG_NO = C.MSG_NO" ).append("\n"); 
		query.append("  AND B.BL_LINE_NO = C.BL_LINE_NO" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("  AND A.MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("  AND A.MSG_NO = @[msg_no]" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("  --AND C.CHG_CD <> 'XXX'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT --C.CHG_CD CHARGE_CD," ).append("\n"); 
		query.append("  DECODE(C.CHG_CD, 'XXX', 'CFS', C.CHG_CD) CHARGE_CD," ).append("\n"); 
		query.append("  --B.ISS_DT FRT_ISSUE_DATE," ).append("\n"); 
		query.append("  A.BIL_DT FRT_ISSUE_DATE," ).append("\n"); 
		query.append("  C.CHG_AMT + C.VAT_AMT REQ_AMOUNT," ).append("\n"); 
		query.append("  NVL(C.CHG_CURR_CD,' ') REQ_CUR_CD," ).append("\n"); 
		query.append("  C.CHG_AMT SUP_AMOUNT," ).append("\n"); 
		query.append("  NVL(C.CHG_CURR_CD,' ') SUP_CUR_CD," ).append("\n"); 
		query.append("  C.VAT_AMT TAX_AMOUNT," ).append("\n"); 
		query.append("  NVL(C.VAT_CURR_CD,' ') TAX_CUR_CD," ).append("\n"); 
		query.append("  DECODE(C.CHG_CURR_CD,'KRW',1,A.INV_XCH_RT) RAT_EX_RATE,  " ).append("\n"); 
		query.append("  C.CHG_CURR_CD BASIC_CUR_CD," ).append("\n"); 
		query.append("  C.CHG_CURR_CD DEST_CUR_CD," ).append("\n"); 
		query.append("  NVL(A.INV_XCH_RT_DT,' ') RAT_EX_RATE_DATE," ).append("\n"); 
		query.append("  C.MSG_ID MSG_ID_CHG," ).append("\n"); 
		query.append("  C.MSG_NO MSG_NO_CHG," ).append("\n"); 
		query.append("  C.BL_LINE_NO BL_LINE_NO_CHG," ).append("\n"); 
		query.append("  C.BL_SRC_NO BL_SRC_NO_CHG" ).append("\n"); 
		query.append("FROM INV_AR_EDI_GERP_HDR A," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_BL B," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_CHG C" ).append("\n"); 
		query.append("WHERE A.MSG_ID = B.MSG_ID" ).append("\n"); 
		query.append("  AND A.MSG_NO = B.MSG_NO" ).append("\n"); 
		query.append("  AND B.MSG_ID = C.MSG_ID" ).append("\n"); 
		query.append("  AND B.MSG_NO = C.MSG_NO" ).append("\n"); 
		query.append("  AND B.BL_LINE_NO = C.BL_LINE_NO" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = C.BL_SRC_NO" ).append("\n"); 
		query.append("  AND A.MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("  AND A.MSG_NO = @[msg_no]" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("  --AND C.CHG_CD <> 'XXX'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}