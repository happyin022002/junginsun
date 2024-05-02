/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPsaBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBlInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPsaBlInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       V.BKG_NO," ).append("\n"); 
		query.append("       PV.VSL_CD," ).append("\n"); 
		query.append("       PV.SKD_VOY_NO," ).append("\n"); 
		query.append("       PV.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_BOOKING BK," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POL_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BK.POL_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BK.POL_NOD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND BK.POL_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POL_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_BOOKING BK," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BK.POD_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BK.POD_NOD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND BK.POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POD_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_BOOKING BK," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND BK.DEL_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BK.DEL_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BK.DEL_NOD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND BK.DEL_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS DEL_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       BD.PCK_QTY," ).append("\n"); 
		query.append("       NVL2(CNV.CSTMS_PCK_TP_CD, CNV.CSTMS_PCK_TP_CD, BD.PCK_TP_CD) AS CSTMS_PCK_TP_CD," ).append("\n"); 
		query.append("       BD.ACT_WGT," ).append("\n"); 
		query.append("       BD.WGT_UT_CD," ).append("\n"); 
		query.append("       BD.MEAS_QTY," ).append("\n"); 
		query.append("       BD.MEAS_UT_CD," ).append("\n"); 
		query.append("       BD.CSTMS_DESC," ).append("\n"); 
		query.append("       DECODE(V.POD_CD, B.POD_CD, 'L', 'T') AS TS_IND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD V," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_VVD NV," ).append("\n"); 
		query.append("       BKG_CSTMS_PSA_VVD PV," ).append("\n"); 
		query.append("       BKG_BL_DOC BD," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND V.POD_CD = 'SGSIN'" ).append("\n"); 
		query.append("   AND v.VSL_CD = PV.VSL_CD(+)" ).append("\n"); 
		query.append("   AND v.SKD_VOY_NO = PV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND v.SKD_DIR_CD = PV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND V.BKG_NO IN (#foreach(${key} in ${bkg_no}) #if($velocityCount < $bkg_no.size()) '${key}',#else '${key}' #end #end)" ).append("\n"); 
		query.append("   AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND V.BKG_NO = NV.BKG_NO" ).append("\n"); 
		query.append("   AND V.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("   AND BD.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'SG'" ).append("\n"); 
		query.append("   AND NV.VSL_PRE_PST_CD||NV.VSL_SEQ = (SELECT NVL(MIN(VSL_PRE_PST_CD||VSL_SEQ), V.VSL_PRE_PST_CD||V.VSL_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_VVD" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                           AND V.VSL_PRE_PST_CD||V.VSL_SEQ < VSL_PRE_PST_CD||VSL_SEQ)" ).append("\n"); 

	}
}