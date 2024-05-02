/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOAddCtmVrfdGrsMassEdiMsgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOAddCtmVrfdGrsMassEdiMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VERMAS EDI 수신 데이터 저장
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOAddCtmVrfdGrsMassEdiMsgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_zip_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("smt_cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_ste_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_ctrl_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cut_off_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pty_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_cntc_phn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmmc_cntc_phn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pty_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_dtmn_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmmc_cntc_fax_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_cntc_dtl_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_cty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("smt_ste_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_zip_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmmc_cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pty_cty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_vrfy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vrfd_wgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOAddCtmVrfdGrsMassEdiMsgCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_VRFD_GRS_MASS_EDI_MSG (" ).append("\n"); 
		query.append("  REF_NO," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  VGM_SEQ," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  VGM_ID," ).append("\n"); 
		query.append("  FUNC_CD," ).append("\n"); 
		query.append("  ISS_DT," ).append("\n"); 
		query.append("  CUT_OFF_DT," ).append("\n"); 
		query.append("  POR_NM," ).append("\n"); 
		query.append("  POR_CD," ).append("\n"); 
		query.append("  POR_YD_CD," ).append("\n"); 
		query.append("  POL_NM," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  POL_YD_CD," ).append("\n"); 
		query.append("  SMT_NM," ).append("\n"); 
		query.append("  SMT_ADDR," ).append("\n"); 
		query.append("  SMT_CTY_CTNT," ).append("\n"); 
		query.append("  SMT_STE_CTNT," ).append("\n"); 
		query.append("  SMT_ZIP_CTNT," ).append("\n"); 
		query.append("  SMT_CNT_CD," ).append("\n"); 
		query.append("  SMT_CNTC_DTL_CTNT," ).append("\n"); 
		query.append("  SMT_CNTC_EML," ).append("\n"); 
		query.append("  SMT_CNTC_PHN_CTNT," ).append("\n"); 
		query.append("  VSL_CD," ).append("\n"); 
		query.append("  SKD_VOY_NO," ).append("\n"); 
		query.append("  SKD_DIR_CD," ).append("\n"); 
		query.append("  VSL_NM," ).append("\n"); 
		query.append("  VSL_LLOYD_NO," ).append("\n"); 
		query.append("  BKG_REF_NO," ).append("\n"); 
		query.append("  SI_REF_NO," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  TRSP_CTRL_NO_CTNT," ).append("\n"); 
		query.append("  VGM_WGT_QTY," ).append("\n"); 
		query.append("  VRFD_WGT_CD," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  DOC_ID," ).append("\n"); 
		query.append("  VGM_DTMN_DT," ).append("\n"); 
		query.append("  VGM_VRFY_DT," ).append("\n"); 
		query.append("  SEAL_NO_CTNT," ).append("\n"); 
		query.append("  PTY_FUNC_CD," ).append("\n"); 
		query.append("  PTY_NM," ).append("\n"); 
		query.append("  PTY_ADDR," ).append("\n"); 
		query.append("  PTY_CTY_CTNT," ).append("\n"); 
		query.append("  PTY_STE_CTNT," ).append("\n"); 
		query.append("  PTY_ZIP_CTNT," ).append("\n"); 
		query.append("  PTY_CNT_CD," ).append("\n"); 
		query.append("  PTY_PSON_NM," ).append("\n"); 
		query.append("  CMMC_CNTC_PHN_CTNT," ).append("\n"); 
		query.append("  CMMC_CNTC_EML," ).append("\n"); 
		query.append("  CMMC_CNTC_FAX_CTNT," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("  @[ref_no]," ).append("\n"); 
		query.append("  @[cntr_no]," ).append("\n"); 
		query.append("  NVL((SELECT MAX(VGM_SEQ)" ).append("\n"); 
		query.append("       FROM CTM_VRFD_GRS_MASS_EDI_MSG" ).append("\n"); 
		query.append("       WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      ), 0" ).append("\n"); 
		query.append("  ) + 1," ).append("\n"); 
		query.append("  @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("  @[vgm_id]," ).append("\n"); 
		query.append("  @[func_cd]," ).append("\n"); 
		query.append("  TO_DATE(@[iss_dt], 'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("  TO_DATE(@[cut_off_dt], 'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("  @[por_nm]," ).append("\n"); 
		query.append("  @[por_cd]," ).append("\n"); 
		query.append("  @[por_yd_cd]," ).append("\n"); 
		query.append("  @[pol_nm]," ).append("\n"); 
		query.append("  @[pol_cd]," ).append("\n"); 
		query.append("  @[pol_yd_cd]," ).append("\n"); 
		query.append("  @[smt_nm]," ).append("\n"); 
		query.append("  @[smt_addr]," ).append("\n"); 
		query.append("  @[smt_cty_ctnt]," ).append("\n"); 
		query.append("  @[smt_ste_ctnt]," ).append("\n"); 
		query.append("  @[smt_zip_ctnt]," ).append("\n"); 
		query.append("  @[smt_cnt_cd]," ).append("\n"); 
		query.append("  @[smt_cntc_dtl_ctnt]," ).append("\n"); 
		query.append("  @[smt_cntc_eml]," ).append("\n"); 
		query.append("  @[smt_cntc_phn_ctnt]," ).append("\n"); 
		query.append("  @[vsl_cd]," ).append("\n"); 
		query.append("  @[skd_voy_no]," ).append("\n"); 
		query.append("  @[skd_dir_cd]," ).append("\n"); 
		query.append("  @[vsl_nm]," ).append("\n"); 
		query.append("  @[vsl_lloyd_no]," ).append("\n"); 
		query.append("  @[bkg_ref_no]," ).append("\n"); 
		query.append("  @[si_ref_no]," ).append("\n"); 
		query.append("  @[bkg_no]," ).append("\n"); 
		query.append("  @[trsp_ctrl_no_ctnt]," ).append("\n"); 
		query.append("  @[vgm_wgt_qty]," ).append("\n"); 
		query.append("  @[vrfd_wgt_cd]," ).append("\n"); 
		query.append("  @[vgm_mzd_tp_cd]," ).append("\n"); 
		query.append("  @[doc_id]," ).append("\n"); 
		query.append("  TO_DATE(@[vgm_dtmn_dt], 'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("  TO_DATE(@[vgm_vrfy_dt], 'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("  @[seal_no_ctnt]," ).append("\n"); 
		query.append("  @[pty_func_cd]," ).append("\n"); 
		query.append("  @[pty_nm]," ).append("\n"); 
		query.append("  @[pty_addr]," ).append("\n"); 
		query.append("  @[pty_cty_ctnt]," ).append("\n"); 
		query.append("  @[pty_ste_ctnt]," ).append("\n"); 
		query.append("  @[pty_zip_ctnt]," ).append("\n"); 
		query.append("  @[pty_cnt_cd]," ).append("\n"); 
		query.append("  @[pty_pson_nm]," ).append("\n"); 
		query.append("  @[cmmc_cntc_phn_ctnt]," ).append("\n"); 
		query.append("  @[cmmc_cntc_eml]," ).append("\n"); 
		query.append("  @[cmmc_cntc_fax_ctnt]," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}