/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AvailabilityDBDAOupdFirstRlsDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.08.11 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.availability.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailabilityDBDAOupdFirstRlsDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pickup container number가 처음으로 release될때 date update
	  * </pre>
	  */
	public AvailabilityDBDAOupdFirstRlsDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.availability.integration").append("\n"); 
		query.append("FileName : AvailabilityDBDAOupdFirstRlsDtUSQL").append("\n"); 
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
		query.append("UPDATE BKG_PKUP_NTC_PKUP_NO                                          	  	" ).append("\n"); 
		query.append("SET PKUP_NO_N1ST_RLSE_DT = globaldate_pkg.time_local_ofc_fnc('NYCSC')     	" ).append("\n"); 
		query.append("WHERE 1=1           	                                                              	" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]                                            				" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]                                              				" ).append("\n"); 
		query.append("AND PKUP_NO_N1ST_RLSE_DT is NULL" ).append("\n"); 

	}
}