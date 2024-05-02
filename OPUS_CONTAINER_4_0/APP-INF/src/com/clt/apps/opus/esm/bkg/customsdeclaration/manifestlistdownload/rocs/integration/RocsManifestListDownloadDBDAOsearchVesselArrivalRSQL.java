/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchVesselArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.03.31 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchVesselArrivalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관에 신고할 대상 Vessel Arrival 정보 데이터를 조회한다.
	  * 2011.10.19 김보배 [CHM-201113922] [BKG] [ROCS] ADD Lane - 하드코딩 제거, lane 추가 테이블 관리
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchVesselArrivalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_eta_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchVesselArrivalRSQL").append("\n"); 
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
		query.append("SELECT skd.SLAN_CD,mst.VSL_CALL_REF_NO, skd.VSL_CD||skd.SKD_VOY_NO||skd.SKD_DIR_CD vvd_number," ).append("\n"); 
		query.append("to_char(skd.VPS_ETA_DT,'YYYY-MM-DD') vps_eta_dt,vsl.VSL_ENG_NM,skd.VPS_PORT_CD," ).append("\n"); 
		query.append("mst.CSTMS_DECL_USR_ID,mst.VSL_CALL_REF_STS_CD,to_char(mst.BL_CRE_DT,'YYYY-MM-DD') BL_CRE_DT," ).append("\n"); 
		query.append("decode(mst.VSL_CALL_REF_STS_CD,'Y','Created','N','New','C','Cancel','','Non CRN') VSL_CALL_REF_STS_CD_NM" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD skd, VSK_VSL_SKD  , MDM_VSL_CNTR vsl, BKG_CSTMS_RTM_VSL mst , BKG_HRD_CDG_CTNT BB" ).append("\n"); 
		query.append("	WHERE (SKD.VSL_CD, SKD.SKD_VOY_NO, SKD.SKD_DIR_CD, SKD.VPS_PORT_CD, SKD.CLPT_IND_SEQ) IN (" ).append("\n"); 
		query.append("                            SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, MIN(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                            AND VPS_PORT_CD  = 'NLRTM'" ).append("\n"); 
		query.append("                            AND NVL(SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if (${vsl_cd}!= '' ) " ).append("\n"); 
		query.append("								AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("							    AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("							    AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("							#if (${vps_eta_start_dt}!= '') 	   " ).append("\n"); 
		query.append("							AND VPS_ETA_DT > TO_DATE(@[vps_eta_start_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (${vps_eta_end_dt}!= '') 	 " ).append("\n"); 
		query.append("							AND VPS_ETA_DT < TO_DATE(@[vps_eta_end_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD" ).append("\n"); 
		query.append("						 )" ).append("\n"); 
		query.append("	AND VPS_PORT_CD  = 'NLRTM'" ).append("\n"); 
		query.append("--	AND skd.SLAN_CD in ('SCP','PDE','JES','AEC','CNE','NTA','CEX','PDS','SCX','FEX','NCX','AEX','CEU','SCE','NAL','NNX','CNX','KPM','CME','NCE','SAF')" ).append("\n"); 
		query.append("--  AND decode(skd.SLAN_CD,'NTA','A','SAF','A','SAP','A','ESE','A','EXE','A',skd.SKD_DIR_CD) = decode(skd.SLAN_CD,'NTA','A','SAF','A','SAP','A','ESE','A','EXE','A','W')" ).append("\n"); 
		query.append("    AND BB.HRD_CDG_ID = 'ROCS_CSTMS_SLAN_CD'" ).append("\n"); 
		query.append("    AND skd.SLAN_CD = BB.ATTR_CTNT1" ).append("\n"); 
		query.append("    AND skd.SKD_DIR_CD = DECODE (BB.ATTR_CTNT2, 'A', skd.SKD_DIR_CD, 'W')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND skd.VSL_CD = vsl.VSL_CD" ).append("\n"); 
		query.append("	AND skd.VSL_CD = VSK_VSL_SKD.VSL_CD" ).append("\n"); 
		query.append("	AND skd.SKD_VOY_NO = VSK_VSL_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND skd.SKD_DIR_CD = VSK_VSL_SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND skd.SLAN_CD = VSK_VSL_SKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("	AND SKD_STS_CD = 'ACT'" ).append("\n"); 
		query.append("	AND skd.VSL_CD = mst.VSL_CD(+)" ).append("\n"); 
		query.append("   AND skd.SKD_VOY_NO = mst.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND skd.SKD_DIR_CD = mst.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("#if (${frm_crn_number}!= '' ) " ).append("\n"); 
		query.append("	AND mst.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '' ) " ).append("\n"); 
		query.append("	AND skd.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND skd.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("    AND skd.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${vps_eta_start_dt}!= '') 	   " ).append("\n"); 
		query.append("AND skd.VPS_ETA_DT > TO_DATE(@[vps_eta_start_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_eta_end_dt}!= '') 	 " ).append("\n"); 
		query.append("AND skd.VPS_ETA_DT < TO_DATE(@[vps_eta_end_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("#if (${slan_cd}!= 'V' && ${slan_cd}!= '0')" ).append("\n"); 
		query.append("      AND mst.VSL_CALL_REF_STS_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${slan_cd} == 'V' && ${slan_cd}!= '0')" ).append("\n"); 
		query.append("      AND mst.VSL_CALL_REF_STS_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}