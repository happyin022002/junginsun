/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOUsaManifestSearchDetailOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
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

public class UsaManifestListDownloadDBDAOUsaManifestSearchDetailOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0615 상세조회
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOUsaManifestSearchDetailOBRSQL(){
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
		query.append("FileName : UsaManifestListDownloadDBDAOUsaManifestSearchDetailOBRSQL").append("\n"); 
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
		query.append("				       NVL(VVD.POL_CD,' ') POL,   NVL(VVD.POD_CD,' ') POD,   NVL(A.DEL_CD,' ') DEL," ).append("\n"); 
		query.append("				       DECODE(DOC.PCK_QTY,NULL,'N',0,'N','Y') PK," ).append("\n"); 
		query.append("				       DECODE(DOC.ACT_WGT,NULL,'N',0,'N','Y') WT," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C1.CUST_NM)),NULL,'N','Y') SHPR_NM, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C1.CUST_ADDR)),NULL,'N','Y') SHPR_AD," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C2.CUST_NM)),NULL,'N','Y') CNEE_NM, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C2.CUST_ADDR)),NULL,'N','Y') CNEE_AD," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C3.CUST_NM)),NULL,'N','Y') NTFY_NM, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(C3.CUST_ADDR)),NULL,'N','Y') NTFY_AD," ).append("\n"); 
		query.append("				       NVL(B.CNTR_NO,' ') CNTR_NO,    " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM((" ).append("\n"); 
		query.append("    						SELECT MAX(CNTR_SEAL_NO) FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("    						WHERE BKG_NO        = A.BKG_NO" ).append("\n"); 
		query.append("                             AND TRIM(CNTR_SEAL_NO) != '-'" ).append("\n"); 
		query.append("    						))),NULL,'N','Y') SEAL," ).append("\n"); 
		query.append("				       DECODE(DOC.PCK_QTY,NULL,'N',0,'N','Y') CNTR_PK," ).append("\n"); 
		query.append("						DECODE(D.CNTR_MF_WGT,NULL,'N',0,'N','Y') CNTR_WT," ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(NVL(TRIM(REPLACE(REPLACE(UPPER(D.CNTR_MF_MK_DESC),CHR(13)||CHR(10),' '),CHR(9),' ')),'NO MARKS'))),NULL,'N','Y')  CNTR_MK, " ).append("\n"); 
		query.append("				       DECODE(LENGTH(RTRIM(UPPER(decode(D.CNTR_MF_GDS_DESC,null,MDM.CMDT_NM,D.CNTR_MF_GDS_DESC)))),NULL,'N','Y') CNTR_DS," ).append("\n"); 
		query.append("				       DECODE(A.USA_CSTMS_FILE_CD,NULL,'3','0','1',A.USA_CSTMS_FILE_CD) FILER," ).append("\n"); 
		query.append("					   VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("					   'MI' TRANSMIT_CD," ).append("\n"); 
		query.append("					   DECODE(A.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_MTY_CD," ).append("\n"); 
		query.append("					   '' USR_ID, '' OFC_CD," ).append("\n"); 
		query.append("                       (SELECT CASE WHEN MAX(VPS_ETA_DT) IS NULL THEN '' ELSE TO_CHAR(MAX(VPS_ETA_DT), 'YYYYMMDD HH24MI') END " ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                         WHERE  VSL_CD         = VVD.VSL_CD" ).append("\n"); 
		query.append("                            AND SKD_VOY_NO     = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND SKD_DIR_CD     = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND VPS_PORT_CD    = VVD.POD_CD) ETA	," ).append("\n"); 
		query.append("                       (SELECT SUBSTR( MIN( LPAD(CLPT_SEQ, 2, 0) ||VPS_PORT_CD) , 3)" ).append("\n"); 
		query.append("		                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		                WHERE 1=1" ).append("\n"); 
		query.append("		                             AND	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("		                                                                                            WHERE CNT_cD='US'" ).append("\n"); 
		query.append("		                                                                                            AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("		                                                                                )                             " ).append("\n"); 
		query.append("		                             AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("		                             AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("		                             AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		                             AND CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("		                ) AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("	           FROM  BKG_VVD VVD ," ).append("\n"); 
		query.append("	                     BKG_BOOKING A, " ).append("\n"); 
		query.append("	           			 BKG_CONTAINER B, " ).append("\n"); 
		query.append("	           			 BKG_CNTR_MF_DESC D," ).append("\n"); 
		query.append("				         BKG_CUSTOMER C1, " ).append("\n"); 
		query.append("				         BKG_CUSTOMER C2, " ).append("\n"); 
		query.append("				         BKG_CUSTOMER C3," ).append("\n"); 
		query.append("				         BKG_BL_DOC DOC," ).append("\n"); 
		query.append("				         MDM_COMMODITY MDM" ).append("\n"); 
		query.append("				WHERE  VVD.BKG_NO        = A.BKG_NO" ).append("\n"); 
		query.append("                AND A.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("#if (${full_empty} == 'F') " ).append("\n"); 
		query.append("           AND  A.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_empty} == 'M') " ).append("\n"); 
		query.append("           AND  A.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("				AND B.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("                AND B.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("                AND A.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("				AND A.CMDT_CD = MDM.CMDT_CD(+)" ).append("\n"); 
		query.append("				AND VVD.VSL_CD         = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				AND VVD.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				AND VVD.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("				AND VVD.POD_CD    LIKE NVL(@[pod],'%')" ).append("\n"); 
		query.append("				AND (VVD.POL_CD   LIKE NVL(@[pol],'%')" ).append("\n"); 
		query.append("				OR VVD.POL_CD    = DECODE(@[pol],'USLAX','MXZLO',@[pol])" ).append("\n"); 
		query.append("				OR  VVD.POL_CD    = DECODE(@[pol],'USOAK','MXZLO',@[pol])" ).append("\n"); 
		query.append("				OR  VVD.POL_CD    = DECODE(@[pol],'USLAX','MXESE',@[pol]))" ).append("\n"); 
		query.append("				AND A.BKG_NO          = C1.BKG_NO(+)" ).append("\n"); 
		query.append("				AND C1.BKG_CUST_TP_CD(+)     = 'S'" ).append("\n"); 
		query.append("				AND A.BKG_NO          = C2.BKG_NO(+)" ).append("\n"); 
		query.append("				AND C2.BKG_CUST_TP_CD(+)     = 'C'" ).append("\n"); 
		query.append("				AND A.BKG_NO          = C3.BKG_NO(+)" ).append("\n"); 
		query.append("				AND C3.BKG_CUST_TP_CD(+)     = 'N'" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${all_err} != 'All') " ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("		WT = 'N' OR PK = 'N' OR SHPR_NM = 'N' OR SHPR_AD = 'N'" ).append("\n"); 
		query.append("		OR CNEE_NM = 'N' OR CNEE_AD = 'N' OR NTFY_NM = 'N' OR NTFY_AD = 'N' OR SEAL = 'N' OR  CNTR_PK = 'N' OR CNTR_WT = 'N'" ).append("\n"); 
		query.append("		OR CNTR_MK = 'N' OR CNTR_DS = 'N' " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND NVL(CSTMS_PORT_CD, ' ') = NVL(@[customs], ' ')" ).append("\n"); 

	}
}