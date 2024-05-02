/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListSmryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
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

public class LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListSmryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장기체화 및 Unclaim 장비 Flagging
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListSmryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListSmryRSQL").append("\n"); 
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
		query.append("	 A.LVL" ).append("\n"); 
		query.append("	,DECODE(A.LVL,'10','Total','11','',A.LOC_CD) LOC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'01','Total','11','G.Total',A.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.TOTAL_QTY" ).append("\n"); 
		query.append("    ,ROUND(A.TOTAL_STAY_DAYS/A.TOTAL_QTY,1) TOTAL_AVG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.OVER_QTY" ).append("\n"); 
		query.append("    ,A.OVER_AVG" ).append("\n"); 
		query.append("	,A.OVER_STAY_DAYS" ).append("\n"); 
		query.append("	,TO_CHAR(A.OVER_QTY/A.TOTAL_QTY*100,'990.0')||'%' OVER_RATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
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
		query.append("	,A.QTY7" ).append("\n"); 
		query.append("	,A.AVG7" ).append("\n"); 
		query.append("	,A.STAY_DAYS7" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY7/A.TOTAL_QTY*100,'990.0')||'%' RATE7" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("		 A.LVL" ).append("\n"); 
		query.append("		,A.LOC_CD" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,DECODE(A.QTY1+A.QTY2+A.QTY3+A.QTY4+A.QTY5+A.QTY6+A.QTY7,0,NULL,A.QTY1+A.QTY2+A.QTY3+A.QTY4+A.QTY5+A.QTY6+A.QTY7) TOTAL_QTY" ).append("\n"); 
		query.append("        ,A.STAY_DAYS1+A.STAY_DAYS2+A.STAY_DAYS3+A.STAY_DAYS4+A.STAY_DAYS5+A.STAY_DAYS6+A.STAY_DAYS7 TOTAL_STAY_DAYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,A.OVER_STAY_DAYS" ).append("\n"); 
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
		query.append("		,A.QTY7" ).append("\n"); 
		query.append("		,A.STAY_DAYS7" ).append("\n"); 
		query.append("		,NVL(ROUND(A.STAY_DAYS7/DECODE(A.QTY7,0,NULL,A.QTY7),1),0) AVG7" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("				 GROUPING(A.LOC_CD)||GROUPING(A.CNTR_TPSZ_CD) LVL" ).append("\n"); 
		query.append("			    ,A.LOC_CD       " ).append("\n"); 
		query.append("	            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	            ,NVL(ROUND(SUM(CASE WHEN STAY_DAYS >= NVL(@[over_stay_days],0) THEN STAY_DAYS END),1),0) OVER_STAY_DAYS" ).append("\n"); 
		query.append("	            ,NVL(SUM(CASE WHEN STAY_DAYS >= NVL(@[over_stay_days],0) THEN 1 END),0) OVER_QTY" ).append("\n"); 
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
		query.append("	    FROM(" ).append("\n"); 
		query.append("	        SELECT " ).append("\n"); 
		query.append("				   DECODE(@[loc_type_code],'',A.RCC_CD,'1',A.LCC_CD,'2',A.ECC_CD,'3',A.SCC_CD,'4',A.SCC_CD,A.CRNT_YD_CD) LOC_CD     " ).append("\n"); 
		query.append("				  ,@[loc_type_code] LOC_TYPE_CODE" ).append("\n"); 
		query.append("	              ,(SELECT RPT_DP_SEQ" ).append("\n"); 
		query.append("	                 FROM MDM_CNTR_TP_SZ E" ).append("\n"); 
		query.append("	                WHERE A.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD) RPT_DP_SEQ    " ).append("\n"); 
		query.append("	              ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				  ,(SELECT CEIL(B.RCC_DATE - A.CNMV_DT) " ).append("\n"); 
		query.append("				    FROM " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						${query_str}" ).append("\n"); 
		query.append("					) B" ).append("\n"); 
		query.append("					WHERE A.RCC_CD=B.RCC_CD) STAY_DAYS" ).append("\n"); 
		query.append("	        FROM MST_CONTAINER A" ).append("\n"); 
		query.append("			WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("			AND   A.CNMV_STS_CD BETWEEN 'CA' AND 'VD'" ).append("\n"); 
		query.append("	        #if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("	        	AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	        #elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("	        	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	        #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("	        	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	        #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("	            AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	        #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("	            AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	        #elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("	            AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("	        #end     " ).append("\n"); 
		query.append("	        #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("	        	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("	        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	                	             FROM dual )" ).append("\n"); 
		query.append("	        				        )" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	        #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("	        	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("	        #end  	         " ).append("\n"); 
		query.append("	        #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("	        	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("	        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	                	             FROM dual )" ).append("\n"); 
		query.append("	        				        )" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	    	#if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("	        	AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("			#elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("	        	AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	        #if (${full_flg} != '')" ).append("\n"); 
		query.append("	        	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("	        #end        " ).append("\n"); 
		query.append("	        #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("	        	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("	        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	                	             FROM dual )" ).append("\n"); 
		query.append("	        				        )" ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	        #if (${soc_cd} != '')" ).append("\n"); 
		query.append("	        	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("	        		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("	        	#else" ).append("\n"); 
		query.append("	        		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("	        	#end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	    ) A" ).append("\n"); 
		query.append("		GROUP BY CUBE(A.LOC_CD,A.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("	    ORDER BY RANK() OVER (ORDER BY A.LOC_CD),RPT_DP_SEQ " ).append("\n"); 
		query.append("	     " ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append(") A " ).append("\n"); 
		query.append("WHERE LVL||NVL(LOC_CD, 'NONE') NOT IN ( '00NONE', '01NONE') " ).append("\n"); 

	}
}