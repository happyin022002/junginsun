/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageDBDAOSearchSalesReportInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOSearchSalesReportInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SalesReportInfo의 조회용 쿼리
	  * </pre>
	  */
	public SalesActivityManageDBDAOSearchSalesReportInfoRSQL(){
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
		params.put("sls_act_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOSearchSalesReportInfoRSQL").append("\n"); 
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
		query.append("SELECT SAR.CUST_CNT_CD" ).append("\n"); 
		query.append("     , SAR.CUST_SEQ" ).append("\n"); 
		query.append("     , MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , SAR.SLS_ACT_SEQ" ).append("\n"); 
		query.append("     , SAR.SLS_ACT_ACT_DT" ).append("\n"); 
		query.append("     , SAR.SREP_CD" ).append("\n"); 
		query.append("     , MSR.SREP_NM" ).append("\n"); 
		query.append("     , SAR.CNTC_PSON_NM" ).append("\n"); 
		query.append("     , SAR.SLS_RPT_CLSS_CD" ).append("\n"); 
		query.append("     , SAR.SLS_RPT_SMRY_DESC" ).append("\n"); 
		query.append("     , SAR.PRB_CLSS_CD" ).append("\n"); 
		query.append("     , SAR.PRB_DESC" ).append("\n"); 
		query.append("     , SAR.SGS_CLSS_CD" ).append("\n"); 
		query.append("     , SAR.SGS_DESC" ).append("\n"); 
		query.append("     , SAR.NXT_PLN_CLSS_CD" ).append("\n"); 
		query.append("     , SAR.NXT_PLN_DESC" ).append("\n"); 
		query.append("     , SAR.VST_PLC_CTNT" ).append("\n"); 
		query.append("     , SAR.SLS_PRMT_DESC" ).append("\n"); 
		query.append("     , SAR.BIZ_AREA_CD" ).append("\n"); 
		query.append("	 , SAR.FREE_RPT_CTNT" ).append("\n"); 
		query.append("FROM SAM_SLS_ACT_RPT SAR" ).append("\n"); 
		query.append("   , MDM_CUSTOMER MC" ).append("\n"); 
		query.append("   , MDM_SLS_REP MSR" ).append("\n"); 
		query.append("WHERE SAR.SREP_CD = MSR.SREP_CD" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = SAR.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = SAR.CUST_SEQ" ).append("\n"); 
		query.append("AND SAR.SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("AND SAR.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND SAR.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND SAR.SLS_ACT_SEQ = @[sls_act_seq]" ).append("\n"); 

	}
}