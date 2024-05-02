/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301BlMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301BlMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301BlMain
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301BlMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301BlMainRSQL").append("\n"); 
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
		query.append("SELECT TO_CLOB('BKGNBR:'		|| BK.bkg_no                                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_DT:'		|| TO_CHAR(BK.bkg_cre_dt, 'RRRRMMDDHH24MISS')				|| CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_CFM_DT:'    || NVL((SELECT TO_CHAR(EVNT_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("								 FROM BKG_DOC_PROC_SKD SKD" ).append("\n"); 
		query.append("								WHERE BKG_DOC_PROC_TP_CD = 'BKGFRM'" ).append("\n"); 
		query.append("								  AND SKD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("								  AND SKD.DOC_PERF_DELT_FLG = 'N' AND ROWNUM = 1),TO_CHAR(BK.bkg_cre_dt, 'YYYYMMDDHH24MI'))	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BRAC:'			|| DECODE(BK.bkg_sts_cd, 'X', 'C',DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                                                                 FROM BKG_NTC_HIS BNH" ).append("\n"); 
		query.append("                                                                 WHERE BNH.BKG_NO = BK.bkg_no" ).append("\n"); 
		query.append("                                                                 AND BNH.NTC_VIA_CD = 'E'" ).append("\n"); 
		query.append("                                                                 AND BNH.NTC_KND_CD = 'BK'),0,'N', 'U'))					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_NO:'			|| BK.BL_NO             	                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_LANE:'		|| bk.slan_cd                                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'BV_LANE:'		|| n1st_vvd.slan_cd                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'TOVSL:'			|| n1st_vvd.vsl_cd											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'LOYD:'			|| Replace(n1st_vsl.LLOYD_NO, '.', '')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSLNAME:'		|| n1st_vsl.vsl_eng_nm										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSL_CALL_SIGN:'	|| Replace(n1st_vsl.CALL_SGN_NO, '.', '')					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VVD_REF_NO:'	|| n1st_skd.SHP_CALL_NO									    || CHR(10)" ).append("\n"); 
		query.append("	|| 'TOVOY:'			|| n1st_vvd.skd_voy_no										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TODIR:'			|| n1st_vvd.skd_dir_cd										|| CHR(10)" ).append("\n"); 
		query.append("    || 'CONSORTIUM_VOY_NO:' || VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(n1st_vvd.vsl_cd,n1st_vvd.skd_voy_no,n1st_vvd.skd_dir_cd,n1st_vvd.POL_CD,'O') || CHR(10)" ).append("\n"); 
		query.append("    || 'SERVICE_LCD:'	|| '   '													|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSLLD:'			|| TO_CHAR(n1st_skd.vps_etd_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSLD:'			|| TO_CHAR(last_skd.vps_eta_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVSL:'		|| '    '                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDLOYD:'       || ''							                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVSLNAME:'    || ''						                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVSL_CALL_SIGN:'|| ''				                                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVOY:'		|| '    '                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDDIR:'		|| ' '                                                      || CHR(10)" ).append("\n"); 
		query.append("    || 'OLD_CONSORTIUM_VOY_NO:'	|| '    '                                           || CHR(10)" ).append("\n"); 
		query.append("    || 'OLD_SERVICE_LCD:'	|| '   '                                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'TVSL:'			|| BK.vsl_cd												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TLOYD:'			|| Replace(TVVD.LLOYD_NO, '.', '')  						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TVSLNAME:'		|| TVVD.vsl_eng_nm											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TVSL_CALL_SIGN:'|| Replace(TVVD.CALL_SGN_NO, '.', '')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TVOY:'			|| BK.skd_voy_no											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TDIR:'			|| BK.skd_dir_cd											|| CHR(10)" ).append("\n"); 
		query.append("    || 'TVSL_CONSORTIUM_VOY_NO:' || VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(BK.vsl_cd,BK.skd_voy_no,BK.skd_dir_cd,trunk_vvd.POL_CD,'O') || CHR(10)" ).append("\n"); 
		query.append("    || 'TLOAD_SERVICE_LCD:'	|| '   '                                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_NAME:'		|| POR.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_QUAL:'		|| DECODE(LENGTH(POR.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_PORT:'		|| POR.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_UNLC:'		|| POR.LOC_CD												|| CHR(10)" ).append("\n"); 
		query.append("    || 'POR_CNT_NM:'	|| (SELECT MC.CNT_NM FROM MDM_COUNTRY MC WHERE MC.CNT_CD = SUBSTR(POR.LOC_CD,1,2) AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("    || 'POR_STATE_CD:'	|| POR.STE_CD												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_ETD:'		|| (SELECT to_char(MIN(ESTM_DT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') as DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO  = HDR.BKG_NO" ).append("\n"); 
		query.append("							   AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("							   AND DTL.NOD_CD = BK.POR_NOD_CD" ).append("\n"); 
		query.append("							   AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("							   AND (DTL.ACT_CD LIKE 'FO__L_' OR  DTL.ACT_CD LIKE 'FL__L_' OR DTL.ACT_CD IN ('FORRAD','MOTZAD','FOTSDO') ))				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_NAME:'		|| POL.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_QUAL:'		|| DECODE(LENGTH(POL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_PORT:'		|| POL.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_UNLC:'		|| POL.loc_cd												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_ETA:'		|| TO_CHAR(n1st_skd.vps_eta_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_ETD:'		|| TO_CHAR(n1st_skd.vps_etd_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_ETD_7:'		|| TO_CHAR(n1st_skd.vps_etd_dt + 7, 'RRRRMMDDHH24MI')		|| CHR(10)" ).append("\n"); 
		query.append("    || 'POL_ETD_GTM:'	|| TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BK.POL_CD,n1st_skd.vps_etd_dt,'GMT'), 'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("	|| 'BED:'			|| DECODE(n1st_vvd.VSL_CD, 'COXX', TO_CHAR(ADD_MONTHS(BK.BKG_cre_DT,       1), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	                                                     , TO_CHAR(ADD_MONTHS(n1st_skd.VPS_ETD_DT, 1), 'YYYYMMDDHH24MI'))|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CCT:'			|| (SELECT TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("							  FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO = CLZ.BKG_NO" ).append("\n"); 
		query.append("							   AND CLZ_TP_CD = 'R')														|| CHR(10)" ).append("\n"); 
		query.append("    || 'CCT_GTM:'	    || (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BK.POL_CD,NVL(MNL_SET_DT, SYS_SET_DT),'GMT'), 'RRRRMMDDHH24MI') " ).append("\n"); 
		query.append("							  FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO = CLZ.BKG_NO" ).append("\n"); 
		query.append("							   AND CLZ_TP_CD = 'R')													    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DCT:'			|| (SELECT TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("							  FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO = CLZ.BKG_NO" ).append("\n"); 
		query.append("							   AND CLZ_TP_CD = 'D')												        || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_NAME:'		|| POD.LOC_NM												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_QUAL:'		|| DECODE(LENGTH(POD.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')		                || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_PORT:'		|| POD.LOC_AMS_PORT_CD											                || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_UNLC:'		|| POD.loc_cd												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_ETA:'		|| TO_CHAR(COALESCE(last_skd.vps_eta_dt" ).append("\n"); 
		query.append("                                     ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                         FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                                        WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                          AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("                                          AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                          AND D.NOD_CD  = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                          AND D.ACT_CD     = 'FUVMAD')" ).append("\n"); 
		query.append("                                     ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                         FROM SCE_COP_HDR	H, SCE_COP_DTL	D" ).append("\n"); 
		query.append("                                        WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                          AND D.COP_NO	 = H.COP_NO" ).append("\n"); 
		query.append("                                          AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                          AND D.NOD_CD	 = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                          AND D.ACT_CD     = 'FUWMUD')" ).append("\n"); 
		query.append("                              ),     'RRRRMMDDHH24MI')			                || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_ETA_1:'		|| TO_CHAR(COALESCE(last_skd.vps_eta_dt" ).append("\n"); 
		query.append("                                     ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                         FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                                        WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                          AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("                                          AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                          AND D.NOD_CD  = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                          AND D.ACT_CD     = 'FUVMAD')" ).append("\n"); 
		query.append("                                     ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                         FROM SCE_COP_HDR	H, SCE_COP_DTL	D" ).append("\n"); 
		query.append("                                        WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                          AND D.COP_NO	 = H.COP_NO" ).append("\n"); 
		query.append("                                          AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                          AND D.NOD_CD	 = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                          AND D.ACT_CD     = 'FUWMUD')" ).append("\n"); 
		query.append("                              ) + 1, 'RRRRMMDDHH24MI')      	   		 			|| CHR(10)" ).append("\n"); 
		query.append("    || 'POD_ETA_GTM:'	|| TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(POD.loc_cd," ).append("\n"); 
		query.append("                                  COALESCE(last_skd.vps_eta_dt" ).append("\n"); 
		query.append("                                     ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                         FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                                        WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                          AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("                                          AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                          AND D.NOD_CD  = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                          AND D.ACT_CD     = 'FUVMAD')" ).append("\n"); 
		query.append("                                     ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                         FROM SCE_COP_HDR	H, SCE_COP_DTL	D" ).append("\n"); 
		query.append("                                        WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                          AND D.COP_NO	 = H.COP_NO" ).append("\n"); 
		query.append("                                          AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                          AND D.NOD_CD	 = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                          AND D.ACT_CD     = 'FUWMUD')" ).append("\n"); 
		query.append("                              ),'GMT'), 'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_ETD:'		|| TO_CHAR(last_skd.vps_etd_dt,     'RRRRMMDDHH24MI')				            || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_NAME:'		|| DEL.LOC_NM												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_QUAL:'		|| DECODE(LENGTH(DEL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')		                || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_PORT:'		|| DEL.LOC_AMS_PORT_CD											                || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_UNLC:'		|| DEL.loc_cd												                    || CHR(10)" ).append("\n"); 
		query.append("    || 'DEL_CNT_NM:'	|| (SELECT MC.CNT_NM FROM MDM_COUNTRY MC WHERE MC.CNT_CD = SUBSTR(DEL.LOC_CD,1,2) AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("    || 'DEL_STATE_CD:'	|| DEL.STE_CD												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_ETA:'		|| (SELECT to_char(MAX(ESTM_DT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') as DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO  = HDR.BKG_NO" ).append("\n"); 
		query.append("							   AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("							   AND DTL.NOD_CD = BK.DEL_NOD_CD" ).append("\n"); 
		query.append("							   AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("							   AND (DTL.ACT_CD LIKE 'FI__A_' OR DTL.ACT_CD LIKE 'FU__U_'))				|| CHR(10)" ).append("\n"); 
		query.append("    || 'DEL_ETA_GTM:'	|| (SELECT to_char(MAX(ESTM_GDT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') as DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO  = HDR.BKG_NO" ).append("\n"); 
		query.append("							   AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("							   AND DTL.NOD_CD = BK.DEL_NOD_CD" ).append("\n"); 
		query.append("							   AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("							   AND (DTL.ACT_CD LIKE 'FI__A_' OR DTL.ACT_CD LIKE 'FU__U_'))				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_ETD:'                                                                                       || CHR(10)" ).append("\n"); 
		query.append("    || 'DEL_ATA:'       || (SELECT to_char(MAX(ACT_DT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') as DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO  = HDR.BKG_NO" ).append("\n"); 
		query.append("							   AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("							   AND DTL.NOD_CD = BK.DEL_NOD_CD" ).append("\n"); 
		query.append("							   AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("							   AND (DTL.ACT_CD LIKE 'FI__A_' OR DTL.ACT_CD LIKE 'FU__U_'))              || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_NAME:'		|| rly1.LOC_NM											                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_QUAL:'		|| DECODE(LENGTH(rly1.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	                || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_PORT:'		|| rly1.LOC_AMS_PORT_CD										                   	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_UNLC:'		|| rly1.loc_cd												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_ETA:'       || TO_CHAR(rly1.vps_eta_dt, 'RRRRMMDDHH24MI')			                        || CHR(10)    " ).append("\n"); 
		query.append("	|| 'RLY_ETD:'       || TO_CHAR(rly1.vps_etD_dt, 'RRRRMMDDHH24MI')			                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_NAME:'     || RLY2.loc_nm                                                                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_QUAL:'     || DECODE(LENGTH(RLY2.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_PORT:'     || RLY2.LOC_AMS_PORT_CD                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_UNLC:'     || RLY2.loc_cd                                                                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_ETA:'      || TO_CHAR(rly2.vps_eta_dt, 'RRRRMMDDHH24MI')			                        || CHR(10)                 " ).append("\n"); 
		query.append("	|| 'RLY2_ETD:'      || TO_CHAR(rly2.vps_etD_dt, 'RRRRMMDDHH24MI')			                        || CHR(10) " ).append("\n"); 
		query.append("	|| 'FNLDST_NAME:'   || final_dest.loc_nm                                                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_QUAL:'   || DECODE(LENGTH(final_dest.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')              || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_PORT:'   || final_dest.LOC_AMS_PORT_CD                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_UNLC:'   || final_dest.loc_cd                                                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_ETA:'      																				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'PUNIT:'			|| bl.pck_tp_cd												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKG:'			|| NVL(bl.pck_qty,0)									                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'WUNIT:'			|| SUBSTR(NVL(bl.wgt_ut_cd,'KGS'), 1, 1)							                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT:'			|| NVL(Bl.act_wgt,0)								                            || CHR(10)" ).append("\n"); 
		query.append("    || 'NWUNIT:'		|| SUBSTR(NVL(bl.wgt_ut_cd,'KGS'), 1, 1)				                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'NWGT:'			|| NVL(Bl.act_wgt,0)								                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'EWUNIT:'		|| SUBSTR(NVL(bl.wgt_ut_cd,'KGS'), 1, 1)							                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'EWGT:'			|| NVL(bl.act_wgt,0)								                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'MUNIT:'			|| SUBSTR(NVL(Bl.meas_ut_cd,'CBM'), 3, 1)								                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEAS:'			|| NVL(bl.meas_qty,0)									                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RDTYP:'			|| BK.rcv_term_cd || BK.de_term_cd						                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'SMOD:'			|| BK.dest_trns_svc_mod_cd												        || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRUCK:'			|| (select SYS_AREA_GRP_ID from bkg_pfx_rout where ofc_pfx_cd = substr(BK.BKG_OFC_CD, 1, 3)))|| CHR(10)" ).append("\n"); 
		query.append("	|| TO_CLOB('REMARK:'		|| REPLACE(REPLACE(REPLACE(REPLACE(TO_CLOB(BK.xter_rmk), CHR(10), ' '), '*', '-'), ':', '-'),CHR(15712189),'')||CHR(10)" ).append("\n"); 
		query.append("	|| 'CMD:'			|| bk.cmdt_cd                                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'CMDD:'			|| (select cmdt_nm from mdm_commodity cmdt where cmdt.cmdt_cd = bk.cmdt_cd)     || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQREL:'			|| BK.mty_pkup_yd_cd					                                        || CHR(10))" ).append("\n"); 
		query.append("	|| TO_CLOB('LC_NO:'         || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'LCNO') || CHR(10)" ).append("\n"); 
		query.append("	|| 'INV_NO:'        || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'FINV') || CHR(10)" ).append("\n"); 
		query.append("	|| 'ACI_FILER_NO:'  || bk.cnd_cstms_file_cd                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'AMS_FILER_NO:'  || bk.usa_cstms_file_cd                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'CN_REF_NO:'  	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'EX_LICENCE_NO:' || (select xpt_lic_no from bkg_xpt_imp_lic lic where lic.bkg_no = bk.bkg_no and io_bnd_cd = 'O' and cnt_cd = 'KR' and rownum = 1)|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHN1:'			|| REPLACE(REPLACE(REPLACE(SH.cust_nm, CHR(10), ' '), '*', '-'), ':', '-')||CHR(10)" ).append("\n"); 
		query.append("	|| 'FFN1:'			|| REPLACE(REPLACE(REPLACE(FW.cust_nm, CHR(10), ' '), '*', '-'), ':', '-')||CHR(10)" ).append("\n"); 
		query.append("	|| 'CNE1:'			|| REPLACE(REPLACE(REPLACE(CN.cust_nm, CHR(10), ' '), '*', '-'), ':', '-')||CHR(10)" ).append("\n"); 
		query.append("	|| 'SH_CD1:'		|| SH.cust_cnt_cd||SH.cust_seq										            || CHR(10)" ).append("\n"); 
		query.append("	|| 'FF_CD1:'		|| FW.cust_cnt_cd||FW.cust_seq										            || CHR(10)" ).append("\n"); 
		query.append("	|| 'CN_CD1:'		|| CN.cust_cnt_cd||CN.cust_seq										            || CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_CD:'		|| NF.cust_cnt_cd||NF.cust_seq										            || CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_CD:'		|| AN.cust_cnt_cd||AN.cust_seq										            || CHR(10)" ).append("\n"); 
		query.append("	|| '3RD_NTFY_CD:'	                                         							            || CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR1:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(SH.cust_nm,   1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR2:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(SH.cust_nm,   2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR3:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(SH.cust_addr, 1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR4:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(SH.cust_addr, 2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR5:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(SH.cust_addr, 3, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_LOC_NM:'	|| SH.CUST_CTY_NM																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_STATE_CD:'	|| SH.CUST_STE_CD																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_UNLOC_CD:'	|| (SELECT ML.UN_LOC_CD FROM MDM_CUSTOMER MCS, MDM_LOCATION ML WHERE MCS.CUST_CNT_CD = SH.CUST_CNT_CD AND MCS.CUST_SEQ = SH.CUST_SEQ AND MCS.LOC_CD = ML.LOC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_ZIP_CD:'	|| SH.CUST_ZIP_ID																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_C_NM:'		|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_C_TEL:'	|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_C_FAX:'	|| SH.CUST_FAX_NO																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR_C_EMAIL:'	|| SH.CUST_EML																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE1:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(CN.cust_nm,   1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE2:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(CN.cust_nm,   2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE3:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(CN.cust_addr, 1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE4:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(CN.cust_addr, 2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE5:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(CN.cust_addr, 3, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_LOC_NM:'	|| CN.CUST_CTY_NM																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_STATE_CD:'	|| CN.CUST_STE_CD																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_UNLOC_CD:'	|| (SELECT ML.UN_LOC_CD FROM MDM_CUSTOMER MCC, MDM_LOCATION ML WHERE MCC.CUST_CNT_CD = CN.CUST_CNT_CD AND MCC.CUST_SEQ = CN.CUST_SEQ AND MCC.LOC_CD = ML.LOC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_ZIP_CD:'	|| CN.CUST_ZIP_ID																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_C_NM:'		|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_C_TEL:'	|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_C_FAX:'	|| CN.CUST_FAX_NO																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE_C_EMAIL:'	|| CN.CUST_EML																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR1:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(FW.cust_nm,   1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR2:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(FW.cust_nm,   2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR3:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(FW.cust_nm,   3, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR4:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(FW.cust_nm,   4, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR5:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(FW.cust_nm,   5, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_LOC_NM:'	|| FW.CUST_CTY_NM																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_STATE_CD:'	|| FW.CUST_STE_CD																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_UNLOC_CD:'	|| (SELECT ML.UN_LOC_CD FROM MDM_CUSTOMER MCF, MDM_LOCATION ML WHERE MCF.CUST_CNT_CD = FW.CUST_CNT_CD AND MCF.CUST_SEQ = FW.CUST_SEQ AND MCF.LOC_CD = ML.LOC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_ZIP_CD:'	|| FW.CUST_ZIP_ID																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_C_NM:'		|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_C_TEL:'	|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_C_FAX:'	|| FW.CUST_FAX_NO																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR_C_EMAIL:'	|| FW.CUST_EML																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY1:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(NF.cust_nm,   1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY2:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(NF.cust_nm,   2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY3:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(NF.cust_addr, 1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY4:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(NF.cust_addr, 2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY5:'			|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(NF.cust_addr, 3, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_LOC_NM:'	|| NF.CUST_CTY_NM																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_STATE_CD:'	|| NF.CUST_STE_CD																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_UNLOC_CD:'	|| (SELECT ML.UN_LOC_CD FROM MDM_CUSTOMER MCN, MDM_LOCATION ML WHERE MCN.CUST_CNT_CD = NF.CUST_CNT_CD AND MCN.CUST_SEQ = NF.CUST_SEQ AND MCN.LOC_CD = ML.LOC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_ZIP_CD:'	|| NF.CUST_ZIP_ID																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_C_NM:'		|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_C_TEL:'	|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_C_FAX:'	|| NF.CUST_FAX_NO																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_C_EMAIL:'	|| NF.CUST_EML																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY1:'		|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(AN.cust_nm,   1, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY2:'		|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(AN.cust_nm,   2, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY3:'		|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(AN.cust_nm,   3, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY4:'		|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(AN.cust_nm,   4, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY5:'		|| REPLACE(REPLACE(BKG_TOKEN_NL_FNC(AN.cust_nm,   5, ''), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_LOC_NM:'	|| AN.CUST_CTY_NM																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_STATE_CD:'|| AN.CUST_STE_CD																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_UNLOC_CD:'|| (SELECT ML.UN_LOC_CD FROM MDM_CUSTOMER MCA, MDM_LOCATION ML WHERE MCA.CUST_CNT_CD = AN.CUST_CNT_CD AND MCA.CUST_SEQ = AN.CUST_SEQ AND MCA.LOC_CD = ML.LOC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_ZIP_CD:'	|| AN.CUST_ZIP_ID																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_C_NM:'	|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_C_TEL:'	|| ''																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_C_FAX:'	|| AN.CUST_FAX_NO																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_C_EMAIL:'	|| AN.CUST_EML																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CANCEL_BIT:'	|| BK.bkg_sts_cd													            || CHR(10)" ).append("\n"); 
		query.append("	|| 'CARGOTYPE:'		|| BK.bkg_cgo_tp_cd												                || CHR(10)" ).append("\n"); 
		query.append("	|| 'OB_TRAFFIC_MD:'	|| DECODE(BK.RCV_TERM_CD,'S','LCL','FCL')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'IB_TRAFFIC_MD:'	|| DECODE(BK.DE_TERM_CD,'S','LCL','FCL')										|| CHR(10)" ).append("\n"); 
		query.append("    || 'OB_HAUL_TP:'			|| CASE WHEN POL.CONTI_CD <> 'E' THEN DECODE(BK.RCV_TERM_CD,'D','C','M')" ).append("\n"); 
		query.append("                                            ELSE NVL((SELECT ETRO.HLG_TP_CD FROM BKG_EUR_TRO ETRO WHERE ETRO.BKG_NO = BK.BKG_NO AND ETRO.IO_BND_CD = 'O' AND ETRO.CXL_FLG = 'N' AND ROWNUM = 1),DECODE(BK.RCV_TERM_CD,'D','C','M'))" ).append("\n"); 
		query.append("                                        END	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'IB_HAUL_TP:'			|| CASE WHEN POD.CONTI_CD <> 'E' THEN DECODE(BK.DE_TERM_CD,'D','C','M')" ).append("\n"); 
		query.append("                                            ELSE NVL((SELECT ETRO.HLG_TP_CD FROM BKG_EUR_TRO ETRO WHERE ETRO.BKG_NO = BK.BKG_NO AND ETRO.IO_BND_CD = 'I' AND ETRO.CXL_FLG = 'N' AND ROWNUM = 1),DECODE(BK.RCV_TERM_CD,'D','C','M')) " ).append("\n"); 
		query.append("                                        END	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DR_IND:'		|| decode(BK.dcgo_flg,       'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_IND:'		|| decode(BK.rc_flg,         'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AK_IND:'		|| decode(BK.awk_cgo_flg,    'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BB_IND:'		|| decode(BK.bb_cgo_flg,     'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HD_IND:'		|| decode(BK.spcl_hide_flg,  'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'UD_IND:'		|| decode(nvl(bk.stwg_cd, '0'), '0', '0', '1')								 	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'UD_CD:'			|| bk.stwg_cd		     										 	            || CHR(10)" ).append("\n"); 
		query.append("	|| 'RD_IND:'		|| decode(BK.rd_cgo_flg,     'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_CA:'     	|| RF.CTRL_ATMS_FLG													            || CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_MA:'     	|| RF.MODI_ATMS_FLG													            || CHR(10)" ).append("\n"); 
		query.append("	|| 'SOC_IND:'		|| DECODE(BK.soc_flg,'Y','1','0')				 	                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'SALES_OFFICE:'	|| BK.ob_sls_ofc_cd										                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'SALES_NAME:'	|| (select srep_nm from mdm_sls_rep SREP where srep.srep_cd = bk.ob_srep_cd)    || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_STF:'	    || BK.doc_usr_id										                        || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_NAME:'	|| usr.usr_nm											                        || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_TEL:'	|| (SELECT MO.OFC_PHN_NO FROM MDM_ORGANIZATION MO WHERE MO.OFC_CD = BK.BKG_OFC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_FAX:'	|| (SELECT MO.OFC_FAX_NO FROM MDM_ORGANIZATION MO WHERE MO.OFC_CD = BK.BKG_OFC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_EMAIL:'	|| USR.USR_EML																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_CPY_NAME:'	|| (SELECT MO.OFC_ENG_NM FROM MDM_ORGANIZATION MO WHERE MO.OFC_CD = BK.BKG_OFC_CD AND ROWNUM = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| NVL((/*+ index_desc(MST XAK5BKG_XTER_RQST_MST) */" ).append("\n"); 
		query.append("                         SELECT 'CONTACT_NAME:'	    || MST.CNTC_NM									    || CHR(10)" ).append("\n"); 
		query.append("	                         || 'CONTACT_TEL:'	    || MST.CNTC_PHN_NO								    || CHR(10)" ).append("\n"); 
		query.append("	                         || 'CONTACT_FAX:'	    || MST.CNTC_FAX_NO								    || CHR(10)" ).append("\n"); 
		query.append("	                         || 'CONTACT_EMAIL:'	|| MST.CNTC_EML" ).append("\n"); 
		query.append("                         FROM BKG_XTER_RQST_MST MST " ).append("\n"); 
		query.append("                         WHERE MST.DOC_TP_CD = 'B' " ).append("\n"); 
		query.append("                         AND MST.XTER_SNDR_ID <> 'WEB' " ).append("\n"); 
		query.append("                         AND MST.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                         AND ROWNUM = 1 " ).append("\n"); 
		query.append("                         AND (MST.CNTC_NM IS NOT NULL OR MST.CNTC_PHN_NO IS NOT NULL OR MST.CNTC_FAX_NO IS NOT NULL OR MST.CNTC_EML IS NOT NULL)" ).append("\n"); 
		query.append("                         ), " ).append("\n"); 
		query.append("                         'CONTACT_NAME:'	|| cntc.cntc_pson_nm									    || CHR(10)" ).append("\n"); 
		query.append("	                  || 'CONTACT_TEL:'	    || cntc.cntc_pson_phn_no								    || CHR(10)" ).append("\n"); 
		query.append("	                  || 'CONTACT_FAX:'	    || CNTC.CNTC_PSON_FAX_NO								    || CHR(10)" ).append("\n"); 
		query.append("	                  || 'CONTACT_EMAIL:'	|| CNTC.CNTC_PSON_EML) 										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BOUND_IND:'		|| 'E'															                || CHR(10)" ).append("\n"); 
		query.append("	|| 'REGIONAL_BKGNBR:'||(select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'PSAN') || CHR(10)" ).append("\n"); 
		query.append("	|| 'CUST_REF_NO:'	|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBRF') || CHR(10)" ).append("\n"); 
		query.append("	|| 'REF_VOYAGE:'	                										                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'SO_NO:'			|| BK.twn_so_no                           												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BLKSTWG:'       || bk.blck_stwg_cd                                                                     || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQPICKDT:'		|| TO_CHAR(bk.mty_PKUP_DT, 'RRRRMMDDHH24MI')				                           || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQRTN:'			|| BK.full_rtn_yd_cd			                                                       || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_CNT:'  	|| PKUP_CY.N1ST_VNDR_CNT_CD                                                       	   || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_CD:'   	|| PKUP_CY.yd_cd                                                                       || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_NM:'   	||                  replace(replace(PKUP_CY.yd_nm,   chr(13), ' '), chr(10), ' ' )     || CHR(10)" ).append("\n"); 
		query.append("    || 'PUCY_LOC_NM:'  	|| (SELECT replace(replace(ML.LOC_NM,   chr(13), ' '), chr(10), ' ' ) FROM MDM_LOCATION ML WHERE ML.LOC_CD = SUBSTR(PKUP_CY.yd_cd,1,5) )     || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR1:'	|| BKG_TOKEN_NL_FNC(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 1, '') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR2:'	|| BKG_TOKEN_NL_FNC(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 2, '') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR3:'	|| BKG_TOKEN_NL_FNC(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 3, '') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR4:'	|| BKG_TOKEN_NL_FNC(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 4, '') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR5:'	|| BKG_TOKEN_NL_FNC(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 5, '') || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_CNT:'  	|| substr(RTN_CY.loc_cd, 1, 2)                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_CD:'   	|| RTN_CY.yd_cd                                                                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_NM:'   	||                  replace(replace(RTN_CY.yd_nm,   chr(13), ' '), chr(10), ' ' )      || CHR(10)" ).append("\n"); 
		query.append("    || 'RTCY_LOC_NM:'  	|| (SELECT replace(replace(ML.LOC_NM,   chr(13), ' '), chr(10), ' ' ) FROM MDM_LOCATION ML WHERE ML.LOC_CD = SUBSTR(RTN_CY.yd_cd,1,5) )     || CHR(10)    " ).append("\n"); 
		query.append("	|| 'RTCY_ADDR1:'	|| BKG_TOKEN_NL_FNC(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 1, '')  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR2:'	|| BKG_TOKEN_NL_FNC(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 2, '')  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR3:'	|| BKG_TOKEN_NL_FNC(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 3, '')  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR4:'	|| BKG_TOKEN_NL_FNC(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 4, '')  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR5:'	|| BKG_TOKEN_NL_FNC(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 5, '')  || CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_PO_NO:'		|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'BKPO') || CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_SI_NO:'		|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESRF') || CHR(10)" ).append("\n"); 
		query.append("	|| 'FRT_TERM:'   	|| (select rt.frt_term_cd from bkg_rate rt where	rt.bkg_no = bk.bkg_no)			   || CHR(10)" ).append("\n"); 
		query.append("	|| 'ONBOARD:'		|| TO_CHAR(Bl.bl_obrd_dt, 'RRRRMMDD')                                                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_OFC:'   	|| BK.bkg_ofc_cd				                                                       || CHR(10)" ).append("\n"); 
		query.append("	|| 'SC_NO:'   		|| bk.sc_no				                                                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'GROUP_ID:'		|| NVL(@[group_id], ' ')||'/'||NVL(@[ref_code], ' ')	                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_VIA:'		|| decode(NVL(BK.xter_bkg_rqst_cd, ' '), 'WEB', 'W', 'EDI', 'E', 'GTN', 'G', 'INT', 'I', 'CSM', 'C', 'DSK', 'P', 'DAK', 'D', 'CLT', 'N')||CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_CUST_REF_NO:'||(select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBRF') || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_SH_REF_NO:' || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBSH') || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_FF_REF_NO:' || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBFF') || CHR(10)" ).append("\n"); 
		query.append("	|| 'SI_CUST_REF_NO:'|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESRF') || CHR(10)" ).append("\n"); 
		query.append("	|| 'SI_SH_REF_NO:'  || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESSH') || CHR(10)" ).append("\n"); 
		query.append("	|| 'SI_FF_REF_NO:'  || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESFF') || CHR(10)" ).append("\n"); 
		query.append("  	|| 'RAIL_CUTOFF:'   || (SELECT TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("				             FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("				            WHERE CLZ.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				              AND NTC_FLG = 'Y'" ).append("\n"); 
		query.append("				              AND CLZ_TP_CD = 'O') || CHR(10)" ).append("\n"); 
		query.append("    || 'PARTNER_OFFICE:'|| NVL(@[group_id], '') || CHR(10)" ).append("\n"); 
		query.append("    || 'VGM_CUTOFF:'    || to_char(BKG_GET_VGM_CUT_TM_FNC(bk.bkg_no),     'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("    ) BL_MAIN" ).append("\n"); 
		query.append("  FROM	bkg_booking	BK, bkg_bl_doc bl, bkg_cntc_pson cntc" ).append("\n"); 
		query.append("           , (SELECT * " ).append("\n"); 
		query.append("				FROM (select ROWNUM NO, vvd.bkg_no, skd.vps_eta_dt, skd.vps_etd_dt, loc.loc_cd, loc.loc_nm, loc.LOC_AMS_PORT_CD, vvd.vsl_cd" ).append("\n"); 
		query.append("                		from (select vvd.bkg_no, vvd.vsl_cd, vvd.skd_voy_no, vvd.skd_dir_cd" ).append("\n"); 
		query.append("                           			, vvd.pod_cd, vvd.pod_clpt_ind_seq                     " ).append("\n"); 
		query.append("                       			from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("                      			where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("                        		and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                        		and bk.pod_cd <> vvd.pod_cd" ).append("\n"); 
		query.append("								ORDER BY VVD.VSL_SEQ ) VVD" ).append("\n"); 
		query.append("                     		, vsk_vsl_port_skd skd, mdm_location loc" ).append("\n"); 
		query.append("               			where vvd.pod_cd           = loc.loc_cd" ).append("\n"); 
		query.append("                 		and vvd.vsl_cd           = skd.vsl_cd" ).append("\n"); 
		query.append("                 		and vvd.skd_voy_no       = skd.skd_voy_no" ).append("\n"); 
		query.append("                 		and vvd.skd_dir_cd       = skd.skd_dir_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_cd           = skd.vps_port_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_clpt_ind_seq = skd.clpt_ind_seq ) RLY" ).append("\n"); 
		query.append("				WHERE RLY.NO = 1 ) rly1" ).append("\n"); 
		query.append("            , (SELECT * " ).append("\n"); 
		query.append("				FROM (select ROWNUM NO, vvd.bkg_no, skd.vps_eta_dt, skd.vps_etd_dt, loc.loc_cd, loc.loc_nm, loc.LOC_AMS_PORT_CD, vvd.vsl_cd" ).append("\n"); 
		query.append("                		from (select vvd.bkg_no, vvd.vsl_cd, vvd.skd_voy_no, vvd.skd_dir_cd" ).append("\n"); 
		query.append("                           			, vvd.pod_cd, vvd.pod_clpt_ind_seq                     " ).append("\n"); 
		query.append("                       			from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("                      			where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("                        		and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                        		and bk.pod_cd <> vvd.pod_cd" ).append("\n"); 
		query.append("								ORDER BY VVD.VSL_SEQ ) VVD" ).append("\n"); 
		query.append("                     		, vsk_vsl_port_skd skd, mdm_location loc" ).append("\n"); 
		query.append("               			where vvd.pod_cd           = loc.loc_cd" ).append("\n"); 
		query.append("                 		and vvd.vsl_cd           = skd.vsl_cd" ).append("\n"); 
		query.append("                 		and vvd.skd_voy_no       = skd.skd_voy_no" ).append("\n"); 
		query.append("                 		and vvd.skd_dir_cd       = skd.skd_dir_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_cd           = skd.vps_port_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_clpt_ind_seq = skd.clpt_ind_seq ) RLY" ).append("\n"); 
		query.append("				WHERE RLY.NO = 2 ) rly2" ).append("\n"); 
		query.append("           , bkg_vvd          n1st_vvd" ).append("\n"); 
		query.append("           , mdm_vsl_cntr     n1st_vsl" ).append("\n"); 
		query.append("	       , vsk_vsl_port_skd n1st_SKD" ).append("\n"); 
		query.append("	       , bkg_vvd          last_vvd" ).append("\n"); 
		query.append("	       , vsk_vsl_port_skd last_skd" ).append("\n"); 
		query.append("           , bkg_vvd          trunk_vvd" ).append("\n"); 
		query.append("	       , bkg_customer SH, bkg_customer CN, bkg_customer FW, bkg_customer NF, bkg_customer AN" ).append("\n"); 
		query.append("	       , mdm_location POR, mdm_location POL, mdm_location POD, mdm_location DEL, mdm_location final_Dest" ).append("\n"); 
		query.append("		   , mdm_yard Pkup_CY, mdm_yard RTN_CY" ).append("\n"); 
		query.append("	       , bkg_rf_cgo 	  RF" ).append("\n"); 
		query.append("	       , mdm_vsl_cntr 	  TVVD" ).append("\n"); 
		query.append("	       , com_user 		  usr" ).append("\n"); 
		query.append(" WHERE BK.bkg_no	   	    = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.pol_cd			= POL.loc_cd" ).append("\n"); 
		query.append("   AND BK.pod_cd			= POD.loc_cd" ).append("\n"); 
		query.append("   AND BK.por_cd			= POR.loc_cd" ).append("\n"); 
		query.append("   AND BK.del_cd			= DEL.loc_cd" ).append("\n"); 
		query.append("   and bk.fnl_dest_cd       = final_dest.loc_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= Bl.bkg_no" ).append("\n"); 
		query.append("   AND BK.bkg_no			= cntc.bkg_no" ).append("\n"); 
		query.append("   and 'BK'                 = cntc.bkg_cntc_pson_tp_cd" ).append("\n"); 
		query.append("   AND BK.bkg_no			= SH.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'S'                  = SH.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= CN.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'C'                  = CN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= FW.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'F'                  = FW.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= NF.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'N'                  = NF.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= AN.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'A'                  = AN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.vsl_cd			= TVVD.vsl_cd(+)" ).append("\n"); 
		query.append("   and bk.bkg_no                = n1st_vvd.bkg_no" ).append("\n"); 
		query.append("   and bk.pol_cd                = n1st_vvd.pol_cd" ).append("\n"); 
		query.append("   and n1st_vvd.vsl_pre_pst_cd  in ('S', 'T')" ).append("\n"); 
		query.append("   AND n1st_vvd.vsl_cd          = n1st_vsl.vsl_cd(+) " ).append("\n"); 
		query.append("   and n1st_vvd.vsl_cd          = n1st_skd.vsl_cd(+) " ).append("\n"); 
		query.append("   and n1st_vvd.skd_voy_no      = n1st_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("   and n1st_vvd.skd_dir_cd      = n1st_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and n1st_vvd.pol_cd          = n1st_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("   and n1st_vvd.pol_clpt_ind_seq= n1st_skd.clpt_ind_seq(+)" ).append("\n"); 
		query.append("   and bk.bkg_no                = last_vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and bk.pod_cd                = last_vvd.pod_cd(+)" ).append("\n"); 
		query.append("   and last_vvd.vsl_pre_pst_cd  in ('T', 'U')" ).append("\n"); 
		query.append("   and last_vvd.vsl_cd          = last_skd.vsl_cd      (+)" ).append("\n"); 
		query.append("   and last_vvd.skd_voy_no      = last_skd.skd_voy_no   (+)" ).append("\n"); 
		query.append("   and last_vvd.skd_dir_cd      = last_skd.skd_dir_cd   (+)" ).append("\n"); 
		query.append("   and last_vvd.pod_cd          = last_skd.vps_port_cd  (+)" ).append("\n"); 
		query.append("   and last_vvd.pod_clpt_ind_seq= last_skd.clpt_ind_seq (+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= rly1.bkg_no(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= rly2.bkg_no(+)" ).append("\n"); 
		query.append("   AND BK.doc_usr_id		= usr.usr_id (+)" ).append("\n"); 
		query.append("   AND BK.mty_pkup_yd_cd    = PKUP_CY.yd_cd(+)" ).append("\n"); 
		query.append("   AND BK.full_rtn_yd_cd    = RTN_CY.yd_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= RF.bkg_no(+)" ).append("\n"); 
		query.append("   and 1                    = rf.rc_seq(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO            = trunk_vvd.BKG_NO " ).append("\n"); 
		query.append("   and bk.vsl_cd            = trunk_vvd.vsl_cd" ).append("\n"); 
		query.append("   and bk.skd_voy_no	    = trunk_vvd.skd_voy_no" ).append("\n"); 
		query.append("   and bk.skd_dir_cd     	= trunk_vvd.skd_dir_cd" ).append("\n"); 
		query.append("   and trunk_vvd.vsl_pre_pst_cd = 'T'" ).append("\n"); 

	}
}