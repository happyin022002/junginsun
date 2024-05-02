/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpclPlanningDBDAOAddKpiInputbyHeadOfficeCSQL.java
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

public class SpclPlanningDBDAOAddKpiInputbyHeadOfficeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpclPlanningDBDAOAddKpiInputbyHeadOffice
	  * </pre>
	  */
	public SpclPlanningDBDAOAddKpiInputbyHeadOfficeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gid_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rpb_rev",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gid_grs_rpb_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration ").append("\n"); 
		query.append("FileName : SpclPlanningDBDAOAddKpiInputbyHeadOfficeCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_LOD_REV (" ).append("\n"); 
		query.append("           BSE_TP_CD" ).append("\n"); 
		query.append("          ,BSE_YR" ).append("\n"); 
		query.append("          ,BSE_QTR_CD" ).append("\n"); 
		query.append("          ,SPCL_TGT_CD" ).append("\n"); 
		query.append("          ,TRD_CD" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("          ,RHQ_CD" ).append("\n"); 
		query.append("          ,DIR_CD" ).append("\n"); 
		query.append("          ,CONV_DIR_CD" ).append("\n"); 
		query.append("          ,SUB_TRD_CD" ).append("\n"); 
		query.append("          ,GID_LOD_QTY" ).append("\n"); 
		query.append("          ,GID_GRS_RPB_REV" ).append("\n"); 
		query.append("          ,LOD_QTY" ).append("\n"); 
		query.append("          ,GRS_RPB_REV" ).append("\n"); 
		query.append("          ,CRE_USR_ID" ).append("\n"); 
		query.append("          ,CRE_DT" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,UPD_DT" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("             @[bse_tp_cd]" ).append("\n"); 
		query.append("            ,@[bse_yr]" ).append("\n"); 
		query.append("            ,@[bse_qtr_cd]" ).append("\n"); 
		query.append("            ,@[spcl_tgt_cd]" ).append("\n"); 
		query.append("            ,@[trd_cd]" ).append("\n"); 
		query.append("            ,@[rlane_cd]" ).append("\n"); 
		query.append("            ,@[rhq_cd]" ).append("\n"); 
		query.append("            ,@[dir_cd]" ).append("\n"); 
		query.append("            ,@[conv_dir_cd]" ).append("\n"); 
		query.append("            ,@[sub_trd_cd]" ).append("\n"); 
		query.append("            ,@[gid_lod_qty]" ).append("\n"); 
		query.append("            ,@[gid_grs_rpb_rev]" ).append("\n"); 
		query.append("            ,@[lod_qty]" ).append("\n"); 
		query.append("            ,@[grs_rpb_rev]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,sysdate" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,sysdate" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}