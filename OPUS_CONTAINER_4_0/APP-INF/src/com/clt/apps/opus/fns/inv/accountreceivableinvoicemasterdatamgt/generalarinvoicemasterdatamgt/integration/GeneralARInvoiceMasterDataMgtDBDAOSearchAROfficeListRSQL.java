/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOSearchAROfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.11.09 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOSearchAROfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOSearchAROfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOSearchAROfficeListRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD AR_OFC_CD" ).append("\n"); 
		query.append("	 , @[ofc_cd] AR_OFC_CD_LOGIN" ).append("\n"); 
		query.append("	 , DECODE(A.DELT_FLG,'Y','X','') DELT_FLG" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("   , COM_SYS_AREA_GRP_ID B" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("       SELECT C.SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("         FROM COM_SYS_AREA_GRP_ID C, MDM_LOCATION D, MDM_ORGANIZATION E" ).append("\n"); 
		query.append("        WHERE E.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("          AND E.LOC_CD = D.LOC_CD" ).append("\n"); 
		query.append("          AND C.CNT_CD = D.CNT_CD" ).append("\n"); 
		query.append("          AND C.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("     ) C" ).append("\n"); 
		query.append("WHERE SUBSTR(A.LOC_CD,1,2) = B.CNT_CD" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND A.AR_HD_QTR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY A.OFC_CD" ).append("\n"); 

	}
}