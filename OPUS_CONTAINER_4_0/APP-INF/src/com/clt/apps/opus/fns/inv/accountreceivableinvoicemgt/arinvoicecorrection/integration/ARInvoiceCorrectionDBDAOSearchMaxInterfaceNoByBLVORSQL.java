/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchMaxInterfaceNoByBLVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
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

public class ARInvoiceCorrectionDBDAOSearchMaxInterfaceNoByBLVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_AR_MN 테이블에서 select
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchMaxInterfaceNoByBLVORSQL(){
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
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchMaxInterfaceNoByBLVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(INV_DELT_DIV_CD,'X','X',AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("  FROM INV_AR_MN" ).append("\n"); 
		query.append(" WHERE AR_IF_NO = (SELECT SUBSTR(MAX(DECODE(REV_TP_CD, 'M', '1', '2')||AR_IF_NO), 2) --MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("                     FROM INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#if (${bl_no} !='') " ).append("\n"); 
		query.append("                      AND BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("					  AND NVL(INV_SPLIT_CD,'N') NOT IN ('M','X')" ).append("\n"); 
		query.append("					  AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} !='') " ).append("\n"); 
		query.append("                      AND AR_IF_NO IN (SELECT AR_IF_NO " ).append("\n"); 
		query.append("                                         FROM INV_AR_ISS_DTL " ).append("\n"); 
		query.append("                                        WHERE INV_NO = @[inv_no])" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("					  AND NVL(INV_CLR_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("AND   OTS_PAY_CD IS NULL AND ORG_INV_NO IS NULL -- Except Migration Data " ).append("\n"); 

	}
}