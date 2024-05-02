/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StatusReportDBDAOSearchTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.29 변종건 [CHM-201216420-01] Outbound CNTR Movement Status에 Trade, Sub Trade 옵션 추가 요청
	  * </pre>
	  */
	public StatusReportDBDAOSearchTradeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchTradeListRSQL").append("\n"); 
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
		query.append("#if (${div} == 'tradeSearch')" ).append("\n"); 
		query.append("/* Trade List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT   B.TRD_CD" ).append("\n"); 
		query.append(", '' SUB_TRD_CD" ).append("\n"); 
		query.append(", B.TRD_CD AS CODE" ).append("\n"); 
		query.append(", B.TRD_CD ||'|'|| TRD_NM AS NAME" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("B.TRD_CD" ).append("\n"); 
		query.append("FROM   MDM_REV_LANE     A" ).append("\n"); 
		query.append(",MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE  A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("AND    A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("AND    C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", MDM_TRADE B" ).append("\n"); 
		query.append("WHERE    A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${div} == 'subTradeSearch')" ).append("\n"); 
		query.append("/* Sub Trade List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT   A.TRD_CD" ).append("\n"); 
		query.append(", B.SUB_TRD_CD" ).append("\n"); 
		query.append(", B.SUB_TRD_CD AS CODE" ).append("\n"); 
		query.append(", (A.TRD_CD || '|' || B.SUB_TRD_CD  || '|' || NVL(B.SUB_TRD_NM, ( SELECT T.TRD_NM FROM MDM_TRADE T WHERE T.TRD_CD = A.TRD_CD ))) AS NAME" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("SELECT DISTINCT B.TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append("FROM   MDM_REV_LANE     A" ).append("\n"); 
		query.append(",MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE  A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    B.DELT_FLG IN ('N', NULL)" ).append("\n"); 
		query.append("AND    B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("AND    A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("AND    C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND    B.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", MDM_SUB_TRD B" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD" ).append("\n"); 
		query.append(", B.SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${div} == 'revLaneSearch')" ).append("\n"); 
		query.append("/* Lane List를  가져 온다 */" ).append("\n"); 
		query.append("SELECT   DISTINCT B.TRD_CD" ).append("\n"); 
		query.append(", B.SUB_TRD_CD" ).append("\n"); 
		query.append(", A.RLANE_CD CODE" ).append("\n"); 
		query.append(", (B.TRD_CD || '|' || B.SUB_TRD_CD || '|' || A.RLANE_CD || '|' || A.RLANE_NM) AS NAME" ).append("\n"); 
		query.append("FROM     MDM_REV_LANE A" ).append("\n"); 
		query.append(", MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append(", MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE    A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND      A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("AND      B.DELT_FLG IN ('N', NULL)" ).append("\n"); 
		query.append("AND      B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("AND      A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND      DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("AND      C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND      B.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '')" ).append("\n"); 
		query.append("AND      B.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD" ).append("\n"); 
		query.append(", B.SUB_TRD_CD" ).append("\n"); 
		query.append(", A.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}