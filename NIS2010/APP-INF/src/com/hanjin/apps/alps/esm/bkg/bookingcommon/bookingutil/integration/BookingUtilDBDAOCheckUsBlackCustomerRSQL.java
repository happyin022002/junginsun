/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOCheckUsBlackCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOCheckUsBlackCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckUsBlackCustomer
	  * 3글자 이하일 땐 무조건 EQUAL 조건
	  * </pre>
	  */
	public BookingUtilDBDAOCheckUsBlackCustomerRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOCheckUsBlackCustomerRSQL").append("\n"); 
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
		query.append("#if(${full_sch_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT BLCK_KW_NM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BLCK_KW_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM BKG_BLCK_KW_LIST" ).append("\n"); 
		query.append("WHERE BLCK_KW_TP_CD='SAN'" ).append("\n"); 
		query.append("#if(${full_sch_flg} == 'Y')" ).append("\n"); 
		query.append("	AND UPPER(TRIM(@[cust_nm])) = UPPER(TRIM(BLCK_KW_NM))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND (    UPPER(TRIM(@[cust_nm])) = UPPER(TRIM(BLCK_KW_NM))" ).append("\n"); 
		query.append("          OR ( LENGTH(BLCK_KW_NM) > 3" ).append("\n"); 
		query.append("               AND (    UPPER(@[cust_nm]) LIKE UPPER(BLCK_KW_NM)||' %'" ).append("\n"); 
		query.append("                     OR UPPER(@[cust_nm]) LIKE '% '||UPPER(BLCK_KW_NM)" ).append("\n"); 
		query.append("                     OR UPPER(@[cust_nm]) LIKE '% '||UPPER(BLCK_KW_NM)||' %'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}