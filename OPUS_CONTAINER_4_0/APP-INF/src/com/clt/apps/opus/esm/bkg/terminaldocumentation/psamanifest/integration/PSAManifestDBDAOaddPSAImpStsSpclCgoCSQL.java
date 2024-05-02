/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSAManifestDBDAOaddPSAImpStsSpclCgoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddPSAImpStsSpclCgoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOaddPSAImpStsSpclCgoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cbm_per_hr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_bak_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_fnt_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_ovr_sz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_rt_dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_de_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ld_ins",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_lf_dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOaddPSAImpStsSpclCgoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_PSA_IMP_STS_SPCL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ( VSL_CD," ).append("\n"); 
		query.append("         SKD_VOY_NO," ).append("\n"); 
		query.append("         SKD_DIR_CD," ).append("\n"); 
		query.append("         CNTR_NO," ).append("\n"); 
		query.append("         DCGO_FLG," ).append("\n"); 
		query.append("         RC_FLG," ).append("\n"); 
		query.append("         AWK_CGO_FLG," ).append("\n"); 
		query.append("         BB_CGO_FLG," ).append("\n"); 
		query.append("         RD_CGO_FLG," ).append("\n"); 
		query.append("         RC_TEMP," ).append("\n"); 
		query.append("         OVR_DIM_HGT," ).append("\n"); 
		query.append("         OVR_FNT_DIM_LEN," ).append("\n"); 
		query.append("         OVR_BAK_DIM_LEN," ).append("\n"); 
		query.append("         OVR_LF_DIM_WDT," ).append("\n"); 
		query.append("         OVR_RT_DIM_WDT," ).append("\n"); 
		query.append("         DIM_LEN," ).append("\n"); 
		query.append("         DIM_WDT," ).append("\n"); 
		query.append("         DIM_HGT," ).append("\n"); 
		query.append("         CGO_DESC," ).append("\n"); 
		query.append("         CMDT_DESC," ).append("\n"); 
		query.append("         PSA_STWG_TP_ID," ).append("\n"); 
		query.append("         DCHG_OVR_SZ_FLG," ).append("\n"); 
		query.append("         DIR_DE_FLG," ).append("\n"); 
		query.append("         CBM_PER_HR_QTY," ).append("\n"); 
		query.append("         IMDG_CLSS_CD," ).append("\n"); 
		query.append("         CRE_DT," ).append("\n"); 
		query.append("         CRE_USR_ID," ).append("\n"); 
		query.append("         UPD_DT," ).append("\n"); 
		query.append("         UPD_USR_ID )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES ( @[vsl_cd]," ).append("\n"); 
		query.append("         @[skd_voy_no]," ).append("\n"); 
		query.append("         @[skd_dir_cd]," ).append("\n"); 
		query.append("         @[cntr_no]," ).append("\n"); 
		query.append("         NVL(@[dcgo_flg], 'N')," ).append("\n"); 
		query.append("         NVL(@[rc_flg], 'N')," ).append("\n"); 
		query.append("         NVL(@[awk_cgo_flg], 'N')," ).append("\n"); 
		query.append("         NVL(@[bb_cgo_flg], 'N')," ).append("\n"); 
		query.append("         NVL(@[rd_cgo_flg], 'N')," ).append("\n"); 
		query.append("         @[rf_flg],    -- CDO_TEMP" ).append("\n"); 
		query.append("         @[ovr_dim_hgt]," ).append("\n"); 
		query.append("         @[ovr_fnt_dim_len]," ).append("\n"); 
		query.append("         @[ovr_bak_dim_len]," ).append("\n"); 
		query.append("         @[ovr_lf_dim_wdt]," ).append("\n"); 
		query.append("         @[ovr_rt_dim_wdt]," ).append("\n"); 
		query.append("         @[dim_len]," ).append("\n"); 
		query.append("         @[dim_wdt]," ).append("\n"); 
		query.append("         @[dim_hgt]," ).append("\n"); 
		query.append("         @[cgo_desc]," ).append("\n"); 
		query.append("         @[cmdt_desc]," ).append("\n"); 
		query.append("         @[ld_ins]," ).append("\n"); 
		query.append("         @[dchg_ovr_sz_flg]," ).append("\n"); 
		query.append("         NVL(@[dir_de_flg], 'N')," ).append("\n"); 
		query.append("         @[cbm_per_hr_qty]," ).append("\n"); 
		query.append("         @[imdg_clss_cd]," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         @[user_id]," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         @[user_id] )" ).append("\n"); 

	}
}