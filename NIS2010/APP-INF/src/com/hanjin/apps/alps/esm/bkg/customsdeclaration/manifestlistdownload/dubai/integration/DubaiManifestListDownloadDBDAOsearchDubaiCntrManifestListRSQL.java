/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOsearchDubaiCntrManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOsearchDubaiCntrManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DubaiCntrManifestListVO
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOsearchDubaiCntrManifestListRSQL(){
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
		params.put("du_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_code",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOsearchDubaiCntrManifestListRSQL").append("\n"); 
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
		query.append("#if (${data_type} == 'bl')" ).append("\n"); 
		query.append("    SELECT B.BL_NO" ).append("\n"); 
		query.append("          ,B.BKG_NO" ).append("\n"); 
		query.append("          ,B.POD_CD" ).append("\n"); 
		query.append("          ,C.CNTR_NO" ).append("\n"); 
		query.append("          ,SN.CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ,ROUND(" ).append("\n"); 
		query.append("                   DECODE(NVL(S.TARE_WGT, 0), 0 ," ).append("\n"); 
		query.append("                          DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0 ," ).append("\n"); 
		query.append("                                 DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), MDM.CNTR_TPSZ_TARE_WGT) , S.TARE_WGT) " ).append("\n"); 
		query.append("                 /1000, 1)" ).append("\n"); 
		query.append("           AS CNTR_TARE_WGT" ).append("\n"); 
		query.append("          ,1 AS CNTR_MF_SEQ" ).append("\n"); 
		query.append("          ,ROW_NUMBER() OVER(PARTITION BY B.BL_NO||B.POD_CD ORDER BY B.BL_NO, B.POD_CD, C.CNTR_NO) AS DU_CNTR_SER_NO" ).append("\n"); 
		query.append("          ,B.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("          ,B.PCK_CMDT_DESC || B.CNTR_CMDT_DESC || B.CMDT_DESC || CHR(13)||CHR(10) AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("          ,B.CMDT_CD AS CMDT_HS_CD" ).append("\n"); 
		query.append("          ,C.PCK_QTY" ).append("\n"); 
		query.append("          ,P.ATTR_CTNT1 AS DU_PCK_TP_CD" ).append("\n"); 
		query.append("          ,'' PLT_QTY" ).append("\n"); 
		query.append("          ,C.CNTR_WGT AS CNTR_MF_WGT" ).append("\n"); 
		query.append("          ,C.MEAS_QTY" ).append("\n"); 
		query.append("          ,C.DCGO_FLG" ).append("\n"); 
		query.append("          ,DECODE(C.DCGO_FLG, 'Y', DG.IMDG_CLSS_CD) AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("          ,DECODE(C.DCGO_FLG, 'Y', DG.IMDG_UN_NO) AS IMDG_UN_NO" ).append("\n"); 
		query.append("          ,'' AS FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("          ,DECODE(C.DCGO_FLG, 'Y', 'C') AS DCGO_TEMP_UT_CD" ).append("\n"); 
		query.append("          ,DECODE(C.RC_FLG, 'Y', 'Y') AS DG_STO_REQ_FLG" ).append("\n"); 
		query.append("          ,C.RC_FLG AS RFRT_REQ_FLG" ).append("\n"); 
		query.append("          ,DECODE(C.RC_FLG, 'Y', NVL(RF.CDO_TEMP, RF.FDO_TEMP)) AS MIN_TEMP" ).append("\n"); 
		query.append("          ,DECODE(C.RC_FLG, 'Y', NVL(RF.CDO_TEMP, RF.FDO_TEMP)) AS MAX_TEMP" ).append("\n"); 
		query.append("          ,DECODE(C.RC_FLG, 'Y', DECODE(RF.CDO_TEMP, NULL, 'F', 'C')) AS CGO_TEMP_UT_CD" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT B.BKG_NO, B.BL_NO, V.POD_CD, B.CMDT_CD" ).append("\n"); 
		query.append("                  ,DECODE(D.PCK_CMDT_DESC, NULL, '', D.PCK_CMDT_DESC || CHR(13)||CHR(10)) AS PCK_CMDT_DESC " ).append("\n"); 
		query.append("                  ,DECODE(D.CNTR_CMDT_DESC, NULL, '', D.CNTR_CMDT_DESC || CHR(13)||CHR(10)) AS CNTR_CMDT_DESC" ).append("\n"); 
		query.append("                  ,DECODE(B.DE_TERM_CD, 'S', SUBSTR(M.MK_DESC, 1, 200), 'NIL') AS CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("                  ,CASE WHEN NVL(INSTR(M.CMDT_DESC, CHR(13)||CHR(10), 1, 1), 0) = 0 THEN M.CMDT_DESC" ).append("\n"); 
		query.append("                        ELSE SUBSTR(M.CMDT_DESC, 1, INSTR(M.CMDT_DESC, CHR(13)||CHR(10), 1, 1)-1) " ).append("\n"); 
		query.append("                   END CMDT_DESC" ).append("\n"); 
		query.append("				  ,DECODE(B.POD_CD,  V.POD_CD, 'I','T') AS DU_TRD_CD" ).append("\n"); 
		query.append("              FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                  ,BKG_BL_DOC D" ).append("\n"); 
		query.append("                  ,BKG_VVD V" ).append("\n"); 
		query.append("                  ,BKG_BL_MK_DESC M" ).append("\n"); 
		query.append("             WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("               AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("               AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("               AND B.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("               AND B.BKG_NO = M.BKG_NO(+)" ).append("\n"); 
		query.append("               AND (M.MK_SEQ IS NULL OR M.MK_SEQ = (SELECT MIN(MK_SEQ) FROM BKG_BL_MK_DESC SM WHERE SM.BKG_NO = B.BKG_NO))" ).append("\n"); 
		query.append("           #if (${bl_no} != '') " ).append("\n"); 
		query.append("               AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("               AND V.POD_CD LIKE 'AE%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${vvd} != '') " ).append("\n"); 
		query.append("               AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("               AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${pol_cd} != '') " ).append("\n"); 
		query.append("               AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${pod_cd} != '') " ).append("\n"); 
		query.append("               AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${cgo_type} == 'F') " ).append("\n"); 
		query.append("               AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n"); 
		query.append("           #elseif (${cgo_type} == 'M') " ).append("\n"); 
		query.append("               AND B.BKG_CGO_TP_CD IN ('R', 'P')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           ) B" ).append("\n"); 
		query.append("          ,BKG_CONTAINER C" ).append("\n"); 
		query.append("          ,MST_CONTAINER M" ).append("\n"); 
		query.append("          ,MST_CNTR_SPEC S" ).append("\n"); 
		query.append("          ,MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("          ,BKG_CNTR_SEAL_NO SN" ).append("\n"); 
		query.append("          ,BKG_CSTMS_CD_CONV_CTNT P" ).append("\n"); 
		query.append("          ,BKG_DG_CGO DG" ).append("\n"); 
		query.append("          ,BKG_RF_CGO RF" ).append("\n"); 
		query.append("     WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("       AND C.CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND M.CNTR_SPEC_NO = S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("       AND M.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("       AND C.BKG_NO = SN.BKG_NO(+)" ).append("\n"); 
		query.append("       AND C.CNTR_NO = SN.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND (SN.CNTR_SEAL_SEQ IS NULL OR" ).append("\n"); 
		query.append("            SN.CNTR_SEAL_SEQ = (SELECT MAX(CNTR_SEAL_SEQ)" ).append("\n"); 
		query.append("                                  FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                 WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                   AND CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       AND P.CNT_CD(+) = 'AE'" ).append("\n"); 
		query.append("       AND P.CSTMS_DIV_ID(+) = 'DUBAI_PCK_CD'" ).append("\n"); 
		query.append("       AND P.ATTR_CTNT3(+) = C.PCK_TP_CD" ).append("\n"); 
		query.append("       AND (P.CSTMS_DIV_ID_SEQ IS NULL OR " ).append("\n"); 
		query.append("            P.CSTMS_DIV_ID_SEQ = (SELECT MAX(CSTMS_DIV_ID_SEQ) " ).append("\n"); 
		query.append("                                    FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                                   WHERE CNT_CD = 'AE' " ).append("\n"); 
		query.append("                                     AND CSTMS_DIV_ID = 'DUBAI_PCK_CD'" ).append("\n"); 
		query.append("                                     AND ATTR_CTNT3 = C.PCK_TP_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       AND C.BKG_NO = DG.BKG_NO(+)" ).append("\n"); 
		query.append("       AND C.CNTR_NO = DG.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND (DG.DCGO_SEQ IS NULL OR " ).append("\n"); 
		query.append("            DG.DCGO_SEQ = (SELECT MAX(DCGO_SEQ) " ).append("\n"); 
		query.append("                             FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                            WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                              AND CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       AND C.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("       AND C.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND (RF.RC_SEQ IS NULL OR " ).append("\n"); 
		query.append("            RF.RC_SEQ = (SELECT MAX(RC_SEQ) " ).append("\n"); 
		query.append("                             FROM BKG_RF_CGO" ).append("\n"); 
		query.append("                            WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                              AND CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		#if (${du_trd_cd} != 'A'&& ${du_trd_cd} != '')" ).append("\n"); 
		query.append("      		   AND B.DU_TRD_CD = @[du_trd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("#else  " ).append("\n"); 
		query.append("    SELECT BL.BL_NO" ).append("\n"); 
		query.append("          ,B.BKG_NO" ).append("\n"); 
		query.append("          ,BL.POD_CD" ).append("\n"); 
		query.append("          ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("          ,CNTR.CNTR_TARE_WGT" ).append("\n"); 
		query.append("          ,CNTR.CNTR_SEAL_NO" ).append("\n"); 
		query.append("          ,MF.CNTR_MF_SEQ" ).append("\n"); 
		query.append("          ,MF.DU_CNTR_SER_NO" ).append("\n"); 
		query.append("          ,MF.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("          ,MF.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("          ,MF.CMDT_HS_CD" ).append("\n"); 
		query.append("          ,MF.PCK_QTY" ).append("\n"); 
		query.append("          ,MF.DU_PCK_TP_CD" ).append("\n"); 
		query.append("          ,MF.PLT_QTY" ).append("\n"); 
		query.append("          ,MF.CNTR_MF_WGT" ).append("\n"); 
		query.append("          ,MF.MEAS_QTY" ).append("\n"); 
		query.append("          ,MF.DCGO_FLG" ).append("\n"); 
		query.append("          ,MF.IMDG_CLSS_CD" ).append("\n"); 
		query.append("          ,MF.IMDG_UN_NO" ).append("\n"); 
		query.append("          ,MF.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("          ,MF.DCGO_TEMP_UT_CD" ).append("\n"); 
		query.append("          ,MF.DG_STO_REQ_FLG" ).append("\n"); 
		query.append("          ,MF.RFRT_REQ_FLG" ).append("\n"); 
		query.append("          ,MF.MIN_TEMP" ).append("\n"); 
		query.append("          ,MF.MAX_TEMP" ).append("\n"); 
		query.append("          ,MF.CGO_TEMP_UT_CD" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_DU_BL BL" ).append("\n"); 
		query.append("          ,BKG_CSTMS_DU_VVD VVD" ).append("\n"); 
		query.append("          ,BKG_CSTMS_DU_CNTR CNTR" ).append("\n"); 
		query.append("          ,BKG_CSTMS_DU_CNTR_MF MF" ).append("\n"); 
		query.append("          ,BKG_BOOKING B" ).append("\n"); 
		query.append("     WHERE BL.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("       AND BL.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("       AND BL.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND BL.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND BL.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("       AND BL.BL_NO = CNTR.BL_NO" ).append("\n"); 
		query.append("       AND BL.POD_CD = CNTR.POD_CD" ).append("\n"); 
		query.append("       AND CNTR.BL_NO = MF.BL_NO(+)" ).append("\n"); 
		query.append("       AND CNTR.POD_CD = MF.POD_CD(+)" ).append("\n"); 
		query.append("       AND CNTR.CNTR_NO = MF.CNTR_NO(+)" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND VVD.POD_CD LIKE 'AE%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} != '') " ).append("\n"); 
		query.append("       AND VVD.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("       AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cgo_code} != '') " ).append("\n"); 
		query.append("       AND BL.DU_CGO_CD = @[cgo_code]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${du_trd_cd} != 'A' && ${du_trd_cd} != '')" ).append("\n"); 
		query.append("       AND BL.DU_TRD_CD = @[du_trd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}