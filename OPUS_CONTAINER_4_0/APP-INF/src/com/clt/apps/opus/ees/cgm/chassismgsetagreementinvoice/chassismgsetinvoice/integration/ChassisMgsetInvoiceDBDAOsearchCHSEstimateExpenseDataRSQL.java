/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.05.24 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091008 1107 start
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("EXE_YRMON" ).append("\n"); 
		query.append(",SYS_SRC_ID" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",AGMT_NO 			AS AGMT_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD		AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(",LOC_CD 			AS CHSS_POOL_CD" ).append("\n"); 
		query.append(",ESTM_SEQ_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_DIR_CD" ).append("\n"); 
		query.append(",WO_NO			 	AS REV_VVD" ).append("\n"); 
		query.append(",ESTM_AMT" ).append("\n"); 
		query.append(",ACT_AMT" ).append("\n"); 
		query.append(",ACCL_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",VNDR_INV_NO AS INVO_NO" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SYS_SRC_ID = 'CHS'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[period_eddt]" ).append("\n"); 
		query.append("#if (${div} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN ($div)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rev_month} != '')" ).append("\n"); 
		query.append("AND REV_YRMON = @[rev_month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY REV_YRMON DESC" ).append("\n"); 

	}
}