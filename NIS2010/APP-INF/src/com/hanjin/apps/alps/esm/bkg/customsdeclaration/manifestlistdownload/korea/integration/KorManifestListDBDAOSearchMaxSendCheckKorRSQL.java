/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDBDAOSearchMaxSendCheckKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.31 
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

public class KorManifestListDBDAOSearchMaxSendCheckKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세관 Manifest전송여부 확인
	  * </pre>
	  */
	public KorManifestListDBDAOSearchMaxSendCheckKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("createdtype",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_pod_tmnl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_mrn_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchMaxSendCheckKorRSQL").append("\n"); 
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
		query.append("SELECT DECODE(MF_SND_DT,NULL,'N','Y') MF_SND_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("WHERE MRN_NO = @[new_mrn_no]" ).append("\n"); 
		query.append("AND MRN_CHK_NO = @[new_mrn_chk_no]" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND ((@[createdtype] IN ('A','B','C','D','M') AND OB_DECL_TP_CD IN ('A','B','C','D','M')) OR" ).append("\n"); 
		query.append("(@[createdtype] = 'N' AND OB_DECL_TP_CD = @[createdtype]))" ).append("\n"); 
		query.append("AND VVD_SEQ = ( SELECT MAX(VVD_SEQ)" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("WHERE MRN_NO = @[new_mrn_no]" ).append("\n"); 
		query.append("AND MRN_CHK_NO = @[new_mrn_chk_no]" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND ((@[createdtype] IN ('A','B','C','D','M') AND OB_DECL_TP_CD IN ('A','B','C','D','M')) OR" ).append("\n"); 
		query.append("(@[createdtype] = 'N' AND OB_DECL_TP_CD = @[createdtype]))" ).append("\n"); 
		query.append("AND PORT_TML_CD = @[vvd_pod_tmnl_cd] )" ).append("\n"); 
		query.append("AND NVL(PORT_TML_CD,' ') = NVL(@[vvd_pod_tmnl_cd], ' ')" ).append("\n"); 

	}
}