/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LocationDBDAOsearchLseCoYdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOsearchLseCoYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Leasing Company Yard를 조회합니다.
	  * </pre>
	  */
	public LocationDBDAOsearchLseCoYdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOsearchLseCoYdRSQL").append("\n"); 
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
		query.append("SELECT LSE_CO_YD_NM," ).append("\n"); 
		query.append("       ONF_HIR_YD_FLG," ).append("\n"); 
		query.append("       YD_ADDR," ).append("\n"); 
		query.append("       INTL_PHN_NO," ).append("\n"); 
		query.append("       PHN_NO," ).append("\n"); 
		query.append("       FAX_NO," ).append("\n"); 
		query.append("       YD_EML," ).append("\n"); 
		query.append("       YD_PIC_NM," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ1," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ2," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ3," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ4," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ5," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ6," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ7," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ8," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ9," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ10," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ11," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ12," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ13," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ14," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ15," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ16," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ17," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ18," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ19," ).append("\n"); 
		query.append("       LSE_CO_VNDR_SEQ20," ).append("\n"); 
		query.append("       DELT_FLG," ).append("\n"); 
		query.append("       MODI_LSE_CO_YD_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("WHERE LSE_CO_YD_CD = @[lse_co_yd_cd]" ).append("\n"); 

	}
}