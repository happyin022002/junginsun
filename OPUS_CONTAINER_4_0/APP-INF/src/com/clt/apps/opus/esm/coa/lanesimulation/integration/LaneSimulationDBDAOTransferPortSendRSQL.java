/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOTransferPortSendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.01 윤진영
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

public class LaneSimulationDBDAOTransferPortSendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ocean out bound qty를 구한다.
	  * </pre>
	  */
	public LaneSimulationDBDAOTransferPortSendRSQL(){
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
		query.append("FileName : LaneSimulationDBDAOTransferPortSendRSQL").append("\n"); 
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
		query.append("WITH RESULT_DATA AS (" ).append("\n"); 
		query.append("SELECT B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.SKD_DIR_CD" ).append("\n"); 
		query.append(",SUBSTR(B1.TML_CD,1,5) AS PORT_CD" ).append("\n"); 
		query.append(",B1.PORT_SEQ" ).append("\n"); 
		query.append(",B1.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append(",B1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",NVL(ROUND(SUM(B1.QTY/B1.FREQ_NO),2),0) AS QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SKD_DIR_CD" ).append("\n"); 
		query.append(",A1.TML_CD" ).append("\n"); 
		query.append(",A1.PORT_SEQ" ).append("\n"); 
		query.append(",A1.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append(",A1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",A1.TML_CNT" ).append("\n"); 
		query.append(",A1.TML_SEQ" ).append("\n"); 
		query.append(",A1.CNT" ).append("\n"); 
		query.append(",A2.CODE" ).append("\n"); 
		query.append(",A2.PORT_CD" ).append("\n"); 
		query.append(",A2.FREQ_NO" ).append("\n"); 
		query.append(",CASE WHEN A1.TURN_PORT_IND_CD = 'Y' OR A1.TML_CNT = 1 THEN" ).append("\n"); 
		query.append("A2.PORT_PAIR_LOD_QTY" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN A1.CNT <= 2 AND A1.TML_CNT > 1 THEN" ).append("\n"); 
		query.append("DECODE(A1.TML_SEQ,1, DECODE(A2.CODE, 'POL', A2.PORT_PAIR_LOD_QTY)" ).append("\n"); 
		query.append(",2, DECODE(A2.CODE, 'POD', A2.PORT_PAIR_LOD_QTY))" ).append("\n"); 
		query.append("WHEN A1.CNT>2 AND A1.TML_CNT > 1 THEN" ).append("\n"); 
		query.append("DECODE(A1.TML_SEQ,1, DECODE(A2.CODE, 'POL', A2.PORT_PAIR_LOD_QTY, 'POD', A2.PORT_PAIR_LOD_QTY)" ).append("\n"); 
		query.append(",2, DECODE(A2.CODE, 'POL', A2.PORT_PAIR_LOD_QTY, 'POD', A2.PORT_PAIR_LOD_QTY))" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END QTY" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.TML_CD" ).append("\n"); 
		query.append(",B1.SKD_DIR_CD" ).append("\n"); 
		query.append(",B1.PORT_SEQ" ).append("\n"); 
		query.append(",B1.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append(",B1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",B1.CONTI_CD2 AS CONTI_CD" ).append("\n"); 
		query.append(",COUNT(B1.TML_CD) OVER(PARTITION BY B1.TML_CD) TML_CNT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY B1.TML_CD ORDER BY PORT_SEQ) TML_SEQ" ).append("\n"); 
		query.append(",COUNT(DISTINCT B1.CONTI_CD2) OVER() CNT" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.TML_CD" ).append("\n"); 
		query.append(",A1.SKD_DIR_CD" ).append("\n"); 
		query.append(",A1.PORT_SEQ" ).append("\n"); 
		query.append(",A1.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append(",A1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",A2.CONTI_CD" ).append("\n"); 
		query.append(",DECODE('EBX','INX',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD)" ).append("\n"); 
		query.append(",'RES',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD)" ).append("\n"); 
		query.append(",DECODE(A2.CONTI_CD,'F','E',A2.CONTI_CD)) CONTI_CD2" ).append("\n"); 
		query.append("FROM COA_SIM_TML_INFO A1" ).append("\n"); 
		query.append(",MDM_LOCATION     A2" ).append("\n"); 
		query.append("WHERE SUBSTR(A1.TML_CD,1,5) = A2.LOC_CD" ).append("\n"); 
		query.append("AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append("ORDER BY B1.PORT_SEQ" ).append("\n"); 
		query.append(")  A1" ).append("\n"); 
		query.append(",(SELECT /*+ READING(A1 A2 A3) USE_NL(A1 A2) USE_HASH(A2)*/" ).append("\n"); 
		query.append("A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SECT_NO" ).append("\n"); 
		query.append(",A1.SKD_DIR_CD" ).append("\n"); 
		query.append(",DECODE(A3.NUM, 1, 'POL', 2, 'POD') CODE" ).append("\n"); 
		query.append(",DECODE(A3.NUM, 1, A2.POL_CD, 2, A2.POD_CD) PORT_CD" ).append("\n"); 
		query.append(",A2.PORT_PAIR_LOD_QTY" ).append("\n"); 
		query.append(",A1.FREQ_NO" ).append("\n"); 
		query.append("FROM COA_SIM_SVC_LANE A1" ).append("\n"); 
		query.append(",COA_SIM_VOL_PRJ A2" ).append("\n"); 
		query.append(",(SELECT CPY_NO NUM" ).append("\n"); 
		query.append("FROM COM_CPY_NO" ).append("\n"); 
		query.append("WHERE CPY_NO BETWEEN 1 AND 2) A3" ).append("\n"); 
		query.append("WHERE A1.SIM_DT = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO = A2.SIM_NO" ).append("\n"); 
		query.append("AND A1.SECT_NO = A2.SECT_NO" ).append("\n"); 
		query.append("AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("WHERE A1.SIM_DT = A2.SIM_DT(+)" ).append("\n"); 
		query.append("AND A1.SIM_NO = A2.SIM_NO(+)" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD = DECODE(A1.TURN_PORT_IND_CD,'Y',A1.SKD_DIR_CD, A2.SKD_DIR_CD(+))" ).append("\n"); 
		query.append("AND SUBSTR(A1.TML_CD,1,5) = A2.PORT_CD(+)" ).append("\n"); 
		query.append("ORDER BY A2.PORT_CD, TML_SEQ,A2.CODE, A1.SKD_DIR_CD" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append("GROUP BY B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.SKD_DIR_CD" ).append("\n"); 
		query.append(",B1.TML_CD" ).append("\n"); 
		query.append(",B1.PORT_SEQ" ).append("\n"); 
		query.append(",B1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",B1.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SKD_DIR_CD" ).append("\n"); 
		query.append(",A1.PORT_CD" ).append("\n"); 
		query.append(",A1.PORT_SEQ" ).append("\n"); 
		query.append(",A1.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append(",A1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",NVL(CASE" ).append("\n"); 
		query.append("WHEN A1.PORT_SEQ = (SELECT MIN(PORT_SEQ) FROM RESULT_DATA)" ).append("\n"); 
		query.append("THEN A1.QTY + A2.LAST_QTY" ).append("\n"); 
		query.append("WHEN A1.PORT_SEQ = (SELECT MAX(PORT_SEQ) FROM RESULT_DATA)" ).append("\n"); 
		query.append("THEN 0" ).append("\n"); 
		query.append("ELSE A1.QTY" ).append("\n"); 
		query.append("END,0) QTY" ).append("\n"); 
		query.append("FROM RESULT_DATA A1" ).append("\n"); 
		query.append(",(SELECT QTY LAST_QTY" ).append("\n"); 
		query.append("FROM RESULT_DATA" ).append("\n"); 
		query.append("WHERE PORT_SEQ = (SELECT MAX(PORT_SEQ) FROM RESULT_DATA)" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("ORDER BY A1.PORT_SEQ" ).append("\n"); 

	}
}