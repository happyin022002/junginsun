/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : MstMgmtDBDAOSearchMdmDatProcCompletionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchMdmDatProcCompletionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_DAT_PROC Completion List 정보 조회
	  * </pre>
	  */
	public MstMgmtDBDAOSearchMdmDatProcCompletionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_dat_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdaa_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchMdmDatProcCompletionListRSQL").append("\n"); 
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
		query.append("SELECT		DISTINCT" ).append("\n"); 
		query.append("			XX.*" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT RQST_NO," ).append("\n"); 
		query.append("       P.MST_DAT_SUBJ_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD20091'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = P.MST_DAT_SUBJ_CD ) AS MST_DAT_SUBJ_DESC," ).append("\n"); 
		query.append("	   (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD20091'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = P.MST_DAT_SUBJ_CD ) AS RQST_DTL_PGM_NO," ).append("\n"); 
		query.append("       RQST_USR_ID," ).append("\n"); 
		query.append("       RQST_OFC_CD," ).append("\n"); 
		query.append("       APRO_USR_ID," ).append("\n"); 
		query.append("	   PROC_TP_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD20093'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = P.PROC_TP_CD ) PROC_TP_NM," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	   DECODE(PROC_TP_CD, 'A', APRO_RMK, RJCT_RMK) RMK," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC((SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = P.RQST_OFC_CD), RQST_CRE_DT, 'GMT'), 'YYYY-MM-DD HH24:MI:SS') RQST_CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC((SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = P.RQST_OFC_CD), PROC_UPD_DT, 'GMT'), 'YYYY-MM-DD HH24:MI:SS') PROC_UPD_DT," ).append("\n"); 
		query.append("	   DECODE(@[mdaa_chk],'Y', 'S', A.AUTH_TP_CD) AUTH_TP_CD," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("       P.RQST_UPD_DT," ).append("\n"); 
		query.append("       P.PROC_CRE_DT," ).append("\n"); 
		query.append("       P.CRE_USR_ID," ).append("\n"); 
		query.append("       P.CRE_DT," ).append("\n"); 
		query.append("       P.UPD_USR_ID," ).append("\n"); 
		query.append("       P.UPD_DT," ).append("\n"); 
		query.append("	   P.DELT_FLG,     " ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("       CASE P.MST_DAT_SUBJ_CD" ).append("\n"); 
		query.append("         WHEN 'CUST' THEN (SELECT DECODE(CUST_SEQ, 0, '', CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0'))" ).append("\n"); 
		query.append("          FROM MDM_CUST_RQST CR" ).append("\n"); 
		query.append("         WHERE CR.RQST_NO = P.RQST_NO )" ).append("\n"); 
		query.append("         WHEN 'GCST' THEN (SELECT CUST_GRP_ID" ).append("\n"); 
		query.append("          					 FROM MDM_CUST_PERF_GRP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'VNDR' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("          					 FROM MDM_VNDR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'CARR' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT CRR_CD" ).append("\n"); 
		query.append("          					 FROM MDM_CRR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'CHRG' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT CHG_CD" ).append("\n"); 
		query.append("          					 FROM MDM_CHG_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'VESL' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT VSL_CD" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_CNTR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'CMDT' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT CMDT_CD" ).append("\n"); 
		query.append("          					 FROM MDM_CMDT_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'LOCA' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT LOC_CD" ).append("\n"); 
		query.append("          					 FROM MDM_LOC_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'REVL' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT RLANE_CD" ).append("\n"); 
		query.append("          					 FROM MDM_REV_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'SCVL' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_SVC_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'SREP' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT SREP_CD" ).append("\n"); 
		query.append("          					 FROM MDM_SLS_REP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'SVSP' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          					 FROM MDM_SVC_SCP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'TRDE' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT TRD_CD" ).append("\n"); 
		query.append("          					 FROM MDM_TRD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'YARD' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT YD_CD" ).append("\n"); 
		query.append("          					 FROM MDM_YD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'ZONE' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT ZN_CD" ).append("\n"); 
		query.append("          					 FROM MDM_ZN_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END RQST_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE P.MST_DAT_SUBJ_CD" ).append("\n"); 
		query.append("         WHEN 'CUST' THEN (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUST_RQST CR" ).append("\n"); 
		query.append("         WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'GCST' THEN (SELECT CUST_GRP_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CUST_PERF_GRP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'VNDR' THEN (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          					 FROM MDM_VNDR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'CARR' THEN (SELECT CRR_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CRR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'CHRG' THEN (SELECT CHG_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CHG_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'VESL' THEN (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_CNTR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'CMDT' THEN (SELECT CMDT_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CMDT_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'LOCA' THEN (SELECT LOC_NM" ).append("\n"); 
		query.append("          					 FROM MDM_LOC_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'REVL' THEN (SELECT RLANE_NM" ).append("\n"); 
		query.append("          					 FROM MDM_REV_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'SCVL' THEN (SELECT VSL_SLAN_NM" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_SVC_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'SREP' THEN (SELECT SREP_NM" ).append("\n"); 
		query.append("          					 FROM MDM_SLS_REP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'SVSP' THEN (SELECT SVC_SCP_NM" ).append("\n"); 
		query.append("          					 FROM MDM_SVC_SCP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'TRDE' THEN (SELECT TRD_NM" ).append("\n"); 
		query.append("          					 FROM MDM_TRD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'YARD' THEN (SELECT YD_NM" ).append("\n"); 
		query.append("          					 FROM MDM_YD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'ZONE' THEN (SELECT ZN_NM" ).append("\n"); 
		query.append("          					 FROM MDM_ZN_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END RQST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MDM_DAT_PROC P," ).append("\n"); 
		query.append("       MDM_USR_AUTH A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("	#if (${mdaa_chk} == 'Y')" ).append("\n"); 
		query.append("	   --AND A.MST_DAT_SUBJ_CD = 'MDAA'" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("       AND P.MST_DAT_SUBJ_CD = A.MST_DAT_SUBJ_CD" ).append("\n"); 
		query.append("	  #end		" ).append("\n"); 
		query.append("   AND P.PROC_TP_CD != 'O'" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("		   (	P.RQST_USR_ID = A.USR_ID" ).append("\n"); 
		query.append("				#if (${mdaa_chk} != 'Y')" ).append("\n"); 
		query.append("					AND P.RQST_USR_ID = @[rqst_usr_id]" ).append("\n"); 
		query.append("				#end			" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${mdaa_chk} != 'Y')" ).append("\n"); 
		query.append("		OR ( " ).append("\n"); 
		query.append("                 A.USR_ID = @[rqst_usr_id] " ).append("\n"); 
		query.append("             AND ( P.RQST_OFC_CD IN (" ).append("\n"); 
		query.append("					SELECT OFC_CD" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("						SELECT OFC_KIND OFC_KND_CD ," ).append("\n"); 
		query.append("                               A.OFC_CD OFC_CD," ).append("\n"); 
		query.append("                               L1 OFC_LVL," ).append("\n"); 
		query.append("                               DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD) HO ," ).append("\n"); 
		query.append("									   CASE" ).append("\n"); 
		query.append("										 WHEN DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD) = DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD) THEN NULL" ).append("\n"); 
		query.append("										 ELSE DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD)" ).append("\n"); 
		query.append("									   END AS RHQ ," ).append("\n"); 
		query.append("									   CASE" ).append("\n"); 
		query.append("										 WHEN DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD) = DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD) THEN NULL" ).append("\n"); 
		query.append("										 ELSE DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD)" ).append("\n"); 
		query.append("									   END AS BB_AA ," ).append("\n"); 
		query.append("									   CASE" ).append("\n"); 
		query.append("										 WHEN DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD) = DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD) THEN NULL" ).append("\n"); 
		query.append("										 ELSE DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD)" ).append("\n"); 
		query.append("									   END AS SUB_BB ," ).append("\n"); 
		query.append("                               A.OFC_ENG_NM ," ).append("\n"); 
		query.append("                               A.DEL AS STATUS" ).append("\n"); 
		query.append("                          FROM (SELECT OFC_CD ," ).append("\n"); 
		query.append("                                       OFC_ENG_NM," ).append("\n"); 
		query.append("                                       LOC_CD ," ).append("\n"); 
		query.append("                                       PRNT_OFC_CD ," ).append("\n"); 
		query.append("                                       DELT_FLG DEL ," ).append("\n"); 
		query.append("                                       A.OFC_KND_CD OFC_KIND ," ).append("\n"); 
		query.append("                                       LEVEL L1" ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION A START WITH A.OFC_CD = COM_CONSTANTMGR_PKG.COM_getHeadOfficeCode_FNC() CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD ) A ," ).append("\n"); 
		query.append("                               MDM_ORGANIZATION B ," ).append("\n"); 
		query.append("                               MDM_ORGANIZATION C ," ).append("\n"); 
		query.append("                               MDM_ORGANIZATION D" ).append("\n"); 
		query.append("                         WHERE A.PRNT_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("                           AND B.PRNT_OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("                           AND C.PRNT_OFC_CD = D.OFC_CD(+) )" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${ofc_knd_cd} == '1')" ).append("\n"); 
		query.append("					AND HO = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("				#elseif (${ofc_knd_cd} == '2')" ).append("\n"); 
		query.append("					AND RHQ = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("				#elseif (${ofc_knd_cd} == '3')" ).append("\n"); 
		query.append("					AND BB_AA = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("				#elseif (${ofc_knd_cd} == '4')" ).append("\n"); 
		query.append("					AND SUB_BB = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("				#elseif (${ofc_knd_cd} == '5' ) " ).append("\n"); 
		query.append("					AND OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                	AND STATUS <> 'Y' ) " ).append("\n"); 
		query.append("			  )  " ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   AND NVL(P.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_rqst_dt} != '')" ).append("\n"); 
		query.append("   AND P.RQST_CRE_DT BETWEEN TO_DATE(REPLACE(@[fm_rqst_dt], '-', ''), 'YYYYMMDD') " ).append("\n"); 
		query.append("						 AND TO_DATE(REPLACE(@[to_rqst_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mst_dat_subj_cd} != '')" ).append("\n"); 
		query.append("   AND P.MST_DAT_SUBJ_CD = @[mst_dat_subj_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${mst_dat_subj_cd} == '' || ${mst_dat_subj_cd} == 'CUST')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT RQST_NO," ).append("\n"); 
		query.append("       P.MST_DAT_SUBJ_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD20091'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = P.MST_DAT_SUBJ_CD ) AS MST_DAT_SUBJ_DESC," ).append("\n"); 
		query.append("	   (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD20091'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = P.MST_DAT_SUBJ_CD ) AS RQST_DTL_PGM_NO," ).append("\n"); 
		query.append("       RQST_USR_ID," ).append("\n"); 
		query.append("       RQST_OFC_CD," ).append("\n"); 
		query.append("       APRO_USR_ID," ).append("\n"); 
		query.append("	   PROC_TP_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD20093'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = P.PROC_TP_CD ) PROC_TP_NM," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	   DECODE(PROC_TP_CD, 'A', APRO_RMK, RJCT_RMK) RMK," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC((SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = P.RQST_OFC_CD), RQST_CRE_DT, 'GMT'), 'YYYY-MM-DD HH24:MI:SS') RQST_CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC((SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = P.RQST_OFC_CD), PROC_UPD_DT, 'GMT'), 'YYYY-MM-DD HH24:MI:SS') PROC_UPD_DT," ).append("\n"); 
		query.append("	   DECODE(@[mdaa_chk],'Y', 'S', A.AUTH_TP_CD) AUTH_TP_CD," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("       P.RQST_UPD_DT," ).append("\n"); 
		query.append("       P.PROC_CRE_DT," ).append("\n"); 
		query.append("       P.CRE_USR_ID," ).append("\n"); 
		query.append("       P.CRE_DT," ).append("\n"); 
		query.append("       P.UPD_USR_ID," ).append("\n"); 
		query.append("       P.UPD_DT," ).append("\n"); 
		query.append("	   P.DELT_FLG,     " ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("       CASE P.MST_DAT_SUBJ_CD" ).append("\n"); 
		query.append("         WHEN 'CUST' THEN (SELECT DECODE(CUST_SEQ, 0, '', CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0'))" ).append("\n"); 
		query.append("          FROM MDM_CUST_RQST CR" ).append("\n"); 
		query.append("         WHERE CR.RQST_NO = P.RQST_NO )" ).append("\n"); 
		query.append("         WHEN 'GCST' THEN (SELECT CUST_GRP_ID" ).append("\n"); 
		query.append("          					 FROM MDM_CUST_PERF_GRP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'VNDR' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("          					 FROM MDM_VNDR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'CARR' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT CRR_CD" ).append("\n"); 
		query.append("          					 FROM MDM_CRR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'CHRG' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT CHG_CD" ).append("\n"); 
		query.append("          					 FROM MDM_CHG_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'VESL' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT VSL_CD" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_CNTR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("		 WHEN 'CMDT' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT CMDT_CD" ).append("\n"); 
		query.append("          					 FROM MDM_CMDT_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'LOCA' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT LOC_CD" ).append("\n"); 
		query.append("          					 FROM MDM_LOC_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'REVL' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT RLANE_CD" ).append("\n"); 
		query.append("          					 FROM MDM_REV_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'SCVL' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_SVC_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'SREP' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT SREP_CD" ).append("\n"); 
		query.append("          					 FROM MDM_SLS_REP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'SVSP' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          					 FROM MDM_SVC_SCP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'TRDE' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT TRD_CD" ).append("\n"); 
		query.append("          					 FROM MDM_TRD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'YARD' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT YD_CD" ).append("\n"); 
		query.append("          					 FROM MDM_YD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         WHEN 'ZONE' THEN DECODE(PROC_TP_CD, 'R', '', (SELECT ZN_CD" ).append("\n"); 
		query.append("          					 FROM MDM_ZN_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO))" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END RQST_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE P.MST_DAT_SUBJ_CD" ).append("\n"); 
		query.append("         WHEN 'CUST' THEN (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUST_RQST CR" ).append("\n"); 
		query.append("         WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'GCST' THEN (SELECT CUST_GRP_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CUST_PERF_GRP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'VNDR' THEN (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          					 FROM MDM_VNDR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'CARR' THEN (SELECT CRR_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CRR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'CHRG' THEN (SELECT CHG_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CHG_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'VESL' THEN (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_CNTR_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("		 WHEN 'CMDT' THEN (SELECT CMDT_NM" ).append("\n"); 
		query.append("          					 FROM MDM_CMDT_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'LOCA' THEN (SELECT LOC_NM" ).append("\n"); 
		query.append("          					 FROM MDM_LOC_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'REVL' THEN (SELECT RLANE_NM" ).append("\n"); 
		query.append("          					 FROM MDM_REV_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'SCVL' THEN (SELECT VSL_SLAN_NM" ).append("\n"); 
		query.append("          					 FROM MDM_VSL_SVC_LANE_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'SREP' THEN (SELECT SREP_NM" ).append("\n"); 
		query.append("          					 FROM MDM_SLS_REP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'SVSP' THEN (SELECT SVC_SCP_NM" ).append("\n"); 
		query.append("          					 FROM MDM_SVC_SCP_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'TRDE' THEN (SELECT TRD_NM" ).append("\n"); 
		query.append("          					 FROM MDM_TRD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'YARD' THEN (SELECT YD_NM" ).append("\n"); 
		query.append("          					 FROM MDM_YD_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         WHEN 'ZONE' THEN (SELECT ZN_NM" ).append("\n"); 
		query.append("          					 FROM MDM_ZN_RQST CR" ).append("\n"); 
		query.append("         					WHERE CR.RQST_NO = P.RQST_NO)" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END RQST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MDM_DAT_PROC P," ).append("\n"); 
		query.append("       MDM_USR_AUTH A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("  AND P.MST_DAT_SUBJ_CD = A.MST_DAT_SUBJ_CD" ).append("\n"); 
		query.append("	  	" ).append("\n"); 
		query.append("   AND P.PROC_TP_CD <> 'O'" ).append("\n"); 
		query.append("   AND P.MST_DAT_SUBJ_CD = 'CUST'" ).append("\n"); 
		query.append("   AND  ( " ).append("\n"); 
		query.append("                 A.USR_ID = @[rqst_usr_id]" ).append("\n"); 
		query.append("             AND (SELECT SUBSTR(LOC_CD, 1,2) FROM MDM_ORGANIZATION WHERE OFC_CD = @[rqst_ofc_cd]) " ).append("\n"); 
		query.append("                = (SELECT CUST_CNT_CD FROM MDM_CUST_RQST WHERE RQST_NO = P.RQST_NO) " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("   AND NVL(P.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("#if (${fm_rqst_dt} != '')" ).append("\n"); 
		query.append("   AND P.RQST_CRE_DT BETWEEN TO_DATE(REPLACE(@[fm_rqst_dt], '-', ''), 'YYYYMMDD') " ).append("\n"); 
		query.append("						 AND TO_DATE(REPLACE(@[to_rqst_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")	XX" ).append("\n"); 
		query.append("ORDER BY XX.UPD_DT DESC " ).append("\n"); 

	}
}