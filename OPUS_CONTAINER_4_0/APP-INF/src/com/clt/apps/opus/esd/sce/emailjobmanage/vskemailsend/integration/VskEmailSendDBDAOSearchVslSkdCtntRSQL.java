/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSendDBDAOSearchVslSkdCtntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.11.29 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VskEmailSendDBDAOSearchVslSkdCtntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslSkdEmlJob 에서 조회된 화주 (eml_grp_id) 와 특정 조건 별로 송신할 email 내역을 가져온다.
	  * </pre>
	  */
	public VskEmailSendDBDAOSearchVslSkdCtntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slanCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskdDurId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration").append("\n"); 
		query.append("FileName : VskEmailSendDBDAOSearchVslSkdCtntRSQL").append("\n"); 
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
		query.append("/* 삼성전자 MAILING SERVICE */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("M.VVD," ).append("\n"); 
		query.append("M.VESSEL_NAME," ).append("\n"); 
		query.append("M.POL," ).append("\n"); 
		query.append("M.LANE," ).append("\n"); 
		query.append("DECODE(M.SKD_CNG_STS_CD, 'S', 'SKIP', M.VPS_ETB_DT) AS VPS_ETB_DT," ).append("\n"); 
		query.append("M.VPS_ETD_DT," ).append("\n"); 
		query.append("M.PF_ETB_DT," ).append("\n"); 
		query.append("M.PF_ETD_DT," ).append("\n"); 
		query.append("M.DELAY_BERTH," ).append("\n"); 
		query.append("M.DELAY_DEP" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(", (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) AS VESSEL_NAME" ).append("\n"); 
		query.append(", T1.VPS_PORT_CD AS POL" ).append("\n"); 
		query.append(", T1.SLAN_CD AS LANE" ).append("\n"); 
		query.append(", TO_CHAR(T1.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append(", TO_CHAR(T1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR(T1.PF_ETB_DT, 'YYYY-MM-DD HH24:MI') AS PF_ETB_DT" ).append("\n"); 
		query.append(", TO_CHAR(T1.PF_ETD_DT, 'YYYY-MM-DD HH24:MI') AS PF_ETD_DT" ).append("\n"); 
		query.append(", ROUND(T1.VPS_ETB_DT - T1.PF_ETB_DT, 1) AS DELAY_BERTH" ).append("\n"); 
		query.append(", ROUND(T1.VPS_ETD_DT - T1.PF_ETD_DT, 1) AS DELAY_DEP" ).append("\n"); 
		query.append(", T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD T1, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", VPS_PORT_CD" ).append("\n"); 
		query.append(", CLPT_SEQ" ).append("\n"); 
		query.append(", SKD_CNG_STS_CD" ).append("\n"); 
		query.append(", LEAD(VPS_PORT_CD) OVER(PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ORDER BY CLPT_SEQ) AS NXT_PORT_CD /* 이전포트 */" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SLAN_CD = @[slanCd] -- SCE_VSL_SKD_EML 에서 가져온 LANE LIST 로 수정 요망" ).append("\n"); 
		query.append("AND SKD_DIR_CD = 'E'" ).append("\n"); 
		query.append("AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("AND VPS_ETB_DT >= NEXT_DAY(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') , 1) - 7 -- 해당 주에 처음부터 계산하기 위해 NEXT_DAY 후 - 7일 함" ).append("\n"); 
		query.append("AND VPS_ETB_DT <= NEXT_DAY(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') , 1) - 7 + @[vskdDurId] - (1/24/60/60) -- 해당 주에 처음부터 계산하기 위해 NEXT_DAY 후 - 7일 함" ).append("\n"); 
		query.append(") T2, SCE_VSL_SKD_EML V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.SLAN_CD = T2.SLAN_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.VPS_PORT_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND (T2.SLAN_CD= v.vsl_slan_cd AND (T2.VPS_PORT_CD=V.TO_PORT_CD OR T2.NXT_PORT_CD=V.TO_PORT_CD))" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ORDER BY M.VPS_ETB_DT ASC -- ETB 순으로 정렬" ).append("\n"); 

	}
}