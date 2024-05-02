/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOSearchEurDgExcelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.05.11 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOSearchEurDgExcelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur Dg Port를 Excel 다운로드 하기위해 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOSearchEurDgExcelListRSQL(){
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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOSearchEurDgExcelListRSQL").append("\n"); 
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
		query.append("SELECT NO " ).append("\n"); 
		query.append("     , CNTR_NO " ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , BL_NO " ).append("\n"); 
		query.append("     , G_WEIGHT " ).append("\n"); 
		query.append("     , N_WEIGHT " ).append("\n"); 
		query.append("     , PROPER_SHIPPING_NAME " ).append("\n"); 
		query.append("     , HZD_DESC " ).append("\n"); 
		query.append("     , CLS_SUB AS CLS_SUB" ).append("\n"); 
		query.append("     , UN_NO " ).append("\n"); 
		query.append("     , PG " ).append("\n"); 
		query.append("     , CGO_OPR_CD" ).append("\n"); 
		query.append("     , FP " ).append("\n"); 
		query.append("     , EMS1" ).append("\n"); 
		query.append("     , MP " ).append("\n"); 
		query.append("     , MPA " ).append("\n"); 
		query.append("     , EMERGENCY_TEL" ).append("\n"); 
		query.append("     , PIC" ).append("\n"); 
		query.append("     , QTY_PACKAGE_TYPE " ).append("\n"); 
		query.append("     , STOWAGE " ).append("\n"); 
		query.append("     , IMDG_LMT_QTY_FLG " ).append("\n"); 
		query.append("     , POL_CD " ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , BKG_DEL_CD " ).append("\n"); 
		query.append("     , POL_NAME" ).append("\n"); 
		query.append("     , POD_NAME" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , NVL2(EUR_INR_PCK_DESC,NVL2(EUR_INR_PCK_DESC||EUR_INR_PCK_DESC_CD,IN_IMDG_PCK_QTY1,'')||' '||EUR_INR_PCK_DESC, NVL2(EUR_INR_PCK_DESC||EUR_INR_PCK_DESC_CD,IN_IMDG_PCK_QTY1,'')||' '||EUR_INR_PCK_DESC_CD) AS INNER_PACKAGE_DETAIL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT NO " ).append("\n"); 
		query.append("     , CNTR_NO " ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , BL_NO " ).append("\n"); 
		query.append("     , G_WEIGHT " ).append("\n"); 
		query.append("     , N_WEIGHT " ).append("\n"); 
		query.append("     , PROPER_SHIPPING_NAME " ).append("\n"); 
		query.append("     , HZD_DESC " ).append("\n"); 
		query.append("     , CLS_SUB " ).append("\n"); 
		query.append("     , UN_NO " ).append("\n"); 
		query.append("     , PG " ).append("\n"); 
		query.append("     , CGO_OPR_CD" ).append("\n"); 
		query.append("     , FP " ).append("\n"); 
		query.append("     , EMS1||'/'||EMS2 AS EMS1" ).append("\n"); 
		query.append("     , MP " ).append("\n"); 
		query.append("     , MPA " ).append("\n"); 
		query.append("     , EMERGENCY_TEL" ).append("\n"); 
		query.append("     , PIC" ).append("\n"); 
		query.append("     , QTY_PACKAGE_TYPE " ).append("\n"); 
		query.append("     , STOWAGE " ).append("\n"); 
		query.append("     , IMDG_LMT_QTY_FLG " ).append("\n"); 
		query.append("     , POL_CD " ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , BKG_DEL_CD " ).append("\n"); 
		query.append("     , POL_NAME" ).append("\n"); 
		query.append("     , POD_NAME" ).append("\n"); 
		query.append("     , IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("     , EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("     , CASE WHEN IN_IMDG_PCK_CD1 ='4ASTL' THEN (SELECT SUBSTR(IMDG_PCK_DESC,21) FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("       ELSE (SELECT SUBSTR(IMDG_PCK_DESC,19) FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("       END AS EUR_INR_PCK_DESC_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT DENSE_RANK() OVER(ORDER BY EUR_DG.POL_CD,EUR_DG.POD_CD,EUR_DG.BL_NO, NVL(EUR_DG.CNTR_NO, ' ')) AS NO" ).append("\n"); 
		query.append("            , NVL(EUR_DG.CNTR_NO, ' ') AS CNTR_NO " ).append("\n"); 
		query.append("            , EUR_DG.VSL_CD AS VSL_CD  " ).append("\n"); 
		query.append("            , NVL(EUR_DG.CNTR_TPSZ_CD, ' ') AS CNTR_TPSZ_CD " ).append("\n"); 
		query.append("            , EUR_DG.BL_NO AS BL_NO " ).append("\n"); 
		query.append("            , TO_CHAR(NVL(EUR_DG.GRS_WGT,0))|| ' ' || 'KGS' AS G_WEIGHT " ).append("\n"); 
		query.append("            , TO_CHAR(NVL(EUR_DG.NET_WGT,0))|| ' ' || 'KGS' AS N_WEIGHT " ).append("\n"); 
		query.append("            , SUBSTR(REPLACE(TRANSLATE(EUR_DG.PRP_SHP_NM,CHR(13)||CHR(10),' '),CHR(34),' '),1,100) ||DECODE(IMDG_LMT_QTY_FLG,'Y',' / LTD QTY',NULL) AS PROPER_SHIPPING_NAME " ).append("\n"); 
		query.append("            , SUBSTR(REPLACE(TRANSLATE(EUR_DG.HZD_DESC,CHR(13)||CHR(10),' '),CHR(34),' '),1,100) AS HZD_DESC " ).append("\n"); 
		query.append("            , 'Class '||EUR_DG.IMDG_CLSS_CD||SCG.IMDG_COMP_GRP_CD|| REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE( CHR(13)||CHR(10)||'('||EUR_DG.IMDG_SUBS_RSK_LBL_CD1||','||EUR_DG.IMDG_SUBS_RSK_LBL_CD2||','||EUR_DG.IMDG_SUBS_RSK_LBL_CD3||','||EUR_DG.IMDG_SUBS_RSK_LBL_CD4||')' ,',)',')'),',)',')'),',)',')'),',,',','),',,',','),'(,','('),'()','') AS CLS_SUB " ).append("\n"); 
		query.append("			, NVL(EUR_DG.IMDG_UN_NO,' ') AS UN_NO " ).append("\n"); 
		query.append("            , DECODE(EUR_DG.IMDG_PCK_GRP_CD,'1','I','2','II','3','III','N') AS PG " ).append("\n"); 
		query.append("            , EUR_DG.FLSH_PNT_CDO_TEMP AS FP " ).append("\n"); 
		query.append("            , SUBSTRB(SCG.IMDG_EMER_NO, 1, 3) AS EMS1 " ).append("\n"); 
		query.append("            , SUBSTRB(SCG.IMDG_EMER_NO, 5, 3) AS EMS2" ).append("\n"); 
		query.append("            , EUR_DG.CGO_OPR_CD AS CGO_OPR_CD" ).append("\n"); 
		query.append("            , REPLACE(TRANSLATE(NVL(MDM_POL.LOC_NM, ' '), CHR(10), ' '), CHR(34), ' ') AS POL_NAME " ).append("\n"); 
		query.append("            , REPLACE(TRANSLATE(NVL(MDM_POD.LOC_NM, ' '), CHR(10), ' '), CHR(34), ' ') AS POD_NAME " ).append("\n"); 
		query.append("            , EUR_DG.EUR_DCGO_MRN_POLUT_CD AS MP " ).append("\n"); 
		query.append("            , NVL(SCG.PSA_NO,' ') AS MPA " ).append("\n"); 
		query.append("            , EUR_DG.EMER_CNTC_PHN_NO AS EMERGENCY_TEL" ).append("\n"); 
		query.append("            , EUR_DG.EMER_CNTC_PSON_NM AS PIC" ).append("\n"); 
		query.append("            , EUR_DG.EUR_OUTR_PCK_DESC AS QTY_PACKAGE_TYPE " ).append("\n"); 
		query.append("            , EUR_DG.EUR_INR_PCK_DESC " ).append("\n"); 
		query.append("            , EUR_DG.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("            , EUR_DG.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("            , EUR_DG.CELL_PSN_NO AS STOWAGE " ).append("\n"); 
		query.append("            , EUR_DG.IMDG_LMT_QTY_FLG " ).append("\n"); 
		query.append("            , EUR_DG.POL_CD " ).append("\n"); 
		query.append("            , EUR_DG.POD_CD " ).append("\n"); 
		query.append("            , '' AS BKG_DEL_CD " ).append("\n"); 
		query.append("         FROM BKG_CSTMS_EUR_DG EUR_DG " ).append("\n"); 
		query.append("            , SCG_IMDG_UN_NO SCG " ).append("\n"); 
		query.append("            , MDM_LOCATION MDM_POL " ).append("\n"); 
		query.append("            , MDM_LOCATION MDM_POD " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND EUR_DG.IMDG_UN_NO = SCG.IMDG_UN_NO(+) " ).append("\n"); 
		query.append("              AND EUR_DG.IMDG_UN_NO_SEQ = SCG.IMDG_UN_NO_SEQ(+) " ).append("\n"); 
		query.append("              AND EUR_DG.POL_CD = MDM_POL.LOC_CD " ).append("\n"); 
		query.append("              AND EUR_DG.POD_CD = MDM_POD.LOC_CD " ).append("\n"); 
		query.append("              AND EUR_DG.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("              AND EUR_DG.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("              AND EUR_DG.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 4)" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              #if (${list_type} == 'L') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'L'" ).append("\n"); 
		query.append("              #end 			  " ).append("\n"); 
		query.append("			  #if (${list_type} == 'D') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'D'" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'T') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'T'" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'B') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'BE') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'SE') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if (${pol_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if (${pod_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		      #if (${crr_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.CGO_OPR_CD = @[crr_cd]" ).append("\n"); 
		query.append("              #end               " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("ORDER BY NO)" ).append("\n"); 

	}
}