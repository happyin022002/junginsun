/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOCustomerList2VORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.10.26 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOCustomerList2VORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * a
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOCustomerList2VORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rlse_ctrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOCustomerList2VORSQL").append("\n"); 
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
		query.append("A.CUST_CNT_CD ||'-'|| LPAD(A.CUST_SEQ,6,'0') AS CUST_CNT_CD" ).append("\n"); 
		query.append(",A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.CUST_RGST_NO" ).append("\n"); 
		query.append(",B.OWNR_NM" ).append("\n"); 
		query.append(",B.BZCT_NM" ).append("\n"); 
		query.append(",B.BZTP_NM" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append(",DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR1 || C.LOCL_ADDR2 || C.LOCL_ADDR3 || C.LOCL_ADDR4" ).append("\n"); 
		query.append("       		,NVL(B.LOCL_ADDR1|| B.LOCL_ADDR2||B.LOCL_ADDR3||B.LOCL_ADDR4, BZET_ADDR)) CUST_ADDR" ).append("\n"); 
		query.append(",C.CTY_NM" ).append("\n"); 
		query.append(",C.ZIP_CD" ).append("\n"); 
		query.append(",E.FAX_NO" ).append("\n"); 
		query.append(",E.PHN_NO" ).append("\n"); 
		query.append(",B.CNTC_PSON_NM" ).append("\n"); 
		query.append(",B.CR_CURR_CD" ).append("\n"); 
		query.append(",B.CR_AMT" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(B.CR_ST_DT,'YYYY-MM-DD'),'YYYY-MM-DD') CR_ST_DT" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(B.CR_END_DT,'YYYY-MM-DD'),'YYYY-MM-DD') CR_END_DT" ).append("\n"); 
		query.append(",B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append(",B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append(",B.CR_CLT_OFC_CD" ).append("\n"); 
		query.append(",B.CUST_RLSE_CTRL_FLG" ).append("\n"); 
		query.append(",TO_CHAR(B.UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",B.ACT_CUST_CNT_CD||'-'||LPAD(B.ACT_CUST_SEQ,6,'0') AS ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",SUM(D.CUST_SCR_AMT) CUST_SCR_LOCL_AMT" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A ," ).append("\n"); 
		query.append("          MDM_CR_CUST B," ).append("\n"); 
		query.append("          MDM_CUST_ADDR C," ).append("\n"); 
		query.append("          INV_AR_SCR D," ).append("\n"); 
		query.append("          MDM_CUST_CNTC_PNT E" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND A.CUST_SEQ         = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND A.CUST_CNT_CD   = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND A.CUST_SEQ         = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND A.CUST_CNT_CD   = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND A.CUST_SEQ         = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND A.CUST_CNT_CD   = E.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND A.CUST_SEQ         = E.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("    AND C.PRMRY_CHK_FLG(+) = 'Y'        " ).append("\n"); 
		query.append("	--AND NVL(A.BLK_DIV_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL(A.CNTR_DIV_FLG,'N') ='Y' --2010-06-04 김현화수석" ).append("\n"); 
		query.append("    --AND (( B.CR_CLT_OFC_CD is NULL) OR (B.CR_CLT_OFC_CD is not NULL AND B.CR_END_DT < to_CHAR(SYSDATE,'YYYYMMDD')) )" ).append("\n"); 
		query.append("    AND D.SCR_END_DT(+) >=to_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${ofc} != '' && ${ofc} != 'ALL') " ).append("\n"); 
		query.append("	AND A.OFC_CD = @[ofc]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND A.OFC_CD  in ( SELECT DISTINCT M3.AR_OFC_CD" ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION M3" ).append("\n"); 
		query.append("                                  WHERE M3.AR_HD_QTR_OFC_CD = (SELECT M2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                 FROM MDM_ORGANIZATION M1, MDM_ORGANIZATION M2" ).append("\n"); 
		query.append("                                                                 WHERE M1.OFC_CD = @[userofc]" ).append("\n"); 
		query.append("                                                                  AND M2.OFC_CD = M1.AR_OFC_CD)" ).append("\n"); 
		query.append("									AND M3.OFC_CD = M3.AR_OFC_CD" ).append("\n"); 
		query.append("						) 	" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if (${cust_rlse_ctrl_flg} != '') " ).append("\n"); 
		query.append("#if (${cust_rlse_ctrl_flg} == 'Y') " ).append("\n"); 
		query.append("  	AND B.CUST_RLSE_CTRL_FLG  = @[cust_rlse_ctrl_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND (B.CUST_RLSE_CTRL_FLG  =  @[cust_rlse_ctrl_flg] OR B.CUST_RLSE_CTRL_FLG IS NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  GROUP BY	A.CUST_CNT_CD ||'-'|| LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("			,A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			,A.CUST_RGST_NO" ).append("\n"); 
		query.append("			,B.OWNR_NM" ).append("\n"); 
		query.append("			,B.BZCT_NM" ).append("\n"); 
		query.append("			,B.BZTP_NM" ).append("\n"); 
		query.append("			,A.OFC_CD" ).append("\n"); 
		query.append("			,DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR1 || C.LOCL_ADDR2 || C.LOCL_ADDR3 || C.LOCL_ADDR4" ).append("\n"); 
		query.append("			       		,NVL(B.LOCL_ADDR1|| B.LOCL_ADDR2||B.LOCL_ADDR3||B.LOCL_ADDR4, BZET_ADDR))" ).append("\n"); 
		query.append("			,C.CTY_NM" ).append("\n"); 
		query.append("			,C.ZIP_CD" ).append("\n"); 
		query.append("			,E.FAX_NO" ).append("\n"); 
		query.append("			,E.PHN_NO" ).append("\n"); 
		query.append("			,B.CNTC_PSON_NM" ).append("\n"); 
		query.append("			,B.CR_CURR_CD" ).append("\n"); 
		query.append("			,B.CR_AMT" ).append("\n"); 
		query.append("			,TO_CHAR(TO_DATE(B.CR_ST_DT,'YYYY-MM-DD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append("			,TO_CHAR(TO_DATE(B.CR_END_DT,'YYYY-MM-DD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append("			,B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append("			,B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append("			,B.CR_CLT_OFC_CD" ).append("\n"); 
		query.append("			,B.CUST_RLSE_CTRL_FLG" ).append("\n"); 
		query.append("			,TO_CHAR(B.UPD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("			,B.ACT_CUST_CNT_CD||'-'||LPAD(B.ACT_CUST_SEQ,6,'0')" ).append("\n"); 

	}
}