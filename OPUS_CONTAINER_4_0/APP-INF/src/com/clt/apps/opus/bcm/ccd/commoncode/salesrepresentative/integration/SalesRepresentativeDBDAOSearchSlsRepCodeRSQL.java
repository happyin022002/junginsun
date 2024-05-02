/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRepresentativeDBDAOSearchSlsRepCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepresentativeDBDAOSearchSlsRepCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SlsRepCode 조회
	  * </pre>
	  */
	public SalesRepresentativeDBDAOSearchSlsRepCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.integration").append("\n"); 
		query.append("FileName : SalesRepresentativeDBDAOSearchSlsRepCodeRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(SREP_CD, 0, 2) CNT_CD" ).append("\n"); 
		query.append("      ,SREP_CD" ).append("\n"); 
		query.append("	  ,OFC_CD" ).append("\n"); 
		query.append("      ,SREP_NM" ).append("\n"); 
		query.append("      ,OFC_TEAM_CD" ).append("\n"); 
		query.append("      ,SEX_CD" ).append("\n"); 
		query.append("      ,SREP_ABBR_NM" ).append("\n"); 
		query.append("      ,IB_SREP_FLG" ).append("\n"); 
		query.append("      ,OB_SREP_FLG" ).append("\n"); 
		query.append("      ,SREP_CD" ).append("\n"); 
		query.append("      ,EMPE_CD" ).append("\n"); 
		query.append("      ,SREP_EML" ).append("\n"); 
		query.append("      ,INTL_MPHN_NO" ).append("\n"); 
		query.append("      ,DELT_FLG	  " ).append("\n"); 
		query.append("	  ,MPHN_NO" ).append("\n"); 
		query.append("--	  ,'' USER_ID" ).append("\n"); 
		query.append("      ,MODI_SREP_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("  FROM MDM_SLS_REP" ).append("\n"); 
		query.append(" WHERE SREP_CD = @[srep_cd]" ).append("\n"); 

	}
}