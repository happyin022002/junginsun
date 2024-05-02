/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.12 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgCstmsDuBl
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tare_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnsl_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_rotn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_cgo_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_mf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_ts_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_line_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_cntr_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mk_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("du_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_frt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_voy_agn_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuBlUSQL").append("\n"); 
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
		query.append("#if (${ibflag} == 'I')" ).append("\n"); 
		query.append("    UPDATE BKG_CSTMS_DU_BL" ).append("\n"); 
		query.append("       SET DU_ROTN_NO        = @[du_rotn_no]" ).append("\n"); 
		query.append("          ,DU_LINE_ID        = @[du_line_id]" ).append("\n"); 
		query.append("          ,DU_VOY_AGN_ID     = @[du_voy_agn_id]" ).append("\n"); 
		query.append("          ,DU_TRD_CD         = @[du_trd_cd]" ).append("\n"); 
		query.append("          ,DU_CGO_CD         = @[du_cgo_cd]" ).append("\n"); 
		query.append("          ,CNSL_CGO_FLG      = @[cnsl_cgo_flg]" ).append("\n"); 
		query.append("          ,ORG_CNT_CD        = @[org_cnt_cd]" ).append("\n"); 
		query.append("          ,DU_CMDT_CD        = @[du_cmdt_cd]" ).append("\n"); 
		query.append("          ,PCK_QTY           = @[pck_qty]" ).append("\n"); 
		query.append("          ,DU_PCK_TP_CD      = @[du_pck_tp_cd]" ).append("\n"); 
		query.append("          ,CGO_WGT           = @[cgo_wgt]" ).append("\n"); 
		query.append("          ,GRS_WGT           = @[grs_wgt]" ).append("\n"); 
		query.append("     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    UPDATE BKG_CSTMS_DU_BL" ).append("\n"); 
		query.append("       SET DU_LINE_ID        = @[du_line_id]" ).append("\n"); 
		query.append("          ,DU_VOY_AGN_ID     = @[du_voy_agn_id]" ).append("\n"); 
		query.append("          ,DU_MF_NO          = @[du_mf_no]" ).append("\n"); 
		query.append("          ,DU_CGO_CD         = @[du_cgo_cd]" ).append("\n"); 
		query.append("          ,DU_CNTR_SVC_TP_CD = @[du_cntr_svc_tp_cd]" ).append("\n"); 
		query.append("          ,DU_TRD_CD         = @[du_trd_cd]" ).append("\n"); 
		query.append("          ,DU_TS_MOD_CD      = @[du_ts_mod_cd]" ).append("\n"); 
		query.append("          ,CNSL_CGO_FLG      = @[cnsl_cgo_flg]" ).append("\n"); 
		query.append("          ,ORG_CNT_CD        = @[org_cnt_cd]" ).append("\n"); 
		query.append("          ,ORG_BL_NO         = @[org_bl_no]" ).append("\n"); 
		query.append("          ,ORG_VSL_CD        = @[org_vsl_cd]" ).append("\n"); 
		query.append("          ,ORG_SKD_VOY_NO    = @[org_skd_voy_no]" ).append("\n"); 
		query.append("          ,ORG_SKD_DIR_CD    = @[org_skd_dir_cd]" ).append("\n"); 
		query.append("          ,VSL_NM            = @[vsl_nm]" ).append("\n"); 
		query.append("          ,MK_NO_CTNT        = @[mk_no_ctnt]" ).append("\n"); 
		query.append("          ,DU_CMDT_CD        = @[du_cmdt_cd]" ).append("\n"); 
		query.append("          ,CMDT_DESC         = @[cmdt_desc]" ).append("\n"); 
		query.append("          ,PCK_QTY           = @[pck_qty]" ).append("\n"); 
		query.append("          ,DU_PCK_DESC       = @[du_pck_desc]" ).append("\n"); 
		query.append("          ,DU_PCK_TP_CD      = @[du_pck_tp_cd]" ).append("\n"); 
		query.append("          ,CNTR_NO           = @[cntr_no]" ).append("\n"); 
		query.append("          ,CNTR_KNT          = @[cntr_knt]" ).append("\n"); 
		query.append("          ,BKG_TEU_QTY       = @[bkg_teu_qty]" ).append("\n"); 
		query.append("          ,TARE_WGT          = @[tare_wgt]" ).append("\n"); 
		query.append("          ,CGO_WGT           = @[cgo_wgt]" ).append("\n"); 
		query.append("          ,GRS_WGT           = @[grs_wgt]" ).append("\n"); 
		query.append("          ,MEAS_QTY          = @[meas_qty]" ).append("\n"); 
		query.append("          ,DU_TTL_QTY        = @[du_ttl_qty]" ).append("\n"); 
		query.append("          ,DU_FRT_WGT        = @[du_frt_wgt]" ).append("\n"); 
		query.append("          ,PLT_QTY           = @[plt_qty]" ).append("\n"); 
		query.append("          ,UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("          ,UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}