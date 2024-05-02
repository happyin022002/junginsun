/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchNonShippingARChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2010.02.23 박정진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungJin, Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchNonShippingARChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchNonShippingARChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchNonShippingARChargeRSQL").append("\n"); 
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
		query.append("SELECT 'CR' DR_CR," ).append("\n"); 
		query.append("  B.ACCT_CD," ).append("\n"); 
		query.append("  B.CHG_FULL_NM," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD||LPAD(A.ACT_CUST_SEQ, 6, '0') CUST_CODE," ).append("\n"); 
		query.append("  A.POL_CD CITY," ).append("\n"); 
		query.append("  B.CURR_CD," ).append("\n"); 
		query.append("  B.CHG_AMT," ).append("\n"); 
		query.append("  B.CHG_RMK," ).append("\n"); 
		query.append("  B.INV_REV_TP_SRC_CD," ).append("\n"); 
		query.append("  B.CHG_CD," ).append("\n"); 
		query.append("  B.REP_CHG_CD," ).append("\n"); 
		query.append("  B.INV_XCH_RT," ).append("\n"); 
		query.append("  B.CHG_SEQ," ).append("\n"); 
		query.append("  DECODE(B.TVA_FLG, 'Y', '1', 'N', '0') TVA_FLG," ).append("\n"); 
		query.append("  B.MNL_FLG" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("  INV_AR_CHG B," ).append("\n"); 
		query.append("  MDM_CURRENCY D" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("  AND A.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("  AND A.ACCT_CD = '111091'" ).append("\n"); 
		query.append("ORDER BY A.AR_IF_NO, B.CHG_SEQ" ).append("\n"); 

	}
}