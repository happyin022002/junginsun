/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ServiceDBDAOSearchSlaneRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOSearchSlaneRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request VSL Code 상세 내용 조회
	  * </pre>
	  */
	public ServiceDBDAOSearchSlaneRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOSearchSlaneRqstRSQL").append("\n"); 
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
		query.append("SELECT VSL.VSL_SLAN_CD " ).append("\n"); 
		query.append("	  ,VSL.VSL_SLAN_NM" ).append("\n"); 
		query.append("      ,VSL.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("      ,VSL.VSL_TP_CD" ).append("\n"); 
		query.append("      ,VSL.FDR_DIV_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(VSL.ST_EFF_DT, 'YYYYMMDD'), 'YYYY-MM-DD') ST_EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(VSL.END_EFF_DT, 'YYYYMMDD'), 'YYYY-MM-DD') END_EFF_DT" ).append("\n"); 
		query.append("      ,VSL.CO_CD" ).append("\n"); 
		query.append("      ,VSL.DELT_FLG" ).append("\n"); 
		query.append("      ,DIR.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("      ,DIR.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("      ,DIR.DELT_FLG DIR_DELT_FLG" ).append("\n"); 
		query.append("      ,VSL.MODI_VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,VSL.MODI_VSL_SLAN_CD2" ).append("\n"); 
		query.append("      ,VSL.MODI_VIP_TEAM_CD" ).append("\n"); 
		query.append("      ,DIR.MODI_VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("      ,VSL.MODI_COST_CTR_CD" ).append("\n"); 
		query.append("  FROM MDM_VSL_SVC_LANE_RQST VSL" ).append("\n"); 
		query.append("      ,MDM_VSL_SVC_LANE_DIR_RQST DIR" ).append("\n"); 
		query.append(" WHERE VSL.RQST_NO = DIR.RQST_NO(+)" ).append("\n"); 
		query.append("   AND VSL.RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append(" ORDER BY DIR_DELT_FLG, DIR.VSL_SLAN_DIR_SEQ" ).append("\n"); 

	}
}