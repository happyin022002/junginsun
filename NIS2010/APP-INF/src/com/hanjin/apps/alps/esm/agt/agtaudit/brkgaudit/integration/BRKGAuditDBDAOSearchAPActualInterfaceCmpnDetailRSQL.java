/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchAPActualInterfaceCmpnDetailRSQL.java
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

public class BRKGAuditDBDAOSearchAPActualInterfaceCmpnDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPActualInterfaceDetail
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchAPActualInterfaceCmpnDetailRSQL(){
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
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchAPActualInterfaceCmpnDetailRSQL").append("\n"); 
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
		query.append("           C.BL_NO," ).append("\n"); 
		query.append("           A.CMPN_REF_NO," ).append("\n"); 
		query.append("           ROUND(A.ACT_IF_COMM_AMT,0) AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("           DECODE(SUBSTR(A.CMPN_DIV_CD,1,1),'B','RATE','CNTR')   AS CMPN_TYPE," ).append("\n"); 
		query.append("           A.CMPN_BKG_RT," ).append("\n"); 
		query.append("           A.BKG_NO," ).append("\n"); 
		query.append("           A.CMPN_SEQ," ).append("\n"); 
		query.append("           A.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("		   D.BKG_STS_CD" ).append("\n"); 
		query.append("      FROM AGT_CMPN_COMM     A," ).append("\n"); 
		query.append("           MDM_CUSTOMER      B," ).append("\n"); 
		query.append("           AGT_COMM_BKG_INFO C," ).append("\n"); 
		query.append("		   BKG_BOOKING D" ).append("\n"); 
		query.append("     WHERE A.FRT_FWRD_CNT_CD   = SUBSTR(@[fwdr], 0, 2)" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_SEQ      = SUBSTR(@[fwdr], 3, 6)" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD        IS NOT NULL" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_CNT_CD   = B.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_SEQ      = B.CUST_SEQ" ).append("\n"); 
		query.append("       AND A.BKG_NO            = C.BKG_NO" ).append("\n"); 
		query.append("	   AND A.BKG_NO            = D.BKG_NO(+)" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD        IS NOT NULL" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("       AND C.BL_NO            IS NOT NULL" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("       AND A.VNDR_SEQ          = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ap_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD         = @[ap_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${if_option} == 'BF') " ).append("\n"); 
		query.append("		AND A.COMM_PROC_STS_CD IN('AS')" ).append("\n"); 
		query.append("	#if (${sts_option} == '1') " ).append("\n"); 
		query.append("		AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND A.CRE_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${if_option} == 'NC') " ).append("\n"); 
		query.append("		AND A.COMM_PROC_STS_CD IN('CE','IC','CA','CM','CS')" ).append("\n"); 
		query.append("	#if (${sts_option} == '1') " ).append("\n"); 
		query.append("		AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND A.CRE_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${if_option} == 'IF') " ).append("\n"); 
		query.append("		AND A.COMM_PROC_STS_CD IN('IF')" ).append("\n"); 
		query.append("		AND A.CMPN_IF_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("		AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("           'VAT'	AS FWDR," ).append("\n"); 
		query.append("           ''		AS VNDR," ).append("\n"); 
		query.append("           ''		AS BL_NO," ).append("\n"); 
		query.append("           ''		AS CMPN_REF_NO," ).append("\n"); 
		query.append("           ROUND(SUM(A.ACT_IF_COMM_AMT * NVL(A.INV_TAX_RT, 0) / 100), 2)	AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("           ''		AS CMPN_TYPE," ).append("\n"); 
		query.append("           NULL CMPN_BKG_RT," ).append("\n"); 
		query.append("           '' BKG_NO," ).append("\n"); 
		query.append("           NULL CMPN_SEQ," ).append("\n"); 
		query.append("           '' COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("		   '' BKG_STS_CD" ).append("\n"); 
		query.append("      FROM AGT_CMPN_COMM     A," ).append("\n"); 
		query.append("           MDM_CUSTOMER      B," ).append("\n"); 
		query.append("           AGT_COMM_BKG_INFO C," ).append("\n"); 
		query.append("		   BKG_BOOKING D" ).append("\n"); 
		query.append("     WHERE A.FRT_FWRD_CNT_CD   = SUBSTR(@[fwdr], 0, 2)" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_SEQ      = SUBSTR(@[fwdr], 3, 6)" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD        IS NOT NULL" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_CNT_CD   = B.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND A.FRT_FWRD_SEQ      = B.CUST_SEQ" ).append("\n"); 
		query.append("       AND A.BKG_NO            = C.BKG_NO" ).append("\n"); 
		query.append("	   AND A.BKG_NO            = D.BKG_NO(+)" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD        IS NOT NULL" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("       AND C.BL_NO            IS NOT NULL" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("       AND A.VNDR_SEQ          = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ap_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD         = @[ap_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${if_option} == 'BF') " ).append("\n"); 
		query.append("		AND A.COMM_PROC_STS_CD IN('AS')" ).append("\n"); 
		query.append("	#if (${sts_option} == '1') " ).append("\n"); 
		query.append("		AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND A.CRE_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${if_option} == 'NC') " ).append("\n"); 
		query.append("		AND A.COMM_PROC_STS_CD IN('CE','IC','CS','CM','CA')" ).append("\n"); 
		query.append("	#if (${sts_option} == '1') " ).append("\n"); 
		query.append("		AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND A.CRE_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${if_option} == 'IF') " ).append("\n"); 
		query.append("		AND A.COMM_PROC_STS_CD IN('IF')" ).append("\n"); 
		query.append("		AND A.CMPN_IF_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("		AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}