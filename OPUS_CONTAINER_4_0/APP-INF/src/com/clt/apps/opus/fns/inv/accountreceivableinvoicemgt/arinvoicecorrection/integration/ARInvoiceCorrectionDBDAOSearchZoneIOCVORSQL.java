/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchZoneIOCVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.22 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchZoneIOCVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceCorrectionDBDAO::searchZoneIOC ( pol , pod )
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchZoneIOCVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  DECODE(MIN(pol_conti)||MIN(pod_conti), 'AA','IA', 'EE','IE','MM','IM'," ).append("\n"); 
		query.append("'EF','IE','FE','IE','FF','IE','OO') zone_ioc" ).append("\n"); 
		query.append("FROM   ( SELECT conti_cd pol_conti, NULL pod_conti, sconti_cd" ).append("\n"); 
		query.append("FROM  MDM_LOCATION" ).append("\n"); 
		query.append("WHERE  loc_cd =@[pol_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NULL pol_conti, conti_cd pod_conti, NULL sconti_cd" ).append("\n"); 
		query.append("FROM  MDM_LOCATION" ).append("\n"); 
		query.append("WHERE  loc_cd =@[pod_cd] )" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchZoneIOCVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}