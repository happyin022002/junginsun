/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrendLineDBDAOFcmNoonRptVOByMatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.02
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2012.07.02 이혜민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAOFcmNoonRptVOByMatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trend Line 과 관련있는 Noon Report Matching 정보를 조회한다.
	  * 
	  * History
	  * 2012.07.02 이혜민    CHM-201218617-01 [FCM] FO 값을 MN_FOIL_CSM_QT + MN_LOW_SULP_FOIL_CSM_QTY 합으로 수정.
	  * </pre>
	  */
	public TrendLineDBDAOFcmNoonRptVOByMatchRSQL(){
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
		params.put("aply_slp_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAOFcmNoonRptVOByMatchRSQL").append("\n"); 
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
		query.append("#if(${trnd_line_cht_tp_cd}=='01')" ).append("\n"); 
		query.append("ROUND( ((ENG_ML_DIST/" ).append("\n"); 
		query.append("(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)) --HH24MI 형식을 HOUR로 변환" ).append("\n"); 
		query.append(")*(100-TO_NUMBER(@[aply_slp_rt]))" ).append("\n"); 
		query.append(")/100 ,1) CALC_SPD" ).append("\n"); 
		query.append(",ROUND(((TO_NUMBER(NVL(MN_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(MN_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)))*24,1) MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("#elseif(${trnd_line_cht_tp_cd}=='02')" ).append("\n"); 
		query.append("SAIL_AVG_SPD" ).append("\n"); 
		query.append(",ROUND(((TO_NUMBER(NVL(MN_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(MN_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)))*24,1) MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("#elseif(${trnd_line_cht_tp_cd}=='03')" ).append("\n"); 
		query.append("SAIL_AVG_RPM_PWR" ).append("\n"); 
		query.append(",ROUND( ((ENG_ML_DIST/" ).append("\n"); 
		query.append("(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)) --HH24MI 형식을 HOUR로 변환" ).append("\n"); 
		query.append(")*(100-TO_NUMBER(@[aply_slp_rt]))" ).append("\n"); 
		query.append(")/100 ,1) CALC_SPD" ).append("\n"); 
		query.append("#elseif(${trnd_line_cht_tp_cd}=='04')" ).append("\n"); 
		query.append("SAIL_AVG_RPM_PWR" ).append("\n"); 
		query.append(",ROUND(((TO_NUMBER(NVL(MN_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(MN_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)))*24,1) MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("#elseif(${trnd_line_cht_tp_cd}=='05')" ).append("\n"); 
		query.append("TO_NUMBER(MN_PWR)/68640*100 LOAD" ).append("\n"); 
		query.append(",ROUND(((TO_NUMBER(NVL(MN_FOIL_CSM_QTY,0)) + TO_NUMBER(NVL(MN_LOW_SULP_FOIL_CSM_QTY,0)))/(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)))*24,1) MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("#elseif(${trnd_line_cht_tp_cd}=='06')" ).append("\n"); 
		query.append("TO_NUMBER(MN_PWR)/68640*100 LOAD" ).append("\n"); 
		query.append(",SAIL_AVG_SPD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("T1.*" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM FCM_NOON_RPT T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${vsl_slan_cd}!='' && ${vsl_slan_cd}!='A')" ).append("\n"); 
		query.append("AND VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_clss_cd}!='')" ).append("\n"); 
		query.append("AND VSL_CD IN (SELECT VSL_CD FROM MDM_VSL_CNTR WHERE CNTR_DZN_CAPA = @[vsl_clss_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_clss_sub_cd}!='')" ).append("\n"); 
		query.append("AND VSL_CD IN (SELECT VSL_CD FROM FCM_VSL_CNTR_RGST WHERE VSL_CLSS_SUB_CD = @[vsl_clss_sub_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_cd}!='')" ).append("\n"); 
		query.append("AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd}!='' && ${skd_dir_cd}!='A')" ).append("\n"); 
		query.append("AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trnd_line_fm_dt}!='' && ${trnd_line_to_dt}!='')" ).append("\n"); 
		query.append("AND NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT R.VSL_CD FROM FCM_VSL_CNTR_RGST R WHERE T1.VSL_CD = R.VSL_CD AND NVL(R.TRND_LINE_USE_FLG,' ')<>'N')" ).append("\n"); 
		query.append("AND T1.MN_FOIL_CSM_QTY != '0'" ).append("\n"); 
		query.append("AND T1.MN_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("AND TO_CHAR(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)) IN ('23','24','25')" ).append("\n"); 
		query.append("AND ((SLP_RT > -16) AND (SLP_RT < 25))--SLP_RT IS NOT NULL 조건 포함" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(WND_SCL_NO,0))<=7" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(SEA_STE_NO,0))<=7" ).append("\n"); 
		query.append("AND T1.ENG_ML_DIST <> '0'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' FROM FCM_TRND_LINE_RPT_MTCH" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD=VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO=SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD=SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.NOON_RPT_DT=NOON_RPT_DT" ).append("\n"); 
		query.append("#if(${trnd_line_seq}!='')" ).append("\n"); 
		query.append("AND TRND_LINE_SEQ=@[trnd_line_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRND_LINE_XCLD_FLG='Y')" ).append("\n"); 

	}
}