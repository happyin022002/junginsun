/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsRailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
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

public class CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsRailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR HEADER  status UPDATE(RAIL)
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsRailUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COST_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsRailUSQL").append("\n"); 
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
		query.append("UPDATE 		TRS_TRSP_RAIL_INV_WRK      		                			   		" ).append("\n"); 
		query.append("SET 		TRSP_INV_AUD_STS_CD = 'AR'      		                		" ).append("\n"); 
		query.append("		, 	CSR_NO 				= @[CSR_NO]      		                			" ).append("\n"); 
		query.append("		, 	UPD_USR_ID 			= @[CRE_USR_ID]" ).append("\n"); 
		query.append("		, 	UPD_DT 				= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[COST_OFC_CD])   " ).append("\n"); 
		query.append("        ,   COST_OFC_CD = @[COST_OFC_CD]   " ).append("\n"); 
		query.append("WHERE 		INV_NO 				= @[INV_NO]" ).append("\n"); 
		query.append("AND 		INV_VNDR_SEQ 		= @[INV_VNDR_SEQ]" ).append("\n"); 

	}
}