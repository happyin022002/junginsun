/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRMasterCSRNOUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.05 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRMasterCSRNOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifySPCLCmpnCSRMasterCSRNO
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRMasterCSRNOUSQL(){
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
		params.put("inv_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration").append("\n");
		query.append("FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRMasterCSRNOUSQL").append("\n");
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
		query.append("/* 5.ACM_SPCL_CMPN_UPDATE */" ).append("\n");
		query.append("UPDATE ACM_SPCL_CMPN " ).append("\n");
		query.append("  SET CSR_NO = @[csr_no]," ).append("\n");
		query.append("             INV_TAX_RT = @[inv_tax_rt]" ).append("\n");
		query.append("WHERE (BKG_NO, SPCL_CMPN_SEQ) IN ( " ).append("\n");
		query.append("         SELECT A.BKG_NO, " ).append("\n");
		query.append("                A.SPCL_CMPN_SEQ" ).append("\n");
		query.append("           FROM ACM_SPCL_CMPN A, ACM_AGN_BKG_INFO B " ).append("\n");
		query.append("          WHERE A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("            AND B.BL_NO IS NOT NULL " ).append("\n");
		query.append("            AND A.CRE_USR_ID != 'COST' " ).append("\n");
		query.append("            AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n");
		query.append("            AND A.CUST_CNT_CD || TO_CHAR (A.CUST_SEQ, 'FM000000') =  @[cust_cnt_seq]" ).append("\n");
		query.append("            AND A.AP_OFC_CD = @[ap_ofc_cd]" ).append("\n");
		query.append("            AND A.SPCL_CMPN_STS_CD = 'CS'" ).append("\n");
		query.append("            AND NVL(A.PAY_CHK_FLG,'N') = 'Y'" ).append("\n");
		query.append("/* 날짜 조회 조건 */       " ).append("\n");
		query.append("#if(${date_div} == 'C')      " ).append("\n");
		query.append("           AND B.BKG_CRE_DT      " ).append("\n");
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')   " ).append("\n");
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999      " ).append("\n");
		query.append("#elseif(${date_div} == 'E') " ).append("\n");
		query.append("           AND A.VSL_DEP_DT      " ).append("\n");
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')   " ).append("\n");
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999      " ).append("\n");
		query.append("#elseif(${date_div} == 'I')  " ).append("\n");
		query.append("           AND A.IF_DT   " ).append("\n");
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')   " ).append("\n");
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999      " ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");

	}
}