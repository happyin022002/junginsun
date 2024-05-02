/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOremovePlannedRepoInManualQtyDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.26
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.07.26 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOremovePlannedRepoInManualQtyDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INTO EQR_CTRL_PLN_REPO_IN_QTY 에 Planned Repo In Manual 데이터 삭제
	  * </pre>
	  */
	public ForecastReportDBDAOremovePlannedRepoInManualQtyDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pln_repo_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOremovePlannedRepoInManualQtyDSQL").append("\n"); 
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
		query.append("-- EQR_CTRL_PLN_REPO_IN_QTY 삭제                            " ).append("\n"); 
		query.append("                                                     " ).append("\n"); 
		query.append("DELETE EQR_CTRL_PLN_REPO_IN_QTY                          " ).append("\n"); 
		query.append(" WHERE FCAST_YRWK      = @[fcast_yrwk]               " ).append("\n"); 
		query.append("   AND VSL_CD          = @[vsl_cd]                   " ).append("\n"); 
		query.append("   AND SKD_VOY_NO      = @[skd_voy_no]               " ).append("\n"); 
		query.append("   AND SKD_DIR_CD      = @[skd_dir_cd]               " ).append("\n"); 
		query.append("   AND PLN_REPO_STS_CD = @[pln_repo_sts_cd]          " ).append("\n"); 
		query.append("   AND POD_YD_CD       = @[pod_yd_cd]                " ).append("\n"); 
		query.append("   AND TO_CHAR(TO_ETB_DT,'YYYY-MM-DD') = @[to_etb_dt]" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD = DECODE(@[cntr_tpsz_cd],'',CNTR_TPSZ_CD,@[cntr_tpsz_cd]) -- tpsz 없으면, 모든 tpsz 한번에 delete" ).append("\n"); 

	}
}