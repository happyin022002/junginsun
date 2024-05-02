/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOAddReprocessConditionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOAddReprocessConditionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reprocess 시작 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에 삽입합니다.
	  * </pre>
	  */
	public ConstraintMasterDBDAOAddReprocessConditionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_level",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOAddReprocessConditionCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_SB_BKG_PROC_STS" ).append("\n"); 
		query.append("            ( SPC_PROC_SEQ" ).append("\n"); 
		query.append("             ,TRD_CD" ).append("\n"); 
		query.append("             ,SUB_TRD_CD" ).append("\n"); 
		query.append("             ,RLANE_CD" ).append("\n"); 
		query.append("             ,DIR_CD" ).append("\n"); 
		query.append("             ,YRWK" ).append("\n"); 
		query.append("             ,DUR_WKS" ).append("\n"); 
		query.append("             ,VVD_CD" ).append("\n"); 
		query.append("             ,SLS_OFC_CD" ).append("\n"); 
		query.append("             ,OFC_CD" ).append("\n"); 
		query.append("             ,SPC_CTRL_OFC_LVL_CD" ).append("\n"); 
		query.append("             ,CRE_USR_ID" ).append("\n"); 
		query.append("             ,CRE_DT          " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("              NVL((SELECT MAX(SPC_PROC_SEQ)+1" ).append("\n"); 
		query.append("                     FROM SPC_SB_BKG_PROC_STS), 1)" ).append("\n"); 
		query.append("             ,@[f_trd_cd]" ).append("\n"); 
		query.append("             ,@[f_sub_trd_cd]" ).append("\n"); 
		query.append("             ,@[f_rlane_cd]" ).append("\n"); 
		query.append("             ,@[f_dir_cd]" ).append("\n"); 
		query.append("             ,@[f_year]||@[f_week]" ).append("\n"); 
		query.append("             ,@[f_duration]" ).append("\n"); 
		query.append("             ,@[f_vvd_cd]" ).append("\n"); 
		query.append("             ,@[f_sls_ofc_cd]" ).append("\n"); 
		query.append("             ,@[f_ofc_cd]" ).append("\n"); 
		query.append("             ,@[f_level]" ).append("\n"); 
		query.append("             ,@[f_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE           " ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}