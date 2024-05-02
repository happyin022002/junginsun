/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerDBDAOSearchCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.customer.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.customer.integration").append("\n"); 
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
		query.append("SELECT DISTINCT CUST_CD, " ).append("\n"); 
		query.append("  CUST_NM, " ).append("\n"); 
		query.append("  OFC_CD, " ).append("\n"); 
		query.append("  DECODE(SLS_DELT_EFF_DT, NULL, 'Y', 'Y' , 'Y', 'N') USE, " ).append("\n"); 
		query.append("  BZET_ADDR, " ).append("\n"); 
		query.append("  STE_CD, " ).append("\n"); 
		query.append("  ZIP_CD, " ).append("\n"); 
		query.append("  LOC_CD, " ).append("\n"); 
		query.append("  DECODE(RVIS_CNTR_CUST_TP_CD, 'B', 'BCO', 'Non-BCO') RVIS_CNTR_CUST_TP_CD, " ).append("\n"); 
		query.append("  CUST_GRP_ID," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  SREP_CD" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT /*+ INDEX_ASC(A XPKMDM_CUSTOMER) */ ROWNUM NO, " ).append("\n"); 
		query.append("      A.CUST_CNT_CD||lpad(A.CUST_SEQ, 6, 0) CUST_CD, " ).append("\n"); 
		query.append("      A.CUST_LGL_ENG_NM CUST_NM, " ).append("\n"); 
		query.append("      A.OFC_CD, " ).append("\n"); 
		query.append("      DECODE(A.SLS_DELT_EFF_DT, NULL, 'Y', 'N') SLS_DELT_EFF_DT, " ).append("\n"); 
		query.append("      B.BZET_ADDR, " ).append("\n"); 
		query.append("      B.STE_CD, " ).append("\n"); 
		query.append("      B.ZIP_CD, " ).append("\n"); 
		query.append("      A.LOC_CD, " ).append("\n"); 
		query.append("      A.RVIS_CNTR_CUST_TP_CD, " ).append("\n"); 
		query.append("      A.CUST_GRP_ID, " ).append("\n"); 
		query.append("      A.VNDR_SEQ," ).append("\n"); 
		query.append("      A.SREP_CD" ).append("\n"); 
		query.append("    FROM MDM_CUSTOMER A, " ).append("\n"); 
		query.append("      MDM_CUST_ADDR B " ).append("\n"); 
		query.append("    WHERE 1 = 1 " ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD = B.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("      AND A.CUST_SEQ = B.CUST_SEQ(+) " ).append("\n"); 
		query.append("      AND B.PRMRY_CHK_FLG(+) = 'Y' " ).append("\n"); 
		query.append("      AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("	  AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("		AND A.CUST_CNT_CD||lpad(A.CUST_SEQ,6,0) LIKE @[cust_cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("	#if(${include} == 'on')" ).append("\n"); 
		query.append("		AND upper(A.CUST_LGL_ENG_NM) LIKE '%' || upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND upper(A.CUST_LGL_ENG_NM) LIKE upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_cd} != '') " ).append("\n"); 
		query.append("		AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${zip_cd} != '')" ).append("\n"); 
		query.append("		AND B.ZIP_CD LIKE @[zip_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ) A " ).append("\n"); 
		query.append("WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("ORDER BY CUST_CD" ).append("\n"); 

	}
}