/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOCreatePrnrAproRqstFromPartnerEDICSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOCreatePrnrAproRqstFromPartnerEDICSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG EDI INSERT
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOCreatePrnrAproRqstFromPartnerEDICSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_edi_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_unmap_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOCreatePrnrAproRqstFromPartnerEDICSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PRNR_APRO_RQST (" ).append("\n"); 
		query.append("			CRR_CD" ).append("\n"); 
		query.append("		,	BKG_REF_NO" ).append("\n"); 
		query.append("		,	PRNR_CGO_RQST_SEQ		-- :2015-07-28:Adding PK: --" ).append("\n"); 
		query.append("		,	SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,	VSL_CD" ).append("\n"); 
		query.append("		,	SKD_VOY_NO" ).append("\n"); 
		query.append("		,	SKD_DIR_CD" ).append("\n"); 
		query.append("		,	SLAN_CD" ).append("\n"); 
		query.append("		,	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("		,	POL_CD" ).append("\n"); 
		query.append("		,   POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,	ETA_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	POD_CD" ).append("\n"); 
		query.append("		,   POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	DG_FLG" ).append("\n"); 
		query.append("		,	AWK_FLG" ).append("\n"); 
		query.append("		,   SRC_TP_CD" ).append("\n"); 
		query.append("		,   MAPG_TRSM_BND_CD" ).append("\n"); 
		query.append("		,   MAPG_TRSM_DT" ).append("\n"); 
		query.append("		,   MAPG_TRSM_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("		,   MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("		,   MAPG_EDI_TRSM_STS_CD" ).append("\n"); 
		query.append("		,   EML_SND_NO" ).append("\n"); 
		query.append("		,   LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("		,	CRE_USR_ID" ).append("\n"); 
		query.append("		,	CRE_DT" ).append("\n"); 
		query.append("		,	UPD_USR_ID" ).append("\n"); 
		query.append("		,	UPD_DT" ).append("\n"); 
		query.append("		,   RQST_OFC_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,	EDI_UNMAP_KND_CD		-- :2015-08-28:Adding for Indicator of mismatch UN NO SEQ: --" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		) VALUES ( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("		,	@[bkg_ref_no]" ).append("\n"); 
		query.append("		,	@[prnr_cgo_rqst_seq]	-- :2015-07-28:Adding PK: --" ).append("\n"); 
		query.append("		,	@[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,	@[vsl_cd]" ).append("\n"); 
		query.append("		,	@[skd_voy_no]" ).append("\n"); 
		query.append("		,	@[skd_dir_cd]" ).append("\n"); 
		query.append("		,	@[slan_cd]" ).append("\n"); 
		query.append("		,	@[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("        ,	@[pol_cd]" ).append("\n"); 
		query.append("        ,   @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("		,	TO_DATE(REPLACE(@[eta_dt],'-',''),'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,	@[pod_cd]" ).append("\n"); 
		query.append("        ,   @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	@[dg_flg]" ).append("\n"); 
		query.append("		,	@[awk_flg]" ).append("\n"); 
		query.append("		,	@[src_tp_cd]" ).append("\n"); 
		query.append("		,	@[mapg_trsm_bnd_cd]" ).append("\n"); 
		query.append("		,	TO_DATE(@[mapg_trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("		,	@[mapg_trsm_spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("		,	@[mapg_prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("		,	@[mapg_edi_trsm_sts_cd]" ).append("\n"); 
		query.append("		,	@[eml_snd_no]" ).append("\n"); 
		query.append("		,   'Y' --lst_rqst_dat_flg" ).append("\n"); 
		query.append("		,	@[cre_usr_id]" ).append("\n"); 
		query.append("		,	SYSDATE" ).append("\n"); 
		query.append("		,	@[upd_usr_id]" ).append("\n"); 
		query.append("		,	SYSDATE" ).append("\n"); 
		query.append("		,   @[rqst_ofc_cd]" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,	@[edi_unmap_knd_cd]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}