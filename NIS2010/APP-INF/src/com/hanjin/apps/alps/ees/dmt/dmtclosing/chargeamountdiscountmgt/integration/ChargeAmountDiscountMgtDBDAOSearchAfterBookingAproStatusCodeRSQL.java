/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproStatusCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.28 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproStatusCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproStatusCodeRSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproStatusCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_path_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproStatusCodeRSQL").append("\n"); 
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
		query.append("SELECT  ATTR_CTNT7 AS DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("       ,ATTR_CTNT2 AS DMDT_EXPT_RQST_STS_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  DMT_AFT_BKG_APRO_PATH  T1" ).append("\n"); 
		query.append("	   ,DMT_HRD_CDG_CTNT       T2" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  T1.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("   AND  T1.AFT_BKG_PATH_CD = @[aft_bkg_path_cd]" ).append("\n"); 
		query.append("   AND  T2.HRD_CDG_ID	   = 'AFT_BKG_APRO_PATH'" ).append("\n"); 
		query.append("   AND  T1.AFT_BKG_PATH_CD = T2.ATTR_CTNT1" ).append("\n"); 

	}
}