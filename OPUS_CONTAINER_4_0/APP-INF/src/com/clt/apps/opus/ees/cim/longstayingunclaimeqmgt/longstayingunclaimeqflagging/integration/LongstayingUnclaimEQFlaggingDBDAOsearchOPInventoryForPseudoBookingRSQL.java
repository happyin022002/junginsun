/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OP Inventory for Pseudo Booking
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stay_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingRSQL").append("\n"); 
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
		query.append("	   A.LVL " ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'111110','',A.AR_HD_QTR_OFC_CD) RHQ_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'111110','',A.BKG_OFC_CD) BKG_OFC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'000111','','111110','',A.OB_SREP_CD) OB_SREP_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'000111','','111110','',A.CUST_CD) CUST_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'000111','Total','111110','Total',A.CUST_NM) CUST_NM" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'000111','', A.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.TOTAL_QTY" ).append("\n"); 
		query.append("    ,ROUND(A.TOTAL_STAY_DAYS/A.TOTAL_QTY,1) TOTAL_AVG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.OVER_QTY" ).append("\n"); 
		query.append("    ,A.OVER_AVG" ).append("\n"); 
		query.append("	  ,A.OVER_STAY_DAYS" ).append("\n"); 
		query.append("  	,TO_CHAR(A.OVER_QTY/A.TOTAL_QTY*100,'990.0')||'%' OVER_RATE    " ).append("\n"); 
		query.append("    ,A.QTY1" ).append("\n"); 
		query.append("    ,A.AVG1" ).append("\n"); 
		query.append("    ,A.STAY_DAYS1" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY1/A.TOTAL_QTY*100,'990.0')||'%' RATE1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY2" ).append("\n"); 
		query.append("    ,A.AVG2" ).append("\n"); 
		query.append("    ,A.STAY_DAYS2" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY2/A.TOTAL_QTY*100,'990.0')||'%' RATE2" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,A.QTY3" ).append("\n"); 
		query.append("    ,A.AVG3" ).append("\n"); 
		query.append("    ,A.STAY_DAYS3" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY3/A.TOTAL_QTY*100,'990.0')||'%' RATE3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY4" ).append("\n"); 
		query.append("    ,A.AVG4" ).append("\n"); 
		query.append("    ,A.STAY_DAYS4" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY4/A.TOTAL_QTY*100,'990.0')||'%' RATE4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY5" ).append("\n"); 
		query.append("    ,A.AVG5" ).append("\n"); 
		query.append("    ,A.STAY_DAYS5" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY5/A.TOTAL_QTY*100,'990.0')||'%' RATE5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY6" ).append("\n"); 
		query.append("    ,A.AVG6" ).append("\n"); 
		query.append("    ,A.STAY_DAYS6" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY6/A.TOTAL_QTY*100,'990.0')||'%' RATE6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	,A.QTY7" ).append("\n"); 
		query.append("	  ,A.AVG7" ).append("\n"); 
		query.append("	  ,A.STAY_DAYS7" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY7/A.TOTAL_QTY*100,'990.0')||'%' RATE7" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("		    A.LVL" ).append("\n"); 
		query.append("		    ,A.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("        ,A.BKG_OFC_CD" ).append("\n"); 
		query.append("        ,A.OB_SREP_CD" ).append("\n"); 
		query.append("        ,A.CUST_CD" ).append("\n"); 
		query.append("        ,A.CUST_NM " ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,DECODE(A.QTY1+A.QTY2+A.QTY3+A.QTY4+A.QTY5+A.QTY6+A.QTY7,0,NULL,A.QTY1+A.QTY2+A.QTY3+A.QTY4+A.QTY5+A.QTY6+A.QTY7) TOTAL_QTY" ).append("\n"); 
		query.append("        ,A.STAY_DAYS1+A.STAY_DAYS2+A.STAY_DAYS3+A.STAY_DAYS4+A.STAY_DAYS5+A.STAY_DAYS6+A.STAY_DAYS7 TOTAL_STAY_DAYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		    ,A.OVER_STAY_DAYS" ).append("\n"); 
		query.append("        ,NVL(A.OVER_QTY,0) OVER_QTY" ).append("\n"); 
		query.append("        ,NVL(ROUND(A.OVER_STAY_DAYS/DECODE(A.OVER_QTY,0,NULL,A.OVER_QTY),1),0) OVER_AVG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.QTY1" ).append("\n"); 
		query.append("        ,A.STAY_DAYS1" ).append("\n"); 
		query.append("        ,NVL(ROUND(A.STAY_DAYS1/DECODE(A.QTY1,0,NULL,A.QTY1),1),0) AVG1" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,A.QTY2" ).append("\n"); 
		query.append("        ,A.STAY_DAYS2" ).append("\n"); 
		query.append("        ,NVL(ROUND(A.STAY_DAYS2/DECODE(A.QTY2,0,NULL,A.QTY2),1),0) AVG2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.QTY3" ).append("\n"); 
		query.append("        ,A.STAY_DAYS3" ).append("\n"); 
		query.append("        ,NVL(ROUND(A.STAY_DAYS3/DECODE(A.QTY3,0,NULL,A.QTY3),1),0) AVG3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.QTY4" ).append("\n"); 
		query.append("        ,A.STAY_DAYS4" ).append("\n"); 
		query.append("        ,NVL(ROUND(A.STAY_DAYS4/DECODE(A.QTY4,0,NULL,A.QTY4),1),0) AVG4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.QTY5" ).append("\n"); 
		query.append("        ,A.STAY_DAYS5" ).append("\n"); 
		query.append("        ,NVL(ROUND(A.STAY_DAYS5/DECODE(A.QTY5,0,NULL,A.QTY5),1),0) AVG5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.QTY6" ).append("\n"); 
		query.append("        ,A.STAY_DAYS6" ).append("\n"); 
		query.append("        ,NVL(ROUND(A.STAY_DAYS6/DECODE(A.QTY6,0,NULL,A.QTY6),1),0) AVG6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		    ,A.QTY7" ).append("\n"); 
		query.append("		    ,A.STAY_DAYS7" ).append("\n"); 
		query.append("		    ,NVL(ROUND(A.STAY_DAYS7/DECODE(A.QTY7,0,NULL,A.QTY7),1),0) AVG7" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("	(	  	" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("				      GROUPING(A.AR_HD_QTR_OFC_CD)||GROUPING(A.BKG_OFC_CD)||GROUPING(A.OB_SREP_CD)||GROUPING(A.CUST_CD)||GROUPING(A.CUST_NM)||GROUPING(A.CNTR_TPSZ_CD) LVL" ).append("\n"); 
		query.append("			        , A.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("              ,A.BKG_OFC_CD" ).append("\n"); 
		query.append("              ,A.OB_SREP_CD" ).append("\n"); 
		query.append("              ,A.CUST_CD" ).append("\n"); 
		query.append("              ,A.CUST_NM     " ).append("\n"); 
		query.append("	            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS >= NVL(@[stay_days],0) THEN STAY_DAYS END),1),0) OVER_STAY_DAYS" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS >= NVL(@[stay_days],0) THEN 1 END),0) OVER_QTY" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS BETWEEN 0 AND 15 THEN STAY_DAYS END),1),0) STAY_DAYS1" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS BETWEEN 0 AND 15 THEN 1 END),0) QTY1" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS BETWEEN 16 AND 30 THEN STAY_DAYS END),1),0) STAY_DAYS2" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS BETWEEN 16 AND 30 THEN 1 END),0) QTY2" ).append("\n"); 
		query.append("	        " ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS BETWEEN 31 AND 60 THEN STAY_DAYS END),1),0) STAY_DAYS3" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS BETWEEN 31 AND 60 THEN 1 END),0) QTY3" ).append("\n"); 
		query.append("	        " ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS BETWEEN 61 AND 120 THEN STAY_DAYS END),1),0) STAY_DAYS4" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS BETWEEN 61 AND 120 THEN 1 END),0) QTY4" ).append("\n"); 
		query.append("	        " ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS BETWEEN 121 AND 180 THEN STAY_DAYS END),1),0) STAY_DAYS5" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS BETWEEN 121 AND 180 THEN 1 END),0) QTY5" ).append("\n"); 
		query.append("	        " ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS BETWEEN 181 AND 365 THEN STAY_DAYS END),1),0) STAY_DAYS6" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS BETWEEN 181 AND 365 THEN 1 END),0) QTY6" ).append("\n"); 
		query.append("	        " ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS >366 THEN STAY_DAYS END),1),0) STAY_DAYS7" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS >366 THEN 1 END),0) QTY7" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("  	     SELECT   O.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("                  ,B.OB_SREP_CD" ).append("\n"); 
		query.append("                  ,C.CUST_CNT_CD||LPAD(C.CUST_SEQ,6,0) CUST_CD" ).append("\n"); 
		query.append("                  ,T.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("                  ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      				    ,(SELECT RPT_DP_SEQ" ).append("\n"); 
		query.append("      	            FROM MDM_CNTR_TP_SZ E" ).append("\n"); 
		query.append("      	            WHERE A.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD) RPT_DP_SEQ    " ).append("\n"); 
		query.append("				  ,CEIL(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD) - A.CNMV_DT) STAY_DAYS" ).append("\n"); 
		query.append("     	    FROM MST_CONTAINER A, BKG_BOOKING B, MDM_ORGANIZATION O, BKG_CUSTOMER C, MDM_CUSTOMER T " ).append("\n"); 
		query.append("    			WHERE A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("            AND A.BKG_NO  =  B.BKG_NO" ).append("\n"); 
		query.append("            AND B.VSL_CD LIKE '%XX'" ).append("\n"); 
		query.append("            AND A.CNMV_STS_CD = 'OP'" ).append("\n"); 
		query.append("            AND B.BKG_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("            AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("            AND T.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND T.CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("      #if (${rhq_cd} != '')" ).append("\n"); 
		query.append("      		AND O.AR_HD_QTR_OFC_CD   = @[rhq_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("      		AND B.BKG_OFC_CD         = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${bkg_no} != '')" ).append("\n"); 
		query.append("      		AND A.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${cust_cd} != '')" ).append("\n"); 
		query.append("      		AND C.CUST_CNT_CD        = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("      		AND LPAD(C.CUST_SEQ,6,0) = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${cust_nm} != '')" ).append("\n"); 
		query.append("      		AND T.CUST_LGL_ENG_NM    LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${op_loc_cd} != '')" ).append("\n"); 
		query.append("      		AND A.LOC_CD             = @[op_loc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ) A" ).append("\n"); 
		query.append("		GROUP BY CUBE(A.AR_HD_QTR_OFC_CD, A.BKG_OFC_CD, A.OB_SREP_CD, A.CUST_CD, A.CUST_NM, A.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    ORDER BY RANK() OVER (ORDER BY A.AR_HD_QTR_OFC_CD, A.BKG_OFC_CD, A.OB_SREP_CD, A.CUST_CD)--, A.RPT_DP_SEQ" ).append("\n"); 
		query.append("	     " ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("  WHERE A.LVL IN ('000000', '000111', '111110', '111111' )" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}