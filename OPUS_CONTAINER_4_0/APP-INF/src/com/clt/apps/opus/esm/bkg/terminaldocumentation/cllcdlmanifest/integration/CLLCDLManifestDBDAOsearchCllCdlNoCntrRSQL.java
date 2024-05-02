/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCdlNoCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllCdlNoCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllCdlNoCntr
	  * 2013.02.19 [CHM-201322723] Tare Weight 보완
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCdlNoCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pkup_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hot_de_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_prct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCdlNoCntrRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  QT.CNTR_NO," ).append("\n"); 
		query.append("  QT.TP CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  QT.CNTR_SEAL_NO," ).append("\n"); 
		query.append("  QT.CNTR_WGT," ).append("\n"); 
		query.append("  --ROUND((round(nvl(QT.ACT_WGT,0) * decode(substr(QT.TP,2,1),'2',1,2) / QT.TOT) + " ).append("\n"); 
		query.append("   --decode(substr(QT.TP,2,1),'2',NVL(QT.CNTR_VOL_QTY,1)*2500,NVL(QT.CNTR_VOL_QTY,1)*4000))/1000) E_CNTR_WGT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  --2013.02.19 추가 " ).append("\n"); 
		query.append("  ROUND((round(nvl(QT.ACT_WGT,0) * decode(substr(QT.TP,2,1),'2',1,2) / QT.TOT) + " ).append("\n"); 
		query.append("   NVL(QT.CNTR_VOL_QTY,1)*decode(nvl(mst_tare,0), 0, decode(nvl(mdm_tare,0), 0, 2500, mdm_tare), mst_tare))/1000) E_CNTR_WGT," ).append("\n"); 
		query.append("  QT.PCK_QTY," ).append("\n"); 
		query.append("  QT.BKG_NO," ).append("\n"); 
		query.append("  QT.BL_NO," ).append("\n"); 
		query.append("  QT.BKG_POR POR_CD," ).append("\n"); 
		query.append("  QT.BKG_POL A_POL_CD," ).append("\n"); 
		query.append("  QT.BKG_POD A_POD_CD," ).append("\n"); 
		query.append("  QT.BKG_DEL DEL_CD," ).append("\n"); 
		query.append("  QT.BLCK_STWG_CD BLCK_STWG_CD," ).append("\n"); 
		query.append("  QT.RCV_TERM_CD," ).append("\n"); 
		query.append("  QT.DE_TERM_CD," ).append("\n"); 
		query.append("  QT.TS_CD," ).append("\n"); 
		query.append("  QT.FM BKG_CGO_TP_CD," ).append("\n"); 
		query.append("  QT.HOT_DE_FLG," ).append("\n"); 
		query.append("  QT.P_VVD VVD_CD," ).append("\n"); 
		query.append("  QT.CUST_NM," ).append("\n"); 
		query.append("  QT.SOC_FLG," ).append("\n"); 
		query.append("  QT.STWG_CD STWG_CD," ).append("\n"); 
		query.append("  QT.BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("  QT.HAMO_TRF_CD," ).append("\n"); 
		query.append("  ROWNUM SEQ," ).append("\n"); 
		query.append("  QT.CNTR_NO CNTR_NO2,   " ).append("\n"); 
		query.append("  QT.PCK_TP_CD," ).append("\n"); 
		query.append("  QT.POR_NOD_CD," ).append("\n"); 
		query.append("  QT.POL_NOD_CD," ).append("\n"); 
		query.append("  QT.POD_NOD_CD," ).append("\n"); 
		query.append("  QT.DEL_NOD_CD," ).append("\n"); 
		query.append("  QT.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("  QT.POL_CD," ).append("\n"); 
		query.append("  QT.POL_YD_CD," ).append("\n"); 
		query.append("  QT.POD_CD," ).append("\n"); 
		query.append("  QT.POD_YD_CD," ).append("\n"); 
		query.append("  QT.MEAS_QTY,	" ).append("\n"); 
		query.append("  QT.PRCT_FLG," ).append("\n"); 
		query.append("  QT.DG DCGO_FLG," ).append("\n"); 
		query.append("  QT.RF RC_FLG," ).append("\n"); 
		query.append("  QT.AK AWK_CGO_FLG," ).append("\n"); 
		query.append("  QT.ORG_YD_CD," ).append("\n"); 
		query.append("  QT.CNMV_EVNT_DT," ).append("\n"); 
		query.append("  QT.PREVVD1, " ).append("\n"); 
		query.append("  QT.PREVVD2, " ).append("\n"); 
		query.append("  QT.PREVVD3, " ).append("\n"); 
		query.append("  QT.PREVVD4," ).append("\n"); 
		query.append("  QT.TRUNKVVD, " ).append("\n"); 
		query.append("  QT.POSTVVD1, " ).append("\n"); 
		query.append("  QT.POSTVVD2, " ).append("\n"); 
		query.append("  QT.POSTVVD3, " ).append("\n"); 
		query.append("  QT.POSTVVD4," ).append("\n"); 
		query.append("  QT.PRE1POL, " ).append("\n"); 
		query.append("  QT.PRE2POL, " ).append("\n"); 
		query.append("  QT.PRE3POL, " ).append("\n"); 
		query.append("  QT.PRE4POL, " ).append("\n"); 
		query.append("  QT.POST1POL, " ).append("\n"); 
		query.append("  QT.POST2POL, " ).append("\n"); 
		query.append("  QT.POST3POL, " ).append("\n"); 
		query.append("  QT.POST4POL," ).append("\n"); 
		query.append("  QT.A_CNTR_WGT," ).append("\n"); 
		query.append("  QT.RD_CGO_FLG," ).append("\n"); 
		query.append("  QT.CSTMS_DESC," ).append("\n"); 
		query.append("  SUBSTR(PKUP_NOD_CD,1,5) PKUP_LOC_CD," ).append("\n"); 
		query.append("  SUBSTR(PKUP_NOD_CD,6) PKUP_NOD_CD" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("       SELECT " ).append("\n"); 
		query.append("         NVL(QT.CNTR_NO,'T.B.N.'||ROWNUM) CNTR_NO," ).append("\n"); 
		query.append("         QT.TP," ).append("\n"); 
		query.append("         QT.BKG_NO," ).append("\n"); 
		query.append("         QT.BL_NO," ).append("\n"); 
		query.append("         QT.RCV_TERM_CD," ).append("\n"); 
		query.append("         QT.DE_TERM_CD," ).append("\n"); 
		query.append("         QT.CNTR_SEAL_NO," ).append("\n"); 
		query.append("         QT.CNTR_WGT," ).append("\n"); 
		query.append("         QT.ACT_WGT," ).append("\n"); 
		query.append("         QT.PCK_QTY," ).append("\n"); 
		query.append("         QT.CNTR_VOL_QTY," ).append("\n"); 
		query.append("         QT.TOT," ).append("\n"); 
		query.append("         QT.BKG_POR," ).append("\n"); 
		query.append("         QT.BKG_POL," ).append("\n"); 
		query.append("         QT.BKG_POD," ).append("\n"); 
		query.append("         QT.BKG_DEL," ).append("\n"); 
		query.append("         QT.FM," ).append("\n"); 
		query.append("         QT.DG," ).append("\n"); 
		query.append("         QT.RF," ).append("\n"); 
		query.append("         QT.AK," ).append("\n"); 
		query.append("         QT.SLAN_CD," ).append("\n"); 
		query.append("         QT.SKD_DIR_CD," ).append("\n"); 
		query.append("         QT.POL_CD," ).append("\n"); 
		query.append("         QT.PRCT_FLG," ).append("\n"); 
		query.append("         QT.STWG_CD," ).append("\n"); 
		query.append("         QT.BLCK_STWG_CD," ).append("\n"); 
		query.append("         QT.HOT_DE_FLG," ).append("\n"); 
		query.append("         QT.P_VVD," ).append("\n"); 
		query.append("         QT.CUST_NM," ).append("\n"); 
		query.append("         QT.SOC_FLG," ).append("\n"); 
		query.append("         QT.BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("         QT.HAMO_TRF_CD," ).append("\n"); 
		query.append("         QT.PCK_TP_CD," ).append("\n"); 
		query.append("         QT.POR_NOD_CD," ).append("\n"); 
		query.append("         QT.POL_NOD_CD," ).append("\n"); 
		query.append("         QT.POD_NOD_CD," ).append("\n"); 
		query.append("         QT.DEL_NOD_CD," ).append("\n"); 
		query.append("         QT.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("         QT.POL_YD_CD," ).append("\n"); 
		query.append("         QT.POD_CD," ).append("\n"); 
		query.append("         QT.POD_YD_CD," ).append("\n"); 
		query.append("         QT.MEAS_QTY,	" ).append("\n"); 
		query.append("         QT.ORG_YD_CD," ).append("\n"); 
		query.append("         QT.CNMV_EVNT_DT," ).append("\n"); 
		query.append("         QT.PREVVD1, " ).append("\n"); 
		query.append("         QT.PREVVD2, " ).append("\n"); 
		query.append("         QT.PREVVD3, " ).append("\n"); 
		query.append("         QT.PREVVD4," ).append("\n"); 
		query.append("         QT.TRUNKVVD, " ).append("\n"); 
		query.append("         QT.POSTVVD1, " ).append("\n"); 
		query.append("         QT.POSTVVD2, " ).append("\n"); 
		query.append("         QT.POSTVVD3, " ).append("\n"); 
		query.append("         QT.POSTVVD4," ).append("\n"); 
		query.append("         QT.PRE1POL, " ).append("\n"); 
		query.append("         QT.PRE2POL, " ).append("\n"); 
		query.append("         QT.PRE3POL, " ).append("\n"); 
		query.append("         QT.PRE4POL, " ).append("\n"); 
		query.append("         QT.POST1POL, " ).append("\n"); 
		query.append("         QT.POST2POL, " ).append("\n"); 
		query.append("         QT.POST3POL, " ).append("\n"); 
		query.append("         QT.POST4POL," ).append("\n"); 
		query.append("         QT.A_CNTR_WGT," ).append("\n"); 
		query.append("         QT.TS_CD," ).append("\n"); 
		query.append("		 QT.RD_CGO_FLG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 --2013.02.19 추가" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        select max(nvl(spec.tare_wgt, 0)) mst_wgt" ).append("\n"); 
		query.append("        from mst_container mst," ).append("\n"); 
		query.append("          mst_cntr_spec spec" ).append("\n"); 
		query.append("        where mst.cntr_no = QT.CNTR_NO" ).append("\n"); 
		query.append("          and mst.cntr_spec_no = spec.cntr_spec_no ) mst_tare," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        select max(nvl(mdm.CNTR_TPSZ_TARE_WGT, 0)) mdm_wgt" ).append("\n"); 
		query.append("        from mdm_cntr_tp_sz mdm" ).append("\n"); 
		query.append("        where mdm.cntr_tpsz_cd = QT.TP ) mdm_tare" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , QT.CSTMS_DESC" ).append("\n"); 
		query.append("       , PKUP_NOD_CD" ).append("\n"); 
		query.append("       FROM ( " ).append("\n"); 
		query.append("          WITH COPY_T AS ( " ).append("\n"); 
		query.append("          SELECT ROWNUM NO" ).append("\n"); 
		query.append("            FROM BKG_BOOKING" ).append("\n"); 
		query.append("           WHERE ROWNUM<=1000 " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("          SELECT " ).append("\n"); 
		query.append("            BKG_NO," ).append("\n"); 
		query.append("            BL_NO," ).append("\n"); 
		query.append("            CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CNTR_NO END CNTR_NO," ).append("\n"); 
		query.append("            RCV_TERM_CD," ).append("\n"); 
		query.append("            DE_TERM_CD," ).append("\n"); 
		query.append("            CNTR_SEAL_NO," ).append("\n"); 
		query.append("            CNTR_WGT," ).append("\n"); 
		query.append("            ACT_WGT," ).append("\n"); 
		query.append("            PCK_QTY," ).append("\n"); 
		query.append("            PCK_TP_CD," ).append("\n"); 
		query.append("            CNTR_VOL_QTY," ).append("\n"); 
		query.append("            TOT," ).append("\n"); 
		query.append("            BKG_POR," ).append("\n"); 
		query.append("            BKG_POL," ).append("\n"); 
		query.append("            BKG_POD," ).append("\n"); 
		query.append("            BKG_DEL," ).append("\n"); 
		query.append("            POR_NOD_CD," ).append("\n"); 
		query.append("            POL_NOD_CD," ).append("\n"); 
		query.append("            POD_NOD_CD," ).append("\n"); 
		query.append("            DEL_NOD_CD," ).append("\n"); 
		query.append("            POL_CD," ).append("\n"); 
		query.append("            POL_YD_CD," ).append("\n"); 
		query.append("            POD_CD," ).append("\n"); 
		query.append("            POD_YD_CD," ).append("\n"); 
		query.append("            MEAS_QTY," ).append("\n"); 
		query.append("            CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("            TP," ).append("\n"); 
		query.append("            FM," ).append("\n"); 
		query.append("            NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CDG END,DG) DG," ).append("\n"); 
		query.append("            NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CRF END,RF) RF," ).append("\n"); 
		query.append("            NVL(CASE WHEN RN=1 AND NO>1 THEN NULL ELSE CAK END,AK) AK," ).append("\n"); 
		query.append("            SLAN_CD ," ).append("\n"); 
		query.append("            SKD_DIR_CD ," ).append("\n"); 
		query.append("            PRCT_FLG," ).append("\n"); 
		query.append("            BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("            HAMO_TRF_CD," ).append("\n"); 
		query.append("            STWG_CD," ).append("\n"); 
		query.append("            A_CNTR_WGT," ).append("\n"); 
		query.append("            BLCK_STWG_CD," ).append("\n"); 
		query.append("            HOT_DE_FLG," ).append("\n"); 
		query.append("            P_VVD," ).append("\n"); 
		query.append("            CUST_NM," ).append("\n"); 
		query.append("            SOC_FLG," ).append("\n"); 
		query.append("            ORG_YD_CD," ).append("\n"); 
		query.append("            CNMV_EVNT_DT," ).append("\n"); 
		query.append("            PREVVD1, " ).append("\n"); 
		query.append("            PREVVD2, " ).append("\n"); 
		query.append("            PREVVD3, " ).append("\n"); 
		query.append("            PREVVD4," ).append("\n"); 
		query.append("            TRUNKVVD, " ).append("\n"); 
		query.append("            POSTVVD1, " ).append("\n"); 
		query.append("            POSTVVD2, " ).append("\n"); 
		query.append("            POSTVVD3, " ).append("\n"); 
		query.append("            POSTVVD4," ).append("\n"); 
		query.append("            PRE1POL, " ).append("\n"); 
		query.append("            PRE2POL, " ).append("\n"); 
		query.append("            PRE3POL, " ).append("\n"); 
		query.append("            PRE4POL, " ).append("\n"); 
		query.append("            POST1POL, " ).append("\n"); 
		query.append("            POST2POL, " ).append("\n"); 
		query.append("            POST3POL, " ).append("\n"); 
		query.append("            POST4POL," ).append("\n"); 
		query.append("            TS_CD," ).append("\n"); 
		query.append("			RD_CGO_FLG," ).append("\n"); 
		query.append("            CSTMS_DESC," ).append("\n"); 
		query.append("            PKUP_NOD_CD" ).append("\n"); 
		query.append("          FROM ( " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("              BKG_NO," ).append("\n"); 
		query.append("              BL_NO," ).append("\n"); 
		query.append("              CNTR_SEAL_NO," ).append("\n"); 
		query.append("              CNTR_WGT," ).append("\n"); 
		query.append("              A_CNTR_WGT," ).append("\n"); 
		query.append("              ACT_WGT," ).append("\n"); 
		query.append("              PCK_QTY," ).append("\n"); 
		query.append("              PCK_TP_CD," ).append("\n"); 
		query.append("              CNTR_VOL_QTY," ).append("\n"); 
		query.append("              TOT," ).append("\n"); 
		query.append("              BKG_POR," ).append("\n"); 
		query.append("              BKG_POL," ).append("\n"); 
		query.append("              BKG_POD," ).append("\n"); 
		query.append("              BKG_DEL," ).append("\n"); 
		query.append("              POR_NOD_CD," ).append("\n"); 
		query.append("              POL_NOD_CD," ).append("\n"); 
		query.append("              POD_NOD_CD," ).append("\n"); 
		query.append("              DEL_NOD_CD," ).append("\n"); 
		query.append("              CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("              TP," ).append("\n"); 
		query.append("              FM," ).append("\n"); 
		query.append("              DG," ).append("\n"); 
		query.append("              RF," ).append("\n"); 
		query.append("              AK," ).append("\n"); 
		query.append("              CNTR_QTY," ).append("\n"); 
		query.append("              SLAN_CD," ).append("\n"); 
		query.append("              SKD_DIR_CD," ).append("\n"); 
		query.append("              PRCT_FLG," ).append("\n"); 
		query.append("              STWG_CD," ).append("\n"); 
		query.append("              BLCK_STWG_CD," ).append("\n"); 
		query.append("              HOT_DE_FLG," ).append("\n"); 
		query.append("              P_VVD," ).append("\n"); 
		query.append("              BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("              HAMO_TRF_CD," ).append("\n"); 
		query.append("              CUST_NM," ).append("\n"); 
		query.append("              SOC_FLG," ).append("\n"); 
		query.append("              CNTR_NO," ).append("\n"); 
		query.append("              RCV_TERM_CD," ).append("\n"); 
		query.append("              DE_TERM_CD," ).append("\n"); 
		query.append("              POL_CD," ).append("\n"); 
		query.append("              POL_YD_CD," ).append("\n"); 
		query.append("              POD_CD," ).append("\n"); 
		query.append("              POD_YD_CD," ).append("\n"); 
		query.append("              MEAS_QTY," ).append("\n"); 
		query.append("              ORG_YD_CD," ).append("\n"); 
		query.append("              CNMV_EVNT_DT," ).append("\n"); 
		query.append("              PREVVD1, " ).append("\n"); 
		query.append("              PREVVD2, " ).append("\n"); 
		query.append("              PREVVD3, " ).append("\n"); 
		query.append("              PREVVD4," ).append("\n"); 
		query.append("              TRUNKVVD, " ).append("\n"); 
		query.append("              POSTVVD1, " ).append("\n"); 
		query.append("              POSTVVD2, " ).append("\n"); 
		query.append("              POSTVVD3, " ).append("\n"); 
		query.append("              POSTVVD4," ).append("\n"); 
		query.append("              PRE1POL, " ).append("\n"); 
		query.append("              PRE2POL, " ).append("\n"); 
		query.append("              PRE3POL, " ).append("\n"); 
		query.append("              PRE4POL, " ).append("\n"); 
		query.append("              POST1POL, " ).append("\n"); 
		query.append("              POST2POL, " ).append("\n"); 
		query.append("              POST3POL, " ).append("\n"); 
		query.append("              POST4POL," ).append("\n"); 
		query.append("              CDG," ).append("\n"); 
		query.append("              CRF," ).append("\n"); 
		query.append("              CAK," ).append("\n"); 
		query.append("              TS_CD," ).append("\n"); 
		query.append("			  RD_CGO_FLG," ).append("\n"); 
		query.append("              ROW_NUMBER() OVER (PARTITION BY BKG_NO, TP ORDER BY CNTR_NO) RN," ).append("\n"); 
		query.append("              COUNT(CNTR_NO) OVER (PARTITION BY BKG_NO, TP ) CNT," ).append("\n"); 
		query.append("              CSTMS_DESC," ).append("\n"); 
		query.append("              PKUP_NOD_CD" ).append("\n"); 
		query.append("            FROM ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                QTY.BKG_NO  BKG_NO," ).append("\n"); 
		query.append("                BKG.BL_NO||BKG.BL_TP_CD BL_NO," ).append("\n"); 
		query.append("               (  SELECT MIN(NVL(CNTR_SEAL_NO,'')) " ).append("\n"); 
		query.append("                  FROM BKG_CNTR_SEAL_NO SEAL " ).append("\n"); 
		query.append("                  WHERE CNTR.BKG_NO = SEAL.BKG_NO(+) " ).append("\n"); 
		query.append("                  AND CNTR.CNTR_NO = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("               ) CNTR_SEAL_NO," ).append("\n"); 
		query.append("                ROUND(CNTR.CNTR_WGT/1000,0) CNTR_WGT," ).append("\n"); 
		query.append("                MAX(ROUND(CNTR.CNTR_WGT,0)) A_CNTR_WGT," ).append("\n"); 
		query.append("                DOC.ACT_WGT," ).append("\n"); 
		query.append("                CNTR.PCK_QTY," ).append("\n"); 
		query.append("                CNTR.PCK_TP_CD," ).append("\n"); 
		query.append("                CNTR.CNTR_VOL_QTY," ).append("\n"); 
		query.append("--               (  SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)) TOT " ).append("\n"); 
		query.append("--                  FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("--                  WHERE BC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("--               ) TOT," ).append("\n"); 
		query.append("               (  SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)*OP_CNTR_QTY) TOT " ).append("\n"); 
		query.append("                  FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                  WHERE BQ.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                  AND	BQ.CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("                  AND	BQ.CNTR_TPSZ_CD != 'Q4'" ).append("\n"); 
		query.append("               ) TOT," ).append("\n"); 
		query.append("                BKG.POR_CD  BKG_POR," ).append("\n"); 
		query.append("                BKG.POL_CD  BKG_POL," ).append("\n"); 
		query.append("                BKG.POD_CD  BKG_POD," ).append("\n"); 
		query.append("                BKG.DEL_CD  BKG_DEL," ).append("\n"); 
		query.append("                SUBSTR(BKG.POR_NOD_CD,6,2) POR_NOD_CD," ).append("\n"); 
		query.append("                SUBSTR(BKG.POL_NOD_CD,6,2) POL_NOD_CD," ).append("\n"); 
		query.append("                SUBSTR(BKG.POD_NOD_CD,6,2) POD_NOD_CD," ).append("\n"); 
		query.append("                SUBSTR(BKG.DEL_NOD_CD,6,2) DEL_NOD_CD," ).append("\n"); 
		query.append("                VVD.POL_CD POL_CD," ).append("\n"); 
		query.append("                SUBSTR(VVD.POL_YD_CD,6,2) POL_YD_CD," ).append("\n"); 
		query.append("                VVD.POD_CD POD_CD," ).append("\n"); 
		query.append("                SUBSTR(VVD.POD_YD_CD,6,2) POD_YD_CD," ).append("\n"); 
		query.append("                BKG.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("                VVD.POD_CD  POD," ).append("\n"); 
		query.append("                QTY.CNTR_TPSZ_CD TP," ).append("\n"); 
		query.append("                NVL(BKG.BKG_CGO_TP_CD,' ') FM," ).append("\n"); 
		query.append("                BKG.DCGO_FLG     DG," ).append("\n"); 
		query.append("                BKG.RC_FLG  RF," ).append("\n"); 
		query.append("                BKG.AWK_CGO_FLG  AK," ).append("\n"); 
		query.append("                QTY.OP_CNTR_QTY  CNTR_QTY," ).append("\n"); 
		query.append("                VVD.SLAN_CD      SLAN_CD," ).append("\n"); 
		query.append("                VVD.SKD_DIR_CD   SKD_DIR_CD," ).append("\n"); 
		query.append("                PVVD.VSL_CD||PVVD.SKD_VOY_NO||PVVD.SKD_DIR_CD P_VVD," ).append("\n"); 
		query.append("                REPLACE(TRANSLATE(NVL(BCS.CUST_NM,' '),CHR(10),' '),'''',' ') CUST_NM ," ).append("\n"); 
		query.append("                BKG.PRCT_FLG     PRCT_FLG," ).append("\n"); 
		query.append("                BKG.STWG_CD      STWG_CD," ).append("\n"); 
		query.append("                BKG.BLCK_STWG_CD      BLCK_STWG_CD," ).append("\n"); 
		query.append("                HOT_DE_FLG," ).append("\n"); 
		query.append("                '' BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("                CNTR.CNTR_NO     CNTR_NO," ).append("\n"); 
		query.append("                CNTR.DCGO_FLG    CDG," ).append("\n"); 
		query.append("                CNTR.RC_FLG      CRF," ).append("\n"); 
		query.append("                CNTR.AWK_CGO_FLG CAK," ).append("\n"); 
		query.append("                CNTR.MEAS_QTY*1000 MEAS_QTY,          " ).append("\n"); 
		query.append("                NVL(CM.HAMO_TRF_CD,CM.CMDT_HS_CD) HAMO_TRF_CD,	" ).append("\n"); 
		query.append("                CNTR.SOC_FLG," ).append("\n"); 
		query.append("                CNTR.RCV_TERM_CD," ).append("\n"); 
		query.append("                CNTR.DE_TERM_CD," ).append("\n"); 
		query.append("                (SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                	nvl(ORG_YD_CD,' ') ORG_YD_CD" ).append("\n"); 
		query.append("                 FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("                 WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                 AND    MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("--                 AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("                 AND    CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                 AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) ORG_YD_CD," ).append("\n"); 
		query.append("                (SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                	to_char(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("                 FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("                 WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                 AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("--                 AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("                 AND    CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                 AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) CNMV_EVNT_DT," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD1," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD2," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD3," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD4," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.POL_CD))) PRE1POL," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.POL_CD))) PRE2POL," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.POL_CD))) PRE3POL," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.POL_CD))) PRE4POL," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'T',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD)) TRUNKVVD," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD1," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD2," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD3," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD4," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.POL_CD))) POST1POL," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.POL_CD))) POST2POL," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.POL_CD))) POST3POL," ).append("\n"); 
		query.append("                MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.POL_CD))) POST4POL," ).append("\n"); 
		query.append("                DECODE(BKG.POL_CD,VVD.POL_CD,'L','T') TS_CD," ).append("\n"); 
		query.append("                DECODE(SUBSTR(MAX(CNTR.CNTR_TPSZ_CD),1,1),'R',MAX(CNTR.RD_CGO_FLG),'N') AS RD_CGO_FLG,--tank reefer 는 Y, Y 들어감" ).append("\n"); 
		query.append("                MAX(DOC.CSTMS_DESC) CSTMS_DESC," ).append("\n"); 
		query.append("                (SELECT D.NOD_CD" ).append("\n"); 
		query.append("                   FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                  WHERE H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("                    AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                    AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("                    AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                    AND D.COP_DTL_SEQ = (SELECT MAX(COP_DTL_SEQ) FROM SCE_COP_DTL WHERE COP_NO = H.COP_NO AND ACT_CD LIKE 'FI%DO' AND SUBSTR(NOD_CD, 1, 2) IN ('US','CA'))" ).append("\n"); 
		query.append("                ) PKUP_NOD_CD" ).append("\n"); 
		query.append("              FROM BKG_VVD  VVD, " ).append("\n"); 
		query.append("                   BKG_VVD BKGVVD,  " ).append("\n"); 
		query.append("                   BKG_VVD PVVD, " ).append("\n"); 
		query.append("                   BKG_BOOKING   BKG, " ).append("\n"); 
		query.append("                   BKG_BL_DOC    DOC, " ).append("\n"); 
		query.append("                   BKG_QUANTITY  QTY, " ).append("\n"); 
		query.append("                   --TRS_BLCK_STWG_DEST TBSD, " ).append("\n"); 
		query.append("                   BKG_CNTR_MF_DESC CM," ).append("\n"); 
		query.append("                   BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("                   BKG_CUSTOMER BCS" ).append("\n"); 
		query.append("                 ,(SELECT TRIM(COLUMN_VALUE) AS VVD_CD FROM table(BKG_SPLIT_FNC(@[in_vvd_cd],','))) TEMP " ).append("\n"); 
		query.append("             WHERE VVD.VSL_CD     = SUBSTR(TEMP.VVD_CD,1,4)" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO = SUBSTR(TEMP.VVD_CD,5,4)" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD = SUBSTR(TEMP.VVD_CD,9,1)" ).append("\n"); 
		query.append("               AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("		#if (${in_pol_yd_cd} != '' ) " ).append("\n"); 
		query.append("               AND SUBSTR(VVD.POL_YD_CD,6,2) = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pod_cd} != '' ) " ).append("\n"); 
		query.append("               AND VVD.POD_CD LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("               AND SUBSTR(VVD.POD_YD_CD,6,2) = @[in_pod_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pol_ts} != '' ) " ).append("\n"); 
		query.append("               AND DECODE(BKG.POL_CD,VVD.POL_CD,'L','T') = @[in_pol_ts]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("               AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("               AND BKG.BKG_STS_CD  <> 'X'" ).append("\n"); 
		query.append("               AND BKG.BKG_NO  = DOC.BKG_NO" ).append("\n"); 
		query.append("               AND BKG.BKG_NO  = QTY.BKG_NO" ).append("\n"); 
		query.append("               AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("               AND QTY.BKG_NO  = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("               AND QTY.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD(+) " ).append("\n"); 
		query.append("               --AND BKG.POD_CD = TBSD.BLCK_STWG_PORT_LOC_CD (+)" ).append("\n"); 
		query.append("               --AND BKG.DEL_CD = TBSD.BLCK_STWG_DEST_LOC_CD (+)" ).append("\n"); 
		query.append("               AND VVD.BKG_NO = PVVD.BKG_NO (+)" ).append("\n"); 
		query.append("               AND PVVD.POD_CD (+) = @[in_pol_cd]" ).append("\n"); 
		query.append("			   AND PVVD.VSL_PRE_PST_CD(+) || PVVD.VSL_SEQ(+) < VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ" ).append("\n"); 
		query.append("               AND CNTR.BKG_NO = CM.BKG_NO (+)	" ).append("\n"); 
		query.append("               AND CNTR.CNTR_NO = CM.CNTR_NO (+)	" ).append("\n"); 
		query.append("               AND CM.CNTR_MF_SEQ (+) = 1	" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = BKGVVD.BKG_NO" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("               AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("	#if (${in_ofc_cd_type} == 'B' ) " ).append("\n"); 
		query.append("		#if (${in_ofc_cd} != '' ) " ).append("\n"); 
		query.append("			AND BKG.BKG_OFC_CD = @[in_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		#if (${in_ofc_cd} != '' ) " ).append("\n"); 
		query.append("			AND BKG.OB_SLS_OFC_CD = @[in_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_bkg_sts_cd} == 'A' )" ).append("\n"); 
		query.append("		AND NVL(BKG.BKG_STS_CD,' ') NOT IN ('X','A')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${in_bkg_sts_cd} != '' ) " ).append("\n"); 
		query.append("			AND BKG.BKG_STS_CD = @[in_bkg_sts_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_bkg_cgo_tp_cd} != '' && ${in_bkg_cgo_tp_cd} != 'A' ) " ).append("\n"); 
		query.append("		AND BKG.BKG_CGO_TP_CD IN (${in_bkg_cgo_tp_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_cntr_cfm_flg} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.CNTR_CFM_FLG = @[in_cntr_cfm_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_cntr_tpsz_cd} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.CNTR_TPSZ_CD IN (${in_cntr_tpsz_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_por_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.POR_CD LIKE @[in_por_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_del_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.DEL_CD LIKE @[in_del_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_rcv_term_cd} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.RCV_TERM_CD IN (${in_rcv_term_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_de_term_cd} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.DE_TERM_CD IN (${in_de_term_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_org_trns_svd_mod_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.ORG_TRNS_SVC_MOD_CD IN (${in_org_trns_svd_mod_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_dest_trns_svc_mod_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.DEST_TRNS_SVC_MOD_CD IN (${in_dest_trns_svc_mod_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_dcgo_flg} == '' && ${in_rc_flg} == '' && ${in_awk_cgo_flg} == '' && ${in_bb_cgo_flg} == '' && ${in_stwg_cd} == '' && ${in_hot_de_flg} == '' && ${in_rd_cgo_flg} == '' && ${in_soc_flg} == '' && ${in_prct_flg} == '' )" ).append("\n"); 
		query.append("		AND '1' = '1'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND ( '1' = '2' " ).append("\n"); 
		query.append("		#if (${in_dcgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.DCGO_FLG = @[in_dcgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_rc_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.RC_FLG = @[in_rc_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_awk_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.AWK_CGO_FLG = @[in_awk_cgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_bb_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.BB_CGO_FLG = @[in_bb_cgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_stwg_cd} != '' ) " ).append("\n"); 
		query.append("			OR BKG.STWG_CD IS NOT NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_hot_de_flg} != '' ) " ).append("\n"); 
		query.append("			OR BKG.HOT_DE_FLG = @[in_hot_de_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_rd_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR (SUBSTR(CNTR.CNTR_TPSZ_CD,1,1)='R' AND CNTR.RD_CGO_FLG = @[in_rd_cgo_flg])" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_soc_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.SOC_FLG = @[in_soc_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_prct_flg} != '' ) " ).append("\n"); 
		query.append("			OR BKG.PRCT_FLG = @[in_prct_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_scc_cd} != '' ) " ).append("\n"); 
		query.append("		AND MDM.SCC_CD = @[in_scc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("             GROUP BY QTY.BKG_NO," ).append("\n"); 
		query.append("                      QTY.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      QTY.OP_CNTR_QTY," ).append("\n"); 
		query.append("                      BKG.BKG_NO," ).append("\n"); 
		query.append("                      BKG.BL_NO," ).append("\n"); 
		query.append("                      BKG.BL_TP_CD," ).append("\n"); 
		query.append("                      BKG.POR_CD," ).append("\n"); 
		query.append("                      BKG.POL_CD," ).append("\n"); 
		query.append("                      BKG.POD_CD," ).append("\n"); 
		query.append("                      BKG.DEL_CD," ).append("\n"); 
		query.append("                      BKG.POR_NOD_CD," ).append("\n"); 
		query.append("                      BKG.POL_NOD_CD," ).append("\n"); 
		query.append("                      BKG.POD_NOD_CD," ).append("\n"); 
		query.append("                      BKG.DEL_NOD_CD," ).append("\n"); 
		query.append("                      BKG.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("                      BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                      BKG.DCGO_FLG," ).append("\n"); 
		query.append("                      BKG.RC_FLG," ).append("\n"); 
		query.append("                      BKG.PRCT_FLG," ).append("\n"); 
		query.append("                      BKG.STWG_CD," ).append("\n"); 
		query.append("                      BKG.HOT_DE_FLG," ).append("\n"); 
		query.append("                      BKG.AWK_CGO_FLG," ).append("\n"); 
		query.append("                      BKG.BLCK_STWG_CD," ).append("\n"); 
		query.append("                      BCS.CUST_NM," ).append("\n"); 
		query.append("                      DOC.ACT_WGT," ).append("\n"); 
		query.append("                      VVD.POL_CD," ).append("\n"); 
		query.append("                      VVD.POD_CD," ).append("\n"); 
		query.append("                      VVD.POL_YD_CD," ).append("\n"); 
		query.append("                      VVD.POD_YD_CD," ).append("\n"); 
		query.append("                      VVD.SLAN_CD," ).append("\n"); 
		query.append("                      VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("                      CNTR.BKG_NO," ).append("\n"); 
		query.append("                      CNTR.CNTR_WGT," ).append("\n"); 
		query.append("                      CNTR.PCK_QTY," ).append("\n"); 
		query.append("                      CNTR.PCK_TP_CD," ).append("\n"); 
		query.append("                      CNTR.CNTR_VOL_QTY," ).append("\n"); 
		query.append("                      CNTR.SOC_FLG," ).append("\n"); 
		query.append("                      CNTR.RCV_TERM_CD," ).append("\n"); 
		query.append("                      CNTR.DE_TERM_CD," ).append("\n"); 
		query.append("                      CNTR.CNTR_NO," ).append("\n"); 
		query.append("                      CNTR.DCGO_FLG," ).append("\n"); 
		query.append("                      CNTR.RC_FLG," ).append("\n"); 
		query.append("                      CNTR.AWK_CGO_FLG," ).append("\n"); 
		query.append("                      CNTR.MEAS_QTY," ).append("\n"); 
		query.append("                      CNTR.CNMV_CYC_NO," ).append("\n"); 
		query.append("                      PVVD.VSL_CD," ).append("\n"); 
		query.append("                      PVVD.SKD_VOY_NO," ).append("\n"); 
		query.append("                      PVVD.SKD_DIR_CD," ).append("\n"); 
		query.append("                      CM.HAMO_TRF_CD,CM.CMDT_HS_CD" ).append("\n"); 
		query.append("                      --TBSD.BLCK_STWG_HUB_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("        )      QTY, " ).append("\n"); 
		query.append("        COPY_T C" ).append("\n"); 
		query.append("       WHERE " ).append("\n"); 
		query.append("             -- CNTR_QTY >= RN AND" ).append("\n"); 
		query.append("             DECODE(QTY.RN,1,CNTR_QTY - DECODE(QTY.CNT,0,0,QTY.CNT-1)) >= C.NO(+) " ).append("\n"); 
		query.append("     )    QT, " ).append("\n"); 
		query.append("     MDM_CNTR_TP_SZ TP" ).append("\n"); 
		query.append("    WHERE QT.TP = TP.CNTR_TPSZ_CD(+) " ).append("\n"); 
		query.append("	#if (${in_pkup_nod_cd} != '' ) " ).append("\n"); 
		query.append("		AND PKUP_NOD_CD = @[in_pkup_nod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("  )  QT" ).append("\n"); 
		query.append("#if (${in_order_by_type} == '' ) " ).append("\n"); 
		query.append("ORDER BY POL_CD, POD_CD, CNTR_NO, BKG_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("ORDER BY ${in_order_by_type}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}