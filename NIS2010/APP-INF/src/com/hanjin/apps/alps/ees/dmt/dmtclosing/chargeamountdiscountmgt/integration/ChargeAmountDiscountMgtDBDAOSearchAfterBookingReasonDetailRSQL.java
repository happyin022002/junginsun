/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDetail
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingReasonDetailRSQL").append("\n"); 
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
		query.append("SELECT  AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("       ,AFT_BKG_FILE_DIV_CD" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,1,AFT_BKG_RMK,'')) DETAIL_1_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,2,AFT_BKG_RMK,'')) DETAIL_2_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,3,AFT_BKG_RMK,'')) DETAIL_3_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,4,AFT_BKG_RMK,'')) DETAIL_4_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,5,AFT_BKG_RMK,'')) DETAIL_5_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,6,AFT_BKG_RMK,'')) DETAIL_6_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,7,AFT_BKG_RMK,'')) DETAIL_7_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,8,AFT_BKG_RMK,'')) DETAIL_8_TYPE" ).append("\n"); 
		query.append("       ,MAX(DECODE(A_RANK,9,AFT_BKG_RMK,'')) DETAIL_9_TYPE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT AFT_EXPT_DAR_NO, " ).append("\n"); 
		query.append("           AFT_BKG_FILE_DIV_CD," ).append("\n"); 
		query.append("           AFT_BKG_RMK, " ).append("\n"); 
		query.append("           AFT_BKG_RMK_LVL AS A_RANK," ).append("\n"); 
		query.append("           AFT_BKG_RSN_RMK_RQST_SEQ" ).append("\n"); 
		query.append("      FROM DMT_AFT_BKG_RSN_RMK_RQST" ).append("\n"); 
		query.append("     WHERE AFT_EXPT_DAR_NO = @[dar_no] " ).append("\n"); 
		query.append("       AND AFT_BKG_FILE_DIV_CD IN ( SELECT ATTR_CTNT3 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'AFT_BKG_RSN_CD' )" ).append("\n"); 
		query.append("#if ( ${sts_cd} == 'A' )" ).append("\n"); 
		query.append("	   AND AFT_BKG_RMK_LVL = '0'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND AFT_BKG_RMK_LVL > '0'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("GROUP BY AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        ,AFT_BKG_FILE_DIV_CD" ).append("\n"); 
		query.append("        ,AFT_BKG_RSN_RMK_RQST_SEQ" ).append("\n"); 

	}
}