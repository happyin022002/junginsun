/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchShortTermOffHireInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.15 이행지
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

public class ScenarioDefaultManageDBDAOSearchShortTermOffHireInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/T OffHire 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchShortTermOffHireInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchShortTermOffHireInfoRSQL").append("\n"); 
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
		query.append("SELECT  MAX(DECODE(RUMM, 1,ECC_CD)) AS ECC_CD" ).append("\n"); 
		query.append(",MAX(DECODE(RUMM, 1,SEQ)) AS SEQ" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', NVL(AVAL_CNTR_QTY,0) ))   ${key}AVAL_CNTR_QTY" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', NVL(LFT_CHG_AMT,0) ))      ${key}LFT_CHG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', NVL(DRFF_CHG_CR_AMT,0) )) ${key}DRFF_CHG_CR_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', NVL(DRYG_AMT,0) ))         ${key}DRYG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', NVL(DFLT_USD_DYS,0) ))     ${key}DFLT_USD_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  ECC_CD" ).append("\n"); 
		query.append(",CTRT_OFC_CTY_CD||CTRT_SEQ SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",AVAL_CNTR_QTY" ).append("\n"); 
		query.append(",LFT_CHG_AMT" ).append("\n"); 
		query.append(",DRFF_CHG_CR_AMT" ).append("\n"); 
		query.append(",DRYG_AMT" ).append("\n"); 
		query.append(",DFLT_USD_DYS" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY ECC_CD, CTRT_OFC_CTY_CD||CTRT_SEQ, CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM EQR_SHRT_TERM_OFFH_COND" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${status} != '')" ).append("\n"); 
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
		query.append("#if (${arrtpsz} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpsz.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY	RUMM" ).append("\n"); 
		query.append(",ECC_CD" ).append("\n"); 
		query.append(",SEQ" ).append("\n"); 
		query.append("ORDER BY 1, 2" ).append("\n"); 

	}
}