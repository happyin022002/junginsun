/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.08.29 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd 기본 정보 조회
	  * 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - 세부 고객정보 추가 (ENS구조참조)
	  * 2011.10.28 김보배 [CHM-201114181] [BKG] [EUR customs manifest] 쿼리속도 개선
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL").append("\n"); 
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
		query.append("#if(${mode_type}=='O') -- Outbound 전송" ).append("\n"); 
		query.append("SELECT VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,CNTR.CALL_SGN_NO     AS VSL_CALLSIGN" ).append("\n"); 
		query.append("      ,CNTR.LLOYD_NO        AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("      ,CNTR.VSL_ENG_NM      AS VSL_FULLNAME" ).append("\n"); 
		query.append("      ,CNTR.VSL_RGST_CNT_CD AS VSL_FLAG " ).append("\n"); 
		query.append("      ,MAX(TO_CHAR(SKD.VPS_ETA_DT,'YYYYMMDDHH24MI')) AS ETA" ).append("\n"); 
		query.append("      ,MIN(TO_CHAR(SKD.VPS_ETD_DT,'YYYYMMDDHH24MI')) AS ETD" ).append("\n"); 
		query.append("      ,(SELECT BKG_GET_CSTMS_EUR_FOPE_CD_FNC(VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD) FROM DUAL) POFE" ).append("\n"); 
		query.append("  FROM BKG_VVD          VVD" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     CNTR" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD      = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO  = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD  = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CD      = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POL_YD_CD   = SKD.YD_CD" ).append("\n"); 
		query.append("   AND NVL(SKD.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = CNTR.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD   = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append(" GROUP BY VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,CNTR.CALL_SGN_NO" ).append("\n"); 
		query.append("      ,CNTR.LLOYD_NO" ).append("\n"); 
		query.append("      ,CNTR.VSL_ENG_NM" ).append("\n"); 
		query.append("      ,CNTR.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else -- Inbound 전송" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${pod_cd}=='GBSOU') --GBSOU 전송" ).append("\n"); 
		query.append("SELECT VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,CNTR.CALL_SGN_NO     AS VSL_CALLSIGN" ).append("\n"); 
		query.append("      ,CNTR.LLOYD_NO        AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("      ,CNTR.VSL_ENG_NM      AS VSL_FULLNAME" ).append("\n"); 
		query.append("      ,CNTR.VSL_RGST_CNT_CD AS VSL_FLAG " ).append("\n"); 
		query.append("      ,MAX(TO_CHAR(SKD.VPS_ETA_DT,'YYYYMMDDHH24MI')) AS ETA" ).append("\n"); 
		query.append("      ,MIN(TO_CHAR(SKD.VPS_ETD_DT,'YYYYMMDDHH24MI')) AS ETD" ).append("\n"); 
		query.append("      ,(SELECT BKG_GET_CSTMS_EUR_FOPE_CD_FNC(VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD) FROM DUAL) POFE" ).append("\n"); 
		query.append("  FROM BKG_VVD          VVD" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     CNTR" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD      = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO  = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD  = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.POD_CD      = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POD_YD_CD   = SKD.YD_CD" ).append("\n"); 
		query.append("   AND NVL(SKD.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = CNTR.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD   = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append(" GROUP BY VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,CNTR.CALL_SGN_NO" ).append("\n"); 
		query.append("      ,CNTR.LLOYD_NO" ).append("\n"); 
		query.append("      ,CNTR.VSL_ENG_NM" ).append("\n"); 
		query.append("      ,CNTR.VSL_RGST_CNT_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else 					--그외 지역에 전송" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT @[vvd_cd] AS VVD" ).append("\n"); 
		query.append("      ,CNTR.CALL_SGN_NO     AS VSL_CALLSIGN" ).append("\n"); 
		query.append("      ,CNTR.LLOYD_NO        AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("      ,CNTR.VSL_ENG_NM      AS VSL_FULLNAME" ).append("\n"); 
		query.append("      ,CNTR.VSL_RGST_CNT_CD AS VSL_FLAG " ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(VPS_ETA_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("      FROM VSK_VSL_PORT_SKD SKD, BKG_VVD VVD" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("	  AND SKD.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND SKD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND SKD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("      AND SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("      AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND SKD.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND SKD.VPS_PORT_CD = @[pod_cd]) AS ETA" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(VPS_ETD_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("      FROM VSK_VSL_PORT_SKD SKD, BKG_VVD VVD" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND SKD.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND SKD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND SKD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("      AND SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("      AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      AND VVD.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("      AND SKD.VPS_PORT_CD = @[pol_cd]) AS ETD" ).append("\n"); 
		query.append("      ,(SELECT BKG_GET_CSTMS_EUR_FOPE_CD_FNC(@[vvd_cd]) FROM DUAL) POFE" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append("      ,BKG_VVD          VVDL" ).append("\n"); 
		query.append("      ,BKG_VVD          VVDD" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD SKDL" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD SKDD" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     CNTR" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO       = VVDL.BKG_NO" ).append("\n"); 
		query.append("--   AND BKG.POL_CD       = VVDL.POL_CD" ).append("\n"); 
		query.append("   AND VVDL.VSL_CD      = SKDL.VSL_CD" ).append("\n"); 
		query.append("   AND VVDL.SKD_VOY_NO  = SKDL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVDL.SKD_DIR_CD  = SKDL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVDL.POL_CD      = SKDL.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVDL.POL_YD_CD   = SKDL.YD_CD" ).append("\n"); 
		query.append("   AND NVL(SKDL.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO       = VVDD.BKG_NO" ).append("\n"); 
		query.append("--   AND BKG.POD_CD       = VVDD.POD_CD" ).append("\n"); 
		query.append("   AND VVDD.VSL_CD      = SKDD.VSL_CD" ).append("\n"); 
		query.append("   AND VVDD.SKD_VOY_NO  = SKDD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVDD.SKD_DIR_CD  = SKDD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVDD.POD_CD      = SKDD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVDD.POD_YD_CD   = SKDD.YD_CD" ).append("\n"); 
		query.append("   AND NVL(SKDD.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("   AND CNTR.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append(" GROUP BY CNTR.CALL_SGN_NO" ).append("\n"); 
		query.append("      ,CNTR.LLOYD_NO" ).append("\n"); 
		query.append("      ,CNTR.VSL_ENG_NM" ).append("\n"); 
		query.append("      ,CNTR.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("      ,VVDL.POL_CD" ).append("\n"); 
		query.append("      ,VVDD.POL_CD" ).append("\n"); 
		query.append("	#end -- Inbound에서 국가별 if문 끝	" ).append("\n"); 
		query.append("#end -- Out ~ Inbound 구분의 if 문 끝" ).append("\n"); 

	}
}