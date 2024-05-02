/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrdPartyDataForCorrectionInvOrg
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL").append("\n"); 
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
		query.append("SELECT COUNT(ORG.OFC_CD) CNT" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ORG, MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE LOC.CNT_CD = 'FR'" ).append("\n"); 
		query.append("AND ORG.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND ORG.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND ORG.OFC_CD = @[user_ofc_cd]" ).append("\n"); 

	}
}