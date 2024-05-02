/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOcheckContainerNoNotLikeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOcheckContainerNoNotLikeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOcheckContainerNoNotLikeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOcheckContainerNoNotLikeRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO," ).append("\n"); 
		query.append("       CNMV_STS_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CRNT_YD_CD," ).append("\n"); 
		query.append("       ACIAC_DIV_CD," ).append("\n"); 
		query.append("       CO_CRE_FLG," ).append("\n"); 
		query.append("       IMDT_EXT_FLG," ).append("\n"); 
		query.append("	   CNMV_DT," ).append("\n"); 
		query.append("       FULL_FLG" ).append("\n"); 
		query.append("  FROM (SELECT CNTR_NO," ).append("\n"); 
		query.append("               CNMV_STS_CD," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               CRNT_YD_CD," ).append("\n"); 
		query.append("               ACIAC_DIV_CD," ).append("\n"); 
		query.append("               CO_CRE_FLG," ).append("\n"); 
		query.append("               IMDT_EXT_FLG," ).append("\n"); 
		query.append("			   TO_CHAR(CNMV_DT, 'YYYY-MM-DD HH24:MI:SS') AS CNMV_DT," ).append("\n"); 
		query.append("               FULL_FLG" ).append("\n"); 
		query.append("          FROM MST_CONTAINER" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("         WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ORDER BY CNMV_DT DESC)" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}