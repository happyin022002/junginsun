/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEccTurnTimeRSQL.java
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

public class ScenarioDefaultManageDBDAOSearchEccTurnTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI ID : EES_EQR_0043
	  * Title : Turn Time 조회
	  * Change History------------------------------------------------
	  * CSR No : R200903240002 - Cntr Tpsz 자동화
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEccTurnTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEccTurnTimeRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(DECODE ( RUMM , 1 ,CO_CD)) CO_CD" ).append("\n"); 
		query.append(",MAX(DECODE ( RUMM , 1 ,FM_ECC_CD)) FM_ECC_CD" ).append("\n"); 
		query.append(",MAX(DECODE ( RUMM , 1 ,TO_ECC_CD)) TO_ECC_CD" ).append("\n"); 
		query.append(",ROUND(SUM(TT_RTO_DYS)/DECODE((" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("#if ($velocityCount > 1 )" ).append("\n"); 
		query.append("+" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($key == 'O2')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'O2', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif ($key == 'O4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'O4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S4', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif ($key == 'F2')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F2', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif ($key == 'F4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F5', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(MAX(DECODE(CNTR_TPSZ_CD, '$key', TT_RTO_DYS)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), 0, 1," ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("#if ($velocityCount > 1 )" ).append("\n"); 
		query.append("+" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($key == 'O2')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'O2', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif ($key == 'O4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'O4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S4', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif ($key == 'F2')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F2', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif ($key == 'F4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F5', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(MAX(DECODE(CNTR_TPSZ_CD, '$key', TT_RTO_DYS)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") , 2) AVG" ).append("\n"); 
		query.append("#if (${arrtpsz} != '')" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("#if ($key == 'O2')" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, 'O2', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S2', TT_RTO_DYS)),0)  ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#elseif ($key == 'O4')" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, 'O4', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S4', TT_RTO_DYS)),0)  ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#elseif ($key == 'F2')" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F2', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A2', TT_RTO_DYS)),0)  ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#elseif ($key == 'F4')" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F4', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F5', TT_RTO_DYS)),0)  ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', TT_RTO_DYS ))   ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CO_CD" ).append("\n"); 
		query.append(",A.FM_ECC_CD" ).append("\n"); 
		query.append(",A.TO_ECC_CD" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",A.TT_RTO_DYS" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY CO_CD,FM_ECC_CD ,TO_ECC_CD ,IO_BND_CD ,CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM	EQR_ECC_TURN_TM	A" ).append("\n"); 
		query.append(",EQR_ECC_MST	B" ).append("\n"); 
		query.append("WHERE	A.FM_ECC_CD	=	B.ECC_CD" ).append("\n"); 
		query.append("#if (${arrtpsz} != '')" ).append("\n"); 
		query.append("AND	A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpsz.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD IN (" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD IN (" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD IN (" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bound} != '')" ).append("\n"); 
		query.append("AND A.IO_BND_CD ='$bound'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("GROUP BY	RUMM" ).append("\n"); 
		query.append(",FM_ECC_CD" ).append("\n"); 
		query.append(",TO_ECC_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append("ORDER BY FM_ECC_CD  ASC" ).append("\n"); 

	}
}