/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIPerformanceDBDAOAddKpiPerformanceCfmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.03 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KPIPerformanceDBDAOAddKpiPerformanceCfmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KPI Performance Confirm 을 저장한다.
	  * </pre>
	  */
	public KPIPerformanceDBDAOAddKpiPerformanceCfmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jul_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sep_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feb_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_kpi_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jun_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dec_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mar_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aug_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_scre_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nov_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("may_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jan_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oct_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration").append("\n"); 
		query.append("FileName : KPIPerformanceDBDAOAddKpiPerformanceCfmCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_EV_GRP_KPI_PERF(EV_YR" ).append("\n"); 
		query.append("                              , EG_ID" ).append("\n"); 
		query.append("                              , SP_KPI_ID" ).append("\n"); 
		query.append("                              , SP_SEQ" ).append("\n"); 
		query.append("                              , JAN_RTO" ).append("\n"); 
		query.append("                              , FEB_RTO" ).append("\n"); 
		query.append("                              , MAR_RTO" ).append("\n"); 
		query.append("                              , APR_RTO" ).append("\n"); 
		query.append("                              , MAY_RTO" ).append("\n"); 
		query.append("                              , JUN_RTO" ).append("\n"); 
		query.append("                              , JUL_RTO" ).append("\n"); 
		query.append("                              , AUG_RTO" ).append("\n"); 
		query.append("                              , SEP_RTO" ).append("\n"); 
		query.append("                              , OCT_RTO" ).append("\n"); 
		query.append("                              , NOV_RTO" ).append("\n"); 
		query.append("                              , DEC_RTO" ).append("\n"); 
		query.append("                              , RSLT_SCRE_RTO" ).append("\n"); 
		query.append("                              , CRE_USR_ID" ).append("\n"); 
		query.append("                              , CRE_DT" ).append("\n"); 
		query.append("                              , UPD_USR_ID" ).append("\n"); 
		query.append("                              , UPD_DT" ).append("\n"); 
		query.append("                              )VALUES(" ).append("\n"); 
		query.append("                                @[ev_yr]" ).append("\n"); 
		query.append("                              , @[eg_id]" ).append("\n"); 
		query.append("                              , @[sp_kpi_id]" ).append("\n"); 
		query.append("                              , @[sp_seq]" ).append("\n"); 
		query.append("                              , @[jan_rto]" ).append("\n"); 
		query.append("                              , @[feb_rto]" ).append("\n"); 
		query.append("                              , @[mar_rto]" ).append("\n"); 
		query.append("                              , @[apr_rto]" ).append("\n"); 
		query.append("                              , @[may_rto]" ).append("\n"); 
		query.append("                              , @[jun_rto]" ).append("\n"); 
		query.append("                              , @[jul_rto]" ).append("\n"); 
		query.append("                              , @[aug_rto]" ).append("\n"); 
		query.append("                              , @[sep_rto]" ).append("\n"); 
		query.append("                              , @[oct_rto]" ).append("\n"); 
		query.append("                              , @[nov_rto]" ).append("\n"); 
		query.append("                              , @[dec_rto]" ).append("\n"); 
		query.append("                              , @[rslt_scre_rto]" ).append("\n"); 
		query.append("                              , @[cre_usr_id]" ).append("\n"); 
		query.append("                              , SYSDATE" ).append("\n"); 
		query.append("                              , @[cre_usr_id]" ).append("\n"); 
		query.append("                              , SYSDATE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 

	}
}