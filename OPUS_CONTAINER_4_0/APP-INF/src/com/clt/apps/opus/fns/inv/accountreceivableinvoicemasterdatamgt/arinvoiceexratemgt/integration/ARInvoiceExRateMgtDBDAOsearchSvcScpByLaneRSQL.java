/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOsearchSvcScpByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOsearchSvcScpByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] ARInvoiceExRateMgtDBDAO::searchSvcScpByLane ( vvd )  
	  * Vessel Schedule 의 Lane 으로 Service Scope 을 구해 List에 Setting한다.
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOsearchSvcScpByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOsearchSvcScpByLaneRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP_LANE" ).append("\n"); 
		query.append(" WHERE VSL_SLAN_CD IN (SELECT SLAN_CD" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                          AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                          AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("					   UNION ALL" ).append("\n"); 
		query.append("                       SELECT SLAN_CD" ).append("\n"); 
		query.append("                         FROM BKG_VVD" ).append("\n"); 
		query.append("                        WHERE BKG_NO IN (SELECT BKG_NO" ).append("\n"); 
		query.append("                                           FROM BKG_VVD" ).append("\n"); 
		query.append("                                          WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("                          AND VSL_PRE_PST_CD = 'T')" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append(" ORDER BY SVC_SCP_CD" ).append("\n"); 

	}
}