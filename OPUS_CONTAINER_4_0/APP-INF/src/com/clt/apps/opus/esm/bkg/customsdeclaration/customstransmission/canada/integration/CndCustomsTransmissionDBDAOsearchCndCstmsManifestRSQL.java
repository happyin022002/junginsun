/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCndCstmsManifestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.12.31 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCndCstmsManifestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsManifest
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCndCstmsManifestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCndCstmsManifestRSQL").append("\n"); 
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
		query.append("SELECT  A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("       ,A.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(Z1.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD Z1" ).append("\n"); 
		query.append("          WHERE Z1.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("            AND Z1.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND Z1.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND Z1.VPS_PORT_CD = A.CSTMS_POD_CD" ).append("\n"); 
		query.append("            AND Z1.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS ETA_DT" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(A.CSTMS_POD_CD, 1,2), 'CA', 'N', 'Y') AS FROB_FLG" ).append("\n"); 
		query.append("       ,A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(MAX(L1.SND_DT),'YYYY-MM-DD HH24:MI:SS') AS MF_SND_DT" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(Z1.VPS_ETB_DT + 1/24,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD Z1" ).append("\n"); 
		query.append("          WHERE Z1.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("            AND Z1.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND Z1.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND Z1.VPS_PORT_CD = A.CSTMS_POL_CD" ).append("\n"); 
		query.append("            AND Z1.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS ETL_DT" ).append("\n"); 
		query.append("       ,DECODE(MAX(L1.SND_DT), NULL, 'N', 'Y') AS A6A" ).append("\n"); 
		query.append("       ,COUNT(DISTINCT B.CNTR_NO) AS CNTR_CNT" ).append("\n"); 
		query.append("       ,COUNT(DISTINCT A.CNT_CD||A.BL_NO) AS BL_CNT" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BDR.TRNK_MNL_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 WHEN BDR.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 WHEN BDR.TRNK_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("           ) AS BDR_FLG" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CNTR B" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_SND_LOG L1" ).append("\n"); 
		query.append("       ,BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND  A.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("   AND  A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  A.BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("   AND  B.IBD_CNTR_STS_CD(+) = 'A'" ).append("\n"); 
		query.append("   AND  A.CNT_CD = L1.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  A.VSL_CD = L1.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = L1.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = L1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_POL_CD = L1.POL_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_POD_CD = L1.POD_CD(+)" ).append("\n"); 
		query.append("   AND  L1.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND  A.VSL_CD       = BDR.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO   = BDR.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD   = BDR.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_POL_CD       = BDR.POL_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_POD_CD       = BDR.POD_CD(+)" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("   AND  A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND  A.CSTMS_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND  A.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_port_cd} != '') " ).append("\n"); 
		query.append("   AND  A.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("   AND  A.FROB_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_type} == 'F') " ).append("\n"); 
		query.append("   AND  A.FULL_MTY_CD = @[cntr_type]" ).append("\n"); 
		query.append("   AND  L1.TRSM_MSG_TP_ID(+) = 'A6A'" ).append("\n"); 
		query.append("#elseif (${cntr_type} == 'M') " ).append("\n"); 
		query.append("   AND  A.FULL_MTY_CD = @[cntr_type]" ).append("\n"); 
		query.append("   AND  L1.TRSM_MSG_TP_ID(+) = 'E10'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND  L1.TRSM_MSG_TP_ID(+) = DECODE(A.FULL_MTY_CD, 'F', 'A6A', 'E10')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  A.VSL_CD" ).append("\n"); 
		query.append("         ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("         ,A.CSTMS_POL_CD" ).append("\n"); 
		query.append("         ,A.CSTMS_POD_CD" ).append("\n"); 
		query.append("         ,A.CSTMS_PORT_CD" ).append("\n"); 

	}
}