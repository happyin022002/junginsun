/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOmodifyCllUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOmodifyCllUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCll
	  * </pre>
	  */
	public CLLCDLManifestDBDAOmodifyCllUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grs_cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feu_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_vrfy_sig_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_cgo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lodg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOmodifyCllUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_TML_CLL SET " ).append("\n"); 
		query.append("	VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append(",	SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append(",	SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append(",	PORT_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("#if (${eta_dt} != '') " ).append("\n"); 
		query.append(",	ETA_DT = TO_DATE(@[eta_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${etd_dt} != '') " ).append("\n"); 
		query.append(",	ETD_DT = TO_DATE(@[etd_dt],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append(",	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(",	TS_CGO_CD = @[ts_cgo_cd]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	POR_CD = @[por_cd]" ).append("\n"); 
		query.append(",	POL_CD = @[pol_cd]" ).append("\n"); 
		query.append(",	POD_CD = @[pod_cd]" ).append("\n"); 
		query.append(",	DEL_CD = @[del_cd]" ).append("\n"); 
		query.append(",	SOC_FLG = @[soc_flg]" ).append("\n"); 
		query.append(",	FULL_MTY_CD = @[full_mty_cd]" ).append("\n"); 
		query.append(",	RCV_TERM_CD = SUBSTR(@[rcv_de_term_cd],1,1)" ).append("\n"); 
		query.append(",	DE_TERM_CD = SUBSTR(@[rcv_de_term_cd],2,1)" ).append("\n"); 
		query.append(",	CNTR_SEAL_NO = @[cntr_seal_no]" ).append("\n"); 
		query.append(",	CNTR_LODG_NO = @[cntr_lodg_no]" ).append("\n"); 
		query.append(",	CFM_FLG = @[cfm_flg]" ).append("\n"); 
		query.append("#if (${teu_cntr_qty} != '') " ).append("\n"); 
		query.append(",	TEU_CNTR_QTY = @[teu_cntr_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${feu_cntr_qty} != '') " ).append("\n"); 
		query.append(",	FEU_CNTR_QTY = @[feu_cntr_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	RC_FLG 		= NVL(DECODE(@[rc_flg],'1','Y','0','N',@[rc_flg]),'N')" ).append("\n"); 
		query.append(",	DCGO_FLG 	= NVL(DECODE(@[dcgo_flg],'1','Y','0','N',@[dcgo_flg]),'N')" ).append("\n"); 
		query.append(",	AWK_CGO_FLG = NVL(DECODE(@[awk_cgo_flg],'1','Y','0','N',@[awk_cgo_flg]),'N')" ).append("\n"); 
		query.append(",	BB_CGO_FLG 	= NVL(DECODE(@[bb_cgo_flg],'1','Y','0','N',@[bb_cgo_flg]),'N')" ).append("\n"); 
		query.append(",	RD_CGO_FLG 	= NVL(DECODE(@[rd_cgo_flg],'1','Y','0','N',@[rd_cgo_flg]),'N')" ).append("\n"); 
		query.append(",	BL_RMK 		= @[bl_rmk] " ).append("\n"); 
		query.append(",	UPD_USR_ID 	= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT 		= SYSDATE" ).append("\n"); 
		query.append(",	CNTR_WGT 	= @[cntr_wgt]" ).append("\n"); 
		query.append(",	WGT_TP_CD 	= @[wgt_tp_cd]" ).append("\n"); 
		query.append(",	GRS_CNTR_WGT = @[grs_cntr_wgt]" ).append("\n"); 
		query.append(",	GRS_WGT_UT_CD = @[grs_wgt_ut_cd]" ).append("\n"); 
		query.append("#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append(",   CLPT_IND_SEQ = @[in_pol_split_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(",	VGM_WGT =@[vgm_wgt]" ).append("\n"); 
		query.append(",	VGM_VRFY_SIG_CTNT =@[vgm_vrfy_sig_ctnt]" ).append("\n"); 
		query.append(",	VGM_MZD_TP_CD =@[vgm_mzd_tp_cd]" ).append("\n"); 
		query.append("WHERE	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("AND	VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND	PORT_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("AND NVL(CLPT_IND_SEQ, '1') = @[in_pol_split_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND	CNTR_LODG_NO = @[cntr_lodg_no]" ).append("\n"); 

	}
}