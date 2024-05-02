/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOAddPaymentBillMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOAddPaymentBillMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOConsultationDBDAOAddPaymentBillMasterCSQL
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOAddPaymentBillMasterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_pl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bztp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_iss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ownr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bzct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOAddPaymentBillMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_BILL(" ).append("\n"); 
		query.append("	BIL_INV_YRMON," ).append("\n"); 
		query.append("	OFC_CD," ).append("\n"); 
		query.append("	BIL_SER_NO," ).append("\n"); 
		query.append("	DOC_EVID_TP_CD," ).append("\n"); 
		query.append("	BIL_DIV_CD," ).append("\n"); 
		query.append("	BIL_PL_CD," ).append("\n"); 
		query.append("	SPL_AMT," ).append("\n"); 
		query.append("	CURR_CD," ).append("\n"); 
		query.append("	VNDR_SEQ," ).append("\n"); 
		query.append("	SPL_RGST_NO," ).append("\n"); 
		query.append("	OWNR_NM," ).append("\n"); 
		query.append("	CO_NM," ).append("\n"); 
		query.append("	SPL_ADDR," ).append("\n"); 
		query.append("	BZCT_NM," ).append("\n"); 
		query.append("	BZTP_NM," ).append("\n"); 
		query.append("	ISS_DT," ).append("\n"); 
		query.append("	SLP_TP_CD," ).append("\n"); 
		query.append("	SLP_FUNC_CD," ).append("\n"); 
		query.append("	SLP_OFC_CD," ).append("\n"); 
		query.append("	SLP_ISS_DT," ).append("\n"); 
		query.append("	SLP_SER_NO," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	@[tax_inv_yrmon]," ).append("\n"); 
		query.append("	@[ofc_cd]," ).append("\n"); 
		query.append("	(SELECT LPAD(TO_NUMBER(NVL(MAX(BIL_SER_NO),0)) + 1,5,'0')" ).append("\n"); 
		query.append("       FROM FMS_BILL" ).append("\n"); 
		query.append("      WHERE BIL_INV_YRMON = @[tax_inv_yrmon]" ).append("\n"); 
		query.append("        AND OFC_CD = @[ofc_cd])," ).append("\n"); 
		query.append("    @[tax_iss_cd]," ).append("\n"); 
		query.append("	@[tax_div_cd]," ).append("\n"); 
		query.append("	@[tax_pl_cd]," ).append("\n"); 
		query.append("	@[spl_amt]," ).append("\n"); 
		query.append("	'KRW'," ).append("\n"); 
		query.append("    (SELECT VNDR_SEQ " ).append("\n"); 
		query.append("       FROM MDM_VENDOR" ).append("\n"); 
		query.append("      WHERE RGST_NO = REPLACE(@[spl_rgst_no],'-','')" ).append("\n"); 
		query.append("      AND DELT_FLG = 'N' )," ).append("\n"); 
		query.append("	REPLACE(@[spl_rgst_no],'-','')," ).append("\n"); 
		query.append("	@[ownr_nm]," ).append("\n"); 
		query.append("	@[co_nm]," ).append("\n"); 
		query.append("	@[spl_addr]," ).append("\n"); 
		query.append("	@[bzct_nm]," ).append("\n"); 
		query.append("	@[bztp_nm]," ).append("\n"); 
		query.append("	@[iss_dt]," ).append("\n"); 
		query.append("	@[slp_tp_cd]," ).append("\n"); 
		query.append("	@[slp_func_cd]," ).append("\n"); 
		query.append("	@[slp_ofc_cd]," ).append("\n"); 
		query.append("	TO_CHAR(SYSDATE,'YYMMDD')," ).append("\n"); 
		query.append("	@[slp_ser_no]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}