/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CgmValidationDBDAOsearchOfficeYardControlOfficeMatchDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmValidationDBDAOsearchOfficeYardControlOfficeMatchDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015 조직코드개편 Chang-Young Kim   
	  * </pre>
	  */
	public CgmValidationDBDAOsearchOfficeYardControlOfficeMatchDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
		query.append("FileName : CgmValidationDBDAOsearchOfficeYardControlOfficeMatchDataRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("CASE WHEN @[ofc_cd] = 'SELCON' THEN 'OK'" ).append("\n"); 
		query.append("     WHEN @[ofc_cd] = 'NYCRA' AND CNT_CD IN ('US','CA','MX') THEN 'OK'" ).append("\n"); 
		query.append("     WHEN @[ofc_cd] = 'SINRS' AND CNT_CD IN ('PH') THEN 'OK'" ).append("\n"); 
		query.append("     WHEN @[ofc_cd] =  EQ_CTRL_OFC_CD THEN 'OK'" ).append("\n"); 
		query.append("     ELSE 'Error'" ).append("\n"); 
		query.append("     END CHK" ).append("\n"); 
		query.append(" FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = @[loc_cd]" ).append("\n"); 

	}
}