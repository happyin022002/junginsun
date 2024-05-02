/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RestuffingContainerRegistrationDBDAOGetContainerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RestuffingContainerRegistrationDBDAOGetContainerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public RestuffingContainerRegistrationDBDAOGetContainerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration").append("\n"); 
		query.append("FileName : RestuffingContainerRegistrationDBDAOGetContainerInfoRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CO_CRE_FLG," ).append("\n"); 
		query.append("       IMDT_EXT_FLG," ).append("\n"); 
		query.append("       AGMT_CTY_CD," ).append("\n"); 
		query.append("       AGMT_SEQ," ).append("\n"); 
		query.append("       CNMV_STS_CD," ).append("\n"); 
		query.append("       ACIAC_DIV_CD," ).append("\n"); 
		query.append("       LSTM_CD," ).append("\n"); 
		query.append("       TO_CHAR (GLOBALDATE_PKG.TIME_CONV_FNC (LOC_CD, NVL (CNMV_DT, TO_DATE ('19510101', 'YYYYMMDD')), 'GMT'), 'YYYYMMDDHH24MISS') AS EVNT_DT," ).append("\n"); 
		query.append("       TO_CHAR (GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5), TO_DATE (REPLACE (@[evnt_dt], '-', ''), 'YYYYMMDDHH24MI'), 'GMT'), 'YYYYMMDDHH24MISS') AS COMP_DT," ).append("\n"); 
		query.append("       TO_CHAR (CNMV_DT, 'YYYYMMDDHH24MISS') AS CNMV_DT," ).append("\n"); 
		query.append("       CRNT_YD_CD," ).append("\n"); 
		query.append("       NVL (UCLM_LS_DIV_CD, 'X') AS UCLM_LS_DIV_CD," ).append("\n"); 
		query.append("       SYS_AREA_GRP_ID AS SVR_ID," ).append("\n"); 
		query.append("       PRE_STS_FLG" ).append("\n"); 
		query.append("  FROM MST_CONTAINER" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}