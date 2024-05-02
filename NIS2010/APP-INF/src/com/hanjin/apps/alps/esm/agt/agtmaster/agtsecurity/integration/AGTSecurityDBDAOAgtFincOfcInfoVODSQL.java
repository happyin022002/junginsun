/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTSecurityDBDAOAgtFincOfcInfoVODSQL.java
*@FileTitle : Estimation Closing Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.18 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung-won Chu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTSecurityDBDAOAgtFincOfcInfoVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTSecurityDBDAOAgtFincOfcInfoVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.integration").append("\n"); 
		query.append("FileName : AGTSecurityDBDAOAgtFincOfcInfoVODSQL").append("\n"); 
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
		query.append("UPDATE AGT_FINC_OFC_INFO" ).append("\n"); 
		query.append("SET DELT_FLG   = 'Y'," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE AGN_CD     = @[agn_cd]" ).append("\n"); 

	}
}