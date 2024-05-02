/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupDBDAOSearchVslSkdEmlSetUpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.26 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VskEmailSetupDBDAOSearchVslSkdEmlSetUpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL E-MAIL 대상 조회
	  * </pre>
	  */
	public VskEmailSetupDBDAOSearchVslSkdEmlSetUpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.integration").append("\n"); 
		query.append("FileName : VskEmailSetupDBDAOSearchVslSkdEmlSetUpRSQL").append("\n"); 
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
		query.append("D.EML_GRP_ID," ).append("\n"); 
		query.append("D.VSL_SLAN_CD," ).append("\n"); 
		query.append("D.TO_PORT_CD," ).append("\n"); 
		query.append("CASE WHEN LENGTH(D.VSKD_DUR_ID) = 3 THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(D.VSKD_DUR_ID, 3, 1) = 'Q' THEN SUBSTR(D.VSKD_DUR_ID, 1, 2) * 30" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 3, 1) = 'W' THEN SUBSTR(D.VSKD_DUR_ID, 1, 2) * 7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 3, 1) = 'D' THEN SUBSTR(D.VSKD_DUR_ID, 1, 2) * 1" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN LENGTH(D.VSKD_DUR_ID) = 2 THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(D.VSKD_DUR_ID, 2, 1) = 'Q' THEN SUBSTR(D.VSKD_DUR_ID, 1, 1) * 30" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 2, 1) = 'W' THEN SUBSTR(D.VSKD_DUR_ID, 1, 1) * 7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 2, 1) = 'D' THEN SUBSTR(D.VSKD_DUR_ID, 1, 1) * 1" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END VSKD_DUR_ID," ).append("\n"); 
		query.append("'days' UNIT," ).append("\n"); 
		query.append("D.EML_SND_HR," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 1), 0, 0, 1) EML_SND_DYS_CTNT_SUN," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 2), 0, 0, 1) EML_SND_DYS_CTNT_MON," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 3), 0, 0, 1) EML_SND_DYS_CTNT_TUE," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 4), 0, 0, 1) EML_SND_DYS_CTNT_WEB," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 5), 0, 0, 1) EML_SND_DYS_CTNT_THR," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 6), 0, 0, 1) EML_SND_DYS_CTNT_FRI," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 7), 0, 0, 1) EML_SND_DYS_CTNT_SAT," ).append("\n"); 
		query.append("(MIN(DECODE(D.RK, 1, DECODE(D.SUBSC_EML, '', '', D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 2, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 3, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 4, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 5, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 6, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 7, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 8, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 9, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 10, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 11, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 12, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 13, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 14, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 15, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML)))) SUBSC_EML," ).append("\n"); 
		query.append("D.EML_JB_ID," ).append("\n"); 
		query.append("D.SVC_ST_DT," ).append("\n"); 
		query.append("D.SVC_END_DT," ).append("\n"); 
		query.append("D.EML_GRP_ID EML_GRP_ID_HIS," ).append("\n"); 
		query.append("D.EML_SND_HR EML_SND_HR_HIS," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 1), 0, 0, 1) EML_SND_DYS_CTNT_SUN_HIS," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 2), 0, 0, 1) EML_SND_DYS_CTNT_MON_HIS," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 3), 0, 0, 1) EML_SND_DYS_CTNT_TUE_HIS," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 4), 0, 0, 1) EML_SND_DYS_CTNT_WEB_HIS," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 5), 0, 0, 1) EML_SND_DYS_CTNT_THR_HIS," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 6), 0, 0, 1) EML_SND_DYS_CTNT_FRI_HIS," ).append("\n"); 
		query.append("DECODE(instr(D.EML_SND_DYS_CTNT, 7), 0, 0, 1) EML_SND_DYS_CTNT_SAT_HIS," ).append("\n"); 
		query.append("D.VSL_SLAN_CD VSL_SLAN_CD_HIS," ).append("\n"); 
		query.append("D.TO_PORT_CD TO_PORT_CD_HIS," ).append("\n"); 
		query.append("CASE WHEN LENGTH(D.VSKD_DUR_ID) = 3 THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(D.VSKD_DUR_ID, 3, 1) = 'Q' THEN SUBSTR(D.VSKD_DUR_ID, 1, 2) * 30" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 3, 1) = 'W' THEN SUBSTR(D.VSKD_DUR_ID, 1, 2) * 7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 3, 1) = 'D' THEN SUBSTR(D.VSKD_DUR_ID, 1, 2) * 1" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN LENGTH(D.VSKD_DUR_ID) = 2 THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(D.VSKD_DUR_ID, 2, 1) = 'Q' THEN SUBSTR(D.VSKD_DUR_ID, 1, 1) * 30" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 2, 1) = 'W' THEN SUBSTR(D.VSKD_DUR_ID, 1, 1) * 7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN SUBSTR(D.VSKD_DUR_ID, 2, 1) = 'D' THEN SUBSTR(D.VSKD_DUR_ID, 1, 1) * 1" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END VSKD_DUR_ID_HIS," ).append("\n"); 
		query.append("(MIN(DECODE(D.RK, 1, DECODE(D.SUBSC_SEQ, '', '', D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 2, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 3, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 4, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 5, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 6, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 7, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 8, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 9, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 10, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 11, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 12, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 13, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 14, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 15, DECODE(D.SUBSC_SEQ, '', '', ';' ||D.SUBSC_SEQ)))) SUBSC_SEQ_HIS," ).append("\n"); 
		query.append("(MIN(DECODE(D.RK, 1, DECODE(D.SUBSC_EML, '', '', D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 2, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 3, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 4, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 5, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 6, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 7, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 8, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 9, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 10, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 11, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 12, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 13, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 14, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML))) ||" ).append("\n"); 
		query.append("MIN(DECODE(D.RK, 15, DECODE(D.SUBSC_EML, '', '', ';' ||D.SUBSC_EML)))) SUBSC_EML_HIS," ).append("\n"); 
		query.append("D.FM_PORT_CD FM_PORT_CD_HIS," ).append("\n"); 
		query.append("D.EML_GRP_CD_DESC EML_GRP_CD_DESC_HIS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY A.EML_GRP_ID, A.VSL_SLAN_CD, A.TO_PORT_CD, A.VSKD_DUR_ID, B.EML_SND_HR, B.EML_SND_DYS_CTNT, A.EML_JB_ID, A.SVC_ST_DT, A.SVC_END_DT" ).append("\n"); 
		query.append("ORDER BY A.EML_GRP_ID, A.VSL_SLAN_CD, A.TO_PORT_CD, A.VSKD_DUR_ID, B.EML_SND_HR, B.EML_SND_DYS_CTNT, C.SUBSC_SEQ ASC) AS RK," ).append("\n"); 
		query.append("A.EML_GRP_ID," ).append("\n"); 
		query.append("A.VSL_SLAN_CD," ).append("\n"); 
		query.append("A.TO_PORT_CD," ).append("\n"); 
		query.append("A.VSKD_DUR_ID," ).append("\n"); 
		query.append("B.EML_SND_HR," ).append("\n"); 
		query.append("B.EML_SND_DYS_CTNT," ).append("\n"); 
		query.append("C.SUBSC_EML," ).append("\n"); 
		query.append("A.EML_JB_ID," ).append("\n"); 
		query.append("A.SVC_ST_DT," ).append("\n"); 
		query.append("A.SVC_END_DT," ).append("\n"); 
		query.append("C.SUBSC_SEQ," ).append("\n"); 
		query.append("A.FM_PORT_CD," ).append("\n"); 
		query.append("B.EML_GRP_CD_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_VSL_SKD_EML A," ).append("\n"); 
		query.append("SCE_EML_JB_GRP B," ).append("\n"); 
		query.append("SCE_EML_JB_SUBSC C" ).append("\n"); 
		query.append("WHERE A.EML_JB_ID = B.EML_JB_ID" ).append("\n"); 
		query.append("AND A.SVC_ST_DT = B.SVC_ST_DT" ).append("\n"); 
		query.append("AND A.SVC_END_DT = B.SVC_END_DT" ).append("\n"); 
		query.append("AND A.EML_GRP_ID = B.EML_GRP_ID" ).append("\n"); 
		query.append("AND A.EML_JB_ID = C.EML_JB_ID" ).append("\n"); 
		query.append("AND A.SVC_ST_DT = C.SVC_ST_DT" ).append("\n"); 
		query.append("AND A.SVC_END_DT = C.SVC_END_DT" ).append("\n"); 
		query.append("AND A.EML_GRP_ID = C.EML_GRP_ID" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A.TO_PORT_CD = C.TO_PORT_CD" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("D.EML_GRP_ID," ).append("\n"); 
		query.append("D.VSL_SLAN_CD," ).append("\n"); 
		query.append("D.TO_PORT_CD," ).append("\n"); 
		query.append("D.VSKD_DUR_ID," ).append("\n"); 
		query.append("D.EML_SND_HR," ).append("\n"); 
		query.append("D.EML_SND_DYS_CTNT," ).append("\n"); 
		query.append("D.EML_JB_ID," ).append("\n"); 
		query.append("D.SVC_ST_DT," ).append("\n"); 
		query.append("D.SVC_END_DT," ).append("\n"); 
		query.append("D.FM_PORT_CD," ).append("\n"); 
		query.append("D.EML_GRP_CD_DESC" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("D.EML_GRP_ID ASC," ).append("\n"); 
		query.append("D.VSL_SLAN_CD ASC," ).append("\n"); 
		query.append("D.TO_PORT_CD ASC" ).append("\n"); 

	}
}