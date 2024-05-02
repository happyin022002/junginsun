/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchShortTermOnHireInfoRSQL.java
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

public class ScenarioDefaultManageDBDAOSearchShortTermOnHireInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DefaultManage의 S/T On Hire 정보 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchShortTermOnHireInfoRSQL(){
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
		query.append("#foreach( $key in ${arrtpszcd})" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', AVAL_CNTR_QTY ))   ${key}AVAL_CNTR_QTY" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', LFT_CHG_AMT))      ${key}LFT_CHG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', PKUP_CHG_CR_AMT )) ${key}PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', DRYG_AMT))         ${key}DRYG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', PD_COST_AMT))      ${key}PD_COST_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '$key', DFLT_USD_DYS))     ${key}AVG_USD_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  ECC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",AVAL_CNTR_QTY" ).append("\n"); 
		query.append(",LFT_CHG_AMT" ).append("\n"); 
		query.append(",DRYG_AMT" ).append("\n"); 
		query.append(",PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append(",PD_COST_AMT" ).append("\n"); 
		query.append(",DFLT_USD_DYS" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY ECC_CD, CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM EQR_SHRT_TERM_ONH_COND" ).append("\n"); 
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
		query.append("GROUP BY RUMM, ECC_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchShortTermOnHireInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}