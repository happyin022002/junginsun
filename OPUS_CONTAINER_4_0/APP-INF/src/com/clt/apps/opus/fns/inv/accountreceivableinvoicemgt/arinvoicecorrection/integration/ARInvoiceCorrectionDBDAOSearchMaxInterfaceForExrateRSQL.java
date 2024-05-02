/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchMaxInterfaceForExrateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.30 
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

public class ARInvoiceCorrectionDBDAOSearchMaxInterfaceForExrateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchMaxInterfaceForExrateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchMaxInterfaceForExrateRSQL").append("\n"); 
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
		query.append("SELECT AR_IF_NO" ).append("\n"); 
		query.append("  FROM INV_AR_MN" ).append("\n"); 
		query.append(" WHERE AR_IF_NO IN (SELECT MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                      FROM INV_AR_MN" ).append("\n"); 
		query.append("                     WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                       AND BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                       AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                       AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                       AND NVL(INV_SPLIT_CD, 'N') NOT IN ('S','X'))" ).append("\n"); 
		query.append("   AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND NVL(INV_DELT_DIV_CD, 'N') = 'N'" ).append("\n"); 
		query.append("   " ).append("\n"); 

	}
}