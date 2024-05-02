/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KpiTargetDBDAOMultiSpeGrpKpiTargetCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 노영현
*@LastVersion : 1.0
* 2015.02.10 노영현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author N.Y.H
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KpiTargetDBDAOMultiSpeGrpKpiTargetCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public KpiTargetDBDAOMultiSpeGrpKpiTargetCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kpi_wgt_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kpi_tgt_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.integration").append("\n"); 
		query.append("FileName : KpiTargetDBDAOMultiSpeGrpKpiTargetCSQL").append("\n"); 
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
		query.append("INSERT INTO spe_ev_grp_kpi_perf_tgt" ).append("\n"); 
		query.append("		             ( EV_YR" ).append("\n"); 
		query.append("		             , EG_ID" ).append("\n"); 
		query.append("		             , SP_KPI_ID" ).append("\n"); 
		query.append("		             , KPI_TGT_RTO" ).append("\n"); 
		query.append("		             , KPI_WGT_RTO" ).append("\n"); 
		query.append("		             , CRE_USR_ID" ).append("\n"); 
		query.append("		             , CRE_DT" ).append("\n"); 
		query.append("		             , UPD_USR_ID" ).append("\n"); 
		query.append("		             , UPD_DT" ).append("\n"); 
		query.append("		             )" ).append("\n"); 
		query.append("VALUES (    @[ev_yr]" ).append("\n"); 
		query.append("           , @[eg_id]" ).append("\n"); 
		query.append("           , @[sp_kpi_id]" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           ,  @[kpi_tgt_rto]" ).append("\n"); 
		query.append("           ,  @[kpi_wgt_rto]" ).append("\n"); 
		query.append("           ,  @[cre_usr_id] 				        -- CRE_USR_ID" ).append("\n"); 
		query.append("           , SYSDATE 			                    -- CRE_DT" ).append("\n"); 
		query.append("           ,  @[upd_usr_id] 				        -- UPD_USR_ID" ).append("\n"); 
		query.append("           , SYSDATE 			                    -- UPD_DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}