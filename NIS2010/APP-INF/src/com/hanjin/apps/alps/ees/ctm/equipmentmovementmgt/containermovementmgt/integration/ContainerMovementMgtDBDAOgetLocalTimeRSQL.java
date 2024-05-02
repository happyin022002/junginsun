/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetLocalTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.07.24 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetLocalTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현지 시간을 구해온다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetLocalTimeRSQL(){
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
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetLocalTimeRSQL").append("\n"); 
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
		query.append("SELECT EVENT_DATE, LOCAL_DATE," ).append("\n"); 
		query.append("CASE WHEN EVENT_DATE = LOCAL_DATE THEN 0" ).append("\n"); 
		query.append("WHEN EVENT_DATE > LOCAL_DATE THEN 1" ).append("\n"); 
		query.append("ELSE -1" ).append("\n"); 
		query.append("END  BID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT TO_CHAR" ).append("\n"); 
		query.append("(GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5)," ).append("\n"); 
		query.append("TO_DATE (@[cnmv_evnt_dt]," ).append("\n"); 
		query.append("'yyyy-mm-dd hh24:mi'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'GMT'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymmddhh24mi'" ).append("\n"); 
		query.append(") EVENT_DATE," ).append("\n"); 
		query.append("TO_CHAR" ).append("\n"); 
		query.append("(GLOBALDATE_PKG.TIME_CONV_FNC" ).append("\n"); 
		query.append("('KRPUS'," ).append("\n"); 
		query.append("TO_DATE (TO_CHAR (  SYSDATE" ).append("\n"); 
		query.append("+ DECODE (@[mvmt_sts_cd]," ).append("\n"); 
		query.append("'VL', 10," ).append("\n"); 
		query.append("'VD', 10," ).append("\n"); 
		query.append("0.125" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyy-mm-dd hh24:mi'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyy-mm-dd hh24:mi'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("SUBSTR(@[org_yd_cd], 0, 5)" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymmddhh24mi'" ).append("\n"); 
		query.append(") LOCAL_DATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}