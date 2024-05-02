/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationDBDAOSearchSimulationAgreementListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.07 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOSearchSimulationAgreementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMSimulationDBDAOSearchSimulationAgreementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n");
		query.append("FileName : ACMSimulationDBDAOSearchSimulationAgreementListRSQL").append("\n");
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
		query.append("SELECT AGN_AGMT_NO," ).append("\n");
		query.append("       AGMT_FM_DT_CD," ).append("\n");
		query.append("       TO_CHAR(TO_DATE(AGMT_FM_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS AGMT_FM_DT," ).append("\n");
		query.append("       AGMT_TO_DT_CD," ).append("\n");
		query.append("       TO_CHAR(TO_DATE(AGMT_TO_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS AGMT_TO_DT," ).append("\n");
		query.append("       DELT_FLG," ).append("\n");
		query.append("       TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n");
		query.append("  FROM ACM_SIM_AGMT_MST" ).append("\n");
		query.append(" WHERE AGN_CD = @[agn_cd]" ).append("\n");

	}
}