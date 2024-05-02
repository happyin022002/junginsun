/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckDomBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOcheckDomBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DOM_BOOKING에서 ST_TURN_FLG를 확인한다.
	  * --------------------------------------------------------
	  * History
	  * 2011.01.19 김상수 [CHM-201108428-01] [CTM] Domestic Movement Street Turn 보완
	  *                    - ID status 이후 CO status 입력시 Domestic Booking 생성일을 기준으로
	  *                      data 생성 시 사용되는 DateTime포맷 변경
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckDomBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckDomBookingRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(DOM_BOOKING XAK2DOM_BOOKING) */" ).append("\n"); 
		query.append("       NVL (ST_TURN_FLG, 'N') ST_TURN_FLG," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MI') < CRE_DT AND NVL (ST_TURN_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("             THEN TO_CHAR (TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("          WHEN CRE_DT < TO_DATE (@[pre_evnt_dt], 'YYYYMMDDHH24MI') AND NVL (ST_TURN_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("             THEN TO_CHAR (TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("          ELSE TO_CHAR (CRE_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("       END CRE_DT" ).append("\n"); 
		query.append("  FROM DOM_BOOKING" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CRE_DT > SYSDATE - 15" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}