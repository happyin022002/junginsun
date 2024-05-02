/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrendLineDBDAOSearchAverageSlpValRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.20 
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

public class TrendLineDBDAOSearchAverageSlpValRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건에 맞는 데이터의 AVRRAGE SLIP을 구한다.
	  * CHM-201430214 : Trend line 생성시 Noon Report 호출 로직 변경
	  * - MN_FOIL_CSM_QTY(MAIN FUEL OIL CONSUMPTION QUANTITY )  값이 0이 아니거나, NULL이 아닌값에 대한 조회 로직건  제거
	  * </pre>
	  */
	public TrendLineDBDAOSearchAverageSlpValRSQL(){
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
		query.append("FileName : TrendLineDBDAOSearchAverageSlpValRSQL").append("\n"); 
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
		query.append("SELECT ROUND(AVG(NVL(SLP_RT, 0)),4) AVG_SLP_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.NOON_RPT_DT, T1.SLP_RT," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(TRND_LINE_XCLD_FLG),0,'N','Y')" ).append("\n"); 
		query.append("          FROM FCM_TRND_LINE_RPT_MTCH" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND NOON_RPT_DT = T1.NOON_RPT_DT" ).append("\n"); 
		query.append("           AND TRND_LINE_XCLD_FLG='Y'" ).append("\n"); 
		query.append("       ) TRND_LINE_XCLD_FLG" ).append("\n"); 
		query.append("FROM FCM_NOON_RPT T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${vsl_slan_cd}!='' && ${vsl_slan_cd}!='A')" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_clss_cd}!='' && ${vsl_clss_cd}!='A')" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT VSL_CD FROM MDM_VSL_CNTR WHERE CNTR_DZN_CAPA = @[vsl_clss_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_clss_sub_cd}!='')" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT VSL_CD FROM FCM_VSL_CNTR_RGST WHERE VSL_CLSS_SUB_CD = @[vsl_clss_sub_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_cd}!='' && ${vsl_cd}!='A')" ).append("\n"); 
		query.append("AND T1.VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd}!='' && ${skd_dir_cd}!='A')" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT R.VSL_CD FROM FCM_VSL_CNTR_RGST R WHERE T1.VSL_CD = R.VSL_CD AND NVL(R.TRND_LINE_USE_FLG,' ')<>'N')" ).append("\n"); 
		query.append("--AND T1.MN_FOIL_CSM_QTY != '0'" ).append("\n"); 
		query.append("--AND T1.MN_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("AND TO_CHAR(TO_NUMBER(SUBSTR(SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(SAIL_HRMNT, 3, 2))/60)) IN ('23','24','25')" ).append("\n"); 
		query.append("AND ((T1.SLP_RT > -16) AND (T1.SLP_RT < 25))--SLP_RT IS NOT NULL 조건 포함" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(WND_SCL_NO,0))<=7" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(SEA_STE_NO,0))<=7" ).append("\n"); 
		query.append("AND T1.ENG_ML_DIST <> '0'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE TRND_LINE_XCLD_FLG='N'" ).append("\n"); 

	}
}