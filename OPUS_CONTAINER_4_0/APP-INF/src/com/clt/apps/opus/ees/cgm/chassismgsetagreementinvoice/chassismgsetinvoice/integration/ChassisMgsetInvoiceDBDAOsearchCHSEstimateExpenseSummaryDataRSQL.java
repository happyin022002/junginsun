/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseSummaryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.03 이용태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseSummaryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa Chassis 1107 Summary 조회
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseSummaryDataRSQL(){
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
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSEstimateExpenseSummaryDataRSQL").append("\n"); 
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
		query.append("T1.EXE_YRMON" ).append("\n"); 
		query.append(",T1.SYS_SRC_ID" ).append("\n"); 
		query.append(",T1.REV_YRMON" ).append("\n"); 
		query.append(",T1.VSL_CD" ).append("\n"); 
		query.append(",T1.SKD_VOY_NO" ).append("\n"); 
		query.append(",T1.SKD_DIR_CD" ).append("\n"); 
		query.append(",T1.REV_DIR_CD" ).append("\n"); 
		query.append(",T1.ACCT_CD" ).append("\n"); 
		query.append(",SUM( NVL(T1.ESTM_AMT,0) ) AS ESTM_AMT" ).append("\n"); 
		query.append(",SUM( NVL(T1.ACT_AMT,0) ) AS ACT_AMT" ).append("\n"); 
		query.append(",SUM( NVL(T1.ACCL_AMT,0) ) AS ACCL_AMT" ).append("\n"); 
		query.append(",MAX(T1.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append(",MAX(TO_CHAR(T1.CRE_DT, 'YYYY-MM-DD')) AS CRE_DT" ).append("\n"); 
		query.append(",MAX(T1.UPD_USR_ID)   UPD_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",MAX(TO_CHAR(T1.UPD_DT, 'YYYY-MM-DD') ) AS UPD_DT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP T1" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("T1.SYS_SRC_ID = 'CHS' " ).append("\n"); 
		query.append("AND T1.EXE_YRMON = @[period_eddt]" ).append("\n"); 
		query.append("#if (${div} != '')" ).append("\n"); 
		query.append("AND T1.CNTR_TPSZ_CD IN ($div)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_month} != '')" ).append("\n"); 
		query.append("AND T1.REV_YRMON = @[rev_month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY T1.SYS_SRC_ID" ).append("\n"); 
		query.append("         ,T1.EXE_YRMON" ).append("\n"); 
		query.append("         ,T1.REV_YRMON" ).append("\n"); 
		query.append("         ,T1.VSL_CD" ).append("\n"); 
		query.append("         ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("         ,T1.REV_DIR_CD" ).append("\n"); 
		query.append("         ,T1.ACCT_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("ORDER BY T1.SYS_SRC_ID DESC, T1.EXE_YRMON, T1.REV_YRMON DESC" ).append("\n"); 

	}
}