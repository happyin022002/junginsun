/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselInformationMgtDBDAOPerformanceInfoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOPerformanceInfoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance tab 의 form 값들을 저장한다.
	  * 
	  * //History
	  * 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
	  * </pre>
	  */
	public VesselInformationMgtDBDAOPerformanceInfoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("on_deck_per_tr_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_sav_eq_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctcl_rpm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_min_rpm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lod_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_idx_scre",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bow_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slw_stmng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_min_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctcl_to_rpm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("on_deck_per_row_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("htch_cvr_in_hld_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_hld_per_row_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_slw_stmng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hld_per_tr_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOPerformanceInfoVOCSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_VSL_ADD_SPEC A " ).append("\n"); 
		query.append("	USING(" ).append("\n"); 
		query.append("		SELECT MAX(VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("		  FROM VSK_VSL_SKD " ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		   and VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("		  ) B" ).append("\n"); 
		query.append("		ON( A.VSL_CD = B.VSL_CD)" ).append("\n"); 
		query.append("	WHEN MATCHED THEN" ).append("\n"); 
		query.append("	 UPDATE " ).append("\n"); 
		query.append("   			SET      " ).append("\n"); 
		query.append("     			  CTCL_RPM_NO        	= REPLACE(@[ctcl_rpm_no],',','')" ).append("\n"); 
		query.append("     			 ,CTCL_TO_RPM_NO        = REPLACE(@[ctcl_to_rpm_no],',','')        " ).append("\n"); 
		query.append("     			 ,OP_MIN_RPM_NO      	= @[op_min_rpm_no]      " ).append("\n"); 
		query.append("     			 ,OP_MIN_SPD         	= @[op_min_spd]         " ).append("\n"); 
		query.append("     			 ,SLW_STMNG_FLG      	= @[slw_stmng_flg]      " ).append("\n"); 
		query.append("     			 ,SPR_SLW_STMNG_FLG  	= @[spr_slw_stmng_flg]  " ).append("\n"); 
		query.append("     			 ,FUEL_SAV_EQ_FLG    	= @[fuel_sav_eq_flg]    " ).append("\n"); 
		query.append("     			 ,IN_HLD_PER_TR_KNT  	= @[in_hld_per_tr_knt]  " ).append("\n"); 
		query.append("     			 ,IN_HLD_PER_ROW_KNT 	= @[in_hld_per_row_knt]  " ).append("\n"); 
		query.append("     			 ,HTCH_CVR_IN_HLD_KNT	= @[htch_cvr_in_hld_knt]" ).append("\n"); 
		query.append("     			 ,ON_DECK_PER_TR_KNT 	= @[on_deck_per_tr_knt] " ).append("\n"); 
		query.append("     			 ,ON_DECK_PER_ROW_KNT	= @[on_deck_per_row_knt]" ).append("\n"); 
		query.append("     			 ,BOW_HGT            	= @[bow_hgt]            " ).append("\n"); 
		query.append("     			 ,TRSM_HGT           	= @[trsm_hgt]           " ).append("\n"); 
		query.append("     			 ,SHP_IDX_SCRE       	= @[shp_idx_scre]" ).append("\n"); 
		query.append("				 ,AMP_TP_CD         	= @[amp_tp_cd]" ).append("\n"); 
		query.append("				 ,VSL_LOD_RTO			= @[vsl_lod_rto]	 " ).append("\n"); 
		query.append("     			 ,UPD_USR_ID         	= @[usr_id]" ).append("\n"); 
		query.append("      			 ,UPD_DT             	= SYSDATE  " ).append("\n"); 
		query.append("     			      			        " ).append("\n"); 
		query.append("	WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	 INSERT " ).append("\n"); 
		query.append("    		   (" ).append("\n"); 
		query.append("                 VSL_CD             " ).append("\n"); 
		query.append("                ,CTCL_RPM_NO" ).append("\n"); 
		query.append("                ,CTCL_TO_RPM_NO        " ).append("\n"); 
		query.append("        		,OP_MIN_RPM_NO      " ).append("\n"); 
		query.append("        		,OP_MIN_SPD         " ).append("\n"); 
		query.append("        		,SLW_STMNG_FLG      " ).append("\n"); 
		query.append("        		,SPR_SLW_STMNG_FLG  " ).append("\n"); 
		query.append("        		,FUEL_SAV_EQ_FLG    " ).append("\n"); 
		query.append("        		,IN_HLD_PER_TR_KNT  " ).append("\n"); 
		query.append("        		,IN_HLD_PER_ROW_KNT " ).append("\n"); 
		query.append("        		,HTCH_CVR_IN_HLD_KNT" ).append("\n"); 
		query.append("        		,ON_DECK_PER_TR_KNT " ).append("\n"); 
		query.append("        		,ON_DECK_PER_ROW_KNT" ).append("\n"); 
		query.append("        		,BOW_HGT            " ).append("\n"); 
		query.append("        		,TRSM_HGT " ).append("\n"); 
		query.append("     			,SHP_IDX_SCRE" ).append("\n"); 
		query.append("				,AMP_TP_CD" ).append("\n"); 
		query.append("     			,VSL_LOD_RTO            " ).append("\n"); 
		query.append("        		,CRE_USR_ID         " ).append("\n"); 
		query.append("        		,CRE_DT             " ).append("\n"); 
		query.append("     			,UPD_USR_ID         " ).append("\n"); 
		query.append("     			,UPD_DT             " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     			" ).append("\n"); 
		query.append("       				)            " ).append("\n"); 
		query.append("	   VALUES (" ).append("\n"); 
		query.append("			 @[vsl_cd]" ).append("\n"); 
		query.append("			,REPLACE(@[ctcl_rpm_no],',','')" ).append("\n"); 
		query.append("			,REPLACE(@[ctcl_to_rpm_no],',','')" ).append("\n"); 
		query.append("			,@[op_min_rpm_no]" ).append("\n"); 
		query.append("			,@[op_min_spd]" ).append("\n"); 
		query.append("			,@[slw_stmng_flg]" ).append("\n"); 
		query.append("			,@[spr_slw_stmng_flg]" ).append("\n"); 
		query.append("			,@[fuel_sav_eq_flg]" ).append("\n"); 
		query.append("			,@[in_hld_per_tr_knt]" ).append("\n"); 
		query.append("			,@[in_hld_per_row_knt]" ).append("\n"); 
		query.append("			,@[htch_cvr_in_hld_knt]" ).append("\n"); 
		query.append("			,@[on_deck_per_tr_knt]" ).append("\n"); 
		query.append("			,@[on_deck_per_row_knt]" ).append("\n"); 
		query.append("			,@[bow_hgt]" ).append("\n"); 
		query.append("			,@[trsm_hgt]" ).append("\n"); 
		query.append("			,@[shp_idx_scre]" ).append("\n"); 
		query.append("			,@[amp_tp_cd]" ).append("\n"); 
		query.append("			,@[vsl_lod_rto]" ).append("\n"); 
		query.append("        	,@[usr_id]" ).append("\n"); 
		query.append("        	,SYSDATE" ).append("\n"); 
		query.append("        	,@[usr_id]" ).append("\n"); 
		query.append("        	,SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       			)" ).append("\n"); 

	}
}