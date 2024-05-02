/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.03.18 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회시점에 체류하고 있는 컨테이너의 과거 MVMT History를 조회하여, 지역별, EQ TP&SZ로  MVMT Status 를 분류하여 체류   일수를 조회한다.
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_date",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_use_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysRSQL").append("\n"); 
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
		query.append("    A.LVL" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'10','Total','11','',A.LOC_CD) LOC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'01','Total','11','G.Total',A.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.ACT_QTY" ).append("\n"); 
		query.append("    ,A.TOTAL_QTY" ).append("\n"); 
		query.append("    ,A.TOTAL_STAY_DAYS" ).append("\n"); 
		query.append("    ,ROUND(A.TOTAL_STAY_DAYS/A.ACT_QTY,1) TOTAL_AVG" ).append("\n"); 
		query.append("    ,A.QTY1" ).append("\n"); 
		query.append("    ,A.STAY_DAYS1" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS1/DECODE(A.QTY1,0,NULL,A.QTY1),1),0) AVG1" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY1/A.TOTAL_QTY*100,'990.0')||'%' RATE1" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,A.QTY2" ).append("\n"); 
		query.append("    ,A.STAY_DAYS2" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS2/DECODE(A.QTY2,0,NULL,A.QTY2),1),0) AVG2" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY2/A.TOTAL_QTY*100,'990.0')||'%' RATE2" ).append("\n"); 
		query.append("    ,A.QTY3" ).append("\n"); 
		query.append("    ,A.STAY_DAYS3" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS3/DECODE(A.QTY3,0,NULL,A.QTY3),1),0) AVG3" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY3/A.TOTAL_QTY*100,'990.0')||'%' RATE3" ).append("\n"); 
		query.append("    ,A.QTY4" ).append("\n"); 
		query.append("    ,A.STAY_DAYS4" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS4/DECODE(A.QTY4,0,NULL,A.QTY4),1),0) AVG4" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY4/A.TOTAL_QTY*100,'990.0')||'%' RATE4" ).append("\n"); 
		query.append("    ,A.QTY5" ).append("\n"); 
		query.append("    ,A.STAY_DAYS5" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS5/DECODE(A.QTY5,0,NULL,A.QTY5),1),0) AVG5" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY5/A.TOTAL_QTY*100,'990.0')||'%' RATE5" ).append("\n"); 
		query.append("    ,A.QTY6" ).append("\n"); 
		query.append("    ,A.STAY_DAYS6" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS6/DECODE(A.QTY6,0,NULL,A.QTY6),1),0) AVG6" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY6/A.TOTAL_QTY*100,'990.0')||'%' RATE6" ).append("\n"); 
		query.append("    ,A.QTY7" ).append("\n"); 
		query.append("    ,A.STAY_DAYS7" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS7/DECODE(A.QTY7,0,NULL,A.QTY7),1),0) AVG7" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY7/A.TOTAL_QTY*100,'990.0')||'%' RATE7" ).append("\n"); 
		query.append("    ,A.QTY8" ).append("\n"); 
		query.append("    ,A.STAY_DAYS8" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS8/DECODE(A.QTY8,0,NULL,A.QTY8),1),0) AVG8" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY8/A.TOTAL_QTY*100,'990.0')||'%' RATE8" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY9" ).append("\n"); 
		query.append("    ,A.STAY_DAYS9" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS9/DECODE(A.QTY9,0,NULL,A.QTY9),1),0) AVG9" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY9/A.TOTAL_QTY*100,'990.0')||'%' RATE9" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY10" ).append("\n"); 
		query.append("    ,A.STAY_DAYS10" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS10/DECODE(A.QTY10,0,NULL,A.QTY10),1),0) AVG10" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY10/A.TOTAL_QTY*100,'990.0')||'%' RATE10" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY11" ).append("\n"); 
		query.append("    ,A.STAY_DAYS11" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS11/DECODE(A.QTY11,0,NULL,A.QTY11),1),0) AVG11" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY11/A.TOTAL_QTY*100,'990.0')||'%' RATE11" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,A.QTY12" ).append("\n"); 
		query.append("    ,A.STAY_DAYS12" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS12/DECODE(A.QTY12,0,NULL,A.QTY12),1),0) AVG12" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY12/A.TOTAL_QTY*100,'990.0')||'%' RATE12    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY13" ).append("\n"); 
		query.append("    ,A.STAY_DAYS13" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS13/DECODE(A.QTY13,0,NULL,A.QTY13),1),0) AVG13" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY13/A.TOTAL_QTY*100,'990.0')||'%' RATE13" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY14" ).append("\n"); 
		query.append("    ,A.STAY_DAYS14" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS14/DECODE(A.QTY14,0,NULL,A.QTY14),1),0) AVG14" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY14/A.TOTAL_QTY*100,'990.0')||'%' RATE14" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.QTY15" ).append("\n"); 
		query.append("    ,A.STAY_DAYS15" ).append("\n"); 
		query.append("    ,NVL(ROUND(A.STAY_DAYS15/DECODE(A.QTY15,0,NULL,A.QTY15),1),0) AVG15" ).append("\n"); 
		query.append("    ,TO_CHAR(A.QTY15/A.TOTAL_QTY*100,'990.0')||'%' RATE15" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         GROUPING(A.LOC_CD)||GROUPING(A.CNTR_TPSZ_CD) LVL" ).append("\n"); 
		query.append("        ,A.LOC_CD" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,NVL(SUM(TOTAL_STAY_DAYS),0) TOTAL_STAY_DAYS" ).append("\n"); 
		query.append("        ,COUNT(A.ACT_QTY) ACT_QTY" ).append("\n"); 
		query.append("        ,SUM(A.TOTAL_QTY) TOTAL_QTY" ).append("\n"); 
		query.append("        ,SUM(TOTAL_STAY_DAYS)/COUNT(A.ACT_QTY)  TOTAL_AVG" ).append("\n"); 
		query.append("        ,SUM(QTY1) QTY1" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS1) STAY_DAYS1" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY2) QTY2" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS2) STAY_DAYS2" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY3) QTY3" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS3) STAY_DAYS3" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY4) QTY4" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS4) STAY_DAYS4" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY5) QTY5" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS5) STAY_DAYS5" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY6) QTY6" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS6) STAY_DAYS6" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY7) QTY7" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS7) STAY_DAYS7" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY8) QTY8" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS8) STAY_DAYS8" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,SUM(QTY9) QTY9" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS9) STAY_DAYS9" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY10) QTY10" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS10) STAY_DAYS10" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY11) QTY11" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS11) STAY_DAYS11" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY12) QTY12" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS12) STAY_DAYS12" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY13) QTY13" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS13) STAY_DAYS13" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY14) QTY14" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS14) STAY_DAYS14" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,SUM(QTY15) QTY15" ).append("\n"); 
		query.append("        ,SUM(STAY_DAYS15) STAY_DAYS15" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("             MAX(A.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("            ,MAX(A.LOC_CD) LOC_CD" ).append("\n"); 
		query.append("            ,MAX(A.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,NVL(SUM(STAY_DAYS),0) TOTAL_STAY_DAYS" ).append("\n"); 
		query.append("            ,COUNT(DISTINCT A.CNTR_NO) ACT_QTY" ).append("\n"); 
		query.append("            ,COUNT(A.CNTR_NO) TOTAL_QTY" ).append("\n"); 
		query.append("            ,SUM(STAY_DAYS)/COUNT(DISTINCT A.CNTR_NO) TOTAL_AVG" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'IC',1,0)) QTY1" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'IC',STAY_DAYS,0)) STAY_DAYS1" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'ID',1,0)) QTY2" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'ID',STAY_DAYS,0)) STAY_DAYS2" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'MT',1,0)) QTY3" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'MT',STAY_DAYS,0)) STAY_DAYS3" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'OP',1,0)) QTY4" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'OP',STAY_DAYS,0)) STAY_DAYS4" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'OC',1,0)) QTY5" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'OC',STAY_DAYS,0)) STAY_DAYS5" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'TN',1,0)) QTY6" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'TN',STAY_DAYS,0)) STAY_DAYS6" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'EN',1,0)) QTY7" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'EN',STAY_DAYS,0)) STAY_DAYS7" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'TS',1,0)) QTY8" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'TS',STAY_DAYS,0)) STAY_DAYS8" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CI',1,0)) QTY9" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CI',STAY_DAYS,0)) STAY_DAYS9" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CD',1,0)) QTY10" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CD',STAY_DAYS,0)) STAY_DAYS10" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CM',1,0)) QTY11" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CM',STAY_DAYS,0)) STAY_DAYS11" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CP',1,0)) QTY12" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CP',STAY_DAYS,0)) STAY_DAYS12" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CO',1,0)) QTY13" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CO',STAY_DAYS,0)) STAY_DAYS13" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CT',1,0)) QTY14" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CT',STAY_DAYS,0)) STAY_DAYS14" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CE',1,0)) QTY15" ).append("\n"); 
		query.append("            ,SUM(DECODE(A.MVMT_STS_CD,'CE',STAY_DAYS,0)) STAY_DAYS15" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                 A.LOC_CD" ).append("\n"); 
		query.append("                ,A.CNTR_NO" ).append("\n"); 
		query.append("                ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,B.MVMT_STS_CD" ).append("\n"); 
		query.append("                ,B.ORG_YD_CD" ).append("\n"); 
		query.append("                ,CEIL(NVL(LEAD(B.CNMV_EVNT_DT,1) OVER(PARTITION BY B.CNTR_NO,B.CNMV_CYC_NO ORDER BY B.CNMV_YR,B.CNMV_SEQ,B.CNMV_SPLIT_NO),TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS')) - B.CNMV_EVNT_DT) STAY_DAYS" ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                	A.LOC_CD" ).append("\n"); 
		query.append("                    ,A.CNTR_NO" ).append("\n"); 
		query.append("                    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    ,A.CNMV_CYC_NO" ).append("\n"); 
		query.append("                    ,A.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("    	                 DECODE(@[loc_type_code],'2',A.ECC_CD,'3',A.SCC_CD,'4',A.SCC_CD,A.CRNT_YD_CD) LOC_CD " ).append("\n"); 
		query.append("    	                ,A.CNTR_NO" ).append("\n"); 
		query.append("    	                ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    	                ,A.CNMV_CYC_NO" ).append("\n"); 
		query.append("		                ,(SELECT /*+ INDEX_DESC(B XAK11CTM_MOVEMENT) */" ).append("\n"); 
		query.append("		                         MIN(CNMV_EVNT_DT) B" ).append("\n"); 
		query.append("		                  FROM  CTM_MOVEMENT B " ).append("\n"); 
		query.append("		                  		#if (${loc_type_code} == '5')	--SCC" ).append("\n"); 
		query.append("		                  			,MDM_LOCATION C" ).append("\n"); 
		query.append("		                  		#elseif( ${loc_type_code} == '2' || ${loc_type_code} == '3'  || ${loc_type_code} == '4' )	--LCC,ECC" ).append("\n"); 
		query.append("			                  	   ,MDM_LOCATION C" ).append("\n"); 
		query.append("			                  	   ,MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("		                  		#end" ).append("\n"); 
		query.append("		                  WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("		                  AND   A.CNMV_CYC_NO  = B.CNMV_CYC_NO" ).append("\n"); 
		query.append("		                  AND   B.MVMT_STS_CD IN ('CM','CP','CI','CO','CD','CT','CE',  'IC', 'ID', 'MT', 'OP', 'OC', 'TN', 'EN', 'TS')" ).append("\n"); 
		query.append("		                  #if (${loc_type_code} == '5')	  --ECC" ).append("\n"); 
		query.append("		                  	  AND C.LOC_CD = SUBSTR(B.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("		                  #elseif( ${loc_type_code} == '2' || ${loc_type_code} == '3'  || ${loc_type_code} == '4' )" ).append("\n"); 
		query.append("	                          AND C.LOC_CD = SUBSTR(B.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("	                          AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("		                  #end" ).append("\n"); 
		query.append("		                  " ).append("\n"); 
		query.append("				          #if (${loc_type_code} == '2')" ).append("\n"); 
		query.append("					      	  AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("				          #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("						      AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("				          #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("						      AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("				          #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("						      AND C.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("				          #elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("					      	  AND B.ORG_YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("				          #end " ).append("\n"); 
		query.append("		                  " ).append("\n"); 
		query.append("		                ) CNMV_EVNT_DT" ).append("\n"); 
		query.append("                    FROM  MST_CONTAINER A" ).append("\n"); 
		query.append("                    WHERE A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("                    AND   A.CNMV_STS_CD IN ( 'CD','CE','CI','CM','CO','CP','CT','CX', 'EN','IC','ID','MT','OC','OP','TN','TS','VD')" ).append("\n"); 
		query.append("			        #if (${loc_type_code} == '2')" ).append("\n"); 
		query.append("			        	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("			        #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("			        	AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("			        #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("			            AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("			        #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("			            AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("			        #elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("			            AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("			        #end     " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			        #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("			        	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("			        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("			            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("			                	             FROM dual )" ).append("\n"); 
		query.append("			        				        )" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("			        #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("			        	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("			        #end  " ).append("\n"); 
		query.append("			        #if (${cntr_use_co_cd} != '')" ).append("\n"); 
		query.append("			        	AND A.CNTR_USE_CO_CD = @[cntr_use_co_cd]" ).append("\n"); 
		query.append("			        #end  " ).append("\n"); 
		query.append("			    	#if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("			        	AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("					#elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("			        	AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			        #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("			        	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("			        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("			            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("			                	             FROM dual )" ).append("\n"); 
		query.append("			        				        )" ).append("\n"); 
		query.append("			        #end " ).append("\n"); 
		query.append("			        #if (${soc_cd} != '')" ).append("\n"); 
		query.append("			        	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("			        		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("			        	#else" ).append("\n"); 
		query.append("			        		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("			        	#end" ).append("\n"); 
		query.append("			        #end	     " ).append("\n"); 
		query.append("			        " ).append("\n"); 
		query.append("			        #if (${full_flg} != '')" ).append("\n"); 
		query.append("						AND A.FULL_FLG=@[full_flg]" ).append("\n"); 
		query.append("			        #end        " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			        #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("			        	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("			        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("			            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("			                	             FROM dual )" ).append("\n"); 
		query.append("			        				        )" ).append("\n"); 
		query.append("			        #end  " ).append("\n"); 
		query.append("    		    ) A" ).append("\n"); 
		query.append("                WHERE  CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - CNMV_EVNT_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("            ) A,CTM_MOVEMENT B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("            AND A.CNMV_CYC_NO = B.CNMV_CYC_NO " ).append("\n"); 
		query.append("        ) A " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("		AND   @[loc_cd]  =  #if (${loc_type_code} == '2')" ).append("\n"); 
		query.append("		                        (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT X, MDM_LOCATION Y" ).append("\n"); 
		query.append("		                          WHERE Y.LOC_CD = SUBSTR(A.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("		                          AND   Y.SCC_CD = X.SCC_CD)" ).append("\n"); 
		query.append("		                    #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("		                    	(SELECT LCC_CD FROM MDM_EQ_ORZ_CHT X, MDM_LOCATION Y " ).append("\n"); 
		query.append("		     	                 WHERE Y.LOC_CD = SUBSTR(A.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("		    	                 AND   Y.SCC_CD = X.SCC_CD)" ).append("\n"); 
		query.append("		                    #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("		                    	(SELECT ECC_CD FROM MDM_EQ_ORZ_CHT X, MDM_LOCATION Y " ).append("\n"); 
		query.append("		    	                 WHERE Y.LOC_CD = SUBSTR(A.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("		    	                 AND   Y.SCC_CD = X.SCC_CD)" ).append("\n"); 
		query.append("		                    #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("		                    	(SELECT SCC_CD FROM MDM_LOCATION Y " ).append("\n"); 
		query.append("		    	                 WHERE Y.LOC_CD = SUBSTR(A.ORG_YD_CD, 1, 5))        	                " ).append("\n"); 
		query.append("		                    #elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("		             			A.ORG_YD_CD" ).append("\n"); 
		query.append("		                    #end 		                             " ).append("\n"); 
		query.append("        AND   A.MVMT_STS_CD IN ('CM','CP','CI','CO','CD','CT','CE',   'IC', 'ID', 'MT', 'OP', 'OC', 'TN', 'EN', 'TS')" ).append("\n"); 
		query.append("        GROUP BY A.CNTR_NO" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    GROUP BY CUBE(A.LOC_CD,A.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    ORDER BY RANK() OVER (ORDER BY A.LOC_CD)" ).append("\n"); 
		query.append(")A, MDM_CNTR_TP_SZ B" ).append("\n"); 
		query.append("WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.LOC_CD,B.RPT_DP_SEQ" ).append("\n"); 

	}
}