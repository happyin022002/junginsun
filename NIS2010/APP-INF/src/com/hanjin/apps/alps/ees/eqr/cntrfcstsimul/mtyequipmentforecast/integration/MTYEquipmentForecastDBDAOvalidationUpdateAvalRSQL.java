/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOvalidationUpdateAvalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOvalidationUpdateAvalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주차와 입력 시간에 따라 업데이트 불가 여부를 체크한다.
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOvalidationUpdateAvalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("input_year_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOvalidationUpdateAvalRSQL").append("\n"); 
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
		query.append("WITH PARAM AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ A.PLN_YR||A.PLN_WK FCAST_YRWK" ).append("\n"); 
		query.append("     FROM  EQR_WK_PRD A" ).append("\n"); 
		query.append("     WHERE A.PLN_YR||A.PLN_WK > @[input_year_week]" ).append("\n"); 
		query.append("     AND   ROWNUM = 1)   FCAST_YRWK     " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LV_LOCAL_DT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT GLOBALDATE_PKG.TIME_LOCAL_FNC(@[loc_cd]) LOCAL_TIME" ).append("\n"); 
		query.append("       --TO_DATE('20091002'||'17:00:01','YYYYMMDDHH24:MI:SS') LOCAL_TIME --테스트용" ).append("\n"); 
		query.append("FROM PARAM P" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_WEEK AS" ).append("\n"); 
		query.append("(SELECT A.PLN_YR||A.PLN_WK CURR_WK," ).append("\n"); 
		query.append("            TO_DATE(A.WK_END_DT||'17:00:00','YYYYMMDDHH24:MI:SS') - 1  UP_BASE_LINE," ).append("\n"); 
		query.append("           B.LOCAL_TIME   " ).append("\n"); 
		query.append("FROM EQR_WK_PRD A, LV_LOCAL_DT B" ).append("\n"); 
		query.append("WHERE TO_CHAR(B.LOCAL_TIME,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("---- CHK_TP_CD = '1' IN&OUT FCST" ).append("\n"); 
		query.append("SELECT DECODE(SIGN(P.FCAST_YRWK-A.CURR_WK),0,'2'," ).append("\n"); 
		query.append("                                           1,(DECODE(B.CURR_NEXT_WEEK,P.FCAST_YRWK," ).append("\n"); 
		query.append("                                                                                  (CASE WHEN LOCAL_TIME > UP_BASE_LINE" ).append("\n"); 
		query.append("                                                                                        THEN '3'" ).append("\n"); 
		query.append("                                                                                        ELSE '0'" ).append("\n"); 
		query.append("                                                                                   END)," ).append("\n"); 
		query.append("                                                                                  '0'))," ).append("\n"); 
		query.append("                                           '1') UPDATE_AVAL " ).append("\n"); 
		query.append("FROM LV_WEEK A,(SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ A.PLN_YR||A.PLN_WK CURR_NEXT_WEEK" ).append("\n"); 
		query.append("                FROM  EQR_WK_PRD A, LV_WEEK B" ).append("\n"); 
		query.append("                WHERE A.PLN_YR||A.PLN_WK > B.CURR_WK" ).append("\n"); 
		query.append("                AND   ROWNUM = 1) B,PARAM P" ).append("\n"); 
		query.append("WHERE @[chk_tp_cd] = '1'   " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- CHK_TP_CD = '2' IN&OUT FCST (과거주차는 입력 못함)" ).append("\n"); 
		query.append("SELECT DECODE(SIGN(P.FCAST_YRWK-A.CURR_WK),-1,'1','0') UPDATE_AVAL" ).append("\n"); 
		query.append("FROM LV_WEEK A, PARAM P" ).append("\n"); 
		query.append("WHERE @[chk_tp_cd] = '2'" ).append("\n"); 

	}
}