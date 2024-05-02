/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimPortChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimPortChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * port charge 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimPortChargeCSQL(){
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
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimPortChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_SIM_PORT_CHG (" ).append("\n"); 
		query.append("     SIM_DT" ).append("\n"); 
		query.append("    ,SIM_NO" ).append("\n"); 
		query.append("    ,TML_CD" ).append("\n"); 
		query.append("    ,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,PORT_TRF_AMT" ).append("\n"); 
		query.append("    ,CNL_FEE_AMT" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT )" ).append("\n"); 
		query.append("SELECT SIM_DT" ).append("\n"); 
		query.append("		,SIM_NO" ).append("\n"); 
		query.append("		,TML_CD" ).append("\n"); 
		query.append("		,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("		,SUM(PORT_TRF_AMT1) AS PORT_TRF_AMT" ).append("\n"); 
		query.append("		,SUM(CNL_FEE_AMT1) AS CNL_FEE_AMT" ).append("\n"); 
		query.append("		,@[usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	   SELECT C1.SIM_DT ," ).append("\n"); 
		query.append("			  C1.SIM_NO ," ).append("\n"); 
		query.append("			  C1.TML_CD ," ).append("\n"); 
		query.append("			  C1.PORT_SEQ ," ).append("\n"); 
		query.append("			  C2.TML_CD TML_CD2 ," ).append("\n"); 
		query.append("			  C1.VSL_CLSS_CAPA ," ).append("\n"); 
		query.append("			  C2.PORT_USD_AMT PORT_TRF_AMT1 ," ).append("\n"); 
		query.append("			  C2.CNL_USD_AMT CNL_FEE_AMT1 ," ).append("\n"); 
		query.append("			  C2.COST_YRMON ," ).append("\n"); 
		query.append("			  -- PORT_CLSS_CAPA가 없을 경우 가장 비슷한 사이즈의 비용을 가져오도록 함" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("			  ABS(TO_NUMBER(C1.VSL_CLSS_CAPA)-TO_NUMBER(C1.VSL_CLSS_CAPA)) AA ," ).append("\n"); 
		query.append("			  ROW_NUMBER() OVER(PARTITION BY C1.SIM_DT, C1.SIM_NO, C1.PORT_SEQ, C1.VSL_CLSS_CAPA, SUBSTR(C2.TML_CD , 1, 5)" ).append("\n"); 
		query.append("			    ORDER BY C2.COST_YRMON DESC , ABS(TO_NUMBER(C1.VSL_CLSS_CAPA)-TO_NUMBER(C2.VSL_CLSS_CAPA)) ASC , C2.VSL_CLSS_CAPA DESC) NUM" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("		   SELECT B1.SIM_DT ," ).append("\n"); 
		query.append("			      B1.SIM_NO ," ).append("\n"); 
		query.append("			      B1.TML_CD ," ).append("\n"); 
		query.append("			      B1.PORT_SEQ ," ).append("\n"); 
		query.append("			      B2.VSL_CLSS_CAPA ," ).append("\n"); 
		query.append("			      B3.SLAN_CD ," ).append("\n"); 
		query.append("			      B3.EXTD_LANE_FLG" ).append("\n"); 
		query.append("		    FROM (" ).append("\n"); 
		query.append("		       SELECT DISTINCT SIM_DT ," ).append("\n"); 
		query.append("			          SIM_NO ," ).append("\n"); 
		query.append("			          TML_CD ," ).append("\n"); 
		query.append("			          MIN(PORT_SEQ) OVER (PARTITION BY TML_CD) PORT_SEQ" ).append("\n"); 
		query.append("			     FROM MAS_SIM_TML_INFO" ).append("\n"); 
		query.append("		        WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("        		  AND SIM_NO = @[f_sim_no] ) b1 ," ).append("\n"); 
		query.append("		      (" ).append("\n"); 
		query.append("		        SELECT DISTINCT A1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("		        FROM MAS_SIM_VSL_SET_INFO A1," ).append("\n"); 
		query.append("		          (" ).append("\n"); 
		query.append("        	       SELECT VSL_CD," ).append("\n"); 
		query.append("			              VSL_CLSS_CAPA" ).append("\n"); 
		query.append("		             FROM MAS_VSL_RGST" ).append("\n"); 
		query.append("		            WHERE VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("        		      AND VOP_CD = 'SML'" ).append("\n"); 
		query.append("		              AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		            UNION ALL" ).append("\n"); 
		query.append("        	      SELECT VSL_CD," ).append("\n"); 
		query.append("			             VSL_CLSS_CAPA" ).append("\n"); 
		query.append("		            FROM MAS_SIM_VSL_RGST" ).append("\n"); 
		query.append("         		   WHERE VOP_CD = 'SML' ) A2" ).append("\n"); 
		query.append("			     WHERE A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("		           AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("         		   AND A1.SIM_DIV_CD = '1'" ).append("\n"); 
		query.append("		           AND A1.VOP_CD = 'SML'" ).append("\n"); 
		query.append("         		   AND A1.VSL_CD = A2.VSL_CD ) B2 ," ).append("\n"); 
		query.append("			      (" ).append("\n"); 
		query.append("			       SELECT SLAN_CD ," ).append("\n"); 
		query.append("				          EXTD_LANE_FLG" ).append("\n"); 
		query.append("				     FROM MAS_SIM_INFO" ).append("\n"); 
		query.append("			        WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("			          AND SIM_NO = @[f_sim_no] ) b3 ) c1 ," ).append("\n"); 
		query.append("				  	MAS_PORT_TRF C2" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("					  AND C1.TML_CD = C2.TML_CD(+)" ).append("\n"); 
		query.append("					  AND C2.SLAN_CD(+) = @[f_slan_cd]" ).append("\n"); 
		query.append("					  AND C2.SLAN_CD(+) = DECODE(C1.EXTD_LANE_FLG, 'Y', C1.SLAN_CD, 'N', C2.SLAN_CD(+)) ) D1" ).append("\n"); 
		query.append("					WHERE NUM = 1" ).append("\n"); 
		query.append("			GROUP BY SIM_DT , SIM_NO , TML_CD , VSL_CLSS_CAPA , PORT_SEQ" ).append("\n"); 
		query.append("		ORDER BY SIM_DT, SIM_NO, VSL_CLSS_CAPA, PORT_SEQ" ).append("\n"); 

	}
}