/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ReportDBDAOSearchCustomerReportCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportDBDAOSearchCustomerReportCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화주 정보 조회한다
	  * </pre>
	  */
	public ReportDBDAOSearchCustomerReportCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOSearchCustomerReportCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(CUST.CUST_CNT_CD) ROW_CNT" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND CUST.CUST_CNT_CD LIKE '%${cust_cnt_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("   AND CUST.CUST_LGL_ENG_NM LIKE '%${cust_lgl_eng_nm}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("   AND CUST.LOC_CD LIKE '%${loc_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND CUST.OFC_CD LIKE '%${ofc_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${status} != '')" ).append("\n"); 
		query.append("   AND DELT_FLG = @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}