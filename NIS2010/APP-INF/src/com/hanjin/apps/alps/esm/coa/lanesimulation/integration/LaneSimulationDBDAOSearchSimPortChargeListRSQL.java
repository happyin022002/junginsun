/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimPortChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.03 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimPortChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SimPortCharge 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimPortChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimPortChargeListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(B1.SIM_DT, '*'), '*', 'I', 'R') AS IBFLAG ," ).append("\n"); 
		query.append("B2.SIM_DT ," ).append("\n"); 
		query.append("B2.SIM_NO ," ).append("\n"); 
		query.append("SUBSTR(B2.TML_CD, 1, 5) AS PORT_CD ," ).append("\n"); 
		query.append("SUBSTR(B2.TML_CD, 6, 7) AS YD_CD ," ).append("\n"); 
		query.append("B2.TML_CD ," ).append("\n"); 
		query.append("B2.PORT_SEQ ," ).append("\n"); 
		query.append("B2.VSL_CLSS_CAPA ," ).append("\n"); 
		query.append("B1.PORT_TRF_AMT ," ).append("\n"); 
		query.append("B1.CNL_FEE_AMT" ).append("\n"); 
		query.append("FROM COA_SIM_PORT_CHG B1 ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A3.SIM_DT ," ).append("\n"); 
		query.append("A3.SIM_NO ," ).append("\n"); 
		query.append("A2.VSL_CLSS_CAPA ," ).append("\n"); 
		query.append("A3.TML_CD ," ).append("\n"); 
		query.append("MIN(A3.PORT_SEQ) PORT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT SIM_DT ," ).append("\n"); 
		query.append("SIM_NO ," ).append("\n"); 
		query.append("VSL_CD ," ).append("\n"); 
		query.append("VSL_CLSS_CAPA ," ).append("\n"); 
		query.append("VSL_CAPA ," ).append("\n"); 
		query.append("BSA_CAPA ," ).append("\n"); 
		query.append("VOP_CD" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD = '1' )A1 ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VSL_CD ," ).append("\n"); 
		query.append("VSL_OSHP_CD ," ).append("\n"); 
		query.append("VOP_CD ," ).append("\n"); 
		query.append("VSL_CLSS_CAPA ," ).append("\n"); 
		query.append("STND_LDB_CAPA" ).append("\n"); 
		query.append("FROM COA_VSL_RGST" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("VSL_OSHP_CD," ).append("\n"); 
		query.append("VOP_CD," ).append("\n"); 
		query.append("VSL_CLSS_CAPA," ).append("\n"); 
		query.append("STND_LDB_CAPA" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_RGST ) A2 ," ).append("\n"); 
		query.append("COA_SIM_TML_INFO A3" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("AND A1.SIM_DT = A3.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO = A3.SIM_NO" ).append("\n"); 
		query.append("AND A2.VOP_CD = 'HJS'" ).append("\n"); 
		query.append("GROUP BY A3.SIM_DT , A3.SIM_NO , A3.TML_CD , A2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("ORDER BY PORT_SEQ ) B2" ).append("\n"); 
		query.append("WHERE B1.SIM_DT(+) = B2.SIM_DT" ).append("\n"); 
		query.append("AND B1.SIM_NO(+) = B2.SIM_NO" ).append("\n"); 
		query.append("AND B1.TML_CD(+) = B2.TML_CD" ).append("\n"); 
		query.append("AND B1.VSL_CLSS_CAPA(+) = B2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("ORDER BY B2.VSL_CLSS_CAPA, B2.PORT_SEQ" ).append("\n"); 

	}
}