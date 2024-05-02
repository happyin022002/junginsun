/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOcreateIssueMainCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOcreateIssueMainCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOcreateIssueMainCSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOcreateIssueMainCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_iss_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_po_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vn_inv_pay_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOcreateIssueMainCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_ISS (" ).append("\n"); 
		query.append("INV_NO" ).append("\n"); 
		query.append(", INV_SEQ" ).append("\n"); 
		query.append(", ISS_OFC_CD" ).append("\n"); 
		query.append(", ISS_DT" ).append("\n"); 
		query.append(", RISS_DT" ).append("\n"); 
		query.append(", INV_ISS_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", INV_ISS_CMB_FLG" ).append("\n"); 
		query.append(", INV_XCH_RT_DT" ).append("\n"); 
		query.append(", USD_XCH_RT" ).append("\n"); 
		query.append(", LOCL_PO_NO" ).append("\n"); 
		query.append(", ACT_INV_NO" ).append("\n"); 
		query.append(", VN_INV_PAY_MZD_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[inv_no]" ).append("\n"); 
		query.append(", (SELECT NVL(MAX(INV_SEQ) + 1, 1) FROM INV_AR_ISS WHERE INV_NO = @[inv_no])" ).append("\n"); 
		query.append(", @[iss_ofc_cd]" ).append("\n"); 
		query.append(", (SELECT NVL(MIN(ISS_DT), TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[iss_ofc_cd]), 'YYYYMMDD')) FROM INV_AR_ISS WHERE INV_NO = @[inv_no] AND INV_SEQ = 1)" ).append("\n"); 
		query.append(", (SELECT DECODE(NVL(MAX(INV_SEQ) + 1, 1), 1, '', TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[iss_ofc_cd]), 'YYYYMMDD')) FROM INV_AR_ISS WHERE INV_NO = @[inv_no])" ).append("\n"); 
		query.append(", NVL(@[inv_iss_rmk], '')" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", NVL(@[inv_iss_cmb_flg],'N')" ).append("\n"); 
		query.append(", @[inv_xch_rt_dt]" ).append("\n"); 
		query.append(", NVL(@[usd_xch_rt],0)" ).append("\n"); 
		query.append(", NVL(@[locl_po_no], '')" ).append("\n"); 
		query.append(", (SELECT ACT_INV_NO" ).append("\n"); 
		query.append("FROM INV_AR_ISS" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND INV_SEQ IN ( SELECT MAX(INV_SEQ)" ).append("\n"); 
		query.append("FROM INV_AR_ISS" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]))" ).append("\n"); 
		query.append(", @[vn_inv_pay_mzd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}