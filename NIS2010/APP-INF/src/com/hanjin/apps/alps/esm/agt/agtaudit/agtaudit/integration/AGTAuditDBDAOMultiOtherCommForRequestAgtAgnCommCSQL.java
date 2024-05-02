/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.12.20 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiOtherCommForRequestAgtAgnComm
	  * </pre>
	  */
	public AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_occr_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_locl_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_comm_acct_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("      INTO AGT_AGN_COMM" ).append("\n"); 
		query.append("         ( BKG_NO," ).append("\n"); 
		query.append("           AGN_CD," ).append("\n"); 
		query.append("           IO_BND_CD," ).append("\n"); 
		query.append("           AC_TP_CD," ).append("\n"); 
		query.append("           AC_SEQ," ).append("\n"); 
		query.append("           COMM_OCCR_INFO_CD," ).append("\n"); 
		query.append("           COMM_YRMON," ).append("\n"); 
		query.append("           AR_OFC_CD," ).append("\n"); 
		query.append("           AP_OFC_CD," ).append("\n"); 
		query.append("           AP_CTR_CD," ).append("\n"); 
		query.append("           OFC_ENG_NM," ).append("\n"); 
		query.append("           OTR_COMM_ACCT_CTNT," ).append("\n"); 
		query.append("           COMM_STND_COST_CD," ).append("\n"); 
		query.append("           COMM_SLAN_CD," ).append("\n"); 
		query.append("           COMM_RLANE_CD," ).append("\n"); 
		query.append("           COMM_VSL_CD," ).append("\n"); 
		query.append("           COMM_SKD_VOY_NO," ).append("\n"); 
		query.append("           COMM_SKD_DIR_CD," ).append("\n"); 
		query.append("           COMM_REV_DIR_CD," ).append("\n"); 
		query.append("           COMM_PROC_STS_CD," ).append("\n"); 
		query.append("           COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("           COMM_APRO_NO," ).append("\n"); 
		query.append("           ASA_NO," ).append("\n"); 
		query.append("           AGN_AGMT_NO," ).append("\n"); 
		query.append("           VNDR_CNT_CD," ).append("\n"); 
		query.append("           VNDR_SEQ," ).append("\n"); 
		query.append("           SAIL_ARR_DT," ).append("\n"); 
		query.append("           CHG_DDCT_AMT," ).append("\n"); 
		query.append("           FDRG_DDCT_AMT," ).append("\n"); 
		query.append("           HLG_DDCT_AMT," ).append("\n"); 
		query.append("           AGN_AGMT_RT," ).append("\n"); 
		query.append("           ACT_PRE_COMM_AMT," ).append("\n"); 
		query.append("           ACT_COMM_AMT," ).append("\n"); 
		query.append("           ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("           ACT_PRE_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           CURR_CD," ).append("\n"); 
		query.append("           XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("           VVD_XCH_RT," ).append("\n"); 
		query.append("           MON_XCH_RT," ).append("\n"); 
		query.append("           DLY_XCH_RT," ).append("\n"); 
		query.append("           OFC_CHR_LVL," ).append("\n"); 
		query.append("           OFFST_AGN_FLG," ).append("\n"); 
		query.append("           ACCL_FLG," ).append("\n"); 
		query.append("           AC_APRO_USR_ID," ).append("\n"); 
		query.append("           AC_APRO_DT," ).append("\n"); 
		query.append("           AC_IF_USR_ID," ).append("\n"); 
		query.append("           AC_IF_DT," ).append("\n"); 
		query.append("           APLY_DT," ).append("\n"); 
		query.append("           CRE_USR_ID," ).append("\n"); 
		query.append("           CRE_DT," ).append("\n"); 
		query.append("           UPD_USR_ID," ).append("\n"); 
		query.append("           UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("           @[bkg_no]                              AS BKG_NO," ).append("\n"); 
		query.append("           A.OFC_CD                               AS AGN_CD," ).append("\n"); 
		query.append("           'O'                                    AS IO_BND_CD," ).append("\n"); 
		query.append("           'T'                                    AS AC_TP_CD," ).append("\n"); 
		query.append("           '1'                                    AS AC_SEQ," ).append("\n"); 
		query.append("           @[comm_occr_info_cd]                   AS COMM_OCCR_INFO_CD," ).append("\n"); 
		query.append("           REPLACE(@[comm_yrmon], '-', '')        AS COMM_YRMON," ).append("\n"); 
		query.append("           A.AR_OFC_CD                            AS AR_OFC_CD," ).append("\n"); 
		query.append("           A.AP_OFC_CD                            AS AP_OFC_CD," ).append("\n"); 
		query.append("           A.AP_CTR_CD                            AS AP_CTR_CD," ).append("\n"); 
		query.append("           A.OFC_ENG_NM                           AS OFC_ENG_NM," ).append("\n"); 
		query.append("           @[otr_comm_acct_ctnt]                  AS OTR_COMM_ACCT_CTNT," ).append("\n"); 
		query.append("           @[comm_stnd_cost_cd]                   AS COMM_STND_COST_CD," ).append("\n"); 
		query.append("           'CNT'                                  AS COMM_SLAN_CD," ).append("\n"); 
		query.append("           'CNTCO'                                AS COMM_RLANE_CD," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],1,4)                     AS COMM_VSL_CD," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],5,4)                     AS COMM_SKD_VOY_NO," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],9,1)                     AS COMM_SKD_DIR_CD," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],10,1)                    AS COMM_REV_DIR_CD," ).append("\n"); 
		query.append("           'CS'                                   AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("           'OTHER COMMISSION MANUAL INPUTTED BY '" ).append("\n"); 
		query.append("        || @[cre_usr_id]                          AS COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("           ''                                     AS COMM_APRO_NO," ).append("\n"); 
		query.append("           ''                                     AS ASA_NO," ).append("\n"); 
		query.append("           ''                                     AS AGN_AGMT_NO," ).append("\n"); 
		query.append("           @[vndr_cnt_cd]                         AS VNDR_CNT_CD," ).append("\n"); 
		query.append("           @[vndr_seq]                            AS VNDR_SEQ," ).append("\n"); 
		query.append("           @[aply_dt]					          AS SAIL_ARR_DT," ).append("\n"); 
		query.append("           0                                      AS CHG_DDCT_AMT," ).append("\n"); 
		query.append("           0                                      AS FDRG_DDCT_AMT," ).append("\n"); 
		query.append("           0                                      AS HLG_DDCT_AMT," ).append("\n"); 
		query.append("           0                                      AS AGN_AGMT_RT," ).append("\n"); 
		query.append("           0                                      AS ACT_PRE_COMM_AMT," ).append("\n"); 
		query.append("           ROUND (@[act_comm_amt], 2)             AS ACT_COMM_AMT," ).append("\n"); 
		query.append("           ROUND (@[act_comm_amt], 2)             AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("           0                                      AS ACT_PRE_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           ROUND (@[act_locl_comm_amt], 2)        AS ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           @[act_locl_comm_amt]                   AS ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           @[curr_cd]                             AS CURR_CD," ).append("\n"); 
		query.append("           '2'                                    AS XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("           0                                      AS VVD_XCH_RT," ).append("\n"); 
		query.append("           @[mon_xch_rt]                          AS MON_XCH_RT," ).append("\n"); 
		query.append("           0                                      AS DLY_XCH_RT," ).append("\n"); 
		query.append("         (         " ).append("\n"); 
		query.append("                   SELECT OFC_CHR_LVL" ).append("\n"); 
		query.append("                     FROM AGT_AGN_AGMT" ).append("\n"); 
		query.append("                    WHERE AGMT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("                      AND OFC_CHR_LVL IS NOT NULL " ).append("\n"); 
		query.append("                      AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         )                                        AS OFC_CHR_LVL," ).append("\n"); 
		query.append("      CASE A.SO_IF_CD" ).append("\n"); 
		query.append("      WHEN 'O'" ).append("\n"); 
		query.append("      THEN 'Y'" ).append("\n"); 
		query.append("      ELSE 'N'" ).append("\n"); 
		query.append("       END                                        AS OFFST_AGN_FLG," ).append("\n"); 
		query.append("           'N'                                    AS ACCL_FLG," ).append("\n"); 
		query.append("           NULL                                   AS AC_APRO_USR_ID," ).append("\n"); 
		query.append("           NULL                                   AS AC_APRO_DT," ).append("\n"); 
		query.append("           NULL                                   AS AC_IF_USR_ID," ).append("\n"); 
		query.append("           NULL                                   AS AC_IF_DT," ).append("\n"); 
		query.append("           @[aply_dt]					          AS APLY_DT," ).append("\n"); 
		query.append("           @[cre_usr_id]                          AS CRE_USR_ID," ).append("\n"); 
		query.append("           SYSDATE                                AS CRE_DT," ).append("\n"); 
		query.append("           @[upd_usr_id]                          AS UPD_USR_ID," ).append("\n"); 
		query.append("           SYSDATE                                AS UPD_DT" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("     WHERE A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 

	}
}