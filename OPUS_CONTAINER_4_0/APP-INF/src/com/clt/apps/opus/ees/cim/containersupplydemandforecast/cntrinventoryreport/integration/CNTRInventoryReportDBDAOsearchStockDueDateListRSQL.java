/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchStockDueDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.05.07 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchStockDueDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주지역내 MTY 컨테이너의 Release/ Redelivery Order 승인리스트를 확인하여, 해당야드에 반입/ 반출되는 컨테이너 정보를 조회한다.(팝업)
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchStockDueDateListRSQL(){
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
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_stk_jb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchStockDueDateListRSQL").append("\n"); 
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
		query.append("     DECODE(A.STK_GATE_IO_CD,'I','IN','O','OUT') STK_GATE_IO_CD" ).append("\n"); 
		query.append("    ,A.STK_YD_CD" ).append("\n"); 
		query.append("    ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("    ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("    ,A.CNMV_DT" ).append("\n"); 
		query.append("    ,DECODE(A.TRSP_SO_TP_CD,'R','MT','S','S/T','C','C/H','M','M/H') TRSP_SO_TP_CD" ).append("\n"); 
		query.append("    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.CNTR_NO" ).append("\n"); 
		query.append("    ,A.BKG_NO" ).append("\n"); 
		query.append("    ,A.BL_NO" ).append("\n"); 
		query.append("    ,A.STK_JB_DT" ).append("\n"); 
		query.append("    ,A.UPD_USR_ID" ).append("\n"); 
		query.append("    ,A.STK_OFC_CD" ).append("\n"); 
		query.append("    ,A.STK_EVNT_DT " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         B.STK_GATE_IO_CD" ).append("\n"); 
		query.append("        ,B.STK_YD_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("        ,B.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("        ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,B.CNTR_NO" ).append("\n"); 
		query.append("        ,B.BKG_NO" ).append("\n"); 
		query.append("        ,B.BL_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(B.STK_JB_DT,'YYYY-MM-DD') STK_JB_DT" ).append("\n"); 
		query.append("        ,B.UPD_USR_ID" ).append("\n"); 
		query.append("        ,B.STK_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(B.STK_EVNT_DT,'YYYY-MM-DD') STK_EVNT_DT" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A,CIM_CNTR_STK B" ).append("\n"); 
		query.append("    WHERE A.CNTR_NO(+)=B.CNTR_NO" ).append("\n"); 
		query.append("	AND B.STL_FLG ='N'" ).append("\n"); 
		query.append("    #if (${lvl} != '10')" ).append("\n"); 
		query.append("		AND DECODE(@[yard_cd],NULL,B.STK_LOC_CD,B.STK_YD_CD) = DECODE(@[yard_cd],NULL,@[loc_cd],@[yard_cd])" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND B.STK_LOC_CD IN (SELECT D.LOC_CD FROM MDM_EQ_ORZ_CHT C,MDM_LOCATION D WHERE  C.SCC_CD = D.SCC_CD AND DECODE(@[loc_type_code],1,C.RCC_CD,2,C.LCC_CD,3,C.ECC_CD,4,C.SCC_CD) = @[loc_cd] )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND B.CNTR_TPSZ_CD  IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                        		FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                     FROM dual )" ).append("\n"); 
		query.append("    								) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ( ${fm_stk_jb_dt} != '' ) " ).append("\n"); 
		query.append("    	AND B.STK_JB_DT BETWEEN TO_DATE(@[fm_stk_jb_dt],'YYYYMMDD') AND  TO_DATE(NVL(@[to_stk_jb_dt],TO_CHAR(SYSDATE+90,'YYYYMMDD')),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ORDER BY B.STK_GATE_IO_CD, B.STK_YD_CD, A.CRNT_YD_CD, A.CNMV_DT" ).append("\n"); 
		query.append(") A,COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE A.CNMV_STS_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND B.INTG_CD_ID(+)='CD02086'" ).append("\n"); 
		query.append("ORDER BY A.STK_GATE_IO_CD, A.STK_YD_CD, B.INTG_CD_VAL_DP_SEQ, A.CNMV_DT" ).append("\n"); 

	}
}