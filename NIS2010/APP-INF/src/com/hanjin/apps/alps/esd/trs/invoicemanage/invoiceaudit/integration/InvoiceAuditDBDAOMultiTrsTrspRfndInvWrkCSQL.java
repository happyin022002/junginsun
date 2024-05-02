/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOMultiTrsTrspRfndInvWrkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.23 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOMultiTrsTrspRfndInvWrkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_INV_WRK Insert 쿼리
	  * </pre>
	  */
	public InvoiceAuditDBDAOMultiTrsTrspRfndInvWrkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOMultiTrsTrspRfndInvWrkCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_INV_WRK   (" ).append("\n"); 
		query.append("INV_NO             ," ).append("\n"); 
		query.append("INV_VNDR_SEQ       ," ).append("\n"); 
		query.append("TRSP_INV_AUD_STS_CD," ).append("\n"); 
		query.append("WO_VNDR_SEQ        ," ).append("\n"); 
		query.append("INV_CURR_CD        ," ).append("\n"); 
		query.append("INV_BZC_AMT        ," ).append("\n"); 
		query.append("INV_VAT_AMT        ," ).append("\n"); 
		query.append("INV_TTL_AMT        ," ).append("\n"); 
		query.append("INV_RCV_DT         ," ).append("\n"); 
		query.append("INV_ISS_DT         ," ).append("\n"); 
		query.append("DELT_FLG           ," ).append("\n"); 
		query.append("CRE_OFC_CD         ," ).append("\n"); 
		query.append("CRE_USR_ID         ," ).append("\n"); 
		query.append("CRE_DT             ," ).append("\n"); 
		query.append("UPD_USR_ID         ," ).append("\n"); 
		query.append("UPD_DT             ," ).append("\n"); 
		query.append("INV_CFM_DT         ," ).append("\n"); 
		query.append("INV_WHLD_TAX_AMT   ," ).append("\n"); 
		query.append("IF_SYS_KND_CD      ," ).append("\n"); 
		query.append("LOCL_CRE_DT		   ," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[inv_no] ," ).append("\n"); 
		query.append("@[paymt_sp_cd] ," ).append("\n"); 
		query.append("'CF' ," ).append("\n"); 
		query.append("@[combo_svc_provider] ," ).append("\n"); 
		query.append("@[inv_curr_cd] ," ).append("\n"); 
		query.append("@[inv_bzc_amt] ," ).append("\n"); 
		query.append("@[inv_vat_amt] ," ).append("\n"); 
		query.append("@[inv_ttl_amt] ," ).append("\n"); 
		query.append("TO_DATE( @[inv_rcv_dt], 'YYYY-MM-DD') ," ).append("\n"); 
		query.append("TO_DATE( @[inv_iss_dt], 'YYYY-MM-DD') ," ).append("\n"); 
		query.append("'N' ," ).append("\n"); 
		query.append("@[ofc_cd] ," ).append("\n"); 
		query.append("@[usr_id] ," ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("@[usr_id] ," ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) ," ).append("\n"); 
		query.append("@[inv_whld_tax_amt]," ).append("\n"); 
		query.append("'E' ," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) ," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) )" ).append("\n"); 

	}
}