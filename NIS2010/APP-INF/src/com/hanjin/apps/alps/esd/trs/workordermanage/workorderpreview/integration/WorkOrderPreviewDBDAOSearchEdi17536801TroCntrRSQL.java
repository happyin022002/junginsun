/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi17536801TroCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 박근환
*@LastVersion : 1.1
* 2015.07.24 신동일
* 2016.06.09 박근환 (CHM-201641989) VGM 추가에 따른 IFTMIN EDI Flat file 보완 요청
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi17536801TroCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_175368_01_TRO_CNTR
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi17536801TroCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi17536801TroCntrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" X.CNTR_NO" ).append("\n"); 
		query.append(",X.CNTR_TARE_WGT" ).append("\n"); 
		query.append(",NVL(SUBSTR(TMP, 1, INSTR(TMP, '$', 1, 1) -1),X.cntr_wgt) + X.CNTR_TARE_WGT AS cntr_gross_wgt " ).append("\n"); 
		query.append(",X.CNTR_TP" ).append("\n"); 
		query.append(",X.CNTR_TP_DESC" ).append("\n"); 
		query.append(",X.TRO_BOUND" ).append("\n"); 
		query.append(",X.TRO_TYPE" ).append("\n"); 
		query.append(",SUBSTR(TMP, INSTR(TMP, '$', 1, 1) + 1, INSTR(TMP, '$', 1, 2) - INSTR(TMP, '$', 1, 1) - 1) AS tro_haul_type " ).append("\n"); 
		query.append(",X.BKG_NO" ).append("\n"); 
		query.append(",X.BL_NO" ).append("\n"); 
		query.append(",X.TVVD_LANE" ).append("\n"); 
		query.append(",X.TVVD_VSL_CALL" ).append("\n"); 
		query.append(",X.TVSL_NAME" ).append("\n"); 
		query.append(",X.TVVD_VVD" ).append("\n"); 
		query.append(",X.TVV_POR" ).append("\n"); 
		query.append(",X.TVV_POL" ).append("\n"); 
		query.append(",SUBSTR(TMP4, 1, INSTR(TMP4, '$', 1, 1) -1) AS TVVD_POL_NM " ).append("\n"); 
		query.append(",X.TVVD_POD" ).append("\n"); 
		query.append(",SUBSTR(TMP5, 1, INSTR(TMP5, '$', 1, 1) -1) AS TVVD_POD_NM " ).append("\n"); 
		query.append(",SUBSTR(TMP2, 1, INSTR(TMP2, '$', 1, 1) -1) AS tvvd_etd" ).append("\n"); 
		query.append(",SUBSTR(TMP2, INSTR(TMP2, '$', 1, 1) + 1, INSTR(TMP2, '$', 1, 2) - INSTR(TMP2, '$', 1, 1) - 1) AS tvvd_eta" ).append("\n"); 
		query.append(",X.DEL" ).append("\n"); 
		query.append(",X.MT_IND" ).append("\n"); 
		query.append(",SUBSTR(TMP2, INSTR(TMP2, '$', 1, 2) + 1, INSTR(TMP2, '$', 1, 3) - INSTR(TMP2, '$', 1, 2) - 1) AS rf_ind" ).append("\n"); 
		query.append(",SUBSTR(TMP2, INSTR(TMP2, '$', 1, 3) + 1, INSTR(TMP2, '$', 1, 4) - INSTR(TMP2, '$', 1, 3) - 1) AS dg_ind" ).append("\n"); 
		query.append(",SUBSTR(TMP2, INSTR(TMP2, '$', 1, 4) + 1, INSTR(TMP2, '$', 1, 5) - INSTR(TMP2, '$', 1, 4) - 1) AS awk_ind" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(spcl_inst ,CHR(13)||CHR(10),' '), '\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) spcl_inst" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(SUBSTR(TMP2, INSTR(TMP2, '$', 1, 5) + 1, INSTR(TMP2, '$', 1, 6) - INSTR(TMP2, '$', 1, 5) - 1) ,CHR(13)||CHR(10),' '), '\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) remark" ).append("\n"); 
		query.append(",SUBSTR(TMP, INSTR(TMP, '$', 1, 3) + 1, INSTR(TMP, '$', 1, 4) - INSTR(TMP, '$', 1, 3) - 1) AS trm_customs_no " ).append("\n"); 
		query.append(",SUBSTR(TMP3, 1, INSTR(TMP3, '$', 1, 1) -1) AS cmd_hs_cd " ).append("\n"); 
		query.append(",X.PU_YD" ).append("\n"); 
		query.append(",X.PU_YD_DESC" ).append("\n"); 
		query.append(",X.PU_DT" ).append("\n"); 
		query.append(",X.FM_YD" ).append("\n"); 
		query.append(",X.FM_YD_DESC" ).append("\n"); 
		query.append(",X.FM_YD_DT" ).append("\n"); 
		query.append(",X.TO_YD" ).append("\n"); 
		query.append(",X.TO_YD_DESC" ).append("\n"); 
		query.append(",X.TO_YD_DT" ).append("\n"); 
		query.append(",X.RTN_YD" ).append("\n"); 
		query.append(",X.RTN_YD_DESC" ).append("\n"); 
		query.append(",X.RTN_DT" ).append("\n"); 
		query.append(",X.SEAL_NO" ).append("\n"); 
		query.append(",(SELECT /*+ INDEX_ASC(DTL XPKBKG_EUR_TRO_DTL) */" ).append("\n"); 
		query.append("       DTL.LOD_REF_NO" ).append("\n"); 
		query.append("  FROM BKG_EUR_TRO_DTL DTL" ).append("\n"); 
		query.append(" WHERE DTL.BKG_NO      = SUBSTR(TMP, INSTR(TMP, '$', 1, 4) + 1, INSTR(TMP, '$', 1, 5) - INSTR(TMP, '$', 1, 4) - 1)" ).append("\n"); 
		query.append("   AND DTL.IO_BND_CD   = SUBSTR(TMP, INSTR(TMP, '$', 1, 5) + 1, INSTR(TMP, '$', 1, 6) - INSTR(TMP, '$', 1, 5) - 1)" ).append("\n"); 
		query.append("   AND DTL.TRO_SEQ     = SUBSTR(TMP, INSTR(TMP, '$', 1, 6) + 1, INSTR(TMP, '$', 1, 7) - INSTR(TMP, '$', 1, 6) - 1)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("  ) LOAD_REF " ).append("\n"); 
		query.append(",(SELECT A.CMDT_CD FROM BKG_BOOKING A WHERE A.BKG_NO = X.BKG_NO) AS BKG_CMDT_CODE" ).append("\n"); 
		query.append(",(SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = (SELECT A.CMDT_CD FROM BKG_BOOKING A WHERE A.BKG_NO = X.BKG_NO)) AS BKG_CMDT_DESC" ).append("\n"); 
		query.append(",SUBSTR(TMP6, 1, INSTR(TMP6, '$', 1, 1) -1) AS VGM_WEIGHT" ).append("\n"); 
		query.append(",SUBSTR(TMP6, INSTR(TMP6, '$', 1, 1) + 1, INSTR(TMP6, '$', 1, 2) - INSTR(TMP6, '$', 1, 1) - 1) AS VGM_UNIT" ).append("\n"); 
		query.append(",SUBSTR(TMP6, INSTR(TMP6, '$', 1, 2) + 1, INSTR(TMP6, '$', 1, 3) - INSTR(TMP6, '$', 1, 2) - 1) AS VGM_METHOD" ).append("\n"); 
		query.append(",SUBSTR(TMP6, INSTR(TMP6, '$', 1, 3) + 1, INSTR(TMP6, '$', 1, 4) - INSTR(TMP6, '$', 1, 3) - 1) AS VGM_AUTH_PERSON" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("           so.eq_no cntr_no" ).append("\n"); 
		query.append("          ,tpsz.cntr_tpsz_tare_wgt cntr_tare_wgt" ).append("\n"); 
		query.append("          ,tpsz.cntr_tpsz_iso_cd cntr_tp" ).append("\n"); 
		query.append("          ,so.eq_tpsz_cd cntr_tp_desc" ).append("\n"); 
		query.append("          ,so.trsp_bnd_cd tro_bound		" ).append("\n"); 
		query.append("          ,so.trsp_crr_mod_cd tro_type" ).append("\n"); 
		query.append("          ,so.bkg_no bkg_no" ).append("\n"); 
		query.append("          ,so.bl_no bl_no" ).append("\n"); 
		query.append("          ,so.slan_cd tvvd_lane" ).append("\n"); 
		query.append("          ,vsl.call_sgn_no tvvd_vsl_call" ).append("\n"); 
		query.append("          ,vsl.vsl_eng_nm tvsl_name" ).append("\n"); 
		query.append("          ,so.vsl_cd||so.skd_voy_no||so.skd_dir_cd	tvvd_vvd" ).append("\n"); 
		query.append("          ,so.por_cd tvv_por" ).append("\n"); 
		query.append("          ,so.pol_cd tvv_pol" ).append("\n"); 
		query.append("          ,so.pod_cd tvvd_pod" ).append("\n"); 
		query.append("          ,so.del_cd del" ).append("\n"); 
		query.append("          ,DECODE(so.cgo_tp_cd,'F','N','B','N','Y')	mt_ind" ).append("\n"); 
		query.append("          ,'' pu_yd" ).append("\n"); 
		query.append("          ,'' pu_yd_desc" ).append("\n"); 
		query.append("          ,'' pu_dt" ).append("\n"); 
		query.append("          ,so.fm_nod_cd fm_yd" ).append("\n"); 
		query.append("          ,yd1.yd_nm fm_yd_desc" ).append("\n"); 
		query.append("          ,TO_CHAR(so.n1st_nod_pln_dt ,'YYYYMMDDHH24MI') fm_yd_dt" ).append("\n"); 
		query.append("          ,so.to_nod_cd to_yd" ).append("\n"); 
		query.append("          ,yd3.yd_nm to_yd_desc" ).append("\n"); 
		query.append("          ,TO_CHAR(so.lst_nod_pln_dt,'YYYYMMDDHH24MI') to_yd_dt" ).append("\n"); 
		query.append("          ,'' rtn_yd" ).append("\n"); 
		query.append("          ,'' rtn_yd_desc" ).append("\n"); 
		query.append("          ,'' rtn_dt" ).append("\n"); 
		query.append("          ,(SELECT SEAL.CNTR_SEAL_NO  FROM BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("                                     WHERE SEAL.CNTR_SEAL_SEQ = 1" ).append("\n"); 
		query.append("                                       AND SEAL.BKG_NO  = SO.BKG_NO" ).append("\n"); 
		query.append("                                       AND SEAL.CNTR_NO = SO.EQ_NO ) seal_no  " ).append("\n"); 
		query.append("        ,so.cntr_wgt    --추가" ).append("\n"); 
		query.append("        ,so.spcl_instr_rmk AS spcl_inst" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  tro.cgo_wgt || '$' || " ).append("\n"); 
		query.append("                tro.EUR_TRNS_TP_CD || '$' || " ).append("\n"); 
		query.append("                tro.spcl_instr_rmk || '$' || " ).append("\n"); 
		query.append("                tro.cstms_clr_no || '$' ||" ).append("\n"); 
		query.append("                tro.BKG_NO || '$' || " ).append("\n"); 
		query.append("                tro.IO_BND_CD || '$' || " ).append("\n"); 
		query.append("                tro.TRO_SEQ || '$'" ).append("\n"); 
		query.append("        FROM   bkg_eur_tro tro" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("           AND so.bkg_no = tro.bkg_no" ).append("\n"); 
		query.append("           AND so.trsp_bnd_cd  = tro.io_bnd_cd" ).append("\n"); 
		query.append("           AND so.tro_seq = tro.tro_seq   " ).append("\n"); 
		query.append("        ) TMP" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("              TO_CHAR(skd1.vps_etd_dt,'YYYYMMDDHH24MI') || '$' || " ).append("\n"); 
		query.append("              TO_CHAR(skd2.vps_eta_dt,'YYYYMMDDHH24MI') || '$' || " ).append("\n"); 
		query.append("              CASE WHEN SO.VNDR_SEQ IN (114745, 194962,157955) THEN (SELECT RC_FLG FROM BKG_CONTAINER WHERE BKG_NO = BKG.BKG_NO AND CNTR_NO = SO.EQ_NO)                                                " ).append("\n"); 
		query.append("                   ELSE bkg.rc_flg                                                 " ).append("\n"); 
		query.append("              END || '$' ||                                                           " ).append("\n"); 
		query.append("              CASE WHEN SO.VNDR_SEQ IN (114745, 194962,157955) THEN (SELECT DCGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = BKG.BKG_NO AND CNTR_NO = SO.EQ_NO)                                                " ).append("\n"); 
		query.append("              	   ELSE bkg.dcgo_flg                                                 " ).append("\n"); 
		query.append("              END || '$' ||                                                 " ).append("\n"); 
		query.append("              CASE WHEN SO.VNDR_SEQ IN (114745, 194962,157955) THEN (SELECT AWK_CGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = BKG.BKG_NO AND CNTR_NO = SO.EQ_NO)                                                " ).append("\n"); 
		query.append("                   ELSE bkg.awk_cgo_flg                                                 " ).append("\n"); 
		query.append("              END || '$' ||" ).append("\n"); 
		query.append("              bkg.inter_rmk || '$'" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("               vsk_vsl_port_skd skd1" ).append("\n"); 
		query.append("              ,vsk_vsl_port_skd skd2" ).append("\n"); 
		query.append("              ,bkg_vvd bv        " ).append("\n"); 
		query.append("              ,bkg_booking bkg" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND bv.bkg_no = bkg.bkg_no" ).append("\n"); 
		query.append("           AND bv.vsl_pre_pst_cd = 'T'" ).append("\n"); 
		query.append("           AND bv.vsl_cd = SKD1.VSL_CD" ).append("\n"); 
		query.append("           AND bv.skd_voy_no = skd1.skd_voy_no" ).append("\n"); 
		query.append("           AND bv.skd_dir_cd = skd1.skd_dir_cd" ).append("\n"); 
		query.append("           AND bv.pol_cd = skd1.vps_port_cd" ).append("\n"); 
		query.append("           AND skd1.clpt_ind_seq =1" ).append("\n"); 
		query.append("           AND bv.vsl_cd = skd2.vsl_cd" ).append("\n"); 
		query.append("           AND bv.skd_voy_no = skd2.skd_voy_no" ).append("\n"); 
		query.append("           AND bv.skd_dir_cd = skd2.skd_dir_cd" ).append("\n"); 
		query.append("           AND bv.pod_cd = skd2.vps_port_cd" ).append("\n"); 
		query.append("           AND skd2.clpt_ind_seq =1" ).append("\n"); 
		query.append("           AND so.bkg_no = bkg.bkg_no" ).append("\n"); 
		query.append("        ) TMP2" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                cm.cmdt_hs_cd || '$'" ).append("\n"); 
		query.append("            FROM bkg_cntr_mf_desc cm" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND so.bkg_no = cm.bkg_no" ).append("\n"); 
		query.append("            AND so.eq_no = cm.cntr_no" ).append("\n"); 
		query.append("            AND cm.cntr_mf_seq= 1 " ).append("\n"); 
		query.append("        ) TMP3" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT loc1.loc_nm || '$' FROM mdm_location loc1" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND loc1.loc_cd = so.pol_cd" ).append("\n"); 
		query.append("        ) TMP4 " ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT loc2.loc_nm || '$' FROM mdm_location loc2" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND loc2.loc_cd = so.pod_cd" ).append("\n"); 
		query.append("        ) TMP5" ).append("\n"); 
		query.append("		," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			SELECT VGM_WGT || '$' || VGM_WGT_UT_CD || '$' || VGM_MZD_TP_CD || '$' || VGM_VRFY_SIG_CTNT || '$' FROM BKG_CONTAINER" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("			AND BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("			AND CNTR_NO = SO.EQ_NO" ).append("\n"); 
		query.append("		) TMP6" ).append("\n"); 
		query.append("      FROM mdm_cntr_tp_sz tpsz" ).append("\n"); 
		query.append("          ,mdm_vsl_cntr vsl" ).append("\n"); 
		query.append("          ,mdm_yard yd1" ).append("\n"); 
		query.append("          ,mdm_yard yd2" ).append("\n"); 
		query.append("          ,mdm_yard yd3" ).append("\n"); 
		query.append("          ,trs_trsp_svc_ord so                          " ).append("\n"); 
		query.append("     WHERE so.delt_flg	<> 'Y'							" ).append("\n"); 
		query.append("       AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("       AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("       AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("       AND so.eq_tpsz_cd	= tpsz.cntr_tpsz_cd" ).append("\n"); 
		query.append("       AND so.vsl_cd = vsl.vsl_cd" ).append("\n"); 
		query.append("       AND so.fm_nod_cd = yd1.yd_cd" ).append("\n"); 
		query.append("       AND so.via_nod_cd = yd2.yd_cd(+)" ).append("\n"); 
		query.append("       AND so.to_nod_cd = yd3.yd_cd" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}