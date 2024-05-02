/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOSearchEqAverageUsingDayDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.06.13 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOSearchEqAverageUsingDayDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEqAverageUsingDayData
	  * 2010.10.25 남궁진호 [CHM-201006645-01] Container Average Using Days 조회시 ST Term 추가  
	  * 
	  * 2011.06.13 나상보 [CHM-201111466-01] [MST] MDM에 R9 등록에 따른 추가 업무 진행 요청
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOSearchEqAverageUsingDayDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("report_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd26",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd25",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd24",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("man_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd23",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd29",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd28",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd27",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd5",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd30",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd18",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOSearchEqAverageUsingDayDataRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[eq_knd_cd]        EQ_KND_CD" ).append("\n"); 
		query.append("   ,@[report_type]      REPORT_TYPE" ).append("\n"); 
		query.append("   ,@[lstm_cd]          LSTM_CD   " ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd]     CNTR_TPSZ_CD " ).append("\n"); 
		query.append("   ,@[vndr_abbr_nm]     VNDR_ABBR_NM" ).append("\n"); 
		query.append("   ,@[man_year]         MAN_YEAR" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd1]    CNTR_TPSZ_CD1" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd2]    CNTR_TPSZ_CD2" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd3]    CNTR_TPSZ_CD3" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd4]    CNTR_TPSZ_CD4" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd5]    CNTR_TPSZ_CD5" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd6]    CNTR_TPSZ_CD6" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd7]    CNTR_TPSZ_CD7" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd8]    CNTR_TPSZ_CD8" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd9]    CNTR_TPSZ_CD9" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd10]   CNTR_TPSZ_CD10" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd11]   CNTR_TPSZ_CD11" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd12]   CNTR_TPSZ_CD12" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd13]   CNTR_TPSZ_CD13" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd14]   CNTR_TPSZ_CD14" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd15]   CNTR_TPSZ_CD15" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd16]   CNTR_TPSZ_CD16" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd17]   CNTR_TPSZ_CD17" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd18]   CNTR_TPSZ_CD18" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd19]   CNTR_TPSZ_CD19" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd20]   CNTR_TPSZ_CD20" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd21]   CNTR_TPSZ_CD21" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd22]   CNTR_TPSZ_CD22" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd23]   CNTR_TPSZ_CD23" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd24]   CNTR_TPSZ_CD24" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd25]   CNTR_TPSZ_CD25" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd26]   CNTR_TPSZ_CD26" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd27]   CNTR_TPSZ_CD27" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd28]   CNTR_TPSZ_CD28" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd29]   CNTR_TPSZ_CD29" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd30]   CNTR_TPSZ_CD30" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("), LV_EQ_USING_DAY3 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT GRP_ID," ).append("\n"); 
		query.append("        LSTM_CD,MAN_YEAR,MAN," ).append("\n"); 
		query.append("        (SELECT V.VNDR_ABBR_NM" ).append("\n"); 
		query.append("         FROM   MDM_VENDOR V" ).append("\n"); 
		query.append("         WHERE  MAN = V.VNDR_SEQ) MAN_NM," ).append("\n"); 
		query.append("         SEQ, DIV," ).append("\n"); 
		query.append("        (QTY1+QTY2+QTY3+QTY4+QTY5+QTY6+QTY7+QTY8+QTY9+QTY10+QTY11+QTY12+QTY13+QTY14+QTY15+QTY16+QTY17+QTY18+QTY19+QTY20+QTY21+QTY22+QTY23+QTY24+QTY25+QTY26+QTY27+QTY28+QTY29+QTY30) QTY0," ).append("\n"); 
		query.append("        QTY1,QTY2,QTY3,QTY4,QTY5,QTY6,QTY7,QTY8,QTY9,QTY10,QTY11,QTY12,QTY13,QTY14,QTY15,QTY16,QTY17,QTY18,QTY19,QTY20,QTY21,QTY22,QTY23,QTY24,QTY25,QTY26,QTY27,QTY28,QTY29,QTY30" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("       GROUPING(A.LSTM_CD) GRP_ID," ).append("\n"); 
		query.append("        A.LSTM_CD, A.MAN_YEAR, A.MAN," ).append("\n"); 
		query.append("        B.SEQ," ).append("\n"); 
		query.append("        DECODE(B.SEQ, 1, 'Volume', 2, 'Average', 3, '') DIV," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD1  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD1  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD1  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY1," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD2  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD2  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD2  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY2," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD3  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD3  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD3  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY3," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD4  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD4  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD4  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY4," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD5  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD5  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD5  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY5," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD6  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD6  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD6  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY6," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD7  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD7  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD7  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY7," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD8  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD8  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD8  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY8," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD9  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD9  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD9  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY9," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD10  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD10  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD10  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY10," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD11  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD11  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD11  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY11," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD12  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD12  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD12  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY12," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD13  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD13  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD13  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY13," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD14  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD14  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD14  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY14," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD15  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD15  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD15  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY15," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD16  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD16  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD16  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY16," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD17  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD17  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD17  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY17," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD18  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD18  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD18  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY18," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD19  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD19  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD19  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY19," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD20  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD20  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD20  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY20," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD21  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD21  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD21  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY21," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD22  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD22  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD22  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY22," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD23  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD23  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD23  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY23," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD24  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD24  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD24  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY24," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD25  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD25  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD25  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY25," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD26  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD26  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD26  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY26," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD27  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD27  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD27  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY27," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD28  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD28  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD28  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY28," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD29  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD29  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD29  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY29," ).append("\n"); 
		query.append("        CASE WHEN  B.SEQ=1" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD30  ,QTY,0)),0)" ).append("\n"); 
		query.append("        ELSE  (CASE WHEN  B.SEQ=2" ).append("\n"); 
		query.append("        THEN  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD30  ,ROUND(USING_DAY/QTY),0)) ,0)" ).append("\n"); 
		query.append("        ELSE  NVL(SUM(DECODE(A.CNTR_TPSZ_CD,P.CNTR_TPSZ_CD30  ,USING_DAY,0)) ,0)" ).append("\n"); 
		query.append("        END)" ).append("\n"); 
		query.append("        END QTY30" ).append("\n"); 
		query.append("    FROM    PARAM P, " ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("#if (${eq_knd_cd} == 'U')            " ).append("\n"); 
		query.append("          SELECT  A.LSTM_CD,TO_CHAR(DECODE(A.LSTM_CD, 'LT', A.ONH_DT,'ST', A.ONH_DT, A.MFT_DT),'YYYY') MAN_YEAR, NVL(A.MFTR_VNDR_SEQ,0) MAN," ).append("\n"); 
		query.append("                  A.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                  COUNT(A.CNTR_TPSZ_CD) QTY," ).append("\n"); 
		query.append("                  SUM(DECODE(INSTR('LSO,SLD,TLL,DON,SCR,DIO,SRO',A.CNTR_STS_CD),0,TRUNC(SYSDATE),TRUNC(A.CNMV_DT))  - TRUNC(DECODE(A.LSTM_CD, 'LT', A.ONH_DT, 'ST', A.ONH_DT, A.MFT_DT))+1) USING_DAY" ).append("\n"); 
		query.append("          FROM  MST_CONTAINER A" ).append("\n"); 
		query.append("          WHERE 1 = 1" ).append("\n"); 
		query.append("          #if (${report_type} == 'O')" ).append("\n"); 
		query.append("          AND  (A.ACIAC_DIV_CD = 'A' OR A.CNTR_STS_CD IN('SBO','MUO')) " ).append("\n"); 
		query.append("          #elseif (${report_type} == 'X')" ).append("\n"); 
		query.append("          AND  A.CNTR_STS_CD IN('LSO','SLD','TLL','DON','SCR','DIO','SRO') " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${lstm_cd} != '' && ${lstm_cd} != 'ALL')" ).append("\n"); 
		query.append("          AND   A.LSTM_CD  IN ( " ).append("\n"); 
		query.append("          #foreach($cd in ${vel_lstm_cd})  " ).append("\n"); 
		query.append("             '$cd',  " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("          '')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${lstm_cd} == 'ALL' || ${lstm_cd} == '')" ).append("\n"); 
		query.append("          AND   A.LSTM_CD  IN ('OW','LP','OL','LT','ST')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("          AND   A.CNTR_TPSZ_CD  IN ( " ).append("\n"); 
		query.append("          #foreach($cd in ${vel_cntr_tpsz_cd})  " ).append("\n"); 
		query.append("            '$cd',  " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("          '') " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${vndr_abbr_nm} != '' && ${vndr_abbr_nm} != 'ALL')" ).append("\n"); 
		query.append("          AND   A.MFTR_VNDR_SEQ  IN ( " ).append("\n"); 
		query.append("          #foreach($cd in ${vel_vndr_abbr_nm})  " ).append("\n"); 
		query.append("            '$cd',  " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("          '') " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${man_year} != '' && ${man_year} != 'ALL')" ).append("\n"); 
		query.append("          AND   TO_CHAR(A.MFT_DT,'YYYY')  IN ( " ).append("\n"); 
		query.append("          #foreach($cd in ${vel_man_year})  " ).append("\n"); 
		query.append("            '$cd',  " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("          '') " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          GROUP BY  A.LSTM_CD,TO_CHAR(DECODE(A.LSTM_CD, 'LT', A.ONH_DT, 'ST', A.ONH_DT, A.MFT_DT),'YYYY'),NVL(A.MFTR_VNDR_SEQ,0),A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ) A, " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("         SELECT /*+ ORDERED USE_HASH(A B C P H)  */ " ).append("\n"); 
		query.append("                A.AGMT_LSTM_CD LSTM_CD,TO_CHAR(DECODE(A.AGMT_LSTM_CD, 'LT', A.ONH_DT, 'ST', A.ONH_DT, A.MFT_DT),'YYYY') MAN_YEAR ,NVL(B.VNDR_SEQ,0) MAN, " ).append("\n"); 
		query.append("                A.EQ_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                COUNT(A.EQ_TPSZ_CD) QTY," ).append("\n"); 
		query.append("                SUM(DECODE(INSTR('LSO,SLD,TLL,DON,SCR,DIO,SRO',H.EQ_ASET_STS_CD),0,TRUNC(SYSDATE),TRUNC(H.STS_EVNT_DT))" ).append("\n"); 
		query.append("					- TRUNC(DECODE(A.AGMT_LSTM_CD, 'LT', A.ONH_DT, 'ST', A.ONH_DT, A.MFT_DT))+1) USING_DAY" ).append("\n"); 
		query.append("         FROM   CGM_EQUIPMENT A, CGM_EQ_SPEC B, MDM_VENDOR C, PARAM P, CGM_EQ_STS_HIS H" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND  A.EQ_KND_CD = P.EQ_KND_CD" ).append("\n"); 
		query.append("         AND  A.EQ_NO = H.EQ_NO" ).append("\n"); 
		query.append("         AND  A.EQ_STS_SEQ = H.EQ_STS_SEQ" ).append("\n"); 
		query.append("         #if (${report_type} == 'O')" ).append("\n"); 
		query.append("         AND  H.EQ_ASET_STS_CD IN('SBO','MUO','OWN','SBI','MUI','SRI','FND','LSI') " ).append("\n"); 
		query.append("         #elseif (${report_type} == 'X')" ).append("\n"); 
		query.append("         AND  H.EQ_ASET_STS_CD IN('LSO', 'SLD','TLL','DON','SCR','DIO','SRO') " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${lstm_cd} != '' && ${lstm_cd} != 'ALL')" ).append("\n"); 
		query.append("         AND   A.AGMT_LSTM_CD  IN ( " ).append("\n"); 
		query.append("         #foreach($cd in ${vel_lstm_cd})  " ).append("\n"); 
		query.append("            '$cd',  " ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("         '')" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${lstm_cd} == 'ALL' || ${lstm_cd} == '')" ).append("\n"); 
		query.append("         AND   A.AGMT_LSTM_CD  IN ('OW','LP','OL','LT','ST')" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("         AND   A.EQ_TPSZ_CD  IN ( " ).append("\n"); 
		query.append("         #foreach($cd in ${vel_cntr_tpsz_cd})  " ).append("\n"); 
		query.append("            '$cd',  " ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("         '') " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${vndr_abbr_nm} != '' && ${vndr_abbr_nm} != 'ALL')" ).append("\n"); 
		query.append("         AND   B.VNDR_SEQ  IN ( " ).append("\n"); 
		query.append("         #foreach($cd in ${vel_vndr_abbr_nm})  " ).append("\n"); 
		query.append("            '$cd',  " ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("         '') " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${man_year} != '' && ${man_year} != 'ALL')" ).append("\n"); 
		query.append("         AND   TO_CHAR(A.MFT_DT,'YYYY')  IN ( " ).append("\n"); 
		query.append("         #foreach($cd in ${vel_man_year})  " ).append("\n"); 
		query.append("            '$cd',  " ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("         '') " ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         AND   A.EQ_SPEC_NO = B.EQ_SPEC_NO(+)" ).append("\n"); 
		query.append("         AND   A.EQ_KND_CD = B.EQ_KND_CD(+)" ).append("\n"); 
		query.append("         AND   B.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("         GROUP BY  A.AGMT_LSTM_CD,TO_CHAR(DECODE(A.AGMT_LSTM_CD, 'LT', A.ONH_DT, 'ST', A.ONH_DT, A.MFT_DT),'YYYY'),NVL(B.VNDR_SEQ,0),A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      (SELECT LEVEL SEQ  FROM DUAL CONNECT BY LEVEL <=3) B" ).append("\n"); 
		query.append("  GROUP BY GROUPING SETS((B.SEQ,A.LSTM_CD, A.MAN_YEAR ,A.MAN),(B.SEQ))" ).append("\n"); 
		query.append("    ORDER BY A.LSTM_CD, A.MAN_YEAR ,A.MAN,B.SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    AAA.LSTM_CD LSTM_CD," ).append("\n"); 
		query.append("    NVL(MAN_YEAR,' ') MAN_YEAR," ).append("\n"); 
		query.append("    MAN," ).append("\n"); 
		query.append("    MAN_NM," ).append("\n"); 
		query.append("    SEQ," ).append("\n"); 
		query.append("    DIV," ).append("\n"); 
		query.append("    ROUND(QTY0) QTY0," ).append("\n"); 
		query.append("    QTY1,QTY2,QTY3,QTY4,QTY5,QTY6,QTY7,QTY8,QTY9,QTY10,QTY11,QTY12,QTY13,QTY14,QTY15,QTY16,QTY17,QTY18,QTY19,QTY20,QTY21,QTY22,QTY23,QTY24,QTY25,QTY26,QTY27,QTY28,QTY29,QTY30" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- DETAIL VOL,AVG" ).append("\n"); 
		query.append("    SELECT GRP_ID," ).append("\n"); 
		query.append("        LSTM_CD,MAN_YEAR,MAN,MAN_NM,SEQ,DIV," ).append("\n"); 
		query.append("          DECODE( LAG (QTY0,1) OVER(PARTITION BY LSTM_CD,MAN_YEAR,MAN,MAN_NM ORDER BY LSTM_CD,MAN_YEAR,MAN,MAN_NM,SEQ), 0, 0," ).append("\n"); 
		query.append("                DECODE(SEQ, 2, LEAD(QTY0, 1) OVER(PARTITION BY LSTM_CD,MAN_YEAR,MAN,MAN_NM ORDER BY LSTM_CD,MAN_YEAR,MAN,MAN_NM,SEQ)/" ).append("\n"); 
		query.append("                               LAG (QTY0, 1) OVER(PARTITION BY LSTM_CD,MAN_YEAR,MAN,MAN_NM ORDER BY LSTM_CD,MAN_YEAR,MAN,MAN_NM,SEQ) ,   " ).append("\n"); 
		query.append("                QTY0)) AS QTY0," ).append("\n"); 
		query.append("        QTY1,QTY2,QTY3,QTY4,QTY5,QTY6,QTY7,QTY8,QTY9,QTY10,QTY11,QTY12,QTY13,QTY14,QTY15,QTY16,QTY17,QTY18,QTY19,QTY20,QTY21,QTY22,QTY23,QTY24,QTY25,QTY26,QTY27,QTY28,QTY29,QTY30" ).append("\n"); 
		query.append("    FROM LV_EQ_USING_DAY3" ).append("\n"); 
		query.append("    WHERE GRP_ID = 0" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    -- TOTAL VOL" ).append("\n"); 
		query.append("    SELECT GRP_ID," ).append("\n"); 
		query.append("        LSTM_CD,MAN_YEAR,MAN,MAN_NM,SEQ,DIV," ).append("\n"); 
		query.append("        ROUND(QTY0) QTY0," ).append("\n"); 
		query.append("        QTY1,QTY2,QTY3,QTY4,QTY5,QTY6,QTY7,QTY8,QTY9,QTY10,QTY11,QTY12,QTY13,QTY14,QTY15,QTY16,QTY17,QTY18,QTY19,QTY20,QTY21,QTY22,QTY23,QTY24,QTY25,QTY26,QTY27,QTY28,QTY29,QTY30" ).append("\n"); 
		query.append("    FROM LV_EQ_USING_DAY3" ).append("\n"); 
		query.append("    WHERE GRP_ID = 1" ).append("\n"); 
		query.append("    AND   SEQ = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    -- TOTAL AVG" ).append("\n"); 
		query.append("    SELECT A.GRP_ID," ).append("\n"); 
		query.append("        A.LSTM_CD,A.MAN_YEAR,A.MAN,A.MAN_NM,2 SEQ,'Average' DIV," ).append("\n"); 
		query.append("        DECODE(A.QTY0 ,0,0,ROUND(B.QTY0  / A.QTY0 )) QTY0," ).append("\n"); 
		query.append("        DECODE(A.QTY1 ,0,0,ROUND(B.QTY1  / A.QTY1 )) QTY1," ).append("\n"); 
		query.append("        DECODE(A.QTY2 ,0,0,ROUND(B.QTY2  / A.QTY2 )) QTY2," ).append("\n"); 
		query.append("        DECODE(A.QTY3 ,0,0,ROUND(B.QTY3  / A.QTY3 )) QTY3," ).append("\n"); 
		query.append("        DECODE(A.QTY4 ,0,0,ROUND(B.QTY4  / A.QTY4 )) QTY4," ).append("\n"); 
		query.append("        DECODE(A.QTY5 ,0,0,ROUND(B.QTY5  / A.QTY5 )) QTY5," ).append("\n"); 
		query.append("        DECODE(A.QTY6 ,0,0,ROUND(B.QTY6  / A.QTY6 )) QTY6," ).append("\n"); 
		query.append("        DECODE(A.QTY7 ,0,0,ROUND(B.QTY7  / A.QTY7 )) QTY7," ).append("\n"); 
		query.append("        DECODE(A.QTY8 ,0,0,ROUND(B.QTY8  / A.QTY8 )) QTY8," ).append("\n"); 
		query.append("        DECODE(A.QTY9 ,0,0,ROUND(B.QTY9  / A.QTY9 )) QTY9," ).append("\n"); 
		query.append("        DECODE(A.QTY10,0,0,ROUND(B.QTY10 / A.QTY10)) QTY10," ).append("\n"); 
		query.append("        DECODE(A.QTY11,0,0,ROUND(B.QTY11 / A.QTY11)) QTY11," ).append("\n"); 
		query.append("        DECODE(A.QTY12,0,0,ROUND(B.QTY12 / A.QTY12)) QTY12," ).append("\n"); 
		query.append("        DECODE(A.QTY13,0,0,ROUND(B.QTY13 / A.QTY13)) QTY13," ).append("\n"); 
		query.append("        DECODE(A.QTY14,0,0,ROUND(B.QTY14 / A.QTY14)) QTY14," ).append("\n"); 
		query.append("        DECODE(A.QTY15,0,0,ROUND(B.QTY15 / A.QTY15)) QTY15," ).append("\n"); 
		query.append("        DECODE(A.QTY16,0,0,ROUND(B.QTY16 / A.QTY16)) QTY16," ).append("\n"); 
		query.append("        DECODE(A.QTY17,0,0,ROUND(B.QTY17 / A.QTY17)) QTY17," ).append("\n"); 
		query.append("        DECODE(A.QTY18,0,0,ROUND(B.QTY18 / A.QTY18)) QTY18," ).append("\n"); 
		query.append("        DECODE(A.QTY19,0,0,ROUND(B.QTY19 / A.QTY19)) QTY19," ).append("\n"); 
		query.append("        DECODE(A.QTY20,0,0,ROUND(B.QTY20 / A.QTY20)) QTY20," ).append("\n"); 
		query.append("        DECODE(A.QTY21,0,0,ROUND(B.QTY21 / A.QTY21)) QTY21," ).append("\n"); 
		query.append("        DECODE(A.QTY22,0,0,ROUND(B.QTY22 / A.QTY22)) QTY22," ).append("\n"); 
		query.append("        DECODE(A.QTY23,0,0,ROUND(B.QTY23 / A.QTY23)) QTY23," ).append("\n"); 
		query.append("        DECODE(A.QTY24,0,0,ROUND(B.QTY24 / A.QTY24)) QTY24," ).append("\n"); 
		query.append("        DECODE(A.QTY25,0,0,ROUND(B.QTY25 / A.QTY25)) QTY25," ).append("\n"); 
		query.append("        DECODE(A.QTY26,0,0,ROUND(B.QTY26 / A.QTY26)) QTY26," ).append("\n"); 
		query.append("        DECODE(A.QTY27,0,0,ROUND(B.QTY27 / A.QTY27)) QTY27," ).append("\n"); 
		query.append("        DECODE(A.QTY28,0,0,ROUND(B.QTY28 / A.QTY28)) QTY28," ).append("\n"); 
		query.append("        DECODE(A.QTY29,0,0,ROUND(B.QTY29 / A.QTY29)) QTY29," ).append("\n"); 
		query.append("        DECODE(A.QTY30,0,0,ROUND(B.QTY30 / A.QTY30)) QTY30" ).append("\n"); 
		query.append("    FROM  LV_EQ_USING_DAY3 A,LV_EQ_USING_DAY3 B" ).append("\n"); 
		query.append("    WHERE A.GRP_ID = 1" ).append("\n"); 
		query.append("    AND   A.SEQ    = 1" ).append("\n"); 
		query.append("    AND   B.SEQ    = 3" ).append("\n"); 
		query.append("    AND   A.GRP_ID = B.GRP_ID" ).append("\n"); 
		query.append("    ) AAA," ).append("\n"); 
		query.append("    MST_LSE_TERM BBB" ).append("\n"); 
		query.append("WHERE AAA.SEQ IN(1,2)" ).append("\n"); 
		query.append("AND   AAA.LSTM_CD = BBB.LSTM_CD (+)" ).append("\n"); 
		query.append("AND	  AAA.QTY0    > 0" ).append("\n"); 
		query.append("ORDER BY BBB.DP_SEQ, AAA.MAN_YEAR, AAA.MAN, AAA.SEQ" ).append("\n"); 

	}
}