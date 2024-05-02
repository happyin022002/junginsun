/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOAddPaymentTaxDtlsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOAddPaymentTaxDtlsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOConsultationDBDAOAddPaymentTaxDtlsCSQL
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOAddPaymentTaxDtlsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_dtl_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOAddPaymentTaxDtlsCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_TAX_DTL(" ).append("\n"); 
		query.append("	TAX_INV_YRMON," ).append("\n"); 
		query.append("	OFC_CD," ).append("\n"); 
		query.append("	TAX_SER_NO," ).append("\n"); 
		query.append("	TAX_DTL_SER_NO," ).append("\n"); 
		query.append("	ITM_NM," ).append("\n"); 
		query.append("	SPL_AMT," ).append("\n"); 
		query.append("	TAX_AMT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	@[tax_inv_yrmon]," ).append("\n"); 
		query.append("	@[ofc_cd]," ).append("\n"); 
		query.append("	(SELECT LPAD(TO_NUMBER(NVL(MAX(TAX_SER_NO),0)),5,'0')" ).append("\n"); 
		query.append("       FROM FMS_TAX" ).append("\n"); 
		query.append("      WHERE TAX_INV_YRMON = @[tax_inv_yrmon]" ).append("\n"); 
		query.append("        AND OFC_CD = @[ofc_cd])," ).append("\n"); 
		query.append("	TO_NUMBER(@[tax_dtl_ser_no])," ).append("\n"); 
		query.append("	@[itm_nm]," ).append("\n"); 
		query.append("	@[spl_amt]," ).append("\n"); 
		query.append("	@[tax_amt]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}