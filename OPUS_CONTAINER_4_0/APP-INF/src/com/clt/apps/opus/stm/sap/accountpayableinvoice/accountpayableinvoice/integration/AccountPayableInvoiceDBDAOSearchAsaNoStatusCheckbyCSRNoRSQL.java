/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchAsaNoStatusCheckbyCSRNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchAsaNoStatusCheckbyCSRNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR  No을 조건으로 하여 해당 ASA 전표인 경우 최종 SAR OTS로 I/F 하기 전에 해당 ASA의 Open/Close 여부를 체크
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchAsaNoStatusCheckbyCSRNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchAsaNoStatusCheckbyCSRNoRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SAM.ASA_FSH_DT, NULL, 'O', 'C') AS ASA_STATUS" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAR_ASA_MST SAM" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE   SIH.ATTR_CATE_NM = 'INVOICES'" ).append("\n"); 
		query.append("AND     NVL(SIH.ATTR_CTNT5, SIH.ATTR_CTNT2) = SAM.ASA_NO" ).append("\n"); 
		query.append("AND     SAM.OFC_CD = MO.OFC_CD " ).append("\n"); 
		query.append("AND     SAM.CURR_CD = SIH.INV_CURR_CD" ).append("\n"); 
		query.append("AND     SIH.INV_AMT = 0" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("AND     SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}