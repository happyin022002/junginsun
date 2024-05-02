/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchOfficeDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.30 이용태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchOfficeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOSearchOfficeDetailRSQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchOfficeDetailRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchOfficeDetailRSQL").append("\n"); 
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
		query.append("    OFC_CD," ).append("\n"); 
		query.append("    OFC_ENG_NM,     " ).append("\n"); 
		query.append("    OFC_ADDR," ).append("\n"); 
		query.append("    SUBSTR(LOC_CD,1,2) AS LOC_CD," ).append("\n"); 
		query.append("    OFC_PHN_NO," ).append("\n"); 
		query.append("    OFC_FAX_NO" ).append("\n"); 
		query.append(" FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE OFC_CD = @[ofc_cd] and DELT_FLG='N'" ).append("\n"); 

	}
}