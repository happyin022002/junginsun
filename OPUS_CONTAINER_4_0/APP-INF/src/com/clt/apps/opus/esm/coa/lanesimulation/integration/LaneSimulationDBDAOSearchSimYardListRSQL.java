/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimYardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.12.10 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimYardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard 를 조회 한다.
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimYardListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimYardListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(M.YD_CD,6,8) PORT_CY,M.YD_NM YD_NM,TRIM(N.PORT_TRF_AMT) PORT_USD_AMT" ).append("\n"); 
		query.append("	   ,SUBSTR(M.YD_CD,6,8) CODE,  SUBSTR(M.YD_CD,6,8) || '	' || M.YD_NM || '	' || TRIM(N.PORT_TRF_AMT) AS NAME" ).append("\n"); 
		query.append("FROM MDM_YARD M," ).append("\n"); 
		query.append("    (SELECT B1.TML_CD" ).append("\n"); 
		query.append("            ,SUM(B1.PORT_TRF_AMT / DECODE(B1.CURR_CD, 'USD', 1, NVL(B2.USD_LOCL_XCH_RT, 0))) PORT_TRF_AMT" ).append("\n"); 
		query.append("       FROM (SELECT" ).append("\n"); 
		query.append("                A1.YD_CD           TML_CD" ).append("\n"); 
		query.append("               ,A2.ACCT_CD         PORT_COST_CD" ).append("\n"); 
		query.append("               ,A1.BSE_YR          COST_YR" ).append("\n"); 
		query.append("               ,A1.CNTR_VSL_CLSS_CAPA     PORT_CLSS_CAPA" ).append("\n"); 
		query.append("               ,A1.CURR_CD         CURR_CD" ).append("\n"); 
		query.append("               ,A1.TTL_CHG_AMT     PORT_TRF_AMT" ).append("\n"); 
		query.append("               ,RANK() OVER (PARTITION BY A1.YD_CD ORDER BY A1.CNTR_VSL_CLSS_CAPA DESC) NUM" ).append("\n"); 
		query.append("             FROM PSO_VSL_CLSS_TRF A1" ).append("\n"); 
		query.append("                 ,TES_LGS_COST A2" ).append("\n"); 
		query.append("            WHERE A1.LGS_COST_CD = A2.LGS_COST_CD" ).append("\n"); 
		query.append("            ) B1" ).append("\n"); 
		query.append("           ,GL_MON_XCH_RT B2" ).append("\n"); 
		query.append("       WHERE B1.COST_YR = TO_CHAR(SYSDATE,'YYYY')" ).append("\n"); 
		query.append("         AND B1.CURR_CD            = B2.CURR_CD" ).append("\n"); 
		query.append("         AND B2.ACCT_XCH_RT_LVL(+) = '1'" ).append("\n"); 
		query.append("         AND B2.ACCT_XCH_RT_YRMON(+) = '200906' --TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("         AND B1.NUM = 1" ).append("\n"); 
		query.append("         AND SUBSTR(B1.TML_CD,0,5) = @[port_cd]" ).append("\n"); 
		query.append("       GROUP BY DECODE(SUBSTR(B1.TML_CD, 1, 5)" ).append("\n"); 
		query.append("              ,'EGSUZ', '53102000'" ).append("\n"); 
		query.append("              ,'PAPAC', '53102000'" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(B1.PORT_COST_CD, 1, 4), '5119', '53102000', '53101000')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       ,B1.COST_YR" ).append("\n"); 
		query.append("       ,B2.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("       ,B1.PORT_CLSS_CAPA" ).append("\n"); 
		query.append("       ,B1.TML_CD" ).append("\n"); 
		query.append("       ,NVL(B2.USD_LOCL_XCH_RT, 0)) N" ).append("\n"); 
		query.append("  WHERE M.YD_CD=N.TML_CD(+)" ).append("\n"); 
		query.append("    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("    AND SUBSTR(YD_CD,0,5) = @[port_cd]" ).append("\n"); 
		query.append("  UNION ALL " ).append("\n"); 
		query.append("  SELECT 'XX' PORT_CY,'NEW TERMIAL' YD_NM, '' PORT_USD_AMT, 'XX' AS CODE,'XX' || '	'||'NEW TERMIAL' || '	'||'' AS  NAME FROM DUAL" ).append("\n"); 

	}
}