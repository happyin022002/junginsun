/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerDBDAOSearchCustomerRSQL.java
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

public class CustomerDBDAOSearchCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CustomerDBDAOSearchCustomerRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.bizcommon.customer.integration").append("\n"); 
		query.append("FileName : CustomerDBDAOSearchCustomerRSQL").append("\n"); 
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
		query.append("	SELECT DISTINCT CUST_CD, " ).append("\n"); 
		query.append("	  CUST_NM, " ).append("\n"); 
		query.append("	  OFC_CD, " ).append("\n"); 
		query.append("	  DECODE(SLS_DELT_EFF_DT, NULL, 'Y', 'Y' , 'Y', 'N') USE, " ).append("\n"); 
		query.append("	  BZET_ADDR, " ).append("\n"); 
		query.append("	  STE_CD, " ).append("\n"); 
		query.append("	  ZIP_CD, " ).append("\n"); 
		query.append("	  LOC_CD, " ).append("\n"); 
		query.append("	  DECODE(CNTR_CUST_TP_CD  , 'B', 'BCO', 'Non-BCO') CNTR_CUST_TP_CD  , " ).append("\n"); 
		query.append("	  CUST_GRP_ID," ).append("\n"); 
		query.append("	  VNDR_SEQ," ).append("\n"); 
		query.append("		(CASE " ).append("\n"); 
		query.append("			WHEN 'Y' = delt_flg THEN 'Delete' " ).append("\n"); 
		query.append("			ELSE 'Active' " ).append("\n"); 
		query.append("		END) AS delt_flg," ).append("\n"); 
		query.append("	  CUST_SEQ," ).append("\n"); 
		query.append("	  CUST_CNT_CD" ).append("\n"); 
		query.append("	FROM ( " ).append("\n"); 
		query.append("		SELECT /*+ INDEX_ASC(A XPKMDM_CUSTOMER) */ ROWNUM NO, " ).append("\n"); 
		query.append("		  A.CUST_CNT_CD||lpad(A.CUST_SEQ, 6, 0) CUST_CD, " ).append("\n"); 
		query.append("		  A.CUST_LGL_ENG_NM CUST_NM, " ).append("\n"); 
		query.append("		  A.OFC_CD, " ).append("\n"); 
		query.append("		  DECODE(A.SLS_DELT_EFF_DT, NULL, 'Y', 'N') SLS_DELT_EFF_DT, " ).append("\n"); 
		query.append("		  B.BZET_ADDR, " ).append("\n"); 
		query.append("		  B.STE_CD, " ).append("\n"); 
		query.append("		  B.ZIP_CD, " ).append("\n"); 
		query.append("		  A.LOC_CD, " ).append("\n"); 
		query.append("		  A.CNTR_CUST_TP_CD  , " ).append("\n"); 
		query.append("		  A.CUST_GRP_ID, " ).append("\n"); 
		query.append("		  A.VNDR_SEQ ," ).append("\n"); 
		query.append("		  A.DELT_FLG," ).append("\n"); 
		query.append("		  A.CUST_SEQ," ).append("\n"); 
		query.append("		  A.CUST_CNT_CD" ).append("\n"); 
		query.append("		FROM MDM_CUSTOMER A, " ).append("\n"); 
		query.append("		  MDM_CUST_ADDR B, " ).append("\n"); 
		query.append("          MDM_CR_CUST C" ).append("\n"); 
		query.append("		WHERE 1 = 1 " ).append("\n"); 
		query.append("		  AND A.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("		  AND A.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("		  AND A.CUST_CNT_CD = B.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("		  AND A.CUST_SEQ = B.CUST_SEQ(+) " ).append("\n"); 
		query.append("		  AND B.PRMRY_CHK_FLG(+) = 'Y' " ).append("\n"); 
		query.append("		  AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("			AND A.CUST_CNT_CD||lpad(A.CUST_SEQ,6,0) LIKE @[cust_cnt_cd] || '%'" ).append("\n"); 
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
		query.append("			AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${loc_cd} != '')" ).append("\n"); 
		query.append("			AND A.LOC_CD LIKE @[loc_cd] || '%'" ).append("\n"); 
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
		query.append("		   ) A " ).append("\n"); 
		query.append("	WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("	  AND ROWNUM <= 200 " ).append("\n"); 
		query.append("	ORDER BY CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT DISTINCT CUST_CD, " ).append("\n"); 
		query.append("	  CUST_NM, " ).append("\n"); 
		query.append("	  OFC_CD, " ).append("\n"); 
		query.append("	  DECODE(SLS_DELT_EFF_DT, NULL, 'Y', 'Y' , 'Y', 'N') USE, " ).append("\n"); 
		query.append("	  BZET_ADDR, " ).append("\n"); 
		query.append("	  STE_CD, " ).append("\n"); 
		query.append("	  ZIP_CD, " ).append("\n"); 
		query.append("	  LOC_CD, " ).append("\n"); 
		query.append("	  DECODE(CNTR_CUST_TP_CD  , 'B', 'BCO', 'Non-BCO') CNTR_CUST_TP_CD  , " ).append("\n"); 
		query.append("	  CUST_GRP_ID," ).append("\n"); 
		query.append("	  VNDR_SEQ," ).append("\n"); 
		query.append("		(CASE " ).append("\n"); 
		query.append("			WHEN 'Y' = delt_flg THEN 'Delete' " ).append("\n"); 
		query.append("			ELSE 'Active' " ).append("\n"); 
		query.append("		END) AS delt_flg," ).append("\n"); 
		query.append("	  CUST_SEQ," ).append("\n"); 
		query.append("	  CUST_CNT_CD" ).append("\n"); 
		query.append("	FROM ( " ).append("\n"); 
		query.append("		SELECT /*+ INDEX_ASC(A XPKMDM_CUSTOMER) */ ROWNUM NO, " ).append("\n"); 
		query.append("		  A.CUST_CNT_CD||lpad(A.CUST_SEQ, 6, 0) CUST_CD, " ).append("\n"); 
		query.append("		  A.CUST_LGL_ENG_NM CUST_NM, " ).append("\n"); 
		query.append("		  A.OFC_CD, " ).append("\n"); 
		query.append("		  DECODE(A.SLS_DELT_EFF_DT, NULL, 'Y', 'N') SLS_DELT_EFF_DT, " ).append("\n"); 
		query.append("		  B.BZET_ADDR, " ).append("\n"); 
		query.append("		  B.STE_CD, " ).append("\n"); 
		query.append("		  B.ZIP_CD, " ).append("\n"); 
		query.append("		  A.LOC_CD, " ).append("\n"); 
		query.append("		  A.CNTR_CUST_TP_CD  , " ).append("\n"); 
		query.append("		  A.CUST_GRP_ID, " ).append("\n"); 
		query.append("		  A.VNDR_SEQ ," ).append("\n"); 
		query.append("		  A.DELT_FLG," ).append("\n"); 
		query.append("		  A.CUST_SEQ," ).append("\n"); 
		query.append("		  A.CUST_CNT_CD" ).append("\n"); 
		query.append("		FROM MDM_CUSTOMER A, " ).append("\n"); 
		query.append("		  MDM_CUST_ADDR B " ).append("\n"); 
		query.append("		WHERE 1 = 1 " ).append("\n"); 
		query.append("		  AND A.CUST_CNT_CD = B.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("		  AND A.CUST_SEQ = B.CUST_SEQ(+) " ).append("\n"); 
		query.append("		  AND B.PRMRY_CHK_FLG(+) = 'Y' " ).append("\n"); 
		query.append("		  AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("	#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("			AND A.CUST_CNT_CD||lpad(A.CUST_SEQ,6,0) LIKE @[cust_cnt_cd] || '%'" ).append("\n"); 
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
		query.append("			AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${loc_cd} != '')" ).append("\n"); 
		query.append("			AND A.LOC_CD LIKE @[loc_cd] || '%'" ).append("\n"); 
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
		query.append("		   ) A " ).append("\n"); 
		query.append("	WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("	  AND ROWNUM <= 200 " ).append("\n"); 
		query.append("	ORDER BY CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}