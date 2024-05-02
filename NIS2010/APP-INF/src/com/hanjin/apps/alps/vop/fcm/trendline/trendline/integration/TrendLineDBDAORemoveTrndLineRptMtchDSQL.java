/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineDBDAORemoveTrndLineRptMtchDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.21
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.21 진마리아
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

public class TrendLineDBDAORemoveTrndLineRptMtchDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제할 Trnd Line의 rpt mtch 정보를 삭제합니다.
	  * </pre>
	  */
	public TrendLineDBDAORemoveTrndLineRptMtchDSQL(){
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
		query.append("FileName : TrendLineDBDAORemoveTrndLineRptMtchDSQL").append("\n"); 
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
		query.append("DELETE FROM FCM_TRND_LINE_RPT_MTCH" ).append("\n"); 
		query.append("WHERE TRND_LINE_SEQ IN ( SELECT T.TRND_LINE_SEQ" ).append("\n"); 
		query.append("                         FROM FCM_TRND_LINE T" ).append("\n"); 
		query.append("                         WHERE T.TRND_LINE_USE_TP_CD=@[trnd_line_use_tp_cd]" ).append("\n"); 
		query.append("                         AND T.TRND_LINE_TP_CD=@[trnd_line_tp_cd]" ).append("\n"); 
		query.append("                         AND T.TRND_LINE_TP_SUB_CD=@[trnd_line_tp_sub_cd]" ).append("\n"); 
		query.append("                         #if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("                         AND T.VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${vsl_clss_cd} != '')" ).append("\n"); 
		query.append("                         AND T.VSL_CLSS_CD=@[vsl_clss_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${vsl_clss_sub_cd} != '')" ).append("\n"); 
		query.append("                         AND T.VSL_CLSS_SUB_CD=@[vsl_clss_sub_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                         AND T.VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                         AND T.SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${trnd_line_fm_dt} != '')" ).append("\n"); 
		query.append("                         AND T.TRND_LINE_FM_DT=REPLACE(@[trnd_line_fm_dt],'-','')" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${trnd_line_to_dt} != '')" ).append("\n"); 
		query.append("                         AND T.TRND_LINE_TO_DT=REPLACE(@[trnd_line_to_dt],'-','')" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 

	}
}