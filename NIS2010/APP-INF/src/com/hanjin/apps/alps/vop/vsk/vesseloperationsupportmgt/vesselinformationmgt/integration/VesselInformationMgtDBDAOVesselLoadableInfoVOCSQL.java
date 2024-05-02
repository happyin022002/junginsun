/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselInformationMgtDBDAOVesselLoadableInfoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16 
* 1.0 Creation
* 
* 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
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

public class VesselInformationMgtDBDAOVesselLoadableInfoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Loadable Info 를 저장한다.
	  * 
	  * //History
	  * 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
	  * </pre>
	  */
	public VesselInformationMgtDBDAOVesselLoadableInfoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_new_wgt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_hc_deck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_incl_icrz_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_act_ut_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bak_hul_new_slt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_hc_deck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_new_wgt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_hc_xcld_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_bsa_ut_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_act_ut_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_xcld_icrz_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_hc_xcld_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_xcld_icrz_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_bsa_ut_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_xcld_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dzn_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_new_slt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_hc_incl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_hc_incl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_crnt_slt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_incl_icrz_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bak_hul_crnt_slt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_hul_hc_hld_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bak_hul_hc_hld_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_bsa_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_cgo_smr_mt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldb_capa_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_incl_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOVesselLoadableInfoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_LANE_LDB_CAPA" ).append("\n"); 
		query.append("	  ( " ).append("\n"); 
		query.append("	    VSL_SLAN_CD" ).append("\n"); 
		query.append("	  , VSL_SLAN_CTNT" ).append("\n"); 
		query.append("	  , CAPA_SEQ" ).append("\n"); 
		query.append("	  , TRD_CD" ).append("\n"); 
		query.append("	  , CNTR_DZN_CAPA" ).append("\n"); 
		query.append("	  , MAX_CGO_SMR_MT_WGT" ).append("\n"); 
		query.append("	  , HC_INCL_BSA_QTY" ).append("\n"); 
		query.append("	  , HC_XCLD_BSA_QTY" ).append("\n"); 
		query.append("	  , CTRT_BSA_UT_WGT" ).append("\n"); 
		query.append("	  , ACT_BSA_UT_WGT" ).append("\n"); 
		query.append("	  , TTL_BSA_WGT" ).append("\n"); 
		query.append("	  , HD_HUL_HC_HLD_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_HC_DECK_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_HC_INCL_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_HC_XCLD_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_ACT_UT_WGT" ).append("\n"); 
		query.append("	  , HD_HUL_TTL_WGT" ).append("\n"); 
		query.append("	  , HD_HUL_CRNT_SLT_RT" ).append("\n"); 
		query.append("	  , HD_HUL_NEW_SLT_RT" ).append("\n"); 
		query.append("	  , HD_HUL_NEW_WGT_RT" ).append("\n"); 
		query.append("	  , HD_HUL_INCL_ICRZ_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_XCLD_ICRZ_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_HLD_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_DECK_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_INCL_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_XCLD_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_ACT_UT_WGT" ).append("\n"); 
		query.append("	  , BAK_HUL_TTL_WGT" ).append("\n"); 
		query.append("	  , BAK_HUL_CRNT_SLT_RT" ).append("\n"); 
		query.append("	  , BAK_HUL_NEW_SLT_RT" ).append("\n"); 
		query.append("	  , BAK_HUL_NEW_WGT_RT" ).append("\n"); 
		query.append("	  , BAK_HUL_INCL_ICRZ_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_XCLD_ICRZ_QTY" ).append("\n"); 
		query.append("	  , LDB_CAPA_RMK" ).append("\n"); 
		query.append("	  , CRE_USR_ID" ).append("\n"); 
		query.append("	  , CRE_DT" ).append("\n"); 
		query.append("	  , UPD_USR_ID" ).append("\n"); 
		query.append("	  , UPD_DT" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("	  SUBSTR(@[vsl_slan_ctnt],1,3)" ).append("\n"); 
		query.append("	, @[vsl_slan_ctnt]" ).append("\n"); 
		query.append("	, (SELECT NVL(MAX(CAPA_SEQ)+1, 1) " ).append("\n"); 
		query.append("         FROM VSK_VSL_LANE_LDB_CAPA " ).append("\n"); 
		query.append("        WHERE VSL_SLAN_CD = SUBSTR(@[vsl_slan_ctnt],1,3))" ).append("\n"); 
		query.append("	, @[trd_cd]" ).append("\n"); 
		query.append("	, @[cntr_dzn_capa]" ).append("\n"); 
		query.append("	, @[max_cgo_smr_mt_wgt]" ).append("\n"); 
		query.append("	, @[hc_incl_bsa_qty]" ).append("\n"); 
		query.append("	, @[hc_xcld_bsa_qty]" ).append("\n"); 
		query.append("	, @[ctrt_bsa_ut_wgt]" ).append("\n"); 
		query.append("	, @[act_bsa_ut_wgt]" ).append("\n"); 
		query.append("	, @[ttl_bsa_wgt]" ).append("\n"); 
		query.append("	, @[hd_hul_hc_hld_qty]" ).append("\n"); 
		query.append("	, @[hd_hul_hc_deck_qty]" ).append("\n"); 
		query.append("	, @[hd_hul_hc_incl_qty]" ).append("\n"); 
		query.append("	, @[hd_hul_hc_xcld_qty]" ).append("\n"); 
		query.append("	, @[hd_hul_act_ut_wgt]" ).append("\n"); 
		query.append("	, @[hd_hul_ttl_wgt]" ).append("\n"); 
		query.append("	, @[hd_hul_crnt_slt_rt]" ).append("\n"); 
		query.append("	, @[hd_hul_new_slt_rt]" ).append("\n"); 
		query.append("	, @[hd_hul_new_wgt_rt]" ).append("\n"); 
		query.append("	, @[hd_hul_incl_icrz_qty]" ).append("\n"); 
		query.append("	, @[hd_hul_xcld_icrz_qty]" ).append("\n"); 
		query.append("	, @[bak_hul_hc_hld_qty]" ).append("\n"); 
		query.append("	, @[bak_hul_hc_deck_qty]" ).append("\n"); 
		query.append("	, @[bak_hul_hc_incl_qty]" ).append("\n"); 
		query.append("	, @[bak_hul_hc_xcld_qty]" ).append("\n"); 
		query.append("	, @[bak_hul_act_ut_wgt]" ).append("\n"); 
		query.append("	, @[bak_hul_ttl_wgt]" ).append("\n"); 
		query.append("	, @[bak_hul_crnt_slt_rt]" ).append("\n"); 
		query.append("	, @[bak_hul_new_slt_rt]" ).append("\n"); 
		query.append("	, @[bak_hul_new_wgt_rt]" ).append("\n"); 
		query.append("	, @[bak_hul_incl_icrz_qty]" ).append("\n"); 
		query.append("	, @[bak_hul_xcld_icrz_qty]" ).append("\n"); 
		query.append("	, @[ldb_capa_rmk]" ).append("\n"); 
		query.append("	, @[usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}