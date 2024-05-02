/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchVslPortSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.05.09 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchVslPortSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslPortSkd
	  * 2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러 ( WGT 정수자리수가 7자리 이상인지 체크함. )
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchVslPortSkdRSQL(){
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
		params.put("in_call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchVslPortSkdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	TO_CHAR(COUNT(B.BKG_NO)) BKG_COUNT," ).append("\n"); 
		query.append("	NVL(S1.POL_CD,' ') POL_CD,     " ).append("\n"); 
		query.append("	MAX(NVL(S1.POD_CD,' ')) POD_CD," ).append("\n"); 
		query.append("	MAX(NVL(TO_CHAR(S3.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),' ')) VPS_ETD_DT," ).append("\n"); 
		query.append("	MAX(NVL(TO_CHAR(S4.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),' ')) VPS_ETA_DT," ).append("\n"); 
		query.append("	MAX(DECODE(NVL(S2.TRNK_AUTO_BDR_FLG,'N'),'N',DECODE(NVL(S2.TRNK_MNL_BDR_FLG,'N'),'N','N','Y','Y'),'Y','Y')) BDR_FLG," ).append("\n"); 
		query.append("	MAX(DECODE(NVL(TO_CHAR(S2.TRNK_AUTO_BDR_DT,'YYYY-MM-DD HH24:MI'),' '),' ',DECODE(NVL(TO_CHAR(S2.TRNK_MNL_BDR_DT,'YYYY-MM-DD'),' '),' ',' ',TO_CHAR(S2.TRNK_MNL_BDR_DT,'YYYY-MM-DD HH24:MI')),TO_CHAR(S2.TRNK_AUTO_BDR_DT,'YYYY-MM-DD HH24:MI'))) BDR_TIME" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_VVD S1, " ).append("\n"); 
		query.append("	BKG_BOOKING B, " ).append("\n"); 
		query.append("	BKG_VVD_BDR_LOG S2," ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD S3, " ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD S4" ).append("\n"); 
		query.append("WHERE 	S1.VSL_CD         = @[in_vsl_cd]" ).append("\n"); 
		query.append("AND S1.SKD_VOY_NO  = @[in_skd_voy_no]" ).append("\n"); 
		query.append("AND S1.SKD_DIR_CD     = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("AND S1.POD_CD        = @[in_pod_cd]" ).append("\n"); 
		query.append("#if (${in_pol_cd}!= '') 	" ).append("\n"); 
		query.append("AND S1.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND S1.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("AND (B.BKG_STS_CD        = 'F'" ).append("\n"); 
		query.append("OR   B.BKG_STS_CD        = 'W'  )" ).append("\n"); 
		query.append("AND B.BL_NO           > ' '" ).append("\n"); 
		query.append("AND S1.VSL_CD         = S2.VSL_CD(+)" ).append("\n"); 
		query.append("AND S1.SKD_VOY_NO  = S2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND S1.SKD_DIR_CD     = S2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND S1.POL_CD        = S2.POL_CD(+)" ).append("\n"); 
		query.append("AND S1.POD_CD        = S2.POD_CD(+)" ).append("\n"); 
		query.append("AND S1.VSL_CD         = S3.VSL_CD" ).append("\n"); 
		query.append("AND S1.SKD_VOY_NO  = S3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND S1.SKD_DIR_CD     = S3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND S1.POL_CD        = S3.VPS_PORT_CD" ).append("\n"); 
		query.append("AND S3.CLPT_IND_SEQ   =  '1'" ).append("\n"); 
		query.append("AND S1.VSL_CD         = S4.VSL_CD" ).append("\n"); 
		query.append("AND S1.SKD_VOY_NO  = S4.SKD_VOY_NO" ).append("\n"); 
		query.append("AND S1.SKD_DIR_CD     = S4.SKD_DIR_CD" ).append("\n"); 
		query.append("AND S1.POD_CD        = S4.VPS_PORT_CD" ).append("\n"); 
		query.append("AND S4.CLPT_IND_SEQ  = @[in_call_ind]" ).append("\n"); 
		query.append("GROUP BY S1.POL_CD" ).append("\n"); 

	}
}