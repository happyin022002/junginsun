/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MTYWeeklySimulationDBDAOmodifyMtyWeeklySimulationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.09.14 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYWeeklySimulationDBDAOmodifyMtyWeeklySimulationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Weekly simulation 내용을 수정
	  * </pre>
	  */
	public MTYWeeklySimulationDBDAOmodifyMtyWeeklySimulationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.integration").append("\n"); 
		query.append("FileName : MTYWeeklySimulationDBDAOmodifyMtyWeeklySimulationUSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("--  1.정의 : EQR_MTY_WKY_SIM 수정쿼리" ).append("\n"); 
		query.append("--  2.변수" ).append("\n"); 
		query.append("--    :loc_grp_cd" ).append("\n"); 
		query.append("--    :loc_cd" ).append("\n"); 
		query.append("--    :week" ).append("\n"); 
		query.append("--    :sim_tp_cd" ).append("\n"); 
		query.append("--    :cntr_tpsz" ).append("\n"); 
		query.append("--    :cntr_qty" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("--RI : Reposition In  COD에서 추출된 Repostion In  " ).append("\n"); 
		query.append("--OT : Other(LT/ST/OW)  Balance Report 에서 추출된 Other Value(LT/ST/OW) " ).append("\n"); 
		query.append("--IF : IB Forecast  Balance Report 에서 추출된 IB Forecast  " ).append("\n"); 
		query.append("--OF : OB Forecast  Balance Report 에서 추출된 OB Forecast " ).append("\n"); 
		query.append("--RO : Reposition Out  Balance Report 에서 추출된 Reposition Out " ).append("\n"); 
		query.append("l    " ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE EQR_MTY_WKY_SIM" ).append("\n"); 
		query.append("SET CNTR_QTY = @[cntr_qty]" ).append("\n"); 
		query.append("   ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE FCAST_YRWK    = @[week]" ).append("\n"); 
		query.append("AND   LOC_GRP_CD    = @[loc_grp_cd]" ).append("\n"); 
		query.append("AND   LOC_CD        = @[loc_cd]" ).append("\n"); 
		query.append("AND   WKY_SIM_TP_CD = @[sim_tp_cd]" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD  = UPPER(@[cntr_tpsz])" ).append("\n"); 

	}
}