/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSAManifestDBDAOaddPSAImpStsInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.27 
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

public class PSAManifestDBDAOaddPSAImpStsInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOaddPSAImpStsInfoCSQL(){
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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("batch_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("next_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ld_ins",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOaddPSAImpStsInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_PSA_IMP_STS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POD_CD," ).append("\n"); 
		query.append("        TS_TP_CD," ).append("\n"); 
		query.append("        FULL_MTY_CD," ).append("\n"); 
		query.append("        CNTR_WGT," ).append("\n"); 
		query.append("        CNTR_OPR_CD," ).append("\n"); 
		query.append("        IB_SLT_OPR_CD," ).append("\n"); 
		query.append("        DCGO_FLG," ).append("\n"); 
		query.append("        RC_FLG," ).append("\n"); 
		query.append("        AWK_CGO_FLG," ).append("\n"); 
		query.append("        BB_CGO_FLG," ).append("\n"); 
		query.append("        RD_CGO_FLG," ).append("\n"); 
		query.append("        LODG_VSL_CD," ).append("\n"); 
		query.append("        LODG_SKD_VOY_NO," ).append("\n"); 
		query.append("        LODG_VSL_DIR_CD," ).append("\n"); 
		query.append("        OB_SLT_OPR_CD," ).append("\n"); 
		query.append("        PSA_BAT_NO," ).append("\n"); 
		query.append("        N1ST_POD_CD," ).append("\n"); 
		query.append("        N2ND_POD_CD," ).append("\n"); 
		query.append("        N3RD_POD_CD," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        CNTR_SEAL_NO," ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        PSA_STWG_TP_ID," ).append("\n"); 
		query.append("        PSA_CRE_TP_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (@[vsl_cd]," ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd]," ).append("\n"); 
		query.append("        @[cntr_no]," ).append("\n"); 
		query.append("        @[pol_cd]," ).append("\n"); 
		query.append("        @[pod_cd]," ).append("\n"); 
		query.append("        @[ts_tp_cd]," ).append("\n"); 
		query.append("        @[fm_cd]," ).append("\n"); 
		query.append("        NVL(@[cntr_wgt], 0)," ).append("\n"); 
		query.append("        @[cop]," ).append("\n"); 
		query.append("        @[iop]," ).append("\n"); 
		query.append("        NVL(@[dcgo_flg], 'N')," ).append("\n"); 
		query.append("        NVL(@[rc_flg], 'N')," ).append("\n"); 
		query.append("        NVL(@[awk_cgo_flg], 'N')," ).append("\n"); 
		query.append("        NVL(@[bb_cgo_flg], 'N')," ).append("\n"); 
		query.append("        NVL(@[rd_cgo_flg], 'N')," ).append("\n"); 
		query.append("        @[next_vsl_cd]," ).append("\n"); 
		query.append("        @[next_skd_voy_no]," ).append("\n"); 
		query.append("        @[next_skd_dir_cd]," ).append("\n"); 
		query.append("        @[oop]," ).append("\n"); 
		query.append("        @[batch_no]," ).append("\n"); 
		query.append("        @[n1st_pod_cd]," ).append("\n"); 
		query.append("        @[n2nd_pod_cd]," ).append("\n"); 
		query.append("        @[n3rd_pod_cd]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[user_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[user_id]," ).append("\n"); 
		query.append("        SUBSTR(@[seal_no], 1, 20)," ).append("\n"); 
		query.append("        @[bkg_no]," ).append("\n"); 
		query.append("        @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("        @[ld_ins]," ).append("\n"); 
		query.append("        @[psa_cre_tp_cd])" ).append("\n"); 

	}
}