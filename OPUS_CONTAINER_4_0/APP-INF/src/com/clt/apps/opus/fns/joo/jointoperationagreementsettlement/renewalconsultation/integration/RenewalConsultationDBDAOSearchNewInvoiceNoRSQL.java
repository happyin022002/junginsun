/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchNewInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOSearchNewInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Invoice No 생성 
	  * RE_DIVR_CD : REV/EXP 동일 Invoice No를 가지도록 한다.
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchNewInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchNewInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT @[acctg_crr_cd]||NVL(SUBSTR(@[acct_yrmon],3) ,TO_CHAR(SYSDATE,'RRMM'))||TRIM(TO_CHAR(NVL(MAX(TO_NUMBER(SUBSTR(INV.INV_NO, 8))), 0) + 1,'000')) AS NEW_INV_NO " ).append("\n"); 
		query.append("  FROM JOO_INVOICE INV" ).append("\n"); 
		query.append(" WHERE INV.ACCT_YRMON   = NVL(@[acct_yrmon], TO_CHAR(SYSDATE,'YYYYMM'))" ).append("\n"); 
		query.append("   AND INV.ACCTG_CRR_CD = @[acctg_crr_cd]" ).append("\n"); 

	}
}