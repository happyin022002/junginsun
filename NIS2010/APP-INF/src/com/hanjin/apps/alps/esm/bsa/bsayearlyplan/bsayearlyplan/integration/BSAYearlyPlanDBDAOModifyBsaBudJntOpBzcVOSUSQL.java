/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOModifyBsaBudJntOpBzcVOSUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOModifyBsaBudJntOpBzcVOSUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------------------
	  * 2011.01.20 이행지 [CHM-201108497-01] [BSA]사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
	  *                                                        - BSA Creation/Update(Yearly Plan) - Joint Operating 수정시 호출
	  * 2011.03.22 최성민 [CHM-201109647-01] [BSA]Vessel Capa Type을 Numeric에서 Varchar로 변경
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOModifyBsaBudJntOpBzcVOSUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_bsa_bfr_sub_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_hjs_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_vsl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOModifyBsaBudJntOpBzcVOSUSQL").append("\n"); 
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
		query.append("UPDATE BSA_BUD_JNT_OP_BZC SET " ).append("\n"); 
		query.append("	TRD_CD		= @[trd_cd]" ).append("\n"); 
		query.append(",	RLANE_CD	= @[rlane_cd]" ).append("\n"); 
		query.append(",	DIR_CD		= @[dir_cd]" ).append("\n"); 
		query.append(",	VOP_CD		= @[vop_cd]" ).append("\n"); 
		query.append(",	VSL_CAPA	= @[vsl_capa]" ).append("\n"); 
		query.append(",	BSA_SEQ		= @[bsa_seq]" ).append("\n"); 
		query.append(",	VVD_CD		= @[vvd_cd]" ).append("\n"); 
		query.append(",	BSA_FM_DT	= @[bsa_fm_dt]" ).append("\n"); 
		query.append(",	BSA_TO_DT	= @[bsa_to_dt]" ).append("\n"); 
		query.append(",	BSA_CAPA	= @[bsa_capa]" ).append("\n"); 
		query.append(",	FNL_HJS_BSA_CAPA = @[fnl_hjs_bsa_capa]" ).append("\n"); 
		query.append(",	HJS_BSA_BFR_SUB_CAPA = @[hjs_bsa_bfr_sub_capa]" ).append("\n"); 
		query.append(",	JO_DESC		= @[jo_desc]" ).append("\n"); 
		query.append(",	OWNR_VSL_WGT= @[ownr_vsl_wgt]" ).append("\n"); 
		query.append(",	UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT		= SYSDATE" ).append("\n"); 
		query.append("WHERE	TRD_CD		= @[trd_cd]" ).append("\n"); 
		query.append("  AND	RLANE_CD	= @[rlane_cd]" ).append("\n"); 
		query.append("  AND	DIR_CD		= @[dir_cd]" ).append("\n"); 
		query.append("  AND	VOP_CD		= @[vop_cd]" ).append("\n"); 
		query.append("  AND	VSL_CAPA	= @[vsl_capa]" ).append("\n"); 
		query.append("  AND	BSA_SEQ		= @[bsa_seq]" ).append("\n"); 

	}
}