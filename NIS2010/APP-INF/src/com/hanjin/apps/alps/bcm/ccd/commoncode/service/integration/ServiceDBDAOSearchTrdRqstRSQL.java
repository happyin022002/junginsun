/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ServiceDBDAOSearchTrdRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOSearchTrdRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Trd code 조회
	  * </pre>
	  */
	public ServiceDBDAOSearchTrdRqstRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOSearchTrdRqstRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD " ).append("\n"); 
		query.append("	  ,TRD_NM" ).append("\n"); 
		query.append("      ,VSL_TP_CD" ).append("\n"); 
		query.append("      ,FM_CONTI_CD" ).append("\n"); 
		query.append("      ,TO_CONTI_CD" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(ST_EFF_DT, 'YYYY-MM-DD') ST_EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(END_EFF_DT, 'YYYY-MM-DD') END_EFF_DT" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,MODI_COST_CTR_CD" ).append("\n"); 
		query.append("  FROM MDM_TRD_RQST" ).append("\n"); 
		query.append(" WHERE RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}