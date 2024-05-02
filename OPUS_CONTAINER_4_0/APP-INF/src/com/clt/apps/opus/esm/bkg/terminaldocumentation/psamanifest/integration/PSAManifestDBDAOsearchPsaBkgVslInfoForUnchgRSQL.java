/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
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

public class PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUBSTR( PV.PSA_VSL_NM, 1, 12 ), '') AS PV_VSL_NM," ).append("\n"); 
		query.append("       NVL(PV.VSL_CD||PV.SKD_VOY_NO||PV.SKD_DIR_CD, '') AS PV_VOY_DIR," ).append("\n"); 
		query.append("       NVL(PV.PSA_VOY_DIR_CD, '') AS PV_CON_VOY_DIR, " ).append("\n"); 
		query.append("       PB.PSA_IF_CD BKG_FI," ).append("\n"); 
		query.append("       COM_CONSTANTMGR_PKG.COM_GETSCACCODE_FNC()||PB.BKG_NO AS UCR_NO," ).append("\n"); 
		query.append("       PB.N1ST_SHPR_NM AS SHPR_NM1," ).append("\n"); 
		query.append("       PB.N2ND_SHPR_NM AS SHPR_NM2," ).append("\n"); 
		query.append("       'NY' AS OP_CD," ).append("\n"); 
		query.append("       'NY' AS SO_CD," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_BOOKING BK," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = PB.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BK.POD_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BK.POD_NOD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND BK.POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS BKG_POD," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BV.BKG_NO = PB.BKG_NO" ).append("\n"); 
		query.append("           AND BV.POD_CD = PB.N1ST_POD_CD" ).append("\n"); 
		query.append("           AND BV.POD_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BV.POD_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BV.POD_YD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND PB.N1ST_POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POD_LOC1," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BV.BKG_NO = PB.BKG_NO" ).append("\n"); 
		query.append("           AND BV.POD_CD = PB.N2ND_POD_CD" ).append("\n"); 
		query.append("           AND BV.POD_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BV.POD_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BV.POD_YD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND PB.N2ND_POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POD_LOC2," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BV.BKG_NO = PB.BKG_NO" ).append("\n"); 
		query.append("           AND BV.POD_CD = PB.N3RD_POD_CD" ).append("\n"); 
		query.append("           AND BV.POD_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BV.POD_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BV.POD_YD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND PB.N3RD_POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POD_LOC3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PSA_BKG PB," ).append("\n"); 
		query.append("       BKG_CSTMS_PSA_VVD PV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE PV.VSL_CD = PB.VSL_CD" ).append("\n"); 
		query.append("   AND PV.SKD_VOY_NO = PB.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND PV.SKD_DIR_CD = PB.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND PB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND PB.BKG_SEQ = @[bkg_seq]" ).append("\n"); 

	}
}