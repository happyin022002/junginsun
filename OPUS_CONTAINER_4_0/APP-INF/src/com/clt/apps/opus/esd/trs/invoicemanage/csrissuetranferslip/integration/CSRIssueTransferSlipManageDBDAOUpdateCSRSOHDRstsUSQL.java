/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR HEADER status UPDATE
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsUSQL").append("\n"); 
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
		query.append("UPDATE 		TRS_TRSP_INV_WRK  WRK     		                			   		" ).append("\n"); 
		query.append("SET 		WRK.TRSP_INV_AUD_STS_CD = 'AR'      		                		" ).append("\n"); 
		query.append("		, 	WRK.CSR_NO 				= @[CSR_NO]      		                			" ).append("\n"); 
		query.append("		, 	WRK.UPD_USR_ID 			= @[CRE_USR_ID]" ).append("\n"); 
		query.append("		,	WRK.LOCL_UPD_DT       	= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(WRK.CRE_OFC_CD)" ).append("\n"); 
		query.append("		, 	WRK.UPD_DT 				= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(WRK.CRE_OFC_CD)" ).append("\n"); 
		query.append("WHERE 		WRK.INV_NO 				= @[INV_NO]" ).append("\n"); 
		query.append("AND 		WRK.INV_VNDR_SEQ 		= @[INV_VNDR_SEQ]" ).append("\n"); 

	}
}