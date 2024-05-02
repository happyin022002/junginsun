/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOaddBkgCstmsAdvCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOaddBkgCstmsAdvCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsAdvCntr
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOaddBkgCstmsAdvCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_ibd_no_upld_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_crr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_ib_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_arr_acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dty_free_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnd_ibd_no_upld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOaddBkgCstmsAdvCntrCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO  BKG_CSTMS_ADV_CNTR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",IBD_CNTR_STS_CD" ).append("\n"); 
		query.append(",PKUP_NO" ).append("\n"); 
		query.append(",RAIL_CRR_REF_NO" ).append("\n"); 
		query.append(",USA_IB_TRSP_NO" ).append("\n"); 
		query.append(",ARR_DT" ).append("\n"); 
		query.append(",DTY_FREE_DT" ).append("\n"); 
		query.append(",CNMV_STS_CD" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",CGO_ARR_ACPT_DT" ).append("\n"); 
		query.append(",XPT_DT" ).append("\n"); 
		query.append(",XPT_ACPT_DT" ).append("\n"); 
		query.append(",FULL_MTY_CD" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",PCK_TP_CD" ).append("\n"); 
		query.append(",GRS_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",AVAL_DT" ).append("\n"); 
		query.append(",PKUP_YD_CD" ).append("\n"); 
		query.append(",CND_IBD_NO_UPLD_ID" ).append("\n"); 
		query.append(",CND_IBD_NO_UPLD_DT" ).append("\n"); 
		query.append(",PRT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES  (" ).append("\n"); 
		query.append("@[cnt_cd]" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",@[ibd_cntr_sts_cd]" ).append("\n"); 
		query.append(",@[pkup_no]" ).append("\n"); 
		query.append(",@[rail_crr_ref_no]" ).append("\n"); 
		query.append(",@[usa_ib_trsp_no]" ).append("\n"); 
		query.append(",@[arr_dt]" ).append("\n"); 
		query.append(",@[dty_free_dt]" ).append("\n"); 
		query.append(",@[cnmv_sts_cd]" ).append("\n"); 
		query.append(",@[yd_cd]" ).append("\n"); 
		query.append(",@[cgo_arr_acpt_dt]" ).append("\n"); 
		query.append(",@[xpt_dt]" ).append("\n"); 
		query.append(",@[xpt_acpt_dt]" ).append("\n"); 
		query.append(",@[full_mty_cd]" ).append("\n"); 
		query.append(",NVL(@[pck_qty], 0)" ).append("\n"); 
		query.append(",@[pck_tp_cd]" ).append("\n"); 
		query.append(",@[grs_wgt]" ).append("\n"); 
		query.append(",@[wgt_ut_cd]" ).append("\n"); 
		query.append(",@[aval_dt]" ).append("\n"); 
		query.append(",@[pkup_yd_cd]" ).append("\n"); 
		query.append(",@[cnd_ibd_no_upld_id]" ).append("\n"); 
		query.append(",@[cnd_ibd_no_upld_dt]" ).append("\n"); 
		query.append(",@[prt_flg]" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}