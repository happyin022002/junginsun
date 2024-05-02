/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchDelManifestAmendmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchDelManifestAmendmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchDelManifestAmendmentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mbl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchDelManifestAmendmentRSQL").append("\n"); 
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
		query.append("      BL.BL_NO" ).append("\n"); 
		query.append("    , DECODE(MF_NO, NULL, 'M', 'H') AS MH -- US 세관 기준으로" ).append("\n"); 
		query.append("    , DECODE(BL.BL_NO, NULL, '', DECODE(BL.MF_NO, NULL, BL.CSTMS_FILE_TP_CD, '0')) AS CSTMS_FILE_CD -- US 세관 기준으로" ).append("\n"); 
		query.append("    , A.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("    , A.BKG_STS_CD" ).append("\n"); 
		query.append("    , BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS T_VVD_CD" ).append("\n"); 
		query.append("    ,(SELECT /*+INDEX_DESC(A XPKBKG_CORRECTION)*/ CORR_NO" ).append("\n"); 
		query.append("          FROM BKG_CORRECTION A, BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND B.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS CA_NO" ).append("\n"); 
		query.append("    , BL.CSTMS_POL_CD AS BKG_POL_CD -- US 세관 기준으로 ROUTE POL로 사용" ).append("\n"); 
		query.append("    , BL.CSTMS_POD_CD AS BKG_POD_CD -- US 세관 기준으로 ROUTE POD로 사용" ).append("\n"); 
		query.append("    , BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("    ,DECODE(BL.MF_SND_DT, NULL, 'N', 'Y') AS V_MI" ).append("\n"); 
		query.append("    ,BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS B_VVD_CD" ).append("\n"); 
		query.append("    ,CASE WHEN BL.MF_SND_DT IS NULL AND BL.AMDT_SND_DT IS NULL THEN 'N'" ).append("\n"); 
		query.append("          ELSE 'Y'" ).append("\n"); 
		query.append("     END AS B_MI" ).append("\n"); 
		query.append("    ,CASE WHEN BL.MF_SND_DT IS NOT NULL AND BL.AMDT_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("             THEN TO_CHAR(GREATEST(BL.MF_SND_DT, BL.AMDT_SND_DT),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("          WHEN BL.MF_SND_DT IS NULL AND BL.AMDT_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("             THEN TO_CHAR(BL.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("          WHEN BL.MF_SND_DT IS NOT NULL AND BL.AMDT_SND_DT IS NULL" ).append("\n"); 
		query.append("             THEN TO_CHAR(BL.MF_SND_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("          ELSE ''" ).append("\n"); 
		query.append("     END AS MI_SND_DT" ).append("\n"); 
		query.append("    ,DECODE(BL.BL_NO, NULL, '', DECODE(BL.MF_NO, NULL, BL.CSTMS_FILE_TP_CD, '0')) AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("    ,BL.MF_STS_CD" ).append("\n"); 
		query.append("    ,BL.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("    ,C1.CUST_NM AS SHPR_NM" ).append("\n"); 
		query.append("    ,C2.CUST_NM AS CNEE_NM" ).append("\n"); 
		query.append("    ,C3.CUST_NM AS NTFY_NM" ).append("\n"); 
		query.append("    ,BL.HUB_LOC_CD" ).append("\n"); 
		query.append("    ,BL.IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_AMER_BL BL" ).append("\n"); 
		query.append("     ,BKG_BOOKING A" ).append("\n"); 
		query.append("     ,BKG_CSTMS_AMER_CUST C1" ).append("\n"); 
		query.append("     ,BKG_CSTMS_AMER_CUST C2" ).append("\n"); 
		query.append("     ,BKG_CSTMS_AMER_CUST C3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE BL.BL_NO = A.BL_NO(+)" ).append("\n"); 
		query.append("  AND BL.CNT_CD = 'CA'" ).append("\n"); 
		query.append("#if (${mbl_no} != '' || ${bkg_no} != '')" ).append("\n"); 
		query.append("    #if (${mbl_no} != '')" ).append("\n"); 
		query.append("      AND A.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("    #elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("      AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("      AND BL.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND BL.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND BL.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("      AND BL.CSTMS_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '')" ).append("\n"); 
		query.append("      AND BL.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("      AND A.BKG_OFC_CD LIKE @[bkg_ofc_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${doc_usr_id} != '')" ).append("\n"); 
		query.append("      AND A.DOC_USR_ID LIKE @[doc_usr_id] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("      AND A.OB_SREP_CD LIKE @[ob_srep_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${full_mty_cd} == 'F')" ).append("\n"); 
		query.append("      AND A.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("    #elseif (${full_mty_cd} == 'M')" ).append("\n"); 
		query.append("      AND A.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${snd_dt_flg} != '')" ).append("\n"); 
		query.append("      AND BL.AMDT_SND_DT" ).append("\n"); 
		query.append("          BETWEEN TO_DATE(@[s_snd_dt] || ' 000000', 'YYYY-MM-DD HH24MISS')" ).append("\n"); 
		query.append("              AND TO_DATE(@[e_snd_dt] || ' 235959', 'YYYY-MM-DD HH24MISS')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND BL.MF_STS_CD = @[sts_div]" ).append("\n"); 
		query.append("  AND (BL.MF_SND_DT IS NOT NULL OR BL.AMDT_SND_DT IS NOT NULL)" ).append("\n"); 
		query.append("  AND C1.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("  AND BL.BL_NO = C1.BL_NO(+)" ).append("\n"); 
		query.append("  AND C1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("  AND C2.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("  AND BL.BL_NO = C2.BL_NO(+)" ).append("\n"); 
		query.append("  AND C2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("  AND C3.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("  AND BL.BL_NO = C3.BL_NO(+)" ).append("\n"); 
		query.append("  AND C3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 

	}
}