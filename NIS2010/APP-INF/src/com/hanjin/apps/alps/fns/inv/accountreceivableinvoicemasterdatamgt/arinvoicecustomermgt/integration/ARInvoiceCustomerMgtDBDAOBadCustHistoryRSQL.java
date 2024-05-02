/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOBadCustHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOBadCustHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 악성화주 리스트를 조회한다.
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOBadCustHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bad_cust_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOBadCustHistoryRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	NVL(B.CR_CLT_OFC_CD, A.OFC_CD) OFC_CD, " ).append("\n"); 
		query.append("	A.CUST_CNT_CD CUST_CNT_CD, " ).append("\n"); 
		query.append("	A.CUST_SEQ CUST_SEQ, " ).append("\n"); 
		query.append("	A.CUST_LGL_ENG_NM CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("#if (${bad_cust_knd_cd} == 'N')" ).append("\n"); 
		query.append("	TO_CHAR(A.UPD_DT,'YYYY-MM-DD') UPD_DT," ).append("\n"); 
		query.append("#elseif (${bad_cust_knd_cd} == 'F')" ).append("\n"); 
		query.append("	TO_CHAR(B.UPD_DT,'YYYY-MM-DD') UPD_DT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	DECODE(@[bad_cust_knd_cd], 'N',DECODE(A.SLS_DELT_EFF_RSN_CD, '04', 'Bankruptcy', '05', 'Bad OTS'), 'F', B.CUST_RLSE_CTRL_RMK) BAD_CUST_RSN, " ).append("\n"); 
		query.append("	B.CR_CLT_OFC_CD CR_CLT_OFC_CD, " ).append("\n"); 
		query.append("	C.OFC_CD UPD_OFC, " ).append("\n"); 
		query.append("	A.SREP_CD SREP_CD  " ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CR_CUST B, COM_USER C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("AND A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND A.UPD_USR_ID = UPPER(C.USR_ID(+))  -- COM_USER 테이블에는 USR_ID 가 소문자로 존재하는것도 있음. 하지만 MDM 테이블에는 대문자로 존재하여 UPPER 를 사용함" ).append("\n"); 
		query.append("#if (${bad_cust_knd_cd} == 'N')" ).append("\n"); 
		query.append("    AND A.SLS_DELT_EFF_RSN_CD IN ('04','05')" ).append("\n"); 
		query.append("	AND TO_CHAR(A.UPD_DT, 'YYYYMMDD') <= TO_CHAR(REPLACE(@[upd_dt],'-',''))" ).append("\n"); 
		query.append("#elseif (${bad_cust_knd_cd} == 'F')" ).append("\n"); 
		query.append("    AND B.CUST_RLSE_CTRL_RMK IS NOT NULL" ).append("\n"); 
		query.append("	AND TO_CHAR(B.UPD_DT, 'YYYYMMDD') <= TO_CHAR(REPLACE(@[upd_dt],'-',''))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("AND ( CASE" ).append("\n"); 
		query.append("    WHEN ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION           " ).append("\n"); 
		query.append("             WHERE OFC_CD = B.CR_CLT_OFC_CD) = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("    THEN ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION           " ).append("\n"); 
		query.append("            WHERE OFC_CD = B.CR_CLT_OFC_CD)" ).append("\n"); 
		query.append("    ELSE ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION           " ).append("\n"); 
		query.append("            WHERE OFC_CD = A.OFC_CD)" ).append("\n"); 
		query.append("    END ) = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}