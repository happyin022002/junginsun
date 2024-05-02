/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchSvcScpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchSvcScpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchSvcScpRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchSvcScpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd_por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchSvcScpRSQL").append("\n"); 
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
		query.append("SELECT distinct CASE WHEN CNT.CNT = 1 " ).append("\n"); 
		query.append("                     THEN SINGLE.svcScpCd" ).append("\n"); 
		query.append("                     ELSE MULTI.svcScpCd end SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM (SELECT count(*)  CNT" ).append("\n"); 
		query.append("          FROM MDM_svc_scp_lmt org" ).append("\n"); 
		query.append("               , MDM_svc_scp_lmt dest" ).append("\n"); 
		query.append("         WHERE org.rgn_cd           = @[rgn_cd_por]" ).append("\n"); 
		query.append("           AND org.ORG_DEST_CD      = 'O'" ).append("\n"); 
		query.append("           AND org.SVC_SCP_IND_FLG  = 'Y'" ).append("\n"); 
		query.append("           AND dest.rgn_cd          = @[rgn_cd_del]" ).append("\n"); 
		query.append("           AND dest.ORG_DEST_CD     = 'D'" ).append("\n"); 
		query.append("           AND dest.SVC_SCP_IND_FLG = 'Y'" ).append("\n"); 
		query.append("           AND org.svc_scp_cd       = dest.svc_scp_cd" ).append("\n"); 
		query.append("           and org.delt_flg         = 'N'" ).append("\n"); 
		query.append("           and dest.delt_flg        = 'N') CNT" ).append("\n"); 
		query.append("     , (SELECT Max(org.svc_scp_cd) svcScpCd" ).append("\n"); 
		query.append("          FROM MDM_svc_scp_lmt org" ).append("\n"); 
		query.append("               , MDM_svc_scp_lmt dest" ).append("\n"); 
		query.append("               , MDM_svc_scp_lane L" ).append("\n"); 
		query.append("         WHERE org.rgn_cd           = @[rgn_cd_por]" ).append("\n"); 
		query.append("           AND org.ORG_DEST_CD      = 'O'" ).append("\n"); 
		query.append("           AND org.SVC_SCP_IND_FLG  = 'Y'" ).append("\n"); 
		query.append("           and org.delt_flg         = 'N'" ).append("\n"); 
		query.append("           AND dest.rgn_cd          = @[rgn_cd_del]" ).append("\n"); 
		query.append("           AND dest.ORG_DEST_CD     = 'D'" ).append("\n"); 
		query.append("           AND dest.SVC_SCP_IND_FLG = 'Y'" ).append("\n"); 
		query.append("           and dest.delt_flg        = 'N'" ).append("\n"); 
		query.append("           and org.svc_scp_cd       = l.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND org.svc_scp_cd       = dest.svc_scp_cd" ).append("\n"); 
		query.append("           and org.svc_scp_cd       = l.SVC_SCP_CD" ).append("\n"); 
		query.append("           and dest.svc_scp_cd      = l.SVC_SCP_CD" ).append("\n"); 
		query.append("           and l.vsl_slan_cd        = @[lane_cd]) MULTI" ).append("\n"); 
		query.append("     , (SELECT org.svc_scp_cd svcScpCd" ).append("\n"); 
		query.append("          FROM MDM_svc_scp_lmt org" ).append("\n"); 
		query.append("               , MDM_svc_scp_lmt dest" ).append("\n"); 
		query.append("         WHERE org.rgn_cd           = @[rgn_cd_por]" ).append("\n"); 
		query.append("           AND org.ORG_DEST_CD      = 'O'" ).append("\n"); 
		query.append("           AND org.SVC_SCP_IND_FLG  = 'Y'" ).append("\n"); 
		query.append("           AND dest.rgn_cd          = @[rgn_cd_del]" ).append("\n"); 
		query.append("           AND dest.ORG_DEST_CD     = 'D'" ).append("\n"); 
		query.append("           AND dest.SVC_SCP_IND_FLG = 'Y'" ).append("\n"); 
		query.append("           AND org.svc_scp_cd       = dest.svc_scp_cd" ).append("\n"); 
		query.append("           and NVL(org.delt_flg,'N') = 'N'" ).append("\n"); 
		query.append("           and NVL(dest.delt_flg,'N') = 'N') SINGLE" ).append("\n"); 

	}
}