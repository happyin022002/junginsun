/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuBlCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier :
*@LastVersion : 1.0
* 2011.03.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOaddBkgCstmsDuBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addBkgCstmsDuBl
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOaddBkgCstmsDuBlCSQL(){
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
		params.put("rotn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n");
		query.append("FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuBlCSQL").append("\n");
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
		query.append("INSERT " ).append("\n");
		query.append("  INTO BKG_CSTMS_DU_BL" ).append("\n");
		query.append("      (" ).append("\n");
		query.append("       BL_NO" ).append("\n");
		query.append("      ,POD_CD" ).append("\n");
		query.append("      ,VSL_CD" ).append("\n");
		query.append("      ,SKD_VOY_NO" ).append("\n");
		query.append("      ,SKD_DIR_CD" ).append("\n");
		query.append("      ,DU_ROTN_NO" ).append("\n");
		query.append("      ,DU_LINE_ID" ).append("\n");
		query.append("      ,DU_VOY_AGN_ID" ).append("\n");
		query.append("      ,ORG_PORT_CD" ).append("\n");
		query.append("      ,POR_CD" ).append("\n");
		query.append("      ,POL_CD" ).append("\n");
		query.append("      ,DEL_CD" ).append("\n");
		query.append("      --,DU_MF_NO" ).append("\n");
		query.append("      ,DU_CGO_CD" ).append("\n");
		query.append("      ,DU_CNTR_SVC_TP_CD" ).append("\n");
		query.append("      ,DU_TRD_CD" ).append("\n");
		query.append("      --,DU_TS_MOD_CD" ).append("\n");
		query.append("      ,CNSL_CGO_FLG" ).append("\n");
		query.append("      ,ORG_CNT_CD" ).append("\n");
		query.append("      ,ORG_VSL_CD" ).append("\n");
		query.append("      ,ORG_SKD_VOY_NO" ).append("\n");
		query.append("      ,ORG_SKD_DIR_CD" ).append("\n");
		query.append("      ,MK_NO_CTNT" ).append("\n");
		query.append("      ,DU_CMDT_CD" ).append("\n");
		query.append("      ,CMDT_DESC" ).append("\n");
		query.append("      ,PCK_QTY" ).append("\n");
		query.append("      ,DU_PCK_DESC" ).append("\n");
		query.append("      ,DU_PCK_TP_CD" ).append("\n");
		query.append("      ,CNTR_NO" ).append("\n");
		query.append("      ,CNTR_KNT" ).append("\n");
		query.append("      ,BKG_TEU_QTY" ).append("\n");
		query.append("      ,TARE_WGT" ).append("\n");
		query.append("      ,CGO_WGT" ).append("\n");
		query.append("      ,GRS_WGT" ).append("\n");
		query.append("      ,MEAS_QTY" ).append("\n");
		query.append("      --,DU_TTL_QTY" ).append("\n");
		query.append("      ,DU_FRT_WGT" ).append("\n");
		query.append("      --,PLT_QTY" ).append("\n");
		query.append("      ,CRE_USR_ID" ).append("\n");
		query.append("      ,UPD_USR_ID" ).append("\n");
		query.append("      ) " ).append("\n");
		query.append("      (" ).append("\n");
		query.append("      SELECT BL_NO" ).append("\n");
		query.append("            ,POD_CD" ).append("\n");
		query.append("            ,VSL_CD" ).append("\n");
		query.append("            ,SKD_VOY_NO" ).append("\n");
		query.append("            ,SKD_DIR_CD" ).append("\n");
		query.append("            ,@[rotn_no]" ).append("\n");
		query.append("            ,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() " ).append("\n");
		query.append("            ,BKG_GET_BKG_CTMS_CD_FNC('DU','MANI_VOY_AGN_ID',3590,1) " ).append("\n");
		query.append("            ,'' ORG_PORT_CD" ).append("\n");
		query.append("            ,POR_CD" ).append("\n");
		query.append("            ,POL_CD" ).append("\n");
		query.append("            ,DEL_CD" ).append("\n");
		query.append("            --,DU_MF_NO" ).append("\n");
		query.append("            ,DU_CGO_CD" ).append("\n");
		query.append("            ,DU_CNTR_SVC_TP_CD" ).append("\n");
		query.append("            ,DU_TRD_CD" ).append("\n");
		query.append("            --,DU_TS_MOD_CD" ).append("\n");
		query.append("            ,CNSL_CGO_FLG" ).append("\n");
		query.append("            ,SUBSTR(POR_CD, 1, 2) AS ORG_CNT_CD" ).append("\n");
		query.append("            ,'' ORG_VSL_CD" ).append("\n");
		query.append("            ,'' ORG_SKD_VOY_NO" ).append("\n");
		query.append("            ,'' ORG_SKD_DIR_CD" ).append("\n");
		query.append("            ,MK_NO_CTNT" ).append("\n");
		query.append("            ,DU_CMDT_CD" ).append("\n");
		query.append("            ,CASE WHEN NVL(INSTR(CMDT_DESC, CHR(10), 1, 5), 0) = 0 THEN SUBSTR(CMDT_DESC, 1, 100)" ).append("\n");
		query.append("                  WHEN LENGTH(SUBSTR(CMDT_DESC, 1, INSTR(CMDT_DESC, CHR(10), 1, 5))) > 100" ).append("\n");
		query.append("                       THEN SUBSTR(CMDT_DESC, 1, INSTR(CMDT_DESC, CHR(10), 1, 4)-1) " ).append("\n");
		query.append("                  WHEN LENGTH(SUBSTR(CMDT_DESC, 1, INSTR(CMDT_DESC, CHR(10), 1, 4))) > 100" ).append("\n");
		query.append("                       THEN SUBSTR(CMDT_DESC, 1, INSTR(CMDT_DESC, CHR(10), 1, 3)-1) " ).append("\n");
		query.append("                  WHEN LENGTH(SUBSTR(CMDT_DESC, 1, INSTR(CMDT_DESC, CHR(10), 1, 3))) > 100" ).append("\n");
		query.append("                       THEN SUBSTR(CMDT_DESC, 1, INSTR(CMDT_DESC, CHR(10), 1, 2)-1) " ).append("\n");
		query.append("             END CMDT_DESC" ).append("\n");
		query.append("            ,PCK_QTY" ).append("\n");
		query.append("            ,DU_PCK_DESC" ).append("\n");
		query.append("            ,DU_PCK_TP_CD" ).append("\n");
		query.append("            ,CNTR_NO" ).append("\n");
		query.append("            ,CNTR_KNT" ).append("\n");
		query.append("            ,BKG_TEU_QTY" ).append("\n");
		query.append("            ,ROUND(TARE_WGT/1000, 1)" ).append("\n");
		query.append("            ,CGO_WGT" ).append("\n");
		query.append("            ,GRS_WGT" ).append("\n");
		query.append("            ,ROUND(MEAS_QTY, 1)" ).append("\n");
		query.append("            --,DU_TTL_QTY" ).append("\n");
		query.append("            ,ROUND(DU_FRT_WGT, 1)" ).append("\n");
		query.append("            --,PLT_QTY" ).append("\n");
		query.append("            ,@[upd_usr_id] CRE_USR_ID" ).append("\n");
		query.append("            ,@[upd_usr_id] UPD_USR_ID" ).append("\n");
		query.append("       FROM (" ).append("\n");
		query.append("             SELECT TB2.CGO_WGT + TB2.TARE_WGT AS GRS_WGT" ).append("\n");
		query.append("             	  ,P.PCK_CSTMS_CD" ).append("\n");
		query.append("             	  ,P.PCK_CD" ).append("\n");
		query.append("             	  ,TB2.PCK_CMDT_DESC || TB2.CNTR_CMDT_DESC || M.CMDT_DESC AS CMDT_DESC" ).append("\n");
		query.append("             	  ,DECODE(SUBSTR(TB2.DU_CNTR_SVC_TP_CD, 2,1), 'L', SUBSTR(M.MK_DESC, 1, 200), 'NIL') MK_NO_CTNT" ).append("\n");
		query.append("                  ,PCK.ATTR_CTNT1 AS DU_PCK_TP_CD" ).append("\n");
		query.append("                  ,PCK.ATTR_CTNT2 AS DU_PCK_DESC" ).append("\n");
		query.append("                  ,DECODE(TB2.FULL_MTY_CD || TB2.CNTR_NO, 'M', 'M', 'F', 'F', 'L') AS DU_CGO_CD" ).append("\n");
		query.append("                  ,DECODE(TB2.CNTR_NO, NULL, 'N', 'Y') AS CNSL_CGO_FLG" ).append("\n");
		query.append("                  ,TB2.*" ).append("\n");
		query.append("               FROM (" ).append("\n");
		query.append("                     SELECT COUNT(C.BKG_NO) AS CNTR_KNT" ).append("\n");
		query.append("                           ,CASE WHEN COUNT(C.BKG_NO) = 1 AND MIN(C.CNTR_VOL_QTY) <> 1 THEN MIN(C.CNTR_NO)" ).append("\n");
		query.append("                             END CNTR_NO" ).append("\n");
		query.append("                           ,SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2,1), '2', 1, 2)) AS BKG_TEU_QTY" ).append("\n");
		query.append("                           ,SUM(DECODE(NVL(S.TARE_WGT, 0), 0 , " ).append("\n");
		query.append("                                       DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0 ,                                             " ).append("\n");
		query.append("                                              DECODE(M.CNTR_TPSZ_CD, BKG_GET_BKG_CTMS_CD_FNC('DU','MANI_CNTR_TPSZ_CD','3592',1), BKG_GET_BKG_CTMS_CD_FNC('DU','MANI_CNTR_TPSZ_CD','3592',2)," ).append("\n");
		query.append("                                                                     BKG_GET_BKG_CTMS_CD_FNC('DU','MANI_CNTR_TPSZ_CD','3593',1), BKG_GET_BKG_CTMS_CD_FNC('DU','MANI_CNTR_TPSZ_CD','3593',2), 0), MDM.CNTR_TPSZ_TARE_WGT) , S.TARE_WGT )) AS TARE_WGT" ).append("\n");
		query.append("                           ,DECODE(TB.BKG_POD_CD, TB.POD_CD, 'I', 'T') AS DU_TRD_CD" ).append("\n");
		query.append("                           ,TB.*" ).append("\n");
		query.append("                       FROM (" ).append("\n");
		query.append("                             SELECT B.BKG_NO" ).append("\n");
		query.append("                                   ,B.BL_NO" ).append("\n");
		query.append("                                   ,V.VSL_CD" ).append("\n");
		query.append("                                   ,V.SKD_VOY_NO" ).append("\n");
		query.append("                                   ,V.SKD_DIR_CD" ).append("\n");
		query.append("                                   ,B.POD_CD AS BKG_POD_CD" ).append("\n");
		query.append("                                   ,B.POR_CD" ).append("\n");
		query.append("                                   ,V.POL_CD" ).append("\n");
		query.append("                                   ,V.POD_CD" ).append("\n");
		query.append("                                   ,B.DEL_CD" ).append("\n");
		query.append("                                   ,B.CMDT_CD AS DU_CMDT_CD" ).append("\n");
		query.append("                                   ,D.PCK_QTY" ).append("\n");
		query.append("                                   ,D.ACT_WGT AS CGO_WGT" ).append("\n");
		query.append("                                   ,D.MEAS_QTY" ).append("\n");
		query.append("                                   ,D.MEAS_QTY AS DU_FRT_WGT" ).append("\n");
		query.append("                                   ,D.PCK_TP_CD" ).append("\n");
		query.append("                                   ,DECODE(B.BKG_CGO_TP_CD, 'F', 'F', 'M') AS FULL_MTY_CD" ).append("\n");
		query.append("                                   ,DECODE(D.PCK_CMDT_DESC, NULL, '', D.PCK_CMDT_DESC || CHR(10)) AS PCK_CMDT_DESC " ).append("\n");
		query.append("                                   ,DECODE(D.CNTR_CMDT_DESC, NULL, '', D.CNTR_CMDT_DESC || CHR(10)) AS CNTR_CMDT_DESC " ).append("\n");
		query.append("                                   ,DECODE(B.RCV_TERM_CD||B.DE_TERM_CD, 'YS', 'FL', 'SS', 'LL', 'FF') AS DU_CNTR_SVC_TP_CD" ).append("\n");
		query.append("                               FROM BKG_BOOKING B" ).append("\n");
		query.append("                                   ,BKG_VVD V" ).append("\n");
		query.append("                                   ,BKG_BL_DOC D" ).append("\n");
		query.append("                              WHERE B.BKG_NO = V.BKG_NO" ).append("\n");
		query.append("                                AND B.BKG_NO = D.BKG_NO" ).append("\n");
		query.append("                                AND B.BKG_STS_CD IN ('F','W')" ).append("\n");
		query.append("                                AND B.BL_NO IS NOT NULL" ).append("\n");
		query.append("#if (${bl_no} != '') " ).append("\n");
		query.append("                                AND B.BL_NO = @[bl_no]" ).append("\n");
		query.append("                                AND V.POD_CD LIKE 'AE%'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${vvd} != '')" ).append("\n");
		query.append("                                AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("                                AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("                                AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pol_cd} != '')" ).append("\n");
		query.append("                                AND V.POL_CD = @[pol_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pod_cd} != '')" ).append("\n");
		query.append("                                AND V.POD_CD = @[pod_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${cgo_type} == 'F') " ).append("\n");
		query.append("							    AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n");
		query.append("#elseif (${cgo_type} == 'M') " ).append("\n");
		query.append("							    AND B.BKG_CGO_TP_CD IN ('R', 'P')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("                            ) TB" ).append("\n");
		query.append("                           ,BKG_CONTAINER C" ).append("\n");
		query.append("                           ,MST_CONTAINER M" ).append("\n");
		query.append("                           ,MST_CNTR_SPEC S" ).append("\n");
		query.append("                           ,MDM_CNTR_TP_SZ MDM" ).append("\n");
		query.append("                      WHERE TB.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("                        AND C.CNTR_NO = M.CNTR_NO(+)" ).append("\n");
		query.append("                        AND M.CNTR_SPEC_NO = S.CNTR_SPEC_NO(+)" ).append("\n");
		query.append("                        AND M.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD(+)" ).append("\n");
		query.append("                      GROUP BY  TB.BKG_NO" ).append("\n");
		query.append("                               ,TB.BL_NO" ).append("\n");
		query.append("                               ,TB.VSL_CD" ).append("\n");
		query.append("                               ,TB.SKD_VOY_NO" ).append("\n");
		query.append("                               ,TB.SKD_DIR_CD" ).append("\n");
		query.append("                               ,TB.BKG_POD_CD" ).append("\n");
		query.append("                               ,TB.POR_CD" ).append("\n");
		query.append("                               ,TB.POL_CD" ).append("\n");
		query.append("                               ,TB.POD_CD" ).append("\n");
		query.append("                               ,TB.DEL_CD" ).append("\n");
		query.append("                               ,TB.DU_CMDT_CD" ).append("\n");
		query.append("                               ,TB.PCK_QTY" ).append("\n");
		query.append("                               ,TB.CGO_WGT" ).append("\n");
		query.append("                               ,TB.MEAS_QTY" ).append("\n");
		query.append("                               ,TB.DU_FRT_WGT" ).append("\n");
		query.append("                               ,TB.PCK_TP_CD" ).append("\n");
		query.append("                               ,TB.FULL_MTY_CD" ).append("\n");
		query.append("                               ,TB.PCK_CMDT_DESC" ).append("\n");
		query.append("                               ,TB.CNTR_CMDT_DESC" ).append("\n");
		query.append("                               ,TB.DU_CNTR_SVC_TP_CD" ).append("\n");
		query.append("                    )TB2" ).append("\n");
		query.append("                   ,MDM_CSTMS_PCK_TP P" ).append("\n");
		query.append("                   ,BKG_BL_MK_DESC M" ).append("\n");
		query.append("                   ,BKG_CSTMS_CD_CONV_CTNT PCK" ).append("\n");
		query.append("              WHERE TB2.PCK_TP_CD = P.PCK_CD(+)" ).append("\n");
		query.append("                AND P.CSTMS_CNT_CD(+) = 'AE'" ).append("\n");
		query.append("                AND TB2.BKG_NO = M.BKG_NO(+)" ).append("\n");
		query.append("                AND (M.MK_SEQ IS NULL OR M.MK_SEQ = (SELECT MIN(MK_SEQ) FROM BKG_BL_MK_DESC SM WHERE SM.BKG_NO = TB2.BKG_NO))" ).append("\n");
		query.append("                AND PCK.CNT_CD(+) = 'AE'" ).append("\n");
		query.append("                AND PCK.CSTMS_DIV_ID(+) = 'DUBAI_PCK_CD'" ).append("\n");
		query.append("                AND TB2.PCK_TP_CD = PCK.ATTR_CTNT3(+)" ).append("\n");
		query.append("                AND (PCK.CSTMS_DIV_ID_SEQ IS NULL OR " ).append("\n");
		query.append("                     PCK.CSTMS_DIV_ID_SEQ = (SELECT MAX(CSTMS_DIV_ID_SEQ) " ).append("\n");
		query.append("                                               FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n");
		query.append("                                              WHERE CNT_CD = 'AE' " ).append("\n");
		query.append("                                                AND CSTMS_DIV_ID = 'DUBAI_PCK_CD'" ).append("\n");
		query.append("                                                AND ATTR_CTNT3 = TB2.PCK_TP_CD" ).append("\n");
		query.append("                                            )" ).append("\n");
		query.append("                    )" ).append("\n");
		query.append("             )" ).append("\n");
		query.append("       )" ).append("\n");

	}
}