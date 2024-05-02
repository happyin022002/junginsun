/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOModifyOthersFcastToZeroUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.10.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOModifyOthersFcastToZeroUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [모바일] others fcast 입력시 내부에 존재하는 fcast를 0으로 update (alps는 화면내에서 control함)
	  * </pre>
	  */
	public DailyForecastManageDBDAOModifyOthersFcastToZeroUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOModifyOthersFcastToZeroUSQL").append("\n"); 
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
		query.append("UPDATE SPC_DLY_FCAST_CUST F" ).append("\n"); 
		query.append("      SET FCAST_TTL_QTY       = 0," ).append("\n"); 
		query.append("          FCAST_20FT_QTY      = 0," ).append("\n"); 
		query.append("          FCAST_40FT_QTY      = 0," ).append("\n"); 
		query.append("          FCAST_40FT_HC_QTY   = 0," ).append("\n"); 
		query.append("          FCAST_45FT_HC_QTY   = 0," ).append("\n"); 
		query.append("          FCAST_53FT_QTY      = 0," ).append("\n"); 
		query.append("          FCAST_RF_QTY        = 0," ).append("\n"); 
		query.append("          FCAST_TTL_WGT       = 0," ).append("\n"); 
		query.append("          CFM_TTL_QTY         = 0," ).append("\n"); 
		query.append("          CFM_40FT_HC_QTY     = 0," ).append("\n"); 
		query.append("          CFM_45FT_HC_QTY     = 0," ).append("\n"); 
		query.append("          CFM_53FT_QTY        = 0," ).append("\n"); 
		query.append("          CFM_RF_QTY          = 0," ).append("\n"); 
		query.append("          CFM_TTL_WGT         = 0," ).append("\n"); 
		query.append("          UPD_USR_ID          = @[upd_usr_id]," ).append("\n"); 
		query.append("          MODI_GDT            = CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[modi_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE)," ).append("\n"); 
		query.append("          UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("    WHERE F.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("      AND F.SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("      AND F.RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("      AND F.DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("      AND F.IOC_TS_CD        = @[ioc_ts_cd]" ).append("\n"); 
		query.append("      AND F.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("      AND F.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND F.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("      AND F.POL_YD_CD        = @[pol_yd_cd]" ).append("\n"); 
		query.append("      AND F.POD_YD_CD        = @[pod_yd_cd]" ).append("\n"); 
		query.append("      AND F.SREP_USR_ID      = @[srep_usr_id]" ).append("\n"); 
		query.append("      AND (F.CUST_CNT_CD||F.CUST_SEQ) NOT IN " ).append("\n"); 
		query.append("          (SELECT S.CUST_CNT_CD||S.CUST_SEQ" ).append("\n"); 
		query.append("              FROM SPC_SLS_REP_CUST S" ).append("\n"); 
		query.append("             WHERE S.TRD_CD      = F.TRD_CD" ).append("\n"); 
		query.append("               AND S.SUB_TRD_CD  = F.SUB_TRD_CD" ).append("\n"); 
		query.append("               AND S.SREP_CD     = F.SREP_USR_ID" ).append("\n"); 
		query.append("               AND S.CUST_CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND S.CUST_SEQ    = F.CUST_SEQ" ).append("\n"); 
		query.append("               AND S.DELT_FLG    ='N'" ).append("\n"); 
		query.append("               AND NVL(S.INDIV_CUST_USE_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("      AND F.CUST_CNT_CD||F.CUST_SEQ != 'XX999999'" ).append("\n"); 
		query.append("      AND ( F.FCAST_TTL_QTY        > 0" ).append("\n"); 
		query.append("            OR F.FCAST_20FT_QTY    > 0" ).append("\n"); 
		query.append("            OR F.FCAST_40FT_QTY    > 0" ).append("\n"); 
		query.append("            OR F.FCAST_40FT_HC_QTY > 0" ).append("\n"); 
		query.append("            OR F.FCAST_45FT_HC_QTY > 0" ).append("\n"); 
		query.append("            OR F.FCAST_53FT_QTY    > 0" ).append("\n"); 
		query.append("            OR F.FCAST_RF_QTY      > 0" ).append("\n"); 
		query.append("            OR F.FCAST_TTL_WGT     > 0" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}