/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrendLineDBDAOAddTrndLineRptMtchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.10 진마리아
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

public class TrendLineDBDAOAddTrndLineRptMtchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trnd Line Rpt Mtch 정보(xcld 데이터 생성)를 생성합니다.
	  * </pre>
	  */
	public TrendLineDBDAOAddTrndLineRptMtchCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_xcld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("noon_rpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_incl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAOAddTrndLineRptMtchCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_TRND_LINE_RPT_MTCH (" ).append("\n"); 
		query.append("    RPT_MTCH_SEQ," ).append("\n"); 
		query.append("    TRND_LINE_SEQ," ).append("\n"); 
		query.append("    VSL_CD," ).append("\n"); 
		query.append("    SKD_VOY_NO," ).append("\n"); 
		query.append("    SKD_DIR_CD," ).append("\n"); 
		query.append("    NOON_RPT_DT," ).append("\n"); 
		query.append("    TRND_LINE_XCLD_FLG," ).append("\n"); 
		query.append("    TRND_LINE_INCL_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("    (SELECT NVL(MAX(RPT_MTCH_SEQ),0)+1 FROM FCM_TRND_LINE_RPT_MTCH)," ).append("\n"); 
		query.append("    (SELECT MAX(TRND_LINE_SEQ) FROM FCM_TRND_LINE)," ).append("\n"); 
		query.append("    @[vsl_cd]," ).append("\n"); 
		query.append("    @[skd_voy_no]," ).append("\n"); 
		query.append("    @[skd_dir_cd]," ).append("\n"); 
		query.append("    TO_DATE(@[noon_rpt_dt],'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("    @[trnd_line_xcld_flg]," ).append("\n"); 
		query.append("    @[trnd_line_incl_flg]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}