/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchCntrBaseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchCntrBaseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchCntrBaseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bound_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchCntrBaseInfoRSQL").append("\n"); 
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
		query.append("SELECT @[d_type] AS D_TYPE," ).append("\n"); 
		query.append("       @[vvd_cd] AS VVD_CD," ).append("\n"); 
		query.append("       @[port_cd] AS PORT_CD," ).append("\n"); 
		query.append("       @[bl_no] AS BL_NO," ).append("\n"); 
		query.append("       @[p_bound_cd] AS P_BOUND_CD," ).append("\n"); 
		query.append("       @[p_pod_cd] AS P_POD_CD," ).append("\n"); 
		query.append("       @[p_pol_cd] AS P_POL_CD," ).append("\n"); 
		query.append("       @[msg_snd_no] AS MSG_SND_NO," ).append("\n"); 
		query.append("/* CNTR */" ).append("\n"); 
		query.append("       BVD.CNTR_NO," ).append("\n"); 
		query.append("       BVD.CNTR_TPSZ_CD AS CNTRTS_CD," ).append("\n"); 
		query.append("       BVD.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       (SELECT CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("          FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("         WHERE CNTR_TPSZ_CD = BVD.CNTR_TPSZ_CD) AS ISO, -- ISO 값" ).append("\n"); 
		query.append("       @[d_type] AS IMEX," ).append("\n"); 
		query.append("/* SUB_PARTIES */" ).append("\n"); 
		query.append("       'FW1' AS SUB_PARTY_TYPE," ).append("\n"); 
		query.append("       'HANSHI' AS SUB_PARTY_ID," ).append("\n"); 
		query.append("       '' AS SUB_AUTHORIZED," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS1," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS2," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS3," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS4," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS5," ).append("\n"); 
		query.append("       (SELECT USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id]) AS SUB_CONTACT," ).append("\n"); 
		query.append("       (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]) AS SUB_PHONE," ).append("\n"); 
		query.append("       (SELECT OFC_FAX_NO" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]) AS SUB_FAX," ).append("\n"); 
		query.append("       '' AS SUB_REF," ).append("\n"); 
		query.append("/* SUB_MEANS */" ).append("\n"); 
		query.append("       (CASE WHEN @[d_type] = 'D' OR @[d_type] ='DO' OR @[d_type] ='O' THEN '30'" ).append("\n"); 
		query.append("             WHEN @[d_type] = 'L' OR @[d_type] ='PL' THEN '20'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END) AS SUB_MEANS_TYPE," ).append("\n"); 
		query.append("       '' AS SUB_VVD," ).append("\n"); 
		query.append("       '' AS SUB_CON_VVD," ).append("\n"); 
		query.append("       '' AS SUB_MODE," ).append("\n"); 
		query.append("       '' AS SUB_NAME," ).append("\n"); 
		query.append("       '' AS SUB_SSR, -- FEEDER SSR" ).append("\n"); 
		query.append("       'L' AS SUB_ID_TYPE," ).append("\n"); 
		query.append("       '' AS SUB_ID," ).append("\n"); 
		query.append("       '' AS SUB_NATION," ).append("\n"); 
		query.append("       '' AS SUB_LICENSE," ).append("\n"); 
		query.append("/* BOOKINGS */" ).append("\n"); 
		query.append("       'L' AS L_BKG_ID_TYPE," ).append("\n"); 
		query.append("       BVD.BL_NO AS L_BKG_ID," ).append("\n"); 
		query.append("       'B' AS B_BKG_ID_TYPE," ).append("\n"); 
		query.append("       (SELECT BKG_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING" ).append("\n"); 
		query.append("         WHERE BL_NO = BVD.BL_NO) AS B_BKG_ID," ).append("\n"); 
		query.append("       (CASE WHEN @[d_type] = 'PL' OR @[d_type] ='P' THEN 'PRE' " ).append("\n"); 
		query.append("             WHEN @[d_type] = 'DO' OR @[d_type] ='O' THEN 'ON'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END) AS BKG_DATE_TYPE," ).append("\n"); 
		query.append("       (CASE WHEN @[d_type] = 'PL' OR @[d_type] ='P' OR @[d_type] = 'DO' OR @[d_type] ='O' THEN @[crr_dt]" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END) AS BKG_DATE," ).append("\n"); 
		query.append("       'POL' AS POL_BKG_LOC_TYPE," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_BOOKING BK," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = BVD.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POL_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BK.POL_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BK.POL_NOD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND BK.POL_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POL_BKG_LOC," ).append("\n"); 
		query.append("       'POD' AS POD_BKG_LOC_TYPE," ).append("\n"); 
		query.append("       (SELECT DECODE(PT2.PSA_LOC_CD, NULL, DECODE(PT1.PSA_LOC_CD, NULL, NVL(MDM.UN_LOC_CD, MDM.LOC_CD), PT1.PSA_LOC_CD), PT2.PSA_LOC_CD)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_PSA_PORT PT1," ).append("\n"); 
		query.append("               BKG_CSTMS_PSA_PORT PT2," ).append("\n"); 
		query.append("               BKG_BOOKING BK," ).append("\n"); 
		query.append("               MDM_LOCATION MDM" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = BVD.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD = PT1.LOC_CD(+)" ).append("\n"); 
		query.append("           AND LENGTH(PT1.TML_CD(+)) = 5" ).append("\n"); 
		query.append("           AND BK.POD_CD = PT2.LOC_CD(+)" ).append("\n"); 
		query.append("           AND BK.POD_NOD_CD = PT2.TML_CD(+)" ).append("\n"); 
		query.append("           AND BK.POD_CD = MDM.LOC_CD(+)" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POD_BKG_LOC," ).append("\n"); 
		query.append("       @[usr_id] AS USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT DECODE(LAG(BK.BL_NO) OVER (ORDER BY BK.BL_NO, BV.POL_CD, BV.POD_CD, BDC.CNTR_NO), BK.BL_NO, 0, 1) AS SEQ," ).append("\n"); 
		query.append("               COUNT(DISTINCT BDC.CNTR_NO) OVER() AS CNTR_CNT," ).append("\n"); 
		query.append("               BV.BKG_NO," ).append("\n"); 
		query.append("               BK.BL_NO," ).append("\n"); 
		query.append("               BV.POL_CD," ).append("\n"); 
		query.append("               BV.POD_CD," ).append("\n"); 
		query.append("               BV.VSL_CD," ).append("\n"); 
		query.append("               BV.SKD_VOY_NO," ).append("\n"); 
		query.append("               BV.SKD_DIR_CD," ).append("\n"); 
		query.append("               BDC.CNTR_NO," ).append("\n"); 
		query.append("               BDC.CNTR_CGO_SEQ," ).append("\n"); 
		query.append("               BDC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               SIUN.IMDG_COMP_GRP_CD," ).append("\n"); 
		query.append("               BDC.IMDG_UN_NO," ).append("\n"); 
		query.append("               BDC.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("               BDC.IMDG_CLSS_CD," ).append("\n"); 
		query.append("               '' AS DG_SHORT_NM," ).append("\n"); 
		query.append("               BDC.DG_CNTR_SEQ," ).append("\n"); 
		query.append("               BDC.FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("               BDC.IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("               BDC.IN_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("               BDC.IN_IMDG_PCK_CD1," ).append("\n"); 
		query.append("               BDC.OUT_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("               BDC.OUT_IMDG_PCK_CD1," ).append("\n"); 
		query.append("               BDC.EMS_NO," ).append("\n"); 
		query.append("               BDC.NET_WGT," ).append("\n"); 
		query.append("               BDC.GRS_WGT," ).append("\n"); 
		query.append("               BDC.PRP_SHP_NM," ).append("\n"); 
		query.append("               BDC.HZD_DESC," ).append("\n"); 
		query.append("               BDC.IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("               BDC.IMDG_SUBS_RSK_LBL_CD2," ).append("\n"); 
		query.append("               BDC.IMDG_SUBS_RSK_LBL_CD3," ).append("\n"); 
		query.append("               BDC.IMDG_SUBS_RSK_LBL_CD4," ).append("\n"); 
		query.append("               BDC.MRN_POLUT_FLG," ).append("\n"); 
		query.append("               BDC.IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("               BK.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_VVD BV," ).append("\n"); 
		query.append("               BKG_DG_CGO BDC," ).append("\n"); 
		query.append("               BKG_BOOKING BK," ).append("\n"); 
		query.append("               SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND BV.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND BV.POL_CD IN (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                              WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                AND CLPT_SEQ <= (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                  WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                    AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                    AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                    AND VPS_PORT_CD = @[port_cd])" ).append("\n"); 
		query.append("                                AND NVL(SKD_CNG_STS_CD, 'X') <> 'S')" ).append("\n"); 
		query.append("           AND BV.POD_CD IN (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                              WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                AND CLPT_SEQ >= (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                  WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                    AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                    AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                    AND VPS_PORT_CD = @[port_cd])" ).append("\n"); 
		query.append("                                AND CLPT_SEQ < (SELECT NVL(MIN(V2.CLPT_SEQ), 50)" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD V1," ).append("\n"); 
		query.append("                                                       VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                                                 WHERE 1=1" ).append("\n"); 
		query.append("                                                   AND V1.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                   AND V1.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                   AND V1.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                   AND V1.VSL_CD = V2.VSL_CD" ).append("\n"); 
		query.append("                                                   AND V1.SKD_VOY_NO = V2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND V1.SKD_DIR_CD = V2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND NVL(V1.SKD_CNG_STS_CD, 'X') = 'O'" ).append("\n"); 
		query.append("                                                   AND NVL(V2.SKD_CNG_STS_CD, 'X') = 'A'" ).append("\n"); 
		query.append("                                                   AND V1.CLPT_SEQ < V2.CLPT_SEQ)" ).append("\n"); 
		query.append("                                AND NVL(SKD_CNG_STS_CD, 'X') <> 'S')" ).append("\n"); 
		query.append("           AND BV.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("           AND BV.BKG_NO = BDC.BKG_NO" ).append("\n"); 
		query.append("           AND BDC.IMDG_UN_NO = SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("           AND BDC.IMDG_UN_NO_SEQ = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("           AND BK.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BK.BL_NO = @[bl_no]) BVD" ).append("\n"); 

	}
}