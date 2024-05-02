/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchTrendListByInvtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.04.09 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchTrendListByInvtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Operation Trend (Inventory Trend)
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchTrendListByInvtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("from_bse_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_bse_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_trnd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchTrendListByInvtRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.LOC_CD,NULL,'Total',A.LOC_CD) LOC_CD," ).append("\n"); 
		query.append("       DECODE(NVL(A.LOC_CD,'0')||NVL(A.CNTR_TPSZ_CD,'0'),'00',''," ).append("\n"); 
		query.append("       DECODE(CNTR_TPSZ_CD,NULL,'Total',CNTR_TPSZ_CD)) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,'MT',2,'Total','MT Ratio') DIVISION, " ).append("\n"); 
		query.append("	   DECODE(A.DIVISION,1,AVERAGE||'',2,AVERAGE||'',TO_CHAR(AVERAGE,'990.0')||'%') AVERAGE," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR1||'',2,YEAR1||'',(TO_CHAR(YEAR1,'990.0')||'%') ) YEAR1," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR2||'',2,YEAR2||'',(TO_CHAR(YEAR2,'990.0')||'%') ) YEAR2," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR3||'',2,YEAR3||'',(TO_CHAR(YEAR3,'990.0')||'%') ) YEAR3," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR4||'',2,YEAR4||'',(TO_CHAR(YEAR4,'990.0')||'%') ) YEAR4," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR5||'',2,YEAR5||'',(TO_CHAR(YEAR5,'990.0')||'%') ) YEAR5," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR6||'',2,YEAR6||'',(TO_CHAR(YEAR6,'990.0')||'%') ) YEAR6," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR7||'',2,YEAR7||'',(TO_CHAR(YEAR7,'990.0')||'%') ) YEAR7," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR8||'',2,YEAR8||'',(TO_CHAR(YEAR8,'990.0')||'%') ) YEAR8," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR9||'',2,YEAR9||'',(TO_CHAR(YEAR9,'990.0')||'%') ) YEAR9," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR10||'',2,YEAR10||'',(TO_CHAR(YEAR10,'990.0')||'%') ) YEAR10," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR11||'',2,YEAR11||'',(TO_CHAR(YEAR11,'990.0')||'%') ) YEAR11," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,YEAR12||'',2,YEAR12||'',(TO_CHAR(YEAR12,'990.0')||'%') ) YEAR12" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT /*+ INDEX(B XPKCIM_OP_TRND) */" ).append("\n"); 
		query.append("		#if (${loc_type_code} == '')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.RCC_CD)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '1')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.LCC_CD)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.ECC_CD)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.SCC_CD)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.SCC_CD)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("		    RANK() OVER (ORDER BY SUBSTR(A.SCC_CD,1,2))" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.SCC_CD)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.ECC_CD)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("	        RANK() OVER (ORDER BY A.SCC_CD)" ).append("\n"); 
		query.append("		#end RANK," ).append("\n"); 
		query.append("        (SELECT RPT_DP_SEQ" ).append("\n"); 
		query.append("        FROM MDM_CNTR_TP_SZ E" ).append("\n"); 
		query.append("        WHERE B.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD) RPT_DP_SEQ," ).append("\n"); 
		query.append("		#if (${loc_type_code} == '')" ).append("\n"); 
		query.append("			A.RCC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '1')" ).append("\n"); 
		query.append("			A.LCC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("			A.ECC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("			A.SCC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("			A.SCC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("			SUBSTR(A.SCC_CD,1,2)" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("			A.SCC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("			A.ECC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("			A.SCC_CD" ).append("\n"); 
		query.append("		#end LOC_CD" ).append("\n"); 
		query.append("        ,B.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,C.SEQ  DIVISION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("			  SUM(MTY_STK_QTY)/MAX(D.DUR_BETWEEN)" ).append("\n"); 
		query.append("		WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("			  SUM(CNTR_QTY)/MAX(D.DUR_BETWEEN)" ).append("\n"); 
		query.append("		WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			  DECODE(SUM(CNTR_QTY)/MAX(D.DUR_BETWEEN),0,0,ROUND((SUM(MTY_STK_QTY)/MAX(D.DUR_BETWEEN))/(SUM(CNTR_QTY)/MAX(D.DUR_BETWEEN))*100,1))" ).append("\n"); 
		query.append("		END AVERAGE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT1,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT1,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT1,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT1,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT1,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR1" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT2,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT2,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT2,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT2,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT2,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR2" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT3,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT3,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT3,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT3,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT3,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR3" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT4,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("        	NVL(SUM(DECODE(BSE_DT,D.BSE_DT4,CNTR_QTY)),0)" ).append("\n"); 
		query.append("	    WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT4,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT4,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT4,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR4" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT5,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT5,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT5,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT5,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT5,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR5" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT6,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT6,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT6,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT6,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT6,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR6" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT7,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT7,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT7,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT7,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT7,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR7" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT8,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT8,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT8,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT8,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT8,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR8" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT9,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT9,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT9,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT9,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT9,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR9" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT10,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT10,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT10,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT10,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT10,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR10" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	    NVL(SUM(DECODE(BSE_DT,D.BSE_DT11,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("	        NVL(SUM(DECODE(BSE_DT,D.BSE_DT11,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("			NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT11,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT11,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT11,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR11" ).append("\n"); 
		query.append("        ,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("        	NVL(SUM(DECODE(BSE_DT,D.BSE_DT12,MTY_STK_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("        	NVL(SUM(DECODE(BSE_DT,D.BSE_DT12,CNTR_QTY)),0)" ).append("\n"); 
		query.append("        WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("        	NVL(DECODE(SUM(DECODE(BSE_DT,D.BSE_DT12,CNTR_QTY)),0,0,ROUND(NVL(SUM(DECODE(BSE_DT,D.BSE_DT12,MTY_STK_QTY)),0) / SUM(DECODE(BSE_DT,D.BSE_DT12,CNTR_QTY))*100,1)),0)" ).append("\n"); 
		query.append("        END YEAR12" ).append("\n"); 
		query.append("    FROM MDM_EQ_ORZ_CHT A,CIM_OP_TRND B, (SELECT LEVEL SEQ   FROM DUAL CONNECT BY LEVEL <=3) C, " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			 SELECT MAX(DECODE(SEQ,1,BSE_DT)) BSE_DT1," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,2,BSE_DT)) BSE_DT2," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,3,BSE_DT)) BSE_DT3," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,4,BSE_DT)) BSE_DT4," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,5,BSE_DT)) BSE_DT5," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,6,BSE_DT)) BSE_DT6," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,7,BSE_DT)) BSE_DT7," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,8,BSE_DT)) BSE_DT8," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,9,BSE_DT)) BSE_DT9," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,10,BSE_DT)) BSE_DT10," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,11,BSE_DT)) BSE_DT11," ).append("\n"); 
		query.append("			       MAX(DECODE(SEQ,12,BSE_DT)) BSE_DT12," ).append("\n"); 
		query.append("				   MAX(SEQ) DUR_BETWEEN" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("			    (" ).append("\n"); 
		query.append("			    SELECT B.SEQ SEQ, TO_CHAR(ADD_MONTHS(A.BSE_DT,SEQ-1),'YYYYMM') BSE_DT" ).append("\n"); 
		query.append("			    FROM " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT @[op_trnd_tp_cd] OP_TRND_TP_CD,TO_DATE(@[from_bse_dt],'YYYYMM') BSE_DT," ).append("\n"); 
		query.append("						       DECODE(SUBSTR(@[op_trnd_tp_cd],2,1),'M',MONTHS_BETWEEN(TO_DATE(@[to_bse_dt],'YYYYMM'),TO_DATE(@[from_bse_dt],'YYYYMM')) +1,0) DUR_BETWEEN" ).append("\n"); 
		query.append("						FROM DUAL P" ).append("\n"); 
		query.append("						WHERE SUBSTR(@[op_trnd_tp_cd],2,1) = 'M'" ).append("\n"); 
		query.append("					) A,   " ).append("\n"); 
		query.append("					(SELECT LEVEL SEQ   " ).append("\n"); 
		query.append("					 FROM " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SELECT @[op_trnd_tp_cd] OP_TRND_TP_CD,TO_DATE(@[from_bse_dt],'YYYYMM') BSE_DT," ).append("\n"); 
		query.append("							       DECODE(SUBSTR(@[op_trnd_tp_cd],2,1),'M',MONTHS_BETWEEN(TO_DATE(@[to_bse_dt],'YYYYMM'),TO_DATE(@[from_bse_dt],'YYYYMM')) +1,0) DUR_BETWEEN" ).append("\n"); 
		query.append("							FROM DUAL P" ).append("\n"); 
		query.append("							WHERE SUBSTR(@[op_trnd_tp_cd],2,1) = 'M'" ).append("\n"); 
		query.append("						) B		 " ).append("\n"); 
		query.append("					 CONNECT BY LEVEL <= B.DUR_BETWEEN) B" ).append("\n"); 
		query.append("			    WHERE SUBSTR(A.OP_TRND_TP_CD,2,1) = 'M'" ).append("\n"); 
		query.append("			    UNION ALL" ).append("\n"); 
		query.append("			    SELECT /*+ INDEX(A XPKEQR_WK_PRD) */" ).append("\n"); 
		query.append("			          ROWNUM SEQ,A.PLN_YR||A.PLN_WK BSE_DT             " ).append("\n"); 
		query.append("			    FROM  EQR_WK_PRD A" ).append("\n"); 
		query.append("			    WHERE A.PLN_YR||A.PLN_WK BETWEEN @[from_bse_dt]  AND @[to_bse_dt]" ).append("\n"); 
		query.append("			    AND   SUBSTR(@[op_trnd_tp_cd],2,1) = 'W'" ).append("\n"); 
		query.append("			    )" ).append("\n"); 
		query.append("		) D   " ).append("\n"); 
		query.append("    WHERE A.SCC_CD = B.LOC_CD" ).append("\n"); 
		query.append("    AND  B.OP_TRND_TP_CD = @[op_trnd_tp_cd]" ).append("\n"); 
		query.append("	#if (${loc_type_code} != '')" ).append("\n"); 
		query.append("		#if (${loc_type_code} == '1' )" ).append("\n"); 
		query.append("			AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("			AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("			AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("			AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("			AND SUBSTR(A.SCC_CD,1,2) =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("			AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("			AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("			AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("		AND B.CNTR_TPSZ_CD  IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                        		FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                     FROM dual )" ).append("\n"); 
		query.append("									) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${co_cd} != '')" ).append("\n"); 
		query.append("    	AND  B.CO_CD=@[co_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${from_bse_dt} != '' && ${to_bse_dt} != '')" ).append("\n"); 
		query.append("    	AND  B.BSE_DT BETWEEN @[from_bse_dt] AND @[to_bse_dt]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${loc_type_code} != '')" ).append("\n"); 
		query.append("    	#if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("    		GROUP BY CUBE(SEQ,A.LCC_CD,B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("    		GROUP BY CUBE(SEQ,A.ECC_CD,B.CNTR_TPSZ_CD) " ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("    		GROUP BY CUBE(SEQ,A.SCC_CD,B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("    		GROUP BY CUBE(C.SEQ,A.SCC_CD,B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("			GROUP BY CUBE(SEQ,SUBSTR(A.SCC_CD,1,2),B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("    		GROUP BY CUBE(SEQ,A.SCC_CD,B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("    		GROUP BY CUBE(SEQ,A.ECC_CD,B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("    		GROUP BY CUBE(SEQ,A.SCC_CD,B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    	GROUP BY CUBE(SEQ,A.RCC_CD,B.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	ORDER BY RANK,RPT_DP_SEQ,DIVISION" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.DIVISION IS NOT NULL " ).append("\n"); 
		query.append("ORDER BY A.RANK,A.RPT_DP_SEQ,A.DIVISION" ).append("\n"); 

	}
}