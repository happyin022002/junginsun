/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOaddDnHistKorCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.20 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddDnHistKorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Download History 추가
	  * </pre>
	  */
	public KorManifestListDBDAOaddDnHistKorCSQL(){
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
		params.put("del_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOaddDnHistKorCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_KR_DL_HIS (" ).append("\n");
		query.append("MRN_NO, MRN_CHK_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, DL_SEQ," ).append("\n");
		query.append("POL_CD,  POD_CD, OFC_CD, UPD_USR_ID, CRE_USR_ID, BL_KNT, KR_CSTMS_DL_ACT_CD, DELT_DT)" ).append("\n");
		query.append("VALUES (" ).append("\n");
		query.append("SUBSTR(@[mrn_no], 1, 10), SUBSTR(@[mrn_no], 11, 1), SUBSTR(@[vvd], 1, 4), SUBSTR(@[vvd], 5, 4), SUBSTR(@[vvd], 9, 1), @[dl_seq]," ).append("\n");
		query.append("@[pol_cd], @[pod_cd], @[ofc_cd], @[user_id], @[user_id], @[del_cnt], 'D', SYSDATE)" ).append("\n");

	}
}