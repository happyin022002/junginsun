/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchVesselArrivalNotice2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchVesselArrivalNotice2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주24 Vessel Arrival Notice 2
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchVesselArrivalNotice2RSQL(){
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
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchVesselArrivalNotice2RSQL").append("\n"); 
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
		query.append("SELECT VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  VPS.VSL_CD," ).append("\n"); 
		query.append("  VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("  VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("  EU.CVY_REF_NO," ).append("\n"); 
		query.append("  EU.CVY_REF_NO CVY_REF_NO_HIDDEN," ).append("\n"); 
		query.append("  VSL.VSL_ENG_NM," ).append("\n"); 
		query.append("  VSL.LLOYD_NO," ).append("\n"); 
		query.append("  VSL.PICLB_DESC," ).append("\n"); 
		query.append("  '' N1ST_CLPT_CD," ).append("\n"); 
		query.append("  TO_CHAR(VPS.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') ETA_DT," ).append("\n"); 
		query.append("  TO_CHAR(VPS.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ETD_DT," ).append("\n"); 
		query.append("  TO_CHAR(ACT.ACT_ARR_DT, 'YYYY-MM-DD HH24:MI') ATA_DT," ).append("\n"); 
		query.append("  EU.CSTMS_PORT_CD_BL CSTMS_PORT_CD," ).append("\n"); 
		query.append("  EU.CSTMS_YD_CD," ).append("\n"); 
		query.append("  EU.NEW_PORT RVIS_N1ST_CLPT_CD," ).append("\n"); 
		query.append("  (SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("    WHERE A.PORT_CD = EU.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      AND DECODE(A.TML_CD, 'ALL' , EU.CSTMS_YD_CD, A.TML_CD)= EU.CSTMS_YD_CD" ).append("\n"); 
		query.append("      AND ROWNUM=1 ) AS N1ST_PORT_OFC_CD," ).append("\n"); 
		query.append("  (SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("    WHERE A.PORT_CD = SUBSTR(EU.NEW_PORT, 1, 5)" ).append("\n"); 
		query.append("      AND DECODE(A.TML_CD, 'ALL' , EU.NEW_PORT , A.TML_CD)= EU.NEW_PORT" ).append("\n"); 
		query.append("      AND ROWNUM=1 ) AS N1ST_PORT_OFC_CD_NEW ," ).append("\n"); 
		query.append("  VPS.YD_CD TML_CD," ).append("\n"); 
		query.append("  YARD.YD_NM TML_NM," ).append("\n"); 
		query.append("  NVL( EU.LST_CLPT_CD, (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(K XAK4VSK_VSL_PORT_SKD) */VPS_PORT_CD" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ < VPS.CLPT_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM = 1 ) ) LST_CLPT_CD," ).append("\n"); 
		query.append("  NVL(EU.NXT_CLPT_CD, (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */VPS_PORT_CD" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("        WHERE K.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("          AND K.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND K.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND K.CLPT_SEQ > VPS.CLPT_SEQ" ).append("\n"); 
		query.append("          AND ROWNUM = 1 ) ) NXT_CLPT_CD," ).append("\n"); 
		query.append("  EU.ARR_PORT_CD," ).append("\n"); 
		query.append("  VSL.RGST_NO RGST_NO," ).append("\n"); 
		query.append("  TO_CHAR(VSL.RGST_DT, 'YYYY-MM-DD') RGST_DT," ).append("\n"); 
		query.append("  VSL.RGST_PORT_CD RGST_PORT_CD," ).append("\n"); 
		query.append("  VSL.GRS_RGST_TONG_WGT GRS_RGST_TONG_WGT," ).append("\n"); 
		query.append("  VSL.NET_RGST_TONG_WGT NET_RGST_TONG_WGT," ).append("\n"); 
		query.append("  DECODE(EU.CSTMS_PORT_CD, '', 'I', 'U') IBFLAG," ).append("\n"); 
		query.append("  EU.SND_USR_ID," ).append("\n"); 
		query.append("  EU.SND_DT," ).append("\n"); 
		query.append("  '' OFC_CD," ).append("\n"); 
		query.append("  EU.ACK," ).append("\n"); 
		query.append("  EU.RESULT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("  VSK_ACT_PORT_SKD ACT," ).append("\n"); 
		query.append("  MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("  MDM_YARD YARD," ).append("\n"); 
		query.append("  MDM_LOCATION LOC," ).append("\n"); 
		query.append("  BKG_VSL_DCHG_YD DCHG," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT A.VSL_CD," ).append("\n"); 
		query.append("      A.SKD_VOY_NO," ).append("\n"); 
		query.append("      A.SKD_DIR_CD," ).append("\n"); 
		query.append("      A.CSTMS_PORT_CD," ).append("\n"); 
		query.append("      MAX(A.CSTMS_YD_CD) CSTMS_YD_CD," ).append("\n"); 
		query.append("      MAX(B.CSTMS_PORT_CD) CSTMS_PORT_CD_BL," ).append("\n"); 
		query.append("      MAX(B.CSTMS_YD_CD) CSTMS_YD_CD_BL," ).append("\n"); 
		query.append("      MAX(A.CVY_REF_NO) CVY_REF_NO," ).append("\n"); 
		query.append("      MAX(RVIS_N1ST_CLPT_CD) NEW_PORT," ).append("\n"); 
		query.append("      MAX(LST_CLPT_CD) LST_CLPT_CD," ).append("\n"); 
		query.append("      MAX(NXT_CLPT_CD) NXT_CLPT_CD," ).append("\n"); 
		query.append("      MAX(A.ARR_PORT_CD) ARR_PORT_CD," ).append("\n"); 
		query.append("      MAX(SND_DT) SND_DT," ).append("\n"); 
		query.append("      MAX(SND_USR_ID) SND_USR_ID," ).append("\n"); 
		query.append("      MAX(RCV.ACK_RCV_STS_CD) ACK," ).append("\n"); 
		query.append("      MAX(RCV.EUR_CSTMS_ACK_CD) RESULT" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_BL B," ).append("\n"); 
		query.append("      BKG_CSTMS_EUR_VSL A," ).append("\n"); 
		query.append("      BKG_CSTMS_ADV_EUR_SND SND," ).append("\n"); 
		query.append("      BKG_CSTMS_ADV_EUR_RCV RCV" ).append("\n"); 
		query.append("    WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("      AND A.CSTMS_PORT_CD = B.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("      AND A.MSG_SND_NO = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("	  AND SND.MSG_SND_NO = RCV.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("    GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CSTMS_PORT_CD ) EU" ).append("\n"); 
		query.append("WHERE VPS.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND VPS.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("  AND VPS.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND VPS.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND VPS.VSL_CD = DCHG.VSL_CD(+)" ).append("\n"); 
		query.append("  AND VPS.SKD_VOY_NO = DCHG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND VPS.SKD_DIR_CD = DCHG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND VPS.VSL_CD = ACT.VSL_CD(+)" ).append("\n"); 
		query.append("  AND VPS.SKD_VOY_NO = ACT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND VPS.SKD_DIR_CD = ACT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND VPS.VPS_PORT_CD = ACT.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("  AND VPS.YD_CD = DCHG.YD_CD(+)" ).append("\n"); 
		query.append("  AND VPS.VPS_PORT_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("  AND VPS.YD_CD = YARD.YD_CD" ).append("\n"); 
		query.append("  AND VPS.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND VPS.VSL_CD = EU.VSL_CD(+)" ).append("\n"); 
		query.append("  AND VPS.SKD_VOY_NO = EU.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND VPS.SKD_DIR_CD = EU.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND VPS.VPS_PORT_CD = EU.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("  AND VPS.ROWID = (" ).append("\n"); 
		query.append("    SELECT ROWID" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT ROWID" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("        WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("		  AND NVL(SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("          AND SUBSTR(A.VPS_PORT_CD, 1, 2) IN (" ).append("\n"); 
		query.append("            SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("            WHERE B.CSTMS_DIV_ID = 'EU_MEMBER_CNT' )" ).append("\n"); 
		query.append("        ORDER BY CLPT_SEQ )" ).append("\n"); 
		query.append("    WHERE ROWNUM=1 )" ).append("\n"); 

	}
}