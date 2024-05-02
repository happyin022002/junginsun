/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchTotalCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.23
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.05.23 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchTotalCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTotalCustomer
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchTotalCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchTotalCustomerRSQL").append("\n"); 
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
		query.append("  	FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append(" 	WHERE A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("	AND NVL(NMD_CUST_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND A.CUST_CNT_CD||lpad(A.CUST_SEQ,6,0) LIKE @[cust_cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("	#if(${include} == 'on')" ).append("\n"); 
		query.append("		AND upper(A.CUST_LGL_ENG_NM) LIKE '%' || upper(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND upper(A.CUST_LGL_ENG_NM) LIKE upper(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${no_use} != '') " ).append("\n"); 
		query.append("  AND (A.SLS_DELT_EFF_DT IS NULL OR A.SLS_DELT_EFF_DT IS NOT NULL)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND A.SLS_DELT_EFF_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}