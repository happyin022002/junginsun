/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchEURVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.05.10 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchEURVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceExRateMgtDBDAOSearchEURVVDListRSQL
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchEURVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchEURVVDListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT (VSL_CD||SKD_VOY_NO||SKD_DIR_CD) VVD_CD," ).append("\n"); 
		query.append("       VPS_PORT_CD," ).append("\n"); 
		query.append("       'OTH' SVC_SCP_CD," ).append("\n"); 
		query.append("       IO_BND_CD" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("       (SELECT 'I' IO_BND_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'O' IO_BND_CD FROM DUAL) C" ).append("\n"); 
		query.append(" WHERE VSL_CD = substr(@[vvd_cd],0,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = substr(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = substr(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   AND VPS_PORT_CD IN (SELECT LOC_CD FROM MDM_LOCATION  WHERE CONTI_CD IN ('E','F'))" ).append("\n"); 

	}
}