/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrdPartyDataForCorrectionInvOrg
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL").append("\n"); 
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
		query.append("  FROM MDM_ORGANIZATION ORG, MDM_LOCATION LOC" ).append("\n"); 
		query.append(" WHERE LOC.CNT_CD = 'FR'" ).append("\n"); 
		query.append("   AND ORG.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("   AND ORG.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ORG.OFC_CD = @[user_ofc_cd]      " ).append("\n"); 

	}
}