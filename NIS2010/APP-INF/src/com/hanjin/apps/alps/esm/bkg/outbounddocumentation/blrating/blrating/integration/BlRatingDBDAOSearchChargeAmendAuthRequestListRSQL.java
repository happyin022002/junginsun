/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOSearchChargeAmendAuthRequestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchChargeAmendAuthRequestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Amend권한 승인 요청 목록을 조회
	  * </pre>
	  */
	public BlRatingDBDAOSearchChargeAmendAuthRequestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amd_rqst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchChargeAmendAuthRequestListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.BKG_NO, " ).append("\n"); 
		query.append("       DENSE_RANK() OVER (ORDER BY A.BKG_NO, A.CHG_AMD_SEQ) SEQ," ).append("\n"); 
		query.append("       A.CHG_AMD_SEQ," ).append("\n"); 
		query.append("       S.CUST_CNT_CD||LPAD(S.CUST_SEQ,6,'0') SHPR_CD," ).append("\n"); 
		query.append("       (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = S.CUST_CNT_CD AND CUST_SEQ = S.CUST_SEQ) SHPR_NM," ).append("\n"); 
		query.append("       C.CUST_CNT_CD||LPAD(C.CUST_SEQ,6,'0') CNEE_CD," ).append("\n"); 
		query.append("       (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = C.CUST_CNT_CD AND CUST_SEQ = C.CUST_SEQ) CNEE_NM," ).append("\n"); 
		query.append("       R.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       DECODE(R.BKG_CTRT_TP_CD,'S',B.SC_NO,'R',B.RFA_NO,'T',B.TAA_NO) CTRT_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE WHEN R.BKG_CTRT_TP_CD = 'S' " ).append("\n"); 
		query.append("                 THEN (SELECT CTRT_PTY_NM" ).append("\n"); 
		query.append("                       FROM PRI_SP_CTRT_PTY SC, PRI_SP_MN SM, PRI_SP_HDR SH" ).append("\n"); 
		query.append("                       WHERE SH.SC_NO = B.SC_NO" ).append("\n"); 
		query.append("                       AND SH.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                       AND R.RT_APLY_DT BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("                       AND SC.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                       AND SC.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                       AND SC.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("            WHEN R.BKG_CTRT_TP_CD = 'R' " ).append("\n"); 
		query.append("                 THEN (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                       FROM MDM_CUSTOMER MC, PRI_RP_HDR RH, PRI_RP_MN RM" ).append("\n"); 
		query.append("                       WHERE RH.RFA_NO = B.RFA_NO" ).append("\n"); 
		query.append("                       AND RH.PROP_NO = RM.PROP_NO" ).append("\n"); 
		query.append("                       AND R.RT_APLY_DT BETWEEN RM.EFF_DT AND RM.EXP_DT" ).append("\n"); 
		query.append("                       AND RM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND RM.CTRT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("            ELSE (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                       FROM MDM_CUSTOMER MC, PRI_TAA_HDR TH, PRI_TAA_MN TM" ).append("\n"); 
		query.append("                       WHERE TH.TAA_NO = B.TAA_NO" ).append("\n"); 
		query.append("                       AND TH.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 
		query.append("                       AND R.RT_APLY_DT BETWEEN TM.EFF_DT AND TM.EXP_DT" ).append("\n"); 
		query.append("                       AND TM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND TM.CTRT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("       END CTRT_PTY_NM," ).append("\n"); 
		query.append("       (SELECT SREP_NM||'/'||OFC_CD FROM MDM_SLS_REP WHERE SREP_CD = B.CTRT_SREP_CD) CTRT_SREP," ).append("\n"); 
		query.append("       (SELECT SREP_NM||'/'||OFC_CD FROM MDM_SLS_REP WHERE SREP_CD = B.OB_SREP_CD) OB_SREP," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03364'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT =  A.CHG_AMD_RSN_CD) CHG_AMD_RSN_CD," ).append("\n"); 
		query.append("       A.CHG_AMD_RMK," ).append("\n"); 
		query.append("       D.CHG_CD," ).append("\n"); 
		query.append("       D.CURR_CD," ).append("\n"); 
		query.append("       D.RAT_UT_CD," ).append("\n"); 
		query.append("       D.CRNT_CHG_AMT," ).append("\n"); 
		query.append("       D.AMD_CHG_AMT," ).append("\n"); 
		query.append("       D.DIFF_CHG_AMT," ).append("\n"); 
		query.append("       A.RQST_USR_ID, " ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03365' " ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = A.CHG_AMD_RQST_STS_CD)CHG_AMD_RQST_STS_CD," ).append("\n"); 
		query.append("       A.RQST_OFC_CD," ).append("\n"); 
		query.append("       (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.RQST_USR_ID) RQST_USR_NM," ).append("\n"); 
		query.append("       (SELECT USR_EML FROM COM_USER WHERE USR_ID = A.RQST_USR_ID) RQST_USR_EML," ).append("\n"); 
		query.append("       TO_CHAR(A.RQST_DT,'YYYYMMDD') RQST_DT," ).append("\n"); 
		query.append("       A.APRO_USR_ID," ).append("\n"); 
		query.append("       A.APRO_OFC_CD," ).append("\n"); 
		query.append("       (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.APRO_USR_ID) APRO_USR_NM," ).append("\n"); 
		query.append("       TO_CHAR(A.APRO_DT,'YYYYMMDD') APRO_DT," ).append("\n"); 
		query.append("       NVL((SELECT 'Y'" ).append("\n"); 
		query.append("            FROM BKG_CHG_AMD_AUTH_REF_USR U" ).append("\n"); 
		query.append("            WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            AND U.CHG_AMD_SEQ = A.CHG_AMD_SEQ" ).append("\n"); 
		query.append("            AND U.APRO_RQST_REF_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("            AND ROWNUM = 1),'N') AUTH_FLG," ).append("\n"); 
		query.append("        A.APRO_RMK," ).append("\n"); 
		query.append("       -----------------------------------------VO 관리용------------------------------------------" ).append("\n"); 
		query.append("       '' FM_DT," ).append("\n"); 
		query.append("       '' TO_DT," ).append("\n"); 
		query.append("       '' IN_BKG_NO," ).append("\n"); 
		query.append("       '' APRO_RQST_REF_USR_ID," ).append("\n"); 
		query.append("       '' MAIL_BODY," ).append("\n"); 
		query.append("       '' MAIL_TITLE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CHG_AMD_AUTH A, " ).append("\n"); 
		query.append("     BKG_CHG_AMD_AUTH_DTL D, " ).append("\n"); 
		query.append("     BKG_BOOKING B, " ).append("\n"); 
		query.append("     BKG_CUSTOMER S, " ).append("\n"); 
		query.append("     BKG_CUSTOMER C," ).append("\n"); 
		query.append("     BKG_RATE R" ).append("\n"); 
		query.append("#if(${in_bkg_no} != '')" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[in_bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE A.RQST_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("  #if(${chg_amd_rqst_sts_cd} != '' && ${chg_amd_rqst_sts_cd} != 'All')" ).append("\n"); 
		query.append("AND A.CHG_AMD_RQST_STS_CD = @[chg_amd_rqst_sts_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${rqst_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("            FROM BKG_CHG_AMD_AUTH_REF_USR U" ).append("\n"); 
		query.append("            WHERE A.BKG_NO = U.BKG_NO" ).append("\n"); 
		query.append("            AND A.CHG_AMD_SEQ = U.CHG_AMD_SEQ" ).append("\n"); 
		query.append("            AND U.APRO_RQST_REF_USR_OFC_CD = @[apro_ofc_cd]" ).append("\n"); 
		query.append("            AND ROWNUM = 1 )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${apro_usr_id} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("            FROM BKG_CHG_AMD_AUTH_REF_USR U" ).append("\n"); 
		query.append("            WHERE A.BKG_NO = U.BKG_NO" ).append("\n"); 
		query.append("            AND A.CHG_AMD_SEQ = U.CHG_AMD_SEQ" ).append("\n"); 
		query.append("            AND U.APRO_RQST_REF_USR_ID = @[apro_usr_id]" ).append("\n"); 
		query.append("            AND ROWNUM = 1  )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND A.CHG_AMD_SEQ = D.CHG_AMD_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("ORDER BY A.BKG_NO, A.CHG_AMD_SEQ" ).append("\n"); 

	}
}