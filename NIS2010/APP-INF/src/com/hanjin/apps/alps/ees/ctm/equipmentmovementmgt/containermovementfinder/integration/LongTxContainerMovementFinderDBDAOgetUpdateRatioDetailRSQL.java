/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOgetUpdateRatioDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOgetUpdateRatioDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MVMT Timely Update Ratio 의 DETAIL
	  * --------------------------------------------------------
	  * History
	  * 2010.08.18 나상보 [CHM-201005413-01] MVNT timely update ratio 기능보완
	  *                   : [EES_CTM_0418] 1. LCC 선택시 Yard 단위로 Download 가능 하도록 처리
	  * 					             2. 검색 조건 추가 (mvmt status 멀티 선택 가능)
	  * 2010.09.09 김상수 [CHM-201006478-01] Full/Mty Option기능 추가 (Movement 적시 update 비율 및 row data를 조회하는 화면)
	  *                   1.Movement 적시 update 비율 및 row data를 조회하는 화면에 Full/Mty Option기능 추가
	  *                     ->Service Management > CNTR Movement > Monitoring > MVMT Timely Update Ratio
	  *                   2. Default 값은 All 로 하고, 필요시 Full 혹은 Mty별 조회 기능 추가
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOgetUpdateRatioDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOgetUpdateRatioDetailRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       MVMT_STS_CD," ).append("\n"); 
		query.append("       OB_CNTR_FLG," ).append("\n"); 
		query.append("       MVMT_INP_TP_CD," ).append("\n"); 
		query.append("       ORG_YD_CD," ).append("\n"); 
		query.append("       CNMV_EVNT_DT," ).append("\n"); 
		query.append("       CRE_LOCL_DT," ).append("\n"); 
		query.append("       ROUND (OFFSET_DATE, 1) AS OFFSET_DT," ).append("\n"); 
		query.append("	   USR_NM" ).append("\n"); 
		query.append("  FROM (SELECT CNTR_NO," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               MVMT_STS_CD," ).append("\n"); 
		query.append("               OB_CNTR_FLG," ).append("\n"); 
		query.append("               MVMT_INP_TP_CD," ).append("\n"); 
		query.append("               ORG_YD_CD," ).append("\n"); 
		query.append("               CNMV_EVNT_DT," ).append("\n"); 
		query.append("               CRE_LOCL_DT," ).append("\n"); 
		query.append("               OFFSET_DT," ).append("\n"); 
		query.append("               OFFSET_DATE," ).append("\n"); 
		query.append("               CASE WHEN OFFSET_DT <= 0.5 THEN 1 ELSE 0 END AS OFF_12," ).append("\n"); 
		query.append("               CASE WHEN OFFSET_DT > 2 THEN 1 ELSE 0 END AS OVR_48," ).append("\n"); 
		query.append("               CASE WHEN OFFSET_DT > 0.5 AND OFFSET_DT <= 1 THEN 1 ELSE 0 END AS OFF_24," ).append("\n"); 
		query.append("               CASE WHEN OFFSET_DT > 1 AND OFFSET_DT <= 2 THEN 1 ELSE 0 END AS OFF_48," ).append("\n"); 
		query.append("			   USR_NM" ).append("\n"); 
		query.append("          FROM (SELECT CNTR_NO," ).append("\n"); 
		query.append("                       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       MVMT_STS_CD," ).append("\n"); 
		query.append("                       OB_CNTR_FLG," ).append("\n"); 
		query.append("                       MVMT_INP_TP_CD," ).append("\n"); 
		query.append("                       ORG_YD_CD," ).append("\n"); 
		query.append("                       TO_CHAR (CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("                       TO_CHAR (CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') CRE_LOCL_DT," ).append("\n"); 
		query.append("                       (CRE_LOCL_DT - CNMV_EVNT_DT) AS OFFSET_DT," ).append("\n"); 
		query.append("                       (CRE_LOCL_DT - CNMV_EVNT_DT) * 24 AS OFFSET_DATE," ).append("\n"); 
		query.append("					   USR_NM" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("              #if (${rcc_cd} != '')" ).append("\n"); 
		query.append("                   AND SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("                          (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                             FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                            WHERE CNT_CD = SUBSTR (@[rcc_cd], 0, 2)" ).append("\n"); 
		query.append("                              AND SUBSTR (SYS_AREA_GRP_ID, 0, 1) != 'D')" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("                   AND SYS_AREA_GRP_ID IN ('USA', 'SWA', 'KOR', 'EUR', 'CHN')" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${dom_flg} == 'I')" ).append("\n"); 
		query.append("                   AND SUBSTR (MVMT_STS_CD, 0, 1) != 'C'" ).append("\n"); 
		query.append("              #elseif (${dom_flg} == 'D')" ).append("\n"); 
		query.append("                   AND SUBSTR (MVMT_STS_CD, 0, 1) = 'C'" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("                   AND CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                   AND ORG_YD_CD = @[p_yard]" ).append("\n"); 
		query.append("                   AND (NVL(MVMT_CRE_TP_CD, 'XX') = 'XX'" ).append("\n"); 
		query.append("						OR MVMT_CRE_TP_CD IN ('N', 'M', 'S', 'B'))" ).append("\n"); 
		query.append("              #if (${edi_type} == 'S')" ).append("\n"); 
		query.append("                   AND MVMT_INP_TP_CD = 'SPP'" ).append("\n"); 
		query.append("              #elseif (${edi_type} == 'E')" ).append("\n"); 
		query.append("                   AND MVMT_INP_TP_CD = 'EDI'" ).append("\n"); 
		query.append("              #elseif (${edi_type} == 'M')" ).append("\n"); 
		query.append("                   AND MVMT_INP_TP_CD = 'MAN'" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${sts_cd} != '')" ).append("\n"); 
		query.append("                   AND MVMT_STS_CD IN (${sts_cd})" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${fcntr_flg} != '')" ).append("\n"); 
		query.append("                   AND FCNTR_FLG = @[fcntr_flg]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("               ) CTM," ).append("\n"); 
		query.append("               MDM_LOCATION LOC," ).append("\n"); 
		query.append("               MDM_EQ_ORZ_CHT EQ" ).append("\n"); 
		query.append("         WHERE LOC.SCC_CD = EQ.SCC_CD" ).append("\n"); 
		query.append("           AND LOC.LOC_CD = SUBSTR (CTM.ORG_YD_CD, 0, 5)" ).append("\n"); 
		query.append("      #if (${rcc_cd} != '')" ).append("\n"); 
		query.append("           AND EQ.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("           AND EQ.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${gap} == '12')" ).append("\n"); 
		query.append("   #if (${time_off} == '1')" ).append("\n"); 
		query.append("     AND OFF_12 = '1'" ).append("\n"); 
		query.append("   #elseif (${time_off} == '5')" ).append("\n"); 
		query.append("     AND 1 = 1" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("     AND OFF_12 != '1'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#elseif (${gap} == '24')" ).append("\n"); 
		query.append("   #if (${time_off} == '2')" ).append("\n"); 
		query.append("      AND (OFF_12 = '1' OR OFF_24 = '1')" ).append("\n"); 
		query.append("   #elseif (${time_off} == '5')" ).append("\n"); 
		query.append("      AND 1 = 1" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND (OFF_12 != '1' AND OFF_24 != '1')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#elseif (${gap} == '48')" ).append("\n"); 
		query.append("   #if (${time_off} == '3')" ).append("\n"); 
		query.append("      AND (OFF_12 = '1' OR OFF_24 = '1' OR OFF_48 = '1')" ).append("\n"); 
		query.append("   #elseif (${time_off} == '5')" ).append("\n"); 
		query.append("      AND 1 = 1" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND (OFF_12 != '1' AND OFF_24 != '1' AND OFF_48 != '1')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${time_off} == '1')" ).append("\n"); 
		query.append("      AND OFF_12 = '1'" ).append("\n"); 
		query.append("   #elseif (${time_off} == '2')" ).append("\n"); 
		query.append("      AND OFF_24 = '1'" ).append("\n"); 
		query.append("   #elseif (${time_off} == '3')" ).append("\n"); 
		query.append("      AND OFF_48 = '1'" ).append("\n"); 
		query.append("   #elseif (${time_off} == '4')" ).append("\n"); 
		query.append("      AND OVR_48 = '1'" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND 1 = 1" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}