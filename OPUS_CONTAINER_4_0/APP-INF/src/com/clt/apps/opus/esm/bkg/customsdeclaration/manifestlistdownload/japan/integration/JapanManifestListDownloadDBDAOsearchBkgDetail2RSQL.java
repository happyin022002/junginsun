/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBkgDetail2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchBkgDetail2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBkgDetail2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBkgDetail2RSQL").append("\n"); 
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
		query.append("SELECT SEQ," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       I_F," ).append("\n"); 
		query.append("       L_T," ).append("\n"); 
		query.append("       BKG_POL_CD," ).append("\n"); 
		query.append("       BKG_POD_CD," ).append("\n"); 
		query.append("       VVD_POL_CD," ).append("\n"); 
		query.append("       VVD_POD_CD," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       ACT_WGT," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       MEAS_QTY," ).append("\n"); 
		query.append("       MEAS_UT_CD," ).append("\n"); 
		query.append("       CUST_NM1," ).append("\n"); 
		query.append("       CUST_ADDR1," ).append("\n"); 
		query.append("       CUST_NM2," ).append("\n"); 
		query.append("       CUST_ADDR2," ).append("\n"); 
		query.append("       CUST_NM3," ).append("\n"); 
		query.append("       CUST_ADDR3," ).append("\n"); 
		query.append("       MK_DESC," ).append("\n"); 
		query.append("       CMDT_DESC," ).append("\n"); 
		query.append("       BDR_CNG_FLG," ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("       VPS_ETD_DT," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_SEAL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT ROWNUM AS SEQ," ).append("\n"); 
		query.append("               AA.BL_NO," ).append("\n"); 
		query.append("               AA.BKG_NO," ).append("\n"); 
		query.append("               AA.I_F," ).append("\n"); 
		query.append("               AA.L_T," ).append("\n"); 
		query.append("               AA.BKG_POL_CD," ).append("\n"); 
		query.append("               AA.BKG_POD_CD," ).append("\n"); 
		query.append("               AA.VVD_POL_CD," ).append("\n"); 
		query.append("               AA.VVD_POD_CD," ).append("\n"); 
		query.append("               AA.PCK_QTY," ).append("\n"); 
		query.append("               AA.PCK_TP_CD," ).append("\n"); 
		query.append("               AA.ACT_WGT," ).append("\n"); 
		query.append("               AA.WGT_UT_CD," ).append("\n"); 
		query.append("               AA.MEAS_QTY," ).append("\n"); 
		query.append("               AA.MEAS_UT_CD," ).append("\n"); 
		query.append("               AA.CUST_NM1," ).append("\n"); 
		query.append("               AA.CUST_ADDR1," ).append("\n"); 
		query.append("               AA.CUST_NM2," ).append("\n"); 
		query.append("               AA.CUST_ADDR2," ).append("\n"); 
		query.append("               AA.CUST_NM3," ).append("\n"); 
		query.append("               AA.CUST_ADDR3," ).append("\n"); 
		query.append("               AA.MK_DESC," ).append("\n"); 
		query.append("               AA.CMDT_DESC," ).append("\n"); 
		query.append("               AA.BDR_FLG AS BDR_CNG_FLG," ).append("\n"); 
		query.append("               DECODE(AA.BDR_FLG, 'Y', (SELECT NVL(CORR_NO, ' ')" ).append("\n"); 
		query.append("                                           FROM BKG_CORRECTION" ).append("\n"); 
		query.append("                                          WHERE BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("                                            AND CORR_DT = (SELECT MAX(CORR_DT)" ).append("\n"); 
		query.append("                                                             FROM BKG_CORRECTION" ).append("\n"); 
		query.append("                                                            WHERE BKG_NO = AA.BKG_NO)), ' ') AS CORR_NO," ).append("\n"); 
		query.append("               AA.VPS_ETD_DT," ).append("\n"); 
		query.append("               AA.CNTR_NO," ).append("\n"); 
		query.append("               AA.CNTR_SEAL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("               (SELECT DISTINCT NVL(B.BL_NO, ' ') AS BL_NO," ).append("\n"); 
		query.append("                       NVL(B.BKG_NO, ' ') AS BKG_NO," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(I.BL_NO)), NULL, 'N', 'Y') AS I_F," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(B.POD_CD)), LENGTH(RTRIM(@[in_pod_cd])), 'L', 'T') AS L_T," ).append("\n"); 
		query.append("                       NVL(B.POL_CD, ' ') AS BKG_POL_CD," ).append("\n"); 
		query.append("                       NVL(B.POD_CD, ' ') AS BKG_POD_CD," ).append("\n"); 
		query.append("                       NVL(A.POL_CD, ' ') AS VVD_POL_CD," ).append("\n"); 
		query.append("                       NVL(A.POD_CD, ' ') AS VVD_POD_CD," ).append("\n"); 
		query.append("                       NVL(F.PCK_QTY, 0) AS PCK_QTY," ).append("\n"); 
		query.append("                       NVL(F.PCK_TP_CD, ' ') AS PCK_TP_CD," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                          WHEN NVL(F.ACT_WGT, 0) > 999999.999 THEN DECODE(NVL(F.WGT_UT_CD, ' '), 'KGS', ROUND(NVL(F.ACT_WGT, 0)*0.001, 3), 'LBS', ROUND(NVL(F.ACT_WGT, 0)*0.000028, 3), NVL(F.ACT_WGT, 0))" ).append("\n"); 
		query.append("                          ELSE NVL(F.ACT_WGT, 0)" ).append("\n"); 
		query.append("                       END AS ACT_WGT," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                          WHEN NVL(F.ACT_WGT, 0) > 999999.999 THEN 'TNE'" ).append("\n"); 
		query.append("                          ELSE NVL(F.WGT_UT_CD, ' ')" ).append("\n"); 
		query.append("                       END AS WGT_UT_CD," ).append("\n"); 
		query.append("                       NVL(F.MEAS_QTY, 0) AS MEAS_QTY," ).append("\n"); 
		query.append("                       NVL(F.MEAS_UT_CD, ' ') AS MEAS_UT_CD," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(C1.CUST_NM)), NULL, 'N', 'Y') AS CUST_NM1," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(C1.CUST_ADDR)), NULL, 'N', 'Y') AS CUST_ADDR1," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(C2.CUST_NM)), NULL, 'N', 'Y') AS CUST_NM2," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(C2.CUST_ADDR)), NULL, 'N', 'Y') AS CUST_ADDR2," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(C3.CUST_NM)), NULL, 'N', 'Y') AS CUST_NM3," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(C3.CUST_ADDR)), NULL, 'N', 'Y') AS CUST_ADDR3," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(E.MK_DESC)), NULL, 'N', 'Y') AS MK_DESC," ).append("\n"); 
		query.append("                       DECODE(LENGTH(RTRIM(E.CMDT_DESC)), NULL, 'N', 'Y') AS CMDT_DESC," ).append("\n"); 
		query.append("                       NVL(F.BDR_FLG, ' ')AS  BDR_FLG," ).append("\n"); 
		query.append("                       '' AS CORR_NO," ).append("\n"); 
		query.append("                       TO_CHAR(D.VPS_ETD_DT, 'YYYY-MM-DD  HH24:MI') AS VPS_ETD_DT," ).append("\n"); 
		query.append("                       NVL(C.CNTR_NO, ' ') AS CNTR_NO," ).append("\n"); 
		query.append("                       DECODE(G.CNTR_SEAL_NO, NULL, 'N', 'Y') AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  FROM BKG_VVD A," ).append("\n"); 
		query.append("                       BKG_BOOKING B," ).append("\n"); 
		query.append("                       VSK_VSL_PORT_SKD D," ).append("\n"); 
		query.append("                       BKG_CUSTOMER C1," ).append("\n"); 
		query.append("                       BKG_CUSTOMER C2," ).append("\n"); 
		query.append("                       BKG_CUSTOMER C3," ).append("\n"); 
		query.append("                       BKG_BL_MK_DESC E," ).append("\n"); 
		query.append("                       BKG_CSTMS_JP_BL I," ).append("\n"); 
		query.append("                       BKG_BL_DOC F," ).append("\n"); 
		query.append("                       BKG_CONTAINER C," ).append("\n"); 
		query.append("                       BKG_CNTR_SEAL_NO G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = @[in_vsl_cd]" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("                   AND A.POD_CD = @[in_pod_cd]" ).append("\n"); 
		query.append("#if (${in_pol_cd}!= '')" ).append("\n"); 
		query.append("                   AND A.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND (B.BKG_STS_CD = 'F' OR B.BKG_STS_CD = 'W' )" ).append("\n"); 
		query.append("                   AND B.BL_NO > ' '" ).append("\n"); 
		query.append("                   AND A.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND A.POL_CD = D.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND D.CLPT_IND_SEQ = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT MIN(P.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                 FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                  AND P.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("                                  AND P.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND P.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND P.VPS_PORT_CD = D.VPS_PORT_CD" ).append("\n"); 
		query.append("                                  AND NVL(P.SKD_CNG_STS_CD, 'X') <> 'S')    /* Skip */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND B.BKG_NO = C1.BKG_NO" ).append("\n"); 
		query.append("                   AND C1.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                   AND B.BKG_NO = C2.BKG_NO" ).append("\n"); 
		query.append("                   AND C2.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                   AND B.BKG_NO = C3.BKG_NO" ).append("\n"); 
		query.append("                   AND C3.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                   AND B.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND E.MK_SEQ(+) = '1'" ).append("\n"); 
		query.append("                   AND B.BL_NO = I.BL_NO(+)" ).append("\n"); 
		query.append("                   AND B.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND C.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${in_bl_type}== '1')" ).append("\n"); 
		query.append("                   AND B.POD_CD = @[in_pod_cd]" ).append("\n"); 
		query.append("#end #if (${in_bl_type}== '2')" ).append("\n"); 
		query.append("                   AND B.POD_CD <> @[in_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ) AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ORDER BY AA.BKG_POL_CD," ).append("\n"); 
		query.append("               AA.BL_NO" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}