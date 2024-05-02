/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrendLineDBDAOSearchNoonRptForTrndLineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAOSearchNoonRptForTrndLineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trend Line 생성을 위한 정보를 조회한다.
	  * =========================================================================
	  * 2012.02.14 진마리아 CHM-201216243-01 Departure Report의 Cargo Weight 정보 추가
	  * 2012.03.08 선반영 진마리아 Displacement 컬럼 추가
	  * 2012.07.02 이혜민   CHM-201218617-01  TREND 곡선 생성시 DATA관련 M/E 소모량을 FO값만 가져오던 것에서 TOTAL값을 가져올 수 있도록 수정.
	  * 2014.02.12 정운 CHM-201428644 Trend Line Manual Creation - Cargo 컬럼 수정
	  * 2014.05.19 SKY  CHM-201430214 Trend line 생성시 Noon Report 호출 로직 변경
	  * - MN_FOIL_CSM_QTY(MAIN FUEL OIL CONSUMPTION QUANTITY )  값이 0이 아니거나, NULL이 아닌값에 대한  조회 로직건  제거
	  * </pre>
	  */
	public TrendLineDBDAOSearchNoonRptForTrndLineRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_slp_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_slp_opt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAOSearchNoonRptForTrndLineRSQL").append("\n"); 
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
		query.append("T1.VSL_CD" ).append("\n"); 
		query.append(",T1.SKD_VOY_NO" ).append("\n"); 
		query.append(",T1.SKD_DIR_CD " ).append("\n"); 
		query.append(",T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",(SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE T1.VSL_CD=VSL_CD) VSL_CLSS_CD" ).append("\n"); 
		query.append(",T1.VSL_SLAN_CD" ).append("\n"); 
		query.append(",T1.NXT_PORT_CD" ).append("\n"); 
		query.append(",T1.WND_SCL_NO" ).append("\n"); 
		query.append(",T1.SEA_STE_NO" ).append("\n"); 
		query.append(",TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60) SAIL_HRMNT" ).append("\n"); 
		query.append(",T1.NVGT_ML_DIST" ).append("\n"); 
		query.append(",T1.ENG_ML_DIST" ).append("\n"); 
		query.append(",T1.SAIL_AVG_SPD" ).append("\n"); 
		query.append(",T1.SAIL_AVG_RPM_PWR" ).append("\n"); 
		query.append(",T1.SLP_RT" ).append("\n"); 
		query.append(",T1.LOD_IND_QTY" ).append("\n"); 
		query.append(",TO_NUMBER(NVL(T1.MN_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(T1.MN_LOW_SULP_FOIL_CSM_QTY,0)) MN_FOIL_CSM_QTY " ).append("\n"); 
		query.append(",TO_NUMBER(NVL(T1.GNR_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(T1.GNR_LOW_SULP_FOIL_CSM_QTY,0)) GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",TO_NUMBER(NVL(T1.BLR_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(T1.BLR_LOW_SULP_FOIL_CSM_QTY,0)) BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",((TO_NUMBER(NVL(MN_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(MN_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)))*24 DAY_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",((TO_NUMBER(NVL(GNR_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(GNR_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)))*24 DAY_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",((TO_NUMBER(NVL(BLR_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(BLR_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)))*24 DAY_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",T1.MN_PWR" ).append("\n"); 
		query.append(",NVL((SELECT M.MAX_SPD FROM MDM_VSL_CNTR M WHERE M.VSL_CD=T1.VSL_CD),0) MAX_SPD" ).append("\n"); 
		query.append(", @[avg_slp_rt] AVG_SLP_RT" ).append("\n"); 
		query.append(",((ENG_ML_DIST/" ).append("\n"); 
		query.append("            (TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)) --HH24MI 형식을 HOUR로 변환" ).append("\n"); 
		query.append("            )*(100-(TO_NUMBER(@[avg_slp_rt])+TO_NUMBER(@[avg_slp_rt])*TO_NUMBER(NVL(@[avg_slp_opt_rt],0))/100))" ).append("\n"); 
		query.append("          )/100 CALC_SPD" ).append("\n"); 
		query.append(",TO_NUMBER(@[avg_slp_rt])+TO_NUMBER(@[avg_slp_rt])*TO_NUMBER(NVL(@[avg_slp_opt_rt],0))/100 APLY_SLP_RT" ).append("\n"); 
		query.append(",(SELECT DECODE(COUNT(TRND_LINE_XCLD_FLG),0,'N','Y')" ).append("\n"); 
		query.append("    FROM FCM_TRND_LINE_RPT_MTCH" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("     AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND NOON_RPT_DT = T1.NOON_RPT_DT" ).append("\n"); 
		query.append("     AND TRND_LINE_XCLD_FLG='Y'" ).append("\n"); 
		query.append(" ) TRND_LINE_XCLD_FLG" ).append("\n"); 
		query.append(", TO_CHAR(NOON_RPT_DT,'YYYY-MM-DD HH24:MI') NOON_RPT_DT" ).append("\n"); 
		query.append(", TO_NUMBER(MN_PWR)/68640*100 LOAD" ).append("\n"); 
		query.append(", (SELECT " ).append("\n"); 
		query.append("          CASE " ).append("\n"); 
		query.append("                WHEN COUNT(*)  = 2  THEN MAX(TTL_CNTR_OBRD_TEU_EP)" ).append("\n"); 
		query.append("                WHEN COUNT(*)  = 1  THEN  MAX(TTL_CNTR_OBRD_TEU)" ).append("\n"); 
		query.append("                ELSE '0'--DECODE(COUNT(*), 1, MAX(TTL_CNTR_OBRD_TEU), 0)" ).append("\n"); 
		query.append("                END TTL_CNTR_OBRD_TEU" ).append("\n"); 
		query.append("     FROM (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, NXT_PORT_CD, TTL_CNTR_OBRD_TEU ,'0' AS TTL_CNTR_OBRD_TEU_EP" ).append("\n"); 
		query.append("             FROM FCM_DEP_RPT      " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("           SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, B.VPS_PORT_CD AS NXT_PORT_CD,  TTL_CNTR_OBRD_TEU, TTL_CNTR_OBRD_TEU AS TTL_CNTR_OBRD_TEU_EP" ).append("\n"); 
		query.append("             FROM FCM_DEP_RPT A, ( SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, NXT_PORT_CD" ).append("\n"); 
		query.append("                                     FROM (SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD," ).append("\n"); 
		query.append("                                                  LAG(A.VPS_PORT_CD) OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ORDER BY CLPT_SEQ) AS NXT_PORT_CD" ).append("\n"); 
		query.append("                                             FROM VSK_VSL_PORT_SKD A)" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND NXT_PORT_CD IN ('EGSUZ', 'PAPAC')) B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("              AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND A.SKD_DIR_CD  = B.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND A.NXT_PORT_CD = B.NXT_PORT_CD)" ).append("\n"); 
		query.append("   WHERE  T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("   AND    T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("   AND    T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("   AND    T1.NXT_PORT_CD=NXT_PORT_CD) TTL_CNTR_OBRD_TEU  " ).append("\n"); 
		query.append(", (SELECT     CASE " ).append("\n"); 
		query.append("                WHEN COUNT(*)  = 2  THEN MAX(DEP_CGO_WGT_EP)" ).append("\n"); 
		query.append("                WHEN COUNT(*)  = 1  THEN  MAX(DEP_CGO_WGT)" ).append("\n"); 
		query.append("                ELSE '0'" ).append("\n"); 
		query.append("              END DEP_CGO_WGT  --DECODE(COUNT(*), 1, MAX(DEP_CGO_WGT), 0)" ).append("\n"); 
		query.append("     FROM (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, NXT_PORT_CD, DEP_CGO_WGT ,'0' AS DEP_CGO_WGT_EP" ).append("\n"); 
		query.append("             FROM FCM_DEP_RPT      " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("           SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, B.VPS_PORT_CD AS NXT_PORT_CD, DEP_CGO_WGT, DEP_CGO_WGT AS DEP_CGO_WGT_EP" ).append("\n"); 
		query.append("             FROM FCM_DEP_RPT A, ( SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, NXT_PORT_CD" ).append("\n"); 
		query.append("                                     FROM (SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD," ).append("\n"); 
		query.append("                                                  LAG(A.VPS_PORT_CD) OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ORDER BY CLPT_SEQ) AS NXT_PORT_CD" ).append("\n"); 
		query.append("                                             FROM VSK_VSL_PORT_SKD A)" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND NXT_PORT_CD IN ('EGSUZ', 'PAPAC')) B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("              AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND A.SKD_DIR_CD  = B.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND A.NXT_PORT_CD = B.NXT_PORT_CD)" ).append("\n"); 
		query.append("   WHERE  T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("   AND    T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("   AND    T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("   AND    T1.NXT_PORT_CD=NXT_PORT_CD) DEP_CGO_WGT " ).append("\n"); 
		query.append(", (SELECT  " ).append("\n"); 
		query.append("         CASE " ).append("\n"); 
		query.append("                WHEN COUNT(*)  = 2  THEN MAX(DEP_DPL_WGT_EP)" ).append("\n"); 
		query.append("                WHEN COUNT(*)  = 1  THEN MAX(DEP_DPL_WGT)" ).append("\n"); 
		query.append("                ELSE '0'" ).append("\n"); 
		query.append("              END DEP_DPL_WGT --DECODE(COUNT(*), 1, MAX(DEP_DPL_WGT), 0)" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("         SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, NXT_PORT_CD, DEP_DPL_WGT ,'0' AS DEP_DPL_WGT_EP" ).append("\n"); 
		query.append("             FROM FCM_DEP_RPT      " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("           SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, B.VPS_PORT_CD AS NXT_PORT_CD, DEP_DPL_WGT, DEP_DPL_WGT AS DEP_DPL_WGT_EP" ).append("\n"); 
		query.append("             FROM FCM_DEP_RPT A, ( SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, NXT_PORT_CD" ).append("\n"); 
		query.append("                                     FROM (SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD," ).append("\n"); 
		query.append("                                                  LAG(A.VPS_PORT_CD) OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ORDER BY CLPT_SEQ) AS NXT_PORT_CD" ).append("\n"); 
		query.append("                                             FROM VSK_VSL_PORT_SKD A)" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND NXT_PORT_CD IN ('EGSUZ', 'PAPAC')) B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("              AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND A.SKD_DIR_CD  = B.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND A.NXT_PORT_CD = B.NXT_PORT_CD) C" ).append("\n"); 
		query.append("   WHERE  T1.VSL_CD=C.VSL_CD" ).append("\n"); 
		query.append("   AND    T1.SKD_VOY_NO=C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND    T1.SKD_DIR_CD=C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND    T1.NXT_PORT_CD=C.NXT_PORT_CD) DEP_DPL_WGT   " ).append("\n"); 
		query.append(", WND_DIR_CTNT" ).append("\n"); 
		query.append(", OCN_CRNT_CTNT" ).append("\n"); 
		query.append(", CRS_NO" ).append("\n"); 
		query.append(", DECODE(MN_PWR,NULL,'X',0,'X','Y') LOAD_USE_FLG" ).append("\n"); 
		query.append("FROM FCM_NOON_RPT T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${vsl_slan_cd}!='' && ${vsl_slan_cd}!='A')" ).append("\n"); 
		query.append("AND VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_clss_cd}!='' && ${vsl_clss_cd}!='A')" ).append("\n"); 
		query.append("AND VSL_CD IN (SELECT VSL_CD FROM MDM_VSL_CNTR WHERE CNTR_DZN_CAPA = @[vsl_clss_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_clss_sub_cd}!='') " ).append("\n"); 
		query.append("AND VSL_CD IN (SELECT VSL_CD FROM FCM_VSL_CNTR_RGST WHERE VSL_CLSS_SUB_CD = @[vsl_clss_sub_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_cd}!='' && ${vsl_cd}!='A')" ).append("\n"); 
		query.append("AND VSL_CD=@[vsl_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd}!='' && ${skd_dir_cd}!='A')" ).append("\n"); 
		query.append("AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trnd_line_fm_dt}!='' && ${trnd_line_to_dt}!='')" ).append("\n"); 
		query.append("AND NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT R.VSL_CD FROM FCM_VSL_CNTR_RGST R WHERE T1.VSL_CD = R.VSL_CD AND NVL(R.TRND_LINE_USE_FLG,' ')<>'N')" ).append("\n"); 
		query.append("--AND T1.MN_FOIL_CSM_QTY != '0'" ).append("\n"); 
		query.append("--AND T1.MN_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("AND TO_CHAR(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)) IN ('23','24','25')" ).append("\n"); 
		query.append("AND ((SLP_RT > -16) AND (SLP_RT < 25))--SLP_RT IS NOT NULL 조건 포함" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(WND_SCL_NO,0))<=7" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(SEA_STE_NO,0))<=7" ).append("\n"); 
		query.append("AND T1.ENG_ML_DIST <> '0'" ).append("\n"); 
		query.append("ORDER BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, NOON_RPT_DT" ).append("\n"); 

	}
}