/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOaddMtyWeeklySimulationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOaddMtyWeeklySimulationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Weekly simulation 신규 사항을 저장
	  * </pre>
	  */
	public ForecastReportDBDAOaddMtyWeeklySimulationCSQL(){
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
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOaddMtyWeeklySimulationCSQL").append("\n"); 
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
		query.append("--  1.정의     : EQR_CTRL_MTY_WKY_SIM 삭제쿼리" ).append("\n"); 
		query.append("--  2.사전점검 : 중복데이터 존재하는지 확인        " ).append("\n"); 
		query.append("--  3.변수" ).append("\n"); 
		query.append("--    :loc_grp_cd" ).append("\n"); 
		query.append("--    :loc_cd" ).append("\n"); 
		query.append("--    :week" ).append("\n"); 
		query.append("--    :sim_tp_cd" ).append("\n"); 
		query.append("--    :cntr_tpsz" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("--RI : Reposition In  COD에서 추출된 Repostion In  " ).append("\n"); 
		query.append("--OT : Other(LT/ST/OW)  Balance Report 에서 추출된 Other Value(LT/ST/OW) " ).append("\n"); 
		query.append("--IF : IB Forecast  Balance Report 에서 추출된 IB Forecast  " ).append("\n"); 
		query.append("--OF : OB Forecast  Balance Report 에서 추출된 OB Forecast " ).append("\n"); 
		query.append("--RO : Reposition Out  Balance Report 에서 추출된 Reposition Out " ).append("\n"); 
		query.append("l    " ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO EQR_CTRL_MTY_WKY_SIM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" FCAST_YRWK" ).append("\n"); 
		query.append(",LOC_GRP_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",WKY_SIM_TP_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNTR_QTY" ).append("\n"); 
		query.append(",TMP_SAV_FLG" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" @[week]" ).append("\n"); 
		query.append(",@[loc_grp_cd]" ).append("\n"); 
		query.append(",@[loc_cd]" ).append("\n"); 
		query.append(",@[sim_tp_cd]" ).append("\n"); 
		query.append(",UPPER(@[cntr_tpsz])" ).append("\n"); 
		query.append(",@[cntr_qty]" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}