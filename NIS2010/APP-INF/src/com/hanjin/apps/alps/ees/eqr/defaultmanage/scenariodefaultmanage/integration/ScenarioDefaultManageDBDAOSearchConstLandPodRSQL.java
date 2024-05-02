/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchConstLandPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.28 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchConstLandPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI ID : EES_EQR_0137
	  * Title : Constraint by Lane/POD
	  * Change History---------------------------------------------
	  * CSR No             Modifier     Modified Date   Comments
	  * N200802260006    채창호       2008-03-24        Lane/POD별 Discharging Bound 관리 기능 개발 건
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchConstLandPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchConstLandPodRSQL").append("\n"); 
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
		query.append("SELECT	 VSL_LANE_CD AS LANE" ).append("\n"); 
		query.append(",VSL_LOC_CD	 AS POD" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append(",MAX(DECODE(CNST_CNTR_TPSZ_CD, '$key',CNTR_VOL_QTY )) AS ${key}_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	 VSL_LANE_CD" ).append("\n"); 
		query.append(",VSL_LOC_CD" ).append("\n"); 
		query.append(",A.CNST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY VSL_LANE_CD,VSL_LOC_CD ,CNST_CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM	EQR_PORT_DCHG_CNST A" ).append("\n"); 
		query.append(",(	SELECT	ECC_CD" ).append("\n"); 
		query.append("FROM	EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${status} != '')" ).append("\n"); 
		query.append("#if (${status} == 'R')" ).append("\n"); 
		query.append("AND	RCC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'L')" ).append("\n"); 
		query.append("AND	LCC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'E')" ).append("\n"); 
		query.append("AND	ECC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE	A.VSL_LOC_CD	= C.ECC_CD" ).append("\n"); 
		query.append("#if ($arrlane.size() > 0)" ).append("\n"); 
		query.append("AND	A.VSL_LANE_CD	IN (" ).append("\n"); 
		query.append("#foreach( $key in ${arrlane})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlane.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY	 VSL_LANE_CD" ).append("\n"); 
		query.append(",VSL_LOC_CD" ).append("\n"); 
		query.append("ORDER BY	 VSL_LANE_CD" ).append("\n"); 
		query.append(",VSL_LOC_CD" ).append("\n"); 

	}
}