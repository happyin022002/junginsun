/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchVesselArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("vps_eta_end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
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
		query.append("SELECT SKD.SLAN_CD" ).append("\n"); 
		query.append("       , MST.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("       , SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD VVD_NUMBER" ).append("\n"); 
		query.append("       , TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD') VPS_ETA_DT" ).append("\n"); 
		query.append("       , VSL.VSL_ENG_NM" ).append("\n"); 
		query.append("       , SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       , SKD.CLPT_IND_SEQ POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	   , MST.CSTMS_DECL_USR_ID" ).append("\n"); 
		query.append("       , MST.VSL_CALL_REF_STS_CD" ).append("\n"); 
		query.append("       , TO_CHAR(MST.BL_CRE_DT,'YYYY-MM-DD') BL_CRE_DT" ).append("\n"); 
		query.append("       , DECODE(MST.VSL_CALL_REF_STS_CD,'Y','Created','N','New','C','Cancel','','Non CRN') VSL_CALL_REF_STS_CD_NM" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("       , VSK_VSL_SKD VVS" ).append("\n"); 
		query.append("       , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("       , BKG_HRD_CDG_CTNT BB" ).append("\n"); 
		query.append("       , (SELECT RTM.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("                 , RTM.VSL_CALL_REF_STS_CD" ).append("\n"); 
		query.append("                 , RTM.VSL_CD" ).append("\n"); 
		query.append("                 , RTM.SKD_VOY_NO" ).append("\n"); 
		query.append("                 , RTM.SKD_DIR_CD" ).append("\n"); 
		query.append("                 , NVL(RTM.POD_CLPT_IND_SEQ, '1') AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 , RTM.CSTMS_DECL_USR_ID" ).append("\n"); 
		query.append("                 , RTM.BL_CRE_DT" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_RTM_VSL RTM) MST" ).append("\n"); 
		query.append(" WHERE (SKD.VSL_CD, SKD.SKD_VOY_NO, SKD.SKD_DIR_CD, SKD.VPS_PORT_CD, SKD.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                    IN ( SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND VPS_PORT_CD  = 'NLRTM'" ).append("\n"); 
		query.append("                            AND NVL(SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("                            #if (${vsl_cd}!= '' ) " ).append("\n"); 
		query.append("							AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                            AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("                            AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("							#if (${vps_eta_start_dt}!= '') 	   " ).append("\n"); 
		query.append("                            AND VPS_ETA_DT > TO_DATE(@[vps_eta_start_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (${vps_eta_end_dt}!= '') 	" ).append("\n"); 
		query.append("                            AND VPS_ETA_DT < TO_DATE(@[vps_eta_end_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD  = 'NLRTM'" ).append("\n"); 
		query.append("--	AND skd.SLAN_CD in ('SCP','PDE','JES','AEC','CNE','NTA','CEX','PDS','SCX','FEX','NCX','AEX','CEU','SCE','NAL','NNX','CNX','KPM','CME','NCE','SAF')" ).append("\n"); 
		query.append("--  AND decode(skd.SLAN_CD,'NTA','A','SAF','A','SAP','A','ESE','A','EXE','A',skd.SKD_DIR_CD) = decode(skd.SLAN_CD,'NTA','A','SAF','A','SAP','A','ESE','A','EXE','A','W')" ).append("\n"); 
		query.append("   AND BB.HRD_CDG_ID = 'ROCS_CSTMS_SLAN_CD'" ).append("\n"); 
		query.append("   AND SKD.SLAN_CD = BB.ATTR_CTNT1" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = DECODE (BB.ATTR_CTNT2, 'A', SKD.SKD_DIR_CD, 'W')" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = VVS.VSL_CD" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = VVS.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = VVS.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SKD.SLAN_CD = VVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND VVS.SKD_STS_CD = 'ACT'" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = MST.VSL_CD(+)" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = MST.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = MST.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ = MST.POD_CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#if (${frm_crn_number}!= '' ) " ).append("\n"); 
		query.append("   AND MST.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '' ) " ).append("\n"); 
		query.append("   AND SKD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${vps_eta_start_dt}!= '') 	   " ).append("\n"); 
		query.append("   AND SKD.VPS_ETA_DT > TO_DATE(@[vps_eta_start_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_eta_end_dt}!= '') 	 " ).append("\n"); 
		query.append("   AND SKD.VPS_ETA_DT < TO_DATE(@[vps_eta_end_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("#if (${slan_cd}!= 'V' && ${slan_cd}!= '0')" ).append("\n"); 
		query.append("   AND MST.VSL_CALL_REF_STS_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${slan_cd} == 'V' && ${slan_cd}!= '0')" ).append("\n"); 
		query.append("   AND MST.VSL_CALL_REF_STS_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}