/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchBlInqInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchBlInqInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L Inquiry화면에서 보여지는 B/L Info 를 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchBlInqInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchBlInqInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("     , BKG_CGO_TP_CD" ).append("\n"); 
		query.append("     , DECODE(CSTMS_DECL_TP_CD,'I',DECODE(SUBSTR(POD_CD,1,2),'KR',DECODE(SUBSTR(TS_POD_CD,1,2),'KR','1')),'T',DECODE(SUBSTR(POD_CD,1,2),'KR',DECODE(SUBSTR(TS_POD_CD,1,2),'KR','1')),DECODE(SUBSTR(POD_CD,1,2),'KR',DECODE(SUBSTR(TS_POD_CD,1,2),'KR','2'))) CGO_TRSP_CD2" ).append("\n"); 
		query.append("     , POR_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("	 , TS_POD_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , DEL_CD " ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , TRIM(MST_BL_SEQ_NO) MSN_NO" ).append("\n"); 
		query.append("     , KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("     , NULL FLDR_CD" ).append("\n"); 
		query.append("     , PCK_QTY" ).append("\n"); 
		query.append("     , PCK_TP_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(WGT_UT_CD, '   '), 'LBS', ROUND(NVL(CNTR_TTL_WGT, 0)*0.4536, 3), NVL(CNTR_TTL_WGT, 0)) CNTR_TTL_WGT" ).append("\n"); 
		query.append("     , DECODE(NVL(WGT_UT_CD, '   '), 'LBS', 'KGS', NVL(WGT_UT_CD, '   ')) WGT_UT_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(BL_MEAS_UT_CD, '   '), 'CBF', ROUND(NVL(MEAS_QTY, 0)*0.0283, 3), NVL(MEAS_QTY, 0)) MEAS_QTY" ).append("\n"); 
		query.append("     , DECODE(NVL(BL_MEAS_UT_CD, '   '), 'CBF', 'CBM', NVL(BL_MEAS_UT_CD, '   ')) BL_MEAS_UT_CD" ).append("\n"); 
		query.append("     , DECODE(TO_NUMBER(NVL(CSTMS_OFC_CTY_CD, '0')), 0, DECODE(TS_POD_CD, 'KRINC', 20, 'KRPUS', 30, 'KRKAN', 62, 'KRPTK', 16, 'KRUSN', 110, 0), TO_NUMBER(NVL(CSTMS_OFC_CTY_CD, '0'))) TAX_CODE1" ).append("\n"); 
		query.append("     , DECODE(TO_NUMBER(NVL(KR_CSTMS_DEPT_CD, '0')), 0, DECODE(TS_POD_CD, 'KRINC', 10, 'KRPUS', DECODE(@[trans_tp], 'I', 27, 'T', 27, 10), 'KRKAN', 10, 'KRPTK', 10, 'KRUSN', 10, 0), TO_NUMBER(NVL(KR_CSTMS_DEPT_CD, '0'))) TAX_CODE2" ).append("\n"); 
		query.append("     , TRIM(BD_AREA_CD) BD_AREA_CD" ).append("\n"); 
		query.append("     , CSTMS_CRR_IN_LOC_WH_CD" ).append("\n"); 
		query.append("     , KR_CSTMS_WH_TP_CD KR_CSTMS_WH_TP_CD" ).append("\n"); 
		query.append("     , REPLACE(KR_WH_CD, CHR(9), ' ') KR_WH_CD" ).append("\n"); 
		query.append("     , IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , N2ND_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , N3RD_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , KR_MEAS_UT_CD" ).append("\n"); 
		query.append("     , DECODE(@[cstms_decl_tp_cd],'T','', NVL(BIZ_RGST_NO, @[biz_rgst_no])) BIZ_RGST_NO" ).append("\n"); 
		query.append("     , BB_CGO_WGT" ).append("\n"); 
		query.append("     , BB_CGO_MEAS_QTY" ).append("\n"); 
		query.append("     , REPLACE(CGO_DESC1, CHR(9), ' ') CGO_DESC1" ).append("\n"); 
		query.append("     , REPLACE(CGO_DESC2, CHR(9), ' ') CGO_DESC2" ).append("\n"); 
		query.append("     , KR_CSTMS_BND_CD" ).append("\n"); 
		query.append("     , TRNS_SEQ" ).append("\n"); 
		query.append("	 , CGO_TRSP_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append(" WHERE CSTMS_BL_NO = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("   AND CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("   AND DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND TRNS_SEQ = (" ).append("\n"); 
		query.append("                     SELECT NVL(MAX(TRNS_SEQ),1)" ).append("\n"); 
		query.append("                       FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("                      WHERE CSTMS_BL_NO = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("                        AND DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                        AND CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}