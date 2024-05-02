/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEccMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchEccMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DefaultManage의 ECC 정보 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEccMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEccMasterRSQL").append("\n"); 
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
		query.append("ECC_CD" ).append("\n"); 
		query.append(",STO_MAX_QTY" ).append("\n"); 
		query.append(",STO_MIN_QTY" ).append("\n"); 
		query.append(",STO_FREE_QTY" ).append("\n"); 
		query.append(",WKY_MAX_HNDL_QTY" ).append("\n"); 
		query.append(",WKY_MIN_HNDL_QTY" ).append("\n"); 
		query.append(",TS_DIV_FLG" ).append("\n"); 
		query.append(",STV_20FT_COST_AMT" ).append("\n"); 
		query.append(",STV_40FT_COST_AMT" ).append("\n"); 
		query.append(",STV_45FT_COST_AMT" ).append("\n"); 
		query.append(",STO_20FT_COST_AMT" ).append("\n"); 
		query.append(",STO_40FT_COST_AMT" ).append("\n"); 
		query.append(",STO_45FT_COST_AMT" ).append("\n"); 
		query.append(",HNDL_20FT_COST_AMT" ).append("\n"); 
		query.append(",HNDL_40FT_COST_AMT" ).append("\n"); 
		query.append(",HNDL_45FT_COST_AMT" ).append("\n"); 
		query.append(",STTL_20FT_COST_AMT" ).append("\n"); 
		query.append(",STTL_40FT_COST_AMT" ).append("\n"); 
		query.append(",STTL_45FT_COST_AMT" ).append("\n"); 
		query.append(",EXPT_FM_YRWK" ).append("\n"); 
		query.append(",EXPT_TO_YRWK" ).append("\n"); 
		query.append(",EXPT_STO_QTY" ).append("\n"); 
		query.append(",EXPT_WKY_HNDL_QTY" ).append("\n"); 
		query.append(",CASE WHEN TO_CHAR(UPD_DT, 'YYYYMMDD') - TO_CHAR(CRE_DT, 'YYYYMMDD') = '0'" ).append("\n"); 
		query.append("THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END AS TIMEGAP" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD IN(" ).append("\n"); 
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
		query.append("#if (${status} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD IN(" ).append("\n"); 
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
		query.append("#if (${status} == 'E')" ).append("\n"); 
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
		query.append("ORDER BY 1" ).append("\n"); 

	}
}