/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOsearchSplitARInvoiceByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOsearchSplitARInvoiceByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSplitARInvoiceByBL
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOsearchSplitARInvoiceByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOsearchSplitARInvoiceByBLRSQL").append("\n"); 
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
		query.append("SELECT MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_MN A" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ar_ofc_cd]					 " ).append("\n"); 
		query.append("AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(INV_SPLIT_CD,'N') NOT IN ('M','X')" ).append("\n"); 
		query.append("AND BL_INV_CFM_DT IS NOT NULL " ).append("\n"); 
		query.append("#if (${bl_src_no} != '') " ).append("\n"); 
		query.append("AND BL_SRC_NO  = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- 2018.05.16 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append("#if (${ar_ofc_cd} == 'BOMSC') " ).append("\n"); 
		query.append("AND (((EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("               FROM INV_AR_MN" ).append("\n"); 
		query.append("               WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("               AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("               AND NVL(IDA_ISS_TP_CD, 'P') IN ('T','C','D')) " ).append("\n"); 
		query.append("       OR EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                  FROM INV_AR_MN" ).append("\n"); 
		query.append("                  WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                  AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                  AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("      AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("   OR (NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                   FROM INV_AR_MN" ).append("\n"); 
		query.append("                   WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                   AND NVL(IDA_ISS_TP_CD, 'P') IN ('T','C','D'))" ).append("\n"); 
		query.append("       AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                       FROM INV_AR_MN" ).append("\n"); 
		query.append("                       WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                       AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                       AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("       AND INV_CLR_FLG = 'N'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}