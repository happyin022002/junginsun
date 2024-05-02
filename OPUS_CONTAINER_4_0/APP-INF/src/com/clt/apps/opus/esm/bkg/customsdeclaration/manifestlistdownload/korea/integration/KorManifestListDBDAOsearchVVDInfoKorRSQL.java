/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorManifestListDBDAOsearchVVDInfoKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.13 
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

public class KorManifestListDBDAOsearchVVDInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 정보 조회
	  * 2011.04.13 김영철 [CHM-201109147-01] 1) Save 이벤트에서 화면 Receiver항목 저장  2) 화면 조회 항목 추가: Send Date/Time 뒤에 Receiver 표기
	  * </pre>
	  */
	public KorManifestListDBDAOsearchVVDInfoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_snd_rcvr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_ts_mty_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_ts_mty_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_ts_mty_45ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_notice",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_pre_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smp_bl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchVVDInfoKorRSQL").append("\n"); 
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
		query.append("SELECT KV.MRN_NO||KV.MRN_CHK_NO MRN_NO,  /** MRN NO **/ " ).append("\n"); 
		query.append("KV.vsl_cd||KV.skd_voy_no||KV.skd_dir_cd VVD,  /** VVD **/ " ).append("\n"); 
		query.append("KV.VVD_SEQ VVD_SEQ,  /** :kv_seq **/ " ).append("\n"); 
		query.append("KV.VSL_CNT_CD VSL_CNT_CD, /** VSL Country **/ " ).append("\n"); 
		query.append("KV.IO_BND_CD IO_BND_CD, /** :mrn_type **/ " ).append("\n"); 
		query.append("DECODE(KV.IO_BND_CD, 'O', KV.PORT_CD) POL_CD, /** POL **/ " ).append("\n"); 
		query.append("DECODE(KV.IO_BND_CD, 'I', KV.PORT_CD) POD_CD, /** POD **/ " ).append("\n"); 
		query.append("TO_CHAR(KV.ETA_DT, 'YYYY-MM-DD') ETA_DT, /** ETA **/ " ).append("\n"); 
		query.append("TO_CHAR(KV.ETD_DT, 'YYYY-MM-DD HH24:MI') ETD_DT, /** ETD **/ " ).append("\n"); 
		query.append("@[f_date] F_DATE, /** Send Date / Time **/ " ).append("\n"); 
		query.append("@[t_date] T_DATE, /** Send Date / Time **/ " ).append("\n"); 
		query.append("@[mf_snd_rcvr_id] MF_SND_RCVR_ID, /** MF_SND_RCVR_ID **/ " ).append("\n"); 
		query.append("COM_ConstantMgr_PKG.COM_getScacCode_FNC() SHP_CO_CD, /** Shipping Co. Code **/ " ).append("\n"); 
		query.append("DECODE(KV.LOCL_CSTMS_CD,NULL,DECODE(KV.PORT_CD,'KRINC','020','KRGIN', '020', 'KRPUS', '030', 'KRKAN', '062','KRPTK','016'),KV.LOCL_CSTMS_CD) LOCL_CSTMS_CD, /** Local Customs **/ " ).append("\n"); 
		query.append("DECODE(KV.LOCL_CSTMS_PRT_CD,NULL,DECODE(KV.PORT_CD,'KRINC','10','KRGIN','10','KRPUS', DECODE(KV.IO_BND_CD,'I', '27','10'), 'KRKAN', '10','KRPTK','10'),KV.LOCL_CSTMS_PRT_CD) LOCL_CSTMS_PRT_CD, /** Local Customs **/ " ).append("\n"); 
		query.append("KV.JO_CRR_KNT JO_CRR_KNT, /** Joint Ship Count **/ " ).append("\n"); 
		query.append("KV.TTL_WGT TTL_WGT, /** Weight **/ " ).append("\n"); 
		query.append("'KGS' TTL_WGT_UT_CD, /** Weight **/ " ).append("\n"); 
		query.append("KV.TTL_PCK_QTY TTL_PCK_QTY, /** Package **/ " ).append("\n"); 
		query.append("'BG' TTL_PCK_UT_CD, /** Package **/ " ).append("\n"); 
		query.append("KV.TTL_MEAS_QTY TTL_MEAS_QTY, /** Measure **/ " ).append("\n"); 
		query.append("'CBM' TTL_MEAS_UT_CD, /** Measure **/ " ).append("\n"); 
		query.append("KV.MST_BL_KNT MST_BL_KNT, /** Master B/L Total **/ " ).append("\n"); 
		query.append("KV.MTY_BL_KNT MTY_BL_KNT, /** Empty B/L Total **/ " ).append("\n"); 
		query.append("KV.CNSL_BL_KNT CNSL_BL_KNT, /** Consol B/L Total **/ " ).append("\n"); 
		query.append("@[smp_bl_knt] SMP_BL_KNT, /** Simple B/L Total **/ " ).append("\n"); 
		query.append("KV.TTL_FULL_KNT TTL_FULL_KNT, /** Full CNTR Total **/ " ).append("\n"); 
		query.append("KV.TTL_MTY_KNT TTL_MTY_KNT, /** Empty CNTR Total **/ " ).append("\n"); 
		query.append("DECODE(KV.PORT_CD,'KRPUS','030197004','KRKAN','062112001','KRINC','020104002','KRPTK','016105001','KRUSN','110109004','KRGIN','020112001','030197004') CSTMS_DCHG_CD, /** Discharge Company **/" ).append("\n"); 
		query.append("KV.VSL_NM VSL_NM, /** Vessel Full Name **/ " ).append("\n"); 
		query.append("KV.KR_VSL_CALL_SGN_CD VSL_CALL_SGN_CD, /** Call Sign **/ " ).append("\n"); 
		query.append("KV.TTL_LC_TEU_QTY TTL_LC_TEU_QTY, " ).append("\n"); 
		query.append("KV.TTL_TS_TEU_QTY TTL_TS_TEU_QTY, " ).append("\n"); 
		query.append("KV.TTL_MTY_TEU_QTY TTL_MTY_TEU_QTY, " ).append("\n"); 
		query.append("KV.TTL_LC_FEU_QTY TTL_LC_FEU_QTY, " ).append("\n"); 
		query.append("KV.TTL_TS_FEU_QTY TTL_TS_FEU_QTY, " ).append("\n"); 
		query.append("KV.TTL_MTY_FEU_QTY TTL_MTY_FEU_QTY, " ).append("\n"); 
		query.append("KV.TTL_LC_45FT_QTY TTL_LC_45FT_QTY, " ).append("\n"); 
		query.append("KV.TTL_TS_45FT_QTY TTL_TS_45FT_QTY, " ).append("\n"); 
		query.append("KV.TTL_MTY_45FT_QTY TTL_MTY_45FT_QTY, " ).append("\n"); 
		query.append("@[ttl_ts_mty_teu_qty] TTL_TS_MTY_TEU_QTY,                   " ).append("\n"); 
		query.append("@[ttl_ts_mty_feu_qty] TTL_TS_MTY_FEU_QTY,                   " ).append("\n"); 
		query.append("@[ttl_ts_mty_45ft_qty] TTL_TS_MTY_45FT_QTY,                 " ).append("\n"); 
		query.append("@[bd_area_cd] BD_AREA_CD, /** Bond Area Code **/ " ).append("\n"); 
		query.append("NVL(CALL_KNT,0) CALL_KNT, /** 입항 횟수 **/ " ).append("\n"); 
		query.append("NVL(DCHG_MZD_CD,'2') DCHG_MZD_CD, /** 하역방법 Code **/ " ).append("\n"); 
		query.append("IO_TML_LOC_CD, /** 반출입부두 Code **/ " ).append("\n"); 
		query.append("DECODE(KV.PORT_CD,'KRPUS', 20, 'KRGIN', 50,'KRINC',30,'KRKAN',622,'KRPTK',31,0) KT_PA, /** kt_pa **/ " ).append("\n"); 
		query.append("TO_CHAR(KV.ETA_DT,'YYYY') CALL_YEAR, /** call_year **/ " ).append("\n"); 
		query.append("@[trans_pre_cnt] TRANS_PRE_CNT," ).append("\n"); 
		query.append("@[whf_notice] WHF_NOTICE" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY KV " ).append("\n"); 
		query.append("WHERE KV.VSL_CD        = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("AND KV.SKD_VOY_NO    = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("AND KV.SKD_DIR_CD    = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("AND KV.MRN_NO        = @[mrn_no] " ).append("\n"); 
		query.append("AND KV.MRN_CHK_NO    = @[mrn_chk_no] " ).append("\n"); 
		query.append("#if(${in_type}!='D') " ).append("\n"); 
		query.append("AND KV.OB_DECL_TP_CD = @[in_type] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND KV.VVD_SEQ       = @[vvd_seq]" ).append("\n"); 

	}
}