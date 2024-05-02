/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchCntrDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
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

public class JapanManifestListDownloadDBDAOsearchCntrDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrDetail
	  * 2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러 ( WGT 정수자리수가 7자리 이상인지 체크함. )
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchCntrDetailRSQL(){
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
		query.append("FileName : JapanManifestListDownloadDBDAOsearchCntrDetailRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	ROWNUM SEQ," ).append("\n"); 
		query.append("	AA.POL_CD," ).append("\n"); 
		query.append("	AA.VPS_ETD_DT," ).append("\n"); 
		query.append("	AA.BKG_NO," ).append("\n"); 
		query.append("	AA.BL_NO," ).append("\n"); 
		query.append("	AA.CNTR_NO,     " ).append("\n"); 
		query.append("	NVL(AA.CNTR_SEAL_NO, ' ') AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("	AA.CNTR_PRT_FLG," ).append("\n"); 
		query.append("	AA.RCV_TERM_CD, " ).append("\n"); 
		query.append("	AA.DE_TERM_CD," ).append("\n"); 
		query.append("	AA.POD_CD," ).append("\n"); 
		query.append("	COUNT(*) OVER (PARTITION BY BL_NO) AS CNTR_KNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(		" ).append("\n"); 
		query.append("	SELECT  " ).append("\n"); 
		query.append("		NVL(A.POL_CD,' ') POL_CD," ).append("\n"); 
		query.append("		NVL(TO_CHAR(D.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),' ') VPS_ETD_DT," ).append("\n"); 
		query.append("		NVL(B.BKG_NO,' ') BKG_NO," ).append("\n"); 
		query.append("		NVL(B.BL_NO,' ') BL_NO," ).append("\n"); 
		query.append("		NVL(C.CNTR_NO,' ') CNTR_NO,     " ).append("\n"); 
		query.append("		(SELECT /*+ INDEX_ASC(BKG_CNTR_SEAL_NO XPKBKG_CNTR_SEAL_NO) */" ).append("\n"); 
		query.append("                CNTR_SEAL_NO " ).append("\n"); 
		query.append("		   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("		  WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("		    AND CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("		    AND ROWNUM = 1) AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("		DECODE(C.CNTR_PRT_FLG,'1','Y','N') CNTR_PRT_FLG," ).append("\n"); 
		query.append("		NVL(C.RCV_TERM_CD,' ') RCV_TERM_CD, " ).append("\n"); 
		query.append("		NVL(C.DE_TERM_CD,' ') DE_TERM_CD," ).append("\n"); 
		query.append("		NVL(B.POD_CD,' ') POD_CD" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		BKG_VVD A, " ).append("\n"); 
		query.append("		BKG_BOOKING B, " ).append("\n"); 
		query.append("		BKG_CONTAINER C, " ).append("\n"); 
		query.append("		VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("		--,BKG_BL_DOC F" ).append("\n"); 
		query.append("	WHERE A.VSL_CD    = @[in_vsl_cd]" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO  = @[in_skd_voy_no]" ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD  = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("	AND A.POD_CD      = @[in_pod_cd]" ).append("\n"); 
		query.append("#if (${in_pol_cd}!= '') " ).append("\n"); 
		query.append("	AND A.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("	AND (B.BKG_STS_CD  = 'F'" ).append("\n"); 
		query.append("	OR   B.BKG_STS_CD  = 'W'  )" ).append("\n"); 
		query.append("	AND B.BL_NO        > ' '" ).append("\n"); 
		query.append("	AND B.BKG_NO       = C.BKG_NO(+)" ).append("\n"); 
		query.append("	AND A.VSL_CD       = D.VSL_CD" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO   = D.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD   = D.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND A.POL_CD       = D.VPS_PORT_CD" ).append("\n"); 
		query.append("	AND D.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("   -- AND B.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("   -- AND LENGTH(ROUND(F.ACT_WGT,0)) < 7    " ).append("\n"); 
		query.append("#if (${in_bl_type}== '1') " ).append("\n"); 
		query.append("	AND B.POD_CD     = @[in_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bl_type}== '2') " ).append("\n"); 
		query.append("	AND B.POD_CD     <> @[in_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	ORDER BY A.POL_CD ASC, B.BL_NO ASC" ).append("\n"); 
		query.append("	) AA" ).append("\n"); 

	}
}