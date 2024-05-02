/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchTsVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.25 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchTsVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Step1의 T/S Volume 팝업화면 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchTsVolumeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchTsVolumeRSQL").append("\n"); 
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
		query.append("SELECT A1.VSL_CD,A2.IOC_CD" ).append("\n"); 
		query.append(",SUM(DECODE(A2.SKD_DIR_CD,'E',A2.VSL_TRNS_QTY,0)) E_QTY" ).append("\n"); 
		query.append(",SUM(DECODE(A2.SKD_DIR_CD,'W',A2.VSL_TRNS_QTY,0)) W_QTY" ).append("\n"); 
		query.append(",DECODE(NVL(A2.VSL_CD,'*'),'*','I','R') IBFLAG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT SIM_NO, SIM_DT, VSL_CD" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("AND SIM_DIV_CD = '1'" ).append("\n"); 
		query.append(") A1" ).append("\n"); 
		query.append(",COA_SIM_INTR_TRNS_VOL A2" ).append("\n"); 
		query.append("WHERE A2.VSL_CD(+) =A1.VSL_CD" ).append("\n"); 
		query.append("AND A2.SIM_DT(+) =A1.SIM_DT" ).append("\n"); 
		query.append("AND A2.SIM_NO(+) =A1.SIM_NO" ).append("\n"); 
		query.append("GROUP BY A1.VSL_CD,A2.VSL_CD,A2.IOC_CD" ).append("\n"); 
		query.append("ORDER BY A1.VSL_CD" ).append("\n"); 

	}
}