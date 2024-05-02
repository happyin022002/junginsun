/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOConfirmInvoiceAuditSoDelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.19 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOConfirmInvoiceAuditSoDelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 취소시 취소내역을 S/O 테이블에 반영
	  * </pre>
	  */
	public InvoiceAuditDBDAOConfirmInvoiceAuditSoDelUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOConfirmInvoiceAuditSoDelUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SET" ).append("\n"); 
		query.append("TRSP_INV_ACT_STS_CD		= NULL" ).append("\n"); 
		query.append(",	INV_NO					= NULL" ).append("\n"); 
		query.append(",	INV_VNDR_SEQ			= NULL" ).append("\n"); 
		query.append(",	INV_BZC_AMT				= NULL" ).append("\n"); 
		query.append(",	INV_ETC_ADD_AMT			= NULL" ).append("\n"); 
		query.append(",	INV_CURR_CD				= NULL" ).append("\n"); 
		query.append(",	INV_RMK					= NULL" ).append("\n"); 
		query.append(",	TRSP_INV_CALC_LGC_TP_CD	= NULL" ).append("\n"); 
		query.append(",	INV_XCH_RT				= NULL" ).append("\n"); 
		query.append(",  UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",  UPD_USR_ID	= @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD			= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_SO_SEQ			= @[trsp_so_seq]" ).append("\n"); 

	}
}