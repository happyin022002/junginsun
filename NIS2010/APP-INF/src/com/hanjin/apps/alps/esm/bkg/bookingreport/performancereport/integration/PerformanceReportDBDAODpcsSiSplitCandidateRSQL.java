/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAODpcsSiSplitCandidateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.01
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.01 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODpcsSiSplitCandidateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PerformanceReportDBDAODpcsSiSplitCandidateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODpcsSiSplitCandidateRSQL").append("\n"); 
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
		query.append("SELECT /*+RULE */ X.BKG_NO" ).append("\n"); 
		query.append(",      X.DOC_TP_CD" ).append("\n"); 
		query.append(",      X.XTER_RQST_NO" ).append("\n"); 
		query.append(",      X.SPLIT_STS_CD" ).append("\n"); 
		query.append(",      X.XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append(",      X.BKG_UPLD_STS_CD" ).append("\n"); 
		query.append(",      X.XTER_RQST_SEQ" ).append("\n"); 
		query.append(",      TO_CHAR(X.RQST_DT,'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append(",      X.POL_CD" ).append("\n"); 
		query.append(",      TO_CHAR(X.RQST_DEP_DT,'YYYY-MM-DD') AS RQST_DEP_DT" ).append("\n"); 
		query.append(",      X.VSL_CD || X.SKD_VOY_NO || X.SKD_DIR_CD AS VVD_CD " ).append("\n"); 
		query.append(",      B.EDI_HLD_FLG" ).append("\n"); 
		query.append(",      (SELECT COUNT(1) FROM  BKG_XTER_CNTR C WHERE C.XTER_SNDR_ID = X.XTER_SNDR_ID AND C.XTER_RQST_NO = X.XTER_RQST_NO AND C.XTER_RQST_SEQ = X.XTER_RQST_SEQ) CNTR_CNT" ).append("\n"); 
		query.append(",      BKG_JOIN_FNC(CURSOR(SELECT C.CNTR_NO FROM  BKG_XTER_CNTR C WHERE C.XTER_SNDR_ID = X.XTER_SNDR_ID AND C.XTER_RQST_NO = X.XTER_RQST_NO AND C.XTER_RQST_SEQ = X.XTER_RQST_SEQ),',') CNTR_DESC" ).append("\n"); 
		query.append(",      REPLACE(SUBSTR(X.XTER_BKG_RMK1,1,100), CHR(13) || CHR(10), ' ') AS XTER_RMK" ).append("\n"); 
		query.append(",      X.XTER_BKG_RMK1 AS XTER_RMK_ALL" ).append("\n"); 
		query.append(",      X.PCK_QTY" ).append("\n"); 
		query.append(",      X.PCK_TP_CD" ).append("\n"); 
		query.append("--,      X.NET_WGT" ).append("\n"); 
		query.append("--,      X.NET_WGT_UT_CD" ).append("\n"); 
		query.append(",      X.ESTM_WGT AS NET_WGT" ).append("\n"); 
		query.append(",      X.ESTM_WGT_UT_CD AS NET_WGT_UT_CD" ).append("\n"); 
		query.append(",      X.MEAS_QTY" ).append("\n"); 
		query.append(",      X.MEAS_UT_CD" ).append("\n"); 
		query.append(",      X.XTER_SNDR_ID" ).append("\n"); 
		query.append(",      TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD') AS VPS_ETD_DT	" ).append("\n"); 
		query.append(",      CASE WHEN B.BKG_NO IS NULL OR B.BKG_STS_CD = 'X' THEN 'N' ELSE 'Y' END AS BKG_VALID_FLG" ).append("\n"); 
		query.append(",	   '' SEARCH_TYPE" ).append("\n"); 
		query.append("FROM   BKG_XTER_RQST_MST X" ).append("\n"); 
		query.append(",      BKG_BOOKING B" ).append("\n"); 
		query.append(",      BKG_VVD VVD" ).append("\n"); 
		query.append(",      VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    X.BKG_NO       = B.BKG_NO(+)          " ).append("\n"); 
		query.append("AND    VPS.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("AND    VPS.SKD_VOY_NO     =   VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    VPS.SKD_DIR_CD     =   VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    VPS.CLPT_IND_SEQ   =   VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND	   VPS.VPS_PORT_CD    =   VVD.POL_CD" ).append("\n"); 
		query.append("AND    VVD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =   (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                              FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                              WHERE  BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    X.BKG_NO = (SELECT X2.BKG_NO FROM BKG_XTER_RQST_MST X2 WHERE X2.XTER_SNDR_ID = @[xter_sndr_id] AND X2.XTER_RQST_NO = @[xter_rqst_no] AND X2.XTER_RQST_SEQ = @[xter_rqst_seq])" ).append("\n"); 
		query.append("AND    X.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("AND    X.XTER_BKG_RQST_STS_CD IN ('C','U')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY X.XTER_RQST_NO,X.XTER_RQST_SEQ" ).append("\n"); 

	}
}