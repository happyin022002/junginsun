/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearhNextOpenedAsaCheckInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearhNextOpenedAsaCheckInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Receipt Entry에서 Reject 처리시 해당 CSR이 ASA 전표이고, ASA No가 Close되어 Reject 할 수 없을 때 Next Open된 ASA No을 가져와 처리
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearhNextOpenedAsaCheckInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearhNextOpenedAsaCheckInfoRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN SIH.INV_AMT = 0 AND SIH.ATTR_CATE_NM = 'INVOICES' AND SIH.INV_CXL_DT IS NULL AND SAM.ASA_FSH_DT IS NULL THEN 'Y' " ).append("\n"); 
		query.append("             WHEN SIH.INV_AMT = 0 AND SIH.ATTR_CATE_NM = 'INVOICES' AND SIH.INV_CXL_DT IS NULL AND SAM.ASA_FSH_DT IS NOT NULL THEN " ).append("\n"); 
		query.append("                  NVL((SELECT  MIN(SAM1.ASA_NO) FROM SAR_ASA_MST SAM1, MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("                       WHERE   MO.AR_OFC_CD = SAM1.AGN_CD AND MO.AR_OFC_CD = SAM1.OFC_CD " ).append("\n"); 
		query.append("                       AND     MO.OFC_CD = @[ofc_cd] AND SAM1.CURR_CD = @[inv_curr_cd] AND SAM1.ASA_NO LIKE SUBSTR(MO.AR_OFC_CD, 1, 3) || '%'" ).append("\n"); 
		query.append("                       AND     SAM1.ASA_FSH_DT IS NULL), 'N')" ).append("\n"); 
		query.append("             ELSE 'Y' " ).append("\n"); 
		query.append("        END AS OPEN_ASA_NO" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAR_ASA_MST SAM" ).append("\n"); 
		query.append("WHERE   SIH.ATTR_CTNT2 = SAM.ASA_NO(+)" ).append("\n"); 
		query.append("AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}