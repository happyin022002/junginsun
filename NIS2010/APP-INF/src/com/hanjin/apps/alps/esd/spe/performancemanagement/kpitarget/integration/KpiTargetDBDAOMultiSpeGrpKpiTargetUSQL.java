/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KpiTargetDBDAOMultiSpeGrpKpiTargetUSQL.java
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

public class KpiTargetDBDAOMultiSpeGrpKpiTargetUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public KpiTargetDBDAOMultiSpeGrpKpiTargetUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : KpiTargetDBDAOMultiSpeGrpKpiTargetUSQL").append("\n"); 
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
		query.append("MERGE INTO spe_ev_grp_kpi_perf_tgt A" ).append("\n"); 
		query.append("USING DUAL ON (    A.EV_YR 		= @[ev_yr]" ).append("\n"); 
		query.append("               AND A.EG_ID 		= @[eg_id]" ).append("\n"); 
		query.append("			   AND A.SP_KPI_ID	= @[sp_kpi_id]" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET " ).append("\n"); 
		query.append("             A.KPI_TGT_RTO   = @[kpi_tgt_rto]                                               " ).append("\n"); 
		query.append("            ,A.KPI_WGT_RTO   = @[kpi_wgt_rto]                    " ).append("\n"); 
		query.append("            ,A.UPD_USR_ID            = @[cre_usr_id]                 " ).append("\n"); 
		query.append("            ,A.UPD_DT                = SYSDATE     " ).append("\n"); 
		query.append("     WHERE  1=1" ).append("\n"); 
		query.append("     AND A.EV_YR 		= @[ev_yr]" ).append("\n"); 
		query.append("     AND A.EG_ID 		= @[eg_id]" ).append("\n"); 
		query.append("	 AND A.SP_KPI_ID	= @[sp_kpi_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (A.EV_YR" ).append("\n"); 
		query.append("            ,A.EG_ID" ).append("\n"); 
		query.append("            ,A.SP_KPI_ID" ).append("\n"); 
		query.append("            ,A.KPI_TGT_RTO" ).append("\n"); 
		query.append("            ,A.KPI_WGT_RTO            " ).append("\n"); 
		query.append("            ,A.CRE_USR_ID" ).append("\n"); 
		query.append("            ,A.CRE_DT" ).append("\n"); 
		query.append("            ,A.UPD_USR_ID" ).append("\n"); 
		query.append("            ,A.UPD_DT)" ).append("\n"); 
		query.append("     VALUES (@[ev_yr]                 " ).append("\n"); 
		query.append("            ,@[eg_id]               " ).append("\n"); 
		query.append("            ,@[sp_kpi_id]        " ).append("\n"); 
		query.append("            ,@[kpi_tgt_rto]                 " ).append("\n"); 
		query.append("            ,@[kpi_wgt_rto]          " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                 " ).append("\n"); 
		query.append("            ,SYSDATE                     " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                 " ).append("\n"); 
		query.append("            ,SYSDATE                       " ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}