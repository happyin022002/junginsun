/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ApprovalStepMgtDBDAOsearchApprovalStepRankListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalStepMgtDBDAOsearchApprovalStepRankListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ---------------------------------------------------------------------------------------------------------------
	  * 2013-10-28 Created by Jonghee HAN Write Off Approval Route Manager Selection
	  * 2014-02-26 Jonghee HAN Live malfunction fixed
	  * ---------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ApprovalStepMgtDBDAOsearchApprovalStepRankListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration").append("\n"); 
		query.append("FileName : ApprovalStepMgtDBDAOsearchApprovalStepRankListDataRSQL").append("\n"); 
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
		query.append("WITH OFC_STEP AS (SELECT A.OFC_CD, A.APRO_STEP_SEQ, A.OFC_TP_CD, A.MNR_APRO_JB_CD, A.APRO_USR_ID, B.USR_NM, B.OFC_CD USR_OFC_CD" ).append("\n"); 
		query.append("                    FROM MNR_APRO_STEP A, COM_USER B" ).append("\n"); 
		query.append("                   WHERE A.APRO_USR_ID = B.USR_ID)" ).append("\n"); 
		query.append("SELECT OFC_TP_CD, OFC_CD, " ).append("\n"); 
		query.append("       MIN(DECODE(NO, 1, USR_OFC_CD)) PIC1_OFC, MIN(DECODE(NO, 1, APRO_USR_ID)) PIC1_USR_ID, MIN(DECODE(NO, 1, APRO_USR_ID)) PRE_PIC1_USR_ID, MIN(DECODE(NO, 1, USR_NM)) PIC1_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 2, USR_OFC_CD)) PIC2_OFC, MIN(DECODE(NO, 2, APRO_USR_ID)) PIC2_USR_ID, MIN(DECODE(NO, 2, APRO_USR_ID)) PRE_PIC2_USR_ID, MIN(DECODE(NO, 2, USR_NM)) PIC2_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 3, USR_OFC_CD)) PIC3_OFC, MIN(DECODE(NO, 3, APRO_USR_ID)) PIC3_USR_ID, MIN(DECODE(NO, 3, APRO_USR_ID)) PRE_PIC3_USR_ID, MIN(DECODE(NO, 3, USR_NM)) PIC3_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 4, USR_OFC_CD)) PIC4_OFC, MIN(DECODE(NO, 4, APRO_USR_ID)) PIC4_USR_ID, MIN(DECODE(NO, 4, APRO_USR_ID)) PRE_PIC4_USR_ID, MIN(DECODE(NO, 4, USR_NM)) PIC4_NM" ).append("\n"); 
		query.append("  FROM (SELECT ROW_NUMBER() OVER(PARTITION BY OFC_CD ORDER BY APRO_STEP_SEQ) NO, " ).append("\n"); 
		query.append("               OFC_CD, APRO_STEP_SEQ, OFC_TP_CD, MNR_APRO_JB_CD, APRO_USR_ID, USR_OFC_CD, USR_NM" ).append("\n"); 
		query.append("          FROM OFC_STEP)" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND OFC_TP_CD = 'BB'" ).append("\n"); 
		query.append("   AND OFC_CD LIKE DECODE(@[ofc_cd], ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ), '%', 'A', '%', @[ofc_cd])" ).append("\n"); 
		query.append("GROUP BY OFC_TP_CD, OFC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT OFC_TP_CD, OFC_CD, " ).append("\n"); 
		query.append("       MIN(DECODE(NO, 1, USR_OFC_CD)) PIC1_OFC, MIN(DECODE(NO, 1, APRO_USR_ID)) PIC1_USR_ID, MIN(DECODE(NO, 1, APRO_USR_ID)) PRE_PIC1_USR_ID, MIN(DECODE(NO, 1, USR_NM)) PIC1_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 2, USR_OFC_CD)) PIC2_OFC, MIN(DECODE(NO, 2, APRO_USR_ID)) PIC2_USR_ID, MIN(DECODE(NO, 2, APRO_USR_ID)) PRE_PIC2_USR_ID, MIN(DECODE(NO, 2, USR_NM)) PIC2_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 3, USR_OFC_CD)) PIC3_OFC, MIN(DECODE(NO, 3, APRO_USR_ID)) PIC3_USR_ID, MIN(DECODE(NO, 3, APRO_USR_ID)) PRE_PIC3_USR_ID, MIN(DECODE(NO, 3, USR_NM)) PIC3_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 4, USR_OFC_CD)) PIC4_OFC, MIN(DECODE(NO, 4, APRO_USR_ID)) PIC4_USR_ID, MIN(DECODE(NO, 4, APRO_USR_ID)) PRE_PIC4_USR_ID, MIN(DECODE(NO, 4, USR_NM)) PIC4_NM" ).append("\n"); 
		query.append("  FROM (SELECT ROW_NUMBER() OVER(PARTITION BY OFC_CD ORDER BY APRO_STEP_SEQ) NO, " ).append("\n"); 
		query.append("               OFC_CD, APRO_STEP_SEQ, OFC_TP_CD, MNR_APRO_JB_CD, APRO_USR_ID, USR_OFC_CD, USR_NM" ).append("\n"); 
		query.append("          FROM OFC_STEP)" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("   AND OFC_CD LIKE DECODE(@[ofc_cd], ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ), '%', 'A', '%', @[ofc_cd])" ).append("\n"); 
		query.append("GROUP BY OFC_TP_CD, OFC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT OFC_TP_CD, OFC_CD, " ).append("\n"); 
		query.append("       MIN(DECODE(NO, 1, USR_OFC_CD)) PIC1_OFC, MIN(DECODE(NO, 1, APRO_USR_ID)) PIC1_USR_ID, MIN(DECODE(NO, 1, APRO_USR_ID)) PRE_PIC1_USR_ID, MIN(DECODE(NO, 1, USR_NM)) PIC1_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 2, USR_OFC_CD)) PIC2_OFC, MIN(DECODE(NO, 2, APRO_USR_ID)) PIC2_USR_ID, MIN(DECODE(NO, 2, APRO_USR_ID)) PRE_PIC2_USR_ID, MIN(DECODE(NO, 2, USR_NM)) PIC2_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 3, USR_OFC_CD)) PIC3_OFC, MIN(DECODE(NO, 3, APRO_USR_ID)) PIC3_USR_ID, MIN(DECODE(NO, 3, APRO_USR_ID)) PRE_PIC3_USR_ID, MIN(DECODE(NO, 3, USR_NM)) PIC3_NM," ).append("\n"); 
		query.append("       MIN(DECODE(NO, 4, USR_OFC_CD)) PIC4_OFC, MIN(DECODE(NO, 4, APRO_USR_ID)) PIC4_USR_ID, MIN(DECODE(NO, 4, APRO_USR_ID)) PRE_PIC4_USR_ID, MIN(DECODE(NO, 4, USR_NM)) PIC4_NM" ).append("\n"); 
		query.append("  FROM (SELECT ROW_NUMBER() OVER(PARTITION BY OFC_CD ORDER BY APRO_STEP_SEQ) NO, " ).append("\n"); 
		query.append("               OFC_CD, APRO_STEP_SEQ, OFC_TP_CD, MNR_APRO_JB_CD, APRO_USR_ID, USR_OFC_CD, USR_NM" ).append("\n"); 
		query.append("          FROM OFC_STEP)" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND OFC_TP_CD = 'HO'" ).append("\n"); 
		query.append("   AND OFC_CD LIKE DECODE(@[ofc_cd], ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ), '%', 'A', '%', @[ofc_cd])" ).append("\n"); 
		query.append("GROUP BY OFC_TP_CD, OFC_CD" ).append("\n"); 

	}
}