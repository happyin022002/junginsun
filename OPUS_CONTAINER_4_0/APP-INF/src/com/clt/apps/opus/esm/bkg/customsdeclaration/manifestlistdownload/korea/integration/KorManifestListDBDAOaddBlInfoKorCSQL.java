/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOaddBlInfoKorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddBlInfoKorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세관신고 Table에 B/L 정보를 Insert
	  * </pre>
	  */
	public KorManifestListDBDAOaddBlInfoKorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("desc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("desc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("username",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("us_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_tmnl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whouse_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whouse",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pkg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_mty_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pol_tmnl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_actwgt_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_mea_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_rep",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("a_imo_class1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_dmst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_imo_class2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_imo_class3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fford_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bond_area_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_mty_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msn_bltp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOaddBlInfoKorCSQL").append("\n"); 
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
		query.append("INSERT " ).append("\n"); 
		query.append("  INTO BKG_CSTMS_KR_BL " ).append("\n"); 
		query.append("     ( BKG_NO, CSTMS_DECL_TP_CD, TRNS_SEQ, KR_BL_AMDT_STS_CD, BL_NO, POR_CD, POL_CD, " ).append("\n"); 
		query.append("       POD_CD, DEL_CD, MST_BL_SEQ_NO, KR_CSTMS_BL_TP_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, " ).append("\n"); 
		query.append("       TS_POL_CD, TS_POD_CD, PCK_QTY, PCK_TP_CD, CNTR_TTL_WGT, WGT_UT_CD, MEAS_QTY, " ).append("\n"); 
		query.append("       BL_MEAS_UT_CD, BD_AREA_CD, IMDG_CLSS_CD, KR_CSTMS_WH_TP_CD, KR_WH_CD, " ).append("\n"); 
		query.append("       CGO_DESC1, CGO_DESC2, CRE_DT, CRE_USR_ID, UPD_DT, UPD_USR_ID, FRT_FWRD_CD, BKG_CGO_TP_CD, " ).append("\n"); 
		query.append("       KR_CSTMS_BND_CD, DMST_PORT_CD, CMDT_CD, KR_MEAS_UT_CD, N2ND_IMDG_CLSS_CD, " ).append("\n"); 
		query.append("       N3RD_IMDG_CLSS_CD, PORT_TML_CD, CGO_TRSP_CD, CSTMS_BL_NO, ETA_DT, ETD_DT, " ).append("\n"); 
		query.append("       IB_MTY_BKG_NO, IB_MTY_BL_NO, IB_TRNS_SEQ, IB_CSTMS_DECL_TP_CD, " ).append("\n"); 
		query.append("       IB_DMST_PORT_CD, IB_VSL_CD, IB_SKD_VOY_NO, IB_SKD_DIR_CD, IB_ETA_DT, BB_CGO_WGT, BB_CGO_MEAS_QTY, EVNT_YD_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("    ( @[bkg_no]" ).append("\n"); 
		query.append("    , DECODE(@[expt_kcd_tp], 'R', 'R', 'T', 'T', @[kcd_tp])" ).append("\n"); 
		query.append("    , @[kt_seq]" ).append("\n"); 
		query.append("    , @[kt_sts]" ).append("\n"); 
		query.append("    , SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("    , @[bkg_por]" ).append("\n"); 
		query.append("    , @[bkg_pol]" ).append("\n"); 
		query.append("    , @[bkg_pod]" ).append("\n"); 
		query.append("    , @[bkg_del]" ).append("\n"); 
		query.append("    , @[msn]" ).append("\n"); 
		query.append("    , DECODE(@[bkg_cgo_tp], 'P', 'E', @[msn_bltp])" ).append("\n"); 
		query.append("    , SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("    , SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("    , SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("    , @[vvd_pol]" ).append("\n"); 
		query.append("    , @[vvd_pod]" ).append("\n"); 
		query.append("    , @[pck_qty]" ).append("\n"); 
		query.append("    , DECODE(@[bkg_cgo_tp], 'P', 'CN', @[bkg_pkg_cd])" ).append("\n"); 
		query.append("    , @[act_wgt]" ).append("\n"); 
		query.append("    , @[bkg_actwgt_tp]" ).append("\n"); 
		query.append("    , @[meas_qty]" ).append("\n"); 
		query.append("    , @[bkg_mea_tp]" ).append("\n"); 
		query.append("    , @[bond_area_code]" ).append("\n"); 
		query.append("    , NVL(@[a_imo_class1], ' ')" ).append("\n"); 
		query.append("    , @[whouse]" ).append("\n"); 
		query.append("    , @[whouse_desc]" ).append("\n"); 
		query.append("    , DECODE(@[bkg_cgo_tp], 'P', 'EMPTY', nvl(BKG_SPCLCHAR_CONV_FNC(@[desc1], 'Y'), ' '))" ).append("\n"); 
		query.append("    , NVL(BKG_SPCLCHAR_CONV_FNC(@[desc2], 'Y'), ' ')" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[username]" ).append("\n"); 
		query.append("    , SYSDATE    " ).append("\n"); 
		query.append("    , @[username]" ).append("\n"); 
		query.append("    , NVL(@[fford_cd], ' ')" ).append("\n"); 
		query.append("    , @[bkg_cgo_tp]" ).append("\n"); 
		query.append("    , @[us_bound] " ).append("\n"); 
		query.append("    , @[kt_port]" ).append("\n"); 
		query.append("    , @[cmdt_rep]" ).append("\n"); 
		query.append("    , 'M'" ).append("\n"); 
		query.append("    , NVL(@[a_imo_class2], ' ')" ).append("\n"); 
		query.append("    , NVL(@[a_imo_class3], ' ')" ).append("\n"); 
		query.append("    , @[vvd_pod_tmnl_cd]" ).append("\n"); 
		query.append("    , DECODE(@[kcd_tp], 'I', DECODE(@[vvd_pod], 'KRPUS', DECODE(@[vvd_pod], @[bkg_pod], '', DECODE(SUBSTR(@[bkg_pod], 1, 2), 'KR', '1', '')), 'KRKAN', DECODE(@[vvd_pod], @[bkg_pod], '', DECODE(SUBSTR(@[bkg_pod], 1, 2), 'KR', '1', '')), ''), '')" ).append("\n"); 
		query.append("    , @[c_bl_no]" ).append("\n"); 
		query.append("    , TO_DATE(@[eta_dt], 'YYYYMMDD hh24:mi')" ).append("\n"); 
		query.append("    , TO_DATE(@[etd_dt], 'YYYYMMDD hh24:mi')" ).append("\n"); 
		query.append("    , @[ib_mty_bkg_no]" ).append("\n"); 
		query.append("    , @[ib_mty_bl_no]" ).append("\n"); 
		query.append("    , @[ib_trns_seq]" ).append("\n"); 
		query.append("    , @[ib_cstms_decl_tp_cd]" ).append("\n"); 
		query.append("    , @[ib_dmst_port_cd]" ).append("\n"); 
		query.append("    , @[ib_vsl_cd]" ).append("\n"); 
		query.append("    , @[ib_skd_voy_no]" ).append("\n"); 
		query.append("    , @[ib_skd_dir_cd]" ).append("\n"); 
		query.append("    , TO_DATE(@[ib_eta_dt], 'YYYYMMDD hh24:mi')" ).append("\n"); 
		query.append("	, (SELECT NVL(SUM(CNTR_WGT), 0)" ).append("\n"); 
		query.append("	  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("	  WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("      AND  BB_CGO_FLG= 'Y')" ).append("\n"); 
		query.append("    , (SELECT NVL(SUM(MEAS_QTY), 0)" ).append("\n"); 
		query.append("	  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("	  WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("      AND  BB_CGO_FLG= 'Y')" ).append("\n"); 
		query.append("    , @[vvd_pol_tmnl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}