/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationDBDAOsearchChssPoolDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.17 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmValidationDBDAOsearchChssPoolDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CgmValidationDBDAOsearchChssPoolDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
		query.append("FileName : CgmValidationDBDAOsearchChssPoolDataRSQL").append("\n"); 
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
		query.append("SELECT A.CHSS_POOL_CD" ).append("\n"); 
		query.append(",A.CHSS_POOL_NM" ).append("\n"); 
		query.append(",A.POOL_MGMT_CO_CD" ).append("\n"); 
		query.append(",A.POOL_MGMT_CO_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM CGM_CHSS_POOL A" ).append("\n"); 
		query.append("WHERE A.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 

	}
}