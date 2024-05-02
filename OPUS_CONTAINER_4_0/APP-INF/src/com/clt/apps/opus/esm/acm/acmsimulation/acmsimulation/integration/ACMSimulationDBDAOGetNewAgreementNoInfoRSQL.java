/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationDBDAOGetNewAgreementNoInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.25 김상수
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

public class ACMSimulationDBDAOGetNewAgreementNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * GetNewAgnAgreementNoInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOGetNewAgreementNoInfoRSQL(){
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
		query.append("FileName : ACMSimulationDBDAOGetNewAgreementNoInfoRSQL").append("\n");
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
		query.append("SELECT NVL((SELECT AGN_CD||TO_CHAR(MAX(SUBSTR(AGN_AGMT_NO, 6, 3))+1, 'FM000')" ).append("\n");
		query.append("              FROM ACM_SIM_AGMT_MST" ).append("\n");
		query.append("             WHERE AGN_CD = @[agn_cd]" ).append("\n");
		query.append("             GROUP BY AGN_CD)," ).append("\n");
		query.append("           @[agn_cd]||'001')||'S' AS NEW_AGMT_NO" ).append("\n");
		query.append(" FROM DUAL" ).append("\n");

	}
}