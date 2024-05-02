/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpclPlanningDBDAOCreateBasicCmcbNewLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.09.30 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpclPlanningDBDAOCreateBasicCmcbNewLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpclPlanningDBDAOCreateBasicCmcbNewLane
	  * </pre>
	  */
	public SpclPlanningDBDAOCreateBasicCmcbNewLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration ").append("\n"); 
		query.append("FileName : SpclPlanningDBDAOCreateBasicCmcbNewLaneCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_LANE_OFC_COST (" ).append("\n"); 
		query.append("             BSE_TP_CD" ).append("\n"); 
		query.append("            ,BSE_YR" ).append("\n"); 
		query.append("            ,BSE_QTR_CD" ).append("\n"); 
		query.append("            ,SPCL_TGT_CD" ).append("\n"); 
		query.append("            ,TRD_CD" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,DIR_CD" ).append("\n"); 
		query.append("            ,RGN_OFC_CD" ).append("\n"); 
		query.append("            ,RHQ_CD" ).append("\n"); 
		query.append("            ,CONV_DIR_CD" ).append("\n"); 
		query.append("            ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,LOD_POTN_RTO" ).append("\n"); 
		query.append("            ,REV_POTN_RTO" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        SELECT BSE_TP_CD" ).append("\n"); 
		query.append("              ,BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,SPCL_TGT_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,@[f_rlane_cd] AS RLANE_CD --NEW LANE" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,RGN_OFC_CD" ).append("\n"); 
		query.append("              ,RHQ_CD" ).append("\n"); 
		query.append("              ,CONV_DIR_CD" ).append("\n"); 
		query.append("              ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("              ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("              ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("              ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("              ,LOD_POTN_RTO" ).append("\n"); 
		query.append("              ,REV_POTN_RTO" ).append("\n"); 
		query.append("              ,@[usr_id]  AS CRE_USR_ID" ).append("\n"); 
		query.append("              ,SYSDATE    AS CRE_DT" ).append("\n"); 
		query.append("              ,@[usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append("              ,SYSDATE    AS UPD_DT" ).append("\n"); 
		query.append("          FROM SQM_SPCL_LANE_OFC_COST" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BSE_TP_CD    = @[f_bse_tp_cd]    -- Q, Y 필수" ).append("\n"); 
		query.append("           AND BSE_YR       = @[f_bse_yr]       -- 필수" ).append("\n"); 
		query.append("           AND SPCL_TGT_CD  =  @[f_spcl_tgt_cd] -- S, R 필수" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("           AND BSE_QTR_CD   = @[f_bse_qtr_cd]   -- Quartely일때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND TRD_CD       = @[f_trd_cd]       -- Trade" ).append("\n"); 
		query.append("           AND RLANE_CD     = @[f_src_rlane_cd] -- COPY SOURCE" ).append("\n"); 

	}
}