/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.30 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPath
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingAproPathRSQL").append("\n"); 
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
		query.append("SELECT	AFT_PATH.AFT_BKG_PATH_LVL" ).append("\n"); 
		query.append("	,	CD_DTL.INTG_CD_VAL_DP_DESC STS_DESC" ).append("\n"); 
		query.append("	,	TO_CHAR(ADJ_PROG.PROG_DT, 'YYYY-MM-DD') PROG_DT" ).append("\n"); 
		query.append("	,	CASE WHEN ADJ_PROG.PROG_OFC_CD IS NOT NULL THEN ADJ_PROG.PROG_OFC_CD" ).append("\n"); 
		query.append("	         ELSE" ).append("\n"); 
		query.append("	               NVL(AFT_PATH.APRO_OFC_CD,'ERROR')" ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("	    AS PROG_OFC_CD" ).append("\n"); 
		query.append("	,	(SELECT USR_NM PROG_USR_NM FROM COM_USER WHERE USR_ID = ADJ_PROG.PROG_USR_ID ) PROG_USR_NM" ).append("\n"); 
		query.append("	,	REPLACE(ADJ_PROG.PROG_RMK, '@*', chr(13) || chr(10)) PROG_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("    ,   ( SELECT * FROM DMT_AFT_BKG_ADJ_PROG A" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("	#if(${dar_no} != '')" ).append("\n"); 
		query.append("			 AND AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("	#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("             AND AFT_EXPT_DAR_NO = ( SELECT AFT_EXPT_DAR_NO FROM DMT_AFT_BKG_ADJ_RQST WHERE AFT_BKG_APRO_NO = @[apvl_no] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("             AND PROG_SEQ > ( SELECT MAX(PROG_SEQ) FROM DMT_AFT_BKG_ADJ_PROG WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO AND DMDT_EXPT_RQST_STS_CD = 'R' )" ).append("\n"); 
		query.append("        ) ADJ_PROG" ).append("\n"); 
		query.append("    ,   DMT_AFT_BKG_APRO_PATH AFT_PATH" ).append("\n"); 
		query.append("   	,	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("	#if(${dar_no} != '')" ).append("\n"); 
		query.append("        ADJ_RQST.AFT_EXPT_DAR_NO 		= @[dar_no]" ).append("\n"); 
		query.append("	#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("        ADJ_RQST.AFT_BKG_APRO_NO 		= @[apvl_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND ADJ_RQST.AFT_EXPT_DAR_NO 		= AFT_PATH.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    AND AFT_PATH.AFT_EXPT_DAR_NO 		= ADJ_PROG.AFT_EXPT_DAR_NO(+)" ).append("\n"); 
		query.append("    AND AFT_PATH.AFT_BKG_PATH_CD 	    = CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("    AND CD_DTL.INTG_CD_ID 				= 'CD03468'" ).append("\n"); 
		query.append("    AND AFT_PATH.AFT_BKG_PATH_CD 	    = ADJ_PROG.AFT_BKG_PATH_CD(+)" ).append("\n"); 
		query.append("    AND ADJ_PROG.DMDT_EXPT_RQST_STS_CD(+) != 'R'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND AFT_PATH.AFT_BKG_PATH_CPLS_FLG  = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY AFT_PATH.AFT_BKG_PATH_LVL" ).append("\n"); 

	}
}