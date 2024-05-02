/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOSearchElNoKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.16 
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

public class KorManifestListDBDAOSearchElNoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * O/B T/S의 경우 ELNo를 구한다.
	  * </pre>
	  */
	public KorManifestListDBDAOSearchElNoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchElNoKorRSQL").append("\n"); 
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
		query.append("SELECT 	DISTINCT TRIM(NVL(V.MRN_NO||V.MRN_CHK_NO||T.MSN_NO,' ')) D_MRN_NO" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT 	VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", 'I' BND" ).append("\n"); 
		query.append(", TS_POD_CD POD" ).append("\n"); 
		query.append(", NVL(MST_BL_SEQ_NO,' ') MSN_NO" ).append("\n"); 
		query.append(", DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) OB_TYPE" ).append("\n"); 
		query.append("FROM 	BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE 	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND 	CSTMS_DECL_TP_CD IN ('T','I')" ).append("\n"); 
		query.append("AND 	DMST_PORT_CD = @[kt_port]" ).append("\n"); 
		query.append("AND 	TRNS_SEQ = (" ).append("\n"); 
		query.append("SELECT 	MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("FROM 	BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE 	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND 	DMST_PORT_CD = @[kt_port]" ).append("\n"); 
		query.append("AND 	CSTMS_DECL_TP_CD IN ('I','T')" ).append("\n"); 
		query.append("AND 	POD_CD <> TS_POD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(", BKG_CSTMS_KR_VVD_SMRY V" ).append("\n"); 
		query.append("WHERE 	V.VSL_CD 		= T.VSL_CD" ).append("\n"); 
		query.append("AND 	V.SKD_VOY_NO 	= T.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	V.SKD_DIR_CD 	= T.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	V.PORT_CD 		= T.POD" ).append("\n"); 
		query.append("AND 	V.IO_BND_CD 	= T.BND" ).append("\n"); 
		query.append("AND  V.VVD_SEQ = ( 	SELECT  MAX(VVD_SEQ)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("WHERE   VSL_CD 		= T.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO 	= T.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD 	= T.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     PORT_CD 	= T.POD" ).append("\n"); 
		query.append("AND     IO_BND_CD 	= T.BND)" ).append("\n"); 

	}
}