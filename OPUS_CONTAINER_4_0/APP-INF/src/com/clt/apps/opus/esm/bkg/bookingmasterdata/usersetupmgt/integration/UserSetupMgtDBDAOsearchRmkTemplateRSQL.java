/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOsearchRmkTemplateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOsearchRmkTemplateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRmkTemplate
	  * </pre>
	  */
	public UserSetupMgtDBDAOsearchRmkTemplateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOsearchRmkTemplateRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	USR_ID," ).append("\n"); 
		query.append("	TMPLT_TP_CD," ).append("\n"); 
		query.append("	TMPLT_SEQ," ).append("\n"); 
		query.append("	TMPLT_HDR_NM," ).append("\n"); 
		query.append("	TMPLT_CTNT" ).append("\n"); 
		query.append("FROM BKG_USR_TMPLT" ).append("\n"); 
		query.append("WHERE	USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND TMPLT_TP_CD IN ('I','X','E')" ).append("\n"); 

	}
}