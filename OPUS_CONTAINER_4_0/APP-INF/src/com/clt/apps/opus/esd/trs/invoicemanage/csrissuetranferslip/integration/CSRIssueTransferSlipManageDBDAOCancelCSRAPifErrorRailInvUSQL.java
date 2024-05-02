/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorRailInvUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
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

public class CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorRailInvUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR cancel시 TRS_TRSP_RAIL_INV_WRK update
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorRailInvUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorRailInvUSQL").append("\n"); 
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
		query.append("UPDATE 		TRS_TRSP_RAIL_INV_WRK    											" ).append("\n"); 
		query.append("SET			TRSP_INV_AUD_STS_CD = 'CF'," ).append("\n"); 
		query.append("			UPD_USR_ID 			= @[USR_ID]," ).append("\n"); 
		query.append("			LOCL_UPD_DT			=  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)," ).append("\n"); 
		query.append("			UPD_DT 				=  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)," ).append("\n"); 
		query.append("			CSR_NO 				= ''," ).append("\n"); 
		query.append("			GL_DT 				= ''  											" ).append("\n"); 
		query.append("WHERE 		CSR_NO 				= @[CSR_NO]" ).append("\n"); 

	}
}