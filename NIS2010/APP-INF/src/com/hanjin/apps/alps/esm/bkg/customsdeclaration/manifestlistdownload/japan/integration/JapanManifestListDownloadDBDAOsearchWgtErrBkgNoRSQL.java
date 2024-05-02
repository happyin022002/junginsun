/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchWgtErrBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchWgtErrBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWgtErrBkgNo
	  * 2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러 ( WGT 정수자리수가 7자리 이상인지 체크함. )
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchWgtErrBkgNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchWgtErrBkgNoRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AA.BL_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(B.BL_NO,' ') BL_NO," ).append("\n"); 
		query.append("NVL(B.BKG_NO,' ') BKG_NO," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(I.BL_NO)),NULL,'N','Y') I_F," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(B.POD_CD)),LENGTH(RTRIM(@[in_pod_cd])),'L','T') L_T," ).append("\n"); 
		query.append("NVL(B.POL_CD,' ') POL_CD," ).append("\n"); 
		query.append("NVL(B.POD_CD,' ') POD_CD," ).append("\n"); 
		query.append("NVL(A.POL_CD,' ') POL_CD2," ).append("\n"); 
		query.append("NVL(F.PCK_QTY,0) PCK_QTY," ).append("\n"); 
		query.append("NVL(F.PCK_TP_CD,' ') PCK_TP_CD," ).append("\n"); 
		query.append("NVL(F.ACT_WGT,0) ACT_WGT," ).append("\n"); 
		query.append("NVL(F.WGT_UT_CD,' ') WGT_UT_CD," ).append("\n"); 
		query.append("NVL(F.MEAS_QTY,0) MEAS_QTY," ).append("\n"); 
		query.append("NVL(F.MEAS_UT_CD,' ') MEAS_UT_CD," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(C1.CUST_NM)),NULL,'N','Y') CUST_NM1," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(C1.CUST_ADDR)),NULL,'N','Y') CUST_ADDR1," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(C2.CUST_NM)),NULL,'N','Y') CUST_NM2," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(C2.CUST_ADDR)),NULL,'N','Y') CUST_ADDR2," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(C3.CUST_NM)),NULL,'N','Y') CUST_NM3," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(C3.CUST_ADDR)),NULL,'N','Y') CUST_ADDR3," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(E.MK_DESC)),NULL,'N','Y') MK_DESC," ).append("\n"); 
		query.append("DECODE(LENGTH(RTRIM(E.CMDT_DESC)),NULL,'N','Y') CMDT_DESC," ).append("\n"); 
		query.append("NVL(F.BDR_FLG,' ') BDR_FLG," ).append("\n"); 
		query.append("'' CORR_NO," ).append("\n"); 
		query.append("TO_CHAR(D.VPS_ETD_DT, 'YYYY-MM-DD  HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_VVD A," ).append("\n"); 
		query.append("BKG_BOOKING B," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD D," ).append("\n"); 
		query.append("BKG_CUSTOMER C1," ).append("\n"); 
		query.append("BKG_CUSTOMER C2," ).append("\n"); 
		query.append("BKG_CUSTOMER C3," ).append("\n"); 
		query.append("BKG_BL_MK_DESC E," ).append("\n"); 
		query.append("BKG_CSTMS_JP_BL I," ).append("\n"); 
		query.append("BKG_BL_DOC F" ).append("\n"); 
		query.append("WHERE A.VSL_CD         = @[in_vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO  = @[in_skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD     = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("AND A.POD_CD        = @[in_pod_cd]" ).append("\n"); 
		query.append("#if (${in_pol_cd}!= '')" ).append("\n"); 
		query.append("AND A.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("AND (B.BKG_STS_CD       = 'F'" ).append("\n"); 
		query.append("OR   B.BKG_STS_CD       = 'W'  )" ).append("\n"); 
		query.append("AND B.BL_NO          > ' '" ).append("\n"); 
		query.append("AND A.VSL_CD         = D.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO  = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.POL_CD        = D.VPS_PORT_CD" ).append("\n"); 
		query.append("AND D.CLPT_IND_SEQ   = '1'" ).append("\n"); 
		query.append("AND B.BKG_NO         = C1.BKG_NO" ).append("\n"); 
		query.append("AND C1.BKG_CUST_TP_CD        = 'S'" ).append("\n"); 
		query.append("AND B.BKG_NO         = C2.BKG_NO" ).append("\n"); 
		query.append("AND C2.BKG_CUST_TP_CD        = 'C'" ).append("\n"); 
		query.append("AND B.BKG_NO         = C3.BKG_NO" ).append("\n"); 
		query.append("AND C3.BKG_CUST_TP_CD        = 'N'" ).append("\n"); 
		query.append("AND B.BKG_NO         = E.BKG_NO(+)" ).append("\n"); 
		query.append("AND E.MK_SEQ(+)     = '1'" ).append("\n"); 
		query.append("AND B.BL_NO          = I.BL_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO         = F.BKG_NO" ).append("\n"); 
		query.append("AND LENGTH(ROUND(F.ACT_WGT,0)) > 6" ).append("\n"); 
		query.append("#if (${in_bl_type}== '1')" ).append("\n"); 
		query.append("AND B.POD_CD     = @[in_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bl_type}== '2')" ).append("\n"); 
		query.append("AND B.POD_CD     <> @[in_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.POL_CD ASC, B.BL_NO ASC" ).append("\n"); 
		query.append(") AA )" ).append("\n"); 
		query.append(") AS BKG_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}