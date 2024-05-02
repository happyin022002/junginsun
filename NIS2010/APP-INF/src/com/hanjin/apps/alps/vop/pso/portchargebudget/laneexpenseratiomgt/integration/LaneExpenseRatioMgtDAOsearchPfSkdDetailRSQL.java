/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.08.20 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력 받은 Lane Code로 생성된 Standard P/F SKD Detail 정보를 조회한다.
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL(){
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
		query.append("FileName : LaneExpenseRatioMgtDAOsearchPfSkdDetailRSQL").append("\n"); 
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
		query.append("SELECT  SKD_DIR_CD, PORT_CD loc_cd" ).append("\n"); 
		query.append(", DECODE(VSL_SLAN_DIR_SEQ + IN_BND, 101, 100, CASE WHEN IN_BND < 100 AND IN_BND > 0 THEN IN_BND ELSE 0 END) OB_RTO" ).append("\n"); 
		query.append(", DECODE(VSL_SLAN_DIR_SEQ + OUT_BND, 102, 100, CASE WHEN OUT_BND < 100 AND OUT_BND > 0 THEN OUT_BND ELSE 0 END) IB_RTO" ).append("\n"); 
		query.append(", VSL_SLAN_CD slan_cd" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T2.SKD_DIR_CD, T2.PORT_CD, T2.TURN_PORT_IND_CD, T2.PORT_ROTN_SEQ, T4.VSL_SLAN_DIR_SEQ,T1.VSL_SLAN_CD ," ).append("\n"); 
		query.append("DECODE(TURN_PORT_IND_CD, 'Y', 50, DECODE(PORT_ROTN_SEQ||TURN_PORT_IND_CD, '1N', 50, 100)) IN_BND," ).append("\n"); 
		query.append("DECODE(TURN_PORT_IND_CD, 'Y', 50, DECODE(PORT_ROTN_SEQ||TURN_PORT_IND_CD, '1N', 50, 100)) OUT_BND" ).append("\n"); 
		query.append("FROM    VSK_PF_SKD T1, VSK_PF_SKD_DTL T2, MDM_VSL_SVC_LANE T3, MDM_VSL_SVC_LANE_DIR T4" ).append("\n"); 
		query.append("WHERE   T1.VSL_SLAN_CD      = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T1.PF_SVC_TP_CD     = T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND     T1.VSL_SLAN_CD      = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T2.VSL_SLAN_CD      = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T2.SKD_DIR_CD       = T4.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND     T1.VSL_SLAN_CD      = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND     T1.SLAN_STND_FLG    = 'Y'" ).append("\n"); 
		query.append("AND     T3.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("AND     T2.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("ORDER BY T2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}