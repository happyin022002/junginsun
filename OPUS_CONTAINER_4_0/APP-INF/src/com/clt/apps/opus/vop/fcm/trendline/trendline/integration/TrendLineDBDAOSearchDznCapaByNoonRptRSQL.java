/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrendLineDBDAOSearchDznCapaByNoonRptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.12 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAOSearchDznCapaByNoonRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 기간의 Noon Rpt에 존재하는 Vesse의 Capa을 조회한다.
	  * </pre>
	  */
	public TrendLineDBDAOSearchDznCapaByNoonRptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAOSearchDznCapaByNoonRptRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT M.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("FROM FCM_NOON_RPT T1, MDM_VSL_CNTR M" ).append("\n"); 
		query.append("WHERE T1.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("#if (${trnd_line_fm_dt} != '' && ${trnd_line_to_dt} != '') " ).append("\n"); 
		query.append("AND T1.NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_clss_sub_cd} != '')" ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT VSL_CD FROM FCM_VSL_CNTR_RGST WHERE VSL_CLSS_SUB_CD=@[vsl_clss_sub_cd] AND NVL(TRND_LINE_USE_FLG,'X')<>'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '' && ${vsl_slan_cd} != 'A')" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND T1.VSL_CD IN (SELECT R.VSL_CD FROM FCM_VSL_CNTR_RGST R WHERE T1.VSL_CD = R.VSL_CD AND NVL(R.TRND_LINE_USE_FLG,' ')<>'N')" ).append("\n"); 
		query.append("AND T1.MN_FOIL_CSM_QTY != '0'" ).append("\n"); 
		query.append("AND T1.MN_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("AND TO_CHAR(TO_NUMBER(SUBSTR(T1.SAIL_HRMNT, 1, 2))+(TO_NUMBER(SUBSTR(T1.SAIL_HRMNT, 3, 2))/60)) IN ('23','24','25')" ).append("\n"); 
		query.append("AND ((T1.SLP_RT > -16) AND (T1.SLP_RT < 25))" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(T1.WND_SCL_NO,0))<=7" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(T1.SEA_STE_NO,0))<=7" ).append("\n"); 
		query.append("AND T1.ENG_ML_DIST <> '0'" ).append("\n"); 
		query.append("AND CNTR_DZN_CAPA IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY M.CNTR_DZN_CAPA" ).append("\n"); 

	}
}