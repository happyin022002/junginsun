/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.06 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpeEvGrpKpiTgtRtoVOUSQL.Query
	  * </pre>
	  */
	public EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_perf_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sp_kpi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_wgt_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_tgt_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoUSQL").append("\n"); 
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
		query.append("UPDATE SPE_EV_GRP_KPI_TGT_RTO SET" ).append("\n"); 
		query.append("KPI_UT_CD = @[kpi_ut_cd]" ).append("\n"); 
		query.append(",	KPI_TGT_RTO = @[kpi_tgt_rto]" ).append("\n"); 
		query.append(",	KPI_WGT_RTO = @[kpi_wgt_rto]" ).append("\n"); 
		query.append(",	KPI_PERF_RTO = @[kpi_perf_rto]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT =SYSDATE" ).append("\n"); 
		query.append("WHERE	EG_ID = substr(@[eg_id],1,5)" ).append("\n"); 
		query.append("AND	EG_ID_SEQ = TO_NUMBER(substr(@[eg_id],7,3))" ).append("\n"); 
		query.append("AND	SP_KPI_CD = @[sp_kpi_cd]" ).append("\n"); 
		query.append("AND	EV_YR = @[ev_yr]" ).append("\n"); 

	}
}