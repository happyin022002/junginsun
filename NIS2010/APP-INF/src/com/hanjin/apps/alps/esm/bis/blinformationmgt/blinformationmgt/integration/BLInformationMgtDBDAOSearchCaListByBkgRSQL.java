/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtDBDAOSearchCaListByBkgRSQL.java
*@FileTitle : C/A Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.20 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOSearchCaListByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BLInformationMgtDBDAOSearchCaListByBkgRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOSearchCaListByBkgRSQL").append("\n"); 
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
		query.append("SELECT BC.CORR_NO CA_NO," ).append("\n"); 
		query.append("BC.CORR_OFC_CD," ).append("\n"); 
		query.append("( SELECT CTRT_OFC_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = BC.BKG_NO ) CTRT_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(BC.CORR_DT, 'YYYY-MM-DD HH24:MI:SS') CORR_DT," ).append("\n"); 
		query.append("BC.CA_RSN_CD," ).append("\n"); 
		query.append("DECODE(BC.RAT_FLG,  'Y', 'R', '') as RAT_FLG," ).append("\n"); 
		query.append("DECODE(BC.EXPN_FLG, 'Y', 'E', '') as EXPN_FLG," ).append("\n"); 
		query.append("DECODE(BC.DOC_PERF_EXPT_CD, NULL, '', '', '', 'Y') as DOC_PERF_EXPT_CD," ).append("\n"); 
		query.append("DECODE(BC.RT_CORR_FLG,         'N', '', 'A') as RT_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.CHG_TERM_CORR_FLG,   'N', '', 'B') as CHG_TERM_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.RCVDE_TERM_CORR_FLG, 'N', '', 'C') as RCVDE_TERM_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.ROUT_CORR_FLG,       'N', '', 'D') as ROUT_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.CUST_CORR_FLG,       'N', '', 'E') as CUST_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.QTY_CORR_FLG,        'N', '', 'F') as QTY_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.MEAS_QTY_CORR_FLG,   'N', '', 'G') as MEAS_QTY_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.CMDT_CORR_FLG,       'N', '', 'H') as CMDT_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.TRNK_VSL_CORR_FLG,   'N', '', 'I') as TRNK_VSL_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.PRPST_VSL_CORR_FLG,  'N', '', 'J') as PRPST_VSL_CORR_FLG," ).append("\n"); 
		query.append("DECODE(BC.CA_OTR_RSN_CORR_FLG, 'N', '', 'K') as CA_OTR_RSN_CORR_FLG," ).append("\n"); 
		query.append("BC.BKG_NO," ).append("\n"); 
		query.append("BC.BKG_CORR_RMK" ).append("\n"); 
		query.append("FROM BIS_CORRECTION BC" ).append("\n"); 
		query.append("WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BC.CORR_NO NOT IN ('0000000001', 'TMP0000001')" ).append("\n"); 
		query.append("ORDER BY BC.CORR_DT DESC" ).append("\n"); 

	}
}