/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOCaInquiryReportCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.01 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaInquiryReportCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCaInquiryReportCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaInquiryReportCustRSQL").append("\n"); 
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
		query.append("#if (${corr_no} == '')" ).append("\n"); 
		query.append("SELECT CUS.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",CUS.CUST_CNT_CD" ).append("\n"); 
		query.append(",CUS.CUST_SEQ" ).append("\n"); 
		query.append(",CUS.CUST_NM" ).append("\n"); 
		query.append(",CUS.CUST_ADDR" ).append("\n"); 
		query.append(",CUS.CUST_FAX_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append(",BKG_CUSTOMER     CUS" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = CUS.BKG_NO" ).append("\n"); 
		query.append("AND CUS.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CUS.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",CUS.CUST_CNT_CD" ).append("\n"); 
		query.append(",CUS.CUST_SEQ" ).append("\n"); 
		query.append(",CUS.CUST_NM" ).append("\n"); 
		query.append(",CUS.CUST_ADDR" ).append("\n"); 
		query.append(",CUS.CUST_FAX_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append(",BKG_CUST_HIS     CUS" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = CUS.BKG_NO" ).append("\n"); 
		query.append("AND CUS.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND CUS.CORR_NO = @[corr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}