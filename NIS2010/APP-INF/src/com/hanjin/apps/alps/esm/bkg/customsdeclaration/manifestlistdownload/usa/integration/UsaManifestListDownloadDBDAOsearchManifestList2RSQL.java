/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchManifestList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.01 
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

public class UsaManifestListDownloadDBDAOsearchManifestList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaManifestListDetailVO 생성
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchManifestList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchManifestList2RSQL").append("\n"); 
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
		query.append("WITH VSL_PORT AS (" ).append("\n"); 
		query.append("    SELECT  MIN(CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("      FROM  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("     --WHERE  VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("     WHERE	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                        WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                        AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                            )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND   VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("       AND   SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND   SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("NTC_HIS AS (" ).append("\n"); 
		query.append("    SELECT  HIS.BKG_NO" ).append("\n"); 
		query.append("           ,MAX(HIS.HIS_SEQ) AS HIS_SEQ" ).append("\n"); 
		query.append("           ,MAX(HIS.SND_DT) AS SND_DT" ).append("\n"); 
		query.append("      FROM  BKG_NTC_HIS HIS, BKG_VVD VVD" ).append("\n"); 
		query.append("     WHERE  HIS.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND  VVD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("       AND  VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND  VVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND  VVD.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("       AND  VVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("       AND  HIS.NTC_KND_CD  = 'DL'" ).append("\n"); 
		query.append("  GROUP BY  HIS.BKG_NO" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("CORRECTION AS (" ).append("\n"); 
		query.append("    SELECT  COR.BKG_NO, MAX(COR.CORR_NO) AS CORR_NO" ).append("\n"); 
		query.append("      FROM  BKG_CORRECTION COR, BKG_VVD VVD" ).append("\n"); 
		query.append("     WHERE  COR.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND  VVD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("       AND  VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND  VVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND  VVD.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("       AND  VVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("  GROUP BY  COR.BKG_NO" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("SELECT  TB.*" ).append("\n"); 
		query.append("       ,DECODE(EMP_FLG, 'N', BKG_GET_CSTMS_ADV_ERR_CD_FNC(TB.BKG_NO, TB.BL_TYPE, 'US')) AS ERR_CD" ).append("\n"); 
		query.append("       ,'' v_Pol" ).append("\n"); 
		query.append("       ,'' mf_Sts_Cd" ).append("\n"); 
		query.append("       ,'' cstms_Mf_Tp_Cd" ).append("\n"); 
		query.append("       ,'' v_Pod" ).append("\n"); 
		query.append("       ,'' ca_Flg" ).append("\n"); 
		query.append("       ,'' cstms_Trsm_Sts_Cd" ).append("\n"); 
		query.append("       ,'' ca_Iss_Dt" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  BKG.BL_NO" ).append("\n"); 
		query.append("               ,BKG.BL_NO AS BL_NOS " ).append("\n"); 
		query.append("               ,'' AS CNTR_MF_NO" ).append("\n"); 
		query.append("               ,BKG.USA_CSTMS_FILE_CD AS FILER" ).append("\n"); 
		query.append("               ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(BKG.BKG_CGO_TP_CD,'P','Y','N') AS EMP_FLG" ).append("\n"); 
		query.append("               ,DECODE(ABL.BKG_NO,NULL,'N','Y') AS IF_FLG" ).append("\n"); 
		query.append("               ,ABL.ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("               ,BKG.BKG_NO" ).append("\n"); 
		query.append("               ,VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD" ).append("\n"); 
		query.append("               ,VVD.POD_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD" ).append("\n"); 
		query.append("               ,BKG.POD_NOD_CD" ).append("\n"); 
		query.append("               ,BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("               ,DOC.PCK_QTY" ).append("\n"); 
		query.append("               ,DOC.PCK_TP_CD" ).append("\n"); 
		query.append("               ,DOC.ACT_WGT" ).append("\n"); 
		query.append("               ,DOC.WGT_UT_CD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST1.CUST_NM)),NULL,'N','Y') AS SHPR_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST1.CUST_ADDR)),NULL,'N','Y') AS SHPR_AD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST2.CUST_NM)),NULL,'N','Y') AS CNEE_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST2.CUST_ADDR)),NULL,'N','Y') AS CNEE_AD" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST3.CUST_NM)),NULL,'N','Y') AS NTFY_NM" ).append("\n"); 
		query.append("               ,DECODE(LENGTH(RTRIM(CST3.CUST_ADDR)),NULL,'N','Y') AS NTFY_AD" ).append("\n"); 
		query.append("               ,DOC.BDR_FLG" ).append("\n"); 
		query.append("               ,COR.CORR_NO AS CA_NO" ).append("\n"); 
		query.append("               ,DECODE(NVL(NTC.HIS_SEQ, 0),0,'N','Y') AS EDI_FLG" ).append("\n"); 
		query.append("               ,NVL(NTC.SND_DT, '') AS EDI_SND_DT" ).append("\n"); 
		query.append("               ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("               ,'M' BL_TYPE" ).append("\n"); 
		query.append("        FROM    BKG_VVD VVD" ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST1" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST2" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST3" ).append("\n"); 
		query.append("               ,BKG_CSTMS_ADV_BL ABL" ).append("\n"); 
		query.append("               ,CORRECTION COR" ).append("\n"); 
		query.append("               ,NTC_HIS NTC" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     VVD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("        AND     VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND     VVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND     VVD.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("        AND     VVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("        #if (${bkg_cgo_tp_cd} == 'F') " ).append("\n"); 
		query.append("        AND     BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("        AND     BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND     VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("        AND     BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND     ABL.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("        AND     BKG.BL_NO = ABL.BL_NO(+)   " ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = ABL.BKG_NO(+)  " ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = CST1.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     CST1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = CST2.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     CST2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = CST3.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     CST3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = COR.BKG_NO(+)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT   BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("                ,HBL.CNTR_MF_NO AS BL_NOS" ).append("\n"); 
		query.append("                ,HBL.CNTR_MF_NO" ).append("\n"); 
		query.append("                ,'0' AS FILER" ).append("\n"); 
		query.append("                ,'' AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                ,'N' AS EMP_FLG" ).append("\n"); 
		query.append("                ,DECODE(ABL.BKG_NO,NULL,'N','Y') AS IF_FLG" ).append("\n"); 
		query.append("                ,ABL.ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("                ,BKG.BKG_NO" ).append("\n"); 
		query.append("                ,VVD.VSL_CD" ).append("\n"); 
		query.append("                ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,VVD.POL_CD" ).append("\n"); 
		query.append("                ,VVD.POD_CD" ).append("\n"); 
		query.append("                ,BKG.DEL_CD" ).append("\n"); 
		query.append("                ,BKG.POD_NOD_CD" ).append("\n"); 
		query.append("                ,BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("                ,HBL.PCK_QTY" ).append("\n"); 
		query.append("                ,HBL.PCK_TP_CD" ).append("\n"); 
		query.append("                ,HBL.HBL_WGT AS ACT_WGT" ).append("\n"); 
		query.append("                ,HBL.WGT_UT_CD" ).append("\n"); 
		query.append("                ,DECODE(LENGTH(RTRIM(CST1.CUST_NM)),NULL,'N','Y') AS SHPR_NM" ).append("\n"); 
		query.append("                ,DECODE(LENGTH(RTRIM(CST1.CUST_ADDR)),NULL,'N','Y') AS SHPR_AD" ).append("\n"); 
		query.append("                ,DECODE(LENGTH(RTRIM(CST2.CUST_NM)),NULL,'N','Y') AS CNEE_NM" ).append("\n"); 
		query.append("                ,DECODE(LENGTH(RTRIM(CST2.CUST_ADDR)),NULL,'N','Y') AS CNEE_AD" ).append("\n"); 
		query.append("                ,DECODE(LENGTH(RTRIM(CST3.CUST_NM)),NULL,'N','Y') AS NTFY_NM" ).append("\n"); 
		query.append("                ,DECODE(LENGTH(RTRIM(CST3.CUST_ADDR)),NULL,'N','Y') AS NTFY_AD" ).append("\n"); 
		query.append("                ,DOC.BDR_FLG" ).append("\n"); 
		query.append("                ,'' AS CA_NO" ).append("\n"); 
		query.append("               ,DECODE(NVL(NTC.HIS_SEQ, 0),0,'N','Y') AS EDI_FLG" ).append("\n"); 
		query.append("               ,NVL(NTC.SND_DT, '') AS EDI_SND_DT" ).append("\n"); 
		query.append("               ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("               ,'H' BL_TYPE" ).append("\n"); 
		query.append("        FROM    BKG_VVD VVD " ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("               ,BKG_HBL HBL" ).append("\n"); 
		query.append("               ,BKG_HBL_CUST CST1" ).append("\n"); 
		query.append("               ,BKG_HBL_CUST CST2" ).append("\n"); 
		query.append("               ,BKG_HBL_CUST CST3" ).append("\n"); 
		query.append("               ,BKG_CSTMS_ADV_BL ABL" ).append("\n"); 
		query.append("               ,NTC_HIS NTC" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     VVD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("        AND     VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND     VVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND     VVD.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("        AND     VVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("        #if (${bkg_cgo_tp_cd} == 'F') " ).append("\n"); 
		query.append("        AND     BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("        AND     BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND     VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = HBL.BKG_NO" ).append("\n"); 
		query.append("        AND     BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("        AND     HBL.CNTR_MF_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND     ABL.CNT_CD(+) = @[cnt_cd]" ).append("\n"); 
		query.append("        AND     HBL.CNTR_MF_NO = ABL.BL_NO(+)" ).append("\n"); 
		query.append("        AND     HBL.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     HBL.BKG_NO = CST1.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     HBL.HBL_SEQ = CST1.HBL_SEQ(+)" ).append("\n"); 
		query.append("        AND     CST1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND     HBL.BKG_NO = CST2.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     HBL.HBL_SEQ = CST2.HBL_SEQ(+)" ).append("\n"); 
		query.append("        AND     CST2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND     HBL.BKG_NO = CST3.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     HBL.HBL_SEQ = CST3.HBL_SEQ(+)" ).append("\n"); 
		query.append("        AND     CST3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND     BKG.USA_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append("       ,VSL_PORT" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(" WHERE  SKD.CLPT_SEQ >= VSL_PORT.CLPT_SEQ" ).append("\n"); 
		query.append("   AND  TB.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND  TB.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  TB.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  TB.POD_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND  SKD.CLPT_IND_SEQ = 1" ).append("\n"); 

	}
}