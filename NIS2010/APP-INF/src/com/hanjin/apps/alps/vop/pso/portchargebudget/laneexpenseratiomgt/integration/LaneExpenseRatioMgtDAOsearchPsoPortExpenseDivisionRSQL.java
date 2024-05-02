/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOsearchPsoPortExpenseDivisionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOsearchPsoPortExpenseDivisionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO PORT EXPENSE DIVISION 테이블 기준으로 등록된 Service Lane List를 표시한다
	  * 
	  * ======================================================
	  * History
	  * 2011.04.26 진마리아 [CHM-201110289-01] Lane/Port Expense Ratio Creation 조회 로직 변경
	  * 2012.06.28 이준범 [CHM-201218449-01] Lane Expense Ratio 저장시 seq 로직 변경
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOsearchPsoPortExpenseDivisionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration").append("\n"); 
		query.append("FileName : LaneExpenseRatioMgtDAOsearchPsoPortExpenseDivisionRSQL").append("\n"); 
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
		query.append("SELECT  RLANE_CD" ).append("\n"); 
		query.append("       ,REV_DIR_CD RLANE_DIR_CD" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,LOC_CD" ).append("\n"); 
		query.append("       ,IB_RTO" ).append("\n"); 
		query.append("       ,OB_RTO" ).append("\n"); 
		query.append("       ,SLAN_CD" ).append("\n"); 
		query.append("       ,PORT_SEQ" ).append("\n"); 
		query.append("       ,RLANE_CD RLANE_CD_B" ).append("\n"); 
		query.append("       ,rev_dir_cd/*2009.11.23. rlane_dir_cd*/ RLANE_DIR_CD_B" ).append("\n"); 
		query.append("       ,SKD_DIR_CD SKD_DIR_CD_B" ).append("\n"); 
		query.append("       ,LOC_CD LOC_CD_B" ).append("\n"); 
		query.append("FROM    PSO_PORT_EXPN_DIV T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("WHERE   T1.SLAN_CD      = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND     T1.SLAN_CD      = @[vsl_slan_cd]" ).append("\n"); 
		query.append("--ORDER BY T2.VSL_SLAN_DIR_SEQ, T1.PORT_SEQ" ).append("\n"); 
		query.append("--ORDER BY RLANE_CD, SKD_DIR_CD, LOC_CD" ).append("\n"); 
		query.append("ORDER BY PORT_SEQ" ).append("\n"); 

	}
}