/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchSplitARInvoiceByIfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchSplitARInvoiceByIfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchSplitARInvoiceByIfNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchSplitARInvoiceByIfNoRSQL").append("\n"); 
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
		query.append("SELECT 'X' CHK_SPLIT_IF_NO" ).append("\n"); 
		query.append("  FROM INV_AR_MN MN" ).append("\n"); 
		query.append(" WHERE MN.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND MN.REV_TP_CD<> 'M'  " ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'  AND  NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X')" ).append("\n"); 
		query.append("   AND NVL(MN.INV_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                   FROM INV_AR_CHG" ).append("\n"); 
		query.append("				   WHERE AR_IF_NO = MN.AR_IF_NO" ).append("\n"); 
		query.append("				   AND TJ_SRC_NM = 'VAT'" ).append("\n"); 
		query.append("				   AND CURR_CD <> MN.LOCL_CURR_CD)" ).append("\n"); 

	}
}