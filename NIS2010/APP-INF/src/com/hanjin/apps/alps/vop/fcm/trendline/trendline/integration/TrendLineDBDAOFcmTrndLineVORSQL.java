/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrendLineDBDAOFcmTrndLineVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAOFcmTrndLineVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trend Line 정보를 조회합니다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public TrendLineDBDAOFcmTrndLineVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_tp_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnd_line_use_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TrendLineDBDAOFcmTrndLineVORSQL").append("\n"); 
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
		query.append("TRND_LINE_TP_CD," ).append("\n"); 
		query.append("TRND_LINE_SEQ," ).append("\n"); 
		query.append("TRND_LINE_CHT_TP_CD," ).append("\n"); 
		query.append("TRND_LINE_FM_DT," ).append("\n"); 
		query.append("TRND_LINE_TO_DT," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VSL_CLSS_CD," ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("AVG_SLP_RT," ).append("\n"); 
		query.append("AVG_SLP_OPT_RT," ).append("\n"); 
		query.append("APLY_SLP_RT," ).append("\n"); 
		query.append("N1ST_COEF_VAL," ).append("\n"); 
		query.append("N1ST_VAR_DGR_VAL," ).append("\n"); 
		query.append("N2ND_COEF_VAL," ).append("\n"); 
		query.append("N2ND_VAR_DGR_VAL," ).append("\n"); 
		query.append("TRND_LINE_CONS_VAL," ).append("\n"); 
		query.append("COEF_OF_DTMN_VAL," ).append("\n"); 
		query.append("FOML_DESC," ).append("\n"); 
		query.append("AVG_GNR_CSM_WGT," ).append("\n"); 
		query.append("AVG_BLR_CSM_WGT," ).append("\n"); 
		query.append("OP_MAX_SPD," ).append("\n"); 
		query.append("OP_MIN_SPD," ).append("\n"); 
		query.append("TRND_LINE_RMK," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRND_LINE_USE_TP_CD=@[trnd_line_use_tp_cd]" ).append("\n"); 
		query.append("AND TRND_LINE_TP_CD=@[trnd_line_tp_cd]" ).append("\n"); 
		query.append("AND TRND_LINE_TP_SUB_CD=@[trnd_line_tp_sub_cd]" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_clss_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CLSS_CD=@[vsl_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_clss_sub_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CLSS_SUB_CD=@[vsl_clss_sub_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TRND_LINE_SEQ" ).append("\n"); 

	}
}