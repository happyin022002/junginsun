/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOSearchFFCmpnApprovalDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOSearchFFCmpnApprovalDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFFCmpnApprovalDetailList
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOSearchFFCmpnApprovalDetailListRSQL(){
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
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_opt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOSearchFFCmpnApprovalDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_FF_CNT_CD||TO_CHAR(A.BKG_FF_SEQ,'FM000000') AS FF_CNT_SEQ," ).append("\n"); 
		query.append("       TO_CHAR(A.VNDR_SEQ,'FM000000') AS VNDR_SEQ," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       C.BL_NO," ).append("\n"); 
		query.append("       A.FF_REF_NO," ).append("\n"); 
		query.append("       A.IF_AMT," ).append("\n"); 
		query.append("       DECODE(SUBSTR(A.FF_DIV_CD,1,1),'B','RATE','CNTR') AS FF_TYPE," ).append("\n"); 
		query.append("       A.FF_BKG_RT," ).append("\n"); 
		query.append("       D.BKG_STS_CD," ).append("\n"); 
		query.append("       A.FF_CMPN_RMK," ).append("\n"); 
		query.append("       A.FF_SEQ" ).append("\n"); 
		query.append("  FROM ACM_FF_CMPN A," ).append("\n"); 
		query.append("       MDM_CUSTOMER B," ).append("\n"); 
		query.append("       ACM_AGN_BKG_INFO C," ).append("\n"); 
		query.append("       BKG_BOOKING D" ).append("\n"); 
		query.append(" WHERE A.BKG_FF_CNT_CD = SUBSTR(@[hid_ff_cnt_seq], 0, 2)" ).append("\n"); 
		query.append("   AND A.BKG_FF_SEQ = SUBSTR(@[hid_ff_cnt_seq], 3, 6)" ).append("\n"); 
		query.append("   AND A.AP_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND A.BKG_FF_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND A.BKG_FF_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("   AND C.BKG_STS_CD <> 'A'" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.AP_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("   AND C.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ap_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.AP_OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_opt} == 'CS')" ).append("\n"); 
		query.append("   AND A.FF_CMPN_STS_CD IN ('CS', 'CM', 'CA')" ).append("\n"); 
		query.append("   #if (${csr_no} == '')" ).append("\n"); 
		query.append("   AND A.CSR_NO IS NULL" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'PS')	" ).append("\n"); 
		query.append("   AND A.FF_CMPN_STS_CD = 'IF'" ).append("\n"); 
		query.append("   AND A.FF_CMPN_RMK = 'APPROVAL REQUEST!'" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'IF')	" ).append("\n"); 
		query.append("   AND A.FF_CMPN_STS_CD = 'IF'" ).append("\n"); 
		query.append("   AND A.FF_CMPN_RMK = 'Interface Success!'" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.FF_CMPN_STS_CD = @[if_opt]" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* 날짜 조회 조건 */" ).append("\n"); 
		query.append("#if(${date_div} == 'B')	" ).append("\n"); 
		query.append("       AND C.BKG_CRE_DT	" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')	" ).append("\n"); 
		query.append("       AND A.VSL_DEP_DT	" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'C')	" ).append("\n"); 
		query.append("       AND A.UPD_DT	" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'P')	" ).append("\n"); 
		query.append("       AND A.APRO_DT	" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')	" ).append("\n"); 
		query.append("       AND A.IF_DT	" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}