/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchSplitBLListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchSplitBLListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Split BL List
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchSplitBLListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchSplitBLListRSQL").append("\n"); 
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
		query.append("SELECT B.BL_SRC_NO, B.MAX_AR_IF_NO, B.BL_CNT, A.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("    (SELECT BL_SRC_NO" ).append("\n"); 
		query.append("           , MAX(AR_IF_NO) MAX_AR_IF_NO" ).append("\n"); 
		query.append("           , (SELECT COUNT(DISTINCT BL_SRC_NO)" ).append("\n"); 
		query.append("              FROM INV_AR_MN" ).append("\n"); 
		query.append("              WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("              AND BL_SRC_NO IN (${bl_nos})) BL_CNT" ).append("\n"); 
		query.append("    FROM INV_AR_MN MN" ).append("\n"); 
		query.append("    WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("    AND BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append("    AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                FROM INV_AR_MN" ).append("\n"); 
		query.append("                WHERE AR_OFC_CD = MN.AR_OFC_CD" ).append("\n"); 
		query.append("                AND BL_SRC_NO = MN.BL_SRC_NO" ).append("\n"); 
		query.append("                AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                AND NVL(INV_SPLIT_CD, 'N') = 'S'" ).append("\n"); 
		query.append("                AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                AND BL_INV_CFM_DT IS NOT NULL)" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                FROM INV_AR_MN" ).append("\n"); 
		query.append("                WHERE AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                  FROM INV_AR_MN" ).append("\n"); 
		query.append("                                  WHERE AR_OFC_CD = MN.AR_OFC_CD " ).append("\n"); 
		query.append("                                  AND BL_SRC_NO = MN.BL_SRC_NO" ).append("\n"); 
		query.append("                                  AND REV_TP_CD <> 'M')" ).append("\n"); 
		query.append("                AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("                AND NVL(INV_SPLIT_CD, 'N') = 'N')" ).append("\n"); 
		query.append("    GROUP BY BL_SRC_NO) B" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.MAX_AR_IF_NO" ).append("\n"); 

	}
}