/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOTDRCarrierByPeriodAndLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.11.12 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOTDRCarrierByPeriodAndLaneRSQL implements ISQLTemplate{

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
	public JOOFindCodeAndCheckDBDAOTDRCarrierByPeriodAndLaneRSQL(){
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
		query.append("FileName : JOOFindCodeAndCheckDBDAOTDRCarrierByPeriodAndLaneRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT P.OPR_CD CODE" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD S, BAY_PLAN P" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND ( (S.VPS_ETA_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                        AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR S.VPS_ETA_DT IS NULL )" ).append("\n"); 
		query.append("AND S.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("AND S.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO = P.VOY_NO" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("AND S.VPS_PORT_CD = P.PORT_CD" ).append("\n"); 
		query.append("#if (${rlane_cd} == 'QIS')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" 'DYP' AS CODE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}