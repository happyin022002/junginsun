/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOAddDashboardReportSettingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DashboardDBDAOAddDashboardReportSettingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트 세팅 값이 저장 요청 되면, 저장한다.
	  * </pre>
	  */
	public DashboardDBDAOAddDashboardReportSettingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("green_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yellow_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yellow_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dbd_irr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("green_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("red_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("red_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOAddDashboardReportSettingCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DBD_SET" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	    DBD_SET_SEQ" ).append("\n"); 
		query.append("	,   DBD_IRR_TP_CD" ).append("\n"); 
		query.append("	,   BKG_DBD_SET_TP_CD" ).append("\n"); 
		query.append("	,   LMT_STEP_NO" ).append("\n"); 
		query.append("	,   FM_VAL" ).append("\n"); 
		query.append("	,   TO_VAL" ).append("\n"); 
		query.append("	,   CRE_DT" ).append("\n"); 
		query.append("	,   CRE_USR_ID" ).append("\n"); 
		query.append("	,   UPD_DT" ).append("\n"); 
		query.append("	,   UPD_USR_ID" ).append("\n"); 
		query.append("	,   BKG_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("   		 BKG_DBD_SET_SEQ1.NEXTVAL DBD_SET_SEQ" ).append("\n"); 
		query.append("	,   @[dbd_irr_tp_cd] DBD_IRR_TP_CD" ).append("\n"); 
		query.append("	,   'U' BKG_DBD_SET_TP_CD" ).append("\n"); 
		query.append("	,   LMT_STEP_NO" ).append("\n"); 
		query.append("	,   FM_VAL" ).append("\n"); 
		query.append("	,   TO_VAL" ).append("\n"); 
		query.append("	,   SYSDATE CRE_DT" ).append("\n"); 
		query.append("	,   @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,   SYSDATE UPD_DT" ).append("\n"); 
		query.append("	,   @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,   @[bkg_ofc_cd] BKG_OFC_CD" ).append("\n"); 
		query.append("	FROM DUAL, " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("    		'1'  LMT_STEP_NO" ).append("\n"); 
		query.append("			,   @[green_fr] FM_VAL" ).append("\n"); 
		query.append("			,   @[green_to] TO_VAL" ).append("\n"); 
		query.append("			FROM DUAL " ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("			'2'  LMT_STEP_NO" ).append("\n"); 
		query.append("			,   @[yellow_fr] FM_VAL" ).append("\n"); 
		query.append("			,   @[yellow_to] TO_VAL" ).append("\n"); 
		query.append("			FROM DUAL " ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("    		'3'  LMT_STEP_NO" ).append("\n"); 
		query.append("			,   @[red_fr] FM_VAL" ).append("\n"); 
		query.append("			,   @[red_to] TO_VAL" ).append("\n"); 
		query.append("			FROM DUAL" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}