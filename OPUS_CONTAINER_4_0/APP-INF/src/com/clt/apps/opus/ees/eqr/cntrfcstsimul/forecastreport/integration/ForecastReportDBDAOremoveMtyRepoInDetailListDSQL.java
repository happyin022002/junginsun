/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOremoveMtyRepoInDetailListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11 
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

public class ForecastReportDBDAOremoveMtyRepoInDetailListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_BAL_RPT_DCHG_MNL 테이블 정보 삭제
	  * </pre>
	  */
	public ForecastReportDBDAOremoveMtyRepoInDetailListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOremoveMtyRepoInDetailListDSQL").append("\n"); 
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
		query.append("DELETE FROM EQR_CTRL_BAL_RPT_DCHG_MNL " ).append("\n"); 
		query.append("WHERE LOC_CD         = @[to_yd_cd]" ).append("\n"); 
		query.append("AND   ETD_DT         = TO_DATE(@[to_etb_dt_org], 'YYYYMMDD')" ).append("\n"); 
		query.append("AND   RPT_SEQ        = @[rpt_seq]" ).append("\n"); 

	}
}