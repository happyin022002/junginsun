/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAORDRCarrierByPeriodAndLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAORDRCarrierByPeriodAndLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.11 김창헌 [CHM-201217413-01]
	  *                    [ALPS JOO] TDR Inquiry by VVD 및 RDR Inquiry by Lane
	  *                    - Sum 기능 추가, 정렬순서 및 표시형식 변경
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAORDRCarrierByPeriodAndLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAORDRCarrierByPeriodAndLaneRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT H.OPR_CD CODE" ).append("\n"); 
		query.append("FROM RDR_ALLOCATION H," ).append("\n"); 
		query.append("     VSK_VSL_PORT_SKD K," ).append("\n"); 
		query.append("     MDM_REV_LANE L" ).append("\n"); 
		query.append("WHERE 1= 1" ).append("\n"); 
		query.append("AND K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                     AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("AND H.VSL_CD = K.VSL_CD" ).append("\n"); 
		query.append("AND H.VOY_NO = K.SKD_VOY_NO" ).append("\n"); 
		query.append("AND H.DIR_CD = K.SKD_DIR_CD" ).append("\n"); 
		query.append("AND K.SLAN_CD = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND L.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}