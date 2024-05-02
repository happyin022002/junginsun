/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAODpcsSiSplitBkgCntrCompareResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.09
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.09 김기종
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

public class PerformanceReportDBDAODpcsSiSplitBkgCntrCompareResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PerformanceReportDBDAODpcsSiSplitBkgCntrCompareResultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_list",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODpcsSiSplitBkgCntrCompareResultRSQL").append("\n"); 
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
		query.append("#if (${search_type} == '')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("SELECT '' ORIGIN" ).append("\n"); 
		query.append(",      '' BKG_NO" ).append("\n"); 
		query.append(",      '' XTER_SNDR_ID" ).append("\n"); 
		query.append(",      '' XTER_RQST_NO" ).append("\n"); 
		query.append(",      '' XTER_RQST_SEQ" ).append("\n"); 
		query.append(",      '' CNTR_NO	" ).append("\n"); 
		query.append(",      '' SHARE_VOL" ).append("\n"); 
		query.append(",      '' MATCH_FLG" ).append("\n"); 
		query.append(",      '' MASTER_EXIST_FLG" ).append("\n"); 
		query.append(",      '' ESI_EXIST_FLG" ).append("\n"); 
		query.append(",      '' PART_LOAD_CNT" ).append("\n"); 
		query.append(",      '' DUP_SI_REF		" ).append("\n"); 
		query.append(",      '' ORIGIN" ).append("\n"); 
		query.append(",      '' CNTR_DESC" ).append("\n"); 
		query.append(",      '' CNTR_LIST	" ).append("\n"); 
		query.append(",      '' SEARCH_TYPE" ).append("\n"); 
		query.append(",      '' CNTR_TOT_MASTER_CNT" ).append("\n"); 
		query.append(",      '' CNTR_TOT_SPLIT_SI_ALL_CNT" ).append("\n"); 
		query.append(",      '' CNTR_TOT_SPLIT_SI_DISTINCT_CNT" ).append("\n"); 
		query.append(",      '' TOT_SPLIST_SI_PART_LOAD_CNT  " ).append("\n"); 
		query.append(",      '' SUM_COL_VAL " ).append("\n"); 
		query.append(",      '' NUM" ).append("\n"); 
		query.append(",      '' TITLE" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH TEMP_T AS (" ).append("\n"); 
		query.append("SELECT   BKG_GET_TOKEN_FNC(COLUMN_VALUE,1,'￠') ORIGIN" ).append("\n"); 
		query.append(",        BKG_GET_TOKEN_FNC(COLUMN_VALUE,2,'￠') BKG_NO" ).append("\n"); 
		query.append(",        BKG_GET_TOKEN_FNC(COLUMN_VALUE,3,'￠') XTER_SNDR_ID" ).append("\n"); 
		query.append(",        BKG_GET_TOKEN_FNC(COLUMN_VALUE,4,'￠') XTER_RQST_NO" ).append("\n"); 
		query.append(",        BKG_GET_TOKEN_FNC(COLUMN_VALUE,5,'￠') XTER_RQST_SEQ" ).append("\n"); 
		query.append(",        BKG_GET_TOKEN_FNC(COLUMN_VALUE,6,'￠') CNTR_NO" ).append("\n"); 
		query.append("FROM	(SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[cntr_list],'|&&|'))) TEMP    " ).append("\n"); 
		query.append("WHERE    BKG_GET_TOKEN_FNC(COLUMN_VALUE,6,'￠') IS NOT NULL" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_type} == 'SUM') " ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT  S.NUM,S.TITLE,CASE WHEN S.NUM = 1 THEN DECODE(S.NUM,1,SUM(DECODE(MASTER_EXIST_FLG,'Y',1,0))) " ).append("\n"); 
		query.append("                            WHEN S.NUM = 2 THEN DECODE(S.NUM,2,SUM(DECODE(ESI_EXIST_FLG,'Y',NVL(PART_LOAD_CNT,1),0))) " ).append("\n"); 
		query.append("                            WHEN S.NUM = 3 THEN DECODE(S.NUM,3,SUM(DECODE(ESI_EXIST_FLG,'Y',1,0))) " ).append("\n"); 
		query.append("                            WHEN S.NUM = 4 THEN SUM(DECODE(ESI_EXIST_FLG,'Y',NVL(PART_LOAD_CNT,0),0))" ).append("\n"); 
		query.append("                            END SUM_COL_VAL" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT  DISTINCT X.CNTR_NO" ).append("\n"); 
		query.append(",       (SELECT NVL(SUM(C.CNTR_VOL_QTY),0) FROM BKG_CONTAINER C WHERE  C.CNTR_NO = X.CNTR_NO  AND C.BKG_NO = (SELECT T.BKG_NO FROM TEMP_T T WHERE T.ORIGIN = '1' )) AS SHARE_VOL" ).append("\n"); 
		query.append(",       CASE WHEN (SELECT DECODE(INSTR(T.CNTR_NO,X.CNTR_NO),0,'N','Y') FROM TEMP_T T WHERE T.ORIGIN = '1') = 'Y' AND" ).append("\n"); 
		query.append("             (SELECT DECODE(COUNT(1),0,'N','Y') FROM TEMP_T T WHERE T.ORIGIN != '1' AND INSTR(T.CNTR_NO,X.CNTR_NO) > 0) = 'Y' THEN 'M' ELSE 'U' END AS   MATCH_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",       (SELECT DECODE(INSTR(T.CNTR_NO,X.CNTR_NO),0,'N','Y') FROM TEMP_T T WHERE T.ORIGIN = '1') AS  MASTER_EXIST_FLG" ).append("\n"); 
		query.append(",       (SELECT DECODE(COUNT(1),0,'N','Y') FROM TEMP_T T WHERE T.ORIGIN != '1' AND INSTR(T.CNTR_NO,X.CNTR_NO) > 0) AS  ESI_EXIST_FLG" ).append("\n"); 
		query.append(",       (SELECT COUNT(1) FROM TEMP_T T WHERE T.ORIGIN = 0 AND INSTR(T.CNTR_NO,X.CNTR_NO) > 0 HAVING COUNT(1) > 1) AS  PART_LOAD_CNT" ).append("\n"); 
		query.append(",        BKG_JOIN_FNC(CURSOR(SELECT XTER_RQST_NO || '-' || T.XTER_RQST_SEQ  FROM TEMP_T T WHERE T.ORIGIN != '1' AND INSTR(T.CNTR_NO,X.CNTR_NO) > 0 GROUP BY T.XTER_RQST_NO || '-' || T.XTER_RQST_SEQ ),',') AS DUP_SI_REF	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (SELECT COLUMN_VALUE AS CNTR_NO FROM TABLE(BKG_SPLIT_FNC(BKG_JOIN_FNC(CURSOR(SELECT C.CNTR_NO  FROM TEMP_T C),','),',')))  X" ).append("\n"); 
		query.append("ORDER BY X.CNTR_NO" ).append("\n"); 
		query.append("#if (${search_type} == 'SUM')" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append(") , (   " ).append("\n"); 
		query.append("SELECT   ROWNUM NUM, COLUMN_VALUE AS TITLE" ).append("\n"); 
		query.append("FROM     TABLE(BKG_SPLIT_FNC('CNTR Total of Master,CNTR Total of Split S/I (excl. Master/Simple),CNTR Total of Split S/I (excl. Master & Dup.),Total of Split S/I with Partial Load.',',') )      " ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("GROUP BY S.NUM,S.TITLE" ).append("\n"); 
		query.append("ORDER BY S.NUM" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}