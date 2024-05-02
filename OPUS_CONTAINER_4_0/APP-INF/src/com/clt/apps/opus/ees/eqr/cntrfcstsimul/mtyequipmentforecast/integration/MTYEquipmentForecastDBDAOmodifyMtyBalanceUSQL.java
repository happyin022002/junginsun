/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOmodifyMtyBalanceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOmodifyMtyBalanceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 수정
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOmodifyMtyBalanceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fcast_yrwk0",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("r9_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d7_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inp_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("o2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOmodifyMtyBalanceUSQL").append("\n"); 
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
		query.append("UPDATE EQR_CTRL_MTY_BAL_RPT SET  " ).append("\n"); 
		query.append("    D2_FCAST_QTY   = @[d2_fcast_qty]" ).append("\n"); 
		query.append("    ,D4_FCAST_QTY   = @[d4_fcast_qty]" ).append("\n"); 
		query.append("    ,D5_FCAST_QTY   = @[d5_fcast_qty]" ).append("\n"); 
		query.append("    ,D7_FCAST_QTY   = @[d7_fcast_qty]" ).append("\n"); 
		query.append("    ,R2_FCAST_QTY   = @[r2_fcast_qty]" ).append("\n"); 
		query.append("    ,R5_FCAST_QTY   = @[r5_fcast_qty]" ).append("\n"); 
		query.append("    ,R9_FCAST_QTY   = @[r9_fcast_qty]" ).append("\n"); 
		query.append("    ,O2_FCAST_QTY   = @[o2_fcast_qty]" ).append("\n"); 
		query.append("    ,S2_FCAST_QTY   = @[s2_fcast_qty]" ).append("\n"); 
		query.append("    ,O4_FCAST_QTY   = @[o4_fcast_qty]" ).append("\n"); 
		query.append("    ,S4_FCAST_QTY   = @[s4_fcast_qty]" ).append("\n"); 
		query.append("    ,F2_FCAST_QTY   = @[f2_fcast_qty]" ).append("\n"); 
		query.append("    ,A2_FCAST_QTY   = @[a2_fcast_qty]" ).append("\n"); 
		query.append("    ,F4_FCAST_QTY   = @[f4_fcast_qty]" ).append("\n"); 
		query.append("    ,A4_FCAST_QTY   = @[a4_fcast_qty]" ).append("\n"); 
		query.append("    ,F5_FCAST_QTY   = @[f5_fcast_qty]" ).append("\n"); 
		query.append("    ,O5_FCAST_QTY   = @[o5_fcast_qty]" ).append("\n"); 
		query.append("    ,UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE CO_CD =  'H'" ).append("\n"); 
		query.append("AND LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND INP_YRWK = @[inp_yrwk]" ).append("\n"); 
		query.append("AND FCAST_YRWK = @[fcast_yrwk0]" ).append("\n"); 
		query.append("AND MTY_BAL_TP_CD = @[tp_cd]" ).append("\n"); 
		query.append("AND LOC_GRP_CD = @[loc_grp_cd]" ).append("\n"); 

	}
}