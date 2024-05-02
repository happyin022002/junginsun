/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastReportDBDAOmodifyMtyRepoOutDetailListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOmodifyMtyRepoOutDetailListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_BAL_RPT_LODG_MNL 데이터 수정
	  * </pre>
	  */
	public ForecastReportDBDAOmodifyMtyRepoOutDetailListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r9_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d7_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_etb_dt_org",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOmodifyMtyRepoOutDetailListUSQL").append("\n"); 
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
		query.append("UPDATE EQR_CTRL_BAL_RPT_LODG_MNL         " ).append("\n"); 
		query.append("   SET ETD_DT         = TO_DATE(REPLACE(@[to_etb_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,VSL_LANE_CD    = @[vsl_lane_cd] " ).append("\n"); 
		query.append("      ,VSL_CD         = @[substr(@[vvd],@[ 0,@[ 4)" ).append("\n"); 
		query.append("      ,SKD_VOY_NO     = @[substr(@[vvd],@[ 5,@[ 4)" ).append("\n"); 
		query.append("      ,SKD_DIR_CD     = @[substr(@[vvd],@[ 9,@[ 1)" ).append("\n"); 
		query.append("      ,D2_FCAST_QTY   = @[d2_fcast_qty]" ).append("\n"); 
		query.append("      ,D4_FCAST_QTY   = @[d4_fcast_qty]" ).append("\n"); 
		query.append("      ,D5_FCAST_QTY   = @[d5_fcast_qty]" ).append("\n"); 
		query.append("      ,D7_FCAST_QTY   = @[d7_fcast_qty]" ).append("\n"); 
		query.append("      ,R2_FCAST_QTY   = @[r2_fcast_qty] " ).append("\n"); 
		query.append("      ,R5_FCAST_QTY   = @[r5_fcast_qty]" ).append("\n"); 
		query.append("      ,R9_FCAST_QTY   = @[r9_fcast_qty]" ).append("\n"); 
		query.append("      ,O2_FCAST_QTY   = @[o2_fcast_qty]" ).append("\n"); 
		query.append("      ,S2_FCAST_QTY   = @[s2_fcast_qty]" ).append("\n"); 
		query.append("      ,O4_FCAST_QTY   = @[o4_fcast_qty]" ).append("\n"); 
		query.append("      ,S4_FCAST_QTY   = @[s4_fcast_qty]" ).append("\n"); 
		query.append("      ,O5_FCAST_QTY   = @[o5_fcast_qty]" ).append("\n"); 
		query.append("      ,F2_FCAST_QTY   = @[f2_fcast_qty]" ).append("\n"); 
		query.append("      ,A2_FCAST_QTY   = @[a2_fcast_qty]" ).append("\n"); 
		query.append("      ,F4_FCAST_QTY   = @[f4_fcast_qty]" ).append("\n"); 
		query.append("      ,A4_FCAST_QTY   = @[a4_fcast_qty]" ).append("\n"); 
		query.append("      ,A5_FCAST_QTY   = @[a5_fcast_qty]" ).append("\n"); 
		query.append("      ,F5_FCAST_QTY   = @[f5_fcast_qty]" ).append("\n"); 
		query.append("      ,DIFF_RMK       = @[remark]" ).append("\n"); 
		query.append("      ,UPD_USR_ID     = @[upd_usr_id]      " ).append("\n"); 
		query.append("      ,UPD_DT         = SYSDATE        " ).append("\n"); 
		query.append(" WHERE LOC_CD         = @[to_yd_cd]" ).append("\n"); 
		query.append(" AND   ETD_DT         = TO_DATE(@[to_etb_dt_org], 'YYYYMMDD')" ).append("\n"); 
		query.append(" AND   RPT_SEQ        = @[rpt_seq]" ).append("\n"); 

	}
}