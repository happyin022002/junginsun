/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchStockListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.04.07 김종준
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

public class CNTRInventoryReportDBDAOsearchStockListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주지역내 장비수급 계획을 감안하여, 금일 기준의 Available 장비 대수를 조회한다.
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchStockListRSQL(){
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
		params.put("to_stk_jb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_stk_jb_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchStockListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     A.LVL" ).append("\n"); 
		query.append("    ,A.LOC_TYPE_CODE" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'10','Total','11','G.total',A.LOC_CD) LOC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'01','Total','10',A.CNTR_TPSZ_CD,'11','G.total',A.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.RPT_DP_SEQ" ).append("\n"); 
		query.append("    ,A.AVAL_QTY" ).append("\n"); 
		query.append("    ,A.SND_QTY" ).append("\n"); 
		query.append("    ,A.DMG_QTY" ).append("\n"); 
		query.append("    ,A.TOT_QTY" ).append("\n"); 
		query.append("    ,A.DUE_OUT_QTY" ).append("\n"); 
		query.append("    ,A.DUE_IN_QTY" ).append("\n"); 
		query.append("    ,TO_CHAR(A.CNTR_QTY,'9,999,999') CNTR_QTY" ).append("\n"); 
		query.append("    ,A.VARI_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("  		   GROUPING(A.LOC_CD)||GROUPING(A.CNTR_TPSZ_CD) LVL	" ).append("\n"); 
		query.append("		  ,'${loc_type_code}' LOC_TYPE_CODE" ).append("\n"); 
		query.append("	  	  ,A.LOC_CD" ).append("\n"); 
		query.append("          ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ,(SELECT RPT_DP_SEQ" ).append("\n"); 
		query.append("            FROM MDM_CNTR_TP_SZ E" ).append("\n"); 
		query.append("            WHERE A.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD) RPT_DP_SEQ" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.DMG_FLG,'N',A.MST_QTY)),0) - NVL(SUM(DECODE(A.STK_GATE_IO_CD,'O',A.STK_QTY)),0) AVAL_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.DMG_FLG,'N',A.MST_QTY)),0) SND_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.DMG_FLG,'Y',A.MST_QTY)),0) DMG_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.DMG_FLG,'N',MST_QTY)),0)+NVL(SUM(DECODE(A.DMG_FLG,'Y',A.MST_QTY)),0) TOT_QTY" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.STK_GATE_IO_CD,'O',A.STK_QTY)),0) DUE_OUT_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.STK_GATE_IO_CD,'I',A.STK_QTY)),0) DUE_IN_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(A.CNTR_QTY),0) CNTR_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.DMG_FLG,'N',A.MST_QTY)),0) - NVL(SUM(DECODE(A.STK_GATE_IO_CD,'O',A.STK_QTY)),0) - NVL(SUM(A.CNTR_QTY),0) VARI_QTY" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("			 DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}','4',A.YD_CD,B.SCC_CD),A.YD_CD) LOC_CD" ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            , SUM(CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("            ,0 MST_QTY" ).append("\n"); 
		query.append("            ,0 STK_QTY" ).append("\n"); 
		query.append("            ,'' DMG_FLG" ).append("\n"); 
		query.append("            ,'' STK_GATE_IO_CD" ).append("\n"); 
		query.append("            ,'I' ib_flag" ).append("\n"); 
		query.append("        FROM CIM_STK_OPMZ A,MDM_EQ_ORZ_CHT B,MDM_LOCATION C" ).append("\n"); 
		query.append("        WHERE B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("        AND SUBSTR(A.YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("        AND DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}',1,B.RCC_CD,2,B.LCC_CD,3,B.ECC_CD,4,B.SCC_CD),B.SCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    		AND A.CNTR_TPSZ_CD  IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                            		FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                         FROM dual )" ).append("\n"); 
		query.append("    									) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}','4',A.YD_CD,B.SCC_CD),A.YD_CD)" ).append("\n"); 
		query.append("                ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("			 DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}','4',A.CRNT_YD_CD,A.SCC_CD),A.CRNT_YD_CD) LOC_CD" ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,0" ).append("\n"); 
		query.append("            ,COUNT(A.CNTR_NO)" ).append("\n"); 
		query.append("            ,0" ).append("\n"); 
		query.append("            ,A.DMG_FLG" ).append("\n"); 
		query.append("            ,'' STK_GATE_IO_CD" ).append("\n"); 
		query.append("            ,'' ib_flag" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A" ).append("\n"); 
		query.append("        WHERE DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}',1,A.RCC_CD,2,A.LCC_CD,3,A.ECC_CD,4,A.SCC_CD),A.SCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("        AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("        AND A.CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append("		--AND A.CNMV_STS_CD NOT IN('XX')" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    		AND A.CNTR_TPSZ_CD  IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                            		FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                         FROM dual )" ).append("\n"); 
		query.append("    									) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}','4',A.CRNT_YD_CD,A.SCC_CD),A.CRNT_YD_CD)" ).append("\n"); 
		query.append("                ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,A.DMG_FLG" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("			 DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}','4',A.STK_YD_CD,B.SCC_CD),A.STK_YD_CD) LOC_CD" ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,0 " ).append("\n"); 
		query.append("            ,0" ).append("\n"); 
		query.append("            ,COUNT(A.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("            ,'' DMG_FLG" ).append("\n"); 
		query.append("            ,A.STK_GATE_IO_CD" ).append("\n"); 
		query.append("            ,'' ib_flag" ).append("\n"); 
		query.append("        FROM CIM_CNTR_STK A,MDM_EQ_ORZ_CHT B,MDM_LOCATION C,MST_CONTAINER D" ).append("\n"); 
		query.append("		WHERE A.CNTR_NO=D.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}',1,B.RCC_CD,2,B.LCC_CD,3,B.ECC_CD,4,B.SCC_CD),B.SCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("        AND B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("		AND A.STK_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("		AND A.STL_FLG ='N'" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    		AND A.CNTR_TPSZ_CD  IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                            		FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                         FROM dual )" ).append("\n"); 
		query.append("    									) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    #if ( ${fm_stk_jb_dt} != '' ) " ).append("\n"); 
		query.append("			AND A.STK_JB_DT BETWEEN TO_DATE(@[fm_stk_jb_dt],'YYYYMMDD') AND  TO_DATE(NVL(@[to_stk_jb_dt],TO_CHAR(SYSDATE+90,'YYYYMMDD')),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        GROUP BY DECODE('${yard_cd}',NULL,DECODE('${loc_type_code}','4',A.STK_YD_CD,B.SCC_CD),A.STK_YD_CD)" ).append("\n"); 
		query.append("                ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,A.STK_GATE_IO_CD" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    GROUP BY CUBE(A.LOC_CD,A.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append(") A " ).append("\n"); 
		query.append("ORDER BY A.LOC_CD,A.RPT_DP_SEQ" ).append("\n"); 

	}
}