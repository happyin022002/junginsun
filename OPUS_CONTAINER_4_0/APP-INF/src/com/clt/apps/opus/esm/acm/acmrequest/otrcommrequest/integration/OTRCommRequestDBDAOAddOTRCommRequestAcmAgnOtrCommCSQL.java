/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OTRCommRequestDBDAOAddOTRCommRequestAcmAgnOtrCommCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommRequestDBDAOAddOTRCommRequestAcmAgnOtrCommCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddOTRCommRequestAcmAgnOtrComm
	  * </pre>
	  */
	public OTRCommRequestDBDAOAddOTRCommRequestAcmAgnOtrCommCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_comm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_comm_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_if_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_occr_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration").append("\n"); 
		query.append("FileName : OTRCommRequestDBDAOAddOTRCommRequestAcmAgnOtrCommCSQL").append("\n"); 
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
		query.append("INTO ACM_AGN_OTR_COMM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("OTR_COMM_NO" ).append("\n"); 
		query.append(",AGN_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",AC_TP_CD" ).append("\n"); 
		query.append(",AC_SEQ" ).append("\n"); 
		query.append(",COMM_YRMON" ).append("\n"); 
		query.append(",APLY_DT" ).append("\n"); 
		query.append(",AC_STS_CD" ).append("\n"); 
		query.append(",IF_AMT" ).append("\n"); 
		query.append(",LOC_DIV_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",AR_OFC_CD" ).append("\n"); 
		query.append(",AP_OFC_CD 	" ).append("\n"); 
		query.append(",AP_CTR_CD" ).append("\n"); 
		query.append(",OFC_ENG_NM" ).append("\n"); 
		query.append(",OTR_COMM_RMK" ).append("\n"); 
		query.append(",COMM_STND_COST_CD" ).append("\n"); 
		query.append(",AC_OCCR_INFO_CD" ).append("\n"); 
		query.append(",AC_SLAN_CD" ).append("\n"); 
		query.append(",AC_RLANE_CD" ).append("\n"); 
		query.append(",AC_VSL_CD" ).append("\n"); 
		query.append(",AC_SKD_VOY_NO" ).append("\n"); 
		query.append(",AC_SKD_DIR_CD" ).append("\n"); 
		query.append(",AC_REV_DIR_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",XCH_RT_APLY_LVL" ).append("\n"); 
		query.append(",PAY_XCH_RT" ).append("\n"); 
		query.append(",PAY_IF_AMT" ).append("\n"); 
		query.append(",OFC_CHR_CD" ).append("\n"); 
		query.append(",VNDR_CNT_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",ACCL_FLG" ).append("\n"); 
		query.append(",RQST_USR_ID" ).append("\n"); 
		query.append(",RQST_DT" ).append("\n"); 
		query.append(",RQST_GDT" ).append("\n"); 
		query.append(",AUD_NO" ).append("\n"); 
		query.append(",AUD_USR_ID" ).append("\n"); 
		query.append(",AUD_DT" ).append("\n"); 
		query.append(",AUD_GDT" ).append("\n"); 
		query.append(",CSR_NO" ).append("\n"); 
		query.append(",APRO_USR_ID" ).append("\n"); 
		query.append(",APRO_DT" ).append("\n"); 
		query.append(",APRO_GDT" ).append("\n"); 
		query.append(",GL_DT" ).append("\n"); 
		query.append(",ASA_NO" ).append("\n"); 
		query.append(",INV_TAX_RT" ).append("\n"); 
		query.append(",IF_USR_ID" ).append("\n"); 
		query.append(",IF_DT" ).append("\n"); 
		query.append(",IF_GDT" ).append("\n"); 
		query.append(",AC_PROC_DESC" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("           @[otr_comm_no]                         AS OTR_COMM_NO," ).append("\n"); 
		query.append("           A.OFC_CD                               AS AGN_CD," ).append("\n"); 
		query.append("           'O'                                    AS IO_BND_CD," ).append("\n"); 
		query.append("           'T'                                    AS AC_TP_CD," ).append("\n"); 
		query.append("           '1'                                    AS AC_SEQ," ).append("\n"); 
		query.append("           REPLACE(@[hid_comm_yrmon], '-', '')        AS COMM_YRMON," ).append("\n"); 
		query.append("           @[aply_dt]                             AS APLY_DT," ).append("\n"); 
		query.append("           'CS'                                   AS AC_STS_CD," ).append("\n"); 
		query.append("           ROUND (@[usd_amt], 2)                  AS IF_AMT," ).append("\n"); 
		query.append("           NULL                                   AS LOC_DIV_CD," ).append("\n"); 
		query.append("           NULL                                   AS LOC_CD," ).append("\n"); 
		query.append("           @[ar_ofc_cd]                           AS AR_OFC_CD," ).append("\n"); 
		query.append("           A.AP_OFC_CD                            AS AP_OFC_CD," ).append("\n"); 
		query.append("           A.AP_CTR_CD                            AS AP_CTR_CD," ).append("\n"); 
		query.append("           A.OFC_ENG_NM                           AS OFC_ENG_NM," ).append("\n"); 
		query.append("           @[otr_comm_rmk]                        AS OTR_COMM_RMK," ).append("\n"); 
		query.append("           @[comm_stnd_cost_cd]                   AS COMM_STND_COST_CD," ).append("\n"); 
		query.append("           @[ac_occr_info_cd]                     AS AC_OCCR_INFO_CD," ).append("\n"); 
		query.append("           'CNT'                                  AS AC_SLAN_CD," ).append("\n"); 
		query.append("           'CNTCO'                                AS AC_RLANE_CD," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],1,4)                     AS AC_VSL_CD," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],5,4)                     AS AC_SKD_VOY_NO," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],9,1)                     AS AC_SKD_DIR_CD," ).append("\n"); 
		query.append("           SUBSTR(@[vvd],10,1)                    AS AC_REV_DIR_CD," ).append("\n"); 
		query.append("           @[curr_cd]                             AS CURR_CD," ).append("\n"); 
		query.append("           '2'                                    AS XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("           @[pay_xch_rt]                          AS PAY_XCH_RT," ).append("\n"); 
		query.append("           ROUND (@[pay_if_amt], 2)               AS PAY_IF_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("               SELECT NVL(OFC_CHR_CD,'')" ).append("\n"); 
		query.append("                 FROM ACM_OFC_INFO" ).append("\n"); 
		query.append("                WHERE AGN_CD = A.OFC_CD " ).append("\n"); 
		query.append("			   	  AND ROWNUM = 1 " ).append("\n"); 
		query.append("           )     " ).append("\n"); 
		query.append("                                                  AS OFC_CHR_LVL, " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("               SELECT vndr_cnt_cd " ).append("\n"); 
		query.append("                 FROM MDM_VENDOR" ).append("\n"); 
		query.append("                WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("           )                                      AS VNDR_CNT_CD," ).append("\n"); 
		query.append("           @[vndr_seq]                            AS VNDR_SEQ," ).append("\n"); 
		query.append("           'N'                                    AS ACCL_FLG," ).append("\n"); 
		query.append("           NULL                                   AS RQST_USR_ID," ).append("\n"); 
		query.append("           NULL                                   AS RQST_DT," ).append("\n"); 
		query.append("           NULL                                   AS RQST_GDT," ).append("\n"); 
		query.append("           NULL                                   AS AUD_NO," ).append("\n"); 
		query.append("           NULL                                   AS AUD_USR_ID," ).append("\n"); 
		query.append("           NULL                                   AS AUD_DT," ).append("\n"); 
		query.append("           NULL                                   AS AUD_GDT," ).append("\n"); 
		query.append("           NULL                                   AS CSR_NO," ).append("\n"); 
		query.append("           NULL                                   AS APRO_USR_ID," ).append("\n"); 
		query.append("           NULL                                   AS APRO_DT," ).append("\n"); 
		query.append("           NULL                                   AS APRO_GDT," ).append("\n"); 
		query.append("           NULL                                   AS GL_DT," ).append("\n"); 
		query.append("           ''                                     AS ASA_NO," ).append("\n"); 
		query.append("           @[inv_tax_rt]                          AS INV_TAX_RT," ).append("\n"); 
		query.append("           NULL                                   AS IF_USR_ID," ).append("\n"); 
		query.append("           NULL                                   AS IF_DT," ).append("\n"); 
		query.append("           NULL                                   AS IF_GDT," ).append("\n"); 
		query.append("           'OTHER COMMISSION MANUAL INPUTTED BY '|| @[usr_id] AS AC_PROC_DESC,  " ).append("\n"); 
		query.append("           @[usr_id]                              AS CRE_USR_ID," ).append("\n"); 
		query.append("           SYSDATE                                AS CRE_DT," ).append("\n"); 
		query.append("           @[usr_id]                              AS UPD_USR_ID," ).append("\n"); 
		query.append("           SYSDATE                                AS UPD_DT" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("     WHERE A.OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 

	}
}