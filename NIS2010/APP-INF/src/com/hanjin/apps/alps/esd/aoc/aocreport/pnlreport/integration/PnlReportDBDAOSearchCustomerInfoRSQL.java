/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnlReportDBDAOSearchCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PnlReportDBDAOSearchCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.24 변종건 [CHM-201217633] Customer 정보 조회
	  * </pre>
	  */
	public PnlReportDBDAOSearchCustomerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration").append("\n"); 
		query.append("FileName : PnlReportDBDAOSearchCustomerInfoRSQL").append("\n"); 
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
		query.append("SELECT  CUST_CNT_CD || LPAD(CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("      , CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     CUST_CNT_CD = SUBSTRB(TRIM(@[s_cust_cd]),1,2)" ).append("\n"); 
		query.append("AND     CUST_SEQ = TO_NUMBER(SUBSTRB(TRIM(@[s_cust_cd]),3))" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}