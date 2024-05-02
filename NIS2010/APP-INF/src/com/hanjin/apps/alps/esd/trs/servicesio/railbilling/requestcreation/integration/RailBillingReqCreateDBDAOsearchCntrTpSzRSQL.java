/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchCntrTpSzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.27 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchCntrTpSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrTpSz
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchCntrTpSzRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchCntrTpSzRSQL").append("\n"); 
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
		query.append("SELECT  	  a.cntr_no" ).append("\n"); 
		query.append(",a.cntr_tpsz_cd" ).append("\n"); 
		query.append(",b.cntr_tpsz_rmk" ).append("\n"); 
		query.append("FROM mst_container a, mdm_cntr_tp_sz b" ).append("\n"); 
		query.append("WHERE a.cntr_tpsz_cd = b.cntr_tpsz_cd" ).append("\n"); 
		query.append("AND a.cntr_no IN (" ).append("\n"); 
		query.append("#foreach( ${cntrKey} in ${cntrNoList})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$cntrKey.velParamField1'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$cntrKey.velParamField1'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}