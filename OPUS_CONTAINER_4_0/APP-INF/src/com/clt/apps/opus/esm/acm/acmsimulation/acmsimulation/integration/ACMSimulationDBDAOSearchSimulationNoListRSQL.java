/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOSearchSimulationNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOSearchSimulationNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSimulationNoList
	  * </pre>
	  */
	public ACMSimulationDBDAOSearchSimulationNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOSearchSimulationNoListRSQL").append("\n"); 
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
		query.append("SIM_NO," ).append("\n"); 
		query.append("SIM_BKG_KNT," ).append("\n"); 
		query.append("SIM_USR_OFC_CD," ).append("\n"); 
		query.append("SIM_RMK," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM ACM_SIM_INFO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${sim_flg} == 'S')" ).append("\n"); 
		query.append("AND LENGTH(SIM_NO) = 10" ).append("\n"); 
		query.append("#if (${sim_usr_ofc_cd} != '')" ).append("\n"); 
		query.append("AND SIM_USR_OFC_CD = @[sim_usr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND LENGTH(SIM_NO) = 11" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_fm} != '')" ).append("\n"); 
		query.append("AND CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}