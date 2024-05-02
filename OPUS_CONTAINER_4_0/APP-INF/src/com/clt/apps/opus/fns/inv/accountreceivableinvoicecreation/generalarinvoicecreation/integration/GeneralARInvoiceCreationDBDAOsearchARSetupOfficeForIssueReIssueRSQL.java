/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchARSetupOfficeForIssueReIssueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.12.03 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchARSetupOfficeForIssueReIssueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchARSetupOfficeForIssueReIssueRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchARSetupOfficeForIssueReIssueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchARSetupOfficeForIssueReIssueRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[inv_src_no], 'TPB', NVL(N3PTY_BIL_AR_INV_FLG ,'N')" ).append("\n"); 
		query.append(", 'DEM', NVL(DMDT_AR_INV_ISS_FLG,'N')" ).append("\n"); 
		query.append(", 'DET', NVL(DMDT_AR_INV_ISS_FLG,'N')" ).append("\n"); 
		query.append(", 'N') ISSUE_FLAG" ).append("\n"); 
		query.append(", DECODE(DECODE(@[inv_src_no], 'TPB', NVL(N3PTY_BIL_AR_INV_FLG,'N')" ).append("\n"); 
		query.append(", 'DEM', NVL(DMDT_AR_INV_ISS_FLG,'N')" ).append("\n"); 
		query.append(", 'DET', NVL(DMDT_AR_INV_ISS_FLG,'N')" ).append("\n"); 
		query.append(", 'N'), 'N'" ).append("\n"); 
		query.append(", 'Y') REISSUE_FLAG" ).append("\n"); 
		query.append("FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND OTS_SMRY_CD IN ('CLR','INV')" ).append("\n"); 

	}
}