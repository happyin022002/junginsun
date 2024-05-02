/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LocationDBDAOSearchCountryInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOSearchCountryInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Country Info Search
	  * </pre>
	  */
	public LocationDBDAOSearchCountryInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration ").append("\n"); 
		query.append("FileName : LocationDBDAOSearchCountryInfoRSQL").append("\n"); 
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
		query.append("SELECT  RE.CNT_CD" ).append("\n"); 
		query.append("       ,CO.SCONTI_CD" ).append("\n"); 
		query.append("       ,SU.CONTI_CD" ).append("\n"); 
		query.append("  FROM  MDM_REGION RE" ).append("\n"); 
		query.append("       ,MDM_COUNTRY CO" ).append("\n"); 
		query.append("       ,MDM_SUBCONTINENT SU" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  RE.RGN_CD = @[rgn_cd]" ).append("\n"); 
		query.append("   AND  RE.CNT_CD = CO.CNT_CD" ).append("\n"); 
		query.append("   AND  CO.SCONTI_CD = SU.SCONTI_CD" ).append("\n"); 

	}
}