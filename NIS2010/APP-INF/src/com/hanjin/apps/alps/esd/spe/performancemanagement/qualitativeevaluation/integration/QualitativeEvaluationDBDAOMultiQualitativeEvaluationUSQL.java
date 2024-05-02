/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationDBDAOMultiQualitativeEvaluationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.02 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationDBDAOMultiQualitativeEvaluationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public QualitativeEvaluationDBDAOMultiQualitativeEvaluationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_grd_chk_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_wgt_rslt_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qual_ev_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationDBDAOMultiQualitativeEvaluationUSQL").append("\n"); 
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
		query.append("UPDATE SPE_SP_QUAL_EV" ).append("\n"); 
		query.append("   SET EV_GRD_CHK_CD   = @[ev_grd_chk_cd]                                               " ).append("\n"); 
		query.append("     , EV_WGT_RSLT_RT  = @[ev_wgt_rslt_rt]        " ).append("\n"); 
		query.append("     , UPD_USR_ID      = @[cre_usr_id]                 " ).append("\n"); 
		query.append("     , UPD_DT          = SYSDATE     " ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND EV_YR 		  = @[ev_yr]" ).append("\n"); 
		query.append("AND EV_MON		  = @[ev_mon]" ).append("\n"); 
		query.append("AND EG_ID 		  = @[eg_id]" ).append("\n"); 
		query.append("AND SP_KPI_ID	  = @[sp_kpi_id]" ).append("\n"); 
		query.append("AND SP_SEQ 	      = @[sp_seq]" ).append("\n"); 
		query.append("AND QUAL_EV_SEQ   = @[qual_ev_seq]" ).append("\n"); 
		query.append("AND EVR_USR_ID    = @[cre_usr_id]" ).append("\n"); 

	}
}