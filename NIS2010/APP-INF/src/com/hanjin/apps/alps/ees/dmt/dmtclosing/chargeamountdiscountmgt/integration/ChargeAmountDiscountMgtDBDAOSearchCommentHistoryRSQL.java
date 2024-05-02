/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchCommentHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
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

public class ChargeAmountDiscountMgtDBDAOSearchCommentHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request - After Booking Request 의 Comment History 정보를 조회하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchCommentHistoryRSQL(){
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
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchCommentHistoryRSQL").append("\n"); 
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
		query.append("SELECT	ADJ_PROG.PROG_SEQ" ).append("\n"); 
		query.append("	,	CD_DTL.INTG_CD_VAL_DP_DESC STS_DESC" ).append("\n"); 
		query.append("	,	TO_CHAR(ADJ_PROG.PROG_DT, 'YYYY-MM-DD') PROG_DT" ).append("\n"); 
		query.append("	,	ADJ_PROG.PROG_OFC_CD" ).append("\n"); 
		query.append("	,	COM_USER.USR_NM PROG_USR_NM" ).append("\n"); 
		query.append("	,	DECODE(NVL(LENGTH(TRIM(ADJ_PROG.PROG_RMK)),0),0,'N','Y') PROG_RMK_FLG" ).append("\n"); 
		query.append("	,	REPLACE(ADJ_PROG.PROG_RMK, '@*', chr(13) || chr(10)) PROG_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("    ,   DMT_AFT_BKG_ADJ_PROG ADJ_PROG" ).append("\n"); 
		query.append("   	,	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("	,	COM_USER" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	#if(${dar_no} != '')" ).append("\n"); 
		query.append("        ADJ_RQST.AFT_EXPT_DAR_NO 		= @[dar_no]" ).append("\n"); 
		query.append("	#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("        ADJ_RQST.AFT_BKG_APRO_NO 		= @[apvl_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    AND ADJ_RQST.AFT_EXPT_DAR_NO 		= ADJ_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    AND ADJ_PROG.DMDT_EXPT_RQST_STS_CD 	= CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("    AND CD_DTL.INTG_CD_ID 				= 'CD01971'        " ).append("\n"); 
		query.append("    AND	ADJ_PROG.PROG_USR_ID 			= COM_USER.USR_ID(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY ADJ_PROG.PROG_SEQ DESC" ).append("\n"); 

	}
}