/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHblInfoByRefNo
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL").append("\n"); 
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
		query.append("SELECT 'US' AS CNT_CD" ).append("\n"); 
		query.append("       ,H.CNTR_MF_NO AS BL_NO" ).append("\n"); 
		query.append("       ,B.BKG_NO" ).append("\n"); 
		query.append("       ,V.VSL_CD" ).append("\n"); 
		query.append("       ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,B.SLAN_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(S.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS VSL_ARR_DT" ).append("\n"); 
		query.append("       ,V.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("       ,V.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("       ,B.POR_CD" ).append("\n"); 
		query.append("	   ,B.POL_CD" ).append("\n"); 
		query.append("	   ,B.POD_CD" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       -- POD = US & DEL <> US (62 TYPE)" ).append("\n"); 
		query.append("       -- 국경을 넘기 전 마지막 US LOC 이 필요함" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,CASE WHEN V.POD_CD LIKE 'US%' AND B.DEL_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("             THEN (SELECT MAX(LST_LOC_CD) LST_LOC_CD" ).append("\n"); 
		query.append("                     FROM TRS_DMST_LST_CTY" ).append("\n"); 
		query.append("                    WHERE ORG_LOC_CD  = V.POD_CD" ).append("\n"); 
		query.append("                      AND DEST_LOC_CD = B.DEL_CD" ).append("\n"); 
		query.append("                      AND DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("         END USA_LST_LOC_CD" ).append("\n"); 
		query.append("--       ,L1.SCC_CD AS USA_LST_LOC_CD" ).append("\n"); 
		query.append("       ,DECODE(@[cstms_port_cd], NULL, V.POD_CD, @[cstms_port_cd]) CSTMS_PORT_CD" ).append("\n"); 
		query.append("	   ,DECODE(SUBSTR(V.POD_CD, 1, 2), 'US', 'N', 'Y') AS FROB_FLG" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       -- ENTRY TYPE SETUP 에서 설정한 정보가 우선적용된다. (setInbondData)" ).append("\n"); 
		query.append("       -- HUB_LOC_CD, CSTMS_LOC_CD," ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,CASE WHEN V.POD_CD = B.DEL_CD THEN V.POD_CD" ).append("\n"); 
		query.append("      		 ELSE L2.SCC_CD" ).append("\n"); 
		query.append("         END HUB_LOC_CD" ).append("\n"); 
		query.append("       ,'' AS CSTMS_LOC_CD" ).append("\n"); 
		query.append("       ,H.PCK_QTY" ).append("\n"); 
		query.append("       ,NVL((SELECT P.PCK_CD" ).append("\n"); 
		query.append("               FROM MDM_PCK_TP P" ).append("\n"); 
		query.append("              WHERE H.PCK_TP_CD  = P.PCK_CD" ).append("\n"); 
		query.append("            ),'PKG') AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,H.HBL_WGT AS CGO_WGT" ).append("\n"); 
		query.append("       ,NVL(H.WGT_UT_CD,'KGS') AS WGT_UT_CD" ).append("\n"); 
		query.append("       ,H.CMDT_MEAS_QTY AS MEAS_QTY" ).append("\n"); 
		query.append("       ,H.CMDT_MEAS_UT_CD AS MEAS_UT_CD" ).append("\n"); 
		query.append("       ,B.RCV_TERM_CD" ).append("\n"); 
		query.append("       ,B.DE_TERM_CD" ).append("\n"); 
		query.append("       ,D.BDR_FLG" ).append("\n"); 
		query.append("       ,TO_CHAR(D.BDR_DT,'YYYYMMDDHH24MISS') AS BDR_DT" ).append("\n"); 
		query.append("	   ,'' AS BDR_OFC_CD" ).append("\n"); 
		query.append("	   ,'' AS BDR_IF_USR_ID" ).append("\n"); 
		query.append("	   ,'' AS BDR_IF_DT" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("	   -- C/A Report(I/B) 화면에서 다운로드 호출 시" ).append("\n"); 
		query.append("	   -- 넘겨받은 CA_NO, CA_ISS_DT 데이터를 BL 테이블에 저장" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,DECODE(@[ca_no], NULL, NVL2(C.CA_NO, 'Y', NULL), 'Y') AS CA_FLG" ).append("\n"); 
		query.append("       ,DECODE(@[ca_iss_dt], NULL, C.CA_ISS_DT, @[ca_iss_dt]) CA_ISS_DT" ).append("\n"); 
		query.append("       ,DECODE(@[ca_no], NULL, C.CA_NO, @[ca_no]) CA_NO" ).append("\n"); 
		query.append("       ,B.SCAC_CD" ).append("\n"); 
		query.append("       ,NVL(B.USA_CSTMS_FILE_CD,'0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("	   ,B.BL_NO AS MF_NO" ).append("\n"); 
		query.append("       ,B.BKG_CGO_TP_CD AS FULL_MTY_CD" ).append("\n"); 
		query.append("       ,H.ORG_CNTR_MF_NO AS PRE_MF_NO" ).append("\n"); 
		query.append("       ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("	   ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("	   ,B.POD_NOD_CD" ).append("\n"); 
		query.append("	   ,B.DEL_NOD_CD" ).append("\n"); 
		query.append("	   ,B.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       -- FROB(F)  : US에 DISCHARGING 하지않고 지나가는 BL" ).append("\n"); 
		query.append("       -- LOCAL(L) : POD, DEL 이 모두 US PORT이고, POD, DEL의 SCC_CD가 같을 때" ).append("\n"); 
		query.append("       -- PMIB(I)  : 그외는 PMIB의 경우로 세관신고 외에 INBOND 신고를 해야한다." ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,CASE WHEN V.POD_CD NOT LIKE 'US%' THEN 'F'" ).append("\n"); 
		query.append("			 WHEN V.POD_CD LIKE 'US%' AND B.DEL_CD LIKE 'US%' AND L1.SCC_CD = L2.SCC_CD THEN 'L'" ).append("\n"); 
		query.append("             ELSE 'I'" ).append("\n"); 
		query.append("        END LOCL_TRNS_CD" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("	   -- 1) 61 : POD=US & DEL=US 이면서, POD's SCC 와 DEL's SCC 가 다른 경우" ).append("\n"); 
		query.append("	   -- 2) 62 : POD=US, DEL <> US 인 경우" ).append("\n"); 
		query.append("	   -- 3) 63 : POD <> US & DEL <> US 이고, FROB 이 아닌 경우 (Pre 또는 Post 에 US 가 있는경우)" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------" ).append("\n"); 
		query.append("       ,CASE WHEN V.POD_CD LIKE 'US%' AND B.DEL_CD LIKE 'US%' AND L1.SCC_CD <> L2.SCC_CD " ).append("\n"); 
		query.append("             THEN '61'" ).append("\n"); 
		query.append("             WHEN V.POD_CD LIKE 'US%' AND B.DEL_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("             THEN '62'" ).append("\n"); 
		query.append("             WHEN B.POD_CD NOT LIKE 'US%' AND B.DEL_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("             THEN '63'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("         END IBD_TP_CD" ).append("\n"); 
		query.append("       ,V.VSL_PRE_PST_CD||V.VSL_SEQ VVD_ORDER" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      B" ).append("\n"); 
		query.append("      ,BKG_VVD          V" ).append("\n"); 
		query.append("      ,BKG_BL_DOC       D" ).append("\n"); 
		query.append("      ,BKG_HBL          H" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("      ,MDM_LOCATION     L1" ).append("\n"); 
		query.append("      ,MDM_LOCATION     L2" ).append("\n"); 
		query.append(" 	  ,(SELECT BKG_NO" ).append("\n"); 
		query.append("              ,CORR_NO AS CA_NO" ).append("\n"); 
		query.append("        	  ,TO_CHAR(CORR_DT,'YYYYMMDDHH24MISS') AS CA_ISS_DT" ).append("\n"); 
		query.append("          FROM BKG_CORRECTION" ).append("\n"); 
		query.append("         WHERE CORR_DT = ( SELECT MAX(CORR_DT)" ).append("\n"); 
		query.append("                             FROM BKG_CORRECTION" ).append("\n"); 
		query.append("                            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                              AND CORR_CXL_FLG = 'N' " ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("           AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("   AND H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND B.BKG_NO     = V.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO     = D.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO     = H.BKG_NO" ).append("\n"); 
		query.append("   AND V.VSL_CD     = S.VSL_CD" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND V.POD_CD     = S.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND S.CLPT_IND_SEQ = (SELECT /*+ INDEX_ASC(P XPKVSK_VSL_PORT_SKD) */ P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND P.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                            AND P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND P.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND P.VPS_PORT_CD = V.POD_CD" ).append("\n"); 
		query.append("                            AND NVL(P.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1)" ).append("\n"); 
		query.append("   AND V.POD_CD     = L1.LOC_CD" ).append("\n"); 
		query.append("   AND B.DEL_CD     = L2.LOC_CD" ).append("\n"); 
		query.append("   AND B.BKG_NO     = C.BKG_NO(+)" ).append("\n"); 
		query.append("ORDER BY VVD_ORDER DESC" ).append("\n"); 

	}
}