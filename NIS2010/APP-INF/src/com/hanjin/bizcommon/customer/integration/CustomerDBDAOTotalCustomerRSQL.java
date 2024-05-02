/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CustomerDBDAOTotalCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
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
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  	FROM MDM_CUSTOMER A " ).append("\n"); 
		query.append("#if(${zip_cd} != '')" ).append("\n"); 
		query.append("        ,MDM_CUST_ADDR B " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 	WHERE 1=1" ).append("\n"); 
		query.append("      AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("	  AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD||lpad(A.CUST_SEQ,6,0) LIKE @[cust_cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("	#if(${include} == 'on')" ).append("\n"); 
		query.append("	  AND upper(A.CUST_LGL_ENG_NM) LIKE '%' || upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	  AND upper(A.CUST_LGL_ENG_NM) LIKE upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("      AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${zip_cd} != '')" ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD = B.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("      AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("      AND B.PRMRY_CHK_FLG(+) = 'Y' " ).append("\n"); 
		query.append("      AND B.ZIP_CD LIKE @[zip_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}