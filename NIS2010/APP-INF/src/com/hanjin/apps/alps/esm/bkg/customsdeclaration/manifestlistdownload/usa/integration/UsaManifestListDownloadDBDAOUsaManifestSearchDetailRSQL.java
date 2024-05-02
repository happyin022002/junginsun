/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOUsaManifestSearchDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOUsaManifestSearchDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0613 상세조회
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOUsaManifestSearchDetailRSQL(){
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
		params.put("full_empty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOUsaManifestSearchDetailRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO, A.POL, A.POD, A.DEL, A.PK, A.WT, A.SHPR_NM, A.SHPR_AD," ).append("\n"); 
		query.append("	CNEE_NM, CNEE_AD, NTFY_NM, NTFY_AD, CNTR_NO, SEAL,  CNTR_PK,  CNTR_WT," ).append("\n"); 
		query.append("	CNTR_MK, CNTR_DS, FILER, VVD, TRANSMIT_CD, FULL_MTY_CD, USR_ID, OFC_CD, ETA," ).append("\n"); 
		query.append("	SUM(SEQ) OVER (ORDER BY A.BL_NO) ROW_SEQ," ).append("\n"); 
		query.append("	'' MF_STS_CODE --VO 생성시 사용" ).append("\n"); 
		query.append("	,'' PAGE_GUBUN --VO 생성시 사용" ).append("\n"); 
		query.append("    ,'' sel_isf_act_cd --VO 생성시 사용" ).append("\n"); 
		query.append("FROM (	" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("					   DECODE(LAG(A.BL_NO) OVER( order by a.BL_NO), A.BL_NO, 0, 1) seq,	" ).append("\n"); 
		query.append("				       NVL(A.BL_NO,' ') BL_NO," ).append("\n"); 
		query.append("				       NVL(A.CSTMS_POL_CD,' ') POL,   NVL(A.CSTMS_POD_CD,' ') POD,   NVL(A.DEL_CD,' ') DEL," ).append("\n"); 
		query.append("				       DECODE(A.PCK_QTY,NULL,'N',0,'N','Y') PK," ).append("\n"); 
		query.append("				       DECODE(A.CGO_WGT,NULL,'N',0,'N','Y') WT," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C1.CUST_NM)),NULL,'N','Y') SHPR_NM, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C1.CUST_ADDR)),NULL,'N','Y') SHPR_AD," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C2.CUST_NM)),NULL,'N','Y') CNEE_NM, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C2.CUST_ADDR)),NULL,'N','Y') CNEE_AD," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C3.CUST_NM)),NULL,'N','Y') NTFY_NM, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C3.CUST_ADDR)),NULL,'N','Y') NTFY_AD," ).append("\n"); 
		query.append("				       NVL(B.CNTR_NO,' ') CNTR_NO,    " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM((" ).append("\n"); 
		query.append("    						SELECT MAX(SEAL_NO) FROM BKG_CSTMS_SEAL_NO" ).append("\n"); 
		query.append("    						WHERE CNT_CD         = A.CNT_CD" ).append("\n"); 
		query.append("        					AND BL_NO        = A.BL_NO" ).append("\n"); 
		query.append("        					AND CSTMS_DIV_ID = 'CTM'" ).append("\n"); 
		query.append("    						))),NULL,'N','Y') SEAL," ).append("\n"); 
		query.append("				       DECODE(D.PCK_QTY,NULL,'N',0,'N','Y') CNTR_PK," ).append("\n"); 
		query.append("						DECODE(D.GRS_WGT,NULL,'N',0,'N','Y') CNTR_WT," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(D.MK_DESC)),NULL,'N','Y') CNTR_MK, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(D.CGO_DESC)),NULL,'N','Y') CNTR_DS," ).append("\n"); 
		query.append("				       DECODE(NVL(A.MF_NO, ' '), ' ', DECODE(A.CSTMS_FILE_TP_CD,NULL,'3','0','1', A.CSTMS_FILE_TP_CD), ' ') FILER," ).append("\n"); 
		query.append("					   A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("					   'MI' TRANSMIT_CD," ).append("\n"); 
		query.append("					   DECODE(A.FULL_MTY_CD, 'P', 'E', 'E', 'E', 'F') FULL_MTY_CD," ).append("\n"); 
		query.append("					   '' USR_ID, '' OFC_CD," ).append("\n"); 
		query.append("                       (SELECT CASE WHEN MAX(VPS_ETA_DT) IS NULL THEN '' ELSE TO_CHAR(MAX(VPS_ETA_DT), 'YYYYMMDD HH24MI') END " ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                         WHERE  VSL_CD         = A.VSL_CD" ).append("\n"); 
		query.append("                            AND SKD_VOY_NO     = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND SKD_DIR_CD     = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND VPS_PORT_CD    = A.CSTMS_POD_CD) ETA	" ).append("\n"); 
		query.append("				FROM   BKG_CSTMS_ADV_BL A, BKG_CSTMS_ADV_CNTR B, BKG_CSTMS_ADV_CNTR_MF D," ).append("\n"); 
		query.append("				       BKG_CSTMS_ADV_CUST C1, BKG_CSTMS_ADV_CUST C2, BKG_CSTMS_ADV_CUST C3				       " ).append("\n"); 
		query.append("				WHERE  " ).append("\n"); 
		query.append("				A.CNT_CD = 'US'" ).append("\n"); 
		query.append("				AND A.VSL_CD         = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				AND A.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("				AND A.CSTMS_POL_CD    LIKE NVL(@[pol],'%')" ).append("\n"); 
		query.append("				AND (A.CSTMS_POD_CD   LIKE NVL(@[pod],'%')" ).append("\n"); 
		query.append("				OR  A.CSTMS_POD_CD    = DECODE(@[pod],'USLAX','MXZLO',@[pod])" ).append("\n"); 
		query.append("				OR  A.CSTMS_POD_CD    = DECODE(@[pod],'USOAK','MXZLO',@[pod])" ).append("\n"); 
		query.append("				OR  A.CSTMS_POD_CD    = DECODE(@[pod],'USLAX','MXESE',@[pod]))" ).append("\n"); 
		query.append("				--AND A.CSTMS_FILE_TP_CD not in ('1','2')" ).append("\n"); 
		query.append("				AND A.MF_STS_CD      = 'A'" ).append("\n"); 
		query.append("				AND A.CNT_CD         = B.CNT_CD(+)" ).append("\n"); 
		query.append("				AND A.BL_NO          = B.BL_NO(+)" ).append("\n"); 
		query.append("				AND B.IBD_CNTR_STS_CD(+)   = 'A'" ).append("\n"); 
		query.append("				AND B.CNT_CD         = D.CNT_CD(+)" ).append("\n"); 
		query.append("				AND B.BL_NO          = D.BL_NO(+)" ).append("\n"); 
		query.append("				AND B.CNTR_NO        = D.CNTR_NO(+)" ).append("\n"); 
		query.append("				AND A.CNT_CD         = C1.CNT_CD(+)" ).append("\n"); 
		query.append("				AND A.BL_NO          = C1.BL_NO(+)" ).append("\n"); 
		query.append("				AND C1.BKG_CUST_TP_CD(+)     = 'S' -- shipper" ).append("\n"); 
		query.append("				AND A.CNT_CD         = C2.CNT_CD(+)" ).append("\n"); 
		query.append("				AND A.BL_NO          = C2.BL_NO(+)" ).append("\n"); 
		query.append("				AND C2.BKG_CUST_TP_CD(+)     = 'C' -- consignee" ).append("\n"); 
		query.append("				AND A.CNT_CD         = C3.CNT_CD(+)" ).append("\n"); 
		query.append("				AND A.BL_NO          = C3.BL_NO(+)" ).append("\n"); 
		query.append("				AND C3.BKG_CUST_TP_CD(+)     = 'N' -- notifier" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${full_empty} == 'F') " ).append("\n"); 
		query.append("				AND (A.FULL_MTY_CD = @[full_empty] OR A.FULL_MTY_CD = 'R' OR A.FULL_MTY_CD is null)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				AND (A.FULL_MTY_CD = 'M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				AND NVL(A.CSTMS_PORT_CD, ' ') = NVL(@[customs], ' ')" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${all_err} != 'All') " ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("		WT = 'N' OR PK = 'N' OR SHPR_NM = 'N' OR SHPR_AD = 'N'" ).append("\n"); 
		query.append("		OR CNEE_NM = 'N' OR CNEE_AD = 'N' OR NTFY_NM = 'N' OR NTFY_AD = 'N' OR SEAL = 'N' OR  CNTR_PK = 'N' OR CNTR_WT = 'N'" ).append("\n"); 
		query.append("		OR CNTR_MK = 'N' OR CNTR_DS = 'N' " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}