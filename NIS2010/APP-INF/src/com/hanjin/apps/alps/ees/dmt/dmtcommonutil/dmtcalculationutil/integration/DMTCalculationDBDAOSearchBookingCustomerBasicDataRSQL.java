/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBookingCustomerBasicDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.03.31 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchBookingCustomerBasicDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBookingCustomerBasicData
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBookingCustomerBasicDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBookingCustomerBasicDataRSQL").append("\n"); 
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
		query.append("SELECT SYS_AREA_GRP_ID AS EXIST" ).append("\n"); 
		query.append(",DMDT_TRF_APLY_TP_CD AS TP_CD" ).append("\n"); 
		query.append(",DMDT_TRF_CD AS DMDT_TRF_CD" ).append("\n"); 
		query.append(",CNTR_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append(",DMDT_CHG_LOC_DIV_CD AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",FM_MVMT_STS_CD AS FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(FM_MVMT_DT,'YYYYMMDD') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",FM_MVMT_YD_CD AS FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",TO_MVMT_STS_CD AS TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_MVMT_YD_CD AS TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",SUBSTR(DMDT_TRF_CD,3,1) AS IO_BND" ).append("\n"); 
		query.append(",CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append(",ACT_CNT_CD AS ACT_CNT_CD" ).append("\n"); 
		query.append(",ACT_CUST_SEQ AS ACT_CUST_SEQ" ).append("\n"); 
		query.append(",BZC_TRF_CURR_CD AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO) IN (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_CYC_NO" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L','N','U')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("( DMDT_TRF_CD = 'DMIF' AND DMDT_CHG_LOC_DIV_CD = 'POD' )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( DMDT_TRF_CD = 'CTIC' AND DMDT_CHG_LOC_DIV_CD = 'DEL' )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CHG_SEQ = 1" ).append("\n"); 

	}
}