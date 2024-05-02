/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KorManifestListDAOSearchNoneBLVVDInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDAOSearchNoneBLVVDInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L 이 없는 공동 VVD 를 조회
	  * 2011.04.13 김영철 [CHM-201109147-01] 1) Save 이벤트에서 화면 Receiver항목 저장  2) 화면 조회 항목 추가: Send Date/Time 뒤에 Receiver 표기
	  * </pre>
	  */
	public KorManifestListDAOSearchNoneBLVVDInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDAOSearchNoneBLVVDInfoRSQL").append("\n"); 
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
		query.append("SELECT mani.MRN_NO||mani.MRN_CHK_NO                 MRN_NO" ).append("\n"); 
		query.append(", mani.VSL_CD || mani.skd_voy_no || mani.skd_dir_cd VVD" ).append("\n"); 
		query.append(", vsl.CLPT_IND_SEQ                                  VVD_SEQ" ).append("\n"); 
		query.append(", v.VSL_ENG_NM                                      VSL_NM" ).append("\n"); 
		query.append(", v.VSL_RGST_CNT_CD                                 VSL_CNT_CD       " ).append("\n"); 
		query.append(", 'SMLM'                                            SHP_CO_CD" ).append("\n"); 
		query.append(", v.CALL_SGN_NO                                     VSL_CALL_SGN_CD" ).append("\n"); 
		query.append(", DECODE(mani.PORT_CD,'KRPUS','030197004','KRKAN','062112001','KRINC','020116001','KRPTK','016105001','KRUSN','110109004','KRGIN','020112001','030197004') CSTMS_DCHG_CD" ).append("\n"); 
		query.append(", DECODE(mani.IO_BND_CD, 'O', mani.PORT_CD) POL_CD /** POL **/ " ).append("\n"); 
		query.append(", DECODE(mani.IO_BND_CD, 'I', mani.PORT_CD) POD_CD /** POD **/ " ).append("\n"); 
		query.append(", NVL(TO_CHAR(vsl.vps_eta_dt,'YYYY-MM-DD'),' ') ETA_DT" ).append("\n"); 
		query.append(", NVL(TO_CHAR(vsl.vps_etd_dt,'YYYY-MM-DD HH24MI'),' ') ETD_DT" ).append("\n"); 
		query.append(", DECODE(mani.PORT_CD,'KRPUS',20,'KRINC',30,'KRKAN',622,'KRPTK',31,'KRUSN',820,0) KT_PA /** kt_pa **/ " ).append("\n"); 
		query.append("-- Manifest Information " ).append("\n"); 
		query.append(", '' F_DATE" ).append("\n"); 
		query.append(", '' T_DATE" ).append("\n"); 
		query.append(", '' MF_SND_RCVR_ID" ).append("\n"); 
		query.append(", '' BD_AREA_CD" ).append("\n"); 
		query.append(", '' CALL_KNT" ).append("\n"); 
		query.append(", '' IO_TML_LOC_CD" ).append("\n"); 
		query.append("-- Detail(s) Information" ).append("\n"); 
		query.append(", DECODE(@[port_cd],'KRINC', '020', 'KRPUS', '030', 'KRKAN', '062','KRPTK','016','KRUSN','110') LOCL_CSTMS_CD /** Local Customs **/ " ).append("\n"); 
		query.append(", DECODE(@[port_cd],'KRINC', '10', 'KRPUS', DECODE(@[io_bnd_cd],'I', '27','10'), 'KRKAN', '10','KRPTK','10','KRUSN','10') LOCL_CSTMS_PRT_CD /** Local Customs **/ " ).append("\n"); 
		query.append(", '' MST_BL_KNT" ).append("\n"); 
		query.append(", '' TTL_WGT" ).append("\n"); 
		query.append(", '' TTL_WGT_UT_CD" ).append("\n"); 
		query.append(", '' MTY_BL_KNT" ).append("\n"); 
		query.append(", '' TTL_PCK_QTY" ).append("\n"); 
		query.append(", '' TTL_PCK_UT_CD" ).append("\n"); 
		query.append(", '' CNSL_BL_KNT" ).append("\n"); 
		query.append(", '' TTL_LC_TEU_QTY" ).append("\n"); 
		query.append(", '' TTL_LC_FEU_QTY" ).append("\n"); 
		query.append(", '' TTL_LC_45FT_QTY" ).append("\n"); 
		query.append(", '' WHF_NOTICE" ).append("\n"); 
		query.append(", '' TTL_MEAS_QTY" ).append("\n"); 
		query.append(", '' TTL_MEAS_UT_CD" ).append("\n"); 
		query.append(", '' SMP_BL_KNT" ).append("\n"); 
		query.append(", '' TTL_TS_TEU_QTY" ).append("\n"); 
		query.append(", '' TTL_TS_FEU_QTY" ).append("\n"); 
		query.append(", '' TTL_TS_45FT_QTY" ).append("\n"); 
		query.append(", '' JO_CRR_KNT" ).append("\n"); 
		query.append(", '' TTL_FULL_KNT" ).append("\n"); 
		query.append(", '' TTL_MTY_TEU_QTY" ).append("\n"); 
		query.append(", '' TTL_MTY_FEU_QTY" ).append("\n"); 
		query.append(", '' TTL_MTY_45FT_QTY" ).append("\n"); 
		query.append(", '' TTL_MTY_KNT" ).append("\n"); 
		query.append(", '' TTL_TS_MTY_TEU_QTY" ).append("\n"); 
		query.append(", '' TTL_TS_MTY_FEU_QTY" ).append("\n"); 
		query.append(", '' TTL_TS_MTY_45FT_QTY" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO mani" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD vsl" ).append("\n"); 
		query.append(", MDM_VSL_CNTR v" ).append("\n"); 
		query.append("WHERE mani.VSL_CD = v.VSL_CD" ).append("\n"); 
		query.append("AND mani.VSL_CD = vsl.VSL_CD" ).append("\n"); 
		query.append("AND mani.skd_voy_no = vsl.skd_voy_no" ).append("\n"); 
		query.append("AND mani.skd_dir_cd = vsl.skd_dir_cd" ).append("\n"); 
		query.append("AND vsl.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("AND mani.PORT_CD = vsl.VPS_PORT_CD" ).append("\n"); 
		query.append("AND mani.PORT_CD like @[port_cd]" ).append("\n"); 
		query.append("AND mani.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND mani.VSL_CD     LIKE SUBSTR(@[vvd],1,4)||'%'" ).append("\n"); 
		query.append("AND mani.SKD_VOY_NO LIKE SUBSTR(@[vvd],5,4)||'%'" ).append("\n"); 
		query.append("AND mani.SKD_DIR_CD LIKE SUBSTR(@[vvd],9,1)||'%'" ).append("\n"); 

	}
}