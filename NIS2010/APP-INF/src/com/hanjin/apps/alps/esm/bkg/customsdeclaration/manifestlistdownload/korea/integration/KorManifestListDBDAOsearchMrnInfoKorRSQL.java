/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchMrnInfoKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
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

public class KorManifestListDBDAOsearchMrnInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MRN 정보 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchMrnInfoKorRSQL(){
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
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchMrnInfoKorRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(TO_CHAR(KV.VVD_SEQ, '00')||KV.MRN_NO), 4)     MRN_NO" ).append("\n"); 
		query.append("     , SUBSTR(MAX(TO_CHAR(KV.VVD_SEQ, '00')||KV.MRN_CHK_NO), 4) MRN_CHK_NO" ).append("\n"); 
		query.append("     , SUBSTR(MAX(TO_CHAR(KV.VVD_SEQ, '00')||KV.IO_BND_CD), 4)  IO_BND_CD" ).append("\n"); 
		query.append("     , MAX(KV.VVD_SEQ) VVD_SEQ" ).append("\n"); 
		query.append("     , MAX(KV.UPD_DT) UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_VVD_SMRY KV" ).append("\n"); 
		query.append(" WHERE KV.IO_BND_CD  = DECODE(@[pol_cd], NULL, 'I', 'O')" ).append("\n"); 
		query.append("   AND KV.PORT_CD    = DECODE(@[pol_cd], NULL, @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("   AND DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' ')" ).append("\n"); 
		query.append("   AND KV.vsl_cd     =   SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND KV.skd_voy_no =   SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND KV.skd_dir_cd =   SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${in_type} == 'D' || ${in_type} == 'B' || ${in_type} == 'C'||${in_type} == 'D'||${in_type} == 'M')				" ).append("\n"); 
		query.append("   AND KV.OB_DECL_TP_CD IN ('A','B','C','D','M')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND KV.OB_DECL_TP_CD IN ('A','N','M','T','R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND KV.MRN_CHK_NO    = (SELECT MRN_CHK_NO" ).append("\n"); 
		query.append("                           FROM BKG_CSTMS_KR_MF_REF_NO R" ).append("\n"); 
		query.append("                           WHERE R.MRN_NO = KV.MRN_NO" ).append("\n"); 
		query.append("                           AND VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                           AND PORT_CD    = DECODE(@[pol_cd], NULL, @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("                           AND IO_BND_CD  = DECODE(@[pol_cd], NULL, 'I', 'O')" ).append("\n"); 
		query.append("                           AND ROWNUM = 1)" ).append("\n"); 
		query.append(" GROUP BY KV.MRN_NO, KV.MRN_CHK_NO, KV.vsl_cd, KV.skd_voy_no, KV.skd_dir_cd" ).append("\n"); 
		query.append(" ORDER BY VVD_SEQ DESC, UPD_DT DESC" ).append("\n"); 

	}
}