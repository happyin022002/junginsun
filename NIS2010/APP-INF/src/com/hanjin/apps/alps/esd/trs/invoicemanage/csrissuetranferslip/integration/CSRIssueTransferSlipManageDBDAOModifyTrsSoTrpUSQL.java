/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOModifyTrsSoTrpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOModifyTrsSoTrpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRP FLAG UPDATE
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOModifyTrsSoTrpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOModifyTrsSoTrpUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD  " ).append("\n"); 
		query.append("   SET TRP_FLG = 'Y'" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND (TRSP_SO_OFC_CTY_CD,TRSP_SO_SEQ) IN (SELECT SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("											 	  ,SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("  											  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("      											  ,TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("      											  ,TRS_TRSP_INV_WRK INV" ).append("\n"); 
		query.append(" 											 WHERE SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("										       AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("										       AND SO.INV_NO = INV.INV_NO" ).append("\n"); 
		query.append("											   AND SO.INV_VNDR_SEQ = INV.INV_VNDR_SEQ" ).append("\n"); 
		query.append("											   AND SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("											   AND SO.TRSP_SO_TP_CD ='O'" ).append("\n"); 
		query.append("											   AND SO.TRSP_COST_DTL_MOD_CD = 'ER'" ).append("\n"); 
		query.append("											   AND SO.TRSP_CRR_MOD_CD = 'RD'" ).append("\n"); 
		query.append("											   AND WO.CRE_OFC_CD = 'NYCRAO'" ).append("\n"); 
		query.append("											   AND INV.INV_VNDR_SEQ = 181057" ).append("\n"); 
		query.append("			                                   AND INV.CSR_NO = @[CSR_NO] )" ).append("\n"); 

	}
}