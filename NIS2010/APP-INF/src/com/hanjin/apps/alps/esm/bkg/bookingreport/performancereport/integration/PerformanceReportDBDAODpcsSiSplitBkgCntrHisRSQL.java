/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAODpcsSiSplitBkgCntrHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.28 김기종
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

public class PerformanceReportDBDAODpcsSiSplitBkgCntrHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PerformanceReportDBDAODpcsSiSplitBkgCntrHisRSQL(){
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
		query.append("FileName : PerformanceReportDBDAODpcsSiSplitBkgCntrHisRSQL").append("\n"); 
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
		query.append("#if (${xter_sndr_id} == '')" ).append("\n"); 
		query.append("	SELECT BKG_NO" ).append("\n"); 
		query.append("			,DOC_TP_CD" ).append("\n"); 
		query.append("			,XTER_RQST_NO" ).append("\n"); 
		query.append("			,SPLIT_STS_CD" ).append("\n"); 
		query.append("			,XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append("			,BKG_UPLD_STS_CD" ).append("\n"); 
		query.append("			,XTER_RQST_SEQ" ).append("\n"); 
		query.append("			,RQST_DT" ).append("\n"); 
		query.append("			,POL_CD" ).append("\n"); 
		query.append("			,RQST_DEP_DT" ).append("\n"); 
		query.append("			,VVD_CD" ).append("\n"); 
		query.append("			,EDI_HLD_FLG" ).append("\n"); 
		query.append("			,ORIGIN_CNTR_CNT" ).append("\n"); 
		query.append("			,CNTR_CNT" ).append("\n"); 
		query.append("            ,CNTR_DESC		" ).append("\n"); 
		query.append("			,ORIGIN_BKG_QTY" ).append("\n"); 
		query.append("			,BKG_QTY" ).append("\n"); 
		query.append("			,XTER_RMK" ).append("\n"); 
		query.append("			,XTER_RMK_ALL" ).append("\n"); 
		query.append("			,PCK_QTY" ).append("\n"); 
		query.append("			,PCK_TP_CD" ).append("\n"); 
		query.append("			,NET_WGT" ).append("\n"); 
		query.append("			,NET_WGT_UT_CD" ).append("\n"); 
		query.append("			,MEAS_QTY" ).append("\n"); 
		query.append("			,MEAS_UT_CD" ).append("\n"); 
		query.append("			,XTER_SNDR_ID" ).append("\n"); 
		query.append("			,VPS_ETD_DT" ).append("\n"); 
		query.append("			,SEARCH_TYPE" ).append("\n"); 
		query.append("			,CRE_DT" ).append("\n"); 
		query.append("			,NO_RANK" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH TEMP_T AS (" ).append("\n"); 
		query.append("SELECT  /*+RULE */" ).append("\n"); 
		query.append("       B.BKG_NO" ).append("\n"); 
		query.append(",      X.DOC_TP_CD" ).append("\n"); 
		query.append(",      X.XTER_RQST_NO" ).append("\n"); 
		query.append(",      X.SPLIT_STS_CD" ).append("\n"); 
		query.append(",      X.XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append(",      X.BKG_UPLD_STS_CD" ).append("\n"); 
		query.append(",      X.XTER_RQST_SEQ" ).append("\n"); 
		query.append(",      TO_CHAR(X.RQST_DT,'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append(",      B.POL_CD" ).append("\n"); 
		query.append(",      TO_CHAR(X.RQST_DEP_DT,'YYYY-MM-DD') AS RQST_DEP_DT" ).append("\n"); 
		query.append(",      VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD_CD " ).append("\n"); 
		query.append(",      B.EDI_HLD_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",      CASE WHEN X.XTER_SNDR_ID IS NULL THEN  0 ELSE X.ORG_BKG_QTY END AS  ORIGIN_BKG_QTY " ).append("\n"); 
		query.append(",      (SELECT  NVL(SUM(Q.OP_CNTR_QTY),0) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = B.BKG_NO) AS  BKG_QTY   -- current" ).append("\n"); 
		query.append(",      CASE WHEN X.XTER_SNDR_ID IS NULL THEN  0 ELSE X.ORG_BKG_CNTR_QTY END AS  ORIGIN_CNTR_CNT " ).append("\n"); 
		query.append(",      (SELECT NVL(SUM(C.CNTR_VOL_QTY),0) FROM BKG_CONTAINER C WHERE C.BKG_NO = B.BKG_NO) AS  CNTR_CNT -- current" ).append("\n"); 
		query.append(",      BKG_JOIN_FNC(CURSOR(SELECT C.CNTR_NO  FROM BKG_CONTAINER C WHERE C.BKG_NO = B.BKG_NO),',') CNTR_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",      REPLACE(SUBSTR(X.XTER_BKG_RMK1,1,100), CHR(13) || CHR(10), ' ') AS XTER_RMK" ).append("\n"); 
		query.append(",      X.XTER_BKG_RMK1 AS XTER_RMK_ALL" ).append("\n"); 
		query.append(",      (SELECT D.PCK_QTY FROM BKG_BL_DOC D WHERE D.BKG_NO = B.BKG_NO) AS PCK_QTY" ).append("\n"); 
		query.append(",      (SELECT D.PCK_TP_CD FROM BKG_BL_DOC D WHERE D.BKG_NO = B.BKG_NO) AS PCK_TP_CD" ).append("\n"); 
		query.append(",      (SELECT D.ACT_WGT FROM BKG_BL_DOC D WHERE D.BKG_NO = B.BKG_NO) AS  NET_WGT" ).append("\n"); 
		query.append(",      (SELECT D.WGT_UT_CD FROM BKG_BL_DOC D WHERE D.BKG_NO = B.BKG_NO) AS  NET_WGT_UT_CD" ).append("\n"); 
		query.append(",      (SELECT D.MEAS_QTY FROM BKG_BL_DOC D WHERE D.BKG_NO = B.BKG_NO) AS  MEAS_QTY" ).append("\n"); 
		query.append(",      (SELECT D.MEAS_UT_CD FROM BKG_BL_DOC D WHERE D.BKG_NO = B.BKG_NO) AS  MEAS_UT_CD" ).append("\n"); 
		query.append(",      X.XTER_SNDR_ID" ).append("\n"); 
		query.append(",      TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD') AS VPS_ETD_DT	" ).append("\n"); 
		query.append(",      '' SEARCH_TYPE" ).append("\n"); 
		query.append(",      X.CRE_DT" ).append("\n"); 
		query.append(",      DENSE_RANK()  OVER(PARTITION BY X.BKG_NO ORDER BY X.CRE_DT,X.XTER_RQST_NO,X.XTER_RQST_SEQ   ) NO_RANK" ).append("\n"); 
		query.append("FROM   BKG_XTER_RQST_MST X" ).append("\n"); 
		query.append(",      BKG_BOOKING B" ).append("\n"); 
		query.append(",      BKG_VVD VVD" ).append("\n"); 
		query.append(",      VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    X.BKG_NO(+)       = B.BKG_NO" ).append("\n"); 
		query.append("AND    VPS.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("AND    VPS.SKD_VOY_NO     =   VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    VPS.SKD_DIR_CD     =   VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    VPS.CLPT_IND_SEQ   =   VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND	   VPS.VPS_PORT_CD    =   VVD.POL_CD" ).append("\n"); 
		query.append("AND    VVD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =   (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                              FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                              WHERE  BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("AND  B.BL_NO LIKE (SELECT SUBSTR(BK.BL_NO,1,10)" ).append("\n"); 
		query.append("                  FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("                  WHERE  1 = 1 " ).append("\n"); 
		query.append("                  AND    BK.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                  AND    BK.BKG_CGO_TP_CD = 'F' " ).append("\n"); 
		query.append("                  AND    BK.BKG_NO = (SELECT X2.BKG_NO" ).append("\n"); 
		query.append("                                      FROM   BKG_XTER_RQST_MST X2" ).append("\n"); 
		query.append("                                      WHERE  X2.XTER_SNDR_ID = @[xter_sndr_id] AND X2.XTER_RQST_NO = @[xter_rqst_no] AND X2.XTER_RQST_SEQ = @[xter_rqst_seq])" ).append("\n"); 
		query.append("                  ) || '%'" ).append("\n"); 
		query.append("                                  " ).append("\n"); 
		query.append("AND    NVL(X.DOC_TP_CD,'S') = 'S'   " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("ORDER BY   X.CRE_DT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT T1.* FROM TEMP_T T1  WHERE T1.NO_RANK =  NVL((SELECT MIN(NO_RANK) FROM TEMP_T T2 WHERE T1.BKG_NO = T2.BKG_NO AND NVL(ORIGIN_BKG_QTY,0) > 0),1)    ORDER BY BKG_NO        " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}