/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfacePayGroupExistsCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.12 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfacePayGroupExistsCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfacePayGroupExistsCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfacePayGroupExistsCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfacePayGroupExistsCheckRSQL").append("\n"); 
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
		query.append("SELECT  SLD.lU_CD AS PAYGROUP_LOOKUP_CODE" ).append("\n"); 
		query.append("   FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("         , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("   WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("   AND     SLH.LU_TP_CD = 'PAY GROUP'" ).append("\n"); 
		query.append("   AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("   AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("   AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("   AND     SLD.LU_CD = @[pay_grp_lu_cd]" ).append("\n"); 
		query.append("   AND     (((SELECT MO.VNDR_CNT_CD FROM MDM_ORGANIZATION MO WHERE MO.OFC_CD = UPPER(@[ofc_cd])) = 'KR' AND SLD.ATTR_CTNT1 like 'SEL%')" ).append("\n"); 
		query.append("            OR " ).append("\n"); 
		query.append("           (SLD.ATTR_CTNT1 = @[ofc_cd]))" ).append("\n"); 

	}
}