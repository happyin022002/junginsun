/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchApPayInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchApPayInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchApPayInv
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchApPayInvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchApPayInvRSQL").append("\n"); 
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
		query.append("'AGT'                               AS INV_SUB_SYS_CD," ).append("\n"); 
		query.append("@[inv_ofc_cd]                       AS INV_OFC_CD," ).append("\n"); 
		query.append("A.AP_OFC_CD                         AS COST_OFC_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ                          AS VNDR_SEQ," ).append("\n"); 
		query.append("'BRO'||TO_CHAR (SYSDATE, 'YYMM')||TRIM (TO_CHAR (SUBSTR (MAX (A.BROG_APRO_NO), 8, 4) + 1, '0000'))|| 'T' AS INV_NO," ).append("\n"); 
		query.append("to_char(sysdate, 'YYYYMMDD')        AS INV_ISS_DT," ).append("\n"); 
		query.append("@[eff_date]                        AS INV_EFF_DT," ).append("\n"); 
		query.append("A.VNDR_TERM_NM                      AS VNDR_TERM_NM," ).append("\n"); 
		query.append("'USA'                               AS INV_CURR_CD," ).append("\n"); 
		query.append("A.TOT_AMT                           AS INV_TTL_AMT," ).append("\n"); 
		query.append("A.TOT_AMT                           AS INV_NET_AMT," ).append("\n"); 
		query.append("A.INV_DESC                          AS INV_RMK," ).append("\n"); 
		query.append("A.CSR_NO                            AS CSR_NO," ).append("\n"); 
		query.append("A.IF_DATE                           AS AP_IF_DT," ).append("\n"); 
		query.append("A.PAY_DT                            AS AP_PAY_DT," ).append("\n"); 
		query.append("A.PAY_AMT                           AS AP_PAY_AMT," ).append("\n"); 
		query.append("@[cre_usr_id]                       AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE                             AS CRE_DT," ).append("\n"); 
		query.append("@[cre_usr_id]                       AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE                             AS UPD_DT," ).append("\n"); 
		query.append("to_char(sysdate, 'YYYYMMDD')        AS PAY_DUE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("--	   A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("--	   TO_CHAR(E.BKG_CRE_DT,'yyyymmdd') AS BKG_CRE_DT," ).append("\n"); 
		query.append("A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') AS FWDR," ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ,'FM000000')                        AS VNDR," ).append("\n"); 
		query.append("B.CUST_LGL_ENG_NM                                     AS FWDR_NAME," ).append("\n"); 
		query.append("COUNT(*)                                              AS TOT_CNT," ).append("\n"); 
		query.append("SUM(A.ACT_IF_COMM_AMT)                                AS TOT_AMT," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.AP_OFC_CD," ).append("\n"); 
		query.append("A.CSR_NO," ).append("\n"); 
		query.append("TO_CHAR(A.BROG_IF_DT,'YYYYMMDD')                      AS IF_DATE," ).append("\n"); 
		query.append("DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN)           AS IF_RSN," ).append("\n"); 
		query.append("DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN)     AS RCV_RSN," ).append("\n"); 
		query.append("D.IF_FLG                                              AS IF_FLG," ).append("\n"); 
		query.append("D.RCV_ERR_FLG                                         AS RCV_FLG," ).append("\n"); 
		query.append("D.PAY_AMT," ).append("\n"); 
		query.append("D.PAY_DT," ).append("\n"); 
		query.append("D.FTU_USE_CTNT1," ).append("\n"); 
		query.append("D.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("F.gen_pay_term_cd AS VNDR_TERM_NM," ).append("\n"); 
		query.append("NVL(LTRIM(F.subs_co_cd),'00') AS COA_INTER_COMPY_CD ," ).append("\n"); 
		query.append("NVL(LTRIM(F.vndr_locl_lang_nm),F.vndr_lgl_eng_nm) AS INV_DESC," ).append("\n"); 
		query.append("A.BROG_APRO_NO" ).append("\n"); 
		query.append("FROM AGT_BROG_COMM      A," ).append("\n"); 
		query.append("MDM_CUSTOMER       B," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO  C," ).append("\n"); 
		query.append("AP_INV_HDR D," ).append("\n"); 
		query.append("--BKG_BOOKING E," ).append("\n"); 
		query.append("mdm_vendor F" ).append("\n"); 
		query.append("WHERE A.FRT_FWRD_CNT_CD  = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.FRT_FWRD_SEQ     = B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO           = C.BKG_NO" ).append("\n"); 
		query.append("--AND A.BKG_NO 		  = E.BKG_NO" ).append("\n"); 
		query.append("AND A.CRE_USR_ID      != 'COST'" ).append("\n"); 
		query.append("AND A.AP_OFC_CD       IS NOT NULL" ).append("\n"); 
		query.append("AND C.BL_NO           IS NOT NULL" ).append("\n"); 
		query.append("AND A.CSR_NO           = D.CSR_NO(+)" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = F.VNDR_SEQ" ).append("\n"); 
		query.append("#if(${bl_nos} != '')" ).append("\n"); 
		query.append("AND C.BL_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( $bl_nos" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ff_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.FRT_FWRD_CNT_CD = substr(@[ff_cnt_cd], 0, 2)" ).append("\n"); 
		query.append("AND A.FRT_FWRD_SEQ    = substr(@[ff_cnt_cd], 3, 6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_option} == 'BF')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'CS','CM','CA'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${if_option} == 'NC')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'CE','IC'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${if_option} == 'IF')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'IF'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_option} == 'IF')" ).append("\n"); 
		query.append("AND A.BROG_IF_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${sts_option} == '1')" ).append("\n"); 
		query.append("AND A.VSL_DEP_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CRE_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("--		  A.BKG_NO," ).append("\n"); 
		query.append("--		  E.BKG_CRE_DT," ).append("\n"); 
		query.append("A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000')," ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ,'FM000000')," ).append("\n"); 
		query.append("B.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.AP_OFC_CD," ).append("\n"); 
		query.append("A.CSR_NO," ).append("\n"); 
		query.append("TO_CHAR(A.BROG_IF_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN)," ).append("\n"); 
		query.append("DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN)," ).append("\n"); 
		query.append("D.IF_FLG," ).append("\n"); 
		query.append("D.RCV_ERR_FLG," ).append("\n"); 
		query.append("D.PAY_AMT," ).append("\n"); 
		query.append("D.PAY_DT," ).append("\n"); 
		query.append("D.FTU_USE_CTNT1," ).append("\n"); 
		query.append("D.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("F.gen_pay_term_cd," ).append("\n"); 
		query.append("NVL(LTRIM(F.subs_co_cd),'00')," ).append("\n"); 
		query.append("NVL(LTRIM(F.vndr_locl_lang_nm),F.vndr_lgl_eng_nm)," ).append("\n"); 
		query.append("A.BROG_APRO_NO" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.FWDR = @[fwdr]" ).append("\n"); 

	}
}