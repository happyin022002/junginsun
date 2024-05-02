/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerDBDAOTotalCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.09.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.bizcommon.customer.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerDBDAOTotalCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 총 카운트 조회
	  * </pre>
	  */
	public CustomerDBDAOTotalCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.bizcommon.customer.integration").append("\n"); 
		query.append("FileName : CustomerDBDAOTotalCustomerRSQL").append("\n"); 
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
		query.append("#if(${credit_flg} == 'on')" ).append("\n"); 
		query.append("	SELECT COUNT(*)" ).append("\n"); 
		query.append("		FROM MDM_CUSTOMER A, MDM_CR_CUST B" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		    NVL(A.NMD_CUST_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("		AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("	#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("		AND A.CUST_CNT_CD||lpad(A.CUST_SEQ,6,0) LIKE @[cust_cnt_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("		#if(${include} == 'on')" ).append("\n"); 
		query.append("			AND upper(A.CUST_LGL_ENG_NM) LIKE '%' || upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND upper(A.CUST_LGL_ENG_NM) LIKE upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("	AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${mdm_yn} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${delt_flg} == 'Y') " ).append("\n"); 
		query.append("			AND A.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("		#elseif (${delt_flg} == 'ALL') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else	" ).append("\n"); 
		query.append("		AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT COUNT(*)" ).append("\n"); 
		query.append("		FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		NVL(NMD_CUST_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("	#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("		AND A.CUST_CNT_CD||lpad(A.CUST_SEQ,6,0) LIKE @[cust_cnt_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("		#if(${include} == 'on')" ).append("\n"); 
		query.append("			AND upper(A.CUST_LGL_ENG_NM) LIKE '%' || upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND upper(A.CUST_LGL_ENG_NM) LIKE upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("	AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${mdm_yn} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${delt_flg} == 'Y') " ).append("\n"); 
		query.append("			AND A.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("		#elseif (${delt_flg} == 'ALL') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else	" ).append("\n"); 
		query.append("		AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}