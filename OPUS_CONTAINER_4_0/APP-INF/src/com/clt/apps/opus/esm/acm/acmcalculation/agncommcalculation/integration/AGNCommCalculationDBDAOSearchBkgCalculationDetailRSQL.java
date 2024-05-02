/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommCalculationDBDAOSearchBkgCalculationDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalculationDBDAOSearchBkgCalculationDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgCalculationDetail
	  * </pre>
	  */
	public AGNCommCalculationDBDAOSearchBkgCalculationDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.integration").append("\n"); 
		query.append("FileName : AGNCommCalculationDBDAOSearchBkgCalculationDetailRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_NO,IO_BND_CD,GENERAL_AMT,BROG_AMT,CHF_AMT,TS_AMT,CROSS_AMT,CSF_AMT,RCSF_AMT," ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("    SELECT SUM(IF_AMT) FROM ACM_FAC_COMM  WHERE BKG_NO = B.BKG_NO AND SLS_OFC_CD = @[agn_cd] " ).append("\n"); 
		query.append("    )FAC_AMT,(" ).append("\n"); 
		query.append("    SELECT SUM(IF_AMT) FROM ACM_FF_CMPN   WHERE BKG_NO = B.BKG_NO AND AR_OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("    )FF_AMT,(" ).append("\n"); 
		query.append("    SELECT SUM(IF_AMT) FROM ACM_SPCL_CMPN WHERE BKG_NO = B.BKG_NO AND SPCL_OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("    )SPCL_AMT" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, (" ).append("\n"); 
		query.append("    SELECT BKG_NO," ).append("\n"); 
		query.append("    	IO_BND_CD," ).append("\n"); 
		query.append("        NVL(SUM(DECODE(A.AC_TP_CD, 'G', A.IF_AMT, 0)),0) AS GENERAL_AMT," ).append("\n"); 
		query.append("        NVL(SUM(DECODE(A.AC_TP_CD, 'K', A.IF_AMT, 0)),0) AS BROG_AMT," ).append("\n"); 
		query.append("        NVL(SUM(DECODE(A.AC_TP_CD, 'H', A.IF_AMT, 0)),0) AS CHF_AMT," ).append("\n"); 
		query.append("        NVL(SUM(DECODE(A.AC_TP_CD, 'S', A.IF_AMT, 0)),0) AS TS_AMT," ).append("\n"); 
		query.append("        NVL(SUM(DECODE(A.AC_TP_CD, 'C', A.IF_AMT, 0)),0) AS CROSS_AMT," ).append("\n"); 
		query.append("        NVL(SUM(DECODE(A.AC_TP_CD, 'N', A.IF_AMT, 0)),0) AS CSF_AMT," ).append("\n"); 
		query.append("        NVL(SUM(DECODE(A.AC_TP_CD, 'R', A.IF_AMT, 0)),0) AS RCSF_AMT" ).append("\n"); 
		query.append("    FROM ACM_AGN_COMM A " ).append("\n"); 
		query.append("    WHERE A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("    AND   A.BKG_NO IN (${bkg_no})" ).append("\n"); 
		query.append("    GROUP BY BKG_NO, IO_BND_CD" ).append("\n"); 
		query.append(")AGN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_NO IN (${bkg_no})" ).append("\n"); 
		query.append("AND AGN.BKG_NO(+) = B.BKG_NO" ).append("\n"); 

	}
}