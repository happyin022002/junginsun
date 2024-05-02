/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOContainerByXterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.17
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.06.17 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOContainerByXterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationCMDBDAOContainerByXterCSQL
	  * </pre>
	  */
	public BLDocumentationCMDBDAOContainerByXterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_vrfy_sig_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_prt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOContainerByXterCSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("INSERT INTO BKG_CNTR_HIS (" ).append("\n"); 
		query.append("	 BKG_NO" ).append("\n"); 
		query.append(",    CORR_NO" ).append("\n"); 
		query.append(",    CNTR_NO" ).append("\n"); 
		query.append(",    CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",    CNMV_YR" ).append("\n"); 
		query.append(",    CNMV_ID_NO" ).append("\n"); 
		query.append(",    CNMV_CYC_NO" ).append("\n"); 
		query.append(",    CNMV_STS_CD" ).append("\n"); 
		query.append(",    CNTR_DP_SEQ" ).append("\n"); 
		query.append(",    PCK_TP_CD" ).append("\n"); 
		query.append(",    PCK_QTY" ).append("\n"); 
		query.append(",    CNTR_WGT" ).append("\n"); 
		query.append(",    WGT_UT_CD" ).append("\n"); 
		query.append(",      VGM_WGT" ).append("\n"); 
		query.append(",      VGM_WGT_UT_CD" ).append("\n"); 
		query.append(",VGM_DTMN_DT" ).append("\n"); 
		query.append(",VGM_MZD_TP_CD" ).append("\n"); 
		query.append(",VGM_VRFY_DT" ).append("\n"); 
		query.append(",VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append(",    MEAS_QTY" ).append("\n"); 
		query.append(",    MEAS_UT_CD" ).append("\n"); 
		query.append(",    RCV_TERM_CD" ).append("\n"); 
		query.append(",    DE_TERM_CD" ).append("\n"); 
		query.append(",    ORG_FM_LOC_CD" ).append("\n"); 
		query.append(",    ORG_TO_LOC_CD" ).append("\n"); 
		query.append(",    ORG_YD_CD" ).append("\n"); 
		query.append(",    DEST_FM_LOC_CD" ).append("\n"); 
		query.append(",    DEST_TO_YD_CD" ).append("\n"); 
		query.append(",    DEST_YD_CD" ).append("\n"); 
		query.append(",    POR_NOD_CD" ).append("\n"); 
		query.append(",    POL_YD_CD" ).append("\n"); 
		query.append(",    CNTR_PRT_FLG" ).append("\n"); 
		query.append(",    CNTR_PRT_SEQ" ).append("\n"); 
		query.append(",    CNTR_VOL_QTY" ).append("\n"); 
		query.append(",    ADV_SHTG_CD" ).append("\n"); 
		query.append(",    CNTR_WFG_EXPT_FLG" ).append("\n"); 
		query.append(",    CSTMS_PRN_FLG" ).append("\n"); 
		query.append(",    CSTMS_EXP_DT" ).append("\n"); 
		query.append(",    DCGO_FLG" ).append("\n"); 
		query.append(",    RC_FLG" ).append("\n"); 
		query.append(",    BB_CGO_FLG" ).append("\n"); 
		query.append(",    AWK_CGO_FLG" ).append("\n"); 
		query.append(",    RD_CGO_FLG" ).append("\n"); 
		query.append(",    HNGR_FLG" ).append("\n"); 
		query.append(",    SOC_FLG" ).append("\n"); 
		query.append(",    EQ_SUBST_FLG" ).append("\n"); 
		query.append(",    EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",    CGO_RCV_DT" ).append("\n"); 
		query.append(",    CGO_RCV_YD_CD" ).append("\n"); 
		query.append(",    OB_CY_GEN_DT" ).append("\n"); 
		query.append(",    OB_CY_AUTO_GEN_FLG" ).append("\n"); 
		query.append(",    CNMV_FLG" ).append("\n"); 
		query.append(",    CNMV_EVNT_DT" ).append("\n"); 
		query.append(",    PO_NO" ).append("\n"); 
		query.append(",    DO_NO" ).append("\n"); 
		query.append(",    DO_NO_SPLIT" ).append("\n"); 
		query.append(",    DIFF_RMK" ).append("\n"); 
		query.append(",    CNTR_CFM_FLG" ).append("\n"); 
		query.append(",    MCNTR_BDL_NO" ).append("\n"); 
		query.append(",    MF_CFM_FLG" ).append("\n"); 
		query.append(",    CNTR_DELT_FLG" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("     @[bkg_no]" ).append("\n"); 
		query.append(",    'TMP0000001'" ).append("\n"); 
		query.append(",    @[cntr_no]" ).append("\n"); 
		query.append(",    @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    '9999'" ).append("\n"); 
		query.append(",    @[cnmv_sts_cd]" ).append("\n"); 
		query.append(",    @[cntr_dp_seq]" ).append("\n"); 
		query.append(",    @[pck_tp_cd]" ).append("\n"); 
		query.append(",    @[pck_qty]" ).append("\n"); 
		query.append(",    @[cntr_wgt]" ).append("\n"); 
		query.append(",    @[wgt_ut_cd]" ).append("\n"); 
		query.append(",    @[vgm_wgt]" ).append("\n"); 
		query.append(",    @[vgm_wgt_ut_cd]" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(@[vgm_dtmn_dt], 0, 19), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[vgm_mzd_tp_cd]" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(@[vgm_vrfy_dt], 0, 19), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",upper(@[vgm_vrfy_sig_ctnt])" ).append("\n"); 
		query.append(",    @[meas_qty]" ).append("\n"); 
		query.append(",    @[meas_ut_cd]" ).append("\n"); 
		query.append(",    @[rcv_term_cd]" ).append("\n"); 
		query.append(",    @[de_term_cd]" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    @[org_yd_cd]" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    DECODE(@[cntr_prt_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    1   " ).append("\n"); 
		query.append(",    ''  " ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    'N' " ).append("\n"); 
		query.append(",    'N' " ).append("\n"); 
		query.append(",    'N' " ).append("\n"); 
		query.append(",    'N' " ).append("\n"); 
		query.append(",	 DECODE(SUBSTR(@[cntr_tpsz_cd],1,1),'R','Y','N')" ).append("\n"); 
		query.append(",    'N' " ).append("\n"); 
		query.append(",    'N' " ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    ''  " ).append("\n"); 
		query.append(",	 CASE WHEN @[cgo_rcv_dt] IS NULL AND (SELECT TO_DATE(BKG_GET_CNTR_CORR_DT_FNC(@[bkg_no],@[cntr_no],'Y'),'YYYYMMDDHH24MI') FROM DUAL) IS NOT NULL THEN (SELECT TO_DATE(BKG_GET_CNTR_CORR_DT_FNC(@[bkg_no],@[cntr_no],'Y'),'YYYYMMDDHH24MI') FROM DUAL)" ).append("\n"); 
		query.append("	      ELSE TO_DATE(@[cgo_rcv_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	 END" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    TO_DATE(@[cnmv_evnt_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",    @[po_no]" ).append("\n"); 
		query.append(",    ''  " ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''  " ).append("\n"); 
		query.append(",    DECODE(@[cntr_cfm_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("INSERT INTO BKG_CONTAINER (" ).append("\n"); 
		query.append("	 BKG_NO" ).append("\n"); 
		query.append(",    CNTR_NO" ).append("\n"); 
		query.append(",    CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",    CNMV_YR" ).append("\n"); 
		query.append(",    CNMV_ID_NO" ).append("\n"); 
		query.append(",    CNMV_CYC_NO" ).append("\n"); 
		query.append(",    CNMV_STS_CD" ).append("\n"); 
		query.append(",    CNTR_DP_SEQ" ).append("\n"); 
		query.append(",    PCK_TP_CD" ).append("\n"); 
		query.append(",    PCK_QTY" ).append("\n"); 
		query.append(",    CNTR_WGT" ).append("\n"); 
		query.append(",    WGT_UT_CD" ).append("\n"); 
		query.append(",      VGM_WGT" ).append("\n"); 
		query.append(",      VGM_WGT_UT_CD" ).append("\n"); 
		query.append(",VGM_DTMN_DT" ).append("\n"); 
		query.append(",VGM_MZD_TP_CD" ).append("\n"); 
		query.append(",VGM_VRFY_DT" ).append("\n"); 
		query.append(",VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append(",    MEAS_QTY" ).append("\n"); 
		query.append(",    MEAS_UT_CD" ).append("\n"); 
		query.append(",    RCV_TERM_CD" ).append("\n"); 
		query.append(",    DE_TERM_CD" ).append("\n"); 
		query.append(",    ORG_FM_LOC_CD" ).append("\n"); 
		query.append(",    ORG_TO_LOC_CD" ).append("\n"); 
		query.append(",    ORG_YD_CD" ).append("\n"); 
		query.append(",    DEST_FM_LOC_CD" ).append("\n"); 
		query.append(",    DEST_TO_YD_CD" ).append("\n"); 
		query.append(",    DEST_YD_CD" ).append("\n"); 
		query.append(",    POR_NOD_CD" ).append("\n"); 
		query.append(",    POL_YD_CD" ).append("\n"); 
		query.append(",    CNTR_PRT_FLG" ).append("\n"); 
		query.append(",    CNTR_PRT_SEQ" ).append("\n"); 
		query.append(",    CNTR_VOL_QTY" ).append("\n"); 
		query.append(",    ADV_SHTG_CD" ).append("\n"); 
		query.append(",    CNTR_WFG_EXPT_FLG" ).append("\n"); 
		query.append(",    CSTMS_PRN_FLG" ).append("\n"); 
		query.append(",    CSTMS_EXP_DT" ).append("\n"); 
		query.append(",    DCGO_FLG" ).append("\n"); 
		query.append(",    RC_FLG" ).append("\n"); 
		query.append(",    BB_CGO_FLG" ).append("\n"); 
		query.append(",    AWK_CGO_FLG" ).append("\n"); 
		query.append(",    RD_CGO_FLG" ).append("\n"); 
		query.append(",    HNGR_FLG" ).append("\n"); 
		query.append(",    SOC_FLG" ).append("\n"); 
		query.append(",    EQ_SUBST_FLG" ).append("\n"); 
		query.append(",    EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",    CGO_RCV_DT" ).append("\n"); 
		query.append(",    CGO_RCV_YD_CD" ).append("\n"); 
		query.append(",    OB_CY_GEN_DT" ).append("\n"); 
		query.append(",    OB_CY_AUTO_GEN_FLG" ).append("\n"); 
		query.append(",    CNMV_FLG" ).append("\n"); 
		query.append(",    CNMV_EVNT_DT" ).append("\n"); 
		query.append(",    PO_NO" ).append("\n"); 
		query.append(",    DO_NO" ).append("\n"); 
		query.append(",    DO_NO_SPLIT" ).append("\n"); 
		query.append(",    DIFF_RMK" ).append("\n"); 
		query.append(",    CNTR_CFM_FLG" ).append("\n"); 
		query.append(",    MCNTR_BDL_NO" ).append("\n"); 
		query.append(",    MF_CFM_FLG" ).append("\n"); 
		query.append(",    CNTR_DELT_FLG" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("     @[bkg_no]" ).append("\n"); 
		query.append(",    @[cntr_no]" ).append("\n"); 
		query.append(",    @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    '9999'" ).append("\n"); 
		query.append(",    @[cnmv_sts_cd]" ).append("\n"); 
		query.append(",    @[cntr_dp_seq]" ).append("\n"); 
		query.append(",    @[pck_tp_cd]" ).append("\n"); 
		query.append(",    @[pck_qty]" ).append("\n"); 
		query.append(",    @[cntr_wgt]" ).append("\n"); 
		query.append(",    @[wgt_ut_cd]" ).append("\n"); 
		query.append(",      @[vgm_wgt]" ).append("\n"); 
		query.append(",      @[vgm_wgt_ut_cd]" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(@[vgm_dtmn_dt], 0, 19), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[vgm_mzd_tp_cd]" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(@[vgm_vrfy_dt], 0, 19), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",upper(@[vgm_vrfy_sig_ctnt])" ).append("\n"); 
		query.append(",    @[meas_qty]" ).append("\n"); 
		query.append(",    @[meas_ut_cd]" ).append("\n"); 
		query.append(",    @[rcv_term_cd]" ).append("\n"); 
		query.append(",    @[de_term_cd]" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    @[org_yd_cd]" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    DECODE(@[cntr_prt_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    1  " ).append("\n"); 
		query.append(",    '' " ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",	 DECODE(SUBSTR(@[cntr_tpsz_cd],1,1),'R','Y','N')" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    DECODE(@[soc_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    '' " ).append("\n"); 
		query.append(",	 CASE WHEN @[cgo_rcv_dt] IS NULL AND (SELECT TO_DATE(BKG_GET_CNTR_CORR_DT_FNC(@[bkg_no],@[cntr_no],'N'),'YYYYMMDDHH24MI') FROM DUAL) IS NOT NULL THEN (SELECT TO_DATE(BKG_GET_CNTR_CORR_DT_FNC(@[bkg_no],@[cntr_no],'N'),'YYYYMMDDHH24MI') FROM DUAL)" ).append("\n"); 
		query.append("	      ELSE TO_DATE(@[cgo_rcv_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	 END" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    TO_DATE(@[cnmv_evnt_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",    @[po_no]" ).append("\n"); 
		query.append(",    '' " ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    '' " ).append("\n"); 
		query.append(",    DECODE(@[cntr_cfm_flg], '1', 'Y', 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",    ''" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}