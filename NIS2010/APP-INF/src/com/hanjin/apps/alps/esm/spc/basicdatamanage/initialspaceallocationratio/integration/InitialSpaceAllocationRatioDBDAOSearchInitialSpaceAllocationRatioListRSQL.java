/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InitialSpaceAllocationRatioDBDAOSearchInitialSpaceAllocationRatioListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InitialSpaceAllocationRatioDBDAOSearchInitialSpaceAllocationRatioListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_INIT_ALOC_RTO 정보 조회
	  * </pre>
	  */
	public InitialSpaceAllocationRatioDBDAOSearchInitialSpaceAllocationRatioListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.integration").append("\n"); 
		query.append("FileName : InitialSpaceAllocationRatioDBDAOSearchInitialSpaceAllocationRatioListRSQL").append("\n"); 
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
		query.append("  SELECT A.REP_TRD_CD," ).append("\n"); 
		query.append("         A.VSL_SLAN_DIR_CD AS DIR_CD," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '01', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '01', B.INIT_ALOC_RTO))) AS MON_01," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '02', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '02', B.INIT_ALOC_RTO))) AS MON_02," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '03', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '03', B.INIT_ALOC_RTO))) AS MON_03," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '04', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '04', B.INIT_ALOC_RTO))) AS MON_04," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '05', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '05', B.INIT_ALOC_RTO))) AS MON_05," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '06', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '06', B.INIT_ALOC_RTO))) AS MON_06," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '07', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '07', B.INIT_ALOC_RTO))) AS MON_07," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '08', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '08', B.INIT_ALOC_RTO))) AS MON_08," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '09', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '09', B.INIT_ALOC_RTO))) AS MON_09," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '10', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '10', B.INIT_ALOC_RTO))) AS MON_10," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '11', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '11', B.INIT_ALOC_RTO))) AS MON_11," ).append("\n"); 
		query.append("         DECODE(MAX(DECODE(B.BSE_MON, '12', B.INIT_ALOC_RTO)), NULL, 100, MAX(DECODE(B.BSE_MON, '12', B.INIT_ALOC_RTO))) AS MON_12" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT" ).append("\n"); 
		query.append("                   A.REP_TRD_CD     ," ).append("\n"); 
		query.append("                   B.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("              FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                   MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                   MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("             WHERE A.RLANE_CD       = B.RLANE_CD" ).append("\n"); 
		query.append("               AND A.VSL_TP_CD      = 'C'" ).append("\n"); 
		query.append("               AND A.REP_TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("               AND B.DELT_FLG       ='N'" ).append("\n"); 
		query.append("               AND B.TRD_CD        <> 'COM'" ).append("\n"); 
		query.append("               AND A.VSL_SLAN_CD    = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("               AND C.CO_CD          = 'H'" ).append("\n"); 
		query.append("               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         SPC_INIT_ALOC_RTO B" ).append("\n"); 
		query.append("   WHERE A.REP_TRD_CD      = B.REP_TRD_CD(+)" ).append("\n"); 
		query.append("     AND A.VSL_SLAN_DIR_CD = B.DIR_CD    (+)" ).append("\n"); 
		query.append("GROUP BY A.REP_TRD_CD     ," ).append("\n"); 
		query.append("         A.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("ORDER BY A.REP_TRD_CD     ," ).append("\n"); 
		query.append("         A.VSL_SLAN_DIR_CD" ).append("\n"); 

	}
}