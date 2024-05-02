/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueDBDAOModifyIDASplitFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOModifyIDASplitFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify IDA Split Flg
	  * </pre>
	  */
	public InvoiceIssueDBDAOModifyIDASplitFlgUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOModifyIDASplitFlgUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN" ).append("\n"); 
		query.append("SET IDA_INV_SPLIT_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE AR_IF_NO IN (" ).append("\n"); 
		query.append("        SELECT AR_IF_NO" ).append("\n"); 
		query.append("        FROM INV_AR_MN A" ).append("\n"); 
		query.append("        WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        AND BL_SRC_NO  = @[bl_src_no]" ).append("\n"); 
		query.append("        AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("        AND BL_INV_CFM_DT IS NOT NULL " ).append("\n"); 
		query.append("        AND (((EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND NVL(IDA_ISS_TP_CD, 'P') IN ('T','C','D')) " ).append("\n"); 
		query.append("                 OR EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("                AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("            OR (NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND NVL(IDA_ISS_TP_CD, 'P') IN ('T','C','D'))" ).append("\n"); 
		query.append("                AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                        AND BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("                        AND NVL(IDA_INV_SPLIT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("                 AND INV_CLR_FLG = 'N'))" ).append("\n"); 
		query.append("             )" ).append("\n"); 

	}
}