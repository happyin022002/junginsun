/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceOtherListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.06.07 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchMtyBalanceOtherListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceOtherListRSQL(){
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
		params.put("inp_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceOtherListRSQL").append("\n"); 
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
		query.append("     A.CO_CD" ).append("\n"); 
		query.append("    ,A.LOC_CD" ).append("\n"); 
		query.append("	,A.LOC_GRP_CD" ).append("\n"); 
		query.append("    ,A.INP_YRWK" ).append("\n"); 
		query.append("    ,A.FCAST_YRWK" ).append("\n"); 
		query.append("    ,A.MTY_BAL_OTR_TP_CD" ).append("\n"); 
		query.append("    ,A.CRE_SEQ" ).append("\n"); 
		query.append("    ,A.FCTR_CTNT" ).append("\n"); 
		query.append("    ,A.LSTM_CD" ).append("\n"); 
		query.append("    ,A.YD_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(A.FCAST_DT,'YYYY-MM-DD') FCAST_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(A.D2_FCAST_QTY+A.D4_FCAST_QTY+A.D5_FCAST_QTY+A.D7_FCAST_QTY+A.R2_FCAST_QTY+A.R5_FCAST_QTY+A.R9_FCAST_QTY+A.O2_FCAST_QTY+A.S2_FCAST_QTY+A.O4_FCAST_QTY+A.S4_FCAST_QTY+A.F2_FCAST_QTY+A.A2_FCAST_QTY+A.F4_FCAST_QTY+A.A4_FCAST_QTY+A.F5_FCAST_QTY,'9,999,999')   G_TOTAL    " ).append("\n"); 
		query.append("    ,TO_CHAR(A.D2_FCAST_QTY+A.D4_FCAST_QTY+A.D5_FCAST_QTY+A.D7_FCAST_QTY,'9,999,999')   D_TOTAL" ).append("\n"); 
		query.append("    ,A.D2_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.D4_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.D5_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.D7_FCAST_QTY" ).append("\n"); 
		query.append("    ,TO_CHAR(A.R2_FCAST_QTY+A.R5_FCAST_QTY+A.R9_FCAST_QTY+A.O2_FCAST_QTY+A.S2_FCAST_QTY+A.O4_FCAST_QTY+A.S4_FCAST_QTY+A.F2_FCAST_QTY+A.A2_FCAST_QTY+A.F4_FCAST_QTY+A.A4_FCAST_QTY+A.F5_FCAST_QTY,'9,999,999') S_TOTAL" ).append("\n"); 
		query.append("    ,A.R2_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.R5_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.R9_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.O2_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.S2_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.O4_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.S4_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.F2_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.A2_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.F4_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.A4_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.F5_FCAST_QTY" ).append("\n"); 
		query.append("    ,A.DIFF_RMK" ).append("\n"); 
		query.append("    ,A.CRE_USR_ID" ).append("\n"); 
		query.append("    ,A.CRE_DT" ).append("\n"); 
		query.append("    ,A.UPD_USR_ID" ).append("\n"); 
		query.append("    ,A.UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT   " ).append("\n"); 
		query.append("         A.CO_CD" ).append("\n"); 
		query.append("        ,A.LOC_CD" ).append("\n"); 
		query.append("		,A.LOC_GRP_CD" ).append("\n"); 
		query.append("        ,A.INP_YRWK" ).append("\n"); 
		query.append("        ,A.FCAST_YRWK" ).append("\n"); 
		query.append("        ,A.MTY_BAL_OTR_TP_CD" ).append("\n"); 
		query.append("        ,A.CRE_SEQ" ).append("\n"); 
		query.append("        ,A.FCTR_CTNT" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.YD_CD" ).append("\n"); 
		query.append("        ,A.FCAST_DT" ).append("\n"); 
		query.append("        ,NVL(A.D2_FCAST_QTY,0) D2_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.D4_FCAST_QTY,0) D4_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.D5_FCAST_QTY,0) D5_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.D7_FCAST_QTY,0) D7_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.R2_FCAST_QTY,0) R2_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.R5_FCAST_QTY,0) R5_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.R9_FCAST_QTY,0) R9_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.O2_FCAST_QTY,0) O2_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.S2_FCAST_QTY,0) S2_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.O4_FCAST_QTY,0) O4_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.S4_FCAST_QTY,0) S4_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.F2_FCAST_QTY,0) F2_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.A2_FCAST_QTY,0) A2_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.F4_FCAST_QTY,0) F4_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.A4_FCAST_QTY,0) A4_FCAST_QTY" ).append("\n"); 
		query.append("        ,NVL(A.F5_FCAST_QTY,0) F5_FCAST_QTY" ).append("\n"); 
		query.append("        ,A.DIFF_RMK" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,A.CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,A.UPD_DT" ).append("\n"); 
		query.append("    FROM  EQR_MTY_BAL_RPT_OTR A" ).append("\n"); 
		query.append("    WHERE A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    AND   A.FCAST_YRWK = @[fcast_yrwk]" ).append("\n"); 
		query.append("    AND   A.CO_CD ='H'" ).append("\n"); 
		query.append("    AND   A.MTY_BAL_OTR_TP_CD = @[tp_cd]" ).append("\n"); 
		query.append("    AND   A.INP_YRWK = @[inp_yrwk]" ).append("\n"); 
		query.append("    AND   A.LOC_GRP_CD = @[loc_grp_cd]	" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY A.FCAST_DT,A.LSTM_CD,A.YD_CD" ).append("\n"); 

	}
}