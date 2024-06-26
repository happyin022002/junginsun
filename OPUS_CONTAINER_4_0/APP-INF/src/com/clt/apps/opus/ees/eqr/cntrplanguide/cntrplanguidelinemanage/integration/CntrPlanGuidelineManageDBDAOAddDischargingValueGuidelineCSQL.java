/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOAddDischargingValueGuidelineCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOAddDischargingValueGuidelineCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT EQR_CTRL_DCHG_GLINE_VAL
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOAddDischargingValueGuidelineCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_gline_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_gline_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOAddDischargingValueGuidelineCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_CTRL_DCHG_GLINE_VAL(" ).append("\n"); 
		query.append("   TRD_CD        " ).append("\n"); 
		query.append("  ,SUB_TRD_CD    " ).append("\n"); 
		query.append("  ,VSL_LANE_CD   " ).append("\n"); 
		query.append("  ,EQ_GLINE_SEQ  " ).append("\n"); 
		query.append("  ,POD_CD        " ).append("\n"); 
		query.append("  ,CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("  ,EQ_GLINE_TP_CD" ).append("\n"); 
		query.append("  ,EQ_GLINE_VAL  " ).append("\n"); 
		query.append("  ,CRE_USR_ID    " ).append("\n"); 
		query.append("  ,CRE_DT        " ).append("\n"); 
		query.append("  ,UPD_USR_ID    " ).append("\n"); 
		query.append("  ,UPD_DT    " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("   @[trd_cd]" ).append("\n"); 
		query.append("  ,@[sub_trd_cd]" ).append("\n"); 
		query.append("  ,@[vsl_lane_cd]   " ).append("\n"); 
		query.append("  ,@[eq_gline_seq]  " ).append("\n"); 
		query.append("  ,@[pod_cd] " ).append("\n"); 
		query.append("  ,@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("  ,@[eq_gline_tp_cd]" ).append("\n"); 
		query.append("  ,@[eq_gline_val]" ).append("\n"); 
		query.append("  ,@[cre_usr_id] " ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[upd_usr_id]   " ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}