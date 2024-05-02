/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimPortChargeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.03 윤진영
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

public class LaneSimulationDBDAOCreateSimPortChargeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortCharge 머지
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimPortChargeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimPortChargeUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SIM_PORT_CHG INTO_INFO" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SIM_DT               SIM_DT" ).append("\n"); 
		query.append(",SIM_NO               SIM_NO" ).append("\n"); 
		query.append(",TML_CD               TML_CD" ).append("\n"); 
		query.append(",VSL_CLSS_CAPA       VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",PORT_TRF_AMT         PORT_TRF_AMT" ).append("\n"); 
		query.append(",CNL_FEE_AMT          CNL_FEE_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("A1.SIM_DT                                                      SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO                                                      SIM_NO" ).append("\n"); 
		query.append(",A1.TML_CD                                                      TML_CD" ).append("\n"); 
		query.append(",A1.VSL_CLSS_CAPA                                              VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",A2.PORT_USD_AMT                                                PORT_TRF_AMT" ).append("\n"); 
		query.append(",A2.CNL_USD_AMT                                                 CNL_FEE_AMT" ).append("\n"); 
		query.append(",ABS(TO_NUMBER(A1.VSL_CLSS_CAPA)-TO_NUMBER(A2.VSL_CLSS_CAPA)) CAPA_DIFF" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY" ).append("\n"); 
		query.append("A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.TML_CD" ).append("\n"); 
		query.append(",A1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("ABS(TO_NUMBER(A1.VSL_CLSS_CAPA)-TO_NUMBER(A2.VSL_CLSS_CAPA)) ASC" ).append("\n"); 
		query.append(",A1.SIM_DT DESC" ).append("\n"); 
		query.append(",A1.VSL_CLSS_CAPA DESC" ).append("\n"); 
		query.append(") R_NUM" ).append("\n"); 
		query.append("FROM COA_SIM_PORT_CHG A1" ).append("\n"); 
		query.append(",COA_PORT_TRF     A2" ).append("\n"); 
		query.append("WHERE A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("AND NVL(A1.PORT_TRF_AMT,0) + NVL(A1.CNL_FEE_AMT,0) = 0" ).append("\n"); 
		query.append("AND SUBSTR(A1.TML_CD,1,5) = SUBSTR(A2.TML_CD,1,5)" ).append("\n"); 
		query.append("AND A2.COST_YRMON IN (SELECT MAX(COST_YRMON) FROM COA_PORT_TRF)" ).append("\n"); 
		query.append("AND A1.TML_CD <> A2.TML_CD" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append("WHERE B1.R_NUM = 1" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",VSL_CLSS_CAPA" ).append("\n"); 
		query.append(") SEL_INFO" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("INTO_INFO.SIM_DT         = SEL_INFO.SIM_DT" ).append("\n"); 
		query.append("AND INTO_INFO.SIM_NO         = SEL_INFO.SIM_NO" ).append("\n"); 
		query.append("AND INTO_INFO.TML_CD         = SEL_INFO.TML_CD" ).append("\n"); 
		query.append("AND INTO_INFO.VSL_CLSS_CAPA = SEL_INFO.VSL_CLSS_CAPA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("INTO_INFO.PORT_TRF_AMT = SEL_INFO.PORT_TRF_AMT" ).append("\n"); 
		query.append(",INTO_INFO.CNL_FEE_AMT  = SEL_INFO.CNL_FEE_AMT" ).append("\n"); 
		query.append(",UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 

	}
}