/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOaddApPaymentInvoiceDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.26 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOaddApPaymentInvoiceDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addApPaymentInvoiceDetail
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOaddApPaymentInvoiceDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOaddApPaymentInvoiceDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_PAY_INV_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INV_RGST_NO,    INV_RGST_SEQ," ).append("\n"); 
		query.append("SO_ETT_TP_CD,   LGS_COST_CD," ).append("\n"); 
		query.append("ACCT_CD,        VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO,     SKD_DIR_CD," ).append("\n"); 
		query.append("REV_DIR_CD,     SLAN_CD," ).append("\n"); 
		query.append("PORT_CD,        YD_CD," ).append("\n"); 
		query.append("INV_AMT,        SO_OFC_CTY_CD," ).append("\n"); 
		query.append("SO_SEQ,         DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID,     CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID,     UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(	SELECT CASE" ).append("\n"); 
		query.append("WHEN A.CNT = 0 THEN SUBSTR(@[cost_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMM')||'00001'" ).append("\n"); 
		query.append("ELSE SUBSTR(@[cost_ofc_cd],1,3)||RGST_NO" ).append("\n"); 
		query.append("END  INV_RGST_NO" ).append("\n"); 
		query.append("FROM   ( SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   AP_PAY_INV" ).append("\n"); 
		query.append("WHERE  SUBSTR(INV_RGST_NO,1,9) = SUBSTR(@[cost_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMM') ) A," ).append("\n"); 
		query.append("( SELECT MAX(TO_NUMBER(SUBSTR(INV_RGST_NO,4,11)))+1 RGST_NO" ).append("\n"); 
		query.append("FROM   AP_PAY_INV" ).append("\n"); 
		query.append("WHERE  SUBSTR(INV_RGST_NO,1,9) = SUBSTR(@[cost_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMM') ) B)," ).append("\n"); 
		query.append("SO_DTL_SEQ,    '06'" ).append("\n"); 
		query.append("LGS_COST_CD,    ACCT_CD," ).append("\n"); 
		query.append("B.VSL_CD,	    B.SKD_VOY_NO," ).append("\n"); 
		query.append("B.SKD_DIR_CD,    RLANE_DIR_CD," ).append("\n"); 
		query.append("SLAN_CD,    SUBSTR(YD_CD,1,5)," ).append("\n"); 
		query.append("YD_CD,    USD_AMT," ).append("\n"); 
		query.append("ISS_CTY_CD,    SO_SEQ," ).append("\n"); 
		query.append("'N',    'USERID'," ).append("\n"); 
		query.append("SYSDATE,    'USERID'," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM PSO_CHG_DTL" ).append("\n"); 
		query.append("where ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("and SO_SEQ = @[so_seq]" ).append("\n"); 

	}
}