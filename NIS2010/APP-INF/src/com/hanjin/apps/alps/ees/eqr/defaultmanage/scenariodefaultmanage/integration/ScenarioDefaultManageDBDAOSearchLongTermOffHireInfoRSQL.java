/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchLongTermOffHireInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchLongTermOffHireInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * L/T Off-Hire 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchLongTermOffHireInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("MAX(DECODE(RUMM, 1,ECC_CD)) ECC_CD" ).append("\n"); 
		query.append(",MAX(DECODE(RUMM, 1,SEQ)) SEQ" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpszcd})" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', AVAL_OFFH_QTY ))   ${key}AVAL_OFFH_QTY" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', LTOF_CHG_AMT))     ${key}LTOF_CHG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', DRFF_CHG_CR_AMT )) ${key}DRFF_CHG_CR_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', DRYG_AMT))         ${key}DRYG_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  ECC_CD" ).append("\n"); 
		query.append(",CTRT_OFC_CTY_CD||CTRT_SEQ SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",AVAL_OFFH_QTY" ).append("\n"); 
		query.append(",LTOF_CHG_AMT" ).append("\n"); 
		query.append(",DRFF_CHG_CR_AMT" ).append("\n"); 
		query.append(",DRYG_AMT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY ECC_CD, CTRT_OFC_CTY_CD||CTRT_SEQ, CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM EQR_LONG_TERM_OFFH_COND" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arrlocation.size() > 0)" ).append("\n"); 
		query.append("AND ECC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arrtpszcd.size() > 0)" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpszcd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpszcd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY RUMM," ).append("\n"); 
		query.append("ECC_CD," ).append("\n"); 
		query.append("SEQ" ).append("\n"); 
		query.append("ORDER BY 1, 2" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchLongTermOffHireInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}