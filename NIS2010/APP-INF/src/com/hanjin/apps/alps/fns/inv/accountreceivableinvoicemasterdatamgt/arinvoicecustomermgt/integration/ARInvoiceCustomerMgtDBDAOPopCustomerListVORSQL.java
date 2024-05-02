/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOPopCustomerListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.04
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.04 최도순
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

public class ARInvoiceCustomerMgtDBDAOPopCustomerListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOPopCustomerListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOPopCustomerListVORSQL").append("\n"); 
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
		query.append("SELECT	(A.CUST_CNT_CD||'-'||LPAD(A.CUST_SEQ, 6, '0'))	CUST_CODE" ).append("\n"); 
		query.append("		,(B.ACT_CUST_CNT_CD||'-'||LPAD(B.ACT_CUST_SEQ, 6, '0'))	ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		,A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		,C.BZET_ADDR" ).append("\n"); 
		query.append("		,C.ZIP_CD" ).append("\n"); 
		query.append("		,B.CR_CLT_OFC_CD" ).append("\n"); 
		query.append("		,A.CUST_CNT_CD" ).append("\n"); 
		query.append("		,A.CUST_SEQ" ).append("\n"); 
		query.append("		,B.LOCL_NM" ).append("\n"); 
		query.append("		,A.CUST_RGST_NO" ).append("\n"); 
		query.append("		,DECODE(A.DELT_FLG,'Y','Delete','') DELT_FLG" ).append("\n"); 
		query.append("		,(CASE WHEN A.SLS_DELT_EFF_DT IS NULL THEN ''" ).append("\n"); 
		query.append("                WHEN A.SLS_DELT_EFF_DT < TO_CHAR(SYSDATE,'YYYYMMDD') THEN 'No Use'" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                     ''" ).append("\n"); 
		query.append("                END ) SLS_DELT_EFF_DT" ).append("\n"); 
		query.append("FROM 	MDM_CUSTOMER A ," ).append("\n"); 
		query.append("        MDM_CR_CUST B,	" ).append("\n"); 
		query.append("        MDM_CUST_ADDR C" ).append("\n"); 
		query.append("WHERE 	A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("		AND A.CUST_SEQ         = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("    	AND A.CUST_CNT_CD   = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    	AND A.CUST_SEQ         = C.CUST_SEQ(+)		" ).append("\n"); 
		query.append("	    AND C.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("		--AND NVL(A.BLK_DIV_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        AND NVL(A.CNTR_DIV_FLG,'N') ='Y' --2010-06-04 김현화수석" ).append("\n"); 
		query.append("	    AND	A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("		#if (${chk_nm} == 'Y')" ).append("\n"); 
		query.append("			#if (${cust_lgl_eng_nm1} != '')" ).append("\n"); 
		query.append("	    	AND	UPPER(A.CUST_LGL_ENG_NM) like '%' || UPPER(@[cust_lgl_eng_nm1])|| '%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cust_lgl_eng_nm2} != '')" ).append("\n"); 
		query.append("	    	AND	UPPER(A.CUST_LGL_ENG_NM) like '%' || UPPER(@[cust_lgl_eng_nm2])|| '%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cust_lgl_eng_nm3} != '')" ).append("\n"); 
		query.append("	    	AND	UPPER(A.CUST_LGL_ENG_NM) like '%' || UPPER(@[cust_lgl_eng_nm3])|| '%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	UPPER(A.CUST_LGL_ENG_NM) like UPPER(@[cust_lgl_eng_nm])|| '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${zip_cd} != '')" ).append("\n"); 
		query.append("		    AND	C.ZIP_CD like @[zip_cd]|| '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cust_rgst_no} != '')" ).append("\n"); 
		query.append("		AND     A.CUST_RGST_NO = REPLACE(@[cust_rgst_no],'-','')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 

	}
}