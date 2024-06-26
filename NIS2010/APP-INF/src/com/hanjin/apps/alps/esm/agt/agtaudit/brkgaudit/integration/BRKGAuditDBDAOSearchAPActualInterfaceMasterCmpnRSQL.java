/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchAPActualInterfaceMasterCmpnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.29
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.06.29 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchAPActualInterfaceMasterCmpnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPActualInterfaceMasterCmpn
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchAPActualInterfaceMasterCmpnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchAPActualInterfaceMasterCmpnRSQL").append("\n"); 
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
		query.append("           A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') AS FWDR," ).append("\n"); 
		query.append("           TO_CHAR(A.VNDR_SEQ,'FM000000')                        AS VNDR," ).append("\n"); 
		query.append("           B.CUST_LGL_ENG_NM                                     AS FWDR_NAME," ).append("\n"); 
		query.append("           COUNT(*)                                              AS TOT_CNT," ).append("\n"); 
		query.append("           ROUND(SUM(ACT_IF_COMM_AMT), 2) AS NET_AMT," ).append("\n"); 
		query.append("		   ROUND(SUM(ACT_IF_COMM_AMT * NVL(INV_TAX_RT, 0) / 100), 2) AS VAT," ).append("\n"); 
		query.append("		   ROUND(SUM(ACT_IF_COMM_AMT + (ACT_IF_COMM_AMT * NVL(INV_TAX_RT, 0) / 100)), 2) AS TOT_AMT," ).append("\n"); 
		query.append("           A.VNDR_SEQ," ).append("\n"); 
		query.append("           A.AP_OFC_CD," ).append("\n"); 
		query.append("           A.CSR_NO," ).append("\n"); 
		query.append("           TO_CHAR(A.CMPN_IF_DT,'YYYYMMDD')                      AS IF_DATE," ).append("\n"); 
		query.append("           DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN)           AS IF_RSN," ).append("\n"); 
		query.append("           DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN)     AS RCV_RSN," ).append("\n"); 
		query.append("           D.IF_FLG                                              AS IF_FLG," ).append("\n"); 
		query.append("           D.RCV_ERR_FLG                                         AS RCV_FLG," ).append("\n"); 
		query.append("           D.PAY_AMT," ).append("\n"); 
		query.append("           D.PAY_DT," ).append("\n"); 
		query.append("           D.FTU_USE_CTNT1," ).append("\n"); 
		query.append("           D.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("		   F.GEN_PAY_TERM_CD AS VNDR_TERM_NM, " ).append("\n"); 
		query.append("		   NVL(LTRIM(F.subs_co_cd),'00') AS COA_INTER_COMPY_CD , " ).append("\n"); 
		query.append("		   NVL(LTRIM(F.vndr_locl_lang_nm),F.vndr_lgl_eng_nm) AS INV_DESC" ).append("\n"); 
		query.append("      FROM AGT_CMPN_COMM      A," ).append("\n"); 
		query.append("           MDM_CUSTOMER       B," ).append("\n"); 
		query.append("           AGT_COMM_BKG_INFO  C," ).append("\n"); 
		query.append("           AP_INV_HDR D," ).append("\n"); 
		query.append("           --BKG_BOOKING E," ).append("\n"); 
		query.append("		   MDM_VENDOR F" ).append("\n"); 
		query.append("     WHERE A.FRT_FWRD_CNT_CD  = B.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_SEQ     = B.CUST_SEQ" ).append("\n"); 
		query.append("       AND A.BKG_NO           = C.BKG_NO" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID      != 'COST'" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD       IS NOT NULL" ).append("\n"); 
		query.append("       AND C.BL_NO           IS NOT NULL" ).append("\n"); 
		query.append("       AND A.CSR_NO           = D.CSR_NO(+)" ).append("\n"); 
		query.append("	   AND A.VNDR_SEQ = F.VNDR_SEQ" ).append("\n"); 
		query.append("	   AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if(${bl_nos} != '')" ).append("\n"); 
		query.append("       AND C.BL_NO" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         ( $bl_nos" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ff_cnt_cd} != '')" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_CNT_CD = substr(@[ff_cnt_cd], 0, 2)" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_SEQ    = substr(@[ff_cnt_cd], 3, 6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_option} == 'BF')" ).append("\n"); 
		query.append("       AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         ( 'AS'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#elseif(${if_option} == 'NC')" ).append("\n"); 
		query.append("       AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         ( 'CE','IC','CA','CM','CS'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#elseif(${if_option} == 'IF')" ).append("\n"); 
		query.append("       AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         ( 'IF'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_option} == 'IF')" ).append("\n"); 
		query.append("       AND A.CMPN_IF_DT" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" #if(${sts_option} == '1')" ).append("\n"); 
		query.append("       AND A.VSL_DEP_DT" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("       AND A.CRE_DT" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY " ).append("\n"); 
		query.append("		  A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000')," ).append("\n"); 
		query.append("          TO_CHAR(A.VNDR_SEQ,'FM000000')," ).append("\n"); 
		query.append("          B.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("          A.VNDR_SEQ," ).append("\n"); 
		query.append("          A.AP_OFC_CD," ).append("\n"); 
		query.append("          A.CSR_NO," ).append("\n"); 
		query.append("          TO_CHAR(A.CMPN_IF_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("          DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN)," ).append("\n"); 
		query.append("          DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN)," ).append("\n"); 
		query.append("          D.IF_FLG," ).append("\n"); 
		query.append("          D.RCV_ERR_FLG," ).append("\n"); 
		query.append("          D.PAY_AMT," ).append("\n"); 
		query.append("          D.PAY_DT," ).append("\n"); 
		query.append("          D.FTU_USE_CTNT1," ).append("\n"); 
		query.append("          D.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("		  F.GEN_PAY_TERM_CD, " ).append("\n"); 
		query.append("		  NVL(LTRIM(F.subs_co_cd),'00'), " ).append("\n"); 
		query.append("		  NVL(LTRIM(F.vndr_locl_lang_nm),F.vndr_lgl_eng_nm) " ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}