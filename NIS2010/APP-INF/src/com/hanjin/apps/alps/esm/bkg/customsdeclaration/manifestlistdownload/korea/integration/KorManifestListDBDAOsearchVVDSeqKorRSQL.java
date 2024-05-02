/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchVVDSeqKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
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

public class KorManifestListDBDAOsearchVVDSeqKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD SEQ 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchVVDSeqKorRSQL(){
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
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchVVDSeqKorRSQL").append("\n"); 
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
		query.append("SELECT MAX(KV.vvd_seq) VVD_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_VVD_SMRY KV" ).append("\n"); 
		query.append(" WHERE KV.IO_BND_CD = DECODE(@[pol_cd], NULL, 'I', 'O')" ).append("\n"); 
		query.append("   AND KV.PORT_CD    =   DECODE(@[pol_cd], NULL, @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("   AND DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' ')" ).append("\n"); 
		query.append("   AND KV.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND KV.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND KV.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND KV.OB_DECL_TP_CD = @[in_type]" ).append("\n"); 
		query.append("   AND KV.MRN_CHK_NO    = (SELECT MRN_CHK_NO" ).append("\n"); 
		query.append("                           FROM BKG_CSTMS_KR_MF_REF_NO R" ).append("\n"); 
		query.append("                           WHERE R.MRN_NO = KV.MRN_NO" ).append("\n"); 
		query.append("                           AND VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                           AND PORT_CD    = DECODE(@[pol_cd], NULL, @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("                           AND IO_BND_CD  = DECODE(@[pol_cd], NULL, 'I', 'O')" ).append("\n"); 
		query.append("                           AND ROWNUM = 1)" ).append("\n"); 

	}
}